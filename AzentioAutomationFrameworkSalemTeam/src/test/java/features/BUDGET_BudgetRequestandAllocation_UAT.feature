Feature: Check The Azentio UAT Budget Request and Allocation functionaliy

@KUBS_UAT_Monthly_KUBS_BP_UAT_002_001

Scenario: budget for Budgetcode  type monthly
  Given Navigate to the Azentio Url
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
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select to Budget Code 
  And select the Budget Year
  Then click on the Branch
  And select the one Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for Quarterly Budget type
  And click on the save button
  
  @KUBS_UAT_Halfyearly_KUBS_BP_UAT_002_003
  
  Scenario: budget for Budgetcode  type Halfyearly
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Choose to Budget Code 
  And select the Budget Year
  Then click on the Branch
  And select the Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for Halfyearly Budget type
  And click on the save button
  
  @KUBS_UAT_yearly_KUBS_BP_UAT_002_004
  
  Scenario: budget for Budgetcode  type yearly
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Choose to the Budget Code 
  And select the Budget Year
  Then click on the Branch
  And Choose to the one Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Enter the Amount for yearly Budget type
  And click on the save button
  
  @KUBS_UAT_BudgetApprove_KUBS_BP_UAT_002_005
  
  Scenario: Check requested  budget for budget code  can be approved
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then To Select the Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Choose the one Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Give Amount for Budget Type Show in Budget type field
  And click on the save button
 Then click on the Maker icon button
  And click on the Record submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker
  
  @KUBS_UAT_BudgetReject_KUBS_BP_UAT_002_006
  
  Scenario: Check requested  budget for budget code  can be Rejected
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Current Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Select Branch checkbox
  Then click on the Branch ok button
  Then select one currency we need
  And Budget Amount for Budget Type Show in Budget type field
  And click on the save button
 Then click on the Maker icon button
  And click on the Record submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Reject the Record in checker
  Then Submit the Rejecting Record in checker 
   
  @KUBS_UAT_KUBS_BP_UAT_002_007
  
  Scenario: Check the rejected budget can be used 
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Current Budget Code 
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
  Then Current Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Select Branch checkbox
  Then click on the Branch ok button
  Then select one currency we need
  And Budget Amount for Budget Type Show in Budget type field
  And Save the Record and capture the output
  
  
  @KUBS_UAT_KUBS_BP_UAT_003_001
  
  Scenario: Modificatin of the budget before HO approval
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Current Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Select Branch checkbox
  Then click on the Branch ok button
  Then select one currency we need
  And Budget Amount for Budget Type Show in Budget type field
  And click on the save button
  Then click on the Maker icon button
  And Change the Amount Before Approval
  And click on the save button
  Then click on the Maker icon button
  And click on the Record submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker	  
  
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
	Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Monthly Budget Code 
 	And select the Budget Year
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
	Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Quarterly Budget Code
 	And Enter the Budget Year
  Then click on the Branch
  And select to one Branch
  Then click on the Branch ok button
  Then select one currency we need
 	Then Give budget amount for quarterly
	
	@KUBS_UAT_KUBS_BP_UAT_003_005
	
	Scenario: Check for the budget request for Half Yearly  on  current financial year  accounting period is Jan to Dec 
	Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Halfyearly Budget Code
 	And Enter the Budget Year for halfyearly
  Then click on the Branch
  And select to one Branch
  Then click on the Branch ok button
  Then select one currency we need
	Then Give budget amount for HalfYearly	
	
	@KUBS_UAT_KUBS_BP_UAT_004_001
	
	Scenario: Check to cancel the wrongly created budget code
  Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then select the Wrong Budget Code 
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
	Given Navigate to the Azentio Url
  Then click the Two Direction Icon
  And click to the Budget
  Then click on the Budget Sub module Budget Request and Allocation Near Eye Icon
  And click on the Add icon in Request and Allocation
  Then Select the Branch Request Budget Code 
 	And select the Budget Year
  Then click on the Branch
  And Select the Requested Branch
  Then click on the Branch ok button
  Then select one currency we need
  And Give Branch requested to allocate the budget amount
  And click on the save button
 Then click on the Maker icon button
  And click on the Record submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker	
	
	