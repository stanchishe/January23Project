package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.*;

public class ValidateAccDetailsStep {

    HomePage homePage;
    MyAccountPage myAccountPage;
    PersonalDataModal personalDataModal;
    AccountDetailsPage accountDetailsPage;
    AddressesPage addressesPage;
    BillingAddressPage billingAddressPage;
    ShippingAddressPage shippingAddressPage;

    public ValidateAccDetailsStep(HomePage homepage, MyAccountPage myAccountPage, PersonalDataModal personalDataModal,ShippingAddressPage shippingAddressPage,
                                  AccountDetailsPage accountDetailsPage, AddressesPage addressesPage, BillingAddressPage billingAddressPage) {
        this.homePage = homepage;
        this.myAccountPage = myAccountPage;
        this.personalDataModal = personalDataModal;
        this.accountDetailsPage = accountDetailsPage;
        this.addressesPage = addressesPage;
        this.billingAddressPage = billingAddressPage;
        this.shippingAddressPage = shippingAddressPage;
    }

    //Email validation
    @And("The user clicks on Account details")
    public void the_user_clicks_on_account_details() {
        myAccountPage.clickOnAccountDetails();
    }

    @Then("User should see the correct email was used")
    public void user_should_see_the_correct_email_was_used() {
        Assert.assertEquals(accountDetailsPage.getEmailFieldValue(), "testuser477@gmail.com");
    }

    //Change account details
    @When("The user enters a first name")
    public void the_user_enters_a_first_name() {
        accountDetailsPage.enterFirstName("test");
    }

    @And("The user enters a last name")
    public void the_user_enters_a_last_name() {
        accountDetailsPage.enterLastName("test");
    }

    @And("The user saves changes")
    public void the_user_saves_changes() {
        accountDetailsPage.clickOnSaveChangesButton();
    }

    @Then("The user should be presented with a successful change-making message")
    public void theUserShouldBePresentedWithASuccessfulChangeMakingMessage() {
        Assert.assertEquals("Account details changed successfully.", myAccountPage.extractSuccessfulChangeMessage());
    }

    //Validate addressed section
    @When("The user clicks on Addresses link")
    public void the_user_clicks_on_addresses_link() {
        myAccountPage.clickOnAddressesButton();
    }

    @Then("The user should see Billing and Shipping addresses")
    public void the_user_should_see_billing_and_shipping_addresses() {
        Assert.assertEquals("https://practice.automationtesting.in/my-account/edit-address/", addressesPage.getAddressesUrl());
    }

    @And("The user clicks on the billing edit button")
    public void theUserClicksOnTheBillingEditButton() {
        addressesPage.clickOnBillingEditButton();
    }

    @And("The user enters a billing firstname")
    public void theUserEntersABillingFirstname() {
        billingAddressPage.enterBillingFirstName("testname");
    }


    @And("The user enters a billing lastname")
    public void theUserEntersABillingLastname() {
        billingAddressPage.enterBillingLastName("testlastname");
    }

    @And("The user enters a billing phone number")
    public void theUserEntersABillingPhoneNumber() {
        billingAddressPage.enterBillingPhone("09875234645");
    }

    @And("The user selects a billing country")
    public void theUserSelectsABillingCountry() {
        billingAddressPage.clickOnCountryField();
        billingAddressPage.searchForCountry("United Kingdom");
        billingAddressPage.selectCountry();
    }

    @And("The user enters a billing street address")
    public void theUserEntersABillingStreetAddress() {
        billingAddressPage.enterBillingAddress("testaddress44");
    }

    @And("The user enters a billing city")
    public void theUserEntersABillingCity() {
        billingAddressPage.enterCity("testcity");
    }

    @And("The user enters a billing state")
    public void theUserEntersABillingState() {
        billingAddressPage.enterState("teststate");
    }

    @And("The user enters a billing postcode")
    public void theUserEntersABillingPostcode() {
        billingAddressPage.enterPostCode("HD7 5UZ");
    }

    @And("The user clicks on the billing Save Address button")
    public void theUserClicksOnTheBillingSaveAddressButton() {
        billingAddressPage.clickOnSaveAddressButton();
    }

    //Shipping address steps
    @And("The user clicks on the shipping edit button")
    public void theUserClicksOnTheShippingEditButton() {
        addressesPage.clickOnShippingEditButton();
    }

    @And("The user enters a shipping firstname")
    public void theUserEntersAShippingFirstname() {
        shippingAddressPage.enterFirstName("testFirstName");

    }

    @And("The user enters a shipping lastname")
    public void theUserEnterAShippingLastname() {
        shippingAddressPage.enterLastName("testLastName");
    }

    @And("The user selects a shipping country")
    public void theUserSelectsAShippingCountry() {
        shippingAddressPage.clickOnCountryField();
        shippingAddressPage.searchForCountry("United Kingdom");
        shippingAddressPage.selectCountry();
    }

    @And("The user enters a shipping street address")
    public void theUserEntersAStreetAddress() {
        shippingAddressPage.enterStreetAddress("testAddress");
    }

    @And("The user enters a shipping city")
    public void theUserEntersAShippingCity() {
        shippingAddressPage.enterCity("testCity");
    }

    @And("The user enters a shipping postcode")
    public void theUserEntersAShippingPostcode() {
        shippingAddressPage.enterPostCode("HD7 5UZ");
    }

    @And("The user clicks on the shipping Save Address button")
    public void theUserClicksOnTheShippingSaveAddressButton() {
        shippingAddressPage.clickOnSaveChangesButton();
    }

    @Then("The user should be able to save the data")
    public void theUserShouldBeAbleToSaveTheData() {
        Assert.assertEquals("Address changed successfully.", myAccountPage.extractSuccessfulChangeMessage());
    }

}