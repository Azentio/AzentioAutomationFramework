Feature: To check the asset impairement module in fixed asset module
Background: 
Given Navigate to KUBS URL and login with maker credentials
@KUBS_FAT_UAT_009_001
Scenario: Check the impairement of asset 
And click on fixed asset main module
And goto asset creation module
And click on search icon
And search the active record in asset creation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
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

@KUBS_FAT_UAT_009_002
Scenario: Check the impairement of asset (allocated)
And click on fixed asset main module
And go to asset allocation module
And click on search icon
And get the active reference number in asset allocation module
Then check asset reference number is availabe in the list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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


@KUBS_FAT_UAT_009_003    
Scenario: Check the impairement of asset (de allocated)
And click on fixed asset main module
And go to asset de allocation module
And click on search icon
And get the active reference number in asset de allocation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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

@KUBS_FAT_UAT_009_004
Scenario: Check the impairement of asset (re-valued)
And click on fixed asset main module
And go to revalued asset module
And click on search icon
And get the active reference number in asset re valuation module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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

@KUBS_FAT_UAT_009_005
 Scenario: Check the impairement of asset (ammendent)
And click on fixed asset main module
And goto asset ammendent module
And click on search icon
And get the active reference number in the assetammendment module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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


@KUBS_FAT_UAT_009_006
Scenario: Check the impairement of asset (Replacement)
And click on fixed asset main module
And goto asset replacement module
And click on search icon
And get the active reference number in the asset replacement module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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


@KUBS_FAT_UAT_009_007 
Scenario: Check the impairement of asset (return)
And click on fixed asset main module
And goto asset return module and choose the edit icon
And click on search icon
And get the active reference number in asset return module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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

@KUBS_FAT_UAT_009_008
Scenario: Check the impairement of asset (sale)
And click on fixed asset main module
And goto asset sale module and choose the edit icon
And click on search icon
And get the active reference number in asset Sale module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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

@KUBS_FAT_UAT_009_009
Scenario: Check the impairement of asset (Transfer)
And click on fixed asset main module
And goto asset transfer module and choose the edit icon
And click on search icon
And get the active reference number in asset Transfer module
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number
And choose the asset Item no
And choose the transcation type as impairment
And check the book value of asset
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

@KUBS_FAT_UAT_010_001
Scenario: WriteOff an asset if it is not usable
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number in asset Creation
Then check if the asset life is exhausted
And click on view button near by asset impairement module
And click on Add Icon
And select asset reference number
And select asset reference number for write Off
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

@KUBS_FAT_UAT_010_005
Scenario: Check the Write Off for an impaired asset (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do impairement
Then check if the asset life is exhausted
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of expaired asset
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
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number for write Off
Then Validate whether the reference number is visible in dropdown

@KUBS_FAT_UAT_010_003
Scenario: Check the Write Off for an revalued asset (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do revaluation
Then check if the asset life is exhausted
And go to revalued asset module
And click on Add Icon
Then Give Asset Referance Number of revaluation
And Select Asset Item Number
Then Alter the Book Value
Then save the Revaluation record
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
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number for revalued assset in write off
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

@KUBS_FAT_UAT_010_004
Scenario: Check the Write Off for an amended asset (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do ammendent
Then check if the asset life is exhausted
Then goto ammendent asset module
And click on Add Icon
Then Enter Asset Referance Number in ammendent asset for doing write off
And Enter Asset Item Number
Then Choose Modification Type Which need
And Enter Asset Life Value
Then Save the Asset Record
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
Then goto ammendent asset module
Then check the approved record is displayed in ammendent asset
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of ammendent assset in write off
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


@KUBS_FAT_UAT_010_006
Scenario: WriteOff an asset if it is not usable in asset replacement
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do replacement
Then check if the asset life is exhausted
And click on view button in asset replacement module
And click on Add Icon 
And fill the required details 
And save the replacement record
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
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of replacement assset in write off
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

@KUBS_FAT_UAT_010_007
Scenario: Check the Write Off for an allocated asset (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do allocation
Then check if the asset life is exhausted
And goto assetallocation module
And click on Add Icon 
And enter reference number
And enter item number in allocation module
And choose the employee
Then save the record
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
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of allocated assset in write off
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

@KUBS_FAT_UAT_010_008
Scenario: Check the Write Off for an de-allocated asset (usage life exhausted)
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number which we going to do allocation
Then check if the asset life is exhausted
And goto assetallocation module
And click on Add Icon 
And enter reference number
And enter item number in allocation module
And choose the employee
Then save the record
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
And goto asset deallocation module
And click on Add Icon
And enter asset reference number for de allocation 
And enter asset item number for de allocation 
And save the asset deallocation record
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
And click on Add Icon
Then Check System shuld display the input fields
And select asset reference number of deallocated assset in write off
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

@KUBS_FAT_UAT_010_009
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
#Then verify the approval status of the record
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
And click on search icon
And check the asset reference number is available in the undertaking module
And get the text of asset code and transfered branch name
And choose configuration option
And click on entity maintenece
And click on view button near by legal entity branches
And click on search icon
And search the brach name and get the branch code
And choose finance option
And click on fixed asset configuration 
And the click on view button near by serail number setup 
And click on search icon
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

