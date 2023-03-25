Feature: To check BudgetDefinition moduel feature
@input_field_status 
@AutoAuth
Scenario: To verify budget code creation screen should display the required fields
#BP_MB_01_01
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then verify budget code field is enable
Then verify budget type field is enable
Then verify warning percentage fiedls is enable
Then verify budget type field is enable
Then verify remark field is enable

@budget_code_creation 
@AutoAuth
Scenario: To verify maker can able to create budget code in auto auth
#BP_MB_01_02
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on approve button
And enter remark in alert tab 
And click on submit
Then check the approval status form alert message

@Validation_Message  
@AutoAuth
Scenario: To verify maker can able to create budget code with invalid details
#BP_MB_01_03
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code which is already exist
And enter budget type
Then system should display validation message for budget code
And enter warning percentage grater than hundread
And enter budget name
Then system should display validation message for warning percentage
Then give remark
When try to click on save button but system not allow to save the record


@sameBudgetCode_validation_message
@AutoAuth
Scenario: To verifysystem through validation message when maker use same budget code and budget name
#BP_MB_01_06
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code which is already exist
And enter budget type
Then system should display validation message for budget code
And enter warning percentage
And enter budget name
Then give remark
When try to click on save button but system not allow to save the record

@ModificationHistory
@AutoAuth
Scenario: To verify user can able to see modification history of updated budget code in autoauth
#BP_MB_15_04
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And Find the budet code in the list
Then verify system should display the status of the record
And verify system should display the name or id who created the record
And verify system should display record created date
And verify system should display the name or id who made changes the record at last
And verify system should display record modified date
Then verify system should display name or id of the authorized person of that record
And verify system should diplay the authorized date 


@multipleBudgetCode
@AutoAuth
Scenario: To verify maker can able to multiple budget code in auto auth
#BP_MB_01_04
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then create first budget code
Then click on save button
Then select the first record from notification 
Then click on approve button
And enter remark in alert tab 
And click on submit
Then check the approval status form alert message
And click on budget definition sub menu and click on eye icon
And click on add icon
Then create second budget code
Then click on save button
Then select the second record from notification 
Then click on approve button
And enter remark in alert tab 
And click on submit
Then check the approval status form alert message
And click on budget definition sub menu and click on eye icon
And click on add icon
Then create Third budget code
Then click on save button
Then select the record third from notification
Then click on approve button
And enter remark in alert tab 
And click on submit
Then check the approval status form alert message








@Maker_MultiAuth
@MultiAuth
Scenario: To verify maker can able to create budget code
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id

@Check_reviewer_get_notification
@MultiAuth
Scenario: To verify reviewer can get record which is submited by maker
#BP_MB_05_02
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker

@Reviewer_MultiAuth
@MultiAuth
Scenario: To verify reviewer can able approve budget code which is submitted by maker
#BP_MB_05_03
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit

@Check_Checker_get_Notification
@MultiAuth
Scenario: To verify checker can get a notification of record which is sbmited by reviewer
#BP_MB_05_05
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area

@Checker_MultiAuth
@MultiAuth
Scenario: To verify checker can approve the record which is approved by reviewer
#BP_MB_05_06
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area
And click on action button in checker stage
Then validate the budget record
Then click on approve in checker stage
And Write remark in alert
And Submit the record from checker

@Multiauth_reviewer_rejectBudgetCode
@MultiAuth
Scenario: To verify reviewer can able to reject the budget code which is submitted by maker
#BP_MB_05_04
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the budget record is matched with maker submited record
And reject the record in reviewer stage
Then enter remark then submit in reviewer stage

@Multiauth_Checker_rejectBudgetCode
@MultiAuth
Scenario: To verify checker can reject the budget code which is approved by reviewer
#BP_MB_05_07
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on add icon
Then enter budget code
And enter budget type
And enter warning percentage
And enter budget name
Then give remark
Then click on save button
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area
And click on action button in checker stage
Then validate the budget record
Then reject the record
And write negative remark and submit it

@Maker_BudgetCode_Update
@MultiAuth
Scenario: To verify maker can update the budget code
#BP_MB_09_01
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id

@Reviewer_get_Notification_of_Updated_budgetCode
@MultiAuth
Scenario: To verify reviewer can get a notification after reviewer update the budget code and submit it for approval
#BP_MB_14_02
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker


@Updated_Budget_approve_fron_reviewer_submited_by_maker
@MultiAuth
Scenario: To Verify Reviewer can approve the record which is submitted by maker
#BP_MB_14_03
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the updated budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit

