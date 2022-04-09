Feature: Financial Reporting
  GL Balances Report
  
  @KUBS_GL2_UAT_005_001 @Report
  Scenario: Check GL balance for any period
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of GL Balances report
    And fill the required field of GL Balances report
    Then click on view button to view the report for any period
    
  @KUBS_GL2_UAT_004_001 @Report
  Scenario: Check report for GL monthly balances
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of GL monthly balances report
    And fill the required field of GL monthly balances report
    Then click on view button to view the report for monthly period
    
    
