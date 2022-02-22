Feature: Checking the Fixed Asset  functionality

@KUBS_FAT_UAT_006_005 @MultiAuth

Scenario: Check If the de-allocated asset can be allocated to any other resource
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset deallocaion Mandatory fields
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

@KUBS_FAT_UAT_006_007 @MultiAuth
Scenario: Check If the asset to be transferred then it can be de-allocated
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset transferred deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_FAT_UAT_006_008 @MultiAuth
Scenario: Check If the asset to be sold then it should be de-allocated
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



@KUBS_FAT_UAT_006_009 @MultiAuth
Scenario: Check if any impaired asset can be de-allocated
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


@KUBS_FAT_UAT_006_010 @MultiAuth
Scenario: Check if any Check if any re-valued asset can be de-allocated asset can be de-allocated
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset revalued deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_FAT_UAT_006_011 @MultiAuth
Scenario: Check if any amended asset can be de-allocated
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
