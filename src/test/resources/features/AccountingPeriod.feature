Feature: Accounting Period - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page

  @mrc-35
  Scenario:Accounting Period Validation 01:Accounting Period Start Date
    When the accounting period start day is empty
    Then the user is alerted to a mandatory value error

  @mrc-35
  Scenario:Accounting Period Validation 02:Accounting Period Start Date
    When the accounting period start date is empty
    Then the user is alerted to a mandatory field error

  @mrc-35
  Scenario:Accounting Period Validation 03:Accounting Period End Date
    When the accounting period start date is valid
    When the accounting period greater than one Year
    Then the user is alerted to an accounting period length error

  @mrc-93
  Scenario Outline: Auto generated accounting end date when accounting end date is not provided
    When the accounting period start date is provided as "<accountingStartDate>"
    And the user clicks continue button on accounting period page
    And the user click on back button
    Then the user can see the accounting end period as "<ExpectedAccountingEndDate>"

    Examples:
      | accountingStartDate | ExpectedAccountingEndDate |
      | 29/02/2024          | 27/2/2025                 |
      | 01/03/2025          | 28/2/2026                 |
      | 08/09/2022          | 7/9/2023                  |

  @mrc-93
  Scenario: Verify accounting end date by clicking back
    When the accounting period start date is provided as "31/03/2024"
    And the accounting period end date is provided as "30/03/2025"
    And the user clicks continue button on accounting period page
    And the user click on back button
    Then the user can see the accounting end period as "30/3/2025"

  @mrc-90
  Scenario Outline:Marginal Relief not relevant for accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the accounting period end date is provided as "<accountingEndDate>"
    And the user clicks continue button on accounting period page
    Then the user should given with an irrelevant accounting period page

    Examples:
      | accountingStartDate | accountingEndDate |
      | 01/04/2022          | 31/03/2023        |
      | 01/10/2022          | 28/02/2023        |

  @mrc-90
  Scenario Outline:Marginal Relief not relevant for accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the user clicks continue button on accounting period page
    Then the user should given with an irrelevant accounting period page

    Examples:
      | accountingStartDate |
      | 01/04/2022          |

  @mrc-90
  Scenario Outline:Marginal Relief not relevant for accounting period- Error Page
    When the accounting period start date is provided as "<accountingStartDate>"
    And the accounting period end date is provided as "<accountingEndDate>"
    And the user clicks continue button on accounting period page
    Then the user is displayed with error message "<errorMessage>" for accounting period

    Examples:
      | accountingStartDate | accountingEndDate | errorMessage                                                                                  |
      | 01/04/2022          | 30/04/2023        | The accounting period end date must be less than or equal to a full year from the start date. |
      | 01/04/2022          | 31/03/2022        | The accounting period End date must be after the Start date.                                  |

  @mrc-135
  Scenario Outline:Accounting period-Content change
    When the user reads content on accounting period as "<accountingPeriodContent>"
    Then the user reads content on accounting end date as "<accountingPeriodEndDateContent>"

    Examples:
      | accountingPeriodContent                                                                                                                            | accountingPeriodEndDateContent                                                |
      | Your accounting period cannot be longer than a full year and is normally the same as the financial year covered by your company's annual accounts. | If you do not enter a date we will default to a full year from the start date |


