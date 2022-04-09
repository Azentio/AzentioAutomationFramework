Feature: AR/AP Module
 Manual Payout
    
  @KUBS_AR/AP_UAT_006_001_TC_01_Employee
  Scenario: Creating Manual payouts for approved Bills of a Vendor
   	Given Maker Navigate to UAT URL login
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    And click on add button for manual payout
  	And Fill the required fields for manual payout
 	 	Then Click on save button to save the Record for Account Recivable
Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
    
    Given Maker Navigate to UAT URL login
		Then Click on Direction icon
		Then Click on Account Payable 
    When click on eye button of manual payout
    Then Get the payout status
    

