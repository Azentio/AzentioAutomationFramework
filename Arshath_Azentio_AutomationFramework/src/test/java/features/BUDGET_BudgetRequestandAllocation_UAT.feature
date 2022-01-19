Feature: Check The Azentio UAT functionaliy
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
  Then Click on to Notification icon
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
  And  Current financial Budget Year
  Then Click on the Branch field
  And Select Branch checkbox
  Then Click the Branch ok
  Then Select Which currency needed
  And Budget Amount for Budget Type Show in Budget type field
  And click on the save button
  Then click on the Maker icon button 
  And click on the Record submit
  Given Launch Url login as Reviewer
  Then Click on to Notification icon button
  And Click on to Reviewer Action icon button
  Then Click to Approve button in Reviewer
  And Submit the record in reviewer stage
  Given Launch Url login as checker page
  Then click to the security management module
  And Click to sub module open pool Click Edit icon
  Then Click the claim option icon button
  And Click on the checker notification icon button
  Then click the checker action button icon
  And Reject the Record in checker
  Then Submit the Rejecting Record in checker
  
