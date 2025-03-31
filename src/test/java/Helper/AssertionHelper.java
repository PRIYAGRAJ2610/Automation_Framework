package Helper;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionHelper {

    public static void assertElementVisible(WebElement element, ExtentTest test) {
        try {
            Assert.assertTrue(element.isDisplayed(), "Element is not visible.");
            LoggerHelper.logInfo(test, "Element is visible: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element is not visible: " + element.toString(), e);
            throw e;
        }
    }

    public static boolean validateSendKeys(WebElement element, String text, ExtentTest test) {
        try {
            element.clear();
            element.sendKeys(text);
            boolean result = text.equals(element.getAttribute("value"));
            LoggerHelper.logInfo(test, "Entered text in element: " + element.toString() + " | Value: " + text);
            return result;
        } catch (Exception e) {
            LoggerHelper.logError(test, "Failed to send keys to element: " + element.toString(), e);
            return false;
        }
    }

    public static boolean validateClick(WebElement element, ExtentTest test) {
        try {
            element.click();
            LoggerHelper.logInfo(test, "Clicked on element: " + element.toString());
            return true;
        } catch (Exception e) {
            LoggerHelper.logError(test, "Failed to click element: " + element.toString(), e);
            return false;
        }
    }

    public static void assertElementTextEquals(WebElement element, String expectedText, ExtentTest test) {
        try {
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Element text does not match the expected value.");
            LoggerHelper.logInfo(test, "Element text matches expected: " + expectedText);
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element text mismatch: Expected - " + expectedText + ", Actual - " + element.getText(), e);
            throw e;
        }
    }

    public static void assertElementEnabled(WebElement element, ExtentTest test) {
        try {
            Assert.assertTrue(element.isEnabled(), "Element is not enabled.");
            LoggerHelper.logInfo(test, "Element is enabled: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element is not enabled: " + element.toString(), e);
            throw e;
        }
    }

    public static void assertElementSelected(WebElement element, ExtentTest test) {
        try {
            Assert.assertTrue(element.isSelected(), "Element is not selected.");
            LoggerHelper.logInfo(test, "Element is selected: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element is not selected: " + element.toString(), e);
            throw e;
        }
    }

    public static void assertElementContainsText(WebElement element, String expectedText, ExtentTest test) {
        try {
            String actualText = element.getText();
            Assert.assertTrue(actualText.contains(expectedText),
                    "Element text does not contain the expected value. Actual: " + actualText + ", Expected: " + expectedText);
            LoggerHelper.logInfo(test, "Element contains expected text: " + expectedText);
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element text does not contain expected value: " + expectedText, e);
            throw e;
        }
    }

    public static void assertElementAttributeEquals(WebElement element, String attributeName, String expectedValue, ExtentTest test) {
        try {
            String actualValue = element.getAttribute(attributeName);
            Assert.assertEquals(actualValue, expectedValue,
                    "Element attribute '" + attributeName + "' does not match the expected value.");
            LoggerHelper.logInfo(test, "Element attribute matches expected: " + attributeName + " = " + expectedValue);
        } catch (AssertionError e) {
            LoggerHelper.logError(test, "Element attribute mismatch: " + attributeName + " Expected - " + expectedValue + ", Actual - " + element.getAttribute(attributeName), e);
            throw e;
        }
    }
}
