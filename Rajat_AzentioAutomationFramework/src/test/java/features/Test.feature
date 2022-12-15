Feature: Test file steps
 @SupplementaryBudget_KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.

 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT


@SupplementaryBudget_KUBS_BP_UAT_005_004
Scenario: System should able to approve the supplimentary requested budget

 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 
 And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
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
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker

@SupplementaryBudget_KUBS_BP_UAT_005_005
Scenario: Check System should able to Reject the supplimentary requested budget
	 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker
Then click on open pool UAT
And Verify for claming the record UAT
Then User should click on notification icon on reviewer2 home page UAT
Then Claim and reject the record UAT
 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
@SupplementaryBudget_KUBS_BP_UAT_005_006
Scenario: Check if supplimentary budget rejected from HO, the requested amount can not be used
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker
Then click on open pool UAT
And Verify for claming the record UAT
Then User should click on notification icon on reviewer2 home page UAT
Then Claim and reject the record UAT 
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And navigate to search icon and  fill the required field


@SupplementaryBudget_KUBS_BP_UAT_005_003
Scenario: System should allow to modify the supplimentary request budget before approval
 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then Select the Supplementary record from notification
 Then fill apportion amount and save the record UAT
 
 @SupplementaryBudget_KUBS_BP_UAT_005_007
Scenario: Check the supplementary budget request in the report
Given maker should navigate to the url and login with valid credentials UAT
Then click on report segment button
Then Click on Report field
Then click on supplementary budget Report
Then Select the date
And click on view button of report
Then verify the Supplementary Budget report