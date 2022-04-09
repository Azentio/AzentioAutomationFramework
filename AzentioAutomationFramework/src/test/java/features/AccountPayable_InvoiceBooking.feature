Feature: Checking the Acount Payable Invoice Booking functionality

@KUBS_AR/AP_UAT_001_002_TC_01 @MultiAuth

Scenario: Verify Tax details is correctly displayed for Item details in Billing.

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
And click on the invoice booking add button 
And Fill invoice booking required fields
Then Save invoice billing and submit the record

Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker  
       
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_001_003_TC_01 @MultiAuth

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_001_004_TC_05 @MultiAuth

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_001_005_TC_05 @MultiAuth

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_002_002_TC_01 @MultiAuth

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_002_TC_01 @MultiAuth
Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details
