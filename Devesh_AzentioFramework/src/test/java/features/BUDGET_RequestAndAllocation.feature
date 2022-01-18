Feature: Checking the Budgetandrequest allocation functionality

@Budgetandallocation
  Scenario: Check the functionality
    Given Open Azentio login
    And Click the Dirction icon
    When Select the budget Field
    And Click the Budget request & allocation Eye icon
    And Curser click the add icon
    And Select budget code
    And Select budget year
    And Select budget branch
    Then Enter budget amount
    And Select currency
    And Click the save button
    And Click the action button in table
    And Submit the record
    

