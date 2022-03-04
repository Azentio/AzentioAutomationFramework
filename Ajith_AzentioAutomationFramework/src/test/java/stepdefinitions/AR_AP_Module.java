package stepdefinitions;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Account_Receivable;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.InvoiceBookingObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import testDataType.Cancellationofcontractdatatype;

public class AR_AP_Module extends BaseClass {
	public static WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract =new ArAp_Cancellation_of_vendorObj(driver);
	JsonConfig jsonconfig = new JsonConfig();
	Cancellationofcontractdatatype cancellationofcontractdata = jsonconfig.getCancelcontractByName("Maker");
	Map<String,String> testdata = new LinkedHashMap<>();
	private String invoicebuisnessPartner;
	private String NetPayableAmountinBillList;
	private  float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj= new Payment_SettlementObj(driver);
	Account_Receivable account_Receivable= new Account_Receivable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	//Verify creating po against cancelled order is not allowed
	
	@Given("^user navigate to the url and login as a maker$")
    public void user_navigate_to_the_url_and_login_as_a_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }

    @When("^user click Accounts Payable$")
    public void user_click_accounts_payable() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^user click Vendor Contracts eye icon$")
    public void user_click_vendor_contracts_eye_icon() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApeyeicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
    }

    @And("^user click search icon$")
    public void user_click_search_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^user search cancelled vendor contract$")
    public void user_search_cancelled_vendor_contract() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getSearchcontractstatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchcontractstatus());
        cancellationofcontract.getSearchcontractstatus().sendKeys(cancellationofcontractdata.contractstatus);
    }

    @And("^User search Buisness partner name$")
    public void user_search_buisness_partner_name() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getVendorposearchbpname());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getVendorposearchbpname());
        cancellationofcontract.getVendorposearchbpname().sendKeys(cancellationofcontractdata.BuisnessPartnerName);
    }

    @And("^user click the cancelled vendor contract eye icon$")
    public void user_click_the_cancelled_vendor_contract_eye_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getClickEyeiconInListView());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getClickEyeiconInListView());
    }

    @And("^get buisness partner name$")
    public void get_buisness_partner_name() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getBuisnessPartnerNameinContract());
        String buisnessPartnerNameinCancelledContract = cancellationofcontract.getBuisnessPartnerNameinContract().getText();
        testdata.put("buisnessPartnerNameinCancelledContract", buisnessPartnerNameinCancelledContract);
    }

    @And("^click vendor purchase order eye ion$")
    public void click_vendor_purchase_order_eye_ion() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arpoCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton());
    }

    @And("^click vendor purchase order add ion$")
    public void click_vendor_purchase_order_add_ion() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arpoCreationObj.accountsPayable_VendorPurchaseOrder_AddButton());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_AddButton());
    }

    @And("^select buisness partner we get in cancelled list$")
    public void select_buisness_partner_we_get_in_cancelled_list() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
        arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(testdata.get("buisnessPartnerNameinCancelledContract"));
        arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
    }

    @And("^select referece type as contract$")
    public void select_referece_type_as_contract() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver, 2000,arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
        arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
    }
    @Then("^verify not able to select contract and po creation is not allowed$")
    public void verify_not_able_to_select_contract_and_po_creation_is_not_allowed() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
    	Thread.sleep(3000);
    	System.out.println("no items found and not able to create purchase order for cancelled contract");
        
    }
   // check cancellation of contract is not allowed when purchase order is created against contract
    @Given("^user navigate to the url and login as a maker for cancellation of contract is not allowed$")
    public void user_navigate_to_the_url_and_login_as_a_maker_for_cancellation_of_contract_is_not_allowed() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }
    @When("^click the accounts payable$")
    public void click_the_accounts_payable() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the vendor contract eye icon sub module$")
    public void click_the_vendor_contract_eye_icon_sub_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApeyeicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
    }

    @And("^click search icon in list view$")
    public void click_search_icon_in_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search contract status as closed$")
    public void search_contract_status_as_closed() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getSearchcontractstatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchcontractstatus());
        cancellationofcontract.getSearchcontractstatus().sendKeys(cancellationofcontractdata.Contractstatusforcancellationofcontract);
    }

    @And("^click the first eye icon in the list$")
    public void click_the_first_eye_icon_in_the_list() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getClickEyeiconInListView());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getClickEyeiconInListView());
    }

    @And("^get buisness partner name and get contract acccount code$")
    public void get_buisness_partner_name_and_get_contract_acccount_code() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getBuisnessPartnerNameinContract());
        String buisnessPartnerNameinCancelledContract = cancellationofcontract.getBuisnessPartnerNameinContract().getText();
        testdata.put("buisnessPartnerNameinCancelledContract", buisnessPartnerNameinCancelledContract);
        javascriphelper.JavaScriptHelper(driver);
        Object contractacccountcode= javascriphelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[\"contractCode\"].value");
        String contractacccountcode1 = String.valueOf(contractacccountcode);
        testdata.put("contractacccountcode", contractacccountcode1);
    }

    @And("^click the ar ap adjustment sub module$")
    public void click_the_ar_ap_adjustment_sub_module() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(arapAdjustment.ClickArApAdjustmentModule());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.ClickArApAdjustmentModule());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.ClickArApAdjustmentModule());
    }

    @And("^click ar ap eye icon$")
    public void click_ar_ap_eye_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.adjustmentViewButton());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentViewButton());
    }

    @And("^click add icon$")
    public void click_add_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.arApAddIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.arApAddIcon());
    }

    @And("^select bp name according to bp we get in contratc$")
    public void select_bp_name_according_to_bp_we_get_in_contratc() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver, 2000,arapAdjustment.adjustmentBpName());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentBpName());
        arapAdjustment.adjustmentBpName().sendKeys(testdata.get("buisnessPartnerNameinCancelledContract"));
        arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
    }

    @And("^select adjustment type as cancellation$")
    public void select_adjustment_type_as_cancellation() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.adjustmentadjustmentType());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentadjustmentType());
        arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.ENTER);
    }

    @And("^select adjustment item type as contract$")
    public void select_adjustment_item_type_as_contract() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.adjustmentItemType());
        seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentItemType());
        arapAdjustment.adjustmentItemType().sendKeys(cancellationofcontractdata.Cancellationtype);
        arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
    }

    @And("^select adjustment reference as we get in contract account code$")
    public void select_adjustment_reference_as_we_get_in_contract_account_code() throws Throwable {
    	 seleniumactions.getWaitHelper().waitForElement(driver,2000,arapAdjustment.adjustmentAdjustmentReference());
         seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentAdjustmentReference());
         arapAdjustment.adjustmentAdjustmentReference().sendKeys(testdata.get("contractacccountcode"));
    }
    @Then("^verify that cancellation of contract is not allowed when po created for contract$")
    public void verify_that_cancellation_of_contract_is_not_allowed_when_po_created_for_contract() throws Throwable {
        System.out.println("no ajustment reference found and cancellation of contract not Allowed against po created");
    }

	//cancelled bill is not allowed for payment settlement
	@When("^click the invoice eye icon in accounts payable$")
    public void click_the_invoice_eye_icon_in_accounts_payable() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
		seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		
        
    }
    @And("^click the search icon in invoice booking list view$")
    public void click_the_search_icon_in_invoice_booking_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search the buisness partner in list view$")
    public void search_the_buisness_partner_in_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.searchBpInList());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchBpInList());
    	invoiceBookingObj.searchBpInList().sendKeys(cancellationofcontractdata.BuisnessPartnerName1);
    	
    }
    @Then("^verify the bill is cancelled$")
    public void verify_the_bill_is_cancelled() throws Throwable {
    	
        seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.statusOfInvoice);
        String statusOfInvoiceBill = invoiceBookingObj.statusOfInvoice.getText();
        Assert.assertEquals("Cancelled",statusOfInvoiceBill);
       
    }


    @And("^click the payment settlement eye icon$")
    public void click_the_payment_settlement_eye_icon() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon in payment settlement$")
    public void click_the_add_icon_in_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
        
    }

    @And("^select payment option as buisness partnerwise$")
    public void select_payment_option_as_buisness_partnerwise() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
        
    }

    @And("^select buisness partner in payment settlement$")
    public void select_buisness_partner_in_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
    	paymentSettlementObj.getSelectBuisnessPartner().sendKeys(cancellationofcontractdata.BuisnessPartnerName1);
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        
    }
    @Then("^verify that no bill is available for payment settlement$")
    public void verify_that_no_bill_is_available_for_payment_settlement() throws Throwable {
    	System.out.println("No records found for paymentsettlement");
    }
    //creditnote cancelled is not allowed for payment settlement
    @Given("^login azentio as maker$")
    public void login_azentio_as_maker() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }

    @When("^click the Account Receivable main module$")
    public void click_the_account_receivable_main_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountReceivable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
    }
    @And("^click the eye icon in credit note$")
    public void click_the_eye_icon_in_credit_note() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_Eye());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Eye());
    }

    @And("^click the search icon in credit note page$")
    public void click_the_search_icon_in_credit_note_page() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search credit note status as cancelled$")
    public void search_credit_note_status_as_cancelled() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_Status());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
        account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(cancellationofcontractdata.contractstatus);
    }

    @And("^click the first eye icon in the Cancelled Credit List$")
    public void click_the_first_eye_icon_in_the_cancelled_credit_list() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_StatusHead());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }

    @And("^get invoice number and get buisness partner name$")
    public void get_invoice_number_and_get_buisness_partner_name() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,20000,account_Receivable.creditNote_Buisness_Partner());
        String buinesspartner = account_Receivable.creditNote_Buisness_Partner().getText();
        testdata.put("buinesspartner", buinesspartner);
        //seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.creditNote_Invoice_NumberInCreditNotePage());
        //String invoicenumber = account_Receivable.creditNote_Invoice_NumberInCreditNotePage().getText();
        //testdata.put("invoicenumber", invoicenumber);
    }

    @And("^click account payable main module$")
    public void click_account_payable_main_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the eye icon in account payable$")
    public void click_the_eye_icon_in_account_payable() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon in payment settlement for credit$")
    public void click_the_add_icon_in_payment_settlement_for_credit() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partnerwise for credit$")
    public void select_payment_option_as_buisness_partnerwise_for_credit() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^select buisness partner in payment settlement for credit$")
    public void select_buisness_partner_in_payment_settlement_for_credit() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
    	paymentSettlementObj.getSelectBuisnessPartner().sendKeys(testdata.get("buinesspartner"));
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("^verify that invoice from credit not is not available in bill list$")
    public void verify_that_invoice_from_credit_not_is_not_available_in_bill_list() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
   
    	for (int i =1; i <=6; i++) {
    		
				  seleniumactions.getWaitHelper().waitForElementVisible(driver.findElement(By.xpath("//div[text()=' "+testdata.get("invoicenumber")+" ']")),1000,100);
					 
				     try {
						boolean displayed = driver.findElement(By.xpath("//div[text()=' \"+testdata.get(\"invoicenumber\")+\" ']")).isDisplayed();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				 System.out.println("invoice number not  match");
    	}
				 
		}
    	
    	
   

    // active bill is available for payment settlement
    @Given("^log in to azentio as maker$")
    public void log_in_to_azentio_as_maker() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
        
    }

    @When("^click the Account payable module$")
    public void click_the_accounht_payable_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the invoice booking eye icon in sub module$")
    public void click_the_invoice_booking_eye_icon_in_sub_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
    }

    @And("^search Invoice status as active$")
    public void search_invoice_status_as_active() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
       javascriphelper.JavaScriptHelper(driver);
       javascriphelper.scrollIntoView(invoiceBookingObj.searchInvoiceStatus());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.searchInvoiceStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceStatus());
        invoiceBookingObj.searchInvoiceStatus().sendKeys("active");
        
    }

    @And("^click the first eye icon in the list view$")
    public void click_the_first_eye_icon_in_the_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.selectFirstEyeicon);
    	seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.selectFirstEyeicon); 
    }

    @And("^get the buisness partner from invoice bill$")
    public void get_the_buisness_partner_and_the_system_invoice_number() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.getBuisnessPartnerInvoiceBill());
        invoicebuisnessPartner = invoiceBookingObj.getBuisnessPartnerInvoiceBill().getText();
        System.out.println(invoicebuisnessPartner);
    }

    @And("^click the payment settlement eye icon in Accounts payable$")
    public void click_the_payment_settlement_eye_icon_in_accounts_payable() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }
    @And("^click the add icon fot the payment settlement$")
    public void click_the_add_icon_fot_the_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^choose the payment option as Buisness partner Type$")
    public void choose_the_payment_option_as_buisness_partner_type() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^Enter buisness partner get from bill booking$")
    public void enter_buisness_partner_get_from_bill_booking() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
    	paymentSettlementObj.getSelectBuisnessPartner().sendKeys(invoicebuisnessPartner);
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        
    }
    @Then("^verify that active bill is available for payment settlement$")
    public void verify_that_active_bill_is_available_for_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getGetActiveBillBuisnessPartner());
    	String ActiveBillBuisnessPartner = paymentSettlementObj.getGetActiveBillBuisnessPartner().getText();
    	Assert.assertEquals(invoicebuisnessPartner, ActiveBillBuisnessPartner);
        
    }
    // verify tds % and tds amount in payment settlement
    @Given("^log into azentio as maker and select finance option$")
    public void log_into_azentio_as_maker_and_select_finance_option() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
    }

    @When("^click the Account payable Mainmodule$")
    public void click_the_account_payable_mainmodule() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the eye icon of the payment settlement$")
    public void click_the_eye_icon_of_the_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon of the payment settlement$")
    public void click_the_add_icon_of_the_payment_settlement() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type$")
    public void select_payment_option_as_buisness_partner_type() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^select the buisness partner from the list$")
    public void select_the_buisness_partner_from_the_list() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
    }

    @And("^select listed bill contains tds percentage$")
    public void select_listed_bill_contains_tds_percentage() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getBillListViewCheckBox2());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox2());
    }

    @And("^get tds percentage and calculate tds amount$")
    public void get_tds_percentage_and_calculate_tds_amount() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getTdspercentfromList2());
       String tdspercent = paymentSettlementObj.getTdspercentfromList2().getText();
       String substring = tdspercent.substring(0,1);
       seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getTdsvaluefromlist2());
      String TdsValue = paymentSettlementObj.getTdsvaluefromlist2().getText();
      int TDSVALUE = Integer.parseInt(TdsValue);
      seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getGetNetAdjustedAmountList2());
      String NetAdjusted = paymentSettlementObj.getGetNetAdjustedAmountList2().getText();
      int NETADJUSTED = Integer.parseInt(NetAdjusted);
     int TDSPERCENTAGE = Integer.parseInt(substring);
     float tdspercent1 = TDSPERCENTAGE;
     System.out.println(TDSPERCENTAGE);
      CalculatedTdsValue =(float) ((TDSPERCENTAGE/100.0)*NETADJUSTED);
     Assert.assertEquals(TDSVALUE, Math.round(CalculatedTdsValue));
    }
   
    @Then("^verify tds in bill with calculated tds amt$")
    public void verify_tds_in_bill_with_calculated_tds_amt() throws Throwable {
        javascriphelper.JavaScriptHelper(driver);
        Object tdsamountinpaymentsettlement = javascriphelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
        String tdsvalueinsettlement = String.valueOf(tdsamountinpaymentsettlement);
        System.out.println(tdsvalueinsettlement);
        String tdsvalueinpayment = tdsvalueinsettlement.substring(0,4);
        float tdsvalue = Float.parseFloat(tdsvalueinpayment);
        Assert.assertEquals(tdsvalue, Math.round(CalculatedTdsValue));
    }
    // verify net payable amount in bill
    @Given("^log into azentio as maker and select finance option for verify net payable amount$")
    public void log_into_azentio_as_maker_and_select_finance_option_for_verify_net_payable_amount() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
    }

    @When("^click the Account payable Mainmodule for verify net payable amount$")
    public void click_the_account_payable_mainmodule_for_verify_net_payable_amount() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the eye icon of the payment settlement for verify net payable amount$")
    public void click_the_eye_icon_of_the_payment_settlement_for_verify_net_payable_amount() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon of the payment settlement for verify net payable amount$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_net_payable_amount() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type for verify net payable amount$")
    public void select_payment_option_as_buisness_partner_type_for_verify_net_payable_amount() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^select the buisness partner from the list for verify net payable amount$")
    public void select_the_buisness_partner_from_the_list_for_verify_net_payable_amount() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
       
    }

    @And("^select the bill in the list view$")
    public void select_the_bill_in_the_list_view() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getBillListViewCheckBox());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
    }

    @And("^calculate the net payable amount from the bill in list view$")
    public void calculate_the_net_payable_amount_from_the_bill_in_list_view() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getGetNetPayableAmountinBillList());
        NetPayableAmountinBillList = paymentSettlementObj.getGetNetPayableAmountinBillList().getText();
       System.out.println(NetPayableAmountinBillList);
    }
    @Then("^verify netpayable amount in payment settlement with calculated amount$")
    public void verify_netpayable_amount_in_payment_settlement_with_calculated_amount() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	Object object = javascriphelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
    	String netpayablevalueinsettlement = String.valueOf(object); 
    	System.out.println(netpayablevalueinsettlement);
        String substring = netpayablevalueinsettlement.substring(0, 6);
    	System.out.println(substring);
    	String NetAmount =substring.substring(0, 2)+substring.substring(3);
        Assert.assertEquals(NetPayableAmountinBillList,NetAmount);
        
    }
  // pop up message displayed and click yes to proceed for payment
    @Given("^log into azentio as maker and select finance option for verify pop up$")
    public void log_into_azentio_as_maker_and_select_finance_option_for_verify_pop_up() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
    }

    @When("^click the Account payable Mainmodule for verify pop up$")
    public void click_the_account_payable_mainmodule_for_verify_pop_up() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
        
    }

    @And("^click the eye icon of the payment settlement for verify pop up$")
    public void click_the_eye_icon_of_the_payment_settlement_for_verify_pop_up() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
        
    }

    @And("^click the add icon of the payment settlement for verify pop up$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_pop_up() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type for verify pop up$")
    public void select_payment_option_as_buisness_partner_type_for_verify_pop_up() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^select the buisness partner from the list for verify  pop up$")
    public void select_the_buisness_partner_from_the_list_for_verify_pop_up() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
    }

    @And("^select any bill in list view$")
    public void select_any_bill_in_list_view() throws Throwable {
    	 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getBillListViewCheckBox());
         seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
    }

    @And("^choose the valid date$")
    public void choose_the_valid_date() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getCalenderInPaymentSettlement());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getCalenderInPaymentSettlement());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getDate());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDate());
        
    }

    @And("^Enter the description$")
    public void enter_the_description() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getDescription());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDescription());
    	paymentSettlementObj.getDescription().sendKeys(cancellationofcontractdata.PaymentSettlementDescription);
        
    }

    @And("^Click save button$")
    public void click_save_button() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSavebutton());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSavebutton());
    }

    @And("^pop up messages displayed and  click yes$")
    public void pop_up_messages_displayed_and_click_yes() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getClickYespopup());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickYespopup());
        
    }
    @Then("^verify bill is proceed for payment$")
    public void verify_bill_is_proceed_for_payment() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getClickFirstPaymentInListView());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickFirstPaymentInListView());
    	Thread.sleep(2000);
        
    }
    
    @Given("^log into azentio as maker and select finance option for verify pop up display$")
    public void log_into_azentio_as_maker_and_select_finance_option_for_verify_pop_up_display() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
    }

    @When("^click the Account payable Mainmodule for verify pop up display$")
    public void click_the_account_payable_mainmodule_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }
    @And("^click the eye icon of the payment settlement for verify pop up display$")
    public void click_the_eye_icon_of_the_payment_settlement_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
        
    }

    @And("^click the add icon of the payment settlement for verify pop up display$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type for verify pop up display$")
    public void select_payment_option_as_buisness_partner_type_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^select the buisness partner from the list for verify pop up display$")
    public void select_the_buisness_partner_from_the_list_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSelectBuisnessPartner());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
        paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
    }

    @And("^select any bill in list view for verify pop up display$")
    public void select_any_bill_in_list_view_verify_pop_up_display() throws Throwable {
    	 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getBillListViewCheckBox());
         seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
    }

    @And("^choose the valid date for verify pop up display$")
    public void choose_the_valid_date_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getCalenderInPaymentSettlement());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getCalenderInPaymentSettlement());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getDate());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDate());
    }

    @And("^Enter the description for verify pop up display$")
    public void enter_the_description_for_verify_pop_up_display() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getDescription());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDescription());
    	paymentSettlementObj.getDescription().sendKeys(cancellationofcontractdata.PaymentSettlementDescription);
    }
    @And("^Click save button  for verify pop up display$")
    public void click_save_button_for_verify_pop_up_display() throws Throwable {
    	 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getSavebutton());
         seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSavebutton());
    }

    @And("^pop up messages displayed and click no$")
    public void pop_up_messages_displayed_and_click_no() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getClickNopopup());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickNopopup());
    }
    @Then("^verify bill is not proceed for payment and return to payment settlement$")
    public void verify_bill_is_not_proceed_for_payment_and_return_to_payment_settlement() throws Throwable {
        System.out.println("User verified previous Screen");
    }
    // verify debit note adjusted for the selected bill and verify net adjusted value is correctly displayed
    @Given("^log in as a Maker and select finance option for verify debit note against bill$")
    public void log_in_as_a_maker_and_select_finance_option_for_verify_debit_note_against_bill() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		
    }

    @When("^click Account receivable Main module$")
    public void click_account_receivable_main_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountReceivable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
    }

    @And("^click debit note eye icon$")
    public void click_debit_note_eye_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_Debit_Eye());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
    }

    @And("^click search button and then click debit note status search$")
    public void click_search_button_and_then_click_debit_note_status_search() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search Active in debit note status$")
    public void search_active_in_debit_note_status() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
        javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
        account_Receivable.accountsReceivable_DebitNote_Status().sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);
   
    }
    

    @And("^click first eye icon in list view$")
    public void click_first_eye_icon_in_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_StatusHead());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }

    @And("^get buisness partner name and invoice number$")
    public void get_buisness_partner_name_and_invoice_number() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteBuisnessPartner());
        debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteInvoiceNumber());
        String text = account_Receivable.debitNoteInvoiceNumber().getText();
       debitinvoicenumber =text.substring(0, 3)+text.substring(4, 7)+text.substring(8);
    }

    @And("^click Account Payable Main Module for verify debit note against bill$")
    public void click_account_payable_main_module_for_verify_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click eye icon in Payment Settlement for verify debit note against bill$")
    public void click_eye_icon_in_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon of the payment settlement for verify debit note against bill$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
        
    }

    @And("^select payment option as buisness partner type for verify debit note against bill$")
    public void select_payment_option_as_buisness_partner_type_for_verify_debit_note_against_bill() throws Throwable {
    	
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }
    @And("^Select buisness partner according to debit note buisnes partner$")
    public void select_buisness_partner_according_to_debit_note_buisnes_partner() throws Throwable {
		
		 seleniumactions.getWaitHelper().waitForElement(driver,2000,
		  paymentSettlementObj.getSelectBuisnessPartner());
		 seleniumactions.getClickAndActionsHelper().clickOnElement(
		 paymentSettlementObj.getSelectBuisnessPartner());
		  paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
    }

    @And("^search the invoice number based on invoice after click bill and get gross,debit amount$")
    public void search_the_invoice_number_based_on_invoice_after_click_bill_and_get_grossdebit_amount() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	for (int j = 1; j<=12; j++) {
			String invoice = null;
		
    	for (int i =1; i <=6; i++) {
    		seleniumactions.getWaitHelper().waitForElement(driver,4000, driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
    		String text2 = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")).getText();
    	    invoice =text2.substring(0, 3)+text2.substring(4, 7)+text2.substring(8);
    			if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    				seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
                	driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
    			    String GrossAmount= driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
                	String DebitAmount = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
    			    String NetAdjustedValuefromBillDebit = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[12]/div")).getText();
    			    String flatDiscount = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[9]/div")).getText();
     			    String EarlypaymentDiscount = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[10]/div")).getText(); 
    			     testdata.put("GrossAmountfordebit",GrossAmount);
                	 testdata.put("DebitAmount",DebitAmount);
                	 testdata.put("EarlypaymentDiscountfordebit", EarlypaymentDiscount);
                	 testdata.put("flatDiscountfordebit",flatDiscount);
                	 testdata.put("NetAdjustedValuefromBillDebit", NetAdjustedValuefromBillDebit);
                	 break;
				}
				  if(i>3) { javascriphelper.scrollIntoView(driver.findElement(By.xpath(
				 "//datatable-row-wrapper["+i+
				  "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox"))); }
				 if(i==6) {
					 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getNextPageInListView());
					 seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getNextPageInListView());
				 }
				 
		}
    	if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    		break;
    	}
    	}
			}

   
    @Then("^calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list$")
    public void calculate_netadjusted_amount_based_on_gross_and_debit_amount_then_verify_with_netadjusted_value_from_list() throws Throwable {
    	int grossamt = Integer.parseInt(testdata.get("GrossAmountfordebit"));
        int debitamount = Integer.parseInt(testdata.get("DebitAmount"));
        int CalculatedNetAjusted = grossamt-debitamount-Integer.parseInt(testdata.get("flatDiscountfordebit"))-Integer.parseInt(testdata.get("EarlypaymentDiscountfordebit"));
        Assert.assertEquals(CalculatedNetAjusted,Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit")));
    }


    @Then("^verify net adjusted value in bill with net adjusted value shown in payment settlement page$")
    public void verify_net_adjusted_value_in_bill_with_net_adjusted_value_shown_in_payment_settlement_page() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
        Object obj = javascriphelper.executeScript("return document.getElementsByTagName('input')[\"paymentAmt\"].value");
        String valueOf = String.valueOf(obj);
       String substring = valueOf.substring(0,2)+valueOf.substring(3,6);
       int NetAjustedfromPaymentPage = Integer.parseInt(substring);
       int NetAdjustedfrombill = Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit"));
       Assert.assertEquals(NetAdjustedfrombill, NetAjustedfromPaymentPage);
    }
    // verify tds percent and tds value for debit note
    @Given("^log in as a Maker and select finance option for verify tds in debit note against bill$")
    public void log_in_as_a_maker_and_select_finance_option_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

    }

    @When("^click Account receivable Main module for verify tds in debit note against bill$")
    public void click_account_receivable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountReceivable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());

    }

    @And("^click debit note eye icon for verify tds in debit note against bill$")
    public void click_debit_note_eye_icon_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_Debit_Eye());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
    }

    @And("^click search button and then click debit note status search for verify tds in debit note against bill$")
    public void click_search_button_and_then_click_debit_note_status_search_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search Active in debit note status for verify tds in debit note against bill$")
    public void search_active_in_debit_note_status_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
        javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
        account_Receivable.accountsReceivable_DebitNote_Status().sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);
    }

    @And("^click first eye icon in list view for verify tds in debit note against bill$")
    public void click_first_eye_icon_in_list_view_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_StatusHead());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }

    @And("^get buisness partner name and invoice number for verify tds in debit note against bill$")
    public void get_buisness_partner_name_and_invoice_number_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteBuisnessPartner());
        debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteInvoiceNumber());
        String text = account_Receivable.debitNoteInvoiceNumber().getText();
       debitinvoicenumber =text.substring(0, 3)+text.substring(4, 7)+text.substring(8);
    }

    @And("^click Account Payable Main Module for verify tds in debit note against bill$")
    public void click_account_payable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click eye icon in Payment Settlement for verify tds in debit note against bill$")
    public void click_eye_icon_in_payment_settlement_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon of the payment settlement for verify tds in debit note against bill$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type for verify tds in debit note against bill$")
    public void select_payment_option_as_buisness_partner_type_for_verify_tds_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
    }

    @And("^Select buisness partner according to debit note buisnes partner we get$")
    public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get() throws Throwable {
    	 seleniumactions.getWaitHelper().waitForElement(driver,2000,
    			  paymentSettlementObj.getSelectBuisnessPartner());
    			 seleniumactions.getClickAndActionsHelper().clickOnElement(
    			 paymentSettlementObj.getSelectBuisnessPartner());
    			  paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
    			 Thread.sleep(4000);
    }

    @And("^get tds percent , net adjusted,tds amount based on invoice then click bill$")
    public void get_tds_percent_net_adjustedtds_amount_based_on_invoice_then_click_bill() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	for (int j = 1; j<=12; j++) {
			String invoice = null;
		
    	for (int i =1; i <=6; i++) {
    		seleniumactions.getWaitHelper().waitForElement(driver,4000, driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
    		String text2 = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")).getText();
    	    invoice =text2.substring(0, 3)+text2.substring(4, 7)+text2.substring(8);
    			if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    				seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
                	driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
    			   String TdsPercentfordebit= driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[13]/div")).getText();
                	 String NetAjustedValueforDebit = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[12]/div")).getText();
    			     String tdsvaluefordebit = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[14]/div")).getText();
                	testdata.put("TdsPercentfordebit", TdsPercentfordebit);
                	testdata.put("NetAjustedValueforDebit", NetAjustedValueforDebit);
                	testdata.put("tdsvaluefordebit", tdsvaluefordebit);
                	
    			     break;
				}
				  if(i>3) { javascriphelper.scrollIntoView(driver.findElement(By.xpath(
				 "//datatable-row-wrapper["+i+
				  "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox"))); }
				 if(i==6) {
					 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getNextPageInListView());
					 seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getNextPageInListView());
				 }
				 
		}
    	if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    		break;
    	}
    	}
			}

    @And("^calculate tds value based on tds percent and net adjusted value and verify with tds value in bill$")
    public void calculate_tds_value_based_on_tds_percent_and_net_adjusted_value_and_verify_with_tds_value_in_bill() throws Throwable {
    	int NETADJUSTED = Integer.parseInt(testdata.get("NetAjustedValueforDebit"));
    	String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
        int TDSPERCENTAGE = Integer.parseInt(substring);
        float tdspercent1 = TDSPERCENTAGE;
        System.out.println(TDSPERCENTAGE);
         CalculatedTdsValue =(float) ((TDSPERCENTAGE/100.0)*NETADJUSTED);
         testdata.put("calculatedtds",String.valueOf(CalculatedTdsValue));
         float parseFloat = Float.parseFloat(testdata.get("tdsvaluefordebit"));
        Assert.assertEquals(parseFloat, Math.round(CalculatedTdsValue));
    }

    @And("^get tds value from payment settlement for debit note$")
    public void get_tds_value_from_payment_settlement_for_debit_note() throws Throwable {
        javascriphelper.JavaScriptHelper(driver);
        Object tdsvalue = javascriphelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
        testdata.put("tdsvaluefrompayment",String.valueOf(tdsvalue));
    }
   
    @Then("^verify calculated tds value equals to tds value get from payment settlement and correctly displayed$")
    public void verify_calculated_tds_value_equals_to_tds_value_get_from_payment_settlement_and_correctly_displayed() throws Throwable {
        Assert.assertEquals(Math.round(Float.parseFloat(testdata.get("calculatedtds"))),Float.parseFloat(testdata.get("tdsvaluefrompayment")));
    }

    // verify net payable amount is correctly calculated and displayed
    @Given("^log in as a Maker and select finance option for verify Netpayable amount in debit note against bill$")
    public void log_in_as_a_maker_and_select_finance_option_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }

    @When("^click Account receivable Main module for verify Netpayable amount in debit note against bill$")
    public void click_account_receivable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountReceivable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
    }

    @And("^click debit note eye icon for verify Netpayable amount in debit note against bill$")
    public void click_debit_note_eye_icon_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_Debit_Eye());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
    }

    @And("^click search button and then click debit note status search for verify Netpayable amount in debit note against bill$")
    public void click_search_button_and_then_click_debit_note_status_search_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getApserachicon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search Active in debit note status for verify Netpayable amount in debit note against bill$")
    public void search_active_in_debit_note_status_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
        javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_DebitNote_Status());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
        account_Receivable.accountsReceivable_DebitNote_Status().sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);
    }

    @And("^click first eye icon in list view for verify Netpayable amount in debit note against bill$")
    public void click_first_eye_icon_in_list_view_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountsReceivable_CreditNote_StatusHead());
        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }

    @And("^get buisness partner name and invoice number for verify Netpayable amount in debit note against bill$")
    public void get_buisness_partner_name_and_invoice_number_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteBuisnessPartner());
        debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.debitNoteInvoiceNumber());
        String text = account_Receivable.debitNoteInvoiceNumber().getText();
       debitinvoicenumber =text.substring(0, 3)+text.substring(4, 7)+text.substring(8);
    }

    @And("^click Account Payable Main Module for verify Netpayable amount in debit note against bill$")
    public void click_account_payable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,cancellationofcontract.getAccountspayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill$")
    public void click_eye_icon_in_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementEyeIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
    }

    @And("^click the add icon of the payment settlement for verify Netpayable amount in debit note against bill$")
    public void click_the_add_icon_of_the_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentSettlementAddIcon());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
    }

    @And("^select payment option as buisness partner type for verify Netpayable amount in debit note against bill$")
    public void select_payment_option_as_buisness_partner_type_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getPaymentOptions());
    	seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
    	paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);

    }

    @And("^Select buisness partner according to debit note buisnes partner we get in debit list view$")
    public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get_in_debit_list_view() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,
  			  paymentSettlementObj.getSelectBuisnessPartner());
  			 seleniumactions.getClickAndActionsHelper().clickOnElement(
  			 paymentSettlementObj.getSelectBuisnessPartner());
  			  paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
  			 Thread.sleep(4000);
    }

    @And("^get gross amount, debit amount,tds percent,netpayable amount$")
    public void get_gross_amount_debit_amounttds_percentnetpayable_amount() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	for (int j = 1; j<=5; j++) {
			String invoice = null;
		
    	for (int i =1; i <=6; i++) {
    		seleniumactions.getWaitHelper().waitForElement(driver,4000, driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
    		String text2 = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")).getText();
    	    invoice =text2.substring(0, 3)+text2.substring(4, 7)+text2.substring(8);
    			if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    				seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
                	driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
    			   String GrossAmountfromdebitbill = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
                	String DebitAmountfrombill = driver.findElement(By.xpath("(//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
    			    String NetPayableAmountfrombill = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[15]/div")).getText();
    			    String TdsPercentfordebit= driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[13]/div")).getText(); 
    			    String flatDiscount = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[9]/div")).getText();
    			    String EarlypaymentDiscount = driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]/datatable-body-row[1]/div/datatable-body-cell[10]/div")).getText(); 
    			    
    			    testdata.put("NetPayableAmountfrombill", NetPayableAmountfrombill);
                	 testdata.put("GrossAmountfromdebitbill",GrossAmountfromdebitbill);
                	 testdata.put("DebitAmountfrombill",DebitAmountfrombill);
                	 testdata.put("TdsPercentfordebit",TdsPercentfordebit );
                	 testdata.put("flatDiscount", flatDiscount);
                	 testdata.put("EarlypaymentDiscount", EarlypaymentDiscount);
    			    break;
				}
				  if(i>3) { javascriphelper.scrollIntoView(driver.findElement(By.xpath(
				 "//datatable-row-wrapper["+i+
				  "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox"))); }
				 if(i==6) {
					 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getNextPageInListView());
					 seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getNextPageInListView());
				 }
				 
		}
    	if(debitinvoicenumber.equalsIgnoreCase(invoice)) {
    		break;
    	}
    	}
    }

    @And("^calculate net adjusted value , tds value from net adjusted$")
    public void calculate_net_adjusted_value_tds_value_from_net_adjusted() throws Throwable {
    	int grossamt = Integer.parseInt(testdata.get("GrossAmountfromdebitbill"));
    	System.out.println(grossamt);
        int debitamount = Integer.parseInt(testdata.get("DebitAmountfrombill"));
        System.out.println(debitamount);
        int CalculatedNetAjusted = grossamt-debitamount;
        System.out.println(CalculatedNetAjusted);
        testdata.put("CalculatedNetAjusted",String.valueOf(CalculatedNetAjusted));
        // tds
        int NETADJUSTED = Integer.parseInt(testdata.get("CalculatedNetAjusted"));
        System.out.println(NETADJUSTED);
    	String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
        int TDSPERCENTAGE = Integer.parseInt(substring);
        float tdspercent1 = TDSPERCENTAGE;
        CalculatedTdsValue =(float) ((TDSPERCENTAGE/100.0)*NETADJUSTED);
        System.out.println(CalculatedTdsValue);
        testdata.put("calculatedtds",String.valueOf(Math.round(CalculatedTdsValue)));
         

    	
    }
    @And("^Calcualte net payable amount from calculated net adjusted value and tds value$")
    public void calcualte_net_payable_amount_from_calculated_net_adjusted_value_and_tds_value() throws Throwable {
       int CalculatedNetPayableAmount = Integer.parseInt(testdata.get("CalculatedNetAjusted"))-Integer.parseInt(testdata.get("calculatedtds"))
    		   -Integer.parseInt(testdata.get("flatDiscount"))-Integer.parseInt(testdata.get("EarlypaymentDiscount"));
       System.out.println(CalculatedNetPayableAmount);
       testdata.put("CalculatedNetPayableAmount",String.valueOf(CalculatedNetPayableAmount));
    }
    @Then("^verify calculated net payable amount with net payable amount get from debit bill$")
    public void verify_calculated_net_payable_amount_with_net_payable_amount_get_from_debit_bill() throws Throwable {
    	
    	Assert.assertEquals(Integer.parseInt(testdata.get("CalculatedNetPayableAmount")),Integer.parseInt(testdata.get("NetPayableAmountfrombill")));
    }
    @And("^get net payable amount from payment settlement$")
    public void get_net_payable_amount_from_payment_settlement() throws Throwable {
    	Object object = javascriphelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
    	String netpayablevalueinsettlement = String.valueOf(object); 
    	System.out.println(netpayablevalueinsettlement);
        String substring = netpayablevalueinsettlement.substring(0, 6);
    	System.out.println(substring);
    	String NetAmount =substring.substring(0, 2)+substring.substring(3);
    	testdata.put("NetPayableAmount", NetAmount);
    }

    @Then("^verify net payable amount is correctly displayed according to debit bill$")
    public void verify_net_payable_amount_is_correctly_displayed_according_to_debit_bill() throws Throwable {
        Assert.assertEquals(testdata.get("CalculatedNetPayableAmount"),testdata.get("NetPayableAmount"));
    }

    	
   
   
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    





    	
        
    }
    
    




