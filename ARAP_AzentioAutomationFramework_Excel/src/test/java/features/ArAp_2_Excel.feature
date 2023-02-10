Feature: AR/AP Module

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
   
   @KUBS_AR/AP_UAT_003_007_TC_04  @AR/AP
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

@KUBS_AR_AP_UAT_003_007_TC_05_01
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted
#And click on accounts Payable module
#And goto vendor contract module
#And click on Add Icon
#Then fill all the mendatory fields for creating vendor for cancellation of credit note
#And add item details for the contract for cancellation of credit note
#And add the payment term for the contract for cancellation of credit note
#And add the benificiory details and select auto payout as yes for cancellation of credit note
#And click notification button
#Then choose first record in the notification record for cancellation of credit note
#And click on Submit button 
#Then enter remark in confirmation alert for cancellation of credit note
#Then click on submit button in alert
#And capture the reviewer ID for cancellation of credit note
#Then logout from maker
#
#And login with reviewer credentials for cancellation of credit note
#Then click on notification button
#And select our record in notification records for cancellation of credit note
#Then Approve the record from reviewer
#And enter the remark in alert for cancellation of credit note
#Then click on submit in alert for cancellation of credit note
#Then verify the approval status of the record
#And logout from reviewer
#
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and claim for cancellation of credit note
#Then click on Notification button
#Then select our record in notification records for cancellation of credit note
#And click on approve button in checker stage
#Then give alert remark for checker
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#
#And login with Maker ID
#And click on accounts Payable module
#And goto vendor contract module
#And get the contract number for cancellation of credit note
#And goto po creation module
#And click on Add Icon
#And fill the mendatory fields for po creation for cancellation of credit note
#And save the po creation record
#And save the item details for pocreation 
#And save the benificiery details for po creation
#And click notification button
#Then choose first record in the notification record for cancellation of credit note
#And click on Submit button 
#Then enter remark in confirmation alert for cancellation of credit note
#Then click on submit button in alert
#And capture the reviewer ID for cancellation of credit note
#Then logout from maker
#
#
#And login with reviewer credentials for cancellation of credit note
#Then click on notification button
#And select our record in notification records for cancellation of credit note
#Then Approve the record from reviewer
#And enter the remark in alert for cancellation of credit note
#Then click on submit in alert for cancellation of credit note
#Then verify the approval status of the record
#And logout from reviewer
#
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and claim for cancellation of credit note
#Then click on Notification button
#Then select our record in notification records for cancellation of credit note
#And click on approve button in checker stage
#Then give alert remark for checker
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#
#And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And search for approved po record for cancellation of credit note
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po for cancellation of credit note
Then go to Item details and enter po number for cancellation of credit note
And click notification button
Then choose first record in the notification record for cancellation of credit note
And click on Submit button 
Then enter remark in confirmation alert for cancellation of credit note
Then click on submit button in alert
And capture the reviewer ID for cancellation of credit note
Then logout from maker

And login with reviewer credentials for cancellation of credit note
Then click on notification button
And select our record in notification records for cancellation of credit note
Then Approve the record from reviewer
Then enter remark in confirmation alert for cancellation of credit note
Then click on submit in alert for cancellation of credit note
Then verify the approval status of the record
And logout from reviewer

Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and claim for cancellation of credit note
Then click on Notification button
Then select our record in notification records for cancellation of credit note
And click on approve button in checker stage
Then give alert remark for checker
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And get the approved po number from approved record for cancellation of credit note
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record for cancellation of credit note
And goto invoice bill booking temp view and select the record
And fill The invoice against po record for cancellation of credit note
And click notification button
Then choose first record in the notification record for cancellation of credit note
And click on Submit button
Then enter remark in confirmation alert for cancellation of credit note
Then click on submit button in alert
And capture the reviewer ID for cancellation of credit note
Then logout from maker

And login with reviewer credentials for cancellation of credit note
Then click on notification button
And select our record in notification records for cancellation of credit note
Then Approve the record from reviewer
And enter the remark in alert for cancellation of credit note
Then click on submit in alert for cancellation of credit note
Then verify the approval status of the record
And logout from reviewer

Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and claim for cancellation of credit note
Then click on Notification button
Then select our record in notification records for cancellation of credit note
And click on approve button in checker stage
Then give alert remark for checker
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking for cancellation of credit note
And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for cancellation of credit note
And click notification button
Then choose first record in the notification record for cancellation of credit note
And click on Submit button 
Then enter remark in confirmation alert for cancellation of credit note
Then click on submit button in alert
And capture the reviewer ID for cancellation of credit note
Then logout from maker

