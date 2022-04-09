Feature: ACCOUNTING SETUP
  		Chart Of Accounts Definition
  
  @KUBS_GL_UAT_005_005
  Scenario: Modify the Chart of Account (COA)
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search COA name to modify the coa
    
    Then click on pencil button to modify the COA
    Then modify the COA details
    Then Save and submit the modified record of COA
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the COA record
    
  @KUBS_GL_UAT_005_006
  Scenario: Check the created COA can be modified after use of COA if GL entries are passed for the COA
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search used COA code for which GL entries are passed
    
    Then click on pencil button to modify the COA
    Then modify the COA details for which GL entries are passed
    Then Save and check the modified record of used leaf COA
 
  @KUBS_GL_UAT_005_007
  Scenario: Check the created COA can be modified if Gl entries are passed for the parent being mapped or changed
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search used parent COA code for which GL entries are passed
    
    Then click on pencil button to modify the COA
    Then modify the COA details for which GL entries are passed
    Then Save and check the modified record of used parent COA
    
  @KUBS_GL_UAT_005_008
  Scenario: Create Chart of Account Active to De-active
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search COA name to modify the coa
    
    Then click on pencil button to modify the COA
    Then Inactive the active Chart of account
    Then Save and submit the modified record of COA
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the COA record
    Then checker should approved the COA record
    