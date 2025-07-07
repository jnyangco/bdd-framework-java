//package com.automation.runners;
//
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
//        tags = "@smoke",
//        plugin = {
//                "pretty",
//                "html:target/cucumber-reports",
//                "json:target/reports/cucumber.json",
//                "rerun:target/rerun.txt"
//                // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure Report
//        },
//        monochrome = true
//        // publish = false
//)
//public class SmokeTestRunner {
//    // Runs only smoke tests across all applications
//    // Quick validation of critical functionality
//}