Feature: AR/AP Module






 




















@KUBS_AR/AP_UAT_001_010_TC_02	  @AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given User should go to the kubs url and login as a maker user
And user should navigate to accounts payable menu
When click on eye button of invoice booking
And Click On Search Icon
And Update the data set id for Balance sheet Report b13
Then Click on Table Row First Eye Icon in ARAP
And search invoice type as expense
Then Click on Table Row First Eye Icon in ARAP
And get the buisness partner name and invoice number from the bill viewed
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries


@KUBS_AR/AP_UAT_002_001_TC_03	@AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Update the data set id for Balance sheet Report b14
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries


@KUBS_AR/AP_UAT_002_002_TC_03	@AR/AP
Scenario: Verify Balance sheet post Bill is approved.
Given User should go to the kubs url and login as a maker user
Then Click on the Direction
And Update the data set id for Balance sheet Report b15
Then Third Segment report Icon
And click the financial reporting
And click the balance sheet report
Then Fill the details for Balance sheet report
Then Click on View buttons
Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries

   