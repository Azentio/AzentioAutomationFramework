Feature: to verify user can able to do transaction in petty cash module
@KUBS_PC_UAT_001_001
Scenario: Create Expense Code Limit
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And Click on Expense Code Limit
Then Click on Add Icon in Petty cash
And Get the data set id for expence code in petty cash in maker
And Enter Expense code value
Then Enter Expense Name Value
And Choose Expense Gl
Then Enter Max Limit Value
And Choose Currency value
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record in petty cash
Then Click submit button and Enter Remark submit it 
Then Get the reviewer id for expence code and store it in excel
And Close the Alert
Then logout from maker

@KUBS_PC_UAT_001_001_TC_02
Scenario: Create Expense Code Limit reviewer
And Get the data set id for expence code in petty cash
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
And logout from reviewer

@KUBS_PC_UAT_001_001_TC_03
Scenario: Create Expense Code Limit checker
And Get the data set id for expence code in petty cash
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click the First Action Icon
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from checker

@KUBS_PC_UAT_001_001_TC_04
Scenario: Create Expense Code Limit
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And Click on Expense Code Limit
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_001_002
Scenario: Create Employee Limit
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And Click on Employee Limit
Then Click on Add Icon in Petty cash
Then Get the data set id for employee limit as a maker
And Choose Employee Value
Then Enter Advance Limit
And Choose Employee Currency value
Then save Record in Petty cash
And Close the Alert
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for employee limit in petty cash
Then Click submit button and Enter Remark submit it 
Then Get the reviewer id for employee limit and store it in excel
And Close the Alert
Then logout from maker

@KUBS_PC_UAT_001_002_TC_02
Scenario: Create Employee Limit for reviewer approval
Then Get the data set id for employee limit as reviewer
Given Navigate as a Reviewer
Then Goto The Notification Icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give the Remark and Submit it
#And Give Remark and Submit
And logout from reviewer

@KUBS_PC_UAT_001_002_TC_03
Scenario: Create Employee Limit for checker approval
Then Get the data set id for employee limit as reviewer
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click First record Action icon in employee limit
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from checker

@KUBS_PC_UAT_001_002_TC_04
Scenario: Create Employee Limit for checker approval
Then Get the data set id for employee limit as a maker
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And Click on Employee Limit
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_001_003
Scenario: Create Custodian Limit
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And click on Custodian limit module
Then Click on Add Icon in Petty cash
Then Get the data set id for custodian limit in petty cash
And Enter user name in the Custodian limit 
And give maximum limit 
And give replenish limit
And enter the currency type
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for Custodian Limit in petty cash
Then Click submit button and Enter Remark submit it 
Then Get the reviewer id for Custodian limit and store it in excel
Then logout from maker

@KUBS_PC_UAT_001_003_TC_02
Scenario: Create Custodian Limit for reviewer approval
And Get the data set id for the custodaian limit reviewer approval
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
And logout from reviewer

@KUBS_PC_UAT_001_003_TC_03
Scenario: Create Custodian Limit for checker approval
And Get the data set id for the custodaian limit reviewer approval
Given Navigate as a Checker
Then Click module security management
And Claim the Record in Checker
Then Goto the Checker notification Icon
And Click First record Action icon in employee limit
Then Approve the Record in checker stage
And Give the Remark and Submit it
Then logout from checker

@KUBS_PC_UAT_001_003_TC_04
Scenario: Create Custodian Limit for maker list view validation
Then Get the data set id for custodian limit in petty cash
Given Maker Navigate to UAT URL login
Then Click on Pettycash Configuration
And click on Custodian limit module
Then Click on Table Row First Eye Icon
Then logout from maker


@KUBS_PC_UAT_002_001
Scenario: Create a fund request for Petty Cash
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Add Icon in Petty cash
And Choose the data set id for fund request in petty cash as a maker
And Enter Request Amount value
Then Enter Petty cash Remark 
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for fund request in petty cash
Then Click submit button and Enter Remark submit it 
#Then Click submit button and Enter Remark then submit it
Then Get the reviewer id for fund request and store it in excel
And Close the Alert
Then logout from maker

@KUBS_PC_UAT_002_001_TC_02
Scenario: Create a fund request for Petty Cash for reviewer approval
Then choose the data set id for fund request in petty cash as a reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
And logout from reviewer

@KUBS_PC_UAT_002_001_TC_03
Scenario: Create a fund request for Petty Cash list view validation
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_003_001
Scenario: Create reimbursement for vouchers received
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Add Icon in Petty cash
And Get the data set id for reimbursement in maker
And Choose Cash Memo Ref number
Then Enter Advance Amount value
And Choose Expense Code
Then Enter Reimbursement Amount
And Enter Reimbursement Remarks
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for reimbuursement in petty cash
Then Click submit button and Enter Remark submit it 
Then Get the reviewer id for reimburesement and store it in excel
And Close the Alert
Then logout from maker

@KUBS_PC_UAT_003_001_TC_02
Scenario: Create reimbursement for vouchers received reviewer
And Get the data set id for reimbursement in petty cash for reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Then Get the reviewer id for reimburesement and store it in excel
And logout from reviewer


@KUBS_PC_UAT_003_001_TC_03
Scenario: Create reimbursement for vouchers received checker
And Get the data set id for reimbursement in petty cash for reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Then logout from checker

