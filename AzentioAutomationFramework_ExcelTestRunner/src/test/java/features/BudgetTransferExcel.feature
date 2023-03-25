Feature: To verify the Functionalities of  budget and planning tranfer Module
@KUBS_BP_UAT_005_001_01_PRQ1
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly4
And User fill the budget code field for budgetcode yearly for transfer1
And choose budget type in budget configuration for budget request and allocation1
And give warning percentage for Budget configuration supplementary
And enter budget name for yearly budget1
Then enter remark for Budget configuration Supplementary records
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name1
And User update test data id to store reviewver id for yearly4 budget code
And store the reference number of budget config record in excel database1
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert1
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage1
Then logout from maker
@KUBS_BP_UAT_005_001_02_PRQ1
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly4 budget definition record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_BP_UAT_005_001_03_PRQ1
Scenario: To verify checker user can able to approve the budget defenition record
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
Then logout from maker
@KUBS_BP_UAT_005_001_04_PRQ1
Scenario: To do Budget allocation in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
Then click on configuration
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly budget code for transfer1
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code for transfer1 
And User update test data id to verify budget allocated for yearly4 budget code
And select the Budget Year1
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type1
And click on the save button
And User close the workflow initiated pop up
And click notification button 
Then click on the search button
And search the budget request and allocation sub module name1
And User update test data id to store reviewver id for budget request and allocation yearly4 budget code
And store the reference number of budget Creation record in excel database1
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert1
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage1
Then logout from maker
@KUBS_BP_UAT_005_001_05_PRQ1
Scenario: To verify reviewer user can able to approve budget request and allocation record
Given navigate to kubs url to approve the yearly4 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_001_06_PRQ1
Scenario: To verify checker user can able to Approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly4 budget request and Allocation record
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
@KUBS_BP_UAT_005_001_01_PRQ2
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly4
And User fill the budget code field for budgetcode yearly for transfer2
And choose budget type in budget configuration for budget request and allocation1
And give warning percentage for Budget configuration supplementary
And enter budget name for yearly budget1
Then enter remark for Budget configuration Supplementary records
Then click on Save button
And User close the workflow initiated pop up
And click notification button
Then click on the search button
And search the budget defenition sub module name1
And User update test data id to store reviewver id for yearly4 budget code
And store the reference number of budget config record in excel database1
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert1
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage1
Then logout from maker
@KUBS_BP_UAT_005_001_02_PRQ2
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly4 budget definition record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_001_03_PRQ2
Scenario: To verify checker user can able to approve the budget defenition record
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
@KUBS_BP_UAT_005_001_04_PRQ2
Scenario: To do Budget allocation in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
Then click on configuration
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly budget code for transfer1
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code for transfer2
And User update test data id to verify budget allocated for yearly4 budget code 
And select the Budget Year1
Then click on the Branch
And Choose to the one Branch
Then click on the Branch ok button
Then select one currency we need
And Enter the Amount for yearly Budget type1
And click on the save button
And User close the workflow initiated pop up
And click notification button 
Then click on the search button
And search the budget request and allocation sub module name1
And User update test data id to store reviewver id for budget request and allocation yearly4 budget code
And store the reference number of budget Creation record in excel database1
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert1
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage1
Then logout from maker
@KUBS_BP_UAT_005_001_05_PRQ2
Scenario: To verify reviewer user can able to approve budget request and allocation record
Given navigate to kubs url to approve the yearly4 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_001_06_PRQ2
Scenario: To verify checker user can able to Approve the budget Allocation record
Given Navigate to KUBS url and login with checker for approve the yearly4 budget request and Allocation record
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
@KUBS_BP_UAT_006_001_01
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
And User get the test data for budget code test case00600101
Given navigate to given url and login with maker credentials
Then Click on the Finance
And Maker click on the direction tab
Then click on configuration
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button
Then click on add buttion
Then fill the form
And save the form
And User close the workflow initiated pop up
And click notification button
Then choose first record in the notification record in budgetTransfer
And click on Submit button 
Then enter remark in confirmation alert in budgetTransfer
Then click on submit button in alert in budgetTransfer
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in budgetTransfer
Then logout from maker
@KUBS_BP_UAT_006_001_02
Scenario: Login as a Reviewer
And User get the test data for budget code test case00600101
And login with reviewer credentials budget
Then click on notification button
And select our record in notification records using reference ID in budgetTransfer
Then Approve the record from reviewer
And User get the test data for budget code test case00600102
And enter the remark in alert2
Then click on submit in alert2
Then verify the approval status of the record
And logout from reviewer


