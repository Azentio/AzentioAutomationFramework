Feature: To test the asset impairment module
@KUBS_FAT_UAT_002_002_01
Scenario: Create an asset category(Impairment)
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation for asset impairment
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
Given navigate to kubs url to approve the asset category record for asset impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_002_03
Scenario: To verify checker user can able to approve the asset category record
Given Navigate to KUBS url and login with checker for approve asset category record for asset impairment
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
@KUBS_FAT_UAT_002_002_04
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation for asset impairment
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration in impairment asset code config
@KUBS_FAT_UAT_002_003_01
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration to do impairment
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
@KUBS_FAT_UAT_002_003_02
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record to do impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_003_03
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record to di impairment
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
@KUBS_FAT_UAT_002_003_04
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration to do impairment
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database to do impairment
@KUBS_FAT_UAT_002_004_01
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module to do asset impairment
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
@KUBS_FAT_UAT_002_004_02
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record to do asset impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_004_03
Scenario: To verify checker user can able to approve the asset code gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record to do asset impairment
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
@KUBS_FAT_UAT_002_004_04
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module to do asset impairment
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database to do asset impairment
@KUBS_FAT_UAT_002_005_01
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database to do asset impairment
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
@KUBS_FAT_UAT_002_005_02
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record to do asset impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_005_03
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record to do asset impairment
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
@KUBS_FAT_UAT_002_005_04
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database to do asset impairment
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database
And store the asset code in asset creation excel database to do impairment


@KUBS_FAT_UAT_002_007_01
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation from excel database to do asset impairment
Then Click on the add button to add new record
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
@KUBS_FAT_UAT_002_007_02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer to do impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03
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
@KUBS_FAT_UAT_002_007_04
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
And store the asset reference number in asset impairment excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset impairment excel database

@KUBS_FAT_UAT_009_001_01
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
@KUBS_FAT_UAT_009_001_02
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03
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
@KUBS_FAT_UAT_009_001_04
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
@KUBS_FAT_UAT_002_007_01_Impairment
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation from excel database to do asset impairment
Then Click on the add button to add new record
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
And store the asset reference number it allocation excel database to make impirement of allocated asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number it allocation excel database to make impirement of allocated asset
@KUBS_FAT_UAT_006_001_01_Impairment
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocating test data from excel database for prerequisite of asset impairment
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
@KUBS_FAT_UAT_006_001_02_Impairment
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_001_03_Impairment
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in checker
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
@KUBS_FAT_UAT_006_001_04_Impairment
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocating test data from excel database for prerequisite of asset impairment
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number and item number in impairment excel database for impairment
@KUBS_FAT_UAT_009_002_01
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done one asset allocation
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
@KUBS_FAT_UAT_009_002_02
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record which is already allocated
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_002_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record which is already allocated
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
@KUBS_FAT_UAT_009_002_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done one asset allocation
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
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
And store the asset reference number it allocation excel database to make impirement of allocated asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number it allocation excel database to make impirement of allocated asset
@KUBS_FAT_UAT_006_001_01_Impairment
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocating test data from excel database for prerequisite of asset impairment
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
@KUBS_FAT_UAT_006_001_02_Impairment
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_001_03_Impairment
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in checker
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
@KUBS_FAT_UAT_006_001_04_Impairment
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocating test data from excel database for prerequisite of asset impairment
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number and item number in de allocation for impairment prequesites
@KUBS_FAT_UAT_006_005_01_Impairment
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for prerequsites of impairment asset
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

