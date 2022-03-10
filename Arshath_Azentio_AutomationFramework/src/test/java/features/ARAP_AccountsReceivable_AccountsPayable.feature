Feature: Check the Functionality of AR/AP Module
@KUBS_AR_AP_UAT_001_001_TC_012
Scenario: Verify Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for Puchase Bill
Then Click on Table Row First Eye Icon
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved

@KUBS_AR_AP_UAT_001_001_TC_014
Scenario: Verify Accounts Payable Report post bill is approved.
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Give Pan Number in Payment settlement
Then Click on Table Row First Eye Icon
And Get Business Partner name in Payment settlement
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Accounts Payable Report
And Give Getted Business Partner Name
Then Give Current business Date
And Give Accounts Payable Status
Then Click on View button
And Verify the Accounts Payable Report is correctly displayed

@KUBS_AR_AP_UAT_001_006_TC_03
Scenario: Accounting entries post Bill is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
Then Give the Invoice Number for against PO for Expenses with Auto generate bills
Then Click on Table Row First Eye Icon
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Bill is approved Auto generate bills

@KUBS_AR_AP_UAT_002_001_TC_02
Scenario: Verify Accounting entries post Debit note is approved
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Active Value In Debit Not Status
Then Click on Table Row First Eye Icon
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Debit Note is approved

@KUBS_AR_AP_UAT_002_004_TC_02
Scenario: Verify No accounting entry is generated on approval of advances against PO
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on Active advances against PO

@KUBS_AR_AP_UAT_003_003_TC_01
Scenario: Check GRN Report
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
#Then Enter the GRN status cancel
Then Enter the GRN status Active
And Get BP Name and GRN Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module GRN Report
And Give Getted Business Partner Name
Then Give Current business Date
And Give GRN Status
Then Click on View button
And Verify the GRN Report is correctly displayed

@KUBS_AR_AP_UAT_003_003_TC_02
Scenario: Verify Accounting entries post GRN is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
Then Enter the GRN status cancel
And Get the Branchcode and Ref No
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post GRN is cancelled

@KUBS_AR_AP_UAT_003_003_TC_04
Scenario: Check PO Report
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
#Then Enter the GRN status cancel
Then Enter the GRN status Active
And Get BP Name and GRN Number
Then Click on Table Row First Eye Icon
Then Click on Item Details
And Get PO Number
Then Third Segment report Icon
And Click main module Reports
Then Click sub module Po Report
And Give Getted Business Partner Name
Then Give Current business Date
And Give GRN Status
Then Click on View button
And Verify the PO Report is correctly displayed

@KUBS_AR_AP_UAT_003_003_TC_05
Scenario: Check creating Bill against cancelled GRN is not allowed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click On GRN Eye Icon
And Click On Search Icon
Then Enter The GRN No
And Enter the GRN status
Then Click on Table Row First Eye Icon
And Get the Required Details
Then Click on Item Details
And Get PO Number
Then Open Invoice Bill Booking Eye icon
And Click Add icon button
Then Enter the Invoice Type
And Enter Business Partner Name
Then Enter Cost Center value
And Enter Supplier Referance Number
And Enter Flat Discount Invoice Amount
Then Give Mode of payment
And Save the Invoice Bill Record
Then Goto The Notification Icon
And Store the Referance Id and Open the Record
Then Click on AP Invoice Against PO Tab
And Enter The PO Number and Validate

@KUBS_AR_AP_UAT_003_003_TC_06
Scenario: Check GRN cancellation is not allowed if Bill has been approved against that GRN
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
And Enter the Invoice Bill Booking status
Then Click on Table Row First Eye Icon
And Store the Business partner Value
Then Click on AP Invoice Against PO Tab
And Get the Required Number
And Click On Main module Accounts payable
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Enter the Adjustment Item Type
And Enter the Adjustment Ref No and Validate

@KUBS_AR_AP_UAT_003_006_TC_01
Scenario: Verify Accounting entries post Debit Note is cancelled
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Debit Note is cancelled

@KUBS_AR_AP_UAT_003_006_TC_04
Scenario: Verify Cancelled Debit Note is not available for adjustment at Payment Settlement screen
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon
And Store The Business partner and Invoice Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give Business partner Name
Then Choose value date as System current date
And find the invoice reference number for cancelled DebitNote is availabe at the billing queue

@KUBS_AR_AP_UAT_003_006_TC_05
Scenario: Verify cancelling Debit Note is not allowed if the same has been adjusted at payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receivable Debit Note Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Debit Not Status
Then Click on Table Row First Eye Icon
And Get The Bp Name and Debit Number Store It
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type
And Give the Adjustment Ref No and Validate

