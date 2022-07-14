 Feature: AR/AP Module

@KUBS_AR/AP_UAT_003_008_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement

Given Maker Navigate to UAT URL login
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
Given Maker Navigate to UAT URL login
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the form for cancelled advances
And find the invoice reference number for cancelled advance is not availabe at the billing queue

#f
@KUBS_AR_AP_UAT_003_008_TC_03  @AR/AP
Scenario: Verify cancelling Advance To employee is not allowed if the same has been adjusted at payment settlement
Given Maker Navigate to UAT URL login
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
Given Maker Navigate to UAT URL login
And goto arap adjustment main module
Then go to ar ap adjustment module
And click on Add Icon
Then check the settlement completed advance can be cancelled


#p

@KUBS_AR_AP_UAT_003_009_TC_01  @AR/AP
Scenario: Verify No accounting entry is generated on cancelling advances against PO
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
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
Then Verify No accounting entry is generated on cancelling advances against PO

#p
@KUBS_AR_AP_UAT_003_009_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for cancelled Advances is availabe at the billing queue

#f
@KUBS_AR_AP_UAT_003_009_TC_03  @AR/AP
Scenario: Verify cancelling Against PO is not allowed if the same has been adjusted at payment settlement
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
And find the Advance reference number for Active Advances is availabe at the billing queue
Then Click the Checkbox As Tick
When Enter the Description value
And Save The Payment settlement Record
Then Click the Alert message as Yes
#Then Goto The Notification Icon
#And Store the Referance Id and Open the Record
#Then Click submit button and Enter Remark submit it 
#Given Navigate as a Reviewer
#Then click on Notify icon
#And Click First record Action icon
#Then Approve the record in Reviewer
#And Give Remark and Submit
#Given Navigate as a Checker
#Then Click module security management
#And Claim the Record in Checker
#Then Goto the Checker notification Icon
#And Click the First Action Icon
#Then Approve the Record in checker stage
#And Give the Remark and Submit it
#Then logout from checker 
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given Navigate The Azentio Url
Then Choose the second Tab Segment
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type as AR Advance
And Give the Advance Adjustment Ref No and Validate




#aj f
@KUBS_AR/AP_UAT_004_001TC_01  @AR/AP
  Scenario: verify active bill is available for payment settlement
  Given log in to azentio as maker
  When click the Account payable module
  And click the invoice booking eye icon in sub module
  And search Invoice status as active
  And click the first eye icon in the list view
  And get the buisness partner from invoice bill
  And click the payment settlement eye icon in Accounts payable
  And click the add icon fot the payment settlement
  And choose the payment option as Buisness partner Type
  And Enter buisness partner get from bill booking
  Then verify that active bill is available for payment settlement
#p 
 @KUBS_AR/AP_UAT_004_001TC_02  @AR/AP
  Scenario: verify tds% and amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option
  When click the Account payable Mainmodule
  And click the eye icon of the payment settlement
  And click the add icon of the payment settlement
  And select payment option as buisness partner type
  And select the buisness partner from the list
  And select listed bill contains tds percentage
  And get tds percentage and calculate tds amount
  Then verify tds in bill with calculated tds amt
 #f
 @KUBS_AR/AP_UAT_004_001TC_03  @AR/AP
  Scenario: verify net payable amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option for verify net payable amount 
  When click the Account payable Mainmodule for verify net payable amount 
  And click the eye icon of the payment settlement for verify net payable amount 
  And click the add icon of the payment settlement for verify net payable amount 
  And select payment option as buisness partner type for verify net payable amount 
  And select the buisness partner from the list for verify net payable amount 
  And select the bill in the list view
  And calculate the net payable amount from the bill in list view 
  Then verify netpayable amount in payment settlement with calculated amount
  #p need to copy from here
  @KUBS_AR/AP_UAT_004_001TC_04  @AR/AP
  Scenario: verify pop up messages displayed and click yes to payment process
  Given log into azentio as maker and select finance option for verify pop up
  When click the Account payable Mainmodule for verify pop up
  And click the eye icon of the payment settlement for verify pop up
  And click the add icon of the payment settlement for verify pop up
  And select payment option as buisness partner type for verify pop up
  And select the buisness partner from the list for verify  pop up
  And select any bill in list view
  And choose the valid date
  And Enter the description
  And Click save button
  And pop up messages displayed and click yes
  Then verify bill is proceed for payment
 #p
 @KUBS_AR/AP_UAT_004_001TC_05  @AR/AP
  Scenario: verify pop up messages displayed and click no to  return payment settlement
  Given log into azentio as maker and select finance option for verify pop up display
  When click the Account payable Mainmodule for verify pop up display
  And click the eye icon of the payment settlement for verify pop up display
  And click the add icon of the payment settlement for verify pop up display
  And select payment option as buisness partner type for verify pop up display
  And select the buisness partner from the list for verify pop up display
  And select any bill in list view for verify pop up display
  And choose the valid date for verify pop up display
  And Enter the description for verify pop up display
  And Click save button  for verify pop up display
  And pop up messages displayed and click no
  Then verify bill is not proceed for payment and return to payment settlement
  
  #f
  @KUBS_AR/AP_UAT_004_001TC_06  @AR/AP
  Scenario: verify accounting entries post payment settlement approval
   Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and verify payment Approval
   
    #p
   @KUBS_AR/AP_UAT_004_001Tc_07  @AR/AP
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   #And select the branch
   Then Fill branch details for report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   #need to give cancelled txt number
   
   #p
   @KUBS_AR/AP_UAT_004_001TC_08  @AR/AP
   Scenario: Verify Accounts Payable Report post payment settlement approval
    Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And get buisness partner name and payment settlement date
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   
  
  #p 
