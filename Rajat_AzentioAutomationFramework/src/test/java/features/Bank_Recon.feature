Feature: Check the functionality of the Bank Reconciliation
@KUBS_TAX_UAT_006_001_TC_001
Scenario: Check submitting Bank recon is not allowed if there is any unmatched records from Bank Side
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

@KUBS_TAX_UAT_006_001_TC_008
Scenario: Checker approves Bank Reconciliation
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number for Barclays Bank 
And Give recon period from date 
And Give recon period to date 
Then Upload Barclays Bank file 
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
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
Then Click on Table Row First Eye Icon

@KUBS_TAX_UAT_009_001_TC_001
Scenario: Create Bank Recon details by uploading bank statement in CSV file
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number for Barclays Bank
And Give the recon period from date for Barclays Bank
And Give the recon period to date for Barclays Bank
Then Upload Barclays Bank file 
And check the file validated  successfully or not
And save bank recon record
And Process that Bank file