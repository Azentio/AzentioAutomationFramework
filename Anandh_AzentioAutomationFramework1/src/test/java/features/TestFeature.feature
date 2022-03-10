Feature: Test the transfer
Background: 
Given Navigate to KUBS URL and login with maker credentials
@KUBS_FAT_UAT_010_009_2
Scenario: Check the Write Off for an undertaken asset from other branch (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do undertaking
Then check if the asset life is exhausted
And Goto Asset Transfer 
And click on Add Icon
And enter asset reerence Number
And enter new ranch 
And enter transfer as yes and save the record
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
Then verify the approval status of the record
And logout from reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
And enter transfer as yes and save the record in second reviewer
Then click on notification button
And select our record in notification records using reference ID
And click on Submit button
And enter the remark in alert
Then click on submit in alert
And capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage
And logout from reviewer
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
And verify the record got approved from checker
And logout from reviewer
And login with Maker ID

And click on fixed asset main module
And go to asset undertaking module
And click on search
And check the asset reference number is available in the undertaking module
And get the text of asset code and transfered branch name
And choose configuration option
And click on entity maintenece
And click on view button near by legal entity branches
And click on search
And search the brach name and get the branch code
And choose finance option
And click on fixed asset configuration 
And the click on view button near by serail number setup 
And click on search
And serach the asset code and get the last serail number
And click on fixed asset main Module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of undertaking assset in write off
And choose the asset Item no
And choose the transcation type as writeOff
Then click on Save Button
Then click on notification button
Then choose first record in the notification record
And click on Submit button 
Then enter remark in confirmation alert
Then click on submit button in alert
And capture the reviewer ID in pop up which is open when we submit our record in maker stage
Then logout from maker
And login with reviewer credentials
Then click on notification button
And select our record in notification records using reference ID
Then Approve the record from reviewer
And enter the remark in alert
Then click on submit in alert
Then verify the approval status of the record
And logout from reviewer
Then login as a checker 
And click on security management menu in checker
Then click on action button under security management menu
And select our record and clime using reference ID
Then click on Notification button
Then select our record in notification records by the help of reference ID
And click on approve button in checker stage
Then give alert remark 
Then click on submit button on alert
And verify the record got approved from checker
Then logout from checker 
And login with Maker ID
And click on fixed asset main module
And click on view button near by asset impairement module
Then  check the approved record is displayed in appeared in maker list view stage

