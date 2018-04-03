@Regression @article
Feature: create and delete article

  Scenario: article without title
    Given I logged into tiki-wiki
    When I create article without content
    Then "No title specified" article must be in articles list
    And I delete "No title specified" article
    Then "No title specified" must not be in article list

  Scenario Outline: article with title
    Given I logged into tiki-wiki
    When I create article with <title> title
    Then <title> article must be in articles list
    And I delete <title> article
    Then <title> must not be in article list

    Examples: 
      | <title>  |
      | bublik   |
      | morkovka |
      | rediska  |
