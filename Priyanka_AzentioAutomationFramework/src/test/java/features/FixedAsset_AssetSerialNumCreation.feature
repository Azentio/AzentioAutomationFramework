Feature: Checking the Fixed Asset  functionality

@KUBS_FAT_UAT_002_005  @MultiAuth

Scenario: Serial number should be alloted to the asset and displayed in the list view of Asset serial number sub module
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Serial Num Creation Eye button
Then Click on Asset Serial Num Creation Search icon
Then Enter Asset code
Then Click on the record
Then Fill Asset Serial Num Creation Mandatory fields
Then Click on Fixed Asset Save button
