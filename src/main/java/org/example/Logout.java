package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout extends LoginPage {

    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a") // logout Button
    WebElement Logoutbutton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/h2") // login Label
    WebElement Login;

    public Logout() {
        super();
    }

    public void ClickButton() {
        Logoutbutton.click();
    }

    public boolean IsLoggedOut() {
        return Login.isDisplayed();
    }
}
