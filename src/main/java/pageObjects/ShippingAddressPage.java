package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.HelperClass.getDriver;

public class ShippingAddressPage {

    public ShippingAddressPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "shipping_first_name")
    WebElement shippingFirstNameField;

    @FindBy(id = "shipping_last_name")
    WebElement shippingLastNameField;

    @FindBy(id = "s2id_shipping_country")
    WebElement shippingCountryField;

    @FindBy(id = "s2id_autogen1_search")
    WebElement shippingCountrySearchField;

    @FindBy(xpath = "//ul/li/div")
    List<WebElement> shippingCountryOptions;

    @FindBy(id = "shipping_address_1")
    WebElement shippingAddressField;

    @FindBy(id = "shipping_city")
    WebElement shippingCityField;

    @FindBy(id = "shipping_postcode")
    WebElement shippingPostCodeField;

    @FindBy(xpath = "//input[@value='Save Address']")
    WebElement saveChangesButton;

    public void enterFirstName(String firstName){
        shippingFirstNameField.clear();
        shippingFirstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        shippingLastNameField.clear();
        shippingLastNameField.sendKeys(lastName);
    }

    public void clickOnCountryField(){
        shippingCountryField.click();
    }

    public void searchForCountry(String country){
        shippingCountrySearchField.sendKeys(country);
    }

    public void selectCountry(){
        shippingCountryOptions.get(0).click();
    }

    public void enterStreetAddress(String address){
        shippingAddressField.clear();
        shippingAddressField.sendKeys(address);
    }

    public void enterCity(String city){
        shippingCityField.clear();
        shippingCityField.sendKeys(city);
    }

    public void enterPostCode(String postCode){
        shippingPostCodeField.clear();
        shippingPostCodeField.sendKeys(postCode);
    }

    public void clickOnSaveChangesButton(){
        saveChangesButton.click();
    }
}
