Feature: Checking the Supplementary Budget UAT functionality

@SupplementaryBudget_KUBS_BP_UAT_005_002
Scenario: System should allocate more requested amount for the inputted budget code.

 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT


@SupplementaryBudget_KUBS_BP_UAT_005_004
Scenario: System should able to approve the supplimentary requested budget

 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT
 Then user login to checker1 UAT
 And click on notification icon UAT
 And click on action button button of the record which we want to approve UAT
 Then user approve the record UAT
 And user write the remark & submit the record UAT
 Then User should login to checker2 UAT
 Then click on open pool UAT
 And Verify for claming the record UAT
 Then User should click on notification icon on reviewer2 home page UAT
 Then Claim and approve the record UAT


@SupplementaryBudget_KUBS_BP_UAT_005_005
Scenario: Check System should able to Reject the supplimentary requested budget
	 Given maker should navigate to the url and login with valid credentials UAT
 And maker should navigate to the budget module UAT
 And maker click on budget field UAT
 When maker click on budget supplementary eye icon UAT
 And click on add button on budget supplementary view page UAT
 Then fill the input fields UAT
 Then fill apportion amount and save the record UAT
 Then validate maker can submit the record UAT
Then user login to checker1 UAT
And click on notification icon UAT
And click on action button button of the record which we want to approve UAT
Then user approve the record UAT
And user write the remark & submit the record UAT
Then User should login to checker2 UAT
Then click on open pool UAT
And Verify for claming the record UAT
Then User should click on notification icon on reviewer2 home page UAT
Then Claim and reject the record UAT

@SupplementaryBudget_KUBS_BP_UAT_005_006
Scenario: Check if supplimentary budget rejected from HO, the requested amount can not be used
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And click on add button on budget supplementary view page UAT
Then fill the input fields UAT
Then fill apportion amount and save the record UAT
Then validate maker can submit the record UAT
Then user login to checker1 UAT
And click on notification icon UAT
And click on action button button of the record which we want to approve UAT
Then user approve the record UAT
And user write the remark & submit the record UAT
Then User should login to checker2 UAT
Then click on open pool UAT
And Verify for claming the record UAT
Then User should click on notification icon on reviewer2 home page UAT
Then Claim and reject the record UAT 
Given maker should navigate to the url and login with valid credentials UAT
And maker should navigate to the budget module UAT
And maker click on budget field UAT
When maker click on budget supplementary eye icon UAT
And navigate to search icon and  fill the required field


@SupplementaryBudget_KUBS_BP_UAT_005_003
Scenario: System should allow to modify the supplimentary request budget before approval
 Given maker should navigate to the url and login with valid credentials UAT
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
Given maker should navigate to the url and login with valid credentials UAT
Then click on report segment button
Then Click on Report field
Then click on supplementary budget Report
Then Select the date
And click on view button of report
Then verify the Supplementary Budget report

