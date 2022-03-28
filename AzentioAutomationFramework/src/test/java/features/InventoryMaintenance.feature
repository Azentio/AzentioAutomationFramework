Feature: Checking the Inventory Maintenance functionality

@KUBS_INV_MGMT_UAT_002_003 @MultiAuth

Scenario: Unique Inventory item code should be created
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on Inventory Maintenance
Then Click on Inventory Item Master Eye Icon
Then Click on Inventory Maintenance Add button
Then Fill Inventory Item Mandatory fields
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_INV_MGMT_UAT_001_006
Scenario: Check the accounting entries GL
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on Inventory Maintenance
Then Click on Inventory Gl Configuration Eye Icon
Then Click on Inventory Maintenance Add button
Then Fill Inventory Gl Configuration Mandatory fields
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select Inventory Maintenance and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker