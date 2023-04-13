Feature: Checking the Bank Reconcilliation  functionality

@KUBS_TAX_UAT_002_001_TC_001  @MultiAuth
Scenario: System allow user to create bank recon details by uploading correct txt file.
Given User should go to the kubs url and login as a maker user
Then select data set ID for uploading correct bank recon txt file
Then Choose the second Tab Segment
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file

@KUBS_TAX_UAT_002_001_TC_002  @MultiAuth
Scenario: Check system throws validation any data on Bank Reconciliation Details screen does not match with uploaded file.
Given User should go to the kubs url and login as a maker user
Then select data set ID for verifying system throws validation on mismatched data
Then Choose the second Tab Segment
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file data does not match

	@KUBS_TAX_UAT_002_001_TC_003
	Scenario: Click on Process button
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for clicking on process button
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify the bank reconciliation process tab is enabled
    #cancel_processed_record
    Then cancel the process record from temp view

	@KUBS_TAX_UAT_002_002_TC_001
  Scenario: Verify matched entries are displayed under Tab Matched where View Reconciliation Basis is 'Book To Bank'
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify matched entries under matched tab
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify all the matched entries are displayed under the matched tab for book to bank
    #cancel_processed_record
    Then cancel the process record from temp view

  @KUBS_TAX_UAT_002_002_TC_002
  Scenario: Click on a match record and check it displays the match record from uploaded file
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for clicking on match record and check it displays the match record
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify after clicking on a match record it displays the match record from uploaded file
    #cancel_processed_record
    Then cancel the process record from temp view
    
  @KUBS_TAX_UAT_002_002_TC_003
  Scenario: Click on a match record which matches with multiple records from Bank statement
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for clicking on match record and check it matches with multiple record
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify after clicking on a match record it matches with multiple records from bank statement
		#cancel_processed_record
    Then cancel the process record from temp view
    
	@KUBS_TAX_UAT_002_002_TC_004
  Scenario: Verify matched entries are displayed under Tab Matched where View Reconciliation Basis is 'Bank To Book'
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify matched entries under matched tab where View Reconciliation Basis is Bank To Book
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify all the matched entries are displayed under the matched tab for bank to book
    #cancel_processed_record
    Then cancel the process record from temp view
    
	@KUBS_TAX_UAT_002_002_TC_005
  Scenario: Click on a match record and check it displays the match record from Book
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for Click on a match record and check it displays the match record from book
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify after clicking on a match record it displays the match record from book
    #cancel_processed_record
    Then cancel the process record from temp view
    
  @KUBS_TAX_UAT_002_002_TC_006
  Scenario: Click on a match record which matches with multiple records from Book
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for clicking on match record and check it matches with multiple record from Book
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify after clicking on a match record it matches with multiple records from book
    #cancelrecord
    Then cancel the process record from temp view
    
@KUBS_TAX_UAT_002_002_TC_007_01  @MultiAuth
Scenario: Verify system gives correct match basis the matching rule defined
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify match record basis data matching rule
And user should navigate to bank recon format menu
When click on eye button of bank recon format
Then open bank recon format configuration of a bank
And navigate to data matching rule
Then get the matching rule for correct match record
@KUBS_TAX_UAT_002_002_TC_007_02
Scenario: Verify system gives correct match basis the matching rule defined
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify match record basis data matching rule
And user should navigate to bank recon menu
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
And Fill the required fields and upload bank statement for bank reconciliation
Then Save and click on process
Then verify matched record
#cancel_processed_record
Then cancel the process record from temp view
    
  #@KUBS_TAX_UAT_cancel_processed_record
  #Scenario: cancel_processed_record_from_temp_view
    #Given User should go to the kubs url and login as a maker user
    #Then select data set ID for cancel the process record
    #And user should navigate to bank recon menu
    #Then cancel the process record from temp view
    
  @KUBS_TAX_UAT_002_003_TC_001
  Scenario: Check below entries are displayed for unmatched records from uploaded bank statement.
 					1. Unmatched record
 					2. Partially Matched Record
 					3. Transposition matched record
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for unmatched records from uploaded bank statement
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify the Unmatch Record Tab must display all the entries for unmatched records from uploaded bank statement
    #cancelrecord
    Then cancel the process record from temp view
    
  @KUBS_TAX_UAT_002_003_TC_002
  Scenario: Check below entries are displayed for unmatched records from Book.
 					1. Unmatched record
 					2. Partially Matched Record
 					3. Transposition matched record
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for unmatched records from Book
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify the Unmatch Record Tab must display all the entries for unmatched records from Book
		#cancelrecord
    Then cancel the process record from temp view
    
    
