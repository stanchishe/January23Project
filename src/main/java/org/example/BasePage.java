package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage extends LoadableComponent {

    @FindBy(xpath = "//*[@id=\"menu-item-40\"]/a")
    WebElement shopButton;
    @FindBy(xpath = "//*[@id=\"menu-item-50\"]/a")
    WebElement myAccButton;
    public WebDriver webDriver;
    private String pageUrl;
    public BasePage(WebDriver webDriver, String pageUrl) {
        this.webDriver = webDriver;
        this.pageUrl = pageUrl;
        this.load();
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected void load() {
        webDriver.get(pageUrl);
    }

    @Override
    public void isLoaded() throws Error {
        String realUrl = webDriver.getCurrentUrl().trim();
        if(!realUrl.equals(pageUrl)) {
            throw new Error("Wrong loaded page! Expected: " + pageUrl + " , but got: " + realUrl);
        }
    }

    public void clickShop() {
        shopButton.click();
    }

    public void clickMyAcc() {
        myAccButton.click();
    }

    public boolean isBrowserOpen() {
        boolean browserIsOpen;
        try {
            webDriver.getWindowHandles();
            browserIsOpen = true;
        } catch (NullPointerException e) {
            browserIsOpen = false;
        }
        return browserIsOpen;
    }

    public void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }
}
