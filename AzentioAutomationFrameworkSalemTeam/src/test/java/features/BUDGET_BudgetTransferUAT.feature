Feature: Check the Functionality of BudgetTransfer UAT
@BudgetTransfer_KUBS_BP_UAT_006_008_UAT
Scenario: Check the functionality if transfering budget does not have sufficeint amount in that quarter
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then fill form and enter excessive budget amount to transfer

@BudgetTransfer_KUBS_BP_UAT_006_004
Scenario: Check when transfered budget from one budget code to another budget can modify the amount
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker modify the amount