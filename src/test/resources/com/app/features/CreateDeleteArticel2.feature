@Regression @article
Feature: create article with geading and body

  Scenario: 
    Given I logged into tiki-wiki
    When I create article <title> write <body> in bold text format
    Then articles  content bust be bold text format
    And I delete <title> article
    Then <title> must not be in article list
    Then I logout from tiki-wiki

  Scenario Outline: write content
    Given I logged into tiki-wiki
    When I create  article with <body> and <Heading> <title>
    Then I verify  article  <title> has <body> and <Heading> content
    And I delete <title> article
    Then <title> must not be in article list
    Then I logout from tiki-wiki

    Examples: 
      | title    | Heading       | body       |
      | custome1 | test heading1 | my text    |
      | custome2 | test heading1 | other text |
     
