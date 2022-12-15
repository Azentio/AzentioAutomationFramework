Feature: AR/AP Module

@KUBS_AR/AP_UAT_001_001_TC_001  @AR/AP
Scenario: Create a contract for an active vendor with expense type Purchases
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
Then Get the contract and Txn status by searching the record via business partner
And maker should logout

    @KUBS_AR/AP_UAT_001_001_TC_02  @AR/AP
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
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon    
    
@KUBS_AR/AP_UAT_001_001_TC_003  @AR/AP
Scenario: Verify PO is emailed to Vendor post approval of PO	GRN should be created successfully 
		and displayed in approved queue with Active Status.
		
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation eye button
Then Fill the form and check if GRN is showing or not which we created

@KUBS_AR/AP_UAT_001_001_TC_004  @AR/AP
Scenario: Create GRN against above create PO for above vendor
		
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
		Given Navigate to URL and user should login as a maker
		Then Click on the Finance
		Then Click on the Direction
		Then Click on Accounts Payable
		Then Click on Good Recived Note GRN Eye buutton
		Given Navigate to URL and user should login as a maker
		Then Click on the Finance
		Then Click on the Direction
		Then Click on Accounts Payable
		Then Click on Good Recived Note GRN Eye buutton
		
@KUBS_AR/AP_UAT_001_001_TC_005  @AR/AP
Scenario: Verify Accounting entries post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Report TabT
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

@KUBS_AR/AP_UAT_001_001_TC_007	@AR/AP
Scenario: Verify Approved GRN Reference is available on Fixed Asset creation.

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for report
Then Select date in calendarT
Then Click on View buttonT
Then close the report

@KUBS_AR/AP_UAT_001_001_TC_008  @AR/AP
Scenario: Verify GRN Report post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Report TabT
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

@KUBS_AR/AP_UAT_001_001_TC_009  @AR/AP
Scenario: Create Bill against PO & GRN for above vendor

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
    Then Get the invoice status
    And maker should logout

 @KUBS_AR/AP_UAT_001_001_TC_010  @AR/AP
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
    @KUBS_AR/AP_UAT_001_001_TC_011  @AR/AP
  Scenario: Verify Total Tax Amount is auto populated on Fixed Asset creation screen while creating Fixed asset against above GRN
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset creation
    And click on add button to create asset record
    And Fill the required fields to create asset against GRN Ref number
    Then Save the asset creation record against GRN Ref number
    And navigate to fixed asset items tab to add item details
    And click on add button
    Then Fill the hsn code and verify the total tax amount is auto populated
    
    @KUBS_AR_AP_UAT_001_001_TC_012  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for Puchase Bill
Then Click on Table Row First Eye Icon in ARAP
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved
    
@KUBS_AR/AP_UAT_001_001TC_013  @AR/AP
   Scenario: Verify Balance sheet post Bill is approved.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   Then Fill branch details for report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR_AP_UAT_001_001_TC_014  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed
   
   
   @KUBS_AR/AP_UAT_001_002_TC_01 @AR/AP
Scenario: Verify Tax details is correctly displayed for Item details in Billing.

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

   @KUBS_AR_AP_UAT_001_002_TC_02_01
Scenario: Verify Accounting entries post Bill is approved
Given Maker Navigate to UAT URL login
And Go to invoice bill booking module
Then click on search
And search the expence bill is appreared in the list view 
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the expence invoice number is available in the accounting entries tab
   
   @KUBS_AR/AP_UAT_001_002_TC_03	@AR/AP
Scenario: Verify Balance sheet post Bill is approved.

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button


# KUBS_AR/AP_UAT_001_002_TC_04 -Functionality NA

@KUBS_AR_AP_UAT_001_002_TC_05  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed


