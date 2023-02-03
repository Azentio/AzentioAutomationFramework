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
    
     
  @KUBS_FAT_UAT_013_011_AssetTransfer
  Scenario: Check Asset Transfer
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    Then choose the data set id for asset transfer report
        And Get the system date for asset undertaking
        And select the asset code and date to check the asset transfer details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset transfer details for a branch
    
    
    @KUBS_FAT_UAT_013_009_AssetContract
 Scenario: Check Asset Contract
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then Get the data set id for the report of asset contract
 Then click on temp grid button of asset contract
 And Get the system date for asset undertaking
 And select the contract ref number and date to check asset contract details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset contract details for a branch
 
 
@KUBS_FAT_UAT_013_010_AssetAmmenment
Scenario: Check Asset Amendment Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Amendment Report edit button
Then Choose the data set id for asset amenment report
Then fill Amendment Report details
Then Get the system date for asset ammenment report
Then Select Amendment from date in calendar
Then Select Amendment to date in calendar
Then Click on the View button
Then close the report

 @KUBS_FAT_UAT_013_003_AssetCode
Scenario: Check Asset Codes 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset code 
Then Choose the data set for asset code report
Then Get the system date for asset code report
And select the depreciation method and date to check the asset codes are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 

@KUBS_FAT_UAT_013_004_Depreciation
 Scenario: Check Depreciation
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of depreciation
 And Choose the data set id for depreciation report
 And Get the system date for the depreciation report
 And select required fields to check the depreciation details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset depreciation details for a branch
 
  @KUBS_FAT_UAT_013_005_AssetGl
Scenario: Check Asset GL
Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
Then Get the system date for asset ammenment report
And click on transaction from date calender icon
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
#Then validate voucher number

@KUBS_FAT_UAT_007_009_vendorpayment
Scenario: Check If If asset is required to return after vendor payment
Given Maker Navigate to UAT URL login
Then click Third Segment button
And Click on Enquiry main module
Then Click on Financial sub module Edit icon
And choose the data set id to return after vendor payment
And choose branch code Ids
Then Select GL code as Fixed asset code
And Choose the data set id for vendorpayment
And Choose calender From date
Then Choose Calender To dates
And click on view button to see the Record

 @KUBS_FAT_UAT_004_002_AccountingEntries1
Scenario: Check the accounting Entries
Given Maker Navigate to UAT URL login
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And Choose the data set id for the accounting entries
And choose branch code Ids
Then choose the Gl code Ids
Then Get the system date for accounting entries
And click on transaction from date in calender icon
Then choose from date in the calenders
And click on the transaction to date in calender icon
Then choose the To date in the calenders
And click on view button to see the Record

@KUBS_FAT_UAT_004_004_AccountingEntries2

Scenario: Check the accounting Entries
Given Maker Navigate to UAT URL login
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
Then Choose the data set id for accountinmg entries
And choose branch code Ids
Then choose the Gl code Ids
Then Get the system date for accounting entries
And click on transaction from date in calender icon
Then choose from date in the calenders
And click on the transaction to date in calender icon
Then choose the To date in the calenders
And click on view button to see the Record

@KUBS_FAT_UAT_013_001 
Scenario: Check Asset Limit Config 
 And User get the limit config testdata for test case01
 Given Maker Navigate to UAT URL login
 Then click on report icon 
 And user should navigate to master reports menu 
 Then click on temp grid button of asset limit configuration 
 Then Get the system date for asset ammenment report
 And select the accountings standards and date to check the asset limit are displaying 
 Then click in the view button to check 
 Then the report is displaying all the asset codes details for a branch 
 
@KUBS_FAT_UAT_013_002 
Scenario: Check Asset Category 
And User get the limit config testdata for test case02
Given Maker Navigate to UAT URL login
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset category 
And select the asset categorys and date to check the asset category are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 
