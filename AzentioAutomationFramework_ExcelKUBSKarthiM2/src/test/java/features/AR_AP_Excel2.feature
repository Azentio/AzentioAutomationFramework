Feature: AR/AP Module
@KUBS_AR/AP_UAT_003_007_TC_05_01_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement1
And User get the test data for the cancelling credit note test case0101
#Given user navigate to the url and login as a maker for cancellation of contract is not allowed
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record in arap3
And click on Submit button 
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap3
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_01_02
Scenario: Login as a Reviewer
#And User get the test data for the cancelling credit note test case0102
And User get the test data for the cancelling credit note test case0101
And login with reviewer credentials1
Then click on notification button
And User get the test data for the cancelling credit note test case0101
And select our record in notification records using reference ID in arap
And User get the test data for the cancelling credit note test case0102
Then Approve the record from reviewer
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_01_03
Scenario: Login as a Checker
And User get the test data for the cancelling credit note test case0103
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0101
And select our record and clime using reference ID in arap
Then click on Notification button
And User get the test data for the cancelling credit note test case0101
Then select our record in notification records by the help of reference ID in arap
And click on approve button in checker stage
And User get the test data for the cancelling credit note test case0103
Then give alert remark in arap
Then click on submit button on alert in arap
And verify the record got approved from checker
Then logout from checker

@KUBS_AR/AP_UAT_003_007_TC_05_02_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement2
And User get the test data for the cancelling credit note test case0201
And login with Maker ID
And click on accounts Payable module
And goto vendor contract module
And get the contract number
And goto po creation module
And click on Add Icon
And fill the mendatory fields for po creation 
And save the po creation record
And save the item details for pocreation 
And save the benificiery details for po creation
And click notification button
Then choose first record in the notification record in arap4
And click on Submit button 
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap4
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_02_02
Scenario: Login as a Reviewer
And User get the test data for the cancelling credit note test case0201
And login with reviewer credentials1
Then click on notification button
And User get the test data for the cancelling credit note test case0201
And select our record in notification records using reference ID in arap
Then Approve the record from reviewer
And User get the test data for the cancelling credit note test case0202
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_02_03
Scenario: Login as a Checker
And User get the test data for the cancelling credit note test case0203
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0201
And select our record and clime using reference ID in arap
Then click on Notification button
#And User get the test data for the cancelling credit note test case0201
Then select our record in notification records by the help of reference ID in arap
And User get the test data for the cancelling credit note test case0203
And click on approve button in checker stage
Then give alert remark in arap
Then click on submit button on alert
#And verify the record got approved from checker
Then logout from checker

@KUBS_AR/AP_UAT_003_007_TC_05_03_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement3
And User get the test data for the cancelling credit note test case0301
And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And search for approved po in arap
Then go to GRN module
And click on Add Icon
And check GRN can be created for that perticular po in arap
Then go to Item details and enter po number for approval in arap
And click notification button
Then choose first record in the notification record in GRN stage in arap
And click on Submit button 
Then enter remark in confirmation alert in grn in arap0301
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap5
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_03_02 
Scenario: Login as a Reviewer
And User get the test data for the cancelling credit note test case0301
And login with reviewer credentials2
Then click on notification button
And select our record in notification records using reference ID in arap0302
Then Approve the record from reviewer
And User get the test data for the cancelling credit note test case0302
Then enter remark in confirmation alert in grn in arap
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_03_03 
Scenario: Login as a checker
And User get the test data for the cancelling credit note test case0303
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0301
And select our record and clime using reference ID in arap0303
Then click on Notification button
Then select our record in notification records by the help of reference ID in arap0303
And click on approve button in checker stage
And User get the test data for the cancelling credit note test case0303
Then enter remark in confirmation alert in grn in arap0303
And verify the record got approved from checker
Then logout from checker


