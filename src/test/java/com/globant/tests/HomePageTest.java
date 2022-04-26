package com.globant.tests;

import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    public Logger logger = Logger.getLogger(HomePageTest.class);

    @Test(description = "login test", priority = 1)
    public void logInTest(){
        HomePage home = getHomePage();
        logger.info("You login correctly in to the page");
        home.actionHoverElement();
        Assert.assertNotEquals(home.getLogOutButton().getText(), "Log In");
        home.clickLogOut();
        logger.info("You log out correctly");
        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
    }

    @Test(description = "logout test", priority = 2)
    public void logOutTest(){
        HomePage home = getHomePage();
        logger.info("You login correctly in to the page");
        Assert.assertTrue(home.checkLogOut(), "Not in log out view");
        home.clickLogOut();
        logger.info("You log out correctly");
        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
    }

    @Test(description = "cancel account test", priority = 3)
    public void cancelAccountTest(){
        HomePage home = getHomePage();
        LogInIframe logInIframe = home.clickModifyProfile();
        logger.info("You are in modify profile iframe");
        home.waitToBeClickable(logInIframe.getDeleteAccountLink());
        Assert.assertEquals(logInIframe.getDeleteAccountLink().getText(), "Delete Account");
        logInIframe.clickDeleteAccount();
        logger.info("You click in delete account link");
        Assert.assertEquals(logInIframe.getConfirmCommonButton().getText(), "Yes, delete this account");
        logInIframe.clickConfirmDeleteAccount();
        logger.info("Last Pop up confirm delete");
        Assert.assertTrue(logInIframe.getConfirmCommonButton().isDisplayed());
        logInIframe.clickLastDeleteAccount();
        logger.info("You successfully delete your account");
    }
}
