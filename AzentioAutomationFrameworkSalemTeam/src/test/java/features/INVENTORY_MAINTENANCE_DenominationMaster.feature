Feature: INVENTORY MAINTENANCE
 Denomination

  @KUBS_INV_MGMT_UAT_002_002
  Scenario: Create denomination details
    Given User should navigate to the kubs url and login as a maker user
    And user should navigate to denomination master menu
    When click on eye button of denomination master
    And click on add button to create denomination details
    And Fill the required fields to create denomination details
    Then Save and submit the creation denomination details
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the denomination details
    And checker should logout
