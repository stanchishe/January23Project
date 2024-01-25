package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.HelperClass.getDriver;

public class BillingAddressPage {

    public BillingAddressPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "billing_first_name")
    WebElement billingFirstNameField;

    @FindBy(id = "billing_last_name")
    WebElement billingLastNameField;

    @FindBy(id = "billing_phone")
    WebElement billingPhoneField;

    @FindBy(id = "s2id_billing_country")
    WebElement billingCountryField;

    @FindBy(id = "s2id_autogen1_search")
    WebElement billingCountrySearchField;

    @FindBy(xpath = "//ul/li/div")
    List<WebElement> countryOptions;

    @FindBy(id = "billing_address_1")
    WebElement billingAddressField;

    @FindBy(id = "billing_city")
    WebElement billingCity;

    @FindBy(id = "billing_postcode")
    WebElement postCodeField;

    @FindBy(id = "billing_state")
    WebElement billingStateField;

    @FindBy(xpath = "//input[@value='Save Address']")
    WebElement saveAddressButton;

    public void enterBillingFirstName(String firstName){
        billingFirstNameField.clear();
        billingFirstNameField.sendKeys(firstName);
    }

    public void enterBillingLastName(String lastName){
        billingLastNameField.clear();
        billingLastNameField.sendKeys(lastName);
    }

    public void enterBillingPhone(String phoneNumber){
        billingPhoneField.clear();
        billingPhoneField.sendKeys(phoneNumber);
    }

    public void enterBillingAddress(String address){
        billingAddressField.clear();
        billingAddressField.sendKeys(address);
    }

    public void clickOnCountryField(){
        billingCountryField.click();
    }

    public void searchForCountry(String country){
        billingCountrySearchField.sendKeys(country);
    }

    public void selectCountry(){
        countryOptions.get(0).click();
    }

    public void enterCity(String city){
        billingCity.clear();
        billingCity.sendKeys(city);
    }

    public void enterPostCode(String postCode){
        postCodeField.clear();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].value='"+ postCode +"';", postCodeField);
    }

    public void enterState(String state){
        billingStateField.clear();
        billingStateField.sendKeys(state);
    }
    public void clickOnSaveAddressButton(){
        saveAddressButton.click();
    }
}
