Feature: Application Login and verify
#--------------not to automate in UAT link-----------------------------------------------------

@Budget_BudgetTransfer_UAT_006_001
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
Given Maker login to KUBS UAT Url
And Maker click on the direction tab in home page
Then Maker click on budget
Then Maker click on budget transfer eye button
And Maker click on add button to create new record
Then Maker fill the details
And save the record

@Budget_BudgetTransfer_UAT_006_007
Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
Given Maker login to KUBS UAT Url
And Maker click on the direction tab in home page
Then Maker click on budget
Then Maker click on budget transfer eye button
And Maker click on add button to create new record
Then fill the form and enter excessive budget amount to the transfer


@Budget_BudgetTransfer_UAT_006_002 
@Budget_code_needs_to_be_changed_as_currently_budgetcodes_are_changed_in_product
Scenario: UAT_006_002	System should allow to transfer with same budget type
Given Maker login to KUBS UAT Url
And Maker click on the direction tab in home page
Then Maker click on budget
Then Maker click on budget transfer eye button
And Maker click on add button to create new record
Then Maker fill the details of same record
And save the record






