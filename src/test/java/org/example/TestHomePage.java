package org.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHomePage {
    public static WebDriver webDriver;
    public static HomePage homePage;

    @Before
    public static void initSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        //options.addExtensions(new File("adBlocker2"));
        webDriver = new ChromeDriver(options);
        homePage = new HomePage(webDriver);
    }

    @AfterAll
    public static void closeSetup() {
        webDriver.close();
        webDriver.quit();
    }

    @Given("the browser is open")
    public void the_browser_is_open() {
        Assertions.assertTrue(homePage.isBrowserOpen());
    }
    @Given("it is on the home page")
    public void it_is_on_the_home_page() {
        Assertions.assertTrue(homePage.isHomePage());
    }
    @Then("^there are (\\d+) sliders on the home page$")
    public void there_are_three_sliders_on_the_home_page(int expectedSliders) {
        Assertions.assertEquals(expectedSliders, homePage.getSliders(), "Too many or too few sliders located!!!");
    }
}
