package com.practice_automation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
import java.util.List;

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
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")
    public static WebElement signOutButton;

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

        List<WebElement> declineOptions = driver.findElements(By.xpath(Constants.COOKIES_OPTIONS));
        if (!declineOptions.isEmpty()) {
            declineOptions.get(0).click();

        }
    }


    public void fillInField(WebElement element, String argument) {
        element.click();
        element.clear();
        if (argument != null) {
            element.sendKeys(argument);
        }
    }


    public void login() {
        userLoginInput.click();
        userLoginInput.sendKeys(validEmail);
        passwordLoginInput.click();
        passwordLoginInput.sendKeys(validPassword);
        loginButton.click();
    }

}
