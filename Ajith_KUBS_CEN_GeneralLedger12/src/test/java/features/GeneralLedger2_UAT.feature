Feature: To verify user can able to do transaction in gl2 module
@KUBS_GL2_UAT_001_001_01 
Scenario: Create a ledger at entity level
Given Navigate to Azentio Kubs
#Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
And User Update the test data set id to Create a Ledger at entity Level
And User select the cash GL 
And User Select the Cheque GL
And User Select the Inter branch GL
And User Select the Position GL
And User Select the PL Exchange Gain GL
And User Select the PL Exchange Loss GL
And User Select the Revaluation Profit GL
And User Select the Revaluation Loss GL
And User Select the Revaluation Notional Profit GL
And User Select the Revaluation Notional Loss GL
Then save the Legal Entity GL Configuration record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And User Update the data set id to approve Ledger at entity level in Reviewer or Checker
And Store the Referance Id and Open the Record for GL2 records
Then Click submit button and Enter Remark submit it for GL2 Records
@KUBS_GL2_UAT_001_001_02
Scenario: Approve the Created ledger at entity level in Reviewer
And User Update the data set id to approve Ledger at entity level in Reviewer or Checker
Given Navigate as a Reviewer for GL2
Then click on Notify icon
And Click First record Action icon for GL2
Then Approve the record in Reviewer
And Give Remark and Submit for GL2
@KUBS_GL2_UAT_001_001_03
Scenario: Approve the Created ledger at entity level in Checker
And User Update the data set id to approve Ledger at entity level in Reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL2
Then Goto the Checker notification Icon
And Click First record Action icon for GL2
Then Approve the Record in checker stage
And Give Remark and Submit for GL2
@KUBS_GL2_UAT_001_001_04
Scenario: Verify the Created ledger in Maker list view 
Given Navigate to Azentio Kubs
#Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
@KUBS_GL2_UAT_001_002_01 
Scenario: Mapping the GL in side the entity level
Given Maker Navigate to UAT URL login
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
And User select the cash GL 
And User Select the Cheque GL
And User Select the Inter branch GL
And User Select the Position GL
And User Select the PL Exchange Gain GL
And User Select the PL Exchange Loss GL
And User Select the Revaluation Profit GL
And User Select the Revaluation Loss GL
And User Select the Revaluation Notional Profit GL
And User Select the Revaluation Notional Loss GL
Then save the Legal Entity GL Configuration record
And User Close the Workflow iniatiated Pop up in GL
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_GL2_UAT_001_002_02
Scenario: Approve the Mapped the GL in side the entity level in Reviewer 
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
@KUBS_GL2_UAT_001_002_03
Scenario: Approve the Mapped the GL in side the entity level in Checker
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
@KUBS_GL2_UAT_001_002_04
Scenario: Verify the Mapped the GL in side the entity level in Checker
And login with Maker ID
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
@KUBS_GL2_UAT_003_001 @MultiAuth @GL2
Scenario: Create a Journal Voucher to adjust the amount from one GL to another GL
Given Navigate to Azentio Kubs
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher EyeIcon
Then Click on Journal Voucher AddButton
And User Select the branch code
And User Select the Currency
And User Select the Journal Voucher
And User Select the profit center
And User Select cost center or Department
And User enter the remark for Journal Voucher
Then Add Debit credit record 
Then save the Journal Voucher record
And User Close the Workflow iniatiated Pop up in GL
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
And User select the cash GL 
And User Select the Cheque GL
And User Select the Inter branch GL
And User Select the Position GL
And User Select the PL Exchange Gain GL
And User Select the PL Exchange Loss GL
And User Select the Revaluation Profit GL
And User Select the Revaluation Loss GL
And User Select the Revaluation Notional Profit GL
And User Select the Revaluation Notional Loss GL
Then save the Legal Entity GL Configuration record
And User Close the Workflow iniatiated Pop up in GL
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
And User Select the branch code
And User Select the Currency
And User Select the Journal Voucher
And User Select the profit center
And User Select cost center or Department
Then Add one Debit multiple credit record 
Then save the Journal Voucher record
And User Close the Workflow iniatiated Pop up in GL
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
#Then select Transaction from date Journal vourcher
#Then select Transaction to date Journal vourcher
And User Close the Workflow iniatiated Pop up in GL
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
And User Close the Workflow iniatiated Pop up in GL
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
Then Click on Direction icon
Then Click on General Ledger Transaction Field
Then Click on Journal Voucher Reversal EyeIcon

@KUBS_GL2_UAT_003_005 @MultiAuth @GL2

Scenario: System should display the accounting entries for the vourcher generated.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
#Then select Transaction from date Journal vourcher
#Then select Transaction to date Journal vourcher
And Select the Transaction Ref no for Reversal journal Voucher
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
@KUBS_GL2_UAT_008_005
@GlMonthlyBalance
Scenario: Check report for GL monthly balances.
Given Maker Navigate to UAT URL login
And click on tool icon
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
And click on tool icon
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
    And click on view button in trial balance report 
  #  Then click on view button to view the report of Trial balance
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
And click on tool icon
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
And click on tool icon
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
And click on tool icon
Then click on report segment button
Then click on Financial reporting button
Then click on Income statement report
Then fill the input fields of Income statement report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report

