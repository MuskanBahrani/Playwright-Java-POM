package com.Pages;


import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    private String changeCountryDropdown = "Expand to Change Language or Country";
    private String changeCountryButton = "Change country/region.";
    private String countryDropDown = "#icp-dropdown-selected-item-prompt";
    private String optionForIndia = "#icp-dropdown_8"; //"option:has-text('India')";
    private String loadingWebsite = "button:has-text('Go to website')";




    public HomePage(Page page){
        this.page = page;
    }

    public String getTitle(){
        return page.title();
    }

    public String getURL(){
        return page.url();
    }

    public Page changeCountry(){
        page.getByLabel(changeCountryDropdown).first().click();
        page.getByText(changeCountryButton).last().click();
        page.locator(countryDropDown).click();
        page.locator(optionForIndia).isVisible();
        page.locator(optionForIndia).click();
        Page newPage = page.waitForPopup(() -> {
            page.locator(loadingWebsite).click();
        });

        return newPage;

    }







}
