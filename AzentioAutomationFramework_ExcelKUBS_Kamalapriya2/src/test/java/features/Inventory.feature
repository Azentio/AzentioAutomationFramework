Feature: Inventory management
@KUBS_INV_MGMT_UAT_003_004

Scenario: Create branch access for requesting inventories
Given navigate to given url and login with maker credentials
Then Get the data set for requesting invetories
Then Click on Finance
#
Then Click on Inventory maintenance
Then Click on Inventory access master
Then Click on Add button
Then Fill all the required fields for requesting inventories
Then Click on Place Request checkbox
#
Then Click on save button in inventory Access Master
Then Click Notification button
And Select records which we saved
And Submit the records
@KUBS_INV_MGMT_UAT_003_004_02
Scenario: Create branch access for requesting inventories reviewer
And Get the data set id for branch access
Then Open Reviewer accounts
And Click on notification
Then Approve the record which we submitted from maker stage
@KUBS_INV_MGMT_UAT_003_004_03
Scenario: Create branch access for requesting inventories reviewer checker
And Get the data set id for branch access
Then Go to Checker account
And Clam the record
Then Click on notification and approve the records
@KUBS_INV_MGMT_UAT_003_004_04
Scenario: Create branch access for requesting inventories list view validation
Then Get the data set for requesting invetories
Given Navigate to URL and user should login as a maker
Then Click on Finance
#
Then Click on Inventory maintenance
Then Click on Inventory access master