Feature: Accounting Period - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page

  @mrc-93
  Scenario Outline: Auto generated accounting end date when accounting end date is not provided
    When the accounting period start date is provided as "<accountingStartDate>"
    And the user clicks the continue button on the accounting period page
    And the user clicks the back button
    Then the user can see the accounting end period as "<ExpectedAccountingEndDate>"

    Examples:
      | accountingStartDate | ExpectedAccountingEndDate |
      | 29/02/2024          | 27/2/2025                 |
      | 01/03/2025          | 28/2/2026                 |
      | 08/09/2022          | 7/9/2023                  |

  @mrc-90
  Scenario Outline:Marginal Relief not relevant for accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the accounting period end date is provided as "<accountingEndDate>"
    And the user clicks the continue button on the accounting period page
    Then the user is shown the ineligible accounting period page

    Examples:
      | accountingStartDate | accountingEndDate |
      | 01/04/2022          | 31/03/2023        |
      | 01/10/2022          | 28/02/2023        |

  @mrc-90
  Scenario Outline:Marginal Relief not relevant for accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the user clicks the continue button on the accounting period page
    Then the user is shown the ineligible accounting period page

    Examples:
      | accountingStartDate |
      | 01/04/2022          |

  @mrc-135
  Scenario Outline:Accounting period-Content change
    When the user reads content on accounting period as "<accountingPeriodContent>"
    Then the user reads content on accounting end date as "<accountingPeriodEndDateContent>"

    Examples:
      | accountingPeriodContent                                                                                                                            | accountingPeriodEndDateContent                                                |
      | Your accounting period cannot be longer than a full year and is normally the same as the financial year covered by your company's annual accounts. | If you do not enter a date we will default to a full year from the start date |


