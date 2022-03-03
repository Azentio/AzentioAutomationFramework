Feature: ACCOUNTS RECEIVABLE
  Recepts Reversals
  
  @KUBS_AR/AP_UAT_011_002_TC_02
  Scenario: Cancel receipt appropriation through Online Mode
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of receipts
    Then get the txn number
    When click on eye button of receipts reversals
    And click on add button for cancel receipt
    And Fill the required fields to cancel the receipts through online mode
    Then save the record to cancel the receipts
    And select the record actions button
    Then click on initiate the record
    And record status
    And select the record pencil icon
    Then submit the record from maker to cancel the receipts
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the invoice billing
