package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }

    private Actions actions = new Actions(getDriver());

    @FindBy(id = "global-user-trigger")
    private WebElement hoverElement;

    @FindBy(css = "#global-header a[tref='/members/v3_1/login']")
    private WebElement logInButton;

    @FindBy(css = "#global-header ul.account-management > li:nth-child(9) > a")
    private WebElement logOutButton;

    @FindBy(css = "iframe[name ='disneyid-iframe']")
    private WebElement iframeLogIn;

    @FindBy(css = "#sideLogin-left-rail > button.button-alt.med")
    private WebElement logInButtonCheck;

    public LogInIframe clickLogIn(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
        waitToBeClickable(logInButton);
        logInButton.click();
        getDriver().switchTo().frame(iframeLogIn);
        return new LogInIframe(getDriver());
    }

    public void clickLogOut(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
        waitToBeClickable(logOutButton);
        logOutButton.click();
    }

    public boolean checkLogIn(){
        waitElementVisibility(logInButtonCheck);
        return logInButtonCheck.getText().equals("Log In");
    }

    public boolean checkLogOut(){
        waitElementVisibility(hoverElement);
        actions.moveToElement(hoverElement).perform();
        waitToBeClickable(logOutButton);
        return logOutButton.getText().equals("Log Out");
    }
}
