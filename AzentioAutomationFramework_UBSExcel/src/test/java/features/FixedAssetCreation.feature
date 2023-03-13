Feature: Check the Functionality of Fixed Asset 
@KUBS_FAT_UAT_002_001_01
Scenario: Create the asset limit1
And User get the testdata for asset limit
Given Maker Navigate to UAT URL login1
Then Click on the Direction1
Then Click on Fixed Asset1
Then Click on Asset Creation Eye button1
Then Click on the add button to add new record1
Then Fill Form
Then Save the filled form1
Then Click on Fixed Asset Notification1
Then Select the record which we saved1
Then Submit record1

@KUBS_FAT_UAT_002_001_02
Scenario: Create the asset limit2
And User get the testdata for asset limit
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage

@KUBS_FAT_UAT_002_001_03
Scenario: Create the asset limit3
And User get the testdata for asset limit
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_002_001_04
Scenario: Create the asset limit4
And User get the testdata for asset limit
Given Navigate to kubs URL and user should login as a maker1
Then Click on the Direction1
Then Click on Fixed Asset
Then Click on Asset Creation Eye button

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


##################################################################################################################################################

#PO Creation

###########################################################################################################################################################


########################################################################################################################################





