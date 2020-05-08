Feature: Searching at empik.com

  Scenario Outline: Searching for books using searching bar at main page
    Given User is on home page
    When User enter book <title> in searching bar
    And User choose book category
    And User click search button
    Then Results should be books
    And Results should contains entered phrase
    Examples:
      | title    |
      | krzyżacy |