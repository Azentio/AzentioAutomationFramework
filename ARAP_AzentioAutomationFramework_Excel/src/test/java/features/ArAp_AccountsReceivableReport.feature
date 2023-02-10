Feature: AR/AP Module
@KUBS_AR_AP_UAT_003_006_TC_03  @AR/AP
Scenario: Verify Accounts Receivable Report post Debit Note is cancelled
Given User should go to the kubs url and login as a maker user
Then select data set ID for accounts receivable report post debit note is cancelled
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Click main Reports module
Then Click on sub module Accounts Receivable Report
And Give Getted Business Partner Name in field
Then Give Current business Date in Account receivable report
And Give Accounts Payable Status
Then Click on View buttons
And Verify Accounts Receivable Report post Debit Note is cancelled

@KUBS_AR/AP_UAT_003_007TC_03  @AR/AP
   Scenario: Verify Accounts Receivable Report post credit note is cancelled
   Given User should go to the kubs url and login as a maker user
   Then select data set ID for Verify accounts receivable report post credit note is cancelled
   Then Choose the second Tab Segment
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Credit note
   And select the date
   And click the view icon
   Then verify the Credit Note cancelled is available in the report
   
   @KUBS_AR_AP_UAT_004_007_TC_07  @AR/AP
Scenario: Verify Accounts Receivable Report post payment settlement approval.
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify accounts receivalable report post payment settlement
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
Then Give Current business Date for approving bills by employee
And Give Accounts Payable Status
Then Click on View buttons
And Verify the Accounts Receivable Report post payment settlement approval