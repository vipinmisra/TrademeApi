@listings
Feature: This feature tests the listing functionality of TradeMe API

  Scenario: User should be able to create a new listing using API
    When I create a new listing with the below details
      | element | value |
      | Category | 0002-0356-0032-2273- |
    Then I should see a 'Success'