
Feature: AR/AP Module

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
#And Give Getted Branch code 
Then Fill branch details for report
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
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

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
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

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




@KUBS_AR/AP_UAT_002_004_TC_01  @AR/AP
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
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
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

@KUBS_AR/AP_UAT_002_004_TC_03  @AR/AP
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And click on accounts Payable module
Then click on po creation module 
And search for cancelled po
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
And click notification button
Then choose first record in the notification record
Then go to Item details and enter po number

@KUBS_AR/AP_UAT_003_002_TC_04 @AR/AP
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
#And Give Getted Branch code 
Then Fill branch details for report
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
   #And select the branch
   Then Fill branch details for report
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
   Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Go to invoice bill booking module
Then click on search 
And search the cancelled bill
And get the transcationDate
Then click on report segment button
And click on financial reporting main menu
And click on temp view near by balance sheet sub menu
#And select branch in balance sheet
Then Fill branch details for report
And enter the transaction date
And click on the view button
Then Verify Balance sheet post Bill is cancelled

   @KUBS_AR_AP_UAT_003_005_TC_03  @AR/AP
Scenario: Verify Accounts Payable Report post bill is cancelled.(With PO)
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
#And Give Getted Branch code 
Then Fill branch details for report
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
  # And select the branch
   Then Fill branch details for report
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
Given Navigate The Azentio Url
Then Choose the second Tab Segment
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
