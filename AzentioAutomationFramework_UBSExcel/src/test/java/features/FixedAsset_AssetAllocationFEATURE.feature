Feature: To Test the asset allocation module
@KUBS_FAT_UAT_002_002_01Allocation
Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
And get the test data for asset catogory creation Test Data for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_002_02Allocation
Scenario: To verify reviewer user can able to approve the asset category record
Given navigate to kubs url to approve the asset category record for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_002_03Allocation
Scenario: To verify checker user can able to approve the asset category record
Given Navigate to KUBS url and login with checker for approve asset category record for asset allocation
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
@KUBS_FAT_UAT_002_002_04Allocation
Scenario: To verify approved asset category record should visible in asset category list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the test data for asset catogory creation Test Data for asset allocation
Then verify newly created asset category is refelected in list view
And store the asset code for asset code configuration for asset allocation
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_01Allocation
Scenario: Configure the asset category for asset code creation 
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
And get the test data for asset code configuration for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_02Allocation
Scenario: To verify reviewer user can able to approve the asset code configuration record
Given navigate to kubs url to approve the asset code configuration record for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_003_03Allocation
Scenario: To verify checker user can able to approve the asset code configuration record
Given Navigate to KUBS url and login with checker for approve asset code configuration record for asset allocation
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
@KUBS_FAT_UAT_002_003_04Allocation
Scenario: To verify approved asset code config record should available in maker list viewe
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset code configuration Eye button
And get the test data for asset code configuration for asset allocation
Then verify approved asset code appear in aset code config list view
And store the asset code in asset gl Configuration database for asset allocation
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_01Allocation
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
And get the testData for fixed asset gl configuration module for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_02Allocation
Scenario: To verify reviewer user can able to approve the  asset code gl configuration
Given navigate to kubs url to approve the asset GL configuration record for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_004_03Allocation
Scenario: To verify checker user can able to approve the asset code gl configuration
Given Navigate to KUBS url and login with checker for approve asset gl configuration record for asset allocation
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
@KUBS_FAT_UAT_002_004_04Allocation
Scenario: To verify approved asset gl configuration record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
And get the testData for fixed asset gl configuration module for asset allocation
Then verify approved asset reference number is reflected in gl config list view
And store the asset reference number in gl serial number config excel database for asset allocation
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_005_01Allocation
Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset allocation
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_02Allocation
Scenario: To verify reviewer user can able to approve the fixed asset serial number setup record
Given navigate to kubs url to approve the fixed asset serial number setup record for asset allocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_005_03Allocation
Scenario: To verify checker user can able to approve the fixed asset serial number setup record
Given Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset allocation
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
@KUBS_FAT_UAT_002_005_04Allocation
Scenario: To verify approved serial number record should visible in maker list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration
Then Click on Asset Serial Num Creation Eye button
And get the test data for asset serial number setup from excel database for asset allocation
Then verify approved serial number record should reflect the approved list view
And store the asset code in asset creation excel database for asset allocation 
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_002_007_01Allocation01
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
@KUBS_FAT_UAT_002_007_02Allocation02
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
@KUBS_FAT_UAT_002_007_03Allocation03
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
@KUBS_FAT_UAT_002_007_04_DeAllocation04
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
And store the asset Reference number in asset allocation excel Database
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And store the asset item number in asset allocation excel Database
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_01
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocation test data from excel database
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
@KUBS_FAT_UAT_006_001_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_001_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record as a checker
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
@KUBS_FAT_UAT_006_001_04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number asset item number in asset de allocation excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_014
Scenario: Check Asset Allocation
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And open the list view record which is appeared in asset allocation record
And store the asset item number and asset referece number and allocated date for report validation
Then click on report button
And click on transactional reports module
And click on asset allocation report temp view
And enter the employee name in report
And enter the asset item number in report
And enter the asset allocated date in alocation report
And click on view button in loss booking report screen
Then validate the asset reference number should reflect in the allocation report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_005_01Prereq
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database
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
@KUBS_FAT_UAT_006_005_02Prereq
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_005_03Prereq
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset de allocation record as a checker
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
@KUBS_FAT_UAT_006_005_04Prereq
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_013_015
Scenario: Check Asset De Allocation
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And store the de allocation created date for de allocation report
And open the list view record in de allocation list view
And store the asset item number and asset referece number and de allocated date for de allocation report validation
Then click on report button
And click on transactional reports module
And click on temp view of de allocation report temp view
And enter the employee in de allocation report form
And enter the de allocation date in de allocation report form
And enter the de allocation as on date in de allocation report form
And click on view button in loss booking report screen
Then validate the de allocated asset should reflect in de allocation report
And click on user profile in maker
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_005_01
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocation test data from excel database
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
@KUBS_FAT_UAT_006_005_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_005_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record as a checker
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
@KUBS_FAT_UAT_006_005_04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number asset item number in asset de allocation excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout


