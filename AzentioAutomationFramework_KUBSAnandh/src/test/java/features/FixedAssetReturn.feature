Feature: Testing the functionalities of Asset return
@KUBS_FAT_UAT_007_001 @AssetReturn
Scenario: Check if the asset can be returned to its vendor
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
Then Select Asset Reference Number for asset return
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

@KUBS_FAT_UAT_007_002 @returnRevaluedAsset
Scenario: Check if the re-valued asset can be returned to its vendor
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
Then Select Asset Reference Number for asset return
#returnRevalued
#Given Navigate to KUBS URL and login with maker credentials
#And click on fixed asset main module
And go to revalued asset module
And click on Add Icon
Then Give AssetReferance Number
And Select Asset Item Number
Then Alter the Book Value
Then save the Revaluation record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
And click on fixed asset main module
And go to revalued asset module
Then check the approved record is displayed in revalued asset
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of revalued asset
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

