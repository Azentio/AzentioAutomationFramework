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


@tusharUAT
@Budget_BudgetTransfer_UAT_006_001
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
When User login to maker
Then click on configuration
And click on finance
Then click on direction button
And Budget button
Then Click on budget transfer eye button
Then click on add buttion
Then fill the form
And save the form
Then form should get save

@Budget_BudgetTransfer_UAT_006_007
Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
When user login into maker stage
Then user click on configuration
Then user click on the finance button
Then click on direction
Then click on budget button
Then click on transfer eye button
Then click on add button in transfer
Then fill the form and enter excessive budget amount to transfer