@KUBS_AR_AP_UAT_004_002_TC_01  @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement
Given Maker Navigate to UAT URL login
And Goto accounts receivable advances module
And click on Add Icon
And Fill the mendatory fields for creating advance to employee
And Save the advance record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker 
Given Maker Navigate to UAT URL login
And Goto accounts receivable advances module
And get the receivable number from aproved record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
Then verify approved record is availabe for payment settlement
#p

@KUBS_AR/AP_UAT_004_002_TC_02  @AR/AP
Scenario: Verify No accounting entries are posted post payment settlement approval.
Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the Branch detail
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate No accounting entries are posted


#p
@KUBS_AR_AP_UAT_004_003_TC_01  @AR/AP
Scenario: Verify Advance (Against PO) is available in the system for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner Value
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
#Then Goto The Notification Icon
#And Store the Referance Id and Open the Record
#Then Click submit button and Enter Remark submit it 
#Given Navigate as a Reviewer
#Then click on Notify icon
#And Click First record Action icon
#Then Approve the record in Reviewer
#And Give Remark and Submit
#Given Navigate as a Checker
#Then Click module security management
#And Claim the Record in Checker
#Then Goto the Checker notification Icon
#And Click the First Action Icon
#Then Approve the Record in checker stage
#And Give the Remark and Submit it
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
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
And find the Advance reference number for Active Advances is availabe at the billing queue
#p
@KUBS_AR_AP_UAT_004_003_TC_02  @AR/AP
Scenario: Verify No accounting entries are posted post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Enter Txn Number in payment Settlement
Then Click on Table Row First Eye Icon in ARAP
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No Accounting entries are posted post payment settlement approval
#f
 @KUBS_AR/AP_UAT_004_004TC_01  @AR/AP
   Scenario: Verify debit note is adjusted against the bill and Net adjusted value is correctly displayed
   Given log in as a Maker and select finance option for verify debit note against bill
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
   #f
   @KUBS_AR/AP_UAT_004_004TC_02  @AR/AP
   Scenario: verfiy tds percent and tds value correctly calculated and displayed based on debit note
   Given log in as a Maker and select finance option for verify tds in debit note against bill
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
   #f
   @KUBS_AR/AP_UAT_004_004TC_03  @AR/AP
   Scenario: verify net Payable amount is correctly calculated and displayed for debit note bill in payment settlement
   Given log in as a Maker and select finance option for verify Netpayable amount in debit note against bill
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
   Scenario: verify accounting entries post payment Approval for debit transaction
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and then payment approved
  #p
	@KUBS_AR/AP_UAT_004_004_TC_05  @AR/AP
	Scenario: Verify Balance sheet post payment settlement approval.
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report
	#p
   @KUBS_AR/AP_UAT_004_004TC_06  @AR/AP
   Scenario: Verify Accounts Payable Report post payment settlement approval for debit note
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get buisness partner name and payment settlement date, invoicenumber
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   #p
    @KUBS_AR/AP_UAT_004_004TC_07  @AR/AP
   Scenario: verify Receivable Report post payment Approval for debit note
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
   
   #f
   
