package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPayable_InvoiceBookingObj;

import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountPayable_InvoiceBookingTestDataType;


public class AccountPayable_InvoiceBooking extends BaseClass {
	

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
		
		AzentioLogin login;
		AccountPayable_InvoiceBookingObj accountPayable_InvoiceBookingObj = new AccountPayable_InvoiceBookingObj(driver);

		AccountPayable_InvoiceBookingTestDataType accountPayable_InvoiceBookingTestDataType = jsonReader.getInvoiceBookingByName("Maker");
		
		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	
	@When("^click on eye button of the invoice booking$")
	public void click_on_eye_button_of_the_invoice_booking() {
	waithelper.waitForElement(driver, 3000,accountPayable_InvoiceBookingObj.accountsPayable_InvoiceBooking_EyeButton());
	accountPayable_InvoiceBookingObj.accountsPayable_InvoiceBooking_EyeButton().click();

	}
	@And("^click on the invoice booking add button$")
    public void click_on_the_invoice_booking_add_button()  {
	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton());
	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton().click();
    }
	@And("^Fill invoice booking required fields$")
    public void fill_invoice_booking_required_fields() throws InterruptedException, IOException, ParseException  {
    	javascripthelper.JavaScriptHelper(driver);
    	//waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch());
    	//accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(accountPayable_InvoiceBookingTestDataType.EntityBranch);
    	//accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
    	
    	String invoicetype= accountPayable_InvoiceBookingTestDataType.InvoiceType;
    	System.out.println(invoicetype);
		if (invoicetype.equals("Expense")) {
			//InvoiceType
			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceType);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceSubType);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(accountPayable_InvoiceBookingTestDataType.BP_Name);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(accountPayable_InvoiceBookingTestDataType.CostCenter);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(accountPayable_InvoiceBookingTestDataType.SupplierReferenceNumber);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingMonth + " "
							+ accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingFullMonth + " "
					+ accountPayable_InvoiceBookingTestDataType.InvoiceBillingDate + ", " + accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount());
//			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.TaxAndGstAmount);
			
			waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscount().sendKeys(accountPayable_InvoiceBookingTestDataType.FlatDiscountOnInvoice);

			String discounttype = accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType;
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountPercent);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount().click();
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountDays().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(accountPayable_InvoiceBookingTestDataType.ModeOfPayment);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPayment().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrency().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrency().sendKeys(Keys.ENTER);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDate().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustment().sendKeys(accountPayable_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				Thread.sleep(2000);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(accountPayable_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountType().sendKeys(Keys.ENTER);
				
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountAmountFlat);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.ModeOfPayment);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(accountPayable_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		} else {
			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceType);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.BP_Name);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name_AgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.CostCenter);
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterAgainstPO().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.SupplierReferenceNumber);

			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDateAgainstPO().click();

			javascripthelper.JavaScriptHelper(driver);
			while (true) {
				try {

					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingMonth + " "
							+ accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath(
							"//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingMonth + " " + accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
				}
			}
			WebElement InvoiceBillingDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.InvoiceBillingFullMonth + " "
					+ accountPayable_InvoiceBookingTestDataType.InvoiceBillingDate + ", " + accountPayable_InvoiceBookingTestDataType.InvoiceBillingYear + "']/span"));
			clicksAndActionHelper.doubleClick(InvoiceBillingDate);

//			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO());
//			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.TotalInvoiceAmount);

//			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount());
//			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAndGstAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.TaxAndGstAmount);

			waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO());
			accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FlatDiscountAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.FlatDiscountOnInvoice);
			
			String discounttype = accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType;
			if (discounttype.equals("% Basis")) {
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountPercent);
				//flat discount amount&days method bcoz xpath is same
				waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountAmount);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.ModeOfPayment);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlat().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat().sendKeys(Keys.ENTER);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlat().click();

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
					}
				}
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span")));
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlat().sendKeys(accountPayable_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(accountPayable_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountAmount);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
			} else {
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountType);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO().sendKeys(Keys.ENTER);
				
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountAmountFlat);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.EarlyPaymentDiscountDays);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.ModeOfPayment);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);

				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoicePaymentCurrency);
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO().sendKeys(Keys.ENTER);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO().click();
				Thread.sleep(2000);

				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]")));
						WebElement monthAndYear = driver.findElement(
								By.xpath("//span[contains(text(),'" + accountPayable_InvoiceBookingTestDataType.PaymentMonth + " " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
					}
				}
				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span"));
				clicksAndActionHelper.doubleClick(paymentDate);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span")));
