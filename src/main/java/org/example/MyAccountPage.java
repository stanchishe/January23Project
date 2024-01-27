package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"reg_email\"]") //Email polence
    WebElement registrationId;
    @FindBy(xpath = "//*[@id=\"reg_password\"]")  //Pass polence
    WebElement registrationPass;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]") //Register Button
    WebElement registrationButton;
    public static final String myAccountUrl = "https://practice.automationtesting.in/my-account/";
    private WebDriver webDriver;
    public MyAccountPage() {
        super(myAccountUrl);
    }

    public void enterEmail(String userEmail) {
        registrationId.click();
        registrationId.sendKeys(userEmail);
    }

    public void enterPass(String userPass) {
        String[] passChars = userPass.split("");
        for(String passChar: passChars) {
            registrationPass.sendKeys(passChar);
        }
    }

    public void registerUser() {
        registrationButton.click();
    }
}
