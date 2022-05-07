Feature: Checking the Bank Recon functionality

@KUBS_BRS_UAT_001_001_TC_004 @MultiAuth

Scenario: De-activating an approved record

Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then select the active record
Then Inactivate the record
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_BRS_UAT_001_001_TC_003 @MultiAuth

Scenario: Audit history must be correctly maintained on record.

Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then history must be correctly maintained on record


@KUBS_BRS_UAT_001_001_TC_001 @MultiAuth

Scenario: Create format master and Data matching Rules for a specific Bank and Account Type.

Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then Click on Inventory Maintenance Add button
Then fill the Bank Reconciliation Format 
#Then fill the Bank Reconciliation PlaceHolder
#Then Click on Inventory Item Save button
#Then Click on Inventory Maintenance Add button

#Then File Data matching rule
#Then Click on Inventory Item Save button
#Then click back button

#Then Click on Inventory Maintenance Add button
#Then File Transaction Data matching rule
#Then Click on Inventory Item Save button
#Then click back button

#Then Click on Inventory Maintenance Add button
#Then File Deposit Data matching rule
#Then Click on Inventory Item Save button
#Then click back button

#Then Click on Inventory Maintenance Add button
#Then File Withdrawals Data matching rule
#Then Click on Inventory Item Save button


#Then Click on Inventory Item Notification 
#And Select and Submit the record
#Then log in to the reviewer account
#Then click on the Notification select the record and Approve 
#Then log in to the Checker Account
#And then checker claim the record
#Then click on the checker Notification 
#And select the record and Approve by checker
 