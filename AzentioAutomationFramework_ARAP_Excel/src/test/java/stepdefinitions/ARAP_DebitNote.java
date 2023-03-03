package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.Account_Receivable;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.InvoiceBookingObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;

public class ARAP_DebitNote extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	KUBS_Login login;
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

	Map<String, String> testdata = new LinkedHashMap<>();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper  browserHelper =  new BrowserHelper(driver);

	
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_DebitNote", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^user update the data set ID for debit note$")
    public void user_update_the_data_set_id_for_debit_note() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_004_004_TC_01_D1"); 
    }
	
	
	@When("^click Account receivable Main module$")
	public void click_account_receivable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click debit note eye icon$")
	public void click_debit_note_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search$")
	public void click_search_button_and_then_click_debit_note_status_search() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status$")
	public void search_active_in_debit_note_status() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(testData.get("Contractstatusfordebitnote"));

	}

	@And("^click first eye icon in list view$")
	public void click_first_eye_icon_in_list_view() throws Throwable {
		for(int i=1; i<=10; i++) {
			try {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
		break;}
			catch(Exception e) {}
		}
	}

	@And("^get buisness partner name and invoice number$")
	public void get_buisness_partner_name_and_invoice_number() throws Throwable {
		for(int i=1; i<=10; i++) {
			try {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		System.out.println(debitbuisnesspartnername);
		
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
		System.out.println(debitinvoicenumber);
		break;}
			catch(Exception e) {}
		}
	}

	@And("^click Account Payable Main Module for verify debit note against bill$")
	public void click_account_payable_main_module_for_verify_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
