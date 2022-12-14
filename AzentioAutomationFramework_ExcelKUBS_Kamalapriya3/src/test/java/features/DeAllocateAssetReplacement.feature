Feature: To deallocate the asset replacement record
#AssetReplacement Deallocation Test case
#AssetCreation for replacement
@KUBS_FAT_UAT_006_012_01_AssetReplacement
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for prerequisite of asset revaluation
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
@KUBS_FAT_UAT_006_012_02_AssetReplacement
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for the pre requisite of asset revaluation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_012_03_AssetReplacement
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details in checker fo the pre requiste of asset revaluation
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
@KUBS_FAT_UAT_006_0012_04_AssetReplacement
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for prerequisite of asset revaluation
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset replacement excel data base
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And Store the asset item number in asset replacement excel data base

#Creation of asset replacement for asset deallocation
@KUBS_FAT_UAT_006_012_01__AssetReplacementForDealloaction
Scenario: Check the asset for its replacement (any)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
Then Get the data set id for asset replacement from asset replacement excel data base
And Click Add Icon button
And enter the asset reference number in asset replacement
And enter the asset item number in asset replacement
And enter the new asset item number in asset replacement
And enter the new item description in asset replacement
And save the asset replacement record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset replacement event code in notification
And store the replacement record reference number in replacement excel database
And select the replcement record in notification 
And click on submit in asset replacement
And enter the alert remark in asset replacement
And click on alert submit in asset replacement
And validate the submission on replacement record and store the reviewer ID
@KUBS_FAT_UAT_006_012_02__AssetReplacementForDealloaction
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset Replacement record as a reviewer for deallocation 
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_012_03_AssetReplacementForDealloaction
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset replacement record as a checker for deallocation
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
@KUBS_FAT_UAT_006_012_04_AssetReplacementForDealloaction
Scenario: To verify maker user can able to see the approved replacement item number in list view of asset replacement
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
Then Get the data set id for asset replacement from asset replacement excel data base
And click on search button in replacement list view
And search the approved asset reference number of replacement asset
Then verify approved asset reference number should visible in asset replacement list view along with item number
And store the asset reference and item number of replacement should store in asset allocation excel database

#Prerequest of asset alloction(To de allocate the Asset replacement )
@KUBS_FAT_UAT_006_012_01_AssetReplacementAllocation
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And Get the data set id from asset replacement in asset allocation excel data base
And enter the asset reference number in asset allocation
And enter the asset item number in asset allocation
And enter the employee id in asset allocation
And save the asset allocation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset allocation module code
And store the asset allocation reference number in asset allocation excel data base
And select the asset allocation record
And enter the submit button in asset allocation module
And enter the alert remark in asset allocation module
And click on alert submit in asset allocation module
Then store the reviewer ID in asset allocation  excel database
@KUBS_FAT_UAT_006_012_02_AssetReplacementAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation from asset replacement data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_012_03_AssetReplacementAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation from asset replacement record as a checker
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

@KUBS_FAT_UAT_006_012_04_AssetReplacementAllocation
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And Get the data set id from asset replacement in asset allocation excel data base
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And Store the asset reference number and asset item number of asset replacement allocation in asset deallocation excel data base

@KUBS_FAT_UAT_006_012_01.1_AssetReplacementDeAllocation
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset replacement record in deallocation excel database
Then Click on Fixed Asset Add button
And enter the asset reference number in asset de allocation
And enter the asset item number in asset de allocation 
And save the asset de allocation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset de allocation record in notification
And store the asset de allocation record in asset de allocation excel database
And select the asse de allocation record
And click on submit in asset de allocation 
And enter the alert remark in asset de allocation
And click on alert submit in asset de allocation
And store the reviewer ID of asset de allocation record and store in excel database

@KUBS_FAT_UAT_006_012_02.1_AssetReplacementDeAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the asset replacement record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_012_03.1_AssetReplacementDeAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the asset replacement record to de allocation as a checker
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
@KUBS_FAT_UAT_006_012_04.1_AssetReplacementDeAllocation
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset replacement record in deallocation excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
