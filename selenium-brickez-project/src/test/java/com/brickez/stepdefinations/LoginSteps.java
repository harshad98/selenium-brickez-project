package com.brickez.stepdefinations;

import com.brickez.pages.LoginPage;
import com.brickez.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {

        DriverManager.getDriver()
                .get("https://brickez.com");

        loginPage = new LoginPage(
                DriverManager.getDriver()
        );
    }

    @When("I login with valid username and password")
    public void iLoginWithValidUsernameAndPassword() {

        loginPage.login(
                "harshad@homehub.global",
                "10cr6lru"
        );
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {

        WebDriver driver = DriverManager.getDriver();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(ExpectedConditions.urlContains("/home"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "Login was not successful. Current URL: " + driver.getCurrentUrl()
        );
    }
}
