package com.automation.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import com.automation.core.DriverManager;
import com.automation.engines.CalculatorEngine;

public class CalculatorSteps {

    @When("I perform calculation {string}")
    public void performCalculation(String expression) {
        WebDriver driver = DriverManager.getDriver();
        CalculatorEngine calculatorEngine = new CalculatorEngine(driver);
        calculatorEngine.calculate(expression);
    }

    @When("I click number {string}")
    public void clickNumber(String number) {
        WebDriver driver = DriverManager.getDriver();
        CalculatorEngine calculatorEngine = new CalculatorEngine(driver);
        calculatorEngine.clickNumber(number);
    }

    @When("I click operator {string}")
    public void clickOperator(String operator) {
        WebDriver driver = DriverManager.getDriver();
        CalculatorEngine calculatorEngine = new CalculatorEngine(driver);
        calculatorEngine.clickOperator(operator);
    }

    @When("I click equals")
    public void clickEquals() {
        WebDriver driver = DriverManager.getDriver();
        CalculatorEngine calculatorEngine = new CalculatorEngine(driver);
        calculatorEngine.clickEquals();
    }

    @Then("I should see result {string}")
    public void verifyResult(String expectedResult) {
        WebDriver driver = DriverManager.getDriver();
        CalculatorEngine calculatorEngine = new CalculatorEngine(driver);
        String actualResult = calculatorEngine.getResult();
        Assert.assertEquals("Calculation result mismatch", expectedResult, actualResult);
    }
}