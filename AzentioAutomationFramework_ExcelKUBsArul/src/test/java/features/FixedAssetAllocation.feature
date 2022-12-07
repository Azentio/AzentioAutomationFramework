Feature: Testing the functionalities of Fixed Asset Alloctaion  
@KUBS_FAT_UAT_006_001
Scenario: Check if any unused asset can be allocated to a specific resource in the branch
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Maker Navigate to UAT URL login
#Given Navigate to kubs URL and user should login as a maker
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with unused asset
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Maker Navigate to UAT URL login
#Given Navigate to kubs URL and user should login as a maker
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_002
Scenario: Check if any used asset can be allocated to a specific resource in the branch
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with used asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
# pre condition need to create one record for asset impairment
@KUBS_FAT_UAT_006_003
Scenario: Check if any impaired asset can be allocated to a specific resource in the branch
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Impairment Eye button
And User search impaired asset record
And get imparied asset reference number
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with impaired asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_004
Scenario: Check if any re-valued asset can be allocated to a specific resource in the branch
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And User get the revalued asset for allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with revalued asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_005

Scenario: Check If the de-allocated asset can be allocated to any other resource
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#Allocate
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on Asset Allocation Eye button
And get the allocated asset reference number in asset allocation module
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
#Then Fill asset deallocaion Mandatory fields
Then Fill asset deallocaion Mandatory fields to deallocate the asset 
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_006_008 
Scenario: Check If the asset to be sold then it should be de-allocated

Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
When click on eye button of asset sale
And User get sold asset for de allocation
#Allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation For asset sold
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset sold deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_006_009 
Scenario: Check if any impaired asset can be de-allocated
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
# Impairment
Then Click on Asset Impairment Eye button
Then Click on the add button to add new record
Then fill the form for Asset Impairment
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
#Allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form impaired
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset impaired deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
@KUBS_FAT_UAT_006_010 
Scenario: Check if any Check if any re-valued asset can be de-allocated asset can be de-allocated

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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#revalued asset
Then Click on revalued asset Eye button
Then Click on the add button to add new record
Then fill the form for revalued asset
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
#Allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form revalued
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset Revalued deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_006_011 
Scenario: Check if any amended asset can be de-allocated
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#amended asset
Then Click on amended asset Eye button
Then Click on the add button to add new record
Then fill the form for amended asset
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Allocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field 
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form amended
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset amended deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_006_012 @MultiAuth
Scenario: Check if any asset replacement is de-allocated
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#asset replacement 
Then Click on asset replacement  Eye button
Then Click on the add button to add new record
Then fill the form for asset replacement 
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Allocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation for asset replacement
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset replacement deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker



