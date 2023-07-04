Feature: Verify the functionality of teller cash transfer
@Prereq_KUBS_TCT_001
Scenario: Create fund request and submit the record
Prerequestics: Make sure Cash in hand amount should be 0
Given Navigate to Azentio Kubs
And Update test data for TCT_001
Then Click Second Segmant Icon
And Navigate to Petty cash section
Then Click on Fund Request Eye Icon
Then Click on Add Icon in Petty cash
And 74_Enter Request Amount value
Then 74_Enter Petty cash Remark 
Then save Record in Petty cash
Then Goto The Notification Icon
And 74_Store the Referance Id and Open the Record for fund request in petty cash
Then Click submit button and Enter Remark submit it for teller cash transfer
Then logout from maker
And Update test data for TCT_001
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
Then Approve the record in Reviewer
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_001
Scenario: Create a Teller Cash Transfer and submit from maker user
Given Navigate to Azentio Kubs
And Update test data for TCT_001
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Click on Add button in teller cash transfer view list
And Select the value in Target teller ID field
And Select the value in Denom Code field
And Select the value in Denom name field
And Enter the value in Quantity field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for teller cash transfer
And Store the transaction reference number for teller cash transfer
Then Click submit button and Enter Remark submit it for teller cash transfer
Then logout from maker

@KUBS_TCT_002
Scenario: Approve the Created Teller Cash Transfer in Reviewer
And Update test data for TCT_001
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
Then Approve the record in Reviewer
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_003
Scenario: Approve the Created Teller cash transfer in Checker
And Update test data for TCT_001
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Teller cash transfer
Then Goto the Checker notification Icon
And Click First record Action icon for teller cash transfer
Then Approve the Record in checker stage
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_004
Scenario: Validate the approved teller cash transfer record is present in view list
And Update test data for TCT_001
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Search the particular Transaction ref no in view list
And Select the first record in Teller cash transfer view list
And Validate the approved record is reflected in teller cash transfer view list
Then logout from maker

@Prereq_KUBS_TCT_005
Scenario: Create fund request and submit the record
Given Navigate to Azentio Kubs
And Update test data for TCT_005
Then Click Second Segmant Icon
And Navigate to Petty cash section
Then Click on Fund Request Eye Icon
Then Click on Add Icon in Petty cash
And 74_Enter Request Amount value
Then 74_Enter Petty cash Remark 
Then save Record in Petty cash
Then Goto The Notification Icon
And 74_Store the Referance Id and Open the Record for fund request in petty cash
Then Click submit button and Enter Remark submit it for teller cash transfer
Then logout from maker
And Update test data for TCT_005
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
Then Approve the record in Reviewer
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_005
Scenario: Create a Teller Cash Transfer and submit from maker user
Prerequestics: Make sure Cash in hand and Denom value should be equal
Given Navigate to Azentio Kubs
And Update test data for TCT_005
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Click on Add button in teller cash transfer view list
And Select the value in Target teller ID field
And Select the value in Denom Code field
And Select the value in Denom name field
And Enter the value in Quantity field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for teller cash transfer
And Store the transaction reference number for teller cash transfer
Then Click submit button and Enter Remark submit it for teller cash transfer
Then logout from maker

@KUBS_TCT_006
Scenario: Approve the Created Teller Cash Transfer in Reviewer
And Update test data for TCT_005
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
Then Approve the record in Reviewer
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_007
Scenario: Reject the Created Teller cash transfer in Checker
And Update test data for TCT_005
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Teller cash transfer
Then Goto the Checker notification Icon
And Click First record Action icon for teller cash transfer
And Reject the record in checker stage
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_008
Scenario: Validate the rejected teller cash transfer record is present in view list
And Update test data for TCT_005
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Search the particular Transaction ref no in view list
And Validate No Records found popup is displayed
#And Select the first record in Teller cash transfer view list
#And Validate rejected teller cash transfer record is displayed
Then logout from maker

@KUBS_TCT_009
Scenario: Create a Teller Cash Transfer and submit from maker user
Prerequestics: Make sure Cash in hand and Denom value should be equal
Given Navigate to Azentio Kubs
And Update test data for TCT_009
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Click on Add button in teller cash transfer view list
And Select the value in Target teller ID field
And Select the value in Denom Code field
And Select the value in Denom name field
And Enter the value in Quantity field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for teller cash transfer
And Store the transaction reference number for teller cash transfer
Then Click submit button and Enter Remark submit it for teller cash transfer
Then logout from maker

@KUBS_TCT_010
Scenario: Approve the Created Teller Cash Transfer in Reviewer
And Update test data for TCT_009
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
Then Approve the record in Reviewer
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_011
Scenario: Return the Created Teller cash transfer in Checker
And Update test data for TCT_009
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Teller cash transfer
Then Goto the Checker notification Icon
And Click First record Action icon for teller cash transfer
And Return the record in checker stage
And Give Remark and Submit for teller cash transfer
Then logout from maker
Given Navigate as a Reviewer for teller cash transfer
Then click on Notify icon
And Click First record Action icon for teller cash transfer
And Return the record in checker stage
And Give Remark and Submit for teller cash transfer
Then logout from maker

@KUBS_TCT_012
Scenario: Validate the returned teller cash transfer record is present in view list
And Update test data for TCT_009
Given Navigate to Azentio Kubs
Then click on Notify icon
And Click First record Action icon for teller cash transfer
And Validate the returned record is reflected in teller cash transfer view list
Then logout from maker

@KUBS_TCT_013
Scenario: Verify that teller cash transfer view list validation
Given Navigate to Azentio Kubs
And Update test data for TCT_013
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer view list
And Select the first record in Teller cash transfer view list
And Verify the back button functionality
And Navigate to Teller cash transfer temp view
And Search the Teller cash transfer record with valid credentials
And Search the Teller cash transfer record with invalid credentials
And Navigate to Teller cash transfer view list
And Search the Teller cash transfer record with valid credentials
And Search the Teller cash transfer record with invalid credentials

@KUBS_TCT_014
Scenario: Verify that Teller cash transfer View summary functionality
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to Petty cash section
And Navigate to Teller cash transfer temp view
And Select the first record in Teller cash transfer view list
And Validate the view summary functionality of Inter branch fund transfer

@KUBS_TCT_015
Scenario: Verify that created Teller cash transfer is present in Financial transaction report
Given Navigate to Azentio Kubs
And Update test data for TCT_015
And Navigate to Report segment
And Navigate to Financial transaction report
And Select the Branch value in Financial transaction report
And Select the Report type value in Financial transaction report
And Click on View button in Financial transaction report
And Validate the created teller cash transfer record is displayed in Financial transaction report


