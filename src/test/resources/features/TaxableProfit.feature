Feature:Taxable Profit - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page

  @mrc-36 @mrc-130
  Scenario Outline:Taxable Profit Validations
    When the accounting period start date is valid
    When the accounting period end date is valid
    And the profit is "<profitValue>"
    And the user clicks continue button on taxable profit page
    And the user is alerted to taxable profits "<profitError>"
    Examples:
      | profitValue   | profitError                                                                             |
      | 50000.67      | Do not use decimal points for taxable profits. Enter a whole number. For example, 70000 |
      | 10000000000   | Enter an amount lower than or equal to 1000000000                                       |
      | 1,000,000,001 | Enter an amount lower than or equal to 1000000000                                       |
      |               | Enter an amount for your taxable profits                                                |
      | ONE THOUSAND  | Enter a valid taxable profit. For example, 70000                                        |
      | -1000         | Enter an amount greater than 0                                                          |