@KUBS_FAT_UAT_002_007_01Allocation05
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
@KUBS_FAT_UAT_002_007_02Allocation06
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
@KUBS_FAT_UAT_002_007_03Allocation07
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
@KUBS_FAT_UAT_002_007_04Allocation08
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
And store the asset reference number in asset ammenment excel data base
And select the approved asset reference number record
And click on asset Item tab in asset creation
Then verify asset item number is visible under the asset item details section  
And Store the asset item number in asset ammenment excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
#AssetAmmenmentCreation
@KUBS_FAT_UAT_011_01_Allocation
Scenario: Create an amendment to modify an asset for capitalization date
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database to deallocate
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_011_02_Allocation
Scenario: To verify reviewer user can able to approve the asset ammendment record
Given navigate to kubs Url to approve the fixed asset Ammendment as a reviewer for deallocation
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_011_03_Allocation
Scenario: To verify checker user can able to approve the fixed asset Ammendment record
Given navigate to kubs url to approve the fixed asset ammendment record as a checker for deallocation
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
@KUBS_FAT_UAT_011_04_Allocation
Scenario: To verify maker can able to see the approved asset reference number of ammendment record in approved list view 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database to deallocate
And click on search button in ammendment list view
And search the asset approved reference number of ammendment record
Then verify approved asset reference number of ammendment record should visible available along with item number
Then Store the asset reference number and asset item number of asset ammenment in asset allocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_002_01
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And Get the data set id from asset ammenment in asset allocation excel data base
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
@KUBS_FAT_UAT_006_002_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation from asset ammenment data as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_002_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation from asset ammenment record as a checker
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
@KUBS_FAT_UAT_006_002_04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And Get the data set id from asset ammenment in asset allocation excel data base
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And Store the asset reference number and asset item number of asset ammenment allocation in asset deallocation excel data base
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_006_011_01
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset ammenment record in deallocation excel database
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
@KUBS_FAT_UAT_006_011_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the asset ammenment record to de Allocation as a reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_006_011_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the asset ammenment record to de allocation as a checker
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
@KUBS_FAT_UAT_006_011_04
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And Get the data set id for asset deallocation of asset ammenment record in deallocation excel database
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01Allocation09
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
@KUBS_FAT_UAT_002_007_02Allocation10
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
@KUBS_FAT_UAT_002_007_03Allocation11
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
@KUBS_FAT_UAT_002_007_04Allocation12
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


@KUBS_FAT_UAT_006_004_01_PreReq
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
@KUBS_FAT_UAT_006_004_02_PreReq 
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
@KUBS_FAT_UAT_006_004_03_PreReq
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
@KUBS_FAT_UAT_006_004_04_PreReq
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
@KUBS_FAT_UAT_006_004_01
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
@KUBS_FAT_UAT_006_004_02
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
@KUBS_FAT_UAT_006_004_03
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
@KUBS_FAT_UAT_006_004_04
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
@KUBS_FAT_UAT_006_010_01
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
@KUBS_FAT_UAT_006_010_02
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
@KUBS_FAT_UAT_006_010_03
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
@KUBS_FAT_UAT_006_010_04
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


#To Deallocate the asset ammenment record



#TransferEnd

@KUBS_FAT_UAT_002_007_01Allocation13
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
@KUBS_FAT_UAT_002_007_02Allocation14
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
@KUBS_FAT_UAT_002_007_03Allocation15
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
@KUBS_FAT_UAT_002_007_04Allocation16
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
And Get the data set id from asset sale in asset allocation excel data base
Then verify asset reference number or item number is not reflected in asset allocation screen
And click on user profile icon
And click on logout button
Then verify user profile got logout

@KUBS_FAT_UAT_002_007_01Allocation17
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
@KUBS_FAT_UAT_002_007_02Allocation18
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
@KUBS_FAT_UAT_002_007_03Allocation19
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
@KUBS_FAT_UAT_002_007_04Allocation20
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
@KUBS_FAT_UAT_006_012_01
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
@KUBS_FAT_UAT_006_012_02
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
@KUBS_FAT_UAT_006_012_03
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
@KUBS_FAT_UAT_006_012_04
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

@KUBS_FAT_UAT_002_007_01Allocation21
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
@KUBS_FAT_UAT_002_007_02Allocation22
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
@KUBS_FAT_UAT_002_007_03Allocation23
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
@KUBS_FAT_UAT_002_007_04Allocation24
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