Feature: AR/AP Module
 Contract Creation[Vendor Contract]

  @KUBS_AR/AP_UAT_001_001_TC_001
  Scenario: Create a contract for an active vendor with expense type Purchases
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    And click on add button to create contract
    And Fill the required fields to create contract
    Then Save and submit the creation contract record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    Then Get the contract and Txn status by searching the record via business partner
    And maker should logout
    
    
  @vendorcontract @PO @GRN
  Scenario: Create a contract for an active vendor with expense type Purchases
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    And click on add button to create contract
    And Fill the required fields to create contract
    Then Save and submit the creation contract record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record
 
 		Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
		Then Click on purchase order Eye Icon
		Then Click on purchase order Add button
		Then Fill purchase order Mandatory fields
		Then Click on Account Payable Save button
		Then Click on Item Details Record
		Then Edit the item details fields for auto generate bill as no
		Then Click on Account Payable Save button
		Then Click on Account Payable Notification
		Then Select the record from Notification
		And Submit the Selected record
		And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record
 
 
 
 
 
 
 
 
