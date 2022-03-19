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
#And choose Gl code
And click on transaction from date calender icon 
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button


#ArshadCode#Executed By Tushar


#Feature: Check unwanted inventory stock can be return to the Branch
@KUBS_INV_MGMT_UAT_005_StockReturn
Scenario: Return inventories unwanted by branch to issuers

Given Azentio Maker user url
Then Click on Second icon page
And Click Inventory Management module
And Click on stock return from branch SubModule Eye icon
Then Click on stock return from branch Add icon
And Click on Request Referance No code
Then Click on Issue Referance No code
And Click on item code
And Enter Return Quantity Stock value
Then Click on Return Type and Choose Type
And Click on Return Reason and Choose Type
Then Save the Inventory Stock Record
And goto the maker Notification icon
Then Click Submit icon to Inventory Record
And Give Remark and submit Inventory field
Given Login As Reviewer user
And Goto the Reviewer Notification
Then Find submitted Record from maker End and open the Record
And Approve the Record from Reviewer End
Then Enter The Remark and submit from Reviewer End
Given Login As Checker user
Then Click module Security management
And Click Sub module open Pool
And Claim the Record Which submit from Reviewer
Then Goto the Checker Notification
And Find submitted Record from Reviewer End and Open the Record 
Then Get Item Description value
And Approve the Record from Checker End
Then Enter the Remark and submit from checker End
Given Azentio Maker user url
Then Click on Inventory Maintance module
And click on Master Item eye icon
Then click on search icon
And Give Item description value and Click Edit icon
When validate the quantity of the Item


@KUBS_INV_MGMT_UAT_004_StockConfirm
Scenario: Check inventory stock confirmation

Given Launch the Azentio maker url
Then Inventory Second direction icon
And Inventory Management Module
Then Click on Stock issue eye icon
And Click on First record eye icon
Then Get the New Request Referance No
Then Click on Inventory stock confirmation eye icon
And Sub module Inventory stock confirmation click Add icon
Then Enter Request Referance Number
And Enter Item code Number
Then Accept the status in checkbox
And click the save icon for StockConfirm
And goto maker Notification icon
Then Click Submit button to Inventory Record
And Give Remark and submit to reviewer
Given Login As Reviewer
And Goto Reviewer Notification
Then open the submitted Record from maker
And Approve the Record in Reviewer
Then Enter The Remark and submit in Reviewer
Given Login As Checker
Then Click Security management module
And Click Sub module open Pool Edit icon
And Claim the submitted Record 
Then Goto Checker Notification
And Open the Record Approve from Reviewer 
And Approve the Record in Checker End
Then Enter the Remark and submit the record in checker 

@KUBS_INV_MGMT_UAT_004_GL
Scenario: Check the Gl Status
Given Navigate kubs URL  login as maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
Then choose Gl code Id
And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record


