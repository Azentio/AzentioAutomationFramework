Feature: AR/AP Module

 
 
@KUBS_AR/AP_UAT_001_001_TC_001_01  
Scenario: Create a contract for an active vendor with expense type Purchases
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
And click on add button to create contract
And user update the data set ID for vendor contract 
And Fill the required fields to create contract
And Save the Record from maker
Then click on the Notification icon
Then Search Contract Creation record in List
Then store the Reference ID and open the vendor contract record
Then click submit and enter remark for vendor contract
#Then Save and submit the creation contract record
@KUBS_AR/AP_UAT_001_001_TC_001_02  
Scenario: Reviewer approve contract for an active vendor with expense type Purchases
And user update the data set ID for vendor contract Reviewer
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
#Then Search Contract Creation record in List
And approve the record by reviewer user
@KUBS_AR/AP_UAT_001_001_TC_001_03 
Scenario: Checker approve contract for an active vendor with expense type Purchases
And user update the data set ID for vendor contract Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
#Then Search Contract Creation record in List
Then checker should approved the contract record
@KUBS_AR/AP_UAT_001_001_TC_001_04  
Scenario: To verify approve contract record should visible in vendor contract list
And user update the data set ID for vendor contract
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
Then Get the contract and Txn status by searching the record via business partner
And maker should logout

@KUBS_AR/AP_UAT_001_001_TC_02_01 
Scenario: PO should be created successfully and displayed in approved queue with Active Status
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
And user update the data set ID for Purchase Order 
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then close the confrimation msg
Then Click on Item Details Record
And user update the data set ID for Purchase Order
Then Edit the item details fields
Then Click on Account Payable Save button
Then click on the Notification icon
#Then Click on Account Payable Notification
Then Search purchase order record in List
Then Select the record from Notification 
And Submit the Selected record
@KUBS_AR/AP_UAT_001_001_TC_02_02
Scenario: PO should be approved by reviewer
And user update the data set ID for purchase order Reviewer
And User login as a reviewer user Approve purchase order
Then Click on notification button in reviewer
Then Search purchase order record in List
And approve the purchase order record by reviewer user
@KUBS_AR/AP_UAT_001_001_TC_02_03
Scenario: PO should be approved by checker
And user update the data set ID for purchase order Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for purchase order
And capture claimed status
Then click on notification in checker
Then Search purchase order record in List
Then checker should approved the purchase order record
@KUBS_AR/AP_UAT_001_001_TC_02_04
Scenario: PO should be displayed in approved queue with Active Status in maker
And user update the data set ID for Purchase Order 
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on purchase order Eye Icon
Then Get the purchase order Txn status by searching the record via business partner 
 
    
@KUBS_AR/AP_UAT_001_001_TC_003_01  
Scenario: Create GRN against above create PO for above vendor
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
Then Click on Good Recived Note GRN Add button
And user update the data set ID for GRN 
Then Fill the form for GRN
Then click on the Notification icon
Then Search the grn record
And open the grn record 
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
And Save the Item Details record
Then click on the Notification icon
Then store the Reference ID and open the GRN record
Then click submit and enter remark for GRN record
@KUBS_AR/AP_UAT_001_001_TC_003_02 
Scenario: GRN against above create PO for above vendor Reviewer Approve the record
And user update the data set ID for GRN Reviewer
And User login as a reviewer user Approve Grn against PO
Then Click on notification button in reviewer
Then Search the grn record
And Approve Grn against PO the record by reviewer user
@KUBS_AR/AP_UAT_001_001_TC_003_03 
Scenario: Checker should approved the GRN against PO record
And user update the data set ID for GRN Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for grn record
And capture claimed status
Then click on notification in checker
Then Search the grn record
Then checker should approved the GRN against PO record
@KUBS_AR/AP_UAT_001_001_TC_003_04  
Scenario: Create GRN against above create PO for above vendor
And user update the data set ID for GRN 
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
Then Get the GRN and Txn status by searching the record via business partner

