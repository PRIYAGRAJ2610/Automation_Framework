package Tests;

import Base.BaseTest;
import Data.Constant.*;
import Helper.RetryAnalyzer;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest
{

    @Test(description = "User can successfully Login after entering valid Credentials. Author: Priyag Raj Sharma",
            retryAnalyzer = RetryAnalyzer.class ,  groups = {"regression"})
    public void loginSauceLab()
    {
        pages().signInPage().LoginToSauceDemo(LoginConstant.STANDARD_USERNAME,LoginConstant.STANDARD_PASSWORD);
        pages().signInPage().LogOut();
    }

    @Test(description = "User can not Login with Invalid Credentials. Author: Priyag Raj Sharma",
            retryAnalyzer = RetryAnalyzer.class , groups = {"smoke"})
    public void loginSauceLabWithInvalidCredentials()
    {
        pages().signInPage().LoginToSauceDemo(InvalidUser.userName,InvalidUser.password);
        pages().signInPage().ValidateInvalidUserWarningBanner();
    }

    @Test(description = "Add to Cart Test. Author: Priyag Raj Sharma" , retryAnalyzer = RetryAnalyzer.class , groups = {"sanity"})
    public void AddToCartTest()
    {
        pages().signInPage().LoginToSauceDemo(LoginConstant.STANDARD_USERNAME,LoginConstant.STANDARD_PASSWORD);
        pages().signInPage().AddToCartAndValidateCartItem();
        pages().signInPage().LogOut();
    }

    @Test(description = "User can successfully Login after entering valid Credentials. Author: Priyag Raj Sharma",
            retryAnalyzer = RetryAnalyzer.class , groups = {"sanity"})
    public void PrintPartsThatAreUnavailableToAddToCart()
    {
        pages().signInPage().LoginToSauceDemo(LoginConstant.Problem_Username,LoginConstant.STANDARD_PASSWORD);
        pages().signInPage().PrintUnorderedParts();
        pages().signInPage().LogOut();
    }
}
