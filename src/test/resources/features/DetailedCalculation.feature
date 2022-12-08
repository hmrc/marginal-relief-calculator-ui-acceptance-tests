Feature:Detailed Calculation - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page

  @mrc-125 @mrc-143
  Scenario: 2 years of accounting period, and 1 year MR is not applicable
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
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£0"
    And the How its calculated section is displayed
    And "Marginal Relief was not available in financial year 2022 to 2023" is displayed on the page
    And the total Marginal relief is "£2,034.25"
    And "5" MR calculation steps are displayed
    And What is the marginal rate fraction link is displayed
    And the Taxable Profit section is displayed

  @mrc-143
  Scenario: Adjusted taxable profits including distributions is greater than the adjusted upper limit for the financial year
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "120000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£10,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then user is presented with input field for associated companies
    And user inputs a valid number as "1" associated companies
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£10,000"
    And the How its calculated section is displayed
    And "Marginal Relief was not available in financial year 2022 to 2023" is displayed on the page
    And the total Marginal relief is "£0"
    And "3" MR calculation steps are displayed
    And the Taxable Profit section is displayed

  @mrc-143
  Scenario: Adjusted taxable profits including distributions is less than the adjusted upper limit for the financial year
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "15000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£7,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£7,000"
    And the How its calculated section is displayed
    And "Marginal Relief was not available in financial year 2022 to 2023" is displayed on the page
    And the total Marginal relief is "£0"
    And "3" MR calculation steps are displayed
    And the Taxable Profit section is displayed

  @mrc-159 @a11y
  Scenario: Display MR detail in tabs
    When the accounting period start date is provided as "01/01/2024"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£0"
    And the How its calculated section is displayed
    And the tabs are displayed
    Then I click on 2025 tab and verify the tab

  @mrc-200 @failed
  Scenario: Back button
    When the accounting period start date is provided as "01/01/2024"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    And the How its calculated section is displayed
    And the tabs are displayed
    Then I click on 2025 tab and verify the tab
    When the user click on back button
    Then the user navigated to back to result page and display the green box of type "£2,752.49"

  @mrc-221
  Scenario: What to do next
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
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    When the user click on Check Marginal Relief calculation in detail link
    Then header displays as "Full Marginal Relief calculation in detail"
    And the Your details page contains "Covers 2 HMRC financial years"
    And the distribution amount has £ prefix and displayed as "£0"
    And the How its calculated section is displayed
    And "What to do next" section is displayed and it contains "Complete your Corporation Tax return"
    And What to do next session contains date 9months after POA end date which is "1 October 2024"


