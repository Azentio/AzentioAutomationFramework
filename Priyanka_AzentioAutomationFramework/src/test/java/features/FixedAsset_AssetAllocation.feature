Feature: Checking the Fixed Asset  functionality

@KUBS_FAT_UAT_002_006 @MutiAuth
Scenario: Asset Allocation
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
