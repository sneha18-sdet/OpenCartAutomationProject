Feature: Logout functionality

  Scenario: Logout successfully

    Given user is logged into the application
    When user clicks logout link
    Then logout confirmation page should appear