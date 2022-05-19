 Feature: Check the Functionality of Fixed Asset module
 
 @KUBS_FAT_UAT_001_001
 Scenario: Create a Vendor for the procurement of an asset
 
 Given User should go to the kubs url and login as a maker user
 And user should navigate to business partner setup menu
 When click on eye button of business partner
 And click on add button of business partner
 And Fill the required fields to create a vendor
 Then Save and submit the record to create vendor
    
 And User should go to the kubs url and login as a reviewer user
 Then Click on notification button in reviewer
 And approve the record by the reviewer user
  	
 Given User should go to the kubs url and login as a checker user
 And Click on security management in checker
 Then Click on open pool in checker
 And Click on claim button in checker
 And capture claimed status
 Then click on notification in checker
 Then checker should approved the contract record
    
 Given User should go to the kubs url and login as a maker user
 And user should navigate to business partner setup menu
 When click on eye button of business partner
 Then click on search button
 Then search bp details by reference code number
 And bp details should display on business partner list view
 
 @KUBS_FAT_UAT_001_002
  Scenario: Create a contract details for procuring an asset
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    And click on add button to create contract
    And Fill the required fields to create contract
    Then Save and submit the creation contract record
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the contract record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of vendor contract
    Then click on search button
    Then search vendor contract details by business partner name
    And vendor contract details should display on contract creation list view
    
@KUBS_FAT_UAT_001_003  
Scenario: Create a purchase order with Unique purchase order number
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
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_001_004	
Scenario: Create GRN for the generated PO No.s
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton
Then Click on Add button
Then Fill the form for GRN
Then Click on save button to save the record
Then Click on notification & open record which we created for GRN
Then Click on Item Details Tab
Then Select PO Number
Then Add qty received qty approved
Then Click on GRN item save button
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Accounts Payable
Then Click on Good Recived Note GRN Eye buutton

#devesh KUBS_FAT_UAT_001_005
@KUBS_FAT_UAT_001_005
  Scenario: Check the Bill Booking with all the details
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    And click on add button for invoice booking
    And Fill the required fields for invoice booking
    Then Save and submit the invoice billing
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the invoice billing
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts payable menu
    When click on eye button of invoice booking
    Then click on first eye button to get the system invoice number to check
    And maker should logout
    
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the reference number field of financial transaction to check accounting entries post billing
    Then click on view button to view the report as per reference number

@KUBS_FAT_UAT_002_001 

Scenario: Create the asset limit

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button

@KUBS_FAT_UAT_002_002

Scenario: Create an asset category
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
Then Click on Fixed Asset Add button
Then Fill Asset Category Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_002_003 

Scenario: Configure the asset category for asset code creation

Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Category Eye button
And get the active asset code in asset category module 
Then Click on Asset code configuration Eye button
Then Click on Fixed Asset Add button
Then Fill Asset code configuration Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_002_004  

Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset GL configuration Eye button
Then Click on Fixed Asset Add button
Then Fill Asset GL configuration Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_002_005  

Scenario: Allocate the serial number for the asset
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
Then Click on Fixed assets configuration 
Then Click on Asset Serial Num Creation Eye button
Then Click on Asset Serial Num Creation Search icon
Then Enter Asset code
Then Click on the record
Then Fill Asset Serial Num Creation Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

@KUBS_FAT_UAT_002_006
Scenario: Creation of registered asset with minimum details

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button

@KUBS_FAT_UAT_002_007
Scenario: Creation of the registered asset with full details

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form

Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details

Then Click on the Notification
Then Select the record which we saved
Then Submit record

Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button

@KUBS_FAT_UAT_004_001
  Scenario: Check if the given asset is sold at higher price
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    And click on add button to create sale asset record
    And Fill the required fields to sale asset in profit
    Then Save and submit the asset sale record
    
    And User should go to the kubs url and login as a reviewer user 
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset sale
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    Then click on first eye button to get the profit earned
    And maker should logout
    
 @KUBS_FAT_UAT_004_002
Scenario: Check the accounting Entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
Then choose the Gl code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record

  @KUBS_FAT_UAT_004_003
  Scenario: Check if the given asset is sold at lower price
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    And click on add button to create sale asset record
    And Fill the required fields to sale asset in loss
    Then Save and submit the asset sale record
    
    And User should go to the kubs url and login as a reviewer user 
    Then Click on notification button in reviewer
  	And approve the record by reviewer user
  	
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset sale
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed asset menu
    When click on eye button of asset sale
    Then click on first eye button to get the loss earned
    And maker should logout

