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
And store the reference number of bank recon format in excel database
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1 
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
And store the reference number of bank recon format in excel database
And select the bank recon record
And click on submit in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And store the reviewer id of bank recon configuration in excel database
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_002_PQ_2
Scenario: To verify reviewer user can able to approve the bank recon record
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
Given navigate to kubs url and log in with reviewer to approve the bank recon process record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_006_03
Scenario: Verify checker is not allowed to do any modification on any tab
Given Navigate to KUBS url and login with checker for approve bank recon process record
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

@KUBS_TAX_UAT_006_001_TC_003
Scenario: Verify user is not allowed to submit Bank Recon with any suggested matched records
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for correct unmatced,partial and transposition records from bank statement
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And Click the Bank recon Details
Then Try to submit the Record
And Verify the Message we get

@KUBS_TAX_UAT_006_001_TC_004
Scenario: Verify user is not allowed to submit Bank Recon with any Transposition matched records
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for correct unmatced,partial and transposition records from bank statement
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And Click the Bank recon Details
Then Try to submit the Record
And Verify the Message we get

@KUBS_TAX_UAT_006_001_TC_005_01
Scenario: Submit a bank recon from Maker Queue and check the record is available in checker queue for approval
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Submit a bank recon from Maker Queue and check the record is available in checker queue for approval
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And match that record and try to save that record 
And Click the Bank recon Details
Then Goto The Notification Icon
And store the reference number of bank recon process record in excel database
And select the bank recon record to submit
And click on submit in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And store the reviewer id of bank recon process record in excel database to check the record is available in checker queue for approval
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_005_02
Scenario: Submit a bank recon from Maker Queue and check the record is available in checker queue for approval
Given navigate to kubs url and log in with reviewer to approve the bank recon process record and check record available for checker approval
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_005_03
Scenario: Submit a bank recon from Maker Queue and check the record is available in checker queue for approval
Given Navigate to KUBS url and login with checker for approve the bank recon process record and check record available for checker approval
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And Verify the submitted record from maker and check the record id available in cheker queue for approval
#And Click the First Action Icon
#And Click the Bank recon Statement
#And Click the Bank recon Details
#Then Approve the Record in checker stage
#And Give the Remark and Submit it

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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_007_02
Scenario: Reviewer approves Bank Reconciliation
Given navigate to kubs url and log in with reviewer to approve the bank recon for checker approval
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_TAX_UAT_006_001_TC_007_03
Scenario: Checker approve Bank Reconciliation
Given Navigate to KUBS url and login with checker to verify checker able to submit bank recon record
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
@KUBS_TAX_UAT_07_001TC_001_PRQ_1
Scenario: Create Bank Recon details by uploading bank statement in CSV file
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
Then Click on Direction Left
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id prerequisites for Processing Bank recon for same period Bank and Account Number
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
#And enter the bank name and account number for Barclays Bank
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And click on notification icon in maker stage
And click on search in maker notification section 
And search for bank recon record in notification
And store the reference number of bank recon process record in excel database
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon
Then verify system should through the validation message for uploded file
@KUBS_TAX_UAT_07_001TC_001_PRQ_2
Scenario: Cancel Bank recon processed record
Given navigate to given url and login with maker credentials
Then Click on the Finance
And User update test data set id prerequisites for Processing Bank recon for same period Bank and Account Number
And click on notification icon in maker stage
And select the bank recon record based on reference id
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
Then logout from maker
@KUBS_TAX_UAT_008_001TC_002
Scenario: Verify unmatched transactions are displayed of current month plus previous month if any not matched in current month
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Verify unmatched transactions are displayed of current month plus previous month
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
#And enter the bank name and account number for Barclays Bank
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
#And user unmatch the matched record in bank recon text format
And user click the unmatched data in bank recon process
Then Displayed transactions must of current month plus unmatched records from previous month if any matched in current month where view basis is Bank to Book
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_008_002TC_001
Scenario: Verify unmatched transactions are displayed of current month plus previous month if any not matched in current month
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Verify unmatched transactions are displayed of current month plus previous month 
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
#And enter the bank name and account number for Barclays Bank
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
#And user unmatch the matched record in bank recon text format
And user click the unmatched data in bank recon process
Then user verify that unmatched transactions are displayed of current month plus previous month if any not matched in current month
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
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

#need to change reconcilation date
@KUBS_TAX_UAT_0010_001TC_001
Scenario: Click on Process button on Bank Recon Process screen post creating additional entries
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And user click the unmatched data in bank recon process
And user match the records in unmatched tab
And user click matched data tab
Then user verify that Book entry will be matched with Bank entry and will be displayed in Matched Tab
Then user verify that Unmatched entry from Bank Side will not be displayed
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_0010_001TC_002
Scenario: user verify Check post re-processing bank statement, there is no impact on manually matched entries.
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And user click the unmatched data in bank recon process
And user match the records in unmatched tab
And user click matched data tab
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click matched data tab
Then user verify that Post reprocessing bank statement there must be no impact on manually matched entries
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_0010_001TC_003
Scenario: Check post re-processing bank statement, there is no impact on manually unmatched entries.
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
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon 
And check the file validated successfully or not
And save bank recon record
And Process that Bank file
And user click the unmatched data in bank recon process
And user match the records in unmatched tab
And user click matched data tab
And user unmatch the matched records in matched tab
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click the unmatched data in bank recon process
Then user verify Check post reprocessing bank statement there is no impact on manually unmatched entries
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled

@KUBS_TAX_UAT_011_001TC_001
Scenario: Check format of Bank Reconciliation statement is correct as per FSD 
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Check format of Bank Reconciliation statement is correct as per FSD 
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
#And user click matched data tab
And user click the bank statement in bank recon
Then user verify Format of Bank Recon statement must be as per FSD
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled
@KUBS_TAX_UAT_011_001TC_002
Scenario: Check system displays correct sum and records in below head as per logics given in FSD.
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
#And User update test data set id for Check system displays correct sum and records in below head as per logics given in FSD 
And User update test data set id for Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Book
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And user click the bank statement in bank recon
Then user verify Receipt recorded in Book but missing in Bank Statement
Then user verify Receipts recorded in bank statement but missing in Book
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled

@KUBS_TAX_UAT_011_001TC_003
Scenario: Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Books
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on second Segment button
And click Bank Recon module
And click view button near by Bank Reconcilation sub module
And click on Add Icon
And User update test data set id for Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Book
And Enter the Bank Name 
And Enter Bank Account Number for bank recon
And Give the Bank recon period from date1
And Give the Bank recon period to date1 
Then Upload our file for bank recon
And check the file validated successfully or not
And save the bank recon record
And User Verify notification message get while save bank recon record
And Process that Bank file
And Click unmatched Tab
And match that record and try to save that record 
And user click the bank statement in bank recon
#And user click the unmatched data in bank recon process
And user click the bank reconciliation process
And user click the bank statement in bank recon
Then user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books
And User click on bank reconciliation details tab
And click on cancel in bank recon configuration
And enter the alert remark in bank recon configuration 
And click on alert submit in bank recon configuration
And user verify the bank record got cancelled