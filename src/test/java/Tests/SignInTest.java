package Tests;

import Base.BaseTest;
import Data.Constant.*;
import Helper.RetryAnalyzer;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest
{

    @Test(description = "User can successfully Login after entering valid Credentials. Author: Priyag Raj Sharma",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginSauceLab()
    {
        signInPage.LoginToSauceDemo(LoginConstant.STANDARD_USERNAME,LoginConstant.STANDARD_PASSWORD);
        signInPage.LogOut();
    }

    @Test(description = "User can not Login with Invalid Credentials. Author: Priyag Raj Sharma",
            retryAnalyzer = RetryAnalyzer.class)
    public void loginSauceLabWithInvalidCredentials()
    {
        signInPage.LoginToSauceDemo(InvalidUser.userName,InvalidUser.password);
        signInPage.ValidateInvalidUserWarningBanner();
    }

    @Test(description = "Add to Cart Test. Author: Priyag Raj Sharma" , retryAnalyzer = RetryAnalyzer.class)
    public void AddToCartTest()
    {
        signInPage.LoginToSauceDemo(LoginConstant.STANDARD_USERNAME,LoginConstant.STANDARD_PASSWORD);
        signInPage.AddToCartAndValidateCartItem();
        signInPage.LogOut();
    }
}
