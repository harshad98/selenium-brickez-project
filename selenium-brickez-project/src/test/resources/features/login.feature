Feature: Login functionality

  Scenario: Successful login

    Given I open the login page
    When I enter valid username and password
    And I click on login
    Then I should see the dashboard
