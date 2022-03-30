Feature: Checking accountsPayable and accounts Receivable module
Background: 
Given Navigate to KUBS URL and login with maker credentials
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

@KUBS_AR_AP_UAT_001_002_TC_05
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
@KUBS_AR_AP_UAT_001_004_TC_01
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
@KUBS_AR/AP_UAT_001_004_TC_02
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

@KUBS_AR_AP_UAT_003_001_TC_01
Scenario: Check Contract Report
And click on accounts Payable module
And goto vendor contract module
Then click on search
And select the active contract number and business partner name from the approved grid view
And click on view button for open the record
And get the contract amount
And click on the item details
Then click on report segment button
And click on report main menu
And click the temp near by contract report 
And enter bp Name
And click on calender 
And give date for the calendar
And enter contract status
And click on the view button
Then verify the contract reference number is available in the report content

@KUBS_AR_AP_UAT_003_005_TC_03
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




@KUBS_ARAP_UAT_001_003_TC_05
Scenario: Verify Accounts Payable Report post bill is approved
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

@KUBS_AR_AP_UAT_001_005_TC_06
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

@KUBS_AR_AP_UAT_001_006_TC_06
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

@KUBS_AR/AP_UAT_003_002_TC_03
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


@KUBS_AR_AP_UAT_003_002_TC_05
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

@KUBS_AR_AP_UAT_003_002_TC_02
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

@KUBS_AR_AP_UAT_006_003_TC_02
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


@KUBS_AR_AP_UAT_003_005_TC_04
Scenario: Verify Cancelled bill is not available for payment settlement
And Go to invoice bill booking module
Then click on search 
And search the cancelled bill
And Go to payment settlement module
And click on Add Icon
And fill the form
And find the invoice reference number is availabe at the billing queue 

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

@KUBS_AR/AP_UAT_003_005_TC_02
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

@KUBS_AR_AP_UAT_004_005_TC_06
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

@KUBS_AR_AP_UAT_004_005_TC_07
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

@KUBS_AR_AP_UAT_005_001_TC_06
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


@KUBS_AR_AP_UAT_005_002_TC_03
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

@KUBS_AR_AP_UAT_005_003_TC_02
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
@KUBS_AR_AP_UAT_006_001_TC_02
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
@KUBS_AR_AP_UAT_006_001_TC_04
Scenario: Verify Accounts Payable Report post payout approval (Payot for multiple bills)
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

@KUBS_AR_AP_UAT_006_001_TC_05
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


@KUBS_AR_AP_UAT_006_002_TC_02
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


@KUBS_AR_AP_UAT_006_002_TC_04
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

@KUBS_AR_AP_UAT_006_002_TC_005
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


@KUBS_AR_AP_UAT_006_002_TC_06
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

@KUBS_AR_AP_UAT_008_001_TC_01
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


@KUBS_AR_AP_UAT_008_001_TC_02
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


@KUBS_AR_AP_UAT_008_002_TC_01
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

@KUBS_AR_AP_UAT_008_003_TC01
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
 @KUBS_AR_AP_UAT_006_003_TC_04
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

 @KUBS_AR_AP_UAT_006_003_TC_05
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

@KUBS_AR_AP_UAT_009_001_TC_01
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

And goto accouts Receivable module
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
