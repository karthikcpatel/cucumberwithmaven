Feature: Verify login

  @Smoke
  Scenario Outline: Verify login with valid credentials
    Given Open login screen
    And wait for page to load
    When I enter valid "<username>" and "<password>"
    And I click on submit button
    Then I should login successfully
    Then I click logout link
    Then I should logout successfully

    Examples: 
      | username             | password  |
      | kartik9@yopmail.com  | password1 |
      | kartik10@yopmail.com | password1 |
