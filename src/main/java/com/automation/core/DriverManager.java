package com.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    
    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    driver = new EdgeDriver();
                }
                case "safari" -> {
                    driver = new SafariDriver();
                }
                default -> throw new RuntimeException("Browser not supported: " + browserName);
            }
            
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
    
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public static boolean isDriverActive() {
        return driver != null;
    }
}