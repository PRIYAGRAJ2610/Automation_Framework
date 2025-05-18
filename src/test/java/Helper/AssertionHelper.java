package Helper;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionHelper {

    public static void assertElementVisible(WebElement element) {
        try {
            Assert.assertTrue(element.isDisplayed(), "Element is not visible.");
            LoggerHelper.logInfo("Element is visible: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError("Element is not visible: " + element.toString(), e);
            throw e;
        }
    }

    public static boolean EnterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            boolean result = text.equals(element.getAttribute("value"));
            LoggerHelper.logInfo("Entered text in element: " + element.toString() + " | Value: " + text);
            return result;
        } catch (Exception e) {
            LoggerHelper.logError("Failed to send keys to element: " + element.toString(), e);
            return false;
        }
    }

    public static boolean validateClick(WebElement element) {
        try {
            element.click();
            LoggerHelper.logInfo("Clicked on element: " + element.toString());
            return true;
        } catch (Exception e) {
            LoggerHelper.logError("Failed to click element: " + element.toString(), e);
            return false;
        }
    }

    public static void assertElementTextEquals(WebElement element, String expectedText) {
        try {
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Element text does not match the expected value.");
            LoggerHelper.logInfo("Element text matches expected: " + expectedText);
        } catch (AssertionError e) {
            LoggerHelper.logError("Element text mismatch: Expected - " + expectedText + ", Actual - " + element.getText(), e);
            throw e;
        }
    }

    public static void assertElementEnabled(WebElement element) {
        try {
            Assert.assertTrue(element.isEnabled(), "Element is not enabled.");
            LoggerHelper.logInfo("Element is enabled: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError("Element is not enabled: " + element.toString(), e);
            throw e;
        }
    }

    public static void assertElementSelected(WebElement element) {
        try {
            Assert.assertTrue(element.isSelected(), "Element is not selected.");
            LoggerHelper.logInfo("Element is selected: " + element.toString());
        } catch (AssertionError e) {
            LoggerHelper.logError("Element is not selected: " + element.toString(), e);
            throw e;
        }
    }

    public static void assertElementContainsText(WebElement element, String expectedText) {
        try {
            String actualText = element.getText();
            Assert.assertTrue(actualText.contains(expectedText),
                    "Element text does not contain the expected value. Actual: " + actualText + ", Expected: " + expectedText);
            LoggerHelper.logInfo("Element contains expected text: " + expectedText);
        } catch (AssertionError e) {
            LoggerHelper.logError("Element text does not contain expected value: " + expectedText, e);
            throw e;
        }
    }

    public static void assertElementAttributeEquals(WebElement element, String attributeName, String expectedValue) {
        try {
            String actualValue = element.getAttribute(attributeName);
            Assert.assertEquals(actualValue, expectedValue,
                    "Element attribute '" + attributeName + "' does not match the expected value.");
            LoggerHelper.logInfo("Element attribute matches expected: " + attributeName + " = " + expectedValue);
        } catch (AssertionError e) {
            LoggerHelper.logError("Element attribute mismatch: " + attributeName + " Expected - " + expectedValue + ", Actual - " + element.getAttribute(attributeName), e);
            throw e;
        }
    }
}
