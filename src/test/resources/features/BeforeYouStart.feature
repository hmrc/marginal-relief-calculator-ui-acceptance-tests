Feature: Before you start page - Validations

  @mrc-82 @mrc-132
  Scenario: Validating before you start page validations
    Given Marginal Relief Calculator is launched
    When the user lands on the before you start page
    Then the user can see the breadcrumbs on the page
    And the user can verify that Welsh language is not displayed
    Then the user can verify the link present on screen
      | Marginal Relief for Corporation Tax guidance |
      | Corporation Tax guidance                     |
      | Corporation Tax rates and reliefs            |
      | distributions                                |
      | associated company                           |
    When the user clicks the start now button
    Then the user lands on the accounting period page