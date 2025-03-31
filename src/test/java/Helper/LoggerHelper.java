package Helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

    public static void logInfo(ExtentTest test, String message) {
        Logger logger = getLogger(LoggerHelper.class);
        logger.info(message);
        if (test != null) {
            test.log(Status.INFO, message);
        }
    }

    public static void logError(ExtentTest test, String message, Throwable t) {
        Logger logger = getLogger(LoggerHelper.class);
        logger.error(message, t);
        if (test != null) {
            test.log(Status.FAIL, message + " - " + t.getMessage());
        }
    }
}