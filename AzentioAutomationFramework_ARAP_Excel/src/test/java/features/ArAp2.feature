Feature: AR/AP Module



#//----------//
@KUBS_AR/AP_UAT_002_001_TC_01  @AR/AP
Scenario: Verify Tax details is correctly displayed for Item details in Billing
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
And user update the data set ID for Tax1
When click on eye button of invoice booking
Then Get the tax details and check
And maker should logout

@KUBS_AR_AP_UAT_002_001_TC_02  @AR/AP
Scenario: Verify Accounting entries post Debit note is approved
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Update the data set id for Accounting entries16
Then Click on Account Recivable button
 And click debit note eye icon
And Click On Search Icon
Then Enter Active Value In Debit Not Status
And click first eye icon in list view 
And Get The Bp Name and Debit Number Store It
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post Debit Note is approved

 @KUBS_AR/AP_UAT_002_001_TC_03  @AR/AP
Scenario: Verify Balance sheet post Crdit Note is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
And Click On Search Icon
And Update the data set id for Balance sheet Report b14
And search and get the active GRN code
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet post GRN approval

@KUBS_AR/AP_UAT_002_001TC_04  @AR/AP
    Scenario: Verify Accounts Receivable Report post bill is approved.
   Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
And Update the data set id for Accounts Payable Report APR13 post bill is approved
   And click debit note eye icon
   And click search button and then click debit note status search
   And search sale of assert in debit list
   And click first eye icon in list view 
   And get the debit note number and buisnes partner name,debit note date
    And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report

#//----------//
@KUBS_AR/AP_UAT_002_003_TC_01_01  @AR/AP
Scenario: Advance to employee must be created and displayed in approved list view.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance to employee
Then Fill the form for Account Recivable
Then Click on save button to save the Record for Account Recivable
Then click on the Notification icon
Then Search Advance to employee record in List
Then store the Reference ID and open the Advance to employee record
Then click submit and enter remark for Advance to employee
@KUBS_AR/AP_UAT_002_003_TC_01_02  
Scenario: Reviewer approve Advance to employee Record
And user update the data set ID for Advance to employee Reviewer
And User login as a reviewer user Approve Advance to employee
Then Click on notification button in reviewer
And approve Advance to employee record by reviewer user
@KUBS_AR/AP_UAT_002_003_TC_01_03 
Scenario: Checker approve Advance to employee Record
And user update the data set ID for Advance to employee Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Advance to employee
And capture claimed status
Then click on notification in checker
Then Search Advance to employee record in List
Then checker should approved the Advance to employee record
@KUBS_AR/AP_UAT_002_003_TC_01_04  
Scenario: To verify approve Advance to employee Record should visible in Account Receivable list
And user update the data set ID for Advance to employee
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Get the Advance to employee Txn status by searching the record via business partner
And maker should logout


@KUBS_AR/AP_UAT_002_004_TC_01_01
Scenario: Create Advance against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance against PO
Then Fill the form for Account Recivable Advance against PO
Then Click on save button to save the Record for Account Recivable
Then click on the Notification icon
Then Search Advance against PO record in List
Then store the Reference ID and open the Advance against PO record
Then click submit and enter remark for Advance against PO
@KUBS_AR/AP_UAT_002_004_TC_01_02  
Scenario: Reviewer approve Advance against PO Record
And user update the data set ID for Advance against PO Reviewer
And User login as a reviewer user Approve Advance against PO
Then Click on notification button in reviewer
And approve Advance against PO record by reviewer user
@KUBS_AR/AP_UAT_002_004_TC_01_03 
Scenario: Checker approve Advance against PO Record
And user update the data set ID for Advance against PO Reviewer
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker for Advance against PO
And capture claimed status
Then click on notification in checker
Then Search Advance against PO record in List
Then checker should approved the Advance against PO record
@KUBS_AR/AP_UAT_002_004_TC_01_04  
Scenario: To verify approve Advance against PO Record should visible in Account Receivable list
And user update the data set ID for Advance against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Get the Advance against PO Txn status by searching the record via business partner
And maker should logout


@KUBS_AR_AP_UAT_002_004_TC_02  
Scenario: Verify No accounting entry is generated on approval of advances against PO
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
And Click On Search Icon
Then Enter Active Value In Advance Status
Then Click on Table Row First Eye Icon in ARAP
And Get The Business Partner and Advance Number
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify No accounting entry is generated on Active advances against PO

@KUBS_AR/AP_UAT_002_004_TC_03 
Scenario: Verify creating advane against PO with amount greater than PO amount is not allowed
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Click on Account Recivable button
Then Click on Account Recivable Advances eye button
Then Click to add record in Account Recivable
And user update the data set ID for Advance against PO with amount greater than PO amount
Then Fill the form for Account Recivable with amount greater than PO amount

















