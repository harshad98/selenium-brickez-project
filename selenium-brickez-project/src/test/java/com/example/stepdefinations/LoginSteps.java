package com.example.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        System.out.println("Opening login page");
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        System.out.println("Entering username and password");
    }

    @When("I click on login")
    public void iClickOnLogin() {
        System.out.println("Clicking login");
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        System.out.println("Dashboard displayed");
    }

}
