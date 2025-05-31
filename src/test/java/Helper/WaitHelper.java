package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Data.Constant;

import java.time.Duration;

public class WaitHelper {

    protected static WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.Timeout.LONG.getSeconds()));  // Default timeout of 30 seconds
    }

    /**
     * Waits for the visibility of a WebElement.
     *
     * @param element WebElement to wait for
     * @param timeoutInSeconds Maximum time to wait
     */
    public static void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param element WebElement to wait for
     * @param timeoutInSeconds Maximum time to wait
     */
    public static void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for a WebElement to be present in the DOM.
     *
     * @param element WebElement to wait for
     * @param timeoutInSeconds Maximum time to wait
     */
    public static void waitForElementPresence(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    /**
     * Waits for a WebElement to be invisible.
     *
     * @param element WebElement to wait for
     * @param timeoutInSeconds Maximum time to wait
     */
    public static void waitForElementInvisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.invisibilityOf(element));
    }
}

