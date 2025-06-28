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