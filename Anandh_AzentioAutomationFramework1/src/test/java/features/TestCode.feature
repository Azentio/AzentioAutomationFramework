Feature: Contract Report checking
Background: 
Given Navigate to KUBS URL and login with maker credentials
@KUBS_AR_AP_UAT_003_001_TC_01
Scenario: Check Contract Report
And click on accounts Payable module
And goto vendor contract module
Then click on search
And select the active contract number and business partner name from the approved grid view
And click on view button for open the record
And get the contract amount
And click on the item details

Then click on report segment button
And click on report main menu
And click the temp near by contract report 
And enter bp Name
And click on calender 
And give date for the calendar
And enter contract status
And click on the view button
Then verify the contract reference number is available in the report content


