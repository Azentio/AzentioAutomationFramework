Feature: Check the Functionality of the GL2 Module
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

@KUBS_GL_UAT_003_003
Scenario: Create a category for the accounting type based on the base accounting book for Income
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
Then click sub module Accounting Category
Then Click on Table Row First Eye Icon

@KUBS_GL_UAT_003_004
Scenario: Create a category for the accounting type based on the base accounting book for Expenditure
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
Then click sub module Accounting Category
Then Click on Table Row First Eye Icon