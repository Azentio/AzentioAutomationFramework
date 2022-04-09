Feature: Checking the Acount Receivable Updating  deposited cheques  functionality

@KUBS_AR/AP_UAT_010_003_TC_01 @MultiAuth

Scenario: Bouncing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Bounced
Then Add Bank Charges
Then Select the bounced reason
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker



@KUBS_AR/AP_UAT_010_004_TC_01 @MultiAuth

Scenario: Update cheque status to Cleared Bouncing & redepositing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker


@KUBS_AR/AP_UAT_010_002_TC_03 @MultiAuth

Scenario: Update cheque status to Cleared
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
