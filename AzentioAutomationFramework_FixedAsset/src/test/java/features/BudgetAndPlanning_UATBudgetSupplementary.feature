Feature: To test the budget and planning module
@KUBS_BP_UAT_005_001_01
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And User update test data id for budgetcode yearly4
And User fill the budget code field for budgetcode yearly4
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
@KUBS_BP_UAT_005_001_02
Scenario: To verify reviewer user can able to approve the budget defenition record
Given navigate to kubs url to approve the yearly4 budget definition record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_001_03
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
@KUBS_BP_UAT_005_001_04
Scenario: To do Budget allocation in maker stage
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And User update test data id to verify budget allocated for yearly4 budget code
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
Then select the Budget Code1  
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

@KUBS_BP_UAT_005_001_05
Scenario: To verify reviewer user can able to approve budget request and allocation record
Given navigate to kubs url to approve the yearly4 budget request and allocation record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_BP_UAT_005_001_06
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
#budget Suplimentory
 @KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And User update test data id to do More amount of Budget supplementary for yearly budget code
 And click on add button on budget supplementary view page UAT
 And User Select the Budget code to do supplementary of Yearly budget code
 And User Select the Budget Year to do supplementary of Yearly budget code
 And User Select the Budget Branch to do supplementary of Yearly budget code
 And User Select the Currency Type to do supplementary of Yearly budget code
 And User Enter Supplementary Appropriation Amount
 And User Enter New Amount for supplementary
 And User Click save button for Supplementary Records
 And User close the workflow initiated pop up
 And User Click Maker Notification
 Then click on the search button
 And search the budget Supplementary record name
 And User update test data id to store reviewver id for budget supplementary yearly budget code
 And User store reference id for budget supplementary record
 And User update test data id to store reviewver id for budget supplementary yearly budget code
 And User Click action for budget supplementary record
 And User Click the Submit button for budget supplementary record
 And User Enter remark for budget supplementary record
 And User Store reviewver id to submit budget supplementary record in reviewver
 Then logout from maker
 @KUBS_BP_UAT_005_003
Scenario: System should allow to modify the supplimentary request budget before approval
 Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And User Update Test data id to Modify Budget Supplimentary for Yearly Budget Code
 And click on add button on budget supplementary view page UAT
 And User Select the Budget code to do supplementary of Yearly budget code
 And User Select the Budget Year to do supplementary of Yearly budget code
 And User Select the Budget Branch to do supplementary of Yearly budget code
 And User Select the Currency Type to do supplementary of Yearly budget code
 And User Enter Supplementary Appropriation Amount
 And User Enter New Amount for supplementary
 And User Click save button for Supplementary Records
 And User close the workflow initiated pop up
 Then Select the Supplementary record from notification
 And User Modify Supplementary Appropriation Amount
 And User Modify New Amount for supplementary
 And User Click save button for Modified Supplementary Records
 @KUBS_BP_UAT_005_004_01
Scenario: System should able to approve the supplimentary requested budget.
 Given navigate to given url and login with maker credentials
 Then Click on the Finance
 Then Click on Direction icon
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And User update test data id to do Budget supplementary for yearly4 budget code
 And click on add button on budget supplementary view page UAT
 And User Select the Budget code to do supplementary of Yearly budget code
 And User Select the Budget Year to do supplementary of Yearly budget code
 And User Select the Budget Branch to do supplementary of Yearly budget code
 And User Select the Currency Type to do supplementary of Yearly budget code
 And User Enter Supplementary Appropriation Amount
 And User Enter New Amount for supplementary
 And User Update test data id to store new Amount for Verification
 And User Store New Amount for Verification
 And User Click save button for Supplementary Records
 And User close the workflow initiated pop up
 And User Click Maker Notification
 Then click on the search button
 And User update test data id to do Budget supplementary for yearly4 budget code
 And search the budget Supplementary record name
 And User update test data id to store reviewver id for budget supplementary yearly budget code
 And User store reference id for budget supplementary record
 And User update test data id to store reviewver id for budget supplementary yearly budget code
 And User Click action for budget supplementary record
 And User Click the Submit button for budget supplementary record
 And User Enter remark for budget supplementary record
 And User Store reviewver id to submit budget supplementary record in reviewver
 Then logout from maker
 @KUBS_BP_UAT_005_004_02
Scenario: To verify reviewer user can able to approve the Budget Supplementary record
Given navigate to kubs url to approve the Budget Supplementary record for Yearly Budget Code
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_BP_UAT_005_004_03
Scenario: To verify checker user can able to approve the Budget Supplementary record
Given Navigate to KUBS url and login with checker for approve the Budget Supplementary record for Yearly Budget Code
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
@KUBS_BP_UAT_005_004_04
Scenario: To verify Budget supplementary amount is reflected in Maker
Given navigate to given url and login with maker credentials
And User Update test data id to verify budget supplementary approved record
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
Then click on the search button budget supplementary approved record
And User Search the Budget Code to verify Budget Supplementary
And User Click First view icon of Budget Supplementary record
And User Verify Budget Supplementary Amount is Reflected

