Feature: AR_AP Module

  @KUBS_AR_AP_UAT_001_004_TC_08  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR4 post bill is approved
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

  @KUBS_AR_AP_UAT_001_005_TC_08  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR5 post bill is approved
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


@KUBS_AR_AP_UAT_001_006_TC_06  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR6 post bill is approved
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


@KUBS_AR_AP_UAT_001_007_TC_04  @AR_AP
Scenario: verify Accounts payable report post bill is active
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR7 post bill is approved
And search invoice type as expense
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
Then Third Segment report Icon
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report is correctly displayed

@KUBS_AR_AP_UAT_001_008_TC_03  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR8 post bill is approved
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


@KUBS_AR_AP_UAT_001_009_TC_03  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR9 post bill is approved
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

@KUBS_AR_AP_UAT_001_010_TC_03  @AR_AP
Scenario: Verify Accounts Payable Report post bill is approved
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Accounts Payable Report APR10 post bill is approved
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


#Arshath
   @KUBS_AR_AP_UAT_003_004_TC_02  @AR_AP
   Scenario: Verify Balance sheet post Bill is cancelled
   Given User should go to the kubs url and login as a maker user
   #When click the account payable main module 
   And user should navigate to accounts payable menu
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And user update the Excelsheet Testdata for balancesheet 
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
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entriess
   
   @KUBS_AR_AP_UAT_003_004_TC_03  @AR_AP
   Scenario: verify Accounts payable report post bill is cancelled
   Given User should go to the kubs url and login as a maker user
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And user update the Excelsheet Testdata for report 
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

@KUBS_AR_AP_UAT_003_004TC_04_01
Scenario: Check Budget utilization is re-instated
Given User should go to the kubs url and login as a maker user
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT1
And click on add button on budget supplementary view page UAT
And user update the data set ID for Budget Utiliztion Reviewer
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


@KUBS_AR_AP_UAT_003_004TC_04_02
Scenario: user login as reviewer
And user update the data set ID for Budget Utiliztion Reviewer
And User should go to the kubs url and login as a reviewer users
Then Click on notification button in reviewer
#Then Search Contract Creation record in List
And approve the record by reviewer user

@KUBS_AR_AP_UAT_003_004TC_04_03
Scenario: user login as checker
And user update the data set ID for Budget Utiliztion Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
#Then Search Contract Creation record in List
Then checker should approved the contract record


@KUBS_AR_AP_UAT_003_004TC_04_04
Scenario: user login as Maker
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
And goto vendor contract module
And user update the data set ID for Budget Utiliztion Reviewer
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
#And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage


@KUBS_AR_AP_UAT_003_004TC_04_05
Scenario: user login as reviewer
And user update the data set ID for Budget Utiliztion Reviewer
And User should go to the kubs url and login as a reviewer users
Then Click on notification button in reviewer
#Then Search Contract Creation record in List
And approve the record by reviewer user


@KUBS_AR_AP_UAT_003_004TC_04_06
Scenario: user login as checker
And user update the data set ID for Budget Utiliztion Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
#Then Search Contract Creation record in List
Then checker should approved the contract record


@KUBS_AR_AP_UAT_003_004TC_04_07
Scenario: user login as Maker
	Given User should go to the kubs url and login as a maker user
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT1
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


@KUBS_AR_AP_UAT_003_004TC_04_08
Scenario: user login as reviewer
And user update the data set ID for Budget Utiliztion Reviewer
And User should go to the kubs url and login as a reviewer users
Then Click on notification button in reviewer
#Then Search Contract Creation record in List
And approve the record by reviewer user


@KUBS_AR_AP_UAT_003_004TC_04_09
Scenario: user login as checker
And user update the data set ID for Budget Utiliztion Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
#Then Search Contract Creation record in List
Then checker should approved the contract record


@KUBS_AR_AP_UAT_003_004TC_04_10
Scenario: user login as Maker
Given User should go to the kubs url and login as a maker user
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT1
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after cancelling the po
Then verify budget code budget utilization amount is re-instated after cancelling the po

@KUBS_AR_AP_UAT_003_004TC_05  @AR_AP
Scenario: verify cancelled bill is not allowed for payment settlement
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
When click the invoice eye icon in accounts payable
And click the search icon in invoice booking list view
And user update the Excelsheet Testdata for paymentsettlement
And search invoice type as expense
And click the first eye icon in the list view of cancelled invoice bill
And get the invoice number from the bill viewed
And click the payment settlement eye icon
And click the add icon in payment settlement
And select payment option as buisness partnerwise
And select buisness partner in payment settlement
Then verify that no bill is available for payment settlement

