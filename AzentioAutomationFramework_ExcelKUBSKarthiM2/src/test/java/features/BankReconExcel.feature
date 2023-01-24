Feature: Check the functionality of the Bank Reconciliation
@KUBS_TAX_UAT_006_001_TC_001
Scenario: Check submitting Bank recon is not allowed if there is any unmatched records from Bank Side
And User get the test data for bankrecon testcase006001001
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number for Barclays Bank
And Give the recon period from date for Barclays Bank
And Give the recon period to date for Barclays Bank
Then Upload our Barclays Bank file 
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab 
And unmatch that record and save that record
Then verify validation message is comming or not for Bank Recon
@KUBS_TAX_UAT_006_001_TC_002
Scenario: Check submitting Bank recon is allowed if there is any unmatched records from Bank Side
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the Indian bank name and Indian account number 
And Give the Bank recon period from date 
And Give the Bank recon period to date 
Then Upload our file for Indian
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon

@KUBS_TAX_UAT_006_001_TC_003
Scenario: Verify user is not allowed to submit Bank Recon with any suggested matched records
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account numbers
And Give Bank recon period from date 
And Give Bank recon period to date 
Then Upload our Bank file 
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon

@KUBS_TAX_UAT_006_001_TC_004
Scenario: Verify user is not allowed to submit Bank Recon with any Transposition matched records
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account numbers
And Give the recons period from date 
And Give the recons period to date 
Then Upload the Bank file 
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon

@KUBS_TAX_UAT_006_001_TC_005
Scenario: Verify user is not allowed to submit Bank recon if any entry is not verified.
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account numbers
And Give Bank recon period from date 
And Give Bank recon period to date 
Then Upload our Bank file
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And Click the Bank recon Details
Then Try to submit the Record
And Verify the Message we get

@KUBS_TAX_UAT_006_001_TC_006
Scenario: Submit a bank recon from Maker Queue and check the record is available in checker queue for approval
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account numbers
And Give the recons period from date 
And Give the recons period to date 
Then Upload our Bank files
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
And Click the Bank recon Statement
And Click the Bank recon Details
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
And Click the Bank recon Statement
And Click the Bank recon Details
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
And Click the Bank recon Statement
And Click the Bank recon Details
Then Approve the Record in checker stage
And Give the Remark and Submit it


@KUBS_TAX_UAT_006_001_TC_007
Scenario: Verify checker is not allowed to do any modification on any tab
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number for Barclays Bank
And Give recon period from date 
And Give recon period to date 
Then Upload our Bank files 
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
And Click the Bank recon Statement
And Click the Bank recon Details
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
And Click the Bank recon Statement
And Click the Bank recon Details
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
And Click the Bank recon Statement
And click the Bank Recon Process
And Click unmatched Tab
And Click the Record and try to save and Verify

###########################################################################################################################################################################################

#testing the fuctionalities of bank reconciliation module
@KUBS_TAX_UAT_008_001TC_002
Scenario: Verify unmatched transactions are displayed of current month plus previous month if any not matched in current month
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date
And user click bank  recon to date and select the date
And user click choose file and upload the bank statement
And user click save button in bank recon
And user click process button in bank recon
And user unmatch the matched record in bank recon text format
And user click the unmatched data in bank recon process
Then Displayed transactions must of current month plus unmatched records from previous month if any matched in current month where view basis is Bank to Book


@KUBS_TAX_UAT_008_002TC_001
Scenario: Verify unmatched transactions are displayed of current month plus previous month if any not matched in current month
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date
And user click bank  recon to date and select the date
And user click choose file and upload the bank statement
And user click save button in bank recon
And user click process button in bank recon
And user unmatch the matched record in bank recon text format
And user click the unmatched data in bank recon process
Then user verify that unmatched transactions are displayed of current month plus previous month if any not matched in current month


