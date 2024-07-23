package com.nop.commerce.e2e;
import com.nop.commerce.base.BaseTest;
import com.nop.commerce.pages.HomePage;
import com.nop.commerce.pages.LoginPage;
import com.nop.commerce.pages.MyAccountPage;
import com.nop.commerce.pages.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilis.ExcelReader;
import java.util.Map;

public class NopCommerceRegistrationTests extends BaseTest {


    @DataProvider(name = "users")
    public Object[][] getData() {
        ExcelReader excelReader = new ExcelReader("src/main/resources/tast_data/userinfo.xlsx", "users");
        return excelReader.getData();
    }


    @Test(dataProvider = "users")
    public void nopCommerceRegistrationPositiveTest(Map<String, String> users) {

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        homePage.verifyHomePageTitle();
        homePage.clickRegisterLink();

        registerPage.verifyRegisterPageHeader();

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

