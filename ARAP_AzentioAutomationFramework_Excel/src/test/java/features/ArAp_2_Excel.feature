Feature: AR/AP Module
@KUBS_AR_AP_UAT_003_006_TC_01  @AR/AP
Scenario: Verify Accounting entries post Debit Note is cancelled
Given User should go to the kubs url and login as a maker user
Then select data set ID for accounting entries post debit note is cancelled
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module for cancelled debit note
Then Click on financial transction edit button
And choose branch codes for cancelled debit note
And click on transaction from date in calender
Then Select from date in calender for cancelled debit note
And click on transaction to date in calender icon
Then Select To date in calender for cancelled debit note
And Click View HyperLink
Then Verify Accounting entries post Debit Note is cancelled

@KUBS_AR_AP_UAT_003_006_TC_02  @AR/AP
Scenario: Verify Balance sheet post Debit Note is cancelled
Given User should go to the kubs url and login as a maker user
Then select data set ID for balance sheet post debit note is cancelled
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
Given User should go to the kubs url and login as a maker user
Then select data set ID for accounts receivable report post debit note is cancelled
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Click main Reports module
Then Click on sub module Accounts Receivable Report
And Give Getted Business Partner Name in field
Then Give Current business Date in Account receivable report
And Give Accounts Payable Status
Then Click on View buttons
And Verify Accounts Receivable Report post Debit Note is cancelled

@KUBS_AR_AP_UAT_003_006_TC_04  @AR/AP
Scenario: Verify Cancelled Debit Note is not available for adjustment at Payment Settlement screen
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify Cancelled Debit Note is not available for adjustment
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

@KUBS_AR_AP_UAT_003_006_TC_05a
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
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
@KUBS_AR_AP_UAT_003_006_TC_05b
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given Navigate as a Reviewer
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
@KUBS_AR_AP_UAT_003_006_TC_05c
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given Navigate as a Checker
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
@KUBS_AR_AP_UAT_003_006_TC_05d
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
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
@KUBS_AR_AP_UAT_003_006_TC_05e
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given Navigate as a Reviewer
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
@KUBS_AR_AP_UAT_003_006_TC_05f
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given Navigate as a Checker
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
@KUBS_AR_AP_UAT_003_006_TC_05g
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted
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
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify accounting entries post credit note is cancelled
   Then Choose the second Tab Segment
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
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify balance sheet post credit note is cancelled
   Then Choose the second Tab Segment
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
   Then Fill branch details for balance sheet report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR/AP_UAT_003_007TC_03  @AR/AP
   Scenario: Verify Accounts Receivable Report post credit note is cancelled
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify accounts receivable report post credit note is cancelled
   Then Choose the second Tab Segment
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
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for verifying credit cancelled is not available
   Then Choose the second Tab Segment
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
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify no accounting entries for cancelling advance to employee
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
  
@KUBS_AR/AP_UAT_003_008_TC_02a  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify cancelled adcance is not available for payment settlement
Then Choose the second Tab Segment
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
@KUBS_AR/AP_UAT_003_008_TC_02b  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_008_TC_02c  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
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
@KUBS_AR/AP_UAT_003_008_TC_02d  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the form for cancelled advances
And find the invoice reference number for cancelled advance is not availabe at the billing queue

#f
@KUBS_AR_AP_UAT_003_008_TC_03a  @AR/AP
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted
Then Choose the second Tab Segment
And Goto accounts receivable advances module
Then click on search
And select the advance to employee active record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
And fill the form for settlement
#Then Choose value date as System current date
And Save the form
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_AR_AP_UAT_003_008_TC_03b
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR_AP_UAT_003_008_TC_03c
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
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
@KUBS_AR_AP_UAT_003_008_TC_03d
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
And goto arap adjustment main module
Then go to ar ap adjustment module
And click on Add Icon
Then check the settlement completed advance can be cancelled

#p
@KUBS_AR_AP_UAT_003_009_TC_01  @AR/AP
Scenario: Verify No accounting entry is generated on cancelling advances against PO
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify No accounting entry is generated on cancelling advances against PO
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner and Advance Number
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

@KUBS_AR_AP_UAT_004_007_TC_01  @AR/AP
Scenario: Verify Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User should go to the kubs url and login as a maker user
Then select data set ID for advance to employee is adjusted against the selected bill
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





