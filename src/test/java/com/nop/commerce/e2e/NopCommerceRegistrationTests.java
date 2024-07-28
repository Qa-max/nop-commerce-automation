package com.nop.commerce.e2e;
import com.aventstack.extentreports.Status;
import com.nop.commerce.base.BaseTest;
import com.nop.commerce.pages.HomePage;
import com.nop.commerce.pages.LoginPage;
import com.nop.commerce.pages.MyAccountPage;
import com.nop.commerce.pages.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nop.commerce.utilis.ExcelReader;
import java.util.Map;

public class NopCommerceRegistrationTests extends BaseTest {


    @DataProvider(name = "users")
    public Object[][] getData() {
        ExcelReader excelReader = new ExcelReader("src/main/resources/test_data/userinfo.xlsx", "users");
        return excelReader.getData();
    }


    @Test(dataProvider = "users")
    public void nopCommerceRegistrationPositiveTest(Map<String, String> users) {
        startTest("nopCommerce registration Test");

        HomePage homePage = new HomePage(driver);
        test.get().log(Status.INFO,"Navigated to home page");

        RegisterPage registerPage = new RegisterPage(driver);
        test.get().log(Status.INFO,"Navigate to registration page");

        LoginPage loginPage = new LoginPage(driver);
        test.get().log(Status.PASS,"Navigate to Login Page");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        test.get().log(Status.PASS,"Navigate to MyAccount Page");

        homePage.verifyHomePageTitle();
        test.get().log(Status.PASS,"Home Page title is verified");

        homePage.clickRegisterLink();
        test.get().log(Status.INFO, "Clicked register link");

        registerPage.verifyRegisterPageHeader();
        test.get().log(Status.PASS,"Register page header is verified");

        registerPage.enterPersonalDetails(users);
        registerPage.enterCompanyDetails(users);
        registerPage.chooseNewsLetterOptions(users);
        registerPage.enterPassword(users);
        registerPage.enterConfirmPassword(users);

        registerPage.clickRegisterBtn();
        registerPage.verifyRegisterMessage();
        registerPage.clickOnContinueBtn();

        homePage.clickOnLogoutLink();
        homePage.clickOnLoginLink();

        loginPage.enterEmail(users.get("email"));
        loginPage.enterPassword(users.get("password"));
        loginPage.verifyForgotPasswordLink();
        loginPage.clickRememberMeBox();
        loginPage.clickLoginBtn();

        homePage.clickMyAccountLink();
        myAccountPage.verifyMyAccountCustomerHeader();
        homePage.clickOnLogoutLink();
    }
}

