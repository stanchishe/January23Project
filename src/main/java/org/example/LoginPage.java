package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement LogInId;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement LogInPass;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
    WebElement LogInButton;
    public static final String myAccountUrl = "https://practice.automationtesting.in/my-account/";

    public LoginPage(WebDriver webDriver) {
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
}

