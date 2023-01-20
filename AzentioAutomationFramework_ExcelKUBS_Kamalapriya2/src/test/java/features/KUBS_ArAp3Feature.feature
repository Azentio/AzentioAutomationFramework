Feature: To Test the AR Ap module
@KUBS_AR_AP_UAT_003_008_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given Maker Navigate to UAT URL login
And Goto accounts receivable advances module
Then click on search 
And select one record from advances
Then go to ar ap adjustment module
And click on Add Icon
And Fill The form for advance adjustment
Then validate record got save in maker stage
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
Then validate record got save in maker stage
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
#Then Click the Alert message as Yes
Then validate record got save in maker stage
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
		Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from checker 
Given Navigate The Azentio Url
Then Choose the second Tab Segment
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type as AR Advance
And Give the Advance Adjustment Ref No and Validate
@KUBS_AR_AP_UAT_004_001TC_01  @AR/AP
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
  @KUBS_AR_AP_UAT_004_001TC_02  @AR/AP
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
  @KUBS_AR_AP_UAT_004_001TC_03  @AR/AP
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
  @KUBS_AR_AP_UAT_004_001TC_04  @AR/AP
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
  @KUBS_AR_AP_UAT_004_001TC_05  @AR/AP
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
  @KUBS_AR_AP_UAT_004_002_TC_01  @AR/AP
Scenario: Verify Advance (To Employee) is available in the system for payment settlement
Given Maker Navigate to UAT URL login
And Goto accounts receivable advances module
And click on Add Icon
And Fill the mendatory fields for creating advance to employee
And Save the advance record
Then validate record got save in maker stage
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
And Goto accounts receivable advances module
And get the receivable number from aproved record
And go to aacounts payable module
And Go to payment settlement module
And click on Add Icon
Then verify approved record is availabe for payment settlement

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
Then validate record got save in maker stage
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
@KUBS_AR_AP_UAT_004_004TC_01  @AR/AP
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
   
   @KUBS_AR_AP_UAT_004_005_TC_01  @AR/AP
Scenario: Verify Credit Note is adjusted against the selected bill and Net Adjusted Value is correctly displayed
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
Given Maker Navigate to UAT URL login
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
Then validate record got save in maker stage
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

Given Maker Navigate to UAT URL login
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
Given Maker Navigate to UAT URL login
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
@KUBS_AR_AP_UAT_005_001_TC_01  @AR/AP
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
    @KUBS_AR_AP_UAT_005_001_TC_02  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    @KUBS_AR_AP_UAT_005_001_TC_03  @AR/AP
  Scenario: Verify canceling payment settlement is not allowed if payout for the transaction is approved.
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation of aprroved payout and verify
    @KUBS_AR_AP_UAT_006_001_TC_01_Vendor  @AR_AP @e6
  Scenario: Creating Manual payouts for approved Bills of a Vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout vendor
    Then Save and submit the manual payout record
    
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