@Updated_BudgetCode_Rejected_By_Reviewer
@MultiAuth
Scenario: To verify checker can able to reject the budget code which is updated by reviewer
#BP_MB_14_04
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the updated budget record is matched with maker submited record
And reject the record in reviewer stage
Then enter remark then submit in reviewer stage

@Checker_get_notification_After_reviewer_approve_the_updated_budget_Code
@MultiAuth
Scenario: To Verify Checker can get a notification after reviewer approve the budget code which is updated by maker
#BP_MB_14_05
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the updated budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area

@Updated_Budget_Approved_By_Checker_submited_by_reviwer
@MultiAuth
Scenario: To Verify Checker can approve the record which is approved by reviewer
#BP_MB_14_06
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the updated budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area
And click on action button in checker stage
Then click on approve in checker stage
Then validate the updated budget record
And Write remark in alert
And Submit the record from checker

@Updated_Budget_Code_rejected_By_Checker
@MultiAuth
Scenario: To verify checker can able to reject the budget code after the record approved from reviewer
#BP_MB_14_07
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then search the budget code want to update
And select the budget code
And update the budget code
Then update the budget type
Then update warning percentage
Then update budget name
Then update remark
And click on save after update all the details
Then Click on notification icon
And select the first record
Then click on submit button
And enter remark in alert tab 
And click on submit
When click on submit button save the reviewer id
Given navigate to URL and login as a reviewer
Then click on notification icon
When click on notification icon to check reviewer can get a record which is submited by maker
And click on action button
Then verify the updated budget record is matched with maker submited record
And approve the record in reviewer stage
Then enter remark then submit
Given navigate to URL and login as a checker
Then click on security management menu
And click on Action icon in security management
Then clime the record
And click on notification icon in checker stage
When checker click on notification icon record might be showed in notification area
And click on action button in checker stage
Then validate the updated budget record
Then reject the record
And write negative remark and submit it
@Search_the_updated_budgetCode_and_validate
@MultiAuth
Scenario: To verify maker can able to search and view budget code
#BP_MB_15_02
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And click on search icon
Then enter the budget code to search
Then select the budget code in the search result
And validate the submited record
@Modification_history
@MultiAuth
Scenario: To verify user can able to see modification history of updated budget code
#BP_MB_15_04
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
And Find the budet code in the list
Then verify system should display the status of the record
And verify system should display the name or id who created the record
And verify system should display record created date
And verify system should display the name or id who made changes the record at last
And verify system should display record modified date
Then verify system should display name or id of the authorized person of that record
And verify system should diplay the authorized date 



##Budget request and allocation 

 @KUBS_RequestandAllocation_BP_BC_05_01
 @_Multi_auth
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
  And click on the save button
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
  @_Multi_auth
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
  And click on the save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Capture to Notification icon
  And Click the referance action icon
  Then Approve the record and get the Notification
  
  @KUBS_Reviewer_Approve_BP_BC_05_03
  @_Multi_auth
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
  And click on the save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click to Reviewer Action button
  Then Click Approve button in Reviewer
  And Submit the reviewer Approve Record
  
  @KUBS_Reviewer_Rejecting_BP_BC_05_04
  @_Multi_auth
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
  And click on the save button
  Then Click on Maker Notification button
  And Click on Record submit
  Given Navigate the Azentio Url login as Reviewer
  Then Click on Notification icon
  And Click Reviewer Action button
  Then Click on Reject button in Reviewer
  And Submit the reviewer Rejecting Record
  
  @KUBS_Checker_Approve_Notification_BP_BC_05_05
  @_Multi_auth
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
  And click on the save button
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
  @_Multi_auth
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
  And click on the save button
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
  @_Multi_auth
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
  And click on the save button
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
  @_Multi_auth
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
  And click on the save button
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
  @_Multi_auth
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
  And click on the save button
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
@_Multi_auth
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
 @_Multi_auth
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
 
@KUBS_BP_BC_01_01
@_Auto_auth
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
  
  @KUBS_BP_BC_01_03_Savarecord
  @_Autoauth
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
  
  @KUBS_BP_BC_01_04_MultipleRecords
  @_Autoauth
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
 
  @KUBS_BP_BC_01_07_ManualYear
  @_Autoauth
  Scenario: To verify system allows  user to select financial year manually  
 Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then press current Budget Code 
  And Manual Enter current Budget Year
  
  @KUBS_BP_BC_01_08_pastYear
  @_Autoauth
  Scenario: To verify user is able to select previous year (past).System should not allow user to select past year in financial year field
 Given Navigate Azentio Maker Url
  Then Click Transfer Icon
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon in Request and Allocation
  Then CLK current Budget Code 
  And  Enter and capture the Previous Budget Year

  
  @KUBS_BP_BC_01_02_Validation
  @_Autoauth
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
  
