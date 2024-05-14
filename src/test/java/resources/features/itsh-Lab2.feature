Feature: Lab2 iths Web
  Detta är för att bli godkänd på Labration 2

  Background:
    Given Iths WebPage is availible

  Scenario: Iths Web StartPage should show correct title
    Then the title should be "IT-Högskolan – Här startar din IT-karriär!"

  Scenario: Iths start page should show three location buttons
    Then start page should show three buttons with text "ALLA UTBILDNINGAR", "GÖTEBORG" och "STOCKHOLM"

  Scenario: Common questions should have a heading "Vanlig frågor"
    When user clicks Common questions button in header
    Then user should see a heading "Vanliga frågor"

  Scenario: Numbers of all employees
    When user clicks about us button in header
    And user clicks show "Alla" employees
    Then it should be 28 employees in "Alla"

  Scenario: Numbers of Stockholm employees
    When user clicks about us button in header
    And user clicks show "Stockholm" employees
    Then it should be 16 employees in "Stockholm"

  Scenario: Numbers of Göteborg employees
    When user clicks about us button in header
    And user clicks show "Göteborg" employees
    Then it should be 14 employees in "Göteborg"

  Scenario: clicking logo in header user returns to start page
    When user clicks Common questions button in header
    And user clicks on iths logo in header
    Then the title should be "IT-Högskolan – Här startar din IT-karriär!"

  Scenario: clicking hem on breadcrumbs gets user to start page
    When user clicks Common questions button in header
    And user clicks on Hem in breadcrumbs
    Then the title should be "IT-Högskolan – Här startar din IT-karriär!"

  Scenario: current page is shown in breadcrumbs
    When user clicks Common questions button in header
    Then the last breadcrumbs should be "Vanliga frågor"

  Scenario: user should see heading with text
    When user clicks openHouse button in header
    Then user should see a heading "Välkommen till vårens informationsträffar"

  Scenario: this is a successful test
    Then it will be successful