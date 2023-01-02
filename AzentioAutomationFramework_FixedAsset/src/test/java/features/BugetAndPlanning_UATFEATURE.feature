Feature: To test the budget and planning module
@KUBS_BP_UAT_001_001_01
Scenario: To verify user can able to submit the yearly budget record
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating yearly budget code
And click on add button to create budget code
Then enter Budget Code in budget configuration screen
And choose budget type in budget configuration screen
And give warning percentage
And enter the the budget name in budget configuration screen
And enter the remark in budget config screen
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search for budget configuration record in notification
And store the reference number of budget config record in excel database
And select the budget config record
And click on submit in budget configuration
And enter the alert remark in budget configuration 
And click on alert submit in budget configuration
And store the reviewer id of budget configuration in excel database
@KUBS_BP_UAT_001_001_02
Scenario: To verify reviewer user can able to approve the budget definition record
Given navigate to kubs url to approve the yearly budget record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_001_001_03
Scenario: To verify checker user can able to approve the budget definition record
Given Navigate to KUBS url and login with checker for approve the yearly budget record
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
@KUBS_BP_UAT_001_001_04
Scenario: To verify aproved budget code should visible in budget config list view
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating yearly budget code
And click on search button in budget config list view
And search the approved budget code in budget config list view
Then verify approved budget code should reflect in budget config list view
@KUBS_BP_UAT_001_002_01
Scenario: To verify user can able to submit the yearly budget record
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating monthly budget code
And click on add button to create budget code
Then enter Budget Code in budget configuration screen
And choose budget type in budget configuration screen
And give warning percentage
And enter the the budget name in budget configuration screen
And enter the remark in budget config screen
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search for budget configuration record in notification
And store the reference number of budget config record in excel database
And select the budget config record
And click on submit in budget configuration
And enter the alert remark in budget configuration 
And click on alert submit in budget configuration
And store the reviewer id of budget configuration in excel database
@KUBS_BP_UAT_001_002_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the monthly budget record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_001_002_03
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for approve the monthly budget record
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
@KUBS_BP_UAT_001_002_04
Scenario: To verify aproved budget code should visible in budget config list view
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating monthly budget code
And click on search button in budget config list view
And search the approved budget code in budget config list view
Then verify approved budget code should reflect in budget config list view
@KUBS_BP_UAT_001_003_01
Scenario: To verify user can able to submit the yearly budget record
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating quarterly budget code
And click on add button to create budget code
Then enter Budget Code in budget configuration screen
And choose budget type in budget configuration screen
And give warning percentage
And enter the the budget name in budget configuration screen
And enter the remark in budget config screen
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search for budget configuration record in notification
And store the reference number of budget config record in excel database
And select the budget config record
And click on submit in budget configuration
And enter the alert remark in budget configuration 
And click on alert submit in budget configuration
And store the reviewer id of budget configuration in excel database
@KUBS_BP_UAT_001_003_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the quarterly budget record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_001_003_03
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for approve the quarterly budget record
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
@KUBS_BP_UAT_001_003_04
Scenario: To verify aproved budget code should visible in budget config list view
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating quarterly budget code
And click on search button in budget config list view
And search the approved budget code in budget config list view
Then verify approved budget code should reflect in budget config list view
@KUBS_BP_UAT_001_004_01
Scenario: To verify user can able to submit the yearly budget record
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating half yearly budget code
And click on add button to create budget code
Then enter Budget Code in budget configuration screen
And choose budget type in budget configuration screen
And give warning percentage
And enter the the budget name in budget configuration screen
And enter the remark in budget config screen
Then click on Save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search for budget configuration record in notification
And store the reference number of budget config record in excel database
And select the budget config record
And click on submit in budget configuration
And enter the alert remark in budget configuration 
And click on alert submit in budget configuration
And store the reviewer id of budget configuration in excel database
@KUBS_BP_UAT_001_004_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the half yearly budget record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_001_004_03
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for approve the half yearly budget record
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
@KUBS_BP_UAT_001_004_04
Scenario: To verify aproved budget code should visible in budget config list view
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating half yearly budget code
And click on search button in budget config list view
And search the approved budget code in budget config list view
Then verify approved budget code should reflect in budget config list view