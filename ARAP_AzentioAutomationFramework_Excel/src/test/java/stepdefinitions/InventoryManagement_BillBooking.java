package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class InventoryManagement_BillBooking {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
//	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);

	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	Map<String, String> invoiceBooking = new HashMap<>();
	
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"BillBookingTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
	@When("^click on the eye button of invoice booking$")
	public void click_on_the_eye_button_of_invoice_booking() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
	}
	
//	@And("^Fill the required fields for bill booking$")
//	public void fill_the_required_fields_for_bill_booking() {
//		Random random = new Random();
//		javascripthelper.JavaScriptHelper(driver);
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(testData.get("EntityBranch"));
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
//
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(testData.get("InvoiceType"));
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
//
////		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType(), 15, 1);
////		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(testData.get("InvoiceSubType"));
////		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
////		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);
//
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(testData.get("BPName"));
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);
//
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(testData.get("CostCenter"));
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);
//
//		int randomNum = random.nextInt(5000 - 2500) + 2500;
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(testData.get("SupplierReferenceNumber") + randomNum);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(Keys.ENTER);
//
//		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate(), 15, 1);
//		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();
//
//	}
	
	@And("^Fill the required fields for invoice booking record$")
    public void fill_the_required_fields_for_invoice_booking_record() throws InterruptedException, IOException, ParseException  {
    	Random random = new Random();
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(testData.get("EntityBranch"));
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
    	
    	String invoicetype= testData.get("InvoiceType");
    	System.out.println(invoicetype);
		if (invoicetype.equals("Expense")) {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(testData.get("InvoiceType"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(testData.get("InvoiceSubType"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(testData.get("BPName"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(testData.get("CostCenter"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

			int randomNum=random.nextInt(5000-2500)+2500;
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(testData.get("SupplierReferenceNumber")+randomNum);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("InvoiceBillingMonth") + " "
							+ testData.get("InvoiceBillingYear") + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[contains(text(),'" + testData.get("InvoiceBillingMonth") + " " + testData.get("InvoiceBillingYear") + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("InvoiceBillingFullMonth") + " "
					+ testData.get("InvoiceBillingDate") + ", " + testData.get("InvoiceBillingYear") + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);
			
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount().sendKeys(testData.get("FlatDiscountOnInvoice"));

			String discounttype = testData.get("EarlyPaymentDiscountType");
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis().sendKeys(testData.get("EarlyPaymentDiscountPercent"));

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount().click();
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountDays().sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDate().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
						+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustment().sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);
				
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(testData.get("EarlyPaymentDiscountAmountFlat"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();
//				Thread.sleep(3000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
//						javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
						+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(testData.get("RoundingAdjustment"));
				
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		} else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(testData.get("InvoiceType"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(testData.get("BPName"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(testData.get("CostCenter"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO().sendKeys(testData.get("SupplierReferenceNumber"));

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("InvoiceBillingMonth") + " "
//							+ testData.get("InvoiceBillingYear") + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[text()='" + testData.get("InvoiceBillingMonth") + " " + testData.get("InvoiceBillingYear") + " ']"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("InvoiceBillingFullMonth") + " "
					+ testData.get("InvoiceBillingDate") + ", " + testData.get("InvoiceBillingYear") + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);
			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);

//			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO());
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO().sendKeys(testData.get("FlatDiscountOnInvoice"));
			
			String discounttype = testData.get("EarlyPaymentDiscountType");
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO().sendKeys(testData.get("EarlyPaymentDiscountPercent"));
				//flat discount amount&days method bcoz xpath is same
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(testData.get("EarlyPaymentDiscountAmount"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
						+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span")));
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
						+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(testData.get("EarlyPaymentDiscountAmount"));
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);
				
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO().sendKeys(testData.get("EarlyPaymentDiscountAmountFlat"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO().sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(Keys.ENTER);
				
				javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO());

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);
				
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO().click();
				Thread.sleep(1000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

//						waithelper.waitForElement(driver, 3000, driver.findElement(
//								By.xpath("//span[contains(text(),'" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						waithelper.waitForElementwithFluentwait(driver, driver.findElement(
								By.xpath("//span[text()='" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + " ']")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[text()='" + testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + " ']"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
						+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span")));
//				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
//				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO().sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(testData.get("Remarks"));
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		}
    	
//    	Thread.sleep(2000);
//		javascripthelper.JavaScriptHelper(driver);
//		String str = javascripthelper.executeScript(
//				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//				.toString();
//		System.out.println("Message:" + str);
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		
		for (int i = 0; i < 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
				aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 0; i < 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
				aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
//		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[text()='" +testData.get("ReferenceID")+ "']")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" +  testData.get("ReferenceID") + "']"));	
//				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[text()='";
    	String after_xpath="']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID")+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
    	
//    	Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	
    	Thread.sleep(2000);
    	String invoicetype1= testData.get("InvoiceType");
    	System.out.println(invoicetype1);
		if (invoicetype1.equals("Expense")) {
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.AdvanceNumber);
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(Keys.ENTER);
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop().click();
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().sendKeys(testData.get("InvoiceQuantity"));
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
    	while(true) {
    		try {
    			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
    			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
    			break;
    		}catch(StaleElementReferenceException se) {
    			
    		}
    	}
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().sendKeys(testData.get("RatePerUnit"));
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Currency();
    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	
    	
    	while(true) {
    		try {
    			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation());
    	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
    			break;
    		}catch(StaleElementReferenceException se) {
    			
    		}
    	}
    	while(true) {
    		try {
    			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra());
    	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra().click();
    			break;
    		}catch(StaleElementReferenceException se) {
    			
    		}
    	}
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation());;
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation().click();
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund());
    	while(true) {
    		try {
    			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund());
    			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund().click();
    			
    			break;
    		}catch(StaleElementReferenceException se) {
    			
    		}
    	}
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails().click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount().sendKeys(testData.get("TaxAmount"));
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated().sendKeys(testData.get("AmountToBeAllocated"));
    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter().click();
    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton().click();
		}
		else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(invoiceBooking.get("PONumber"));
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
	    
	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
	    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox().click();
	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton().click();
		}
    }
	
	@And("^get the approved po number from approved po record for invoice booking$")
	public void get_the_approved_po_number_from_approved_po_record_for_invoice_booking() throws Throwable {
		waithelper.waitForElementVisible(aCCOUNTSPAYABLE_InvoiceBookingObj.poCreation_ApprovedPoNumber(), 2000, 100);
		String poNumber = aCCOUNTSPAYABLE_InvoiceBookingObj.poCreation_ApprovedPoNumber().getText();
		invoiceBooking.put("PONumber", poNumber);
	}

	@Then("^Save and submit the invoice billing$")
	public void save_and_submit_the_invoice_billing() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		Thread.sleep(2000);

		javascripthelper.JavaScriptHelper(driver);

		String invoicetype2 = testData.get("InvoiceType");
		System.out.println(invoicetype2);
		if (invoicetype2.equals("Expense")) {
			String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
			System.out.println("Message:" + str);
		} else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			clicksAndActionHelper.moveToElement(recordstatus);

			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			System.out.println(message);
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		}

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(testData.get("RemarkByMaker"));

		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);

		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^log in to the reviewer account to approve invoice booking record$")
	public void log_in_to_the_reviewer_account_to_approve_invoice_booking_record() throws IOException, ParseException {
//		reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}

	@And("^approve the record by the reviewer user$")
	public void approve_the_record_by_the_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
//		String before_xpath = "//datatable-row-wrapper[";
//		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
//		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
//		Thread.sleep(1000);
//		for (int i = 1; i < 10; i++) {
//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
//			String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//
//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)));
//			driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();

		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

			waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
			waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(testData.get("ApprovedByReviewer"));
			waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			clicksAndActionHelper.moveToElement(recordstatus);
			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			System.out.println(message);
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			
		}
	

	@Then("^checker should approved the invoice billing$")
	public void checker_should_approved_the_invoice_billing() throws IOException, ParseException, InterruptedException {
//			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, driver
				.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//			+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

//			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//			+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//			driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//			.click();

//			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(testData.get("ApprovedByChecker"));
//			waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^click on first eye button to get the system invoice number$")
	public void click_on_first_eye_button_to_get_the_system_invoice_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String invoicenumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("System generated invoice number: " + invoicenumber);

	}
	
	@Then("^click on first eye button to get a System invoice number$")
	public void click_on_first_eye_button_to_get_a_system_invoice_number() throws InterruptedException {
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String systemInvoiceNo = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("GRN Number: " + systemInvoiceNo);

	}
	
	@And("^Click on claim button in checker for invoice booking record$")
	public void click_on_claim_button_in_checker_for_invoice_booking_record() throws IOException, ParseException, InterruptedException {
		// testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		// String after_xpath = ;
		// waithelper.waitForElementwithFluentwait(driver,
		// driver.findElement(By.xpath(before_xpath + reader.readReferancedata() +
		// after_xpath_claim)));
		Thread.sleep(1000);

		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();

	}
	
	///////////////////////////////////////////////////////////////////

	@Then("^select data set ID for bill booking$")
	public void select_data_set_id_for_bill_booking() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for invoice booking for reviewer$")
    public void update_data_set_id_for_invoice_booking_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^update data set ID for invoice booking for checker$")
    public void update_data_set_id_for_invoice_booking_for_checker() throws Throwable {
    	dataSetID = "KUBS_INV_MGMT_UAT_001_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

}
