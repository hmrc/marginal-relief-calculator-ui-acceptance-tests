@Example
Feature: Marginal Relief Calculator- Basic MR calculation for single financial year with MR rate-FY2023
  Background:
    Given Marginal Relief Calculator is launched

  Scenario: AC1 - 1 COMPLETE YEAR + PROFITS LIES WITHIN MR THRESHOLDS
    When the accounting period start date is empty
    Then the user is alerted to an error





