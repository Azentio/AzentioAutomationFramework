Feature: To test the Gendral Ledgure module 

Background: 
Given Navigate to KUBS URL and login with maker credentials
@KUBS_GL_UAT_003_001
Scenario: Create a category for the accounting type based on the base accounting book for ASSETS
Given Login as a Azentio Maker
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code
And select the accounting book
And enter the accounting category
And select Gl code generation
And click on save button
And Click on notification icon
And select the first record
And click on submit button
And enter remark in alert tab 
And click on submit
Given Navigate to Url and login as a reviewer
Then Click on Notification button
And Find the code which submitted from maker
Then Click on action button
And Approve the record
Given Navigate to Url and login as a Checker
Then Click the Notification icon
And Click on security management
Then Click on open pool
And Click on claim button
Then click on notification
Then approve the records
Given Login as a Azentio Maker
When user click the Accounting setup
And click accounting category eye icon
And click the first eye icon
Then verify the accounting category created