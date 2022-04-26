package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInIframe extends BasePage{

    public LogInIframe(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "button[type='submit']")
    private WebElement logInButton;

    @FindBy(css = "input[type='email']")
    private WebElement userNameInputField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInputField;

    public void clickLoginIframe(String username, String password){
        userNameInputField.sendKeys(username);
        waitToBeClickable(passwordInputField);
        passwordInputField.sendKeys(password);
        logInButton.click();
    }


}
