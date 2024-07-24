package com.nop.commerce.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Map;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement storeLogo;
    @FindBy(className = "ico-register")
    WebElement registerLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Log out")
    WebElement logoutLink;
    @FindBy(linkText = "My account")
    WebElement myAccountLink;
    @FindBy(id ="newsletter-email")
    WebElement subscriptionEmailInput;
    @FindBy(id = "newsletter-subscribe-button")
    WebElement subscriptionBtn;
    @FindBy(id = "newsletter-result-block")
    WebElement signUpMessage;
    @FindBy(id = "newsletter-result-block")
    WebElement invalidEmailErrorMessage;



   public void verifyHomePageTitle(){
       Assert.assertTrue(storeLogo.isDisplayed(),"Store Logo is not displayed");
       String verifyHomePageTitle = driver.getTitle();
       Assert.assertEquals(verifyHomePageTitle,"nopCommerce demo store","Home Page Title does not match");
   }
    public void clickRegisterLink(){
        Assert.assertTrue(registerLink.isDisplayed(),"Register Link is Not Displayed");
        registerLink.click();
    }

    public void clickMyAccountLink(){
        Assert.assertTrue(myAccountLink.isDisplayed(),"My Account is Not Displayed");
        myAccountLink.click();
    }

    public void clickOnLoginLink(){
        Assert.assertTrue(loginLink.isDisplayed(),"Login Link is Not Displayed");
        loginLink.click();
    }

    public void clickOnLogoutLink(){
        Assert.assertTrue(logoutLink.isDisplayed(),"Logout Link is Not Displayed");
        logoutLink.click();
    }

    public void subscribeToNewsLetter(String email) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println(email);
        subscriptionEmailInput.sendKeys(email);
    }
    public void clickSubscriptionBtn(){
        Assert.assertTrue(subscriptionBtn.isEnabled(),"Subscription Button is Not Displayed");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", subscriptionBtn);
    }
    public void verifySingUpMessage(){
        wait.until(ExpectedConditions.visibilityOf(signUpMessage));
        Assert.assertEquals(signUpMessage.getText(), "Thank you for signing up! A verification email has been sent. We appreciate your interest.","Singing up Message is Not Displayed");
    }

    public void verifyInvalidErrorMessageForSubscribe(){
        wait.until(ExpectedConditions.visibilityOf(invalidEmailErrorMessage));
        Assert.assertEquals(invalidEmailErrorMessage.getText(),"Enter valid email","Enter valid email error message is Not Displayed");
    }
}
