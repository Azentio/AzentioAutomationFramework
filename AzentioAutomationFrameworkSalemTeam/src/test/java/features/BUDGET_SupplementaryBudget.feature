Feature: Supplementary Budget Sub-module

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

	@SupplementaryBudget_BP_SB_03_05 @Singleauth
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
	
	@SupplementaryBudget_BP_SB_06_04 @Singleauth
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
	
	@SupplementaryBudget_BP_SB_12_01 @Singleauth
  Scenario: System should display the search criteria to search the data based on specific data elements.
  Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
  When maker click on budget supplementary eye icon
	And  maker navigate to search icon and  fill the required field
	Then maker select the record
	
	 @SupplementaryBudget_BP_SB_08_01 @Singleauth
	Scenario: To verify Monthly option is available on screen to raise Monthly supplementary request
	Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill the required data 
	Then validate monthly supplementary apportion field 
	
	@SupplementaryBudget_BP_SB_08_02 @Singleauth
	Scenario: User should be able to raise supplementary request for Monthly budget
	Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data 
	Then fill apportion amount
	Then validate maker can save request for the monthly budget
	
	@SupplementaryBudget_BP_SB_08_03 @Singleauth
	Scenario: To verify system displays the validation message when user try to raise monthly supplementory request for past 
	Given maker should navigate to the url and login with valid credentials  
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data for record
	And enter past year
		
	@SupplementaryBudget_BP_SB_08_04 @Singleauth
	Scenario: To verify system displays the validation message when user try to raise monthly supplementory request for Lapsed period 
	Given maker should navigate to the url and login with valid credentials 
	And maker should navigate to the budget module
	And maker click on budget field
	When maker click on budget supplementary eye icon
	And click on add button on budget supplementary view page
	Then fill required data for the record
	And enter Lapsed period
	
	@SupplementaryBudget_BP_SB_11_01 @Singleauth
  Scenario: To verify Annually option is available on screen to raise Annually supplementary request
  Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page 
 Then fill the input fields
 Then validate yearly supplementary apportion field
  
  @SupplementaryBudget_BP_SB_11_02 @Singleauth
  Scenario: To verify user is able to raise supplementary request for Annually budget
 Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page
 Then fill the input fields
 Then fill apportion amount and save the record
 Then validate maker can save request for the Annually budget

  
 @SupplementaryBudget_BP_SB_11_03 @Singleauth
  Scenario: System should not allow user to raise Annually supplementory request for past
	Given maker should navigate to the url and login with valid credentials
	And maker should navigate to the budget module
	And maker click on budget field
  When maker click on budget supplementary eye icon
  And click on add button on budget supplementary view page 
  Then FillS the Input fields 
  Then validate maker cannot raise budget for past year
 
@SupplementaryBudget_BP_SB_11_04 @Singleauth
  Scenario: System should not allow user to raise Annually supplementory request for Lapsed period
Given maker should navigate to the url and login with valid credentials
And maker should navigate to the budget module
And maker click on budget field
 When maker click on budget supplementary eye icon
 And click on add button on budget supplementary view page 
 Then FillS the Input fieldss
 
 @SupplementaryBudget_BP_SB_06_03 @Singleauth
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

@SupplementaryBudget_BP_SB_03_01 @Singleauth
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
 Then Click  on the reject button
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
 
 #--------------Auto Auth-------------Priyanka--------#
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
  #--------------------------------autoauth----------------tushar---------
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

 #---------Devesh codes-------  
 	@BP_SB_01_01 @Autoauth
  Scenario: To verify post clicking on Supplementory Budget tab Supplementory budget screen is getting open with the respective fields.
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then verify the respective fields are on screen
   	And maker user should logout

  @BP_SB_03_03 @Singleauth
  Scenario: To verify checker user is able to select and view the Supplementory Budgets record details submitted by maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And Validate the data submitted by maker is display
    And checker user logout
    
  @BP_SB_04_03 @Singleauth
  Scenario: To verify checker user is able to select and view the Supplementory Budgets record details submitted by maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And Validate the data submitted by maker is display
    And checker user logout
    
  @BP_SB_06_02 @Singleauth
  Scenario: To verify checker user is able to select and view the Supplementory Budgets record details submitted by maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And Validate the data submitted by maker is display
    And checker user logout
    
  @BP_SB_07_02 @Singleauth
  Scenario: To verify checker user is able to select and view the Supplementory Budgets record details submitted by maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
   	And Validate the data submitted by maker is display
    And checker user logout

  @BP_SB_03_04 @Singleauth
  Scenario: To verify checker user is able to approve the Supplementory Budgets record by clicking on approve button.
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
    Then checker should approve the record
    And system should show the prompt message for verification
    Then the record gets added into the system
    And checker user logout
    
    @BP_SB_06_05 @Singleauth
  Scenario: To verify system send notification to maker user once checker user returns the Supplementory Budgets record.
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for yearly budget type
   	Then save and submit by maker
  	And maker user should logout
   	Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	And claimed status
   	Then click on notification
    Then checker should return the record
    And system should show the prompt message for verification
    Then the record gets added into the system
    And checker user logout
    Given navigate to kubs url and login as maker user
    Then click on notification
    And verify record is returned
    
  @BP_SB_09_01 @Singleauth
  Scenario: To verify Quarterly option is available on screen to raise Quarterly supplementary request
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
   	Then click on add button
   	And fill the required field for quarterly budget type
   	Then verify quarterly option is available on screen
   	And maker user should logout
   	
 	@BP_SB_09_02 @Singleauth
  Scenario: To verify user is able to raise supplementary request for Quarterly budget
    Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for quarterly budget type
    Then save the record and submit to verify
    And maker user should logout
    
  @BP_SB_09_03 @Singleauth
  Scenario: To verify system displays the validation message when user try to raise Quarterly supplementary request for past months
  	Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for Quarterly type budget for past month
    Then Save the record to verify it
    And system should display validation message
    And maker user should logout
  	
  @BP_SB_09_04 @Singleauth
  Scenario: To verify system allow user to raise Quarterly supplementory budget request for lapsed period
  	Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for Quarterly type budget for lapsed period
    Then system should display validation message for lapsed period
    And maker user should logout
    
  @BP_SB_10_01 @Singleauth
  Scenario: To verify Biannually option is available on screen to raise Biannually supplementary request
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of supplementary budget sub menu
    Then click on add button
   	And fill the required field for Biannually budget type
   	Then verify Biannually option is available on screen
   	And maker user should logout
  	
  @BP_SB_10_02 @Singleauth
  Scenario: To verify user is able to raise supplementary request for Biannually budget
  	Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for Biannually budget type
    Then save the record and submit to verify
  	
  @BP_SB_10_04 @Singleauth
  Scenario: To verify system allow user to raise Biannually supplementory budget request for lapsed period
  	Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for biannually type budget for lapsed period
    Then system should display validation message for lapsed period
    And maker user should logout
