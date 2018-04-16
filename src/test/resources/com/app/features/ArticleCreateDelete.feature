@Regression @article   @aslan
Feature: create and delete article

@aika
  Scenario Outline: article without title
    Given I logged into tiki-wiki
    When I create article without content
    Then <title> article must be in articles list
    And I delete <title> article
    Then <title> must not be in article list
    Then I logout from tiki-wiki

    Examples: 
      | title              |
      | No title specified |

  Scenario Outline: article with title
    Given I logged into tiki-wiki
    When I create article with <title> title
    Then <title> article must be in articles list
    And I delete <title> article
    Then <title> must not be in article list
    Then I logout from tiki-wiki

    Examples: 
      | title    |
      | bublik   |
      | morkovka |
      | rediska  |
