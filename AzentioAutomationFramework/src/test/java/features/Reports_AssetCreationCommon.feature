Feature: Reports
 		Asset Creation Common 
    
  @KUBS_FAT_UAT_013_001
  Scenario: Check Asset Limit Config
    #Given User should go to the kubs url and login as a maker user
    #Then click on report icon
    #And user should navigate to reports menu
    #Then click on temp grid button of asset creation common
    #And select the asset life unit and date to check the asset limit are displaying
    #Then click in the view button to check
    
  @KUBS_FAT_UAT_013_002
  Scenario: Check Asset Category
    #Given User should go to the kubs url and login as a maker user
    #Then click on report icon
    #And user should navigate to reports menu
    #Then click on temp grid button of asset creation item
    #And select the asset life unit and date to check the asset category are displaying
    #Then click in the view button to check
    
  @KUBS_FAT_UAT_013_003
  Scenario: Check Asset Codes
    #Given User should go to the kubs url and login as a maker user
    #Then click on report icon
    #And user should navigate to reports menu
    #Then click on temp grid button of asset creation common
    #And select the asset life unit and date to check the asset codes are displaying
    #Then click in the view button to check
    
    
  @KUBS_FAT_UAT_013_004
  Scenario: Check Depreciation
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of depreciation
    And select required fields to check the depreciation details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset depreciation details for a branch
    