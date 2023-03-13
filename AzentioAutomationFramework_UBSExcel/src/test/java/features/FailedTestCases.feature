Feature: To Test the failed test cases
@KUBS_FAT_UAT_002_007_01Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset allocation
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset revaluation excel data base
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And Store the asset item number in asset revaluation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout


@KUBS_FAT_UAT_006_010_01_AssetRevaluation
Scenario: To verify maker user can able to create the asset revaluation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And Get the data set id for for asset revalation creation from asset revaluation excel database
And Add Icon button
And enter the asset reference number in assetrevaluation module
And enter the asset item number in asset revaluation module
And alter the book value of the given asset in asste revaluation module
And save the asset revaluation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset revaluation module code in notification
And store the record reference number in asset revaluation excel database
And select the asset revlaution record in notification
And click on submit in asset revaluation
And enter the alert ramark in asset revlaution
And click on alert submit in asset revaluation
And store the reviewer ID of asset revaluation record in excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_02_AssetRevaluation 
Scenario: To verify reviewer user can able to approve the asset revaluation record(Replacment Asset)
Given navigate to kubs Url to approve the fixed asset Revaluation record in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_03_AssetRevaluation
Scenario: To verify checker user can able to approve the asset revaluation record
Given navigate to kubs url to approve the fixed asset revaluation record in checker 
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_04_AssetRevaluation
Scenario: To verify approved asset revaluation record should visisble in revaluation list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And Get the data set id for for asset revalation creation from asset revaluation excel database
And click on search icon in revaluation list view
And search the approved revaluation asst reference number
Then store the asset reference number and asset item number of asset revaluation record to asset allocation excel data base for the pre requisite of asset deallocation
And click on user profile icon
And click on logout button
Then verify user profile got logout
#Prerequest of asset alloction(To de allocate the Asset revaluation )
@KUBS_FAT_UAT_006_001_01_AssetRevaluationAllocation
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And Get the data set id from asset revalaution in asset allocation excel data base
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_02_AssetRevaluationAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation from asset revaluation data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_03_AssetRevaluationAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation from asset revalauation record as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_04_AssetRevaluationAllocation
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And Get the data set id from asset revalaution in asset allocation excel data base
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And Store the asset reference number and asset item number of asset revaluation allocation in asset deallocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_01.1_AssetRevaluationDeAllocation
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset revaluation record in deallocation excel database
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_02.1_AssetRevaluationDeAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the asset revaluation record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_03.1_AssetRevaluationDeAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the asset revaluation record to de allocation as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_010_04.1_AssetRevaluationDeAllocation
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset revaluation record in deallocation excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset allocation
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in excel database for prerequisite of asset sale
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in excel database for prerequisite of asset sale
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_01_AssetSaleCreation
Scenario: Creation of asset sale
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And click on add button to create sale asset record
And get the test data for asset sale with high price from excel database for pre requiste of asset de allocation
And enter the asset reference number in asset sale
And enter the asset item number in asset sale module
And enter the asset sale value which is sold in high price
And choose the actionable by in asset sale module
And and enter the remark in asset sale module
And save the asset sale value record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset sale module code in notification
And store the asset sale reference number which is sold at high price
And select the asset sale value record 
And click on submit button in asset sale module
And enter the alert remark in asset sale record 
And click on alet submit button in asset sale module
And store the reviewer id in asset sale module excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_02AssetSaleCreation
Scenario: To verify reviewer user can able to approve the asset sale record which is sold at high price
Given navigate to kubs Url to approve the fixed asset sale record as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_03AssetSaleCreation
Scenario: To verify checker user can able to approve the fixed asset sale record which is sold at high price
Given navigate to kubs url to approve the fixed asset sale record as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_04AssetSaleCreation
Scenario: To verify maker user can able to see the approved asset sale record which is sold at high price in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And get the test data for asset sale with high price from excel database for pre requiste of asset de allocation
Then verify maker user can able to see the approved asset sale record which is sold at high price in maker list view
Then verify approved Asset item number is available in approved asset sale record
And Store the asset reference number and asset item number of asset sale in asset allocation excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout
#AssetSale Allocation
@KUBS_FAT_UAT_006_001_01_AssetSaleAllocation
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
#And get the asset allocation test data from excel database
And Get the data set id from asset sale in asset allocation excel data base
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_02_DeAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
#Given navigate to kubs Url to approve the fixed asset Allocation as a reviewer
Given navigate to kubs Url to approve the fixed asset Allocation from asset sale data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_03_DeAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
#Given navigate to kubs url to approve the fixed asset allocation record as a checker
Given navigate to kubs url to approve the fixed asset allocation from asset sale record as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_04_DeAllocation
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
#And get the asset allocation test data from excel database
And Get the data set id from asset sale in asset allocation excel data base
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
#And store the asset reference number asset item number in asset de allocation excel database
And Store the asset reference number and asset item number of asset sale allocation in asset deallocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_008_01
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
#And get the asset de allocation test data from excel database
And Get the data set id for asset deallocation of asset sale record in deallocation excel database
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_008_02
Scenario: To verify reviewer user can able to approve the asset allocation record
#Given navigate to kubs Url to approve the fixed asset de Allocation as a reviewer
Given navigate to kubs Url to approve the asset sale record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_008_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
#Given navigate to kubs url to approve the fixed asset de allocation record as a checker
Given navigate to kubs url to approve the asset sale record to de allocation as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_008_04
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
#And get the asset de allocation test data from excel database
And Get the data set id for asset deallocation of asset sale record in deallocation excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
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
And click on user profile icon
And click on logout button
Then verify user profile got logout

