Feature: AR/AP Module

  @KUBS_AR/AP_UAT_001_004_TC_08  @AR/AP
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

  @KUBS_AR/AP_UAT_001_005_TC_08  @AR/AP
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


@KUBS_AR_AP_UAT_001_006_TC_06  @AR/AP
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


@KUBS_AR/AP_UAT_001_007_TC_04  @AR/AP
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

@KUBS_AR_AP_UAT_001_008_TC_03  @AR/AP
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


@KUBS_AR_AP_UAT_001_009_TC_03  @AR/AP
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

@KUBS_AR_AP_UAT_001_010_TC_03  @AR/AP
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
   @KUBS_AR/AP_UAT_003_004_TC_02  @AR/AP
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
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR/AP_UAT_003_004_TC_03  @AR/AP
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

@KUBS_AR/AP_UAT_003_004TC_04_01
Scenario: Check Budget utilization is re-instated
Given User should go to the kubs url and login as a maker user
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


@KUBS_AR/AP_UAT_003_004TC_04_02
Scenario: user login as reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record


@KUBS_AR/AP_UAT_003_004TC_04_03
Scenario: user login as checker
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


@KUBS_AR/AP_UAT_003_004TC_04_04
Scenario: user login as Maker
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


@KUBS_AR/AP_UAT_003_004TC_04_05
Scenario: user login as reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record


@KUBS_AR/AP_UAT_003_004TC_04_06
Scenario: user login as checker
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert


@KUBS_AR/AP_UAT_003_004TC_04_07
Scenario: user login as Maker
Given User should go to the kubs url and login as a maker user
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


@KUBS_AR/AP_UAT_003_004TC_04_08
Scenario: user login as reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record


@KUBS_AR/AP_UAT_003_004TC_04_09
Scenario: user login as checker
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


@KUBS_AR/AP_UAT_003_004TC_04_10
Scenario: user login as Maker
And login with Maker ID
And maker should navigate to the budget module UAT 
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then check the budget utilazation amount of budet code which we create the expense code after cancelling the po
Then verify budget code budget utilization amount is re-instated after cancelling the po

@KUBS_AR/AP_UAT_003_004TC_05  @AR/AP
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

@KUBS_AR/AP_UAT_003_005_TC_01  @AR/AP
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

@KUBS_AR/AP_UAT_003_005_TC_02  @AR/AP
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

@KUBS_AR_AP_UAT_003_005_TC_03  @AR/AP
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

@KUBS_AR_AP_UAT_003_005_TC_04  @AR/AP
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

@KUBS_AR_AP_UAT_004_002_TC_01  @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement
Given User should go to the kubs url and login as a maker user
And Goto accounts receivable advances module
And click on Add Icon
And user update the exccelsheet Testdata for Advance to Employee
And Fill the mendatory fields for creating advance to employee
And Save the advance record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record

@KUBS_AR_AP_UAT_004_002_TC_01_T1 @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for Reviewer
And user update the exccelsheet Testdata for Advance to Employee
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve

@KUBS_AR_AP_UAT_004_002_TC_01_T2  @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for checker
And user update the exccelsheet Testdata for Advance to Employee
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker 

@KUBS_AR_AP_UAT_004_002_TC_01_T3   @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement for maker
Given User should go to the kubs url and login as a maker user
And Goto accounts receivable advances module
And user update the exccelsheet Testdata for Advance to Employee
And get the receivable number from aproved record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
Then verify approved record is availabe for payment settlement