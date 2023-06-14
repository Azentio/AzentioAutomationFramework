Feature: Check the Functionality of the Fixed Assets

@KUBS_FAT_UAT_011_001
Scenario: Create an amendment to modify an asset for capitalization date
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which we need
And Click on calender Icon
And Choose a current date in calender
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_011_002
Scenario: Create an amendment to modify asset life for a fixed asset
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view


@KUBS_FAT_UAT_011_003
Scenario: Create an amendment to modify asset life (lesser than current/existing asset life)
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life lesser than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

@KUBS_FAT_UAT_011_004
Scenario: Create an amendment to modify asset life (greater than current/existing asset life)
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then click on Asset creation Eye icon
And Click to view First record and store RefNo
Then Click on Asset Ammendent submodule Eye Icon
And Click on Add Icon
Then Enter Asset Referance Number
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life greater than Value
Then Save the Asset Record
And Click on Maker Notification
Then Select Saved record and click on action icon
And Submit the Asset record to Reviewer
Given Launch the Azentio Reviewer Page
And Click the Reviewer Notification icon
Then Click the submitted record from maker
And Click the Approve icon from Reviewer End
Then Enter the remark and submit the Record
Given Launch the Azentio Checker page
Then Click the Security management module
And Click the open pool Edit icon
Then Claim the record Approved from Reviewer
And Click the Checker Notification icon
Then Click the Action Icon from claimed record
And Click on Approve icon
Then Submit the Record from Checker End  
Given Lauch The Azentio Url 
Then Click Second Segment Icon
And Click on fixed Asset Module
Then Click on Asset Ammendent submodule Eye Icon
And Click the search icon
Then Enter the Asset Referance No
When capture the Asset Grid view

