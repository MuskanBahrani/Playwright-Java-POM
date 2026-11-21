package com.Tests;

import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{
    @Test
    public void homePageTest() throws InterruptedException {

        System.out.println(">>> Test started");
        System.out.println(">>> HomePage in test: " + homePage);

        System.out.println(homePage.getTitle());
        System.out.println(homePage.getURL());
        homePage.searchItems("earrings").searchResultsDisplayed("earrings");


    }

}
