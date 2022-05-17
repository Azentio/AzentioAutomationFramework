Feature: Check the Functionality of the GL1 Module
@KUBS_GL_UAT_001_001
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
Then Choose the Template Type of Base Template
And Enter Book Name 
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
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
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code

@KUBS_GL_UAT_002_001
Scenario: Creation of Accounting Books for custom templet
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
Then Choose the Template Type of Custom Template
And Enter Another Book Name 
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code

@KUBS_GL_UAT_002_002
Scenario: Check the created already and trying to create same accounting book
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
Then Choose the Template Type of Custom Template
And Enter Another Book Name
Then Enter the Remark
Then Validate the Message we get

@KUBS_GL_UAT_002_004
Scenario: Modify the accounting book
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Edit Icons
And Enter Modify Book Name
#Then Validate the Message we get
And Save the Record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon

@KUBS_GL_UAT_002_006
Scenario: Delete the Accunting Book if COA is not created
Given Navigate to Azentio Kubs
When user click the Accounting setup
And click the accounting book eye icon
And get the book name
And Click On Search Icon
And seach the active status
And Click the status and select deactivate
Then save the Accounting book record 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
Then verify the bill is inavtive or not 

@KUBS_GL_UAT_002_008
Scenario: De-activate the account book
Given Navigate to Azentio Kubs
When user click the Accounting setup
And click the accounting book eye icon
And get the book name
And Click On Search Icon
And seach the active status
And Click the status and select deactivate
Then save the Accounting book record 
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
Then verify the bill is inavtive or not

@KUBS_GL_UAT_003_001
Scenario: Create a category for the accounting type based on the base accounting book for ASSETS
Given Navigate to the Azentio Url
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code
And select the accounting book
And enter the accounting categorys
And select Gl code generations
And click on save the accounting record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
When user click the Accounting setups
And click accounting category eye icon
Then verify the accounting category created

@KUBS_GL_UAT_003_002
Scenario: Create a category for the accounting type based on the base accounting book for Liability
Given Navigate to the Azentio Url
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code as Liability
And select the accounting book
And enter the accounting category as Liability
And select Gl code generation
And click on save the accounting record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
When user click the Accounting setup
And click accounting category eye icon
Then verify the accounting category created for liability

@KUBS_GL_UAT_003_003
Scenario: Create a category for the accounting type based on the base accounting book for Income
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
Then Choose the Template Type of Base Template
And Enter Book Name 
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
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
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click On Search Icon
When Give the type as Base Template
And Get the Account Book Name
Then click sub module Accounting Category
And Click on Add icon
And enter the category code as Income
And select the accounting book for Income
And enter the accounting category
And select Gl code generation
And Save the Record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then click sub module Accounting Category
Then Click on Table Row First Eye Icon

@KUBS_GL_UAT_003_004
Scenario: Create a category for the accounting type based on the base accounting book for Expenditure
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
Then Choose the Template Type of Base Template
And Enter Book Name 
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
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
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click On Search Icon
When Give the type as Base Template
And Get the Account Book Name
Then click sub module Accounting Category
And Click on Add icon
And enter the category code as Expenditure
And select the accounting book for Expenditure
And enter the accounting category for Expenditure
And select Gl code generation
And Save the Record
And click notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then click sub module Accounting Category
Then Click on Table Row First Eye Icon

@KUBS_GL_UAT_003_005
Scenario: Check the category already created and trying to create same accounting book
Given Navigate to Azentio Kubs
When user click the Accounting setup
And click accounting category eye icon
Then verify the accounting category created for liability
And click add icon in Gl
And enter the category code as Liability
And select the accounting book
Then verify the system should through the validation message for the excisting code

@KUBS_GL_UAT_005_001
Scenario: Create chart of account for Parent GL (COA)

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on COA add button
Then FIll the form for COA
Then Click on Save buttonT

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation

@KUBS_GL_UAT_005_002
Scenario: Create a leaf GL (COA) for the parent GL

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on COA add button
Then FIll the form for COA1
Then Click on Save buttonT

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation

@KUBS_GL_UAT_005_003
 
Scenario: Create different leaf gls for the node GL

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on COA add button
Then FIll the form for COA2
Then Click on Save buttonT

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation

@KUBS_GL_UAT_005_004
Scenario: Create COA for the selected branch from Main Branch as per the hierarchy

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on COA add button
Then FIll the form for COA3
Then Click on Save buttonT
Then Click on the Notification
#Then Click on add button of branch
#Then Fill the form for which branch we need to save
#Then Click on save button for saving branch
#Then Click on save of General Ledger
#Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation

@KUBS_GL_UAT_005_005
Scenario: Modify the Chart of Account (COA)
Given User should go to the kubs url and login as a maker user
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
Then search COA name to modify the coa 
Then click on pencil button to modify the COA
Then modify the COA details
Then Save and submit the modified record of COA
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
   
@KUBS_GL_UAT_005_006
Scenario: Check the created COA can be modified after use of COA if GL entries are passed for the COA
Given User should go to the kubs url and login as a maker user
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
Then search used COA code for which GL entries are passed    
Then click on pencil button to modify the COA
Then modify the COA details for which GL entries are passed
Then Save and check the modified record of used leaf COA
 
@KUBS_GL_UAT_005_007
Scenario: Check the created COA can be modified if Gl entries are passed for the parent being mapped or changed
Given User should go to the kubs url and login as a maker user
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
Then search used parent COA code for which GL entries are passed
Then click on pencil button to modify the COA
Then modify the COA details for which GL entries are passed
Then Save and check the modified record of used parent COA
    
@KUBS_GL_UAT_005_008
Scenario: Create Chart of Account Active to De-active
Given User should go to the kubs url and login as a maker user
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
    #Then search COA name to modify the coa
Then click on pencil button to modify the COA
Then Inactive the active Chart of account
Then Save the Record and submit the modified record of COA
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
And approve the record by the reviewer user  	
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
Then checker should approved the COA record
Then checker should approved the COA record
    
@KUBS_GL_UAT_005_009
Scenario: If COA marked as de-active when accounting transaction carried out
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on search button to search COA
Then Click on Edit button to edit COA record
Then Click on status to make it inactive
Then Click on save button to save record
Then Validation message should pop up
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation

@KUBS_GL_UAT_006_001
Scenario: Create a accounting Schemes for different products
Given Login as a Azentio Maker
When user click the Accounting setup
And click the accounting scheme definition eye icon
And click add icon in Gl
And select accounting book name
And enter the Accounting Scheme Code
And enter the Accounting Scheme name
And select expand indicator
And select Transaction Type
And click save buttons
And Click on notification icon
And select the first records
And click add icon in accounting scheme details
And select GL resource
And select CrDr flag
And select parameter String
And select expand indicator in accounting Scheme details
And select parameter
And click add icon in table
And click save button in accounting scheme
And click edit icon in accounting schemes
And select the status in accounting Scheme details
And click save button in accounting scheme
And click add icon in accounting scheme details
And select GL resource
And select Cr flag
And select parameter String
And select expand indicator in accounting Scheme details
And select parameter
And click add icon in table
And click save button in accounting scheme
And click edit icon in accounting schemes
And select the status in accounting Scheme details
And click save button in accounting scheme
And Click on notification icon
And select the first record
And click on submit buttons
And enter remark in alert tab 
And click on submits
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
Given Login as a Azentio Maker
When user click the Accounting setup
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
Then verify System should triggered the applied rule for the accounting scheme

@KUBS_GL_UAT_007_001
Scenario: Check the accounting mapping done for the accounting Scheme
Given Login as a Azentio Maker
When user click the Accounting setup
And click the accounting scheme definition eye icon
And click the search icon
And search the active status in list view
And get the accounting scheme name in first list view
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
Then verify the mapping of accounintg entries to be triggered

# - Accounting Scheme
#@KUBS_GL_UAT_007_002
#Scenario: check Accounting schemes should mapped to the same Transaction event 
#Given Login as a Azentio Maker
#When user click the Accounting setup
#And click the Accounting Scheme Event Mapping Eye icon
#And click add icon in Gl
#And select the event
#And click the Scheme
#And click Add button
#And click next Scheme
#And click Add button
#And click save button in event mapping
#And click notification button
#Then choose first record in the notification record
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#And login with reviewer credentials
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#And logout from reviewer
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
##Then logout from checker 
#Given Login as a Azentio Maker
#When user click the Accounting setup
#And click the Accounting Scheme Event Mapping Eye icon
#And click the search icon
#And search Event name based on which we created
#And clck the first edit icon in list view
#Then verify System should allow to map to the transaction event more than one Accounting Scheme##

