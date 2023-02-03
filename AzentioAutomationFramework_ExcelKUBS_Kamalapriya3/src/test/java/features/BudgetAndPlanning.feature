Feature: Budget and planning

@KUBS_UAT_KUBS_BP_UAT_004_001
Scenario: Check to cancel the wrongly created budget code
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then Get the data set id for wrongly created budget code
And click on add button to create budget code
Then fill the budget code fields
And choose half yearly option in budget type
And give warning percentages
And enter budget name for Quarterly budgets
Then enter remarks
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module names
Then choose first record in the notification records
And click on Submit button 
Then enter remark in confirmation alerts
Then click on submit button in alerts
And capture the reviewer ID in pop up which is open when we submit our record in maker stages
Then logout from maker
@KUBS_UAT_KUBS_BP_UAT_004_001_02
Scenario: Check to cancel the wrongly created budget code reviewer
Then Choose the dataset id for wrongly created budget code reviewer
And login with reviewers credentials
Then click on notification button
And select our record in notification records using references IDs
Then Approve the record from reviewer
And enter the remark in alerts
Then click on submit in alerts
Then verify the approval status of the record
And logout from reviewer
@KUBS_UAT_KUBS_BP_UAT_004_001_03
Scenario: Check to cancel the wrongly created budget code checker
Then Choose the dataset id for wrongly created budget code reviewer
Then login as a checkers 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference IDs
Then click on Notification button
Then select our record in notification records by the help of reference IDs
And click on approve button in checker stage
Then give alert remarks 
Then click on submit button on alerts
And verify the record got approved from checker
Then logout from checker
@KUBS_UAT_KUBS_BP_UAT_004_001_04
Scenario: Check to cancel the wrongly created budget code list view validation
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then Get the data set id for wrongly created budget code
And get the budget code for allocations
 Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Codes 
  And select the past Budget Years
  Then click on the Branch
  And select FIRST Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for Required Budget types
  And click on the save button
	Then click on the Maker icon buttons
	And Click the Cancel button 
	Then Submit the Cancel Records
	
	@KUBS_UAT_KUBS_BP_UAT_005_001
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then Choose the data set id for branch request to allocate the budget
And click on add button to create budget code
Then enter the budget code  to make current/future financial budgets
And choose yearly option in budget type
And give warning percentages
And enter budget name for yearly budgets
Then enter remarks
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module names
Then choose first record in the notification record to allocate the budget
And click on Submit button 
Then enter remark in confirmation alerts
Then click on submit button in alerts
And capture the reviewer ID in pop up which is open when we submit our record in maker stage to allocate the budget
Then logout from maker
@KUBS_UAT_KUBS_BP_UAT_005_001_02
Scenario: Branch requested to allocate the budget reviewer
Then Choose the data set id for branch request to allocate the budget reviewer
And login with reviewers credentials
Then click on notification button
And select our record in notification records using references IDs
Then Approve the record from reviewer
And enter the remark in alerts
Then click on submit in alerts
Then verify the approval status of the record
And logout from reviewer
@KUBS_UAT_KUBS_BP_UAT_005_001_03
Scenario: Branch requested to allocate the budget checker
Then Choose the data set id for branch request to allocate the budget reviewer
Then login as a checkers 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference IDs
Then click on Notification button
Then select our record in notification records by the help of reference IDs
And click on approve button in checker stage
Then give alert remarks 
Then click on submit button on alerts
And verify the record got approved from checker
Then logout from checker
@KUBS_UAT_KUBS_BP_UAT_005_001_04
Scenario: Branch requested to allocate the budget Maker
Then Choose the data set id for branch request to allocate the budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation to allocate the budget
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Codes 
 	And select the Budget Year
  Then click on the Branch
  And Select the Requested Branch
  Then click on the Branch ok button
  Then select one currency we need
    And Enter the Amount for Required Budget types
    #And Give Branch requested to allocate the budget amount
  And click on the save button
 And click notification button 
Then click on the search button
And serach the budget request and allocation sub module names
Then choose first record in the notification record to allocate the budget
And click on Submit button 
Then enter remark in confirmation alerts
Then click on submit button in alerts
And capture the reviewer ID in pop up which is open when we submit our record in maker stage to allocate the budget
Then logout from maker
@KUBS_UAT_KUBS_BP_UAT_005_001_05
Scenario: Branch requested to allocate the budget reviewer
Then Choose the data set id for branch request to allocate the budget reviewer
And login with reviewers credentials
Then click on notification button
And select our record in notification records using references IDs
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
@KUBS_UAT_KUBS_BP_UAT_005_001_06
Scenario: Branch requested to allocate the budget checker
Then Choose the data set id for branch request to allocate the budget reviewer
Then login as a checkers 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference IDs
Then click on Notification button
Then select our record in notification records by the help of reference IDs
And click on approve button in checker stage
Then give alert remarks 
Then click on submit button on alerts
And verify the record got approved from checker

#Transfer budget
  
  @BudgetTransfer_KUBS_BP_UAT_006_008_UAT
Scenario: Check the functionality if transfering budget does not have sufficeint amount in that quarter
Given navigate to given url and login with maker credentials
And Maker click on  the direction tab
And click on budget main menu
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Get the data set id for transfering the budget
Then fill form and enter excessive budget amount to transfers



@KUBS_BP_UAT_006_009
@MultiAuth
Scenario: Check the transafer once transfer is completed in the report
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click on budget main menu
And click on view button near by budget transfer menu
And get the Transfered from budget codes
And get the Transfered to budget codes
And get the Transfered budget amounts
Then click on report segment button
And click on report main menu
And click on Transfer of budget details list report
And click on date icon
And give date in report
And click on the view button
Then verify the transfered budget and amount is available in the transfered report
  