package com.nop.commerce.e2e;

import com.nop.commerce.base.BaseTest;
import com.nop.commerce.pages.BasePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nop.commerce.utilis.ExcelReader;
import java.util.Map;

public class SubscribeToNewsLetterTests extends BaseTest {
    @DataProvider(name = "subscription")
    public Object[][] getData() {
        ExcelReader excelReader = new ExcelReader("src/main/resources/test_data/userinfo.xlsx", "subscription");
        return excelReader.getData();
    }

    @Test(dataProvider = "subscription" )
    public void subscribeToNewsLetterPositiveTest(Map<String, String> data) {

        BasePage basePage = new BasePage(driver);
        basePage.subscribeToNewsLetter(data.get("email_address"));
        basePage.clickSubscriptionBtn();
        basePage.verifySingUpMessage();
    }

    @Test
    public void subscribeToNewsLetterNegativeTest()  {
        BasePage basePage = new BasePage(driver);
        String name = faker.name().firstName();
        basePage.subscribeToNewsLetter(name);
        basePage.clickSubscriptionBtn();
        basePage.verifyInvalidErrorMessageForSubscribe();
    }
}