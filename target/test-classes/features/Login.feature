Feature: Login functionality

  As a registered user
  I want to login into my account
  So that I can access my dashboard

  Background:
    Given user is on the OpenCart login page

  @Smoke
  Scenario: Login with valid credentials
    When user enters email "snehasuchi43@gmail.com" and password "Suchi@1022"
    And user clicks on Login button
    Then user should be redirected to My Account page

  