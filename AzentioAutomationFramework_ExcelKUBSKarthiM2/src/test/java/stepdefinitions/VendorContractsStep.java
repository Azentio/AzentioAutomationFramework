package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
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
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","ContractTestData","Data Set ID");
	Map<String, String> testData;
	
	@And("^fill the accountPayable_VendorContracts_ExpenseType$")
    public void fill_the_accountpayablevendorcontractsexpensetype() throws Throwable {
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType()
				.sendKeys(testData.get("ExpenseType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_BP_Name$")
    public void fill_the_accountpayablevendorcontractsbpname() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name()
				.sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_BP_Branch$")
    public void fill_the_accountpayablevendorcontractsbpbranch() throws Throwable {
    	
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().click();
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch()
				.sendKeys(testData.get("BP_Branch"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_ContractName$")
    public void fill_the_accountpayablevendorcontractscontractname() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName()
				.sendKeys(testData.get("ContractName"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_AgreementCalendar$")
    public void fill_the_accountpayablevendorcontractsagreementcalendar() throws Throwable {
    	
    	// agreement calendar
    			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar());
    			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar().click();
//    			Thread.sleep(2000);
    			javascripthelper.JavaScriptHelper(driver);
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
    					.click();
    			driver.findElement(
    					By.xpath("//span[text()='" +testData.get("AgreementYear")+ "']")).click();
    			driver.findElement(
    					By.xpath("//span[text()='" +testData.get("AgreementMonth")+ "']"))
    					.click();
    			waithelper.waitForElementwithFluentwait(driver, driver.findElement(
    							By.xpath("//td[@aria-label='" +testData.get("AgreementFullMonth")+ " " +testData.get("AgreementDate")+ ", "
    									+testData.get("AgreementYear")+ "']")));
    			driver.findElement(
    					By.xpath("//td[@aria-label='" +testData.get("AgreementFullMonth")+ " "
    							+testData.get("AgreementDate")+ ", "
    							+testData.get("AgreementYear")+ "']"))
    					.click();
        
    }

    @And("^fill the accountPayable_VendorContracts_ContractEndDate$")
    public void fill_the_accountpayablevendorcontractscontractenddate() throws Throwable {
    	
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
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(
						By.xpath("//td[@aria-label='" +testData.get("ContractEndFullMonth")
								+ " " +testData.get("ContractEndDate")+ ", "
								+testData.get("ContractEndYear")+ "']")));
		driver.findElement(
				By.xpath("//td[@aria-label='" +testData.get("ContractEndFullMonth")+ " "
						+testData.get("ContractEndDate")+ ", "
						+testData.get("ContractEndYear")+ "']"))
				.click();
        
    }

    @And("^fill the accountPayable_VendorContracts_ContractSignedOnDate$")
    public void fill_the_accountpayablevendorcontractscontractsignedondate() throws Throwable {
        
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
				.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"
								+ testData.get("ContractSignedOnFullMonth") + " "
								+ testData.get("ContractSignedOnDate") + ", "
								+ testData.get("ContractSignedOnYear")+ "']")));
		driver.findElement(
				By.xpath("//td[@aria-label='" + testData.get("ContractSignedOnFullMonth")
						+ " " + testData.get("ContractSignedOnDate") + ", "
						+ testData.get("ContractSignedOnYear") + "']")).click();
    	
    }

    @And("^fill the accountPayable_VendorContracts_Currency$")
    public void fill_the_accountpayablevendorcontractscurrency() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency()
				.sendKeys(testData.get("Currency"));
		
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(Keys.ENTER);

        
    }

    @And("^fill the accountPayable_VendorContracts_Remark$")
    public void fill_the_accountpayablevendorcontractsremark() throws Throwable {
    	
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Remark()
		.sendKeys(testData.get("Remark"));
        
    }

    @And("^fill the accountPayable_VendorContracts_OtherDetailsButton$")
    public void fill_the_accountpayablevendorcontractsotherdetailsbutton() throws Throwable {
    	
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_OtherDetailsButton().click();
        
    }

    @And("^fill the accountPayable_VendorContracts_AutoGenerateInvoice$")
    public void fill_the_accountpayablevendorcontractsautogenerateinvoice() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(testData.get("AutoGenerateBill"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice()
				.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_CreditPeriod$")
    public void fill_the_accountpayablevendorcontractscreditperiod() throws Throwable {
        
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod()
				.sendKeys(testData.get("CreditPeriod"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod().sendKeys(Keys.ENTER);
		
    }

    @And("^fill the accountPayable_VendorContracts_LatePaymentFee$")
    public void fill_the_accountpayablevendorcontractslatepaymentfee() throws Throwable {
        
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee()
				.sendKeys(testData.get("LatePaymentFee"));
    	
    }

    @And("^fill the accountPayable_VendorContracts_Currency2$")
    public void fill_the_accountpayablevendorcontractscurrency2() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2()
				.sendKeys(testData.get("Currency2"));
        
    }

    @And("^User click the accountPayable_VendorContracts_SaveButton$")
    public void user_click_the_accountpayablevendorcontractssavebutton() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton());
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
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code()
				.sendKeys(testData.get("HSN_Code"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_ExpenseCode$")
    public void fill_the_accountpayablevendorcontractsexpensecode() throws Throwable {
    	
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().click();
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode()
				.sendKeys(testData.get("ExpenseCode"));
		Thread.sleep(1000);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_Quantity$")
    public void fill_the_accountpayablevendorcontractsquantity() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity()
				.sendKeys(testData.get("Quantity"));
        
    }

    @And("^fill the accountPayable_VendorContracts_CostCenter$")
    public void fill_the_accountpayablevendorcontractscostcenter() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter()
				.sendKeys(testData.get("CostCenter"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_Unit$")
    public void fill_the_accountpayablevendorcontractsunit() throws Throwable {
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit()
				.sendKeys(testData.get("Unit"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_RatePerUnit$")
    public void fill_the_accountpayablevendorcontractsrateperunit() throws Throwable {
    	
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit()
				.sendKeys(testData.get("RatePerUnit"));
        
    }

    @And("^fill the accountPayable_VendorContracts_CurrencyInItemDetail$")
    public void fill_the_accountpayablevendorcontractscurrencyinitemdetail() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail());
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
    	
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
        
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
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent()
				.sendKeys(testData.get("PaymentTermPercent"));
        
    }

    @And("^fill the accountPayable_VendorContracts_PaymentTermType$")
    public void fill_the_accountpayablevendorcontractspaymenttermtype() throws Throwable {
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType()
				.sendKeys(testData.get("PaymentTermType"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType().sendKeys(Keys.ENTER);
        
    }

    @And("^User fill accountPayable_VendorContracts_ModeOfPayment$")
    public void user_fill_accountpayablevendorcontractsmodeofpayment() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment()
				.sendKeys(testData.get("ModeOfPayment"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment().sendKeys(Keys.ENTER);
        
    }

    @And("^fill the accountPayable_VendorContracts_AutoPayout$")
    public void fill_the_accountpayablevendorcontractsautopayout() throws Throwable {
    	
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout()
				.sendKeys(testData.get("AutoPayout"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout().sendKeys(Keys.ENTER);
        
    }

    @And("^User click the accountPayable_VendorContracts_BenificiaryDetailsSaveButton$")
    public void user_click_the_accountpayablevendorcontractsbenificiarydetailssavebutton() throws Throwable {
    	
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton());
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
	@And("^User get the test data for Contract creation Testcase1$")
    public void user_get_the_test_data_for_contract_creation_testcase1() throws Throwable {
		 testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
    }
	@Then("^search vendor contract details by business partner name$")
    public void search_vendor_contract_details_by_business_partner_name() throws Throwable {
		
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch().sendKeys(testData.get("BP_Name"));
		
       
    }

    @And("^vendor contract details should display on contract creation list view$")
    public void vendor_contract_details_should_display_on_contract_creation_list_view() throws Throwable {
    	
    	
        
    }





}
