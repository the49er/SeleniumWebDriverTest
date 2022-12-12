package com.api.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WebDriverSelenium {
    private static WebDriverSelenium instanceWebDriver;
    private WebDriverWait webDriverWait;

    private WebDriverSelenium(){
        webDriverWait = new WebDriverWait(new ChromeDriver(),
                Duration.of(20, ChronoUnit.SECONDS));
    };

    public static WebDriverSelenium getInstance(){
        if(instanceWebDriver == null){
            instanceWebDriver = new WebDriverSelenium();
        }
        return instanceWebDriver;
    }

    public WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }

}
