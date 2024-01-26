package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.List;

public class ShippingAddress extends BasePage {

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement LogInId;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement LogInPass;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
    WebElement LogInButton;
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")
    WebElement AddressButton;
    @FindBy(xpath =  "//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")
    WebElement EditAddress;

    @FindBy String[] BlankFields = {
        "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[1]/input",  //First name
            "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[2]/input", //Last name
            "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/p[3]/input", //company name
            "//*[@id=\"shipping_address_1\"]", //Street
            "//*[@id=\"shipping_address_2\"]", //Appartment
            "//*[@id=\"shipping_city\"]", //TownCity
            "//*[@id=\"shipping_postcode\"]" //PosteCode
            //missing Country, State


    };


    public static final String myAccountUrl = "https://practice.automationtesting.in/my-account/";

    public ShippingAddress(WebDriver webDriver) {
        super(webDriver, myAccountUrl);
        this.webDriver = webDriver;
    }

    public void enterEmail(String userEmail) {
        LogInId.click();
        LogInId.sendKeys(userEmail);
    }

    public void enterPass(String userPass) {
        String[] passChars = userPass.split("");
        for(String passChar: passChars) {
            LogInPass.sendKeys(passChar);
        }
    }
    public void registerUser() {LogInButton.click(); }
    public void address(){
        AddressButton.click();
    }
    public void edit(){
        EditAddress.click();

        WebElement[] elements = new WebElement[BlankFields.length];

        // Find the web elements and store them in the array
        for (int i = 0; i < BlankFields.length; i++) {
            elements[i] = webDriver.findElement(By.xpath(BlankFields[i]));
        }

        // Iterate over the array of web elements using a for loop
        for (int i = 0; i < elements.length; i++) {
            WebElement element = elements[i];
            String value = element.getAttribute("value");
            if (value== "") {
                System.out.println("prazno");
            }
        }
    }

}
