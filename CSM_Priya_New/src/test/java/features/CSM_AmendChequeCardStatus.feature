Feature: checking the system is changing the chequebook status to its old status
@ACSD_006
Scenario: checking if the system is changing the chequebook status from "cancelled" to its old status "send to provider"
Given navigate to CSM application and login with valid credentials
Then Click the Amend cheque card status flag
And Click the maintainance under amend cheque card status 
Then Choose the product type as chequebook in amend cheque card status
And Enter the branch code in amend cheque card status
Then Enter the currency code under amend cheque card status
And Enter the GL code under amend cheque card status
Then Enter the CIF code under amend cheque card status
And Enter the serial number under amend cheque card status
Then Enter the request number under amend cheque card status
And Change the status as cancelled under amend cheque card status
Then Click the retrive button under the amend cheque card status
And Click the equivalent code check box under amend cheque card status
Then Click the update button and update the record under amend cheque card status
