package com.practice_automation.step_definitions;

import com.practice_automation.BaseClassPracticeAutomation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepDefinitions extends BaseClassPracticeAutomation {


    @When("user enters valid username in the username field")
    public void userEntersValidUsernameInTheUsernameField() {
        fillInField(userLoginInput, validEmail);

    }

    @And("user enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        fillInField(passwordLoginInput, validPassword);
    }


    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        WebElement accountView = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[2]/a[3]"));
        wait.until(ExpectedConditions.visibilityOf(accountView));
        String txtDisplayed = accountView.getText();
        Assert.assertEquals(txtDisplayed, "edit your password and account details");
    }


    @When("user enters invalid username in the username field")
    public void userEntersInvalidUsernameInTheUsernameField() {
        fillInField(userLoginInput, invalidEmail);
    }

    @And("user enters invalid password in the password field")
    public void userEntersInvalidPasswordInThePasswordField() {
        fillInField(passwordLoginInput, invalidPassword);
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li/strong[1]"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String message = errorMessage.getText();
        Assert.assertEquals("Error:", message);
    }


}
