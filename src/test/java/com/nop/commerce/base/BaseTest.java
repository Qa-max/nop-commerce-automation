package com.nop.commerce.base;
import com.github.javafaker.Faker;
import com.nop.commerce.config.ConfigReader;
import com.nop.commerce.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest {
    protected static WebDriver driver;
    protected Faker faker;

    @BeforeMethod
    public void beforeMethod() {
        faker = new Faker();
        faker = new Faker();
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }
    @AfterMethod
    public void afterMethod() {
        Driver.quitDriver();
        driver = null;
    }
}