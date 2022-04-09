Feature: Checking the Acount Payable GRN  functionality

@TC_003 @MultiAuth

Scenario: GRN should be created successfully and displayed in approved queue with Active Status.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button
Then Click on purchase order Add button
Then Fill the form for the GRN
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
Then Click on item Details tab
Then Select the PO Number
Then Add qty received qnty approved
Then Click on item Details Save button

Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the record with Remark
Then log in to the reviewer account
Then click on the Notification Approve the record
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve add remark by checker

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button


@KUBS_AR/AP_UAT_001_004_TC_04 @MultiAuth

Scenario: Verify details are auto populated on Inventory Stock Receipt Confirmation post entering GRN reference.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button
Then Click on purchase order Add button
Then Fill the form for GRN
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
Then Click on item Details tab
Then Select PO Number which is created with expense code mapped with inventory code
Then Add qty received qty approved
Then Click on item Details Save button

Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the record with Remark
Then log in to the reviewer account
Then click on the Notification Approve the record
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve add remark by checker

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button
Then select GRN refernce

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Inventory Management
Then Click on inventory stock receipt Eye Icon
Then Click on inventory stock Add button
Then enter GRN reference check details auto populated



@KUBS_AR/AP_UAT_001_005_TC_04 @MultiAuth

Scenario: Verify details are auto populated on Inventory Stock Receipt Confirmation post entering GRN reference.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button
Then Click on purchase order Add button
Then Fill the form for GRN
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
Then Click on item Details tab
Then Select PO Number which is created with expense code mapped with inventory code
Then Add qty received qty approved
Then Click on item Details Save button

Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the record with Remark
Then log in to the reviewer account
Then click on the Notification Approve the record
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve add remark by checker

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on GRN Eye button
Then select GRN refernce

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Inventory Management
Then Click on inventory stock receipt Eye Icon
Then Click on inventory stock Add button
Then enter GRN reference check details auto populated



