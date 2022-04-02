Feature: testing the General Ledger Module
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
Then verify that available balance should equal to closing net balance in Gl balance Report
@KUBS_GL_UAT_007_001
Scenario: Check the accounting mapping done for the accounting Scheme
Given Login as a Azentio Maker
When user click the Accounting setup
And click the accounting scheme definition eye icon
And click the search icon
And search the active status in list view
And get the accounting scheme name in first list view
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
Then verify the mapping of accounintg entries to be triggered
@KUBS_GL_UAT_007_002
Scenario: check Accounting schemes should mapped to the same Transaction event 
Given Login as a Azentio Maker
When user click the Accounting setup
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
And select the event
And click the Scheme
And click Add button
And click next Scheme
And click Add button
And click save button in event mapping
And Click on notification icon
And select the first record
And select the Status for EventMapping
And click on submit buttons
And enter remark in alert tab 
And click on submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker
Given Login as a Azentio Maker
When user click the Accounting setup
And click the Accounting Scheme Event Mapping Eye icon
And click the search icon
And search Event name based on which we created
And clck the first edit icon in list view
Then verify System should allow to map to the transaction event more than one Accounting Scheme
@KUBS_GL_UAT_006_001
Scenario: Create a accounting Schemes for different products
Given Login as a Azentio Maker
When user click the Accounting setup
And click the accounting scheme definition eye icon
And click add icon in Gl
And select accounting book name
And enter the Accounting Scheme Code
And enter the Accounting Scheme name
And select expand indicator
And select Transaction Type
And click save buttons
And Click on notification icon
And select the first records
And click add icon in accounting scheme details
And select GL resource
And select CrDr flag
And select parameter String
And select expand indicator in accounting Scheme details
And select parameter
And click add icon in table
And click save button in accounting scheme
And click edit icon in accounting schemes
And select the status in accounting Scheme details
And click save button in accounting scheme
And click add icon in accounting scheme details
And select GL resource
And select Cr flag
And select parameter String
And select expand indicator in accounting Scheme details
And select parameter
And click add icon in table
And click save button in accounting scheme
And click edit icon in accounting schemes
And select the status in accounting Scheme details
And click save button in accounting scheme
And Click on notification icon
And select the first record
And click on submit buttons
And enter remark in alert tab 
And click on submits
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker
Given Login as a Azentio Maker
When user click the Accounting setup
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
Then verify System should triggered the applied rule for the accounting scheme










