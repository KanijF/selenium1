Feature:Verify Demoqa checkboxes

  Scenario: User should be able to expand all checkbox options and select public and private
    Given I navigate to "https://demoqa.com/checkbox"
    When I expand all checkboxes
    And I click on public and private
    Then I should see a text called "You have selected : public private"
    And I quit the browser