@KUBS_FAT_UAT_004_004

Scenario: Check the accounting Entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu

Then click on Edit icon near by financial transaction
And choose branch code Id
Then choose the Gl code Id
And click on transaction from date in calender icon
Then choose from date in the calender

And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record

@KUBS_FAT_UAT_004_005

Scenario: Check the Tax/GST on asset sale accordingly

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id

And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record

Then validate voucher number

 @KUBS_FAT_UAT_005_001
  Scenario: Check if the given asset is transferred to a pre decided centre
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
    
   # impaired asset - MACHINARY-AIRCONDITIONER-Lloyd_BR0003_1
  @KUBS_FAT_UAT_005_002 
  Scenario: Check if the given asset is transferred to a pre decided centre (impaired asset)
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for impaired asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
 
	 # Revaluation asset - MACHINARY-AIRCONDITIONER-Lloyd_AZENTMAIN_2
  @KUBS_FAT_UAT_005_003 
  Scenario: Check if the given asset is transferred to a pre decided centre (re-valued asset)
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for revalued asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    Then click on first view icon to see the transferred
    And maker should logout
    
@KUBS_FAT_UAT_005_004
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then validate voucher number

@KUBS_FAT_UAT_005_005
  Scenario: Check if other centre can accept the asset once received in their branch
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset undertaking
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a maker user for FAUM
   	Then click on notification in checker
    And Maker user should received the transferred asset
    Then maker user should submit in undertaking
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset undertaking
    Then click on first view button to see the Transferred to Branch
    And maker should logout
    
    # - impairement asset (MACHINARY-AIRCONDITIONER-Lloyd_BR0003_6)
    
  @KUBS_FAT_UAT_005_006
  Scenario: Check if other centre can accept the asset once received in their branch
   	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset impairement
    And click on add button for asset impairement
    And Fill the required fields for asset impairement
    Then Save and submit the asset impairement
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
    
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset impairement record
   
    #Given User should go to the kubs url and login as a maker user
    #And user should navigate to fixed assets menu
    #When click on eye button of asset transfer
    #And click on add button for asset transfer
    #And Fill the required fields for asset transfer
    #Then Save and submit the asset transfer
    #
    #And User should go to the kubs url and login as a reviewer user
    #Then Click on notification button in reviewer
  #	And approve the record by the reviewer user
  #	
    #Given User should go to the kubs url and login as a maker user for FAUM
   #	Then click on notification in checker
    #And Maker user should received the transferred asset
    #Then maker user should submit in undertaking
    #
    #And User should go to the kubs url and login as a reviewer user
    #Then Click on notification button in reviewer
  #	And approve the record by the final checker user
  #	
  #	Given User should go to the kubs url and login as a maker user
    #And user should navigate to fixed assets menu
    #When click on eye button of asset undertaking
    #Then click on first view button to see the Transferred to Branch
    #And maker should logout
    
    # - Revaluation asset (MACHINARY-AIRCONDITIONER-Lloyd_BR0003_6)
  @KUBS_FAT_UAT_005_007
  Scenario: Check if other centre can accept the asset once received in their branch
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset revaluation
    And click on add button for asset revaluation
    And Fill the required fields for asset revaluation
    Then Save and submit the asset revaluation
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
    
    Given User should go to the kubs url and login as a checker user
   	And Click on security management in checker
   	Then Click on open pool in checker
   	And Click on claim button in checker
   	And capture claimed status
   	Then click on notification in checker
    Then checker should approved the asset revaluation record
    
    Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset transfer
    And click on add button for asset transfer
    And Fill the required fields for asset transfer
    Then Save and submit the asset transfer
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the reviewer user
  	
    Given User should go to the kubs url and login as a maker user for FAUM
   	Then click on notification in checker
    And Maker user should received the transferred asset
    Then maker user should submit in undertaking
    
    And User should go to the kubs url and login as a reviewer user
    Then Click on notification button in reviewer
  	And approve the record by the final checker user
  	
  	Given User should go to the kubs url and login as a maker user
    And user should navigate to fixed assets menu
    When click on eye button of asset undertaking
    Then click on first view button to see the Transferred to Branch
    And maker should logout
    
