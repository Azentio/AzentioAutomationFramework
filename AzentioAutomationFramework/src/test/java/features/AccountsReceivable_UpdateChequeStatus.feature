Feature: ACCOUNTS RECEIVABLE
  Update Cheque Status
  
  @KUBS_AR/AP_UAT_010_002_TC_04
  Scenario: Verify accounting entries for cleared cheques.
 	  Given User should go to the kubs url and login as a maker user
    And user should navigate to accounts receivable menu
    When click on eye button of update cheque status
    Then get slip number by using cheque number
    Then click on report icon1
    Then click on enquiry menu
    Then click on temp grid button of financial transaction
    And fill the required fields of financial transaction
    Then click on view button to view the reports and verify
    