package ReportManager;

import Helper.DriverManager;
import Helper.LoggerHelper;
import Helper.ScreenshotHelper;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class ListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentManager.getTest(result.getMethod().getMethodName());

        // Log failure message to Extent
        if (test != null) {
            test.fail("Test Failed: " + result.getThrowable().getMessage());
        }

        WebDriver driver = DriverManager.getDriver();
        String testName = result.getMethod().getMethodName();

        // Capture and attach screenshot (Extent + Allure)
        if (driver != null) {
            ScreenshotHelper.captureScreenshot(driver, testName); // Saves + attaches to Allure

            // Optionally: Add only screenshot to Allure directly again
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(
                    ScreenshotHelper.captureScreenshotAsBase64(driver).getBytes()));
        }

        // Also log error via LoggerHelper
        LoggerHelper.logError("Test Failed: " + testName, result.getThrowable());
    }
}