@KUBS_BP_BC_01_06_CodeenterManually
@_Autoauth
 Scenario: To verify system allows  user to select budget code, manually
	Given Navigate Azentio Maker Url
  Then Click Transfer Icon button
  And Click on Budget Module field
  Then Click on Budget Sub module Near Eye Icon button
  And Click on Add icon Request and Allocation
  Then choose the Budget Code
  
  #Budget suplimentroy
  

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
	Given maker should navigate to the url and login with valid credentials
 And maker should navigate to the budget module
 And maker click on budget field
 When maker click on budget supplementary eye icon
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
    
    
    #Budget Transfer
    
    
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
   	And claimed status
   	Then click on notification
    Then checker should approved the record
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
   	And claimed status
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
   	And claimed status
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

#-----------------Tushar feature files----------------//

# Common feature file statements.
#Scenario: 
#Given Maker login
#And Maker click on  the direction tab
#Then Maker click on the budget
#Then Maker click on  budget transfer eye button
#And Maker click on add button
#Then Maker fill the details and save
#Then Maker  click on the notification icon
#Then Maker submit the budget transfer record 

@Budget_BudgetTransfer_BP_BT_05_02 @multiauth
Scenario: BP_BT_05_02 To verify system generates notification at checker1 login 
if maker user creates Budget Transfer record and submit the record to checker
Given navigate to kubs url and login as maker user
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 

Then Navigate to Url and login as a reviewer1
When Click on Notification button
And Find the budget code which submitted from maker user
Then Click on action button
And Verify the record

@Budget_BudgetTransfer_BP_BT_05_04 @multiauth
Scenario: To verify the impact if checker1 user select, view and reject the Budget Transfer record submitted by maker user
 BP_BT_05_04 when user reject the record submitted by maker
 Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
 
Then Navigate to Url and login as a reviewer1
When Click on Notification button on reviewer1 home page
And Find the budget code which submitted from maker end
Then Click on action button on reviewer1 notification page
And Reject the record
Then Enter the remark
And Click on submit button

@Budget_BudgetTransfer_BP_BT_05_05 @multiauth

Scenario: System should display notification to checker2 user for approving/rejecting the task or record
 BP_BT_05_05 To verify system generates notification at checker2 login if maker user creates Budget Transfer record and approved by checker1
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
Then user login to checker1
And click on the notification icon

And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Verify the clamed record is showing or not

#------------------remaining codes tushar-----------
@Budget_BudgetTransfer_BP_BT_01_04 @autoauth
Scenario: (auto auth)BP_BT_01_04 To verify user is able to create multiple records of Budget Transfer	
 System should allow user to create multiple records of Budget Transfer
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record
Then Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record

#----------------priyanka feature files------------//
 
 
@BudgetTransfer_BP_BT_05_01
Scenario: To verify user is able to create a budget transfer record and submitting the record 
					for approval where multiple approvers are configured
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 

Then user login to checker1
And click on notification icon
And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Verify the clamed record is showing or not


@BudgetTransfer_BP_BT_08_01
Scenario: To verify Budget transfer is possible between any two budget codes within same branch
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker submit the budget transfer record 
Then user login to checker1
And click on notification icon
And click on action button button of the record which we want to approve
Then user approve the record
And user write the remark & submit the record
Then User should login to checker2
Then click on open pool
And Verify for claming the record
Then User should click on notification icon on reviewer2 home page
Then Claim and approve the record

@BudgetTransfer_BP_BT_10_01
Scenario: searching the Budget Transfers record through search criteria
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
Then Maker click on the search icon 
Then maker enter the required data
Then click on the matching record
#---------------------Priyanka new codes of auto auth----------
#--------------AutoAuth--------#
@BudgetTransfer_BP_BT_01_02
Scenario:  If all the mandatory data is captured and user clicks on save button
	     then new Budget Transfer record should get save.
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the details and save
Then Maker  click on the notification icon
Then Maker Approve the budget transfer record
Then Maker click on  budget transfer eye button
Then Maker click on the search icon 
Then maker enter the required data
Then click on the matching record

#--------------AutoAuth--------#
@BudgetTransfer_BP_BT_01_03
Scenario: System should throw the validation message to fill all the mandatory and 
	   valid details in the respective fields
Given Maker login
And Maker click on  the direction tab
Then Maker click on the budget
Then Maker click on  budget transfer eye button
And Maker click on add button
Then Maker fill the invalid details and try to save
    
    
