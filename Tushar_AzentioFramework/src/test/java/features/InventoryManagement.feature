Feature: Check the Functionality of Inventory

@KUBS_INV_MGMT_UAT_001_001 @multiauth

Scenario: Create a request for inventory

Given Navigate to URL and user should login as a maker
Then Click on Finance
Then Click on Direction
Then Click on Inventory Management
And Click on the eye icon of Inventory Request
Then Click on Add button

And Fill all the mandatory fields

Then Click on save button
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record


@KUBS_INV_MGMT_UAT_001_004

Scenario: Create a GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN


Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
Then Click on GRN item save button

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
@KUBS_INV_MGMT_UAT_002_001 @multiauth

Scenario: Create instrument code
Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Instrument code master eye button
Then Click on Add button
Then Fill all the details

Then Click on save button on instrument code master
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record


@KUBS_INV_MGMT_UAT_003_001	
Scenario: Create branch access for issuing inventories
Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Inventory access master
Then Click on Add button
Then Fill all the required field for issuing inventories
Then Click on issue checkbox

Then Click on save button in inventory Access Master
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record



@KUBS_INV_MGMT_UAT_003_002	
Scenario: Create branch access for receiving inventories
Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Inventory access master
Then Click on Add button
Then Fill all the required field for receiving inventories
Then Click on Recive checkbox

Then Click on save button in inventory Access Master
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_INV_MGMT_UAT_003_003
Scenario: Create branch access for ordering inventories
	Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Inventory access master
Then Click on Add button
Then Fill all the required field for ordering inventories
Then Click on Place Order checkbox

Then Click on save button in inventory Access Master
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_INV_MGMT_UAT_003_004	
Scenario: Create branch access for requesting inventories
Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Inventory access master
Then Click on Add button
Then Fill all the required field for requesting inventories
Then Click on Place Request checkbox

Then Click on save button in inventory Access Master
Then Click on Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

















