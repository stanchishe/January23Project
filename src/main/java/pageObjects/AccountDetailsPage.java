package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.HelperClass.getDriver;

public class AccountDetailsPage {

    public AccountDetailsPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "account_email")
    WebElement emailField;

    @FindBy(id = "account_first_name")
    WebElement firstNameField;

    @FindBy(id = "account_last_name")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@value='Save changes']")
    WebElement saveChangesButton;

    public String getEmailFieldValue(){
        return emailField.getAttribute("value");
    }

    public void enterFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clickOnSaveChangesButton(){
        saveChangesButton.click();
    }
}
