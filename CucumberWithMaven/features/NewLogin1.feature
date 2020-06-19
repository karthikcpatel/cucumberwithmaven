Feature: Compare price for mobile

  @Smoke
  Scenario: Verify and compare mobile price
    Given Open application and wait for page to load
    When I click on mobile link
    And I sort with name
    Then I compare price
