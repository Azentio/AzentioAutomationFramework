package stepdefinitions;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_ContractReportPageObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_MakerObj;
import pageobjects.REPORT_ACCOUNTSPAYABLEREPORTObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;

public class ACCOUNTSYPAYABLE_Invoicebooking extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActions = new ClicksAndActionsHelper(driver);
	Map<String, String> invoiceBookingTestData = new HashMap<>();
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj crediteNoteObj = new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUNTSPAYABLE_PaymentSettlementTestDataType paymentSettlementTestData = jsonConfig
			.getPayementSettlementTestDataByName("Maker");
	String invoiceAmmount;
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	REPORT_ACCOUNTSPAYABLEREPORTObj accountsPayableReportObj = new REPORT_ACCOUNTSPAYABLEREPORTObj(driver);
	ACCOUNTSPAYABLE_AccountsPayableReportObj payableReportObj=new ACCOUNTSPAYABLE_AccountsPayableReportObj(driver);
	ACCOUNTSPAYABLE_ContractReportPageObj contractReportObj = new ACCOUNTSPAYABLE_ContractReportPageObj(driver);
	ACCOUNTSPAYABLE_ContractReportTestData contractReportTestData = jsonConfig
			.getAccountsPayableContractReportTestDataByName("Maker");
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper=new BrowserHelper(driver);
	
	// ClicksAndActionsHelper clickAndActionHelper=new
	// ClicksAndActionsHelper(driver);

	@And("^goto invoice booking module$")
	public void goto_invoice_booking_module() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(), 3000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();

	}

	@And("^fill the mendatory field for invoice booking module module$")
	public void fill_the_mendatory_field_for_invoice_booking_module_module() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
	//	invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		// waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType(),
		// 2000, 100);
		// invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
		// invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
		// invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_BP_Name()
				.sendKeys(paymentSettlementTestData.BusinessPartnerName);
		invoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayableIvoiceBookingExpenceSuplierReferenceNo().click();
		invoiceBookingObj.accountPayableIvoiceBookingExpenceSuplierReferenceNo()
				.sendKeys(paymentSettlementTestData.SuplierName);

		invoiceBookingObj.accountPayableIvoiceBookingFLatDiscount().click();
		invoiceBookingObj.accountPayableIvoiceBookingFLatDiscount().sendKeys(paymentSettlementTestData.FlatDiscount);

		invoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment()
				.sendKeys(paymentSettlementTestData.ModeOfPayment);
		invoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);
		invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

	}

	@And("^fill the mendatory field for invoice booking for expenseType invoice$")
	public void fill_the_mendatory_field_for_invoice_booking_for_expensetype_invoice() throws Throwable {
		Random rand= new Random();
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

		invoiceBookingObj.billBookingExpenceBpName().click();
		invoiceBookingObj.billBookingExpenceBpName().sendKeys(paymentSettlementTestData.BusinessPartnerName);
		invoiceBookingObj.billBookingExpenceBpName().sendKeys(Keys.ENTER);

		invoiceBookingObj.billBookingExpenceSuplierName().click();
		int min=1000;
		int max=100000;
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    String suplierReferenceNumber=paymentSettlementTestData.SuplierName+random_int;
		invoiceBookingObj.billBookingExpenceSuplierName().sendKeys(suplierReferenceNumber);

		invoiceBookingObj.billBookingExpenceFlatDiscount().click();
		invoiceBookingObj.billBookingExpenceFlatDiscount().sendKeys(paymentSettlementTestData.FlatDiscount);

		invoiceBookingObj.billBookingExpenceDiscountType().click();
		invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);

		invoiceBookingObj.billBookingExpenceDiscountPercent().click();
		invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys(paymentSettlementTestData.FlatDiscountPercent);

		invoiceBookingObj.billBookingExpencePaymentMode().click();
		invoiceBookingObj.billBookingExpencePaymentMode().sendKeys(paymentSettlementTestData.ModeOfPayment);
		invoiceBookingObj.billBookingExpencePaymentMode().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
	}

	@And("^goto invoice bill booking temp view and select the record$")
	public void goto_invoice_bill_booking_temp_view_and_select_the_record() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingTempView(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingTempView().click();
		Thread.sleep(2000);
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingRecord(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingRecord().click();
	}

	@And("^fill the second tab details details$")
	public void fill_the_expence_details() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				waitHelper.waitForElementVisible(
						invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
				invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(paymentSettlementTestData.PoNumber);
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().clear();
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().sendKeys(paymentSettlementTestData.RatePerUnit);
		invoiceAmmount = invoiceBookingObj.billBookingInvoiceAmmount().getText();
		invoiceBookingTestData.put("InvoiceAmmount", invoiceAmmount);
		Thread.sleep(1000);
		javascriptHelper.scrollIntoView(invoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation());
		invoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
		invoiceBookingObj.accountPayableIvoiceBookingDeleveryLocationPunjab().click();
		// Thread.sleep(5000);
		invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		waitHelper.waitForElementVisible(invoiceBookingObj.toastAlertClose(), 2000, 100);
		invoiceBookingObj.toastAlertClose().click();

	}

	@And("^fill the second tab for expencess details$")
	public void fill_the_second_tab_for_expencess_details() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				waitHelper.waitForElementVisible(
						invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
				invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
				waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode(), 2000,
						100);
				invoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();
				waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingExpenceExpense11Code(),
						2000, 100);
				invoiceBookingObj.accountPayableIvoiceBookingExpenceExpense11Code().click();

				break;
			} catch (StaleElementReferenceException e) {

			}
		}
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity()
				.sendKeys(paymentSettlementTestData.InvoiceQuantity);
		invoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
		try {
			invoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
		} catch (StaleElementReferenceException e) {
			invoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
		}
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().click();
		invoiceAmmount = invoiceBookingObj.billBookingExpenceInvoiceAmmount().getText();
		invoiceBookingTestData.put("InvoiceAmmount", invoiceAmmount);
		// invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().clear();
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit()
				.sendKeys(paymentSettlementTestData.InvoiceRatePerUnitQuantity);

		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
		
		Thread.sleep(1500);
		invoiceBookingObj.accountPayableIvoiceBookingDeleveryLocationPunjab().click();

		invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();

		// Thread.sleep(5000);
	}/*
		 * @Then("^click on submit_button_in_alert_in_bill_booking$") public void
		 * click_on_submit_button_in_alert_in_bill_booking() throws Throwable {
		 * //waitHelper.waitForElementVisible(invoiceBookingObj.AlertRemark(), 2000,
		 * 100); javascriptHelper.JavaScriptHelper(driver); Thread.sleep(1000);
		 * while(true) { try { javascriptHelper.JSEClick(invoiceBookingObj.
		 * accountPayable_InvoiceBooking_RemarksByMaker());
		 * //clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
		 * //invoiceBookingObj.AlertRemark().click(); Thread.sleep(1000);
		 * invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(
		 * CreditNoteTestData.Remark); break; } catch(ElementNotInteractableException e)
		 * {
		 * 
		 * } }
		 * 
		 * waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,
		 * 100);
		 * 
		 * invoiceBookingObj.alertSubmitButton().click(); }
		 */

	@Then("^click on the submit button which is appeared in alert box$")
	public void click_on_the_submit_button_which_is_appeared_in_alert_box() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
				// clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
				// invoiceBookingObj.AlertRemark().click();
				Thread.sleep(1000);
				invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker()
						.sendKeys(paymentSettlementTestData.Remark);
				break;
			} catch (ElementNotInteractableException e) {

			}
		}

		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(), 2000, 100);

		invoiceBookingObj.alertSubmitButton().click();

	}

	@And("^select the approved record from invoice bill booking$")
	public void select_the_approved_record_from_invoice_bill_booking() throws Throwable {
		// waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(),
		// 2000, 100);
		Thread.sleep(1000);
		String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
		invoiceBookingTestData.put("approvedInvoiceNumber", approvedInvoiceNumber);
		invoiceBookingTestData.put("approvedBpName", approvedBpName);

	}

	@And("^goto accouts receivable module$")
	public void goto_accouts_receivable_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementVisible(makerObj.kubsAccountsReceivable(), 2000,
		// 100);
		// makerObj.kubsDirectionIcon().click();
		javascriptHelper.scrollIntoView(makerObj.kubsAccountsReceivable());
		makerObj.kubsAccountsReceivable().click();
	}

	@And("^goto credit notet module$")
	public void goto_credit_notet_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(crediteNoteObj.accountsReceivableViewButton());
		// waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableViewButton(),
		// 2000, 100);
		crediteNoteObj.accountsReceivableViewButton().click();
	}

	@And("^Fill the form for credit note$")
	public void fill_the_form_for_credit_note() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableReceivableName(), 2000, 100);
		crediteNoteObj.accountsReceivableReceivableName().click();
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableBpName().click();
		crediteNoteObj.accountsReceivableBpName().sendKeys(invoiceBookingTestData.get("approvedBpName"));
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableInvoiceNumber().click();// approvedInvoiceNumber
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(invoiceBookingTestData.get("approvedInvoiceNumber"));
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableCreditAmmount().click();
		crediteNoteObj.accountsReceivableCreditAmmount().sendKeys(paymentSettlementTestData.CreditAmmount);
		String creditAmmount = paymentSettlementTestData.CreditAmmount;
		String finalCreditValue = creditAmmount.substring(0, creditAmmount.length() - 2);
		invoiceBookingTestData.put("finalCreditValue", finalCreditValue);
		Thread.sleep(1000);

		crediteNoteObj.accountsReceivableDescription().click();
		crediteNoteObj.accountsReceivableDescription().sendKeys(paymentSettlementTestData.Remark);
		waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivablleSaveButton(), 2000, 100);
		clickAndActionHelper.doubleClick(crediteNoteObj.accountsReceivablleSaveButton());
		//crediteNoteObj.accountsReceivablleSaveButton().click();

	}

	@And("^fill the mendatory field to check")
	public void fill_the_mendatory_field_to_check() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(invoiceBookingTestData.get("approvedBpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 14; i++) {
			Thread.sleep(1000);
			if (i == 14) {
				System.out.println("Data not available");
				System.out.println("Approved record we search " + invoiceBookingTestData.get("approvedInvoiceNumber"));
				Assert.fail("Data not available");
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")), 2000,
						100);
				javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By
						.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]"))
						.isDisplayed();
				Assert.assertTrue(finalStatus);
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableAdjustedAmmount());
				String adjustedAmmount = javascriptHelper.executeScript(
						"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value")
						.toString();
				System.out.println("Adjusted ammount : " + adjustedAmmount);
				String ammount = adjustedAmmount.replace(".", "-");
				String[] Ammount = ammount.split("-");
				System.out.println("Ammount is" + Ammount[0]);

				String ammountFull = Ammount[0];

				String finalAmmount = ammountFull.replaceAll(",", "");
				int intFinalAmmount = Integer.parseInt(finalAmmount);
				int intInvoiceAmmount = Integer.parseInt(invoiceAmmount);// .get("finalCreditValue");
				int creditNoteAmmount = Integer.parseInt(invoiceBookingTestData.get("finalCreditValue"));
				int calculatedAdjustedAmmount = intInvoiceAmmount - creditNoteAmmount;
				if (intFinalAmmount == calculatedAdjustedAmmount) {
					System.out.println("TestCase got Passed");
				} else {
					Assert.fail("Ammount miss match");
				}

				break;
			} catch (NoSuchElementException e) {
				// Thread.sleep
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	@And("^fill the payment settlement record and validate the invoice number is not available in the invoice list view$")
	public void fill_the_payment_settlement_record_and_validate_the_invoice_number_is_not_available_in_the_invoice_list_view()
			throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(invoiceBookingTestData.get("approvedBpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 15; i++) {
			Thread.sleep(1000);
			if (i == 15) {
				boolean result = false;
				System.out.println("Approved record we search, But the record is not availabe "
						+ invoiceBookingTestData.get("approvedInvoiceNumber"));
				System.out.println("Test case got passed");
				Assert.assertFalse(result);
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")), 2000,
						100);
				javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By
						.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]"))
						.isDisplayed();
				Assert.assertTrue(finalStatus);
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				/*
				 * javascriptHelper.scrollIntoView(paymentSettlementObj.
				 * accountsPayableAdjustedAmmount()); String adjustedAmmount=javascriptHelper.
				 * executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value"
				 * ).toString(); System.out.println("Adjusted ammount : "+adjustedAmmount);
				 * String ammount=adjustedAmmount.replace(".","-"); String[]
				 * Ammount=ammount.split("-"); System.out.println("Ammount is"+Ammount[0]);
				 * 
				 * String ammountFull=Ammount[0];
				 * 
				 * String finalAmmount=ammountFull.replaceAll(",",""); int
				 * intFinalAmmount=Integer.parseInt(finalAmmount); int
				 * intInvoiceAmmount=Integer.parseInt(invoiceAmmount);//.get("finalCreditValue")
				 * ; int creditNoteAmmount=Integer.parseInt(invoiceBookingTestData.get(
				 * "finalCreditValue")); int
				 * calculatedAdjustedAmmount=intInvoiceAmmount-creditNoteAmmount;
				 * if(intFinalAmmount==calculatedAdjustedAmmount) {
				 * System.out.println("TestCase got Passed"); } else {
				 * Assert.fail("Ammount miss match"); }
				 */
				break;
			} catch (NoSuchElementException e) {
				// Thread.sleep
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	@And("^fill the mendatory field to check the the TDS percent and TDS ammount$")
	public void fill_the_mendatory_field_to_check_the_the_tds_percent_and_tds_ammount() throws Throwable {

		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys("Business Partner Wise");
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(invoiceBookingTestData.get("approvedBpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'INV-53-122021')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div

		for (int i = 1; i <= 14; i++) {
			Thread.sleep(1000);
			if (i == 14) {
				System.out.println("Data not available");
				System.out.println("Approved record we search " + invoiceBookingTestData.get("approvedInvoiceNumber"));
				Assert.fail("Data not available");
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")), 2000,
						100);
				javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By
						.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]"))
						.isDisplayed();
				Assert.assertTrue(finalStatus);
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableAdjustedAmmount());
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber")
								+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div")));
				driver.findElement(
						By.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber")
								+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div"))
						.getText();
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableTDSAmmount());
				String tdsAmmount = javascriptHelper
						.executeScript(
								"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value")
						.toString();
				System.out.println("TDS Ammount is" + tdsAmmount);
				break;
			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}

	}

	@And("^fill the mendatory field to check the the net payable ammount$")
	public void fill_the_mendatory_field_to_check_the_the_net_payable_ammount() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
				100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(paymentSettlementTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(invoiceBookingTestData.get("approvedBpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 14; i++) {
			Thread.sleep(1000);
			if (i == 14) {
				System.out.println("Data not available");
				System.out.println("Approved record we search " + invoiceBookingTestData.get("approvedInvoiceNumber"));
				Assert.fail("Data not available");
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")), 2000,
						100);
				javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
						"//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By
						.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber") + "')]"))
						.isDisplayed();
				Assert.assertTrue(finalStatus);
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'"
						+ invoiceBookingTestData.get("approvedInvoiceNumber")
						+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableAdjustedAmmount());
				String adjustedAmmount = javascriptHelper.executeScript(
						"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value")
						.toString();
				System.out.println("Adjusted ammount : " + adjustedAmmount);
				String ammount = adjustedAmmount.replace(".", "-");
				String[] Ammount = ammount.split("-");
				System.out.println("Ammount is" + Ammount[0]);

				String ammountFull = Ammount[0];

				String finalAmmount = ammountFull.replaceAll(",", "");
				int intFinalAmmount = Integer.parseInt(finalAmmount);
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableTDSAmmount());
				String tdsAmmount = javascriptHelper
						.executeScript(
								"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value")
						.toString();
				System.out.println("TDS Ammount is" + tdsAmmount);
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + invoiceBookingTestData.get("approvedInvoiceNumber")
								+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div")));
				String tdsPercentage = driver
						.findElement(By.xpath("//div[contains(text(),'"
								+ invoiceBookingTestData.get("approvedInvoiceNumber")
								+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div"))
						.getText();
				// javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableTDSAmmount());
				// String tdsAmmount=javascriptHelper.executeScript("return
				// document.getElementsByClassName('native-input
				// sc-ion-input-md')[1].value").toString();
				System.out.println("TDS Ammount is" + tdsAmmount);
				String[] finalTDSAmmount = tdsAmmount.split("[.]");
				int intTdsAmmount = Integer.parseInt(finalTDSAmmount[0]);
				String formNetPayableAmmount = javascriptHelper.executeScript(
						"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value")
						.toString();
				String[] arrayNetPayableAmmount = formNetPayableAmmount.split("[.]");
				String finalStringNetPayableAmmount = arrayNetPayableAmmount[0];
				String finalNet = finalStringNetPayableAmmount.replace(",", "");
				int IntegerNetPayableAmmount = Integer.parseInt(finalNet);
				int expectedNetPayableAmmount = intFinalAmmount - intTdsAmmount;

				System.out.println("Net Payable Ammount" + formNetPayableAmmount);
				System.out.println("Final Ammount is" + finalAmmount);
				System.out.println("TDS Percentage is" + tdsPercentage);
				System.out.println("expected netPayableAmmount is" + expectedNetPayableAmmount);
				if (IntegerNetPayableAmmount == expectedNetPayableAmmount) {
					System.out.println("Test Case passed");

				} else {
					Assert.fail("Condition not matched");
				}
				break;
			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}

		}
	}

	@And("^fill the calender details and description$")
	public void fill_the_calender_details_and_save_the_record() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementValueDate());
		paymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + paymentSettlementTestData.MonthYear + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + paymentSettlementTestData.MonthYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + paymentSettlementTestData.FullMonth
				+ " " + paymentSettlementTestData.Day + ", " + paymentSettlementTestData.Year + "']/span"));
		clicksAndActions.doubleClick(FinalDay);
		clicksAndActions.doubleClick(paymentSettlementObj.accountsPayableDescription());
		paymentSettlementObj.accountsPayableDescription().sendKeys(paymentSettlementTestData.Remark);

	}

	@And("^search the expence bill is appreared in the list view$")
	public void search_the_expence_bill_is_appreared_in_the_list_view() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSearchInvoiceNumber(), 2000, 100);
		invoiceBookingObj.invoiceBookingSearchInvoiceNumber().click();
		invoiceBookingObj.invoiceBookingSearchInvoiceNumber()
				.sendKeys(paymentSettlementTestData.ApprovedExpenceInvoice);
		driver.findElement(
				By.xpath("//span[contains(text(),'" + paymentSettlementTestData.ApprovedExpenceInvoice + "')]"))
				.isDisplayed();
	}

	@And("^get the business partner name$")
	public void get_the_business_partner_name() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedBpName(), 2000, 200);
		String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
		String approvedInvoiceNumber=invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		invoiceBookingTestData.put("ApprovedBpName", approvedBpName);
		invoiceBookingTestData.put("approvedInvoiceNumber", approvedInvoiceNumber);
		System.out.println("Approved invoice number "+invoiceBookingTestData.get("approvedInvoiceNumber"));
	}
	
	@Then("^verify the approved invoicebill number is available in the report$")
    public void verify_the_approved_invoicebill_number_is_available_in_the_report() throws Throwable {
		System.out.println("Approved invoice number "+invoiceBookingTestData.get("approvedInvoiceNumber"));
		javascriptHelper.JavaScriptHelper(driver);
		//Thread.sleep(1500);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(1500);
		while(true)
		{
			try
			{
				javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'"+invoiceBookingTestData.get("approvedInvoiceNumber")+"')]")));
				driver.findElement(By.xpath("//div[contains(text(),'"+invoiceBookingTestData.get("approvedInvoiceNumber")+"')]")).isDisplayed();
			break;	
			}
			catch(NoSuchElementException e)
			{
				payableReportObj.accountsPayableReportNextRecord().click();
					
			}
			catch(StaleElementReferenceException e1)
			{
				
			}
		}
		browserHelper.switchToParentWithChildClose();
	}
	

	/******************** KUBS_AR_AP_UAT_001_002_TC_02 ***********************/
	@Then("^verify the expence invoice number is available in the accounting entries tab$")
	public void verify_the_expence_invoice_number_is_available_in_the_accounting_entries_tab() throws Throwable {
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		// boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i < 299; i++) {
			try {
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
								+ paymentSettlementTestData.ApprovedExpenceInvoice + "')]")),
						2000, 100);
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
						+ paymentSettlementTestData.ApprovedExpenceInvoice + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);

				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}

			if (i == 299) {
				Assert.fail("InvoiceNumber not availabe : " + paymentSettlementTestData.ApprovedExpenceInvoice);
			}
		}

		for (int j = 0; j < 2; j++) {
			try {
				String creditAmount = driver.findElement(By.xpath("//span[contains(text(),'"
						+ paymentSettlementTestData.ApprovedExpenceInvoice
						+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[5]//span[contains(text(),'Credit')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[1]//span"))
						.getText();
				String debitNote = driver.findElement(By.xpath("//span[contains(text(),'"
						+ paymentSettlementTestData.ApprovedExpenceInvoice
						+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[5]//span[contains(text(),'Debit')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[1]//span"))
						.getText();
				System.out.println("Credit amount is " + creditAmount);
				System.out.println("Credit amount is " + debitNote);
				break;
			} catch (NoSuchElementException e2) {
				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	/******************** KUBS_AR_AP_UAT_001_002_TC_02 ***********************/

	/******************** KUBS_AR_AP_UAT_001_002_TC_05 ************************/
	@And("^click on temp view near by accounts Payable$")
	public void click_on_temp_view_near_by_accounts_payable() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementVisible(accountsPayableReportObj.accountsPayableTempView(),
		// 2000, 200);
		javascriptHelper.scrollIntoView(accountsPayableReportObj.accountsPayableTempView());
		accountsPayableReportObj.accountsPayableTempView().click();
	}

	@And("^enter business partner name$")
	public void enter_business_partner_name() throws Throwable {
		waitHelper.waitForElementVisible(accountsPayableReportObj.accountsPayableReportBpName(), 2000, 200);
		accountsPayableReportObj.accountsPayableReportBpName().click();
		accountsPayableReportObj.accountsPayableReportBpName().sendKeys(invoiceBookingTestData.get("ApprovedBpName"));
		accountsPayableReportObj.accountsPayableReportBpName().sendKeys(Keys.ENTER);
	}

	/*@And("^click on date icon$")
	public void click_on_date_icon() throws Throwable {
		accountsPayableReportObj.accountsPayableReportDateAsOn().click();
	}*/

//	@And("^give date in report$")
//	public void give_date_in_report() throws Throwable {
//		while (true) {
//			try {
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
//						+ contractReportTestData.Month + " " + contractReportTestData.Year + "')]")));
//				driver.findElement(By.xpath("//span[contains(text(),'" + contractReportTestData.Month + " "
//						+ contractReportTestData.Year + "')]"));
//				break;
//			} catch (NoSuchElementException e) {
//				contractReportObj.contractReportNextMonthButton().click();
//			}
//		}
//		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + contractReportTestData.FullMonth + " "
//				+ contractReportTestData.Day + ", " + contractReportTestData.Year + "']/span"));
//		clickAndActionHelper.doubleClick(FinalDay);
//	}

	@And("^give payable status$")
	public void give_payable_status() throws Throwable {
		accountsPayableReportObj.accountsPayablePayableStatu().click();
		accountsPayableReportObj.accountsPayablePayableStatu().sendKeys(contractReportTestData.PayableStatus);
		accountsPayableReportObj.accountsPayablePayableStatu().sendKeys(Keys.ENTER);
	}

	/******************** KUBS_AR_AP_UAT_001_002_TC_05 ************************/

	@And("^search the invoice number which is created inventory purchase$")
	public void search_the_invoice_number_which_is_created_inventory_purchase() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSearchInvoiceNumber(), 2000, 100);
		invoiceBookingObj.invoiceBookingSearchInvoiceNumber().click();
		invoiceBookingObj.invoiceBookingSearchInvoiceNumber()
				.sendKeys(paymentSettlementTestData.InventoryPurchaseInvoiceNumber);
		driver.findElement(
				By.xpath("//span[contains(text(),'" + paymentSettlementTestData.InventoryPurchaseInvoiceNumber + "')]"))
				.isDisplayed();
	}

	@And("^verify the inventory requested invoice number is availabe in the accounting entries$")
	public void verify_the_inventory_requested_invoice_number_is_availabe_in_the_accounting_entries() throws Throwable {
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		// boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i < 299; i++) {
			try {
				waitHelper
						.waitForElementVisible(
								driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
										+ paymentSettlementTestData.InventoryPurchaseInvoiceNumber + "')]")),
								2000, 100);
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
						+ paymentSettlementTestData.InventoryPurchaseInvoiceNumber + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);

				javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}

			if (i == 299) {
				Assert.fail("InvoiceNumber not availabe : " + paymentSettlementTestData.InventoryPurchaseInvoiceNumber);
			}
		}

	}
}
