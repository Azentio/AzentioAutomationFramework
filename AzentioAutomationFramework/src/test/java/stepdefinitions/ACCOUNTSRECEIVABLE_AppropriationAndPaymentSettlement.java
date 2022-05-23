package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSRECEIVABLE_AppropriationObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;

public class ACCOUNTSRECEIVABLE_AppropriationAndPaymentSettlement extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_InvoiceBookingObj invoicebookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	AccountsReceivable_DebitNoteObj debitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSRECEIVABLE_AppropriationObj appropriationObj = new ACCOUNTSRECEIVABLE_AppropriationObj(driver);
	Map<String, String> testData = new HashMap<>();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);

	@And("^search the invoice agaist po in invoice type area$")
	public void search_the_invoice_agaist_po_in_invoice_type_area() throws Throwable {
		waitHelper.waitForElementVisible(invoicebookingObj.invoiceBookingSearchInvoiceType(), 3000, 300);
		invoicebookingObj.invoiceBookingSearchInvoiceType().click();
		invoicebookingObj.invoiceBookingSearchInvoiceType().sendKeys("Invoice Against PO");
	}

	@And("^get the approved invoice reference to do debit note$")
	public void get_the_approved_invoice_reference_to_do_debit_note() throws Throwable {
		Thread.sleep(1500);
		waitHelper.waitForElementVisible(invoicebookingObj.billBookingApprovedInvoiceNumber(), 3000, 300);
		testData.put("approvedInvoiceReferenceNumber", invoicebookingObj.billBookingApprovedInvoiceNumber().getText());
		testData.put("approvedBpName", invoicebookingObj.billBookingApprovedBpName().getText());
		System.out.println("Approved Invoice Reference number "+testData.get("approvedInvoiceReferenceNumber")+" ApprovedBp name "+testData.get("approvedBpName"));
	}

	@And("^click on debit note module$")
	public void click_on_debit_note_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		//waitHelper.waitForElementVisible(debitNoteObj.accountsReceivable_DebitNote_EyeButton(), 3000, 300);
		javascriptHelper.scrollIntoViewAndClick(debitNoteObj.accountsReceivable_DebitNote_EyeButton());
	}

	@And("^fill the debit note details against that bill$")
	public void fill_the_debit_note_details_against_that_bill() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		debitNoteObj.accountsReceivable_DebitNote_ReceivableName().click();
		debitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys(Keys.DOWN);
		debitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys(Keys.ENTER);

		debitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(testData.get("approvedBpName"));
		debitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(Keys.ENTER);

		debitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().click();
		debitNoteObj.accountsReceivable_DebitNote_InvoiceNumber()
				.sendKeys(testData.get("approvedInvoiceReferenceNumber"));
		debitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().sendKeys(Keys.ENTER);

		debitNoteObj.accountsReceivableCostCenter().click();
		Thread.sleep(1000);
		debitNoteObj.accountsReceivableCostCenter().sendKeys(Keys.ENTER);
		javascriptHelper.scrollIntoViewAndClick(debitNoteObj.accountsReceivable_DebitNote_Description());
		//debitNoteObj.accountsReceivable_DebitNote_Description().click();
		debitNoteObj.accountsReceivable_DebitNote_Description().sendKeys("Debit note");

	}

	@And("^save the debit note record$")
	public void save_the_debit_note_record() throws Throwable {
		waitHelper.waitForElementVisible(debitNoteObj.accountsReceivable_DebitNote_SaveButton(), 3000, 300);
		debitNoteObj.accountsReceivable_DebitNote_SaveButton().click();

	}

	@And("^get the recently we approved debit note reference number$")
	public void get_the_recently_we_approved_debit_note_reference_number() throws Throwable {
		waitHelper.waitForElementVisible(debitNoteObj.accountsReceivableDebitNoteApprovedReferenceNumber(), 3000, 300);
		testData.put("ApprovedDebitNote", debitNoteObj.accountsReceivableDebitNoteApprovedReferenceNumber().getText());
	}
	@And("^goto accouts Receivable module to do debit note$")
    public void goto_accouts_receivable_module_to_do_debit_note() throws Throwable {
		Thread.sleep(1000);
     javascriptHelper.JavaScriptHelper(driver);
     javascriptHelper.scrollIntoView(kubsMakerObj.kubsAccountsReceivable());
     javascriptHelper.scrollToElemetAndClick(kubsMakerObj.kubsAccountsReceivable());
     
    }

	@And("^do the appropriation for the debit note record$")
	public void do_the_appropriation_for_the_debit_note_record() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(appropriationObj.accountsReceivableAppropriationReceiptReferenceNumber(), 3000,
				300);
		//REC_221_2742022
		appropriationObj.accountsReceivableAppropriationReceiptReferenceNumber().sendKeys("REC_221_2742022");
		appropriationObj.accountsReceivableAppropriationReceiptReferenceNumber().sendKeys(Keys.DOWN);
		appropriationObj.accountsReceivableAppropriationReceiptReferenceNumber().sendKeys(Keys.ENTER);
		while (true) {
			try {

				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedDebitNote") + "')]"));
				String ammount = driver
						.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedDebitNote")
								+ "')]//ancestor::datatable-body-cell/following-sibling::datatable-body-cell[1]//div"))
						.getText();
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedDebitNote")
						+ "')]//ancestor::datatable-body-cell/following-sibling::datatable-body-cell[2]//input"))
						.click();
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedDebitNote")
						+ "')]//ancestor::datatable-body-cell/following-sibling::datatable-body-cell[2]//input"))
						.sendKeys(ammount);
				break;
			} catch (NoSuchElementException e) {
				javascriptHelper.scrollIntoViewAndClick(appropriationObj.accontsReceivableNextButton());
			}

		}
	}

	@And("^save the appropriation record$")
	public void save_the_appropriation_record() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(appropriationObj.appropriationSaveButton(), 3000, 300);
		javascriptHelper.scrollIntoViewAndClick(appropriationObj.appropriationSaveButton());
