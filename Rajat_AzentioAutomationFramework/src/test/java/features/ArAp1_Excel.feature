Feature: AR/AP Module

@KUBS_AR/AP_UAT_001_001_TC_001_01 @AR/AP
Scenario: Create a contract for an active vendor with expense type Purchases
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
And click on add button to create contract
And Updating Testdata Id for Vendor contract
And Fill the required fields to create contract
Then Save and submit the creation contract record
@KUBS_AR/AP_UAT_001_001_TC_001_02
Scenario: Reviewer Approved the Vendor Contract
And User update the datasetId for vendor contract reviewer
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
And approve the record by reviewer user
@KUBS_AR/AP_UAT_001_001_TC_001_03
Scenario: Checker Approved the Vendor Contract
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
Then checker should approved the contract record

@KUBS_AR/AP_UAT_001_001_TC_001_04
Scenario: Marker Verify  the Vendor Contract
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
Then Get the contract and Txn status by searching the record via business partner
And maker should logout

 @KUBS_AR/AP_UAT_001_001_TC_02  @AR/AP
Scenario: PO should be created successfully and displayed in approved queue with Active Status
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order eye button    
    
@KUBS_AR/AP_UAT_001_001_TC_003  @AR/AP
Scenario: Verify PO is emailed to Vendor post approval of PO	GRN should be created successfully 
		and displayed in approved queue with Active Status.
		
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation eye button
Then Fill the form and check if GRN is showing or not which we created

@KUBS_AR_AP_UAT_003_009_TC_02  @AR/AP
Scenario: Verify cancelled advances is not available for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
And Updating Testdata Id for cancelled advances
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
And Updating Testdata Id for cancelling Against PO
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
And fill the calender details and description
And Save the form
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker

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

