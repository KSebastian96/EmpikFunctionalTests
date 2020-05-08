Feature: Filtering at empik.com as non-logged user

  Scenario: Filtering books by author at empik.com
    Given User is on main page
    When User click book category
    And User click IT subcategory
    And User randomly choose author filter
    Then Results should match author filter

  Scenario: Filtering books by type of cover
    Given User is on main page
    When User click book category
    And User click IT subcategory
    And User randomly choose cover type filter
    Then Results should match cover filter

  Scenario: Filtering books by score
    Given User is on main page
    When User click book category
    And User click IT subcategory
    And User randomly choose score filter
    Then Results should match score filter

  Scenario Outline: Filtering books by price
    Given User is on main page
    When User click book category
    And User click IT subcategory
    And User fill minimal price field with <minimal price>
    And User fill maximal price field with <maximal price>
    Then Results should match price filters
    Examples:
      | minimal price | maximal price |
      | 30            | 60            |