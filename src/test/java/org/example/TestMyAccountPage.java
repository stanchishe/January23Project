package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MyAccountPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestMyAccountPage {
        public static WebDriver webDriver;
        public static MyAccountPage myAccountPage;

        @Before
        public static void initState() {
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("Start-Maximized");
                //options.addExtensions(new File("src/resources/ChromeExtension/Adblocker2.crx"));
                //webDriver = new ChromeDriver(options);
                //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                myAccountPage = new MyAccountPage();
        }

        @After
        public static void closeState() {
                myAccountPage.closeBrowser();
        }

        @Given("the browser window is openn")
        public void the_browser_window_is_open() {
                Assertions.assertTrue(myAccountPage.isBrowserOpen(), "The browser is not open!");
        }
        @Given("the correct page is loadedd")
        public void the_correct_page_is_loaded() {
                boolean correctPageLoaded;
                try {
                        myAccountPage.isLoaded();
                        correctPageLoaded = true;
                } catch (Error e) {
                        correctPageLoaded = false;
                }
                Assertions.assertTrue(correctPageLoaded, "The correct url was not loaded!");
        }
        @When("^the user enters a valid email (.*) and passs (.*)$")
        public void the_user_enters_a_valid_email_and_pass(String userEmail, String userPass) {
                myAccountPage.enterEmail(userEmail);
                myAccountPage.enterPass(userPass);
        }
        @When("clicks the registration buttonn")
        public void clicks_the_registration_button() {
                myAccountPage.registerUser();
        }
        @Then("^a new userId (.*) is registered on the serverr$")
        public void a_new_user_id_is_registered_on_the_server(String expectedUser) {
                String registeredUser = webDriver.findElement(
                        By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/strong")
                ).getText().trim();
                Assertions.assertEquals(expectedUser.split("@")[0], registeredUser, "The user was not registered correctly!");
        }
}
