package com.Tests;

import com.Pages.HomePage;
import com.microsoft.playwright.Page;
import org.example.PlaywrightFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    HomePage homePage;
    Properties prop;

    @BeforeClass
    public void setup() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.initProperties();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
        System.out.println(">>> HomePage initialized: " + homePage);
    }


    @AfterClass
    public void tearDown(){
        page.context().browser().close();
    }

}
