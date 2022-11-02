 Feature: Check the Functionality of Fixed Asset module
 @KUBS_FAT_UAT_002_001 

Scenario: Create the asset limit

Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on Fixed Asset Notification
#Then Click on the Notification
Then Select the record which we saved
Then Submit record
Then Open Reviewer account
And Click on notification
Then Approve the record which we submitted from maker stage
Then Go to Checker account
And Clam the record
Then Click on notification and approve the record
Given Navigate to kubs URL and user should login as a maker
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
 
 @KUBS_FAT_UAT_002_006
Scenario: Creation of registered asset with minimum details
Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on Fixed Asset Notification
#Then Click on the Notification
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
 @KUBS_FAT_UAT_002_007
Scenario: Creation of the registered asset with full details

Given Maker Navigate to UAT URL login
Then Click on the Direction
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
Then Click on the add button to add new record
Then Fill Form
Then Save the filled form
Then Click on Fixed Asset Notification
#Then Click on the Notification
Then Select the record which we saved
Then Click on Fixed Asset items
Then Click on the add button of asset items
Then fill the asset item details
Then Click on save button of item details
#Then Click on Fixed Asset Notification
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
@KUBS_FAT_UAT_004_001
  Scenario: Check if the given asset is sold at higher price
 
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
Then fill the asset item details
Then Click on save button of item details
Then Click on the Notification
#Then Click on Fixed Asset Notification 
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker

    Given Maker Navigate to UAT URL login
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
    #Then Click on notification button in reviewer
  	#And approve the record by reviewer user
  	Then click on the Notification select the record and Approve
  	
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
    #Then click on first eye button to get the loss earned
    #And maker should logout
    
    
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
  
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
  #Creation
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
Then fill the asset item details
#Then fill the asset item details asset Creation replaced
Then Click on save button of item details
Then Click on Fixed Asset Notification icon
And Select and Submit the record
Then log in to the reviewer account
Then click on the Notification select the record and Approve 
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the record and Approve by checker
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
 
 