package Pages;

import org.openqa.selenium.WebDriver;
import Pages.SignInPage;
// import other page classes

public class PageObjectManager {
    private WebDriver driver;

    private SignInPage signInPage;
    // Add other page object declarations here

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage signInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage(driver);
        }
        return signInPage;
    }

    // Add other getter methods similarly
}
