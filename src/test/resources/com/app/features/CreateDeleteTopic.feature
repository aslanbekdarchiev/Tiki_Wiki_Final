@Regression @topic
Feature: create and delete topics

  Scenario: article without topic
    Given I logged into tiki-wiki
    When I create topic named "custom"
    Then "custom" topic must be in topic list
    And I create article with "custom" topic
    Then I logout from tiki-wiki

  Scenario Outline: article with title
    Given I logged into tiki-wiki
    When I create article with <topic> title
    Then <topic> article must be in articles list
    And I delete <topic> article
    Then <topic> must not be in article list
    Then I logout from tiki-wiki

    Examples: 
      | <topic>  |
      | bublik   |
      | morkovka |
      | rediska  |