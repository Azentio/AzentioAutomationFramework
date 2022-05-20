 Feature: AR/AP Module
 Contract Creation[Vendor Contract]
 
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

@KUBS_AR/AP_UAT_001_001_TC_007	@AR/AP
Scenario: Verify Approved GRN Reference is available on Fixed Asset creation.

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for reportT
Then Select date in calendarT
Then Click on View buttonT

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
   And select the branch
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

   @KUBS_AR_AP_UAT_001_002_TC_02
Scenario: Verify Accounting entries post Bill is approved
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
Scenario: Accounts Receivable Report must display the correct info for logged in Branch

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
   And select the branch in balance sheet report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   # KUBS_AR/AP_UAT_001_003_TC_04 - Functionality NA
   
   @KUBS_AR_AP_UAT_001_003_TC_05  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
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
And click on accounts Payable module
Then go to GRN module
Then click on search
And search and get the active GRN code
And get the transaction date in grn
Then click on report segment button
And click on financial reporting main menu
And click on temp view near by balance sheet sub menu
And select branch in balance sheet
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
And Give Getted Branch code 
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
And choose branch code Id

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



@KUBS_AR_AP_UAT_001_009_TC_01  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill for Reimbursement 
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name for Invoice Bill
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved is Display

@KUBS_AR_AP_UAT_001_009_TC_02  @AR/AP
Scenario: Verify Balance sheet post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get the Branch Name
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
And Give Getted Branch code 
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

@KUBS_AR_AP_UAT_001_009_TC_03  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill for Reimbursement 
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name for Invoice Bill
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Reimbursement of expenses Accounts Payable Report is displayed correctly



@KUBS_AR_AP_UAT_001_010_TC_01  @AR/AP
Scenario: Verify Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill for Reimbursement 
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name for Invoice Bill
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved is Display

@KUBS_AR/AP_UAT_001_010_TC_02  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

@KUBS_AR_AP_UAT_001_010_TC_03  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give Invoice Number in Invoice Bill for Reimbursement 
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name for Invoice Bill
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Reimbursement of expenses Accounts Payable Report is displayed correctly



@KUBS_AR/AP_UAT_002_001_TC_01  @AR/AP
Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of invoice booking
Then Get the tax details and check the details

@KUBS_AR_AP_UAT_002_001_TC_02  @AR/AP
Scenario: Verify Accounting entries post Debit note is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Active Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Debit Note is approved

@KUBS_AR/AP_UAT_002_001_TC_03  @AR/AP
Scenario: Verify Balance sheet post Debit Note is approved.
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

 @KUBS_AR/AP_UAT_002_001TC_04  @AR/AP
    Scenario: Verify Accounts Receivable Report post bill is approved.
   Given user navigate to azentio url and login as maker
   When click the Account Receivable main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search sale of assert in debit list
   And click first eye icon in list view 
   And get the debit note number and buisnes partner name,debit note date
    And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report
   
   
   
   
   @KUBS_AR/AP_UAT_002_002_TC_01  @AR/AP
Scenario: Verify Tax details is correctly displayed for Item details in Billing.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
When click on eye button of the invoice booking
Then Get the tax details and check the details

 @KUBS_AR/AP_UAT_002_002TC_02  @AR/AP
   Scenario: Verify Accounting entries post Credit Note is approved
   Given user login as Azentio Maker
   When click the Account Receivable Main Module for verify Accounting entries
   And click the credit note eye icon
   And click the search icon in the list view of credit 
   And search the Active credit note and click the first list
   And store the credit note number
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   And select the Transaction Ref No as Credit note Number
   Then Verify the Credit note number in Voucher Id and verify transaction type 

   @KUBS_AR/AP_UAT_002_002_TC_03  @AR/AP
Scenario: Verify Balance sheet post Crdit Note is approved.
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

@KUBS_AR/AP_UAT_002_002_TC_04
Scenario: Verify Accounts Receivable Report post credit note is Active
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as Active
   And click first eye icon in list view Searched
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Credit note
   And select the date
   And click the view icon
   Then verify the Credit Note Active is available in the report



@KUBS_AR/AP_UAT_002_003_TC_01  @AR/AP
Scenario: Advance to employee must be created and displayed in approved list view.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
Then Fill the form for Account Recivable
Then Click on save button to save the Record for Account Recivable
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR_AP_UAT_002_003_TC_02  @AR/AP
Scenario: Verify No accounting entry is generated on approval of advances to Employees
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on Active advances to Employees




@KUBS_AR/AP_UAT_002_004	@TC_01  @AR/AP
Scenario: Create Advance against PO
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Account Recivable buttonT
Then Click on Account Recivable Advances eye buttonT
Then Click to add record in Account RecivableT
Then Fill the form for Account RecivableT
Then Click on save button to save the Record for Account RecivableT
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Account Recivable buttonT
Then Click on Account Recivable Advances eye buttonT

@KUBS_AR_AP_UAT_002_004_TC_02  @AR/AP
Scenario: Verify No accounting entry is generated on approval of advances against PO
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on Active advances against PO

@KUBS_AR/AP_UAT_002_004 @TC_03  @AR/AP
Scenario: Verify creating advane against PO with amount greater than PO amount is not allowed
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Account Recivable buttonT
Then Click on Account Recivable Advances eye buttonT
Then Click to add record in Account RecivableT
Then Fill the form for Account Recivable with amount greater than PO amount

 @KUBS_AR/AP_UAT_003_001TC_01  @AR/AP
  Scenario: verify contract report should display the correct info for logged in branch
  Given user login as azentio maker for contract report verification
  When user click Accounts Payable for contract report verification
  And user click Vendor Contracts eye icon for contract report verification
   And click the first eye icon in the list for contract report verification
   And get buisness partner name,get contract end date and get contract acccount code,get contract status
   And click the notes option for contract report verification 
   And click the Reports Sub Module
   And click the contract report edit icon
   And select the vendor name according to contract
   And select the contract status based on we get from list
   And select the date based on contract end date
   And click the view icon
   Then verify the contract code in contract report
   
  @KUBS_AR/AP_UAT_003_001TC_02  @AR/AP
  Scenario: Verify creating po against cancelled order is not allowed
    Given user navigate to the url and login as a maker
    When user click Accounts Payable
    And user click Vendor Contracts eye icon
    And user click search icon
    And user search cancelled vendor contract
    And user click the cancelled vendor contract eye icon
    And get buisness partner name and get contract name
    And click vendor purchase order eye ion
    And click vendor purchase order add ion
    And select buisness partner we get in cancelled list
    And select referece type as contract
    And select the contract Name
    Then verify not able to select contract and po creation is not allowed
    
