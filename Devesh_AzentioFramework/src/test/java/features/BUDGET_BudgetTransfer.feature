Feature: Budget Transfer
  
  @BP_BT_01_01 @Autoauth
  Scenario: To verify the impact if checker1 user select, view and approve the Budget Transfer record submitted by maker user
  	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then verify the respective fields are on transfer budget screen
   	And maker user should logout
  
  # We can only raise budget transfer request.
  @BP_BT_01_06 @Autoauth
 	Scenario: To verify user is able to raise request for both budget transfer and Supplementary request.
 		Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and approve by maker to transfer
   	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field for supplementary budget type
   	And maker user should logout
   	
  @BP_BT_05_03 @Multiauth
  Scenario: To verify the impact if checker1 user select, view and approve the Budget Transfer record submitted by maker user
  	Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
 		And reviewer user logout
  	
  @BP_BT_05_06 @Multiauth
  Scenario: To verify the impact if checker2 user select, view and approve the Budget Transfer record by maker
  					user and approved by checker1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	Then click on notification
    Then checker should approve the record
    And system should show the prompt message for verification
    Then the record gets added into the system
    And checker user logout
    
  @BP_BT_05_07 @Multiauth
  Scenario: To verify the impact if checker2 user select, view and reject the Budget Transfer record details by maker
  					user and approved by checker 1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	Then click on notification
   	And Click  on action button of record user want to reject
   	Then Click  on reject button
   	And system should show the prompt message for verification
   	And checker user logout
    
  @BP_BT_10_01 @Multiauth
  Scenario: Budget Transfer with multi auth with Return Functionality from checker2 to checker1
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
  	Then approve the record by reviewer
  	And reviewer user logout
    Given Navigate to Url and login as a Checker
   	Then Click the Notification icon
   	And Click on security management
   	Then Click on open pool
   	And Click on claim button
   	Then click on notification
   	And validate the data sent by checker1 submitted by maker
  	Then checker2 should return the record
  	And system should show the prompt message for verification
 		And checker user logout
    
  @BP_BT_10_02 @Multiauth
  Scenario: Budget Transfer with multi auth with Return Functionality from checker1 to maker user
    Given navigate to kubs url and login as maker user
   	Then select budget menu
   	And click on the eye icon of budget transfer sub menu
   	Then click on add button to create record
   	And fill the required field
   	Then save and submit by maker to transfer
   	And Navigate to Url and login as a reviewer
  	Then Click on Notification button
  	And validate the data submitted by maker to checker1
    Then reviewer should return the record
  	And system should show the prompt message for verification
 		And reviewer user logout
    
    
    
    
    