Feature: To Test the fixed asset Configuration and asset creation
@KUBS_FAT_UAT_002_002_01
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

@KUBS_FAT_UAT_002_002_02
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout

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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_002_04
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_002
Scenario: Check Asset Category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the asset category from asset category approved list view
Then click on report button
And click on master report main module
And click on asset category report temp view
And enter the asset category as on date in report
And click on view button in loss booking report screen
Then verify approved asset category should reflect in asset category report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_01
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout 
@KUBS_FAT_UAT_002_003_02
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_03
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_04
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_003
Scenario:  Check Asset Codes report
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the asset code for report
And get the asset depriciation method for report
Then click on report button
And click on master report main module
And click on temp view of asset code report 
And enter the asset depriciation method in asset code report
And enter the asset code as on date in asset code report
And click on view button in loss booking report screen
Then validate the asset code should reflect in asset code report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_01
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_02
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_03
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
@KUBS_FAT_UAT_002_004_04
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_005
Scenario: Check Asset GL (report)
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the approved asset code for asset gl report
Then click on report button
And click on master report main module
And click on asset gl report temp view
And enter the asset code for asset gl report
And enter the asset gl as on date in asset gl report
And click on view button in loss booking report screen
Then validate the approved asset code should reflect in asset gl report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_01
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_02
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_03
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_04
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_006 
Scenario: Check Asset Serial Number
And User get the test data for check assert serial number 
Given User should go to the kubs url and login as a maker user
And User click the fixed assert config button
Then Click on Asset Serial Num Creation Eye button
And User get the assert code in fixed assert config
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset serial number 
And User enter the assert code
And User enter the start assert serial number
And User select the date in assert report 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_006_01
Scenario: Creation of registered asset with minimum details
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with minimum details from excel data
And select the branch code in asset creation module
And select the asset code in asset creation module
And select the bill reference number in asset creation module 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset creation module code in notification
And store the fixed asset creation with minimum details reference number in excel data base and select the record
And click on submit in fixed asset creation with minimum details
And enter the alert remark in fixed asset creation with minimum details
And click on alert submit in fixed asset creation with minimum details
Then validate the submit and store the reviewer ID of fixed asset creation with minimum details in excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_006_02
Scenario: To verify reviewer user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with minimum details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_006_03
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset creation record with minimum details as a checker
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_006_04
Scenario: To verify asset creation record should reflect in asset creation approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with minimum details from excel data
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_008_01
Scenario: To verify user can able to create the asset with GRN number
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
And get the test data for asset creation with GRN number from excel database
And select the branch code in asset creation module
And select the asset code in asset creation module
And enter the GRN number in asset creation screen 
And save the asset creation record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And Select the asset creation recod in notification
And click on contract linkage tab
And enter the po number in contract linkage screen
And save the contract linkage screen
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
@KUBS_FAT_UAT_002_008_02
Scenario: To verify reviewer user can able to approve the fixed asset creation with GRN number
Given navigate to kubs url to approve the fixed asset creation record with GRN number
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_008_03
Scenario: To verify checker user can able to approve the fixed asset creation with GRN number
Given navigate to kubs url to approve the fixed asset creation record with GRN number as a checker
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_008_04
Scenario: To verify asset creation record should reflect in asset creation approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the test data for asset creation with GRN number from excel database
And click on search button in asset creation module
And search the asset code in asset creation module
Then verify approved asset creation record is visible under asset creation list view
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_007
Scenario: Check Asset Creation (Common)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset branch for asset creation common report
And store the asset code and seet reference number for asset creation report
And seelect the asset creation approved record in list view
And store the asset life in for asset creation report validation
Then click on report button
And click on reports main module
And click on asset creation common roport temp view
And enter the asset life unit in asset creation common report
And enter the asset date in asset creation common report
And click on view button in loss booking report screen
Then verify asset reference number and code should reflect in asset code common report 
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01
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
@KUBS_FAT_UAT_002_007_02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04
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
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_008
Scenario: Check Asset Creation (Item Wise) 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset code and seet reference number for asset creation report
And seelect the asset creation approved record in list view
And click on asset Item tab in asset creation
And click on asset Item tab in asset creation
And select the item record in list view of item details
And store the capitalization date and created date for asset creation report
Then click on report button
And click on reports main module
And click on asset creation item report temp view
And give the capitalization date in asset creation item wise report
And give the asset creation as on date in asset creation item wise report
And click on view button in loss booking report screen
Then verify approved asset reference number should reflect in asset item report
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_013_004
Scenario:  Check Depreciation 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset branch for asset creation common report
And store the asset code and seet reference number for asset creation report
And seelect the asset creation approved record in list view
And store the asset life in for asset creation report validation
And click on asset Item tab in asset creation
And click on asset Item tab in asset creation
And select the item record in list view of item details
And store the capitalization date and created date for asset creation report
And click on configuration section
Then Click on Fixed assets configuration
And click on fixed asset branch level depriciation list view
And click on search button in branch level depriciation list view
And search the branch level for geting the depriciation period
Then click on report button
And click on reports main module
And click on temp view of depriciation report temp view
And enter the branch in depriciation report
And give the date in depriciation report
And enter the depriciation period in depriciation report
And click on view button in loss booking report screen
Then validate the asset reference number should reflect in asset depriciation report 
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_001
Scenario: Check Asset Limit Config
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset branch for asset creation common report
And store the asset code and seet reference number for asset creation report
And seelect the asset creation approved record in list view
And store the asset life in for asset creation report validation
And click on asset Item tab in asset creation
And click on asset Item tab in asset creation
And select the item record in list view of item details
And store the capitalization date and created date for asset creation report
Then click on report button
And click on master report main module
And click on temp view of asset limit report
And enter the accounting standard in asset limit report
And enter the limit as on date in asset limit report
And click on view button in loss booking report screen
Then verify asset limit report should generate
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01_AssetSale01
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
@KUBS_FAT_UAT_002_007_02_AssetSale02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_AssetSale03
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04_AssetSale04
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
And store the asset reference number for asset sale in excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number number for asset sale in excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_004_001_01
Scenario: Check if the given asset is sold at higher price
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And click on add button to create sale asset record
And get the test data for asset sale with high price from excel database
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
@KUBS_FAT_UAT_004_001_02
Scenario: To verify reviewer user can able to approve the asset sale record which is sold at high price
Given navigate to kubs Url to approve the fixed asset sale record which is sold at high price as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_03
Scenario: To verify checker user can able to approve the fixed asset sale record which is sold at high price
Given navigate to kubs url to approve the fixed asset sale record whcih is sold at high price as a checker
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_001_04
Scenario: To verify maker user can able to see the approved asset sale record which is sold at high price in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And get the test data for asset sale with high price from excel database
Then verify maker user can able to see the approved asset sale record which is sold at high price in maker list view
Then verify approved Asset item number is available in approved asset sale record
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_002
Scenario: Check the accounting Entries (Sold at high price)
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset sold accounting entries
And click on search button ion gl list view
And search the asset code in gl list view
Then store the gl code for verify accounnt entries
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch as azentio main in accounting entries screen
And enter the accounting gl in accounting entries screen
And click on view button in accounting entries screen
Then verify the sold at high price asset gl code should populate in accounting entries screen
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_013
Scenario: Check Asset Sale
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And get the asset code and asset reference number of sold asset for sale 
Then click on report button
And click on reports main module
And click on temp view of asset sale report
And enter the asset sale asset code in report
And give the asset sale date in asset sale report
And click on view button in loss booking report screen
Then validate the sold asset reference number should reflect in asset sale report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
 @KUBS_FAT_UAT_002_007_01_AssetSale05
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
@KUBS_FAT_UAT_002_007_02_AssetSale06
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_AssetSale07
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04_AssetSale08
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
And store the asset reference number for asset sale in excel database for asset sale at low price
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section
And store the asset item number number for asset sale in excel database for asset sale at low price
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_003_01
Scenario: Check if the given asset is sold (lower price) 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And click on add button to create sale asset record
And get the test data for asset sale with low price from excel database
And enter the asset reference number in asset sale
And enter the asset item number in asset sale module
And enter the asset sale value which is sold in low price
And choose the actionable by in asset sale module
And and enter the remark in asset sale module
And save the asset sale value record
Then validate record got save in maker stage 
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset sale module code in notification
And store the asset sale reference number which is sold at low price
And select the asset sale value record 
And click on submit button in asset sale module
And enter the alert remark in asset sale record 
And click on alet submit button in asset sale module
And store the reviewer id in asset sale module excel database  which is sold at low price
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_003_02
Scenario: To verify reviewer user can able to approve the asset sale record which is sold at low price
Given navigate to kubs Url to approve the fixed asset sale record which is sold at low price as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_003_03
Scenario: To verify checker user can able to approve the asset sale record which is sold at low price
Given navigate to kubs url to approve the fixed asset sale record whcih is sold at low price as a checker
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_003_04
Scenario: To verify maker user can able to see the approved asset sale record which is sold at low price in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset sale
And get the test data for asset sale with low price from excel database
Then verify maker user can able to see the approved asset sale record which is sold at high price in maker list view
Then verify approved Asset item number is available in approved asset sale record
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_004
Scenario: Check the accounting Entries (Sold at Low price)
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset sold accounting entries
And click on search button ion gl list view
And search the asset code in gl list view
Then store the gl code for verify accounnt entries
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch as azentio main in accounting entries screen
And enter the accounting gl in accounting entries screen
And click on view button in accounting entries screen
Then verify the sold at high price asset gl code should populate in accounting entries screen
And click on user profile in checker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01_Replacement01
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_02_Replacement02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_03_Replacement03
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_04_Replacement04
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
And store the asset reference number in asset replacement excel database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset replacement excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_008_001_01
Scenario: Check the asset for its replacement (any)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database
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
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_008_001_02
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset Replacement record as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile in reviewer
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_008_001_03
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset replacement record as a checker
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
And click on user profile in checker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_008_001_04
Scenario: To verify maker user can able to see the approved replacement item number in list view of asset replacement
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database
And click on search button in replacement list view
And search the approved asset reference number of replacement asset
Then verify approved asset reference number should visible in asset replacement list view along with item number
And store the asset reference and item number of replacement should store in asset return excel database
And click on user profile in maker
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_013_017
Scenario: Check Asset replacement
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And store the approved replacement reference number
And store the replacement record created date
And store the item number of replaced asset
And select the approved replacement record from replacement list view
And store the approved replacement asset code
Then click on report button
And click on transactional reports module
And click on replacement report temp view
And enter the asset code in replacement report
And enter the replacement asset item number in report
And give the the replacement created date in report
And click on view button in loss booking report screen
Then verify the replaced asset referene number should avaiable in repacement report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_004_005
Scenario: Check the Tax/GST on asset sale accordingly
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset sold accounting entries
And click on search button ion gl list view
And search the asset code in gl list view
Then store the gl code for verify accounnt entries
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch as azentio main in accounting entries screen
And enter the accounting gl in accounting entries screen
And click on view button in accounting entries screen
Then verify the sold at high price asset gl code should populate in accounting entries screen
And click on user profile in checker
And click on logout button
Then verify user profile got logout