Feature:Detailed Calculation - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page

  @mrc-125
  Scenario: View your details (on full MR calculation page)
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£0"