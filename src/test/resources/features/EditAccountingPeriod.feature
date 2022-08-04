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

  @mrc-115
  Scenario: Edit Accounting Period
    Then I am presented with change link next to the accounting period dates
    And I can validate my accounting period dates as "1 Apr 2023 to 31 Mar 2024"
    When I click on change link next to the accounting period dates
    Then I am navigated to accounting period page
    Then the user can see the accounting end period as "31/03/2024"
    When the accounting period start date is provided as "01/01/2023"
    And the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And I can validate my accounting period dates as "1 Jan 2023 to 31 Dec 2023"

  @mrc-115
  Scenario Outline: Edit Accounting Period-Invalid end date
    Then I am presented with change link next to the accounting period dates
    And I can validate my accounting period dates as "1 Apr 2023 to 31 Mar 2024"
    When I click on change link next to the accounting period dates
    Then I am navigated to accounting period page
    Then the user can see the accounting end period as "31/03/2024"
    When the accounting period start date is provided as "01/01/2023"
    And the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And I can validate my accounting period dates as "1 Jan 2023 to 31 Dec 2023"
    When I click on change link next to the accounting period dates
    When the accounting period start date is provided as "31/03/2024"
    And the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    Then the user is displayed with error message "<errorMessage>" for accounting period
    Examples:
    |errorMessage|
    | The accounting period End date must be less than or equal to a full calendar year from the Start date |
