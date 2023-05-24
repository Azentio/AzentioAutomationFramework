Feature: Check the Functionality of Inventory

@KUBS_INV_MGMT_UAT_001_001 @multiauth
Scenario: Create a request for inventory
Given Navigate to URL and user should login as a maker
Then Click on Finance
Then Click on the Direction
Then Click on Inventory Management
And Click on the eye icon of Inventory Request
Then Click on Add button

And Fill all the mandatory fields

Then Click on save button
Then Click Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on Finance
Then Click on the Direction
Then Click on Inventory Management
And Click on the eye icon of Inventory Request

  #@CreateContract_KUBS_INV_MGMT_UAT_001_002
  #Scenario: Create a contract
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to accounts payable menu
    #When click on eye button of vendor contract
    #And click on add button to create contract
    #And Fill the required fields to create contract
    #Then Save and submit the creation contract record
    #
    #And User should go to the kubs url and login as a reviewer user
    #Then Click on notification button in reviewer
  #	And approve the record by reviewer user
  #	
    #Given User should go to the kubs url and login as a checker user
   #	And Click on security management in checker
   #	Then Click on open pool in checker
   #	And Click on claim button in checker
   #	And capture claimed status
   #	Then click on notification in checker
    #Then checker should approved the contract record
    #
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to accounts payable menu
    #When click on eye button of vendor contract
    #Then click on first eye button to get the unique contract code
    #And maker should logout
    
     @PurchseReqConf_KUBS_INV_MGMT_UAT_001_002
  Scenario: Purchase Requisition Confirmation
    Given User should go to the kubs url and login as a maker user
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    And click on add button  of purchase requisition confirmation
    And Fill the required fields to purchase req
    Then Save and submit the purchase req confirmation
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record

    Given User should go to the kubs url and login as a maker user
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    Then click on first eye button to get the indent reference number
    And maker should logout
    
     @CreateContract_KUBS_INV_MGMT_UAT_001_002
  Scenario: Create a contract
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    And click on add button to create contract
    And Fill the required fields to create contract
    Then Save and submit the creation contract record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    Then click on first eye button to get the unique contract code
    And maker should logout
        
    @KUBS_INV_MGMT_UAT_001_003 @MultiAuth

Scenario: Create a purchase order with Unique purchase order number

Given User should go to the kubs url and login as a maker user
And user should navigate to inventory management
When click on eye button of purchase requisition confirmation
Then click on first eye button to get the indent reference number
#Given Maker Navigate to UAT URL login
#Then Click on Direction icon
Then Click on Account Payable
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order for inventory Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields po
Then Click on the item details save button po
#Then Click on Account Payable Save button

Then Click on Beneficiary details tab
Then fill Beneficiary Details
Then Click on Beneficiary Save button

#Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
    
 @KUBS_INV_MGMT_UAT_001_004 @multiauth

Scenario: Create a GRN
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable
Then Click on purchase order Eye Icon
Then click on first eye button to get the po number

#Given Navigate to URL and user should login as a maker
#Then Click on the Finance
#Then Click on the Direction
#Then Click on Accounts Payable

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
    
    @KUBS_INV_MGMT_UAT_001_002_Inventory_Stock @MultiAuth

Scenario: Confirm the inventory stock received from the vendor

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then click on first eye button to get the grn number

#Given Maker Navigate to UAT URL login
#Then Click on Direction icon
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

@KUBS_INV_MGMT_UAT_001_005
  Scenario: Bill(invoice) Booking
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking
    Then Save and submit the invoice billing
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the invoice billing
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then click on first eye button to get the system invoice number
    And maker should logout
  	
  	@KUBS_INV_MGMT_UAT_001_006AE
Scenario: Check the accounting entries

Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And choose the branch code
And choose the Gl code
And click transaction from date calender icon
Then choose from date
And click on transaction to date calender icon
Then choose to date
And click on view button

@KUBS_INV_MGMT_UAT_002_001 @multiauth

Scenario: Create instrument code
Given Navigate to URL and user should login as a maker
#Then Click on Finance

Then Click on Inventory maintenance
Then Click on Instrument code master eye button
Then Click on Add button
Then Fill all the details

Then Click on save button on instrument code master
Then Click Notification button
And Select record which we saved
And Submit the record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on Finance

