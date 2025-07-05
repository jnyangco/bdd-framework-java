package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportUtils {
    
    public static void attachScreenshot(WebDriver driver, Scenario scenario, String name) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", name);
        }
    }
    
    public static void addLog(Scenario scenario, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        scenario.log(timestamp + " - " + message);
    }
    
    public static void logStep(Scenario scenario, String stepDescription) {
        addLog(scenario, "Executing: " + stepDescription);
    }
}