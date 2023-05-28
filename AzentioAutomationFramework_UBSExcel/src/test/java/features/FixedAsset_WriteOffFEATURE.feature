Feature: To test the fixed asset write off scenario
@KUBS_FAT_UAT_010_001_01
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_001_02
Scenario: To verify reviewer user can able to approve the asset write off record
Given navigate to kubs Url to approve the fixed asset write off record in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_001_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset write off record in checker
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
@KUBS_FAT_UAT_010_001_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_012_01_WriteOff
Scenario: To verify maker user can able to create the asset revaluation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for the prerequsite of asset writeoff
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
@KUBS_FAT_UAT_012_02_WriteOff
Scenario: To verify reviewer user can able to approve the asset revaluation record
Given navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for prerequisite of asset write off
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_012_03_WriteOff
Scenario: To verify checker user can able to approve the asset revaluation record
Given navigate to kubs url to approve the fixed asset revaluation record in checker for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_012_04_WriteOff
Scenario: To verify approved asset revaluation record should visisble in revaluation list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Asset Revaluvation submodule Eye Icon
And get the test data for asset revaluation test data from excel database for the prerequsite of asset writeoff
And click on search icon in revaluation list view
And search the approved revaluation asst reference number
Then verify approved asset reference number of revaluation record should visisble along with item number
And store the asset reference number and item number of revalued asset in asset write off excel database




@KUBS_FAT_UAT_010_003_01
Scenario: Check the write off of asset(Revalued)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already revalued
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_003_02
Scenario: To verify reviewer user can able to approve the asset write off record
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already revlaued
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_003_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset write off record in checker which is already revalued
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
@KUBS_FAT_UAT_010_003_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already revalued
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_011_01_WriteOff
Scenario: Create an amendment to modify an asset for capitalization date
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_011_02_WriteOff
Scenario: To verify reviewer user can able to approve the asset ammendment record
Given navigate to kubs Url to approve the fixed asset Ammendment in reviewer for prerequisite of asset writeoff
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_011_03_WriteOff
Scenario: To verify checker user can able to approve the fixed asset Ammendment record
Given navigate to kubs url to approve the fixed asset ammendment record in checker for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_011_04_WriteOff
Scenario: To verify maker can able to see the approved asset reference number of ammendment record in approved list view 
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Ammendent submodule Eye Icon
And get the test data for asset ammendment from ammendment excel database for prerequisite of asset writeoff
And click on search button in ammendment list view
And search the asset approved reference number of ammendment record
Then verify approved asset reference number of ammendment record should visible available along with item number
And store the asset reference number and item number of ammendment asset in asset writeoff excel database

@KUBS_FAT_UAT_010_004_01
Scenario: Check the write off of asset(ammendment)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already ammendment
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_004_02
Scenario: To verify reviewer user can able to approve the asset write off record
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already ammendment
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_004_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset write off record in checker which is already ammendment
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
@KUBS_FAT_UAT_010_004_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already ammendment
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_009_001_01_WriteOff
Scenario: Check the impairement of asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon
And get the test data for impairment asset from excel database for the pre requisite of asset write off
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
@KUBS_FAT_UAT_009_001_02_WriteOff
Scenario: To verify reviewer user can able to approve the asset impairment record
Given navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset write off
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_009_001_03_WriteOff
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the fixed asset impairment record in checker for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_009_001_04_WriteOff
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for impairment asset from excel database for the pre requisite of asset write off
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
And store the asset reference number and item number of impaired assset in write off excel database

@KUBS_FAT_UAT_010_005_01
Scenario: Check the write off of asset(impaired)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already impaired
Then verify asset reference number or asset item number should not visible for write off

@KUBS_FAT_UAT_008_001_01_WriteOff
Scenario: Check the asset for its replacement (any)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database for the prerequisite of asset writeoff
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
@KUBS_FAT_UAT_008_001_02_WriteOff
Scenario: To verify reviewer user can able to approve the asset creation record with full details record
Given navigate to kubs Url to approve the fixed asset Replacement record in reviewer for prerequisite of asset write off
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_008_001_03_WriteOff
Scenario: To verify checker user can able to approve the fixed asset creation with minimum details record
Given navigate to kubs url to approve the fixed asset replacement record in checker for prerequisite of asset write off
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
@KUBS_FAT_UAT_008_001_04_WriteOff
Scenario: To verify maker user can able to see the approved replacement item number in list view of asset replacement
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Replacement submodule Eye Icon
And get the test data from asset replacement excel database for the prerequisite of asset writeoff
And click on search button in replacement list view
And search the approved asset reference number of replacement asset
Then verify approved asset reference number should visible in asset replacement list view along with item number
And store the asset reference and item number of replacement should store in asset write off excel database

@KUBS_FAT_UAT_010_006_01
Scenario: Check the write off of asset(Replaced Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already Replaced
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_006_02
Scenario: To verify reviewer user can able to approve the asset write off record(Replaced Asset)
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already replaced
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_006_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Replaced Asset)
Given navigate to kubs url to approve the fixed asset write off record in checker which is already replaced
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
@KUBS_FAT_UAT_010_006_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Replaced Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already Replaced
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_006_001_01_WriteOff
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocation test data from excel database for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_006_001_02_writeOff
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset writeoff prerequisite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_001_03_writeOff
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record in checker for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_006_001_04_writeOff
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database for prerequisite of asset writeoff
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number and item number of allocated asset in asset writeoff excel database

