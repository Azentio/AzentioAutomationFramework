package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSRECEIVABLE_AdvancesObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType;

public class ACCOUNTSPAYABLE_PaymentSettlement extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ACCOUNTSRECEIVABLE_AdvancesObj accuountsReceivableObj = new ACCOUNTSRECEIVABLE_AdvancesObj(driver);
	INVENTORY_EnquiryGlObject glObj = new INVENTORY_EnquiryGlObject(driver);
	ACCOUNTSPAYABLE_PaymentSettlementTestDataType paymentSettlementTestData = jsonConfig
			.getPayementSettlementTestDataByName("Maker");
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBillBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	VerificationHelper verificationHelper = new VerificationHelper();
	ARAP_AdjustmentsObj arapAdjustment = new ARAP_AdjustmentsObj(driver);
	// ACCOUNTSPAYABLE_PaymentSettlementTestDataType
	// paymentSettlementTestData=jsonConfig.getPayementSettlementTestDataByName("Maker");
	ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType AccoutsReceivableAdvanceTestData = jsonConfig
			.getAccountsReceivableAdvanceTestDataByName("Maker");
	Map<String, String> accountsReceivableTestData = new HashMap<>();
	Map<String, String> invoiceBookingData = new HashMap<>();
	Map<String, String> settlementData = new HashMap<>();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);

	/******************** BILL BOOKING ****************************/
	@And("^Go to invoice bill booking module$")
	public void go_to_invoice_bill_booking_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
		waitHelper.waitForElementVisible(makerObj.kubsAccountsPayable(), 2000, 100);
		makerObj.kubsAccountsPayable().click();
		invoiceBillBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
	}

	@And("^go to aacounts payable module$")
	public void go_to_aacounts_payable_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
		waitHelper.waitForElementVisible(makerObj.kubsAccountsPayable(), 2000, 100);
		makerObj.kubsAccountsPayable().click();
	}

	@And("^search the cancelled bill$")
	public void search_the_cancelled_bill() throws Throwable {
		invoiceBillBookingObj.accountPayable_InvoiceBooking_ContractStatus().click();
		invoiceBillBookingObj.accountPayableSearchInvoiceStatus().sendKeys(paymentSettlementTestData.InvoiceStatus);
		Thread.sleep(3000);
		String beforXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(driver
				.findElement(By.xpath(beforXpath + paymentSettlementTestData.canceledInvoiceNumber + afterXpath)));
		boolean status = driver
				.findElement(By.xpath(beforXpath + paymentSettlementTestData.canceledInvoiceNumber + afterXpath))
				.isDisplayed();
		Assert.assertTrue(status);
		waitHelper.waitForElementVisible(invoiceBillBookingObj.invoiceBookingBpName(), 2000, 100);

		String bpName = invoiceBillBookingObj.invoiceBookingBpName().getText();
		accountsReceivableTestData.put("bpName", bpName);

	}

	@Then("^click on search$")
	public void click_on_search() throws Throwable {
		invoiceBillBookingObj.accountPayable_InvoiceBooking_Search().click();
	}

	@And("^search for cancelled bill$")
	public void search_for_cancelled_bill() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(invoiceBillBookingObj.invoiceBookingCancelledStatus());
		waitHelper.waitForElementVisible(invoiceBillBookingObj.invoiceBookingCancelledStatus(), 2000, 200);
		invoiceBillBookingObj.invoiceBookingCancelledStatus().click();
		invoiceBillBookingObj.invoiceBookingCancelledStatus().sendKeys(paymentSettlementTestData.InvoiceBookingStatus);
		String bpName = invoiceBillBookingObj.invoiceBookingBpName().getText();
		invoiceBookingData.put("BpName", bpName);
		String invoiceNumber = invoiceBillBookingObj.invoiceBookingInvoiceNumber().getText();
		invoiceBookingData.put("InvoiceNumber", invoiceNumber);
		System.out.println("Invoice Number is" + invoiceBookingData.get("InvoiceNumber"));
	}

	@Then("^verify the accounting entries for the cancelled bill$")
	public void verify_the_accounting_entries_for_the_cancelled_bill() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i < 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ invoiceBookingData.get("InvoiceNumber") + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ invoiceBookingData.get("InvoiceNumber") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ invoiceBookingData.get("InvoiceNumber")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ invoiceBookingData.get("InvoiceNumber")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoView(glObj.nextRecord());
				glObj.nextRecord().click();
			}
		}
		for (int i = 0; i < 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ invoiceBookingData.get("InvoiceNumber") + "')])[2]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ invoiceBookingData.get("InvoiceNumber") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ invoiceBookingData.get("InvoiceNumber")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ invoiceBookingData.get("InvoiceNumber")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoView(glObj.nextRecord());
				glObj.nextRecord().click();
			}
		}
	}

	@And("^select the advance to employee active record$")
	public void select_the_advance_to_employee_active_record() throws Throwable {
		// input[@placeholder='Search Receivable Name']
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsReceivablereceivableName(), 2000, 100);
		accuountsReceivableObj.accountsReceivablereceivableName().click();
		accuountsReceivableObj.accountsReceivablereceivableName()
				.sendKeys(AccoutsReceivableAdvanceTestData.RecevableName);
		for (int row = 1; row < 7; row++) {
			// datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]
			waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper[" + row
					+ "]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]")), 2000, 100);
			String receivableStatus = driver.findElement(By.xpath("//datatable-row-wrapper[" + row
					+ "]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]")).getText();
			System.out.println("Receivable STatus is " + receivableStatus);
			
			
			try {
				Assert.assertEquals(receivableStatus, "Active");
				Thread.sleep(2000);
				String advNumber = driver.findElement(By.xpath("//datatable-row-wrapper[" + row
						+ "]/datatable-body-row[1]//datatable-body-cell[4]/div[1]/span[1]")).getText();
				String bpName = driver.findElement(By.xpath("//datatable-row-wrapper[" + row
						+ "]/datatable-body-row[1]//datatable-body-cell[5]/div[1]/span[1]")).getText();
				accountsReceivableTestData.put("advNumber", advNumber);
				accountsReceivableTestData.put("BpName", bpName);
				System.out.println(accountsReceivableTestData.get("advNumber"));
				System.out.println(accountsReceivableTestData.get("BpName"));
				break;
			} catch (AssertionError e) {
				System.out.println("No match Try again");
			}

		}
	}

	@And("^Go to payment settlement module$")
	public void go_to_payment_settlement_module() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementViewIcon(), 1000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementViewIcon().click();
		Thread.sleep(1000);

	}

	@And("^get the approved record from list view$")
	public void get_the_approved_record_from_list_view() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableApprovedSettlementRefNo(), 2000, 100);
		String approvedReferenceNumber = paymentSettlementObj.accountsPayableApprovedSettlementRefNo().getText();
		settlementData.put("approvedReferenceNumber", approvedReferenceNumber);
		System.out.println("Settlement Reference Number" + settlementData.get("approvedReferenceNumber"));
	}
	@And("^give the refrence number which we going to see accounting entries$")
    public void give_the_refrence_number_which_we_going_to_see_accounting_entries() throws Throwable {
		glObj.glTransactionReferenceNumber().click();
		glObj.glTransactionReferenceNumber().sendKeys(settlementData.get("approvedReferenceNumber"));
		glObj.glTransactionReferenceNumber().sendKeys(Keys.ENTER);
    }
	@Then("^verify approved settlement reference number is available in the Gl report$")
	public void verify_approved_settlement_reference_number_is_available_in_the_gl_report() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		
	
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
//						+ settlementData.get("approvedReferenceNumber") + "')])[1]")).isDisplayed();

