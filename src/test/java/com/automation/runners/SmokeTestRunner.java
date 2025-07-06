package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        tags = "@smoke",
        plugin = {
                "pretty",
                "html:target/smoke-reports",
                "json:target/smoke-reports/smoke-results.json",
                "junit:target/smoke-reports/smoke-results.xml"
                // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Report
        },
        monochrome = true
        // publish = false
)
public class SmokeTestRunner {
    // Runs only smoke tests across all applications
    // Quick validation of critical functionality
}