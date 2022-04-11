Feature: Check the Functionality of GL1 Module

@KUBS_GL_UAT_005_003
 
Scenario: Create different leaf gls for the node GL

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
@KUBS_GL_UAT_005_004
Scenario: Create COA for the selected branch from Main Branch as per the hierarchy

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then click on accounting setup
Then Click on Chart of account definatation
Then Click on COA add button
Then FIll the form for COA
Then Click on Save buttonT

Then Click on the Notification

Then Click on add button of branch
Then Fill the form for which branch we need to save
Then Click on save button for saving branch
Then Click on save of General Ledger

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

















