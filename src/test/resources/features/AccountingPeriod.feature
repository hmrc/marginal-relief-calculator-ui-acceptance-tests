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
