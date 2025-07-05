package com.automation.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import com.automation.core.DriverManager;
import com.automation.engines.TodoEngine;

public class TodoSteps {
    private WebDriver driver;
    private TodoEngine todoEngine;
    
    @When("I add a task {string}")
    public void addTask(String taskName) {
        driver = DriverManager.getDriver("chrome");
        todoEngine = new TodoEngine(driver);
        todoEngine.addTask(taskName);
    }
    
    @When("I complete task {string}")
    public void completeTask(String taskName) {
        todoEngine.completeTask(taskName);
    }
    
    @Then("I should see task {string} in the list")
    public void verifyTaskExists(String taskName) {
        boolean taskExists = todoEngine.isTaskVisible(taskName);
        Assert.assertTrue("Task '" + taskName + "' should be visible", taskExists);
    }
    
    @Then("I should see {int} tasks in total")
    public void verifyTaskCount(int expectedCount) {
        int actualCount = todoEngine.getTaskCount();
        Assert.assertEquals("Task count mismatch", expectedCount, actualCount);
    }
}