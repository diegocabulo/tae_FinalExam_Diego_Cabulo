package com.globant.pages;

import org.openqa.selenium.*;
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

    @FindBy(linkText = "Sign Up")
    private WebElement signUpAnchorTag;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[name='email']")
    private WebElement emailField;

    @FindBy(css = "input[name='newPassword']")
    private WebElement newPasswordField;

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;

    @FindBy(css = "button.btn.btn-primary.ng-isolate-scope")
    private WebElement confirmCommonButton;

    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }

    public WebElement getConfirmCommonButton() {
        return confirmCommonButton;
    }


    public void clickDeleteAccount(){
        waitToBeClickable(deleteAccountLink);
        try{
            deleteAccountLink.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex){
            WebElement deleteButton = getDriver().findElement(By.id("cancel-account"));
            deleteButton.click();
        }
    }

    public void clickConfirmDeleteAccount(){
        if(confirmCommonButton.isDisplayed()){
            waitToBeClickable(confirmCommonButton);
            confirmCommonButton.click();
        }

    }

    public void clickLastDeleteAccount(){
        waitToBeClickable(confirmCommonButton);
        try{
            confirmCommonButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex){
            WebElement confirmDeleteAccount = getDriver().findElement(By.cssSelector("button.btn.btn-primary.ng-isolate-scope"));
            confirmDeleteAccount.click();
        }
    }

     public void clickSignUpIframe(){
        waitToBeClickable(signUpAnchorTag);
        signUpAnchorTag.click();
    }

    public void fillFieldsSignUp(String email){
        waitToBeClickable(firstNameField);
        firstNameField.sendKeys("test");
        waitToBeClickable(lastNameField);
        lastNameField.sendKeys("test");
        waitToBeClickable(emailField);
        emailField.sendKeys(email);
        waitToBeClickable(passwordInputField);
        passwordInputField.sendKeys("test12345*");
    }

    public void clickSignUp(){
        confirmCommonButton.isDisplayed();
        waitToBeClickable(confirmCommonButton);
        confirmCommonButton.click();
    }


}
