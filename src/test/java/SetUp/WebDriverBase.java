package SetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverBase {
    private static WebDriver driver;

    public static void initializeWebDriver() {
        if (driver != null) {
            return; // Prevent reinitialization if already set
        }

        // Read browser name from config file, default to "chrome"
        String browser = System.getProperty("browser", ConfigReader.getProperty("browser")).toLowerCase();

        // Determine if running in a CI environment (e.g., Jenkins)
        boolean isCIEnvironment = System.getenv("CI") != null || System.getenv("JENKINS_HOME") != null;
        // Read headless property, default to "true" if in CI, "false" otherwise
        String headlessProperty = System.getProperty("headless", isCIEnvironment ? "true" : "false");
        boolean isHeadless = "true".equalsIgnoreCase(headlessProperty);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-password-leak-detection");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                firefoxOptions.addArguments("--disable-popup-blocking");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                edgeOptions.addArguments("--disable-notifications");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }

    public static WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        }
        initializeWebDriver();
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}