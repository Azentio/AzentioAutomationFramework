Feature: AR/AP Module

@KUBS_AR/AP_UAT_003_001TC_01  @AR/AP
Scenario: verify contract report should display the correct info for logged in branch
		Given User should go to the kubs url and login as a maker user
		And user should navigate to accounts payable menu
  	And user click Vendor Contracts eye icon for contract report verification
   	And click the first eye icon in the list for contract report verification
   	And get buisness partner name,get contract end date and get contract acccount code,get contract status
   	And click the notes option for contract report verification 
   	And click the Reports Sub Module
   	And click the contract report edit icon
   	And select the vendor name according to contract
   	And select the contract status based on we get from list
   	And select the date based on contract end date
   	And click the view icon
  	Then verify the contract code in contract report
   
  @KUBS_AR/AP_UAT_003_001TC_02  @AR/AP
  Scenario: Verify creating po against cancelled order is not allowed
		Given User should go to the kubs url and login as a maker user
		And user should navigate to accounts payable menu
		When click on eye button of vendor contract
    And user click search icon
    And user update the data set ID for po against cancelled order
    And user search cancelled vendor contract
    And user click the cancelled vendor contract eye icon
    And get buisness partner name and get contract name
    Then Click on purchase order Eye Icon
		Then Click on purchase order Add button
    And select buisness partner we get in cancelled list
    And select referece type as contract
    And select the contract Name
    Then verify not able to select contract and po creation is not allowed
    
#@KUBS_AR/AP_UAT_003_001TC_03  @AR/AP
#Scenario: check cancellation of contract is not allowed when purchase order is created against contract
#Given user navigate to the url and login as a maker for cancellation of contract is not allowed
#And click on accounts Payable module
#And goto vendor contract module
#And click on Add Icon
#Then fill all the mendatory fields for creating vendor
#And add item details for the contract
#And add the payment term for the contract
#And add the benificiory details and select auto payout as yes
#And click notification button
#Then choose first record in the notification record
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#And login with reviewer credentials
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#And logout from reviewer
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#And login with Maker ID
#And click on accounts Payable module
#And goto vendor contract module
#And get the contract number
#And goto po creation module
#And click on Add Icon
#And fill the mendatory fields for po creation 
#And save the po creation record
#And save the item details for pocreation 
#And save the benificiery details for po creation
#And click notification button
#Then choose first record in the notification record
#And click on Submit button 
#Then enter remark in confirmation alert
#Then click on submit button in alert
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#And login with reviewer credentials
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#And enter the remark in alert
#Then click on submit in alert
#Then verify the approval status of the record
#And logout from reviewer
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then give alert remark 
#Then click on submit button on alert
#And verify the record got approved from checker
#Then logout from checker
#And login with Maker ID
   #When click the accounts payable
   #And click vendor purchase order eye ion
   #And click search icon in list view
   #And search PO status as Active
   #And click the first eye icon in the list
   #And get contract name in vendor 
   #And click the vendor contract eye icon sub module
   #And click the eye icon in list based on contractname
   #And get buisness partner name and get contract acccount code
   #And click the ar ap adjustment sub module
   #And click ar ap eye icon
   #And click add icon
   #And select bp name according to bp we get in contratc
   #And select adjustment type as cancellation
   #And select adjustment item type as contract
   #And select adjustment reference as we get in contract account code
   #Then verify that cancellation of contract is not allowed when po created for contract
   
   
   
   
   
    @KUBS_AR/AP_UAT_003_002_TC_01  @AR/AP
  Scenario: verify contract report should display the correct info for logged in branch
  Given User should go to the kubs url and login as a maker user
	And user should navigate to accounts payable menu
  And user click Vendor Contracts eye icon for contract report verification
   And click the first eye icon in the list for contract report verification
   And get buisness partner name,get contract end date and get contract acccount code,get contract status
   And click the notes option for contract report verification 
   And click the Reports Sub Module
   And click the contract report edit icon
   And select the vendor name according to contract
   And select the contract status based on we get from list
   And select the date based on contract end date
   And click the view icon
   Then verify the contract code in contract report
   
   @KUBS_AR_AP_UAT_003_002_TC_02  @AR/AP
Scenario: Check PO Report
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on purchase order Eye Icon
Then click on search
And user update the data set ID for PO Report
And search for the active po
And get the approved po reference number and get the business partner name
Then Third Segment report Icon
And click on report main menu
And goto po report
And enter business partner name in po report
And click on date icon
And give date in report
And enter po status in po report
And click on the view button
Then verify the approved po number is availabe in the po report

   @KUBS_AR/AP_UAT_003_002_TC_03  @AR/AP @f
