Feature: Password reset functionality

  Background: Navigates to login page
    Given user able to navigates login page
  @reset
  Scenario: User able to see reset password button
    Given user clicks on forgot password link
    Then user verify that "Reset password" button visible