@KUBS_PC_UAT_003_001_TC_04
Scenario: Create reimbursement for vouchers received list view validation
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_003_003
Scenario: Record multiple expense code at a time in the reimbursement
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Add Icon in Petty cash
And Choose the data set id reimbursement for multiple expense code
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
And Store the Referance Id and Open the Record reimbursement for multiple expense code
Then Click submit button and Enter the Remark submit it
Then Get the reviewer id for reimburesement of multiple expense code and store it in excel
And Close the Alert
Then logout from maker

@KUBS_PC_UAT_003_003_TC_02
Scenario: Record multiple expense code at a time in the reimbursement for reviewer
And choose the data set id for reimbursement for multiple expense code as reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Then Get the reviewer id for reimburesement of multiple expense code and store it in excel
And logout from reviewer

#Then Get the Checker id and store it in a excel for checker
@KUBS_PC_UAT_003_003_TC_03
Scenario: Record multiple expense code at a time in the reimbursement for checker
And choose the data set id for reimbursement for multiple expense code as reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in Reviewer
And Give Remark and Submit
Then Click submit button and Enter the Remark then submit it
Then logout from checker

@KUBS_PC_UAT_003_003_TC_04
Scenario: Record multiple expense code at a time in the reimbursement for maker list view
And Choose the data set id reimbursement for multiple expense code
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Reimbursement Eye Icon
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_004_001 
Scenario: Create a fund request for Petty Cash
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
#Then Click on the Finance
#Then Click on the Direction
#Then Click on Petty Cash button
Then Click on Fund Request eye button
Then Click on Add button to request fund
Then Get the data set id for fund request in petty cash
Then Click on Request Amount Text Box and entre amount
Then save Record in Petty cash
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for fund request2 in petty cash
Then Click submit button and Enter Remark then submit it 
Then Get the reviewer id for fund request2 and store it in excel
Then logout from maker

@KUBS_PC_UAT_004_001_TC0_02
Scenario: Create a fund request for Petty Cash reviewer
Then Get the data set id for fund request2 as a reviewer
Given Navigate as a Reviewer for fund request
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit
And logout from reviewer

@KUBS_PC_UAT_004_001_TC_03
Scenario: Create a fund request for Petty Cash list view validation
Then Get the data set id for fund request in petty cash
Given Maker Navigate to UAT URL login
Then Choose the second Tab Segment
And Click on Petty cash module
Then Click on Fund Request Eye Icon
Then Click on Table Row First Eye Icon
Then logout from maker

@KUBS_PC_UAT_004_002
Scenario: Check the GL entries for replenishment of petty cash
Given Maker Navigate to UAT URL login
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
Then Get the data set id for GL entries
And choose branchs code Id
And Get the system data for petty cash
And click on transaction from date in calender icon
Then choose from date in calender for petty cashs
And click on the transaction to date in calender icon
Then choose the To date in calender for petty cashs
And click on view button to see the Record
#Then validate voucher number for petty cash
#And Close the Alert
Then logout from maker

@KUBS_PC_UAT_005_002
  Scenario: Check amount remaining in hand Balance Should tally
Given Maker Navigate to UAT URL login
Then Selet configuration
Then User get the system for job execution
And user should navigate to job scheduler menu
When click on temp grid button of job execution
Then select the date to start jobs
#And select the date to start job
Then Click on start job
Then logout from maker

@KUBS_PC_UAT_005_002_TC_02
Scenario: Creation of reconciliation
Given Maker Navigate to UAT URL login
And user should navigate to petty cash menu
When click on eye button of reconciliation
Then Get the data set id for reconciliation
And click on add button
And Fill the required fields for reconciliations
Then save Record in Petty cash
And Close the Alert
Then Goto The Notification Icon
And Store the Referance Id and Open the Record for reconciliation in petty cash
Then Click submit button and Enter Remark then submit it 
Then Get the reviewer id for reconciliation and store it in excel
And Close the Alert
Then logout from maker

#Then Save and submit the reconciliation 
@KUBS_PC_UAT_005_002_TC_03
Scenario: Creation of reconciliation reviewer
And Get the data set id for reconciliation in reviewer
Given Navigate as a Reviewer
Then click on Notify icon
And Click First record Action icon
Then Approve the record in ReviewerStage
And Give Remark and Submit 
And logout from reviewer


@KUBS_PC_UAT_005_002_TC_04
Scenario: Creation of reconciliation maker list view   
Given Maker Navigate to UAT URL login
And user should navigate to petty cash menu
When click on eye button of reconciliation
Then click on first eye button of new record
Then Balance should tally
And maker should logout
    
#@KUBS_PC_UAT_006_001
#Scenario: Check report for fund requisition
#Given User should go to the kubs url and login as a maker user
#Then click on report icon
#And user should navigate to reports menu
#Then click on temp grid button of fund requisition report
#And select the date to check the fund requisition details are displaying
#Then click in the view button to check
#Then the report is displaying all fund requisition details
   #
#@KUBS_PC_UAT_006_002
#Scenario: Check report for petty cash receipt
#Given User should go to the kubs url and login as a maker user
#Then click on report icon
#And user should navigate to reports menu
#Then click on temp grid button of petty cash receipt report
#And select the date to check the petty cash receipt details are displaying
#Then click in the view button to check
#Then the report is displaying all the petty cash receipt details
   #
#@KUBS_PC_UAT_006_003
#Scenario: Check report for petty cash register
#Given User should go to the kubs url and login as a maker user
#Then click on report icon
#And user should navigate to reports menu
#Then click on temp grid button of petty cash register report
#And select the date to check the petty cash register details are displaying
#Then click in the view button to check
#Then the report is displaying all the petty cash register details
#


