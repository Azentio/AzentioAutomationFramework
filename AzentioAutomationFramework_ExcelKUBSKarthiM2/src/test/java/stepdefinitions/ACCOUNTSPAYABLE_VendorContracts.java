package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class ACCOUNTSPAYABLE_VendorContracts {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType = jsonReader
			.getVendorContractdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","ContractTestData","Data Set ID");
	Map<String, String> testData;

//--------	 @KUBS_INV_MGMT_UAT_001_002  ------------
	@Given("^User should go to the kubs url and login as a maker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_maker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppByMaker();
	}

	@And("^user should navigate to accounts payable menu$")
	public void user_should_navigate_to_accounts_payable_menu() throws InterruptedException {
		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu().click();

	}

	@When("^click on eye button of vendor contract$")
	public void click_on_eye_button_of_vendor_contract() throws InterruptedException {
		// Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton().click();
	}

	@And("^click on add button to create contract$")
	public void click_on_add_button_to_create_contract() throws InterruptedException {
		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		//waithelper.waitForElementwithFluentwait(driver,
				//aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		for(int i=0; i<40; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
	}

	@And("^Fill the required fields to create contract$")
	public void fill_the_required_fields_to_create_contract() throws InterruptedException {
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType()
				.sendKeys(testData.get("ExpenseType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name()
				.sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(Keys.ENTER);

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().click();
		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch()
				.sendKeys(testData.get("BP_Branch"));
		Thread.sleep(1000);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName()
				.sendKeys(testData.get("ContractName"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName().sendKeys(Keys.ENTER);

		// agreement calendar
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar().click();
//		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(
				By.xpath("//span[text()='" +testData.get("AgreementYear")+ "']")).click();
		driver.findElement(
				By.xpath("//span[text()='" +testData.get("AgreementMonth")+ "']"))
				.click();
		waithelper.waitForElement(driver, 2000,
				driver.findElement(
						By.xpath("//td[@aria-label='" +testData.get("AgreementFullMonth")+ " " +testData.get("AgreementDate")+ ", "
								+testData.get("AgreementYear")+ "']")));
		driver.findElement(
				By.xpath("//td[@aria-label='" +testData.get("AgreementFullMonth")+ " "
						+testData.get("AgreementDate")+ ", "
						+testData.get("AgreementYear")+ "']"))
				.click();
		/*
		 * while(true) { try {
		 * 
		 * // waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"')]")));
		 * waithelper.waitForElementwithFluentwait(driver,
		 * driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"')]")));
		 * WebElement
		 * monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"')]")); break; }
		 * 
		 * catch(NoSuchElementException nosuchElement) {
		 * aCCOUNTSPAYABLE_VendorContractsObj.
		 * accountPayable_VendorContracts_ClickOnNextMonth().click(); } } WebElement
		 * FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementFullMonth
		 * +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementDate+", "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"']/span"));
		 * clicksAndActionHelper.doubleClick(FinalDay);
		 */
//		Thread.sleep(1000);
		// ContractEndDate calendar
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(
				By.xpath("//span[text()='" +testData.get("ContractEndYear")+ "']"))
				.click();
		driver.findElement(
				By.xpath("//span[text()='" +testData.get("ContractEndMonth")+ "']"))
				.click();
		waithelper.waitForElement(driver, 2000,
				driver.findElement(
						By.xpath("//td[@aria-label='" +testData.get("ContractEndFullMonth")
								+ " " +testData.get("ContractEndDate")+ ", "
								+testData.get("ContractEndYear")+ "']")));
		driver.findElement(
				By.xpath("//td[@aria-label='" +testData.get("ContractEndFullMonth")+ " "
						+testData.get("ContractEndDate")+ ", "
						+testData.get("ContractEndYear")+ "']"))
				.click();
		/*
		 * while(true) { try {
		 * 
		 * waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"')]")));
		 * WebElement
		 * monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"')]")); break;
		 * }
		 * 
		 * catch(NoSuchElementException nosuchElement) {
		 * aCCOUNTSPAYABLE_VendorContractsObj.
		 * accountPayable_VendorContracts_ClickOnNextMonth().click(); } }
		 * waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//td[@aria-label='"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndFullMonth
		 * +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndDate+", "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"']/span")));
		 * WebElement EndDay=driver.findElement(By.xpath("//td[@aria-label='"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndFullMonth
		 * +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndDate+", "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"']/span"));
		 * clicksAndActionHelper.doubleClick(EndDay);
		 */
		Thread.sleep(1000);
		// ContractSignedOnDate calendar
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(
				By.xpath("//span[text()='" +testData.get("ContractSignedOnYear")+ "']"))
				.click();
		driver.findElement(
				By.xpath("//span[text()='" + testData.get("ContractSignedOnMonth") + "']"))
				.click();
		waithelper
				.waitForElement(driver, 2000,
						driver.findElement(By.xpath("//td[@aria-label='"
								+ testData.get("ContractSignedOnFullMonth") + " "
								+ testData.get("ContractSignedOnDate") + ", "
								+ testData.get("ContractSignedOnYear")+ "']")));
		driver.findElement(
				By.xpath("//td[@aria-label='" + testData.get("ContractSignedOnFullMonth")
						+ " " + testData.get("ContractSignedOnDate") + ", "
						+ testData.get("ContractSignedOnYear") + "']")).click();
		/*
		 * while(true) { try {
		 * 
		 * waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"')]")));
		 * WebElement
		 * monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnMonth+" "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"')]"));
		 * break; }
		 * 
		 * catch(NoSuchElementException nosuchElement) {
		 * waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.
		 * accountPayable_VendorContracts_ClickOnNextMonth());
		 * aCCOUNTSPAYABLE_VendorContractsObj.
		 * accountPayable_VendorContracts_ClickOnNextMonth().click(); } } WebElement
		 * SignedOnDay=driver.findElement(By.xpath("//td[@aria-label='"+
		 * aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnFullMonth
		 * +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnDate+", "
		 * +aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"']/span"))
		 * ; clicksAndActionHelper.doubleClick(SignedOnDay);
		 */

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency()
				.sendKeys(testData.get("Currency"));
		;
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(Keys.ENTER);

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Remark()
				.sendKeys(testData.get("Remark"));
		;

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_OtherDetailsButton().click();

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(testData.get("AutoGenerateBill"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod()
				.sendKeys(testData.get("CreditPeriod"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee()
				.sendKeys(testData.get("LatePaymentFee"));

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2()
				.sendKeys(testData.get("Currency2"));
		
		// scroll down to additional details button
		Thread.sleep(2000);
		

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();
		
		

		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code()
				.sendKeys(testData.get("HSN_Code"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(Keys.ENTER);

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().click();
		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode()
				.sendKeys(testData.get("ExpenseCode"));
		Thread.sleep(1000);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity()
				.sendKeys(testData.get("Quantity"));

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter()
				.sendKeys(testData.get("CostCenter"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit()
				.sendKeys(testData.get("Unit"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit()
				.sendKeys(testData.get("RatePerUnit"));

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail()
				.sendKeys(testData.get("CurrencyinItemDetails"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail().sendKeys(Keys.ENTER);

		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton().click();

		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();

		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails()
				.sendKeys(testData.get("PaymentTerm"));

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent()
				.sendKeys(testData.get("PaymentTermPercent"));

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType()
				.sendKeys(testData.get("PaymentTermType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton().click();

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment()
				.sendKeys(testData.get("ModeOfPayment"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout()
				.sendKeys(testData.get("AutoPayout"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton().click();
	}

	@Then("^Save and submit the creation contract record$")
	public void save_and_submit_the_creation_contract_record()
			throws InterruptedException, IOException, ParseException {
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();

//		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		
		excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1","Reference ID",id);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
		
//		for (int i = 1; i <= 35; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000, driver
//						.findElement(By.xpath("//span[contains(text(),'" +testData.get("Reference ID")+ "')]")));
//				WebElement referanceID = driver
//						.findElement(By.xpath("//span[contains(text(),'" +testData.get("Reference ID")+ "')]"));
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
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath)));
		driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath)).click();

//    	Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField()
				.sendKeys(testData.get("RemarkByMaker"));

//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
		//jsonWriter = new JsonDataReaderWriter();
		//jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1","Reviewer ID",reviewerId);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
		

	}

	@And("^User should go to the kubs url and login as a reviewer user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_user()
			throws IOException, ParseException, InterruptedException {
		
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
		//reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
		Thread.sleep(2000);
	}

	@Then("^Click on notification button in reviewer$")
	public void click_on_notification_button_in_reviewer() {
		// waithelper.waitForElement(driver, 2000,
		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		for (int i = 0; i < 30; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("notification icon not clicked");
				}
			}
		}

	}

	@And("^approve the record by reviewer user$")
	public void approve_the_record_by_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			String referance_id = null;
			for (int j = 0; j < 30; j++) {
				try {
					referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					break;
				} catch (Exception e) {

				}
			}
			// waithelper.waitForElementwithFluentwait(driver,
			// driver.findElement(By.xpath(before_xpath + i + after_xpath)));

//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)));
//			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)));
			for (int j = 0; j < 30; j++) {
				try {
					driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();
					break;
				} catch (Exception e) {

				}
			}
			excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1","Reference ID",referance_id);
			testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");

			//reader.addReferanceData(referance_id);

//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer()
					.sendKeys(testData.get("ApproveRemarkByReviewer"));
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
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

	@Given("^User should go to the kubs url and login as a checker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_checker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@And("^Click on security management in checker$")
	public void click_on_security_management_in_checker() {
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

	}

	@Then("^Click on open pool in checker$")
	public void click_on_open_pool_in_checker() {
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@And("^Click on claim button in checker$")
	public void click_on_claim_button_in_checker() throws IOException, ParseException {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		// String after_xpath = ;
		
		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath_claim)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^capture claimed status$")
	public void capture_claimed_status() {
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^click on notification in checker$")
	public void click_on_notification_in_checker() {
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		// waithelper.waitForElementwithFluentwait(driver,
		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		for (int i = 0; i < 30; i++) {
			try {
				clicksAndActionHelper.moveToElement(
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("Checker notification icon not clicked");
				}
			}
		}

	}

	@Then("^checker should approved the contract record$")
	public void checker_should_approved_the_contract_record() throws IOException, ParseException, InterruptedException {
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				+ testData.get("Reference ID")
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID")
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();

//		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerRemark"));
//		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^click on first eye button to get the unique contract code$")
	public void click_on_first_eye_button_to_get_the_unique_contract_code() throws InterruptedException {

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String uniquecode = javascripthelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value")
				.toString();
		System.out.println("Contract Unique code: " + uniquecode);

	}

	@Then("^Get the contract and Txn status by searching the record via business partner$")
	public void get_the_contract_and_txn_status_by_searching_the_record_via_business_partner() {

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search().click();

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch()
				.sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.BP_Name);

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractStatus());
		System.out.println("Contract Status - "
				+ aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractStatus().getText());

		waithelper.waitForElement(driver, 3000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_TxnStatus());
		System.out.println("Txn Status - "
				+ aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_TxnStatus().getText());
	}

	@And("^maker should logout$")
	public void checker_should_logout() {
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName().click();
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout();
	}
	@And("^User get the test data for Contract creation Testcase1$")
    public void user_get_the_test_data_for_contract_creation_testcase1() throws Throwable {
		 testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
    }

    @And("^User get the test data for Contract creation Testcase2$")
    public void user_get_the_test_data_for_contract_creation_testcase2() throws Throwable {
   	   testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_02_D1");
    }

    @And("^User get the test data for Contract creation Testcase3$")
    public void user_get_the_test_data_for_contract_creation_testcase3() throws Throwable {
   	   testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_03_D1");
    }

    @And("^User get the test data for Contract creation Testcase4$")
    public void user_get_the_test_data_for_contract_creation_testcase4() throws Throwable {
   	   testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_04_D1"); 
    }


}
