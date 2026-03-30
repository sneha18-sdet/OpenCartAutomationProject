Feature: Remove product from cart

  As a customer
  I want to remove product from shopping cart
  So that I can update my cart items

  Scenario: Remove product successfully from cart

    
    When user removes product from cart
    Then cart should be empty