@KUBS_FAT_UAT_005_008
Scenario: Check accounting entries

Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record
Then validate voucher number
    
@KUBS_FAT_UAT_006_001
Scenario: Check if any unused asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with unused asset
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_002
Scenario: Check if any used asset can be allocated to a specific resource in the branch

Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with used asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_003
Scenario: Check if any impaired asset can be allocated to a specific resource in the branch
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with impaired asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_004
Scenario: Check if any re-valued asset can be allocated to a specific resource in the branch
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill the Allocation form with revalued asset details
Then Save the filled Allocation
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Finance
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Allocation Eye button

@KUBS_FAT_UAT_006_005

Scenario: Check If the de-allocated asset can be allocated to any other resource
#Creation
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#Allocate
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login

Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on Asset Allocation Eye button
And get the allocated asset reference number in asset allocation module
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
#Then Fill asset deallocaion Mandatory fields
Then Fill asset deallocaion Mandatory fields to deallocate the asset 
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Allocate
#Given Maker Navigate to UAT URL login
#Then Click on fixed asset deallocaion  Direction icon
#Then Click on Fixed assets field
#Then Click on Asset Allocation Eye button
#Then Click on the add button to add new record
#Then Fill Asset Allocation Form another employee
#Then Click on Fixed Asset Save button
#Then Click on Fixed Asset Notification 
#And Select and Submit the record
#Then log in to the reviewer account
#Then click on the Notification select the record and Approve 
#Then log in to the Checker Account
#And then checker claim the record
#Then click on the checker Notification 
#And select the record and Approve by checker

@KUBS_FAT_UAT_006_007 
Scenario: Check If the asset to be transferred then it can be de-allocated

Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset transferred deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_FAT_UAT_006_008 
Scenario: Check If the asset to be sold then it should be de-allocated

Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset sold deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker



@KUBS_FAT_UAT_006_009 
Scenario: Check if any impaired asset can be de-allocated
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation impaired
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
# 
Then Click on Asset Impairment Eye button
Then Click on the add button to add new record
Then fill the form for Asset Impairment
Then Click on Fixed Asset Save button
#Allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form impaired
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset impaired deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_FAT_UAT_006_010 
Scenario: Check if any Check if any re-valued asset can be de-allocated asset can be de-allocated

#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation revalued
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#revalued asset
Then Click on revalued asset Eye button
Then Click on the add button to add new record
Then fill the form for revalued asset
Then Click on Fixed Asset Save button
#Allocation
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form revalued
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset Revalued deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker


@KUBS_FAT_UAT_006_011 
Scenario: Check if any amended asset can be de-allocated
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation amended
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#amended asset
Then Click on amended asset Eye button
Then Click on the add button to add new record
Then fill the form for amended asset
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Allocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field 
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form amended
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset amended deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker




@KUBS_FAT_UAT_006_012 @MultiAuth
Scenario: Check if any asset replacement is de-allocated
#Creation
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form asset Creation
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#asset replacement 
Then Click on asset replacement  Eye button
Then Click on the add button to add new record
Then fill the form for asset replacement 
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Allocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation for asset replacement
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
Then Fill asset replacement deallocaion Mandatory fields
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

 @KUBS_FAT_UAT_007_001 @AssetReturn
Scenario: Check if the asset can be returned to its vendor
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

 @KUBS_FAT_UAT_007_002 @returnRevaluedAsset
Scenario: Check if the re-valued asset can be returned to its vendor
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And go to revalued asset module
And click on Add Icon
Then Give AssetReferance Number
And Select Asset Item Number
Then Alter the Book Value
Then save the Revaluation record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And go to revalued asset module
Then check the approved record is displayed in revalued asset
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of revalued asset
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

@KUBS_FAT_UAT_007_003 @AmmendentAssetReturn
Scenario: Check if the ammendent asset can be returned to its vendor
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
Then goto ammendent asset module
And click on Add Icon
Then Enter Asset Referance Number in ammendent asset
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
Then goto ammendent asset module
Then check the approved record is displayed in ammendent asset
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of ammendent asset
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset


@KUBS_FAT_UAT_007_004 @returnImpairedAsset
Scenario: Check if the impaired asset can be returned to its vendor
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose asset reference number in asset impaired module
And choose the asset Item no
And choose the transcation type as impairment
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of impaired asset
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

