package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.List;

public class ShippingAddress extends LoginPage {

    @FindBy(xpath = "//*[@id=\"shipping_first_name\"]")  //First name
    WebElement FirstName;
    @FindBy(xpath = "//*[@id=\"shipping_last_name\"]") //Last name
    WebElement LastName;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[3]/input")//company name
    WebElement Company;
    @FindBy(xpath = "//*[@id=\"shipping_address_1\"]") //Street
    WebElement Street;
    @FindBy(xpath = "//*[@id=\"shipping_address_2\"]") //Appartment
    WebElement Appartment;
    @FindBy(xpath = "//*[@id=\"shipping_city\"]") //TownCity
    WebElement Town;
    @FindBy(xpath = "//*[@id=\"shipping_postcode\"]") //PosteCode
    WebElement Poste;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a") //address button
    WebElement Addressbutton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div/div[2]/header/a") //EditBilling
    WebElement Editbilling;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[10]/input[1]") //SAvebutton
    WebElement SaveButton;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div[1]") // Address saved text
    WebElement SavedAddress;
    @FindBy String[] BlankFields = {
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[1]/input",  //First name
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[2]/input", //Last name
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[3]/input", //company name
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[5]/input", //Street
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[6]/input", //Appartment
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[7]/input", //TownCity
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[9]/input" //PosteCode
        //missing Country, State


    };

    public ShippingAddress() {
        super();
    }

    public void selectAddress() {
        Addressbutton.click();
    }
    public void selectEditBilling() {
        Editbilling.click();
        WebElement[] elements = new WebElement[BlankFields.length];

        // Find the web elements and store them in the array
        for (int i = 0; i < BlankFields.length; i++) {
            elements[i] = webDriver.findElement(By.xpath(BlankFields[i]));
        }

        // Iterate over the array of web elements using a for loop
        for (int i = 0; i < elements.length; i++) {
            WebElement element = elements[i];
            String value = element.getAttribute("value");
            if (value == "") {
                System.out.println("prazno");
            }
        }
    }
    public void enterName(String firstName) {
        FirstName.click();
        FirstName.clear();
        FirstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        LastName.click();
        LastName.clear();
        LastName.sendKeys(lastName);
    }
    public void enterCompnay(String company) {
        Company.click();
        Company.clear();
        Company.sendKeys(company);
    }
    public void enterStreetName(String Streetname) {
        Street.click();
        Street.clear();
        Street.sendKeys(Streetname);
    }public void enterAppartmentName(String Appartmentname) {
        Appartment.click();
        Appartment.clear();
        Appartment.sendKeys(Appartmentname);
    }public void enterTownName(String TownName) {
        Town.click();
        Town.clear();
        Town.sendKeys(TownName);
    }public void enterPosteName(String PosteName) {
        Poste.click();
        Poste.clear();
        Poste.sendKeys(PosteName);
    }
    public void ClickSave() {
        SaveButton.click();
    }

    public String isSaved() {
        return SavedAddress.getText().trim();
    }

}
