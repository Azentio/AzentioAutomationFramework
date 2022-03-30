Feature: Check the Functionality of Petty cash
@KUBS_PC_UAT_001_001
Scenario: Create Expense Code Limit
	Given Navigate to the Azentio Url
	Then Click on Pettycash Configuration
	And Click on Expense Code Limit
	Then Click on Add Icon in Petty cash
	And Enter Expense code value
	Then Enter Expense Name Value
	And Choose Expense Gl
	Then Enter Max Limit Value
	And Choose Currency value
	Then save Record in Petty cash
	Then click on the Maker icon button
  And click on the Record submit
  Given Azentio Url login as Reviewer
  Then Click on Reviewer Notification icon
  And Click on to Reviewer Action button
  Then Click on to Approve button in Reviewer
  And Submit the record in reviewer
  Given Azentio Url login as checker page
  Then click on the security management
  And Click on the sub module open pool near Edit icon
  Then Click the claim option icon
  And Click on the checker notification icon
  Then click the checker action icon
  And Approve the Record in checker
  Then Submit the Record in checker 