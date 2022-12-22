Feature: AR/AP Module
@KUBS_AR/AP_UAT_003_001_TC_03
Scenario: check cancellation of contract is not allowed when purchase order is created against contract
And User get the test data for the po contract cancellation test case00300103
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
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap
Then logout from maker

And login with reviewer credentials1
Then click on notification button
And select our record in notification records using reference ID in arap
Then Approve the record from reviewer
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer

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
Then logout from checker

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
Then choose first record in the notification record in arap
And click on Submit button 
Then enter remark in confirmation alert in arap
Then click on submit button in alert in arap
And capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap
Then logout from maker

And login with reviewer credential
Then click on notification button
And select our record in notification records using reference ID in arap
Then Approve the record from reviewer
And enter the remark in alert1
Then click on submit in alert1
Then verify the approval status of the record
And logout from reviewer

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
