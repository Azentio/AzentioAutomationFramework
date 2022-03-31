Feature: To test the Gendral Ledgure module 

Background: 
Given Navigate to KUBS URL and login with maker credentials
@KUBS_GL_UAT_003_001
Scenario: Create a category for the accounting type based on the base accounting book for ASSETS
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code
And select the accounting book
And enter the accounting category
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
Then verify the accounting category created

@KUBS_GL_UAT_003_002
Scenario: Create a category for the accounting type based on the base accounting book for Liability
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

@KUBS_GL_UAT_003_005
Scenario: Check the category already created and trying to create same accounting book
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
And click add icon in Gl
And enter the category code as Liability
And select the accounting book
Then verify the system should through the validation message for the excisting code

@KUBS_GL_UAT_002_006
Scenario: Delete the Accunting Book if COA is not created
When user click the Accounting setup
And click the accounting book eye icon
And get the book name
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
Then click on search
Then verify the bill is inavtive or not 

@KUBS_GL_UAT_002_008
Scenario: De-activate the account book
When user click the Accounting setup
And click the accounting book eye icon
And get the book name
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
Then click on search
Then verify the bill is inavtive or not




