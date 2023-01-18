Feature: user create login in to Budget and planning UAT files
@KUBS_UAT_KUBS_BP_UAT_005_001
Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
And user update the Excel sheet testdata for Budget and planning Allocation
Then enter the budget code  to make current future financial budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification buttons
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification records1
And click on Submit buttons 
Then enter remark in confirmation alertss
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage1

@KUBS_UAT_KUBS_BP_UAT_005_001_1
Scenario: login to reviewer
And user update the Excel sheet testdata for Budget and planning Allocation
And User should go to the kubs url and login as a reviewer users1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_UAT_KUBS_BP_UAT_005_001_2
Scenario: login to checker
And user update the Excel sheet testdata for Budget and planning Allocation
Then log in to the Checker Account1
And click on security management tool
And click on temp view near by open pool
And user update the Excel sheet testdata for Budget and planning Allocation
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
@KUBS_UAT_KUBS_BP_UAT_005_001_3
Scenario: login to maker
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
Then click the Two Direction Icon
And click to the Budget
Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
And click on the Add icon in Request and Allocation
And user update the Excel sheet testdata for Budget and planning Allocation1
Then select the Budget Code 
And select the Budget Year
Then click on the Branch
And Select the Requested Branch
Then click on the Branch ok button
Then select one currency we need
And Give Branch requested to allocate the budget amount
And click on the save button
And click notification buttons 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification records1
And click on Submit button 
Then enter remark in confirmation alertss
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage3
@KUBS_UAT_KUBS_BP_UAT_005_001_4
Scenario: login to reviewer1
And user update the Excel sheet testdata for Budget and planning Allocation1
Given navigate to given url and login with maker credentials
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_UAT_KUBS_BP_UAT_005_001_5
Scenario: login to checker
And user update the Excel sheet testdata for Budget and planning Allocation1
Given navigate to given url and login with maker credentials
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

 @SupplementaryBudget_KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.
Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 And user update the Excel sheet testdata for Budget and planning Allocation2
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT
 
 @SupplementaryBudget_KUBS_BP_UAT_005_003
Scenario: System should allow to modify the supplimentary request budget before approval
 Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 And user update the Excel sheet testdata for Budget and planning Allocation3
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then Select the Supplementary record from notification
 Then fill apportion amount and save the record UAT
 
 @SupplementaryBudget_KUBS_BP_UAT_005_004
Scenario: System should able to approve the supplimentary requested budget
Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 And user update the Excel sheet testdata for Budget and planning Allocation4
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record4
And click on Submit button 
Then enter remark in confirmation alertss
Then click on submit button in alert
And user update the Excel sheet testdata for Budget and planning Allocation4
And capture the reviewer ID in pop up which is open when we submit our record in maker stagesss

 @SupplementaryBudget_KUBS_BP_UAT_005_004_01
Scenario: user click on reviwer 
And user update the Excel sheet testdata for Budget and planning Allocation4
And User should go to the kubs url and login as a reviewer users1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

 @SupplementaryBudget_KUBS_BP_UAT_005_004_02
 Scenario: user click on checker
Then log in to the Checker Account1
And click on security management tool
And click on temp view near by open pool
And user update the Excel sheet testdata for Budget and planning Allocation4
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage

@KUBS_BP_UAT_005_005_1
Scenario: Check System should able to Reject the supplimentary requested budget
Given navigate to given url and login with maker credentials
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
And user update the Excel sheet testdata for Budget and planning Allocation5
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alertss
Then click on submit button in alert
And user update the Excel sheet testdata for Budget and planning Allocation5
And capture the reviewer ID in pop up which is open when we submit our record in maker stage5

@KUBS_BP_UAT_005_005_2
Scenario: user login to reviewer
And user update the Excel sheet testdata for Budget and planning Allocation5
And User should go to the kubs url and login as a reviewer users1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_BP_UAT_005_005_3
Scenario: user login to checker
And user update the Excel sheet testdata for Budget and planning Allocation5
Then log in to the Checker Account1
And click on security management tool
And click on temp view near by open pool
And user update the Excel sheet testdata for Budget and planning Allocation5
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage

@KUBS_BP_UAT_005_005_4
Scenario: user login to maker
Given navigate to given url and login with maker credentials
And user update the Excel sheet testdata for Budget and planning Allocation5
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
 
@KUBS_BP_UAT_005_006_1
Scenario: Check if supplimentary budget rejected from HO, the requested amount can not be used
Given navigate to given url and login with maker credentials
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
And user update the Excel sheet testdata for Budget and planning Allocation6
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record3
And click on Submit button 
Then enter remark in confirmation alertss
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage6

@KUBS_BP_UAT_005_006_2
Scenario: user login to reviewer
And user update the Excel sheet testdata for Budget and planning Allocation6
And User should go to the kubs url and login as a reviewer users1
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage

@KUBS_BP_UAT_005_006_3
Scenario: user login to checker
And user update the Excel sheet testdata for Budget and planning Allocation6
Then log in to the Checker Account1
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

@KUBS_BP_UAT_005_006_4
Scenario: user login to maker
And user update the Excel sheet testdata for Budget and planning Allocation6
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And navigate to search icon and  fill the required field1