Feature: Checking the Supplementary Budget functionality


  Scenario: Check the functionality  Request of the supplementary budget for the branch
  Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then maker should fill the required field
	Then fill apportion amount and save the record
 	Then validate maker can save request for the Annually budget
 	
 	#---checker common--#
 Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
	

	@SupplementaryBudget_BP_SB_03_05
  Scenario: Check the functionality System should display Approved authorisation status of the record
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
 Given Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 And Verify the record is Approved
  Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click search icon and  fill the required field
	Then select the record check Approved auth status of the record

	
	@SupplementaryBudget_BP_SB_06_04
  Scenario: Check the functionality System should display Returned authorisation status of the record
  Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Given Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
And Verify the record is Return
  Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
  When maker click on budget supplementary eye icon
	And navigate to search icon and  fill the required field
	Then select the record check Returned auth status of the record
	
	@SupplementaryBudget_BP_SB_12_01
  Scenario: System should display the search criteria to search the data based on specific data elements.
  Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
  When maker click on budget supplementary eye icon
	And  maker navigate to search icon and  fill the required field
	Then maker select the record
	
	
	
	
	 @SupplementaryBudget_BP_SB_08_01
	Scenario: To verify Monthly option is available on screen to raise Monthly supplementary request
	Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill the required data 
	Then validate monthly supplementary apportion field 
	
	@SupplementaryBudget_BP_SB_08_02
	Scenario: User should be able to raise supplementary request for Monthly budget
	Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data 
	Then fill apportion amount
	Then validate maker can save request for the monthly budget
	
	@SupplementaryBudget_BP_SB_08_03
	Scenario: To verify system displays the validation message when user try to raise monthly supplementory request for past 
	Given maker should navigate to the url and login with valid credentials  
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data for record
	And enter past year
		
	@SupplementaryBudget_BP_SB_08_04
	Scenario: To verify system displays the validation message when user try to raise monthly supplementory request for Lapsed period 
	Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data for the record
	And enter Lapsed period
	
	@SupplementaryBudget_BP_SB_11_01
  Scenario: To verify Annually option is available on screen to raise Annually supplementary request
  Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page 
 Then fill the input fields
 Then validate yearly supplementary apportion field
  
  @SupplementaryBudget_BP_SB_11_02
  Scenario: To verify user is able to raise supplementary request for Annually budget
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget

  
 @SupplementaryBudget_BP_SB_11_03
  Scenario: System should not allow user to raise Annually supplementory request for past
	Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
  When maker click on budget supplementary eye icon
  And click on add button on budget supplementary view page 
  Then FillS the Input fields 
  Then validate maker cannot raise budget for past year
 
@SupplementaryBudget_BP_SB_11_04
  Scenario: System should not allow user to raise Annually supplementory request for Lapsed period
Given maker should navigate to the url and login with valid credentials
And maker should navigate to the budget module
And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page 
 Then FillS the Input fieldss
 
 @SupplementaryBudget_BP_SB_06_03
	Scenario: To verify checker is able to Return the Supplementory Budgets record 
Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Given Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
And Verify the record is Return

@SupplementaryBudget_BP_SB_03_01
	Scenario: To verify checker is able to Approve the Supplementory Budgets record 
Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Given Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
And Verify the record is Approved 

#-----------------------Tushar----------------------#

#-----11_02-------#

@Budget_BudgetSupplementary_BP_SB_03_02
Scenario: BP_SB_03_02	To verify system generates notification at checker login
 if maker user creates Supplementory Budgets record and submit the record to checker
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 And Find the budget code which is submitted from maker
Then Click on action Button
And Verify the record is generated by opening the record
@Budget_BudgetSupplementary_BP_SB_04_01
Scenario: BP_SB_04_01 To verify whether user is able to reject the Supplementory Budgets
 record where single approval is configured
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 Then Click  on action button of record user want to reject
 Then Click  on reject button
 @Budget_BudgetSupplementary_BP_SB_04_04
 Scenario: BP_SB_04_04	If checker user clicks on reject button then record should
  get rejected and Supplementory Budgets record should not get added into the system
  #We cant validate that where rejected record is going as system delete the record
Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 Then Click on action  button of record user want to reject the record.
 Then Click on reject the button.
 @Budget_BudgetSupplementary_BP_SB_06_01
 Scenario: BP_SB_06_01	System should display notification to checker user for approving/rejecting the task or record
 
Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 Then Click  on action  button of record user want to approv or reject
 @Budget_BudgetSupplementary_BP_SB_06_06
 Scenario: BP_BC_06_06	To verify system prompt the confirmation message post clicking on Return button
Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget
Then Navigate  to URL and login to Checker1
 When Click  on the Security management
 Then Click  on open pool & click clam button
 Then Click  on the Notification
 Then Click  on  action  button of record user want to Return
 Then Capture  the popup that shows in right corner
 
 #--------------Auto Auth---------------------#
 @SupplementaryBudget_BP_SB_01_03
Scenario: To verify the impact if user enters all the invalid details and clicking on save button
Given maker should navigate to the url and login with valid credentials
And maker should navigate to the budget module
And maker click on budget field
When maker click on budget supplementary eye icon
And click on add button on budget supplementary view page
Then fill required data for the record
And enter invalid year

#--------------------------------autoauth----------------tushar---------
   @Budget_BudgetSupplementary_BP_SB_01_04
Scenario: BP_SB_01_04	To verify user is able to create multiple records of Supplementory Budget	
 System should allow user to create multiple records of Supplementory Budget
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
Then fill the input fields
 Then fill apportion amount and save the record

Then aprove the record

Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
Then fill the input fields
Then fill apportion amount and save the record

Then aprove the record
  
  @Budget_BudgetSupplementary_BP_SB_01_02
 Scenario: BP_SB_01_02 If all the mandatory data is captured and user clicks on save button 
 then new Supplementory Budget record should get save.newly added record should get auto approved
 System should display newly created Supplementory Budget detail record in list.
 
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
Then fill apportion amount and save the record

Then aprove the record
Then Search the created record

	 