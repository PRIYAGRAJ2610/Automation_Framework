package Helper;

import org.openqa.selenium.By;

/**
 * Utility class to generate dynamic XPath locators using `?` placeholders.
 * Each `?` in the XPath string will be replaced in order with the provided values.
 */
public class XPathHelper {

    /**
     * Used for: Any dynamic XPath with one or more `?`
     * XPath pattern example: "//div[@data-id='?']"
     */
    public static By getDynamicXPath(String xpathTemplate, String... values) {
        for (String value : values) {
            xpathTemplate = xpathTemplate.replaceFirst("\\?", java.util.regex.Matcher.quoteReplacement(value));
        }
        return By.xpath(xpathTemplate);
    }

    /**
     * Used for: Matching exact visible text
     * XPath pattern example: "//a[text()='?']"
     */
    public static By getElementByText(String xpathTemplate, String text) {
        return getDynamicXPath(xpathTemplate, text);
    }

    /**
     * Used for: Contains/@id or @class partial matching
     * XPath pattern example: "//*[contains(@class, '?')]"
     */
    public static By getElementByPartialAttribute(String xpathTemplate, String partialValue) {
        return getDynamicXPath(xpathTemplate, partialValue);
    }

    /**
     * Used for: Select nth element from list
     * XPath pattern example: "(//li[@class='option'])[?]"
     */
    public static By getElementByIndex(String xpathTemplate, int index) {
        return getDynamicXPath(xpathTemplate, String.valueOf(index));
    }

    /**
     * Used for: Row/Col specific table access
     * XPath pattern example: "//table/tbody/tr[?]/td[?]"
     */
    public static By getTableCell(String xpathTemplate, int row, int col) {
        return getDynamicXPath(xpathTemplate, String.valueOf(row), String.valueOf(col));
    }
}
