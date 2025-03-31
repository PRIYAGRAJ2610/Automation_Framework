package ReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {
    private static ExtentReports extent;
    private static final Map<String, ExtentTest> testMap = new HashMap<>();

    // Initialize Extent Reports
    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Get or create test case in Extent Report
    public static synchronized ExtentTest getTest(String testName) {
        return testMap.computeIfAbsent(testName, key -> getExtentReports().createTest(testName));
    }

    // Log retry attempts inside the same test case
    public static synchronized void logRetry(String testName, int retryCount) {
        ExtentTest test = getTest(testName);
        test.info("Retry Attempt #" + retryCount);
    }

    // Flush report at end
    public static synchronized void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