And login with reviewer credentials for cancellation of credit note
Then click on notification button
And select our record in notification records for cancellation of credit note
Then Approve the record from reviewer
And enter the remark in alert for cancellation of credit note
Then click on submit in alert for cancellation of credit note
Then verify the approval status of the record
And logout from reviewer

Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and claim for cancellation of credit note
Then click on Notification button
Then select our record in notification records for cancellation of credit note
And click on approve button in checker stage
Then give alert remark for checker
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker

And login with Maker ID
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the mendatory fields for settle the payment
And fill the calender detail and description
And Save the form
And click notification button
Then choose first record in the notification record for cancellation of credit note
And click on Submit button 
Then enter remark in confirmation alert for cancellation of credit note
Then click on submit button in alert
And capture the reviewer ID for cancellation of credit note
Then logout from maker
@KUBS_AR_AP_UAT_003_007_TC_05_02
Scenario: verify reviewer approve payment settlement for the cancellation of credit note record
Then update data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted for reviewer
Given login with reviewer credentials to approve payment settlement for cancellation of credit note
Then click on notification button
And select our record in notification records for cancellation of credit note
Then Approve the record from reviewer
And enter the remark in alert for cancellation of credit note
Then click on submit in alert for cancellation of credit note
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR_AP_UAT_003_007_TC_05_03
Scenario: verify checker approve payment settlement for the cancellation of credit note record
Then update data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted for checker
Given login with checker credentials to approve payment settlement for cancellation of credit note
And click on security management menu in checker
Then click on action button under security management menu
And select our record and claim for cancellation of credit note
Then click on Notification button
Then select our record in notification records for cancellation of credit note
And click on approve button in checker stage
Then give alert remark for checker
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
@KUBS_AR_AP_UAT_003_007_TC_05_04
Scenario: verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement 
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted
Then Choose the second Tab Segment
When click the Account Receivable Main Module for verify Accounting entries
And click the credit note eye icon
And click the search icon in the list view of credit 
And search the Active credit note and click on the first list
And get buisness partner name , get credit note number and get credit note date
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Fill The Business Partner according to creditnote
And Give The Adjustment Type
Then Fill the credit note number in Adjustment Item Type
And Give the Adjustment Ref No and Validate cancellation is not allowed

  
#@KUBS_AR/AP_UAT_003_008_TC_02_01  @AR/AP
#Scenario: Verify cancelled advances is not available for payment settlement
#Given User should go to the kubs url and login as a maker user
#Then select data set ID for verify cancelled advance is not available for payment settlement
#Then Choose the second Tab Segment
#And Goto accounts receivable advances module
#Then click on search 
#And select one record from advances
#Then go to ar ap adjustment module
#And click on Add Icon
#And Fill The form for advance adjustment
#And click notification button
#Then choose first record in the notification record in GRN stage
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#@KUBS_AR/AP_UAT_003_008_TC_02_02  @AR/AP
#Scenario: Verify cancelled advances is not available for payment settlement
#Then update data set ID for verify cancelled advance is not available for payment settlement for reviewer
#Given login with reviewer credentials for cancelled advance record
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#And logout from reviewer
#@KUBS_AR/AP_UAT_003_008_TC_02_03  @AR/AP
#Scenario: Verify cancelled advances is not available for payment settlement
#Then update data set ID for verify cancelled advance is not available for payment settlement for checker
#Given login with checker credentials for cancelled advance record
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#@KUBS_AR/AP_UAT_003_008_TC_02_04  @AR/AP
#Scenario: Verify cancelled advances is not available for payment settlement
#Given User should go to the kubs url and login as a maker user
#Then select data set ID for verify cancelled advance is not available for payment settlement
#And click on accounts Payable module
#And Go to payment settlement module
#And click on Add Icon
#And fill the form for cancelled advances
#And find the invoice reference number for cancelled advance is not availabe at the billing queue