@KUBS_AR/AP_UAT_003_001TC_03  @AR/AP
Scenario: check cancellation of contract is not allowed when purchase order is created against contract
Given user navigate to the url and login as a maker for cancellation of contract is not allowed
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
#And verify the record got approved from checker
Then logout from checker
And login with Maker ID
   When click the accounts payable
   And click vendor purchase order eye ion
   And click search icon in list view
   And search PO status as Active
   And click the first eye icon in the list
   And get contract name in vendor 
   And click the vendor contract eye icon sub module
   And click the eye icon in list based on contractname
   And get buisness partner name and get contract acccount code
   And click the ar ap adjustment sub module
   And click ar ap eye icon
   And click add icon
   And select bp name according to bp we get in contratc
   And select adjustment type as cancellation
   And select adjustment item type as contract
   And select adjustment reference as we get in contract account code
   Then verify that cancellation of contract is not allowed when po created for contract
   
   
   
   
   
    @KUBS_AR/AP_UAT_003_002_TC_01  @AR/AP
  Scenario: verify contract report should display the correct info for logged in branch
  Given user login as azentio maker for contract report verification
  When user click Accounts Payable for contract report verification
  And user click Vendor Contracts eye icon for contract report verification
   And click the first eye icon in the list for contract report verification
   And get buisness partner name,get contract end date and get contract acccount code,get contract status
   And click the notes option for contract report verification 
   And click the Reports Sub Module
   And click the contract report edit icon
   And select the vendor name according to contract
   And select the contract status based on we get from list
   And select the date based on contract end date
   And click the view icon
   Then verify the contract code in contract report
   
   @KUBS_AR_AP_UAT_003_002_TC_02  @AR/AP
Scenario: Check PO Report
And click on accounts Payable module
And goto po creation module
Then click on search
And search for the active po
And get the approved po reference number and get the business partner name
Then click on report segment button
And click on report main menu
And goto po report
And enter business partner name in po report
And click on date icon
And give date in report
And enter po status in po report
And click on the view button
Then verify the approved po number is availabe in the po report

   @KUBS_AR/AP_UAT_003_002_TC_03  @AR/AP
Scenario: Check creating GRN against cancelled PO is not allowed
And click on accounts Payable module
Then click on po creation module 
And search for cancelled po
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
And click notification button
Then choose first record in the notification record
Then go to Item details and enter po number

@KUBS_AR/AP_UAT_003_002_TC_04
Scenario: Check Budget utilization is re-instated
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract give budgetcode maped expense code
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
Then logout from checker
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after creating po 
And click on accounts Payable module 
And goto po creation module
Then get the approved Po number which is created newly
And click the ar ap adjustment sub module
And click ar ap eye icon
And click add icon
Then enter business partner name and po number for cancellation 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after cancelling the po
Then verify budget code budget utilization amount is re-instated after cancelling the po

@KUBS_AR_AP_UAT_003_002_TC_05  @AR/AP
Scenario: Check PO cancellation is not allowed if GRN has been approved against that PO
And click on accounts Payable module
Then click on po creation module
And search for approved po
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
Then go to Item details and enter po number for approval
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then enter remark in confirmation alert in grn 
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then enter remark in confirmation alert in grn
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then enter remark in confirmation alert in grn 
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
Then go to ar ap adjustment module
And click on Add Icon
Then validate the po is not available for adjustment
   

   
   
   
   @KUBS_AR_AP_UAT_003_003_TC_01  @AR/AP
Scenario: Check GRN Report
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
#Then Enter the GRN status cancel
Then Enter the GRN status Active
And Get BP Name and GRN Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module GRN Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give GRN Status
Then Click on View buttons
And Verify the GRN Report is correctly displayed

@KUBS_AR_AP_UAT_003_003_TC_02  @AR/AP
Scenario: Verify Accounting entries post GRN is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
Then Enter the GRN status cancel
And Get the Branchcode and Ref No
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post GRN is cancelled

@KUBS_AR_AP_UAT_003_003_TC_03  @AR/AP
Scenario: Verify Balance sheet post GRN is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
Then Enter the GRN status cancel
And Get the Branchcode and Ref No
Then Click on Table Row First Eye Icon in ARAP
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
And Give Getted Branch code 
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

@KUBS_AR_AP_UAT_003_003_TC_04  @AR/AP
Scenario: Check PO Report
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
#Then Enter the GRN status cancel
Then Enter the GRN status Active
And Get BP Name and GRN Number
Then Click on Table Row First Eye Icon in ARAP
Then Click on Item Details
And Get PO Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Po Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give GRN Status
Then Click on View buttons
And Verify the PO Report is correctly displayed

@KUBS_AR_AP_UAT_003_003_TC_05  @AR/AP
Scenario: Check creating Bill against cancelled GRN is not allowed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
Then Enter The GRN No
And Enter the GRN status
Then Click on Table Row First Eye Icon in ARAP
And Get the Required Details
Then Click on Item Details
And Get PO Number
Then Open Invoice Bill Booking Eye icon
And Click Add icon button
Then Enter the Invoice Type
And Enter Business Partner Name
Then Enter Cost Center value
And Enter Supplier Referance Number
And Enter Flat Discount Invoice Amount
Then Give Mode of payment
And Save the Invoice Bill Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click on AP Invoice Against PO Tab
And Enter The PO Number and Validate

@KUBS_AR_AP_UAT_003_003_TC_06  @AR/AP
Scenario: Check GRN cancellation is not allowed if Bill has been approved against that GRN
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
And Enter the Invoice Bill Booking status
Then Click on Table Row First Eye Icon in ARAP
And Store the Business partner Value
Then Click on AP Invoice Against PO Tab
And Get the Required Number
And Click On Main module Accounts payable
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Enter the Adjustment Item Type
And Enter the Adjustment Ref No and Validate





@KUBS_AR/AP_UAT_003_004TC_01  @AR/AP
   Scenario: verify accounting entries post bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And click the notes option in top
   And click the enquiry module
   And click the financial transaction edit icon
   And select the branch code as azentio main branch
   And select the transaction from date 
   And select the transaction to date
   And click the view option
   Then verify that the invoice number get from bill matches with voucher id in report
   
   @KUBS_AR/AP_UAT_003_004TC_02  @AR/AP
   Scenario: Verify Balance sheet post Bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR/AP_UAT_003_004TC_03  @AR/AP
   Scenario: verify Accounts payable report post bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
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
   
   @KUBS_AR/AP_UAT_003_004TC_04
   Scenario: Check Budget utilization is re-instated
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract give budgetcode maped expense code
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
Then logout from checker
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after creating po 
And click on accounts Payable module 
And goto po creation module
Then get the approved Po number which is created newly
And click the ar ap adjustment sub module
And click ar ap eye icon
And click add icon
Then enter business partner name and po number for cancellation 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after cancelling the po
Then verify budget code budget utilization amount is re-instated after cancelling the po
   
   @KUBS_AR/AP_UAT_003_004TC_05  @AR/AP
   Scenario: verify cancelled bill is not allowed for payment settlement
   When click the invoice eye icon in accounts payable
   And click the search icon in invoice booking list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And click the payment settlement eye icon
   And click the add icon in payment settlement
   And select payment option as buisness partnerwise 
   And select buisness partner in payment settlement
   Then verify that no bill is available for payment settlement
   
   
   
   
   
   @KUBS_AR/AP_UAT_003_005_TC_01  @AR/AP
Scenario: Verify Accounting entries post Bill is cancelled
And Go to invoice bill booking module
Then click on search
And search for cancelled bill
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the accounting entries for the cancelled bill

