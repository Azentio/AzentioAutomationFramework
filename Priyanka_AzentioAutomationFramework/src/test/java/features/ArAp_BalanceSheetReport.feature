Feature: Balance Sheet
@KUBS_AR/AP_UAT_001_004_TC_07	
Scenario: Verify Balance sheet post Bill is approved.

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@KUBS_AR/AP_UAT_001_005_TC_02	
Scenario: Verify Balance sheet post GRN post approval of GRN

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@KUBS_AR/AP_UAT_001_005_TC_07	
Scenario: Verify Balance sheet post Bill is approved.

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Finincial Reporting tab
Then Click on Balance Sheet Report edit button
Then Fill branch details for report
Then Select date in calendar
Then Click on View button

@KUBS_AR/AP_UAT_010_005_TC_07	
Scenario: Accounts Receivable Report must display the correct info for logged in Branch

Given Maker Navigate to UAT URL login
Then Click on Report button
Then Click on Reports tab
Then Click on Account Receivable Report edit button
Then Fill Vendor employee details for report
Then Select date in calendar
Then select Receivable Status
Then Click on View button