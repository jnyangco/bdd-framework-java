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
    // Thread-local storage for parallel execution
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Gets the current driver, creates one if it doesn't exist
     * This eliminates the need for null checks in step definitions
     */
    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            driver = createDriver(AppConfig.getBrowser());
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    /**
     * Gets driver with specific browser, creates one if it doesn't exist
     */
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            driver = createDriver(browserName);
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    /**
     * Private method to create driver instance
     */
    private static WebDriver createDriver(String browserName) {
        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                // Add headless mode for parallel execution (optional)
                if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "safari" -> {
                driver = new SafariDriver();
            }
            default -> throw new RuntimeException("Browser not supported: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        return driver;
    }

    public static void closeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            } finally {
                driverThreadLocal.remove();
            }
        }
    }

    public static boolean isDriverActive() {
        WebDriver driver = driverThreadLocal.get();
        return driver != null;
    }
}