@KUBS_AR/AP_UAT_003_007_TC_05_04_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement4
And User get the test data for the cancelling credit note test case0401
And login with Maker ID
And click on accounts Payable module
Then click on po creation module
And get the approved po number from approved record0401
And go to invoice bill booking module
And click on Add Icon
And fill the invoice booking record in arap0401
And goto invoice bill booking temp view and select the record1
And fill The invoice againse po record in arap0401
And click notification button
Then choose first record in the notification record in GRN stage in arap0401
And click on Submit button 
Then click on the submit button which is appeared in alert box in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0401
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_04_02
Scenario: Login as a Reviewer
And User get the test data for the cancelling credit note test case0401
And login with reviewer credentials1
Then click on notification button
And select our record in notification records using reference ID in arap0402
Then Approve the record from reviewer
And User get the test data for the cancelling credit note test case0402
Then click on the submit button which is appeared in alert box in arap
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_04_03
Scenario: Login as a Checker
And User get the test data for the cancelling credit note test case0403
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0401
And select our record and clime using reference ID in arap0403
Then click on Notification button
Then select our record in notification records by the help of reference ID in arap0403
And click on approve button in checker stage
And User get the test data for the cancelling credit note test case0403
Then click on the submit button which is appeared in alert box in arap
And verify the record got approved from checker
Then logout from checker


@KUBS_AR/AP_UAT_003_007_TC_05_05_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement5
And User get the test data for the cancelling credit note test case0501
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And select the approved record from invoice bill booking0501
And goto accouts receivable module
And goto credit notet module
And click on Add Icon
And Fill the form for credit note in arap
And click notification button
Then choose first record in the notification record in arap0501
And click on Submit button 
Then click on the submit button which is appeared in alert box in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0501
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_05_02 
Scenario: Login as a Reviewer
And User get the test data for the cancelling credit note test case0501
And login with reviewer credentials2
Then click on notification button
#And User get the test data for the cancelling credit note test case0501
And select our record in notification records using reference ID in arap0402
Then Approve the record from reviewer
And User get the test data for the cancelling credit note test case0502
Then click on the submit button which is appeared in alert box in arap0502
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_05_03 
Scenario: Login as a Checker
And User get the test data for the cancelling credit note test case0503
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0501
And select our record and clime using reference ID in arap0403
Then click on Notification button
Then select our record in notification records by the help of reference ID in arap0403
And click on approve button in checker stage
And User get the test data for the cancelling credit note test case0503
Then click on the submit button which is appeared in alert box in arap0503
And verify the record got approved from checker
Then logout from checker

@KUBS_AR/AP_UAT_003_007_TC_05_06_01 @AR/AP
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement6
And User get the test data for the cancelling credit note test case0601
And login with Maker ID
And click on accounts Payable module
And goto invoice booking module
And get the approved invoice from table0601
And Go to payment settlement module
And click on Add Icon
And fill the mendatory field for settle the payment in arap0601
And fill the calender details and description in arap
And Save the form
And click notification button
Then choose first record in the notification record in arap0601
And click on Submit button 
Then click on the submit button which is appeared in alert box in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0601
Then logout from maker
@KUBS_AR/AP_UAT_003_007_TC_05_06_02
Scenario: Login as a Reviewer
And User get the test data for the cancelling credit note test case0601
And login with reviewer credentials2
Then click on notification button
And select our record in notification records using reference ID in arap0402
Then Approve the record from reviewer
And User get the test data for the cancelling credit note test case0602
Then click on submit button in alert in arap0602
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_007_TC_05_06_03
Scenario: Login as a Checker
And User get the test data for the cancelling credit note test case0603
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the cancelling credit note test case0601
And select our record and clime using reference ID in arap0403
Then click on Notification button
Then select our record in notification records by the help of reference ID in arap0403
And User get the test data for the cancelling credit note test case0603
And click on approve button in checker stage
Then click on submit button in alert in arap0603
And verify the record got approved from checker
Then logout from checker
@KUBS_AR/AP_UAT_003_007_TC_05_06_04
Scenario: Verify cancelling Credit Note is not allowed if the same has been adjusted at payment settlement6
And User get the test data for the cancelling credit note test case0604
And login with Maker ID
When click the Account Receivable Main Module for verify Accounting entries
And click the credit note eye icon
And click the search icon in the list view of credit 
And search the Active credit note and click the first list in arap
And get buisness partner name , get credit note number and get credit note date in arap
Then Open the Adjustment ARAP module
And Click on Adjustment ARAP Eye Icon
And Click Add icon button
Then Give The Business Partner according to creditnote in arap
And Give The Adjustment Type
Then Give the credit note number in Adjustment Item Type in arap
And Give the Adjustment Ref No and Validate

