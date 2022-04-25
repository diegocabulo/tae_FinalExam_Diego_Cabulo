package com.globant.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }
}
