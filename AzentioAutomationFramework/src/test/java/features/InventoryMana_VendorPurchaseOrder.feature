Feature: Checking the Acount Payable  functionality

@KUBS_INV_MGMT_UAT_001_003 @MultiAuth

Scenario: Create a purchase order with Unique purchase order number
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_001_003  @MultiAuth
Scenario: Create a purchase order with Unique purchase order number
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR/AP_UAT_001_001_TC_02  @MultiAuth
Scenario: PO should be created successfully and displayed in approved queue with Active Status
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_AR/AP_UAT_013_001_TC_01  @MultiAuth
Scenario: Verify creating PO against contracts is not allowed if PO QTY
 					is greater than available Contract QTY For Expense Type Purchase
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order fields
Then Enter Po Quantity

@KUBS_AR/AP_UAT_013_TC_02  @MultiAuth

Scenario: Verify creating PO against contract is allowed if total QTY of previous
				  and Current PO is greater than contract QTY but total PO Amount is equal 
				  or lesser than contract value For Expense Type Service
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then enter the PO service type details
Then Click on Account Payable Save button
Then Click on purchase order Add button
Then fill the item details PO Amount is equal or lesser than contract Amount
Then Click on Account Payable Save button
Then fill Beneficiary Details
Then Click on Beneficiary Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected final record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR/AP_UAT_013_TC_03 @MultiAuth
Scenario: Verify creating PO against contract is not allowed if PO Amount is
					greater than contract value but PO Qty is equal or lesser than Contract QTY.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record				
Then Edit the item details PO Qty fields 
