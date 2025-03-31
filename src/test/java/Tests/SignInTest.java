package Tests;

import Base.BaseTest;
import Helper.RetryAnalyzer;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest
{

    @Test(description = "Login Test. Author: Priyag", retryAnalyzer = RetryAnalyzer.class)
    public void loginSauceLab()
    {
        signInPage.LoginToSauceDemo();
    }

    @Test(description = "Add to Cart Test. Author: Priyag" , retryAnalyzer = RetryAnalyzer.class)
    public void AddToCartTest()
    {
        signInPage.LoginToSauceDemo();
        signInPage.AddToCartAndValidateCartItem();
    }
}
