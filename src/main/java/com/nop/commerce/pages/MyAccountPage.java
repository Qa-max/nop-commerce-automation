package com.nop.commerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement myAccountCustomerHeader;

    public void verifyMyAccountPageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "nopCommerce demo store. Account", "Account Page title does not match");
    }

    public void verifyMyAccountCustomerHeader(){
        Assert.assertTrue(myAccountCustomerHeader.isDisplayed(),"My Account Customer header is Not Displayed");
    }
}
