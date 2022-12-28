Feature: To create Bank Recon details

@KUBS_BRS_UAT_001_001_TC_001 @MultiAuth

Scenario: Create format master and Data matching Rules for a specific Bank and Account Type
Given User should go to the kubs url and login as a maker user
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then Click on Inventory Maintenance Add button
Then user update the Excel sheet testdata for BankRecon
Then fill the Bank Reconciliation Format 
Then fill the Bank Reconciliation PlaceHolder
Then Click on Inventory Item Save button
Then Click on Inventory Maintenance Add button
Then user update the Excel sheet testdata for BankRecon
Then File Data matching rule
Then Click on Inventory Item Save button
Then click back button
Then Click on Inventory Maintenance Add button
Then user update the Excel sheet testdata for BankRecon
Then File Transaction Data matching rule
Then Click on Inventory Item Save button
Then click back button
Then Click on Inventory Maintenance Add button
Then user update the Excel sheet testdata for BankRecon
Then File Deposit Data matching rule
Then Click on Inventory Item Save button
Then click back button
Then Click on Inventory Maintenance Add button
Then user update the Excel sheet testdata for BankRecon
Then File Withdrawals Data matching rule
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the record
@KUBS_BRS_UAT_001_001_TC_001_1
Scenario: user login to Reviwer
Then user update the Excel sheet testdata for BankRecon
Then log in to the reviewer account
Then click on the Notification select the record and Approve
@KUBS_BRS_UAT_001_001_TC_001_2
Scenario: user login to Checker
Then user update the Excel sheet testdata for BankRecon
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_BRS_UAT_001_001_TC_003 @MultiAuth
Scenario: Audit history must be correctly maintained on record.
Given User should go to the kubs url and login as a maker user
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
#Then user update the Excel sheet testdata for BankRecon
Then history must be correctly maintained on record

@KUBS_BRS_UAT_001_001_TC_004 @MultiAuth
 Scenario: De-activating an approved record
Given User should go to the kubs url and login as a maker user
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then user update the Excel sheet testdata for BankRecon1
Then select the active record
Then Inactivate the record
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the records
@KUBS_BRS_UAT_001_001_TC_004_1
Scenario: user login to reviewer
Then user update the Excel sheet testdata for BankRecon1
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
@KUBS_BRS_UAT_001_001_TC_004_2
Scenario: user login to Checker
Then user update the Excel sheet testdata for BankRecon1
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
 