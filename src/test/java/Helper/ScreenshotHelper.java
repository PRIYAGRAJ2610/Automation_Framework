package Helper;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static final Logger log = LoggerHelper.getLogger(ScreenshotHelper.class);

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png").getAbsolutePath();

        try {
            FileHandler.createDir(new File(System.getProperty("user.dir") + "/screenshots"));
            FileHandler.copy(src, new File(screenshotPath));
            log.info("Screenshot captured: " + screenshotPath);

            // Attach to Allure report as file
            Allure.addAttachment(screenshotName, new ByteArrayInputStream(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES)));

        } catch (IOException e) {
            log.error("Failed to capture screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }

    public static String captureScreenshotAsBase64(WebDriver driver) {
        log.info("Capturing screenshot in Base64 format...");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
