package com.practice_automation.step_definitions;

import com.practice_automation.BaseClassPracticeAutomation;
import com.practice_automation.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Hooks extends BaseClassPracticeAutomation {


    @Before
    public void setUp() {
        browserSetUp();

    }

    @After
    public void close() {
        browserClose();

    }

    @Given("user is at home page")
    public void userIsAtHomePage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(Constants.URL, currentUrl);
    }

    @And("user navigates to myAccount")
    public void userNavigatesToMyAccount() {
        myAccountButton.click();
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        loginButton.click();
    }
}
