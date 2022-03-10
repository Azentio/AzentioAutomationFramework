Feature: Financial Reporting
  Trial Balance Report
  
  @KUBS_GL2_UAT_008_007 @Report
  Scenario: Check the trial balance
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report
    Then click on view button to view the report of Trial balance
    
  @KUBS_GL2_UAT_008_008 @Report
  Scenario: Check the trial balance summary
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report summarized
    And fill the required field of Trial Balance report summarized
    Then click on view button to view the report of Trial balance summary
    
    
