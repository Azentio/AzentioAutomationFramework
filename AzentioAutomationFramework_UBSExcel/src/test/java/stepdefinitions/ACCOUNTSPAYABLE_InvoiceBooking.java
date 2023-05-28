package stepdefinitions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class ACCOUNTSPAYABLE_InvoiceBooking {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "BillBookingTestData", "Data Set ID");
	ExcelData excelDataForAssetCreation = new ExcelData(path, "FixedAsset_AssetCreation", "DataSet ID");
	ExcelData excelDataForAssetConfig = new ExcelData(path, "AssetConfig_ExecutionTrack", "DataSet ID");
	KUBS_CommonWebElements kubsCommonWebObj = new KUBS_CommonWebElements(driver);
	private Map<String, String> testData;
	Map<String, String> dataSetID= new HashMap<>();

//--------    @KUBS_INV_MGMT_UAT_001_005  ------------

	@When("^click on eye button of invoice booking$")
	public void click_on_eye_button_of_invoice_booking() {
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
	}

	@When("^click on temp grid button of invoice booking$")
	public void click_on_temp_grid_button_of_invoice_booking() {
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton().click();
	}

	@And("^click on add button for invoice booking$")
	public void click_on_add_button_for_invoice_booking() {
		for (int i = 0; i <= 500; i++) {
			try {
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^Fill the required fields for invoice booking$")
	public void fill_the_required_fields_for_invoice_booking()
			throws InterruptedException, IOException, ParseException {
		Random random = new Random();
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch()
				.sendKeys(testData.get("EntityBranch"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
		String invoicetype = testData.get("InvoiceType");

		System.out.println(invoicetype);
		if (invoicetype.equals("Expense")) {
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType()
					.sendKeys(testData.get("InvoiceType"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType()
					.sendKeys(testData.get("InvoiceSubType"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(testData.get("BP_Name"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter()
					.sendKeys(testData.get("CostCenter"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

			int randomNum = random.nextInt(5000 - 2500) + 2500;
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber()
					.sendKeys(testData.get("SupplierReferenceNumber") + randomNum);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);

			waithelper.waitForElement(driver, 3000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount()
					.sendKeys(testData.get("FlatDiscountOnInvoice"));

			String discounttype = testData.get("EarlyPaymentDiscountType");
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType()
						.sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis()
						.sendKeys(testData.get("EarlyPaymentDiscountPercent "));

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount().click();
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountDays()
						.sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment()
						.sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency()
						.sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency()
						.sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDate().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000,
								aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver
						.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustment()
						.sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks()
						.sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType()
						.sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount()
						.sendKeys(testData.get("EarlyPaymentDiscountAmountFlat"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays()
						.sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat()
						.sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat()
						.sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat()
						.sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();
//				Thread.sleep(3000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
//						javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						waithelper.waitForElement(driver, 3000,
								aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver
						.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
				waithelper.waitForElementwithFluentwait(driver,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat()
						.sendKeys(testData.get("RoundingAdjustment"));

				javascripthelper.scrollIntoViewAndClick(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks()
						.sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		} else {
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType()
					.sendKeys(testData.get("InvoiceTypeSearch"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO()
					.sendKeys(testData.get("BP_Name"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO()
					.sendKeys(testData.get("CostCenter"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO()
					.sendKeys(testData.get("SupplierReferenceNumber"));

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
							+ testData.get("InvoiceBillingMonth") + " " + testData.get("InvoiceBillingYear") + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
							+ testData.get("InvoiceBillingMonth") + " " + testData.get("InvoiceBillingYear") + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000,
							aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='"
					+ testData.get("InvoiceBillingFullMonth") + " " + testData.get("InvoiceBillingDate") + ", "
					+ testData.get("InvoiceBillingYear") + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);

			waithelper.waitForElement(driver, 3000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO()
					.sendKeys(testData.get("FlatDiscountOnInvoice"));

			String discounttype = testData.get("EarlyPaymentDiscountType");
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
						.sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO()
						.sendKeys(testData.get("EarlyPaymentDiscountPercent"));
				// flat discount amount&days method bcoz xpath is same
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount()
						.sendKeys(testData.get("EarlyPaymentDiscountAmount"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays()
						.sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat()
						.sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat()
						.sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat()
						.sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000,
								aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span")));
				WebElement paymentDate = driver
						.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat()
						.sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks()
						.sendKeys(testData.get("Remarks"));
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount()
						.sendKeys(testData.get("FlatDiscountOnInvoice"));
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
						.sendKeys(testData.get("EarlyPaymentDiscountType"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO()
						.sendKeys(testData.get("EarlyPaymentDiscountAmount"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO()
						.sendKeys(testData.get("EarlyPaymentDiscountDays"));

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO()
						.sendKeys(testData.get("ModeOfPayment"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO()
						.sendKeys(testData.get("InvoiceCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO()
						.sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj
						.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO()
						.sendKeys(testData.get("InvoicePaymentCurrency"));
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO()
						.sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO().click();
				Thread.sleep(2000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("PaymentMonth") + " " + testData.get("PaymentYear") + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000,
								aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span")));
				WebElement paymentDate = driver
						.findElement(By.xpath("//td[@aria-label='" + testData.get("PaymentFullMonth") + " "
								+ testData.get("PaymentDate") + ", " + testData.get("PaymentYear") + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span")));
//				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
//				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO()
						.sendKeys(testData.get("RoundingAdjustment"));
				javascripthelper.scrollIntoViewAndClick(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys("Remarks");
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		}

		for (int i = 0; i <= 500; i++) {
			try {
				javascripthelper.JSEClick(
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
				break;

			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		excelData.updateTestData("KUBS_FAT_UAT_001_005_02_D1", "C", id);
		System.out.println("Reference ID:" + id);
//    	for (int i = 1; i <= 35; i++) {
//			try {
//		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
//				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
//				waithelper.waitForElement(driver, i, referanceID);
//				referanceID.click();
//		    	System.out.println(referanceID);
////				Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
//				}
//		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

//    	Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();

		Thread.sleep(2000);
		String invoicetype1 = testData.get("InvoiceType");
		System.out.println(invoicetype1);
		if (invoicetype1.equals("Expense")) {
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.AdvanceNumber);
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(Keys.ENTER);
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop().click();

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity()
					.sendKeys(testData.get("InvoiceQuantity"));

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
			while (true) {
				try {
					waithelper.waitForElementwithFluentwait(driver,
							aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
					break;
				} catch (StaleElementReferenceException se) {

				}
			}

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit()
					.sendKeys(testData.get("RatePerUnit"));

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Currency();
			javascripthelper
					.scrollIntoView(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());

			while (true) {
				try {
					waithelper.waitForElement(driver, 2000,
							aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation());
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
					break;
				} catch (StaleElementReferenceException se) {

				}
			}
			while (true) {
				try {
					waithelper.waitForElement(driver, 2000,
							aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra());
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra().click();
					break;
				} catch (StaleElementReferenceException se) {

				}
			}
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation());
			;
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation().click();
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund());
			while (true) {
				try {
					waithelper.waitForElementwithFluentwait(driver,
							aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund());
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund().click();

					break;
				} catch (StaleElementReferenceException se) {

				}
			}
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails().click();
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount()
					.sendKeys(testData.get("TaxAmount"));

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton().click();

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton().click();

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail().click();

			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance().click();

			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated()
					.sendKeys(testData.get("AmountToBeAllocated"));

//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter().click();

//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton().click();
		} else {
			waithelper.waitForElement(driver, 2000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber()
					.sendKeys(testData.get("PONumber"));
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 3000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox().click();
			waithelper.waitForElement(driver, 3000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton().click();
		}
	}

	@Then("^Save and submit the invoice billing$")
	public void save_and_submit_the_invoice_billing() throws IOException, ParseException, InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
//		waithelper.waitForElement(driver, 2000,
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
//		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
//		System.out.println("Reference ID:" + id);
//		for (int i = 1; i <= 35; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000, driver
//						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
//				WebElement referanceID = driver
//						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
//				waithelper.waitForElement(driver, i, referanceID);
//				referanceID.click();
//				System.out.println(referanceID);
////				Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver, 4000,
//						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
//			}
//		}
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayableInvoiceBookingFirstReferenceId(), 20, 1);
		String referenceNumber = aCCOUNTSPAYABLE_VendorContractsObj.accountPayableInvoiceBookingFirstReferenceId()
				.getText();
		System.out.println("Reference number is " + referenceNumber);
		excelData.updateTestData(testData.get("Data Set ID"), "Reference ID", referenceNumber);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayableInvoiceBookingFirstRecord(), 20, 1);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayableInvoiceBookingFirstRecord().click();
		for (int i = 0; i <= 500; i++) {
			try {
				javascripthelper
						.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
				clicksAndActionHelper.clickOnElement(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys("ok");
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

		waithelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
		excelData.updateTestData(testData.get("Data Set ID"), "Reviewer ID", reviewerId);
	}

	@And("^approve the record by the reviewer user$")
	public void approve_the_record_by_the_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
			// waithelper.waitForElement(driver, 10000,
			// driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			for (int j = 0; j < 30; j++) {
				try {
					String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					break;
				} catch (Exception e) {

				}
			}

			waithelper.waitForElement(driver, 10000,
					driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();

			// reader.addReferanceData(referance_id);

			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark()
					.sendKeys(testData.get("ApprovedByReviewer"));
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			clicksAndActionHelper.moveToElement(recordstatus);
			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			System.out.println(message);
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			break;
		}
	}

	@Then("^checker should approved the invoice billing$")
	public void checker_should_approved_the_invoice_billing() throws IOException, ParseException, InterruptedException {
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				+ jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

//		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();

//		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		waithelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark()
				.sendKeys(testData.get("ApprovedByChecker"));
//		waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^click on first eye button to get the system invoice number$")
	public void click_on_first_eye_button_to_get_the_system_invoice_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String invoicenumber = javascripthelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value")
				.toString();
		System.out.println("System generated invoice number: " + invoicenumber);

	}

	@Then("^click on first eye button to get the system invoice number to check$")
	public void click_on_first_eye_button_to_get_the_system_invoice_number_to_check()
			throws InterruptedException, IOException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();

	}

	@And("^update the invoice number in asset creation excel database$")
	public void update_the_invoice_number_in_asset_creation_excel_database() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.invoiceBookingApprovedInvoiceReferenceNumber(), 60, 1);
		String invoiceNumber = aCCOUNTSPAYABLE_InvoiceBookingObj.invoiceBookingApprovedInvoiceReferenceNumber()
				.getText();
		System.out.println("Invoice Number Is " + invoiceNumber);
		/*
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_006_D1",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D1",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D2",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D3",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D4",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D5",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D6",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D7",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D8",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D9",
		 * invoiceNumber, invoiceNumber);
		 * excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D10",
		 * invoiceNumber, invoiceNumber);
		 */
	}

	@And("^choose the invoice type as invoice against po$")
	public void choose_the_invoice_type_as_invoice_against_po() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType()
				.sendKeys(testData.get("InvoiceType"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

	}

	@And("^choose the business partner name in invoice booking screen$")
	public void choose_the_business_partner_name_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoBpName(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoBpName().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoBpName().sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoBpName().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoBpName().sendKeys(Keys.ENTER);
	}

	@And("^choose the cost center in invoice booking screen$")
	public void choose_the_cost_center_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO()
				.sendKeys(testData.get("CostCenter"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.ENTER);
	}

	@And("^enter the suplier reference number in invoice booking screen$")
	public void enter_the_suplier_reference_number_in_invoice_booking_screen() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(5000 - 2500) + 2500;
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO(), 20,
				1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO()
				.sendKeys(testData.get("CostCenter") + randomNum);
	}

	@And("^enter the flat discount on in invoice booing screen$")
	public void enter_the_flat_discount_on_in_invoice_booing_screen() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO()
				.sendKeys(testData.get("FlatDiscountOnInvoice"));

	}

	@And("^choose the early payment discount type in invoice booking screen$")
	public void choose_the_early_payment_discount_type_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO(), 20,
				1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
				.sendKeys(testData.get("EarlyPaymentDiscountType"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
				.sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO()
				.sendKeys(Keys.ENTER);
	}

	@And("^enter the early payment discount amount in invoice booking screen$")
	public void enter_the_early_payment_discount_amount_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj
				.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO()
				.click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO()
				.sendKeys(testData.get("FlatDiscountOnInvoice"));

	}

	@And("^enter the mode of payment in invoice booking screen$")
	public void enter_the_mode_of_payment_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoPaymentMode(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoPaymentMode().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoPaymentMode().sendKeys(testData.get("ModeOfPayment"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.ENTER);
	}

	@And("^save the invoice Against Po first screen$")
	public void save_the_invoice_against_po_first_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

	}

	@And("^select the record from invoice booking record from temp grid$")
	public void select_the_record_from_invoice_booking_record_from_temp_grid() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayableInvoiceBookingTempGridFirstRecord(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayableInvoiceBookingTempGridFirstRecord().click();
	}

	@And("^click ap invoice against po in invoice booking screen$")
	public void click_ap_invoice_against_po_in_invoice_booking_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayableInvoiceBookingInvoiceAgainstPoTab(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayableInvoiceBookingInvoiceAgainstPoTab().click();
	}

	@And("^enter the po number in invoice against po screen$")
	public void enter_the_po_number_in_invoice_against_po_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(testData.get("PONumber"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton(), 20, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton().click();
	}

	@And("^save the invoice against po screen$")
	public void save_the_invoice_against_po_screen() throws Throwable {
		System.out.println("Invoice save screen");
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BillingPoSaveButton());
				clicksAndActionHelper.clickOnElement(
						aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BillingPoSaveButton());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 20, 1);
		Assert.assertTrue(kubsCommonWebObj.kubsToastAlert().isDisplayed());

	}

	@And("^Update test data for bill booking create and submit from maker$")
	public void update_test_data_for_bill_booking_create_and_submit_from_maker() throws Throwable {
		dataSetID=excelDataForAssetConfig.getTestdata("KUBS_FAT_UAT_001_005_01");
		testData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^Update test data for bill booking create and approve from reviewer$")
	public void update_test_data_for_bill_booking_create_and_approve_from_reviewer() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_005_02_D1");
	}

	@And("^Update test data for bill booking create and approve from checker$")
	public void update_test_data_for_bill_booking_create_and_approve_from_checker() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_005_03_D1");
	}

	@And("^Update test data for bill booking record is present in reports$")
	public void update_test_data_for_bill_booking_record_is_present_in_reports() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_005_05_D1");
	}

}
