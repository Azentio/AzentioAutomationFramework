Feature: ACCOUNTS PAYABLE
	Payment Settlement Cancellation

  @KUBS_AR/AP_UAT_005_001_TC_01
  Scenario: User cancels the payment settlement transaction for multiple bills.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
  @KUBS_AR/AP_UAT_005_002_TC_01
  Scenario: User cancels the payment settlement transaction for multiple bills.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    Then Get the payout status
    And maker should logout
    
  @KUBS_AR/AP_UAT_005_001_TC_03
  Scenario: Verify canceling payment settlement is not allowed if payout for the transaction is approved.
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation of aprroved payout and verify
    
    
    
    
    