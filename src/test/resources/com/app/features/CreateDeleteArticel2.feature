@Regression @article
Feature: create article with geading and body


  Scenario Outline: 
    Given I logged into tiki-wiki
    When I create article "<title>" write "<heading>" in bold text format
    Then "<title>" articles  body bust be bold text format
    Then I logout from tiki-wiki

    Examples: 
      | title    | heading          |
      | custome1 | __heading1__     |
      | custome2 | __testHeading1__ |
  @aslan
  Scenario Outline: write content
    Given I logged into tiki-wiki
    When I create  article with "<title>" "<body>" and "<Heading>"
    Then I verify  article "<title>" has "<body>" and "<Heading>" content
    Then I logout from tiki-wiki

    Examples: 
      | title     | Heading      | body      |
      | custome11 | testHeading1 | myText    |
      | custome22 | testHeading1 | otherText |
