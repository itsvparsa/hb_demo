Feature: Searching for Products on Holland & Barrett site

  Background:
    Given the user navigated to the site

  @search
  Scenario: search for one product
    When the user search for Honey
    Then the user able to see only Honey products

  @search
  Scenario Outline: search for multiple products
    When the user search for <products>
    Then the user able to see only <products> products
    Examples:
      | products     |
      | Multivitamin |
      | Herbal       |

  @search
  Scenario: search for invalid product
    When the user search for !"£$%^&
    Then validation message shown on the screen
    And There is search box to search again


