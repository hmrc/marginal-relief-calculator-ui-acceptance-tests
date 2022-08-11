Feature:Edit Associated Companies - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    And the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "Yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    And user inputs a valid number as "25" associated companies
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page

  @mrc-45
  Scenario: Edit Associated Companies
    And I am presented with change link next to the associated companies
    Then I can validate the associated companies as "25"
    And I click on change link next to the associated companies
    And user is landed on associated companies page
    And I validate associated companies is pre-populated as "25"
    And user inputs a valid number as "50" associated companies
    Then the user clicks continue button on associated companies page
    And user is presented with Check Your Answers page
    And I can validate the associated companies as "50"

  @mrc-45
  Scenario Outline: Edit Associated Companies-Invalid Associated Companies
    And I am presented with change link next to the associated companies
    Then I can validate the associated companies as "25"
    And I click on change link next to the associated companies
    And user is landed on associated companies page
    And I validate associated companies is pre-populated as "25"
    And user inputs a valid number as "500" associated companies
    Then the user clicks continue button on associated companies page
    Then the user is displayed with error message "<ErrorMessage>" for associated company
    Examples:
      | ErrorMessage                             |
      | Enter a number lower than or equal to 99 |


