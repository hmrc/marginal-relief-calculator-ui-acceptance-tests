@ignore
Feature: 2 Associated companies - Validations on different pages

  Background:
    Given Marginal Relief Calculator is launched
    And the user clicks the start now button
    And the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2027"
    And the accounting period end date is provided as "31/12/2027"
    And the user clicks the continue button on the accounting period page
    And the profit is "50000"
    And the user clicks continue button on taxable profit page
    And the user selects option "yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    And the user provides "£2000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    And display the "Did your company have any active associated companies?" on associated company
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user clicks the continue button on the associated companies page
    And display the "How many active associated companies did you have?" on associated company

  @mrc-196
  Scenario:Verify 2 associated companies on check your answers page
    When the user inputs "2" associated companies for the first part of accounting period
    When the user inputs "3" associated companies for the second part of accounting period
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    Then the user validates associated companies for the first part of financial year as "2"
    Then the user validates associated companies for the second part of financial year as "3"

  @mrc-196
  Scenario:Verify 2 associated companies on results page
    When the user inputs "1" associated companies for the first part of accounting period
    When the user inputs "3" associated companies for the second part of accounting period
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    Then the user validates associated companies for the first part of financial year as "1"
    Then the user validates associated companies for the second part of financial year as "3"
    And the user clicks the calculate marginal relief button on the check your answers page
    Then display the green box of type "£612.07"
    And the user validates the associated companies on the results page as "2026 to 2027: 1"
    And the user validates the associated companies on the results page as "2027 to 2028: 3"

  @mrc-196
  Scenario:Verify 2 associated companies on detailed calculation page
    When the user inputs "1" associated companies for the first part of accounting period
    When the user inputs "3" associated companies for the second part of accounting period
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    Then the user validates associated companies for the first part of financial year as "1"
    Then the user validates associated companies for the second part of financial year as "3"
    And the user clicks the calculate marginal relief button on the check your answers page
    Then display the green box of type "£612.07"
    And the user validates the associated companies on the results page as "2026 to 2027: 1"
    And the user validates the associated companies on the results page as "2027 to 2028: 3"
    And the Check Marginal Relief calculation in detail link is displayed
    When the user clicks the Check Marginal Relief calculation in detail link
    Then the user validates the associated companies on the detailed calculation page as "2026 to 2027: 1"
    And the user validates the associated companies on the detailed calculation page as "2027 to 2028: 3"

  @mrc-196
  Scenario:Verify 2 associated companies on PDF page
    When the user inputs "1" associated companies for the first part of accounting period
    When the user inputs "3" associated companies for the second part of accounting period
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    Then the user validates associated companies for the first part of financial year as "1"
    Then the user validates associated companies for the second part of financial year as "3"
    And the user clicks the calculate marginal relief button on the check your answers page
    Then display the green box of type "£612.07"
    And the user validates the associated companies on the results page as "2026 to 2027: 1"
    And the user validates the associated companies on the results page as "2027 to 2028: 3"
    And the user clicks the Get A Copy Of Results link
    Then the user is presented with add company details to your result page
    And the user selects option as "no" on add company details page
    Then the user validates the associated companies on the PDF page as "2026 to 2027: 1"
    And the user validates the associated companies on the PDF page as "2027 to 2028: 3"
