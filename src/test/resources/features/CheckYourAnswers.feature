Feature: Marginal Relief Calculator - Check your answers page validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "31/03/2024"
    And the accounting period end date is provided as "30/03/2025"
    Then the user clicks continue button on accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£50,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    And user inputs a valid number as "10" associated companies
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page


  @mrc-118
  Scenario: Clicking on back button
    When the user clicks on back button
    Then user is landed on associated companies page

  @mrc-118
  Scenario: Clicking on back button after changing the distributions amount
    Then I am presented with change link next to the distribution amount
    And I can validate my distribution amount as "£50,000"
    When I click on change link next to the distribution amount
    Then I am navigated to exempt distributions page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    When I change the distributions value to "£30,000"
    And the user clicks continue button on distributions page
    Then user is presented with Check Your Answers page
    And I can validate my distribution amount as "£30,000"
    When the user clicks on back button
    Then I am navigated to Second exempt distributions page