@Supplementary_Budget
Feature: Supplementary Budget Sub-module
 
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
  Scenario: To verify system allow user to raise Biannuallyl supplementory budget request for lapsed period
  	Given navigate to kubs url and login as maker user
    Then select budget menu
    And click on the eye icon of supplementary budget sub menu
    Then click on add button
    And fill the required fields for biannually type budget for lapsed period
    Then system should display validation message for lapsed period
    And maker user should logout
  	

  	
  	