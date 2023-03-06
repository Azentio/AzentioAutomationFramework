Feature: Check the Functionality of the GL1 Module
@KUBS_GL_UAT_001_001_1
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name 
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_2
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_3
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_4
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_002_001_1
Scenario: Creation of Accounting Books for custom template
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Custom Template
Then Choose the Template Type of Custom Template
And Enter Book Name for custom template record
Then Select system date as Effective date
And Choose the Book Type what you Need for custom template
Then Enter the Remark for custom template
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for custom template
Then Click submit button and Enter Remark submit it for custom template
Then logout from maker
@KUBS_GL_UAT_002_001_2
Scenario: Approve the Created accounting base template record in reviewer
And User Update the data set id for Custom Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for custom template accounting book
Then Approve the record in Reviewer
And Give Remark and Submit
Then logout from maker
@KUBS_GL_UAT_002_001_3
Scenario: Approve the Created accounting custom template record in Checker
And User Update the data set id for Custom Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from maker
@KUBS_GL_UAT_002_001_4
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for Custom Template verified in maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_002_002
Scenario: Check the created already and trying to create same accounting book
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User update the test data set id for accounting book already created
Then Choose the Template Type of Custom Template
And Enter Another Book Name
Then Enter the Remark for already created record
Then Validate the Message we get
Then logout from maker
@KUBS_GL_UAT_002_004_1
Scenario: Modify the accounting book
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Edit Icons
And User update the test data set id for modify accounting book
And Enter Modify Book Name
#Then Validate the Message we get
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Modify accounting book
Then Click submit button and Enter Remark submit it for modified accounting book
Then logout from maker
@KUBS_GL_UAT_002_004_2
Scenario: Approve the Modified accounting book record in reviewer
And User Update the data set id for Modified Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for modified Accounting book
Then Approve the record in Reviewer
And Give Remark and Submit
Then logout from maker
@KUBS_GL_UAT_002_004_3
Scenario: Approve the Modified accounting book record in checker
And User Update the data set id for Modified Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give the Remark and Submit it for Modified accounting book
Then logout from maker
@KUBS_GL_UAT_002_004_4
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for Modified accounting book
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And User verify the Modified accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_001_001_1_Prq1
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name1
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_2_Prq2
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_3_Prq3
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_4_Prq4
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_002_006_1
Scenario: Delete the Accunting Book if COA is not created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
And User update the test data set id for Delete the accounting book
And search the created Accounting book
And Click the status and select deactivate
Then save the Accounting book record 
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for delete accounting book
Then Click submit button and Enter Remark submit it for delete accounting book
Then logout from maker
@KUBS_GL_UAT_002_006_2
Scenario: Approve the deactivated accounting book record in reviewer
And User update the test data set id for Delete the accounting book reviewer
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for deactivated Accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for delete accounting book
Then logout from maker
@KUBS_GL_UAT_002_006_3
Scenario: Approve the deactivated accounting book record in checker
And User update the test data set id for Delete the accounting book reviewer
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for deactivated Accounting book
Then Approve the Record in checker stage
And Give Remark and Submit for delete accounting book
Then logout from maker 
@KUBS_GL_UAT_002_006_4
Scenario: Verify the accounting book is deactivated 
And User update the test data set id for verify accounting book is deactivated
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
And User Search the deactivated Book name
Then verify the bill is inactive or not 
Then logout from maker
#Before scenario need to execute custom Template Accounting book creation
@KUBS_GL_UAT_002_001_1_CTPRQ1
Scenario: Creation of Accounting Books for custom template
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Custom Template
Then Choose the Template Type of Custom Template
And Enter Book Name1 for custom template record
Then Select system date as Effective date
And Choose the Book Type what you Need for custom template
Then Enter the Remark for custom template
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for custom template
Then Click submit button and Enter Remark submit it for custom template
Then logout from maker
@KUBS_GL_UAT_002_001_2_CTPRQ1
Scenario: Approve the Created accounting base template record in reviewer
And User Update the data set id for Custom Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for custom template accounting book
Then Approve the record in Reviewer
And Give Remark and Submit
Then logout from maker
@KUBS_GL_UAT_002_001_3_CTPRQ1
Scenario: Approve the Created accounting custom template record in Checker
And User Update the data set id for Custom Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from maker
@KUBS_GL_UAT_002_001_4_CTPRQ1
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for Custom Template verified in maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_002_008_1
Scenario: De-activate the account book
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
And User update the test data set id for Deactivate the accounting book
And search the created Accounting book for De Active accounting book
And Click the status and select deactivate
Then save the Accounting book record
And User Close the Workflow iniatiated Pop up in GL 
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Deactivate the accounting book
Then Click submit button and Enter Remark submit it for Deactivate the accounting book
Then logout from maker
@KUBS_GL_UAT_002_008_2
Scenario: Approve the deactivated accounting book record in reviewer
And User update test data set id for Deactive accounting book record in reviewer or Checker
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for deactivated Accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for deactivate the accounting book
Then logout from maker
@KUBS_GL_UAT_002_008_3
Scenario: Approve the deactivated accounting book record in checker
And User update test data set id for Deactive accounting book record in reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for deactivated Accounting book
Then Approve the Record in checker stage
And Give Remark and Submit for deactivate the accounting book
Then logout from maker
@KUBS_GL_UAT_002_008_4
Scenario: Verify the accounting book is deactivated
And User update test data set id for verify the deactivated accounting book
Given Navigate to the Azentio Url
And Click on Finance Option for GL
When user click the Accounting setup
And click the accounting book eye icon
And Click On Search Icon
Then verify the bill is inactive or not
Then logout from maker
# prerequites for creation of category code for Assets category
@KUBS_GL_UAT_001_001_1PRQ1
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name2
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_2PRQ1
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_3PRQ1
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_4PRQ1
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_003_001_1
Scenario: Create a category for the accounting type based on the base accounting book for ASSETS
And User Update the test data set id for category record Assets
Given Navigate to the Azentio Url
And Click on Finance Option for GL
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code
And select the accounting book
And enter the accounting categorys
And select Gl code generations
And click on save the accounting record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for category record Assets
Then Click submit button and Enter Remark submit it for category record Assets
Then logout from maker
@KUBS_GL_UAT_003_001_2
Scenario: Approve the created category record for the accounting type based on the base accounting book for ASSETS in Reviewer
And User Update the test data set id for approve category record Assets in Reviewer or Checker
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for category records
Then Approve the record in Reviewer
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_001_3
Scenario: Approve the created category record for the accounting type based on the base accounting book for ASSETS in Checker
And User Update the test data set id for approve category record Assets in Reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for category records
Then Approve the Record in checker stage
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_001_4
Scenario: Verify the Created Category record reflected in Maker view
And User Update the test data set id to Verify the created category in Maker
Given Navigate to the Azentio Url
And Click on Finance Option for GL
When user click the Accounting setups
And click accounting category eye icon
Then verify the accounting category created
Then logout from maker
@KUBS_GL_UAT_001_001_1PRQ2
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name3
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_2PRQ2
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_3PRQ2
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_4PRQ2
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_003_002_01
Scenario: Create a category for the accounting type based on the base accounting book for Liability
And User update the test data set id for category record Liability
Given Navigate to the Azentio Url
And Click on Finance Option for GL
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And enter the category code as Liability
And select the accounting book
And enter the accounting category as Liability
And select Gl code generation for Liability category record
And click on save the accounting record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Category record Liability
Then Click submit button and Enter Remark submit it for Category Record Liability
Then logout from maker
@KUBS_GL_UAT_003_002_02
Scenario: Approve the created category record for the accounting type based on the base accounting book for Liability in Reviewer
And User update the test data set for Category record Liability In Reviewer or Checker
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for category records
Then Approve the record in Reviewer
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_002_03
Scenario: Approve the created category record for the accounting type based on the base accounting book for Liability in Checker
And User update the test data set for Category record Liability In Reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for category records
Then Approve the Record in checker stage
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_002_04
Scenario: Verify the created category record is reflected in Maker list view 
And User Update the test data set id to Verify the created category Liability in Maker
Given Navigate to the Azentio Url
And Click on Finance Option for GL
When user click the Accounting setup
And click accounting category eye icon
Then verify the accounting category created for liability
Then logout from maker
@KUBS_GL_UAT_001_001_01PRQ3
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name4
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_02PRQ3
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_03PRQ3
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_04PRQ3
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_003_003_01
Scenario: Create a category for the accounting type based on the base accounting book for Income
And User update the test data set id for category record Income
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then click sub module Accounting Category
And Click on Add icon
And enter the category code as Income
And select the accounting book
And enter the accounting category as Income
And select Gl code generation for Income Category record
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Category record Income
Then Click submit button and Enter Remark submit it for Category Record Income
Then logout from maker 
@KUBS_GL_UAT_003_003_02
Scenario: Approve the created category record for the accounting type based on the base accounting book for Income in Reviewer
And User update the test data set for Category record Income In Reviewer or Checker
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for category records
Then Approve the record in Reviewer
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_003_03
Scenario: Approve the created category record for the accounting type based on the base accounting book for Income in Checker
And User update the test data set for Category record Income In Reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for category records
Then Approve the Record in checker stage
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_003_04
Scenario: Verify the created category record is reflected in Maker list view
And User Update the test data set id to Verify the created category Income in Maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then click sub module Accounting Category
Then verify the accounting category created for Income
Then logout from maker
@KUBS_GL_UAT_001_001_01PRQ4
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name5
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_02PRQ4
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_03PRQ4
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_04PRQ4
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_003_004_01
Scenario: Create a category for the accounting type based on the base accounting book for Expenditure
And User update the test data set id for category record Expenditure
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then click sub module Accounting Category
And Click on Add icon
And enter the category code as Expenditure
And select the accounting book
And enter the accounting category as Expenditure
And select Gl code generation for Expenditure Category record
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Category record Expenditure
Then Click submit button and Enter Remark submit it for Category Record Expenditure 
Then logout from maker
@KUBS_GL_UAT_003_004_02
Scenario: Approve the created category record for the accounting type based on the base accounting book for Expenditure in Reviewer
And User update the test data set for Category record Expenditure In Reviewer or Checker
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for category records
Then Approve the record in Reviewer
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_004_03
Scenario: Approve the created category record for the accounting type based on the base accounting book for Expenditure in Checker
And User update the test data set for Category record Expenditure In Reviewer or Checker
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click First record Action icon for category records
Then Approve the Record in checker stage
And Give Remark and Submit for category records
Then logout from maker
@KUBS_GL_UAT_003_004_04
Scenario: Verify the created category record is reflected in Maker list view
And User Update the test data set id to Verify the created category Expenditure in Maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then click sub module Accounting Category
Then verify the accounting category created for Expenditure
Then logout from maker
# before execution Preq liablitiy test case need to execute
@KUBS_GL_UAT_001_001_01PRQ5
Scenario: Create an accounting base templet for accounting book for legal entity
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
And Click on Add icon
And User Update the data set id for Base Template
Then Choose the Template Type of Base Template
And Enter Book Name6
And User Update the data set id for Base Template
Then Select system date as Effective date
And Choose the Book Type what you Need
Then Enter the Remark
And Save the Record
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Base Template Accounting Book
Then Click submit button and Enter Remark submit it for Gl Record
Then logout from maker
@KUBS_GL_UAT_001_001_02PRQ5
Scenario: Approve the Created accounting base templet record in reviewer
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Reviewer for GL
Then click on Notify icon
And Click First record Action icon for accounting book
Then Approve the record in Reviewer
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_03PRQ5
Scenario: Approve the Created accounting base templet record in Checker
And User Update the data set id for Base Template Accounting Book Reviewer submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for GL
Then Goto the Checker notification Icon
And Click the  Action Icon for accounting book record
Then Approve the Record in checker stage
And Give Remark and Submit for accounting base template reviewer
Then logout from maker
@KUBS_GL_UAT_001_001_04PRQ5
Scenario: Verify the Approved accounting book record in maker
And User Update the data set id for verify Base Template book created
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And Click on Accounting Setup module
Then Click sub module Accounting book definition
Then Click on Table Row First Eye Icon
And System should Generate unique code
Then Click sub module Accounting book definition
And User verify the created accounting book in maker view
Then logout from maker
@KUBS_GL_UAT_003_005
Scenario: Check the category already created and trying to create same accounting book
And User Test data set for category already created and trying to create same accounting book
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
When user click the Accounting setup
And click accounting category eye icon
And click add icon in Gl
And Enter the old accounting category as Liability
And Enter the old accounting book
Then verify the system should through the validation message for the existing code
Then logout from maker
# for individual execution prereq Expenditure Accounting Category
@KUBS_GL_UAT_005_001_01
Scenario: Create chart of account for Parent GL (COA)
When User Update the Test data Set id for COA Parent GL
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then Click on COA add button
And User Select Accounting Category
And User enter the coa name
#And User select the parent GL
And User select the GL type 
And User Select the balance type
And User enter description in COA definition
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Parent GL
Then Click submit button and Enter Remark submit it for Parent GL
Then logout from maker
@KUBS_GL_UAT_005_001_02
Scenario: Approve the COA record for Parent GL in Reviewer
When User Update the Test data set id for COA Parent GL in Reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_001_03
Scenario: Approve the COA record for Parent GL in Checker
When User Update the Test data set id for COA Parent GL in Reviewer or Checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_001_04
Scenario: Verify the created COA record in Maker
When User Update the test data set id for verify created COA Parent GL
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then User Verify Approved COA record for Parent GL in Maker
Then logout from maker
@KUBS_GL_UAT_005_002_01
Scenario: Create a leaf GL (COA) for the parent GL
And User Update the test data set id for Creation of Leaf GL
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then Click on COA add button
And User Select Accounting Category for Leaf GL
And User enter the coa name for Leaf GL
And User select the parent GL for Leaf GL
And User select the GL type as Sub GL
And User Select the balance type for Leaf GL
And User enter description in COA definition for Leaf GL
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Leaf GL
Then Click submit button and Enter Remark submit it for Leaf GL
Then logout from maker
@KUBS_GL_UAT_005_002_02
Scenario: Approve the COA record for Leaf GL in Reviewer
And User Update the test data set for approve the COA record for Leaf GL in Reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_002_03
Scenario: Approve the COA record for Leaf GL in Checker
And User Update the test data set for approve the COA record for Leaf GL in Reviewer or Checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_002_04
Scenario: Verify the Approved the COA record for Leaf GL in Maker
And User Update the test data set id for Verify the approved the COA record of Leaf GL in Maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then User Verify Approved COA record for Leaf GL in Maker
Then logout from maker
@KUBS_GL_UAT_005_003_01
Scenario: Create different leaf gls for the node GL
And User Update the test data set id for Node GL records
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then Click on COA add button
And User Select Accounting Category for Node GL
And User enter the coa name for Node GL
And User select the parent GL for Node GL
And User select the GL type as Sub GL for Leaf GL
And User Select the balance type for Node GL
And User enter description in COA definition for Node GL
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Node GL
Then Click submit button and Enter Remark submit it for Node GL
Then logout from maker
@KUBS_GL_UAT_005_003_02
Scenario: Approve the Node GL records in Reviewer
And User Update the test data set id for Approve Node GL Records in reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_003_03
Scenario: Approve the Node GL records in Checker
And User Update the test data set id for Approve Node GL Records in reviewer or Checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_003_04
Scenario: Verify the approved Node GL records in Maker
And User Update the test data set id to Verify the approved Node GL records in Maker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then User Verify Approved COA record for Node GL in Maker
Then logout from maker
# prerequisites KUBS_GL_UAT_005_003_01,2,3,4
@KUBS_GL_UAT_005_004_01
Scenario: Create COA for the selected branch from Main Branch as per the hierarchy
And User Update the test data set id for Created COA Selected branch
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then Click on COA add button
And User Select Accounting Category for Selected branch coa creation
And User enter the coa name for Selected branch coa creation
And User select the parent GL for selected branch coa creation
And User select the GL type as Main GL for Selected branch coa creation
And User Select the balance type for Selected branch coa creation
And User enter description in COA definition for Selected branch coa creation
And User select the branch specific
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Selected branch coa creation
Then Click submit button and Enter Remark submit it for Created COA Selected branch
Then logout from maker
@KUBS_GL_UAT_005_004_02
Scenario: Approve the Created COA for the selected branch from Main Branch as per the hierarchy in Reviewer
And User Update the test data set id for approve created coa selected branch in Reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_004_03
Scenario: Approve the Created COA for the selected branch from Main Branch as per the hierarchy in Checker
And User Update the test data set id for approve created coa selected branch in Reviewer or Checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_004_04
Scenario: Verify the Created COA for the selected branch from Main Branch as per the hierarchy in Maker
And User update the test data set id for verify created coa
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then User Verify Approved COA record in Maker for selected branch
Then logout from maker
#prerequisites KUBS_GL_UAT_005_004_01,2,3,4
@KUBS_GL_UAT_005_005_01
Scenario: Modify the Chart of Account (COA)
And User update the test data set id to Modify the Chart of Account record
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
Then search COA name to modify the coa
Then click on pencil button to modify the COA
And Modify the COA Name
And Modify the GL Type
And Modify the Description
And Modify the Balance Type
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Modified COA record
Then Click submit button and Enter Remark submit it for Modified COA record
Then logout from maker
@KUBS_GL_UAT_005_005_02
Scenario: User Approve the Modified Chart of Account (COA) in reviewer
And User Update the test data id to Approve the Modified Chart of Account COA in reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_005_03
Scenario: User Approve the Modified Chart of Account (COA) in Checker
And User Update the test data id to Approve the Modified Chart of Account COA in reviewer or Checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_005_04
Scenario: User Verify the Modified Chart of Account (COA) in Maker
And User update the test data set id for verify Modified coa
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then User Verify Approved and Modified COA record in Maker
Then logout from maker
@KUBS_GL_UAT_005_006
Scenario: Check the created COA can be modified after use of COA if GL entries are passed for the COA
And User update the test data set id for modified after use of COA if GL entries are passed for the COA
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button for GL
Then search used COA code for which GL entries are passed    
Then click on pencil button to modify the COA
Then modify the COA details for which GL entries are passed
Then Save and check the modified record of used leaf COA
Then logout from maker
@KUBS_GL_UAT_005_007
Scenario: Check the created COA can be modified if Gl entries are passed for the parent being mapped or changed
And User update the test data set id for modified if Gl entries are passed for the parent being mapped or changed
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button for GL
Then search used parent COA code for which GL entries are passed
Then click on pencil button to modify the COA
Then modify the COA details for which GL entries are passed
Then Save and check the modified record of used parent COA
Then logout from maker
# prerequisites KUBS_GL_UAT_005_003_01 
@KUBS_GL_UAT_005_008_01
Scenario: Create Chart of Account Active to De-active
And User update the test data set id for Change Chart of Account Active to De active
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button for GL
Then search COA name to modify the coa1
Then click on pencil button to modify the COA
Then Inactive the active Chart of account
And Save the Record for COA creation
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for deactivated COA record
Then Click submit button and Enter Remark submit it for deactivated COA record
Then logout from maker
#Then Save the Record and submit the created record of COA
@KUBS_GL_UAT_005_008_02
Scenario: Approve the deactivated COA record in Reviewer
And User update test data set id to Approve the deactivated COA record in Reviewer or Checker
Given Azentio Url login as Reviewer
Then Click on Reviewer Notification icon
And Click on First Action button for COA records
Then Click on to Approve button in Reviewer
And Give Remark and Submit for COA records
Then logout from maker
@KUBS_GL_UAT_005_008_03
Scenario: Approve the deactivated COA record in Checker
And User update test data set id to Approve the deactivated COA record in Reviewer or Checker
Given Azentio Url login as checker page
Then click on the security management
And Click on the sub module open pool near Edit icon
And Claim the Record in Checker for GL
Then click on notification in checker
And Click on First Action button for COA records
Then checker should approved the COA record
Then logout from maker
@KUBS_GL_UAT_005_008_04
Scenario: Verify the deactivated COA record in Checker
And User Update test data set id to Verify the deactivated COA record in Checker
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
And user should navigate to accounting setup menu
Then click on eye button of chart of accounts definition submenu
Then click on search button
Then search COA name to modify the coa1
And Verify the deactivated COA record shows In active in List view
Then logout from maker
@KUBS_GL_UAT_005_009
Scenario: If COA marked as de-active when accounting transaction carried out
And User Update test data set id for COA marked as de active when accounting transaction carried out
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
Then click on accounting setup
Then Click on Chart of account definition
Then Click on search button to search COA
Then Click on Edit button to edit COA record
Then Click on status to make it inactive
Then Click on save button to save record
Then Validation message should pop up
Then logout from maker
@KUBS_GL_UAT_007_001
Scenario: Check the accounting mapping done for the accounting Scheme
Given Navigate to Azentio Kubs
And Click on Finance Option for GL
When user click the Accounting setup
And click the accounting scheme definition eye icon
And click the search icon
And search the active status in list view
And get the accounting scheme name in first list view
And click the Accounting Scheme Event Mapping Eye icon
And click add icon in Gl
Then verify the mapping of accounintg entries to be triggered
Then logout from maker