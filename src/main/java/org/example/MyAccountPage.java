package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"reg_email\"]")
    WebElement registrationId;
    @FindBy(xpath = "//*[@id=\"reg_password\"]")
    WebElement registrationPass;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")
    WebElement registrationButton;
    public static final String myAccountUrl = "https://practice.automationtesting.in/my-account/";
    private WebDriver webDriver;
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, myAccountUrl);
        this.webDriver = webDriver;
    }

    public void enterEmail(String userEmail) {
        //WebElement registrationId = webDriver.findElement(By.xpath("//*[@id=\"reg_email\"]"));
        registrationId.click();
        registrationId.sendKeys(userEmail);
    }

    public void enterPass(String userPass) {
        registrationPass.sendKeys(userPass + Keys.TAB);
    }

    public void registerUser() {
        registrationButton.click();
    }
}
