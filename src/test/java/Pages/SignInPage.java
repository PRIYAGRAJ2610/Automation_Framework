package Pages;

import Base.BasePage;
import Data.Constant;
import Helper.AssertionHelper;
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

    public void LoginToSauceDemo()
    {
        AssertionHelper.assertElementVisible(UsernameInput);
        enterText(UsernameInput, Constant.LoginConstant.STANDARD_USERNAME);
        enterText(PasswordInput, Constant.LoginConstant.STANDARD_PASSWORD);
        click(LoginButton);
    }

    public void AddToCartAndValidateCartItem()
    {
        AssertionHelper.assertElementVisible(BikeLightAddToCartButton);
        click(BikeLightAddToCartButton);
        AssertionHelper.assertElementVisible(CartButton);
        click(CartButton);
        AssertionHelper.assertElementTextEquals(InventoryItem,Constant.LoginConstant.SauceLabsBikeLight);
    }
}
