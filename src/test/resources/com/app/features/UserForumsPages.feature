Feature: Create User Forums functionality

  @ilyarForumsPage
  Scenario: View Forums Page
    Given I logged into tiki-wiki
    When I am on the Home page
    And I click on Forum button
    Then I should see Forum option:
    Then I logout from tiki-wiki
      | List Forums  |
      | Admin Forums |

  Scenario Outline: View List Forums Page
    Given I logged into tiki-wiki
    When I am on the Home page
    Then I create new form with <Name> and <Description>
    And I should see <Name>  with <Description> in blogs list:
    Then I logout from tiki-wiki

    Examples: 
      | Name      | Description  |
      | Hustlers1 | description1 |
      | Hustlers2 | description2 |
