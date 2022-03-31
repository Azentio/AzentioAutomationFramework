Feature: Check the Functionality of Fixed Asset module

@KUBS_FAT_UAT_002_001 @multiauth

Scenario: Create the asset limit

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record


@KUBS_FAT_UAT_001_004	
Scenario: Create GRN for the generated PO No.s
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
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_002_006
Scenario: Creation of registered asset with minimum details

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_002_007
Scenario: Creation of the registered asset with full details

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_006_001
Scenario: Check if any unused asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset

Then Click on Asset Allocation Eye button

Then Click on the add button to add new record

Then Fill the Allocation form with unused asset
Then Save the filled Allocation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_006_002
Scenario: Check if any used asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset

Then Click on Asset Allocation Eye button

Then Click on the add button to add new record

Then Fill the Allocation form with used asset details
Then Save the filled Allocation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_006_003
Scenario: Check if any impaired asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset

Then Click on Asset Allocation Eye button

Then Click on the add button to add new record

Then Fill the Allocation form with impaired asset details
Then Save the filled Allocation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
@KUBS_FAT_UAT_006_004
Scenario: Check if any re-valued asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset

Then Click on Asset Allocation Eye button

Then Click on the add button to add new record

Then Fill the Allocation form with revalued asset details
Then Save the filled Allocation

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_002_008
Scenario: Running batch job for the fixed asset
Given Navigate to kubs URL and user should login as a maker
Then Click on Job Scheduler
Then Click on Job Execution edit button
Then Click on calander to set desire date
Then click on Start the job
Then Click on refresh button
Then login with maker to check if date is changed or not

@KUBS_FAT_UAT_003_005
Scenario: Check if Depreciation is calculated after running the batch process

Given Navigate to kubs URL and user should login as a maker
Then Click on Job Scheduler
Then Click on Job Execution edit button
Then Click on calander to set desire date
Then click on Start the job
Then Click on refresh button
Then login with maker to check if date is changed or not

@KUBS_FAT_UAT_004_002
Scenario: Check the accounting Entries

Given Navigate to URL and user should login as a maker
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

@KUBS_FAT_UAT_004_004

Scenario: Check the accounting Entries

Given Navigate to URL and user should login as a maker
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


@KUBS_FAT_UAT_005_004
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record

Then validate voucher number

@KUBS_FAT_UAT_005_008

Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record

Then validate voucher number

@KUBS_FAT_UAT_004_005

Scenario: Check the Tax/GST on asset sale accordingly

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record

Then validate voucher number

@KUBS_FAT_UAT_010_002
Scenario: Check the accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in calender
And click on the transaction to date in calender icon
Then choose the To date in calender
And click on view button to see the Record

@KUBS_FAT_UAT_013_005
Scenario: Check Asset GL
Given Navigate to URL and user should login as a maker
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

Then validate voucher number

@KUBS_FAT_UAT_013_007
Scenario: Check Asset Creation(Common)

Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab

Then Click on Asset Creation Common Edit Grid
Then Fill the form
Then Click on view button to see Asset Creation report
Then verify the approved record is available in the report



