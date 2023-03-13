Feature: Test
#Business Partner
@KUBS_FAT_UAT_001_01
 Scenario: Create a Vendor for the procurement of an asset1
 And Get the test data for the business partner test case01
 Given User should go to the kubs url and login as a maker user
 And user should navigate to business partner setup menu
 When click on eye button of business partner
 And click on add button of business partner
 And Fill the required fields to create a vendor
 Then Save and submit the record to create vendor
 And click on user profile icon
And click on logout button
Then verify user profile got logout
 @KUBS_FAT_UAT_001_02
 Scenario: Create a Vendor for the procurement of an asset2
 And Get the test data for the business partner test case02
 And User should go to the kubs url and login as a reviewer user1
 Then Click on notification button in reviewer
 And approve the record by the reviewer user1 
 And click on user profile icon
And click on logout button
Then verify user profile got logout	
 @KUBS_FAT_UAT_001_03
 Scenario: Create a Vendor for the procurement of an asset3
 And Get the test data for the business partner test case03
 Given User should go to the kubs url and login as a checker user
 And Click on security management in checker
 Then Click on open pool in checker
 And Click on claim button in checker
 And capture claimed status
 Then click on notification in checker
 Then checker should approved the contract record1 
 And click on user profile icon
And click on logout button
Then verify user profile got logout 
 @KUBS_FAT_UAT_001_04
 Scenario: Create a Vendor for the procurement of an asset4
 And Get the test data for the business partner test case04 
 Given User should go to the kubs url and login as a maker user
 And user should navigate to business partner setup menu
 When click on eye button of business partner
 Then click on search button
 Then search bp details by reference code number
 And bp details should display on business partner list view
 And click on user profile icon
And click on logout button
Then verify user profile got logout
#Contract Creation
@KUBS_FAT_UAT_001_002_01
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase1
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
And click on add button to create contract
And Fill the required fields to create contract
Then Save and submit the creation contract record
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_002_02 
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase2
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
And approve the record by reviewer user
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_002_03  
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase3	
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
Then checker should approved the contract record
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_002_04 
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase4
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
Then click on search button
And click on user profile icon
And click on logout button
Then verify user profile got logout
#Then search vendor contract details by business partner name
#And vendor contract details should display on contract creation list view

@KUBS_FAT_UAT_001_003_01 
Scenario: Create a purchase order with Unique purchase order number
And Get the test data for the po creation test case1
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
Then Fill purchase order Mandatory fields
Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_003_02
Scenario: Create a purchase order with Unique purchase order number Reviewer
And Get the test data for the po creation test case2
Then log in to the reviewer account
Then click on the Notification select the record and Approve
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_003_03
Scenario: Create a purchase order with Unique purchase order number Checker
And Get the test data for the po creation test case3
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_003_04
Scenario: Create a purchase order with Unique purchase order number1
And Get the test data for the po creation test case4
Given Navigate to kubs URL and user should login as a maker1
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
And click on user profile icon
And click on logout button
Then verify user profile got logout