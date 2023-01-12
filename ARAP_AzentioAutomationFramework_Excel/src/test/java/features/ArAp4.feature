 Feature: AR/AP Module

@KUBS_AR_AP_UAT_005_001_TC_06  @AR/AP 
Scenario: Verify Accounts Payable Report post canceling payment settlement cancellation
Given Navigate The Azentio Url
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


 @KUBS_AR/AP_UAT_005_002_TC_01  @AR/AP @e1
  Scenario: User cancels the payment settlement transaction for multiple bills.
   Given Navigate The Azentio Url
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
    #Then Get the payout status
    And maker should logout
    
 @KUBS_AR/AP_UAT_005_002_TC_02  @AR/AP	@e2	
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_002_TC_03  @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
   Given Navigate The Azentio Url
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

@KUBS_AR/AP_UAT_005_002_TC_04  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

 @KUBS_AR/AP_UAT_005_002TC_05  @AR/AP @report
    Scenario: Verify Accounts Payable Report post cancelling payment settlement txn
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
   
   
   
   
   
    @KUBS_AR/AP_UAT_005_003_TC_01  @AR/AP @e3
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_003_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
Given Navigate The Azentio Url
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
#And give the refrence number which we going to see accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report


 @KUBS_AR/AP_UAT_005_004_TC_01  @AR/AP @e4
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
    @KUBS_AR_AP_UAT_005_004_TC_02  @AR/AP
Scenario: Verify accounting entries post payment settlement cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Cancellation Eye Icon
And Click On Search Icon
Then Enter Txn No for Advance to Empolyee
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
Then Verify Accounting entries Advance to Empolyee post payment settlement cancellation




#@_UAT_006_001_TC_01
  #Scenario: Creating Manual payouts for approved Bills of a Vendor
   #	Given Maker Navigate to UAT URL login
#		Then Click on Direction icon
#		Then Click on Account Payable 
    #When click on eye button of manual payout
    #And click on add button for manual payout
  #	And Fill the required fields for manual payout
 #	 	Then Click on save button to save the Record for Account Recivable
#		Then Click on Update Deposited Cheque Notification
#		And Select and Submit the Update Deposited Cheque record
#		Then log in to the reviewer account
#		Then click on the Notification select the Cheque record and Approve
#		Then log in to the Checker Account
#		And then checker claim the record
#		Then click on the checker Notification 
#		And select the Cheque record and Approve by checker
    #
    #Given Maker Navigate to UAT URL login
#		Then Click on Direction icon
#		Then Click on Account Payable 
    #When click on eye button of manual payout
    #Then Get the payout status
   
  @KUBS_AR/AP_UAT_006_001_TC_01_Vendor  @AR/AP @e6
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
    
	
@KUBS_AR_AP_UAT_006_001_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval (Manual payout for multiple bill)
Given Maker Navigate to UAT URL login
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

@KUBS_AR/AP_UAT_006_001_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

@KUBS_AR_AP_UAT_006_001_TC_04  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval (Payout for multiple bills)
Given Maker Navigate to UAT URL login
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
  
@KUBS_AR_AP_UAT_006_001_TC_05  @AR/AP
Scenario: Verify Payout Report post payout approval (Payout for multiple bills)
Given Maker Navigate to UAT URL login
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

  
  @KUBS_AR/AP_UAT_006_002_TC_01  @AR/AP @e5
  Scenario: Creating manual payouts for approved advances of a vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout
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
    


@KUBS_AR_AP_UAT_006_002_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
Given Maker Navigate to UAT URL login
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



@KUBS_AR_AP_UAT_006_002_TC_03  @AR/AP
Scenario: Verify Balance sheet post payout approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click on Sub module Maual payout
Then Click on Table Row First Eye Icon in ARAP
And Get the manual payout Branch Name
And Get the Referance Number
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
#And Give Getted Branch code 
Then Fill branch details for report
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved


@KUBS_AR_AP_UAT_006_002_TC_04  @AR/AP
Scenario: Verify Accounts Receivable Report post payout approval
Given Maker Navigate to UAT URL login
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

