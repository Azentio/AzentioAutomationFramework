Feature: Test
@KUBS_FAT_UAT_002_007_01_Impairment
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation from excel database to do asset impairment
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
@KUBS_FAT_UAT_002_007_02_Impairment
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer to do impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03_Impairment
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker to do impairment
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
@KUBS_FAT_UAT_002_007_04_Impairment
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation from excel database to do asset impairment
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset replacement excel database for prerequsite of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset replacement excel database for prerequsite of asset impairment
@KUBS_FAT_UAT_008_001_01_Impairment
Scenario: Check the asset for its replacement (any)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database for asset impairment prerequsite
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
And store the asset reference number and item number of replaced asset in impairment excel database
@KUBS_FAT_UAT_009_006_01
Scenario: Check the impairement of asset(Replacement Asset- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset replacement maker part
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset impairment reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset impairment excel database
@KUBS_FAT_UAT_009_006_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Replacement Asset- Maker done only)
Given navigate to kubs Url to approve the fixed asset impairment record which is already replaced in maker end
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_006_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Replacement Asset- Maker done only)
Given navigate to kubs url to approve the fixed asset impairment record which is already replaced in maker end to approve in checker
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
@KUBS_FAT_UAT_009_006_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Replacement Asset- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset replacement maker part
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view