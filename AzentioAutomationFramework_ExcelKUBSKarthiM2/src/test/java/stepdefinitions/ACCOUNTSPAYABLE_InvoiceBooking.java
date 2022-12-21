package stepdefinitions;

import java.io.IOException;
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
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingTestDataType aCCOUNTSPAYABLE_InvoiceBookingTestDataType=jsonReader.getInvoiceBookingdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","BusinessPartnerTestData","Data Set ID");
	Map<String, String> testData;
	
//--------    @KUBS_INV_MGMT_UAT_001_005  ------------
    
    @When("^click on eye button of invoice booking$")
    public void click_on_eye_button_of_invoice_booking() {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
    }
    
    @When("^click on temp grid button of invoice booking$")
    public void click_on_temp_grid_button_of_invoice_booking() {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton().click();
    }

    @And("^click on add button for invoice booking$")
    public void click_on_add_button_for_invoice_booking() {
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton().click();
    }

    @And("^Fill the required fields for invoice booking$")
    public void fill_the_required_fields_for_invoice_booking() throws InterruptedException, IOException, ParseException  {
    	Random random = new Random();
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EntityBranch);
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
    	
    	String invoicetype= aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType;
    	System.out.println(invoicetype);
		if (invoicetype.equals("Expense")) {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceSubType);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.BP_Name);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.CostCenter);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

			int randomNum=random.nextInt(5000-2500)+2500;
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.SupplierReferenceNumber+randomNum);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " "
							+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingFullMonth + " "
					+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);
			
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.FlatDiscountOnInvoice);

			String discounttype = aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType;
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountPercent);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount().click();
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountDays().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDate().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustment().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);
				
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountAmountFlat);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();
//				Thread.sleep(3000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
//						javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
				
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		} else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.BP_Name);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.CostCenter);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.SupplierReferenceNumber);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " "
							+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingFullMonth + " "
					+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAndGstAmount);

			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.FlatDiscountOnInvoice);
			
			String discounttype = aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType;
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountPercent);
				//flat discount amount&days method bcoz xpath is same
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountAmount);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span")));
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountAmount);
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);
				
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountAmountFlat);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO().click();
				Thread.sleep(2000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span")));
//				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
//				clicksAndActionHelper.doubleClick(paymentDate);

				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		}
    	
    	Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
//    	Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	
    	Thread.sleep(2000);
    	String invoicetype1= aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType;
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
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceQuantity);
    	
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
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RatePerUnit);
    	
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
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAmount);
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail().click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.AmountToBeAllocated);
    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter().click();
    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton().click();
		}
		else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PONumber);
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
	    
	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
	    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox().click();
	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton());
	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton().click();
		}
    }
    
    @Then("^Save and submit the invoice billing$")
    public void save_and_submit_the_invoice_billing() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
    	Thread.sleep(2000);
		
    	javascripthelper.JavaScriptHelper(driver);
    	
    	String invoicetype2= aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType;
    	System.out.println(invoicetype2);
		if (invoicetype2.equals("Expense")) {
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
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
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RemarkByMaker);
		
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
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
    }
    
    @And("^approve the record by the reviewer user$")
	public void approve_the_record_by_the_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
			//waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			for (int j = 0; j <30; j++) {
				try {
					String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					break;
				} catch (Exception e) {
					
				}
			}
			
			
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)).click();
			
				//reader.addReferanceData(referance_id);
				
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
				break;
		}
	}
    @Then("^checker should approved the invoice billing$")
	public void checker_should_approved_the_invoice_billing() throws IOException, ParseException, InterruptedException {
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
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
		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ApprovedByChecker);
