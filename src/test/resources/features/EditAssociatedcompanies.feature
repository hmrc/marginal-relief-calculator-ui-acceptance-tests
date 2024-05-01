Feature:Edit Associated Companies - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks the continue button on the accounting period page
    And the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "Yes" for the question Did your company have any active associated companies?
    Then the user is presented with an input field for associated companies
    And the user inputs a valid number as "25" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page

  @mrc-45 @zap
  Scenario: Edit Associated Companies
    And the user is presented with a change link next to the associated companies
    Then the user can validate the associated companies as "25"
    And the user clicks the change link next to the associated companies
    And the user lands on the associated companies page
    And the user validates associated companies are pre-populated as "25"
    And the user inputs a valid number as "50" associated companies
    Then the user clicks the continue button on the associated companies page
    And the user is presented with the Check Your Answers page
    And the user can validate the associated companies as "50"

  @mrc-45
  Scenario: Edit Associated Companies-No Associated Company
    And the user is presented with a change link next to the associated companies
    Then the user can validate the associated companies as "25"
    And the user clicks the change link next to the associated companies
    And the user lands on the associated companies page
    And the user validates associated companies are pre-populated as "25"
    And the user selects option "No" for the question Did your company have any active associated companies?
    Then the user clicks the continue button on the associated companies page
    And the user is presented with the Check Your Answers page
    And the user can validate the associated companies as "0"