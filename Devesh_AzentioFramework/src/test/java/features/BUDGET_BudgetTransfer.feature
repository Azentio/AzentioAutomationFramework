Feature: Budget Transfer
  
  @BP_BT_01_01 @Autoauth
  Scenario: To verify the impact if checker1 user select, view and approve the Budget Transfer record submitted by maker user
  	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then verify the respective fields are on transfer budget screen
   	And maker user should logout
  
  # We can only raise budget transfer request.
  @BP_BT_01_06 @Autoauth
 	Scenario: To verify user is able to raise request for both budget transfer and Supplementary request.
 		Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and approve by maker to transfer
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field for supplementary budget type
   	And maker user should logout
   	
  @BP_BT_05_03 @Multiauth
  Scenario: To verify the impact if checker1 user select, view and approve the Budget Transfer record submitted by maker user
  	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
 		And reviewer user logout
  	
  @BP_BT_05_06 @Multiauth
  Scenario: To verify the impact if checker2 user select, view and approve the Budget Transfer record by maker
  					user and approved by checker1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
    Then checker should approved the record
    And system should show the prompt message for verification
    Then the record gets added into the system
    And checker user logout
    
  @BP_BT_05_07 @Multiauth
  Scenario: To verify the impact if checker2 user select, view and reject the Budget Transfer record details by maker
  					user and approved by checker 1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And Click  on action button of record user want to reject
   	Then Click  on reject button
   	And system should show the prompt message for verification
   	And checker user logout
    
  @BP_BT_10_01 @Multiauth
  Scenario: Budget Transfer with multi auth with Return Functionality from checker2 to checker1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And validate the data sent by checker1 submitted by maker
  	Then checker2 should return the record
  	And system should show the prompt message for verification
 		And checker user logout
    
  @BP_BT_10_02 @Multiauth
  Scenario: Budget Transfer with multi auth with Return Functionality from checker1 to maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
    Then reviewer should return the record
  	And system should show the prompt message for verification
 		And reviewer user logout

#-----------------Tushar feature files----------------//

# Common feature file statements.
#Scenario: 
#Given Maker login
#And Maker click on  the direction tab
#Then Maker click on the budget
#Then Maker click on  budget transfer eye button
#And Maker click on add button
#Then Maker fill the details and save
#Then Maker  click on the notification icon
#Then Maker submit the budget transfer record 

@Budget_BudgetTransfer_BP_BT_05_02
Scenario: BP_BT_05_02 To verify system generates notification at checker1 login 
if maker user creates Budget Transfer record and submit the record to checker
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 

Then Navigate to Url and login as a reviewer
When Click on Notification button
And Find the budget code which submitted from maker user
Then Click on action button
And Verify the record

@Budget_BudgetTransfer_BP_BT_05_04
Scenario: To verify the impact if checker1 user select, view and reject the Budget Transfer record submitted by maker user
 BP_BT_05_04 when user reject the record submitted by maker
 Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
 
Then Navigate to Url and login as a reviewer1
When Click on Notification button on reviewer1 home page
And Find the budget code which submitted from maker end
Then Click on action button on reviewer1 notification page
And Reject the record
Then Enter the remark
And Click on submit button

@Budget_BudgetTransfer_BP_BT_05_05

Scenario: System should display notification to checker2 user for approving/rejecting the task or record
 BP_BT_05_05 To verify system generates notification at checker2 login if maker user creates Budget Transfer record and approved by checker1
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
Then user login to checker1
And click on notification icon

And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Verify the clamed record is showing or not

#------------------remaining codes tushar-----------
@Budget_BudgetTransfer_BP_BT_01_04
Scenario: (auto auth)BP_BT_01_04 To verify user is able to create multiple records of Budget Transfer	
 System should allow user to create multiple records of Budget Transfer
 Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record
Then Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record

#----------------priyanka feature files------------//
 
 
@BudgetTransfer_BP_BT_05_01
Scenario: To verify user is able to create a budget transfer record and submitting the record 
					for approval where multiple approvers are configured
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 

Then user login to checker1
And click on notification icon
And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Verify the clamed record is showing or not


@BudgetTransfer_BP_BT_08_01
Scenario: To verify Budget transfer is possible between any two budget codes within same branch
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
Then user login to checker1
And click on notification icon
And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Claim and approve the record

@BudgetTransfer_BP_BT_10_01
Scenario: searching the Budget Transfers record through search criteria
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
Then Maker click on the search icon 
Then maker enter the required data
Then click on the matching record
#---------------------Priyanka new codes of auto auth----------
#--------------AutoAuth--------#
@BudgetTransfer_BP_BT_01_02
Scenario:  If all the mandatory data is captured and user clicks on save button
	     then new Budget Transfer record should get save.
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record
Then Maker click on  budget transfer eye button
Then Maker click on the search icon 
Then maker enter the required data
Then click on the matching record

#--------------AutoAuth--------#
@BudgetTransfer_BP_BT_01_03
Scenario: System should throw the validation message to fill all the mandatory and 
	   valid details in the respective fields
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the invalid details and try to save
