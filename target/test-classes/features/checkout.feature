Feature: Checkout functionality

  As a customer
  I want to proceed to checkout
  So that I can purchase the product

  Scenario: Proceed to checkout successfully

    
    When user proceeds to checkout
    Then checkout page should be displayed