@KUBS_AR/AP_UAT_001_001_TC_004_01  
Scenario: Create GRN against above create PO for above vendor

Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
Then Click on Good Recived Note GRN Add button
And user update the data set ID for GRN 
Then Fill the form for GRN
Then click on the Notification icon
Then Search the grn record
And open the grn record 
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
And Save the Item Details record
Then click on the Notification icon
Then store the Reference ID and open the GRN record
Then click submit and enter remark for GRN record
@KUBS_AR/AP_UAT_001_001_TC_004_02 
Scenario: GRN against above create PO for above vendor Reviewer Approve the record
And user update the data set ID for GRN Reviewer
And User login as a reviewer user Approve Grn against PO
Then Click on notification button in reviewer
Then Search the grn record
And Approve Grn against PO the record by reviewer user
@KUBS_AR/AP_UAT_001_001_TC_004_03 
Scenario: Checker should approved the GRN against PO record
And user update the data set ID for GRN Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for grn record
And capture claimed status
Then click on notification in checker
Then Search the grn record
Then checker should approved the GRN against PO record
@KUBS_AR/AP_UAT_001_001_TC_004_04  
Scenario: Create GRN against above create PO for above vendor
And user update the data set ID for GRN 
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
Then Get the GRN and Txn status by searching the record via business partner

@KUBS_AR/AP_UAT_001_001_TC_005  @AR/AP
Scenario: Verify Accounting entries post approval of GRN
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounting entries post bill is approved
#Then Give the Invoice Number for Puchase Bill
#Then Click on Table Row First Eye Icon in ARAP
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

@KUBS_AR/AP_UAT_001_001_TC_06 @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Balance sheet Report b1
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries

@KUBS_AR/AP_UAT_001_001_TC_007
Scenario: Verify Approved GRN Reference is available on Fixed Asset creation.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation eye button
And user update the data set ID for GRN Fixed Asset
Then Fill the form and check if GRN is showing or not which we created

@KUBS_AR/AP_UAT_001_001_TC_008  @AR/AP
Scenario: Verify GRN Report post approval of GRN
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Third Segment report Icon
Then Click on Report Tab
Then Click on GRN Edit button
Then update data set Id for GRN Report
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

@KUBS_AR/AP_UAT_001_001_TC_009 
Scenario: Create Bill against PO & GRN for above vendor
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And click on add button for invoice booking
And user update the data set ID for invoice booking 
And Fill the required fields for invoice booking
Then Save and submit the invoice billing

@KUBS_AR/AP_UAT_001_001_TC_010  @AR/AP
Scenario: Verify Tax details is correctly displayed for Item details in Billing
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
Then Get the tax details and check
And maker should logout

@KUBS_AR/AP_UAT_001_001_TC_11  @AR/AP
Scenario: Verify Total Tax Amount is auto populated on Fixed Asset creation screen while creating Fixed asset against above GRN
Given User should go to the kubs url and login as a maker user
And user should navigate to fixed asset menu
When click on eye button of asset creation
And click on add button to create asset record
And update  data set id for Tax Amount is auto populated on Fixed Asset
And Fill the required fields to create asset against GRN Ref number
Then Save the asset creation record against GRN Ref number
Then click on the Notification icon
Then Search Asset Creation record
And navigate to fixed asset items tab to add item details
And click on add button to create asset record
Then Fill the hsn code and verify the total tax amount is auto populated  

@KUBS_AR_AP_UAT_001_001_TC_12  @AR/AP
Scenario: Verify Accounting entries post approval of GRN 
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounting entries post bill is approved
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

@KUBS_AR/AP_UAT_001_001_TC_13  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Balance sheet Report post bill is approved
And search invoice type as expense
Then Click on Table Row First Eye Icon in ARAP
And get the buisness partner name and invoice number from the bill viewed
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries
   
   @KUBS_AR_AP_UAT_001_001_TC_014  @AR/AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report post bill is approved
