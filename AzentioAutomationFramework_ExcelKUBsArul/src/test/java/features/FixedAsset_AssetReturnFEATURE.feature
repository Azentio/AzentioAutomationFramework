Feature: To test the asset return module in fixed asset
@KUBS_FAT_UAT_002_002_01_Return
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data for asset return
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
@KUBS_FAT_UAT_002_002_02_Return
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record for asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_002_03_Return
Scenario: To verify checker user can able to approve the asset category record
Given Navigate to KUBS url and login with checker for approve asset category record for asset return
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
@KUBS_FAT_UAT_002_002_04_Return
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data for asset return
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration for asset return
@KUBS_FAT_UAT_002_003_01_Return
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration for asset return
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
@KUBS_FAT_UAT_002_003_02_Return
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record for asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_003_03_Return
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record for asset return
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
@KUBS_FAT_UAT_002_003_04_Return
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration for asset return
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database for asset return
@KUBS_FAT_UAT_002_004_01_Return
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module for asset return
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
@KUBS_FAT_UAT_002_004_02_Return
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record for asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_004_03_Return
Scenario: To verify checker user can able to approve the asset code gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record for asset return
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
@KUBS_FAT_UAT_002_004_04_Return
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset return
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database for asset return
@KUBS_FAT_UAT_002_005_01_Return
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset return
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
@KUBS_FAT_UAT_002_005_02_Return
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record for asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_002_005_03_Return
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset return
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
@KUBS_FAT_UAT_002_005_04_Return
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset return
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database for asset return
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
And store the asset reference number in asset return excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset return excel database
@KUBS_FAT_UAT_007_001_01
Scenario: To verify user can able to create asset return record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for asset return from excel database
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
@KUBS_FAT_UAT_007_001_02
Scenario: To verify reviewer user can able to approve the asset return record
Given navigate to kubs Url to approve the fixed asset return record reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_001_03
Scenario: To verify checker user can able to approve the asset return record
Given navigate to kubs url to approve the fixed asset return record
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
@KUBS_FAT_UAT_007_001_04
Scenario: To verify approved asset reference number of return record should available in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for asset return from excel database
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available

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
And store the asset refeference number in asset revaluation excel database for return revalued asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset revaluation excel database for return revalued asset
@KUBS_FAT_UAT_012_01_AssetReturn
Scenario: To verify maker user can able to create the asset revaluation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset return prerequsite
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
@KUBS_FAT_UAT_012_02_AssetReturn
Scenario: To verify reviewer user can able to approve the asset revaluation record
Given navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for asset return prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_012_03_AssetReturn
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset revaluation record in checker for asset return prerequsite
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
@KUBS_FAT_UAT_012_04_AssetReturn
Scenario: To verify approved asset revaluation record should visisble in revaluation list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset return prerequsite
And click on search icon in revaluation list view
And search the approved revaluation asst reference number
Then verify approved asset reference number of revaluation record should visisble along with item number
And store the asset reference number and item number of revalued asset in return excel database
@KUBS_FAT_UAT_007_002_01
Scenario: To verify user can able to create asset return record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for assset return which is already revalued
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
@KUBS_FAT_UAT_007_002_02
Scenario: To verify reviewer user can able to approve the asset return record
Given navigate to kubs Url to approve the fixed asset return record which is already revalued in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_002_03
Scenario: To verify checker user can able to approve the asset return record
Given navigate to kubs url to approve the fixed asset return record which is already revalued in checker
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
@KUBS_FAT_UAT_007_002_04
Scenario: To verify approved asset reference number of return record should available in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for assset return which is already revalued
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available
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
And store the asset refeference number in asset ammendment excel database for return ammendment asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset ammendment excel database for return ammendment asset
@KUBS_FAT_UAT_011_01_AssetReturn
Scenario: Create an amendment to modify an asset for capitalization date
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for asset return prerequsite
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
@KUBS_FAT_UAT_011_02_AssetReturn
Scenario: To verify reviewer user can able to approve the asset ammendment record
Given navigate to kubs Url to approve the fixed asset Ammendment in reviewer for asset retur prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_011_03_AssetReturn
Scenario: To verify checker user can able to approve the fixed asset Ammendment record
Given navigate to kubs url to approve the fixed asset ammendment record in checker for asset return prerequsite
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
@KUBS_FAT_UAT_011_04_AssetReturn
Scenario: To verify maker can able to see the approved asset reference number of ammendment record in approved list view 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for asset return prerequsite
And click on search button in ammendment list view
And search the asset approved reference number of ammendment record
Then verify approved asset reference number of ammendment record should visible available along with item number
And store the asset reference number and item number of approved ammendment asset in asset return excel database
@KUBS_FAT_UAT_007_003_01
Scenario: Check if the amended asset can be returned to its vendor
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for asset return which is done asset ammendment
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
@KUBS_FAT_UAT_007_003_02
Scenario: To verify reviewer user can able to approve the asset return record which is done asset ammendment
Given navigate to kubs Url to approve the fixed asset return record which is done at asset ammendment in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_003_03
Scenario: To verify checker user can able to approve the asset return record which is done asset ammendment
Given navigate to kubs url to approve the fixed asset return record which is done on asset ammendment in checker
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
@KUBS_FAT_UAT_007_003_04
Scenario: To verify approved asset reference number of return record should available in maker list view(Ammendment asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for asset return which is done asset ammendment
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available
#ImpairedAssetReturn Start
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
And store the asset refeference number in asset impairment excel database for return impairment asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset impairment excel database for return impaired asset
@KUBS_FAT_UAT_009_001_01_AsetReturn
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database for the prerequsite of asset return
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
@KUBS_FAT_UAT_009_001_02_AsetReturn
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequsite of asset return
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03_AsetReturn
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record in checker for the prerequsite of asset return
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
@KUBS_FAT_UAT_009_001_04_AsetReturn
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database for the prerequsite of asset return
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the asset reference number and item number of imapired asset in asset return excel database
@KUBS_FAT_UAT_007_004_01
Scenario: To verify user can able to create asset return record(Impaired asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for assset return which is already impaired
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
@KUBS_FAT_UAT_007_004_02
Scenario: To verify reviewer user can able to approve the asset return record(Impaired asset)
Given navigate to kubs Url to approve the fixed asset return record which is already impaired in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_004_03
Scenario: To verify checker user can able to approve the asset return record(Impaired asset)
Given navigate to kubs url to approve the fixed asset return record which is already impaired in checker
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
@KUBS_FAT_UAT_007_004_04
Scenario: To verify approved asset reference number of return record should available in maker list view(Impaired asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for assset return which is already impaired
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available
#ImpairedAssetReturn End

#Replacment AssetReturn start
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
And store the asset refeference number in asset replacement excel database for return replacement asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset replacement excel database for return replacement asset
@KUBS_FAT_UAT_008_001_01_Return
Scenario: Check the asset for its replacement (any)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database for asset return prerequsite
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
@KUBS_FAT_UAT_008_001_02_Return
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset Replacement record in reviewer for asset return prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_008_001_03_Return
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset replacement record in checker for asset retrurn prerequsite
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
@KUBS_FAT_UAT_008_001_04_Return
Scenario: To verify maker user can able to see the approved replacement item number in list view of asset replacement
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database for asset return prerequsite
And click on search button in replacement list view
And search the approved asset reference number of replacement asset
Then verify approved asset reference number should visible in asset replacement list view along with item number
And store the asset reference and item number of replacement should store in asset return excel database
@KUBS_FAT_UAT_007_005_01
Scenario: To verify user can able to create asset return record(Replacement asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for assset return which is already replacement
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
@KUBS_FAT_UAT_007_005_02
Scenario: To verify reviewer user can able to approve the asset return record(Replacement asset)
Given navigate to kubs Url to approve the fixed asset return record which is already repalced in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_005_03
Scenario: To verify checker user can able to approve the asset return record(Replacement asset)
Given navigate to kubs url to approve the fixed asset return record which is already replaced in checker
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
@KUBS_FAT_UAT_007_005_04
Scenario: To verify approved asset reference number of return record should available in maker list view(Replacement asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for assset return which is already replacement
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available
#Replacment AssetReturn End

#DeAllocated AssetReturn Start
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
And store the asset refeference number in asset allocation excel database for return allocation asset
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset allocation excel database for return allocation asset
@KUBS_FAT_UAT_006_001_01_Return
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocation test data from excel database for asset return prerequsite
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
@KUBS_FAT_UAT_006_001_02_Return
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset return prerequsite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_001_03_Return
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record in checker for asset return prerequsite
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

@KUBS_FAT_UAT_006_001_04_Return
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database for asset return prerequsite
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number asset item number in asset de allocation excel database for asset return prerequsite
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
@KUBS_FAT_UAT_007_006_01
Scenario: To verify user can able to create asset return record(Deallocation asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And click on add button to add new record
And get the test data for assset return which is already deallocated
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
Scenario: To verify reviewer user can able to approve the asset return record(Deallocated asset)
Given navigate to kubs Url to approve the fixed asset return record which is already Deallocated in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_006_03
Scenario: To verify checker user can able to approve the asset return record(Deallocated asset)
Given navigate to kubs url to approve the fixed asset return record which is already deallocated in checker
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
Scenario: To verify approved asset reference number of return record should available in maker list view(Deallocated asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button in asset return
And get the test data for assset return which is already deallocated
And click on search button in list view of asset return module
And search the asset reference number in asset return module
And verify approved asset reference shoudl be available in asset return approved list view
And select the asset return list view record
Then verify approved asset item number of asset return record should be available

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

@KUBS_FAT_UAT_007_007_01
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
@KUBS_FAT_UAT_007_007_02
Scenario: To verify reviewer user can able to approve the asset return record(undertaken asset)
Given navigate to kubs Url to approve the fixed asset return record which is already undertaken in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_007_007_03
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
@KUBS_FAT_UAT_007_007_04
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
