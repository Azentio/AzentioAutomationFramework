Feature: To test the budget and planning module
#Budget Request AndAllocation Monthly
@KUBS_BP_UAT_002_001_01
Scenario: budget for Budgetcode type monthly
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Monthly
And User fill the budget code for type Monthly
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
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
And User update test data id to verify budget allocated for monthly budget code
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for monthly budget code
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
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Quarterly
And User fill the budget code for type Quarterly
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
And User update test data id to store reviewver id for Quarterly budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And store the reviewer id of budget configuration in excel database
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
And User update test data id to verify budget allocated for Quarterly budget code
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
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode Halfyearly
And User fill the budget code for type Half Yearly
And choose half yearly option in budget type
And give warning percentage
And enter budget name for half yearly
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
And User update test data id to store reviewver id for Halfyearly budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And store the reviewer id of budget configuration in excel database
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
Scenario: To verify budget allocated for half yerarly budget code in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for Halfyearly budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
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
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly
And User fill the budget code for type Yearly
And choose yearly option in budget type for budget code creation
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
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
Scenario: To verify budget allocated for yearly budget code in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button

@KUBS_BP_UAT_002_005_01
Scenario: Check requested  budget for budget code  can be approved
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly3
And User fill the budget code for type yearly3
And choose yearly option in budget type for budget code creation
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
And User update test data id to store reviewver id for yearly3 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_005_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly3 budget defenition record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_005_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly3 budget defenition record
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

@KUBS_BP_UAT_002_005_04
Scenario: To do Budget allocation in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly3 budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button
And User close the workflow initiated pop up
And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
And User update test data id to store reviewver id for yearly3 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker

@KUBS_BP_UAT_002_005_05
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly3 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_BP_UAT_002_005_06
Scenario: To verify checker user can able to reject the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly3 budget request and Allocation record
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

@KUBS_BP_UAT_002_006_01
Scenario: budget for Budgetcode type yearly
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly1
And User fill the budget code for type yearly1
And choose yearly option in budget type for budget code creation
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
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
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly1 budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button
And User close the workflow initiated pop up
And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
And User update test data id to store reviewver id for budget and allocation using yearly1 budget code
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
Scenario: To verify checker user can able to reject the budget Allocation record
Given Navigate to KUBS url and login with checker for reject the yearly1 budget request and Allocation record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And Reject the Record in checker
Then Submit the Rejecting Record in checker 

@KUBS_BP_UAT_002_007_01
Scenario: Check the rejected budget can be used 
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly2
And User fill the budget code for budgetcode yearly2
And choose yearly option in budget type for budget code creation
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
And User update test data id to store reviewver id for yearly2 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_002_007_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly2 budget definition
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_002_007_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly2 budget request and Allocation record
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
@KUBS_BP_UAT_002_007_04
Scenario: Do Budget request and allocation
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly2 budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code 
And select the Budget Year
Then click on the Branch
And Select Branch checkbox
Then click on the Branch ok button
Then select one currency we need
And Budget Amount for Budget Type Show in Budget type field
And click on the save button
Then click on the Maker icon button
And click on the Record Reject
@KUBS_BP_UAT_002_007_05
Scenario: Check the rejected budget can be used
Then Again Login the Maker
Then Click on the Finance
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
And User update test data id to verify budget allocated for yearly Rejected budget code
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Select Branch checkbox
Then click on the Branch ok button
Then select one currency we need
And Budget Amount for Budget Type Show in Budget type field
And Save the Record and capture the output
  
@KUBS_BP_UAT_005_002_01
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly4
And User fill the budget code field for budgetcode yearly4
And choose yearly option in budget type for budget code creation
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name
And User update test data id to store reviewver id for yearly4 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
@KUBS_BP_UAT_005_002_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly4 budget defenition record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_002_03
Scenario: To verify checker user can able to approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly4 budget defenition record
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

@KUBS_BP_UAT_005_002_04
Scenario: To do Budget allocation in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly4 budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code  
And select the Budget Year
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type
And click on the save button
And User close the workflow initiated pop up
And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
And User update test data id to store reviewver id for budget request and allocation yearly4 budget code
And store the reference number of budget config record in excel database
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker

@KUBS_BP_UAT_005_002_05
Scenario: To verify reviewer user can able to approve budget request and allocation record
Given navigate to kubs url to approve the yearly4 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_BP_UAT_005_002_06
Scenario: To verify checker user can able to reject the budget Allocation record
Given Navigate to KUBS url and login with checker for reject the yearly4 budget request and Allocation record
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

