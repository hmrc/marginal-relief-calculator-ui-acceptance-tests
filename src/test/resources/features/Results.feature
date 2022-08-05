Feature:Results - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks on start now button
    Then the user lands on accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks continue button on accounting period page

  @mrc-41
  Scenario: Your taxable profits are above the Marginal Relief limit
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
  Scenario: Your taxable profits and included distributions are above the Marginal Relief limit
    When the profit is "45000"
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
    Then user is presented with Check Your Answers page
    And the user clicks on calculate marginal relief button on check you answers page
    Then display the green box of type "£1,929.93"