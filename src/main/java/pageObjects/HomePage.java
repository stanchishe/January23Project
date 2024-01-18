package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.HelperClass.TIMEOUT;
import static utils.HelperClass.getDriver;

public class HomePage {

    WebDriverWait wait;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
    }

    @FindBy(xpath = "//a[text()='My Account']")
    WebElement myAccountLink;

    public void clickOnMyAccount(){
        myAccountLink.click();
    }

}
