package com.practice_automation.step_definitions;

import com.practice_automation.BaseClassPracticeAutomation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepDefinitionsLogout extends BaseClassPracticeAutomation {


    @Given("user is logged in his account")
    public void userIsLoggedInHisAccount() {
        myAccountButton.click();
        login();
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton));
    }

    @When("user clicks the Sign out button")
    public void userClicksTheSignOutButton() {

        signOutButton.click();
    }

    @Then("user is  successfully logout")
    public void userIsSuccessfullyLogout() {

        wait.until(ExpectedConditions.visibilityOf(userLoginInput));
        Assert.assertTrue(userLoginInput.isDisplayed());

    }

}
