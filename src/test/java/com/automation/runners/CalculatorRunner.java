package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/calculator.feature",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = {
                "pretty",
                "html:target/calculator-reports",
                "json:target/calculator-reports/calculator-results.json",
                "junit:target/calculator-reports/calculator-results.xml"
                // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Report

        },
        monochrome = true
        // publish = false
)
public class CalculatorRunner {
    // Runs only Calculator application tests
    // Features: Basic math operations, step-by-step calculations
}