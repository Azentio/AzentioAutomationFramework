Feature: To verify user can able to create the transaction in budget and planning module 
#budget definition
@Yearly_budget
Scenario: To verify user can able to create budget code for yearly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for yearly budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then verify the yearly budget approve record is available in the approved list view
@MonthlyBudget
Scenario: To verify user can able to create budget code for monthly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for monthly budget
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then verify the monthly approved budget code is appeared in the list view

@QuarterlyBudget
Scenario: To verify user can able to create budget code for Quarterly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code quarterly budget
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then verify the quaterly budget approve record is available in the approved list view
@HalfYearlyBudget
Scenario: To verify user can able to create budget code for Half yearly budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter Budget Code for half yearly budget
And choose half yearly option in budget type
And give warning percentage
And enter budget name for half yearly
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then verify budget data are matched whic is submited by maker
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And validate the record which is submited by maker
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then verify the half yearly budget approve record is available in the approved list view
@CurentFinancialYear
Scenario: To Create the budget for current financial year
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter the budget code  to make current/future financial budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button 
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Choose to the Budget Code for current financial budget
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
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
  
  @Future_FinacialBudget
  Scenario: To Create the budget for future financial year
    Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter the budget code  to make current/future financial budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Choose to the Budget Code for future financial year budget
  And select the Budget Year fo future 
  Then click on the Branch
  And Choose to the one Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for yearly Budget type
  And click on the save button
  And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  
  
  @KUBS_BP_UAT_001_007
  Scenario: Check created budget code in the report
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
Then get the budget code budget type and transaction date
Then click on report segment button
Then click on master report main module 
And click on temp view near by budget code report sub module 
Then enter budget type in budget code report
And give transaction date 
Then click on view button in budget code report
Then verify approved budget code is appeared under in master report
#Budget Request AndAllocation
@KUBS_UAT_Monthly_KUBS_BP_UAT_002_001

Scenario: budget for Budgetcode  type monthly
  Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
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
  
  @KUBS_UAT_Quarterly_KUBS_BP_UAT_002_002
  
  Scenario: budget for Budgetcode  type Quaterly
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
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
  
  @KUBS_UAT_Halfyearly_KUBS_BP_UAT_002_003
  
  Scenario: budget for Budgetcode  type Halfyearly
  
  Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose half yearly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
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
  
  @KUBS_UAT_yearly_KUBS_BP_UAT_002_004
  
  Scenario: budget for Budgetcode  type yearly
  Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter the budget code  to make current/future financial budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  
  
  Then click the Two Direction Icon
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
  
  @KUBS_UAT_BudgetApprove_KUBS_BP_UAT_002_005
  
  Scenario: Check requested  budget for budget code  can be approved
  Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And search the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Code
 	And select the Budget Year
  Then click on the Branch
  And Choose the one Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Give Amount for Budget Type Show in Budget type field
  And click on the save button
 And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
  
  @KUBS_UAT_BudgetReject_KUBS_BP_UAT_002_006
  
  Scenario: Check requested  budget for budget code  can be Rejected
    Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  
  
  Then click the Two Direction Icon
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
 And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
  And Reject the Record in checker
  Then Submit the Rejecting Record in checker 
   
  @KUBS_UAT_KUBS_BP_UAT_002_007
  
Scenario: Check the rejected budget can be used 
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And search the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  

  Then click the Two Direction Icon
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
  Then Again Login the Maker
  Then click the Two Direction Icon
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
  And Save the Record and capture the output
  
  
  @KUBS_UAT_KUBS_BP_UAT_003_001
  
  Scenario: Modificatin of the budget before HO approval
 Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose half yearly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
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
  And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
  
  @KUBS_UAT_KUBS_BP_UAT_003_002
  
  Scenario: Modificatin of the budget After HO approval
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And Click On Search Icon
  Then Enter the Budget type
  Then Click on Table Row First Eye Icon
  And Change the Amount After Approval
  When validate the modification
  
 
	@KUBS_UAT_KUBS_BP_UAT_003_003
	
	Scenario: Check for the budget request for monthly on  current financial year  accounting period is Jan to Dec and current month is on April 
	 Given navigate to given url and login with maker credentials
	Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose monthly option in budget type
And give warning percentage
And enter budget name for monthly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Code
 	Then click on the Branch
  And select to one Branch
  Then click on the Branch ok button
  Then select one currency we need
 	Then Capture April Month
 	And Capture May Month
 	Then Capture June Month
 	And Capture July Month
 	Then Capture Augest Month
 	And Capture Sepetember Month
 	Then Capture October Month
 	And Capture November Month
 	Then Capture December Month
 	And Capture January Month
 	Then Capture Feburary Month
 	And Capture March Month
	
	@KUBS_UAT_KUBS_BP_UAT_003_004
	
	Scenario: Check for the budget request for Quarterly on  current financial year accounting period is Jan to Dec 
	Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose Quarterly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
    And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