@KUBS_AR/AP_UAT_003_005_TC_02  @AR/AP
Scenario: Verify Balance sheet post Bill is cancelled
And Go to invoice bill booking module
Then click on search 
And search the cancelled bill
And get the transcationDate
Then click on report segment button
And click on financial reporting main menu
And click on temp view near by balance sheet sub menu
And select branch in balance sheet
And enter the transaction date
And click on the view button
Then Verify Balance sheet post Bill is cancelled

   @KUBS_AR_AP_UAT_003_005_TC_03  @AR/AP
Scenario: Verify Accounts Payable Report post bill is cancelled.(With PO)
And Go to invoice bill booking module
Then click on search
Then search the cancelled invoice number with po
And get the invoice number and business partner name
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter the business partner name for cancelled invoice
And click on date icon
And give date in report
And enter the payable status as cancelled 
And click on the view button
Then verify the cancelled invoice number is available in the accountspayable report

@KUBS_AR_AP_UAT_003_005_TC_04  @AR/AP
Scenario: Verify Cancelled bill is not available for payment settlement
And Go to invoice bill booking module
Then click on search 
And search the cancelled bill
And Go to payment settlement module
And click on Add Icon
And fill the form for payment settlement
And find the invoice reference number is availabe at the billing queue 
   
   
   
   
   
   @KUBS_AR_AP_UAT_003_006_TC_01  @AR/AP
Scenario: Verify Accounting entries post Debit Note is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Debit Note is cancelled

@KUBS_AR_AP_UAT_003_006_TC_02  @AR/AP
Scenario: Verify Balance sheet post Debit Note is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get the Branch Name in wait
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
And Give Getted Branch code 
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

@KUBS_AR_AP_UAT_003_006_TC_03  @AR/AP
Scenario: Verify Accounts Receivable Report post Debit Note is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Receivable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify Accounts Receivable Report post Debit Note is cancelled

@KUBS_AR_AP_UAT_003_006_TC_04  @AR/AP
Scenario: Verify Cancelled Debit Note is not available for adjustment at Payment Settlement screen
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Store The Business partner and Invoice Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give Business partner Name
Then Choose value date as System current date
And find the invoice reference number for cancelled DebitNote is availabe at the billing queue

@KUBS_AR_AP_UAT_003_006_TC_05
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given user navigate to azentio url and login as maker
When click the account payable main module 
And click the eye icon of invoice bill booking
And click the search icon in list view
And search invoice type as Invoice Against Po
And click the first eye icon in the list view of Active invoice bill
And get the invoice number for DebitNote
When click the account payable main module
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
Then click on add button
And Fill the required fields in debit note
And Click save button  
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Active Value In Debit Not Status
Then Click on Table Row First Eye Icon
And Get The Bp Name and Debit Number Store It
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
#Then Give Current business Date
And find the Debit reference number for Active Debit is availabe at the billing queue
Then Click the Debit Note Checkbox As Tick
When Enter the Description value
And Save The Payment settlement Record
#Then Click the Alert message as Yes
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type
And Give the Adjustment Ref No and Validate










@KUBS_AR/AP_UAT_003_007TC_01  @AR/AP
   Scenario: Verify Accounting entries post Credit Note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable Main Module for verify Accounting entries
   And click the credit note eye icon
   And click the search icon in the list view of credit 
   And search the cancelled credit note and click the first list
   And store the credit note number
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the Credit note number in Voucher Id and verify transaction type
   
   @KUBS_AR/AP_UAT_003_007TC_02  @AR/AP
   Scenario: Verify Balance sheet post Credit Note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR/AP_UAT_003_007TC_03  @AR/AP
   Scenario: Verify Accounts Receivable Report post credit note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Credit note
   And select the date
   And click the view icon
   Then verify the Credit Note cancelled is available in the report
   
   @KUBS_AR/AP_UAT_003_007TC_04  @AR/AP
  Scenario: verify credit cancelled is not available in payment settlement
   Given login azentio as maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get invoice number and get buisness partner name
   And click account payable main module
   And click the eye icon in account payable
   And click the add icon in payment settlement for credit
   And select payment option as buisness partnerwise for credit
   And select buisness partner in payment settlement for credit
   Then verify that invoice from credit not is not available in bill list
   
    @KUBS_AR/AP_UAT_003_007_TC_05
    Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement
   Given user navigate to the url and login as a maker for cancellation of contract is not allowed
	 And click on accounts Payable module
	 And goto vendor contract module
	 And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
#And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And search for approved po
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
Then go to Item details and enter po number for approval
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then enter remark in confirmation alert in grn 
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then enter remark in confirmation alert in grn
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then enter remark in confirmation alert in grn 
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And get the approved po number from approved record
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record
And goto invoice bill booking temp view and select the record
And fill The invoice againse po record
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking 
And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And get the approved invoice from table
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field for settle the payment
And fill the calender details and description
And Save the form
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on submit button in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on submit button in alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
When click the Account Receivable Main Module for verify Accounting entries
   And click the credit note eye icon
   And click the search icon in the list view of credit 
  And search the Active credit note and click the first list
   And get buisness partner name , get credit note number and get credit note date
   
   Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner according to creditnote
And Give The Adjustment Type
Then Give the credit note number in Adjustment Item Type
And Give the Adjustment Ref No and Validate
   



   
   
   @KUBS_AR/AP_UAT_003_008_TC_01  @AR/AP
Scenario: Verify No accounting entry is generated on cancelling advances to employees
Then go to ar ap adjustment module
Then click on search
And search the Ar cancelled advance in the adjustment screen
And select one record 
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then adjustment reference number not availabe in the GL  record

@KUBS_AR/AP_UAT_003_008_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
And Goto accounts receivable advances module
Then click on search 
And select one record from advances
Then go to ar ap adjustment module
And click on Add Icon
And Fill The form for advance adjustment
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the form for cancelled advances
And find the invoice reference number for cancelled advance is not availabe at the billing queue


@KUBS_AR_AP_UAT_003_008_TC_03  @AR/AP
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
And Goto accounts receivable advances module
Then click on search
And select the advance to employee active record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
And fill the form for settlement
And Save the form
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And goto arap adjustment main module
Then go to ar ap adjustment module
And click on Add Icon
Then check the settlement completed advance can be cancelled




@KUBS_AR_AP_UAT_003_009_TC_01  @AR/AP
Scenario: Verify No accounting entry is generated on cancelling advances against PO
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on cancelling advances against PO

@KUBS_AR_AP_UAT_003_009_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for cancelled Advances is availabe at the billing queue

@KUBS_AR_AP_UAT_003_009_TC_03  @AR/AP
Scenario: Verify cancelling Against PO is not allowed if the same has been adjusted at payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for Active Advances is availabe at the billing queue
Then Click the Checkbox As Tick
When Enter the Description value
And Save The Payment settlement Record
Then Click the Alert message as Yes
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type as AR Advance
And Give the Advance Adjustment Ref No and Validate





