@now
Feature: Associated companies Title Message - Validations

  Background:
    Given Marginal Relief Calculator is launched
    And the user clicks on start now button
    And the user lands on accounting period page
    When the accounting period start date is provided as "01/01/2027"
    And the accounting period end date is provided as "31/12/2027"
    And the user clicks continue button on accounting period page
    And the profit is "50000"
    And the user clicks continue button on taxable profit page
    And the user selects option "yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    And the user provides "£2000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    And display the "Did your company have any active associated companies?" on associated company
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    And display the "How many active associated companies did you have?" on associated company

  @mrc-196
  Scenario:Verify 2 associated companies on check your answers page
    When the user inputs "2" as associated companies for first part of accounting period
    When the user inputs "3" as associated companies for second part of accounting period
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    Then I can validate associated companies for first part of financial year as "2"
    Then I can validate associated companies for second part of financial year as "3"

  @mrc-196
  Scenario:Verify 2 associated companies on results page
    When the user inputs "1" as associated companies for first part of accounting period
    When the user inputs "3" as associated companies for second part of accounting period
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    Then I can validate associated companies for first part of financial year as "1"
    Then I can validate associated companies for second part of financial year as "3"
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£612.07"
    And I can validate the associated companies on results page as "2026 to 2027: 1"
    And I can validate the associated companies on results page as "2027 to 2028: 3"

  @mrc-196
  Scenario:Verify 2 associated companies on detailed calculation page
    When the user inputs "1" as associated companies for first part of accounting period
    When the user inputs "3" as associated companies for second part of accounting period
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    Then I can validate associated companies for first part of financial year as "1"
    Then I can validate associated companies for second part of financial year as "3"
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£612.07"
    And I can validate the associated companies on results page as "2026 to 2027: 1"
    And I can validate the associated companies on results page as "2027 to 2028: 3"
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then I can validate the associated companies on detailed calculation page as "2026 to 2027: 1"
    And I can validate the associated companies on detailed calculation page as "2027 to 2028: 3"

  @mrc-196
  Scenario:Verify 2 associated companies on PDF page
    When the user inputs "1" as associated companies for first part of accounting period
    When the user inputs "3" as associated companies for second part of accounting period
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    Then I can validate associated companies for first part of financial year as "1"
    Then I can validate associated companies for second part of financial year as "3"
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£612.07"
    And I can validate the associated companies on results page as "2026 to 2027: 1"
    And I can validate the associated companies on results page as "2027 to 2028: 3"
    And the user clicks on Get A Copy Of Results your calculation link
    Then the user is presented with add company details to your result page
    And the user selects option as "no" on add company details page
    Then I can validate the associated companies on PDF page as "2026 to 2027: 1"
    And I can validate the associated companies on PDF page as "2027 to 2028: 3"
