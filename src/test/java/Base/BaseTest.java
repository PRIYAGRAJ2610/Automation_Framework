package Base;

import Pages.PageObjectManager;
import Pages.PageObjectManager;
import SetUp.ConfigReader;
import SetUp.WebDriverBase;
import Helper.LoggerHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private static ThreadLocal<PageObjectManager> pageManagerThread = new ThreadLocal<>();

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    protected ExtentTest test;
    private static final Logger log = LoggerHelper.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driverThread.get();
    }

    public PageObjectManager pages() {
        return pageManagerThread.get();
    }

    @BeforeSuite
    public void setUpExtent() {
        extent = new ExtentReports();
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Test Report");
        spark.config().setReportName("Selenium Execution");
    }

    @BeforeMethod
    public void setUp(Method method) {
        WebDriver driver = WebDriverBase.getWebDriver(); // internally uses ThreadLocal
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

        driverThread.set(driver);
        pageManagerThread.set(new PageObjectManager(driver));

        test = extent.createTest(method.getName());
        LoggerHelper.setExtentTest(test);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                LoggerHelper.getExtentTest().fail("Test Failed: " + result.getName());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                LoggerHelper.getExtentTest().pass("Test Passed: " + result.getName());
            }
        } catch (Exception e) {
            log.error("Exception in test logging: " + e.getMessage());
        } finally {
            WebDriverBase.quitWebDriver(); // cleans up ThreadLocal driver
            driverThread.remove();
            pageManagerThread.remove();
        }
    }

    @AfterSuite
    public void tearDownExtent() {
        extent.flush();
    }
}
