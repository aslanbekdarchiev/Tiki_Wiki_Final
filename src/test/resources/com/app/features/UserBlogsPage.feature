Feature: Create User Blogs functionality

  @ilyarBlogsPage @aika
  Scenario: View Blog Page
    Given I logged into tiki-wiki
    When I am on the Home page
    And I click on Blogs button
    Then I should see Pages option:
    Then I logout from tiki-wiki
      | List Blogs     |
      | Create Blog    |
      | New Blog Post  |
      | List Blog Post |

  Scenario Outline: List Blogs Page
    Given I logged into tiki-wiki
    When I am on the Home page
    Then I create new blog with <Title> and <Description>
    And I should see <Title>  with <Description> in blogs list
    Then I logout from tiki-wiki

    Examples: 
      | Title  | Description  |
      | title1 | description1 |
      | title2 | description2 |