@KUBS_AR/AP_UAT_004_001TC_01  @AR/AP
  Scenario: verify active bill is available for payment settlement
  Given log in to azentio as maker
  When click the Account payable module
  And click the invoice booking eye icon in sub module
  And search Invoice status as active
  And click the first eye icon in the list view
  And get the buisness partner from invoice bill
  And click the payment settlement eye icon in Accounts payable
  And click the add icon fot the payment settlement
  And choose the payment option as Buisness partner Type
  And Enter buisness partner get from bill booking
  Then verify that active bill is available for payment settlement
 
 @KUBS_AR/AP_UAT_004_001TC_02  @AR/AP
  Scenario: verify tds% and amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option
  When click the Account payable Mainmodule
  And click the eye icon of the payment settlement
  And click the add icon of the payment settlement
  And select payment option as buisness partner type
  And select the buisness partner from the list
  And select listed bill contains tds percentage
  And get tds percentage and calculate tds amount
  Then verify tds in bill with calculated tds amt
 
 @KUBS_AR/AP_UAT_004_001TC_03  @AR/AP
  Scenario: verify net payable amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option for verify net payable amount 
  When click the Account payable Mainmodule for verify net payable amount 
  And click the eye icon of the payment settlement for verify net payable amount 
  And click the add icon of the payment settlement for verify net payable amount 
  And select payment option as buisness partner type for verify net payable amount 
  And select the buisness partner from the list for verify net payable amount 
  And select the bill in the list view
  And calculate the net payable amount from the bill in list view 
  Then verify netpayable amount in payment settlement with calculated amount
  
  @KUBS_AR/AP_UAT_004_001TC_04  @AR/AP
  Scenario: verify pop up messages displayed and click yes to payment process
  Given log into azentio as maker and select finance option for verify pop up
  When click the Account payable Mainmodule for verify pop up
  And click the eye icon of the payment settlement for verify pop up
  And click the add icon of the payment settlement for verify pop up
  And select payment option as buisness partner type for verify pop up
  And select the buisness partner from the list for verify  pop up
  And select any bill in list view
  And choose the valid date
  And Enter the description
  And Click save button
  And pop up messages displayed and  click yes
  Then verify bill is proceed for payment
 
 @KUBS_AR/AP_UAT_004_001TC_05  @AR/AP
  Scenario: verify pop up messages displayed and click no to  return payment settlement
  Given log into azentio as maker and select finance option for verify pop up display
  When click the Account payable Mainmodule for verify pop up display
  And click the eye icon of the payment settlement for verify pop up display
  And click the add icon of the payment settlement for verify pop up display
  And select payment option as buisness partner type for verify pop up display
  And select the buisness partner from the list for verify pop up display
  And select any bill in list view for verify pop up display
  And choose the valid date for verify pop up display
  And Enter the description for verify pop up display
  And Click save button  for verify pop up display
  And pop up messages displayed and click no
  Then verify bill is not proceed for payment and return to payment settlement
  
  @KUBS_AR/AP_UAT_004_001TC_06  @AR/AP
  Scenario: verify accounting entries post payment settlement approval
   Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and verify payment Approval
   
    
   @KUBS_AR/AP_UAT_004_001Tc_07  @AR/AP
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   #need to give cancelled txt number
   
   
   @KUBS_AR/AP_UAT_004_001TC_08  @AR/AP
   Scenario: Verify Accounts Payable Report post payment settlement approval
    Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And get buisness partner name and payment settlement date
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   
  
   
@KUBS_AR_AP_UAT_004_002_TC_01  @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement
And Goto accounts receivable advances module
And click on Add Icon
And Fill the mendatory fields for creating advance to employee
And Save the advance record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And Goto accounts receivable advances module
And get the receivable number from aproved record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
Then verify approved record is availabe for payment settlement


@KUBS_AR/AP_UAT_004_002_TC_02  @AR/AP
Scenario: Verify No accounting entries are posted post payment settlement approval.
Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the Branch detail
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate No accounting entries are posted



@KUBS_AR_AP_UAT_004_003_TC_01  @AR/AP
Scenario: Verify Advance (Against PO) is available in the system for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner Value
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for Active Advances is availabe at the billing queue

@KUBS_AR_AP_UAT_004_003_TC_02  @AR/AP
Scenario: Verify No accounting entries are posted post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Enter Txn Number in payment Settlement
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
Then Verify No Accounting entries are posted post payment settlement approval

 @KUBS_AR/AP_UAT_004_004TC_01  @AR/AP
   Scenario: Verify debit note is adjusted against the bill and Net adjusted value is correctly displayed
   Given log in as a Maker and select finance option for verify debit note against bill
   When click Account receivable Main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search Active in debit note status
   And click first eye icon in list view 
   And get buisness partner name and invoice number
   And click Account Payable Main Module for verify debit note against bill
   And click eye icon in Payment Settlement for verify debit note against bill
   And click the add icon of the payment settlement for verify debit note against bill
   And select payment option as buisness partner type for verify debit note against bill
   And Select buisness partner according to debit note buisnes partner
   And search the invoice number based on invoice after click bill and get gross,debit amount
   Then calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list
   Then verify net adjusted value in bill with net adjusted value shown in payment settlement page
   
   @KUBS_AR/AP_UAT_004_004TC_02  @AR/AP
   Scenario: verfiy tds percent and tds value correctly calculated and displayed based on debit note
   Given log in as a Maker and select finance option for verify tds in debit note against bill
   When click Account receivable Main module for verify tds in debit note against bill
   And click debit note eye icon for verify tds in debit note against bill
   And click search button and then click debit note status search for verify tds in debit note against bill
   And search Active in debit note status for verify tds in debit note against bill
   And click first eye icon in list view for verify tds in debit note against bill
   And get buisness partner name and invoice number for verify tds in debit note against bill
   And click Account Payable Main Module for verify tds in debit note against bill
   And click eye icon in Payment Settlement for verify tds in debit note against bill
   And click the add icon of the payment settlement for verify tds in debit note against bill
   And select payment option as buisness partner type for verify tds in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get
   And get tds percent , net adjusted,tds amount based on invoice then click bill
   And calculate tds value based on tds percent and net adjusted value and verify with tds value in bill
   And get tds value from payment settlement for debit note
   Then verify calculated tds value equals to tds value get from payment settlement and correctly displayed
   
   @KUBS_AR/AP_UAT_004_004TC_03  @AR/AP
   Scenario: verify net Payable amount is correctly calculated and displayed for debit note bill in payment settlement
   Given log in as a Maker and select finance option for verify Netpayable amount in debit note against bill
   When click Account receivable Main module for verify Netpayable amount in debit note against bill
   And click debit note eye icon for verify Netpayable amount in debit note against bill
   And click search button and then click debit note status search for verify Netpayable amount in debit note against bill
   And search Active in debit note status for verify Netpayable amount in debit note against bill
   And click first eye icon in list view for verify Netpayable amount in debit note against bill
   And get buisness partner name and invoice number for verify Netpayable amount in debit note against bill
   And click Account Payable Main Module for verify Netpayable amount in debit note against bill
   And click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill
   And click the add icon of the payment settlement for verify Netpayable amount in debit note against bill
   And select payment option as buisness partner type for verify Netpayable amount in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get in debit list view
   And get gross amount, debit amount,tds percent,netpayable amount
   And calculate net adjusted value , tds value from net adjusted
   And Calcualte net payable amount from calculated net adjusted value and tds value
   Then verify calculated net payable amount with net payable amount get from debit bill
   And get net payable amount from payment settlement
   Then verify net payable amount is correctly displayed according to debit bill
   
   @KUBS_AR/AP_UAT_004_004TC_04  @AR/AP
   Scenario: verify accounting entries post payment Approval for debit transaction
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and then payment approved
   
	@KUBS_AR/AP_UAT_004_004_TC_05  @AR/AP
	Scenario: Verify Balance sheet post payment settlement approval.
	Given Navigate to URL and user should login as a maker
	Then Click on Report buttonT
	And click Enquiry menu
	Then click on Edit icon near by financial transaction
	And choose branch code Id

	And click on transaction from date in calender icon
	Then choose from date in the calender
	And click on the transaction to date in calender icon
	Then choose the To date in the calender
	And click on view button to see the Record
	Then Verify record is available in the sheet or not
	
   @KUBS_AR/AP_UAT_004_004TC_06  @AR/AP
   Scenario: Verify Accounts Payable Report post payment settlement approval for debit note
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get buisness partner name and payment settlement date, invoicenumber
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   
    @KUBS_AR/AP_UAT_004_004TC_07  @AR/AP
   Scenario: verify Receivable Report post payment Approval for debit note
   Given user navigate to azentio url and login as maker
   When click the Account Receivable main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search sale of assert in debit list
   And click first eye icon in list view 
   And get the debit note number and buisnes partner name,debit note date
    And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report
   
   
   
