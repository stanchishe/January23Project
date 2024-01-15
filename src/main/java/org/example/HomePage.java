package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private static final String homePageUrl = "https://practice.automationtesting.in/";
    public HomePage(WebDriver webDriver) {
        super(webDriver, homePageUrl);

    }

    public int getSliders(){
        List<WebElement> slider = webDriver.findElements(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div"));
        return slider.size();
    }

    public boolean isHomePage() {
        return webDriver.getCurrentUrl().equals("https://practice.automationtesting.in/");
    }
}
