Feature: Filtering behaviour

  Background:
    Given the user navigated to the site

  @filters
  Scenario: Filter behaviour
    And the user clicks on "Vitamins & Supplements" from main navigation
    And the user clicks on "Vitamins"
    And the user clicks on "Brand" filter
    When the user selects Vitabiotics filter option
    Then the user able to see only Vitabiotics products