package com.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",      // Reads failed scenarios from file
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = {
                "pretty",                                        // Console output
                "html:target/rerun-html-reports",                // HTML in different folder
                "json:target/rerun-json/results.json",           // JSON in separate folder
                "junit:target/rerun-xml/results.xml"             // XML in separate folder
                // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Report
        },
        monochrome = true
)
public class FailedTestsRunner {
        // Fixed: Uses separate directories for HTML, JSON, and XML
        // No path collisions between different report types
}