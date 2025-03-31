package Helper;


import org.openqa.selenium.By;

public class XPathHelper {

    /**
     * Replaces placeholders in the given XPath template with provided values.
     * @param xpathTemplate XPath string with placeholders (e.g., "//button[text()='{0}']")
     * @param values Values to replace placeholders
     * @return By locator with dynamic XPath
     */
    public static By getDynamicXPath(String xpathTemplate, String... values) {
        for (int i = 0; i < values.length; i++) {
            xpathTemplate = xpathTemplate.replace("{" + i + "}", values[i]);
        }
        return By.xpath(xpathTemplate);
    }

    /**
     * Get an element by visible text dynamically.
     * @param xpathTemplate XPath template with a placeholder (e.g., "//button[text()='{0}']")
     * @param text Visible text to replace in XPath
     * @return By locator with dynamic XPath
     */
    public static By getElementByText(String xpathTemplate, String text) {
        return getDynamicXPath(xpathTemplate, text);
    }

    /**
     * Get an element by partial attribute match dynamically.
     * @param xpathTemplate XPath template with a placeholder (e.g., "//*[contains(@id, '{0}')]")
     * @param partialValue Partial value to replace in XPath
     * @return By locator with dynamic XPath
     */
    public static By getElementByPartialAttribute(String xpathTemplate, String partialValue) {
        return getDynamicXPath(xpathTemplate, partialValue);
    }

    /**
     * Get an element from a list using index dynamically.
     * @param xpathTemplate XPath template with an index placeholder (e.g., "(//li)[{0}]")
     * @param index Index to replace in XPath
     * @return By locator with dynamic XPath
     */
    public static By getElementByIndex(String xpathTemplate, int index) {
        return getDynamicXPath(xpathTemplate, String.valueOf(index));
    }

    /**
     * Get a table cell dynamically by row and column index.
     * @param xpathTemplate XPath template with row and column placeholders (e.g., "//table/tbody/tr[{0}]/td[{1}]")
     * @param row Row index to replace in XPath
     * @param col Column index to replace in XPath
     * @return By locator with dynamic XPath
     */
    public static By getTableCell(String xpathTemplate, int row, int col) {
        return getDynamicXPath(xpathTemplate, String.valueOf(row), String.valueOf(col));
    }
}
