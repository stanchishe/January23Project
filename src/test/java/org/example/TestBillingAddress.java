package org.example;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBillingAddress {
    public static WebDriver webDriver;
    public static BillingAddress MyBillingAddress;

    @Before
    public static void initState() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("Start-Maximized");
        //options.addExtensions(new File("src/resources/ChromeExtension/Adblocker2.crx"));
        //WebDriverManager.chromedriver().setup();
        //webDriver = new ChromeDriver(options);
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        MyBillingAddress = new BillingAddress();
    }

    @After
    public static void closeState() {
        MyBillingAddress.closeBrowser();
    }

    @Given("the browser Window is Open")
    public void the_browser_window_is_open() {
        Assertions.assertTrue(MyBillingAddress.isBrowserOpen(), "The browser is not open!");
    }
    @Given("the correct Page is Loaded")
    public void the_correct_page_is_loaded() {
        boolean correctPageLoaded;
        try {
            MyBillingAddress.isLoaded();
            correctPageLoaded = true;
        } catch (Error e) {
            correctPageLoaded = false;
        }
        Assertions.assertTrue(correctPageLoaded, "The correct url was not loaded!");
    }
    @When("^the user enters a valid Email (.*) and Pass (.*)$")
    public void the_user_enters_a_valid_email_and_pass(String userEmail, String userPass) {
        MyBillingAddress.enterEmail(userEmail);
        MyBillingAddress.enterPass(userPass);
    }
    @When("clicks the Login Button")
    public void clicks_the_login_button() {
        MyBillingAddress.registerUser();
    }

    @Then("go to address page")
    public void go_to_address_page() {
        MyBillingAddress.selectAddress();
    }

    @Then("click the edit billing address button")
    public void click_the_edit_billing_address_button() {
        MyBillingAddress.selectEditBilling();
    }

    @When("^the user enters (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void the_user_enters_information(String first_name, String last_name, String company, String street, String apartment, String town, String post, String email, String phone) throws InterruptedException {
        MyBillingAddress.enterName(first_name);
        MyBillingAddress.enterLastName(last_name);
        MyBillingAddress.enterCompnay(company);
        MyBillingAddress.enterStreetName(street);
        MyBillingAddress.enterAppartmentName(apartment);
        MyBillingAddress.enterTownName(town);
        MyBillingAddress.enterPosteName(post);
        MyBillingAddress.enterEmailName(email);
        MyBillingAddress.enterPhoneName(phone);
    }

    @And("clicks the save button")
    public void clicks_the_save_button() {
        MyBillingAddress.ClickSave();
    }

    @Then("the information is saved")
    public void the_information_is_saved() {
        String savedAddress = MyBillingAddress.isSaved();
        Assertions.assertEquals("Address changed successfully.", savedAddress, "The address was saved correctly!");
    }

}