@KUBS_AR_AP_UAT_004_005_TC_01  @AR/AP
Scenario: Verify Credit Note is adjusted against the selected bill and Net Adjusted Value is correctly displayed
And click on accounts Payable module
And goto invoice booking module
And click on Add Icon
And fill the mendatory field for invoice booking module module
And goto invoice bill booking temp view and select the record
And fill the second tab details details
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field to check

@KUBS_AR_AP_UAT_004_005_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
And click on accounts Payable module
And goto invoice booking module
And click on Add Icon
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field to check the the TDS percent and TDS ammount

@KUBS_AR_AP_UAT_004_005_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed.
And click on accounts Payable module
And goto invoice booking module
And click on Add Icon
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field to check the the net payable ammount
And fill the calender details and description
And Save the form
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

@KUBS_AR/AP_UAT_004_005_TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement approval
#And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify approved settlement reference number is available in the Gl report
 @KUBS_AR/AP_UAT_004_005TC_05  @AR/AP
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.

@KUBS_AR_AP_UAT_004_005_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
And click on accounts Payable module
And Go to payment settlement module
And open the recently payment settlement approved record
And get the approved invoice number and business partner
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter the payment settled business partner 
And click on date icon
And give date in report
And give payable status in accounts payable report for approved invoice
And click on the view button
Then verify the payment settlement invoice number is available in the report

@KUBS_AR_AP_UAT_004_005_TC_07  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval.
And click ok segment segmant button
And goto accouts receivable module
And goto credit notet module
And select the approved credit note reference number
And get the credit note amount 
And get the business partner name from approved credit note
Then click on report segment button
And click on report main menu
And click on temp view near by accounts receivable report
And click on business partner for settled credit note
And click on date icon
And give date in report
And enter active credit note status in accounts Receivable module
And click on the view button
Then verify the approved credit note is available in the receivable report


@KUBS_AR_AP_UAT_004_006_TC_01  @AR/AP
Scenario: Verify Advance against PO is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net Adjusted Value is correctly displayed

@KUBS_AR_AP_UAT_004_006_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the TDS % & amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_006_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net payable amount is correctly calculated & displayed

#@KUBS_AR_AP_UAT_004_006_TC_04
#Scenario: Verify accounting entries post payment settlement approval
#Given Navigate The Azentio Url
#Then Choose the second Tab Segment
#And Click On Main module Accounts payable
#Then Click sub module Payment settlement Eye Icon
#And Click On Search Icon
#Then Enter Advance Against PO and Active Value In Advance Status
#And Enter Advance Against Po Pan Number
#Then Click on Table Row First Eye Icon in ARAP
#Then Third Segment report Icon
#And Choose Enquiry Module
#Then Click Note iCon near by financial transction
#And choose branch codes
#And click on transaction from date in calender
#Then Select from date in calender
#And click on transaction to date in calender icon
#Then Select To date in calender
#And Click View HyperLink
#Then Verify Accounting entries post payment settlement approval

@KUBS_AR_AP_UAT_004_006_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get the Branch Name
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
And Give Getted Branch code 
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

#KUBS_AR_AP_UAT_004_006_TC_06 - Not Automatable

@KUBS_AR_AP_UAT_004_006_TC_07  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report post payment settlement approval

@KUBS_AR_AP_UAT_004_006_TC_08  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Receivable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Receivable Report post payment settlement approval


@KUBS_AR_AP_UAT_004_007_TC_01  @AR/AP
Scenario: Verify Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name as Advance to employee
And Enter Business partner Value For Employee
#Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net Adjusted Value is correctly displayed

@KUBS_AR_AP_UAT_004_007_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the TDS % & amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_007_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net payable amount is correctly calculated & displayed


# fuctionality not available
#@KUBS_AR_AP_UAT_004_007_TC_04
#Scenario: Verify accounting entries post payment settlement approval
#Given Navigate The Azentio Url
#Then Choose the second Tab Segment
#And Click On Main module Accounts payable
#Then Click sub module Payment settlement Eye Icon
#And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
#And Enter Advance to employee Pan Number
#Then Click on Table Row First Eye Icon in ARAP
#Then Third Segment report Icon
#And Choose Enquiry Module
#Then Click Note iCon near by financial transction
#And choose branch codes
#And click on transaction from date in calender
#Then Select from date in calender
#And click on transaction to date in calender icon
#Then Select To date in calender
#And Click View HyperLink
#Then Verify Accounting entries post payment settlement approval fo Advance to Employee

@KUBS_AR/AP_UAT_004_007_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

@KUBS_AR_AP_UAT_004_007_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report post payment settlement approval

@KUBS_AR_AP_UAT_004_007_TC_07  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Receivable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Receivable Report post payment settlement approval


@KUBS_AR_AP_UAT_004_008_TC_01  @AR/AP
Scenario: Verify on payment date (As per Bill), settlement for the bill is auto approved.
Given Navigate to KUBS URL and login with maker credentials
And click on arap configuration main menu
And click on view button near by arap configuration 
And select the arap configuration record
And give auto payout as yes
And save the configuration record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number

And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
#And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And search for approved po
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
Then go to Item details and enter po number for approval
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then enter remark in confirmation alert in grn 
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then enter remark in confirmation alert in grn
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then enter remark in confirmation alert in grn 
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And get the approved po number from approved record
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record
And goto invoice bill booking temp view and select the record
And fill The invoice againse po record
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And get the approved invoice from table
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field for settle the payment
And fill the calender details and description
And Save the form
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on submit button in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on submit button in alert
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And go to auto payout module 
And select the record from temp view
And fill the valued date
And fill the mendatory fields for auto payout record 
Then save the auto payout record
And select the record from temp view and initiate
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

