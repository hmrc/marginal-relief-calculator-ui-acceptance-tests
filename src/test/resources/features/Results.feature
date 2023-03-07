Feature:Results - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page

  @mrc-41
  Scenario: Your taxable profits are above the Marginal Relief limit
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "260000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "Your taxable profits are above the Marginal Relief limit"

  @mrc-41
  Scenario: Your taxable profits and included distributions are above the Marginal Relief limit
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "260000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£5,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "Your taxable profits and included distributions are above the Marginal Relief limit"

  @mrc-41
  Scenario: Your taxable profits are below the Marginal Relief limit
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "45000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "Your taxable profits are below the Marginal Relief limit"

  @mrc-41
  Scenario: Your taxable profits and included distributions are below the Marginal Relief limit
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "44500"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£5,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "Your taxable profits and included distributions are below the Marginal Relief limit"

  @mrc-41
  Scenario: Your taxable profits and included distributions are above the Marginal Relief limit
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "60000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with input field to provide distributions
    And the user provides "£5,000" as distributions
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£1,922.80"

  @mrc-126 @mrc-42
  Scenario: CT liability payable- MRC Dual year
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£2,026.53"
    Then the corporation tax liability heading is displayed as "£14,437.85"
    Then the accounting period covering 2 years section is displayed
    And the corporation tax liability body is displayed as "Reduced from £16,464.38 after £2,026.53 Marginal Relief" for dual year
    And the dual year corporation tax liability table is displayed

  @mrc-42
  Scenario: CT liability payable- MRC Single year
    When the accounting period start date is provided as "01/06/2023"
    And the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£1,142.62"
    And the corporation tax liability heading is displayed as "£16,357.38"
    And the corporation tax liability body is displayed as "Reduced from £17,500 after £1,142.62 Marginal Relief" for single year
    And the single year corporation tax liability table is displayed

  @mrc-42
  Scenario: CT liability payable- No MRC
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "45000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "No" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    Then user is landed on associated companies page
    When the user selects option "no" for the question Did your company have any active associated companies?
    Then the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "Your taxable profits are below the Marginal Relief limit"
    And the corporation tax liability heading is displayed as "£8,550"
    And the corporation tax liability body is not displayed
    And the NO MRC dual year corporation tax liability table is displayed

  @mrc-40 @a11y
  Scenario: Effective tax rate- MRC Dual year
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    And the effective tax rate heading is displayed as "20.63%"
    And the effective tax body is displayed as "Reduced from 23.52% after Marginal Relief" for dual year
    And the dual year effective tax table is displayed

  @mrc-40
  Scenario: Effective tax rate- MRC Single year
    When the accounting period start date is provided as "01/06/2023"
    When the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "70000"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    And the effective tax rate heading is displayed as "23.37%"
    And the effective tax body is displayed as "Reduced from 25% after Marginal Relief" for single year
    And the single year effective tax table is displayed

  @mrc-40
  Scenario: Effective tax rate- NO MRC Dual year
    When the accounting period start date is provided as "01/01/2023"
    When the accounting period end date is provided as "31/12/2023"
    Then the user clicks continue button on accounting period page
    When the profit is "37000"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    And the effective tax rate heading is displayed as "19%"
    And the NO MRC effective tax table is displayed

  @mrc-40
  Scenario: Effective tax rate- Small profit rate
    When the accounting period start date is provided as "01/01/2024"
    Then the user clicks continue button on accounting period page
    When the profit is "25000"
    And the user clicks continue button on taxable profit page
    And the user selects option "no" for the question Did your company receive any distributions?
    And the user clicks continue button on distributions page
    And user is landed on associated companies page
    And the user selects option "no" for the question Did your company have any active associated companies?
    And the user clicks continue button on associated companies page
    And the user clicks on calculate marginal relief button on check you answers page
    And the effective tax rate heading is displayed as "19%"
    And the "Small profit rate" effective tax table is displayed