@KUBS_AR_AP_UAT_003_005_TC_01  @AR_AP
Scenario: Verify Accounting entries post Bill is cancelled
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
And Go to invoice bill booking module
Then click on search
And user update the Excelsheet Testdata for accountingentry 
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

@KUBS_AR_AP_UAT_003_005_TC_02  @AR_AP
Scenario: Verify Balance sheet post Bill is cancelled
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
And Go to invoice bill booking module
Then click on search 
And user update the Excelsheet Testdata for Balancesheets 
#And search the cancelled bill
And search for cancelled bill
And get the transcationDate
Then click on report segment button
And click on financial reporting main menu
And click on temp view near by balance sheet sub menu
#And select branch in balance sheet
Then Fill branch details for report
And enter the transaction date
And click on view button
Then Verify Balance sheet post Bill is cancelled

@KUBS_AR_AP_UAT_003_005_TC_03  @AR_AP
Scenario: Verify Accounts Payable Report post bill is cancelled.(With PO)
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
And Go to invoice bill booking module
Then click on search
And user update the Excelsheet Testdata for Payable report
Then search the cancelled invoice number with po
And get the invoice number and business partner name
Then click on report segment button
And click on report main menu
And click on accouts payable report
And enter the business partner name for cancelled invoice
And click on date icon
And give date in report
And enter the payable status as cancelled 
And click on view button
Then verify the cancelled invoice number is available in the accountspayable report

@KUBS_AR_AP_UAT_003_005_TC_04  @AR_AP
Scenario: Verify Cancelled bill is not available for payment settlement
Given User should go to the kubs url and login as a maker user
Then Choose the second Tab Segment
And Go to invoice bill booking module
Then click on search 
And user update the excelshheet Testdata for payment settlement
And search for the cancelled bill
And Go to payment settlement module
And click on Add Icon
And fill the form for payment settlement
And find the invoice reference number is availabe at the billing queue 

@KUBS_AR_AP_UAT_004_002_TC_01  @AR_AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement
Given User should go to the kubs url and login as a maker user
And Goto accounts receivable advances module
And click on Add Icon
And user update the exccelsheet Testdata for Advance to Employee
And Fill the mendatory fields for creating advance to employee
And Save the advance record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record

@KUBS_AR_AP_UAT_004_002_TC_01_T1 @AR_AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for Reviewer
And user update the exccelsheet Testdata for Advance to Employee
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve

@KUBS_AR_AP_UAT_004_002_TC_01_T2  @AR_AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for checker
And user update the exccelsheet Testdata for Advance to Employee
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker 

@KUBS_AR_AP_UAT_004_002_TC_01_T3   @AR_AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for maker
Given User should go to the kubs url and login as a maker user
And Goto accounts receivable advances module
And user update the exccelsheet Testdata for Advance to Employee
And get the receivable number from aproved record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
Then verify approved record is availabe for payment settlement
#
@KUBS_AR_AP_UAT_005_003_TC_01  @AR_AP @e3
Scenario: Verify cancelled payment txn is not available for payout on payout screen.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
And click on add button for manual payout
And user update the Testdata for cancelled payout screen
And Fill the required fields for verify cancelled payment txn availability
    
@KUBS_AR_AP_UAT_005_003_TC_02  @AR_AP
Scenario: Verify accounting entries post payment settlement approval.
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And user update the Excelsheet testdata for payment settlement accounting Entries
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
#And give the refrence number which we going to see accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report

@KUBS_AR_AP_UAT_005_004_TC_01  @AR_AP @e4
Scenario: Verify cancelled payment txn is not available for payout on payout screen.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
And click on add button for manual payout
And user update the Testdata for cancelled payout txn screen
And Fill the required fields for verify cancelled payment txn availability
    
@KUBS_AR_AP_UAT_005_004_TC_02  @AR_AP
Scenario: Verify accounting entries post payment settlement cancellation
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
Then Click sub module Payment settlement Cancellation Eye Icon
And Click On Search Icon
And user update the Excelsheet testdata for payment settlement cancellation accounting Entries
Then Enter Txn No for Advance to Empolyee
Then Click on Table Row First Eye Icon in ARAP
#And Get the Cancelled Txn Number
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then Verify Accounting entries Advance to Empolyee post payment settlement cancellation