#f
#@KUBS_AR_AP_UAT_003_008_TC_03_01  @AR/AP
#Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
#Given User should go to the kubs url and login as a maker user
#Then select data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted
#Then Choose the second Tab Segment
#And Goto accounts receivable advances module
#Then click on search
#And select the advance to employee active record
#And go to aacounts payable module
#And Go to payment settlement module
#And click on Add Icon
#And fill the form for settlement
#And Save the form
#And click notification button
#Then choose first record in the notification record
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#@KUBS_AR_AP_UAT_003_008_TC_03_02
#Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
#Then update data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted for reviewer
#Given login with reviewer credentials for cancelled advance record
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#@KUBS_AR_AP_UAT_003_008_TC_03_03
#Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
#Given login with checker credentials for cancelled advance record
#Then update data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted for checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#@KUBS_AR_AP_UAT_003_008_TC_03_04
#Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
#Given User should go to the kubs url and login as a maker user
#Then select data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted
#Then Choose the second Tab Segment
#And goto arap adjustment main module
#Then go to ar ap adjustment module
#And click on Add Icon
#Then check the settlement completed advance can be cancelled


@KUBS_AR_AP_UAT_004_007_TC_01_01  @AR/AP
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
And Store the Referance Id and Open the adjusted Record
Then Click submit button and Enter Remark submit it
@KUBS_AR_AP_UAT_004_007_TC_01_02
Scenario: reviewer approve Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User navigate to the kubs url and login as a reviewer user
Then click on Notify icon
And Click First record of advance to employee Action icon
Then Approve the record in Reviewer
And Give reviewer Remark and Submit
@KUBS_AR_AP_UAT_004_007_TC_01_03
Scenario: Checker approve Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User navigate to the kubs url and login as a checker user
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon from checker
Then Approve the Record in checker stage
And Give the Remark and Submit it
@KUBS_AR_AP_UAT_004_007_TC_01_04
Scenario: Verify Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User should go to the kubs url and login as a maker user
Then select data set ID for advance to employee is adjusted against the selected bill
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
Then Enter payment option for verify
And Give the stored Business partner Name
Then Choose the value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net Adjusted Value is correctly displayed

@KUBS_AR_AP_UAT_004_007_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify TDS percentage and amount is correctly calculated
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
Then Enter payment option for verify
And Give stored Business partner Name
Then Choose the value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the TDS % & amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_007_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed
Given User should go to the kubs url and login as a maker user
Then select data set ID for net payable amount is correctly calculated
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
Then Enter payment option for verify
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


@KUBS_AR_AP_UAT_004_008_TC_01_01  @AR/AP
Scenario: Verify on payment date (As per Bill), settlement for the bill is auto approved.
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
Then Choose the second Tab Segment
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then logout from maker
		Given User login as a reviewer user to approve the record by reviewer
		Then click on the Notification select the Cheque record and Approve
		And logout from reviewer
		Given User navigate to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		Then logout from checker

Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
Then Click on Beneficiary details tab
Then Click on Beneficiary Save button
And save the benificiery details for po creation
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then logout from maker
		Given User login as a reviewer user to approve the record by reviewer
		Then click on the Notification select the Cheque record and Approve
		And logout from reviewer
		Given User navigate to the kubs url and login as a checker user
		Then select data set ID for verify settlement for the bill is auto approved
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		Then logout from checker

Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
And click on accounts Payable module
Then click on po creation module
And search for approved po record
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po
Then go to Item details and enter po number for approval
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then logout from maker
		Given User login as a reviewer user to approve the record by reviewer
		Then click on the Notification select the Cheque record and Approve
		And logout from reviewer
		Given User navigate to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		Then logout from checker

Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
And click on accounts Payable module
Then click on po creation module
And get the approved po number from approved record
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record
And goto invoice bill booking temp view and select the record
And fill The invoice againse po record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then logout from maker
		Given User login as a reviewer user to approve the record by reviewer
		Then click on the Notification select the Cheque record and Approve
		And logout from reviewer
		Given User navigate to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		Then logout from checker

Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
And click on accounts Payable module
And goto invoice booking module
And get the approved invoice from table
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field for settle the payment
And fill the calender details and description
And Save the form
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then logout from maker
		Given User login as a reviewer user to approve the record by reviewer
		Then click on the Notification select the Cheque record and Approve
		And logout from reviewer
		Given User navigate to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		Then logout from checker