@KUBS_FAT_UAT_007_005
Scenario: Check if the replaced asset can be returned to its vendor
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Replacement Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list

@KUBS_FAT_UAT_007_006 @deAllocatedAssetReturn
Scenario: Check if the deallocated asset can be returned to its vendor
Given Navigate to KUBS URL and login with maker credentials
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
And click on Add Icon
Then Fill the asset de Allocaion Mandatory fields
Then Click on Fixed Asset Save button for de allocation
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on asset deallocaion Eye button
Then check the approved record is displayed in de allocation list view
And click on view button nearby asset return module
And click on Add Icon
And choose asset reference number of de allocated asset
And choose item number for the asset
Then click on Save after fill all the asset
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button nearby asset return module
Then check the approved record is displayed in list view of returned asset

@KUBS_FAT_UAT_007_007
Scenario: Check if the undertaken asset can be returned to its vendor
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Undertaken Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list


@KUBS_FAT_UAT_007_008
Scenario: Check If asset required to retun before vendor payment
Given Navigate the Azentio url
Then click Third Segment button
And Click on Enquiry main module
Then Click on Financial sub module Edit icon
And Click Branch code Dropdown
Then Select GL code as Fixed asset
And Choose calender From date
Then Choose Calender To date
And Click on View and See the record


@KUBS_FAT_UAT_007_009
Scenario: Check If If asset is required to return after vendor payment
Given Navigate the Azentio url
Then click Third Segment button
And Click on Enquiry main module
Then Click on Financial sub module Edit icon
And Click Branch code Dropdown
Then Select GL code as Fixed asset code
And Choose calender From date
Then Choose Calender To date
And Click on View and See the record


@KUBS_FAT_UAT_008_001
Scenario: Check the asset for its replacement (any)
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click Add Icon button
Then Enter the Asset Referance Number
And Enter the Asset Item Number
Then Enter the New Item Number
And Enter the New Description
Then save the Replacement recordss
And Went to Maker Notification
Then Click the first Action icon
And Submit the Record in maker
Then Enter Remark and Submit it
Given Launch the Azentio Reviewer
And Click Reviewer Notification icon
Then Click submitted record from maker
And Click Approve icon from Reviewer End
Then Enter remark and submit the Record
Given Launch the Azentio Checker
Then Click Security management
And Click open pool Edit icon
Then Claim record Approved from Reviewer
And Click Checker Notification icon
Then Click Action Icon from claimed record
And Click Approve icon
Then Submit Record from Checker End  
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click on the search icon
Then Enter Asset Referance No
When capture Asset Grid view 


@KUBS_FAT_UAT_009_001
Scenario: Check the impairement of asset 
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
And click on search icon
And search the active record in asset creation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_009_002
Scenario: Check the impairement of asset (allocated)
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record


Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#Allocate
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker



Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And go to asset allocation module
And click on search icon
And get the active reference number in asset allocation module
#Then check asset reference number is availabe in the list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage


@KUBS_FAT_UAT_009_003    
Scenario: Check the impairement of asset (de allocated)
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

#Reference
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Select Asset Reference Number
#Allocate
Then Click on Asset Allocation Eye button
Then Click on the add button to add new record
Then Fill Asset Allocation Form
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
#Deallocation
Given Maker Navigate to UAT URL login

Then Click on fixed asset deallocaion  Direction icon
Then Click on Fixed assets field
Then Click on Asset Allocation Eye button
And get the allocated asset reference number in asset allocation module
Then Click on asset deallocaion Eye button
Then Click on Fixed Asset Add button
#Then Fill asset deallocaion Mandatory fields
Then Fill asset deallocaion Mandatory fields to deallocate the asset 
Then Click on Fixed Asset Save button
Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

Given Navigate to KUBS URL and login with maker credentials




And click on fixed asset main module
And go to asset de allocation module
And click on search icon
And get the active reference number in asset de allocation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_009_004
Scenario: Check the impairement of asset (re-valued)
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset reference number to do the asset revaluation

Then 	Asset Revaluvation submodule Eye Icon
And 	Add Icon button
Then 	Give Asset Referance Number
And Select Asset Item Number
Then Alter TheBook Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker

And click on fixed asset main module
And go to revalued asset module
And click on search icon
And get the active reference number in asset re valuation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_009_005
 Scenario: Check the impairement of asset (ammendent)
 Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

 Given Navigate to KUBS URL and login with maker credentials
 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which we need
