Feature: Testing the functionalities of Fixed Asset
@KUBS_FAT_UAT_002_002_01_Allocation
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data
And select the data from Asset category dropdown
And select the data from Asset sub category
And enter the dta in asset item category
And enter the asset description input
Then Click on Fixed Asset Save button
Then validate record got save in maker stage
Then Click on Fixed Asset Notification
And click on notification search in asset category
And search the asset catregory record
And store the reference number of asset category record 
And select the asset category record
And submit the asset category record
And store the reciewer ID in asset category
@KUBS_FAT_UAT_002_002_02_Allocation
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_002_03_Allocation
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
@KUBS_FAT_UAT_002_002_04_Allocation
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration
@KUBS_FAT_UAT_002_003_01_Allocation
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration
And enter the asset code in asset code configuration
And enter the accounting model in asset code configuration
And enter the asset life unit in asset code configuration
And enter the asset life in asset code configuration
And enter the basis for depriciation in asset code configuration
And enter the depriciaton method in asset code configuration 
And enter the depriciation rounding method in asset code configuration
And save the asset code configuration record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset code config module code in notification
And store the asset code reference number in excel file
And select the asset code configuration record 
And click on submit in asset code configuration record
And enter the alert remark in asset code configuration record
And click on alert submit in asset code configuration
Then verify asset code config record got submitted and store the reviewer ID 
@KUBS_FAT_UAT_002_003_02_Allocation
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_003_03_Allocation
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record
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
@KUBS_FAT_UAT_002_003_04_Allocation
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database
@KUBS_FAT_UAT_002_004_01_Allocation
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module
And select the data from the asset code in fixed asset gl configuration
And select the data from the fixed asset Gl in fixed asset gl configuration
And select the data from the accumlated Depreceiation Gl in fixed asset gl configuration
And select the data from the Depreceiation Gl in fixed asset gl configuration
And select the data from the profit on slae Gl in fixed asset gl configuration
And select the data from the Loss on sale Gl in fixed asset gl configuration
And select the data from the Write off Gl in fixed asset gl configuration
And select the data from the impairement loss Gl in fixed asset gl configuration
And select the data from the accumlated impairement loss Gl in fixed asset gl configuration
And select the data from the Revaluation surplus Gl in fixed asset gl configuration
And save the fixed asset gl configuration Gl Record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset gl configuration module code in notification
And store the fixed asset gl configuration record reference number in excel data base and select the record
And click on submit button in fixed asset gl configuration
And enter the alert remark in fixed asset gl configuration
And click on alert submit in fixed asset gl config
Then validate the submit and store the reviewer ID in database in gl config
@KUBS_FAT_UAT_002_004_02_Allocation
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_004_03_Allocation
Scenario: To verify checker user can able to approve the asset ciode gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record
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
@KUBS_FAT_UAT_002_004_04_Allocation
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database

@KUBS_FAT_UAT_002_005_01_Allocation
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database
And select the asset code record which is newly completed asset gl configuration
And enter the asset seria number in asset serail number configuration
And click on save button in asset serial number configuration
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset serail number setup module code in notification
And store the fixed asset gl serail number setup record reference number in excel data base and select the record
And click on submit in asset serail number setup
And enter the alert remark in asset serial number setup
And click on alert submit in serial number setup
Then validate the submit and store the reviewer ID of asset gl setup in excel database
@KUBS_FAT_UAT_002_005_02_Allocation
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_005_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record
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
@KUBS_FAT_UAT_002_005_04_Allocation
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database

