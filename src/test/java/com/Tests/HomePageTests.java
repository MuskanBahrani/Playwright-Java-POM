package com.Tests;

import com.Pages.CartPage;
import com.Pages.SearchResultsPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{


    @Test(priority = 1)
    public void homePageTest() throws InterruptedException {
        System.out.println(homePage.getTitle());
        System.out.println(homePage.getURL());


    }

    Page newPageAfterCountryChange;

    @Test(priority = 2)
    public void changingCountry() throws InterruptedException {
        newPageAfterCountryChange = homePage.changeCountry();
        page = newPageAfterCountryChange;
        searchPage = new SearchResultsPage(page);
        cartPage = new CartPage(page);
    }



    @Test(priority = 3)
    public void searchForItems() throws InterruptedException {
        searchPage.searchItems("earrings");
        searchPage.searchResultsDisplayed("earrings");
        searchPage.sortPriceLowToHigh();
        searchPage.brandFilter();
        searchPage.addToCart();
    }

    @Test(priority = 4, dependsOnMethods = "searchForItems")
    public void cartTests(){
        cartPage.verifyCartOpened();
    }


}