@KUBS_TAX_UAT_002_003_TC_003_01
Scenario: Verify system gives correct unmatch basis the matching rule defined
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify unmatch record basis data matching rule
And user should navigate to bank recon format menu
When click on eye button of bank recon format
Then open bank recon format configuration of a bank
And navigate to data matching rule
Then get the matching rule for unmatch record
@KUBS_TAX_UAT_002_003_TC_003_02
Scenario: System must give correct unmatch (Unmatch, Partial Match & Transposition match) basis the matching rule defined.
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify unmatch record basis data matching rule
And user should navigate to bank recon menu
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
And Fill the required fields and upload bank statement for bank reconciliation
Then Save and click on process
Then verify unmatch record
#cancel_processed_record
Then cancel the process record from temp view

@KUBS_TAX_UAT_003_001_TC_001
Scenario: Select a matched record and click on unmatch button
Given User should go to the kubs url and login as a maker user
Then select data set ID for verify system must unmatch a matched record
And user should navigate to bank recon menu
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
And Fill the required fields and upload bank statement for bank reconciliation
Then Save and click on process
Then select matched record from matched tab
And click on unmatch button
Then verify system must unmatch the matched record and unmatched record must display in unmatched tab
And verify the same record should not be displayed in matched tab
#cancel_processed_record
Then cancel the process record from temp view

@KUBS_TAX_UAT_003_002_TC_001
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Books to Bank.
		Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify system must unmatch a matched record and a single record From Book on Matched Tab
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then select a unmatched record from bank and one record from book where view basis is book to bank
    And click on match button
    Then verify system must unmatch a matched record and a single record From Book on Matched Tab

@KUBS_TAX_UAT_003_002_TC_002
Scenario: Select a unmatched record from Bank and one record from Book and click on Match button where View basis is Bank To Book
		Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify system must unmatch a matched record and a single record From Bank statement on Matched Tab
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then select a unmatched record from bank and one record from book where view basis is bank to book
    And click on match button in unmatched tab
    Then verify system must unmatch a matched record and a single record From Bank statement on Matched Tab
    #cancel_processed_record
		Then cancel the process record from temp view

@KUBS_TAX_UAT_003_002_TC_003
Scenario: Select a suggested record from Bank and one record from Book and click on Match button where View basis is Book To Bank
		Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify system must unmatch a matched record and a single record From Book on Matched Tab
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then select a suggested record from bank and one record from book where view basis is book to bank
    And click on match button in unmatched tab
    Then verify system must unmatch a matched record and a single record From Book on Matched Tab
		#cancel_processed_record
		Then cancel the process record from temp view
	
@KUBS_TAX_UAT_003_002_TC_004
Scenario: Select a suggested record from Bank and one record from Book and click on Match button where View basis is Bank To Book
		Given User should go to the kubs url and login as a maker user
    Then select data set ID for verify system must unmatch a matched record and a single record From Bank statement on Matched Tab
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then select a suggested record from bank and one record from book where view basis is bank to book
    And click on match button in unmatched tab
    Then verify system must unmatch a matched record and a single record From Book on Matched Tab
    #cancel_processed_record
		Then cancel the process record from temp view
    
