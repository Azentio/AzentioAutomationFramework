Feature: Checking the General Ledger Report functionality

@KUBS_GL2_UAT_008_006 @MultiAuth

Scenario: Check report for Financial Transaction 
					The report should display all the details for transaction.
					
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Financial Transaction Report
Then fill the input fields of Financial Transaction
Then Select Transaction from date Financial Transaction Report
Then select Transaction to date Financial Transaction Report
And click view button of report
Then verify the approved invoicebill number is available in report

@KUBS_GL2_UAT_008_005 @MultiAuth

Scenario: Check report for GL monthly balances.
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on GL monthly balances 
Then fill the input fields of GL monthly balances
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report

@KUBS_GL2_UAT_008_011 @MultiAuth

Scenario: System should display the balancesheet report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on balancesheet report
Then fill the input fields of balancesheet report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in the report


@KUBS_GL2_UAT_008_012 @MultiAuth

Scenario: System should display the Cashflow statement report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Cashflow statement report
Then fill the input fields of Cashflow statement report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report

@KUBS_GL2_UAT_008_013 @MultiAuth

Scenario: System should display the Income statement report  
Given Maker Navigate to UAT URL login
Then click on report segment button
Then click on Financial reporting button
Then click on Income statement report
Then fill the input fields of Income statement report
Then Select Transaction from date Financial Transaction Report
And click view button of report
Then verify the Record available in report
