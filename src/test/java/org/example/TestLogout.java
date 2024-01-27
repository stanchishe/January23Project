package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TestLogout {

    public static Logout LogOut;

    @Before
    public static void initState() {
        LogOut = new Logout();
    }

    @After
    public static void closeState() {
        LogOut.closeBrowser();
    }

    @Given("the Browser Window is Open")
    public void the_browser_window_is_open() {
        Assertions.assertTrue(LogOut.isBrowserOpen(), "The browser is not open!");
    }

    @Given("the Correct Page is Loaded")
    public void the_correct_page_is_loaded() {
        boolean correctPageLoaded;
        try {
            LogOut.isLoaded();
            correctPageLoaded = true;
        } catch (Error e) {
            correctPageLoaded = false;
        }
        Assertions.assertTrue(correctPageLoaded, "The correct url was not loaded!");
    }

    @When("^the User enters a valid Email (.*) and Pass (.*)$")
    public void the_user_enters_a_valid_email_and_pass(String userEmail, String userPass) {
        LogOut.enterEmail(userEmail);
        LogOut.enterPass(userPass);
    }

    @When("Clicks the Login Button")
    public void clicks_the_login_button() {
        LogOut.registerUser();
    }

    @Then("clicks the logout button")  // Logout button function
    public void click_the_logout_button() {
        LogOut.ClickButton();
    }

    @Then("the user has logged out")
    public void the_user_has_logged_out() {
        Assertions.assertTrue(LogOut.IsLoggedOut(), "The user has logged out.");
    }
}
