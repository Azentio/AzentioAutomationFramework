Feature: To check the functionalities of Account Resctriction in SADs application
@SADS_AT_001
Scenario: To resctrict the CIF and GL for all transaction
Given navigate to CSM sads application and login with valid credentials
And Choose the test data for account resctriction
Then Click the Parameter
And Click the Account Resctriction under parameter
Then Click the Maintainance under Account Resctriction
And Enter the code in Account Resctriction
Then Enter the description in Account Resctriction
And Choose the resctriction as AND or OR
And Click the Root under ApplicationOTPs
Then Click the RET under Root
And Click the Transaction Flag and select all transaction
Then Click the Root under CompaniesBranches
Then Select the Branch under Root
And Search the UserID
Then Click the checkbox of the searched user ID
And Click the Add button in the resctriction type
Then Click the search button to choose the GL code
And Enter the GL code input value and choose it
Then Click the add button in the resctriction type and select the CIF Type
And Click the add button in CIF Type
Then Click the search button in CIF Type
And Enter the CIF Type input value and select the value
Then Save the record in account resctriction
And Navigate to Approval in account resctriction
Then Enter the code input value and select it
And Approve the rescticted record
 