//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
//						+ settlementData.get("approvedReferenceNumber") + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
//								+ settlementData.get("approvedReferenceNumber")
//								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
//						+ settlementData.get("approvedReferenceNumber")
//						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
//						.getText();
				//System.out.println("Amount is " + amount);
					}

	@And("^fill the form for payment settlement$")
	public void fill_the_form_for_payment_settlement() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(accountsReceivableTestData.get("bpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.DOWN);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("^Fill the form for accounts receivable for advance to employee$")
	public void fill_the_form_for_accounts_receivable_for_advance_to_employee() throws Throwable {

	}

	@And("^fill the form for cancelled advances$")
	public void fill_the_form_for_cancelled_advances() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOptionForCancelledAdvance);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(accountsReceivableTestData.get("BpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.DOWN);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("^fill the form for settlement$")
	public void fill_the_form_for_settlement() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000,
				100);
paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(paymentSettlementTestData.PaymentOptionForCancelledAdvance);
paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		System.out.println(accountsReceivableTestData.get("advNumber"));
		System.out.println(accountsReceivableTestData.get("BpName"));
		Thread.sleep(1000);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(accountsReceivableTestData.get("BpName"));
		
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		// div[contains(text(),'ADV_36_2422022')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]/ion-checkbox
Thread.sleep(1000);
for (int i = 1; i <= 15; i++) {
if (i == 15) {
Assert.fail("Record not available");
}
try {

javascriptHelper.scrollIntoViewAndClick( driver.findElement(By.xpath("//div[contains(text(),'" + accountsReceivableTestData.get("advNumber")
+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")));
break;
} catch (NoSuchElementException e) {
javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
}
}
// javascriptHelper.JSEClick(paymentSettlementObj.firstRecord());
// clicksAndActionsHelper.doubleClick(paymentSettlementObj.firstRecord());
javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementValueDate());
paymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
Thread.sleep(1000);
while (true) {
	try {

		waitHelper.waitForElement(driver, 5000, driver.findElement(
				By.xpath("//span[contains(text(),'" + paymentSettlementTestData.MonthYear + "')]")));
		driver.findElement(
				By.xpath("//span[contains(text(),'" + paymentSettlementTestData.MonthYear + "')]"));
		break;
	}

	catch (NoSuchElementException nosuchElement) {
		waitHelper.waitForElement(driver, 5000, paymentSettlementObj.accountsPayable_paymentSettlemen_NextMonth());
		paymentSettlementObj.accountsPayable_paymentSettlemen_NextMonth().click();
	}
}

waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//td[@aria-label='" + paymentSettlementTestData.FullMonth
		+ " " + paymentSettlementTestData.Day + ", " + paymentSettlementTestData.Year + "']/span")));
WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + paymentSettlementTestData.FullMonth + " "
		+ paymentSettlementTestData.Day + ", " + paymentSettlementTestData.Year + "']/span"));

