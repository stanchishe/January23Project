package com.practice_automation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BaseClassPracticeAutomation {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DesiredCapabilities capabilities;
    public static ChromeOptions options;


    @FindBy(xpath = Constants.PASSWORD_FIELD)
    public static WebElement passwordLoginInput;
    @FindBy(xpath = Constants.MY_ACCOUNT_BTN)
    public static WebElement myAccountButton;
    @FindBy(xpath = Constants.LOGIN_BTN)
    public static WebElement loginButton;


    @FindBy(xpath = Constants.USERNAME_FIELD)
    public static WebElement userLoginInput;

    public static String validPassword = "Sofiya123!@#";
    public static String validEmail = "asdf123@d.nh";
    public static String invalidPassword = "Sofiya";
    public static String invalidEmail = "qwe@abv.bg";

    public static void browserClose() {
        driver.close();
        driver.quit();
    }


    public void browserSetUp() {

        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addExtensions(new File(Constants.AD_BLOCKER_PATH));
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickOnButton(WebElement btn) {
        btn.click();
    }


    public void fillInField(WebElement element, String argument) {
        element.click();
        element.clear();
        if (argument != null) {
            element.sendKeys(argument);
        }
    }
}