@KUBS_FAT_UAT_002_007_01_Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data
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
@KUBS_FAT_UAT_002_007_02_Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker
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
@KUBS_FAT_UAT_002_007_04_Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset impairment excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset impairment excel database
@KUBS_FAT_UAT_009_001_01_Allocation
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database
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
@KUBS_FAT_UAT_009_001_02_Allocation
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record as a checker
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
@KUBS_FAT_UAT_009_001_04_Allocation
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the asset reference number and asset item number in asset allocation excel database
@KUBS_FAT_UAT_006_002_01
Scenario: To verify maker user can able to create the asset allocation record which is already used
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database which the asset is already used
Then Click on the add button to add new record
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
@KUBS_FAT_UAT_006_002_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation which is already used as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_002_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record which is already used asset as a checker
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
@KUBS_FAT_UAT_006_002_04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database which the asset is already used
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
@KUBS_FAT_UAT_002_002_01_Allocation
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data
And select the data from Asset category dropdown
And select the data from Asset sub category
And enter the dta in asset item category
And enter the asset description input
Then Click on Fixed Asset Save button
Then validate record got save in maker stage
Then Click on Fixed Asset Notification
And click on notification search in asset category
And search the asset catregory record
And store the reference number of asset category record 
And select the asset category record
And submit the asset category record
And store the reciewer ID in asset category
@KUBS_FAT_UAT_002_002_02_Allocation
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_002_03_Allocation
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
@KUBS_FAT_UAT_002_002_04_Allocation
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration
@KUBS_FAT_UAT_002_003_01_Allocation
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration
And enter the asset code in asset code configuration
And enter the accounting model in asset code configuration
And enter the asset life unit in asset code configuration
And enter the asset life in asset code configuration
And enter the basis for depriciation in asset code configuration
And enter the depriciaton method in asset code configuration 
And enter the depriciation rounding method in asset code configuration
And save the asset code configuration record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset code config module code in notification
And store the asset code reference number in excel file
And select the asset code configuration record 
And click on submit in asset code configuration record
And enter the alert remark in asset code configuration record
And click on alert submit in asset code configuration
Then verify asset code config record got submitted and store the reviewer ID 
@KUBS_FAT_UAT_002_003_02_Allocation
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_003_03_Allocation
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record
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
@KUBS_FAT_UAT_002_003_04_Allocation
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database
@KUBS_FAT_UAT_002_004_01_Allocation
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module
And select the data from the asset code in fixed asset gl configuration
And select the data from the fixed asset Gl in fixed asset gl configuration
And select the data from the accumlated Depreceiation Gl in fixed asset gl configuration
And select the data from the Depreceiation Gl in fixed asset gl configuration
And select the data from the profit on slae Gl in fixed asset gl configuration
And select the data from the Loss on sale Gl in fixed asset gl configuration
And select the data from the Write off Gl in fixed asset gl configuration
And select the data from the impairement loss Gl in fixed asset gl configuration
And select the data from the accumlated impairement loss Gl in fixed asset gl configuration
And select the data from the Revaluation surplus Gl in fixed asset gl configuration
And save the fixed asset gl configuration Gl Record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset gl configuration module code in notification
And store the fixed asset gl configuration record reference number in excel data base and select the record
And click on submit button in fixed asset gl configuration
And enter the alert remark in fixed asset gl configuration
And click on alert submit in fixed asset gl config
Then validate the submit and store the reviewer ID in database in gl config
@KUBS_FAT_UAT_002_004_02_Allocation
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_004_03_Allocation
Scenario: To verify checker user can able to approve the asset ciode gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record
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
@KUBS_FAT_UAT_002_004_04_Allocation
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database

@KUBS_FAT_UAT_002_005_01_Allocation
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database
And select the asset code record which is newly completed asset gl configuration
And enter the asset seria number in asset serail number configuration
And click on save button in asset serial number configuration
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset serail number setup module code in notification
And store the fixed asset gl serail number setup record reference number in excel data base and select the record
And click on submit in asset serail number setup
And enter the alert remark in asset serial number setup
And click on alert submit in serial number setup
Then validate the submit and store the reviewer ID of asset gl setup in excel database
@KUBS_FAT_UAT_002_005_02_Allocation
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_005_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record
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
@KUBS_FAT_UAT_002_005_04_Allocation
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database

@KUBS_FAT_UAT_002_007_01_Allocation
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data
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
@KUBS_FAT_UAT_002_007_02_Allocation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with full details as a checker
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
@KUBS_FAT_UAT_002_007_04_Allocation
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset impairment excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset impairment excel database
@KUBS_FAT_UAT_009_001_01_Allocation
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database
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
@KUBS_FAT_UAT_009_001_02_Allocation
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record as a checker
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
@KUBS_FAT_UAT_009_001_04_Allocation
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the asset reference number and item number of impaired asset should store in excel database
@KUBS_FAT_UAT_006_003_01
Scenario: To verify maker user can able to create the asset allocation record which is already used
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database which the asset is already impaired
Then Click on the add button to add new record
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
@KUBS_FAT_UAT_006_003_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation which is impaired asset as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_003_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record which is  impaired asset as a checker
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
@KUBS_FAT_UAT_006_003_04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database which the asset is already impaired
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number






#Revaluation Impairment Issue Test case
@KUBS_FAT_UAT_002_007_01_AssetRevaluation
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
@KUBS_FAT_UAT_002_007_02_AssetRevaluation
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for the pre requisite of asset revaluation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03_AssetRevaluation
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
@KUBS_FAT_UAT_002_007_04_AssetRevaluation
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
And store the asset reference number in asset impairment excel database for prerequisite of asset revaluation
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset impairment excel database for prerequisite of asset revaluation

@KUBS_FAT_UAT_009_001_01_Revaluation
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database for the prerequisite of asset revaluation
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
@KUBS_FAT_UAT_009_001_02_Revaluation
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequisite of asset revaluation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03_Revaluation
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record in checker for the prerequisite of asset revaluation
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
@KUBS_FAT_UAT_009_001_04_Revaluation
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database for the prerequisite of asset revaluation
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the asset reference number and item number of impaired asset in assetrevaluation excel database
@KUBS_FAT_UAT_012_004_01
Scenario: To verify maker user can able to create the asset revaluation record(Impaired Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database which is already Impaired
And Add Icon button
And enter the asset reference number in assetrevaluation module
And enter the asset item number in asset revaluation module
Then enter the asset item number and verify asset item number should not available for asset revaluation screen