Feature: Petty Cash
 		Reconciliation
    
  @KUBS_PC_UAT_006
  Scenario: Check amount remaining in hand
 										 Balance Should tally
    Given User should go to the kubs url and login as a maker user
    And user should navigate to petty cash menu
    When click on eye button of reconciliation
    And click on add button
    And Fill the required fields for reconciliation
    Then Save and submit the reconciliation
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to petty cash menu
    When click on eye button of reconciliation
    Then click on first eye button of new record
    Then Balance should tally
    And maker should logout