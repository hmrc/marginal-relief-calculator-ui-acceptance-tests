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
    And the user is alerted to taxable profits "<profitError>"
    Examples:
      | profitValue  | profitError                                                                             |
      | 50000.67     | Do not use decimal points for taxable profits. Enter a whole number. For example, 70000 |
      | 10000000000  | Enter an taxable profit amount between 0 and 2,147,483,647                              |
      |              | Enter an amount for your taxable profits                                                |
      | ONE THOUSAND | Enter a valid taxable profit. For example, 70000                                        |
      | -1000        | Enter an taxable profit amount between 0 and 2,147,483,647                              |