Then Click on Inventory maintenance
Then Click on Instrument code master eye button

@KUBS_INV_MGMT_UAT_002_002
  Scenario: Create denomination details
    Given User should navigate to the kubs url and login as a maker user
    And user should navigate to denomination master menu
    When click on eye button of denomination master
    And click on add button to create denomination details
    And Fill the required fields to create denomination details
    Then Save and submit the creation denomination details
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the denomination details
    And checker should logout

    @KUBS_INV_MGMT_UAT_002_003_Item_Code @MultiAuth

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

#@KUBS_INV_MGMT_UAT_003_001	
#@allthebranchesareAlreadyExist
#Scenario: Create branch access for issuing inventories
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#Then Click on Add button
#Then Fill all the required field for issuing inventories
#Then Click on issue checkbox
#
#Then Click on save button in inventory Access Master
#Then Click Notification button
#And Select record which we saved
#And Submit the record
#Then Open Reviewer account
#And Click on notification
#Then Approve the record which we submitted from maker stage
#Then Go to Checker account
#And Clam the record
#Then Click on notification and approve the record
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#
#@KUBS_INV_MGMT_UAT_003_002	
#@Existing2
#Scenario: Create branch access for receiving inventories
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#Then Click on Add button
#Then Fill all the required field for receiving inventories
#Then Click on Recive checkbox
#
#Then Click on save button in inventory Access Master
#Then Click Notification button
#And Select record which we saved
#And Submit the record
#Then Open Reviewer account
#And Click on notification
#Then Approve the record which we submitted from maker stage
#Then Go to Checker account
#And Clam the record
#Then Click on notification and approve the record
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#
#@KUBS_INV_MGMT_UAT_003_003
#@Existing3
#Scenario: Create branch access for ordering inventories
#	Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#Then Click on Add button
#Then Fill all the required field for ordering inventories
#Then Click on Place Order checkbox
#
#Then Click on save button in inventory Access Master
#Then Click Notification button
#And Select record which we saved
#And Submit the record
#Then Open Reviewer account
#And Click on notification
#Then Approve the record which we submitted from maker stage
#Then Go to Checker account
#And Clam the record
#Then Click on notification and approve the record
#	Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#@KUBS_INV_MGMT_UAT_003_004
#@Existing4
#Scenario: Create branch access for requesting inventories
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master
#Then Click on Add button
#Then Fill all the required field for requesting inventories
#Then Click on Place Request checkbox
#
#Then Click on save button in inventory Access Master
#Then Click Notification button
#And Select record which we saved
#And Submit the record
#Then Open Reviewer account
#And Click on notification
#Then Approve the record which we submitted from maker stage
#Then Go to Checker account
#And Clam the record
#Then Click on notification and approve the record
#Given Navigate to URL and user should login as a maker
#Then Click on Finance
#
#Then Click on Inventory maintenance
#Then Click on Inventory access master

@InventoryRequestChecking @KUBS_INV_MGMT_UAT_004_001
Scenario: To verify maker user can able to issue the inventory to requested branch
Given navigate to kubs URL and login as maker credentials
Then click on second Segment button
And click on inventory management main menu
Then click on view button near by inventory request menu
Then select the perticular inventory record by the help of request reference number
And check the inventory requested sucessfully and capture the inventory data
When user see the inventory request reference number , The inventory was successfully requested

@InventoryStockIssue @KUBS_INV_MGMT_UAT_004_002
Scenario: To verify inventory stock to be issued to requested branch
Given navigate to kubs URL and login as maker credentials
Then click on second Segment button
And click on inventory management main menu
Then click on view button near by inventory request menu
Then click on first eye button to get the request reference number

#Given navigate to kubs URL and login as maker credentials
#Then click on second Segment button
#And click on inventory management main menu
Then click the eye icon near by inventory stock issue
And click on Add button
And enter inventory item
Then enter inventory branch
And enter inventory reference number
Then Click on Save button
Then click on notification 
And select the first record in notification 
Then submit the record 
And logout from maker end 
And login with reviewer id
Then click on notification icon in reviewer
And select our record
Then approve the record in reviewer end
And validate the approval status in reviewer end
And logout from reviewer end 
Then login with checker ID
And click on Security management menu
And click on action button near by open pool
Then clime the Record
And click on Notification icon in checker stage
Then approve the Record
And validate the approval status in checker stage
Given navigate to kubs URL and login as maker credentials
Then click on second Segment button
And click on inventory management main menu
Then click the eye icon near by inventory stock issue
Then verify the inventory stock issue record is appeared in the temp view

