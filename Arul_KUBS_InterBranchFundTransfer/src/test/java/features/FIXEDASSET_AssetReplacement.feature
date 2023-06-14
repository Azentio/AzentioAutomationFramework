Feature: Check The Functionality of Asset ReplaceMent

@KUBS_FAT_UAT_008_001
Scenario: Check the asset for its replacement (any)
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click Add Icon button
Then Enter the Asset Referance Number
And Enter the Asset Item Number
Then Enter the New Item Number
And Enter the New Description
Then save the Replacement record
And Went to Maker Notification
Then Click the first Action icon
And Submit the Record in maker
Then Enter Remark and Submit it
Given Launch the Azentio Reviewer
And Click Reviewer Notification icon
Then Click submitted record from maker
And Click Approve icon from Reviewer End
Then Enter remark and submit the Record
Given Launch the Azentio Checker
Then Click Security management
And Click open pool Edit icon
Then Claim record Approved from Reviewer
And Click Checker Notification icon
Then Click Action Icon from claimed record
And Click Approve icon
Then Submit Record from Checker End  
Given Launch The Azentio Url
Then Click Second Segman button
And Click fixed Asset Module
Then Click on Asset Replacement submodule Eye Icon
And Click on the search icon
Then Enter Asset Referance No
When capture Asset Grid view 