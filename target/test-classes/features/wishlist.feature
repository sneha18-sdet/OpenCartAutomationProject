Feature: Wishlist functionality

  Scenario: Add product to wishlist

    Given user is logged in
    When user adds product to wishlist
    Then wishlist page should be displayed