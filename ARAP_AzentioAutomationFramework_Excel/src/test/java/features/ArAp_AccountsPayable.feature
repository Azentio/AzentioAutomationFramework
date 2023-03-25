Feature: AR/AP Module
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

#Given User should go to the kubs url and login as a maker user
#Then select data set ID for verify settlement for the bill is auto approved
#And click on accounts Payable module
#And goto invoice booking module
#And get the approved invoice from table
#And Go to payment settlement module
#And click on Add Icon
#And fill the mendatory field for settle the payment
#And fill the calender details and description
#And Save the form
#Then Click on Update Deposited Cheque Notification
#And Select and Submit the Update Deposited Cheque record
#Then logout from maker
#		Given User login as a reviewer user to approve the record by reviewer
#		Then click on the Notification select the Cheque record and Approve
#		And logout from reviewer
#		Given User navigate to the kubs url and login as a checker user
#		And then checker claim the record
#		Then click on the checker Notification 
#		And select the Cheque record and Approve by checker
#		Then logout from checker
#
#Given User should go to the kubs url and login as a maker user
#Then select data set ID for verify settlement for the bill is auto approved
#And click on accounts Payable module
#And go to auto payout module 
#And select the record from temp view
#And fill the valued date
#And fill the mendatory fields for auto payout record 
#Then save the auto payout record
#And select the record from temp view and initiate
#Then Click on Update Deposited Cheque Notification
#And Select and Submit the Update Deposited Cheque record
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
And Claim the Record in Checker for online mode receipt record
Then Goto the Checker notification Icon
And Click the First Action Icon of the record
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
And Claim the Record in Checker for online mode receipt record
Then Goto the Checker notification Icon
And Click the First Action Icon of the record
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
		Then click on the Notification and select the receipt record and Approve
		@KUBS_AR_AP_UAT_010_002_TC_02_03
		Scenario: checker user approve the record
		Then update data set ID for verify status of receipt is auto changed to deposit for checker
		Given User navigate to the kubs url and login as a checker user
		Then Click module security management
		And Claim the Record in Checker for cheque mode receipt record
		Then click on the checker Notification 
		And select the receipt record and Approve by checker
@KUBS_AR_AP_UAT_010_002_TC_02_04
Scenario: maker user verify the record after checker apporoval
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify status of the receipt is auto changed to deposit
And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
#And give date of bill deposited date 
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