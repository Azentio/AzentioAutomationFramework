Feature: FIXED ASSETS
 ASSET SALE

  @KUBS_FAT_UAT_004_001
  Scenario: Check if the given asset is sold at higher price
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    And click on add button to create sale asset record
    And Fill the required fields to sale asset
    Then Save and submit the asset sale record
    
    And User should go to the kubs url and login as a reviewer user 
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset sale
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    Then click on first eye button to get the profit earned
    And maker should logout
    
  @KUBS_FAT_UAT_004_003
  Scenario: Check if the given asset is sold at higher price
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    And click on add button to create sale asset record
    And Fill the required fields to sale asset
    Then Save and submit the asset sale record
    
    And User should go to the kubs url and login as a reviewer user 
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset sale
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    Then click on first eye button to get the loss earned
    And maker should logout