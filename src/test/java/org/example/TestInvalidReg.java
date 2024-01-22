package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestInvalidReg {
    public static WebDriver webDriver;
    public static MyAccountPage myAccountPage;

    @Before
    public static void initState() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        //options.addExtensions(new File("src/resources/ChromeExtension/Adblocker2.crx"));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        myAccountPage = new MyAccountPage(webDriver);
    }

    @After
    public static void closeState() {
        myAccountPage.closeBrowser();
    }
    @Given("the browser window is open again")
    public void the_browser_window_is_open_again() {
        Assertions.assertTrue(myAccountPage.isBrowserOpen(), "The browser is not open!");
    }
    @Given("the correct page is loaded again")
    public void the_correct_page_is_loaded_again() {
        boolean correctPageLoaded;
        try {
            myAccountPage.isLoaded();
            correctPageLoaded = true;
        } catch (Error e) {
            correctPageLoaded = false;
        }
        Assertions.assertTrue(correctPageLoaded, "The correct url was not loaded!");
    }
    @When("^the user enters a registered email (.*) and pass (.*)$")
    public void the_user_enters_a_registered_email_and_pass(String userEmail, String userPass) {
        myAccountPage.enterEmail(userEmail);
        myAccountPage.enterPass(userPass);
    }
    @When("the user attempts to clicks the registration button")
    public void the_user_attempts_to_clicks_the_registration_button() {
        myAccountPage.registerUser();
    }
    @Then("a registered user error is displayed")
    public void a_registered_user_error_is_displayed() {
        String actualError = myAccountPage.checkForError();
        Assertions.assertEquals(actualError, InternalRegErrors.INTERNAL_EXISTING_USER, "Some unexpected error occurred!");
    }
}
