package com.globant.data;

import org.testng.annotations.DataProvider;

public class DataTest {

    @DataProvider(name = "dataESPN")
    public static Object [] [] inputData(){
        return new Object[][] {{"testFirstNameOne","testLastNameOne", "testNameOne@gmail.com", "FirstNameOne*"},
                {"testFirstNameTwo","testLastNameTwo", "testNameTwo@gmail.com", "FirstNameTwo*"},
                {"testFirstNameThree","testLastNameThree", "testNameThree@gmail.com", "FirstNameThree*"}};
    }

}
