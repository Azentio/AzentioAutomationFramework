Feature: To verify the budget and planning UAT flow
@KUBS_BP_UAT_006_001_01
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
And User get the test data for budget code test case00600101
Given navigate to given url and login with maker credentials
#Then click on configuration
Then Click on the Finance
And Maker click on the direction tab
And click on budget main menu
Then click on configuration
And click on budget main menu
Then Click on budget transfer eye button
Then click on add buttion
Then fill the form
And save the form
Then form should get save
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
#Then click on configuration
Then Click on the Finance
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button

#######################################
@KUBS_BP_UAT_006_007_01
Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
And User get the test data for budget code test case00600701
Given navigate to given url and login with maker credentials
#Then user click on configuration
Then Click on the Finance
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
#Then click on configuration
Then Click on the Finance
And Maker click on the direction tab
And click on budget main menu
Then Click on budget transfer eye button


