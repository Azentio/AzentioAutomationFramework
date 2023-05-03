Feature: To check the restricted CIF and Gl is resctriced in accounts module
@SADS_AT_067
Scenario: Checking on the "OR" restriction for CIF Type “A” and GL “Y”  under Accounts (Acc Query,FMA,General Acc,Closed dormant acc)
Given navigate to CSM application and login with valid credentials
Then Click the accounts under CSM application
And Click the Fixed maturity account flag under accounts
Then Click the opening under fixed maturity account
And Enter the currency code and search it under fixed maturity account 
Then Enter the type and it under fixed maturity account
And Enter the CIF type and search it under fixed maturity account
Then Validate the selected CIF and GL is resctricted under fixed maturity accounts
And Navigate and click the General accounts flag
Then Click the openings under general accounts
And Enter and search the currency code under general accounts
Then Enter and search the type under genearl accounts
And Enter and search the  CIF under the general accounts
Then Validate the CIF is resctricted under the general accounts
And Navigate and click the account query under accounts
Then Click and enter the GL code under the account query
And Click and enter the CIF number under the account query
Then Validate the selected CIF and GL is resctricted under account query
And Navigate and click the closed dormant account flag under accounts
Then Click the maintainance under the closed dormant account
And Enter and search the the CIF code under the closed dormant account
Then Validate the CIF is resctriced under the closed dormant account



