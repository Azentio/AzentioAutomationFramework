Feature: To verify user can see the GL report for stock return to vendors
@InventoryRequestChecking @KUBS_INV_MGMT_UAT_004
Scenario: To verify maker user can able to issue the inventory to requested branch
Given navigate to kubs URL and login as maker credentials
Then click on second Segment button
And click on inventory management main menu
Then click on view button near by inventory request menu
Then select the perticular inventory record by the help of request reference number
And check the inventory requested sucessfully and capture the inventory data
When user see the inventory request reference number , The inventory was successfully requested
@InventoryStockIssue @KUBS_INV_MGMT_UAT_004
Scenario: To verify inventory stock to be issued to requested branch
Given navigate to kubs URL and login as maker credentials
Then click on second Segment button
And click on inventory management main menu
Then click the eye icon near by inventory stock issue
And click on Add button
And enter inventory item
Then enter inventory branch
And enter inventory reference number
Then Click on Save button
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
#@gl
#Scenario: To verify user can see the GL report for stock return to vendors
#Given navigate to kubs URL and login as maker
#Then click on report segment button
#And click on equiry menu
#Then click on edit icon near by fiancial transaction menu
#And choose branch code
#And choose Gl code
#And click on transaction from date calender icon 
#Then choose the from date
#And click on the transaction to date calender icon
#Then choose the to date
#And click on view button



