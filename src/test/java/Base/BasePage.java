// BasePage.java
package Base;

import Helper.LoggerHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected ExtentTest test;

    public BasePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    private String getElementIdentifier(WebElement element) {
        try {
            // 1️⃣ Get Tag Name
            String tagName = element.getTagName();

            // 2️⃣ Get ID and Name attributes
            String id = element.getDomAttribute("id");
            String nameAttr = element.getDomAttribute("name");

            // 3️⃣ Fallback to getAttribute() if DOM attributes are null
            if (id == null || id.isEmpty()) {
                id = element.getAttribute("id");
            }
            if (nameAttr == null || nameAttr.isEmpty()) {
                nameAttr = element.getAttribute("name");
            }

            // 4️⃣ Get Class Name & Text Content
            String classAttr = element.getAttribute("class");
            String text = element.getText().trim();

            // 6️⃣ Identify Element
            if (id != null && !id.isEmpty()) {
                return tagName + " with id='" + id + "'";
            }
            if (nameAttr != null && !nameAttr.isEmpty()) {
                return tagName + " with name='" + nameAttr + "'";
            }
            if (classAttr != null && !classAttr.isEmpty()) {
                return tagName + " with class='" + classAttr + "'";
            }
            if (!text.isEmpty()) {
                return tagName + " with text='" + text + "'";
            }

            // 7️⃣ Fallback Case
            return tagName + " (No ID, Name, Class, or Text)";
        } catch (Exception e) {
            return "Unknown Element"; // In case of any failure
        }
    }


    public void click(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            String elementName = getElementIdentifier(element);
            LoggerHelper.logInfo(test, "Clicked on: " + elementName);
        } catch (Exception e) {
            LoggerHelper.logError(test, "Failed to click on: " + getElementIdentifier(element), e);
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);

            String elementName = getElementIdentifier(element);
            LoggerHelper.logInfo(test, "Entered text in: " + elementName + " | Value: " + text);
        } catch (Exception e) {
            LoggerHelper.logError(test, "Failed to enter text in: " + getElementIdentifier(element), e);
        }
    }
}