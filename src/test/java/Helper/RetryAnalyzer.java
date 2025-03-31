package Helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import ReportManager.ExtentManager; // Import ExtentManager

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Retry 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;

            // Log retry attempt inside the same test case
            ExtentManager.logRetry(result.getMethod().getMethodName(), retryCount);

            return true; // Retry the test
        }
        return false; // Stop retrying
    }
}