@KUBS_AR_AP_UAT_004_008_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement approval (Auto payout)
And click on accounts Payable module
And Go to payment settlement module
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify approved settlement reference number is available in the Gl report




@KUBS_AR/AP_UAT_005_001_TC_01  @AR/AP
  Scenario: User cancels the payment settlement transaction for multiple bills.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
 @KUBS_AR/AP_UAT_005_001_TC_02  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
     @KUBS_AR/AP_UAT_005_001_TC_03  @AR/AP
  Scenario: Verify canceling payment settlement is not allowed if payout for the transaction is approved.
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation of aprroved payout and verify
    
@KUBS_AR_AP_UAT_005_001_TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Cancellation Eye Icon
Then Click on Table Row First Eye Icon in ARAP
And Get the Cancelled Txn Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post payment settlement cancellation

@KUBS_AR/AP_UAT_005_001_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement cancellation.

Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

@KUBS_AR_AP_UAT_005_001_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post canceling payment settlement cancellation
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And search the cancelled payment settlement record 
And get the invoice number of cancelled payment settlement record
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter the payment settled business partner 
And click on date icon
And give date in report
And give the status in payment settlement report section
And click on the view button
Then verify the payment settement invoice number is available in the payable report





 @KUBS_AR/AP_UAT_005_002_TC_01  @AR/AP
  Scenario: User cancels the payment settlement transaction for multiple bills.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
 @KUBS_AR/AP_UAT_005_002_TC_02  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_002_TC_03  @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And search for approved record in view area
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And give the refrence number which we going to see accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report

@KUBS_AR/AP_UAT_005_002_TC_04  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.

Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

 @KUBS_AR/AP_UAT_005_002TC_05  @AR/AP
    Scenario: Verify Accounts Payable Report post cancelling payment settlement txn
    Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And get buisness partner name and payment settlement date
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   
   
   
   
   
    @KUBS_AR/AP_UAT_005_003_TC_01  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_003_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And search for approved record in view area
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And give the refrence number which we going to see accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report


 @KUBS_AR/AP_UAT_005_004_TC_01  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_004_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Cancellation Eye Icon
And Click On Search Icon
Then Enter Txn No for Advance to Empolyee
Then Click on Table Row First Eye Icon in ARAP
And Get the Cancelled Txn Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries Advance to Empolyee post payment settlement cancellation




#@KUBS_AR/AP_UAT_006_001_TC_01
  #Scenario: Creating Manual payouts for approved Bills of a Vendor
   #	Given Maker Navigate to UAT URL login
#		Then Click on Direction icon
#		Then Click on Account Payable 
    #When click on eye button of manual payout
    #And click on add button for manual payout
  #	And Fill the required fields for manual payout
 #	 	Then Click on save button to save the Record for Account Recivable
#		Then Click on Update Deposited Cheque Notification
#		And Select and Submit the Update Deposited Cheque record
#		Then log in to the reviewer account
#		Then click on the Notification select the Cheque record and Approve
#		Then log in to the Checker Account
#		And then checker claim the record
#		Then click on the checker Notification 
#		And select the Cheque record and Approve by checker
    #
    #Given Maker Navigate to UAT URL login
#		Then Click on Direction icon
#		Then Click on Account Payable 
    #When click on eye button of manual payout
    #Then Get the payout status
   
  @KUBS_AR/AP_UAT_006_001_TC_01_Vendor  @AR/AP
  Scenario: Creating Manual payouts for approved Bills of a Vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout vendor
    Then Save and submit the manual payout record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
	
@KUBS_AR_AP_UAT_006_001_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval (Manual payout for multiple bill)
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the active record in the manual pay out and get the transaction reference number
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the manual payout is appeared in the accounting entries

@KUBS_AR/AP_UAT_006_001_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given Navigate to URL and user should login as a maker
Then Click on Report buttonT
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then Verify record is available in the sheet or not

@KUBS_AR_AP_UAT_006_001_TC_04  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval (Payout for multiple bills)
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the multiple bill payout approved reference number
And click on that record
And get the invoice number
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter businessPartner name for multiple record
And click on date icon
And give date in report
And give status of the settlement record
And click on the view button
Then verify the approved invoice reference number are available in the payable report
  
@KUBS_AR_AP_UAT_006_001_TC_05  @AR/AP
Scenario: Verify Payout Report post payout approval (Payout for multiple bills)
And click on accounts Payable module
And click on view button near by manual payout module
And get the recently approved payout reference number 
Then click on report segment button
And click on report main menu
And click on the payout report
And enter business partner name for payout report
And click on date icon
And give date in report
And enter payout status in payout report
And click on the view button
Then  verify approved payout reference number is available in the payout report

  
  @KUBS_AR/AP_UAT_006_002_TC_01  @AR/AP
  Scenario: Creating manual payouts for approved advances of a vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout
    Then Save and submit the manual payout record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    


@KUBS_AR_AP_UAT_006_002_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
And get the recently approved payout reference number 
Then click on report segment button
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the approved payout reference number is available in the accounting entries screen



@KUBS_AR_AP_UAT_006_002_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click on Sub module Maual payout
Then Click on Table Row First Eye Icon in ARAP
And Get the manual payout Branch Name
And Get the Referance Number
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
And Give Getted Branch code 
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved


@KUBS_AR_AP_UAT_006_002_TC_04  @AR/AP
Scenario: Verify Accounts Receivable Report post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the advance approved reference number in the reference number search column
And get the business partner nname
And click on the perticular suggestion record and get the advance reference number
Then click on report segment button
And click on report main menu
And click on temp view near by accounts receivable report
And enter the business partner name for advances to employee 
And click on date icon
And give date in report
And enter the advances to employee status active
And click on the view button 
Then verify the advance reference number is available in the accounts Receivable report

@KUBS_AR_AP_UAT_006_002_TC_005  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the payout completed reference number
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter businessPartner name for multiple record
And click on date icon
And give date in report
And give status of the settlement record
And click on the view button
And verify the advance record is available in the payable report section


@KUBS_AR_AP_UAT_006_002_TC_06  @AR/AP
Scenario: Verify Payout Report post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
And get the recently approved payout reference number 
Then click on report segment button
And click on report main menu
And click on the payout report
And enter business partner name for payout report
And click on date icon
And give date in report
And enter payout status in payout report
And click on the view button
Then  verify approved payout reference number is available in the payout report
	

 
 
  @KUBS_AR/AP_UAT_006_003_TC_01_Employee  @AR/AP
  Scenario: Creating Manual payouts for approved Bills of a Vendor
   	Given Maker Navigate to UAT URL login
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    And click on add button for manual payout
  	And Fill the required fields for manual payout
 	 	Then Click on save button to save the Record for Account Recivable
		Then Click on Update Deposited Cheque Notification
		And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
    
    Given Maker Navigate to UAT URL login
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    Then Get the payout status
    
@KUBS_AR_AP_UAT_006_003_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the active record in the manual pay out and get the transaction reference number
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the manual payout is appeared in the accounting entries