Then select the Budget Code
 	And Enter the Budget Year
  Then click on the Branch
  And select to one Branch
  Then click on the Branch ok button
  Then select one currency we need
 	Then Give budget amount for quarterly
	
	@KUBS_UAT_KUBS_BP_UAT_003_005
	
	Scenario: Check for the budget request for Half Yearly  on  current financial year  accounting period is Jan to Dec 
	Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose half yearly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Code
 	And Enter the Budget Year for halfyearly
  Then click on the Branch
  And select to one Branch
  Then click on the Branch ok button
  Then select one currency we need
	Then Give budget amount for HalfYearly	
	
	@KUBS_UAT_KUBS_BP_UAT_004_001
	
	Scenario: Check to cancel the wrongly created budget code
  	Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then fill the budget code field
And choose half yearly option in budget type
And give warning percentage
And enter budget name for Quarterly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And serach the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation


  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Code 
  And select the past Budget Year
  Then click on the Branch
  And select FIRST Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for Required Budget type
  And click on the save button
	Then click on the Maker icon button
	And Click the Cancel button 
	Then Submit the Cancel Record
	
	@KUBS_UAT_KUBS_BP_UAT_004_002
	
	Scenario: Check the budget request in the report
	Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And Get Budget type
	Then Third Segment report Icon
	And Click main module Reports
	And Click on sub module Budget creation Reports
	Then Give the Getted budget type
	Then Give Current business Date
	Then Click on View button
	And Verify the Budget creation Report

	@KUBS_UAT_KUBS_BP_UAT_005_001
	
	Scenario: Branch requested to allocate the budget
Given navigate to given url and login with maker credentials
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And click on add button to create budget code
Then enter the budget code  to make current/future financial budget
And choose yearly option in budget type
And give warning percentage
And enter budget name for yearly budget
Then enter remark
Then click on Save button
And click notification button
Then click on the search button
And search the budget defenition sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker
And login with Maker ID
Then click on budget configuration menu
Then click on eye icon which is near by budget definition submenu
And get the budget code for allocation
  
  
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Select the Requested Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Give Branch requested to allocate the budget amount
  And click on the save button
 And click notification button 
Then click on the search button
And serach the budget request and allocation sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
  
  
  #budget Suplimentory
  @SupplementaryBudget_KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.

 Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT


@SupplementaryBudget_KUBS_BP_UAT_005_004
Scenario: System should able to approve the supplimentary requested budget

Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 
 And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker

@SupplementaryBudget_KUBS_BP_UAT_005_005
Scenario: Check System should able to Reject the supplimentary requested budget
Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker
Then click on open pool UAT
And Verify for claming the record UAT
#Then User should click on notification icon on reviewer2 home page UAT
Then click on Notification button
Then select our record in notification records by the help of reference ID
Then Claim and reject the record UAT
Then logout from checker
And login with Maker ID
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
@SupplementaryBudget_KUBS_BP_UAT_005_006
Scenario: Check if supplimentary budget rejected from HO, the requested amount can not be used
Given navigate to given url and login with maker credentials
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
And click notification button 
Then click on the search button
And serach the budget supplimentory sub module name
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
Then Claim and reject the record UAT 
Then logout from checker
And login with Maker ID
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And navigate to search icon and  fill the required field


@SupplementaryBudget_KUBS_BP_UAT_005_003
Scenario: System should allow to modify the supplimentary request budget before approval
 Given navigate to given url and login with maker credentials
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then Select the Supplementary record from notification
 Then fill apportion amount and save the record UAT
 
 @SupplementaryBudget_KUBS_BP_UAT_005_007
Scenario: Check the supplementary budget request in the report
Given navigate to given url and login with maker credentials
Then click on report segment button
Then Click on Report field
Then click on supplementary budget Report
Then Select the date
And click on view button of report
Then verify the Supplementary Budget report

#Transfer budget
  
  @BudgetTransfer_KUBS_BP_UAT_006_008_UAT
Scenario: Check the functionality if transfering budget does not have sufficeint amount in that quarter
Given Maker login
And Maker click on  the direction tab
And click on budget main menu
Then Maker click on  budget transfer eye button
And Maker click on add button
Then fill form and enter excessive budget amount to transfer

@BudgetTransfer_KUBS_BP_UAT_006_004
Scenario: Check when transfered budget from one budget code to another budget can modify the amount
Given Maker login
And Maker click on  the direction tab
And click on budget main menu
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker modify the amount

@Budget_BudgetTransfer_UAT_006_001
Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
When User login to maker
Then click on configuration
And click on finance
And Maker click on  the direction tab
And click on budget main menu
Then Click on budget transfer eye button
Then click on add buttion
Then fill the form
And save the form
Then form should get save

@Budget_BudgetTransfer_UAT_006_007
Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
When user login into maker stage
Then user click on configuration
Then user click on the finance button
And click on budget main menu
Then click on transfer eye button
Then click on add button in transfer
Then fill the form and enter excessive budget amount to transfer

@KUBS_BP_UAT_006_009
@MultiAuth
Scenario: Check the transafer once transfer is completed in the report
Given navigate to given url and login with maker credentials
Then click on second Segment button
And click on budget main menu
And click on view button near by budget transfer menu
And get the Transfered from budget code
And get the Transfered to budget code
And get the Transfered budget amount
Then click on report segment button
And click on report main menu
And click on Transfer of budget details list report
And click on date icon
And give date in report
And click on the view button
Then verify the transfered budget and amount is available in the transfered report
