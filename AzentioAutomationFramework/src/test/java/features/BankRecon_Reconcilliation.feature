Feature: Checking the Bank Reconcilliation  functionality

@KUBS_TAX_UAT_002_001_TC_001  @MultiAuth

Scenario: System allow user to create bank recon details by uploading correct txt file.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on purchase order Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file

@KUBS_TAX_UAT_002_001_TC_002  @MultiAuth

Scenario: Check system throws validation any data on Bank Reconciliation Details screen does not match with uploaded file.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on purchase order Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file data does not match

@KUBS_TAX_UAT_002_001_TC_003  @MultiAuth

Scenario: Check system throws validation any data on Bank Reconciliation Details screen does not match with uploaded file.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on purchase order Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file
Then Click on Inventory Item Save button
Then Click on Process button
Then verify matched record

@KUBS_TAX_UAT_002_001_TC_004  @MultiAuth

Scenario: System must give correct unmatch (Unmatch, Partial Match & Transposition match) basis the matching rule defined.
Given Maker Navigate to UAT URL login
Then Click on Direction icon
Then Click on Bank Reconcilliation
Then click on Bank Reconcilliation format eye button
Then Click on purchase order Add button
Then Select Bank Name and Account Number
Then Select Recon period from
Then Select Recon period to
Then upload the file
Then Click on Inventory Item Save button
Then Click on Process button
Then verify unmatch record