//appropriationObj.appropriationSaveButton().click();
	}
//	@And("^fill the details to check the aprropriation against bill is visible in the payment settlement or not$")
//    public void fill_the_details_to_check_the_aprropriation_against_bill_is_visible_in_the_payment_settlement_or_not() throws Throwable {
//		javascriptHelper.JavaScriptHelper(driver);
//		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 3000, 300);
//		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
//		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.DOWN);
//		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
//
//		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
//		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(testData.get("approvedBpName"));
//		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
//		for(int i=0;i<=15;i++)
//		{
//			if(i>=15)
//			{
//				System.out.println("Asset reference number not available in payment settlement screen,And the Asset reference number is : "+paymentSettlementObj);
//			break;
//			}
//		try
//		{
//		driver.findElement(By.xpath("//div[contains(text(),"+testData.get("approvedInvoiceReferenceNumber")+")]"));
//		break;
//		}
//		catch(NoSuchElementException e)
//		{
//			javascriptHelper.scrollIntoViewAndClick(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());	
//		}
//		}
//	}
	
	@And("^check the aprropriation against bill is visible in the payment settlement or not in payment settlement module$")
    public void check_the_aprropriation_against_bill_is_visible_in_the_payment_settlement_or_not_in_payment_settlement_module() throws Throwable {
		
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 3000, 300);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.DOWN);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);

		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(testData.get("approvedBpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
Thread.sleep(3000);
		for(int i=0;i<=15;i++)
		{
			if(i>=15)
			{
				System.out.println("Asset reference number not available in payment settlement screen,And the Asset reference number is : "+paymentSettlementObj);
			break;
			}
		try
		{
		driver.findElement(By.xpath("//div[contains(text(),"+testData.get("approvedInvoiceReferenceNumber")+")]"));
		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoViewAndClick(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());	
		}
		}
    }

}
