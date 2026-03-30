Feature: Add to Cart functionality

  As a customer
  I want to add product to cart
  So that I can purchase it later

  Scenario: Add product to cart successfully

    Given user is on the OpenCart home page
    When user searches for product "MacBook"
    And user selects the product
    And user clicks Add to Cart button
    Then product should be added to the cart successfully