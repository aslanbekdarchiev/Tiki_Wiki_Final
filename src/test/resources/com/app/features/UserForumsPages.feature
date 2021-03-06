Feature: Create User Forums functionality

  @ilyarForumsPage
  Scenario: View Forums Page
    Given I logged into tiki-wiki
    When I am on the Home page
    And I click on Forum button
    Then I should see Forum option:
      | List Forums  |
      | Admin Forums |
  
  @ilyarForumsPage
  Scenario Outline: View List Forums Page
    Given I logged into tiki-wiki
    When I am on the Home page
    And I click on Forum button
    Then I create new form with "<Name>" and "<Description>"
    And I should see "<Name>"  with "<Description>" in blogs list:

    Examples: 
      | Name      | Description  |
      | Hustlers1 | description1 |
      | Hustlers2 | description2 |
      | Hustlers3 | description3 |
