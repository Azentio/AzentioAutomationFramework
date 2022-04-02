Feature: Checking the Fixed Asset  functionality



@KUBS_FAT_UAT_002_007 @MutiAuth
Scenario: Creation of the registered asset with full details

Given Navigate to kubs URL and user should login as a maker
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
Then fill the asset item details asset Creation
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
