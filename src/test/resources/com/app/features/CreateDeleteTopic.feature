@Regression @topic
Feature: create and delete topics

  @aslan
  Scenario Outline: article without topic
    Given I logged into tiki-wiki
    When I create topic "<topic>"
    Then "<topic>" topic must be in topic list
    Then I logout from tiki-wiki

    Examples: 
      | topic    |
      | bublik   |
      | morkovka |

  Scenario Outline: article with title
    Given I logged into tiki-wiki
    When I create topic "<topic>"
    Then "<topic>" must be in articles topic list
    Then I logout from tiki-wiki

    Examples: 
      | topic |
      | sam   |
      | bam   |
      | lam   |
