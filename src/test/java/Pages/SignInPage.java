package Pages;

import Base.BasePage;
import Data.Constant;
import Helper.AssertionHelper;
import Helper.WaitHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage
{
    @FindBy(xpath = "//input[@id = 'user-name']")
    private WebElement UsernameInput ;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement PasswordInput ;
    @FindBy(xpath = "//input[@id = 'login-button']")
    private WebElement LoginButton;

    @FindBy(xpath = "//h3[contains(text(),'Username and password do not match any user')]")
    private WebElement InvalidUserWarningBanner;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement LeftNavBarButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement CartButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement LogoutButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement BikeLightAddToCartButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement InventoryItem;


    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void LoginToSauceDemo(String user , String password)
    {
        AssertionHelper.assertElementVisible(UsernameInput , "UsernameInput");
        enterText(UsernameInput, "UsernameInput",user);
        AssertionHelper.assertElementVisible(PasswordInput,"PasswordInput");
        enterText(PasswordInput,"PasswordInput",password);
        click(LoginButton,"LoginButton");
    }

    public void ValidateInvalidUserWarningBanner()
    {
        AssertionHelper.assertElementVisible(InvalidUserWarningBanner,"InvalidUserWarningBanner");
    }

    public void LogOut()
    {
        AssertionHelper.assertElementVisible(LeftNavBarButton,"LeftNavBarButton");
        click(LeftNavBarButton,"LeftNavBarButton");
        WaitHelper.waitForElementVisibility(LeftNavBarButton,Constant.Timeout.LONG.getSeconds());
        AssertionHelper.assertElementVisible(LogoutButton,"LogOutButton");
        //(LogoutButton,"LogoutButton");
        click(LogoutButton,"LogoutButton");
    }

    public void AddToCartAndValidateCartItem()
    {
        AssertionHelper.assertElementVisible(BikeLightAddToCartButton,"BikeLightAddToCartButton");
        click(BikeLightAddToCartButton,"BikeLightAddToCartButton");
        AssertionHelper.assertElementVisible(CartButton,"CartButton");
        click(CartButton,"CartButton");
        AssertionHelper.assertElementTextEquals(InventoryItem,Constant.LoginConstant.SauceLabsBikeLight);
    }
}