@KUBS_AR_AP_UAT_006_002_TC_005  @AR/AP
Scenario: Verify Accounts Payable Report post payout approval
Given Maker Navigate to UAT URL login
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


@KUBS_AR_AP_UAT_006_002_TC_06  @AR/AP
Scenario: Verify Payout Report post payout approval
Given Maker Navigate to UAT URL login
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
	

 
 
  @KUBS_AR/AP_UAT_006_003_TC_01_Employee  @AR/AP @e7
  Scenario: Creating Manual payouts for approved Bills of a Vendor
   Given User should go to the kubs url and login as a maker user
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    And click on add button for manual payout
  	And Fill the required fields for manual payout
 	 	Then Click on save button to save the Record for Account Recivable
		Then Click on Update Deposited Cheque Notification
		And Select and Submit the Update Deposited Cheque record
	And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
    
     Given User should go to the kubs url and login as a maker user
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    Then Get the payout status
    
@KUBS_AR_AP_UAT_006_003_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
 Given User should go to the kubs url and login as a maker user
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

@KUBS_AR/AP_UAT_006_003_TC_03 @Report  @AR/AP
  Scenario: Verify Balance sheet post payout approval
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly

 @KUBS_AR_AP_UAT_006_003_TC_04  @AR/AP
 Scenario: Verify Accounts Receivable Report post payout approval
 Given Maker Navigate to UAT URL login
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

 @KUBS_AR_AP_UAT_006_003_TC_05  @AR/AP
 Scenario: Verify payout Report post payout approval
 Given Maker Navigate to UAT URL login
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



@KUBS_AR/AP_UAT_007_001_TC_01  @AR/AP @(NoDateInAutoPayout)
Scenario: Auto payouts for approved Bills of a Vendor
Given User should go to the kubs url and login as a maker user
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable

Then Click on Auto Payout edit grid
Then Click on action button of record which we need to verify for details


@KUBS_AR_AP_UAT_008_001_TC_01  @AR/AP @Fail
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank & Account Number Wise
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank & Account Number Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given User should go to the kubs url and login as a maker user
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


@KUBS_AR_AP_UAT_008_001_TC_02  @AR/AP @NA
Scenario: Verify payment file includes only below records,Where payment mode is Wire Transfer.Beneficiary Account is NOT maintained with legal entity.
Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank & Account Number Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
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

#KUBS_AR_AP_UAT_008_002_TC_03 - NA




@KUBS_AR_AP_UAT_008_002_TC_01  @AR/AP @blocker
Scenario: Checking of downloaded payment files for online payment where create file basis is Bank Wise
 Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Bank Wise
And save the arap configure record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
			And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
 Given User should go to the kubs url and login as a maker user
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

#_UAT_008_002_TC_02 -Defect

#_UAT_008_002_TC_03 -Defect



@KUBS_AR_AP_UAT_008_003_TC01  @AR/AP @blocker
Scenario: Verify download file is auto created basis the defined time and user is allowed to download the file.
 Given User should go to the kubs url and login as a maker user
And click on arap configuration main menu
And click on payment file generation setup sub menu
And configure the file format as Payout wise
And save the arap configure record
And validate the saved record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
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

#@KUBS_AR_AP_UAT_008_003_TC_02 - NA

#@KUBS_AR_AP_UAT_008_003_TC_03 - NA



@KUBS_AR_AP_UAT_009_001_TC_01  @AR/AP @blocker
Scenario: Checking of upload payment files for online payments
 Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
And click on view button near by payment file upload module
And click on Add Icon
And upload the downloaded Payment file
And click on upload button
Then verify the reference number and payout status unsuccessfull reason is visible in screen
And save the upload file record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker


#\_UAT_009_001_TC_03 - NA


@KUBS_AR_AP_UAT_010_001_TC_01  @AR/AP
Scenario: Record a receipt through cheque mode
 Given User should go to the kubs url and login as a maker user
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
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_001_TC_02  @AR/AP @E8
Scenario: Record a receipt through Online mode
 Given User should go to the kubs url and login as a maker user
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
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon in ARAP

