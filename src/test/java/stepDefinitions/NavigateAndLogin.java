package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.PersonalDataModal;
import utils.HelperClass;

public class NavigateAndLogin {

    PersonalDataModal personalDataModal;
    HomePage homePage;
    MyAccountPage myAccountPage;

    public NavigateAndLogin(PersonalDataModal personalDataModal, HomePage homePage, MyAccountPage myAccountPage){
        this.personalDataModal = personalDataModal;
        this.homePage = homePage;
        this.myAccountPage = myAccountPage;
    }

    @Given("The user access practice.automationtesting homepage")
    public void the_user_access_practice_automationtesting_homepage() {
        HelperClass.openPage("https://practice.automationtesting.in");
        personalDataModal.cancelPersonalDataModal();
    }

    @When("The user clicks on my account button")
    public void theUserClicksOnMyAccountButton() {
        homePage.clickOnMyAccount();
    }

    @And("The user log in into account")
    public void the_user_log_in_into_account() {
        myAccountPage.login();
    }

}
