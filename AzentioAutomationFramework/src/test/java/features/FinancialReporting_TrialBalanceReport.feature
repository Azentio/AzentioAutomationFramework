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
    
  @KUBS_GL2_UAT_008_009 @Report
  Scenario: Check the trial balance based on the leaf GL
    Given User should go to the kubs url and login as a maker user
    And user should navigate to accounting setup menu 
    Then click on eye button of chart of accounts definition submenu
    Then click on search button
    Then search coa code using coa name
    And get the coa code
    
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report based on leaf GL
    Then click on view button to view the report of Trial balance
    And check the trial balance based on the leaf gl is available
    
  @KUBS_GL2_UAT_008_010 @Report
  Scenario: Check the trial balance based on the given from date to till date 
  						(From date should be less than or equal to current business date)
    Given User should go to the kubs url and login as a maker user
    Then click on report icon
    And user should navigate to financial reporting menu
    Then click on temp grid button of Trial Balance report
    And fill the required field of Trial Balance report based on given date
    Then click on view button to view the report of Trial balance
    
    
