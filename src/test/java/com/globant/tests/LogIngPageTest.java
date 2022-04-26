package com.globant.tests;

import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIngPageTest extends BaseTest{

    public Logger logger = Logger.getLogger(BaseTest.class);

    @Test(description = "log in test", groups = {"logInGroup"})
    public void logInTest(){
        HomePage home = getHomePage();
        logger.info("You are in the home page");
        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
        LogInIframe logInIframe = home.clickLogIn();
        logger.info("You enter the log in iframe page");
        logInIframe.clickLoginIframe("malirsalpodcast0816@gmail.com", "test1234*");
        logger.info("You log in correctly in to the page");
        Assert.assertTrue(home.checkLogOut(), "Not in log out view");
        home.clickLogOut();
        logger.info("You log out correctly");
        Assert.assertTrue(home.checkLogIn(), "Not in log in view");
    }
}
