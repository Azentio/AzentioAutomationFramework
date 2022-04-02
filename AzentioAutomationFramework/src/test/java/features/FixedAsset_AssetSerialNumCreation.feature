Feature: Checking the Fixed Asset  functionality

@KUBS_FAT_UAT_002_005  @MultiAuth

Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Serial Num Creation Eye button
Then Click on Asset Serial Num Creation Search icon
Then Enter Asset code
Then Click on the record
Then Fill Asset Serial Num Creation Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker