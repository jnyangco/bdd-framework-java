package com.automation.core;

public class SetupTest {
    public static void main(String[] args) {
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        
        // Test Java 21 switch expression
        String browser = "chrome";
        String message = switch (browser) {
            case "chrome" -> "Chrome browser selected";
            case "firefox" -> "Firefox browser selected";
            case "edge" -> "Edge browser selected";
            case "safari" -> "Safari browser selected";
            default -> "Unknown browser";
        };
        
        System.out.println(message);
        System.out.println("✅ Java 21 features working!");
        System.out.println("✅ IntelliJ setup successful!");
    }
}