@KUBS_AR/AP_UAT_006_003_TC_03 @Report  @AR/AP
  Scenario: Verify Balance sheet post payout approval
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly

 @KUBS_AR_AP_UAT_006_003_TC_04  @AR/AP
 Scenario: Verify Accounts Receivable Report post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the advance approved reference number in the reference number search column
And get the business partner nname
And click on the perticular suggestion record and get the advance reference number
Then click on report segment button
And click on report main menu
And click on temp view near by accounts receivable report
And enter the business partner name for advances to employee 
And click on date icon
And give date in report
And enter the advances to employee status active
And click on the view button 
Then verify the advance reference number is available in the accounts Receivable report

 @KUBS_AR_AP_UAT_006_003_TC_05  @AR/AP
 Scenario: Verify payout Report post payout approval
And click on accounts Payable module
And click on view button near by manual payout module
And get the recently approved payout reference number 
Then click on report segment button
And click on report main menu
And click on the payout report
And enter business partner name for payout report
And click on date icon
And give date in report
And enter payout status in payout report
And click on the view button
Then  verify approved payout reference number is available in the payout report



@KUBS_AR/AP_UAT_007_001_TC_01  @AR/AP
Scenario: Auto payouts for approved Bills of a Vendor
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable

Then Click on Auto Payout edit grid
Then Click on action button of record which we need to verify for details


@KUBS_AR_AP_UAT_008_001_TC_01  @AR/AP
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank & Account Number Wise
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank & Account Number Wise
And save the arap configure record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on arap configuration main menu
And click on payment file generation setup sub menu
And verify payment file download format is in bank and accont number wise
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file


@KUBS_AR_AP_UAT_008_001_TC_02  @AR/AP
Scenario: Verify payment file includes only below records,Where payment mode is Wire Transfer.Beneficiary Account is NOT maintained with legal entity.
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank & Account Number Wise
And save the arap configure record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on arap configuration main menu
And click on payment file generation setup sub menu
And verify payment file download format is in bank and accont number wise
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file
And verify Where payment mode is Wire Transfer

#KUBS_AR_AP_UAT_008_002_TC_03 - NA




@KUBS_AR_AP_UAT_008_002_TC_01  @AR/AP
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank Wise
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank Wise
And save the arap configure record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on arap configuration main menu
And click on payment file generation setup sub menu
And verify payment file download format is in Bank wise wise
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file

#KUBS_AR/AP_UAT_008_002_TC_02 -Defect

#KUBS_AR/AP_UAT_008_002_TC_03 -Defect



@KUBS_AR_AP_UAT_008_003_TC01  @AR/AP
Scenario: Verify download file is auto created basis the defined time and user is allowed to download the file.
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Payout wise
And save the arap configure record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on arap configuration main menu
And click on payment file generation setup sub menu
And verify payment file download format is in Payout wise
And click on accounts Payable module
And click on view button near by manual payout module
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file

#@KUBS_AR_AP_UAT_008_003_TC_02 - NA

#@KUBS_AR_AP_UAT_008_003_TC_03 - NA



@KUBS_AR_AP_UAT_009_001_TC_01  @AR/AP
Scenario: Checking of upload payment files for online payments
And click on accounts Payable module
And click on view button near by payment file upload module
And click on Add Icon
And upload the downloaded Payment file
And click on upload button
Then verify the reference number and payout status unsuccessfull reason is visible in screen
And save the upload file record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID to approve the payment file in checker stage
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker

#KUBS_AR_AP_UAT_009_001_TC_02 - NA

#KUBS_AR_AP_UAT_009_001_TC_03 - NA


@KUBS_AR_AP_UAT_010_001_TC_01  @AR/AP
Scenario: Record a receipt through cheque mode
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click Add icon button
Then Enter Receipt type as cheque
And Enter Receipt Ref Number 
Then Enter Receipt Amount
And Enter Bank Account Number
Then Enter Receipt payer
#Then Choose value date as System current date
And Enter Remarks for Receipt
Then Save Receipt Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_001_TC_02  @AR/AP
Scenario: Record a receipt through Online mode
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click Add icon button
Then Enter Receipt type as Online
And Enter Receipt Ref Number 
Then Enter Receipt Amount
And Enter Bank Account Number
Then Enter Receipt payer
#Then Choose value date as System current date
And Enter Remarks for Receipt
Then Save Receipt Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_001_TC_03  @AR/AP
Scenario: Verify accounting entries post receipt recording
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Receipt type as Wire
Then Click on Table Row First Eye Icon in ARAP
And Get The Txn Receipt Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post receipt recording

 @KUBS_AR/AP_UAT_010_001_TC_04  @AR/AP
  Scenario: Verify Balance sheet post approval through online mode
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly post approval through online mode




@KUBS_AR_AP_UAT_010_002_TC_01  @AR/AP
Scenario: Check cheque receipts are available for the selected Bank
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID

And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
Then check our bill is appeared in the list view

@KUBS_AR_AP_UAT_010_002_TC_02  @AR/AP
Scenario: Verify status for the receipt is auto changed to Deposit
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID

And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
And select our bill
And save the bill record




@KUBS_AR/AP_UAT_010_002_TC_03 @AR/AP

Scenario: Update cheque status to Cleared
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

  @KUBS_AR/AP_UAT_010_002_TC_04  @AR/AP
  Scenario: Verify accounting entries for cleared cheques.
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of update cheque status
    Then get slip number by using cheque number
    Then click on report icon1
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the required fields of financial transaction
    Then click on view button to view the reports and verify
 
 
#@KUBS_AR/AP_UAT_010_002_TC_04
#Scenario: Verify accounting entries for cleared cheques
#
#Given Navigate to URL and user should login as a maker
#Then Click on Report buttonT
#And click Enquiry menu
#Then click on Edit icon near by financial transaction
#And choose branch code Id
#
#And click on transaction from date in calender icon
#Then choose from date in the calender
#And click on the transaction to date in calender icon
#Then choose the To date in the calender
#And click on view button to see the Record
#Then Verify record is available in the sheet or not

@KUBS_AR/AP_UAT_010_002_TC_05  @AR/AP
  Scenario: Verify Balance sheet post cheque is cleared
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly post cheque is cleared
    
    
    
    

@KUBS_AR/AP_UAT_010_003_TC_01  @AR/AP
Scenario: Bouncing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Bounced
Then Add Bank Charges
Then Select the bounced reason
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

@KUBS_AR/AP_UAT_010_003_TC_02  @AR/AP
Scenario: Verify accounting entries for bounced cheques.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate bounced cheques vourcher number 



@KUBS_AR/AP_UAT_010_004_TC_01  @AR/AP
Scenario: Update cheque status to Cleared Bouncing & redepositing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

@KUBS_AR/AP_UAT_010_004_TC_02  @AR/AP
Scenario: Verify accounting entries for bounced & redeposited cheques.
Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate cleared cheques vourcher number 
#DEP-RR88888888-20220307




@KUBS_AR/AP_UAT_010_005_TC_01  @AR/AP
Scenario: Check approved receipts are available for appropriation.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation

@KUBS_AR/AP_UAT_010_005_TC_02  @AR/AP
Scenario: Approved receivables must be list for appropriation 
					which are not cancelled or appropriated fully.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation


#Below 2 scenario are duplicates
@KUBS_AR/AP_UAT_010_005_TC_03  @AR/AP
Scenario: Verify Credit Note is not available for appropriation against receipt.
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Recivable
Then Click on Appropriation eye button
Then Click on add button of  Appropriation
Then Verify Credit Not record is available or not

@KUBS_AR_AP_UAT_010_005_TC_03  
Scenario: Verify Credit Note is not available for appropriation against receipt.
And goto accouts Receivable module
And goto credit notet module
And get the approved credit note reference number
And goto appropriation module
And click on Add Icon
And validate the credit note approved record is not available
    

@KUBS_AR/AP_UAT_010_005_TC_04 @AR/AP

Scenario: Below amount must be correctly calculated & displayed post receipt appropriation.
 				  Receipt Outstanding, Appropriation Amount, Outstanding amount for Receivables.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation
Then enter App Amount check the calculation for Outstanding amount for Receivable
Then Click on Appropriation Save button
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR/AP_UAT_010_005_TC_05  @AR/AP
  Scenario: Verify accounting entries for appropriating receipts against:
						 1. Debit Note
						 2. Advance against PO
						 3. Advance to Employee
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against debit note
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against debit note
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against advance po
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against Advance PO
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against advance employee
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against Advance to Employee

@KUBS_AR/AP_UAT_010_005_TC_06  @AR/AP
Scenario: Verify Balance sheet post appropriating receipts against:Debit Note ,Advance against PO, Advance to Employee

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for reportT
Then Select date in calendarT
Then Click on View buttonT

@KUBS_AR/AP_UAT_010_005_TC_07	  @AR/AP
Scenario: Accounts Receivable Report must display the correct info for logged in Branch

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Reports tab
Then Click on Account Receivable Report edit button
Then Fill Vendor employee details for report
Then Select date in calendar
Then select Receivable Status
Then Click on the View button



@KUBS_AR/AP_UAT_011_001_TC_01  @AR/AP
Scenario: Cancellation of approved receipts	Cancel approved receipts through Cheque Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals formm
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button

@KUBS_AR/AP_UAT_011_001_TC_02  @AR/AP
Scenario: Cancel approved receipts through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals form
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button

@KUBS_AR_AP_UAT_011_001_TC_03  @AR/AP
Scenario: Verify accounting entries post receipt cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Reverels Eye Icon
And Click On Search Icon
Then Enter Receipt Reversals type as Wire
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post receipt recording
	
@KUBS_AR/AP_UAT_011_001_TC_04  @AR/AP
Scenario: Verify Balance sheet post receipt cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for reportT
Then Select date in calendarT
Then Click on View buttonT



@KUBS_AR/AP_UAT_011_002_TC_01  @AR/AP
Scenario: Cancel receipt appropriation through cheque mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal


@KUBS_AR/AP_UAT_011_002_TC_02  @AR/AP
Scenario: Cancel receipt appropriation through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation for online mode
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal

#KUBS_AR/AP_UAT_011_002_TC_03 - Functionality NA

@KUBS_AR/AP_UAT_011_002_TC_04  @AR/AP
Scenario: Verify Balance sheet post receipt appropriation cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for reportT
Then Select date in calendarT
Then Click on View buttonT

 @KUBS_AR/AP_UAT_011_002TC_05  @AR/AP
   Scenario: Verify receipts and receivable against cancelled appropriation are available again for receipt appropriation
    Given user navigate to azentio url and login as maker
    When click the Account Receivable main module
    And click the Appropriation reversal eye icon
    And click the search icon in list view
    And search the txt num
    And click first eye icon in list view Searched
    And get Receipt Reference number
    And click the Appropriation eye icon
    And click add icon
    And select the Reference number based on we got from Appropriation reversal
    And Click save button
    Then verify Receipts and receivable against cancelled appropriation must be available again for receipt appropriation
    
    #KUBS_AR/AP_UAT_011_002_TC_06 - Functionality NA
    
    
    #KUBS_AR/AP_UAT_012_001_TC_01 - KUBS_AR/AP_UAT_012_003_TC_05 (Not Automatable)
	
	
	@KUBS_AR/AP_UAT_013_001_TC_01  @AR/AP
Scenario: Verify creating PO against contracts is not allowed if PO QTY
 					is greater than available Contract QTY For Expense Type Purchase
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order fields
Then Enter Po Quantity

@KUBS_AR/AP_UAT_013_TC_02  @AR/AP

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

@KUBS_AR/AP_UAT_013_TC_03  @AR/AP
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

@KUBS_AR/AP_UAT_013_001_TC_04  @AR/AP
Scenario: Verify Creating GRN is not allowed if total QTY of previous and current GRN is greater than PO Qty

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
Then Add Excessive PO qty received qty approved

 # invoice type,SRN should be change in json
  @KUBS_AR/AP_UAT_013_001_TC_05  @AR/AP
  Scenario: Verify creating Bill is not allowed if YTD amount for expense exceeds mapped budget code limit. 
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking with exceeded amount
    Then Save and submit the invoice billing with exceeded amount

@KUBS_AR_AP_UAT_013_001_TC_06  @AR/AP
Scenario: Verify Payment settlement txn is not available for payout if net payabe is 0.
And click on accounts Payable module
And go to invoice bill booking module
And click on Add Icon
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
And click notification button
Then choose first record in the notification record in GRN stage
And click on Submit button 
Then click on the submit button which is appeared in alert box
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
Then click on the submit button which is appeared in alert box
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then click on the submit button which is appeared in alert box
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking
And Go to payment settlement module
And click on Add Icon
And fill the payment settlement record and validate the invoice number is not available in the invoice list view


@KUBS_AR/AP_UAT_013_002_TC_01  @AR/AP
  Scenario: Verify Receivables once adjusted against Bill is not available for appropriation on Receipt appropriation screen
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of receivable debit note
    Then click on add button
    And Fill the required fields in debit note screen
    Then save and submit the record of receivable debit note
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the record of receivable debit note
    
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement against bill
    And click on add button for payment settlement against bill
    And Fill the required fields to adjust against billl
    Then Save and submit the payment settlement
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the payment settlement against bill
    
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of receivable debit note
    Then get the receivable debit number to verify
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    Then click on eye button of appropriation to verify
    Then click on add button
    Then Verify the receivable adjusted against bill is not available for appropriation
    @KUBS_AR/AP_UAT_013_002TC_01 @AR/AP
    Scenario: Verify Receivables once appropriated against a receipt is not adjusted against a bill on payment settlement screen.
And click on accounts Payable module
And go to invoice bill booking module
Then click on search
And search the invoice agaist po in invoice type area
And get the approved invoice reference to do debit note

And goto accouts Receivable module to do debit note 

And click on debit note module
And click on Add Icon
And fill the debit note details against that bill 
And save the debit note record 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID

And goto accouts Receivable module
And click on debit note module
And get the recently we approved debit note reference number
And goto appropriation module
And click on Add Icon
And do the appropriation for the debit note record
And save the appropriation record 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID

Then click on second Segment button
And Go to payment settlement module
And click on Add Icon
And check the aprropriation against bill is visible in the payment settlement or not in payment settlement module