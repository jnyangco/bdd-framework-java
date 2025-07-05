package com.automation.models;

public class Task {
    private String name;
    private boolean completed;
    
    public Task(String name) {
        this.name = name;
        this.completed = false;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void markCompleted() {
        this.completed = true;
    }
}