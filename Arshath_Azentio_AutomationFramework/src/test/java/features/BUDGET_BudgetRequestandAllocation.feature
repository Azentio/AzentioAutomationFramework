Feature: Check Budget Request and Allocation feature module
 @KUBS_RequestandAllocation_BP_BC_05_01
  Scenario: System should follow the flow as Maker
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Select Budget Code in fields
  And  Select Current Budget Year
  Then Click on Branch
  And Select one Branch
  Then Click on Branch ok button
  Then Select Which currency we need
  And Enter Amount for which Budget Type Show in Budget type field
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click on Reviewer Action button
  Then Click on Approve button in Reviewer
  And Submit the reviewer Record
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then Click the claim option
  And Click on checker notification icon
  Then click checker action icon
  And Approve the Record
  Then Submit the Record
  
  @KUBS_Reviewer_Approve_Notification_BP_BC_05_02
  Scenario: System should follow the flow as Reviewer record approve view in Notification
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then New Budget Code
  And  Select Current Budget Year
  Then Click on Branch 
  And choose  Branch
  Then Click on Branch ok button
  Then Choose one currency 
  And Enter Amount which Budget Type Show in budget type
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Capture to Notification icon
  And Click the referance action icon
  Then Approve the record and get the Notification
  
  @KUBS_Reviewer_Approve_BP_BC_05_03
  Scenario: System should follow the flow as Record Approve in Reviewer
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Select New Budget Code in maker
  And Select Current Budget Year
  Then Click on Branch
  And choose one Branch
  Then Click on Branch ok button
  Then choose one currency 
  And Enter Amount which Budget Type Show in type field
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click to Reviewer Action button
  Then Click Approve button in Reviewer
  And Submit the reviewer Approve Record
  
  @KUBS_Reviewer_Rejecting_BP_BC_05_04
  Scenario: System should follow the flow as Record Rejecting in Reviewer
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Select New Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Select on one Branch
  Then Click on Branch ok button
  Then Select currency we need
  And Enter Amount which Budget Type Show in Budget type field
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click Reviewer Action button
  Then Click on Reject button in Reviewer
  And Submit the reviewer Rejecting Record
  
  @KUBS_Checker_Approve_Notification_BP_BC_05_05
   Scenario: System should follow the flow as Checker Approving Notification
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then current Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Choose one branch in field
  Then Click on Branch ok button
  Then Choose currency type
  And Enter Amount for Budget Type
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
	Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And  Reviewer Action button icon
  Then  Approve button in Reviewer stage
  And Submit Record
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then the claim option button
  And Onclick the checker notification icon in checker
  Then Capture the Notification is displayed
  
  @KUBS_Checker_Approve_BP_BC_05_06
   Scenario: System should follow the flow as Checker Approving
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Choose current Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Choose one Branch in branch field
  Then Click on Branch ok button
  Then Choose Need currency
  And Enter Amount for Budget Type Show in Budget type
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
	Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click Reviewer Action button icon
  Then Click Approve button in Reviewer stage
  And Submit reviewer Records
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then Click to the claim option button
  And Click on the checker notification icon in checker
  Then click to checker action icon button
  And Checker Approve the Record
  Then Submit the Approve Record in checker
  
  @KUBS_Checker_Rejecting_BP_BC_05_07
  Scenario: System should follow the flow as Checker Rejecting
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Select current Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Select one Branch in branch field
  Then Click on Branch ok button
  Then Select Need currency
  And Enter Amount for which Budget Type Show in Budget type
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
	Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click on Reviewer Action button icon
  Then Click on Approve button in Reviewer stage
  And Submit the reviewer Records
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then Click the claim option button
  And Click on checker notification icon in checker
  Then click checker action icon button
  And Checker Reject the Record
  Then Submit the Reject Record in checker
  
  @KUBS_Authorizationstatus_BP_BC_05_08
  Scenario: To check the authorization status of budget creation record post checkers approval
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Choose one current Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Choose Branch branch field
  Then Click on Branch ok button
  Then Choose Any Need currency
  And Enter Amount for Budget Type Show in Budget type field
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
	Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click on the Reviewer Action button icon
  Then Click to the Approve button in Reviewer stage
  And Submit to the reviewer Records
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then Click to claim option button
  And Click the checker notification icon in checker
  Then click to the checker action icon button
  And Checker click Approve the Record
  Then Submit to the Approve Record in checker
  And Capture the Authorization status
  
  @KUBS_Checker_Send_Notification_to_Maker_BP_BC_05_09
 Scenario: To verify system send notification to maker user once checker user approves/rejects the budget creation record 
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click on Budget Sub module Near Eye Icon
  And Click on Add icon in Request and Allocation
  Then Choose New Budget Code 
  And  Select Current Budget Year
  Then Click on Branch
  And Onclick one Branch in branch field
  Then Click on Branch ok button
  Then Choose we Need currency
  And Enter Amount On Budget Show in Budget type
  And click on save button
  Then Click on Maker Notification button
  And Click on Record submit
	Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And OnClick Reviewer Action button icon
  Then OnClick Approve button in Reviewer stage
  And Submit reviewer Record
  Given Navigate the Azentio Url login as checker
  Then click on security management
  And Click on sub module open pool near Edit icon
  Then OnClick to the claim option button
  And OnClick on the checker notification icon in checker
  Then Onclick to checker action icon button
  And Once Checker Approve the Record
  Then then Submit the Approve Record in checker
  And Navigate the Azentio Maker Url
  Then Onclick Maker Notification

 
