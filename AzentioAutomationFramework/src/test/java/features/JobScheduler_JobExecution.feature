Feature: JobScheduler
 Job Execution, Job Definition, Batch job details 
    
  @KUBS_GL2_UAT_007_002 @StartJobExecution
  Scenario: StartJob
    Given User should go to the kubs url and login as a maker user
    Then Selet configuration
    And user should navigate to job scheduler menu
    When click on temp grid button of job execution
    And select the date to start job
    Then Click on start job
    
  @KUBS_GL2_UAT_007_001 @BatchJobConfiguration
  Scenario: Configure batch job
    Given User should go to the kubs url and login as a maker user
    Then Selet configuration
    And user should navigate to job scheduler menu
    When click on temp grid button of job definition
    Then click on add button to config job
    And fill the required fields for day end activity
    Then click on save button1
 
  @BatchJob
  Scenario: Execute batch jobs
    Given User should go to the kubs url and login as a maker user
    Then Selet configuration
    And user should navigate to job scheduler menu
    When click on temp grid button of batch job details
    And select the date to search batch job details
    Then Click on search job
    
