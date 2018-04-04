Feature: Creating Wiki Pages

  @aika
  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I go to 
    And I should see Menu options:
      | Home           |
      | Search         |
      | Categories     |
      | Tags           |
      | Calendar       |
      | Wiki           |
      | Articles       |
      | Blogs          |
      | Forums         |
      | File Galleries |
      | Spreadsheets   |
      | Trackers       |
      | Surverys       |
      | Newsletters    |
      | Settings       |
    And I create wiki page "Continuos Integration"
    Then Wiki Page " Continuous Integration "is listed in List Pages

  
  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I see Menu options
    And I go to Wiki
    And I edit the page
    Then I am able to see Last Changes of all pages

  Scenario: Wiki Page
    Given I logged into tiki-wiki
    And I see Menu options
    And I go to Wiki
    And I go to List Wiki Pages
    Then I should  be able to search for pages
    And number of available pages should be same as number of displayed rows