//				WebElement paymentDate = driver.findElement(By.xpath("//td[@aria-label='" + accountPayable_InvoiceBookingTestDataType.PaymentFullMonth + " "
//						+ accountPayable_InvoiceBookingTestDataType.PaymentDate + ", " + accountPayable_InvoiceBookingTestDataType.PaymentYear + "']/span"));
//				clicksAndActionHelper.doubleClick(paymentDate);

				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO().sendKeys(accountPayable_InvoiceBookingTestDataType.RoundingAdjustment);
				javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Remarks().sendKeys(accountPayable_InvoiceBookingTestDataType.Remarks);
				waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();

			}
		}
    	
    	Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationButton());
		accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstReferenceId());
		String id=accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ClickOnNextMonth().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	
    	Thread.sleep(2000);
    	String invoicetype1= accountPayable_InvoiceBookingTestDataType.InvoiceType;
    	System.out.println(invoicetype1);
		if (invoicetype1.equals("Expense")) {
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(accountPayable_InvoiceBookingTestDataType.AdvanceNumber);
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AdvanceNumber().sendKeys(Keys.ENTER);
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCodeForLaptop().click();
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().sendKeys(accountPayable_InvoiceBookingTestDataType.InvoiceQuantity);
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().sendKeys(accountPayable_InvoiceBookingTestDataType.RatePerUnit);
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Currency();
    	javascripthelper.scrollIntoView(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromMaharastra().click();
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocation().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_DeliveryLocationMulund().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails().click();
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxAmount().sendKeys(accountPayable_InvoiceBookingTestDataType.TaxAmount);
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsSaveButton().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterButton().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeDetail().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterTypeFinance().click();
    	
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AmountToBeAllocated().sendKeys(accountPayable_InvoiceBookingTestDataType.AmountToBeAllocated);
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_AddCostCenter().click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenterDetailsSaveButton().click();
		}
		else {
			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber());
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(accountPayable_InvoiceBookingTestDataType.PONumber);
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
	    
	    	waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number());
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
	    	waithelper.waitForElement(driver, 4000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox());
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBox().click();
	    	waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton());
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_GRN_CheckBoxOKButton().click();
		}
    }
	

    @Then("^Save invoice billing and submit the record$")
    public void save_invoice_billing_and_submit_the_record() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
    	Thread.sleep(2000);
		
    	javascripthelper.JavaScriptHelper(driver);
    	
    	String invoicetype2= accountPayable_InvoiceBookingTestDataType.InvoiceType;
    	System.out.println(invoicetype2);
		if (invoicetype2.equals("Expense")) {
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		} else {
			waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus());
	    	WebElement recordstatus = accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	
	    	String message = accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus().getText();
	    	System.out.println(message);
	    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus().click();
		}
		
		waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationButton());
		accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstReferenceId());
		String id=accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationNextButton());
				accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SubmitButton());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(accountPayable_InvoiceBookingTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Submit());
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus());
    	WebElement recordstatus = accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus().getText();
    	System.out.println(message);
    	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_RecordStatus().click();
    	String t = "";
		String ar[] = message.split(" ");
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
    }
	
	
	@Then("^Get the tax details and check the details$")
    public void get_the_tax_details_and_check_the_details() throws InterruptedException  {
    javascripthelper.JavaScriptHelper(driver);
    accountPayable_InvoiceBookingTestDataType = jsonReader.getInvoiceBookingByName("Maker");
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch().sendKeys(accountPayable_InvoiceBookingTestDataType .InvoiceNumber);
    waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton().click();
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    Thread.sleep(2000);
    javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
    Thread.sleep(2000);
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();
   
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
	
	
//	double taxamtSGST = Double.valueOf((taxSGST)/100 * invoiceamountSGST);
//	double taxamtCGST = Double.valueOf((taxCGST)/100 * invoiceamountCGST);
//  double taxamt = Double.valueOf(Double.parseDouble(taxSGST)/100 * Integer.parseInt(invoiceamountSGST));
//	System.out.println("Calculated SGST tax amount is : " +taxamtSGST);
//	System.out.println("Calculated CGST tax amount is : " +taxamtCGST);
	
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
	
	accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();
	
	}

}
