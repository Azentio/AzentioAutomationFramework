Feature: Reviewer login
@Reviewer
Scenario: After Budget creation login into Reviewer
Given Navigate to Url and login as a Checker
Then Click on Notification button
And Find the budget code which submitted from maker
Then Click on action button
And Approve the record