package Helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

    public static void setExtentTest(ExtentTest test) {
        extentTestThreadLocal.set(test);
    }

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public static void logInfo(String message) {
        Logger logger = getLogger(LoggerHelper.class);
        logger.info(message);
        ExtentTest test = getExtentTest();
        if (test != null) {
            test.log(Status.INFO, message);
        }
    }

    public static void logError(String message, Throwable t) {
        Logger logger = getLogger(LoggerHelper.class);
        logger.error(message, t);
        ExtentTest test = getExtentTest();
        if (test != null) {
            test.log(Status.FAIL, message + " - " + t.getMessage());
        }
    }
}
