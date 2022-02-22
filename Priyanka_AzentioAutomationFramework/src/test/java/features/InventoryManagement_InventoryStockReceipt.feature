Feature: Checking the Inventory Management functionality

@KUBS_INV_MGMT_UAT_001_002 @MultiAuth

Scenario: Confirm the inventory stock received from the vendor
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Inventory Management
Then Click on inventory stock receipt Eye Icon
Then Click on inventory stock Add button
Then Fill inventory stock Mandatory fields
Then Click on inventory stock Save button
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

