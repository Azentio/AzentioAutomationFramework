Feature: Reports
 		Asset Transfer 
    
  @KUBS_FAT_UAT_013_011
  Scenario: Check Asset Transfer
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And select the asset code and date to check the asset transfer details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset transfer details for a branch
 
  @KUBS_FAT_UAT_013_012
  Scenario: Check Asset Undertaking
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And select the asset code and date to check the asset undertaking details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset undertaking details for a branch