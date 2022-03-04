Feature: Checking GRN module
Background: 
Given Navigate to KUBS URL and login with maker credentials
@PoCancelledGRN
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
@GRNforApprovalPo
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

@KUBS_AR_AP_UAT_003_005_TC_04
Scenario: Verify Cancelled bill is not available for payment settlement
And Go to invoice bill booking module
Then click on search 
And search the cancelled bill
And Go to payment settlement module
And click on Add Icon
And fill the form
And find the invoice reference number is availabe at the billing queue 
#Gl
@KUBS_AR/AP_UAT_003_005_TC_01
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

@KUBS_AR/AP_UAT_003_008_TC_02
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

@KUBS_AR/AP_UAT_003_008_TC_01
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

@KUBS_AR_AP_UAT_003_008_TC_03
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

@KUBS_AR_AP_UAT_004_002_TC_01
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

@KUBS_AR_AP_UAT_004_005_TC_01
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
@KUBS_AR_AP_UAT_004_005_TC_02
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

@KUBS_AR_AP_UAT_004_005_TC_03
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

@KUBS_AR/AP_UAT_004_005_TC_04
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



@KUBS_AR_AP_UAT_010_002_TC_01
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
@KUBS_AR_AP_UAT_010_002_TC_02
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


And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
And select our bill
And save the bill record

@KUBS_AR_AP_UAT_010_005_TC_03
Scenario: Verify Credit Note is not available for appropriation against receipt.
And goto accouts Receivable module
And goto credit notet module
And get the approved credit note reference number
And goto appropriation module
And click on Add Icon
And validate the credit note approved record is not available
@KUBS_AR_AP_UAT_013_001_TC_06
Scenario: Verify Payment settlement txn is not available for payout if net payabe is 0.
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
And Go to payment settlement module
And click on Add Icon
And fill the payment settlement record and validate the invoice number is not available in the invoice list view
