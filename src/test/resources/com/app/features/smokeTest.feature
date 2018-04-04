Feature: Smoke Test

  @smokeTest
  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I see Menu options
    And I create wiki page "Continuos Integration"
    Then Wiki Page " Continuous Integration "is listed in List Pages
    Then I logout from tiki-wiki

  @smokeTest
  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I see Menu options
    And I go to Wiki
    And I edit the page
    Then I am able to see Last Changes of all pages
    Then I logout from tiki-wiki

  @smokeTest
  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I see Menu options
    And I go to Wiki
    And I go to List Wiki Pages
    Then I should  be able to search for pages
    And number of available pages should be same as number of displayed rows
    Then I logout from tiki-wiki

  @smokeTest
  Scenario: article without title
    Given I logged into tiki-wiki
    When I create article without content
    Then "No title specified" article must be in articles list
    And I delete "No title specified" article
    Then "No title specified" must not be in article list
    Then I logout from tiki-wiki

  Scenario Outline: article with title
    Given I logged into tiki-wiki
    When I create article with <title> title
    Then <title> article must be in articles list
    And I delete <title> article
    Then <title> must not be in article list
    Then I logout from tiki-wiki

    Examples: 
      | <title>  |
      | bublik   |
      | morkovka |
      | rediska  |
