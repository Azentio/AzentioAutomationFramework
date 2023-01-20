	Feature: To verify user can able to view the created budget in report
	@KUBS_UAT_KUBS_BP_UAT_004_002_01
	Scenario: Check the budget request in the report
	Given Navigate to the Azentio Url
	And Update test data for created budget present in report
	Then Click on the Finance
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

@SupplementaryBudget_KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.
Given navigate to given url and login with maker credentials
And Update test data for supplementory budget test case
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
Then validate maker can submit the record UAT