Given User should go to the kubs url and login as a maker user
Then select data set ID for verify settlement for the bill is auto approved
And click on accounts Payable module
And go to auto payout module 
And select the record from temp view
And fill the valued date
And fill the mendatory fields for auto payout record 
Then save the auto payout record
And select the record from temp view and initiate
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		@KUBS_AR_AP_UAT_004_008_TC_01_02
		Scenario: reviewer approved the record
		Given User login as a reviewer user for verify settlement for the bill is auto approved
		Then update data set ID for verify settlement for the bill is auto approved reviewer
		Then click on the Notification select the Cheque record and Approve
		@KUBS_AR_AP_UAT_004_008_TC_01_03
		Scenario: checker approved the record
		Given User login as a checker user for verify settlement for the bill is auto approved
		Then update data set ID for verify settlement for the bill is auto approved checker
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker


@KUBS_AR_AP_UAT_010_001_TC_01_01  @AR/AP
Scenario: Record a receipt through cheque mode
 Given User should go to the kubs url and login as a maker user
 Then select data set ID for Record a receipt through cheque mode
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
And Store the Referance Id and Open the cheque mode receipt Record
Then Click submit button and Enter Remark and submit it 
@KUBS_AR_AP_UAT_010_001_TC_01_02
Scenario: reviewer approved the record
Then update data set ID for Record a receipt through cheque mode for reviewer
Given User login as a reviewer user for recording receipt record
Then click on Notify icon
And Click First receipt record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit the cheque mode receipt Record
@KUBS_AR_AP_UAT_010_001_TC_01_03
Scenario: checker approved the record
Then update data set ID for Record a receipt through cheque mode for checker
Given User login as a checker user for recording receipt record
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it from checker
@KUBS_AR_AP_UAT_010_001_TC_01_04
Scenario: verify the record from maker stage
Given User should go to the kubs url and login as a maker user
Then select data set ID for Record a receipt through cheque mode
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_001_TC_02_01  @AR/AP @E8
Scenario: Record a receipt through Online mode
 Given User should go to the kubs url and login as a maker user
 Then select data set ID for Record a receipt through Online mode
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
And Store the Referance Id and Open the wire mode receipt Record
Then Click submit button and Enter Remark and submit it  
@KUBS_AR_AP_UAT_010_001_TC_02_02
Scenario: reviewer approved the record
Then update data set ID for Record a receipt through Online mode for reviewer
Given User login as a reviewer user for recording receipt record
Then click on Notify icon
And Click First receipt record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit the wire mode receipt Record
@KUBS_AR_AP_UAT_010_001_TC_02_03
Scenario: chekcer approved the record
Then update data set ID for Record a receipt through Online mode for checker
Given User login as a checker user for recording receipt record
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it from checker
@KUBS_AR_AP_UAT_010_001_TC_02_04
Scenario: verify the record from maker stage
Given User should go to the kubs url and login as a maker user
Then select data set ID for Record a receipt through Online mode
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_002_TC_02_01  @AR/AP
Scenario: Verify status for the receipt is auto changed to Deposit
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify status of the receipt is auto changed to deposit
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposit Cheque record
		@KUBS_AR_AP_UAT_010_002_TC_02_02
		Scenario: reviewer user approve the record
		Then update data set ID for verify status of receipt is auto changed to deposit for reviewer
		And User should login as a reviewer user to verify status of receipt
		Then click on the Notification select the Cheque record and Approve
		@KUBS_AR_AP_UAT_010_002_TC_02_03
		Scenario: checker user approve the record
		Then update data set ID for verify status of receipt is auto changed to deposit for checker
		Given User navigate to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
@KUBS_AR_AP_UAT_010_002_TC_02_04
Scenario: maker user verify the record after checker apporoval
Given User should go to the kubs url and login as a maker user
And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
And select our bill
And save the bill record

@KUBS_AR_AP_UAT_010_002_TC_03_01 @AR/AP
Scenario: Update cheque status to Cleared
Given User should go to the kubs url and login as a maker user
Then select data set ID for Update cheque status to Cleared
Then Choose the second Tab Segment
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record as cleared
@KUBS_AR_AP_UAT_010_002_TC_03_02
Scenario: reviewer user approve the record
Then update data set ID for Update cheque status to Cleared for reviewer
Given User login as a reviewer user for Update cheque status to Cleared 
Then click on the Notification select the Cheque record to cleared and Approve
@KUBS_AR_AP_UAT_010_002_TC_03_03
Scenario: checker user approve the record
Then update data set ID for Update cheque status to Cleared for checker approval
Given User navigate to the kubs url and login as a checker user
And then checker claim the update cheque status as cleared record
Then click on the checker Notification 
And select the update Cheque record as cleared and Approve by checker

   