Scenario: Check creating GRN against cancelled PO is not allowed
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on purchase order Eye Icon
Then click on search
And user update the data set ID for GRN against cancelled PO
And search for cancelled po
Then Click on Good Recived Note GRN Eye buutton
Then Click on Good Recived Note GRN Add button
And check GRN can be created for that perticular po
And click notification button
Then choose first record in the notification record
Then go to Item details and enter po number


#@KUBS_AR_AP_UAT_003_002_TC_05  @AR/AP
#Scenario: Check PO cancellation is not allowed if GRN has been approved against that PO
#Given Navigate The Azentio Url
#Then Choose the second Tab Segment
#And click on accounts Payable module
#Then click on po creation module
#And search for approved po
#Then go to GRN module
#And click on Add Icon
#And check GRN can be created for that perticular po
#Then go to Item details and enter po number for approval
#And click notification button
#Then choose first record in the notification record in GRN stage
#And click on Submit button 
#Then enter remark in confirmation alert in grn 
#And capture the reviewer ID in pop up which is open when we submit our record in maker stage
#Then logout from maker
#And login with reviewer credentials
#Then click on notification button
#And select our record in notification records using reference ID
#Then Approve the record from reviewer
#Then enter remark in confirmation alert in grn
#Then verify the approval status of the record
#And logout from reviewer
#Then login as a checker 
#And click on security management menu in checker
#Then click on action button under security management menu
#And select our record and clime using reference ID
#Then click on Notification button
#Then select our record in notification records by the help of reference ID
#And click on approve button in checker stage
#Then enter remark in confirmation alert in grn 
#And verify the record got approved from checker
#Then logout from checker 
#And login with Maker ID
#Then go to ar ap adjustment module
#And click on Add Icon
#Then validate the po is not available for adjustment
   

   
   
@KUBS_AR_AP_UAT_003_003_TC_01  @AR/AP
Scenario: Check GRN Report
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
Then Third Segment report Icon
Then Click on Report Tab
Then Click on GRN Edit button
Then update data set Id for GRN Report2
Then Select Vendor or Employee name
Then Select Date
Then Select GRN Status
Then Click on View buttonT
Then close the report

@KUBS_AR_AP_UAT_003_003_TC_02  @AR/AP
Scenario: Verify Accounting entries post GRN is cancelled
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
And Click On Search Icon
And Update the data set id for Accounting entries14
Then Enter the GRN status cancel
And Get the Branchcode and Ref No
Then Third Segment report Icon
And Choose Enquiry Module
Then Click Note iCon near by financial transction
And choose branch codes
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And Click View HyperLink
Then Verify Accounting entries post GRN is cancelled

@KUBS_AR_AP_UAT_003_003_TC_03  @AR/AP
Scenario: Verify Balance sheet post GRN is cancelled
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Balance sheet Report b16
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries

@KUBS_AR_AP_UAT_003_003_TC_04  @AR/AP
Scenario: Check PO Report
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on purchase order Eye Icon
Then click on search
And user update the data set ID for PO Report2
And search for the active po
And get the approved po reference number and get the business partner name
Then Third Segment report Icon
And click on report main menu
And goto po report
And enter business partner name in po report
And click on date icon
And give date in report
And enter po status in po report
And click on the view button
Then verify the approved po number is availabe in the po report

@KUBS_AR_AP_UAT_003_003_TC_05  @AR/AP @f
Scenario: Check creating Bill against cancelled GRN is not allowed
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Click on Good Recived Note GRN Eye buutton
And Click On Search Icon
And Update the data set id for creating Bill against cancelled GRN
And Enter the GRN status
Then Click on Table Row First Eye Icon in ARAP
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

@KUBS_AR_AP_UAT_003_003_TC_06  @AR/AP
Scenario: Check GRN cancellation is not allowed if Bill has been approved against that GRN
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
And Update the data set id for GRN cancellation is not allowed if Bill has been approved
And Enter the Invoice Bill Booking status
Then Click on Table Row First Eye Icon in ARAP
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

@KUBS_AR/AP_UAT_003_004TC_01  @AR/AP @f
Scenario: verify accounting entries post bill is cancelled
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu 
Then Open Invoice Bill Booking Eye icon
And Click On Search Icon
And Update the data set id for Accounting entries15
And search invoice type as a expense
Then Click on Table Row First Eye Icon in ARAP
And get the invoice number from the bill viewed
And click the notes option in top
And click the enquiry module
And click the financial transaction edit icon
And select the branch code as azentio main branch
And click on transaction from date in calender
Then Select from date in calender
And click on transaction to date in calender icon
Then Select To date in calender
And click the view option
Then verify that the invoice number get from bill matches with voucher id in report
   
