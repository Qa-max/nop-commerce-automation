package com.nop.commerce.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.Map;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement registerPageHeader;
    @FindBy(id = "FirstName")
    WebElement firstNameInput;
    @FindBy(id = "LastName")
    WebElement lastNameInput;
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement getDateOfBirthYear;
    @FindBy(id = "Email")
    WebElement emailInput;
    @FindBy(id = "Company")
    WebElement companyName;
    @FindBy(id = "Newsletter")
    WebElement newsletterCheckbox;
    @FindBy(id = "Password")
    WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInput;
    @FindBy(name = "register-button")
    WebElement registerBtn;
    @FindBy(xpath = "//div[@class='result']")
    WebElement verifyRegisterMessage;
    @FindBy(xpath = "//a[contains(@class, 'continue-button')]")
    WebElement continueBtn;

    @FindBy(id="FirstName-error")
    WebElement firstNameIsRequiredMessage;
    @FindBy(id ="LastName-error")
    WebElement lastNameIsRequiredMessage;

    @FindBy(id = "Email-error")
    WebElement emailErrorMessage;

    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//li[text()='The specified email already exists']")
    WebElement specifiedEmailAlreadyExistsMessage;

    public void verifyRegisterPageHeader(){
        Assert.assertTrue(registerPageHeader.isDisplayed(),"Page register Header is NOT displayed");
    }
    public void enterPersonalDetails(Map<String,String> users){
        firstNameInput.sendKeys(users.get("firstname"));
        lastNameInput.sendKeys(users.get("lastname"));
        dateOfBirthDay.sendKeys(users.get("day"));
        dateOfBirthMonth.sendKeys(users.get("month"));
        getDateOfBirthYear.sendKeys(users.get("year"));
        emailInput.sendKeys(users.get("email"));
    }

    public void enterCompanyDetails(Map<String, String> users) {
        companyName.sendKeys(users.get("company_name"));
    }
    public void chooseNewsLetterOptions(Map<String, String> users) {
        if (users.get("newsletter").equals("yes")) {
            if (!newsletterCheckbox.isSelected()){
                newsletterCheckbox.click();
            }
        }else{
            if (newsletterCheckbox.isSelected()){
                newsletterCheckbox.click();
            }
        }
    }
    public void enterPassword(Map<String, String> users) {
        passwordInput.sendKeys(users.get("password"));
    }

    public void enterConfirmPassword(Map<String, String> users){
        confirmPasswordInput.sendKeys(users.get("password"));
    }


    public void clickRegisterBtn(){
        Assert.assertTrue(registerBtn.isDisplayed(),"Register Link is Not Displayed");
        registerBtn.click();
    }
    public void verifyRegisterMessage(){
        Assert.assertTrue(verifyRegisterMessage.isDisplayed(),"Register Message is Not Displayed");
    }
    public void clickOnContinueBtn(){
       Assert.assertTrue(continueBtn.isDisplayed(),"Continue Button is Not displayed");
       continueBtn.click();
    }

    public void verifyFirstNameIsRequiredMessage(){
        Assert.assertTrue(firstNameIsRequiredMessage.isDisplayed(), "'First name is required message' is Not displayed");
    }

    public void verifyLastNameIsRequiredMessage(){
        Assert.assertTrue(lastNameIsRequiredMessage.isDisplayed(), "'Last name is required message' is Not displayed");

    }

    public void verifyEmailErrorMessage(){
        Assert.assertTrue(emailErrorMessage.isDisplayed(), "'Please enter a valid email address' is Not displayed");
    }

    public void verifyConfirmPasswordErrorMessage(){
        Assert.assertTrue(confirmPasswordErrorMessage.isDisplayed(), "'The password and confirmation password do not match' is Not displayed");
    }

    public void verifySpecifiedEmailAlreadyExistsMessage(){
        Assert.assertTrue(specifiedEmailAlreadyExistsMessage.isDisplayed(), "'Specified Email Already Exists' is Not displayed");
    }

    public void clearRegisterForm(){
        firstNameInput.clear();
        lastNameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        confirmPasswordInput.clear();
    }


}




