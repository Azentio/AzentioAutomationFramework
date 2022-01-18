Feature: Check the Functionality of BudgetTransfer
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
