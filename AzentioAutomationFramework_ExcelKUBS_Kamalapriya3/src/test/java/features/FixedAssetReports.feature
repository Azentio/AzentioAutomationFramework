Feature: To verify the reports for fixed asset

@KUBS_FAT_UAT_013_019_Revaluation
Scenario: Check Asset Revaluation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Revaluation Report edit button
And Get the system data
Then Select Revaluation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_017_Replacement
Scenario: Check Asset replacement Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Asset replacement Report edit button
Then Choose the data set id for asset replacement report
And Get the system data
Then Fill details for report
Then Select date from calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_016_Return
Scenario: Check Asset return Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on return Report edit button
Then choose the data set for asset return report
Then Fill details for return report
And Get the system data
Then Select return date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_018_ImpairementLoss
Scenario: Check Impairement Loss booking Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Impairement Report edit button
And Get the system data
Then Select Impairement loss date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_014_AssetAllocation
Scenario: Check Asset Allocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Allocation Report edit button
Then Choose the data set id for asset allocation report
And Get the system data
Then fill Allocation Report details
Then Select Allocation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_015_Deallocation
Scenario: Check Asset DeAllocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on DeAllocation Report edit button
Then Choose the data set id for asset allocation report
Then fill DeAllocation Report details
And Get the system data
Then Select DeAllocation from date in calendar
Then Select DeAllocation to date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_013_Assetsale  @MultiAuth
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then click on report segment button
Then Click on Report field
And Choose the data set id for asset sale report
Then click on Asset Sale Report
Then Select the Asset Sale Code
And Get the system data for asset sale
Then Select the date Asset Sale
And click on view button of report
Then verify the Asset Sale report

@KUBS_FAT_UAT_013_012_AssetUndertaking
  Scenario: Check Asset Undertaking
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And choose the data set id for asset undertaking report
    And Get the system date for asset undertaking
    And select the asset code and date to check the asset undertaking details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset undertaking details for a branch 
    
     
  @KUBS_FAT_UAT_013_011
  Scenario: Check Asset Transfer
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And select the asset code and date to check the asset transfer details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset transfer details for a branch
