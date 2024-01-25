package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.HelperClass.getDriver;

public class AddressesPage {

    public AddressesPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='u-column1 col-1 woocommerce-Address']/header/a")
    WebElement billingEditButton;

    @FindBy(xpath = "//div[@class='u-column2 col-2 woocommerce-Address']/header/a")
    WebElement shippingEditButton;

    public String getAddressesUrl(){
        return getDriver().getCurrentUrl();
    }

    public void clickOnBillingEditButton(){
        billingEditButton.click();
    }

    public void clickOnShippingEditButton(){
        shippingEditButton.click();
    }
}
