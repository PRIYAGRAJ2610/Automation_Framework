package Base;

import Helper.LoggerHelper;
import Helper.ScreenshotHelper;
import Pages.SignInPage;
import SetUp.ConfigReader;
import SetUp.WebDriverBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected SignInPage signInPage;
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    protected ExtentTest test;
    private static final Logger log = LoggerHelper.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUpReport() {
        log.info("Initializing Extent Report...");
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        sparkReporter.config().setReportName("Selenium Automation Report");
        sparkReporter.config().setDocumentTitle("Test Results");
        log.info("Extent Report Initialized");
    }

    @BeforeMethod
    public void setup(Method method) {
        log.info("Starting Test: " + method.getName());
        driver = WebDriverBase.getWebDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

        test = extent.createTest(method.getName());
        LoggerHelper.setExtentTest(test); // Set it in ThreadLocal

        signInPage = new SignInPage(driver); // No need to pass test anymore

        log.info("Navigated to Test Page");
    }

    @AfterMethod
    public void captureTestResult(ITestResult result) {
        String screenshotBase64 = ScreenshotHelper.captureScreenshotAsBase64(driver);
        if (result.getStatus() == ITestResult.FAILURE) {
            log.error("Test Failed: " + result.getName());
            LoggerHelper.getExtentTest().fail("Test Failed").addScreenCaptureFromBase64String(screenshotBase64);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("Test Passed: " + result.getName());
            LoggerHelper.getExtentTest().pass("Test Passed").addScreenCaptureFromBase64String(screenshotBase64);
        }
        WebDriverBase.quitWebDriver();
    }

    @AfterSuite
    public void tearDownReport() {
        log.info("Finalizing Extent Report...");
        extent.flush();
    }
}
