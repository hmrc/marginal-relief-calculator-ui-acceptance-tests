Feature:Edit Accounting Period - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "01/04/2023"
    And the accounting period end date is provided as "31/03/2024"
    Then the user clicks continue button on accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page

  @mrc-116
  Scenario: Edit Taxable Profit
    And I am presented with change link next to the company's profit
    Then I can validate my company profit as "£50,000"
    And I click on change link next to the company's profit
    And I am navigated to taxable profit page
    And I validate company profit is pre-populated as "£50000"
    And the profit is "100000"
    And the user clicks continue button on taxable profit page
    Then I am presented with change link next to the company's profit
    And I can validate my company profit as "£100,000"

  @mrc-116
  Scenario Outline: Edit Taxable Profit-Invalid Profit format
    And I am presented with change link next to the company's profit
    Then I can validate my company profit as "£50,000"
    And I click on change link next to the company's profit
    And I am navigated to taxable profit page
    And I validate company profit is pre-populated as "£50000"
    And the profit is "100000.50"
    And the user clicks continue button on taxable profit page
    Then the user is alerted to taxable profits "<profitError>"
    Examples:
      | profitError                                                                             |
      | Do not use decimal points for taxable profits. Enter a whole number. For example, 70000 |
