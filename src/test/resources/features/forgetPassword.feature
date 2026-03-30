Feature: Forgot Password functionality

  Scenario: Request password reset

    When user clicks forgotten password link
    And user enters email "test@gmail.com"
    Then password reset confirmation should be displayed