@KUBS_AR/AP_UAT_001_003_TC_01 @AR/AP

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR/AP_UAT_001_003TC_02  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
   Given user navigate to azentio url and login as maker for verify post bill is approved in Accounting Entries
   When click the account payable main module for verify post bill is approved in Accounting Entries
   And click the eye icon of invoice bill booking for verify post bill is approved in Accounting Entries
   And click the search icon in list view for verify post bill is approved in Accounting Entries
   And search invoice type as expense for verify post bill is approved in Accounting Entries
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the Active  bill viewed 
   And click the notes option in top for verify post bill is approved
   And click the enquiry module for verify post bill is approved
   And click the financial transaction edit icon for verify post bill is approved in Accounting Entries
   And select the branch code as azentio main branch for verify post bill is approved in Accounting Entries
   And select the transaction from date  for verify post bill is approved in Accounting Entries
   And select the transaction to date for verify post bill is approved in Accounting Entries
   And select the Transaction Ref No
   And click the view option for verify post bill is approved in Accounting Entries
   Then verify that the invoice number get from Active bill matches with voucher id in report

 @KUBS_AR/AP_UAT_001_003TC_03  @AR/AP
   Scenario: Verify Balance sheet post Bill is approved.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   Then Fill branch details for report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   # KUBS_AR/AP_UAT_001_003_TC_04 - Functionality NA
   
   @KUBS_AR_AP_UAT_001_003_TC_05  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given Maker Navigate to UAT URL login
And Go to invoice bill booking module
Then click on search
And search the expence bill is appreared in the list view 
And get the business partner name 
Then click on report segment button
And click on report main menu
And click on temp view near by accounts Payable 
And enter business partner name 
And click on date icon
And give date in report
And give payable status 
And click on the view button
Then verify the approved invoicebill number is available in the report


   
   @KUBS_AR/AP_UAT_001_004TC_01  @AR/AP
Scenario: verify the accounting entries post approval of GRN
 Given user login as Azentio Maker
 When user click Accounts Payable
 And click the eye icon of GRN
 And user click search icon
 And Search GRN status as Active
 And click the first eye icon in the list
 And get the Grn number
 And click the Notes Option In Top
 And click The Enquiry Module for Accounting Entries
 And Click the Edit icon in Financial Transaction
 And Select Branch code as Azentio Manin Branch
 And Choose the Transaction from date
 And choose the Transaction To date
 And select the Transaction Ref No as Grn Number
 Then Verify the GRN number in Voucher Id and verify transaction type
 
 @KUBS_AR/AP_UAT_001_004_TC_02  @AR/AP
Scenario: Verify Accounting entries post approval of GRN
Given Maker Navigate to UAT URL login
And click on accounts Payable module
Then go to GRN module
Then click on search
And search and get the active GRN code
And get the transaction date in grn
Then click on report segment button
And click on financial reporting main menu
And click on temp view near by balance sheet sub menu
Then Fill branch details for report
And enter the transaction date
And click on the view button
Then Verify Balance sheet post GRN approval
 
 @KUBS_AR/AP_UAT_001_004_TC_03  @AR/AP

Scenario: Verify GRN Report post approval of GRN
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Report TabT
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

# Reusable Code - P
@CommonFeatureFile
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

@KUBS_AR/AP_UAT_001_004_TC_04 @AR/AP
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

@KUBS_AR/AP_UAT_001_004_TC_05 @AR/AP

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

@KUBS_AR_AP_UAT_001_004_TC_06  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Maker Navigate to UAT URL login
And Go to invoice bill booking module
Then click on search
And search the expence bill is appreared in the list view 
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the expence invoice number is available in the accounting entries tab
 
 @KUBS_AR/AP_UAT_001_004_TC_07	@AR/AP
Scenario: Verify Balance sheet post Bill is approved.

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button

  @KUBS_AR/AP_UAT_001_004TC_08  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as Invoice Against Po
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed invoice against po
   And get buisness partner name and Bill Status for invoice against po
   And click the notes option in top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status as Active
   And select the date
   And click the view icon
   Then verify the bill is Active in Accounts payable report
   
   
   @KUBS_AR_AP_UAT_001_005_TC_01  @AR/AP
Scenario: Verify Accounting entries post approval of GRN
Given Maker Navigate to UAT URL login
And click on accounts Payable module
Then go to GRN module
Then click on search
And search and get the active GRN code
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
And verify the accounting entries of GRn is appeared in the accounting entry screen
   
   @KUBS_AR/AP_UAT_001_005_TC_02	@AR/AP
Scenario: Verify Balance sheet post GRN post approval of GRN

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

@KUBS_AR/AP_UAT_001_005_TC_03  @AR/AP

Scenario: Verify GRN Report post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Report TabT
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

@KUBS_AR/AP_UAT_001_005_TC_04 @AR/AP

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

@KUBS_AR/AP_UAT_001_005_TC_05 @AR/AP

Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of invoice booking
Then Get the tax details and check the details

