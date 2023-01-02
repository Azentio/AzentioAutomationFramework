Feature: To test the budget and planning module
#Budget Request AndAllocation Monthly
@KUBS_BP_UAT_002_001_01
Scenario: budget for Budgetcode type monthly
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Monthly
Then fill the budget code field
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And User update test data id to store reviewver id
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And store the reviewer id of budget configuration in excel database
Then logout from maker
@KUBS_BP_UAT_002_001_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the Montly budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_001_03
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for approve the Monthly budget request and Allocation record
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
@KUBS_BP_UAT_002_001_04
Scenario: To verify budget allocated in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And User update test data id to verify budget allocated for monthly budget code
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code 
And select the Budget Year
Then click on the Branch
And select to one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for Monthly Budget type
And click on the save button
@KUBS_BP_UAT_002_002_01
Scenario: budget for Budgetcode  type Quaterly
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Quarterly
Then fill the budget code field
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And User update test data id to store reviewver id for Quarterly budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_002_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the Quartely budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_002_03
Scenario: To verify checker user can able to approve the budget defenition record
Given Navigate to KUBS url and login with checker for approve the Quarterly budget request and Allocation record
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
@KUBS_BP_UAT_002_002_04
Scenario: To verify budget allocated in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And User update test data id to verify budget allocated for Quarterly budget code
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code
And select the Budget Year
Then click on the Branch
And select the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for Quarterly Budget type
And click on the save button
@KUBS_BP_UAT_002_003_01
Scenario: budget for Budgetcode type Halfyearly
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Halfyearly
Then fill the budget code field
And choose half yearly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And User update test data id to store reviewver id for Halfyearly budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_003_02
Scenario: To verify reviewer user can able to approve the budget definition record
Given navigate to kubs url to approve the Halfyearly budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_003_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the Halfyearly budget request and Allocation record
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
@KUBS_BP_UAT_002_003_04
Scenario: To verify budget allocated in maker stage
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And User update test data id to verify budget allocated for Halfyearly budget code
And click on the Add icon in Request and Allocation
Then select the Budget Code 
And select the Budget Year
Then click on the Branch
And select the Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for Halfyearly Budget type
And click on the save button
@KUBS_BP_UAT_002_004_01
Scenario: budget for Budgetcode  type yearly
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly
#Then enter the budget code  to make current/future financial budget
Then fill the budget code field
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And User update test data id to store reviewver id for yearly budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_004_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_004_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly budget request and Allocation record
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
@KUBS_BP_UAT_002_004_04
Scenario: To verify budget allocated in maker stage
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And User update test data id to verify budget allocated for yearly budget code
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button
 
 
@KUBS_BP_UAT_002_006_01
Scenario: budget for Budgetcode type yearly
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly1
#Then enter the budget code  to make current/future financial budget
Then fill the budget code field
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And User update test data id to store reviewver id for yearly1 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_006_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly1 budget definition
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_006_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly1 budget request and Allocation record
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
@KUBS_BP_UAT_002_006_04
Scenario: To verify budget allocated in maker stage
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And User update test data id to verify budget allocated for yearly1 budget code
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button
And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
And User update test data id to store reviewver id for yearly1 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker

@KUBS_BP_UAT_002_006_05
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly1 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_006_06
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly1 budget request and Allocation record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And Reject the Record in checker
Then Submit the Rejecting Record in checker 

  