Then Give Invoice Number in Invoice Bill
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed


#//----------//
@KUBS_AR/AP_UAT_001_002_TC_01 
Scenario: Verify Tax details is correctly displayed for Item details in Billing
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
Then Get the tax details and check
And maker should logout

#Accounting entries 
#Balance sheet
#Account payable report
@KUBS_AR/AP_UAT_001_002_TC_05  
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report post bill is approved
Then Give Invoice Number in Invoice Bill
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed

#//----------//
@KUBS_AR/AP_UAT_001_003_TC_01 
Scenario: Verify Tax details is correctly displayed for Item details in Billing
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
Then Get the tax details and check
And maker should logout

#Accounting entries 
#Balance sheet
#Account payable report

@KUBS_AR/AP_UAT_001_003_TC_05 
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report post bill is approved
Then Give Invoice Number in Invoice Bill
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed

@KUBS_AR/AP_UAT_002_003_TC_01_01  @AR/AP
Scenario: Advance to employee must be created and displayed in approved list view.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance to employee
Then Fill the form for Account Recivable
Then Click on save button to save the Record for Account Recivable
Then click on the Notification icon
Then Search Advance to employee record in List
Then store the Reference ID and open the Advance to employee record
Then click submit and enter remark for Advance to employee
@KUBS_AR/AP_UAT_002_003_TC_01_02  
Scenario: Reviewer approve Advance to employee Record
And user update the data set ID for Advance to employee Reviewer
And User login as a reviewer user Approve Advance to employee
Then Click on notification button in reviewer
And approve Advance to employee record by reviewer user
@KUBS_AR/AP_UAT_002_003_TC_01_03 
Scenario: Checker approve Advance to employee Record
And user update the data set ID for Advance to employee Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Advance to employee
And capture claimed status
Then click on notification in checker
Then Search Advance to employee record in List
Then checker should approved the Advance to employee record
@KUBS_AR/AP_UAT_002_003_TC_01_04  
Scenario: To verify approve Advance to employee Record should visible in Account Receivable list
And user update the data set ID for Advance to employee
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Get the Advance to employee Txn status by searching the record via business partner
And maker should logout


@KUBS_AR/AP_UAT_002_004_TC_01_01
Scenario: Create Advance against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance against PO
Then Fill the form for Account Recivable Advance against PO
Then Click on save button to save the Record for Account Recivable
Then click on the Notification icon
Then Search Advance against PO record in List
Then store the Reference ID and open the Advance against PO record
Then click submit and enter remark for Advance against PO
@KUBS_AR/AP_UAT_002_004_TC_01_02  
Scenario: Reviewer approve Advance against PO Record
And user update the data set ID for Advance against PO Reviewer
And User login as a reviewer user Approve Advance against PO
Then Click on notification button in reviewer
And approve Advance against PO record by reviewer user
@KUBS_AR/AP_UAT_002_004_TC_01_03 
Scenario: Checker approve Advance against PO Record
And user update the data set ID for Advance against PO Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Advance against PO
And capture claimed status
Then click on notification in checker
Then Search Advance against PO record in List
Then checker should approved the Advance against PO record
@KUBS_AR/AP_UAT_002_004_TC_01_04  
Scenario: To verify approve Advance against PO Record should visible in Account Receivable list
And user update the data set ID for Advance against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Get the Advance against PO Txn status by searching the record via business partner
And maker should logout


@KUBS_AR_AP_UAT_002_004_TC_02  
Scenario: Verify No accounting entry is generated on approval of advances against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
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

@KUBS_AR/AP_UAT_002_004_TC_03 
Scenario: Verify creating advane against PO with amount greater than PO amount is not allowed
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance against PO with amount greater than PO amount
Then Fill the form for Account Recivable with amount greater than PO amount


