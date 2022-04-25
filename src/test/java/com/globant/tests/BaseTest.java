package com.globant.tests;

import com.globant.driver.Driver;
import com.globant.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
        logger.info("Estoy en la home page");

    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        homePage.dispose();
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
