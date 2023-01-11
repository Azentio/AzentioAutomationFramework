Feature: user create the patty cash login details
@KUBS_PC_UAT_006_001
Scenario: Check report for fund requisition
Given User should go to the kubs url and login as a maker user 
Then click on report icon
And user should navigate to reports menu
Then user update the Excel sheet testdata for Pettycash
Then click on temp grid button of fund requisition report
And select the date to check the fund requisition details are displaying
Then click in the view button to check
Then the report is displaying all fund requisition details
   
@KUBS_PC_UAT_006_002
Scenario: Check report for petty cash receipt
Given User should go to the kubs url and login as a maker user
Then click on report icon
And user should navigate to reports menu
Then user update the Excel sheet testdata for Pettycashs
Then click on temp grid button of petty cash receipt report
And select the date to check the petty cash receipt details are displaying
Then click in the view button to check
Then the report is displaying all the petty cash receipt details
   
@KUBS_PC_UAT_006_003
Scenario: Check report for petty cash register
Given User should go to the kubs url and login as a maker user
Then click on report icon
And user should navigate to reports menu
Then user update the Excel sheet testdata for Pettycashss
Then click on temp grid button of petty cash register report
And select the date to check the petty cash register details are displaying
Then click in the view button to check
Then the report is displaying all the petty cash register details
