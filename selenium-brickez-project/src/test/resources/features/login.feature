Feature: Login functionality

  Scenario: Successful login with valid credentials

    Given I open the login page
    When I login with valid username and password
    Then I should be logged in successfully
