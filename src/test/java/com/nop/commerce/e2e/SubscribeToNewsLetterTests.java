package com.nop.commerce.e2e;

import com.nop.commerce.base.BaseTest;
import com.nop.commerce.pages.BasePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilis.ExcelReader;

import java.util.HashMap;
import java.util.Map;

public class SubscribeToNewsLetterTests extends BaseTest {
    @DataProvider(name = "subscription")
    public Object[][] getData() {
        ExcelReader excelReader = new ExcelReader("src/main/resources/tast_data/userinfo.xlsx", "subscription");
        return excelReader.getData();
    }

    @Test
    public void subscribeToNewsLetterPositiveTest() {
        BasePage basePage = new BasePage(driver);
        Map<String, String> subscription = new HashMap<>();
        basePage.subscribeToNewsLetter(subscription);
        basePage.clickSubscriptionBtn();
        basePage.verifySingUpMessage();

    }

    /*@Test
    public void subscribeToNewsLetterNegativeTest()  {
        BasePage basePage = new BasePage(driver);
        String name = faker.name().firstName();
        basePage.subscribeToNewsLetter(name);
        basePage.clickSubscriptionBtn();
        basePage.verifyInvalidErrorMessageForSubscribe();
    }

     */

}