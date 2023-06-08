Feature: Associated companies - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page

  @mrc-38
  Scenario: Associated companies - Happy path
    Then user is landed on associated companies page
    And user can see the options yes and No as not selected
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    And user inputs a valid number as "10" associated companies
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page

  @mrc-38
  Scenario: No Associated companies - Happy path
    Then user is landed on associated companies page
    And user can see the options yes and No as not selected
    When the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page

  @mrc-38
  Scenario: Yes / No is not selected and clicked on continue on associated companies page
    Then user is landed on associated companies page
    And user can see the options yes and No as not selected
    Then the user clicks continue button on associated companies page
    Then the user is displayed with error message "Select whether you have associated companies or not." for associated company

  @mrc-38
  Scenario: Yes selected and clicked on continue on associated companies page
    Then user is landed on associated companies page
    And user can see the options yes and No as not selected
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    Then the user clicks continue button on associated companies page
    Then the user is displayed with error message "Enter the number of associated companies, like 1" for associated company

  @mrc-38 @mrc-130
  Scenario Outline: Associated companies - Error Message validations
    Then user is landed on associated companies page
    And user can see the options yes and No as not selected
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    And user inputs a valid number as "<InvalidAC>" associated companies
    Then the user clicks continue button on associated companies page
    Then the user is displayed with error message "<Error Message>" for associated company

    Examples:
      | InvalidAC | Error Message                                                    |
      | 1.        | The number of associated companies must be a whole number, like 1 |
      | -3        | The number of associated companies must be greater than 0                                  |
      | 1B        | The number of associated companies must be a number, like 1              |
      | 0         | The number of associated companies must be greater than 0                                  |