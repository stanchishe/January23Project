package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.*;
import utils.HelperClass;

public class ValidateAccDetailsStep {

    HomePage homePage;
    MyAccountPage myAccountPage;
    PersonalDataModal personalDataModal;
    AccountDetailsPage accountDetailsPage;
    AddressesPage addressesPage;

    public ValidateAccDetailsStep(HomePage homepage, MyAccountPage myAccountPage, PersonalDataModal personalDataModal,
                                  AccountDetailsPage accountDetailsPage, AddressesPage addressesPage){
        this.homePage = homepage;
        this.myAccountPage = myAccountPage;
        this.personalDataModal = personalDataModal;
        this.accountDetailsPage = accountDetailsPage;
        this.addressesPage = addressesPage;
    }

    @Given("The user access practice.automationtesting homepage")
    public void the_user_access_practice_automationtesting_homepage() {
        HelperClass.openPage("https://practice.automationtesting.in");
        personalDataModal.cancelPersonalDataModal();
    }
    @When("The user log in into account")
    public void the_user_log_in_into_account() {
        homePage.clickOnMyAccount();
        myAccountPage.login();
    }
    @And("The user click on Account details")
    public void the_user_click_on_account_details() {
        myAccountPage.clickOnAccountDetails();
    }
    @Then("User should see the correct email was used")
    public void user_should_see_the_correct_email_was_used()  {
       Assert.assertEquals(accountDetailsPage.getEmailFieldValue(), "testuser477@gmail.com");
    }

    @When("The user enter first name")
    public void the_user_enter_first_name() {
        accountDetailsPage.enterFirstName("test");
    }
    @And("The user enter last name")
    public void the_user_enter_last_name() {
        accountDetailsPage.enterLastName("test");
    }
    @And("The user saves changes")
    public void the_user_saves_changes() {
        accountDetailsPage.clickOnSaveChangesButton();
    }

    @Then("The user should be presented with a successful change-making message")
    public void theUserShouldBePresentedWithASuccessfulChangeMakingMessage() {
        Assert.assertEquals("Account details changed successfully."  ,myAccountPage.extractSuccessfulChangeMessage());
    }

    @When("The user click on Addresses link")
    public void the_user_click_on_addresses_link() {
        myAccountPage.clickOnAddressesButton();
    }
    @Then("The user should see his Billing and Shipping addresses")
    public void the_user_should_see_his_billing_and_shipping_addresses() {
        Assert.assertEquals("https://practice.automationtesting.in/my-account/edit-address/", addressesPage.getAddressesUrl());
    }
}
