package com.automation.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.automation.core.DriverManager;

public class TestHooks {
    
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("🚀 Starting scenario: " + scenario.getName());
        System.out.println("📋 Tags: " + scenario.getSourceTagNames());
    }
    
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (DriverManager.isDriverActive()) {
            WebDriver driver = DriverManager.getDriver("chrome");
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Step Screenshot");
            }
        }
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ Test FAILED: " + scenario.getName());
            
            if (DriverManager.isDriverActive()) {
                WebDriver driver = DriverManager.getDriver("chrome");
                if (driver instanceof TakesScreenshot) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                }
            }
        } else {
            System.out.println("✅ Test PASSED: " + scenario.getName());
        }
        
        DriverManager.closeDriver();
        System.out.println("🔚 Browser closed for scenario: " + scenario.getName());
    }
}