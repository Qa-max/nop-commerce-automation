package com.nop.commerce.driver;
import com.nop.commerce.config.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private static WebDriver driver;
    private Driver(){}
    //this method should return a driver object based on the config file
    public static WebDriver getDriver(){
        String browser = ConfigReader.getProperty("browser"); //firefox

        if (driver == null){
            switch (browser){
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_settings.popups", 0);
                    prefs.put("autofill.profile_enabled", false);
                    prefs.put("profile.password_manager_enabled", false);
                    prefs.put("profile.default_content_setting_values.notifications", 2);

                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                    break;
            }
        }
        return driver;
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}


