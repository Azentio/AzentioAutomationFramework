Feature: Check the Functionality of the Fixes Asset Return

@KUBS_FAT_UAT_007_005
Scenario: Check if the replaced asset can be returned to its vendor
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Replacement Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list 


@KUBS_FAT_UAT_007_007
Scenario: Check if the replaced asset can be returned to its vendor
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Undertaken Store the Referance No 
Then Asset Return Click on Eye Icon
And Asset Return Add Icon button
Then Give Asset Replacement Referance Number
And Select Asset Return Item Number
Then Click on save button in asset Return
And Click on Maker Notification icon button
Then Click on Action icon
And Approve the Asset Return Record
Then Enter Remark and click submit button
Given Launch the Azentio URL as Reviewer
And Reviewer Notification icon button
Then Click ACtion submitted record from maker
And Click Approve button from Reviewer End
Then Enter remark then submit Record
Given Launch the Azentio Checker URL
Then Main module Security management
And Sub module open pool Edit icon
Then Claim the record in checker
And Click Checker Notification icon button
Then Action Icon from claim record
And Click Approve icon button
Then Submit the Record from Checker 
Given Navigate the Azentio url
Then Click Second Segmant Icon
And Click main module fixed Asset Module
Then Asset Return Click on Eye Icon
And  Mouse click on search icon
Then Enter Asset Referance No in that field
When capture the Asset Grid view list


#@KUBS_FAT_UAT_007_008
#Scenario: Check If asset required to retun before vendor payment
#Given Navigate the Azentio url
#Then click Third Segment button
#And Click on Enquiry main module
#Then Click on Financial sub module Edit icon
#And Click Branch code Dropdown
#Then Select GL code as Fixed asset
#And Choose calender From date
#Then Choose Calender To date
#And Click on View and See the record


#@KUBS_FAT_UAT_007_009
#Scenario: Check If If asset is required to return after vendor payment
#Given Navigate the Azentio url
#Then click Third Segment button
#And Click on Enquiry main module
#Then Click on Financial sub module Edit icon
#And Click Branch code Dropdown
#Then Select GL code as Fixed asset code
#And Choose calender From date
#Then Choose Calender To date
#And Click on View and See the record

