@KUBS_TAX_UAT_003_002_TC_005
Scenario: Verify sum of selected record from one side matches with sum of records from other side else system to throw validation while matching such records
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for Verify sum of selected record from one side matches with sum of records from other side
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify system to throw validation while sum of selected records are not matching with sum of records from other side
    Then verify sum of selected record from one side matches with sum of records from other side
    #cancel_processed_record
		Then cancel the process record from temp view
		
@KUBS_TAX_UAT_004_001_TC_001
Scenario: Click on Process button on Bank Recon Process screen post creating additional entries (for txt file)
    Given User should go to the kubs url and login as a maker user
    Then select data set ID to verify Bank Recon Process screen post creating additional entries
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify Book entry will be matched with Bank entry and will be displayed in Matched Tab
		Then verify Unmatched entry from Bank Side will not be displayed
		#cancel_processed_record
		Then cancel the process record from temp view
		
@KUBS_TAX_UAT_004_001_TC_002
Scenario: verify post re-processing bank statement, there is no impact on manually matched entries (for txt file)
    Given User should go to the kubs url and login as a maker user
    Then select data set ID to Verify post reprocessing bank statement there is no impact on manually matched entries
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then user should match the record manually in unmatched tab
    And click on match button in unmatched tab
    Then select the record from temp view of bank recon for reprocessing
    Then click on process button for reprocessing
    Then verify post reprocessing bank statement there is no impact on manually matched entries
    #cancel_processed_record
		Then cancel the process record from temp view
		
@KUBS_TAX_UAT_004_001_TC_003
Scenario: verify post re-processing bank statement, there is no impact on manually unmatched entries (for txt file)
    Given User should go to the kubs url and login as a maker user
    Then select data set ID to Verify post reprocessing bank statement there is no impact on manually unmatched entries
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then user should match the record manually in unmatched tab
    And click on match button in unmatched tab
   	 Then user should unmatch the record manually from matched tab
     And click on unmatch button in matched tab
    Then verify the unmatch record is in unmatched tab
    Then select the record from temp view of bank recon for reprocessing
    Then click on process button for reprocessing
    Then verify post reprocessing bank statement there is no impact on manually unmatched entries
    #cancel_processed_record
		Then cancel the process record from temp view
    
@KUBS_TAX_UAT_005_001_TC_001
Scenario: verify format of Bank Reconciliation statement is correct as per FSD (for txt file)
    Given User should go to the kubs url and login as a maker user
    Then select data set ID to verify format of Bank Reconciliation statement is correct as per FSD
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then click on bank reconciliation statement tab
    Then verify format of bank reconciliation statement is correct as per FSD
    #cancel_processed_record
		Then cancel the process record from temp view
    
@KUBS_TAX_UAT_005_001_TC_002
Scenario: System must display correct sum  and records in below head as per logics given in FSD.
					1. Receipt recorded in Book but missing in Bank Statement
					2. Payment recorded in Book but missing in Bank Statement 
					3. Receipts recorded in bank statement but missing in Book
					4. Payment recorded in bank statement but missing in Book
    Given User should go to the kubs url and login as a maker user
    Then select data set ID to verify system must display correct sum and records as per logics given in FSD
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    #And Fill the required fields and upload bank statement for bank reconciliation
    Then Fill the bank name and account number for bank reconciliation
    Then select the recon period from date for bank reconciliation
    And verify and cancel Bank Reconciliation process if already done for selected period 
    Then select the recon period to date for bank reconciliation
    Then upload the text file for bank reconciliation
    Then Save and click on process
    Then click on bank reconciliation statement tab
    Then verify system displays correct sum and records in Receipt recorded in Book but missing in Bank Statement head
    Then verify system displays correct sum and records in Payment recorded in Book but missing in Bank Statement head
    Then verify system displays correct sum and records in Receipts recorded in bank statement but missing in Book head
    Then verify system displays correct sum and records in Payment recorded in bank statement but missing in Book head
    #cancel_processed_record
		Then cancel the process record from temp view
    
    
    