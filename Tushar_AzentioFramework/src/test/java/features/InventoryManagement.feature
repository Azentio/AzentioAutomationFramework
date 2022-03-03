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


@KUBS_INV_MGMT_UAT_001_006
Scenario: Check the accounting entries

Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
And click on transaction from date calender icon
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button

@KUBS_INV_MGMT_UAT_005_002
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
And click on transaction from date calender icon
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button

@KUBS_INV_MGMT_UAT_005_001
Scenario: Check stock return from branch

Given Navigate to URL and user should login as a maker
Then Click on Second icon page
And Click Inventory Management module
And Click on stock return from branch SubModule Eye icon
Then Click on stock return from branch Add icon
And Click on Request Referance No code
Then Click on Issue Referance No code
And Click on item code
And Enter Return Quantity Stock value
Then Click on Return Type and Choose Type
And Click on Return Reason and Choose Type
Then Save the Inventory Stock Record
And goto the maker Notification icon
Then Click Submit icon to Inventory Record
And Give Remark and submit Inventory field
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on Inventory Maintance module
And click on Master Item eye icon
Then click on search icon
And Give Item description value and Click Edit icon
When validate the quantity of the Item

@KUBS_INV_MGMT_UAT_004_StockConfirm
Scenario: Check inventory stock confirmation

Given Navigate to URL and user should login as a maker
Then Inventory Second direction icon
And Inventory Management Module
Then Click on Stock issue eye icon
And Click on First record eye icon
Then Get the New Request Referance No
Then Click on Inventory stock confirmation eye icon
And Sub module Inventory stock confirmation click Add icon
Then Enter Request Referance Number
And Enter Item code Number
Then Accept the status in checkbox
And click the save icon for StockConfirm
And goto maker Notification icon
Then Click Submit button to Inventory Record
And Give Remark and submit to reviewer
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_INV_MGMT_UAT_004_GL
Scenario: Check the Gl Status
Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
Then choose Gl code Id
And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record

