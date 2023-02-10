Feature: AR/AP Module
@KUBS_AR_AP_UAT_003_006_TC_02  @AR/AP
Scenario: Verify Balance sheet post Debit Note is cancelled
Given User should go to the kubs url and login as a maker user
Then select data set ID for balance sheet post debit note is cancelled
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get the Branch Name in wait
Then Get the Transaction Date
Then Third Segment report Icon
And Click on Financial Reporting module
Then Click on Balance sheet Sub module
#And Give Getted Branch code 
Then Fill branch details for post debit note balance sheet report
Then Give Getted Transaction Date
Then Click on Balance sheet View button
And verify Balance sheet post Bill is approved

 @KUBS_AR/AP_UAT_003_007TC_02  @AR/AP
   Scenario: Verify Balance sheet post Credit Note is cancelled
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify balance sheet post credit note is cancelled
   Then Choose the second Tab Segment
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the financial reporting button
   And click the balance sheet report
  # And select the branch
   Then Fill branch details for balance sheet report
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   
   @KUBS_AR/AP_UAT_004_007_TC_05  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify balance sheet post payment setlement approval
Then Choose the second Tab Segment
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on the View button
Then close the report

@KUBS_AR_AP_UAT_010_001_TC_04  @AR/AP
  Scenario: Verify Balance sheet post approval through online mode
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for Verify Balance sheet post approval through online mode
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Balance sheet report
    And fill the required field of Balance sheet report
    Then click on view button to view the balance sheet report
    Then Verify balance sheet should updated correctly post approval through online mode

@KUBS_AR_AP_UAT_010_002_TC_05  @AR/AP
Scenario: Verify Balance sheet post cheque is cleared
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify Balance sheet post cheque is cleared
   Then click on report icon
   And user should navigate to financial reporting menu
   Then click on temp grid button of Balance sheet report
   Then Fill branch details for Balance sheet report post cheque is cleared
   Then Select balance sheet as on date
   Then click on view button to view the balance sheet report
   Then Verify balance sheet should updated correctly post cheque is cleared
