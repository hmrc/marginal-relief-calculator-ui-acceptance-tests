Feature: Run another calculation - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "31/03/2023"
    And the accounting period end date is provided as "30/03/2024"
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
    And I can see calculate margin relief button enabled
    When I can click on calculate margin relief button
    Then I am navigated to MRC results page
    And I can see run another calculation button enabled

  @mrc-44@wip
  Scenario: Click on Run Another Calculation and verify fields as NULL
    When I click on run another calculation button
    Then I am landed on before you start page
    When the user clicks on start now button
    Then I can see accounting period start and end dates as empty
    When the accounting period start date is provided as "31/03/2023"
    And the accounting period end date is provided as "30/03/2024"
    Then the user clicks continue button on accounting period page