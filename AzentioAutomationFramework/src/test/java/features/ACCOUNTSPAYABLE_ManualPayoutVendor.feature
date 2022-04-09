Feature: AR/AP Module
 Manual Payout
    
  @KUBS_AR/AP_UAT_006_001_TC_01_Vendor
  Scenario: Creating Manual payouts for approved Bills of a Vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout vendor
    Then Save and submit the manual payout record
    
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
    
  @KUBS_AR/AP_UAT_006_002_TC_01
  Scenario: Creating manual payouts for approved advances of a vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for manual payout
    Then Save and submit the manual payout record
    
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
    
  @KUBS_AR/AP_UAT_005_001_TC_02
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
  @KUBS_AR/AP_UAT_005_001_TC_02
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
  @KUBS_AR/AP_UAT_005_003_TC_01
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
    
  @KUBS_AR/AP_UAT_005_004_TC_01
  Scenario: Verify cancelled payment txn is not available for payout on payout screen.
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    And click on add button for manual payout
    And Fill the required fields for verify cancelled payment txn availability
