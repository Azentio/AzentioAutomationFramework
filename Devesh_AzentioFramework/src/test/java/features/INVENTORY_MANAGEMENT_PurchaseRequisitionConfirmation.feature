Feature: INVENTORY MANAGEMENT
 Purchase Requisition Confirmation

  @PurchseReqConf_KUBS_INV_MGMT_UAT_001_002
  Scenario: Purchase
    Given User should go to the kubs url and login as a maker user
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    And click on add button  of purchase requisition confirmation
    And Fill the required fields to purchase req
    Then Save and submit the purchase req confirmation
    
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
    And user should navigate to inventory management
    When click on eye button of purchase requisition confirmation
    Then click on first eye button to get the indent reference number
    And maker should logout