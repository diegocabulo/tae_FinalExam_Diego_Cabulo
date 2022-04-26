package com.globant.tests;

import com.globant.driver.Driver;
import com.globant.pages.HomePage;
import com.globant.pages.LogInIframe;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import java.util.Random;

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
        logInIframe.clickSignUpIframe();
        logger.info("You enter the signUp iframe page");
        logInIframe.fillFieldsSignUp(randomEmailGenerate());
        logInIframe.clickSignUp();
        logger.info("You Signup correctly");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        homePage.dispose();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public String randomEmailGenerate(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 18;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return String.join("",generatedString, "@gmail.com");
    }
}
