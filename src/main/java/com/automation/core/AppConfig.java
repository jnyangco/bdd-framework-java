package com.automation.core;

import java.util.Map;

public class AppConfig {
    private static final Map<String, String> APP_URLS = Map.of(
        "todoApp", "https://todomvc.com/examples/react/",
        "calculatorApp", "https://calculator.net/",
        "practice", "https://the-internet.herokuapp.com/"
    );
    
    public static String getAppUrl(String appName) {
        return APP_URLS.get(appName);
    }
    
    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }
    
    public static boolean isValidApp(String appName) {
        return APP_URLS.containsKey(appName);
    }
}