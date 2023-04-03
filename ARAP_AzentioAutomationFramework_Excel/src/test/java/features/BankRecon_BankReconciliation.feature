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
    Then select data set ID for cancel the process record
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
    
  @KUBS_TAX_UAT_cancel_processed_record
  Scenario: cancel_processed_record_from_temp_view
    Given User should go to the kubs url and login as a maker user
    Then select data set ID for cancel the process record
    And user should navigate to bank recon menu
    Then cancel the process record from temp view
    
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
    Then select data set ID for cancel the process record
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
    Then select data set ID for cancel the process record
    Then cancel the process record from temp view
    
@KUBS_TAX_UAT_002_003_TC_003  @MultiAuth
Scenario: System must give correct unmatch (Unmatch, Partial Match & Transposition match) basis the matching rule defined.
Given User should go to the kubs url and login as a maker user
And user should navigate to bank recon menu
Then click on Bank Reconcilliation format eye button
When click on eye button of bank reconciliation
And click on add button for bank reconciliation
And Fill the required fields and upload bank statement for bank reconciliation
Then Save and click on process
Then verify unmatch record


