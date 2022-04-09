Feature: Checking the Acount Receivable Advances  functionality

@KUBS_AR/AP_UAT_002_003_TC_01 @MultiAuth

Scenario: Advance to employee must be created and displayed in approved list view.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
Then Fill the form for Account Recivable
Then Click on save button to save the Record for Account Recivable
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

