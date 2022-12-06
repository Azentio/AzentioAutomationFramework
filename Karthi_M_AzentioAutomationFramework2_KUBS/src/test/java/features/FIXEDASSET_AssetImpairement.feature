Feature: To check the asset impairement module in fixed asset module
Background: 
Given Navigate to KUBS URL and login with maker credentials
@any
Scenario: Check the impairement of asset 
And click on fixed asset main module
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

@allocation
Scenario: Check the impairement of asset (allocated)
And click on fixed asset main module
And go to asset allocation module
Then check asset reference number is availabe in the list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select the asset reference number of allocated asset
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


@deallocation    
Scenario: Check the impairement of asset (de allocated)
#notExecuted
And click on fixed asset main module
And go to asset de allocation module
Then check asset reference number of de allocated asset is availabe in the list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And select the asset reference number of deallocated asset
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

@reVauedAsset
Scenario: Check the impairement of asset (re-valued)
And click on fixed asset main module
And go to revalued asset module
Then search the asset reference number of revalued is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of revalued asset
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
@ammendent
 Scenario: Check the impairement of asset (ammendent)
And click on fixed asset main module
And goto asset ammendent module
Then search the asset reference number of ammendent asset is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of ammendent asset
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


@replacementAsset
Scenario: Check the impairement of asset (Replacement)
And click on fixed asset main module
And goto asset replacement module
Then search the asset reference number of replacement asset is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of replaced asset
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


@Return 
Scenario: Check the impairement of asset (return)
And click on fixed asset main module
And goto asset return module and choose the edit icon
Then search the asset reference number of returned asset is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of returned asset
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

@AssetSale
Scenario: Check the impairement of asset (sale)
And click on fixed asset main module
And goto asset sale module and choose the edit icon
Then search the asset reference number of sale asset is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of sold asset
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

@assetTransfer
Scenario: Check the impairement of asset (Transfer)
And click on fixed asset main module
And goto asset transfer module and choose the edit icon
Then search the asset reference number of transfered asset is availabe in list view
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
And choose the asset reference number of transfered asset
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

@writeOff
Scenario: WriteOff an asset if it is not usable
And click on fixed asset main module
And goto asset creation module
Then search the asset reference number in asset Creation
Then check if the asset life is exhausted
And click on view button near by asset impairement module
And click on Add Icon
Then Check System shuld display the input fields
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

@writeOffImpairedAsset
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

@WriteOffRevaluedAsset
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

@ammendentWriteOff
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





