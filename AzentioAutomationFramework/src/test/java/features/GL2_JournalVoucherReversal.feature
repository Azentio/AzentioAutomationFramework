Feature: Checking the General LedgerTransaction Journal Voucher Reversal  functionality

@KUBS_GL2_UAT_003_004 @MultiAuth

Scenario: Create a Reverse Journal Voucher to undo the already generated journal Voucher

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher Reversal EyeIcon
Then Click on Journal Voucher Reversal Pencil Icon
Then save the Journal Voucher record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker