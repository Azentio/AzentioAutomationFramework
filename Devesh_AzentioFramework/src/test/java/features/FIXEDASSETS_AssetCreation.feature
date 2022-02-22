Feature: FIXED ASSETS
 Asset Creation
    
  @KUBS_FAT_UAT_005_Creation
  Scenario: Asset Creation
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset creation
    And click on add button to create asset record
    And Fill the required fields to create asset
    Then Save and submit the asset creation record
    
    And User should go to the kubs url and login as a reviewer user 
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
  	Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset creation record
    #
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to fixed asset menu
    #When click on eye button of asset creation
    #Then click on first eye button to get the Asset Reference Number
    #And maker should logout