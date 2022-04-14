Feature: Checking the General LedgerTransaction JournalVoucher  functionality

@KUBS_GL2_UAT_003_001 @MultiAuth

Scenario: Create a Journal Voucher to adjust the amount from one GL to another GL

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon
Then Click on Journal Voucher AddButton
Then Fill the Mandatory fields of Journal Voucher
Then Add Debit credit record 
Then save the Journal Voucher record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon

@KUBS_GL2_UAT_003_002 @MultiAuth

Scenario: System should generate a unique journal voucher number and accounting entries
 					should be passed as one Debit GL and multiple credit GL amount accordingly
 					
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon
Then Click on Journal Voucher AddButton
Then Fill the Mandatory fields of Journal Voucher
Then Add one Debit multiple credit record 
Then save the Journal Voucher record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon