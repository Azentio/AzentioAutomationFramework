Feature: Check the Functionality of AR/AP Module

@TC_004 @multiauth
 
Scenario: Create GRN against above create PO for above vendor

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN


Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
Then Click on GRN item save button

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton

@TC_007	
Scenario: Verify Approved GRN Reference is available on Fixed Asset creation.

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@TC_003
Scenario: Verify PO is emailed to Vendor post approval of PO	GRN should be created successfully 
and displayed in approved queue with Active Status.


Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset

Then Click on Asset Creation eye button
Then Fill the form and check if GRN is showing or not which we created

@KUBS_AR/AP_UAT_002_004	@TC_01
Scenario: Create Advance against PO


Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
Then Fill the form for Account Recivable
Then Click on save button to save the Record for Account Recivable

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

@KUBS_AR/AP_UAT_002_004 @TC_03
Scenario: Verify creating advane against PO with amount greater than PO amount is not allowed
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
Then Fill the form for Account Recivable with amount greater than PO amount

@KUBS_AR/AP_UAT_007_001
Scenario: Auto payouts for approved Bills of a Vendor
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable

Then Click on Auto Payout edit grid
Then Click on action button of record which we need to verify for details


@KUBS_AR/AP_UAT_011_001
Scenario: Cancellation of approved receipts	Cancel approved receipts through Cheque Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals formm
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

@KUBS_AR/AP_UAT_011_001_TC_02
Scenario: Cancel approved receipts through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable
Then Click on  Receipts reversals eye button
Then Click on add button of  Receipts reversals
Then Fill all the details of  Receipts reversals form
Then Click on save button of  Receipts reversals form
Then Click on Edit Grid of Receipts reversals
Then Open first record from Edit Grid of Receipts reversals
Then Click on initiate

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

@KUBS_AR/AP_UAT_011_002_TC_01
Scenario: Cancel receipt appropriation through cheque mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record

@KUBS_AR/AP_UAT_011_002_TC_02
Scenario: Cancel receipt appropriation through Online Mode

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on receipt appropriation Reversal
Then Click on add button of receipt appropriation
Then Fill all the details of receipt appropriation for online mode
Then Click on save button of receipt appropriation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open the Reviewer account
Then Click on the Notification
Then Approve the record which we submitted from maker
Then Go to Checker login
Then Clam record
Then Click on the notification and approve the record


@KUBS_AR/AP_UAT_013_001_TC_04

Scenario: Verify Creating GRN is not allowed if total QTY of previous and current GRN is greater than PO Qty

Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN


Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add Excessive PO qty received qty approved

@KUBS_AR/AP_UAT_010_005_TC_03
Scenario: Verify Credit Note is not available for appropriation against receipt.


Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction

Then Click on Accounts Recivable

Then Click on Appropriation eye button
Then Click on add button of  Appropriation
Then Verify Credit Not record is available or not


@KUBS_AR/AP_UAT_001_001_TC_005
Scenario: Verify Accounting entries post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button

Then Click on Report Tab
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status

Then Click on View button


@KUBS_AR/AP_UAT_001_005_TC_03

Scenario: Verify GRN Report post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button

Then Click on Report Tab
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status

Then Click on View button

@KUBS_AR/AP_UAT_001_004_TC_03

Scenario: Verify GRN Report post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button

Then Click on Report Tab
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status

Then Click on View button

@KUBS_AR/AP_UAT_001_001_TC_008

Scenario: Verify GRN Report post approval of GRN

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button

Then Click on Report Tab
Then Click on GRN Edit button
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status

Then Click on View button



@KUBS_AR/AP_UAT_010_005_TC_06
Scenario: Verify Balance sheet post appropriating receipts against:Debit Note ,Advance against PO, Advance to Employee

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@KUBS_AR/AP_UAT_011_001_TC_04
Scenario: Verify Balance sheet post receipt cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@KUBS_AR/AP_UAT_011_002_TC_04
Scenario: Verify Balance sheet post receipt appropriation cancellation

Given Navigate to URL and user should login as a maker
Then Click on the Finance

Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button








































