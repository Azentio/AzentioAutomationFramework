Feature: BUDGET TRANSFER SUBMODULE UAT TESTCASES
#		Devesh's code
  @KUBS_BP_UAT_006_002
  Scenario: Check the trasnfering budget code and transferred budget code type should be same
  	Given navigate to kubs url and login as a maker user
   	Then select the budget menu in segment button
   	And click on the eye icon of budget transfer sub module
   	Then click on add button to create budget record
   	And fill the required field to transfer budget
   	Then save and submit by the maker user to transfer
   	And Navigate to the Url and login as reviewer user
  	Then Click on the Notification button
  	Then Find the budget code which is submitted by maker
  	And reviewer user should logout
    Given Navigate to kubs Url and login as a Checker user
   	And Click on the security management menu
   	Then Click on open pool sub menu
   	And Click on claim button of the submitted record
   	Then claimed status should appear
   	Then Click on the Notification button
    Then finally checker should approve the record
    And system should show prompt message for verification
    Then checker user should logout
    
#		Tushar's code
  @Budget_BudgetTransfer_UAT_006_001
	Scenario: UAT_006_001 System should transfer the requested budgeted code amount to the another budget code
		Given Maker login to KUBS UAT Url
		And Maker click on the direction tab in home page
		Then Maker click on budget
		Then Maker click on budget transfer eye button
		And Maker click on add button to create new record
		Then Maker fill the details
		And save the record

	@Budget_BudgetTransfer_UAT_006_007
	Scenario: UAT_006_007 If transfering budget code does not have sufficeint amount to transfer for the month
		Given Maker login to KUBS UAT Url
		And Maker click on the direction tab in home page
		Then Maker click on budget
		Then Maker click on budget transfer eye button
		And Maker click on add button to create new record
		Then fill the form and enter excessive budget amount to the transfer
		
#		Priyanka's code
	@BudgetTransfer_KUBS_BP_UAT_006_008_UAT
	Scenario: Check the functionality if transfering budget does not have sufficeint amount in that quarter
		Given Maker login to KUBS UAT Url
		And Maker click on the direction tab in home page
		Then Maker click on budget
		Then Maker click on budget transfer eye button
		And Maker click on add button to create new record
		Then fill the form and enter excessive budget amount to the transfer
    