@KUBS_SEARCH_CRITERIA_BP_BC_11_01
Scenario: System Should follow the flow as Search criteria
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click to Budget module Budget Request and Allocation Edit Icon
  And Click on search icon
  Then Enter the search code we Need
  And Click the action button
  Then Capture the code is displayed
  
 @KUBS_SEARCH_CRITERIA_MODIFICATION_BP_BC_19_01
Scenario: System Should follow the flow as Search criteria
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module
  Then Click Budget module Budget Request and Allocation Edit Icon
  And Click search icon
  Then Enter the search code
  And Click action button
  Then Capture the code
  And Modify the Code
  And After modify click save button
 
@KUBS_BP_BC_01_01_Auto_auth
Scenario: To verify post clicking on Master Budget tab budget creation screen is getting open with the respective fields
 Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button 
  And Capture the Budget Code fields
  Then Capture the Budget Name Fields
  And Capture the Budget Year fields
  Then Capture the Budget Type fields
  And Capture the Budget Budget Amount fields
  Then Capture the Budget Status fields
  And Click on Add icon Request and Allocation
  Then Capture current Budget Code 
  And  Capture current Budget Year
  Then Capture on Branch fields
  And Capture one Branch in branch field
  Then Capture on Branch ok button in pop up
  Then Capture Need currency
  And Capture Amount for which Budget Type Show in Budget type
  And Capture on save icon
  Then Click on Maker Notification icon
  And Approve the Auto auth Record
  
  @KUBS_BP_BC_01_03_Autoauth_Savarecord
Scenario: To verify the impact if user enters all the valid details and clicking on save button  
  Given Navigate the Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then choose current Budget Code 
  And   Clk current Budget Year
  Then  Clk on Branch fields
  And  Clk one Branch in branch field
  Then Clk on Branch ok button in pop up
  Then Clk Need currency
  And Select Amount for which Budget Type Show in Budget type
  And Clk on save icon
  
  @KUBS_BP_BC_01_04_Autoauth_MultipleRecords
 Scenario: To verify user is able to create multiple records of budget creation
Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then Find the updated Budget Code 
  And  Choose the current financial Budget Year
  Then Press on Branch
  And Multiselect one  Branchs
  Then Branch ok button
  And Which currency we need
  Then Enter Amount for Showing in Budget type field
  And click save button
  Then Click the Notification Action button
  And Click on Record Approve
  Given Navigate Azentio Maker Url
    Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then updated Budget Code 
  And  current financial Budget Year
  Then Mouseclk on Branch
  And Multiselect Two  Branchs
  Then Branch Mouseclk ok button
  And Mouseclk select currency we need
  Then Mouseclk and Enter Amount for Showing in Budget type field
  And Mouseclk save button
  Then Mouseclk the Action button 
  And Mouseclk on Record Approve
   Given Navigate Azentio Maker Url
    Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then Choose updated Budget Code 
  And  choose current financial Budget Year
  Then Mouseclk on Branch fields
  And Multiselect on Third  Branchs
  Then Branch Mouseclk on ok button
  And Mouseclk select which currency we need
  Then Mouseclk then Enter Amount for Showing in Budget type field
  And Mouseclk on save button
  Then Mouseclk to the Action button 
  And Mouseclk on the Record Approve
 
  @KUBS_BP_BC_01_07_Autoauth_ManualYear
  Scenario: To verify system allows  user to select financial year manually  
 Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then press current Budget Code 
  And Manual Enter current Budget Year
  
  @KUBS_BP_BC_01_08_Autoauth_pastYear
  Scenario: To verify user is able to select previous year (past).System should not allow user to select past year in financial year field
 Given Navigate Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon in Request and Allocation
  Then CLK current Budget Code 
  And  Enter and capture the Previous Budget Year

  
  @KUBS_BP_BC_01_02_Autoauth_Validation
  Scenario: To verify the impact if user enters all the invalid details and clicking on save button
  Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then choose Budget Code 
  And   Clk Budget Year
  Then  Clk Branch fields
  And  Choose Branch in branch field
  Then Clk Branch ok button in pop up
  And Capture the validation Message
  
@KUBS_BP_BC_01_06_Autoauth_CodeenterManually
 Scenario: To verify system allows  user to select budget code, manually
	Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then choose the Budget Code 
  
 