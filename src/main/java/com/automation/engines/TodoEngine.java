package com.automation.engines;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class TodoEngine {
    private WebDriver driver;

    // ELEMENTS DECLARATION
    private static final By NEW_TODO = By.className("new-todo");
    private static final By TASK_COUNT = By.xpath("//ul[@class='todo-list']/li");




    
    public TodoEngine(WebDriver driver) {
        this.driver = driver;
    }
    
    public void addTask(String taskName) {
        WebElement taskInput = driver.findElement(By.className("new-todo"));
        taskInput.clear();
        taskInput.sendKeys(taskName);
        taskInput.sendKeys(Keys.ENTER);
    }
    
    public void completeTask(String taskName) {
        WebElement checkbox = driver.findElement(
            By.xpath("//label[text()='" + taskName + "']/../input[@type='checkbox']"));
        checkbox.click();
    }
    
    public boolean isTaskVisible(String taskName) {
        try {
            driver.findElement(By.xpath("//label[text()='" + taskName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public int getTaskCount() {
        return driver.findElements(By.xpath("//ul[@class='todo-list']/li")).size();
    }
}