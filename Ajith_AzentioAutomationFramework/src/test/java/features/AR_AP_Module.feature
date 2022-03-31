
Feature: Testing the AR/AP Module
@KUBS_AR/AP_UAT_001_002TC_02
Scenario: Verify Accounting entries post Bill is approved
   Given user navigate to azentio url and login as maker for verify post bill is approved in Accounting Entries
   When click the account payable main module for verify post bill is approved in Accounting Entries
   And click the eye icon of invoice bill booking for verify post bill is approved in Accounting Entries
   And click the search icon in list view for verify post bill is approved in Accounting Entries
   And search invoice type as expense for verify post bill is approved in Accounting Entries
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the Active  bill viewed 
   And click the notes option in top for verify post bill is approved
   And click the enquiry module for verify post bill is approved
   And click the financial transaction edit icon for verify post bill is approved in Accounting Entries
   And select the branch code as azentio main branch for verify post bill is approved in Accounting Entries
   And select the transaction from date  for verify post bill is approved in Accounting Entries
   And select the transaction to date for verify post bill is approved in Accounting Entries
   And select the Transaction Ref No
   And click the view option for verify post bill is approved in Accounting Entries
   Then verify that the invoice number get from Active bill matches with voucher id in report
   @KUBS_AR/AP_UAT_001_003TC_03
   Scenario: Verify Balance sheet post Bill is approved.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_001_004TC_01
Scenario: verify the accounting entries post approval of GRN
 Given user login as Azentio Maker
 When user click Accounts Payable
 And click the eye icon of GRN
 And user click search icon
 And Search GRN status as Active
 And click the first eye icon in the list
 And get the Grn number
 And click the Notes Option In Top
 And click The Enquiry Module for Accounting Entries
 And Click the Edit icon in Financial Transaction
 And Select Branch code as Azentio Manin Branch
 And Choose the Transaction from date
 And choose the Transaction To date
 And select the Transaction Ref No as Grn Number
 Then Verify the GRN number in Voucher Id and verify transaction type
 @KUBS_AR/AP_UAT_001_004TC_08
