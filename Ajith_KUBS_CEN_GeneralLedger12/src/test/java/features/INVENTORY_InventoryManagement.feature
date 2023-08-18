Feature: Check unwanted inventory stock can be return to the Branch
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
Then Enter the Request Referance Number
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
Then choose the Gl code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose To date in the calender
And click on view button to see the Record

