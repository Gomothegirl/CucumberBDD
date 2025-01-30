@regression
@Accordion

Feature: Accordion

  Scenario: User can click on the accordion items
    Given user is on the accordion page
    When user clicks on the accordion items
    Then accordion items should display