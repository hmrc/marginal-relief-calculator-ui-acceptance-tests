Feature: Associated companies Title Message - Validations

  Background:
    Given Marginal Relief Calculator is launched
    And the user clicks the start now button
    And the user lands on the accounting period page

  @mrc-94
  Scenario Outline:Enter associated companies for a portion of the accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the accounting period end date is provided as "<accountingEndDate>"
    And the user clicks the continue button on the accounting period page
    And the profit is "<profitValue>"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then display the "<message>" on associated company

    Examples:
      | accountingStartDate | accountingEndDate | profitValue | message                                                                                          |
      | 01/05/2024          | 31/12/2024        | 50000       | Did your company have any active associated companies?                                           |
      | 01/01/2023          | 31/12/2023        | 50000       | Did your company have any active associated companies between 1 April 2023 and 31 December 2023? |
