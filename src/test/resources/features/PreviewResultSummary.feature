Feature:Preview Result Summary  - Validations

  Background:
    Given Marginal Relief Calculator is launched
    And the user clicks the start now button
    And the user lands on the accounting period page

  @mrc-162 @a11y
  Scenario: Preview results summary information before retaining a calculation
    And the accounting period start date is provided as "01/01/2023"
    And the user clicks the continue button on the accounting period page
    And the profit is "70000"
    And the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user lands on the associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks the continue button on the associated companies page
    And the user is presented with the Check Your Answers page
    And the user clicks the calculate marginal relief button on the check your answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user clicks the Get A Copy Of Results link
    And the user selects option as "yes" on add company details page
    And the user clicks the continue button on the company details page
    Then "Print your calculation" should be displayed
    And  "Print your full calculation" link is available
    And marginal results are shown