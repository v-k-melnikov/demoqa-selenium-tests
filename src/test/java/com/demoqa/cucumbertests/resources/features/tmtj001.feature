@all, @smoke
Feature:  User's sign up

  Scenario: User's sign up
    Given Navigate to "https://web.archive.org/web/20180815044632/http://demoqa.com/registration"
    When Fill fields with presented values
      | firstName | lastName | phoneNumber  | username | email | password |
      | John      | Brown    | +11233231212 |          |       | pa$$word |
    And Fill unique values to username and password
    Then Click on SUBMIT
    And Registration succeed