@KUBS_AR_AP_UAT_006_001_TC_01  @AR/AP @e6
Scenario: Creating Manual payouts for approved Bills of a Vendor
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
And click on add button for manual payout
And user update the exccelsheet Testdata for Manual payout
And Fill the required fields for manual payout vendor
Then Save and submit the manual payout record
And click notification button
Then choose first record in the notification records
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage

Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
  	

Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker 
    
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
Then Get the payout status
And maker should logout

@KUBS_AR_AP_UAT_006_001_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval (Manual payout for multiple bill)
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
Then click on search
And user update the Excelsheet Testdata for manual payout accounting Entries
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

@KUBS_AR_AP_UAT_006_001_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given User should go to the kubs url and login as a maker user
And click the notes option in top
And click the financial reporting
And click the balance sheet report
And user update the excelsheet Testdata for Manual payout balancesheet
Then Fill branch details for report
And select the date
And click the view icon
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entriess

@KUBS_AR_AP_UAT_006_001_TC_04  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval (Payout for multiple bills)
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And user update the Excelsheet Testdata for Account payable post payout
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
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
And user update the Excelsheet Testdata for post payout approval
And get the recently approved payout reference number 
Then click on report segment button
And click on report main menu
And click on the payout report
And user update the Excelsheet Testdata for post payout approval
And enter business partner name for payout report
And click on date icon
And give date in report
And enter payout status in payout report
And click on the view button
Then  verify approved payout reference number is available in the payout report

@KUBS_AR_AP_UAT_006_002_TC_01  @AR/AP @e5
Scenario: Creating manual payouts for approved advances of a vendor
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
And click on add button for manual payout
And user update the Excelsheeet Testdata for advance
And Fill the required fields for manual payout vendor
Then Save and submit the manual payout record
And click notification button
Then choose first record in the notification recordss
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stagess
    
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve

Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker 
    
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
Then Get the payout status
And maker should logout

@KUBS_AR_AP_UAT_006_002_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
And user update the Excelsheet Testdata for payout approval accounting Entries
And get the recently approved payout reference numberss 
Then click on report segment button
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And user update the Excelsheet Testdata for payout approval accounting Entries
And choose branch code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then verify the approved payout reference number is available in the accounting entries screen

@KUBS_AR_AP_UAT_006_002_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
Then Click on Table Row First Eye Icon in ARAP
And user update the Excelsheet Testdata for Balancesheet for payout approval
And Get the manual payout Branch Name
#And Get the Referance Number
Then Get the Transaction Date
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
#And Give Getted Branch code 
And user update the Excelsheet Testdata for Balancesheet for payout approval
Then Fill branch details for report
Then Give Getted Transaction Date
And click the view icon
And verify Balance sheet post Bill is approved

@KUBS_AR_AP_UAT_006_002_TC_04  @AR/AP
Scenario: Verify Accounts Receivable Report post payout approval
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And user update the Excelsheet Testdata for Account Receivable post Payout approval 
And search the advance approved reference number in the reference number search column
And get the business partner nname
And click on the perticular suggestion record and get the advance reference number
Then click on report segment button
And click on report main menu
And click on temp view near by accounts receivable report
And user update the Excelsheet Testdata for Account Receivable post Payout approval 
And enter the business partner name for advances to employee 
And click on date icon
And give date in report
And enter the advances to employee status active
And click on the view button 
Then verify the advance reference number is available in the accounts Receivable report

@KUBS_AR_AP_UAT_006_002_TC_05  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And user update the Excelsheet Testdata for Account Payable post Payout approval 
And search the payout completed reference number
Then click on report segment button
And click on report main menu
And click on accouts payable report
And user update the Excelsheet Testdata for Account Payable post Payout approval 
And enter businessPartner name for multiple records
And click on date icon
And give date in report
And give status of the settlement record
And click on the view button
And verify the advance record is available in the payable report section

@KUBS_AR_AP_UAT_006_002_TC_06  @AR/AP
Scenario: Verify Payout Report post payout approval
Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
When click on eye button of manual payout
And user update the Excelsheet Testdata for post payout approval for payout Report
And get the recently approved payout reference numbers
Then click on report segment button
And click on report main menu
And click on the payout report
And user update the Excelsheet Testdata for post payout approval for payout Report
And enter business partner name for payout report
And click on date icon
And give date in report
And enter payout status in payout report
And click on the view button
Then verify approved payout reference number is available in the payout report