@KUBS_AR_AP_UAT_004_005_TC_01  @AR/AP
Scenario: Verify Credit Note is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Maker Navigate to UAT URL login
And click on accounts Payable module
And goto invoice booking module
And click on Add Icon
And fill the mendatory field for invoice booking for expenseType invoice
And goto invoice bill booking temp view and select the record
And fill the second tab for expencess details
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker

Given Maker Navigate to UAT URL login
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking 

And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field to check the the net payable ammount
#p
@KUBS_AR_AP_UAT_004_005_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Maker Navigate to UAT URL login
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
#p
@KUBS_AR_AP_UAT_004_005_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed.
Given Maker Navigate to UAT URL login
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
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field to check the the net payable ammount
And fill the calender details and description
And Save the form
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

@KUBS_AR/AP_UAT_004_005_TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement approval
Given Maker Navigate to UAT URL login
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

 @KUBS_AR/AP_UAT_004_005TC_05  @AR/AP
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   #And select the branch
   Then Fill branch details for report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.

@KUBS_AR_AP_UAT_004_005_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given Maker Navigate to UAT URL login
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

@KUBS_AR_AP_UAT_004_005_TC_07  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval.
Given Maker Navigate to UAT URL login
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


@KUBS_AR_AP_UAT_004_006_TC_01  @AR/AP
Scenario: Verify Advance against PO is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
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

@KUBS_AR_AP_UAT_004_006_TC_02  @AR/AP
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
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

@KUBS_AR_AP_UAT_004_006_TC_03  @AR/AP
Scenario: Net payable amount is correctly calculated & displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
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

#@KUBS_AR_AP_UAT_004_006_TC_04
#Scenario: Verify accounting entries post payment settlement approval
#Given Navigate The Azentio Url
#Then Choose the second Tab Segment
#And Click On Main module Accounts payable
#Then Click sub module Payment settlement Eye Icon
#And Click On Search Icon
#Then Enter Advance Against PO and Active Value In Advance Status
#And Enter Advance Against Po Pan Number
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
#Then Verify Accounting entries post payment settlement approval

@KUBS_AR_AP_UAT_004_006_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
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

#KUBS_AR_AP_UAT_004_006_TC_06 - Not Automatable

@KUBS_AR_AP_UAT_004_006_TC_07  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report post payment settlement approval

@KUBS_AR_AP_UAT_004_006_TC_08  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Receivable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Receivable Report post payment settlement approval


@KUBS_AR_AP_UAT_004_007_TC_01  @AR/AP
Scenario: Verify Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
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

@KUBS_AR/AP_UAT_004_007_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

@KUBS_AR_AP_UAT_004_007_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Payable Report post payment settlement approval

@KUBS_AR_AP_UAT_004_007_TC_07  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name in Invoice Bill
When Store the Advance Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Receivable Report
And Give Getted Business Partner Name
Then Give Current business Date in ArAp
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Receivable Report post payment settlement approval


@KUBS_AR_AP_UAT_004_008_TC_01  @AR/AP
Scenario: Verify on payment date (As per Bill), settlement for the bill is auto approved.
Given Navigate to KUBS URL and login with maker credentials
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
Then click on po creation module
And get the approved po number from approved record
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record
And goto invoice bill booking temp view and select the record
And fill The invoice againse po record
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
And go to auto payout module 
And select the record from temp view
And fill the valued date
And fill the mendatory fields for auto payout record 
Then save the auto payout record
And select the record from temp view and initiate
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
And go to auto payout module 
And select the record from temp view

@KUBS_AR_AP_UAT_004_008_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement approval (Auto payout)
Given Maker Navigate to UAT URL login
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




@KUBS_AR/AP_UAT_005_001_TC_01  @AR/AP
  Scenario: User cancels the payment settlement transaction for multiple bills.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
 @KUBS_AR/AP_UAT_005_001_TC_02  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
     @KUBS_AR/AP_UAT_005_001_TC_03  @AR/AP
  Scenario: Verify canceling payment settlement is not allowed if payout for the transaction is approved.
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation of aprroved payout and verify
    
@KUBS_AR_AP_UAT_005_001_TC_04  @AR/AP
Scenario: Verify accounting entries post payment settlement cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Cancellation Eye Icon
Then Click on Table Row First Eye Icon in ARAP
And Get the Cancelled Txn Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post payment settlement cancellation

@KUBS_AR/AP_UAT_005_001_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement cancellation.

Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report