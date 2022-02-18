Feature: To check BudgetDefinition moduel feature
Scenario: To verify maker can able to create budget code
Given navigate to URL and login as a maker and choose finance option
And click on budgetConfiguration
Then cick on action button
And Find the budet code in the list
Then verify system should display the status of the record
And verify system should display the name or id who created the record
And verify system should display record created date
And verify system should display the name or id who made changes the record at last
And verify system should display record modified date
Then verify system should display name or id of the authorized person of that record
And verify system should diplay the authorized date 