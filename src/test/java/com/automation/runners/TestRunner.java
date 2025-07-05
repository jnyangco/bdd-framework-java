package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = {
                "pretty",                                           // Console output
                "html:target/cucumber-reports",                     // HTML reports (ADD THIS)
                "json:target/reports/cucumber.json",                // JSON data (your current)
                "rerun:target/rerun.txt",                           // Creates file with failed scenarios
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Report
        },
        monochrome = true
)
public class TestRunner {
    // Enhanced with HTML reports for easy viewing
}