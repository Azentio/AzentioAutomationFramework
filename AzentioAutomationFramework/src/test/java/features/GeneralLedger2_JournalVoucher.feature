Feature: General Ledger2 Transaction
  Journal Voucher
  
  @KUBS_GL2_UAT_006_001 @Report
  Scenario: Check the transactions as per reference number feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    When click on eye button of journal voucher
    Then click on the record to get the voucher number
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the reference number field of financial transaction
    Then click on view button to view the report as per reference number
 
  @KUBS_GL2_UAT_006_002 @Report
  Scenario: Check the transactions as per GL number feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    When click on eye button of journal voucher
    Then click on the record to get the GL number
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the GL number field of financial transaction
    Then click on view button to view the report as per reference number
  
  @KUBS_GL2_UAT_006_003 @Report
  Scenario: Check the transactions as per dates feeded
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to general ledger transaction menu
    #When click on eye button of journal voucher
    #Then click on the record to get the transaction date
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the date field of financial transaction
    Then click on view button to view the report as per reference number