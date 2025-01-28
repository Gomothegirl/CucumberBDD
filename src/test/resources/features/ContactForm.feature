@regression
@ContactForm

Feature: Contact Form

  Scenario Outline: User is can submit contact form
    Given User is on the home page
    When User clicks on Contact Form from the menu
    And User enters name "<name>"
    And User enters lastname "<lastname>"
    And User enters email "<email>"
    And User enters comments "<comments>"
    And User clicks on submit
    Then A thank you message should be displayed

    Examples:
      | name | lastname | email         | comments   |
      | gomo | gomo     | Como@test.com | contact me |


