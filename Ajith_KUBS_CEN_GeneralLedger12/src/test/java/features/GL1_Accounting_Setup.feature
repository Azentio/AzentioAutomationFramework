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
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
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
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
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
Then Click on Table Row First Edit Icon
And Enter Modify Book Name
#Then Validate the Message we get
And Save the Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
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
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
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
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate to Azentio Kubs
And Click on Accounting Setup module
Then click sub module Accounting Category
Then Click on Table Row First Eye Icon