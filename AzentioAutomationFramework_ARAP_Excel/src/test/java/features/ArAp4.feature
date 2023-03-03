Feature: AR/AP Module
@KUBS_AR/AP_UAT_004_004_TC_01  @AR/AP
#failed due to invoice number is not reflecting in the debit note record
   Scenario: Verify debit note is adjusted against the bill and Net adjusted value is correctly displayed
   Given User should go to the kubs url and login as a maker user
   And user update the data set ID for debit note
   Then Click on the Direction
   When click Account receivable Main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search Active in debit note status
   And click first eye icon in list view 
   And get buisness partner name and invoice number
   And click Account Payable Main Module for verify debit note against bill
   And click eye icon in Payment Settlement for verify debit note against bill
   And click the add icon of the payment settlement for verify debit note against bill
   And select payment option as buisness partner type for verify debit note against bill
   And Select buisness partner according to debit note buisnes partner
   And search the invoice number based on invoice after click bill and get gross,debit amount
   Then calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list
   Then verify net adjusted value in bill with net adjusted value shown in payment settlement page
   
   @KUBS_AR/AP_UAT_004_004_TC_02  @AR/AP
   #failed due to invoice number is not reflecting in the debit note record
   Scenario: verfiy tds percent and tds value correctly calculated and displayed based on debit note
   Given User should go to the kubs url and login as a maker user
   Then Click on the Direction
   And user update the data set ID for debit note
   When click Account receivable Main module for verify tds in debit note against bill
   And click debit note eye icon for verify tds in debit note against bill
   And click search button and then click debit note status search for verify tds in debit note against bill
   And search Active in debit note status for verify tds in debit note against bill
   And click first eye icon in list view for verify tds in debit note against bill
   And get buisness partner name and invoice number for verify tds in debit note against bill
   And click Account Payable Main Module for verify tds in debit note against bill
   And click eye icon in Payment Settlement for verify tds in debit note against bill
   And click the add icon of the payment settlement for verify tds in debit note against bill
   And select payment option as buisness partner type for verify tds in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get
   And get tds percent , net adjusted,tds amount based on invoice then click bill
   And calculate tds value based on tds percent and net adjusted value and verify with tds value in bill
   And get tds value from payment settlement for debit note
   Then verify calculated tds value equals to tds value get from payment settlement and correctly displayed
 
   @KUBS_AR/AP_UAT_004_004_TC_03  @AR/AP
   #failed due to invoice number is not reflecting in the debit note record
   Scenario: verify net Payable amount is correctly calculated and displayed for debit note bill in payment settlement
   Given User should go to the kubs url and login as a maker user
   Then Click on the Direction
   And user update the data set ID for debit note
   When click Account receivable Main module for verify Netpayable amount in debit note against bill
   And click debit note eye icon for verify Netpayable amount in debit note against bill
   And click search button and then click debit note status search for verify Netpayable amount in debit note against bill
   And search Active in debit note status for verify Netpayable amount in debit note against bill
   And click first eye icon in list view for verify Netpayable amount in debit note against bill
   And get buisness partner name and invoice number for verify Netpayable amount in debit note against bill
   And click Account Payable Main Module for verify Netpayable amount in debit note against bill
   And click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill
   And click the add icon of the payment settlement for verify Netpayable amount in debit note against bill
   And select payment option as buisness partner type for verify Netpayable amount in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get in debit list view
   And get gross amount, debit amount,tds percent,netpayable amount
   And calculate net adjusted value , tds value from net adjusted
   And Calcualte net payable amount from calculated net adjusted value and tds value
   Then verify calculated net payable amount with net payable amount get from debit bill
   And get net payable amount from payment settlement
   Then verify net payable amount is correctly displayed according to debit bill
    #f
   @KUBS_AR/AP_UAT_004_004TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement approval
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
And Go to payment settlement module
And update data set id for accounting entries payment settlement 
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then verify approved settlement reference number is available in the Gl report
  #p
	@KUBS_AR/AP_UAT_004_004_TC_05  @AR/AP
	Scenario: Verify Balance sheet post payment settlement approval.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Update the data set id for Balance sheet Report b3
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries
	#p
   @KUBS_AR/AP_UAT_004_004TC_06  @AR/AP
   Scenario: Verify Accounts Payable Report post payment settlement approval for debit note
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
   #p
    @KUBS_AR/AP_UAT_004_004_TC_07  @AR/AP
   Scenario: verify Receivable Report post payment Approval for debit note
   Given User should go to the kubs url and login as a maker user
   Then Click on the Direction
   When click Account receivable Main module
   And click debit note eye icon
   And user update the data set ID for debit note
   And click search button and then click debit note status search
   And click first eye icon in list view 
   And get buisness partner name and invoice number
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And user update the data set ID for Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report
   
   #f
   
