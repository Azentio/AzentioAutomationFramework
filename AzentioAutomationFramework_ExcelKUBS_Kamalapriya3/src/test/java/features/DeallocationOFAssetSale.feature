Feature: Test
@KUBS_FAT_UAT_002_002_01
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data for asset Allocation1
And select the data from Asset category dropdown
And select the data from Asset sub category
And enter the dta in asset item category
And enter the asset description input
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification
And click on notification search in asset category
And search the asset catregory record
And store the reference number of asset category record 
And select the asset category record
And submit the asset category record
And store the reciewer ID in asset category
@KUBS_FAT_UAT_002_002_02
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_002_03
Scenario: To verify checker user can able to approve the asset category record
Given Navigate to KUBS url and login with checker for approve asset category record
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
@KUBS_FAT_UAT_002_007_01Allocation(De-AllocationPreRequest1)
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset allocation prerequest for asset deallocation1
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
@KUBS_FAT_UAT_002_007_02Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record for asset allocation prerequest for asset deallocation1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record as a checker for asset allocation prerequest for asset deallocation1
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
@KUBS_FAT_UAT_002_007_04Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset allocation prerequest for asset deallocation1
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset Reference number in asset allocation excel Database prerequest for asset deallocation1
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset allocation excel Database prerequest for asset deallocation1 
@KUBS_FAT_UAT_006_005_01_Return
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for asset return prerequsite
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

@KUBS_FAT_UAT_006_005_02_Return
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset de Allocation as a reviewer in asset return prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_005_03_Return
Scenario: To verify checker user can able to approve the fixed asset de allocation record
Given navigate to kubs url to approve the fixed asset de allocation record in checker for asset return prerequsite
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
@KUBS_FAT_UAT_006_005_04_Return
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for asset return prerequsite
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And store the asset reference number and item number of deallocated asset in asset return excel database