package com.automation.models;

public class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public boolean isValid() {
        return username != null && password != null && 
               !username.isEmpty() && !password.isEmpty();
    }
}