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
Then click on notification 
And select the first record in notification 
Then submit the record 
And logout from maker end 
And login with reviewer id
Then click on notification icon in reviewer
And select our record
Then approve the record in reviewer end
And validate the approval status in reviewer end
And logout from reviewer end 
Then login with checker ID
And click on Security management menu
And click on action button near by open pool
Then clime the Record
And click on Notification icon in checker stage
Then approve the Record
And validate the approval status in checker stage
@gl
Scenario: To verify user can see the GL report for stock return to vendors
Given navigate to kubs URL and login as maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button


