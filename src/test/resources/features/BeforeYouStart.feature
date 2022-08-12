Feature: Before you start page - Validations

  @mrc-82 @mrc-132
  Scenario: Validating before you start page validations
    Given Marginal Relief Calculator is launched
    When I am landed on before you start page
    Then I can see the breadcrumbs on the page
    And I can verify that Welsh language is not displayed
    Then I can verify the link present on screen
      | Marginal Relief for Corporation Tax guidance |
      | Corporation Tax guidance                     |
      | Corporation Tax rates and reliefs            |
      | distributions                                |
      | associated company                           |
    When the user clicks on start now button
    Then the user lands on accounting period page