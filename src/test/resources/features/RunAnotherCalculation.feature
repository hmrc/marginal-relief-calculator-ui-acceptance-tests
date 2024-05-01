Feature: Run another calculation - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "31/03/2023"
    And the accounting period end date is provided as "30/03/2024"
    Then the user clicks the continue button on the accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with an input field to provide distributions
    And the user provides "£50,000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user is presented with an input field for associated companies
    And the user inputs a valid number as "10" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    And the user can see the calculate margin relief button enabled
    When the user can click on the calculate margin relief button
    And the user can see the run another calculation button enabled

  @mrc-44 @zap @a11y
  Scenario: Click on Run Another Calculation and verify fields as NULL
    When the user clicks the run another calculation button
    Then the user lands on the before you start page
    When the user clicks the start now button
    Then the user can see the accounting period start and end dates as null
    When the accounting period start date is provided as "31/03/2023"
    When the user clicks the continue button on the accounting period page
    Then I can see companies taxable profit as null
    And the profit is "50000"
    When the user clicks continue button on taxable profit page
    Then the user is navigated to the exempt distributions page
    And the user can see the options yes, no are not selected
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user can see the options yes,no are not selected on the Second exempt distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with an input field to provide distributions
    And the user provides "£50,000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    And the user can see the options yes and No as not selected
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user is presented with an input field for associated companies
    And the user is presented with an input field for associated companies with the value as null
    And the user inputs a valid number as "2" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    And the user can see the calculate margin relief button enabled
    When the user can click on the calculate margin relief button
    And the user can see the run another calculation button enabled