@KUBS_INV_MGMT_UAT_004_003StockConfirmT @multiauth
Scenario: Check inventory stock confirmation

Given Navigate to URL and user should login as a maker
Then Inventory Second direction icon
And Inventory Management Module
Then Click on Stock issue eye icon
And Click on First record eye icon
Then Get the New Request Referance No
Then Click on Inventory stock confirmation eye icon
And Sub module Inventory stock confirmation click Add icon
Then Enter the Request Referance Number
And Enter Item code Number
Then Accept the status in checkbox
And click the save icon for StockConfirm
And goto maker Notification Icon
Then Click Submit button to Inventory Record
And Give Remark and submit to Reviewer
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

@KUBS_INV_MGMT_UAT_004_004GL
Scenario: Check the Gl Status
Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then validate voucher number for stock issue

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
#Given Navigate to URL and user should login as a maker
#Then Click on Inventory Maintance module
#And click on Master Item eye icon
#Then click on search icon
#And Give Item description value and Click Edit icon
#When validate the quantity of the Item


@KUBS_INV_MGMT_UAT_005_002AE
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And choose the branch code
And choose the Gl code
And click transaction from date calender icon
Then choose from date
And click on transaction to date calender icon
Then choose to date
And click on view button

@KUBS_INV_MGMT_UAT_006_001
Scenario: Check stock return to vendors

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on stock return report edit grid
Then Fill the form for stock return report for return the inventories

And Click on view button to view report of stock return report
Then verify the approved record is available in the report
@KUBS_INV_MGMT_UAT_006_002
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record

Then validate voucher number

@KUBS_INV_MGMT_UAT_007_001
Scenario: Check inventory access details report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Inventory access detail report edit grid
Then Fill the form for  Inventory access detail report

And click on view button to view report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_002
Scenario: Check inventory request report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Inventory Request report edit grid
Then Fill the form for Inventory Request report

And click on view button to view report of inventory request
Then verify the approved record is available in the report
@KUBS_INV_MGMT_UAT_007_003

Scenario: Check Purchase requisition report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Purchase requisition report edit grid
Then Fill the form for Purchase requisition report

And Click on view button to view report of Purchase requisition report
Then verify the approved record is available in the report
@KUBS_INV_MGMT_UAT_007_004
Scenario: Check stock issuance report


Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on stock issuance report edit grid
Then Fill the form for stock issuance report

And Click on view button to view report of stock issuance report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_005
Scenario: Check stock confirmation report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Stock Confirmation edit button
Then Fill the details of stock confirmation

And click transaction from date calender icon
Then choose from date

Then Click on View button
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_006
Scenario: System should able to show the stock Return history for the inventory item

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on stock return report edit grid
Then Fill the form for stock return report

And Click on view button to view report of stock return report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_007 
Scenario: Check instrument code report 

 Given User should go to the kubs url and login as a maker user 
 Then click on report icon 
 And user should navigate to master reports menu 
 Then click on temp grid button of inventory code report
 And Fill the form for inventory code Report
 Then click in the view button to check 
 Then the report is displaying with all the details

@KUBS_INV_MGMT_UAT_007_008
Scenario: Check denomination details report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Fund Requisition Report edit grid
Then Fill the form for Fund Requisition Report

And Click on view button to view report of Fund Requisition Report
Then verify the approved record is available in the report
@KUBS_INV_MGMT_UAT_007_009
Scenario: Check inventory item details report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on inventory item details Report edit grid
Then Fill the form for inventory item details Report

And Click on view button to view report of inventory item details Report
Then verify the approved record is available in the report
@KUBS_INV_MGMT_UAT_007_010
Scenario: Check inventory stock receipt report

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on inventory stock receipt Report edit grid
Then Fill the form for inventory stock receipt Report

And Click on view button to view report of inventory stock receipt Report
Then verify the approved record is available in the report
