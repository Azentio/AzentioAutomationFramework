Feature: Checking the Fixed Asset  functionality



@KUBS_FAT_UAT_002_007 @MutiAuth
Scenario: Creation of the registered asset with full details

Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on Fixed Asset Notification 
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Save the filled form

#Then Click on save button of item details

Then Click on Fixed Asset Notification
Then Select the record which we saved
Then Submit record

Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
