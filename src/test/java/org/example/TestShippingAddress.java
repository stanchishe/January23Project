package org.example;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
    public class TestShippingAddress {
        public static WebDriver webDriver;
        public static ShippingAddress newShippingAddress;

        @Before
        public static void initState() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("Start-Maximized");
            //options.addExtensions(new File("src/resources/ChromeExtension/Adblocker2.crx"));
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            newShippingAddress = new ShippingAddress(webDriver);
        }

        @After
        public static void closeState() {
            newShippingAddress.closeBrowser();
        }

        @Given("the browser window is Open")
        public void the_browser_window_is_open() {
            Assertions.assertTrue(newShippingAddress.isBrowserOpen(), "The browser is not open!");
        }

        @Given("the correct page is Loaded")
        public void the_correct_page_is_loaded() {
            boolean correctPageLoaded;
            try {
                newShippingAddress.isLoaded();
                correctPageLoaded = true;
            } catch (Error e) {
                correctPageLoaded = false;
            }
            Assertions.assertTrue(correctPageLoaded, "The correct url was not loaded!");
        }

        @When("^the user enters a valid Email (.*) and pass (.*)$")
        public void the_user_enters_a_valid_email_and_pass(String userEmail, String userPass) {
            newShippingAddress.enterEmail(userEmail);
            newShippingAddress.enterPass(userPass);
        }

        @When("clicks the Login button")
        public void clicks_the_login_button() {
            newShippingAddress.registerUser();
        }

        @Then("^a userId (.*) is Logged in to the site$")
        public void a_user_id_is_logged_in_to_the_site(String expectedUser) {
            String registeredUser = webDriver.findElement(
                    By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/strong")
            ).getText().trim();
            Assertions.assertEquals(expectedUser.split("@")[0], registeredUser, "The user was not registered correctly!");
        }

        @Then("Clicks the Address button")
        public void clicks_the_address_button() {
            newShippingAddress.address();
        }

        @Then("Clicks Edit button")
        public void clicks_the_edit_button() {
            newShippingAddress.edit();
    }

}
