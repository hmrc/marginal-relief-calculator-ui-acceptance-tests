Feature:Preview Result Summary  - Validations

  Background:
    Given Marginal Relief Calculator is launched
    And the user clicks on start now button
    And the user lands on accounting period page

  @mrc-162
  Scenario: Preview results summary information before retaining a calculation
    And the accounting period start date is provided as "01/01/2023"
    And the user clicks continue button on accounting period page
    And the profit is "70000"
    And the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user clicks on Print or save your calculation link
    And the user clicks continue button on company details page
    Then "Save or print your calculation" should be displayed
    And  "Print this page" link is available
    And marginal results are shown


