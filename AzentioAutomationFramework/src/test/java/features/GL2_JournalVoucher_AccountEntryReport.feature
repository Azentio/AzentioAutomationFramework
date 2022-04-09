Feature: accounting entries for the Journal vourcher 

@KUBS_GL2_UAT_003_003 @MultiAuth

Scenario: System should display the accounting entries for the vourcher generated.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate Journal vourcher number 



@KUBS_GL2_UAT_003_005 @MultiAuth

Scenario: System should display the accounting entries for the   vourcher generated.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate Journal vourcher Reversal number

@KUBS_GL2_UAT_008_002 @MultiAuth
Scenario: The report should display all the details for JV.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate all the details for Journal vourcher 

@KUBS_GL2_UAT_008_003 @MultiAuth

Scenario: The report should display all the details for JV reversal.

Given Maker Navigate to UAT URL login
Then click on report segment button
And click on equiry menu
Then click on edit icon near fiancial transaction menu
And fill the mandtory field for Journal vourcher
Then select Transaction from date Journal vourcher
Then select Transaction to date Journal vourcher
And click on view button for record
Then validate all the details for JV reversal
