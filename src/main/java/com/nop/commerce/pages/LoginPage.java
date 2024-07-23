package com.nop.commerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Map;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement emailAddress;
    @FindBy(id = "Password")
    WebElement passwordInput;
    @FindBy(id = "RememberMe")
    WebElement rememberBox;
    @FindBy(xpath = "//a[@href='/passwordrecovery' and text()='Forgot password?']")
    WebElement forgotPasswordLink;
    @FindBy(className = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement verifyErrorMessage;
    @FindBy(id = "Email-error")
    WebElement verifyInvalidEmailMessage;

   public void enterEmail(String email){
       emailAddress.sendKeys(email);
   }
   public void enterPassword(String password){
       passwordInput.sendKeys(password);
   }
   public void clickRememberMeBox(){
       rememberBox.click();
   }
   public void verifyForgotPasswordLink(){
       Assert.assertTrue(forgotPasswordLink.isDisplayed(),"Forgot Password is Not Displayed");
   }
   public void clickLoginBtn(){
       Assert.assertTrue(loginBtn.isDisplayed(),"Login Button is Not Displayed");
       loginBtn.click();
   }


   public void verifyLoginError(){
       Assert.assertTrue(verifyErrorMessage.isDisplayed(),"Login Error message is Not Displayed");

   }
   public void enteredInvalidEmail(){
       Assert.assertTrue(verifyInvalidEmailMessage.isDisplayed(),"Invalid Email Message is Not Displayed");

   }
}
