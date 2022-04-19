Feature: To verify user can able to do transaction in gl2 moduyle
@KUBS_GL2_UAT_001_001 @MultiAuth @GL2

Scenario: Create a ledger at entity level
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon

@KUBS_GL2_UAT_001_002 @MultiAuth @GL2

Scenario: Mapping the GL in side the entity level
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon

@KUBS_GL2_UAT_003_001 @MultiAuth @GL2

Scenario: Create a Journal Voucher to adjust the amount from one GL to another GL

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon
Then Click on Journal Voucher AddButton
Then Fill the Mandatory fields of Journal Voucher
Then Add Debit credit record 
Then save the Journal Voucher record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon

@KUBS_GL2_UAT_001_003 @MultiAuth @GL2

Scenario: User should have permission to do the entity level transaction
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon


@KUBS_GL2_UAT_003_002 @MultiAuth @GL2

Scenario: System should generate a unique journal voucher number and accounting entries
 					should be passed as one Debit GL and multiple credit GL amount accordingly
 					
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon
Then Click on Journal Voucher AddButton
Then Fill the Mandatory fields of Journal Voucher
Then Add one Debit multiple credit record 
Then save the Journal Voucher record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon

@KUBS_GL2_UAT_003_003 @MultiAuth @GL2

Scenario: System should display the accounting entries for the vourcher generated.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate Journal vourcher number 

@KUBS_GL2_UAT_003_004 @MultiAuth @GL2

Scenario: Create a Reverse Journal Voucher to undo the already generated journal Voucher

Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher Reversal EyeIcon
Then Click on Journal Voucher Reversal Pencil Icon
Then save the Journal Voucher record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher Reversal EyeIcon

@KUBS_GL2_UAT_003_005 @MultiAuth @GL2

Scenario: System should display the accounting entries for the   vourcher generated.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate Journal vourcher Reversal number


@KUBS_GL2_UAT_004_001 @Report @GL2
  Scenario: Check report for GL monthly balances
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of GL monthly balances report
    And fill the required field of GL monthly balances report
    Then click on view button to view the report for monthly period
    
 @KUBS_GL2_UAT_005_001 @Report @GL2
  Scenario: Check GL balance for any period
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of GL Balances report
    And fill the required field of GL Balances report
    Then click on view button to view the report for any period    
    
    
    @KUBS_GL2_UAT_006_001 @Report @GL2
  Scenario: Check the transactions as per reference number feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    When click on eye button of journal voucher
    Then click on the record to get the voucher number
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the reference number field of financial transaction
    Then click on view button to view the report as per reference number
 
  @KUBS_GL2_UAT_006_002 @Report @GL2
  Scenario: Check the transactions as per GL number feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    When click on eye button of journal voucher
    Then click on the record to get the GL number
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the GL number field of financial transaction
    Then click on view button to view the report as per reference number
  
  @KUBS_GL2_UAT_006_003 @Report @GL2
  Scenario: Check the transactions as per dates feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    #When click on eye button of journal voucher
    #Then click on the record to get the transaction date
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the date field of financial transaction
    Then click on view button to view the report as per reference number
    
    @KUBS_GL2_UAT_007_001 @BatchJobConfiguration @GL2
  Scenario: Configure batch job
    Given User should go to the kubs url and login as a maker user
    Then Selet configuration
    And user should navigate to job scheduler menu
    When click on temp grid button of job definition
    Then click on add button to config job
    And fill the required fields for day end activity
    Then click on save button1
    
    
     @KUBS_GL2_UAT_007_002 @StartJobExecution @GL2
  Scenario: StartJob
    Given User should go to the kubs url and login as a maker user
    Then Selet configuration
    And user should navigate to job scheduler menu
    When click on temp grid button of job execution
    And select the date to start job
    Then Click on start job
    
    
    @KUBS_GL2_UAT_008_002 @MultiAuth @GL2
Scenario: The report should display all the details for JV.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate all the details for Journal vourcher 

@KUBS_GL2_UAT_008_003 @MultiAuth @GL2

Scenario: The report should display all the details for JV reversal.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate all the details for JV reversal
@KUBS_GL2_UAT_008_004
Scenario: verify GL balance report should display the correct balance of GL
Given Login as a Azentio Maker
When click the Direction icon
And click the Account Payable Main Module
And click the Manual Payout Eye icon
And click the Add icon in Manual Payout
And Select the entity branch
And Select the Buisness Partner Name
And Select the beneficiary name
And Select the currency type
And click the calender and select the valid date
And Select bank in manual payout
And Select the bank Account Number
And get the Available  balance and store
And click the notes option
And click the financial Report
And click the Gl balance report edit icon
And select the branch 
And select the Gl code
And Select the Gl from date
#And Select the Gl To date
And select the currency type in gl balance report
And click the View button
Then verify that available balance should equal to closing net balance in Gl balance Report


@KUBS_GL2_UAT_008_005 @MultiAuth @GL2

Scenario: Check report for GL monthly balances.
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on GL monthly balances 
Then fill the input fields of GL monthly balances
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report


@KUBS_GL2_UAT_008_006 @MultiAuth @GL2

Scenario: Check report for Financial Transaction 
					The report should display all the details for transaction.
					
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Financial Transaction Report
Then fill the input fields of Financial Transaction
Then Select Transaction from date Financial Transaction Report
Then select Transaction to date Financial Transaction Report
And click view button of report
Then verify the approved invoicebill number is available in report

@KUBS_GL2_UAT_008_007 @Report @GL2
  Scenario: Check the trial balance
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report
    Then click on view button to view the report of Trial balance
    
  @KUBS_GL2_UAT_008_008 @Report @GL2
  Scenario: Check the trial balance summary
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report summarized
    And fill the required field of Trial Balance report summarized
    Then click on view button to view the report of Trial balance summary
    
  @KUBS_GL2_UAT_008_009 @Report @GL2
  Scenario: Check the trial balance based on the leaf GL
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu 
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search coa code using coa name
    And get the coa code
    
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report based on leaf GL
    Then click on view button to view the report of Trial balance
    And check the trial balance based on the leaf gl is available
    
  @KUBS_GL2_UAT_008_010 @Report @GL2
  Scenario: Check the trial balance based on the given from date to till date 
  						(From date should be less than or equal to current business date)
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report based on given date
    Then click on view button to view the report of Trial balance

@KUBS_GL2_UAT_008_011 @MultiAuth @GL2

Scenario: System should display the balancesheet report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on balancesheet report
Then fill the input fields of balancesheet report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in the report


@KUBS_GL2_UAT_008_012 @MultiAuth @GL2

Scenario: System should display the Cashflow statement report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Cashflow statement report
Then fill the input fields of Cashflow statement report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report

@KUBS_GL2_UAT_008_013 @MultiAuth @GL2

Scenario: System should display the Income statement report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Income statement report
Then fill the input fields of Income statement report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report

