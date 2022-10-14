Feature:  To Verify user can able to do the transaction in Bank recon module
@KUBS_TAX_UAT_07_001
Scenario: Processing Bank recon for same period, Bank and Account Number
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number 
And Give the recon period from date which is already processed 
Then verify system throw the validation message or not

@KUBS_TAX_UAT_07_002
Scenario: Processing bank recon with already used file.
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number 
And Give the recon period from date to upload the already existiong file
And Give the recon period to date to upload the already existiong file
And upload the already processed file 
Then verify system should through the validation message for uploded file 


@KUBS_TAX_UAT_009_001_TC_002
Scenario: Check system throws validation any data on Bank Reconciliation Details screen does not match with uploaded file.
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number 
And Give the recon period from date 
And Give the recon period to date 
Then Upload our file 
And check the file is validated  successfully or not
And save the bank recon record
And Process that file
And goto unmatched Tab
And unmatch that record and try to save that record 
Then verify validation message is comming or not
@KUBS_TAX_UAT_009_001_TC_003
Scenario: Creating Bank details by uploading bank statement in CSV format.Click on Process button
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify the bank statement tab
And Give the recon period to date to verify the bank statement tab
And upload te file to verify the bank statement
And check the file is validated  successfully or not
And save the bank recon record
And Process that file
And goto unmatched Tab
And match that receipt reference number in unmatched tab 
And goto matched tab and check the receipt reference number comes under matched tab

@KUBS_TAX_UAT_009_002_TC_001
Scenario: Verify matched entries are displayed under Tab' Matched' where View Reconciliation Basis is 'Book To Bank'
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify the mach tab for Book to bank basis
And Give the recon period to date to verify the mach tab for Book to bank basis
And upload the file to verify the book to bank type
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record
#And goto bank statement tab and validate theat amount should be tally
And choose the book to bank in type and verify matched data is comming under the matched tab
And goto match tab and verify record was displayed under the match tab

@KUBS_TAX_UAT_009_002_TC_002
Scenario: Click on a match record and check it displays the match record from uploaded file.
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify the mach tab for Book to bank basis
And Give the recon period to date to verify the mach tab for Book to bank basis
And upload the file to verify the book to bank type for verify the matchTab
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record
And choose the book to bank in type and verify matched data is comming under the matched tab
#And goto bank statement tab and verify the amount was tally or not
And goto match tab and verify record was displayed under the match tab

@KUBS_TAX_UAT_009_002_TC_003
Scenario: Click on a match record which matches with multiple records from Bank statement
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date for multiple data file in Book to bank basis
And Give the recon period to date for multiple data file in Book to bank basis
And upload the file for multiple data file in Book to bank basis
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record and verify the transaction as yes
#And goto bank statement tab and validate theat amount should be tally
And choose the book to bank in type and verify matched data is comming under the matched tab
And goto match tab and verify record was displayed under the match tab


@KUBS_TAX_UAT_009_002_TC_004
Scenario: Verify matched entries are displayed under Tab' Matched' where View Reconciliation Basis is 'Bank To Book'
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify the mach tab for Bank to book basis
And Give the recon period to date to verify the mach tab for Bank to book basis
And upload the file to verify the Bank to book type for verify the matchTab 
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record
And choose the bank to book in type and verify matched data is comming under the matched tab
And goto match tab and verify record was displayed under the match tab

@KUBS_TAX_UAT_009_002_TC_005
Scenario: Click on a match record and check it displays the match record from uploaded file.
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify uploded file data is desplayed under the matched tab
And Give the recon period to date to verify uploded file data is desplayed under the matched tab
And upload the file for bank to book basis and verify the data in match tab
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record
And choose the bank to book in type and verify matched data is comming under the matched tab
#And goto bank statement tab and verify the amount was tally or not
And goto match tab and verify record was displayed under the match tab

@KUBS_TAX_UAT_009_002_TC_006
Scenario: Click on a match record which matches with multiple records from Book
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify uploded file data is desplayed under the matched tab
And Give the recon period to date to verify uploded file data is desplayed under the matched tab
And upload the file for bank to book basis and verify the data in match tab with multiple recipt numbers
And save the bank recon record
And Process that file
And goto unmatched Tab
And match the book record into bank record and verify the transaction as yes
And choose the bank to book in type and verify matched data is comming under the matched tab
And goto match tab and verify record was displayed under the match tab
@KUBS_TAX_UAT_009_002_TC_007
Scenario: Verify system gives correct match basis the matching rule defined.
Given Navigate to KUBS URL and login with maker credentials
And click on bank recon configuration module
And click on bank recon format module
And Click On Search Icon
And get our bank record 
And click on matching rule tab 
And get the suggested condition of any one field
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter the bank name and account number
And Give the recon period from date to verify the mach tab for Bank to book basis
And Give the recon period to date to verify the mach tab for Bank to book basis
And upload the file to verify system show the matched condition as per the configuation 
And save the bank recon record
And Process that file
And goto unmatched Tab
And verify system should show the data as per the match condition


#TextFile
@KUBS_TAX_UAT_003_002_TC_01
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Books to Bank.
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text file
And give the recon period from date for text file
And give the recon period to date for text file
Then upload the text file for process
And save the bank recon record
And Process that file
And choose book to bank as reconcilation basis
And goto unmatched Tab
And try to match the unmatched recipt and verify shstem should through the validation message

@KUBS_TAX_UAT_003_002_TC_02
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Bank To Book
Given Navigate to KUBS URL and login with maker credentials
Then click on second Segment button
And click on Bank Recon module
And click on view button near by Bank Reconcilation sub module
And click on Add Icon
And enter bank name and account number for text file
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
Given Navigate to KUBS URL and login with maker credentials
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
Given Navigate to KUBS URL and login with maker credentials
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
Given Navigate to KUBS URL and login with maker credentials
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