//		for(int i=1; i<=10; i++) {
//			try {	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
//					paymentSettlementObj.getPaymentSettlementEyeIcon());
//			seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
//	break;}
//			catch(Exception e) {}
//		}
		for(int i=1; i<=10; i++) {
			try {
		clicksAndActionHelper.moveToElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
		waithelper.waitForElementToVisibleWithFluentWait(driver, paymentSettlementObj.getPaymentSettlementEyeIcon(), 10, 2);
		paymentSettlementObj.getPaymentSettlementEyeIcon().click();
		break;}
			catch(Exception e) {}
		}
	}
		
		

	@And("^click the add icon of the payment settlement for verify debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());

	}

	@And("^select payment option as buisness partner type for verify debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_debit_note_against_bill() throws Throwable {

		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^Select buisness partner according to debit note buisnes partner$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner() throws Throwable {

		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(debitbuisnesspartnername);
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^search the invoice number based on invoice after click bill and get gross,debit amount$")
	public void search_the_invoice_number_based_on_invoice_after_click_bill_and_get_grossdebit_amount()
			throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 12; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				javascriphelper.scrollIntoView(driver.findElement(By.xpath("(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
			//	seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
			//			"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				System.out.println(invoice);
				if (debitinvoicenumber.trim().equalsIgnoreCase(invoice.trim())) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String GrossAmount = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
					String DebitAmount = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
					String NetAdjustedValuefromBillDebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[12]/div"))
							.getText();
					String flatDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[9]/div"))
							.getText();
					String EarlypaymentDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[10]/div"))
							.getText();
					testdata.put("GrossAmountfordebit", GrossAmount);
					testdata.put("DebitAmount", DebitAmount);
					testdata.put("EarlypaymentDiscountfordebit", EarlypaymentDiscount);
					testdata.put("flatDiscountfordebit", flatDiscount);
					testdata.put("NetAdjustedValuefromBillDebit", NetAdjustedValuefromBillDebit);
					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
				break;
			}
		}
	}

	@Then("^calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list$")
	public void calculate_netadjusted_amount_based_on_gross_and_debit_amount_then_verify_with_netadjusted_value_from_list()
			throws Throwable {
		int grossamt = Integer.parseInt(testdata.get("GrossAmountfordebit"));
		int debitamount = Integer.parseInt(testdata.get("DebitAmount"));
		int CalculatedNetAjusted = grossamt - debitamount - Integer.parseInt(testdata.get("flatDiscountfordebit"))
				- Integer.parseInt(testdata.get("EarlypaymentDiscountfordebit"));
		Assert.assertEquals(CalculatedNetAjusted, Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit")));
	}

	@Then("^verify net adjusted value in bill with net adjusted value shown in payment settlement page$")
	public void verify_net_adjusted_value_in_bill_with_net_adjusted_value_shown_in_payment_settlement_page()
			throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object obj = javascriphelper
				.executeScript("return document.getElementsByTagName('input')[\"paymentAmt\"].value");
		String valueOf = String.valueOf(obj);
		String substring = valueOf.substring(0, 2) + valueOf.substring(3, 6);
		int NetAjustedfromPaymentPage = Integer.parseInt(substring);
		int NetAdjustedfrombill = Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit"));
		Assert.assertEquals(NetAdjustedfrombill, NetAjustedfromPaymentPage);
	}
	//--------------------4_4------//
	
	@When("^click Account receivable Main module for verify tds in debit note against bill$")
	public void click_account_receivable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());

	}

	@And("^click debit note eye icon for verify tds in debit note against bill$")
	public void click_debit_note_eye_icon_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search for verify tds in debit note against bill$")
	public void click_search_button_and_then_click_debit_note_status_search_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status for verify tds in debit note against bill$")
	public void search_active_in_debit_note_status_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(testData.get("Contractstatusfordebitnote"));
	}

	@And("^click first eye icon in list view for verify tds in debit note against bill$")
	public void click_first_eye_icon_in_list_view_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get buisness partner name and invoice number for verify tds in debit note against bill$")
	public void get_buisness_partner_name_and_invoice_number_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
	}

	@And("^click Account Payable Main Module for verify tds in debit note against bill$")
	public void click_account_payable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify tds in debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify tds in debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify tds in debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^Select buisness partner according to debit note buisnes partner we get$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^get tds percent , net adjusted,tds amount based on invoice then click bill$")
	public void get_tds_percent_net_adjustedtds_amount_based_on_invoice_then_click_bill() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 12; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String TdsPercentfordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[13]/div"))
							.getText();
					String NetAjustedValueforDebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[12]/div"))
							.getText();
					String tdsvaluefordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[14]/div"))
							.getText();
					testdata.put("TdsPercentfordebit", TdsPercentfordebit);
					testdata.put("NetAjustedValueforDebit", NetAjustedValueforDebit);
					testdata.put("tdsvaluefordebit", tdsvaluefordebit);

					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					javascriphelper.scrollIntoView(paymentSettlementObj.getNextPageInListView());
					//seleniumactions.getWaitHelper().waitForElement(driver, 2000,
						//	paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
				break;
			}
		}
	}

	@And("^calculate tds value based on tds percent and net adjusted value and verify with tds value in bill$")
	public void calculate_tds_value_based_on_tds_percent_and_net_adjusted_value_and_verify_with_tds_value_in_bill()
			throws Throwable {
		int NETADJUSTED = Integer.parseInt(testdata.get("NetAjustedValueforDebit"));
		String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
		int TDSPERCENTAGE = Integer.parseInt(substring);
		float tdspercent1 = TDSPERCENTAGE;
		System.out.println(TDSPERCENTAGE);
		CalculatedTdsValue = (float) ((TDSPERCENTAGE / 100.0) * NETADJUSTED);
		testdata.put("calculatedtds", String.valueOf(CalculatedTdsValue));
		float parseFloat = Float.parseFloat(testdata.get("tdsvaluefordebit"));
		Assert.assertEquals(parseFloat, Math.round(CalculatedTdsValue));
	}

	@And("^get tds value from payment settlement for debit note$")
	public void get_tds_value_from_payment_settlement_for_debit_note() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object tdsvalue = javascriphelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		testdata.put("tdsvaluefrompayment", String.valueOf(tdsvalue));
	}

	@Then("^verify calculated tds value equals to tds value get from payment settlement and correctly displayed$")
	public void verify_calculated_tds_value_equals_to_tds_value_get_from_payment_settlement_and_correctly_displayed()
			throws Throwable {
		Assert.assertEquals(Math.round(Float.parseFloat(testdata.get("calculatedtds"))),
				Float.parseFloat(testdata.get("tdsvaluefrompayment")));
	}
	
	@When("^click Account receivable Main module for verify Netpayable amount in debit note against bill$")
	public void click_account_receivable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click debit note eye icon for verify Netpayable amount in debit note against bill$")
	public void click_debit_note_eye_icon_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search for verify Netpayable amount in debit note against bill$")
	public void click_search_button_and_then_click_debit_note_status_search_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status for verify Netpayable amount in debit note against bill$")
	public void search_active_in_debit_note_status_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		for(int i=1; i<=10; i++) {
			try {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(testData.get("Contractstatusfordebitnote"));
		break;}
	catch(Exception e) {}
}
	}

	@And("^click first eye icon in list view for verify Netpayable amount in debit note against bill$")
	public void click_first_eye_icon_in_list_view_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get buisness partner name and invoice number for verify Netpayable amount in debit note against bill$")
	public void get_buisness_partner_name_and_invoice_number_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		System.out.println(text);
 	debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
	}

	@And("^click Account Payable Main Module for verify Netpayable amount in debit note against bill$")
	public void click_account_payable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify Netpayable amount in debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify Netpayable amount in debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);

	}

	@And("^Select buisness partner according to debit note buisnes partner we get in debit list view$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get_in_debit_list_view()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^get gross amount, debit amount,tds percent,netpayable amount$")
	public void get_gross_amount_debit_amounttds_percentnetpayable_amount() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 5; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String GrossAmountfromdebitbill = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
					String DebitAmountfrombill = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
					String NetPayableAmountfrombill = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[15]/div"))
							.getText();
					String TdsPercentfordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[13]/div"))
							.getText();
					String flatDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[9]/div"))
							.getText();
					String EarlypaymentDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[10]/div"))
							.getText();

					testdata.put("NetPayableAmountfrombill", NetPayableAmountfrombill);
					testdata.put("GrossAmountfromdebitbill", GrossAmountfromdebitbill);
					testdata.put("DebitAmountfrombill", DebitAmountfrombill);
					testdata.put("TdsPercentfordebit", TdsPercentfordebit);
					testdata.put("flatDiscount", flatDiscount);
					testdata.put("EarlypaymentDiscount", EarlypaymentDiscount);
					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					javascriphelper.scrollIntoView(paymentSettlementObj.getNextPageInListView());
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
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
		int CalculatedNetAjusted = grossamt - debitamount;
		System.out.println(CalculatedNetAjusted);
		testdata.put("CalculatedNetAjusted", String.valueOf(CalculatedNetAjusted));
		// tds
		int NETADJUSTED = Integer.parseInt(testdata.get("CalculatedNetAjusted"));
		System.out.println(NETADJUSTED);
		String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
		int TDSPERCENTAGE = Integer.parseInt(substring);
		float tdspercent1 = TDSPERCENTAGE;
		CalculatedTdsValue = (float) ((TDSPERCENTAGE / 100.0) * NETADJUSTED);
		System.out.println(CalculatedTdsValue);
		testdata.put("calculatedtds", String.valueOf(Math.round(CalculatedTdsValue)));

	}

	@And("^Calcualte net payable amount from calculated net adjusted value and tds value$")
	public void calcualte_net_payable_amount_from_calculated_net_adjusted_value_and_tds_value() throws Throwable {
		int CalculatedNetPayableAmount = Integer.parseInt(testdata.get("CalculatedNetAjusted"))
				- Integer.parseInt(testdata.get("calculatedtds")) - Integer.parseInt(testdata.get("flatDiscount"))
				- Integer.parseInt(testdata.get("EarlypaymentDiscount"));
		System.out.println(CalculatedNetPayableAmount);
		testdata.put("CalculatedNetPayableAmount", String.valueOf(CalculatedNetPayableAmount));
	}

	@Then("^verify calculated net payable amount with net payable amount get from debit bill$")
	public void verify_calculated_net_payable_amount_with_net_payable_amount_get_from_debit_bill() throws Throwable {

		Assert.assertEquals(Integer.parseInt(testdata.get("CalculatedNetPayableAmount")),
				Integer.parseInt(testdata.get("NetPayableAmountfrombill")));
	}

	@And("^get net payable amount from payment settlement$")
	public void get_net_payable_amount_from_payment_settlement() throws Throwable {
		Object object = javascriphelper.executeScript(
				"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
		String netpayablevalueinsettlement = String.valueOf(object);
		System.out.println(netpayablevalueinsettlement);
		String substring = netpayablevalueinsettlement.substring(0, 6);
		System.out.println(substring);
		String NetAmount = substring.substring(0, 2) + substring.substring(3);
		testdata.put("NetPayableAmount", NetAmount);
	}

	@Then("^verify net payable amount is correctly displayed according to debit bill$")
	public void verify_net_payable_amount_is_correctly_displayed_according_to_debit_bill() throws Throwable {
		Assert.assertEquals(testdata.get("CalculatedNetPayableAmount"), testdata.get("NetPayableAmount"));
	}
	
	// ******************************************* @KUBS_AR/AP_UAT_004_004TC_04*******************************
		// verify accounting entries post payment approval for debit transaction
		@And("^click first eye icon in list view in payment settlement$")
	    public void click_first_eye_icon_in_list_view_in_payment_settlement() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getClickFirstPaymentInListView());
	        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickFirstPaymentInListView());
	    }
		
		 @And("^user search transaction number which is debit payment in payment settlement list view$")
		    public void user_search_transaction_number_which_is_debit_payment_in_payment_settlement_list_view() throws Throwable {
			 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getTransactionNumber());
			 paymentSettlementObj.getTransactionNumber().click();
			 paymentSettlementObj.getTransactionNumber().sendKeys(testData.get("txtNumber"));
		    }
		 @Then("^Verify the transaction number in Voucher Id and then payment approved$")
		    public void verify_the_transaction_number_in_voucher_id_and_then_payment_approved() throws Throwable {
			 while (true) {
					try {
						seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("txtnumber")+"')]")));
						driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("txtnumber")+"')]")).isDisplayed();
						String txtnumber = driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("txtnumber")+"')]")).getText();
						System.out.println("Found the "+txtnumber+"in Accounting Entries ");
						break;
						
					} catch (NoSuchElementException e) {
						//javascriphelper.scrollIntoView(enquiryObj.nextPageInListView());
						seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.nextPageInListView());
						enquiryObj.nextPageInListView().click();
						
					}
				}
		    }

		 //**************************************@KUBS_AR/AP_UAT_004_004TC_06*************************************************
		 @And("^get buisness partner name and payment settlement date, invoicenumber$")
		    public void get_buisness_partner_name_and_payment_settlement_date_invoicenumber() throws Throwable {
			 Thread.sleep(2000);
			 seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj.getGetBuisnessPartnerName());
		        String buisnessPartnerName = paymentSettlementObj.getGetBuisnessPartnerName().getText();
		        testdata.put("buisnessPartnerName", buisnessPartnerName);
		        javascriphelper.JavaScriptHelper(driver);
		        String paymentDate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[1].value");
		        testdata.put("paymentDate", paymentDate);
		        System.out.println(paymentDate);
				String year = paymentDate.substring(7,11);
				testdata.put("year", year);
				String month = paymentDate.substring(3, 6);
				testdata.put("month", month);
				if (Integer.parseInt(paymentDate.substring(0, 2))>9) {
					String day = paymentDate.substring(0,2);
					System.out.println(day);
					testdata.put("day", day);
				}
				else{
					String day = paymentDate.substring(1, 2);
					testdata.put("day", day);
					System.out.println(day);
				}
				String invoiceNumber = driver.findElement(By.xpath("(//datatable-body-cell[4]/div[1])[2]")).getText();
				System.out.println(invoiceNumber);
				testdata.put("invoiceNumber", invoiceNumber);
		        
		    }

}
