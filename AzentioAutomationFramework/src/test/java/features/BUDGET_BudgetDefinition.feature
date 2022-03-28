
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

