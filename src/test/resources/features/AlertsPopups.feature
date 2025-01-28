@regression
@AlertsPopups

  Feature: Alerts Popups
    Scenario: user can click ok on an alert
      Given user is on the popups page
      When user triggers a popup
      And user clicks on ok to accept alert
      And user can trigger popup
      And user can close popup window
      Then user returns to the Alert

