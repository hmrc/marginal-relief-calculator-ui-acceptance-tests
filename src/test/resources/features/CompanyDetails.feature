Feature:Company Details  - Validations

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
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    And the Check Marginal Relief calculation in detail link is displayed
    And the user clicks on Print or save your calculation link

  @mrc-146
  Scenario Outline: Company Details- Character limit on Company Name
    When the user provides a "<longCompanyName>" on Company name field
    And the user clicks continue button on company details page
    Then an "<errorMessage>" is displayed
    Examples:
      | longCompanyName                                                                                                                                                      | errorMessage                                |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt labore et dolore magna aliqua.Ut enim ad minim, quis nostrud exercitation. | Company name must be 160 characters or less |


  @mrc-146
  Scenario Outline: Company Details- Character limit on UTR Number
    When the user provides a "<longUTRNumber>" on UTR number field
    And the user clicks continue button on company details page
    Then an "<errorMessage>" is displayed
    Examples:
      | longUTRNumber    | errorMessage                             |
      | 9876543210123456 | UTR number must be 15 characters or less |

  @mrc-146
  Scenario Outline: Company Details- Valid Scenario
    When the user provides a "<validCompanyName>" on Company name field
    And the user provides a "<validUTRNumber>" on UTR number field
    And the user clicks continue button on company details page
    Then I verify same name is displayed on Preview summary page
    Examples:
      | validCompanyName  | validUTRNumber |
      | Test-Company name | 987654321      |
