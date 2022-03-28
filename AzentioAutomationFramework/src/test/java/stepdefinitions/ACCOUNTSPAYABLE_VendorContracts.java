package stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class ACCOUNTSPAYABLE_VendorContracts {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType=jsonReader.getVendorContractdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
//--------	 @KUBS_INV_MGMT_UAT_001_002  ------------
	@Given("^User should go to the kubs url and login as a maker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_maker_user() throws InterruptedException  {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	/*@And("^user should navigate to accounts payable menu$")
	public void user_should_navigate_to_accounts_payable_menu() {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayableMenu().click();
		
	}
	
	@When("^click on eye button of vendor contract$")
	public void click_on_eye_button_of_vendor_contract() throws InterruptedException  {
		//Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_EyeButton().click();
	}

	@And("^click on add button to create contract$")
	public void click_on_add_button_to_create_contract() throws InterruptedException {
		//Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
	}
	
	@And("^Fill the required fields to create contract$")
	public void fill_the_required_fields_to_create_contract() throws InterruptedException  {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.ExpenseType);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.BP_Name);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Name().sendKeys(Keys.ENTER);
		
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().click();
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.BP_Branch);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BP_Branch().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractName);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractName().sendKeys(Keys.ENTER);
		
		//agreement calendar
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AgreementCalendar().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementFullMonth +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementDate+", "+aCCOUNTSPAYABLE_VendorContractsTestDataType.AgreementYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
		
		Thread.sleep(1000);
		//ContractEndDate calendar
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractEndDate().click();
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
		}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndFullMonth +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndDate+", "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"']/span")));
		WebElement EndDay=driver.findElement(By.xpath("//td[@aria-label='"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndFullMonth +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndDate+", "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractEndYear+"']/span"));
		clicksAndActionHelper.doubleClick(EndDay);
		
		Thread.sleep(1000);
		//ContractSignedOnDate calendar
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractSignedOnDate().click();
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnMonth+" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
		}
		}
		WebElement SignedOnDay=driver.findElement(By.xpath("//td[@aria-label='"+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnFullMonth +" "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnDate+", "+aCCOUNTSPAYABLE_VendorContractsTestDataType.ContractSignedOnYear+"']/span"));
		clicksAndActionHelper.doubleClick(SignedOnDay);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.Currency);;
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency().sendKeys(Keys.ENTER);
		
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Remark().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.Remark);;
		
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_OtherDetailsButton().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoGenerateInvoice().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.CreditPeriod);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CreditPeriod().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_LatePaymentFee().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.LatePaymentFee);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Currency2().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.Currency2);;
		//scroll down to additional details button
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();
		
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.HSN_Code);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_HSN_Code().sendKeys(Keys.ENTER);
		
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().click();
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.ExpenseCode);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ExpenseCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Quantity().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.Quantity);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.CostCenter);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CostCenter().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.Unit);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Unit().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RatePerUnit().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.RatePerUnit);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.CurrencyinItemDetails);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_CurrencyInItemDetail().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton().click();
		
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AddButton().click();
		
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermDetails().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.PaymentTerm);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermPercent().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.PaymentTermPercent);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.PaymentTermType);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_PaymentTermType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ItemDetailsSaveButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.ModeOfPayment);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ModeOfPayment().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.AutoPayout);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_AutoPayout().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BenificiaryDetailsSaveButton().click();		
	}
	
	@Then("^Save and submit the creation contract record$")
	public void save_and_submit_the_creation_contract_record() throws InterruptedException, IOException, ParseException{
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();
		
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
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
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
		
	}*/

	@And("^User should go to the kubs url and login as a reviewer user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_user() throws IOException, ParseException {
		reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	}

	@Then("^Click on notification button in reviewer$")
	public void click_on_notification_button_in_reviewer() {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();;
	}

	@And("^approve the record by reviewer user$")
	public void approve_the_record_by_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		
		for (int i = 1; i < 10; i++) {
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)).click();
			
				reader.addReferanceData(referance_id);
				
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.ApproveRemarkByReviewer);
				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
				Thread.sleep(2000);
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
    	waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
    	kubschecker.checkerSecurityManagement().click();
    	
    }

    @Then("^Click on open pool in checker$")
    public void click_on_open_pool_in_checker() {
    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
    	kubschecker.checkerActionIcon().click();
    }

    @And("^Click on claim button in checker$")
    public void click_on_claim_button_in_checker() throws IOException, ParseException  {
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
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
    public void click_on_notification_in_checker()  {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
    }
    
	@Then("^checker should approved the contract record$")
	public void checker_should_approved_the_contract_record() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();
		
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	
		/*kubschecker.checkerRemarks().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.CheckerRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();*/
	}
}
	
	/*@Then("^click on first eye button to get the unique contract code$")
    public void click_on_first_eye_button_to_get_the_unique_contract_code() throws InterruptedException {
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String uniquecode = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
    	System.out.println("Contract Unique code: " +uniquecode);
       
    }
	
	@Then("^Get the contract and Txn status by searching the record via business partner$")
    public void get_the_contract_and_txn_status_by_searching_the_record_via_business_partner()  {
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.BP_Name);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractStatus());
		System.out.println("Contract Status - " +aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractStatus().getText());
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_TxnStatus());
		System.out.println("Txn Status - " +aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_TxnStatus().getText());
    }

	
	@And("^maker should logout$")
    public void checker_should_logout()  {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout();
    }
	*/
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

