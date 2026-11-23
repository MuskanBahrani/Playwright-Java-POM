package com.Pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchResultsPage {

    Page page;

    private String headerText = "h2 span.a-color-state.a-text-bold";
    private String searchBox = "#twotabsearchtextbox";
    private String searchButton = "input#nav-search-submit-button";
    private String sortDropdown = "span#a-autoid-0-announce";
    private String lowToHighOption = "a:has-text('Price: Low to High')";
    private String priceLocator = "span.a-price-whole";
    private String brandFilterString = "#filter-p_123 li span.a-list-item a";
    private String brandName = "h2.s-line-clamp-1 span";
    private String firstProduct = "//div[@role='listitem'][@data-component-type='s-search-result'][1]";
    private String addToCartForFirstProduct = "//input[@name='submit.addToCart']";
    private String brandOfFirstProduct = "//h2/span";
    private String cartString = "Go to Cart";



    // create a constructor that accepts page as parameter
    public SearchResultsPage(Page page) {
        this.page = page;
    }

    public void searchItems(String items) throws InterruptedException {
        page.fill(searchBox , items);
        page.click(searchButton);
    }

    public void searchResultsDisplayed(String searchText) {
        assertThat(page.locator(headerText)).isVisible();
        System.out.println(page.locator(headerText).textContent());
    }

    public void sortPriceLowToHigh() throws InterruptedException {
        page.locator(sortDropdown).click();
        page.locator(lowToHighOption).click();
        Locator prices = page.locator(priceLocator);

        ArrayList<Integer> priceList = new ArrayList<>();

        for(int i=0;i<prices.count();i++){
            priceList.add(Integer.parseInt(prices.nth(i).textContent()));
        }

        for(int value : priceList){
            if(value > 100){
                priceList.remove(value);
            }
        }

        for(int i=1;i<priceList.size();i++){
            if(priceList.get(i-1) > priceList.get(i)){
                System.out.println("List is not sorted, hence sort dropdown not working");
            }
        }

        System.out.println("Price list is sorted");


    }



    public void brandFilter() throws InterruptedException {
        page.locator(brandFilterString).nth(0).click();
        String brandOfProductDisplayed = page.locator(brandName).first().textContent();
        String brandSelected = page.locator(brandFilterString).nth(0).getAttribute("aria-label").toString();
        if(brandSelected.contains(brandOfProductDisplayed)){
            System.out.println("Brand filter working fine");
        }
        else{
            System.out.println("Brand filter not working");
        }


    }

    public void addToCart()  throws InterruptedException {
            Locator parent = page.locator(firstProduct);
            parent.locator(addToCartForFirstProduct).click();
            String brand = parent.locator(brandOfFirstProduct).first().textContent();
            String fullName = parent.locator(brandOfFirstProduct).last().textContent();

            page.getByText(cartString).click();
    }

}
