package com.Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {

    Page page;
    private String cartHeader = "h2#sc-active-items-header";

    public CartPage(Page page){
        this.page = page;
    }



    public void verifyCartOpened(){
        if(page.locator(cartHeader).isVisible()){
            System.out.println("Cart opened");
        }
        else{
            System.out.println("Cart not opened");
        }

    }





}
