@charities
Feature: This feature file tests the Charities functionality of TradeMe API

  Scenario: Retrieve a list of charities and confirm that St John is included in the list
    When I retrieve the list of all Charities using 'Description' tag
    Then I should find 'St John' in the list of Charities