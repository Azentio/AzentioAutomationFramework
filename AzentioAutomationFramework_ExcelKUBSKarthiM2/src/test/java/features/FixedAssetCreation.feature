Feature: Check the Functionality of Fixed Asset 
@KUBS_FAT_UAT_002_001_01
Scenario: Create the asset limit1
And User get the testdata for asset limit
Given Maker Navigate to UAT URL login1
Then Click on the Direction1
Then Click on Fixed Asset1
Then Click on Asset Creation Eye button1
Then Click on the add button to add new record1
#And User get the testdata for asset limit
Then Fill Form
Then Save the filled form1
Then Click on Fixed Asset Notification1
#Then Click on the Notification
Then Select the record which we saved1
Then Submit record1

@KUBS_FAT_UAT_002_001_02
Scenario: Create the asset limit2
And User get the testdata for asset limit
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage

@KUBS_FAT_UAT_002_001_03
Scenario: Create the asset limit3
And User get the testdata for asset limit
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

@KUBS_FAT_UAT_002_001_04
Scenario: Create the asset limit4
And User get the testdata for asset limit
Given Navigate to kubs URL and user should login as a maker1
Then Click on the Direction1
Then Click on Fixed Asset
Then Click on Asset Creation Eye button

##################################################################################################################################################

@KUBS_FAT_UAT_013_001 
Scenario: Check Asset Limit Config 

 Given User should go to the kubs url and login as a maker user 
 Then click on report icon 
 And user should navigate to master reports menu 
 Then click on temp grid button of asset limit configuration 
 And select the accounting standards and date to check the asset limit are displaying 
 Then click in the view button to check 
 Then the report is displaying all the asset codes details for a branch 
 
@KUBS_FAT_UAT_013_002 
Scenario: Check Asset Category 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset category 
And select the asset category and date to check the asset category are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 


##################################################################################################################################################

#PO Creation
@KUBS_FAT_UAT_001_003_01
Scenario: Create a purchase order with Unique purchase order number
And Get the test data for the po creation test case1
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
#Then Fill purchase order Mandatory fields

And User fill the accountsPayable_VendorPurchaseOrder_EntityBranch
And User fill the accountsPayable_VendorPurchaseOrder_BPName
And User fill the accountsPayable_VendorPurchaseOrder_ReferenceType

And User get the test data for Contract creation Testcase4
And User fill the accountsPayable_VendorPurchaseOrder_Contract

And Get the test data for the po creation test case1
And User fill the accountsPayable_VendorPurchaseOrder_CheckBoxPoItem
And User fill the accountsPayable_VendorPurchaseOrder_PoQuantity
And User save the accountsPayable_VendorPurchaseOrder_PoItemSave1
And User fill the accountsPayable_VendorPurchaseOrder_POSubType1
And User fill the accountsPayable_VendorPurchaseOrder_CostCenter1


Then Click on Account Payable Save button
Then Click on Item Details Record
Then Edit the item details fields
Then Click on Account Payable Save button
Then Click on Account Payable Notification
Then Select the record from Notification 
And Submit the Selected record

@KUBS_FAT_UAT_001_003_02
Scenario: Create a purchase order with Unique purchase order number Reviewer
And Get the test data for the po creation test case1
Then log in to the reviewer account3
And Get the test data for the po creation test case2
Then click on the Notification select the record and Approve3

@KUBS_FAT_UAT_001_003_03
Scenario: Create a purchase order with Unique purchase order number Checker
And Get the test data for the po creation test case3
Then log in to the Checker Account
And then checker claim the record3
Then click on the checker Notification 
And select the record and Approve by checker3

@KUBS_FAT_UAT_001_003_04
Scenario: Create a purchase order with Unique purchase order number1
And Get the test data for the po creation test case4
Given Navigate to kubs URL and user should login as a maker1
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then click on search button
And Get the test data for the po creation test case1
Then search vendor contract details by business partner name
And vendor contract PO details should display on PO creation  list view

###########################################################################################################################################################
#Contract Creation
@KUBS_FAT_UAT_001_002_01
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase1
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
And click on add button to create contract
#And Fill the required fields to create contract

And fill the accountPayable_VendorContracts_ExpenseType
And fill the accountPayable_VendorContracts_BP_Name
And fill the accountPayable_VendorContracts_BP_Branch
And fill the accountPayable_VendorContracts_ContractName
And fill the accountPayable_VendorContracts_AgreementCalendar
And fill the accountPayable_VendorContracts_ContractEndDate
And fill the accountPayable_VendorContracts_ContractSignedOnDate
And fill the accountPayable_VendorContracts_Currency
And fill the accountPayable_VendorContracts_Remark
And fill the accountPayable_VendorContracts_OtherDetailsButton
And fill the accountPayable_VendorContracts_AutoGenerateInvoice
And fill the accountPayable_VendorContracts_CreditPeriod
And fill the accountPayable_VendorContracts_LatePaymentFee
And fill the accountPayable_VendorContracts_Currency2
And User click the accountPayable_VendorContracts_SaveButton
And User click the accountPayable_VendorContracts_AddButton
And fill the accountPayable_VendorContracts_HSN_Code
And fill the accountPayable_VendorContracts_ExpenseCode
And fill the accountPayable_VendorContracts_Quantity
And fill the accountPayable_VendorContracts_CostCenter
And fill the accountPayable_VendorContracts_Unit
And fill the accountPayable_VendorContracts_RatePerUnit
And fill the accountPayable_VendorContracts_CurrencyInItemDetail
And user click the accountPayable_VendorContracts_ItemDetailsSaveButton
And User fill the accountPayable_VendorContracts_AddButton
And fill the accountPayable_VendorContracts_PaymentTermDetails
And fill the accountPayable_VendorContracts_PaymentTermPercent
And fill the accountPayable_VendorContracts_PaymentTermType
And user click the accountPayable_VendorContracts_ItemDetailsSaveButton
And User fill accountPayable_VendorContracts_ModeOfPayment
And fill the accountPayable_VendorContracts_AutoPayout
And User click the accountPayable_VendorContracts_BenificiaryDetailsSaveButton
Then Save and submit the creation contract record1

@KUBS_FAT_UAT_001_002_02
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase1
And User should go to the kubs url and login as a reviewer user
Then Click on notification button in reviewer
And User get the test data for Contract creation Testcase2
And approve the record by reviewer user

@KUBS_FAT_UAT_001_002_03  
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase1	
Given User should go to the kubs url and login as a checker user
And Click on security management in checker
Then Click on open pool in checker
And Click on claim button in checker
And capture claimed status
Then click on notification in checker
And User get the test data for Contract creation Testcase3	
Then checker should approved the contract record
@KUBS_FAT_UAT_001_002_04 
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase4
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
Then click on search button
And User get the test data for Contract creation Testcase1
Then search vendor contract details by business partner name
And User get the test data for Contract creation Testcase4
And vendor contract details should display on contract creation list view

########################################################################################################################################

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
 @KUBS_FAT_UAT_001_02
 Scenario: Create a Vendor for the procurement of an asset2
 And Get the test data for the business partner test case02
 And User should go to the kubs url and login as a reviewer user1
 Then Click on notification button in reviewer
 And approve the record by the reviewer user1 	
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
 @KUBS_FAT_UAT_001_04
 Scenario: Create a Vendor for the procurement of an asset4
 And Get the test data for the business partner test case04 
 Given User should go to the kubs url and login as a maker user
 And user should navigate to business partner setup menu
 When click on eye button of business partner
 Then click on search button
 Then search bp details by reference code number
 And bp details should display on business partner list view



