Feature: AR/AP Module
@KUBS_AR/AP_UAT_003_001_TC_03_01   @AR/AP
Scenario: check cancellation of contract is not allowed when purchase order is created against contract1
And User get the test data for the po contract cancellation test case1
Given user navigate to the url and login as a maker for cancellation of contract is not allowed
And click on accounts Payable module
And goto vendor contract module
And click on Add Icon
Then fill all the mendatory fields for creating vendor
And add item details for the contract
And add the payment term for the contract
And add the benificiory details and select auto payout as yes
And click notification button
Then choose first record in the notification record in arap
And click on Submit button 
And User get the test data for the po contract cancellation test case1
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap
Then logout from maker

@KUBS_AR/AP_UAT_003_001_TC_03_02
Scenario: Login as a Reviewer
And User get the test data for the po contract cancellation test case1
And login with reviewer credentials1
#And User get the test data for the po contract cancellation test case2
Then click on notification button
And User get the test data for the po contract cancellation test case1
And select our record in notification records using reference ID in arap
And User get the test data for the po contract cancellation test case2
Then Approve the record from reviewer
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer

@KUBS_AR/AP_UAT_003_001_TC_03_03
Scenario: Login as a Checker
And User get the test data for the po contract cancellation test case3
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And User get the test data for the po contract cancellation test case1
And select our record and clime using reference ID in arap
Then click on Notification button
And User get the test data for the po contract cancellation test case1
Then select our record in notification records by the help of reference ID in arap
And click on approve button in checker stage
And User get the test data for the po contract cancellation test case3
Then give alert remark in arap
Then click on submit button on alert in arap
And verify the record got approved from checker
Then logout from checker
@KUBS_AR/AP_UAT_003_001_TC_03_04
Scenario: check cancellation of contract is not allowed when purchase order is created against contract3
And User get the test data for the po contract cancellation test case4
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
Then choose first record in the notification record in arap1
And click on Submit button 
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap1
Then logout from maker
@KUBS_AR/AP_UAT_003_001_TC_03_05
Scenario: Login as a Reviewer
And User get the test data for the po contract cancellation test case5
And login with reviewer credentials1
Then click on notification button
And select our record in notification records using reference ID in arap
Then Approve the record from reviewer
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer
@KUBS_AR/AP_UAT_003_001_TC_03_06
Scenario: Login as a Checker
And User get the test data for the po contract cancellation test case6
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID in arap
Then click on Notification button
Then select our record in notification records by the help of reference ID in arap
And click on approve button in checker stage
Then give alert remark in arap 
Then click on submit button on alert in arap
And verify the record got approved from checker
#And verify the record got approved from checker
Then logout from checker
@KUBS_AR/AP_UAT_003_001_TC_03_07
Scenario: check cancellation of contract is not allowed when purchase order is created against contract4
And User get the test data for the po contract cancellation test case7
And login with Maker ID
When click the accounts payable
And click vendor purchase order eye ion
And click search icon in list view
And search PO status as Active1
And click the first eye icon in the list
And get contract name in vendor 
And click the vendor contract eye icon sub module
And click the eye icon in list based on contractname in arap
And get buisness partner name and get contract acccount code
And click the ar ap adjustment sub module
And click ar ap eye icon
And click add icon
And select bp name according to bp we get in contract
And select adjustment type as cancellation
And select adjustment item type as contract in arap
And select adjustment reference as we get in contract account code in arap
Then verify that cancellation of contract is not allowed when po created for contract

###########################################################################################################################################################


#####################################################################################################################

    @KUBS_AR/AP_UAT_005_002_TC_01_01 @AR/AP
    Scenario: User cancels the payment settlement transaction for multiple bills.
    And User get the test data for the payment settlement transaction test case0101
    Given Navigate The Azentio Url
    And user should navigate to accounts payable menu
    When click on eye button of payment settlement cancellation
    And click on add button for payment settlement cancellation
    And Fill the required fields for payment settlement cancellation
    Then Save and submit the payment settlement cancellation record
    
    @KUBS_AR/AP_UAT_005_002_TC_01_02 
    Scenario: Login as a Reviewer
    And User get the test data for the payment settlement transaction test case0102
    And login with reviewer credentials1
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user in arap
  	
  	
  	@KUBS_AR/AP_UAT_005_002_TC_01_03
    Scenario: Login as a Checker
    And User get the test data for the payment settlement transaction test case0103
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker in arap
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the manual payout record in arap
    
    @KUBS_AR/AP_UAT_005_002_TC_01_04
    Scenario: User cancels the payment settlement transaction for multiple bills.
    And User get the test data for the payment settlement transaction test case0104
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of manual payout
    #Then Get the payout status
    And maker should logout
    
@KUBS_AR/AP_UAT_005_002_TC_02  @AR/AP
Scenario: Verify cancelled payment txn is not available for payout on payout screen.
And User get the test data for the payment settlement transaction test case02
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of manual payout
And click on add button for manual payout
And Fill the required fields for verify cancelled payment txn availability in arap
    
@KUBS_AR_AP_UAT_005_002_TC_03 @AR/AP
Scenario: Verify accounting entries post payment settlement approval.
And User get the test data for the payment settlement transaction test case03
Given Navigate The Azentio Url
And click on accounts Payable module
And Go to payment settlement module
Then click on search
And search for approved record in view area in arap
And get the approved record from list view in arap
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code in arap
And click on transaction from date calender icon 
Then choose the from date in arap
And click on the transaction to date calender icon
Then choose the to date in arap
And give the refrence number which we going to see accounting entries in arap
And click on view button
Then verify approved settlement reference number is available in the Gl report in arap

@KUBS_AR/AP_UAT_005_002_TC_04  @AR/AP
Scenario: Verify Balance sheet post payment settlement approval.
And User get the test data for the payment settlement transaction test case04
Given Navigate to URL and user should login as a maker
Then Click on Report button
Then Click on Financial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report in arap
Then Select date in calendar in arap
Then Click on the View button
Then close the report

 @KUBS_AR/AP_UAT_005_002_TC_05  @AR/AP @report
Scenario: Verify Accounts Payable Report post cancelling payment settlement txn
And User get the test data for the payment settlement transaction test case05
#Given user login as Azentio Maker
Given Navigate The Azentio Url
When click the Account payable Mainmodule
And click the eye icon of the payment settlement
And user click search icon
And user search active in payment settlement list view in arap
And click first eye icon in list view 
And get the transaction number from payment settlement
And get buisness partner name and payment settlement date in arap
And click the Notes Option In Top
And click the Reports Sub Module
And click the Accounts Payable Report
And select the vendor name in arap
And select the payable status according to payment settlement
And select the date in arap
And click the view icon
Then verify the invoice number get from payment settlement available in Account payable Report








