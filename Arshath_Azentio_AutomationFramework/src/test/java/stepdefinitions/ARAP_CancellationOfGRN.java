package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ARAP_ARandAPData;

public class ARAP_CancellationOfGRN extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String GRNNO;
	String Branchcode;
	String InvoiceNo;
	String PoNumber;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	String TxnNo;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	ARAP_ARandAPData arapData = jsonConfig.getARAPByName("ARAP");
	JsonDataReaderWriter json = new JsonDataReaderWriter();

	// **********************@KUBS_AR/AP_UAT_003_003_TC_02*********************//

	@Then("^Third Segment report Icon$")
	public void third_segment_report_icon() throws Throwable {
		// -----------CLICK ON REPORT ICON----------------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPReportIcon());
		arapObj.ARAPReportIcon().click();
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPEnquiryMenu());
		Assert.assertTrue(arapObj.ARAPEnquiryMenu().isDisplayed());
	}

	@And("^Choose Enquiry Module$")
	public void choose_enquiry_module() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPEnquiryMenu());
		arapObj.ARAPEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPFinancialTransactionIcon());
		Assert.assertTrue(arapObj.ARAPFinancialTransactionIcon().isDisplayed());
	}

	@Then("^Click Note iCon near by financial transction$")
	public void click_note_icon_near_by_financial_transction() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		arapObj.ARAPFinancialTransactionIcon().click();
	}

	@Then("^Enter the GRN status cancel$")
	public void enter_the_grn_status_cancel() throws Throwable {
		// ---------ENTER THE STATUS-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GRNStatus());
		arapObj.ARAP_GRNStatus().click();
		arapObj.ARAP_GRNStatus().sendKeys(arapData.GRNStatus1);
	}

	@And("^Get the Branchcode and Ref No$")
	public void get_the_branchcode_and_ref_no() throws Throwable {
		// ---------GET BRANCH CODE---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviable_GetBranchcode());
		Branchcode = arapObj.accountReceviable_GetBranchcode().getText();
		System.out.println(Branchcode);
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviable_GetGrn());
		GRNNO = arapObj.accountReceviable_GetGrn().getText();
		System.out.println(GRNNO);
	}

	@And("^choose branch code$")
	public void choose_branch_code() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAPBranchCode());
		arapObj.ARAPBranchCode().click();
		arapObj.ARAPBranchCode().sendKeys(arapData.branchCode);
		arapObj.ARAPBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date in calender$")
	public void click_on_transaction_from_date_in_calender() throws Throwable {
		// -----------CLICK ON CALANDER--------------//
		arapObj.ARAPFromDate().click();
	}

	@Then("^Select from date in calender$")
	public void select_from_date_in_calender() throws Throwable {
		// ----------CLICK ON FROM DATE--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlMonth + " " + arapData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlMonth + " " + arapData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + arapData.GlFullMonth + " "
				+ arapData.GlDay + ", " + arapData.GlYear + "']/span")));
		 WebElement Click =driver.findElement(By.xpath("//td[@aria-label='" + arapData.GlFullMonth + " "
				+ arapData.GlDay + ", " + arapData.GlYear + "']/span"));
		
		clickAndActionHelper.doubleClick(Click);
		//clickAndActionHelper.clickOnElement(Click);
	}

	@And("^click on transaction to date in calender icon$")
	public void click_on_transaction_to_date_in_calender_icon() throws Throwable {
		// ----------CLICK ON TRANSACTION TO DATE--------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPToDate());
		arapObj.ARAPToDate().click();
	}

	@Then("^Select To date in calender$")
	public void select_to_date_in_calender() throws Throwable {
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlToMonth + " " + arapData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlToMonth + " " + arapData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + arapData.GlFullToMonth + " "
				+ arapData.GlToDate + ", " + arapData.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click View HyperLink$")
	public void click_view_hyperlink() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		arapObj.ARAPViewButton().click();
	}

	@Then("^Verify Accounting entries post GRN is cancelled$")
	public void verify_accounting_entries_post_grn_is_cancelled() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javaScriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 265; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(
								By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')]")),
						1000, 100);
				 driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')]"));
				break;
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 265) {
				System.out.println("This is the end of the table Referance number is not availabe ");
				break;

			}
		}
	}

	// ************************@KUBS_AR/AP_UAT_003_003_TC_05****************************//

	@Given("^Navigate The Azentio Url$")
	public void navigate_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^Choose the second Tab Segment$")
	public void choose_the_second_tab_segment() throws Throwable {
		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAPTransfericon());
		arapObj.ARAPTransfericon().click();
	}

	@And("^Click On Main module Accounts payable$")
	public void click_on_main_module_accounts_payable() throws Throwable {
		// ---------CLICK ON ACCOUNTS PAYABLE MODULE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Accountspayable());
		arapObj.ARAP_Accountspayable().click();
	}

	@Then("^Click On GRN Eye Icon$")
	public void click_on_grn_eye_icon() throws Throwable {
		// ---------CLICK ON GRN EYE ICON--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GRN_Eye());
		arapObj.ARAP_GRN_Eye().click();
	}

	@And("^Click On Search Icon$")
	public void click_on_search_icon() throws Throwable {
		// ---------CLICK ON GRN SEARCH ICON-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Search());
		arapObj.ARAP_Search().click();
	}

	@Then("^Enter The GRN No$")
	public void enter_the_grn_no() throws Throwable {
		// ---------ENTER THE BUSINESS PARTNER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GrnNo());
		arapObj.ARAP_GrnNo().click();
		arapObj.ARAP_GrnNo().sendKeys(arapData.GRN);
	}

	@And("^Enter the GRN status$")
	public void enter_the_grn_status() throws Throwable {
		// ---------ENTER THE STATUS-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GRNStatus());
		arapObj.ARAP_GRNStatus().click();
		arapObj.ARAP_GRNStatus().sendKeys(arapData.GRNStatus1);
	}

	@Then("^Click on Table Row First Eye Icon$")
	public void click_on_table_row_first_eye_icon() throws Throwable {
		// --------CLICK THE TABLE FIRST EYE ICON-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_TableEye());
		arapObj.ARAP_TableEye().click();
	}

	@And("^Get the Required Details$")
	public void get_the_required_details() throws Throwable {
		// --------GET BUSINESS PARTNER DETAILS-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetPoNumber());
		BPNumber = arapObj.ARAP_GetPoNumber().getText();
		System.out.println(BPNumber);

		// --------GET THE GRN NUMBER DETAILS---------//
		javaScriptHelper.JavaScriptHelper(driver);
		GRNNO = (String) javaScriptHelper.executeScript(" return document.getElementsByName('grnNumber')[1].value");
		System.out.println(GRNNO);

		// --------GET INVOICE NUMBER DETAILS----------//
		javaScriptHelper.JavaScriptHelper(driver);
		InvoiceNo = (String) javaScriptHelper
				.executeScript(" return document.getElementsByName('billNumber')[1].value");
		System.out.println(InvoiceNo);
	}

	@Then("^Click on Item Details$")
	public void click_on_item_details() throws Throwable {
		// ---------CLICK ON ITEM DETAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ItemDetails());
		arapObj.ARAP_ItemDetails().click();
		Thread.sleep(2000);
	}

	@And("^Get PO Number$")
	public void get_po_number() throws Throwable {
		// ---------GET PO NUMBER------------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetPoNumber());
		PoNumber = arapObj.ARAP_GetPoNumber().getText();
		System.out.println(PoNumber);
	}

	@Then("^Open Invoice Bill Booking Eye icon$")
	public void open_invoice_bill_booking_eye_icon() throws Throwable {
		// --------CLICK BILL BOOKING EYE ICON---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceEye());
		arapObj.ARAP_InvoiceEye().click();
	}

	@And("^Click Add icon button$")
	public void click_add_icon_button() throws Throwable {
		// -------CLICK ON ADD ICON--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceAdd());
		arapObj.ARAP_InvoiceAdd().click();
	}

	@Then("^Enter the Invoice Type$")
	public void enter_the_invoice_type() throws Throwable {
		// -------ENTER THE INVOICE TYPE--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceType());
		arapObj.ARAP_InvoiceType().click();
		arapObj.ARAP_InvoiceType().sendKeys(arapData.InvoiceType);
		arapObj.ARAP_InvoiceType().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business Partner Name$")
	public void enter_business_partner_name() throws Throwable {
		// -------ENTER THE BUSINESS PARTNER--------//
		waitHelper.waitForElementVisible(arapObj.ARAP_InvoiceSubType(), 3000, 3000);
		arapObj.ARAP_InvoiceSubType().click();
		arapObj.ARAP_InvoiceSubType().sendKeys(BPNumber);
		arapObj.ARAP_InvoiceSubType().sendKeys(Keys.ENTER);

	}

	@Then("^Enter Cost Center value$")
	public void enter_cost_center_value() throws Throwable {
		// -------ENTER COST CENTER VALUE---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveCostCenter());
		arapObj.ARAP_GiveCostCenter().click();
		arapObj.ARAP_GiveCostCenter().sendKeys(arapData.CostCenter);
		arapObj.ARAP_GiveCostCenter().sendKeys(Keys.ENTER);
	}

	@And("^Enter Supplier Referance Number$")
	public void enter_supplier_referance_number() throws Throwable {
		// ---------ENTER SUPPLIER REF NO---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GivesupplierRefno());
		arapObj.ARAP_GivesupplierRefno().click();
		arapObj.ARAP_GivesupplierRefno().sendKeys(arapData.SupplyRefNo);
	}

	@And("^Enter Flat Discount Invoice Amount$")
	public void enter_flat_discount_invoice_amount() throws Throwable {
		// -------ENTER INVOICE AMOUNT-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveflatDiscount());
		arapObj.ARAP_GiveflatDiscount().click();
		arapObj.ARAP_GiveflatDiscount().sendKeys(arapData.Discount);
	}

	@Then("^Give Mode of payment$")
	public void give_mode_of_payment() throws Throwable {
		// --------GIVE MODE OF PAYMENT----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveModeofPayment());
		arapObj.ARAP_GiveModeofPayment().click();
		arapObj.ARAP_GiveModeofPayment().sendKeys(arapData.ModeofPayment);
		arapObj.ARAP_GiveModeofPayment().sendKeys(Keys.ENTER);
	}

	@And("^Save the Invoice Bill Record$")
	public void save_the_invoice_bill_record() throws Throwable {
		// --------SAVE THE RECORD--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceSave());
		arapObj.ARAP_InvoiceSave().click();
	}

	@Then("^Goto The Notification Icon$")
	public void goto_the_notification_icon() throws Throwable {

		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_MakerNotification());
		arapObj.ARAP_MakerNotification().click();
	}

	@And("^Store the Referance Id and Open the Record$")
	public void store_the_referance_id_and_open_the_record() throws Throwable {
		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}

	@Then("^Click on AP Invoice Against PO Tab$")
	public void click_on_ap_invoice_against_po_tab() throws Throwable {
		// -----------CLICK ON AGAINST PO TAB----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_APInvoiceAgainstPO());
		arapObj.ARAP_APInvoiceAgainstPO().click();
	}

	@And("^Enter The PO Number and Validate$")
	public void enter_the_po_number_and_Validate() throws Throwable {
		// ----------GIVE THE PO NUMBER-------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_PoNumber());
		arapObj.ARAP_PoNumber().click();
		arapObj.ARAP_PoNumber().sendKeys(PoNumber);
		arapObj.ARAP_PoNumber().sendKeys(Keys.ENTER);
		try {
			arapObj.InvoiceBooking_GRN_Number().isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("THE CANCELLATION GRN IS NOT ALLOWED");
		}
	}

	// ********************KUBS_AR/AP_UAT_003_003_TC_06*************************//

	@And("^Enter the Invoice Bill Booking status$")
	public void enter_the_invoice_bill_booking_status() throws Throwable {
		// --------------BILL BOOKING STATUS--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceTypeSearch());
		arapObj.ARAP_InvoiceTypeSearch().click();
		arapObj.ARAP_InvoiceTypeSearch().sendKeys(arapData.InvoiceNo);
		/*
		 * javaScriptHelper.JavaScriptHelper(driver);
		 * javaScriptHelper.scrollIntoView(arapObj.ARAP_InvoiceStatus());
		 * waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceStatus());
		 * arapObj.ARAP_InvoiceStatus().click();
		 * arapObj.ARAP_InvoiceStatus().sendKeys(arapData.GRNStatus);
		 */
	}

	@And("^Store the Business partner Value$")
	public void store_the_business_partner_value() throws Throwable {
		// ------------STORE THE VALUES-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetcancelBpName());
		BPNumber = arapObj.ARAP_GetcancelBpName().getText();
		System.out.println(BPNumber);
	}

	@And("^Get the Required Number$")
	public void get_the_required_number() throws Throwable {
		// ----------GET THE DETAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.InvoiceBooking_GRN_Number());
		GRNNO = arapObj.InvoiceBooking_GRN_Number().getText();
		System.out.println(GRNNO);
	}

	@Then("^Open the Adjustment ARAP module$")
	public void open_the_adjustment_arap_module() throws Throwable {
		// ----------adjustment ARAP---------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustment_ARAP());
		arapObj.adjustment_ARAP().click();
	}

	@And("^Click on Adjustment ARAP Eye Icon$")
	public void click_on_adjustment_arap_eye_icon() throws Throwable {
		// -----------ADJUSTMENT ARAP-------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentViewButton());
		arapObj.adjustmentViewButton().click();
	}

	@Then("^Give The Business Partner$")
	public void give_the_business_partner() throws Throwable {
		// ----------BUSINESS PARTNER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentBpName());
		arapObj.adjustmentBpName().click();
		arapObj.adjustmentBpName().sendKeys(BPNumber);
		arapObj.adjustmentBpName().sendKeys(Keys.ENTER);
	}

	@And("^Give The Adjustment Type$")
	public void give_the_adjustment_type() throws Throwable {
		// -----------ADJUSTMENTS TYPE-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentadjustmentType());
		arapObj.adjustmentadjustmentType().sendKeys(Keys.DOWN);
		arapObj.adjustmentadjustmentType().sendKeys(Keys.ENTER);
	}

	@Then("^Enter the Adjustment Item Type$")
	public void enter_the_adjustment_item_type() throws Throwable {
		// ----------ADJUSTMENTS ITEM TYPE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(arapData.AdjustmentType);
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);

	}

	@And("^Enter the Adjustment Ref No and Validate$")
	public void enter_the_adjustment_ref_no_and_validate() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(GRNNO);

		try {
			waitHelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("The Approved Invoice Bill Record GRN is Not Allowed to Cancellation");
		}

	}

	// *******************@KUBS_AR/AP_UAT_003_006_TC_02******************//

	@Then("^Verify Accounting entries post Debit Note is cancelled$")
	public void verify_accounting_entries_post_debit_note_is_cancelled() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javaScriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 265; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(
								By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')]")),
						1000, 100);
				WebElement result= driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')]"));
				//Assert.assertFalse(result);
				break;

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 265) {
				System.out.println("This is the end of the table Referance number is not availabe ");
				break;

			}
		}
	}

	// ***************@KUBS_AR/AP_UAT_003_006_TC_04******************//

	@And("^Click On Main module Accounts Receivable$")
	public void click_on_main_module_accounts_receivable() throws Throwable {
		// ----------ACCOUTS RECEIVABLE----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Accountsreceivable());
		arapObj.ARAP_Accountsreceivable().click();
	}

	@Then("^Click on Accounts Receivable Debit Note Eye Icon$")
	public void click_on_accounts_receivable_debit_note_eye_icon() throws Throwable {
		// -----------DEBIT NOTE EYE---------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Eye());
		arapObj.accountsReceivable_DebitNote_Eye().click();
	}

	@Then("^Enter Cancelled Value In Debit Not Status$")
	public void enter_cancelled_value_in_debit_not_status() throws Throwable {
		// ------------Cancelled STATUS------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsReceivable_DebitNote_Status());
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Status());
		arapObj.accountsReceivable_DebitNote_Status().click();
		arapObj.accountsReceivable_DebitNote_Status().sendKeys(arapData.GRNStatus1);
	}

	@Then("^Click on Table Row First Edit Icon$")
	public void click_on_table_row_first_edit_icon() throws Throwable {
		// -----------TABLE ROW FIRST EDIT ICON--------------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_TableEdit());
		arapObj.ARAP_TableEdit().click();
	}

	@And("^Store The Business partner and Invoice Number$")
	public void store_the_business_partner_and_invoice_number() throws Throwable {
		// ------------STORE THE DTAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_InvoiceNo());
		InvoiceNo = arapObj.accountsReceivable_DebitNote_InvoiceNo().getText();
		System.out.println(InvoiceNo);
	}

	@Then("^Click sub module Payment settlement Eye Icon$")
	public void click_sub_module_payment_settlement_eye_icon() throws Throwable {
		// ------------PAYMENT SETTLEMENT EYE ICON---------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementViewIcon());
		arapObj.accountsPayablePayementSettlementViewIcon().click();

	}

	@Then("^Enter payment option$")
	public void enter_payment_option() throws Throwable {
		// -----------ENTER PAYMENT OPTION----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementPaymentOption());
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(arapData.PaymentOption);
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner$")
	public void enter_business_partner() throws Throwable {
		// ----------ENTER BUSINESS PARTNER-------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(arapData.BusinesPartner);
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);
	}

	@Then("^Choose value date as System current date$")
	public void choose_value_date_as_system_current_date() throws Throwable {
		// ------------VALUE DATE--SYSTEM DATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementValueDate());
		arapObj.accountsPayablePayementSettlementValueDate().click();

		// -------------CHOOSE DATE---------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 5000, driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlMonth + " " + arapData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + arapData.GlMonth + " " + arapData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waitHelper.waitForElement(driver, 5000, arapObj.ARAPNextMonth());
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//td[@aria-label='" + arapData.GlFullMonth
				+ " " + arapData.GlDay + ", " + arapData.GlYear + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + arapData.GlFullMonth + " "
				+ arapData.GlDay + ", " + arapData.GlYear + "']/span"));

		clickAndActionHelper.doubleClick(Click);
		clickAndActionHelper.clickOnElement(Click);
	}

	@And("^find the invoice reference number for cancelled DebitNote is availabe at the billing queue$")
	public void find_the_invoice_reference_number_for_cancelled_debitnote_is_availabe_at_the_billing_queue()
			throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 3; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]")), 1000, 100);
				boolean status = driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);
				break;

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 3) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	// ****************@KUBS_AR/AP_UAT_003_006_TC_05*******************//

	// document.getElementsByName('debitNoteNumber')[1].value
	@And("^Get The Bp Name and Debit Number Store It$")
	public void get_the_bp_name_and_debit_number_store_it() throws Throwable {
		// ---------GET THE REQUIRED DETAILS--------------//
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetBpname());
		BPNumber = arapObj.accountsReceivable_DebitNote_GetBpname().getText();
		System.out.println(BPNumber);
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		DebitNo = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('debitNoteNumber')[1].value");
		System.out.println(DebitNo);
	}

	@Then("^Give the Adjustment Item Type$")
	public void give_the_adjustment_item_type() throws Throwable {
		// ----------ADJUSTMENTS ITEM TYPE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(arapData.DebitType);
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);
	}

	@And("^Give the Adjustment Ref No and Validate$")
	public void give_the_adjustment_ref_no_and_validate() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(DebitNo);

		try {
			waitHelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("The Approved Invoice Bill Record GRN is Not Allowed to Cancellation");
		}
	}

	// **********************@KUBS_AR/AP_UAT_003_009_TC_01*******************//

	@Then("^Verify No accounting entry is generated on cancelling advances against PO$")
	public void verify_no_accounting_entry_is_generated_on_cancelling_advances_against_po() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 200; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(
								By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')]")),
						1000, 100);
				boolean status = driver
						.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);
				break;

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 200) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	// *********************@KUBS_AR/AP_UAT_003_009_TC_02*******************//

	@Then("^Click on Accounts Receive Advances Eye Icon$")
	public void click_on_accounts_receive_advances_eye_icon() throws Throwable {
		// ---------------ADVANCE EYE ICON----------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_Eye());
		arapObj.accountsReceivable_Advance_Eye().click();
	}

	@Then("^Enter Cancelled Value In Advance Status$")
	public void enter_cancelled_value_in_advance_status() throws Throwable {
		// ----------GIVE DETAILS FOR SEARCH-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(arapData.RecivableName);
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(arapData.GRNStatus1);
	}

	@And("^Get The Business Partner and Advance Number$")
	public void get_the_business_partner_and_advance_number() throws Throwable {
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_GetBp());
		BPNumber = arapObj.accountsReceivable_Advance_GetBp().getText();
		System.out.println(BPNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVNumber = (String) javaScriptHelper.executeScript("return document.getElementsByName('advanceNo')[1].value");
		System.out.println(ADVNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVAmount = (String) javaScriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value");
		System.out.println(ADVAmount);
	}

	@And("^Give stored Business partner Name$")
	public void give_stored_business_partner_name() throws Throwable {
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(BPNumber);
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);

	}

	@And("^find the Advance reference number for cancelled Advances is availabe at the billing queue$")
	public void find_the_advance_reference_number_for_cancelled_advances_is_availabe_at_the_billing_queue()
			throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 3; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")), 1000, 100);
				boolean status = driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 3) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	// ***********************@KUBS_AR/AP_UAT_003_009_TC_03************************//

	@Then("^Enter Active Value In Advance Status$")
	public void enter_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(arapData.GRNStatus);
	}

	@And("^find the Advance reference number for Active Advances is availabe at the billing queue$")
	public void find_the_advance_reference_number_for_active_advances_is_availabe_at_the_billing_queue()
			throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);

		for (int i = 0; i <= 13; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")), 1000, 100);
				boolean status = driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 13) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	@Then("^Click the Checkbox As Tick$")
	public void click_the_checkbox_as_tick() throws Throwable {
		// -------CHECKBOX CLICK----------------//
		String befr_xpath = "//div[contains(text(),'";
		String aftr_xpath = "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr_xpath + ADVNumber + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + ADVNumber + aftr_xpath)).click();
	}

	@When("^Enter the Description value$")
	public void enter_the_description_value() throws Throwable {
		// ---------ENTER THE DESCRIPTION----------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsPayableDescription());
		arapObj.accountsPayableDescription().click();
		arapObj.accountsPayableDescription().sendKeys(arapData.Description);
	}

	@And("^Save The Payment settlement Record$")
	public void save_the_payment_settlement_record() throws Throwable {
		// ---------SAVE THE RECORD---------//
		waitHelper.waitForElement(driver, 3000, arapObj.accountsPayableSaveButton());
		arapObj.accountsPayableSaveButton().click();

	}

	@Then("^Click the Alert message as Yes$")
	public void click_the_alert_message_as_yes() throws Throwable {
		// -------ALERT MESSAGE-------//
		waitHelper.waitForElement(driver, 3000, arapObj.accountsPayableAlertYes());
		arapObj.accountsPayableAlertYes().click();
	}

	@Then("^Click submit button and Enter Remark submit it$")
	public void click_submit_button_and_enter_remark_submit_it() throws Throwable {
		// -------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Submit());
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Remark());
		arapObj.ARAP_Remark().sendKeys(arapData.Remark);
		waitHelper.waitForElement(driver, 5000, arapObj.ARAP_RemarkSubmit());
		arapObj.ARAP_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER
	@Given("^Navigate as a Reviewer$")
	public void navigate_as_a_reviewer() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@Then("^click on Notify icon$")
	public void click_on_notify_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@And("^Click First record Action icon$")
	public void click_first_record_action_icon() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Approve the record in Reviewer$")
	public void approve_the_record_in_reviewer() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Give Remark and Submit$")
	public void give_remark_and_submit() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(arapData.Remark);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER

	@Given("^Navigate as a Checker$")
	public void navigate_as_a_checker() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click module security management$")
	public void click_module_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();

		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@And("^Claim the Record in Checker$")
	public void claim_the_record_in_checker() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@Then("^Goto the Checker notification Icon$")
	public void goto_the_checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@And("^Click the First Action Icon$")
	public void click_the_first_action_icon() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@Then("^Approve the Record in checker stage$")
	public void approve_the_record_in_checker_stage() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@And("^Give the Remark and Submit it$")
	public void give_the_remark_and_submit_it() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(arapData.Remark);
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	@Then("^Give the Adjustment Item Type as AR Advance$")
	public void give_the_adjustment_item_type_as_ar_advance() throws Throwable {
		// ----------ADJUSTMENTS ITEM TYPE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(arapData.AdvanceType);
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);
	}

	@And("^Give the Advance Adjustment Ref No and Validate$")
	public void give_the_advance_adjustment_ref_no_and_validate() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(ADVNumber);

		try {
			waitHelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().click();
		} catch (ElementClickInterceptedException e) {
			e.getMessage();
		}
	}

	// ***************@KUBS_AR/AP_UAT_004_003_TC_01****************//

	@Then("^Enter the Receivable Name$")
	public void enter_the_receivable_name() throws Throwable {
		// -------ENTER RECEIVABLE NAME---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_ReceivableName_TextBox());
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().click();
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(arapData.RecivableName);
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner Value$")
	public void enter_business_partner_value() throws Throwable {
		// -----------ENTER BUSINESS PARTNER--------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_BusinessPatner_TextBox());
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().click();
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(arapData.BusinesPartner);
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Enter the PO Number$")
	public void enter_the_po_number() throws Throwable {
		// ----------ENTER PO NUMBER----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_PONumber_TextBox());
		arapObj.accountReceviableAdvances_PONumber_TextBox().click();
		arapObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(arapData.PONumber);
		arapObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Payment mode$")
	public void enter_payment_mode() throws Throwable {
		// ----------ENTER PAYMENT AMOUNT---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_paymentMode_TextBox());
		arapObj.accountReceviableAdvances_paymentMode_TextBox().click();
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(arapData.ModeofPayment);
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Amount value$")
	public void enter_amount_value() throws Throwable {
		// ---------ENTER AMOUNT VALUE--------//
		waitHelper.waitForElement(driver, 2000, arapObj.amount_TextBox());
		arapObj.amount_TextBox().sendKeys(arapData.Amount);
	}

	@And("^Choose Needed Currancy$")
	public void choose_needed_currancy() throws Throwable {
		// --------ENTER NEEDED CURRENCY-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_currency_TextBox());
		arapObj.accountReceviableAdvances_currency_TextBox().sendKeys("INR");
		arapObj.accountReceviableAdvances_currency_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Choose cost center$")
	public void choose_cost_center() throws Throwable {
		// --------ENTER COST CENTER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_costCenter_TextBox());
		arapObj.accountReceviableAdvances_costCenter_TextBox().click();
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(arapData.CostCenter);
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Description value$")
	public void enter_description_value() throws Throwable {
		// --------ENTER DESCRIPTION------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_description_TextBox());
		arapObj.accountReceviableAdvances_description_TextBox().click();
		arapObj.accountReceviableAdvances_description_TextBox().sendKeys(arapData.Description);
	}

	@Then("^Save the Advance Record$")
	public void save_the_advance_record() throws Throwable {
		// ------SAVE THE RECORD----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_Save_Button());
		arapObj.accountReceviableAdvances_Save_Button().click();
	}

	// *****************@KUBS_AR/AP_UAT_004_006_TC_01********************//

	@And("^find the Advance reference number and Net Adjustable value in the billing queue$")
	public void find_the_advance_reference_number_and_net_adjustable_value_in_the_billing_queue() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 10; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")), 1000, 100);
				boolean status = driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 10) {
				System.out.println("This is the end of the table");
				break;

			}
		}
	}

	@And("^Verify the Net Adjusted Value is correctly displayed$")
	public void verify_the_net_adjusted_value_is_correctly_displayed() throws Throwable {
		// --------VALIDATE THE NET PAYABLE ADJUSTMENT--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String NetadjAmount = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('paymentAmt')[0].value");
		System.out.println("The Net Adjust Amount is : " + NetadjAmount);
	}

	// *****************@KUBS_AR/AP_UAT_004_006_TC_02********************//

	// *****************@KUBS_AR/AP_UAT_004_006_TC_03********************//

	@And("^Verify the Net payable amount is correctly calculated & displayed$")
	public void verify_the_net_payable_amount_is_correctly_calculated_displayed() throws Throwable {
		// ------VERIFY THE NET PAYABLE AMOUNT-------//
		javaScriptHelper.JavaScriptHelper(driver);
		String Netpay = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('nettAmt')[0].value");
		System.out.println("The Net Payable Amount is : " + Netpay);
	}

	@Then("^Enter Advance Against PO and Active Value In Advance Status$")
	public void enter_advance_against_po_and_active_value_in_advance_status() throws Throwable {
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(arapData.RecivableName);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_01*******************//

	@Then("^Enter the Receivable Name as Advance to employee$")
	public void enter_the_receivable_name_as_advance_to_employee() throws Throwable {
		// -------ADVANCE TO EMPOLYEE----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_ReceivableName_TextBox());
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().click();
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(arapData.RecivableName1);
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner Value For Employee$")
	public void enter_business_partner_value_for_empolyee() throws Throwable {
		// -----------ENTER BUSINESS PARTNER--------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_BusinessPatner_TextBox());
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().click();
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(arapData.Partner1);
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_02*************//

	@And("^Verify the TDS % & amount is correctly calculated & displayed$")
	public void verify_the_tds_amount_is_correctly_calculated_displayed() throws Throwable {
		// ----------VERIFY TDS VALUE------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String TDS = (String) javaScriptHelper.executeScript("return document.getElementsByName('tdsAmt')[0].value");
		System.out.println("The TDS% & TDS amount is : " + TDS);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_03*************//

	@Then("^Enter Advance to employee and Active Value In Advance Status$")
	public void enter_advance_to_employee_and_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(arapData.RecivableName1);
	}

	// *************KUBS_AR/AP_UAT_010_001_TC_01***************//

	@Then("^Click on the Receipt Eye Icon$")
	public void click_on_the_receipt_eye_icon() throws Throwable {
		// --------RECEIPT EYE ICON--------//
		arapObj.accountReceviableReceipt_Eye().click();
	}

	@Then("^Enter Receipt type as cheque$")
	public void enter_receipt_type_as_cheque() throws Throwable {
		// -------RECEIPT TYPR--------//
		arapObj.accountReceviableReceipt_Receipt_Type().click();
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(arapData.ReceiptType);
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(Keys.ENTER);
	}

	@And("^Enter Receipt Ref Number$")
	public void enter_receipt_ref_number() throws Throwable {
		// -------RECEIPT REF NO---------//
		arapObj.accountReceviableReceipt_Receipt_RefNo().click();
		arapObj.accountReceviableReceipt_Receipt_RefNo().sendKeys(arapData.ReceiptRefNo);
		arapObj.accountReceviableReceipt_Receipt_RefNo().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Receipt Amount$")
	public void enter_receipt_amount() throws Throwable {
		// -------RECEIPT AMOUNT-------//
		arapObj.accountReceviableReceipt_Receipt_Amount().click();
		arapObj.accountReceviableReceipt_Receipt_Amount().sendKeys(arapData.Amount);
		arapObj.accountReceviableReceipt_Receipt_Amount().sendKeys(Keys.ENTER);
	}

	@And("^Enter Bank Account Number$")
	public void enter_bank_account_number() throws Throwable {
		// -------BANK ACC NUMBER-------//
		arapObj.accountReceviableReceipt_Receipt_BankNo().click();
		arapObj.accountReceviableReceipt_Receipt_BankNo().sendKeys(arapData.BankAcc);
		arapObj.accountReceviableReceipt_Receipt_BankNo().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Receipt payer$")
	public void enter_receipt_payer() throws Throwable {
		// -------RECEIPT PAYER--------//
		arapObj.accountReceviableReceipt_Receipt_Payer().click();
		arapObj.accountReceviableReceipt_Receipt_Payer().sendKeys(arapData.Receiptpayer);

	}

	@And("^Enter Remarks for Receipt$")
	public void enter_remarks_for_receipt() throws Throwable {
		// --------RECEIPT REMARK-------//
		arapObj.accountReceviableReceipt_Receipt_Remark().click();
		arapObj.accountReceviableReceipt_Receipt_Remark().sendKeys(arapData.Remark);
		Thread.sleep(2000);
	}

	@Then("^Save Receipt Record$")
	public void save_receipt_record() throws Throwable {
		// -------SAVE RECEIPT RECORD-----//
		arapObj.accountReceviableReceipt_Receipt_Save().click();
	}

	@Then("^Enter Get Referance Number$")
	public void enter_get_referance_number() throws Throwable {
		// -------REFERANCE NUMBER--------//
		arapObj.accountReceviableReceipt_Receipt_SearchRefNo().click();
		arapObj.accountReceviableReceipt_Receipt_SearchRefNo().sendKeys(arapData.ReceiptRefNo);
	}

	// *******************@KUBS_AR_AP_UAT_010_001_TC_02*******************//

	@Then("^Enter Receipt type as Online$")
	public void enter_receipt_type_as_online() throws Throwable {
		// -------RECEIPT TYPR--------//
		arapObj.accountReceviableReceipt_Receipt_Type().click();
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(arapData.ReceiptType1);
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(Keys.ENTER);
	}

	// *******************@KUBS_AR_AP_UAT_010_001_TC_03*******************//

	@And("^Get The Txn Receipt Number$")
	public void get_the_txn_receipt_number() throws Throwable {
		// -------get the txn number--------//
		javaScriptHelper.JavaScriptHelper(driver);
		TxnNo = (String) javaScriptHelper.executeScript("return document.getElementsByName('receiptNo')[1].value");
		System.out.println(TxnNo);
	}

	@Then("^Verify Accounting entries post receipt recording$")
	public void verify_accounting_entries_post_receipt_recording() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javaScriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 265; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(
								By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')]")),
						1000, 100);
				boolean status = driver
						.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')]"))
						.isDisplayed();
				break;
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 265) {
				System.out.println("This is the end of the table Referance number is not availabe ");
				break;

			}
		}
	}

}
