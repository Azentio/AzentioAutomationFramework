Feature: feature
Background: 
Given Navigate to KUBS URL and login with maker credentials 

@KUBS_AR_AP_UAT_013_001_TC_06
Scenario: Verify Payment settlement txn is not available for payout if net payabe is 0.
And click on accounts Payable module
And goto invoice booking module
And click on Add Icon
And fill the mendatory field for invoice booking module module
And goto invoice bill booking temp view and select the record
And fill the second tab details details
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking
And Go to payment settlement module
And click on Add Icon
And fill the payment settlement record and validate the invoice number is not available in the invoice list view