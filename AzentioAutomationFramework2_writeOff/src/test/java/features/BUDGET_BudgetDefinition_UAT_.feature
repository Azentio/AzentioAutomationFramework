Feature: To verify user can able to create and approve the budget records in UAT environment 
@Yearly_budget
Scenario: To verify user can able to create budget code for yearly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for yearly budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
@MonthlyBudget
Scenario: To verify user can able to create budget code for monthly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for monthly budget
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
@QuarterlyBudget
Scenario: To verify user can able to create budget code for Quarterly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code quarterly budget
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker

@HalfYearlyBudget
Scenario: To verify user can able to create budget code for Half yearly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for half yearly budget
And choose half yearly option in budget type
And give warning percentage
And enter budget name for half yearly
Then enter remark
Then click on Save button
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker


