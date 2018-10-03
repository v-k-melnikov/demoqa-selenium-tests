@all
Feature:  User's sign up

  Scenario: User's sign up
    Given user's data: <firstName> <lastName> <phoneNumber> <username > <email> <password>
    When user inputs
    Then server saves user's data and site displays message "Thank you for your registration"

  | firstName     | lastName    | phoneNumber  | username |  email           | password     |
  | John          | Brown       | +11233231212 | jBrown   | jbrown@gmail.com | pa$$word     |
  | a             | a           | +11233231212 | a        | jbrown@gmail.com | pa$$word     |
  | a             | a           | +11233231212 | a        | jbrown@gmail.com | pa$$word     |