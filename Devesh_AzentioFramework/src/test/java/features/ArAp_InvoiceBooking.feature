Feature: AR/AP Module
 Invoice booking
    
  @KUBS_AR/AP_UAT_001_001_TC_009
  Scenario: Create Bill against PO & GRN for above vendor
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking
    Then Save and submit the invoice billing
    
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
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the invoice status
    And maker should logout
    
  @KUBS_AR/AP_UAT_001_006_TC_01
  Scenario: Verify Bill is auto created on defined date
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking
    Then Save and submit the invoice billing
    
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
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the invoice status
    And maker should logout
    
  @KUBS_AR/AP_UAT_001_001_TC_010
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
  @KUBS_AR/AP_UAT_001_006_TC_02
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
  @KUBS_AR/AP_UAT_001_007_TC_01
  Scenario: Verify Tax details is correctly displayed for Item details in Billing
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then Get the tax details and check
    And maker should logout
    
  @KUBS_AR/AP_UAT_013_001_TC_05
  Scenario: Verify creating Bill is not allowed if YTD amount for expense exceeds mapped budget code limit. 
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking with exceeded amount
    Then Save and submit the invoice billing with exceeded amount
    
  	
 
 
 
 
 
 
 
 
 
 
 
 
 