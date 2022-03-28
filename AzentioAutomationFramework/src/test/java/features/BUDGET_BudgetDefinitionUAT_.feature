Feature: To verify user can able to create and approve the budget records in UAT environment 
@Yearlybudget
@MultiAuth
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

#@KUBS_BP_UAT_001_0052
#@MultiAuth
#Scenario: Create a budget for current financial year
#Given navigate to given url and login with maker credentials
#Then click on budget configuration menu
#Then click on eye icon which is near by budget definition submenu
#And click on add button to create budget code
#Then enter Budget Code for current financial yearly budget
#And choose yearly option in budget type
#And give warning percentage
#And enter budget name for yearly budget
#Then enter remark
#Then click on Save button
#And click notification button
#Then choose first record in the notification record
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#And login with reviewer credentials
#Then click on notification button
#And select our record in notification records using reference ID
#Then verify budget data are matched whic is submited by maker
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#And logout from reviewer
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And validate the record which is submited by maker
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker

#And login with Maker ID
#@budgetcreation2
#Scenario: Test budget creation
#Given navigate to given url and login with maker credentials
#Then click on second Segment button
#And click on budget main menu
#And click on eye icon near by budget request and allocation 
#Then click on add button
#And enter the budget code for current financial year
#And choose the budget year as current financial year
#And choose branch as azentio main
#And enter the budget amount in the appropriate text box along with remark 


@MonthlyBudget
@MultiAuth
Scenario: To verify user can able to create budget code for monthly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for monthly budget
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly Budget
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
@MultiAuth
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
@MultiAuth
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


@KUBS_BP_UAT_006_009
@MultiAuth
Scenario: Check the transafer once transfer is completed in the report
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click on budget main menu 
And click on view button near by budget transfer menu
And get the Transfered from budget code 
And get the Transfered to budget code
And get the Transfered budget amount
Then click on report segment button
And click on report main menu
And click on Transfer of budget details list report
And click on date icon
And give date in report
And click on the view button
Then verify the transfered budget and amount is available in the transfered report