And Click on calender Icon
And Choose a current date in calender
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End

 
 Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset ammendent module
And click on search icon
And get the active reference number in the assetammendment module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage


@KUBS_FAT_UAT_009_006
Scenario: Check the impairement of asset ( Replacement- maker done)
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And get the asset reference number for do asset replacement 
#Given Launch The Azentio Url
#Then Click Second Segman button
#And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click Add Icon button
#Then Enter the Asset Referance Number
Then Enter the Asset Referance Number which we got from aset Creation module 
And Enter the Asset Item Number
Then Enter the New Item Number
And Enter the New Description
Then save the Replacement recordss
And Went to Maker Notification
Then Click the first Action icon
And Submit the Record in maker
Then Enter Remark and Submit it

Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset replacement module
And get the active reference number in the asset replacement module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage


@KUBS_FAT_UAT_009_007 
Scenario: Check the impairement of asset (return)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset return module and choose the edit icon
And click on search icon
And get the active reference number in asset return module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_009_008
Scenario: Check the impairement of asset (sale)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset sale module and choose the edit icon
And click on search icon
And get the active reference number in asset Sale module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_009_009
Scenario: Check the impairement of asset (Transfer)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset transfer module and choose the edit icon
And click on search icon
And get the active reference number in asset Transfer module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_001
Scenario: WriteOff an asset if it is not usable
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number in asset Creation
Then check if the asset life is exhausted
And click on view button near by asset impairement module
And click on Add Icon
And select asset reference number
And select asset reference number for write Off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

#Given Navigate to KUBS URL and login with maker credentials
@KUBS_FAT_UAT_010_002
Scenario: Check the accounting entries
Given Navigate to URL and user should login as a maker
Then click on report button
And click Enquiry menu
Then click on Edit icon near by financial transaction
And choose branch code Id
And click on transaction from date in calender icon
Then choose from date in the calender
And click on the transaction to date in calender icon
Then choose the To date in the calender
And click on view button to see the Record

