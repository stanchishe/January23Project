package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.List;


public class BillingAddress extends LoginPage {

    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")  //First name
    WebElement FirstName;
    @FindBy(xpath = "//*[@id=\"billing_last_name\"]") //Last name
    WebElement LastName;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[3]/input")//company name
    WebElement Company;
    @FindBy(xpath = "//*[@id=\"billing_address_1\"]") //Street
    WebElement Street;
    @FindBy(xpath = "//*[@id=\"billing_address_2\"]") //Appartment
    WebElement Appartment;
    @FindBy(xpath = "//*[@id=\"billing_city\"]") //TownCity
    WebElement Town;
    @FindBy(xpath = "//*[@id=\"billing_city\"]") //PosteCode
    WebElement Poste;
    @FindBy(xpath = "//*[@id=\"billing_email\"]") // email
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"billing_phone\"]") //phone
    WebElement Phone;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a") //address button
    WebElement Addressbutton;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/a") //EditBilling
    WebElement Editbilling;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/form/p[12]/input[1]") //SAvebutton
    WebElement SaveButton;

    public BillingAddress() {
        super();
    }

    public void selectAddress() {
        Addressbutton.click();
    }
    public void selectEditBilling() {
        Editbilling.click();
    }
    public void enterName(String firstName) {
        FirstName.click();
        FirstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        LastName.click();
        LastName.sendKeys(lastName);
    }
    public void enterCompnay(String company) {
        Company.click();
        Company.sendKeys(company);
    }
    public void enterStreetName(String Streetname) {
        Street.click();
        Street.sendKeys(Streetname);
    }public void enterAppartmentName(String Appartmentname) {
        Appartment.click();
        Appartment.sendKeys(Appartmentname);
    }public void enterTownName(String TownName) {
        Town.click();
        Town.sendKeys(TownName);
    }public void enterPosteName(String PosteName) {
        Poste.click();
        Poste.sendKeys(PosteName);
    }public void enterEmailName(String EmailName) {
        Email.click();
        Email.sendKeys(EmailName);
    }public void enterPhoneName(String PhoneName) {
        Phone.click();
        Phone.sendKeys(PhoneName);
    }
    public void ClickSave() {
        SaveButton.click();
    }
}