#AssetCreation for transfer
@KUBS_FAT_UAT_002_007_01Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset allocation
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset Transfer excel data base
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And Store the asset item number in asset transfer excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
#AssetTransferCreation
@KUBS_FAT_UAT_006_012_01_AssetTranferCreation
Scenario: To Transfer the asset one branch to another branch
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And Choose the data set id for the creation of asset tranfer from asset transfer excel data base
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
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_006_012_02_AssetTranferCreation
Scenario: To verify stage 1 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage1 prerequest for deallocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_03_assetTransferCreation
Scenario: To verify stage 2 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage2 prerequest for deallocation
And click on notification in reviewer stage
And select the record in notification
And submit the transfer record in stage 2
And enter the alert remark in stage 2
And click on submit in reviewer alert pop up
And store the stage 3 user id in transfer undertaking excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_006_012_04_AssetTranferCreation
Scenario: To verify stage 3 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage3 prerequest for deallocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_05_AssetTranferCreation
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And Choose the data set id for the creation of asset tranfer from asset transfer excel data base
Then click on search icon of asset transfer list view
And search the approved asset transfer asset reference number in list view
And verify asset reference number should visible in asset transfer list view
And Store the asset reference number and item number of asset transfer in asset alllocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
#Prerequest of asset alloction(To de allocate the Asset Transfer )
@KUBS_FAT_UAT_006_012_01_AssetTransferAllocation
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And Get the data set id from asset transfer in asset allocation excel data base
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_02_AssetTransferAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation from asset transfer data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_03_AssetTransferAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation from asset transfer record as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_04_AssetTransferAllocation
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And Get the data set id from asset transfer in asset allocation excel data base
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And Store the asset reference number and asset item number of asset transfer allocation in asset deallocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout


@KUBS_FAT_UAT_006_012_01.1_AssetTransferDeAllocation
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset transfer record in deallocation excel database
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_02.1_AssetTransferDeAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the asset transfer record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_03.1_AssetTransferDeAllocation
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the asset transfer record to de allocation as a checker
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_04.1_AssetTransferDeAllocation
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset transfer record in deallocation excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset allocation
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset replacement excel data base
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And Store the asset item number in asset replacement excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_02__AssetReplacementForDealloaction
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset Replacement record as a reviewer for deallocation 
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_02_AssetReplacementAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation from asset replacement data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_012_02.1_AssetReplacementDeAllocation
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the asset replacement record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
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
And click on user profile icon
And click on logout button
Then verify user profile got logout