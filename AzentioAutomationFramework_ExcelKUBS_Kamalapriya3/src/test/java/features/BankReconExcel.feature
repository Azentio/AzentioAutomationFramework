Feature: To check the functionalities of bank recon
@KUBS_TAX_UAT_003_001TC_001
Scenario: Select a matched record and click on unmatch button
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv files
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv files
And user click bank recon to date and select the date for csv files
And user click choose file and upload the bank statements for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
And user match the records in unmached tabs
And user click matched data tab
And user unmatch the matched records in matched tabs
And user click the unmatched data in bank recon process
Then user verify System must unmatch a matched record and now the both the records to be displayed on Unmatched Tab under Unmatched transactions from Bank statement and Books
And user click matched data tab
Then user verify Same records should not be displayed in Matched Tabs

#TextFile
@KUBS_TAX_UAT_003_002_TC_01
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Books to Bank.
Given Maker Navigate to UAT URL login
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text files
And give the recon period from date for text files
And give the recon period to date for text files
Then upload the text files for process
And save the bank recon record
And Process that file
And choose book to bank as reconcilation basis
And goto unmatched Tab
And try to match the unmatched recipt and verify shstem should through the validation message

@KUBS_TAX_UAT_003_002_TC_02
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Bank To Book
Given Maker Navigate to UAT URL login
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text files
And give the recon period from date for text file for bank to book basis
And give the recon period to date for text file for bank to book basis
Then upload the text file in the basis of bank to book for process
And save the bank recon record
And Process that file
And choose bank to book as reconcilation basis
And goto unmatched Tab
And try to match the unmatched recipt and verify shstem should through the validation message

@KUBS_TAX_UAT_003_002_TC_03
Scenario: Select a suggested match record from Bank and one record from Book and click on Match button where View basis is Books to Bank.
Given Maker Navigate to UAT URL login
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text file
And give the recon period from date for text file for book to bank basis
And give the recon period to date for text file for book to bank basis
Then upload the text file in the basis of book to bank for process
And save the bank recon record
And Process that file
And choose book to bank as reconcilation basis
And goto unmatched Tab
And match the book record into bank record
Then click on match tab
And goto match tab and verify record was displayed under the match tab

@KUBS_TAX_UAT_003_002_TC_04
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Bank To Book
Given Maker Navigate to UAT URL login
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text file
And give the recon period from date for text file for banktobook basis
And give the recon period to date for text file for banktobook basis
Then upload the text file in the basis of banktobook for process
And save the bank recon record
And Process that file
And choose bank to book as reconcilation basis
And goto unmatched Tab
And match the book record into bank record and verify the transaction as yes
Then click on match tab
And goto match tab and verify record was displayed under the match tab


@KUBS_TAX_UAT_003_002_TC_05
Scenario: Verify sum of selected record from one side matches with sum of records from other side else system to throw validation while matching such records
Given Maker Navigate to UAT URL login
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text file
And give the recon period from date for textfile
And give the recon period to date for textfile
Then upload the textfile
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record and verify the transaction as yes
#Then click on match tab
Then system should through the validation for match those record