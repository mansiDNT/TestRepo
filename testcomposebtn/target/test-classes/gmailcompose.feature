Feature: Compose button functionality in Gmail

  Scenario: User clicks on the Compose button
    Given User is on the Gmail login page
    When User logs in with valid credentials
    Then User clicks on the Compose button
    And Compose window should be displayed