@KUBS_FAT_UAT_010_007_01
Scenario: Check the write off of asset(Allocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already allocated
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_007_02
Scenario: To verify reviewer user can able to approve the asset write off record(Allocated Asset)
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already allocated
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_007_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Allocated Asset)
Given navigate to kubs url to approve the fixed asset write off record in checker which is already allocated
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
@KUBS_FAT_UAT_010_007_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Allocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already allocated
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_006_001_01_WriteOff01
Scenario: To verify maker user can able to create the asset allocation record
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
And get the asset allocation test data from excel database for prerequisite of asset deallocation writeoff
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
@KUBS_FAT_UAT_006_001_01_WriteOff02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset deallocation writeoff prerequisite
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_001_01_WriteOff03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset allocation record in checker for prerequisite of asset deallocation writeoff
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
@KUBS_FAT_UAT_006_001_01_WriteOff04
Scenario: To verify approved asset allocation record should visible in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
And get the asset allocation test data from excel database for prerequisite of asset deallocation writeoff
And click on search in maker approved list view
And search the approved asset reference number in asset allocation list view
Then verify approved allocation asset record should visible along with item number
And store the asset reference number and item number of allocated asset in asset deallocation excel database for prerequisite of asset write off

@KUBS_FAT_UAT_006_005_01
Scenario: To verify user can able to de allocate the asset
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for asset write off prerequisite
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

@KUBS_FAT_UAT_006_005_02
Scenario: To verify reviewer user can able to approve the asset allocation record
Given navigate to kubs Url to approve the fixed asset de Allocation in reviewer for prerequisite of asset writeoff
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_006_005_03
Scenario: To verify checker user can able to approve the fixed asset allocation record
Given navigate to kubs url to approve the fixed asset de allocation record as a checker for prerequisite of asset writeoff
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
@KUBS_FAT_UAT_006_005_04
Scenario: To verify approved asset de allocation asset reference number should reflect in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on asset deallocaion Eye button
And get the asset de allocation test data from excel database for asset write off prerequisite
And click on search in maker approved list view
And search the de allocated asset reference number
Then verify approved de allocated asset reference number should visible long with item number in de allocation list view
And store the asset reference number and item number of de allocated asset in asset writeoff excel database


@KUBS_FAT_UAT_010_008_01
Scenario: Check the write off of asset(DeAllocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already de allocated
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_008_02
Scenario: To verify reviewer user can able to approve the asset write off record(DeAllocated Asset)
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already de allocated
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_008_03
Scenario: To verify checker user can able to approve the fixed asset impairment(DeAllocated Asset)
Given navigate to kubs url to approve the fixed asset write off record in checker which is already de allocated
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
@KUBS_FAT_UAT_010_008_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(DeAllocated Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already de allocated
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view

@KUBS_FAT_UAT_005_001_01_WriteOff
Scenario: To Transfer the asset one branch to another branch
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And click on add button for asset transfer
And get the test data for asset transfer from asset transfer excel database for the prerequisite of asset writeoff
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


@KUBS_FAT_UAT_005_001_02_WriteOff
Scenario: To verify stage 1 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage1 for prerequisite of asset writeoff
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage one
And click on submit in reviewer alert pop up
And get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation

@KUBS_FAT_UAT_005_001_03_WriteOff
Scenario: To verify stage 2 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage2 for prerequisite of asset writeOff
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



@KUBS_FAT_UAT_005_001_04_WriteOff
Scenario: To verify stage 3 user can able to approve the asset transfer record
Given navigate to kubs Url to approve the fixed asset transfer record in stage3 for prerequisite for prerequisite of asset writeOff
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in stage3
And click on submit in reviewer alert pop up
And verify record got approved in stage3

@KUBS_FAT_UAT_005_001_05_WriteOff
Scenario: To verify maker user can able to see the approved undertaking record in maker approved list view
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
When click on eye button of asset transfer
And get the test data for asset transfer from asset transfer excel database for the prerequisite of asset writeoff
Then click on search icon of asset transfer list view
And search the approved asset transfer asset reference number in list view
And verify asset reference number should visible in asset transfer list view
And store the asset reference number and item number of undertaking asset in asset write off excel database

@KUBS_FAT_UAT_010_009_01
Scenario: Check the write off of asset(Undertaking Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And click on Add Icon 
And get the test data for asset write off from excel database which is already undertaking
And select the asset reference number in asset impairment module
And select the asset item number in asset impairment module
And choose the transcation type as impairment
And choose the transcation type as write off
And click on save button in impairment module
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search the asset asset impairment module code in notification
And store the asset writeoff reference number in impairment excel database
And select the asset impairment record from notification
And click on submit in asset impairment
And enter the alert remark in asset impairment
And click on alert submit in asset impairment
And store the reviewer ID in asset write off excel database
@KUBS_FAT_UAT_010_009_02
Scenario: To verify reviewer user can able to approve the asset write off record(Undertaking Asset)
Given navigate to kubs Url to approve the fixed asset write off record in reviewer which is already undertaking
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_010_009_03
Scenario: To verify checker user can able to approve the fixed asset impairment(Undertaking Asset)
Given navigate to kubs url to approve the fixed asset write off record in checker which is already undertaken
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
@KUBS_FAT_UAT_010_009_04
Scenario: To verify approved asset reference number of asset impairment should visisble in maker list view(Undertaking Asset)
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
And click on view button near by asset impairement module
And get the test data for asset write off from excel database which is already undertaking
And click on search button in list view of asset impairment module
And search the asset reference number in asset impairment list view
Then verify asset reference number should visisble along with item number in impairment list view
