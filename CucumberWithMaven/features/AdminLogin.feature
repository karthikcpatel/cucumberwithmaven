Feature: Verify admin login functionality

  @Regression
  Scenario: Verify admin logic and basic navigation
    Given I navigate to admin login screen
    When I enter valid username and password
    When I click on sign in button
    Then I should get logged in successfully
    Then I click on logout button