@KUBS_AR_AP_UAT_004_005_TC_01_01  @AR/AP
Scenario: Verify Credit Note is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And click on add button for invoice booking
And user update the data set ID for Invoice against Expense
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
Then click on the Notification icon
Then store the Reference ID and open the invoice booking record
Then click submit and enter remark for invoice booking
@KUBS_AR_AP_UAT_004_005_TC_01_02  @AR/AP
Scenario: Reviewer approved Invoice against Expense
And user update the data set ID for Invoice against Expense reviewer
And User login as a reviewer user for Invoice against Expense
Then Click on notification button in reviewer
And approve the record by reviewer for Invoice against Expense 
@KUBS_AR_AP_UAT_004_005_TC_01_03  @AR/AP
Scenario: Checker approved Invoice against Expense
And user update the data set ID for Invoice against Expense reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim for Invoice against Expense
And capture claimed status
Then click on notification in checker
Then checker should approved the record for Invoice against Expense
@KUBS_AR_AP_UAT_004_005_TC_01_04  @AR/AP
Scenario: approved record from invoice bill booking	
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on add button for invoice booking
And user update the data set ID for Invoice against Expense
And Fill the form for credit note

Then click on the Notification icon
Then store the Reference ID and open the credit note record
Then click submit and enter remark for credit note
@KUBS_AR_AP_UAT_004_005_TC_01_05  @AR/AP
Scenario: Reviewer approved credit note record
And user update the data set ID for credit note reviewer
And User login as a reviewer user for for credit note
Then Click on notification button in reviewer
And approve the record by reviewer for credit note 
@KUBS_AR_AP_UAT_004_005_TC_01_06  @AR/AP
Scenario:  Checker approved credit note record	
And user update the data set ID for credit note reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim for for credit note
And capture claimed status
Then click on notification in checker
Then checker should approved the record for credit note
@KUBS_AR_AP_UAT_004_005_TC_01_07  @AR/AP
Scenario: check the the net payable ammount
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
And user update the data set ID for credit note reviewer
And Go to payment settlement module
And click on add button for invoice booking
And fill the mendatory field to check the the net payable ammount


#p
@KUBS_AR_AP_UAT_004_005_TC_02_01 @AR/AP
Scenario: Verify Credit Note is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And click on add button for invoice booking
And user update the data set ID for Invoice against Expense
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
Then click on the Notification icon
Then store the Reference ID and open the invoice booking record
Then click submit and enter remark for invoice booking
@KUBS_AR_AP_UAT_004_005_TC_02_02  @AR/AP
Scenario: Reviewer approved Invoice against Expense
And user update the data set ID for Invoice against Expense reviewer
And User login as a reviewer user for Invoice against Expense
Then Click on notification button in reviewer
And approve the record by reviewer for Invoice against Expense 
@KUBS_AR_AP_UAT_004_005_TC_02_03  @AR/AP
Scenario: Checker approved Invoice against Expense
And user update the data set ID for Invoice against Expense reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim for Invoice against Expense
And capture claimed status
Then click on notification in checker
Then checker should approved the record for Invoice against Expense
@KUBS_AR_AP_UAT_004_005_TC_02_04  @AR/AP
Scenario: approved record from invoice bill booking	
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on add button for invoice booking
And user update the data set ID for Invoice against Expense
And Fill the form for credit note

Then click on the Notification icon
Then store the Reference ID and open the credit note record
Then click submit and enter remark for credit note
@KUBS_AR_AP_UAT_004_005_TC_02_05  @AR/AP
Scenario: Reviewer approved credit note record
And user update the data set ID for credit note reviewer
And User login as a reviewer user for for credit note
Then Click on notification button in reviewer
And approve the record by reviewer for credit note 
@KUBS_AR_AP_UAT_004_005_TC_02_06  @AR/AP
Scenario:  Checker approved credit note record	
And user update the data set ID for credit note reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim for for credit note
And capture claimed status
Then click on notification in checker
Then checker should approved the record for credit note
@KUBS_AR_AP_UAT_004_005_TC_02_07  @AR/AP
Scenario: check the the net payable ammount
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
And Go to payment settlement module
And click on add button for invoice booking
And fill the mendatory field to check the the net payable ammount

@KUBS_AR/AP_UAT_004_005_TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement approval
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
And Go to payment settlement module
And update data set id for accounting entries payment settlement 
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then verify approved settlement reference number is available in the Gl report

 @KUBS_AR/AP_UAT_004_005TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Update the data set id for Balance sheet Report b3
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries

