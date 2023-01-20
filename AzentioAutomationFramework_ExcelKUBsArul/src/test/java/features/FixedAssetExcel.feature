Feature: Check the Functionality of Fixed Asset module
@KUBS_FAT_UAT_001_004_01
Scenario: Create GRN for the generated PO No.s
Given Navigate to URL and user should login as a maker
And update test data to create GRN for generated PO
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
#Then Fill the form for GRN
And Enter GRN Business partner name
And Enter GRN Business partner branch
And Enter GRN Invoice number
And Enter GRN Delivery location
Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
Then Click on GRN item save button
Then Click on the Notification
Then Select the record which we saved
Then Submit record
@KUBS_FAT_UAT_001_004_02
Scenario: Create GRN for the generated PO No.s
And Update test data to approve GRN record in reviewer
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
@KUBS_FAT_UAT_001_004_03
Scenario: Create GRN for the generated PO No.s
And Update test data to approve GRN record in checker
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
@KUBS_FAT_UAT_001_004_04
Scenario: Create GRN for the generated PO No.s
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton

@KUBS_FAT_UAT_001_005_01
Scenario: Check the Bill Booking with all the details and submit from maker
Given User should go to the kubs url and login as a maker user
And Update test data for bill booking create and submit from maker
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And click on add button for invoice booking
And Fill the required fields for invoice booking
Then Save and submit the invoice billing
@KUBS_FAT_UAT_001_005_02
Scenario: Check the Bill Booking with all the details and approve record from reviewer
And Update test data for bill booking create and approve from reviewer
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
And approve the record by the reviewer user
@KUBS_FAT_UAT_001_005_03	
Scenario: Check the Bill Booking with all the details and approve record from checker
And Update test data for bill booking create and approve from checker
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
Then checker should approved the invoice billing
@KUBS_FAT_UAT_001_005_04
Scenario: Verify that approved bill booking record is present in view list
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
Then click on first eye button to get the system invoice number to check
And maker should logout
@KUBS_FAT_UAT_001_005_05
Scenario: Verify that approved bill booking record is present in reports
And Update test data for bill booking record is present in reports
Given User should go to the kubs url and login as a maker user
Then click on report icon
Then click on enquiry menu
Then click on temp grid button of financial transaction
And fill the reference number field of financial transaction to check accounting entries post billing
Then click on view button to view the report as per reference number


