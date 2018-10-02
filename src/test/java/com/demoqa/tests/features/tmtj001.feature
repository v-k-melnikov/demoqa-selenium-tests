@withdrawal, @all
Feature: Sign up user

  @success
  Scenario: Successful registration
    Given valid values for the registration form with new unique username and password
    When user inputs given values into registration form
    Then server saves user's data and site  displays message "Thank you for your registration"

