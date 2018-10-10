@UI
Feature:Valtech Exercrise Validation
  As an Valtech user
  I want explore some pages
  So that validation for Exercrise is captured

  Background: Given user is in Valtech Homepage

  Scenario:1.Validate Recent Blogs
    Given user is in Valtech Homepage
    Then user should get "RECENT BLOGS" in Homepage
    When user clicks blog at position 1
    Then user should get same position 1 Blog as Header

  Scenario Outline:2.Validate Different Navigation Menu
    Given user is in Valtech Homepage
    When user clicks "<menuitem>" in the Navigating menu bar
    Then user should get header as "<menuitem>"

    Examples:
    |menuitem|
    |About|
    |Services|
    |Work|

  Scenario: Validate number of offices
    Given user is in Valtech Homepage
    When user extends url as /about/contact-us
    Then user should get number of offices




