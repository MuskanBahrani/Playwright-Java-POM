package com.Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {

    private Page page;

    private String searchBox = "#twotabsearchtextbox";
    private String searchButton = "input#nav-search-submit-button";

    Page searchResults;



    public HomePage(Page page){
        this.page = page;
    }

    public String getTitle(){
        return page.title();
    }

    public String getURL(){
        return page.url();
    }

    public SearchResultsPage searchItems(String items) throws InterruptedException {
        page.fill(searchBox , items);
        page.click(searchButton);
        // return search page that will open when search button is clicked
        return new SearchResultsPage(page);
        // since we want to verify if search items are displayed correctly pass page as parameter
    }




}
