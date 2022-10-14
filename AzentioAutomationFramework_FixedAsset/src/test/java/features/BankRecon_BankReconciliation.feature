Feature: Bank Recon Module
				 Bank Reconciliation
    
  @KUBS_TAX_UAT_002_001_TC_003
  Scenario: Click on Process button
    Given User should go to the kubs url and login as a maker user
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then verify the bank reconciliation process tab is enabled
    
  @KUBS_TAX_UAT_002_002_TC_001
  Scenario: Verify matched entries are displayed under Tab Matched where View Reconciliation Basis is 'Book To Bank'
    Given User should go to the kubs url and login as a maker user
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify all the matched entries are displayed under the matched tab for book to bank
     
  @KUBS_TAX_UAT_002_002_TC_004
  Scenario: Verify matched entries are displayed under Tab Matched where View Reconciliation Basis is 'Bank To Book'
    Given User should go to the kubs url and login as a maker user
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify all the matched entries are displayed under the matched tab for bank to book
     
  @KUBS_TAX_UAT_002_003_TC_002
  Scenario: Check below entries are displayed for unmatched records from Book.
 					1. Unmatched record
 					2. Partially Matched Record
 					3. Transposition matched record
    Given User should go to the kubs url and login as a maker user
    And user should navigate to bank recon menu
    When click on eye button of bank reconciliation
    And click on add button for bank reconciliation
    And Fill the required fields and upload bank statement for bank reconciliation
    Then Save and click on process
    Then Verify the Unmatch Record Tab must display all the entries for unmatched records from Book

    #@KUBS_TAX_UAT_002_002_TC_002
  #Scenario: Click on a match record and check it displays the match record from uploaded file
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to bank recon menu
    #When click on eye button of bank reconciliation
    #And click on add button for bank reconciliationl
    #And Fill the required fields and upload bank statement for bank reconciliation
    #Then Save and click on process
    #Then verify after clicking on a match record it displays the match record from uploaded file
    