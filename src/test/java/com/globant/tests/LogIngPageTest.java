package com.globant.tests;

import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIngPageTest extends BaseTest{

    public Logger logger = Logger.getLogger(LogIngPageTest.class);

//    @Test(description = "login test")
//    public void logInTest(){
//        HomePage home = getHomePage();
//        logger.info("You login correctly in to the page");
//        home.actionHoverElement();
//        Assert.assertNotEquals(home.getLogOutButton().getText(), "Log In");
//        home.clickLogOut();
//        logger.info("You log out correctly");
//        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
//    }
//
//    @Test(description = "logout test")
//    public void logOutTest(){
//        HomePage home = getHomePage();
//        logger.info("You login correctly in to the page");
//        Assert.assertTrue(home.checkLogOut(), "Not in log out view");
//        home.clickLogOut();
//        logger.info("You log out correctly");
//        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
//    }

    @Test(description = "cancel account test")
    public void cancelAccountTest(){
        HomePage home = getHomePage();
        logger.info("You login correctly in to the page");
        LogInIframe logInIframe = home.clickModifyProfile();
        logInIframe.scrollEndFrame();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
