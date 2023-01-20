Feature: AR/AP Module
@KUBS_AR_AP_UAT_010_002_TC_01_01 @AR/AP 
Scenario: Create cheque and submit from maker
Given User should go to the kubs url and login as a maker user
And Update test data for cheque creation and submit from maker
And goto accouts Receivable module
And goto accouts receipt module
And click on Add Icon
And fill the all receipt mendatory details 
And save the receipt record
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
@KUBS_AR_AP_UAT_010_002_TC_01_02
Scenario: Verify that created cheque is approved by reviewer
And Update test data for cheque creation and approve from reviewer
And User should go to the kubs url and login as a reviewer user
Then click on the Notification select the Cheque record and Approve
@KUBS_AR_AP_UAT_010_002_TC_01_03
Scenario: Verify that created cheque is approved by checker
And Update test data for cheque creation and approve from checker
Given User should go to the kubs url and login as a checker user
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
@KUBS_AR_AP_UAT_010_002_TC_01_04
Scenario: Verify that approved cheque is present in maker view list
And Update test data for approved cheque present in view list
Given User should go to the kubs url and login as a maker user
And goto accouts Receivable module
And goto cheque deposite module
And click on Add Icon
And enter the bank account number
And give date of bill deposited date 
And click on deposite bill generation
Then check our bill is appeared in the list view