Feature: Reports
 		Asset Contract
    
  @KUBS_FAT_UAT_013_009
  Scenario: Check Asset Contract
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset contract
    And select the contract ref number and date to check asset contract details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset contract details for a branch