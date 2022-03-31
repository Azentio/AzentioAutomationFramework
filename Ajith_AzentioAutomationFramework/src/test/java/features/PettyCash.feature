Feature: Testing the Petty Cash Module
@KUBS_PC_UAT_002
Scenario: Create a fund request for Petty Cash
Given Login as a Azentio Maker
When click the Direction icon
And  click the Petty Cash Module
And click Fund request Eye icon In Petty cash Modle
And click add icon
And Enter the request amount
And click on save button
And Click on notification icon
And select the first record
And click on submit button
And enter remark in alert tab 
And click on submit
Given Navigate to Url and login as a reviewer
Then Click on Notification button
And Find the code which submitted from maker
Then Click on action button
And Approve the record
Given Login as a Azentio Maker
When click the Direction icon
And  click the Petty Cash Module
And click Fund request Eye icon In Petty cash Modle
Then Verify New Req should be created in the Fund Req list view with Unique Ref number