@KUBS_AR_AP_UAT_010_001_TC_03  @AR/AP
Scenario: Verify accounting entries post receipt recording
Given Navigate The Azentio Url
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
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post receipt recording

 @KUBS_AR/AP_UAT_010_001_TC_04  @AR/AP
  Scenario: Verify Balance sheet post approval through online mode
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly post approval through online mode




@KUBS_AR_AP_UAT_010_002_TC_01  @AR/AP 
Scenario: Check cheque receipts are available for the selected Bank
  Given User should go to the kubs url and login as a maker user
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
				And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
			Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
 Given User should go to the kubs url and login as a maker user
And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
Then check our bill is appeared in the list view

@KUBS_AR_AP_UAT_010_002_TC_02  @AR/AP
Scenario: Verify status for the receipt is auto changed to Deposit
 Given User should go to the kubs url and login as a maker user
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
				And User should go to the kubs url and login as a reviewer user

		Then click on the Notification select the Cheque record and Approve
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login

And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
And select our bill
And save the bill record




@KUBS_AR/AP_UAT_010_002_TC_03 @AR/AP

Scenario: Update cheque status to Cleared
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

  @KUBS_AR/AP_UAT_010_002_TC_04  @AR/AP
  Scenario: Verify accounting entries for cleared cheques.
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of update cheque status
    Then get slip number by using cheque number
    Then click on report icon1
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the required fields of financial transaction
    Then click on view button to view the reports and verify
 
 
#@_UAT_010_002_TC_04
#Scenario: Verify accounting entries for cleared cheques
#
#Given Navigate to URL and user should login as a maker
#Then Click on Report buttonT
#And click Enquiry menu
#Then click on Edit icon near by financial transaction
#And choose branch code Id
#
#And click on transaction from date in calender icon
#Then choose from date in the calender
#And click on the transaction to date in calender icon
#Then choose the To date in the calender
#And click on view button to see the Record
#Then Verify record is available in the sheet or not

@KUBS_AR/AP_UAT_010_002_TC_05  @AR/AP
  Scenario: Verify Balance sheet post cheque is cleared
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    Then Fill branch details for report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly post cheque is cleared
    
    
    
    

@KUBS_AR/AP_UAT_010_003_TC_01  @AR/AP
Scenario: Bouncing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Bounced
Then Add Bank Charges
Then Select the bounced reason
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

@KUBS_AR/AP_UAT_010_003_TC_02  @AR/AP
Scenario: Verify accounting entries for bounced cheques.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate bounced cheques vourcher number 



@KUBS_AR/AP_UAT_010_004_TC_01  @AR/AP
Scenario: Update cheque status to Cleared Bouncing & redepositing of deposited cheques
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Update cheque status Note icon
Then Select the Record
Then Select Cheque Status Cleared
Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker

@KUBS_AR/AP_UAT_010_004_TC_02  @AR/AP
Scenario: Verify accounting entries for bounced & redeposited cheques.
Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate cleared cheques vourcher number 
#DEP-RR88888888-20220307




@KUBS_AR/AP_UAT_010_005_TC_01  @AR/AP
Scenario: Check approved receipts are available for appropriation.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation

@KUBS_AR/AP_UAT_010_005_TC_02  @AR/AP
Scenario: Approved receivables must be list for appropriation 
					which are not cancelled or appropriated fully.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation


#Below 2 scenario are duplicates
#@_UAT_010_005_TC_03  @AR/AP
#Scenario: Verify Credit Note is not available for appropriation against receipt.
#Given Navigate to kubs URL and user should login as a maker
#Then Click on the Finance
#Then Click on the Direction
#Then Click on Accounts Recivable
#Then Click on Appropriation eye button
#Then Click on add button of  Appropriation
#Then Verify Credit Not record is available or not

