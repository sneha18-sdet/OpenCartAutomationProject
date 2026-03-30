Feature: Login functionality

  @positive
  Scenario: Login with valid credentials
    Given user is on the OpenCart login page
    When user enters email "VALID_EMAIL_HERE" and password "VALID_PASSWORD_HERE"
    And user clicks on Login button
    Then user should be redirected to My Account page

  @negative @data
  Scenario Outline: Login with invalid credentials
    Given user is on the OpenCart login page
    When user enters email "<email>" and password "<password>"
    And user clicks on Login button
    Then warning message should be displayed

    Examples:
      | email             | password  |
      | invalid@test.com  | wrong123  |
      | test              | pass      |
      |                   | pass123   |
      | valid@test.com    |           |
      | invalid-email     | wrong     |
