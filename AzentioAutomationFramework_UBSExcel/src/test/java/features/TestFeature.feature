Feature: Test
@KUBS_FAT_UAT_013_001
Scenario: Check Asset Limit Config
Given Maker Navigate to UAT URL login
And click on configuration section
And click on transaction section
Then Click on Fixed Asset
Then Click on Asset Creation Eye button
And store the asset branch for asset creation common report
And store the asset code and seet reference number for asset creation report
And seelect the asset creation approved record in list view
And store the asset life in for asset creation report validation
And click on asset Item tab in asset creation
And click on asset Item tab in asset creation
And select the item record in list view of item details
And store the capitalization date and created date for asset creation report
Then click on report button
And click on master report main module
And click on temp view of asset limit report
And enter the accounting standard in asset limit report
And enter the limit as on date in asset limit report
And click on view button in loss booking report screen
Then verify asset limit report should generate


@KUBS_FAT_UAT_001_01
Scenario: To verify maker user can able to submit the business partner setup record
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
And click on business partner setup main menu
And click on business partner view icon
And get the test data for creating the business partner record
And click on add button in businesspartner setup
And enter the business partner type
And enter the business partner sub type
And enter the reference type in business partner setup
And enter the reference code no in business partner setup
And save the business partner record
Then validate record got save in maker stage
And enter bp name in corporate section
And enter the registeration number in corporate section
And enter the country of registeration
And enter the industry in coporate section
And enter the complaince in corporate section
And enter the blackisted option in corporate section
And save the corporate section
And click on branch tab
And click on add button in branch
And enter the brance code in branch section
And enter the branch type in branch section
And enter the branch name in branch section
And enter the phone number in branch section
And enter the email in branch section
And enter the remark in branch section
And save the branch section details
And click on identification tab
And click on add button in identification section
And enter the id type in identification section
And enter the id number in identification section
And save the identification details
And click on bank account tab
And click on add button in bank account section
And enter the bank name in bank account section
And enter the branch name of bank in bank acoount section
And enter the account type in bank ccount section
And enter the account no in bank account section
And enter the account currency in bank account section
And enter the payment account indicator in bank account section
And enter the account status in bank coount section
And enter the remark in bank acount section
And save the bank account details
And click on HSN SAC Code mapping section
And click on add button in HSN SAC Code mapping 
And enter the HSN SAC Code in code mapping section
And enter the remark in HSN Code mapping section
And save the HSN record in business partner setup
And click on branch tab
And select the recently saved branch record
And click on address section
And enter the address type in address section
And check the correspondence address
And enter the address line one in address section
And enter the address line two in address section
And enter the address line three in address section
And enter the country in address section
And enter the state in address section
And enter the city in address section
And enter the zip code in address section
And save the address details data
And click on branch tab
And select the recently saved branch record
And enter the contact type in contact section
And enter the contact persion in contact sectiobn
And check the communication tab
And enter the designation in contact section
And enter the mobile one in contact section
And enter the mobile two in contac section
And enter the phone one in contact section
And enter the phone two in contact section'
And enter the emil one in contact section A
And enter the email two in contact section
And save the contact details section
And click on notification icon in maker stage
And click on search in maker notification section
And search the business partner module code in maker notification search
And store the record reference number of business partner record in excel database
And select the business partner record in maker notification
And click on submit in business partner
And enter the alert remark in business partner record
And click on alert submit in business partner
Then store the reviewer ID in business partner excel database 
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_02
Scenario: verify user can able to approve the businessPartner record
Given navigate to kubs url to approve the business partner setup record
And click on notification in reviewer stage
And select the record in notification
And click on approve button in reviewer stage
And enter the alert remark in reviewer stage
And click on submit in reviewer alert pop up
Then verify record got approved in reviewer stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_03
Scenario: To verify checker user can able to approve the business partner setup
Given Navigate to KUBS url and login with checker for approve the business partner setup record
And click on security management tool
And click on temp view near by open pool
And clime the record by the help of Record reference ID
Then verify record got climed in checker
And click on notification in checker stage
And select the record in notification in checker stage
And click on approve button in checker
And give approve alert remark in checker stage
And click on submit button in checker stage
Then verify record got approved in checker stage
And click on user profile icon
And click on logout button
Then verify user profile got logout
@KUBS_FAT_UAT_001_04
Scenario: To verify maker user can able to see the approved business partner in list view
Given Maker Navigate to UAT URL login
Then Click on Fixed Asset Direction icon
And click on business partner setup main menu
And click on business partner view icon
And get the test data for creating the business partner record
Then verify approved business partner should reflect in maker list view
And click on user profile icon
And click on logout button
Then verify user profile got logout