@KUBS_AR_AP_UAT_003_009_TC_01
Scenario: Verify No accounting entry is generated on cancelling advances against PO
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on cancelling advances against PO

@KUBS_AR_AP_UAT_003_009_TC_02
Scenario: Verify cancelled advances is not available for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Cancelled Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for cancelled Advances is availabe at the billing queue

@KUBS_AR_AP_UAT_003_009_TC_03
Scenario: Verify cancelling Against PO is not allowed if the same has been adjusted at payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for Active Advances is availabe at the billing queue
Then Click the Checkbox As Tick
When Enter the Description value
And Save The Payment settlement Record
Then Click the Alert message as Yes
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
Then Choose the second Tab Segment
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner
And Give The Adjustment Type
Then Give the Adjustment Item Type as AR Advance
And Give the Advance Adjustment Ref No and Validate

@KUBS_AR_AP_UAT_004_003_TC_01
Scenario: Verify Advance (Against PO) is available in the system for payment settlement
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner Value
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
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
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number for Active Advances is availabe at the billing queue

@KUBS_AR_AP_UAT_004_003_TC_02
Scenario: Verify No accounting entries are posted post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Enter Txn Number in payment Settlement
Then Click on Table Row First Eye Icon
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No Accounting entries are posted post payment settlement approval

@KUBS_AR_AP_UAT_004_006_TC_01
Scenario: Verify Advance against PO is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name 
And Enter Business partner
Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
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
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net Adjusted Value is correctly displayed

@KUBS_AR_AP_UAT_004_006_TC_02
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the TDS % & amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_006_TC_03
Scenario: Net payable amount is correctly calculated & displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net payable amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_006_TC_04
Scenario: Verify accounting entries post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Enter Advance Against PO and Active Value In Advance Status
And Enter Advance Against Po Pan Number
Then Click on Table Row First Eye Icon
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post payment settlement approval

@KUBS_AR_AP_UAT_004_007_TC_01
Scenario: Verify Advance to employee is adjusted against the selected bill and Net Adjusted Value is correctly displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click Add icon button
Then Enter the Receivable Name as Advance to employee
And Enter Business partner Value For Employee
#Then Enter the PO Number
And Enter Payment mode
Then Enter Amount value
And Choose Needed Currancy
Then Choose cost center
And Enter Description value
Then Save the Advance Record
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
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net Adjusted Value is correctly displayed

@KUBS_AR_AP_UAT_004_007_TC_02
Scenario: Verify TDS % & amount is correctly calculated & displayed for the bill
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the TDS % & amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_007_TC_03
Scenario: Net payable amount is correctly calculated & displayed
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on Accounts Receive Advances Eye Icon
And Click On Search Icon
Then Enter Advance to employee and Active Value In Advance Status
Then Click on Table Row First Eye Icon
And Get The Business Partner and Advance Number
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click Add icon button
Then Enter payment option
And Give stored Business partner Name
Then Choose value date as System current date
And find the Advance reference number and Net Adjustable value in the billing queue
Then Click the Checkbox As Tick
And Verify the Net payable amount is correctly calculated & displayed

@KUBS_AR_AP_UAT_004_007_TC_04
Scenario: Verify accounting entries post payment settlement approval
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts payable
Then Click sub module Payment settlement Eye Icon
And Click On Search Icon
Then Enter Advance to employee and Active Value In Advance Status
And Enter Advance to employee Pan Number
Then Click on Table Row First Eye Icon
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post payment settlement approval fo Advance to Employee

@KUBS_AR_AP_UAT_010_001_TC_01
Scenario: Record a receipt through cheque mode
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click Add icon button
Then Enter Receipt type as cheque
And Enter Receipt Ref Number 
Then Enter Receipt Amount
And Enter Bank Account Number
Then Enter Receipt payer
#Then Choose value date as System current date
And Enter Remarks for Receipt
Then Save Receipt Record
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
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon

@KUBS_AR_AP_UAT_010_001_TC_02
Scenario: Record a receipt through Online mode
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click Add icon button
Then Enter Receipt type as Online
And Enter Receipt Ref Number 
Then Enter Receipt Amount
And Enter Bank Account Number
Then Enter Receipt payer
#Then Choose value date as System current date
And Enter Remarks for Receipt
Then Save Receipt Record
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
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Get Referance Number
Then Click on Table Row First Eye Icon

@KUBS_AR_AP_UAT_010_001_TC_03
Scenario: Verify accounting entries post receipt recording
Given Navigate The Azentio Url
Then Choose the second Tab Segment
And Click On Main module Accounts Receivable
Then Click on the Receipt Eye Icon
And Click On Search Icon
Then Enter Receipt type as Wire
Then Click on Table Row First Eye Icon
And Get The Txn Receipt Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch code
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post receipt recording

















