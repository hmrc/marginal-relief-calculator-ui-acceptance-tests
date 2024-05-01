Feature:Edit Taxable Profit - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/04/2023"
    And the accounting period end date is provided as "31/03/2024"
    Then the user clicks the continue button on the accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page

  @mrc-116
  Scenario: Edit Taxable Profit
    And the user is presented with a change link next to the company's profit
    Then the user can validate their company profit as "£50,000"
    And the user clicks the change link next to the company's profit
    And I am navigated to taxable profit page
    And I validate company profit is pre-populated as "50000"
    And the profit is "100000"
    And the user clicks continue button on taxable profit page
    Then the user is presented with a change link next to the company's profit
    And the user can validate their company profit as "£100,000"
