Feature: AR/AP Module
@KUBS_AR_AP_UAT_004_007_TC_06  @AR/AP
Scenario: Verify Accounts Payable Report post payment settlement approval.
Given User should go to the kubs url and login as a maker user
Then select data set ID for accounts payable report post payment settlement approval
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
#Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon in ARAP
And Get Business Partner name from the payment settlement record
When Store the Advance Number
Then Third Segment report Icon
#And Click main module Reports
Then Click sub module Accounts Payable Report
And fill Getted Business Partner Name
Then Give Current business Date for approving bills by employee
And Give Accounts Payable Status for approving bills by employee
Then Click on View buttons
And Verify the Accounts Payable Report post payment settlement approval