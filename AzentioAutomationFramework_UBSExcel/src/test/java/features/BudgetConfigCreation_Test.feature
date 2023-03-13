Feature: Test Budget config
@KUBS_BP_UAT_001_001_01_CurrentFinacialYear
Scenario: To verify user can able to submit the yearly budget record
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating the current financial budget
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
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_BP_UAT_001_001_02_CurrentFinacialYear
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly budget for current financial budget
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_BP_UAT_001_001_03_CurrentFinacialYear
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for current financial budget
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
@KUBS_BP_UAT_001_001_04_CurrentFinacialYear
Scenario: To verify aproved budget code should visible in budget config list view
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the test data from excel database for creating the current financial budget
And click on search button in budget config list view
And search the approved budget code in budget config list view
Then verify approved budget code should reflect in budget config list view
And store the budget code in budget request and allocation excel database for current financial year
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_B&P_UAT_001_005_01
Scenario: To verify user can able to create budget code for current financial year
Given navigate to given url and login with maker credentials
And click on configuration section
And click on transaction section
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And get the test data for allocate the budget for current finacial year
And click on the Add icon in Request and Allocation
And enter the budget code for budget request and allocation screen
And select the budget year as current financial year
And select the branch in budget request and allocation screen
And enter the currency in budget request and allocation screen
And enter the amount in budget request and allocation screen
And click on the save button
Then validate record got save in maker stage
And click on notification icon in maker stage
And click on search in maker notification section
And search for budget request and allocation record in notification
And store the record reference number of budget allocation record request and allocation excel database
And select the request and allocation notification record
And click on submit in request and allocation screen
And enter the alert remark in request and allocation
And click on alert submit in request and allocation
And store the reviewer ID in request and allocation excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_B&P_UAT_001_005_02
Scenario: To verify reviewer user can able to approve the current financial budget record
Given navigate to kubs url to approve the budget allocation record for current financial budget
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_B&P_UAT_001_005_03
Scenario: To verify checker user can able to approve the current financial budget record
Given Navigate to KUBS url and login with checker for approve the budget allocation record for current financial budget
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
@KUBS_B&P_UAT_001_005_04
Scenario: To verify approved busget request allocation of current financial budget should reflect in budget request and allocation screen
Given navigate to given url and login with maker credentials
And click on configuration section
And click on transaction section
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And get the test data for allocate the budget for current finacial year
And click on search button in busget request and allocation screen
And search for approved budget in budgte request and allocation screen
Then verify approved budget code should reflect in budget request and allocation screen
And store the budget code in after HO approval scenario excel database
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_BP_UAT_003_002_01
Scenario: Modificatin of the budget After HO approval
Given navigate to given url and login with maker credentials
And click on configuration section
And click on transaction section
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And get the test data for modify budget after HO approval
And click on search button in busget request and allocation screen
And search for approved budget in budgte request and allocation screen
And select the budget record in request and allocation screen
And update the budget code in request and allocation
And click on user profile icon
And click on logout button
Then verify user profile got logout