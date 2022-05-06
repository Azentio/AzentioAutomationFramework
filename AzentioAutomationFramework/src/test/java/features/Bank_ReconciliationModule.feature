Feature: testing the fuctionalities of bank reconciliation module
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
@KUBS_TAX_UAT_005_001TC_002
Scenario: Check post re-processing bank statement, there is no impact on manually matched entries.
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
And user click the unmatched data in bank recon process
Then user verify Receipt recorded in Book but missing in Bank Statement for text file

@KUBS_TAX_UAT_004_001TC_002
Scenario: Check post re-processing bank statement, there is no impact on manually matched entries.
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
And user match record in unmatched tab for text format
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click matched data tab
Then user verify that Check post re processing bank statement there is no impact on manually matched entries 
@KUBS_TAX_UAT_004_001TC_003
Scenario: Check post re-processing bank statement, there is no impact on manually unmatched entries.
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
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click the unmatched data in bank recon process
Then user verify that Check post re processing bank statement there is no impact on manually unmatched entries

@KUBS_TAX_UAT_003_001TC_001
Scenario: Select a matched record and click on unmatch button
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
And user match the records in unmached tab
And user click matched data tab
And user unmatch the matched records in matched tab
And user click the unmatched data in bank recon process
Then user verify System must unmatch a matched record and now the both the records to be displayed on Unmatched Tab under Unmatched transactions from Bank statement and Book
And user click matched data tab
Then user verify Same records should not be displayed in Matched Tab
@KUBS_TAX_UAT_004_001TC_001
Scenario: Click on Process button on Bank Recon Process screen post creating additional entries
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
And user click the unmatched data in bank recon process
And user click matched data tab
And user select bank reconcilation basis bank to book
And user unmatch the matched records in matched tab
And user click the unmatched data in bank recon process
And user match the records in unmached tab fot textt file
And user click matched data tab
Then user verify that Book entry will be matched with Bank entry and will be displayed in Matched Tab for text
Then user verify that Unmatched entry from Bank Side will not be displayed for text
@KUBS_TAX_UAT_005_001TC_001
Scenario: Format of Bank Reconciliation statement is correct as per FSD
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
And user click matched data tab
And user click the bank statement in bank recon
Then user verify Format of Bank Recon statement must be as per FSD
@KUBS_TAX_UAT_005_001TC_003
Scenario: Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Books
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
And user click the bank statement in bank recon
#And user click the unmatched data in bank recon process
And user click the bank reconciliation process
And user click the bank statement in bank recon
Then user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books

@KUBS_TAX_UAT_009_003TC_001
Scenario: Verify system gives correct unmatced,partial and transposition records from bank statement
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
And user click the unmatched data in bank recon process
Then verify unmatched,partially matched and transposition matched records in bank Statment  after processing
@KUBS_TAX_UAT_009_003TC_002
Scenario: Verify system gives correct unmatced,partial and transposition records from book records 
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
And user click the unmatched data in bank recon process
Then verify unmatched,partially matched and transposition matched records in bank records after processing
@KUBS_TAX_UAT_009_003TC_003  
Scenario: Verify system gives correct unmatced,partial and transpositio records from book records 
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
And user click the unmatched data in bank recon process
Then Verify system gives correct unmatched data basis the matching rule defined
@KUBS_TAX_UAT_011_001TC_001
Scenario: Check format of Bank Reconciliation statement is correct as per FSD 
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click matched data tab
And user click the bank statement in bank recon
Then user verify Format of Bank Recon statement must be as per FSD
@KUBS_TAX_UAT_011_001TC_002
Scenario: Check system displays correct sum and records in below head as per logics given in FSD.
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
Then user verify Receipt recorded in Book but missing in Bank Statement
Then user verify Receipts recorded in bank statement but missing in Book

@KUBS_TAX_UAT_011_001TC_003
Scenario: Check Adjusted Balance as per Bank Statement matches with Adjusted Balance as per Books
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the bank statement in bank recon
#And user click the unmatched data in bank recon process
And user click the bank reconciliation process
And user click the bank statement in bank recon
Then user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books
@job
Scenario: Job execution run for two days
Given user log in to Azentio for bank recon
And user click maker option
And user select configuration menu
And user click job scheduler 
And user click temp view in job execution
And user click start job
And user click job execution refresh option
And user log in to Azentio
#need to change reconcilation date
@KUBS_TAX_UAT_0010_001TC_001
Scenario: Click on Process button on Bank Recon Process screen post creating additional entries
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
And user match the records in unmached tab
And user click matched data tab
Then user verify that Book entry will be matched with Bank entry and will be displayed in Matched Tab
Then user verify that Unmatched entry from Bank Side will not be displayed
@KUBS_TAX_UAT_0010_001TC_002
Scenario: user verify Check post re-processing bank statement, there is no impact on manually matched entries.
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
And user match the records in unmached tab
And user click matched data tab
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click matched data tab
Then user verify that Post reprocessing bank statement there must be no impact on manually matched entries
@KUBS_TAX_UAT_0010_001TC_003
Scenario: Check post re-processing bank statement, there is no impact on manually unmatched entries.
Given user log in to Azentio for bank recon
And user click bank recon module
And user click eye icon in bank recon module
And user click add icon in bank recon
And user select bank name in bank recon Module for csv file
And user select bank account Number in bank recon Module
And user click bank recon from date and select the date for csv file
And user click bank recon to date and select the date for csv file
And user click choose file and upload the bank statement for csv
And user click save button in bank recon
And user click process button in bank recon
And user click the unmatched data in bank recon process
And user match the records in unmached tab
And user click matched data tab
And user unmatch the matched records in matched tab
And user click bank recon temp view
And user click first record in bank recon temp view
And user click process button again for reprocessing
And user click the unmatched data in bank recon process
Then user verify Check post reprocessing bank statement there is no impact on manually unmatched entries




