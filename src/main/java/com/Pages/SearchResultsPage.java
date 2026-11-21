package com.Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchResultsPage {

    Page page;

    private String headerText = "h2 span.a-color-state.a-text-bold";
    private String dismissButton = "//input[@data-action-type='DISMISS']";


    // create a constructor that accepts page as parameter
    public SearchResultsPage(Page page) {
        this.page = page;
    }

    public void searchResultsDisplayed(String searchText) {
        page.click(dismissButton);
        assertThat(page.locator(headerText)).isVisible();
        System.out.println(page.locator(headerText).textContent());
    }
}
