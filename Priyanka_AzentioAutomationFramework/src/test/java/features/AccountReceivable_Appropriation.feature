Feature: Checking the Acount Receivable Appropriation  functionality

@KUBS_AR/AP_UAT_010_005_TC_01 @MultiAuth

Scenario: Check approved receipts are available for appropriation.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation

@KUBS_AR/AP_UAT_010_005_TC_02 @MultiAuth

Scenario: Approved receivables must be list for appropriation 
					which are not cancelled or appropriated fully.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation

@KUBS_AR/AP_UAT_010_005_TC_04 @MultiAuth

Scenario: Below amount must be correctly calculated & displayed post receipt appropriation.
 				  Receipt Outstanding, Appropriation Amount, Outstanding amount for Receivables.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation
Then enter App Amount check the calculation for Outstanding amount for Receivable
Then Click on Appropriation Save button
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

