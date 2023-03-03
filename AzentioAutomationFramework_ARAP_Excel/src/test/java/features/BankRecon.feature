Feature: testing the fuctionalities of bank reconciliation module

@KUBS_TAX_UAT_005_001TC_001
Scenario: Format of Bank Reconciliation statement is correct as per FSD
Given User should go to the kubs url and login as a maker user
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user update the data set ID for Bank Recon1
And user select bank name in bank recon Module
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date
And user click bank  recon to date and select the date
And user click choose file and upload the bank statement
And user click save button in bank recon
And user click process button in bank recon
And user click matched data tab
And user click the bank statement in bank recon
Then user verify Format of Bank Recon statement must be as per FSD

@KUBS_TAX_UAT_005_001TC_002
Scenario: Check post re-processing bank statement, there is no impact on manually matched entries.
Given User should go to the kubs url and login as a maker user
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user update the data set ID for Bank Recon2
And user select bank name in bank recon Module
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date
And user click bank  recon to date and select the date
And user click choose file and upload the bank statement
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
Then user verify Receipt recorded in Book but missing in Bank Statement for text file

@KUBS_TAX_UAT_005_001TC_003
Scenario: Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Books
Given User should go to the kubs url and login as a maker user
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user update the data set ID for Bank Recon3
And user select bank name in bank recon Module
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date
And user click bank  recon to date and select the date
And user click choose file and upload the bank statement
And user click save button in bank recon
And user click process button in bank recon
And user click the bank statement in bank recon
#And user click the unmatched data in bank recon process
And user click the bank reconciliation process
And user click the bank statement in bank recon
Then user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books