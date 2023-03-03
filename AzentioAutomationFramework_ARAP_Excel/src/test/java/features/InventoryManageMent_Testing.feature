Feature: Check the Functionality of Inventory

@KUBS_INV_MGMT_UAT_002_001_01 
Scenario: Create instrument code
Given User should go to the kubs url and login as a maker user
Then Click on Inventory Maintenance
Then Click on Instrument code master eye button
Then Click on Add button of Instrument code
And user update the data set ID for instrument code
Then Fill all the details
Then Click on save button on instrument code master
Then Save and submit the creation instrument code details
@KUBS_INV_MGMT_UAT_002_001_02 
Scenario:  Reviewer approve instrument code
And user update the data set ID for instrument code Reviewer
And User login as a reviewer for instrument code Reviewer
Then Click on notification button in reviewer
And approve the instrument code record by reviewer user
@KUBS_INV_MGMT_UAT_002_001_03
Scenario: Checker approve instrument code
And user update the data set ID for instrument code Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button for instrument code
And capture claimed status
Then click on notification in checker    
Then checker should approved the instrument code details
@KUBS_INV_MGMT_UAT_002_001_04
Scenario:To verify approve instrument code record should visible in instrument code details list
Given User should go to the kubs url and login as a maker user
Then Click on Inventory Maintenance
Then Click on Instrument code master eye button
And maker should logout

@KUBS_INV_MGMT_UAT_002_002_01
Scenario: Create denomination details
Given User should go to the kubs url and login as a maker user
And user should navigate to denomination master menu
When click on eye button of denomination master
And click on add button to create denomination details
And user update the data set ID for denomination 
And Fill the required fields to create denomination details
Then Save and submit the creation denomination details
@KUBS_INV_MGMT_UAT_002_002_02  
Scenario: Reviewer approve denomination details record
And user update the data set ID for denomination Reviewer
And User login as a reviewer for denomination Reviewer
Then Click on notification button in reviewer
And approve the denomination record by reviewer user
@KUBS_INV_MGMT_UAT_002_002_03  
Scenario: Checker approve denomination details record   
And user update the data set ID for denomination Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And capture claimed status for denomination Reviewer
And capture claimed status
Then click on notification in checker    
Then checker should approved the denomination details
#And checker should logout
@KUBS_INV_MGMT_UAT_002_002_04  
Scenario: To verify approve denomination record should visible in denomination details list
And user update the data set ID for denomination 
Given User should go to the kubs url and login as a maker user
And user should navigate to denomination master menu
When click on eye button of denomination master
And maker should logout

    
@KUBS_INV_MGMT_UAT_002_003_01 @Item_Code 
Scenario: Unique Inventory item code should be created
Given User should go to the kubs url and login as a maker user
Then Click on Inventory Maintenance
Then Click on Inventory Item Master Eye Icon
Then Click on Inventory Maintenance Add button
And user update the data set ID for Inventory item code 
Then Fill Inventory Item Mandatory fields
Then Click on Inventory Item Save button
Then Click on Inventory Item Notification 
And Select and Submit the record
@KUBS_INV_MGMT_UAT_002_003_02  
Scenario: Reviewer approve Inventory item code record
And user update the data set ID for Inventory item code Reviewer
And User login as a reviewer user for Inventory item code
Then Click on notification button in reviewer
Then click on the Notification select the record and Approve 
@KUBS_INV_MGMT_UAT_002_003_03  
Scenario: Checker approve Inventory item code record
And user update the data set ID for Inventory item code Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button for Inventory item code
And capture claimed status
Then click on notification in checker 
And select the Inventory item code record and Approve by checker
@KUBS_INV_MGMT_UAT_002_003_04  
Scenario: To verify approve Inventory item code record should visible in list
Given User should go to the kubs url and login as a maker user
Then Click on Inventory Maintenance
Then Click on Inventory Item Master Eye Icon
And maker should logout


@InventoryRequestChecking @KUBS_INV_MGMT_UAT_004_001
Scenario: To verify maker user can able to issue the inventory to requested branch
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And click on inventory management main menu
And user update the data set ID for Inventory request
Then click on view button near by inventory request menu
Then click on first eye button to get the request reference number
Then click on view button near by inventory request menu
Then select the perticular inventory record by the help of request reference number
And check the inventory requested sucessfully and capture the inventory data
When user see the inventory request reference number , The inventory was successfully requested

@InventoryStockIssue @KUBS_INV_MGMT_UAT_004_002_01 @FailTC
Scenario: To verify inventory stock to be issued to requested branch
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And click on inventory management main menu
Then click on view button near by inventory request menu
And user update the data set ID for Inventory stock
#Then click on first eye button to get the req reference number
Then click the eye icon near by inventory stock issue
And click on Add button
And enter inventory item
Then enter inventory branch
And enter inventory reference number
Then Click on Save button
Then click on notification  
Then submit the record 
@KUBS_INV_MGMT_UAT_004_002_02 
Scenario: Reviewer approve Inventory Stock Issue
And user update the data set ID for Inventory stock Reviewer
And User login as a reviewer user for Inventory stock
Then Click on notification button in reviewer
And approve the record by reviewer user for Inventory stock
@KUBS_INV_MGMT_UAT_004_002_03 
Scenario: Checker approve Inventory Stock Issue
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And capture claimed status for Inventory Stock
And capture claimed status
Then click on notification in checker 
Then checker should approved the Inventory Stock
@KUBS_INV_MGMT_UAT_004_002_04
Scenario:To verify approve Inventory Stock Issue record should visible in list
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And click on inventory management main menu
Then click the eye icon near by inventory stock issue


@KUBS_INV_MGMT_UAT_004_003_01 @StockConfirmT @multiauth @Re
Scenario: Check inventory stock confirmation
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And click on inventory management main menu
Then Click on Stock issue eye icon
And Click on First record eye icon
And user update the data set ID for Inventory stock confirmation
Then Get the New Request Referance No
Then Click on Inventory stock confirmation eye icon
And Sub module Inventory stock confirmation click Add icon
Then Enter the Request Referance Number
And Enter Item code Number
Then Accept the status in checkbox
And click the save icon for StockConfirm
And goto maker Notification Icon
Then Click Submit button to Inventory Record
And Give Remark and submit to Reviewer
@KUBS_INV_MGMT_UAT_004_003_02 
Scenario: Reviewer approve Inventory Stock Issue confirmation
And user update the data set ID for Inventory stock confirmation Reviewer
And User login as a reviewer user for Inventory stock confirmation Reviewer
Then Click on notification button in reviewer
And approve the record by reviewer user for Inventory stock confirmation Reviewer
@KUBS_INV_MGMT_UAT_004_003_03 
Scenario: Checker approve Inventory Stock Issue confirmation
And user update the data set ID for Inventory stock confirmation Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Inventory stock confirmation
And capture claimed status
Then click on notification in checker
Then Checker approve Inventory Stock Issue confirmation
@KUBS_INV_MGMT_UAT_004_003_04 
Scenario:To verify approve Inventory Stock Issue confirmation record should visible in list
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And click on inventory management main menu
Then Click on Stock issue eye icon

@KUBS_INV_MGMT_UAT_004_004GL
Scenario: Check the Gl Status
Given User should go to the kubs url and login as a maker user 
Then click on report button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And user update the data set ID for Inventory stock Gl Status
And choose the branch code
And click transaction from date calender icon
Then choose from date
And click on transaction to date calender icon
Then validate voucher number for stock issue

@KUBS_INV_MGMT_UAT_005_001_01
Scenario: Check stock return from branch
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Click Inventory Management module
And Click on stock return from branch SubModule Eye icon
Then Click on stock return from branch Add icon
And user update the data set ID for Inventory stock return 
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
@KUBS_INV_MGMT_UAT_005_001_02 
Scenario: Reviewer approve Inventory Stock return
And user update the data set ID for Inventory stock return Reviewer
And User login as a reviewer user for Inventory stock return
Then Click on notification button in reviewer
And approve the record by reviewer user for Inventory stock return
@KUBS_INV_MGMT_UAT_005_001_03 
Scenario: Checker approve Inventory Stock return
And user update the data set ID for Inventory stock return Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Inventory stock return
And capture claimed status
Then click on notification in checker
Then Checker approve Inventory stock return 
@KUBS_INV_MGMT_UAT_005_001_04 
Scenario:To verify approve Inventory Stock return record should visible in list
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Click Inventory Management module
And Click on stock return from branch SubModule Eye icon

@KUBS_INV_MGMT_UAT_005_002 @AE
Scenario: Check accounting entries
Given User should go to the kubs url and login as a maker user 
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And user update the data set ID for inventory accounting entries
And choose the branch code
And choose the Gl code
And click transaction from date calender icon
Then choose from date
And click on transaction to date calender icon
Then choose to date
And click on view button

@KUBS_INV_MGMT_UAT_007_007 
Scenario: Check instrument code report 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user update the data set ID for instrument code report 
And user should navigate to master reports menu 
Then click on temp grid button of inventory code report
And Fill the form for inventory code Report
Then click in the view button to check 
Then the report is displaying with all the details

@KUBS_INV_MGMT_UAT_007_008
Scenario: Check denomination details report
Given User should go to the kubs url and login as a maker user 
Then click on report button
Then Click on Report Tab
And user update the data set ID for denomination details report
Then Click on Fund Requisition Report edit grid
Then Fill the form for Fund Requisition Report
And Click on view button to view report of Fund Requisition Report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_009
Scenario: Check inventory item details report
Given User should go to the kubs url and login as a maker user 
Then click on report button
Then Click on Report Tab
And user update the data set ID for inventory item details report
Then Click on inventory item details Report edit grid
Then Fill the form for inventory item details Report
And Click on view button to view report of inventory item details Report
Then verify the approved record is available in the report

@KUBS_INV_MGMT_UAT_007_010
Scenario: Check inventory stock receipt report
Given User should go to the kubs url and login as a maker user 
Then click on report button
Then Click on Report Tab
And user update the data set ID for inventory stock receipt report
Then Click on inventory stock receipt Report edit grid
Then Fill the form for inventory stock receipt Report
And Click on view button to view report of inventory stock receipt Report
Then verify the approved record is available in the report
