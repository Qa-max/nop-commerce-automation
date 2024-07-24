package com.nop.commerce.e2e;

import com.nop.commerce.base.BaseTest;
import com.nop.commerce.pages.HomePage;
import com.nop.commerce.pages.LoginPage;
import org.testng.annotations.Test;

public class NopCommerceLoginTests extends BaseTest {

    @Test
    public void nopCommerceIncorrectCredentialsLoginTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickOnLoginLink();
        String email = faker.internet().emailAddress();
        String password = "Hello123!";
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.verifyForgotPasswordLink();
        loginPage.clickRememberMeBox();
        loginPage.clickLoginBtn();
        loginPage.verifyLoginError();
    }

    @Test
    public void nopCommerceInvalidCredentialsLoginTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickOnLoginLink();

        String name = faker.name().firstName() + "." +faker.name().lastName();
        String password = "Hello123!";

        loginPage.enterEmail(name);
        loginPage.enterPassword(password);
        loginPage.verifyForgotPasswordLink();
        loginPage.clickRememberMeBox();
        loginPage.clickLoginBtn();
        loginPage.enteredInvalidEmail();
    }

}
