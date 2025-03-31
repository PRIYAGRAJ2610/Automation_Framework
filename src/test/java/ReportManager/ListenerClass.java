package ReportManager;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentManager.getTest(result.getMethod().getMethodName());

        int retryCount = result.getMethod().getCurrentInvocationCount(); // Get retry count
        int maxRetry = result.getMethod().getRetryAnalyzer(result).getClass().getDeclaredFields().length;

        if (retryCount <= maxRetry) {
            test.info("Retrying test case. Attempt #" + retryCount);
        } else {
            test.fail("Test Failed: " + result.getThrowable().getMessage());
        }
    }
}
