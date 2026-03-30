Feature: Contact Us functionality

  As a user
  I want to send enquiry
  So that admin can respond

  Scenario: Submit contact enquiry

    Given user navigates to Contact Us page
    When user enters name "Sneha" email "sneha@gmail.com" and enquiry "Test enquiry message"
    And user clicks submit button
    Then contact enquiry should be submitted successfully