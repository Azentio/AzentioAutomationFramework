Feature: testing the General Ledger  Module
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
And Select the Gl To date
And select the currency type in gl balance report
And click the View button
And get the closing net balance from the report
Then verify that available balance should equal to closing net balance