//		waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
    	System.out.println("System generated invoice number: " +invoicenumber);
       
    }
    
    @Then("^click on first eye button to get the system invoice number to check$")
    public void click_on_first_eye_button_to_get_the_system_invoice_number_to_check() throws InterruptedException, IOException {
    	javascripthelper.JavaScriptHelper(driver);
    	
    	waithelper.waitForElement(driver,3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
    	Thread.sleep(2000);
    	String invoicenumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
    	System.out.println("System generated invoice number: " +invoicenumber);
    	jsonWriter=new JsonDataReaderWriter();
    	jsonWriter.addData(invoicenumber);
    	
    }
    
    @Then("^Get the invoice status$")
    public void get_the_invoice_status()  {
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.BP_Name);
    	System.out.println("Invoice Status is - " +aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ContractStatus().getText());
       
    }
    
    @Then("^Get the tax details and check$")
    public void get_the_tax_details_and_check() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceNumber);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton().click();
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	Thread.sleep(2000);
    	javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
    	Thread.sleep(2000);
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();
    	
    	//CODES FOR SGST AND CGST
    	
    	/*double taxSGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[24].value").toString());
    	int invoiceamountSGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByTagName('input')[25].value").toString());
    	double taxamountSGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[26].value").toString());
    	
    	double taxCGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[29].value").toString());
    	int invoiceamountCGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByTagName('input')[30].value").toString());
    	double taxamountCGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[31].value").toString());
    	*/
    	
    	double taxIGST =  Double.parseDouble(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[2].value").toString());
    	int invoiceamountIGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[3].value").toString());
    	double taxamountIGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[4].value").toString());
    	
    	
//    	double taxamtSGST = Double.valueOf((taxSGST)/100 * invoiceamountSGST);
//    	double taxamtCGST = Double.valueOf((taxCGST)/100 * invoiceamountCGST);
    //  double taxamt = Double.valueOf(Double.parseDouble(taxSGST)/100 * Integer.parseInt(invoiceamountSGST));
//    	System.out.println("Calculated SGST tax amount is : " +taxamtSGST);
//    	System.out.println("Calculated CGST tax amount is : " +taxamtCGST);
    	
    	//CODES FOR SGST AND CGST
    	
    	/*if(Double.valueOf((taxSGST)/100 * invoiceamountSGST).equals(taxamountSGST))
    	{
    		System.out.println("SGST Tax details are correctly displayed");
    	}else System.out.println("Tax details are not correctly displayed");
    	
    	if(Double.valueOf((taxCGST)/100 * invoiceamountCGST).equals(taxamountCGST))
    	{
    		System.out.println("CGST Tax details are correctly displayed");
    	}else System.out.println("Tax details are not correctly displayed");
    	*/
    	
    	if(Double.valueOf((taxIGST)/100 * invoiceamountIGST).equals(taxamountIGST))
    	{
    		System.out.println("IGST Tax details are correctly displayed");
    	}else {System.out.println("Tax details are not correctly displayed");}
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();
    	
    	
    }
    
    @And("^Fill the required fields for invoice booking with exceeded amount$")
    public void fill_the_required_fields_for_invoice_booking_with_exceeded_amount() throws InterruptedException, IOException, ParseException  {
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EntityBranch);
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
    	
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceType);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceSubType);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.BP_Name);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.CostCenter);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.SupplierReferenceNumber);

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath(
						"//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
			}
		}
		WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingFullMonth + " "
				+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceBillingYear + "']/span"));
		clicksAndActionHelper.doubleClick(InvoiceBillingDate);

		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.FlatDiscountOnInvoice);

		String discounttype = aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType;
		if (discounttype.equals("% Basis")) {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountPercent);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount().click();
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountDays().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(Keys.ENTER);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDate().click();

			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
					WebElement monthAndYear = driver.findElement(
							By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
					+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
			clicksAndActionHelper.doubleClick(paymentDate);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustment().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
			javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
		} else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountAmountFlat);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ModeOfPayment);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceCurrency);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoicePaymentCurrency);
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]")));
					WebElement monthAndYear = driver.findElement(
							By.xpath("//span[contains(text(),'" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentMonth + " " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
				}
			}
			WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentFullMonth + " "
					+ aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentDate + ", " + aCCOUNTSPAYABLE_InvoiceBookingTestDataType.PaymentYear + "']/span"));
			clicksAndActionHelper.doubleClick(paymentDate);

			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RoundingAdjustment);
			javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.Remarks);
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

		}

    	Thread.sleep(2000);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
//    	Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	
//    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 5000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();
    	
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseNewCode());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseNewCode().click();
    	
    	String beforexpath = "//ion-radio-group/ion-item[";
		String afterxpath = "]/ion-label";
		List<WebElement> radioitem= driver.findElements(By.xpath("//ion-radio-group/ion-item"));
		int size = radioitem.size();
		System.out.println(size);
		for (int i = 1; i <= size ; i++) {
			if(driver.findElement(By.xpath(beforexpath+ i + afterxpath)).getText().equals(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.ExpenseCodeExceededBudget))
			{
				String beforexpath1 = "//ion-item[";
				String afterxpath1 = "]/ion-radio";
				driver.findElement(By.xpath(beforexpath1 + i + afterxpath1)).click();
				break;
			}
		}
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceQuantity);
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RatePerUnit);
    	
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Currency();
    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra().click();
    	
//    	String azentmain=aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationAzentioMainView().getText();
//    	if(azentmain=="Azentio Main Branch")
//    	{
//  
//    	}else {
//    		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation().click();
//    		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationAzentioMain());
//    		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationAzentioMain().click();
//    	}
    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails().click();
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.TaxAmount);
//    	
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton().click();
//    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton().click();
//    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail().click();
//    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance().click();
//    	
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.AmountToBeAllocated);
//    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter().click();
//    	
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
//    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton().click();
		
    }
    
    @Then("^Save and submit the invoice billing with exceeded amount$")
    public void save_and_submit_the_invoice_billing_with_exceeded_amount() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 5000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
    	Thread.sleep(2000);
		
    	javascripthelper.JavaScriptHelper(driver);
    	
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	
    }
    
    @Then("^search auto generate bill and verify$")
    public void search_auto_generate_bill_and_verify() {
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AutoGenerateBillSearch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AutoGenerateBillSearch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.AutoGenerateBill);
    	
    }
    
    @Then("^Get the invoice number of bill against po of particular vendor$")
    public void get_the_invoice_number_of_bill_against_po_of_particular_vendor() throws IOException  {
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.BP_Name);
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceTypeSearch());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceTypeSearch().sendKeys(aCCOUNTSPAYABLE_InvoiceBookingTestDataType.InvoiceTypeSearch);
    	
    	String invoicenum=aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumber().getText();
    	System.out.println("Bill Against PO Invoice Number is - " +aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumber().getText());
    	jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(invoicenum);
       
    }
    
}
