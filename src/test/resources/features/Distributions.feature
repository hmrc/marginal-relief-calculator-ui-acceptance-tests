Feature:Exempt Distributions - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks the continue button on the accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page

  @mrc-37
  Scenario: User selects No for question Did your company receive any distributions
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page

  @mrc-37
  Scenario: User selects Yes for question Did your company receive any distributions and No to include in profits
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "No" for the question Do any distributions need to be included with your profits?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page

  @mrc-37
  Scenario: Happy Path - Yes for question Did your company receive any distributions and Yes to include in profits
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with an input field to provide distributions
    And the user provides "£50,000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page

  @mrc-118
  Scenario: Happy Path - Distributions amount is displayed on check your answers page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    And the user provides "£200,500,000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "yes" for the question Did your company have any active associated companies?
    And the user inputs a valid number as "1" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    Then the user is presented with change link next to the distribution amount
    And the user can validate their distribution amount as "£200,500,000"
    When the user clicks the change link next to the distribution amount
    Then the user is navigated to the exempt distributions page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    When the user changes the distributions value to "£30,000"
    And the user clicks the continue button on the distributions page
    Then the user is presented with the Check Your Answers page
    And the user can validate their distribution amount as "£30,000"


  @mrc-118
  Scenario: Zero Distributions Shown as NONE on check your answers page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    And the user can validate their distribution amount as "None"