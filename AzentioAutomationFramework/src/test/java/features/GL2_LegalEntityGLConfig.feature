Feature: Checking the Legal Entity GL Config

@KUBS_GL2_UAT_001_001 @MultiAuth

Scenario: Create a ledger at entity level
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon

@KUBS_GL2_UAT_001_002 @MultiAuth

Scenario: Mapping the GL in side the entity level
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon

@KUBS_GL2_UAT_001_003 @MultiAuth

Scenario: User should have permission to do the entity level transaction
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon
Then Click on Legal Entity GL Configuration Add button
Then Fill Legal Entity GL Configuration fields
Then save the Legal Entity GL Configuration record

Then Click on Update Deposited Cheque Notification
And Select and Submit the Update Deposited Cheque record
Then log in to the reviewer account
Then click on the Notification select the Cheque record and Approve
Then log in to the Checker Account
And then checker claim the record
Then click on the checker Notification 
And select the Cheque record and Approve by checker
Given Maker Navigate to UAT URL login
Then Click on Direction Left
Then Click on General ledger configuration
Then Click on Legal Entity GL Configuration Eye Icon