package com.automation.engines;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorEngine {
    private WebDriver driver;

    // ELEMENTS DECLARATION
    private static final By EQUALS_BUTTON = By.xpath("//span[text()='=']");
    private static final By RESULT = By.id("sciOutPut");




    
    public CalculatorEngine(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickNumber(String number) {
        WebElement numberBtn = driver.findElement(By.xpath("//span[text()='" + number + "']"));
        numberBtn.click();
    }
    
    public void clickOperator(String operator) {
        WebElement operatorBtn = driver.findElement(By.xpath("//span[text()='" + operator + "']"));
        operatorBtn.click();
    }
    
    public void clickEquals() {
        WebElement equalsBtn = driver.findElement(By.xpath("//span[text()='=']"));
        equalsBtn.click();
    }
    
    public String getResult() {
        WebElement display = driver.findElement(By.id("sciOutPut"));
        return display.getAttribute("value");
    }
    
    public void calculate(String expression) {
        String[] parts = expression.split(" ");
        
        clickNumber(parts[0]);     // First number
        clickOperator(parts[1]);   // Operator
        clickNumber(parts[2]);     // Second number
        clickEquals();             // Calculate
    }
}