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
#And click on transaction to date in calender icon
#Then Select To date in calender for cancelled debit note
And click on view button
Then Verify Accounting entries post Debit Note is cancelled

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
And choose branch codes to verify accounting entries
And click on transaction from date in calender
Then Select from date in calender to verify no accounting entries
And click on transaction to date in calender icon
Then Select To date in calender to verify no accounting entries
And click on view button
Then Verify No accounting entry is generated on cancelling advances against PO

@KUBS_AR_AP_UAT_004_008_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement approval (Auto payout)
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify accounting entries post payment settlement
Then Choose the second Tab Segment
And click on accounts Payable module
And Go to payment settlement module
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code for auto payout accounting entries
And click on transaction from date calender icon 
Then choose the from date for auto payout accounting entries
#And click on the transaction to date calender icon
#Then choose the to date for auto payout accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report

@KUBS_AR_AP_UAT_010_001_TC_03  @AR/AP
Scenario: Verify accounting entries post receipt recording
Given User should go to the kubs url and login as a maker user
Then select data set ID for Verify accounting entries post receipt recording
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
And choose branch codes to verify accounting entries post receipt recording
And click on transaction from date in calender
Then Select from date in calender to verify accounting entries post receipt recording
#And click on transaction to date in calender icon
#Then Select To date in calender to verify accounting entries post receipt recording
And click on view button
Then Verify Accounting entries post receipt recording

@KUBS_AR_AP_UAT_010_002_TC_04  @AR/AP
Scenario: Verify accounting entries for cleared cheques.
 	 Given User should go to the kubs url and login as a maker user
 	 Then select data set ID for accounting entries for cleared cheques
   And user should navigate to accounts receivable menu
   When click on eye button of update cheque status
   Then get slip number by using cheque number
   Then click on report icon1
   Then click on enquiry menu
   Then click on temp grid button of financial transaction
   And fill the required fields of financial transaction
   Then click on view button to view the reports and verify
