package com.globant.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "close")
    private WebElement currentPasswordField;

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;

    public void clickLoginIframe(String username, String password){
        userNameInputField.sendKeys(username);
        waitToBeClickable(passwordInputField);
        passwordInputField.sendKeys(password);
        logInButton.click();
    }

    public void scrollEndFrame(){
        waitToBeClickable(currentPasswordField);
        currentPasswordField.click();
    }


}
