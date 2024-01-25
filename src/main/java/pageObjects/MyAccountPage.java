package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.HelperClass.getDriver;

public class MyAccountPage  {

    public MyAccountPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Account Details']")
    WebElement accountDetailsLink;

    @FindBy(css = "div.woocommerce-message")
    WebElement successfulChangeMessage;

    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement addressesLink;

    @FindBy(xpath = "//a[text()='Sign out']")
    WebElement signOutButton;

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void login(){
        enterUsername("testuser477");
        enterPassword("Testuser477!");
        clickOnLoginButton();
    }

    public void clickOnAccountDetails(){
        accountDetailsLink.click();
    }

    public String extractSuccessfulChangeMessage(){
        return successfulChangeMessage.getText();
    }

    public void clickOnAddressesButton(){
        addressesLink.click();
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }
}
