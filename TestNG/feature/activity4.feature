@activity4

Feature: Login Test

  @SmokeTest
  Scenario Outline: Testing Login
    Given User is on Login page second
    When User enters username "<Username>" and password "<Password>"
    Then Read the page title and confirmation messages
    And Close the browser of Login second
    Examples:
      | Username | Password  |
      | admin    | password |
      | user2    | password2 |
      | user3    | password3 |