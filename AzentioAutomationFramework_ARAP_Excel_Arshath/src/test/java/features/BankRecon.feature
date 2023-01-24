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
Then click on the search button
And User Enter BankRecon Event Name
And Select and Submit the record
Then logout from maker
@KUBS_BRS_UAT_001_001_TC_001_1
Scenario: user login to Reviwer
Then user update the Excel sheet testdata for BankRecon
Then log in to the reviewer account1
Then click on the Notification select the record and Approve
And logout from reviewer
@KUBS_BRS_UAT_001_001_TC_001_2
Scenario: user login to Checker
Then user update the Excel sheet testdata for BankRecon
Then log in to the Checker Account2
And then checker claim the record1
Then click on the checker Notification 
And select the record and Approve by checker
Then logout from checker
@KUBS_BRS_UAT_001_001_TC_003 @MultiAuth
Scenario: Audit history must be correctly maintained on record.
Given User should go to the kubs url and login as a maker user
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
Then click on the first Record of bankReon
Then history must be correctly maintained on record
Then logout from maker
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
Then click on the search button
And User Enter BankRecon Event Name
And Select and Submit the records
Then logout from maker
@KUBS_BRS_UAT_001_001_TC_004_1
Scenario: user login to reviewer
Then user update the Excel sheet testdata for BankRecon1
Then log in to the reviewer account1
Then click on the Notification select the record and Approve 
And logout from reviewer
@KUBS_BRS_UAT_001_001_TC_004_2
Scenario: user login to Checker
Then user update the Excel sheet testdata for BankRecon1
Then log in to the Checker Account2
And then checker claim the record1
Then click on the checker Notification 
And select the record and Approve by checker
Then logout from checker

@KUBS_TAX_UAT_002_003_TC_002
Scenario: Check below entries are displayed for unmatched records from Book.
1. Unmatched record
2. Partially Matched Record
3. Transposition matched record
Given User should go to the kubs url and login as a maker user
And user should navigate to bank recon menu
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
And user update the Excel sheet testdata for BankRecon2
And Fill the required fields and upload bank statement for bank reconciliation
Then Save and click on process
Then Verify the Unmatch Record Tab must display all the entries for unmatched records from Book

@KUBS_TAX_UAT_002_003_TC_003  @MultiAuth
Scenario: System must give correct unmatch (Unmatch, Partial Match & Transposition match) basis the matching rule defined.
Given User should go to the kubs url and login as a maker user
And user should navigate to bank recon menu
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file
Then Save and click on process
Then verify unmatch record









