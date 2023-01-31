package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class VendorContractsStep {
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

	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx",
			"ContractTestData", "Data Set ID");
	Map<String, String> testData;

	@And("^fill the accountPayable_VendorContracts_ExpenseType$")
	public void fill_the_accountpayablevendorcontractsexpensetype() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType()
				.sendKeys(testData.get("ExpenseType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_BP_Name$")
	public void fill_the_accountpayablevendorcontractsbpname() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_BP_Branch$")
	public void fill_the_accountpayablevendorcontractsbpbranch() throws Throwable {

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().click();
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch()
				.sendKeys(testData.get("BP_Branch"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_ContractName$")
	public void fill_the_accountpayablevendorcontractscontractname() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName()
				.sendKeys(testData.get("ContractName"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName().sendKeys(Keys.ENTER);

	}
	

	@And("^fill the accountPayable_VendorContracts_AgreementCalendar$")
	public void fill_the_accountpayablevendorcontractsagreementcalendar() throws Throwable {

		// agreement calendar
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar().click();
//    			Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("AgreementYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("AgreementMonth") + "']")).click();
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("AgreementFullMonth") + " "
						+ testData.get("AgreementDate") + ", " + testData.get("AgreementYear") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("AgreementFullMonth") + " "
				+ testData.get("AgreementDate") + ", " + testData.get("AgreementYear") + "']")).click();

	}

	@And("^fill the accountPayable_VendorContracts_ContractEndDate$")
	public void fill_the_accountpayablevendorcontractscontractenddate() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ContractEndYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ContractEndMonth") + "']")).click();
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ContractEndFullMonth") + " "
						+ testData.get("ContractEndDate") + ", " + testData.get("ContractEndYear") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ContractEndFullMonth") + " "
				+ testData.get("ContractEndDate") + ", " + testData.get("ContractEndYear") + "']")).click();

	}

	@And("^fill the accountPayable_VendorContracts_ContractSignedOnDate$")
	public void fill_the_accountpayablevendorcontractscontractsignedondate() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ContractSignedOnYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ContractSignedOnMonth") + "']")).click();
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ContractSignedOnFullMonth") + " "
						+ testData.get("ContractSignedOnDate") + ", " + testData.get("ContractSignedOnYear") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ContractSignedOnFullMonth") + " "
				+ testData.get("ContractSignedOnDate") + ", " + testData.get("ContractSignedOnYear") + "']")).click();

	}

	@And("^fill the accountPayable_VendorContracts_Currency$")
	public void fill_the_accountpayablevendorcontractscurrency() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(testData.get("Currency"));

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_Remark$")
	public void fill_the_accountpayablevendorcontractsremark() throws Throwable {

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Remark().sendKeys(testData.get("Remark"));

	}

	@And("^fill the accountPayable_VendorContracts_OtherDetailsButton$")
	public void fill_the_accountpayablevendorcontractsotherdetailsbutton() throws Throwable {

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_OtherDetailsButton().click();

	}

	@And("^fill the accountPayable_VendorContracts_AutoGenerateInvoice$")
	public void fill_the_accountpayablevendorcontractsautogenerateinvoice() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(testData.get("AutoGenerateBill"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_CreditPeriod$")
	public void fill_the_accountpayablevendorcontractscreditperiod() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod()
				.sendKeys(testData.get("CreditPeriod"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_LatePaymentFee$")
	public void fill_the_accountpayablevendorcontractslatepaymentfee() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee()
				.sendKeys(testData.get("LatePaymentFee"));

	}

	@And("^fill the accountPayable_VendorContracts_Currency2$")
	public void fill_the_accountpayablevendorcontractscurrency2() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2()
				.sendKeys(testData.get("Currency2"));

	}

	@And("^User click the accountPayable_VendorContracts_SaveButton$")
	public void user_click_the_accountpayablevendorcontractssavebutton() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();

	}

	@And("^User click the accountPayable_VendorContracts_AddButton$")
	public void user_click_the_accountpayablevendorcontractsaddbutton() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();

	}

	@And("^fill the accountPayable_VendorContracts_HSN_Code$")
	public void fill_the_accountpayablevendorcontractshsncode() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(testData.get("HSN_Code"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_ExpenseCode$")
	public void fill_the_accountpayablevendorcontractsexpensecode() throws Throwable {

		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().click();
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode()
				.sendKeys(testData.get("ExpenseCode"));
		Thread.sleep(1000);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_Quantity$")
	public void fill_the_accountpayablevendorcontractsquantity() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity().sendKeys(testData.get("Quantity"));

	}

	@And("^fill the accountPayable_VendorContracts_CostCenter$")
	public void fill_the_accountpayablevendorcontractscostcenter() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter()
				.sendKeys(testData.get("CostCenter"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_Unit$")
	public void fill_the_accountpayablevendorcontractsunit() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(testData.get("Unit"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_RatePerUnit$")
	public void fill_the_accountpayablevendorcontractsrateperunit() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit()
				.sendKeys(testData.get("RatePerUnit"));

	}

	@And("^fill the accountPayable_VendorContracts_CurrencyInItemDetail$")
	public void fill_the_accountpayablevendorcontractscurrencyinitemdetail() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail()
				.sendKeys(testData.get("CurrencyinItemDetails"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail().sendKeys(Keys.ENTER);

	}

	@And("^user click the accountPayable_VendorContracts_ItemDetailsSaveButton$")
	public void user_click_the_accountpayablevendorcontractsitemdetailssavebutton() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton().click();

	}

	@And("^User fill the accountPayable_VendorContracts_AddButton$")
	public void user_fill_the_accountpayablevendorcontractsaddbutton() throws Throwable {

		// waithelper.waitForElementwithFluentwait(driver,
		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		for (int i = 0; i < 20; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 20) {
					Assert.fail(e.getMessage());
				}

			}
		}

	}

	@And("^fill the accountPayable_VendorContracts_PaymentTermDetails$")
	public void fill_the_accountpayablevendorcontractspaymenttermdetails() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails()
				.sendKeys(testData.get("PaymentTerm"));

	}

	@And("^fill the accountPayable_VendorContracts_PaymentTermPercent$")
	public void fill_the_accountpayablevendorcontractspaymenttermpercent() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent()
				.sendKeys(testData.get("PaymentTermPercent"));

	}

	@And("^fill the accountPayable_VendorContracts_PaymentTermType$")
	public void fill_the_accountpayablevendorcontractspaymenttermtype() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType()
				.sendKeys(testData.get("PaymentTermType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType().sendKeys(Keys.ENTER);

	}

	@And("^User fill accountPayable_VendorContracts_ModeOfPayment$")
	public void user_fill_accountpayablevendorcontractsmodeofpayment() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment()
				.sendKeys(testData.get("ModeOfPayment"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment().sendKeys(Keys.ENTER);

	}

	@And("^fill the accountPayable_VendorContracts_AutoPayout$")
	public void fill_the_accountpayablevendorcontractsautopayout() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout()
				.sendKeys(testData.get("AutoPayout"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout().sendKeys(Keys.ENTER);

	}

	@And("^User click the accountPayable_VendorContracts_BenificiaryDetailsSaveButton$")
	public void user_click_the_accountpayablevendorcontractsbenificiarydetailssavebutton() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton().click();

	}

	@Then("^Save and submit the creation contract record1$")
	public void save_and_submit_the_creation_contract_record1()
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

		excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1", "Reference ID", id);
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
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

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
		// jsonWriter = new JsonDataReaderWriter();
		// jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1", "Reviewer ID", reviewerId);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");

	}

	@And("^User get the test data for Contract creation Testcase1$")
	public void user_get_the_test_data_for_contract_creation_testcase1() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
	}

	@And("^User get the test data for Contract creation Testcase3$")
	public void user_get_the_test_data_for_contract_creation_testcase3() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_03_D1");
	}

	@And("^User get the test data for Contract creation Testcase4$")
	public void user_get_the_test_data_for_contract_creation_testcase4() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_04_D1");
	}

	@Then("^search vendor contract details by business partner name$")
	public void search_vendor_contract_details_by_business_partner_name() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch()
				.sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch()
		.sendKeys(Keys.ENTER);

	}

	@And("^vendor contract details should display on contract creation list view$")
	public void vendor_contract_details_should_display_on_contract_creation_list_view() throws Throwable {

		for (int i = 0; i < 20; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_verify().isDisplayed();
				break;
			} catch (Exception e) {
				if (i == 20) {
					Assert.fail(e.getMessage());
				}

			}
		}
		

		String ContractDes = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractDes().getText();

		System.out.println(ContractDes);

		excelData.updateTestData("KUBS_FAT_UAT_001_002_04_D1", "ContractDes", ContractDes);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_04_D1");

	}

	@And("^User should go to the kubs url and login as a reviewer user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_user()
			throws IOException, ParseException, InterruptedException {

		// testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
		// reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
		Thread.sleep(2000);
	}

	@And("^approve the record by reviewer user$")
	public void approve_the_record_by_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
//			waithelper.waitForElementwithFluentwait(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			String referance_id = null;
			for (int j = 0; j < 30; j++) {
				try {
					referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					break;
				} catch (Exception e) {

				}
			}
			// waithelper.waitForElementwithFluentwaitwithFluentwait(driver,
			// driver.findElement(By.xpath(before_xpath + i + after_xpath)));

//			waithelper.waitForElementwithFluentwait(driver, 10000, driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)));
//			waithelper.waitForElementwithFluentwaitwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)));
			for (int j = 0; j < 30; j++) {
				try {
					driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();
					break;
				} catch (Exception e) {

				}
			}
			excelData.updateTestData("KUBS_FAT_UAT_001_002_01_D1", "Reference ID", referance_id);
			testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");

			// reader.addReferanceData(referance_id);

//				waithelper.waitForElementwithFluentwait(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//				waithelper.waitForElementwithFluentwait(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer()
					.sendKeys(testData.get("ApproveRemarkByReviewer"));
//				waithelper.waitForElementwithFluentwait(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
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

	@Then("^Click on notification button in reviewer$")
	public void click_on_notification_button_in_reviewer() {
		// waithelper.waitForElementwithFluentwait(driver, 2000,
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
	@Given("^User should go to the kubs url and login as a checker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_checker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@When("^click on eye button of vendor contract$")
	public void click_on_eye_button_of_vendor_contract() throws InterruptedException {
		// Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton().click();
	}

	@And("^click on add button to create contract$")
	public void click_on_add_button_to_create_contract() throws InterruptedException {
		Thread.sleep(1000);
//		waithelper.waitForElementwithFluentwait(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		// waithelper.waitForElementwithFluentwaitwithFluentwait(driver,
		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		for (int i = 0; i < 40; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@And("^user should navigate to accounts payable menu$")
	public void user_should_navigate_to_accounts_payable_menu() throws InterruptedException {
		Thread.sleep(2000);
//		waithelper.waitForElementwithFluentwait(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu().click();

	}

	@Given("^User should go to the kubs url and login as a maker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_maker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppByMaker();
	}

	@And("^User get the test data for Contract creation Testcase2$")
	public void user_get_the_test_data_for_contract_creation_testcase2() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_02_D1");
	}
	@And("^Click on security management in checker$")
	public void click_on_security_management_in_checker() {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

	}

	@Then("^Click on open pool in checker$")
	public void click_on_open_pool_in_checker() {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerActionIcon());
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
//    	waithelper.waitForElementwithFluentwait(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		// waithelper.waitForElementwithFluentwaitwithFluentwait(driver,
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
//		waithelper.waitForElementwithFluentwait(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		Thread.sleep(2000);
		//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				//+ testData.get("Reference ID")
				//+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		for(int i=0; i<20; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID")
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
				break;
			} catch (Exception e) {
				if(i==20) {
					Assert.fail(e.getMessage());
				}
				
			}
		}
		
		
//    	waithelper.waitForElementwithFluentwait(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElementwithFluentwait(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();

//		waithelper.waitForElementwithFluentwait(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElementwithFluentwait(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerRemark"));
//		waithelper.waitForElementwithFluentwait(driver, 2000, kubschecker.checkersubmitButton());
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
	   @And("^User fill the accountsPayable_VendorPurchaseOrder_Contract$")
	    public void user_fill_the_accountspayablevendorpurchaseordercontract() throws Throwable {
		   AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	    	
	    	 //Contract
			 waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(testData.get("ContractDes"));
			Thread.sleep(1000);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);
	        
	    }


}
