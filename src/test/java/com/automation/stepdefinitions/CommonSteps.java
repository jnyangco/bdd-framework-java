package com.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import com.automation.core.DriverManager;
import com.automation.core.AppConfig;

public class CommonSteps {
    private WebDriver driver;
    
    @Given("I am on the {string} application")
    public void navigateToApplication(String appName) {
        if (!AppConfig.isValidApp(appName)) {
            throw new RuntimeException("Unknown application: " + appName);
        }
        
        driver = DriverManager.getDriver(AppConfig.getBrowser());
        String url = AppConfig.getAppUrl(appName);
        driver.get(url);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}