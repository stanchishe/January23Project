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
    WebElement submitButton;

    @FindBy(xpath = "//a[text()='Account Details']")
    WebElement accountDetailsLink;

    @FindBy(css = "div.woocommerce-message")
    WebElement successfulChangeMessage;

    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement addressesLink;

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnSubmit(){
        submitButton.click();
    }

    public void login(){
        enterUsername("testuser477");
        enterPassword("Testuser477!");
        clickOnSubmit();
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
}
