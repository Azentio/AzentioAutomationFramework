Feature: BUSINESS PARTNER SETUP
 BUSINESS PARTNER
    
  @KUBS_FAT_UAT_001_001
  Scenario: Create a Vendor for the procurement of an asset

		Given User should go to the kubs url and login as a maker user
    And user should navigate to business partner setup menu
    When click on eye button of business partner
    And click on add button of business partner
    And Fill the required fields to create a vendor
    Then Save and submit the record to create vendor
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
  	Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record