Feature: Verify the functionality of Inter branch fund transfer
@KUBS_IBFT_001
Scenario: Create an Inter branch Fund Trnsfer for checker approval
Given Navigate to Azentio Kubs
And Update test data for IBFT_001
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Click on Add button in Inter branch fund transfer
And Select the value in Mode of payment dropdown
And Enter the value in Instrument no
And Select the value in DR as Debit
And Select GL Code1 in GL Code field
And Enter the amount1 in Amount field
And Enter the remarks1 on Remarks field
And Click on Add button in Action section
And Select the value in DR as Credit
And Select Branch code in Branh code field
And Select GL Code2 in GL Code field
And Enter the amount2 in Amount field
And Enter the remarks2 on Remarks field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for GL2 records
Then Click submit button and Enter Remark submit it for GL2 Records
Then logout from maker

@KUBS_IBFT_002
Scenario: Approve the Created Inter branch fund transfer in Reviewer
And Update test data for IBFT_002
Given Navigate as a Reviewer for Inter branch fund transfer
Then click on Notify icon
And Click First record Action icon for Inter branch fund transfer
Then Approve the record in Reviewer
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_003
Scenario: Approve the Created Inter branch fund transfer in Checker
And Update test data for IBFT_003
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Inter branch fund transfer
Then Goto the Checker notification Icon
And Click First record Action icon for Inter branch fund transfer
Then Approve the Record in checker stage
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_004
Scenario: Verify the approved inter branch fund transfer is present in maker view list
And Update test data for IBFT_004
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Select the first record in Inter branch fund transfer view list
And Verify the given data in Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_005
Scenario: Create an Inter branch Fund Trnsfer for checker reject
Given Navigate to Azentio Kubs
And Update test data for IBFT_005
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Click on Add button in Inter branch fund transfer
And Select the value in Mode of payment dropdown
And Enter the value in Instrument no
And Select the value in DR as Debit
And Select GL Code1 in GL Code field
And Enter the amount1 in Amount field
And Enter the remarks1 on Remarks field
And Click on Add button in Action section
And Select the value in DR as Credit
And Select Branch code in Branh code field
And Select GL Code2 in GL Code field
And Enter the amount2 in Amount field
And Enter the remarks2 on Remarks field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for GL2 records
Then Click submit button and Enter Remark submit it for GL2 Records
Then logout from maker

@KUBS_IBFT_006
Scenario: Approve the Created Inter branch fund transfer in Reviewer
And Update test data for IBFT_006
Given Navigate as a Reviewer for Inter branch fund transfer
Then click on Notify icon
And Click First record Action icon for Inter branch fund transfer
Then Approve the record in Reviewer
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_007
Scenario: Approve the Created Inter branch fund transfer in Checker
And Update test data for IBFT_007
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Inter branch fund transfer
Then Goto the Checker notification Icon
And Click First record Action icon for Inter branch fund transfer
And Reject the record in checker stage
#Then Approve the Record in checker stage
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_008
Scenario: Verify the rejected inter branch fund transfer is present in maker view list
And Update test data for IBFT_008
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Select the first record in Inter branch fund transfer view list
And Verify the rejected inter branch fund transfer record is displayed
Then logout from maker

@KUBS_IBFT_009
Scenario: Create an Inter branch Fund Trnsfer for checker return
Given Navigate to Azentio Kubs
And Update test data for IBFT_009
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Click on Add button in Inter branch fund transfer
And Select the value in Mode of payment dropdown
And Enter the value in Instrument no
And Select the value in DR as Debit
And Select GL Code1 in GL Code field
And Enter the amount1 in Amount field
And Enter the remarks1 on Remarks field
And Click on Add button in Action section
And Select the value in DR as Credit
And Select Branch code in Branh code field
And Select GL Code2 in GL Code field
And Enter the amount2 in Amount field
And Enter the remarks2 on Remarks field
And Click on Save icon
And User Close the Workflow iniatiated Pop up in GL
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for GL2 records
Then Click submit button and Enter Remark submit it for GL2 Records
Then logout from maker

@KUBS_IBFT_010
Scenario: Approve the Created Inter branch fund transfer in Reviewer
And Update test data for IBFT_010
Given Navigate as a Reviewer for Inter branch fund transfer
Then click on Notify icon
And Click First record Action icon for Inter branch fund transfer
Then Approve the record in Reviewer
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_011
Scenario: Approve the Created Inter branch fund transfer in Checker
And Update test data for IBFT_011
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker for Inter branch fund transfer
Then Goto the Checker notification Icon
And Click First record Action icon for Inter branch fund transfer
And Return the record in checker stage
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker
Given Navigate as a Reviewer for Inter branch fund transfer
Then click on Notify icon
And Click First record Action icon for Inter branch fund transfer
And Return the record in checker stage
And Give Remark and Submit for Inter branch fund transfer
Then logout from maker

@KUBS_IBFT_012
Scenario: Verify the returned inter branch fund transfer is present in maker view list
And Update test data for IBFT_012
Given Navigate to Azentio Kubs
Then click on Notify icon
And Click First record Action icon for Inter branch fund transfer
#Then Click Second Segmant Icon
#And Navigate to General ledger transaction section
#And Navigate to Inter branch fund transfer temp view
#And Select the first record in Inter branch fund transfer view list
And Verify the returned inter branch fund transfer record is displayed
Then logout from maker

@KUBS_IBFT_013
Scenario: Verify that Inter branch fund transfer view list validation
Given Navigate to Azentio Kubs
And Update test data for IBFT_013
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Click on Inter branch fund transfer eye icon
And Select the first record in Inter branch fund transfer view list
And Verify the back button functionality
And Navigate to Inter branch fund transfer temp view
And Search the Inter branch fund transfer record with valid credentials
And Search the Inter branch fund transfer record with Invalid credentials
And Click on Inter branch fund transfer eye icon
And Search the Inter branch fund transfer record with valid credentials
And Search the Inter branch fund transfer record with Invalid credentials


@KUBS_IBFT_014
Scenario: Verify that Inter branch fund transfer View summary functionality
Given Navigate to Azentio Kubs
Then Click Second Segmant Icon
And Navigate to General ledger transaction section
And Navigate to Inter branch fund transfer temp view
And Select the first record in Inter branch fund transfer view list
And Validate the view summary functionality of Inter branch fund transfer
