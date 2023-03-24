Feature: To test the asset transfer moule

@KUBS_FAT_UAT_002_002_01_Transfer_Undertaking
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data for asset transfer undertaking
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_002_02_Transfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record for asset transfer and undertaking
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_002_03_Transfer_Undertaking
Scenario: To verify checker user can able to approve the asset category record
Given Navigate to KUBS url and login with checker for approve asset category record for asset tranfer and undertaking
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
@KUBS_FAT_UAT_002_002_04_Transfer_Undertaking
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data for asset transfer undertaking
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration for asset transfer and undertaking

@KUBS_FAT_UAT_002_003_01_Transfer_Undertaking
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration for asset transfer and undetaking
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_02_Transfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record for asset transfer and undetaking
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_03_Transfer_Undertaking
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record for asset transfer and undetaking
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
@KUBS_FAT_UAT_002_003_04_Transfer_Undertaking
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration for asset transfer and undetaking
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database for asset transfer and undetaking
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_01_Transfer_Undertaking
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module for asset transfer and undertaking
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_02_Transfer_Undertaking
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record for asset transfer and undertaking
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_03_Transfer_Undertaking
Scenario: To verify checker user can able to approve the asset code gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record for asset transfer and undertaking
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
@KUBS_FAT_UAT_002_004_04_Transfer_Undertaking
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset transfer and undertaking
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database for asset transfer and undertaking
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_005_01_Transfer_Undertaking
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset transfer and undertaking
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_02_Transfer_Undertaking
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record for asset transfer and undertaking
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_03_Transfer_Undertaking
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset transfer and undertaking
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
@KUBS_FAT_UAT_002_005_04_Transfer_Undertaking
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset transfer and undertaking
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database for asset transfer and undertaking
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01_AssetTransfer_Undertaking
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset transfer
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02_AssetTransfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset transfer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_AssetTransfer_Undertaking
Scenario: To verify checker user can able to approve the fixed asset creation with full details record
Given navigate to kubs url to approve the fixed asset creation record with full details in checker for asset transfer
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
@KUBS_FAT_UAT_002_007_04_AssetTransfer_Undertaking
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset transfer
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset transfer undertaking excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset transfer undertaking excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01_AssetTransfer_Undertaking
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset transfer
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02_AssetTransfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset transfer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_AssetTransfer_Undertaking
Scenario: To verify checker user can able to approve the fixed asset creation with full details record
Given navigate to kubs url to approve the fixed asset creation record with full details in checker for asset transfer
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
@KUBS_FAT_UAT_002_007_04_AssetTransfer_Undertaking
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset transfer
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset impairment excel database for the prerequisite of asset transfer
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset impairment excel database for the prerequisite of asset transfer
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01_AssetTransfer_Undertaking
Scenario: Creation of the registered asset with full details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with full details from excel data for asset transfer
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02_AssetTransfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset transfer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_AssetTransfer_Undertaking
Scenario: To verify checker user can able to approve the fixed asset creation with full details record
Given navigate to kubs url to approve the fixed asset creation record with full details in checker for asset transfer
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
@KUBS_FAT_UAT_002_007_04_AssetTransfer_Undertaking
Scenario: To verify maker user can able to see the approved asset reference number in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with full details from excel data for asset transfer
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And store the asset reference number in asset revaluation excel database for the prerequisite of asset transfer
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number in asset revaluation excel database for the prerequisite of asset transfer
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_005_001_01
Scenario: To Transfer the asset one branch to another branch
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer from asset transfer excel database
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_001_02
Scenario: To verify stage 1 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_005_001_03
Scenario: To verify stage 2 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage2
And click on notification in reviewer stage
And select the record in notification
And submit the transfer record in stage 2
And enter the alert remark in stage 2
And click on submit in reviewer alert pop up
And store the stage 3 user id in transfer undertaking excel database


@KUBS_FAT_UAT_005_001_04
Scenario: To verify stage 3 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage3
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3


@KUBS_FAT_UAT_005_001_05
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And get the test data for asset transfer from asset transfer excel database
Then click on search icon of asset transfer list view
And search the approved asset transfer asset reference number in list view
And verify asset reference number should visible in asset transfer list view
And click on user profile in maker
And click on logout button
Then verify user profile got logout


