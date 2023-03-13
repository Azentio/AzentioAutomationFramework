Feature: Check the Functionality of Fixed Asset module

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
#And fill the accountPayable_VendorContracts_AgreementCalendar
#And fill the accountPayable_VendorContracts_ContractEndDate
#And fill the accountPayable_VendorContracts_ContractSignedOnDate
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
Then checker should approved the contract record

@KUBS_FAT_UAT_001_002_04 
Scenario: Create a contract details for procuring an asset
And User get the test data for Contract creation Testcase1
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of vendor contract
Then click on search button
Then search vendor contract details by business partner name
And vendor contract details should display on contract creation list view

#PoCreation

@KUBS_FAT_UAT_001_003_01
Scenario: Create a purchase order with Unique purchase order number
And Get the test data for the po creation test case1
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then Click on purchase order Add button
#Then Fill purchase order Mandatory fields
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
Then click on the Notification select the record and Approve3

@KUBS_FAT_UAT_001_003_03
Scenario: Create a purchase order with Unique purchase order number Checker
And Get the test data for the po creation test case1
Then log in to the Checker Account
And then checker claim the record3
Then click on the checker Notification 
And select the record and Approve by checker3

@KUBS_FAT_UAT_001_003_04

Scenario: Create a purchase order with Unique purchase order number1
And Get the test data for the po creation test case1
Given Navigate to kubs URL and user should login as a maker1
Then Click on Direction icon
Then Click on Account Payable 
Then Click on purchase order Eye Icon
Then click on search button
And vendor contract PO details should display on PO creation  list view
And store the Po number in GRN excel database


@KUBS_FAT_UAT_001_004_01
Scenario: Create GRN for the generated PO No.s
Given Navigate to URL and user should login as a maker
And update test data to create GRN for generated PO
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
And Enter GRN Business partner name
And Enter GRN Business partner branch
And Enter GRN Invoice number
And Enter GRN Delivery location
Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
Then Click on GRN item save button
Then Click on the Notification
Then Select the record which we saved
Then Submit record
@KUBS_FAT_UAT_001_004_02
Scenario: To verify reviewer user can able to approve the asset write off record
Given navigate to kubs Url to approve the GRN record in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_001_004_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the GRN record in checker
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
@KUBS_FAT_UAT_001_004_04
Scenario: Create GRN for the generated PO No.s
Given Navigate to URL and user should login as a maker
And update test data to create GRN for generated PO
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
And store the GRN Number and po number and bp name in invoice booking excel database

@KUBS_FAT_UAT_001_005_01
Scenario: Check the Bill Booking with all the details and submit from maker
Given User should go to the kubs url and login as a maker user
And Update test data for bill booking create and submit from maker
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And click on add button for invoice booking
And choose the invoice type as invoice against po
And choose the business partner name in invoice booking screen
And choose the cost center in invoice booking screen
And enter the suplier reference number in invoice booking screen
And enter the flat discount on in invoice booing screen
And choose the early payment discount type in invoice booking screen
And enter the early payment discount amount in invoice booking screen
And enter the mode of payment in invoice booking screen
And save the invoice Against Po first screen
And select the record from invoice booking record from temp grid
And click ap invoice against po in invoice booking screen
And enter the po number in invoice against po screen
And save the invoice against po screen
Then Save and submit the invoice billing
@KUBS_FAT_UAT_001_005_02
Scenario: To verify reviewer user can able to approve the asset write off record
Given navigate to kubs Url to approve the invoice against po record in reviewer
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
@KUBS_FAT_UAT_001_005_03
Scenario: To verify checker user can able to approve the fixed asset impairment
Given navigate to kubs url to approve the the invoice against po record in checker
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
@KUBS_FAT_UAT_001_005_04
Scenario: Verify that approved bill booking record is present in view list
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
Then click on first eye button to get the system invoice number to check
And update the invoice number in asset creation excel database
