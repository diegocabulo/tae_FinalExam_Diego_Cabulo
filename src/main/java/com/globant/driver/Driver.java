package com.globant.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;

    public Driver (String browser){
        switch (browser){
            case ("firefox"):
                try {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                break;
            case ("chrome"):
                try {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
