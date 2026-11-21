package com.Tests;


import org.testng.annotations.Test;

public class SearchResultsPageTest extends BaseTest {



    @Test
    public void searchResultsDisplayed() throws InterruptedException {

        homePage.searchItems("earrings").searchResultsDisplayed("earrings");

    }
}
