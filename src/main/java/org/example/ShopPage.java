package org.example;

import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

    private static String shopPageUrl = "https://practice.automationtesting.in/shop/";
    public ShopPage(WebDriver webDriver) {
        super(webDriver, shopPageUrl);
    }
}
