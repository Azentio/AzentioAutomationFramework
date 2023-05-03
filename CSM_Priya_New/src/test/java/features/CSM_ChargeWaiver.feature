Feature: To check the functinalities of charge waiver feature
@CW_008
Scenario: Checking the waiver when opening an FMA
Given navigate to CSM application and login with valid credentials
And Get the data set id for FMA
And Click the accounts falg
Then Click the Fixed Maturity Accounts under accounts
And Click the openings under fixed maturity accounts
Then Enter the currency code under FMA
And Enter the GL Type under FMA
Then Enter the CIF number under FMA
And Click the Instruction under FMA
Then Enter the transfer amount under instruction
And Enter the transaction type under instruction
#Then Save the FMA record
And Validate the charges amount is waived


@CW_024
Scenario: Checking on the waiver for the reversal trx charges
Given navigate to CSM param application and login with valid credentials
And Click the parameter under CSM param
Then Click the system parameter under parameter
And Click the reason under system parameter
Then Click the update after approval under the reason
And Enter the transaction code and select the record
Then Change the reason type as reverse under reason
Then Click the update after approve button
@CW_024_1
Scenario: Checking on the waiver for the reversal trx charges
Given navigate to CSM application and login with valid credentials
And Click the transactions under CSM
Then Click the reverse under transactions
And Enter the transaction number and select the record
Then Verify the reason is in reverse or not
And Click the to reverse button under reverse
Then Validate the pop message as charge is waived

@CW_028
Scenario: Checking the no waiver when New flag not checked/ Backward compatibility
Given navigate to CSM param application and login with valid credentials
And Click the parameter under CSM param
Then Click the system parameter under parameter
And Click the control record under system parametee
Then Click the update after approval under control record 
And Click the other information tab under control record
Then Uncheck the checkbox of apply charges waiver for specific period
And Approve the record and click update after approval
@CW_028_1
Scenario: Checking the no waiver when New flag not checked/ Backward compatibility in csm
Given navigate to CSM application and login with valid credentials
Then Click Chequebook request 
And Click the maintanence under chequebook request
Then Choose the Cheque code under chequebook request
And Enter the branch code under accounts in chequebook request 
Then Enter the Currency code under accounts in chequebook request 
And Enter the GL Code under accounts in chequebook request
Then Enter the CIF number under accounts in chequebook request
And Enter the serial number under accounts in chequebook request
Then Click the charges under chequebook request

#@CW_029
#Scenario: checking on the waiver under batch processing
#Given navigate to CSM application and login with valid credentials
#((Viplove need to check with his manager-file uploading test case))



