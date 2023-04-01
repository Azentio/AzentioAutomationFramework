Feature: Check the functionality of the Bank Reconciliation
@KUBS_TAX_UAT_006_001_TC_001_PQ_1
Scenario: Check submitting Bank recon is allowed if there is any unmatched records from Bank Side
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
And Click On Search Icon
And User upadte test data id for unmatched entry 
And User Search Bank name in approved view
And User click edit icon of searched bank record
And User select Allow unadjust entry from bank statement
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section 
And search for bank recon record in notification
And store the reference number of budget bank recon in excel database
And select the bank recon record
And click on submit in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And store the reviewer id of bank recon configuration in excel database
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_001_PQ_2
Scenario: To verify reviewer user can able to approve the bank recon definition record
Given navigate to kubs url and log in with reviewer to approve the bank recon config record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_001_PQ_3
Scenario: To verify checker user can able to approve the bank recon definition record
Given Navigate to KUBS url and login with checker for approve bank recon config record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_001
Scenario: Check submitting Bank recon is allowed if there is any unmatched records from Bank Side
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data for sbmitting Bank recon is allowed if there is any unmatched records from Bank Side
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date 
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
@KUBS_TAX_UAT_006_001_TC_002_PQ_1
Scenario: Check submitting Bank recon is allowed if there is any unmatched records from Bank Side
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction Left
Then Click on Bank Recon
Then click on Bank Recon format eye button
And Click On Search Icon
And User upadte test data id for unmatched entry 
And User Search Bank name in approved view
And User click edit icon of searched bank record
And User select Allow unadjust entry from bank statement
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section 
And search for bank recon record in notification
And store the reference number of budget bank recon in excel database
And select the bank recon record
And click on submit in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And store the reviewer id of bank recon configuration in excel database
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_002_PQ_2
Scenario: To verify reviewer user can able to approve the bank recon definition record
Given navigate to kubs url and log in with reviewer to approve the bank recon config record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_002_PQ_3
Scenario: To verify checker user can able to approve the bank recon definition record
Given Navigate to KUBS url and login with checker for approve bank recon config record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_002
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
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
@KUBS_TAX_UAT_006_001_TC_006_01
Scenario: Verify checker is not allowed to do any modification on any tab
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Verify checker is not allowed to do any modification on any tab
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
And Click the Bank recon Statement
And Click the Bank recon Details
Then Click submit button and Enter Remark submit it 
@KUBS_TAX_UAT_006_001_TC_006_02
Scenario: Reviewer approve bank recon record from maker
Given navigate to kubs url and log in with reviewer to approve the bank recon config record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_006_03
Scenario: Verify checker is not allowed to do any modification on any tab
Given Navigate to KUBS url and login with checker for approve bank recon config record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And Click the Bank recon Statement
And click the Bank Recon Process
And Click unmatched Tab
And Click the Record and try to save and Verify

@KUBS_TAX_UAT_006_001_TC_007_01
Scenario: Checker approves Bank Reconciliation
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Checker approves Bank Reconciliation
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And unmatch that record and save that record 
Then verify validation message is comming or not for Bank Recon
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
And Click the Bank recon Statement
And Click the Bank recon Details
Then Click submit button and Enter Remark submit it 
@KUBS_TAX_UAT_006_001_TC_007_02
Scenario: Reviewer approves Bank Reconciliation
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
And Click the Bank recon Statement
And Click the Bank recon Details
Then Approve the record in Reviewer
And Give Remark and Submit
@KUBS_TAX_UAT_006_001_TC_007_03
Scenario: Checker approve Bank Reconciliation
Given Navigate to KUBS url and login with checker for approve bank recon config record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_007_04
Scenario: Approved Bank Recon must be displayed in approved queue now. 
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click Bank Recon module
Then Click on Table Row First Eye Icon
@KUBS_TAX_UAT_07_001TC_001
Scenario: Processing Bank recon for same period, Bank and Account Number
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data id to Processing Bank recon for same period Bank and Account Number
And Enter the Bank Name
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then verify system throw the validation message or not
@KUBS_TAX_UAT_07_002TC_001
Scenario: Processing bank recon with already used file.
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data id to Processing bank recon with already used file
And Enter the Bank Name
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
Then verify system should through the validation message for uploded file 
@KUBS_TAX_UAT_009_001_TC_001
Scenario: Create Bank Recon details by uploading bank statement in CSV file
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for uploading bank statement in CSV file
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
#And enter the bank name and account number for Barclays Bank
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled

@KUBS_TAX_UAT_009_001_TC_002
Scenario: Check system throws validation any data on Bank Reconciliation Details screen does not match with uploaded file.
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
Then Click on Direction Left
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for getting validation messages when uploaded file not matched with book records
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date  
Then Upload our file for bank recon  
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And goto unmatched Tab
And match that record and try to save that record 
Then verify validation message is comming or not
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_009_001_TC_003
Scenario: Creating Bank details by uploading bank statement in CSV format.Click on Process button
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Click on Bank Process button
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon  
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And User click on bank reconciliation details tab
And Verify Bank Reconciliation process tab is enabled
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
#And goto unmatched Tab
#And match that receipt reference number in unmatched tab 
#And goto matched tab and check the receipt reference number comes under matched tab
@KUBS_TAX_UAT_009_003TC_001
Scenario: Verify system gives correct unmatced,partial and transposition records from bank statement
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for correct unmatced,partial and transposition records from bank statement
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
#And user click save button in bank recon
#And user click process button in bank recon
And user click the unmatched data in bank recon process
Then verify unmatched,partially matched and transposition matched records in bank Statment after processing
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_009_003TC_002
Scenario: Verify system gives correct unmatced,partial and transposition records from book records 
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for correct unmatced,partial and transposition records from bank statement
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And user click the unmatched data in bank recon process
Then verify unmatched,partially matched and transposition matched records in bank records after processing
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_009_003TC_003  
Scenario: Verify system gives correct unmatced,partial and transpositio records from book records 
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for correct unmatced,partial and transposition records from bank statement
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date
And Give the Bank recon period to date 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And user click the unmatched data in bank recon process
Then Verify system gives correct unmatched data basis the matching rule defined
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled