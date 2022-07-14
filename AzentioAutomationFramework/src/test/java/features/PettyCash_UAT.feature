Feature: to verify user can able to do transaction in petty cash module

@KUBS_PC_UAT_001_001
Scenario: Create Expense Code Limit
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And Click on Expense Code Limit
Then Click on Add Icon in Petty cash
And Enter Expense code value
Then Enter Expense Name Value
And Choose Expense Gl
Then Enter Max Limit Value
And Choose Currency value
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And Click on Expense Code Limit
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_001_002
Scenario: Create Employee Limit
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And Click on Employee Limit
Then Click on Add Icon in Petty cash
And Choose Employee Value
Then Enter Advance Limit
And Choose Employee Currency value
Then save Record in Petty cash
And Close the Alert
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And Click on Employee Limit
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_001_003
Scenario: Create Custodian Limit
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And click on Custodian limit module
Then Click on Add Icon in Petty cash
And Enter user name in the Custodian limit 
And give maximum limit 
And give replenish limit
And enter the currency type
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Given Navigate The Azentio Url
Then Click on Pettycash Configuration
And click on Custodian limit module
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_002_001
Scenario: Create a fund request for Petty Cash
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Add Icon in Petty cash
And Enter Request Amount value
Then Enter Petty cash Remark 
Then Click on Save button for saving record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark then submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_003_001
Scenario: Create reimbursement for vouchers received
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Add Icon in Petty cash
And Choose Cash Memo Ref number
Then Enter Advance Amount value
And Choose Expense Code
Then Enter Reimbursement Amount
And Enter Reimbursement Remarks
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter the Remark submit it
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_003_003
Scenario: Record multiple expense code at a time in the reimbursement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Add Icon in Petty cash
And Choose Cash Memo Ref number
Then Enter Advance Amount value
And Choose Expense Code
Then Enter Reimbursement Amount
And Enter Reimbursement Remarks
Then Click on Extra Add button 
And Choose Multiple Expense Code
Then Enter Multiple Reimbursement Amount
And Enter Multiple Reimbursement Remarks
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter the Remark submit it
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_004_001 
Scenario: Create a fund request for Petty Cash
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Petty Cash button
Then Click on Fund Request eye button
Then Click on Add button to request fund
Then Click on Request Amount Text Box and entre amount
Then Click on Save button for saving record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click submit button and Enter Remark then submit it 
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Table Row First Eye Icon

@KUBS_PC_UAT_004_002
Scenario: Check the GL entries for replenishment of petty cash
Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in calender for petty cash
And click on the transaction to date in calender icon
Then choose the To date in calender for petty cash
And click on view button to see the Record
Then validate voucher number for petty cash

@KUBS_PC_UAT_005_002
  Scenario: Check amount remaining in hand Balance Should tally
Given User should go to the kubs url and login as a maker user
Then Selet configuration
And user should navigate to job scheduler menu
When click on temp grid button of job execution
And select the date to start job
Then Click on start job
Given User should go to the kubs url and login as a maker user
And user should navigate to petty cash menu
When click on eye button of reconciliation
And click on add button
And Fill the required fields for reconciliation
Then Save and submit the reconciliation    
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit    
Given User should go to the kubs url and login as a maker user
And user should navigate to petty cash menu
When click on eye button of reconciliation
Then click on first eye button of new record
Then Balance should tally
And maker should logout
    
@KUBS_PC_UAT_006_001
Scenario: Check report for fund requisition
Given User should go to the kubs url and login as a maker user
Then click on report icon
And user should navigate to reports menu
Then click on temp grid button of fund requisition report
And select the date to check the fund requisition details are displaying
Then click in the view button to check
Then the report is displaying all fund requisition details
   
@KUBS_PC_UAT_006_002
Scenario: Check report for petty cash receipt
Given User should go to the kubs url and login as a maker user
Then click on report icon
And user should navigate to reports menu
Then click on temp grid button of petty cash receipt report
And select the date to check the petty cash receipt details are displaying
Then click in the view button to check
Then the report is displaying all the petty cash receipt details
   
@KUBS_PC_UAT_006_003
Scenario: Check report for petty cash register
Given User should go to the kubs url and login as a maker user
Then click on report icon
And user should navigate to reports menu
Then click on temp grid button of petty cash register report
And select the date to check the petty cash register details are displaying
Then click in the view button to check
Then the report is displaying all the petty cash register details



