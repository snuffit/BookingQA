Feature: Search hotel
  Background:
    Given booking search page is opened

  Scenario: Looking for 'Akra Kemer'
    When user searches for "Akra Kemer"
    Then "Akra Kemer - Ultra All Inclusive" hotel is shown

  Scenario Outline: Looking for hotels
    When user searches for "<hotel>"
    Then "<expectedResult>" hotel is shown
    Examples:
    | hotel | expectedResult |
    | Akra Kemer | Akra Kemer - Ultra All Inclusive |
    | Meraki | Meraki Resort - Adults Only |

  Scenario Outline: Checking hotel ratings
    When user searches for "<hotel>"
    Then "<expectedResult>" hotel is shown
    And "<expectedResult>" hotel  rating is "<expectedRating>"
    Examples:
      | hotel | expectedResult | expectedRating |
      | Akra Kemer | Akra Kemer - Ultra All Inclusive | 9,2 |
      | Meraki | Meraki Resort - Adults Only | 9,4 |