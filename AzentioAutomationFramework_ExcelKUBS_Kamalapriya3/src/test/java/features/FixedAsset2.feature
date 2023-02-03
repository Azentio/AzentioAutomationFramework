Feature: testing functionalities of Fixed Asset

@KUBS_FAT_UAT_011_002
Scenario: Create an amendment to modify asset life for a fixed asset
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view


@KUBS_FAT_UAT_011_003
Scenario: Create an amendment to modify asset life (lesser than current/existing asset life)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life lesser than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_011_004
Scenario: Create an amendment to modify asset life (greater than current/existing asset life)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life greater than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_012_001
Scenario: Alter the Value of an existing asset (Any)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset reference number to do the asset revaluation

Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Referance Number
And Select Asset Item Number
Then Alter TheBook Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_002
Scenario: Alter the Value of an existing asset (de-allocation)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset deallocation submodule Eye Icon
And Click Table first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Deallocation Referance Number
And Select Asset Item Number
Then Alter the Deallocation Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_012_003
Scenario: Alter the Value of an existing asset (Revalued)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Revalued Referance Number
And Select Asset Item Number
Then Alter the Revalue Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_004
Scenario: Alter the Value of an existing asset (Impared)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Impairment submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Impaired Referance Number
And Select Asset Item Number
Then Alter the Impaired Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_012_005
Scenario: Alter the Value of an existing asset (Amendent)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Amendment submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Amendment Referance Number
And Select Asset Item Number
Then Alter the Amendment Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_006
Scenario: Alter the Value of an existing asset (undertaken)

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Undertaken submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Undertaken Referance Number
And Select Asset Item Number
Then Alter the Undertaken Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_007
Scenario: Alter the Value of an existing asset (Sold - Maker Only)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Sale submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Sale Referance Number
And Select Asset Item Number
Then Alter the Sale Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it

@KUBS_FAT_UAT_012_008
Scenario: Alter the Value of an existing asset (Return - Maker Only)
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Return submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Return Referance Number
And Select Asset Item Number
Then Alter the Return Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it


@KUBS_FAT_UAT_012_009
Scenario: Alter the Value of an existing asset (Replace)

Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Replacement submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Replace Referance Number
And Select Asset Item Number
Then Alter the Replace Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_013_004
 Scenario: Check Depreciation
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of depreciation
 And select required fields to check the depreciation details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset depreciation details for a branch
 
 @KUBS_FAT_UAT_013_005
Scenario: Check Asset GL
Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
And click on transaction from date calender icon
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then validate voucher number
 
@KUBS_FAT_UAT_013_007
Scenario: Check Asset Creation(Common)
Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab
Then Click on Asset Creation Common Edit Grid
Then Fill the form
Then Click on view button to see Asset Creation report
Then verify the approved record is available in the report

 @KUBS_FAT_UAT_013_008
 Scenario: Check Asset Creation(item)
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of asset creation item
 And select the asset life unit and date to check the asset category are displaying
 Then click in the view button to check
 Then the report is displaying all the asset transfer details for a branch
 
 @KUBS_FAT_UAT_013_009
 Scenario: Check Asset Contract
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of asset contract
 And select the contract ref number and date to check asset contract details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset contract details for a branch
 
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
@KUBS_FAT_UAT_013_013  @MultiAuth
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then click on report segment button
Then Click on Report field
Then click on Asset Sale Report
Then Select the Asset Sale Code
Then Select the date Asset Sale
And click on view button of report
Then verify the Asset Sale report



#----pending---#
#@KUBS_FAT_UAT_002_008
#Scenario: Running batch job for the fixed asset
#Given Navigate to kubs URL and user should login as a maker
#Then Click on Job Scheduler
#Then Click on Job Execution edit button
#Then Click on calander to set desire date
#Then click on Start the job
#Then Click on refresh button
#Then login with maker to check if date is changed or not

#@KUBS_FAT_UAT_003_005
#Scenario: Check if Depreciation is calculated after running the batch process

#Given Navigate to kubs URL and user should login as a maker
#Then Click on Job Scheduler
#Then Click on Job Execution edit button
#Then Click on calander to set desire date
#Then click on Start the job
#Then Click on refresh button
#Then login with maker to check if date is changed or not

@KUBS_FAT_UAT_013_016
Scenario: Check Asset return Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on return Report edit button
Then Fill details for return report
Then Select return date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_017
Scenario: Check Asset replacement Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Asset replacement Report edit button
Then Fill details for report
Then Select date from calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_018
Scenario: Check Impairement Loss booking Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Impairement Report edit button
Then Select Impairement loss date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_019
Scenario: Check Asset Revaluation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Revaluation Report edit button
Then Select Revaluation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_014
Scenario: Check Asset Allocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Allocation Report edit button
Then fill Allocation Report details
Then Select Allocation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_015
Scenario: Check Asset DeAllocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on DeAllocation Report edit button
Then fill DeAllocation Report details
Then Select DeAllocation from date in calendar
Then Select DeAllocation to date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_010
Scenario: Check Asset Amendment Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Amendment Report edit button
Then fill Amendment Report details
Then Select Amendment from date in calendar
Then Select Amendment to date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_001 

  Scenario: Check Asset Limit Config 

 Given User should go to the kubs url and login as a maker user 
 Then click on report icon 
 And user should navigate to master reports menu 
 Then click on temp grid button of asset limit configuration 
 And select the accounting standards and date to check the asset limit are displaying 
 Then click in the view button to check 
 Then the report is displaying all the asset codes details for a branch 
 
@KUBS_FAT_UAT_013_002 
Scenario: Check Asset Category 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset category 
And select the asset category and date to check the asset category are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 

 @KUBS_FAT_UAT_013_003 
Scenario: Check Asset Codes 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset code 
And select the depreciation method and date to check the asset codes are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 

@KUBS_FAT_UAT_013_006 
Scenario: Check Asset Serial Number 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset serial number 
And select the asset code and serial number and date to check the asset serial number are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 















