Feature: Associated companies - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks the continue button on the accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page

  @mrc-38
  Scenario: Associated companies - Happy path
    Then the user lands on the associated companies page
    And the user can see the options yes and No as not selected
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user is presented with an input field for associated companies
    And the user inputs a valid number as "10" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page

  @mrc-38
  Scenario: No Associated companies - Happy path
    Then the user lands on the associated companies page
    And the user can see the options yes and No as not selected
    When the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page