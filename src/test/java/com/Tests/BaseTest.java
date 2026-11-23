package com.Tests;

import com.Pages.CartPage;
import com.Pages.HomePage;
import com.Pages.SearchResultsPage;
import com.microsoft.playwright.Page;
import org.example.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    HomePage homePage;
    SearchResultsPage searchPage;
    CartPage cartPage;
    Properties prop;

    @BeforeClass
    public void setup() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.initProperties();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
        searchPage = new SearchResultsPage(page);
        cartPage = new CartPage(page);

    }



    @AfterClass
    public void tearDown(){
        page.context().browser().close();
    }

}