@KUBS_FAT_UAT_010_003
Scenario: Check the Write Off for an revalued asset (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do revaluation
Then check if the asset life is exhausted
And go to revalued asset module
And click on Add Icon
Then Give Asset Referance Number of revaluation
And Select Asset Item Number
Then Alter the Book Value
Then save the Revaluation record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number for revalued assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_004
Scenario: Check the Write Off for an amended asset (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do ammendent
Then check if the asset life is exhausted
Then goto ammendent asset module
And click on Add Icon
Then Enter Asset Referance Number in ammendent asset for doing write off
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
Then goto ammendent asset module
Then check the approved record is displayed in ammendent asset
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of ammendent assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_005
Scenario: Check the Write Off for an impaired asset (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do impairement
Then check if the asset life is exhausted
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of expaired asset
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number for write Off
Then Validate whether the reference number is visible in dropdown

@KUBS_FAT_UAT_010_006
Scenario: WriteOff an asset if it is not usable in asset replacement
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do replacement
Then check if the asset life is exhausted
And click on view button in asset replacement module
And click on Add Icon 
And fill the required details 
And save the replacement record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of replacement assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_007
Scenario: Check the Write Off for an allocated asset (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do allocation
Then check if the asset life is exhausted
And goto assetallocation module
And click on Add Icon 
And enter reference number
And enter item number in allocation module
And choose the employee
Then save the record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of allocated assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_008
Scenario: Check the Write Off for an de-allocated asset (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do allocation
Then check if the asset life is exhausted
And goto assetallocation module
And click on Add Icon 
And enter reference number
And enter item number in allocation module
And choose the employee
Then save the record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And goto asset deallocation module
And click on Add Icon
And enter asset reference number for de allocation 
And enter asset item number for de allocation 
And save the asset deallocation record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of deallocated assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_010_009
Scenario: Check the Write Off for an undertaken asset from other branch (usage life exhausted)
Given Navigate to KUBS URL and login with maker credentials
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do undertaking
Then check if the asset life is exhausted
And Goto Asset Transfer 
And click on Add Icon
And enter asset reerence Number
And enter new ranch 
And enter transfer as yes and save the record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
#Then verify the approval status of the record
And logout from reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
And enter transfer as yes and save the record in second reviewer
Then click on notification button
And select our record in notification records using reference ID
And click on Submit button
And enter the remark in alert
Then click on submit in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
And logout from reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
And verify the record got approved from checker
And logout from reviewer
And login with Maker ID

And click on fixed asset main module
And go to asset undertaking module
And click on search icon
And check the asset reference number is available in the undertaking module
And get the text of asset code and transfered branch name
And choose configuration option
And click on entity maintenece
And click on view button near by legal entity branches
And click on search icon
And search the brach name and get the branch code
And choose finance option
And click on fixed asset configuration 
And the click on view button near by serail number setup 
And click on search icon
And serach the asset code and get the last serail number
And click on fixed asset main Module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of undertaking assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

@KUBS_FAT_UAT_011_001
Scenario: Create an amendment to modify an asset for capitalization date
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

 Given Navigate to KUBS URL and login with maker credentials
 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which we need
And Click on calender Icon
And Choose a current date in calender
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_011_002
Scenario: Create an amendment to modify asset life for a fixed asset
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view


@KUBS_FAT_UAT_011_003
Scenario: Create an amendment to modify asset life (lesser than current/existing asset life)
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life lesser than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_011_004
Scenario: Create an amendment to modify asset life (greater than current/existing asset life)
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life greater than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_012_001
Scenario: Alter the Value of an existing asset (Any)
Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record

Given Navigate to KUBS URL and login with maker credentials
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset reference number to do the asset revaluation

Then 	Asset Revaluvation submodule Eye Icon
And 	Add Icon button
Then 	Give Asset Referance Number
And Select Asset Item Number
Then Alter TheBook Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_002
Scenario: Alter the Value of an existing asset (de-allocation)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset deallocation submodule Eye Icon
#And Click Table first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Deallocation Referance Number
And Select Asset Item Number
Then Alter the Deallocation Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_012_003
Scenario: Alter the Value of an existing asset (Revalued)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click Table Row first Eye Icon
Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Revalued Referance Number
And Select Asset Item Number
Then Alter the Revalue Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_004
Scenario: Alter the Value of an existing asset (Impared)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Impairment submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Impaired Referance Number
And Select Asset Item Number
Then Alter the Impaired Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_012_005
Scenario: Alter the Value of an existing asset (Amendent)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Amendment submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Amendment Referance Number
And Select Asset Item Number
Then Alter the Amendment Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_006
Scenario: Alter the Value of an existing asset (undertaken)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Undertaken submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Undertaken Referance Number
And Select Asset Item Number
Then Alter the Undertaken Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List



@KUBS_FAT_UAT_012_007
Scenario: Alter the Value of an existing asset (Sold - Maker Only)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Sale submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Sale Referance Number
And Select Asset Item Number
Then Alter the Sale Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it

@KUBS_FAT_UAT_012_008
Scenario: Alter the Value of an existing asset (Return - Maker Only)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Return submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Return Referance Number
And Select Asset Item Number
Then Alter the Return Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it


@KUBS_FAT_UAT_012_009
Scenario: Alter the Value of an existing asset (Replace)
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
#Then Asset Replacement submodule Eye Icon
#And Click Table Row first Eye Icon
#Then Store the Referance No
Then Asset Revaluvation submodule Eye Icon
And Add Icon button
Then Give Asset Replace Referance Number
And Select Asset Item Number
Then Alter the Replace Book Value
Then save the Revaluation record
And Go to Maker Notification
Then Select the first Action icon
And Submit Record in maker
Then Give Remark and Submit it
Given Launch Azentio Reviewer Url
And Reviewer Notification icon
Then submitted record from maker
And Approve icon from Reviewer End
Then Enter remark and submit Record
Given Launch Azentio Checker Url
Then Click the Security management
And Click the open pool Note icon
Then Claim the record from Checker
And Checker Notification icon
Then Action Icon from claimed record
And Press Approve icon
Then Submit Record from Checker
Given Navigate the Maker Url
Then Choose Second Segmant Icon
And fixed Asset Module
Then Asset Revaluvation submodule Eye Icon
And Click search icon button
Then Give the Asset Referance Number 
When capture Asset Grid view List

@KUBS_FAT_UAT_013_004
 Scenario: Check Depreciation
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of depreciation
 And select required fields to check the depreciation details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset depreciation details for a branch
 
 @KUBS_FAT_UAT_013_005
Scenario: Check Asset GL
Given Navigate to URL and user should login as a maker
Then click on report segment button
And click on equiry menu
Then click on edit icon near by fiancial transaction menu
And choose branch code
And choose Gl code
And click on transaction from date calender icon
Then choose the from date
And click on the transaction to date calender icon
Then choose the to date
And click on view button
Then validate voucher number
 
@KUBS_FAT_UAT_013_007
Scenario: Check Asset Creation(Common)
Given Navigate to URL and user should login as a maker
Then click on report button
Then Click on Report Tab
Then Click on Asset Creation Common Edit Grid
Then Fill the form
Then Click on view button to see Asset Creation report
Then verify the approved record is available in the report

 @KUBS_FAT_UAT_013_008
 Scenario: Check Asset Creation(item)
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of asset creation item
 And select the asset life unit and date to check the asset category are displaying
 Then click in the view button to check
 Then the report is displaying all the asset transfer details for a branch
 
 @KUBS_FAT_UAT_013_009
 Scenario: Check Asset Contract
 Given User should go to the kubs url and login as a maker user
 Then click on report icon
 And user should navigate to reports menu
 Then click on temp grid button of asset contract
 And select the contract ref number and date to check asset contract details are displaying
 Then click in the view button to check
 Then the report is displaying all the asset contract details for a branch
 
  @KUBS_FAT_UAT_013_011
  Scenario: Check Asset Transfer
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And select the asset code and date to check the asset transfer details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset transfer details for a branch
 
  @KUBS_FAT_UAT_013_012
  Scenario: Check Asset Undertaking
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to reports menu
    Then click on temp grid button of asset transfer
    And select the asset code and date to check the asset undertaking details are displaying
    Then click in the view button to check
    Then the report is displaying all the asset undertaking details for a branch 
@KUBS_FAT_UAT_013_013  @MultiAuth
Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then click on report segment button
Then Click on Report field
Then click on Asset Sale Report
Then Select the Asset Sale Code
Then Select the date Asset Sale
And click on view button of report
Then verify the Asset Sale report



#----pending---#
@KUBS_FAT_UAT_002_008
Scenario: Running batch job for the fixed asset
Given Navigate to kubs URL and user should login as a maker
Then Click on Job Scheduler
Then Click on Job Execution edit button
Then Click on calander to set desire date
Then click on Start the job
Then Click on refresh button
Then login with maker to check if date is changed or not

@KUBS_FAT_UAT_003_005
Scenario: Check if Depreciation is calculated after running the batch process

Given Navigate to kubs URL and user should login as a maker
Then Click on Job Scheduler
Then Click on Job Execution edit button
Then Click on calander to set desire date
Then click on Start the job
Then Click on refresh button
Then login with maker to check if date is changed or not

@KUBS_FAT_UAT_013_016
Scenario: Check Asset return Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on return Report edit button
Then Fill details for return report
Then Select return date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_017
Scenario: Check Asset replacement Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Asset replacement Report edit button
Then Fill details for report
Then Select date from calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_018
Scenario: Check Impairement Loss booking Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Impairement Report edit button
Then Select Impairement loss date in calendar
Then Click on the View button
Then close the report

@KUBS_FAT_UAT_013_019
Scenario: Check Asset Revaluation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Revaluation Report edit button
Then Select Revaluation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_014
Scenario: Check Asset Allocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Allocation Report edit button
Then fill Allocation Report details
Then Select Allocation date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_015
Scenario: Check Asset DeAllocation Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on DeAllocation Report edit button
Then fill DeAllocation Report details
Then Select DeAllocation from date in calendar
Then Select DeAllocation to date in calendar
Then Click on the View button
Then close the report


@KUBS_FAT_UAT_013_010
Scenario: Check Asset Amendment Report
Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Transaction Reports tab
Then Click on Amendment Report edit button
Then fill Amendment Report details
Then Select Amendment from date in calendar
Then Select Amendment to date in calendar
Then Click on the View button
Then close the report

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

 @KUBS_FAT_UAT_013_003 
Scenario: Check Asset Codes 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset code 
And select the depreciation method and date to check the asset codes are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 

@KUBS_FAT_UAT_013_006 
Scenario: Check Asset Serial Number 
Given User should go to the kubs url and login as a maker user 
Then click on report icon 
And user should navigate to master reports menu 
Then click on temp grid button of asset serial number 
And select the asset code and serial number and date to check the asset serial number are displaying 
Then click in the view button to check 
Then the report is displaying all the asset codes details for a branch 















