package pageObjects;

import org.openqa.selenium.support.PageFactory;

import static utils.HelperClass.getDriver;

public class AddressesPage {

    public AddressesPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String getAddressesUrl(){
        return getDriver().getCurrentUrl();
    }
}
