Feature: FIXED ASSETS
 Asset Transfer
    
  @KUBS_FAT_UAT_005_001
  Scenario: Check if the given asset is transferred to a pre decided centre
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
    
   # impaired asset - MACHINARY-AIRCONDITIONER-Lloyd_BR0003_1
  @KUBS_FAT_UAT_005_002 
  Scenario: Check if the given asset is transferred to a pre decided centre (impaired asset)
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
 
	 # Revaluation asset - MACHINARY-AIRCONDITIONER-Lloyd_AZENTMAIN_2
  @KUBS_FAT_UAT_005_003 
  Scenario: Check if the given asset is transferred to a pre decided centre (re-valued asset)
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
    
    
    
    
    
    
    
    