Feature: Sample

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