Feature: Check the Functionality of Inventory

@KUBS_INV_MGMT_UAT_001_001_01
Scenario: Create a request for inventory
Given User should go to the kubs url and login as a maker user
Then select data set ID for Inventory Request
Then Choose the second Tab Segment
#Then Click on Finance
#Then Click on the Direction
Then Click on Inventory Management
And Click on the eye icon of Inventory Request
Then Click on Add button
And Fill all the mandatory fields
Then Click on save button
Then Click Notification button
And Select record which we saved
And Submit the record
@KUBS_INV_MGMT_UAT_001_001_02
Scenario: verify reviewer approve the inventory request record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
@KUBS_INV_MGMT_UAT_001_001_03
Scenario: verify Checker approve the inventory request record
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
@KUBS_INV_MGMT_UAT_001_001_04
Scenario: verify record from the maker stage after approval
Given User should go to the kubs url and login as a maker user
Then select data set ID for Inventory Request
Then Choose the second Tab Segment
#Then Click on Finance
#Then Click on the Direction
Then Click on Inventory Management
And Click on the eye icon of Inventory Request

	@KUBS_INV_MGMT_UAT_001_002_TC_01
	Scenario: Purchase Requisition Confirmation
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for purchase requisition confirmation creation
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    And click on add button  of purchase requisition confirmation
    And Fill the required fields to purchase req
    Then Save and submit the purchase req confirmation
	@KUBS_INV_MGMT_UAT_001_002_TC_02
	Scenario: verify reviewer approve the Purchase Requisition Confirmation record
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the purchase requisition confirmation record by reviewer user
	@KUBS_INV_MGMT_UAT_001_002_TC_03
	Scenario: verify Checker approve the Purchase Requisition Confirmation record
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the purchase requisition confirmation record
	@KUBS_INV_MGMT_UAT_001_002_TC_04
	Scenario: verify record from the maker stage after approval
    Given User should go to the kubs url and login as a maker user
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    Then click on first eye button to get the indent reference number
    And maker should logout


@KUBS_INV_MGMT_UAT_001_003_TC_01
Scenario: Create a contract
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for create contract
    And user should navigate to accounts payable menu to create contract
    When click on eye button of vendor contract to create contract
    And click on add button to create contract to create contract
    And Fill the required fields to create vendor contract 
    Then Save and submit the creation of contract record
  @KUBS_INV_MGMT_UAT_001_003_TC_02
  Scenario: verify reviewer approve the create contract record
    And User should login as a reviewer user
    Then Click on notification button in reviewer stage
  	And approve the contract record by reviewer user
  @UBS_INV_MGMT_UAT_001_003_TC_03
  Scenario: verify checker approve the create contract record
    Given User should login as a checker user
   	And Click on security management in checker stage
   	Then Click on open pool in checker stage
   	And Click on claim button in checker stage
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the create contract record
  @KUBS_INV_MGMT_UAT_001_003_TC_04
  Scenario: verify record from the maker stage after approval
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    Then click on first eye button to get an unique contract code
    And maker should logout
        
@KUBS_INV_MGMT_UAT_001_004_TC_01 @MultiAuth
Scenario: Create a purchase order with Unique purchase order number
Given User should go to the kubs url and login as a maker user
Then select data set ID for PO creation
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
@KUBS_INV_MGMT_UAT_001_004_TC_02
Scenario: 
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
@KUBS_INV_MGMT_UAT_001_004_TC_03
Scenario: 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
   
   
@KUBS_INV_MGMT_UAT_001_005_TC_01 @multiauth
Scenario: Create a GRN
Given User should go to the kubs url and login as a maker user
Then select data set ID for GRN
Then Click on Direction icon
Then Click on Account Payable
Then Click on purchase order Eye Icon
Then click on first eye button to get the po number
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN record
Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number for grn
Then Add quantity received quantity approved
Then Click on GRN item save button
Then Click on the Notification
Then Select the record which we saved
Then Submit record
@KUBS_INV_MGMT_UAT_001_005_TC_02
Scenario: 
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
@KUBS_INV_MGMT_UAT_001_005_TC_03
Scenario: 
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
    
@KUBS_INV_MGMT_UAT_001_006_TC_01 @MultiAuth
Scenario: Confirm the inventory stock received from the vendor
Given User should go to the kubs url and login as a maker user
Then select data set ID for inventory stock received from vendor
Then Choose the second Tab Segment
#Then Click on the Finance
#Then Click on the Direction
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
@KUBS_INV_MGMT_UAT_001_006_TC_02
Scenario: 
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
@KUBS_INV_MGMT_UAT_001_006_TC_03
Scenario: 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_INV_MGMT_UAT_001_007_TC_01
  Scenario: Bill(invoice) Booking
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for bill booking
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for bill booking
    Then Save and submit the invoice billing
  @KUBS_INV_MGMT_UAT_001_007_TC_02
  Scenario: 
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  @KUBS_INV_MGMT_UAT_001_007_TC_03
  Scenario: 
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the invoice billing
  @KUBS_INV_MGMT_UAT_001_007_TC_04
  Scenario: 
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then click on first eye button to get the system invoice number
    And maker should logout
  	
@KUBS_INV_MGMT_UAT_001_008
Scenario: Check the accounting entries
Given User should go to the kubs url and login as a maker user
Then select data set ID for checking accounting entries
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
Given User should go to the kubs url and login as a maker user
Then select data set ID for checking stock return to vendor
Then click on report button
Then Click on Report Tab
Then Click on stock return report edit button
Then Fill the form for stock return report for return the inventories
And Click on view button to view report of stock return
Then verify the approved record is available in the stock return report

@KUBS_INV_MGMT_UAT_006_002
Scenario: Check accounting entries
Given User should go to the kubs url and login as a maker user
Then select data set ID for checking GL
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
Given User should go to the kubs url and login as a maker user
Then select data set ID for inventory access details report
Then click on report button
Then Click on Report Tab
Then Click on Inventory access detail report edit grid
Then Fill the form for  Inventory access detail report
And click on view button to view report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_002
Scenario: Check inventory request report
Given User should go to the kubs url and login as a maker user
Then select data set ID for inventory request report
Then click on report button
Then Click on Report Tab
Then Click on Inventory Request report edit grid
Then Fill the form for Inventory Request report
And click on view button to view report of inventory request
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_003
Scenario: Check Purchase requisition report
Given User should go to the kubs url and login as a maker user
Then select data set ID for Purchase requisition report
Then click on report button
Then Click on Report Tab
Then Click on Purchase requisition report edit grid
Then Fill the form for Purchase requisition report
And Click on view button to view report of Purchase requisition report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_004
Scenario: Check stock issuance report
Given User should go to the kubs url and login as a maker user
Then select data set ID for stock issuance report
Then click on report button
Then Click on Report Tab
Then Click on stock issuance report edit grid
Then Fill the form for stock issuance report
And Click on view button to view report of stock issuance report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_005
Scenario: Check stock confirmation report
Given User should go to the kubs url and login as a maker user
Then select data set ID for stock confirmation report
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
Given User should go to the kubs url and login as a maker user
Then select data set ID for Purchase requisition report
Then click on report button
Then Click on Report Tab
Then Click on stock return report edit grid
Then Fill the form for stock return report
And Click on view button to view report of stock return report
Then verify the approved record is available in the report



