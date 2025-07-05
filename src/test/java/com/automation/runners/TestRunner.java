package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
    plugin = {
        "pretty",
        "json:target/reports/cucumber.json"
    },
    monochrome = true
)
public class TestRunner {
    // Minimal configuration - just get it working first
}