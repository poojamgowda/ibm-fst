@activity3

Feature: JavaScript Alerts

  @SmokeTest
  Scenario: Testing Alerts
    Given User is on Javascript page
    When Simple Alert
    Then To switch Focus to the Alert
    And Get Text
    And Accept the Alert
    When Confirm Alert
    Then To switch Focus to the Alert
    And Get Text
    And Accept the Alert
    When Prompt Alert
    Then To switch Focus to the Alert
    And Get Text
    And Send Keys
    And Accept the Alert
    And Closing the JS Browser