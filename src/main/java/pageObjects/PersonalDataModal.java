package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.HelperClass.getDriver;

public class PersonalDataModal {

    public PersonalDataModal(){
        PageFactory.initElements(getDriver(), this);

    }
    @FindBy(xpath = "//button[@class='fc-button fc-cta-do-not-consent fc-secondary-button']")
    WebElement cancelButton;

    public void cancelPersonalDataModal(){
        cancelButton.click();
    }
}
