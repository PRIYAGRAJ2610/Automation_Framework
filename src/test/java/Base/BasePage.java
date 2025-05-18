package Base;

import Helper.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void click(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            String elementName = getElementIdentifier(element);
            LoggerHelper.logInfo("Clicked on: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to click on: " + getElementIdentifier(element), e);
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);

            String elementName = getElementIdentifier(element);
            LoggerHelper.logInfo("Entered text in: " + elementName + " | Value: " + text);
        } catch (Exception e) {
            LoggerHelper.logError("Failed to enter text in: " + getElementIdentifier(element), e);
        }
    }
}
