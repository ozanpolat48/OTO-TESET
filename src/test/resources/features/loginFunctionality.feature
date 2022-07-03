Feature: Login functionality with valid and invalid credentials

  Background: Navigates to login page
    Given user able to navigates login page


  Scenario: User able to login with valid credentials
    Given user fills username as "Employee3" and password as "Employee123"
    And   user clicks on login button
    And   user verify that url as "https://qa.seamlessly.net/index.php/apps/files/?dir=/&fileid=2503"
    When  user verify that username "Employee3"
    Then  user successfully logout


  Scenario: User able to login with valid credentials
    Given user fills username as "Employee3" and password as "Employee123"
    And   user press enter for login
    And   user verify that url as "https://qa.seamlessly.net/index.php/apps/files/?dir=/&fileid=2503"
    When  user verify that username "Employee3"
    Then  user successfully logout


  Scenario Outline: User should not able to login with invalid credentials
    Given user fills username as "<username>" and password as "<password>"
    When  user clicks on login button
    Then  user should see error message as "Wrong username or password."
    Examples: Inputs for username and password
      | username | password  |
      | Marvel   | Tiryakisi |
      | Cucumber | King      |

  @testing
  Scenario: User should able to see error message when username input empty
    Given user fills username as "" and password as "Employee123"
    And   user clicks on login button
    Then  user should see blank error message as "Please fill out this field"

  @testing
  Scenario: User should able to see error message when username input empty
    Given user fills username as "Employee3" and password as ""
    And   user clicks on login button
    Then  user should see blank error message as "Please fill out this field"

  @testing
  Scenario: User able to see password input dots by default
    Given user fills username as "Employee3" and password as "Employee123"
    Then  verify that filled password input shown by default

  @testing
  Scenario: User should able to see password when click on toggle button
      Given user fills username as "Employee3" and password as "Employee123"
      When  user clicks on password toggle button
      Then  user verify that password is visible
  @testing
  Scenario: User should able to see placeholders
    Given user verify that username placeholder as "Username or email" and password placeholder as "Password"



