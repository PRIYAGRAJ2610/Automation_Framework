package Base;

import Data.Constant;
import Helper.LoggerHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String getElementIdentifier(WebElement element) {
        try {
            String tagName = element.getTagName();
            String id = element.getDomAttribute("id");
            String nameAttr = element.getDomAttribute("name");

            if (id == null || id.isEmpty()) id = element.getAttribute("id");
            if (nameAttr == null || nameAttr.isEmpty()) nameAttr = element.getAttribute("name");

            String classAttr = element.getAttribute("class");
            String text = element.getText().trim();

            if (id != null && !id.isEmpty()) return tagName + " with id='" + id + "'";
            if (nameAttr != null && !nameAttr.isEmpty()) return tagName + " with name='" + nameAttr + "'";
            if (classAttr != null && !classAttr.isEmpty()) return tagName + " with class='" + classAttr + "'";
            if (!text.isEmpty()) return tagName + " with text='" + text + "'";

            return tagName + " (No ID, Name, Class, or Text)";
        } catch (Exception e) {
            return "Unknown Element";
        }
    }

    public void click(WebElement element , String elementName) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constant.Timeout.MEDIUM.getSeconds()))
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            LoggerHelper.logInfo("Clicked on: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to click on: " + elementName, e);
        }
    }

    public void enterText(WebElement element, String elementName,String text) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constant.Timeout.MEDIUM.getSeconds()))
                    .until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            LoggerHelper.logInfo("Entered text in: " + elementName + " | Value: " + text);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to enter text in: " + elementName, e);
        }
    }

    public void selectDropdown(WebElement element, String text, String elementName) {
        try {
            new Select(element).selectByVisibleText(text);
            LoggerHelper.logInfo("Selected '" + text + "' from dropdown: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to select '" + text + "' from dropdown: " + elementName, e);
        }
    }

    public void clickCheckbox(WebElement element, String elementName) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
            LoggerHelper.logInfo("Checked: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to check: " + elementName, e);
        }
    }

    public void hoverOverElement(WebElement element, String elementName) {
        try {
            new Actions(driver).moveToElement(element).perform();
            LoggerHelper.logInfo("Hovered over: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to hover over: " + elementName, e);
        }
    }

    public String getText(WebElement element, String elementName) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constant.Timeout.MEDIUM.getSeconds()))
                    .until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            LoggerHelper.logInfo("Text from " + elementName + ": " + text);
            return text;
        } catch (Exception e) {
            LoggerHelper.logError("Failed to get text from: " + elementName, e);
            return null;
        }
    }



    public String getAttributeValue(WebElement element, String attribute, String elementName) {
        try {
            String value = element.getAttribute(attribute);
            LoggerHelper.logInfo("Attribute '" + attribute + "' of " + elementName + " is: " + value);
            return value;
        } catch (Exception e) {
            LoggerHelper.logError("Failed to get attribute '" + attribute + "' from " + elementName, e);
            return null;
        }
    }

    // JavaScriptExecutor Methods

    public void clickUsingJS(WebElement element, String elementName) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            LoggerHelper.logInfo("Clicked using JS on: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to click using JS on: " + elementName, e);
        }
    }

    public void scrollToElement(WebElement element, String elementName) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            LoggerHelper.logInfo("Scrolled to: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to scroll to: " + elementName, e);
        }
    }

}
