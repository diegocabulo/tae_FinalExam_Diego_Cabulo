package com.globant.tests;

import com.globant.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    @Test(description = "just test")
    public void submitTest(){
        HomePage home = getHomePage();
        System.out.println("hola funciona");
    }
}
