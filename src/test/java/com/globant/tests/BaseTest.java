package com.globant.tests;

import com.globant.driver.Driver;
import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest {
    Driver driver;
    private HomePage homePage;

    public Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url){
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver(), url);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        logger.info("You are in the home page");
        LogInIframe logInIframe = homePage.clickLogIn();
        logger.info("You enter the log in iframe page");
        logInIframe.clickLoginIframe("malirsalpodcast0816@gmail.com", "test12345*");
        logger.info("You log in correctly in to the page");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        homePage.dispose();
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
