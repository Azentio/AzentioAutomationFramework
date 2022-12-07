Feature: To test the fixed asset module
@KUBS_FAT_UAT_002_007_01_Return
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset return
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset creation module code in notification
And Select the asset creation recod in notification
And click on asset Item tab in asset creation
And click on add button in asset item section
And enter asset item number in asset item creation
And enter asset description in asset item creation
And select the asset capitalization date in asset item creation
And enter HSN Code in asset item creation
And enter asset value in asset item creation
And save the asset item creation record
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset creation module code in notification
And store the fixed asset creation with full details reference number in excel data base and select the record
And click on submit in fixed asset creation with full details
And enter the alert remark in fixed asset creation with full details
And click on alert submit in fixed asset creation with full details
Then validate the submit and store the reviewer ID of fixed asset creation with full details in excel database
@KUBS_FAT_UAT_002_007_02_Return
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in a reviewer for asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03_Return
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details in a checker for asset return
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
@KUBS_FAT_UAT_002_007_04_Return
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset return
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset refeference number in asset undertaken excel database for return undertaken asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset undertaken excel database for return undertaken asset

@KUBS_FAT_UAT_005_001_Revaluation
Scenario: To Transfer the asset one branch to another branch
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer for pre requisite of asset return
And enter the asset reference number in asset transfer screen
And mark asset transfer as yes in appropriate asset item number
And enter the new branch in asset transfer screen
And save the asset transfer record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And search the asset transfer record in notification
And store the reference number of asset transfer in asset transfer excel database
And select the asset transfer record in notification
And click on submit in asset transfer
And enter the alert remark in asset transfer
And click on alert submit in asset transfer
And store the reviewer ID in asset transfer excel database
And store the asset reference number and itemnumber of transfered asset in asset impairment excel database


@KUBS_FAT_UAT_005_002_Revaluation
Scenario: To verify stage 1 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage1 for the pre requisite of asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation

@KUBS_FAT_UAT_005_003_Revaluation
Scenario: To verify stage 2 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage2 for the pre requisite of asset return
And click on notification in reviewer stage
And select the record in notification
And change the record trasfered as yes in stage 2
And save the transfer record in stage2
And click on notification in reviewer stage
And select the record in notification
And submit the transfer record in stage 2
And enter the alert remark in stage 2
And click on submit in reviewer alert pop up
And store the stage 3 user id in transfer undertaking excel database


@KUBS_FAT_UAT_005_004_Revaluation
Scenario: To verify stage 3 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage3 for the pre requisite of asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3

@KUBS_FAT_UAT_005_005_Revaluation
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset undertaking
And get the test data for asset transfer for pre requisite of asset return
Then click on search icon of asset undertaking list view
And search the approved asset undertaking asset reference number in list view
And verify asset reference number should visible in asset undertaking list view
And store the asset reference number and item number of undertaking asset in asset return excel database

@KUBS_FAT_UAT_007_006_01
Scenario: To verify user can able to create asset return record(undertaken asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for assset return which is already done on undertaken
And enter the asset reference number in asset return
And enter the item number in asset return
And click on save button in asset return
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset return event code in notification section
And strore the reference number on asset retrurn record in excel database
And select the asset return record in notification
And click on submit in asset return
And enter the alert remark in asset return
And click on alert submit in asset return
And store the reviewer id in asset return excel data base
@KUBS_FAT_UAT_007_006_02
Scenario: To verify reviewer user can able to approve the asset return record(undertaken asset)
Given navigate to kubs Url to approve the fixed asset return record which is already undertaken in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_006_03
Scenario: To verify checker user can able to approve the asset return record(undertaken asset)
Given navigate to kubs url to approve the fixed asset return record which is already undertaken in checker
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
@KUBS_FAT_UAT_007_006_04
Scenario: To verify approved asset reference number of return record should available in maker list view(undertaken asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for assset return which is already done on undertaken
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available
