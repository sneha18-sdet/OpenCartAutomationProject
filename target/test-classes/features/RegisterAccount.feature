Feature: Register Account
  @register @positive
  Scenario Outline: Register with valid data
    Given user is on register page
    When user enters registration details
      | firstName  | <firstName>  |
      | lastName   | <lastName>   |
      | email      | <email>      |
      | telephone  | <telephone>  |
      | password   | <password>   |
      | confirmPassword | <password> |
    Then user should register successfully

    Examples:
      | firstName | lastName | email                | telephone  | password    |
      | Sneha     | Sahu     | sneha123@test.com    | 9876543210 | Test@123    |
      | John      | Doe      | john@test.com        | 1234567890 | Pass@123    |

  @register @negative
  Scenario Outline: Register with duplicate email
    Given user is on register page
    When user enters registration details
      | firstName  | Sneha     |
      | lastName   | Sahu      |
      | email      | <email>   |
      | telephone  | 9876543210|
      | password   | Test@123  |
      | confirmPassword | Test@123 |
    Then duplicate email error should be displayed

    Examples:
      | email            |
      | sneha@test.com   |
