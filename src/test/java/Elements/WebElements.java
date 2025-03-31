// WebElements.java
package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {
    private WebDriver driver;

    // Constructor
    public WebElements(WebDriver driver) {
        // Initialize WebDriver
        this.driver = driver;
    }

    // WebElement declaration
//    public WebElement SignInLink() {return driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));}
//    public WebElement EmailOrPhoneInputField() {return driver.findElement(By.xpath("//input[@id='session_key']"));}
//    public WebElement PasswordInputField() {return driver.findElement(By.xpath("//input[@id='session_password']"));}
//    public WebElement SignInButton(){return driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));}
   // public WebElement connectButtton(){return driver.findElement(By.xpath("//button[@class='Web3Status__StyledConnectButton-sc-d00a9aba-6 itXeqc']"));}
//    public WebElement InstallMetaMask(){return driver.findElement(By.xpath("//div[@class = 'Option__HeaderText-sc-7bbb556d-2 hMknws']"));}
//    public WebElement DownloadForChromeButton(){return driver.findElement(By.xpath("//a[@class ='Button__ButtonWrapper-sc-5os99m-1 bKcKNQ button chrome']"));}
    public WebElement AddToChromeButton(){return driver.findElement(By.xpath("//button[@class='UywwFc-LgbsSe UywwFc-LgbsSe-OWXEXe-dgl2Hf UywwFc-LgbsSe-OWXEXe-wdeprb-MD85tf-DKzjMe']"));}
}
