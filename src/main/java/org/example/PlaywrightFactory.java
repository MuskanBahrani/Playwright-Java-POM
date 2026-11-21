package org.example;

import com.microsoft.playwright.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PlaywrightFactory {

Playwright playwright;
Browser browser;
BrowserContext browserContext;
Page page;
Properties prop;




public Properties initProperties() throws IOException {

    FileInputStream fis = new FileInputStream("resources/config.properties");
    prop = new Properties();
    prop.load(fis);

    return prop;
}


    public Page initBrowser(Properties prop) throws IOException {

    String browserName = prop.getProperty("browser");
    String url = prop.getProperty("url");
    boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

        System.out.println("Browser used is: " + browserName);

        playwright = Playwright.create();


        switch(browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            default:
                System.out.println("Use chromium or safari browser");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        page.navigate(url);

        return page;


    }
}
