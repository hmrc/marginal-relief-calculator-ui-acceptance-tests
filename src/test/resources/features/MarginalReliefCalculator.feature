Feature: Marginal Relief Calculator- Validations

  Background:
    Given Marginal Relief Calculator is launched

  Scenario:Accounting Period Validation 01:Accounting Period Start Date
    When the accounting period start day is empty
    Then the user is alerted to a mandatory value error

  Scenario:Accounting Period Validation 02:Accounting Period Start Date
    When the accounting period start date is empty
    Then the user is alerted to a mandatory field error

  Scenario:Accounting Period Validation 03:Accounting Period End Date
    When the accounting period start date is valid
    When the accounting period greater than one Year
    Then the user is alerted to an accounting period length error

  Scenario Outline:Taxable Profit Validations
    When the accounting period start date is valid
    When the accounting period end date is valid
    And the profit is "<profitValue>"
    And the user clicks continue button on taxable profit page
    And the user is alerted to taxable profits "<profitError>"
    Examples:
      | profitValue  | profitError                                                                             |
      | 50000.67     | Do not use decimal points for taxable profits. Enter a whole number. For example, 70000 |
      | 10000000000  | Enter a taxable profit amount between 0 and 2,147,483,647                               |
      |              | Enter an amount for your taxable profits                                                |
      | ONE THOUSAND | Enter a valid taxable profit. For example, 70000                                        |
      | -1000        | Enter a taxable profit amount between 0 and 2,147,483,647                               |

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

  Scenario: Verify accounting end date by clicking back
    When the accounting period start date is provided as "31/03/2024"
    And the accounting period end date is provided as "30/03/2025"
    And the user clicks continue button on accounting period page
    And the user click on back button
    Then the user can see the accounting end period as "30/3/2025"

  Scenario Outline: Enter associated companies for a portion of the accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the user clicks continue button on accounting period page
    And the user click on back button
    Then the user can see the accounting end period as "<ExpectedAccountingEndDate>"

    Examples:
      | accountingStartDate | ExpectedAccountingEndDate |
      | 29/02/2024          | 27/2/2025                 |
      | 01/03/2025          | 28/2/2026                 |
      | 08/09/2022          | 7/9/2023                  |

  Scenario Outline:Enter associated companies for a portion of the accounting period
    When the accounting period start date is provided as "<accountingStartDate>"
    And the accounting period end date is provided as "<accountingEndDate>"
    And the user clicks continue button on accounting period page
    And the profit is "<profitValue>"
    And the user clicks continue button on taxable profit page
    And the distributions is "<excemptDistributions>"
    And the user clicks continue button on distributions page
    Then display the "<message>" on associated company

    Examples:
      | accountingStartDate | accountingEndDate | profitValue | excemptDistributions | message                                                                                    |
      | 01/01/2024          | 31/12/2024        | 50000       | 0                    | Did your company have any active associated companies?                                     |
      | 01/01/2023          | 31/12/2023        | 50000       | 0                    | Did your company have any active associated companies between 01 Apr 2023 and 31 Dec 2023? |