Feature: Login into account at empik.com

  Scenario: Failed login into account
    Given User is on login page
    When User enter correct e-mail
    And User enter incorrect password
    And User click login button
    Then Error appeared

    Scenario: Successful login into account
      Given User is on login page
      When User enter correct e-mail
      And User enter correct password
      And User click login button
      Then Welcome message appeared on main page