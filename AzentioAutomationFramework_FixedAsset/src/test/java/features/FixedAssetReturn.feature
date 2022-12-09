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
And User close the workflow initiated pop up
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
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number
And choose item number for the asset
Then click on Save after fill all the asset
And User close the workflow initiated pop up
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
And User close the workflow initiated pop up
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
#returnRevalued
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And go to revalued asset module
And click on Add Icon
Then Give AssetReferance Number
And Select Asset Item Number
Then Alter the Book Value
Then save the Revaluation record
And User close the workflow initiated pop up
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
And User close the workflow initiated pop up
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
@KUBS_FAT_UAT_007_003 @AmmendentAssetReturn
Scenario: Check if the ammendent asset can be returned to its vendor
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
And User close the workflow initiated pop up
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
#AmendentAssetReturn
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
Then goto ammendent asset module
And click on Add Icon
Then Enter Asset Referance Number in ammendent asset
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
And User close the workflow initiated pop up
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
And User close the workflow initiated pop up
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


@KUBS_FAT_UAT_007_004 @returnImpairedAsset
Scenario: Check if the impaired asset can be returned to its vendor
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
And User close the workflow initiated pop up
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
#impairedAsset
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose asset reference number in asset impaired module
And choose the asset Item no
And choose the transcation type as impairment
Then click on Save Button
And User close the workflow initiated pop up
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
And User close the workflow initiated pop up
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

@KUBS_FAT_UAT_007_005
Scenario: Check if the replaced asset can be returned to its vendor
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
And User close the workflow initiated pop up
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
#Asset Replacement
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click Add Icon button
Then Enter the Asset Referance Number
And Enter the Asset Item Number
Then Enter the New Item Number
And Enter the New Description
Then save the Replacement recordss
And User close the workflow initiated pop up
And Went to Maker Notification
Then Click the first Action icon
And Submit the Record in maker
Then Enter Remark and Submit it
Given Launch the Azentio Reviewer
And Click Reviewer Notification icon
Then Click submitted record from maker
And Click Approve icon from Reviewer End
Then Enter remark and submit the Record
Given Launch the Azentio Checker
Then Click Security management
And Click open pool Edit icon
Then Claim record Approved from Reviewer
And Click Checker Notification icon
Then Click Action Icon from claimed record
And Click Approve icon
Then Submit Record from Checker End  
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click on the search icon
Then Enter Asset Referance No
When capture Asset Grid view 
#replaced asset
#Given Navigate the Azentio url
#Then Click Second Segmant Icon
#And Click main module fixed Asset Module
Then Asset Replacement Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And User close the workflow initiated pop up
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list

@KUBS_FAT_UAT_007_006 @deAllocatedAssetReturn
Scenario: Check if the deallocated asset can be returned to its vendor
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
And User close the workflow initiated pop up
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
#Allocation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form
Then Click on Fixed Asset Save button
And User close the workflow initiated pop up
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#deallocatedAssetReturn
Given Navigate to KUBS URL and login with maker credentials
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
And click on Add Icon
Then Fill the asset de Allocaion Mandatory fields
Then Click on Fixed Asset Save button for de allocation
And User close the workflow initiated pop up
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
#Asset return
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

@KUBS_FAT_UAT_007_007
Scenario: Check if the undertaken asset can be returned to its vendor
#undertaken
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Undertaken Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And User close the workflow initiated pop up
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list


@KUBS_FAT_UAT_007_008
Scenario: Check If asset required to return before vendor payment

Given Navigate the Azentio url
Then click Third Segment button
And Click on Enquiry main module
Then Click on Financial sub module Edit icon
And Click Branch code Dropdown
Then Select GL code as Fixed asset
And Choose calender From date
Then Choose Calender To date
And Click on View and See the record


@KUBS_FAT_UAT_007_009
Scenario: Check If If asset is required to return after vendor payment
Given Navigate the Azentio url
Then click Third Segment button
And Click on Enquiry main module
Then Click on Financial sub module Edit icon
And Click Branch code Dropdown
Then Select GL code as Fixed asset code
And Choose calender From date
Then Choose Calender To date
And Click on View and See the record


