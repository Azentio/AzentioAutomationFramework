Feature: To check the asset return module
Background: 
Given Navigate to KUBS URL and login with maker credentials
@AssetReturn
Scenario: Check if the asset can be returned to its vendor
And click on fixed asset main module
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

@returnRevaluedAsset
Scenario: Check if the re-valued asset can be returned to its vendor
And click on fixed asset main module
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

@AmmendentAssetReturn 
Scenario: Check if the ammendent asset can be returned to its vendor
And click on fixed asset main module
Then goto ammendent asset module
And click on Add Icon
Then Enter Asset Referance Number in ammendent asset
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
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
Then goto ammendent asset module
Then check the approved record is displayed in ammendent asset
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of ammendent asset
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


@returnImpairedAsset
Scenario: Check if the impaired asset can be returned to its vendor
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose asset reference number in asset impaired module
And choose the asset Item no
And choose the transcation type as impairment
Then click on Save Button
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
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of impaired asset
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

@deAllocatedAssetReturn 
Scenario: Check if the deallocated asset can be returned to its vendor
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
And click on Add Icon
Then Fill the asset de Allocaion Mandatory fields
Then Click on Fixed Asset Save button for de allocation
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
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then check the approved record is displayed in de allocation list view
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of de allocated asset
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


