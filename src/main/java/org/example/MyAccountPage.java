package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public String checkForError() {
        List<WebElement> possibleErrors = webDriver.findElements(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li"));
        String realError;
        if(possibleErrors.size() > 0) {
            String externalError = possibleErrors.get(0).getText().trim();
            switch (possibleErrors.get(0).getText().trim()) {
                case RegErrors.EXISTING_ID:
                    realError = InternalRegErrors.INTERNAL_EXISTING_USER;
                    break;
                case RegErrors.MISSING_EMAIL:
                    realError = InternalRegErrors.INTERNAL_MISSING_EMAIL;
                    break;
                case RegErrors.MISSING_PASSWORD:
                    realError = InternalRegErrors.INTERNAL_MISSING_PWD;
                    break;
                default:
                    realError = InternalRegErrors.UNEXPECTED_ERROR + externalError;
            }
            return realError;
        }
        return "No error was generated on the web page!";
    }
}