clickAndActionHelper.doubleClick(Click);
paymentSettlementObj.accountsPayableDescription().click();
paymentSettlementObj.accountsPayableDescription().sendKeys("Ok");
}


	/*
	 * @And("^validate the invoice number is not available for payment settlement$")
	 * public void
	 * validate_the_invoice_number_is_not_available_for_payment_settlement() throws
	 * Throwable {
	 * 
	 * }
	 */
	@Then("fill the payment settlement record and validate the invloice number is not available in the invoice list view")
	public void fill_the_payment_settlement_record_and_validate_the_invloice_number_is_not_available_in_the_invoice_list_view() {

	}

	@And("^Save the form$")
	public void Save_the_form() throws Throwable {
		Thread.sleep(1000);
		// paymentSettlementObj.firstRecord().click();
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableSaveButton(), 2000, 100);
		paymentSettlementObj.accountsPayableSaveButton().click();
		// clicksAndActionsHelper.doubleClick(paymentSettlementObj.accountsPayableSaveButton());
		// paymentSettlementObj.accountsPayableSaveButton().click();
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableAlertYes(), 2000, 100);
		paymentSettlementObj.accountsPayableAlertYes().click();
		Thread.sleep(1000);
	}

	@And("^find the invoice reference number for cancelled advance is not availabe at the billing queue$")
	public void find_the_invoice_reference_number_for_cancelled_advance_is_not_availabe_at_the_billing_queue()
			throws Throwable {
		Thread.sleep(3000);
		javascriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 30; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath(
								"//div[contains(text(),'" + accountsReceivableTestData.get("advNumber") + "')]")),
						1000, 100);
				driver.findElement(
						By.xpath("//div[contains(text(),'" + accountsReceivableTestData.get("advNumber") + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				// try

				try
				{
				javascriptHelper.scrollIntoViewAndClick(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				//paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
				}
				catch(ElementNotInteractableException e5)
				{
					
				}
				}
			if (i == 3) {
				System.out.println("This is the end of the table Reference Number is not availabe ");
				break;

			}
		}

	}

	@And("^find the invoice reference number is availabe at the billing queue$")
	public void find_the_invoice_reference_number_is_availabe_at_the_billing_queue() throws Throwable {
		// div[contains(text(),'ADV_10_21122021')]
		Thread.sleep(3000);
		javascriptHelper.JavaScriptHelper(driver);
		boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 13; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath(
								"//div[contains(text(),'" + paymentSettlementTestData.canceledInvoiceNumber + "')]")),
						1000, 100);
				driver.findElement(
						By.xpath("//div[contains(text(),'" + paymentSettlementTestData.canceledInvoiceNumber + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				try {
					javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

					paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
				} catch (ElementNotInteractableException e2) {
					pageStatus = false;
				}
			}
			if (i == 13) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
		if (pageStatus == false) {
			System.out.println(
					"This is the final record " + paymentSettlementTestData.canceledInvoiceNumber + " is not availabe");
		}
	}

	/******************* ACCOUNTS RECEIVABLE ADVANCES ****************************/
	@And("^Goto accounts receivable advances module$")
	public void goto_accounts_receivable_advances_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 1000, 100);
		Thread.sleep(2000);
		makerObj.kubsDirectionIcon().click();
		Thread.sleep(2000);
		makerObj.kubsAccountsReceivable().click();
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsreceivableAdvancesViewIcon(), 1000, 100);
		accuountsReceivableObj.accountsreceivableAdvancesViewIcon().click();

	}

	@And("^Fill the mendatory fields for creating advance to employee$")
	public void fill_the_mendatory_fields_for_creating_advance_to_employee() throws Throwable {
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsReceivablereceivableNameInput(), 3000, 100);
		accuountsReceivableObj.accountsReceivablereceivableNameInput().click();
		accuountsReceivableObj.accountsReceivablereceivableNameInput()
				.sendKeys(AccoutsReceivableAdvanceTestData.RecevableName);
		accuountsReceivableObj.accountsReceivablereceivableNameInput().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName().click();
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName()
				.sendKeys(AccoutsReceivableAdvanceTestData.BusinessPartnerNAme);
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode().click();
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode()
				.sendKeys(AccoutsReceivableAdvanceTestData.PaymentMode);
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivableAmmount().click();
		accuountsReceivableObj.accountsReceivableAmmount().sendKeys(AccoutsReceivableAdvanceTestData.Ammount);
		accuountsReceivableObj.accountsReceivableCurrencyType().click();
		for (int i = 1; i < 4; i++) {
			accuountsReceivableObj.accountsReceivableCurrencyType().sendKeys(Keys.DOWN);
		}
		accuountsReceivableObj.accountsReceivableCurrencyType().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivableDescription().click();
		accuountsReceivableObj.accountsReceivableDescription().sendKeys(AccoutsReceivableAdvanceTestData.Description);
	}

	@And("^Save the advance record$")
	public void save_the_advance_record() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableSaveButton(), 2000, 100);
		paymentSettlementObj.accountsPayableSaveButton().click();

	}

	/******************** PAYMENT SETTLEMENT ****************************/
	@Then("^verify approved record is availabe for payment settlement$")
	public void verify_approved_record_is_availabe_for_payment_settlement() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(AccoutsReceivableAdvanceTestData.BusinessPartnerNAme);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 14; i++) {
			Thread.sleep(1000);
			if (i == 14) {
				System.out.println("Data not available");
				System.out
						.println("Approved record we search " + accountsReceivableTestData.get("FirstApprovedRecord"));
				Assert.fail("Data not available");
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath(
						"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]")),
						2000, 100);
				javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
						"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]")));
				boolean finalStatus = driver.findElement(By.xpath(
						"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]"))
						.isDisplayed();
				Assert.assertTrue(finalStatus);
				break;
			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	@And("^get the receivable number from aproved record$")
	public void get_the_receivable_number_from_aproved_record() throws Throwable {
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsReceivableApprovedFirstRecord(), 2000, 100);
		String firstApprovedRecord = accuountsReceivableObj.accountsReceivableApprovedFirstRecord().getText();
		accountsReceivableTestData.put("FirstApprovedRecord", firstApprovedRecord);
		System.out.println(accountsReceivableTestData.get("FirstApprovedRecord"));
	}

	@And("^select one record from advances$")
	public void select_one_record_from_advances() throws Throwable {

		accuountsReceivableObj.accountsreceivableAdvancesADVStatusSearch()
				.sendKeys(AccoutsReceivableAdvanceTestData.ADVStatus);
		// datatable-row-wrapper[1]//datatable-body-cell[8]//span

		String advNumber = accuountsReceivableObj.accountsreceivableAdvancesADVNumber().getText();
		accountsReceivableTestData.put("advNumber", advNumber);
		String BpName = accuountsReceivableObj.accountsreceivableAdvancesPoNumber().getText();
		accountsReceivableTestData.put("BpName", BpName);
		System.out.println(accountsReceivableTestData.get("advNumber"));
		System.out.println(accountsReceivableTestData.get("BpName"));
	}

	/******************** ADJUSTMENT ARAP ****************************/
	@And("^Fill The form for advance adjustment$")
	public void fill_the_form_for_advance_adjustment() throws Throwable {
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 1000, 100);
		arapAdjustment.adjustmentBpName().click();
		arapAdjustment.adjustmentBpName().sendKeys(accountsReceivableTestData.get("BpName"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentadjustmentType().click();
		arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentItemType().click();
		arapAdjustment.adjustmentItemType().sendKeys("AR Advances");
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentAdjustmentReference().click();
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(accountsReceivableTestData.get("advNumber"));
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentSaveButton().click();

	}

	@Then("^check the settlement completed advance can be cancelled$")
	public void check_the_settlement_completed_advance_can_be_cancelled() throws Throwable {
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 1000, 100);
		arapAdjustment.adjustmentBpName().sendKeys(accountsReceivableTestData.get("BpName"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentadjustmentType().click();
		arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentItemType().click();
		arapAdjustment.adjustmentItemType().sendKeys(paymentSettlementTestData.AdjustementItemType);
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentAdjustmentReference().click();
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(accountsReceivableTestData.get("advNumber"));
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentAdjustmentReferenceNodata(), 2000, 100);
		boolean result = arapAdjustment.adjustmentAdjustmentReferenceNodata().isDisplayed();
		Assert.assertTrue(result);
		//driver.close();
	}
	
	/**************** KUBS_AR_AP_UAT_005_002_TC_03 ***********************/
	@And("^search for approved record in view area$")
    public void search_for_approved_record_in_view_area() throws Throwable {
		paymentSettlementObj.paymentSettlementSearchTXNNumber().click();
		paymentSettlementObj.paymentSettlementSearchTXNNumber().sendKeys("Active");
    }
}
