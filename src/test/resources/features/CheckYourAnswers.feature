Feature:Check your answers - Validations

  Background:
    Given Marginal Relief Calculator is launched
    When the user clicks the start now button
    Then the user lands on the accounting period page
    When the accounting period start date is provided as "01/01/2023"
    Then the user clicks the continue button on the accounting period page
    And the profit is "50000"
    Then the user clicks continue button on taxable profit page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    And the user selects option "Yes" for the question Do any distributions need to be included with your profits?
    Then the user is provided with an input field to provide distributions
    And the user provides "£50,000" as distributions
    And the user clicks the continue button on the distributions page
    Then the user lands on the associated companies page
    When the user selects option "yes" for the question Did your company have any active associated companies?
    Then the user is presented with an input field for associated companies
    And the user inputs a valid number as "10" associated companies
    Then the user clicks the continue button on the associated companies page
    Then the user is presented with the Check Your Answers page

  @mrc-39 @mrc-128
  Scenario: Validate all values on check your answers page
    Then the user can validate the accounting period as "1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date."
    Then the user can validate profit as "£50,000"
    Then the user can validate distributions included as "£50,000"
    Then the user can validate associated companies as "10"
    And the user can see the calculate margin relief button enabled


  @mrc-118
  Scenario: Clicking on back button
    When the user clicks the back button
    Then the user lands on the associated companies page

  @mrc-118
  Scenario: Clicking on back button after changing the distributions amount
    Then the user is presented with change link next to the distribution amount
    And the user can validate their distribution amount as "£50,000"
    When the user clicks the change link next to the distribution amount
    Then the user is navigated to the exempt distributions page
    And the user selects option "Yes" for the question Did your company receive any distributions?
    And the user clicks the continue button on the distributions page
    When the user changes the distributions value to "£30,000"
    And the user clicks the continue button on the distributions page
    Then the user is presented with the Check Your Answers page
    And the user can validate their distribution amount as "£30,000"
    When the user clicks the back button
    Then the user lands on the associated companies page

  @mrc-128
  Scenario: Verify message for default accounting period end date
    Then the user can validate the accounting period as "1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date."
    When the user clicks the change link next to the accounting period dates
    Then the user is navigated to the accounting period page
    Then the user can see the accounting end period as "31/12/2023"
    When the accounting period start date is provided as "01/04/2023"
    And the accounting period end date is provided as "31/03/2024"
    Then the user clicks the continue button on the accounting period page
    Then the user is presented with the Check Your Answers page
    And the user can validate their accounting period dates as "1 April 2023 to 31 March 2024"