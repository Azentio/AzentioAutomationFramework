Feature: Testing the functionalities of  AR/AP Module
    @KUBS_AR/AP_UAT_006_003_TC_01_01 
    Scenario: Creating Manual payouts for approved Bills of a Vendor
    And User update test data id for Manual payouts
   	Given Maker Navigate to UAT URL login
   	Then Click on the Finance
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    And click on add button for manual payout
    And User Select Entity branch for Manual payout
    And User Select BP Name for Manual payout
    And User Select the Beneficiary Name for Manual payout 
    And User Select the Currency for Manual payout
    And User Select the Payment Bank for Manual Payout
    And User select the Bank Account number for Manual Payout
    And User select the Payment mode for Manual Payout 
    And User select the Reference Number for Manual Payout
    And User select the Cheque Number for Manual Payout
    And User Enter remark for Manual Payout
    And User Select the Payment transaction number
 	 	Then Click on save button to save the Record for Account Recivable
 	 	And User close the workflow initiated pop up
		Then Click on Update Deposited Cheque Notification
		And Select and Submit the Update Deposited Cheque record
		And maker should logout
		And User Verify the Login Page
		@KUBS_AR/AP_UAT_006_003_TC_01_02  
		Scenario: Approve the Manual Payout record in reviewer
		And User update test data id for Approve the Manual Payout record in reviewer
		Then log in to the reviewer account
		Then click on the Notification select the Cheque record and Approve
		And maker should logout
		And User Verify the Login Page
		@KUBS_AR/AP_UAT_006_003_TC_01_03
		Scenario: Approve the Manual Payout record in checker
		And User Update the test data id for Approve the Manual Payout record in checker
		Then log in to the Checker Account
		And then checker claim the record
		Then click on the checker Notification 
		And select the Cheque record and Approve by checker
		And maker should logout
		And User Verify the Login Page
    @KUBS_AR/AP_UAT_006_003_TC_01_04
    Scenario:  Verify the Manual payout record in Maker
    Given Maker Navigate to UAT URL login
   	Then Click on the Finance
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
		And User Verify the Login Page
		@KUBS_AR_AP_UAT_006_003_TC_02  @AR/AP
Scenario: Verify accounting entries post payout approval
And User update test data id for Verify accounting entries post payout approval
Given Maker Navigate to UAT URL login
Then Click on the Finance
Then Click on Direction icon
Then Click on Account Payable 
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
    And User update test data id for Verify Balance sheet post payout approval
   	Given Maker Navigate to UAT URL login
   	Then Click on the Finance
		Then Click on Direction icon 
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And User Select the branch name for Balance sheet post payout 
    And User Select the report type for Balance sheet post payout
    And User Select the balance sheet on date for Balance sheet post payout
    #And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly

 @KUBS_AR_AP_UAT_006_003_TC_04  @AR/AP
 Scenario: Verify Accounts Receivable Report post payout approval
And User update test data id for Verify Accounts Receivable Report post payout approval
Given Maker Navigate to UAT URL login
Then Click on the Finance
Then Click on Direction icon
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
And Choose date for Accounts Receivable report
And enter the advances to employee status active
And click on the view button 
Then verify the advance reference number is available in the accounts Receivable report

 @KUBS_AR_AP_UAT_006_003_TC_05  @AR/AP
 Scenario: Verify payout Report post payout approval
And User update test data id to Verify payout Report post payout approval
Given Maker Navigate to UAT URL login
Then Click on the Finance
Then Click on Direction icon
And click on accounts Payable module
And click on view button near by manual payout module
And get the recently approved payout reference number 
Then click on report segment button
And click on report main menu
And click on the payout report
And enter business partner name for payout report
And click on date icon
And Choose date for Accounts Receivable report
And enter payout status in payout report
And click on the view button
Then verify approved payout reference number is available in the payout report
		
		@KUBS_AR/AP_UAT_005_001_TC_01_01  @AR/AP
  	Scenario: User cancels the payment settlement transaction for multiple bills.
    And User update test data id for cancellation of payment settlement
   	Given Maker Navigate to UAT URL login
   	Then Click on the Finance
   	Then Click on Direction icon
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And User Select the Entity branch for payment cancellation
    And User Select the Transaction Number for payment cancellation
    And Store the selected Transaction number for payment cancellation
    And User Select the value date for payment cancellation
    And User Enter Remarks for payment cancellation 
    Then Save and submit the payment settlement cancellation record
    And maker should logout
		And User Verify the Login Page
    @KUBS_AR/AP_UAT_005_001_TC_01_02
    Scenario: User Approve the cancelled payment settlement transaction in reviewver
    And User update test data id for Approve cancelled payment settlement transaction in reviewver
		Then log in to the reviewer account for payment settlement
		Then click on the Notification select the Cheque record and Approve
  	And maker should logout
		And User Verify the Login Page
  	@KUBS_AR/AP_UAT_005_001_TC_01_03 
  	Scenario: User Approve the cancelled the payment settlement transaction in checker
  	And User update test data id for Approve cancelled payment settlement transaction in reviewver
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    And maker should logout
		And User Verify the Login Page
    @KUBS_AR/AP_UAT_005_001_TC_01_04
    Scenario: User verify the cancelled payment settlement transaction in Maker
    And User update test data id to verify the cancelled payment settlement transaction in Maker
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
 
 @KUBS_AR/AP_UAT_005_001_TC_02  @AR/AP
  Scenario: Verify cancelled payment txn is not available for payout on payout screen
  	And User update test data id to verify cancelled payment txn is not available for payout on payout screen
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And User Select Entity branch for Manual payout to verify cancelled payment transaction
    And User Select BP Name for Manual payout to verify cancelled payment transaction
    And User Select the Beneficiary Name for Manual payout to verify cancelled payment transaction
    And User Select the Currency for Manual payout to verify cancelled payment transaction
    And User Select the Payment Bank for Manual Payout to verify cancelled payment transaction
    And User select the Bank Account number for Manual Payout to verify cancelled payment transaction
    And User select the Payment mode for Manual Payout to verify cancelled payment transaction
    And User select the Reference Number for Manual Payout to verify cancelled payment transaction
    And User select the Cheque Number for Manual Payout to verify cancelled payment transaction
    And User Enter remark for Manual Payout to verify cancelled payment transaction
    And Fill the required fields for verify cancelled payment txn availability
    @KUBS_AR_AP_UAT_005_001_TC_03  @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
And User update test data id to verify accounting entries post payment settlement approval
Given Maker Navigate to UAT URL login
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And search for approved record in view area for post payment settlement
And get the approved record from list view
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And click on transaction from date calender icon 
Then choose the from date to verify accounting entries post payment settlement approval
And click on the transaction to date calender icon
Then choose the to date for verify accounting entries post payment settlement approval
And give the refrence number which we going to see accounting entries
And click on view button
Then verify approved settlement reference number is available in the Gl report

@KUBS_AR/AP_UAT_005_001_TC_04  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval
And User Update test data id to Verify Balance sheet post payment settlement approval
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
And User Select branch code for Verify Balance sheet post payment settlement approval
And User Select report type for Verify Balance sheet post payment settlement approval
Then Select date in calendar
Then Click on the View button
Then close the report
		
    