@KUBS_BP_UAT_006_001_03
Scenario: Login as a Checker
And User get the test data for budget code test case00600101
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID in budgetTransfer
Then click on Notification button
Then select our record in notification records by the help of reference ID in budgetTransfer
And click on approve button in checker stage
And User get the test data for budget code test case00600103
Then click on the submit button which is appeared in alert box in budgetTransfer
And verify the record got approved from checker
Then logout from checker

@KUBS_BP_UAT_006_001_04
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
And User get the test data for budget code test case00600104
When User login to maker
#Then click on configuration
Then Click on the Finance
And Maker click on the direction tab
Then click on configuration
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button

################################################################################################

@KUBS_BP_UAT_006_004_01
Scenario: Check when transfered budget from one budget code to another budget can modify the amount
And User get the test data for budget code test case00600401
When User login to maker
Then Click on the Finance
And Maker click on the direction tab
Then click on configuration
And Maker click on the direction tab
And click on budget main menu
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save in budgetTransfer
And User close the workflow initiated pop up
Then Maker click on the notification icon
Then Maker modify the amount in budgetTransfer
And User close the workflow initiated pop up
And click notification button
Then choose first record in the notification record in budgetTransfer1
And click on Submit button 
Then enter remark in confirmation alert in budgetTransfer
Then click on submit button in alert in budgetTransfer
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in budgetTransfer1
Then logout from maker


@KUBS_BP_UAT_006_004_02
Scenario: Login as a Reviewer
And User get the test data for budget code test case00600401
And login with reviewer credentials4
Then click on notification button
And select our record in notification records using reference ID in budgetTransfer
Then Approve the record from reviewer
And User get the test data for budget code test case00600402
And enter the remark in alert2
Then click on submit in alert2
Then verify the approval status of the record
And logout from reviewer


@KUBS_BP_UAT_006_004_03
Scenario: Login as a Checker
And User get the test data for budget code test case00600403
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for budget code test case00600401
And select our record and clime using reference ID in budgetTransfer
Then click on Notification button
Then select our record in notification records by the help of reference ID in budgetTransfer
And click on approve button in checker stage
And User get the test data for budget code test case00600403
Then click on the submit button which is appeared in alert box in budgetTransfer
And verify the record got approved from checker
Then logout from checker

@KUBS_BP_UAT_006_004_04
Scenario: Check when transfered budget from one budget code to another budget can modify the amount
And User get the test data for budget code test case00600404
When User login to maker
Then Click on the Finance
And Maker click on the direction tab
Then click on configuration
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button

#######################################
@KUBS_BP_UAT_006_007_01
Scenario: UAT_006_007 If transfering budget code does not have sufficient amount to transfer for the month
And User get the test data for budget code test case00600701
Given navigate to given url and login with maker credentials
Then Click on the Finance
And Maker click on the direction tab
Then user click on configuration
And Maker click on the direction tab
And click on budget main menu
Then click on transfer eye button
Then click on add button in transfer
Then fill the form and enter excessive budget amount to transfer in budgetTransfer
And User get the test data for budget code test case00600401
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save in budgetTransfer
And User close the workflow initiated pop up
Then Maker click on the notification icon
Then choose first record in the notification record in budgetTransfer7
And click on Submit button 
Then enter remark in confirmation alert in budgetTransfer
Then click on submit button in alert in budgetTransfer
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in budgetTransfer7
Then logout from maker


@KUBS_BP_UAT_006_007_02
Scenario: Login as a Reviewer
And User get the test data for budget code test case00600701
And login with reviewer credentials4
Then click on notification button
And select our record in notification records using reference ID in budgetTransfer
Then Approve the record from reviewer
And User get the test data for budget code test case00600702
And enter the remark in alert2
Then click on submit in alert2
Then verify the approval status of the record
And logout from reviewer


@KUBS_BP_UAT_006_007_03
Scenario: Login as a Checker
And User get the test data for budget code test case00600703
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for budget code test case00600701
And select our record and clime using reference ID in budgetTransfer
Then click on Notification button
Then select our record in notification records by the help of reference ID in budgetTransfer
And click on approve button in checker stage
And User get the test data for budget code test case00600703
Then click on the submit button which is appeared in alert box in budgetTransfer
And verify the record got approved from checker
Then logout from checker

@KUBS_BP_UAT_006_007_04
Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
And User get the test data for budget code test case00600704
Given navigate to given url and login with maker credentials
Then Click on the Finance
And Maker click on the direction tab
Then click on configuration
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button