@KUBS_AR_AP_UAT_010_005_TC_03  
Scenario: Verify Credit Note is not available for appropriation against receipt.
Given Navigate to kubs URL and user should login as a maker
And goto accouts Receivable module
And goto credit notet module
And get the approved credit note reference number
And goto appropriation module
And click on Add Icon
And validate the credit note approved record is not available
    

@_UAT_010_005_TC_04 @AR/AP

Scenario: Below amount must be correctly calculated & displayed post receipt appropriation.
 				  Receipt Outstanding, Appropriation Amount, Outstanding amount for Receivables.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Recivable button
Then Click on Account Recivable Appropriation eye button
Then Click to add record in Account Recivable
Then Check receipt is available for Appropriation
Then enter App Amount check the calculation for Outstanding amount for Receivable
Then Click on Appropriation Save button
Then Click on inventory stock Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR/AP_UAT_010_005_TC_05  @AR/AP
  Scenario: Verify accounting entries for appropriating receipts against:
 						 1. Debit Note
 						 2. Advance against PO
 						 3. Advance to Employee
						 
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against debit note
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against debit note
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against advance po
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against Advance PO
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of appropriation
    Then click on search button
    Then get trx no for appropriating receipts against advance employee
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    
    And fill the required fields for appropriating receipt against debit note
    Then click on view button to view the reports
    And Verify for appropriating receipt against Advance to Employee

@KUBS_AR/AP_UAT_010_005_TC_06  @AR/AP
Scenario: Verify Balance sheet post appropriating receipts against:Debit Note ,Advance against PO, Advance to Employee

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for report
Then Select date in calendar
Then Click on View button
Then close the report

@KUBS_AR/AP_UAT_010_005_TC_07	  @AR/AP
Scenario: Accounts Receivable Report must display the correct info for logged in Branch

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Reports tab
Then Click on Account Receivable Report edit button
Then Fill Vendor employee details for report
Then Select date in calendar
Then select Receivable Status
Then Click on the View button
Then close the report


@KUBS_AR/AP_UAT_011_001_TC_01  @AR/AP
Scenario: Cancellation of approved receipts	Cancel approved receipts through Cheque Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals formm
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button

@KUBS_AR/AP_UAT_011_001_TC_02  @AR/AP
Scenario: Cancel approved receipts through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals form
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button

@KUBS_AR_AP_UAT_011_001_TC_03  @AR/AP
Scenario: Verify accounting entries post receipt cancellation
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Reverels Eye Icon
And Click On Search Icon
Then Enter Receipt Reversals type as Wire
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post receipt recording
	
@KUBS_AR/AP_UAT_011_001_TC_04  @AR/AP
Scenario: Verify Balance sheet post receipt cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for report
Then Select date in calendar
Then Click on View button
Then close the report



@KUBS_AR/AP_UAT_011_002_TC_01  @AR/AP
Scenario: Cancel receipt appropriation through cheque mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal


@KUBS_AR/AP_UAT_011_002_TC_02  @AR/AP
Scenario: Cancel receipt appropriation through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation for online mode
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal

#_UAT_011_002_TC_03 - Functionality NA

@KUBS_AR/AP_UAT_011_002_TC_04  @AR/AP
Scenario: Verify Balance sheet post receipt appropriation cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report buttonT
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit buttonT
Then Fill branch details for report
Then Select date in calendar
Then Click on View button
Then close the report

 @KUBS_AR/AP_UAT_011_002TC_05  @AR/AP
   Scenario: Verify receipts and receivable against cancelled appropriation are available again for receipt appropriation
    Given user navigate to azentio url and login as maker
    When click the Account Receivable main module
    And click the Appropriation reversal eye icon
    And click the search icon in list view
    And search the txt num
    And click first eye icon in list view Searched
    And get Receipt Reference number
    And click the Appropriation eye icon
    And click add icon
    And select the Reference number based on we got from Appropriation reversal
    And Click save button
    Then verify Receipts and receivable against cancelled appropriation must be available again for receipt appropriation
    
    #_UAT_011_002_TC_06 - Functionality NA
    
    
    #_UAT_012_001_TC_01 - _UAT_012_003_TC_05 (Not Automatable)
	
	
	@KUBS_AR/AP_UAT_013_001_TC_01  @AR/AP
