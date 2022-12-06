Feature: To verify budget request and allocation modules ae working fine
@AllocationBudgetForCurrentFinancialYear
Scenario: To verify user can able to create budget for current financial year
Given navigate to given url and login with maker credentials
And click on second segment button
Then click on budget menu
And click on eye icon near by budget request and allocation 
Then click on add button
And choose yearly budget code
Then choose current financial year
And choose branch
Then enter the amount in the appropriate box
And give remark in nearby amount text box 
Then choose the currency type
And Click on save button
And Click on notification button
When click on first notification records are appear in that list
Then Click on Submit button
And enter the remark in Alert 
Then click on submit button appear in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then click on logout from maker
And login with reviewer ID
Then click on notification button
And select our record in notification records using reference ID
Then Approve the budget record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our budget record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