@KUBS_BP_UAT_005_005_01
Scenario: Check System should able to Reject the supplimentary requested budget
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And User update test data id to do Budget supplementary Rejection for yearly4 budget code
 And click on add button on budget supplementary view page UAT
 And User Select the Budget code to do supplementary of Yearly budget code
 And User Select the Budget Year to do supplementary of Yearly budget code
 And User Select the Budget Branch to do supplementary of Yearly budget code
 And User Select the Currency Type to do supplementary of Yearly budget code
 And User Enter Supplementary Appropriation Amount
 And User Enter New Amount for supplementary
 And User Update test data id to store new Amount for Verification rejected
 And User Store New Amount for Verification
 And User Click save button for Supplementary Records
 And User update test data id to do Budget supplementary Rejection for yearly4 budget code
 And User close the workflow initiated pop up
 And User Click Maker Notification
 Then click on the search button
 And search the budget Supplementary record name
 And User update test data id to store reviewver id for budget supplementary yearly4 budget code
 And User store reference id for budget supplementary record
 And User update test data id to store reviewver id for budget supplementary yearly4 budget code
 And User Click action for budget supplementary record
 And User Click the Submit button for budget supplementary record
 And User Enter remark for budget supplementary record
 And User Store reviewver id to submit budget supplementary record in reviewver
 Then logout from maker
 @KUBS_BP_UAT_005_005_02
Scenario: To verify reviewer user can able to approve supplimentary requested budget
Given navigate to kubs url to approve the Budget Supplementary record in Reviewver for Yearly Budget Code
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_BP_UAT_005_005_03
Scenario: To verify checker user can able to reject supplementary requested budget
Given Navigate to KUBS url and login with checker for reject Budget Supplementary record for Yearly Budget Code
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And Reject the Record in checker
And User Enter remarks for Checker Reject
Then Submit the Rejecting Record in checker for supplementary record
Then logout from maker
@KUBS_BP_UAT_005_005_04
Scenario: To verify Budget supplementary amount is not reflected in Maker
Given navigate to given url and login with maker credentials
And User Update test data id to verify budget supplementary Rejected record
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
Then click on the search button budget supplementary approved record
And User Search the Budget Code to verify Budget Supplementary
And User Click First view icon of Budget Supplementary record
And User Verify Budget Supplementary Amount is Not Reflected
 @KUBS_BP_UAT_005_006_01
Scenario: Check if supplimentary budget rejected from HO, the requested amount can not be used
 Given navigate to given url and login with maker credentials
 Then Click on the Finance
 Then Click on Direction icon
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And User update test data id to Reject Budget supplementary  for yearly4 budget code
 And click on add button on budget supplementary view page UAT
 And User Select the Budget code to do supplementary of Yearly budget code
 And User Select the Budget Year to do supplementary of Yearly budget code
 And User Select the Budget Branch to do supplementary of Yearly budget code
 And User Select the Currency Type to do supplementary of Yearly budget code
 And User Enter Supplementary Appropriation Amount
 And User Enter New Amount for supplementary
 And User Update test data id to store new Amount for Verification rejected HO
 And User Store New Amount for Verification
 And User Click save button for Supplementary Records
 And User close the workflow initiated pop up
 And User Click Maker Notification
 And User update test data id to Reject Budget supplementary  for yearly4 budget code
 Then click on the search button
 And search the budget Supplementary record name
 And User update test data id to store reviewver id for HO budget supplementary yearly budget code
 And User store reference id for budget supplementary record
 And User update test data id to store reviewver id for HO budget supplementary yearly budget code
 And User Click action for budget supplementary record
 And User Click the Submit button for budget supplementary record
 And User Enter remark for budget supplementary record
 And User Store reviewver id to submit budget supplementary record in reviewver
 Then logout from maker
 @KUBS_BP_UAT_005_006_02
Scenario: To verify reviewer user can able to approve supplimentary requested budget
Given navigate to kubs url to approve the HO Budget Supplementary record in Reviewver for Yearly Budget Code
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
Then logout from maker
@KUBS_BP_UAT_005_006_03
Scenario: To verify checker user can able to reject supplimentary requested budget
Given Navigate to KUBS url and login with checker for reject HO Budget Supplementary record for Yearly Budget Code
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And Reject the Record in checker
And User Enter remarks for Checker Reject
Then Submit the Rejecting Record in checker for supplementary record 
Then logout from maker
@KUBS_BP_UAT_005_006_04
Scenario: To verify Budget supplementary amount is not reflected in Maker
Given navigate to given url and login with maker credentials
And User Update test data id to verify budget supplementary record
Then Click on the Finance
Then Click on Direction icon
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
Then click on the search button budget supplementary approved record
And User Search the Budget Code to verify Budget Supplementary
And User Click First view icon of Budget Supplementary record
And User Verify Budget Supplementary Amount is Not Reflected
@KUBS_BP_UAT_005_007
Scenario: Check the supplementary budget request in the report
Given navigate to given url and login with maker credentials
Then Click on the Finance
Then click on report segment button
Then Click on Report field
Then click on supplementary budget Report
Then Select the date
And click on view button of report
Then verify the Supplementary Budget report
