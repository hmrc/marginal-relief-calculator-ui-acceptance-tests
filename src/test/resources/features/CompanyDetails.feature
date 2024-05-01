Feature:Company Details  - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks the continue button on the accounting period page
    And the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page
    And the user clicks the calculate marginal relief button on the check your answers page
    And the Check Marginal Relief calculation in detail link is displayed
    And the user clicks the Get A Copy Of Results link
    Then the user is presented with add company details to your result page
    And the user selects option as "yes" on add company details page

  @mrc-146 @mrc-257 @a11y
  Scenario Outline: Company Details- Valid Scenario
    Then the user lands on AddCompanyDetails page
    When the user provides a "<validCompanyName>" on Company name field
    And the user provides a "<validUTRNumber>" on UTR number field
    And the user clicks the continue button on the company details page
    Then the user verifies the same name is displayed on the Preview summary page
    Examples:
      | validCompanyName  | validUTRNumber |
      | Test-Company name | 0987654321     |