@KUBS_AR_AP_UAT_008_001_TC_01  @AR/AP
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank & Account Number Wise
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excelsheet Testdata for payment file download
And configure the file format as Bank & Account Number Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque records

@KUBS_AR_AP_UAT_008_001_TC_01_1
Scenario: User Logain as reviewer
And user update the Excelsheet Testdata for payment file download
And User should go to the kubs url and login as a reviewer userr
Then click on the Notification select the Cheque record and Approved

@KUBS_AR_AP_UAT_008_001_TC_01_2
Scenario: User Logain as checker
And user update the Excelsheet Testdata for payment file download
Given User should go to the kubs url and login as a checker userr
And then checker claim the records
Then click on the checker Notification 
And select the Cheque record and Approve by checkers

@KUBS_AR_AP_UAT_008_001_TC_01_3
Scenario: User Logain as Maker
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excelsheet Testdata for payment file download
And verify payment file download format is in bank and accont number wise
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file

@KUBS_AR_AP_UAT_008_001_TC_02  @AR/AP @NA
Scenario: Verify payment file includes only below records,Where payment mode is Wire Transfer.Beneficiary Account is NOT maintained with legal entity.
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excelsheet Testdata for payment file legal
And configure the file format as Bank & Account Number Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque recordss

@KUBS_AR_AP_UAT_008_001_TC_02_1
Scenario: User Logain as reviewer
And user update the Excelsheet Testdata for payment file legal
And User should go to the kubs url and login as a reviewer userr
Then click on the Notification select the Cheque record and Approved

@KUBS_AR_AP_UAT_008_001_TC_02_2
Scenario: User Logain as checker
And user update the Excelsheet Testdata for payment file legal
Given User should go to the kubs url and login as a checker userr
And then checker claim the records
Then click on the checker Notification 
And select the Cheque record and Approve by checkers
		
@KUBS_AR_AP_UAT_008_001_TC_02_3
Scenario: Login as Maker
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excelsheet Testdata for payment file legal
And verify payment file download format is in bank and accont number wise
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file
And verify Where payment mode is Wire Transfer

@KUBS_AR_AP_UAT_008_002_TC_01  @AR/AP @blocker
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank Wise
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excel sheet testdata for online payment
And configure the file format as Bank Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque recordssss
Then logout from maker
@KUBS_AR_AP_UAT_008_002_TC_01_2
Scenario: Login as reviewer
And user update the Excel sheet testdata for online payment
And User should go to the kubs url and login as a reviewer userss
Then click on the Notification select the Cheque record and Approved
And logout from reviewer
@KUBS_AR_AP_UAT_008_002_TC_01_3
Scenario: Login as Checker 
And user update the Excel sheet testdata for online payment
Then log in to the Checker Account
And then checker claim the records
Then click on the checker Notification 
And select the Cheque record and Approve by checkers
Then logout from checker
@KUBS_AR_AP_UAT_008_002_TC_01_4
Scenario: Login as Maker	
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excel sheet testdata for online payment
And verify payment file download format is in Bank wise wise
And click on accounts Payable module
When click on eye button of manual payout
Then click on search
And search the transfer as payment mode
And goto payment file download module 
And enter branch name
And click on calendar in the payment file download module
And enter the payout date
And click on go button 
And download the payment file
Then logout from maker

@KUBS_AR_AP_UAT_008_003_TC01  @AR/AP @blocker
Scenario: Verify download file is auto created basis the defined time and user is allowed to download the file.
 Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excel sheet testdata for online payments
And configure the file format as Payout wise
And save the arap configure record
And validate the saved record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record1

@KUBS_AR_AP_UAT_008_003_TC01_2
Scenario: Login as reviewer
And user update the Excel sheet testdata for online payments
	Then log in to the reviewer account
	Then click on the Notification select the Cheque record and Approve
	
	@KUBS_AR_AP_UAT_008_003_TC01_3
	Scenario: Login as Checker
	And user update the Excel sheet testdata for online payments
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		
	@KUBS_AR_AP_UAT_008_003_TC01_4
	Scenario: Login as maker		
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And user update the Excel sheet testdata for online payments
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