@KUBS_FAT_UAT_009_001_01__AssetTransfer
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database for the prerequisite of asset transfer
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_009_001_02
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset transfer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record in checker for prerequisite of asset transfer
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
And get the test data for impairment asset from excel database for the prerequisite of asset transfer
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the impaired asset reference number and item number in asset transfer exceldatabase
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_002_01
Scenario: To Transfer the asset one branch to another branch(Impaired asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer from asset transfer excel database which is already impaired
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_002_02
Scenario: To verify stage 1 user can able to approve the asset transfer record(Impaired asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already impaired
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_005_002_03
Scenario: To verify stage 2 user can able to approve the asset transfer record(Impaired asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already impaired
And click on notification in reviewer stage
And select the record in notification
And submit the transfer record in stage 2
And enter the alert remark in stage 2
And click on submit in reviewer alert pop up
And store the stage 3 user id in transfer undertaking excel database
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_002_04
Scenario: To verify stage 3 user can able to approve the asset transfer record(Impaired asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already impaired
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_002_05
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view(Impaired Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And get the test data for asset transfer from asset transfer excel database which is already impaired
Then click on search icon of asset transfer list view
And search the approved asset transfer asset reference number in list view
And verify asset reference number should visible in asset transfer list view
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_012_01_AssetTransfer_Undertaking
Scenario: To verify maker user can able to create the asset revaluation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset transfer undertaking prerequisite
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_012_02_AssetTransfer_Undertaking
Scenario: To verify reviewer user can able to approve the asset revaluation record
Given navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for the prerequisite of asset transfer undertaking 
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_012_03_AssetTransfer_Undertaking
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset revaluation record in checker for the prerequisite of asset transfer undertaking
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
@KUBS_FAT_UAT_012_04_AssetTransfer_Undertaking
Scenario: To verify approved asset revaluation record should visisble in revaluation list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for asset transfer undertaking prerequisite
And click on search icon in revaluation list view
And search the approved revaluation asst reference number
Then verify approved asset reference number of revaluation record should visisble along with item number
And store the asset referefnce number and item number of revalued asset in asset transfer undertaking excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_005_003_01
Scenario: To Transfer the asset one branch to another branch(Revalued asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer from asset transfer excel database which is already revalued
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_003_02
Scenario: To verify stage 1 user can able to approve the asset transfer record(Revalued asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already revalued
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_005_002_03
Scenario: To verify stage 2 user can able to approve the asset transfer record(Revalued asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already revalued
And click on notification in reviewer stage
And select the record in notification
And submit the transfer record in stage 2
And enter the alert remark in stage 2
And click on submit in reviewer alert pop up
And store the stage 3 user id in transfer undertaking excel database


@KUBS_FAT_UAT_005_003_04
Scenario: To verify stage 3 user can able to approve the asset transfer record(Revalued asset)
Given navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already revalued
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3

@KUBS_FAT_UAT_005_003_05
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view(Revalued asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And get the test data for asset transfer from asset transfer excel database which is already revalued
Then click on search icon of asset transfer list view
And search the approved asset transfer asset reference number in list view
And verify asset reference number should visible in asset transfer list view
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_013_011
Scenario: Check Asset Transfer
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And get the asset code for asset transfer report
Then click on report button
And click on reports main module
And click on temp view of asset transfer report
And enter the asset code in asset trasfer report
And enter the asset transfer date
And click on view button in loss booking report screen
Then validate the asset reference number of transfered asset should reflect in asset transfer report
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_005_004
Scenario: To verify accounting entries post asset transfer
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset transfer and undertaking
And search the transfer asset code in gl config list view
And get the gl code for transfered asset code 
And get the test data for transfer data gl code and branch code from excel database
And click on report segment button
And click on enquiry main menu
And click on financila transaction sub menu
And enter the branch code in accounting entries for transfered asset accounting entries
And enter the gl code for verify accounting entries for transfered asset accounting entries
And click on view button in accounting entries
Then verify transfered asset Gl should reflect in accounting entries 
And click on user profile in maker
And click on logout button
Then verify user profile got logout

