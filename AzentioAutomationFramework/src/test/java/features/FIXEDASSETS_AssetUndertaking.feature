Feature: FIXED ASSETS
 Asset Undertaking
    
  @KUBS_FAT_UAT_005_005
  Scenario: Check if other centre can accept the asset once received in their branch
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a maker user for FAUM
   	Then click on notification in checker
    And Maker user should received the transferred asset
    Then maker user should submit in undertaking
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset undertaking
    Then click on first view button to see the Transferred to Branch
    And maker should logout
    
    # - impairement asset (MACHINARY-AIRCONDITIONER-Lloyd_BR0003_6)
    
  @KUBS_FAT_UAT_005_006
  Scenario: Check if other centre can accept the asset once received in their branch
   	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset impairement
    And click on add button for asset impairement
    And Fill the required fields for asset impairement
    Then Save and submit the asset impairement
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
    
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset impairement record
   
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to fixed assets menu
    #When click on eye button of asset transfer
    #And click on add button for asset transfer
    #And Fill the required fields for asset transfer
    #Then Save and submit the asset transfer
    #
    #And User should go to the kubs url and login as a reviewer user
    #Then Click on notification button in reviewer
  #	And approve the record by the reviewer user
  #	
    #Given User should go to the kubs url and login as a maker user for FAUM
   #	Then click on notification in checker
    #And Maker user should received the transferred asset
    #Then maker user should submit in undertaking
    #
    #And User should go to the kubs url and login as a reviewer user
    #Then Click on notification button in reviewer
  #	And approve the record by the final checker user
  #	
  #	Given User should go to the kubs url and login as a maker user
    #And user should navigate to fixed assets menu
    #When click on eye button of asset undertaking
    #Then click on first view button to see the Transferred to Branch
    #And maker should logout
    
    # - Revaluation asset (MACHINARY-AIRCONDITIONER-Lloyd_BR0003_6)
  @KUBS_FAT_UAT_005_007
  Scenario: Check if other centre can accept the asset once received in their branch
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset revaluation
    And click on add button for asset revaluation
    And Fill the required fields for asset revaluation
    Then Save and submit the asset revaluation
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
    
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset revaluation record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a maker user for FAUM
   	Then click on notification in checker
    And Maker user should received the transferred asset
    Then maker user should submit in undertaking
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset undertaking
    Then click on first view button to see the Transferred to Branch
    And maker should logout
    
  	
 