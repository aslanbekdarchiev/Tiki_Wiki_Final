Feature: Creating Wiki Pages

  @aika
  Scenario: Creating a Wiki Page
    Given I logged into tiki-wiki
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
      | Surveys        |
      | Newsletters    |
      | Settings       |
    And I create wiki page "Continuos Integration"
    Then Wiki Page " Continuous Integration "is listed in List Pages
    Then I log out from application
@aika
  Scenario: Editing a  Wiki Page
    Given I logged into tiki-wiki
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
      | Surveys        |
      | Newsletters    |
      | Settings       |
    And I edit the page called "Continuos Integration"
    Then I am able to see Last Changes of this pages
    Then I log out from application
@aika
  Scenario: Searching  for a Wiki Page
    Given I logged into tiki-wiki
    And I go to List Pages
    Then I should  be able to search for "Continuos Integration" page
    And the resulf of my search is the "Continuos Integration" page
    Then I log out from application
