package org.example;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ShippingAddress;
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
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("Start-Maximized");
            //options.addExtensions(new File("src/resources/ChromeExtension/Adblocker2.crx"));
            //webDriver = new ChromeDriver(options);
            //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            newShippingAddress = new ShippingAddress();
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

        @Then("go to address Page")
        public void go_to_address_page() {
            newShippingAddress.selectAddress();
        }

        @Then("click the edit billing address Button")
        public void click_the_edit_billing_address_button() {
            newShippingAddress.selectEditBilling();
        }

        @When("^the user enters (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)$")
        public void the_user_enters_information(String first_name, String last_name, String company, String street, String apartment, String town, String post) {
            newShippingAddress.enterName(first_name);
            newShippingAddress.enterLastName(last_name);
            newShippingAddress.enterCompnay(company);
            newShippingAddress.enterStreetName(street);
            newShippingAddress.enterAppartmentName(apartment);
            newShippingAddress.enterTownName(town);
            newShippingAddress.enterPosteName(post);
        }

        @And("clicks the save Button")
        public void clicks_the_save_button() {
            newShippingAddress.ClickSave();
        }

        @Then("the information is Saved")
        public void the_information_is_saved() {
            String savedAddress = newShippingAddress.isSaved();
            Assertions.assertEquals("Address changed successfully.", savedAddress, "The address was saved correctly!");
        }

}
