package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.MyAccountPage;

public class LogOutStep {

    MyAccountPage myAccountPage;

    public LogOutStep(MyAccountPage myAccountPage){
        this.myAccountPage = myAccountPage;
    }

    @When("The user clicks on sign out button")
    public void theUserClicksOnSignOutButton() {
        myAccountPage.clickOnSignOutButton();
    }

    @Then("The user should be logged out and redirected to the login and registration section")
    public void theUserShouldBeLoggedOutAndRedirectedToTheLoginAndRegistrationSection() {
        Assert.assertTrue(myAccountPage.isLoginButtonDisplayed());
    }
}