Scenario: Verify creating PO against contracts is not allowed if PO QTY
 					is greater than available Contract QTY For Expense Type Purchase
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order fields
Then Enter Po Quantity

@KUBS_AR/AP_UAT_013_TC_02  @AR/AP

Scenario: Verify creating PO against contract is allowed if total QTY of previous
				  and Current PO is greater than contract QTY but total PO Amount is equal 
				  or lesser than contract value For Expense Type Service
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then enter the PO service type details
Then Click on Account Payable Save button
Then Click on purchase order Add button
Then fill the item details PO Amount is equal or lesser than contract Amount
Then Click on Account Payable Save button
Then fill Beneficiary Details
Then Click on Beneficiary Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected final record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_AR/AP_UAT_013_TC_03  @AR/AP
Scenario: Verify creating PO against contract is not allowed if PO Amount is
					greater than contract value but PO Qty is equal or lesser than Contract QTY.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record				
Then Edit the item details PO Qty fields

@KUBS_AR/AP_UAT_013_001_TC_04  @AR/AP
Scenario: Verify Creating GRN is not allowed if total QTY of previous and current GRN is greater than PO Qty

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN
Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add Excessive PO qty received qty approved

 # invoice type,SRN should be change in json
  @KUBS_AR/AP_UAT_013_001_TC_05  @AR/AP
  Scenario: Verify creating Bill is not allowed if YTD amount for expense exceeds mapped budget code limit. 
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking with exceeded amount
    Then Save and submit the invoice billing with exceeded amount

@KUBS_AR_AP_UAT_013_001_TC_06  @AR/AP
Scenario: Verify Payment settlement txn is not available for payout if net payabe is 0.
Given Maker Navigate to UAT URL login
And click on accounts Payable module
And go to invoice bill booking module
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
And Go to payment settlement module
And click on Add Icon
And fill the payment settlement record and validate the invoice number is not available in the invoice list view


@KUBS_AR/AP_UAT_013_002_TC_01  @AR/AP
  Scenario: Verify Receivables once adjusted against Bill is not available for appropriation on Receipt appropriation screen
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of receivable debit note
    Then click on add button
    And Fill the required fields in debit note screen
    Then save and submit the record of receivable debit note
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the record of receivable debit note
    
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement against bill
    And click on add button for payment settlement against bill
    And Fill the required fields to adjust against bill
    Then Save and submit the payment settlement
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the payment settlement against bill
    
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of receivable debit note
    Then get the receivable debit number to verify
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    Then click on eye button of appropriation to verify
    Then click on add button
    Then Verify the receivable adjusted against bill is not available for appropriation
    
    @KUBS_AR/AP_UAT_013_002TC_02 @AR/AP
    Scenario: Verify Receivables once appropriated against a receipt is not adjusted against a bill on payment settlement screen.
    Given User should go to the kubs url and login as a maker user
And click on accounts Payable module
And go to invoice bill booking module
Then click on search
And search the invoice agaist po in invoice type area
And get the approved invoice reference to do debit note

And goto accouts Receivable module to do debit note 

And click on debit note module
And click on Add Icon
And fill the debit note details against that bill 
And save the debit note record 
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		 And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
 Given User should go to the kubs url and login as a maker user

And goto accouts Receivable module
And click on debit note module
And get the recently we approved debit note reference number
And goto appropriation module
And click on Add Icon
And do the appropriation for the debit note record
And save the appropriation record 
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
		  And User should go to the kubs url and login as a reviewer user
		Then click on the Notification select the Cheque record and Approve
		Given User should go to the kubs url and login as a checker user
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
 Given User should go to the kubs url and login as a maker user
Then click on second Segment button
And click on accounts Payable module
And Go to payment settlement module
And click on Add Icon
And check the aprropriation against bill is visible in the payment settlement or not in payment settlement module