Scenario: Verify Accounts Payable Report post bill is approved.
Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as Invoice Against Po
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed invoice against po
   And get buisness partner name and Bill Status for invoice against po
   And click the notes option in top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status as Active
   And select the date
   And click the view icon
   Then verify the bill is Active in Accounts payable report
 @KUBS_AR/AP_UAT_001_007TC_02
 Scenario: verify Accounting entries of post bill approved
 Given user navigate to azentio url and login as maker for verify post bill is approved in Accounting Entries
   When click the account payable main module for verify post bill is approved in Accounting Entries
   And click the eye icon of invoice bill booking for verify post bill is approved in Accounting Entries
   And click the search icon in list view for verify post bill is approved in Accounting Entries
   And search invoice type as expense for verify post bill is approved in Accounting Entries
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the Active  bill viewed 
   And click the notes option in top for verify post bill is approved
   And click the enquiry module for verify post bill is approved
   And click the financial transaction edit icon for verify post bill is approved in Accounting Entries
   And select the branch code as azentio main branch for verify post bill is approved in Accounting Entries
   And select the transaction from date  for verify post bill is approved in Accounting Entries
   And select the transaction to date for verify post bill is approved in Accounting Entries
   And click the view option for verify post bill is approved in Accounting Entries
   Then verify that the invoice number get from Active bill matches with voucher id in report
   @KUBS_AR/AP_UAT_002_002TC_02
   Scenario: Verify Accounting entries post Credit Note is approved
   Given user login as Azentio Maker
   When click the Account Receivable Main Module for verify Accounting entries
   And click the credit note eye icon
   And click the search icon in the list view of credit 
   And search the Active credit note and click the first list
   And store the credit note number
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   And select the Transaction Ref No as Credit note Number
   Then Verify the Credit note number in Voucher Id and verify transaction type
 @KUBS_AR/AP_UAT_003_001TC_01
  Scenario: verify contract report should display the correct info for logged in branch
  Given user login as azentio maker for contract report verification
  When user click Accounts Payable for contract report verification
  And user click Vendor Contracts eye icon for contract report verification
   And click the first eye icon in the list for contract report verification
   And get buisness partner name,get contract end date and get contract acccount code,get contract status
   And click the notes option for contract report verification 
   And click the Reports Sub Module
   And click the contract report edit icon
   And select the vendor name according to contract
   And select the contract status based on we get from list
   And select the date based on contract end date
   And click the view icon
   Then verify the contract code in contract report
  @KUBS_AR/AP_UAT_003_001TC_02
  Scenario: Verify creating po against cancelled order is not allowed
    Given user navigate to the url and login as a maker
    When user click Accounts Payable
    And user click Vendor Contracts eye icon
    And user click search icon
    And user search cancelled vendor contract
    And User search Buisness partner name
    And user click the cancelled vendor contract eye icon
    And get buisness partner name 
    And click vendor purchase order eye ion
    And click vendor purchase order add ion
    And select buisness partner we get in cancelled list
    And select referece type as contract
    Then verify not able to select contract and po creation is not allowed
   @KUBS_AR/AP_UAT_003_001TC_03
   Scenario: check cancellation of contract is not allowed when purchase order is created against contract
   Given user navigate to the url and login as a maker for cancellation of contract is not allowed
   When click the accounts payable
   And click vendor purchase order eye ion
   And click search icon in list view
   And search PO status as Active
   And click the first eye icon in the list
   And get contract name in vendor 
   And click the vendor contract eye icon sub module
   And click the eye icon in list based on contractname
   And get buisness partner name and get contract acccount code
   And click the ar ap adjustment sub module
   And click ar ap eye icon
   And click add icon
   And select bp name according to bp we get in contratc
   And select adjustment type as cancellation
   And select adjustment item type as contract
   And select adjustment reference as we get in contract account code
   Then verify that cancellation of contract is not allowed when po created for contract
   @KUBS_AR/AP_UAT_003_004TC_01
   Scenario: verify accounting entries post bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And click the notes option in top
   And click the enquiry module
   And click the financial transaction edit icon
   And select the branch code as azentio main branch
   And select the transaction from date 
   And select the transaction to date
   And click the view option
   Then verify that the invoice number get from bill matches with voucher id in report
   @KUBS_AR/AP_UAT_003_004TC_03
   Scenario: verify Accounts payable report post bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status
   And select the date
   And click the view icon
   Then verify the bill is cancelled in Accounts payable report
   @KUBS_AR/AP_UAT_003_004TC_05
   Scenario: verify cancelled bill is not allowed for payment settlement
   When click the invoice eye icon in accounts payable
   And click the search icon in invoice booking list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And click the payment settlement eye icon
   And click the add icon in payment settlement
   And select payment option as buisness partnerwise
   And select buisness partner in payment settlement
   Then verify that no bill is available for payment settlement
   @KUBS_AR/AP_UAT_003_007TC_01
   Scenario: Verify Accounting entries post Credit Note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable Main Module for verify Accounting entries
   And click the credit note eye icon
   And click the search icon in the list view of credit 
   And search the cancelled credit note and click the first list
   And store the credit note number
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the Credit note number in Voucher Id and verify transaction type
   @KUBS_AR/AP_UAT_003_007TC_03
   Scenario: Verify Accounts Receivable Report post credit note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Credit note
   And select the date
   And click the view icon
   Then verify the Credit Note cancelled is available in the report
   @KUBS_AR/AP_UAT_003_007TC_04
  Scenario: verify credit cancelled is not available in payment settlement
   Given login azentio as maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get invoice number and get buisness partner name
   And click account payable main module
   And click the eye icon in account payable
   And click the add icon in payment settlement for credit
   And select payment option as buisness partnerwise for credit
   And select buisness partner in payment settlement for credit
   Then verify that invoice from credit not is not available in bill list
  @KUBS_AR/AP_UAT_004_001TC_01
  Scenario: verify active bill is available for payment settlement
  Given log in to azentio as maker
  When click the Account payable module
  And click the invoice booking eye icon in sub module
  And search Invoice status as active
  And click the first eye icon in the list view
  And get the buisness partner from invoice bill
  And click the payment settlement eye icon in Accounts payable
  And click the add icon fot the payment settlement
  And choose the payment option as Buisness partner Type
  And Enter buisness partner get from bill booking
  Then verify that active bill is available for payment settlement
  @KUBS_AR/AP_UAT_004_001TC_02
  Scenario: verify tds% and amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option
  When click the Account payable Mainmodule
  And click the eye icon of the payment settlement
  And click the add icon of the payment settlement
  And select payment option as buisness partner type
  And select the buisness partner from the list
  And select listed bill contains tds percentage
  And get tds percentage and calculate tds amount
  Then verify tds in bill with calculated tds amt
  #pending
  @KUBS_AR/AP_UAT_004_001TC_03
  Scenario: verify net payable amount is correctly calculated for the bill
  Given log into azentio as maker and select finance option for verify net payable amount 
  When click the Account payable Mainmodule for verify net payable amount 
  And click the eye icon of the payment settlement for verify net payable amount 
  And click the add icon of the payment settlement for verify net payable amount 
  And select payment option as buisness partner type for verify net payable amount 
  And select the buisness partner from the list for verify net payable amount 
  And select the bill in the list view
  And calculate the net payable amount from the bill in list view 
  Then verify netpayable amount in payment settlement with calculated amount
  @KUBS_AR/AP_UAT_004_001TC_04
  Scenario: verify pop up messages displayed and click yes to payment process
  Given log into azentio as maker and select finance option for verify pop up
  When click the Account payable Mainmodule for verify pop up
  And click the eye icon of the payment settlement for verify pop up
  And click the add icon of the payment settlement for verify pop up
  And select payment option as buisness partner type for verify pop up
  And select the buisness partner from the list for verify  pop up
  And select any bill in list view
  And choose the valid date
  And Enter the description
  And Click save button
  And pop up messages displayed and  click yes
  Then verify bill is proceed for payment
  @KUBS_AR/AP_UAT_004_001TC_05
  Scenario: verify pop up messages displayed and click no to  return payment settlement
  Given log into azentio as maker and select finance option for verify pop up display
  When click the Account payable Mainmodule for verify pop up display
  And click the eye icon of the payment settlement for verify pop up display
  And click the add icon of the payment settlement for verify pop up display
  And select payment option as buisness partner type for verify pop up display
  And select the buisness partner from the list for verify pop up display
  And select any bill in list view for verify pop up display
  And choose the valid date for verify pop up display
  And Enter the description for verify pop up display
  And Click save button  for verify pop up display
  And pop up messages displayed and click no
  Then verify bill is not proceed for payment and return to payment settlement
  @KUBS_AR/AP_UAT_004_001TC_06
  Scenario: verify accounting entries post payment settlement approval
   Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and verify payment Approval
   @KUBS_AR/AP_UAT_004_001TC_08
   Scenario: Verify Accounts Payable Report post payment settlement approval
    Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And get buisness partner name and payment settlement date
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
   @KUBS_AR/AP_UAT_004_004TC_01
   Scenario: Verify debit note is adjusted against the bill and Net adjusted value is correctly displayed
   Given log in as a Maker and select finance option for verify debit note against bill
   When click Account receivable Main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search Active in debit note status
   And click first eye icon in list view 
   And get buisness partner name and invoice number
   And click Account Payable Main Module for verify debit note against bill
   And click eye icon in Payment Settlement for verify debit note against bill
   And click the add icon of the payment settlement for verify debit note against bill
   And select payment option as buisness partner type for verify debit note against bill
   And Select buisness partner according to debit note buisnes partner
   And search the invoice number based on invoice after click bill and get gross,debit amount
   Then calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list
   Then verify net adjusted value in bill with net adjusted value shown in payment settlement page
   @KUBS_AR/AP_UAT_004_004TC_02
   Scenario: verfiy tds percent and tds value correctly calculated and displayed based on debit note
   Given log in as a Maker and select finance option for verify tds in debit note against bill
   When click Account receivable Main module for verify tds in debit note against bill
   And click debit note eye icon for verify tds in debit note against bill
   And click search button and then click debit note status search for verify tds in debit note against bill
   And search Active in debit note status for verify tds in debit note against bill
   And click first eye icon in list view for verify tds in debit note against bill
   And get buisness partner name and invoice number for verify tds in debit note against bill
   And click Account Payable Main Module for verify tds in debit note against bill
   And click eye icon in Payment Settlement for verify tds in debit note against bill
   And click the add icon of the payment settlement for verify tds in debit note against bill
   And select payment option as buisness partner type for verify tds in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get
   And get tds percent , net adjusted,tds amount based on invoice then click bill
   And calculate tds value based on tds percent and net adjusted value and verify with tds value in bill
   And get tds value from payment settlement for debit note
   Then verify calculated tds value equals to tds value get from payment settlement and correctly displayed
   @KUBS_AR/AP_UAT_004_004TC_03
   Scenario: verify net Payable amount is correctly calculated and displayed for debit note bill in payment settlement
   Given log in as a Maker and select finance option for verify Netpayable amount in debit note against bill
   When click Account receivable Main module for verify Netpayable amount in debit note against bill
   And click debit note eye icon for verify Netpayable amount in debit note against bill
   And click search button and then click debit note status search for verify Netpayable amount in debit note against bill
   And search Active in debit note status for verify Netpayable amount in debit note against bill
   And click first eye icon in list view for verify Netpayable amount in debit note against bill
   And get buisness partner name and invoice number for verify Netpayable amount in debit note against bill
   And click Account Payable Main Module for verify Netpayable amount in debit note against bill
   And click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill
   And click the add icon of the payment settlement for verify Netpayable amount in debit note against bill
   And select payment option as buisness partner type for verify Netpayable amount in debit note against bill
   And Select buisness partner according to debit note buisnes partner we get in debit list view
   And get gross amount, debit amount,tds percent,netpayable amount
   And calculate net adjusted value , tds value from net adjusted
   And Calcualte net payable amount from calculated net adjusted value and tds value
   Then verify calculated net payable amount with net payable amount get from debit bill
   And get net payable amount from payment settlement
   Then verify net payable amount is correctly displayed according to debit bill
   @KUBS_AR/AP_UAT_004_004TC_04
   Scenario: verify accounting entries post payment Approval for debit transaction
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get the transaction number from payment settlement
   And click the Notes Option In Top
   And click The Enquiry Module for Accounting Entries
   And Click the Edit icon in Financial Transaction
   And Select Branch code as Azentio Manin Branch
   And Choose the Transaction from date
   And choose the Transaction To date and click view option
   Then Verify the transaction number in Voucher Id and then payment approved
    @KUBS_AR/AP_UAT_004_004TC_06
   Scenario: Verify Accounts Payable Report post payment settlement approval for debit note
   Given user navigate to azentio url and login as maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search transaction number which is debit payment in payment settlement list view
   And click first eye icon in list view in payment settlement
   And get buisness partner name and payment settlement date, invoicenumber
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
    @KUBS_AR/AP_UAT_004_004TC_07
   Scenario: verify Receivable Report post payment Approval for debit note
   Given user navigate to azentio url and login as maker
   When click the Account Receivable main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search sale of assert in debit list
   And click first eye icon in list view 
   And get the debit note number and buisnes partner name,debit note date
    And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report
   @KUBS_AR/AP_UAT_001_007TC_04
    Scenario: verify Accounts payable report post bill is active
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status
   And select the date
   And click the view icon
   Then verify the bill is cancelled in Accounts payable report
   @KUBS_AR/AP_UAT_002_001TC_04
    Scenario: Verify Accounts Receivable Report post bill is approved.
   Given user navigate to azentio url and login as maker
   When click the Account Receivable main module
   And click debit note eye icon
   And click search button and then click debit note status search
   And search sale of assert in debit list
   And click first eye icon in list view 
   And get the debit note number and buisnes partner name,debit note date
    And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Debit note
   And select the date
   And click the view icon
   Then verify the debit note is available in Receivable Report
    @KUBS_AR/AP_UAT_003_004TC_02
   Scenario: Verify Balance sheet post Bill is cancelled
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of cancelled invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_004_001Tc_07
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_011_002TC_05
   Scenario: Verify receipts and receivable against cancelled appropriation are available again for receipt appropriation
    Given user navigate to azentio url and login as maker
    When click the Account Receivable main module
    And click the Appropriation reversal eye icon
    And click the search icon in list view
    And search the txt num
    And click first eye icon in list view Searched
    And get Receipt Reference number
    And click the Appropriation eye icon
    And click add icon
    And select the Reference number based on we got from Appropriation reversal
    And Click save button
    Then verify Receipts and receivable against cancelled appropriation must be available again for receipt appropriation
    @KUBS_AR/AP_UAT_002_002TC_04
     Scenario: Verify Accounts Receivable Report post credit note is Active
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as Active
   And click first eye icon in list view Searched
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the Reports Sub Module
   And click the Account Receivable Report
   And select the vendor name 
   And select the Receivable status based on we get from Credit note
   And select the date
   And click the view icon
   Then verify the Credit Note Active is available in the report
   @KUBS_AR/AP_UAT_004_005TC_05
   Scenario: Verify Balance sheet post payment settlement approval.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the payment date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_001_001TC_013
   Scenario: Verify Balance sheet post Bill is approved.
   Given user navigate to azentio url and login as maker
   When click the account payable main module 
   And click the eye icon of invoice bill booking
   And click the search icon in list view
   And search invoice type as expense
   And click the first eye icon in the list view of Active invoice bill
   And get the invoice number from the bill viewed
   And get buisness partner name and Bill Status
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_003_007TC_02
   Scenario: Verify Balance sheet post Credit Note is cancelled
   Given user login as Azentio Maker
   When click the Account Receivable main module
   And click the eye icon in credit note
   And click the search icon in credit note page
   And search credit note status as cancelled
   And click the first eye icon in the Cancelled Credit List
   And get buisness partner name , get credit note number and get credit note date
   And click the notes option in top
   And click the financial reporting
   And click the balance sheet report
   And select the branch
   And select the date
   And click the view icon
   Then Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.
   @KUBS_AR/AP_UAT_005_002TC_05
    Scenario: Verify Accounts Payable Report post cancelling payment settlement txn
    Given user login as Azentio Maker
   When click the Account payable Mainmodule
   And click the eye icon of the payment settlement
   And user click search icon
   And user search active in payment settlement list view
   And click first eye icon in list view 
   And get the transaction number from payment settlement
   And get buisness partner name and payment settlement date
   And click the Notes Option In Top
   And click the Reports Sub Module
   And click the Accounts Payable Report
   And select the vendor name 
   And select the payable status according to payment settlement
   And select the date
   And click the view icon
   Then verify the invoice number get from payment settlement available in Account payable Report
  
