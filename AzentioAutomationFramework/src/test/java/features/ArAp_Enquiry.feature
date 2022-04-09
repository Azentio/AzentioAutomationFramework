Feature: accounting entries for the AR/AP

@KUBS_AR/AP_UAT_010_003_TC_02 @MultiAuth

Scenario: Verify accounting entries for bounced cheques.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate bounced cheques vourcher number 

@KUBS_AR/AP_UAT_010_004_TC_02 @MultiAuth

Scenario: Verify accounting entries for bounced & redeposited cheques.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for bounced cheques
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate cleared cheques vourcher number 
#DEP-RR88888888-20220307

@KUBS_AR/AP_UAT_004_002_TC_02 @MultiAuth

Scenario: Verify No accounting entries are posted post payment settlement approval.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the Branch detail
Then select Transaction from date bounced cheques
Then select Transaction to date bounced cheques
And click on view button for record
Then validate No accounting entries are posted