@KUBS_AR_AP_UAT_001_005_TC_06  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Maker Navigate to UAT URL login
And Go to invoice bill booking module
Then click on search
And search the invoice number which is created inventory purchase
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
And verify the inventory requested invoice number is availabe in the accounting entries

@KUBS_AR_AP_UAT_001_005_TC_07  @AR/AP
Scenario: Verify Balance sheet post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Click on Table Row First Eye Icon in ARAP
And Get the Branch Name
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
Then Fill branch details for report
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

@KUBS_AR/AP_UAT_001_005_TC_08  @AR/AP
  Scenario: Verify Accounts Payable Report post bill is approved.
  	
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
   	#Then click on first eye button to get the system invoice number
    Then Get the invoice number of bill against po of particular vendor
    
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of account payable report
    And Fill the required fill to check the accounts payable report must display
    Then click in the view button to check
    #Then the report is displaying all the asset transfer details for a branch
    Then verify the accounts payable report must correctly displayed
    
    @KUBS_AR/AP_UAT_001_005_TC_09  @AR/AP
  Scenario: Verify Accounts Payable Report post bill is approved.
  	
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the invoice number of bill against po of particular vendor
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of account payable report
    And Fill the required fill to check the accounts payable report must display
    Then click in the view button to check
    Then verify the accounts payable report must correctly displayed


#After API run It will work
 @KUBS_AR/AP_UAT_001_006_TC_01  @AR/AP
  Scenario: Verify Bill is auto created on defined date
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
 		When click on temp grid button of invoice booking
 		Then search auto generate bill and verify

@KUBS_AR/AP_UAT_001_006_TC_02  @AR/AP
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
    @KUBS_AR_AP_UAT_001_006_TC_03  @AR/AP
Scenario: Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for against PO for Expenses with Auto generate bills
Then Click on Table Row First Eye Icon in ARAP
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved Auto generate bills
    
@KUBS_AR/AP_UAT_001_006_TC_04  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

# KUBS_AR/AP_UAT_001_006_TC_05 - Functionality NA

@KUBS_AR_AP_UAT_001_006_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given Maker Navigate to UAT URL login
And Go to invoice bill booking module
Then click on search
And search the active bill
And get the approved invoice number
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter bp name in accoutspayable report for approved invoice
And click on date icon
And give date in report
And give payable status in accounts payable report for approved invoice
And click on the view button
Then verify the approved invoice is appeared in the accounts Payable report


@KUBS_AR/AP_UAT_001_007_TC_01  @AR/AP
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
@KUBS_AR/AP_UAT_001_007TC_02  @AR/AP
 Scenario: verify Accounting entries of post bill approved
 Given user navigate to azentio url and login as maker for verify post bill is approved in Accounting Entries
   When click the account payable main module for verify post bill is approved in Accounting Entries
   And click the eye icon of invoice bill booking for verify post bill is approved in Accounting Entries
   And click the search icon in list view for verify post bill is approved in Accounting Entries
   And search invoice type as expense for verify post bill is approved in Accounting Entries
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the Active  bill viewed 
   And click the notes option in top for verify post bill is approved
   And click the enquiry module for verify post bill is approved
   And click the financial transaction edit icon for verify post bill is approved in Accounting Entries
   And select the branch code as azentio main branch for verify post bill is approved in Accounting Entries
   And select the transaction from date  for verify post bill is approved in Accounting Entries
   And select the transaction to date for verify post bill is approved in Accounting Entries
   And click the view option for verify post bill is approved in Accounting Entries
   Then verify that the invoice number get from Active bill matches with voucher id in report
   
@KUBS_AR/AP_UAT_001_007_TC_03  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
Then Fill branch details for report

And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

 @KUBS_AR/AP_UAT_001_007TC_04  @AR/AP
    Scenario: verify Accounts payable report post bill is active
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status
   And select the date
   And click the view icon
   Then verify the bill is cancelled in Accounts payable report



@KUBS_AR_AP_UAT_001_008_TC_01  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for Mapped Tax category
Then Click on Table Row First Eye Icon in ARAP
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved Tax category

@KUBS_AR/AP_UAT_001_008_TC_02	  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

@KUBS_AR_AP_UAT_001_008_TC_03  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for Mapped Tax category
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name for Invoice Bill
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is displayed correctly