@KUBS_FAT_UAT_006_005_02_Impairment
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset de Allocation for asset impairmemnt in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_005_03_Impairment
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs Url to approve the fixed asset de Allocation for asset impairmemnt in checker
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
@KUBS_FAT_UAT_006_005_04_Impairment
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for prerequsites of impairment asset
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And store the asset reference number and item number in impairment excel database
@KUBS_FAT_UAT_009_003_01
Scenario: Check the impairement of asset(DeAllocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset de allocation
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
@KUBS_FAT_UAT_009_003_02
Scenario: To verify reviewer user can able to approve the asset impairment record(DeAllocated Asset)
Given navigate to kubs Url to approve the fixed asset impairment record which is already de allocated
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_003_03
Scenario: To verify checker user can able to approve the fixed asset impairment(DeAllocated Asset)
Given navigate to kubs url to approve the fixed asset impairment record which is already de allocated
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
@KUBS_FAT_UAT_009_003_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(DeAllocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset de allocation
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
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
And store the asset reference number in asset revlauation excel database for prerequsite of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset revlauation excel database for prerequsite of asset impairment
@KUBS_FAT_UAT_012_01_AssetImpairment
Scenario: To verify maker user can able to create the asset revaluation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset impairment prerequsite
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
@KUBS_FAT_UAT_012_02_AssetImpairment
Scenario: To verify reviewer user can able to approve the asset revaluation record
Given navigate to kubs Url to approve the fixed asset Revaluation record in a reviewer for impairment asset prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_012_03_AssetImpairment
Scenario: To verify checker user can able to approve the fixed asset revaluation record
Given navigate to kubs url to approve the fixed asset revaluation record in a checker for asset impairment prerequsite
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
@KUBS_FAT_UAT_012_04_AssetImpairment
Scenario: To verify approved asset revaluation record should visisble in revaluation list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset impairment prerequsite
And click on search icon in revaluation list view
And search the approved revaluation asst reference number
Then verify approved asset reference number of revaluation record should visisble along with item number
And store the asset reference number and item number of revalued asset in impairment excel database


@KUBS_FAT_UAT_009_004_01
Scenario: Check the impairement of asset(Revalued Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset revaluation
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
@KUBS_FAT_UAT_009_004_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Revalued Asset)
Given navigate to kubs Url to approve the fixed asset impairment record which is already revalued
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_004_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Revalued Asset)
Given navigate to kubs url to approve the fixed asset impairment record which is already revalued
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
@KUBS_FAT_UAT_009_004_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Revalued Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset revaluation
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
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
And store the asset reference number in asset ammemdment excel database for prerequsite of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset ammendment excel database for prerequsite of asset impairment
@KUBS_FAT_UAT_011_01_Impairment
Scenario: Create an amendment to modify an asset for capitalization date
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for asset impairment prerequsite
And Click on Add Icon
And enter the asset reference number in aset ammendment
And enter the asset item number in asset ammendment
And choose modifcation type as capitalization date
And change the asset capitalizaion date in asset ammendment
And click on save button in asset ammanedment
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset ammendment event code in notification
And store the record reference number of ammendment asset in ammendment excel database
And select the ammendment record from notification
And click on submit in asset ammendment
And enter the alert remark in asset ammendment
And click on alert remark in asset ammendment
And valiadate teh ammendment record submittion and store the reviewer ID in ammendment excel database
@KUBS_FAT_UAT_011_02_Impairment
Scenario: To verify reviewer user can able to approve the asset ammendment record
Given navigate to kubs Url to approve the fixed asset Ammendment in a reviewer for pre requsite of assset impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_011_03_Impairment
Scenario: To verify checker user can able to approve the fixed asset Ammendment record
Given navigate to kubs url to approve the fixed asset ammendment record in a checker for prerequsite of asset impairment
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
@KUBS_FAT_UAT_011_04_Impairment
Scenario: To verify maker can able to see the approved asset reference number of ammendment record in approved list view 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for asset impairment prerequsite
And click on search button in ammendment list view
And search the asset approved reference number of ammendment record
Then verify approved asset reference number of ammendment record should visible available along with item number
And store the asset reference number and item number of ammendment asset in asset impairment excel database
@KUBS_FAT_UAT_009_005_01
Scenario: Check the impairement of asset(Ammendment Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset ammendment
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
@KUBS_FAT_UAT_009_005_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Ammendment Asset)
Given navigate to kubs Url to approve the fixed asset impairment record which is already ammendment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_005_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Ammendment Asset)
Given navigate to kubs url to approve the fixed asset impairment record which is already ammendment
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
@KUBS_FAT_UAT_009_005_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Ammendment Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset ammendment
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
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
And store the asset reference number in asset return excel database for prerequsite of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset return excel database for prerequsite of asset impairment
@KUBS_FAT_UAT_007_001_01_Impairment
Scenario: To verify user can able to create asset return record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for asset return from excel database for asset impairment prerequsite
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
And store the asset reference number and item number of return asset in impairment excel database
@KUBS_FAT_UAT_009_007_01
Scenario: Check the impairement of asset(Replacement Return- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset return maker part
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
@KUBS_FAT_UAT_009_007_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Replacement Asset- Maker done only)
Given navigate to kubs Url to approve the fixed asset impairment record which is already return in maker end
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_007_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Replacement Return- Maker done only)
Given navigate to kubs url to approve the fixed asset impairment record which is already Return in maker end to approve in checker
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
@KUBS_FAT_UAT_009_007_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Replacement Asset- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset return maker part
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
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
And store the asset reference number in asset Sale excel database for prerequsite of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset Sale excel database for prerequsite of asset impairment

@KUBS_FAT_UAT_004_001_01
Scenario: Check if the given asset is sold at higher price
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And click on add button to create sale asset record
And get the test data for asset sale with high price from excel database for asset impairment prerequsite
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
And store the asset reference number and item number of sold asset in impairment excel database

@KUBS_FAT_UAT_009_008_01
Scenario: Check the impairement of asset(Asset Sale- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset Sale maker part
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
@KUBS_FAT_UAT_009_008_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Asset Sale- Maker done only)
Given navigate to kubs Url to approve the fixed asset impairment record which is already Sale in maker end
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_008_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Replacement Return- Maker done only)
Given navigate to kubs url to approve the fixed asset impairment record which is already Sale in maker end to approve in checker
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
@KUBS_FAT_UAT_009_008_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Asset Sale- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset Sale maker part
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_002_007_01
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation from excel database to do asset impairment
Then Click on the add button to add new record
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
@KUBS_FAT_UAT_002_007_02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer to do impairment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_007_03
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
@KUBS_FAT_UAT_002_007_04
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
And store the asset reference number in asset impairment excel database
And store the asset reference number in asset transfer excel database for prerequiste of asset impairment
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset impairment excel database
And store the asset item number in asset transfer excel database for prerequiste of asset impairment
@KUBS_FAT_UAT_005_001
Scenario: To Transfer the asset one branch to another branch(Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer for pre requisite of asset impairment
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
@KUBS_FAT_UAT_009_009_01
Scenario: Check the impairement of asset(Asset Transfer- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database which is already done on asset Transfer maker part
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
@KUBS_FAT_UAT_009_009_02
Scenario: To verify reviewer user can able to approve the asset impairment record(Asset Transfer- Maker done only)
Given navigate to kubs Url to approve the fixed asset impairment record which is already Transfered in maker end
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_009_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Asset Transfer- Maker done only)
Given navigate to kubs url to approve the fixed asset impairment record which is already Transfered in maker end to approve in checker
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
@KUBS_FAT_UAT_009_009_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Asset Transfer- Maker done only)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database which is already done on asset Transfer maker part
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view