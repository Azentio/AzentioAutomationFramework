Feature: Check the Functionality of Petty Cash Module

@KUBS_PC_UAT_004_001
 
Scenario: Create a fund request for Petty Cash

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Petty Cash button
Then Click on Fund Request eye button
Then Click on Add button to request fund
Then Click on Request Amount Text Box and entre amount
Then Click on Save button for saving record

Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification

Then Click on Approve button in reviewer stage
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Petty Cash button
Then Click on Fund Request eye button
@KUBS_PC_UAT_004_002
Scenario: Check the GL entries for replenishment of petty cash

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in calender for petty cash
And click on the transaction to date in calender icon
Then choose the To date in calender for petty cash
And click on view button to see the Record

Then validate voucher number for petty cash








