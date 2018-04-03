Feature: Tiki-Wiki menu options

  Scenario: Verify Recent Preferences menu options
    Given I logged into tiki-wiki
    When I hover over the clock icon
    Then following options should be visible for Recent Preferences:
      | wikiHomePage                   |
      | sitetitle                      |
      | browsertitle                   |
      | tiki version check frequency   |
      | wikiplugin banner              |
      | search index outdated          |
      | sitesubtitle                   |
      | theme admin                    |
      | theme                          |
      | flaggedrev approval categories |

  Scenario: Verify Quick Administration menu options
    Given I logged into tiki-wiki
    When I hover over the angle-down icon
    Then following options should be visible for Quick Administration:
      | Wizards              |
      | Control panels       |
      | Themes               |
      | Users                |
      | Groups               |
      | Permissions          |
      | Menus                |
      | Clear all caches     |
      | Rebuild search index |
      | Plugin approval      |
      | Logs                 |
      | Modules              |
      | Scheduler            |
