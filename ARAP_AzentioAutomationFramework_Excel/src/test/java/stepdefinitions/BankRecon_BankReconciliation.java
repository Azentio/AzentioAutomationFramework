package stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.BankRecon_BankReconciliationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;

public class BankRecon_BankReconciliation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	WaitHelper waithelper = new WaitHelper(driver);
	BankRecon_BankReconciliationObj bankRecon_BankReconciliationObj = new BankRecon_BankReconciliationObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	AlertHelper alertHelper = new AlertHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData(System.getProperty("user.dir") + "\\Test-data\\KUBS_BankRecon_TestData.xlsx",
			"BankReconciliationTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
//-------- @KUBS_TAX_UAT_002_001_TC_002------------//
	
	@Then("^upload the file data which does not match with uploaded file$")
    public void upload_the_file_data_which_does_not_match_with_uploaded_file() throws Throwable {
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().sendKeys(testData.get("UploadTextFile"));
		
		//By using AUTO IT Method
//		//Thread.sleep(7000);
//		Runtime.getRuntime().exec("C://Users/inindc00091/Desktop/IDFC_REC_A11.exe"+" "+"C:\\Users\\inindc00091\\Downloads\\IDFC_REC_A11.txt");
//		//Thread.sleep(1000);
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
    	String toastmessage = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(toastmessage);
    	Assert.assertEquals("Account no in uploaded file is not matching with account no selected on screen", toastmessage);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    }
	
//-------- @KUBS_TAX_UAT_002_001_TC_003------------//
	
	@And("^user should navigate to bank recon menu$")
	public void user_should_navigate_to_bank_recon_menu()  {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankReconciliationMenu()).isDisplayed();
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		for (int i = 0; i < 35; i++) {
			try {
				javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankReconciliationMenu());
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankReconciliationMenu());
				bankRecon_BankReconciliationObj.BankReconciliationMenu().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	@And("^user should navigate to bank recon format menu$")
	public void user_should_navigate_to_bank_recon_format_menu()  {
		for (int i = 0; i < 35; i++) {
			try {
				javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankReconciliationMenu());
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankReconciliationMenu());
				bankRecon_BankReconciliationObj.BankReconciliationMenu().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
    
	@When("^click on eye button of bank reconciliation$")
    public void click_on_eye_button_of_bank_reconciliation() {
		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton().click();
		
    }
	
	@When("^click on eye button of bank recon format$")
	public void click_on_eye_button_of_bank_recon_format() {
		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_eyeButton());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_eyeButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_eyeButton().click();
		
	}
	
	@And("^click on add button for bank reconciliation$")
	public void click_on_add_button_for_bank_reconciliation() {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	
	
	@And("^Fill the required fields and upload bank statement for bank reconciliation$")
	public void fill_the_required_fields_and_upload_bank_statement_for_bank_reconciliation() throws InterruptedException, IOException {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(testData.get("BankName"));
		String beforexpath = "//div[text()='";
		String afterxpath = "']";
		for (int i = 0; i <= 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)));
				driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)).isDisplayed();
				break;
			} catch (Exception e) {
				if(i==35) {
					Assert.fail(e.getMessage());	
					}
				// TODO: handle exception
			}
		}
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(Keys.ENTER);
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().click();
		Double d = Double.valueOf(testData.get("AccountNumber"));
	    String accountNumber =String.format("%.0f", d);
	    waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(accountNumber);
		String beforexpath1 = "//div[text()='";
		String afterxpath1 = "']";
		for (int i = 0; i <= 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)));
				driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)).isDisplayed();
				break;
			} catch (Exception e) {
				if(i==35) {
					Assert.fail(e.getMessage());	
					}
				// TODO: handle exception
			}
		}
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("FromYear"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span")));	
		WebElement PeriodFromDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodFromDate);
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToMonth")+" "+testData.get("ToYear")+" ']")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[text()='"+testData.get("ToMonth")+" "+testData.get("ToYear")+" ']"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("ToYear"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToYear")+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToYear")+"']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth") +" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span")));	
		WebElement PeriodToDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth") +" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodToDate);
		
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().sendKeys(testData.get("UploadTextFile"));
		
		//By using AUTO IT Method
//		//Thread.sleep(7000);
//		Runtime.getRuntime().exec("C://Users/inindc00091/Desktop/IDFC_REC_A11.exe"+" "+"C:\\Users\\inindc00091\\Downloads\\IDFC_REC_A11.txt");
//		//Thread.sleep(1000);
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}
	
	@Then("^Fill the bank name and account number for bank reconciliation$")
    public void fill_the_bank_name_and_account_number_for_bank_reconciliation() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(testData.get("BankName"));
		String beforexpath = "//div[text()='";
		String afterxpath = "']";
		for (int i = 0; i <= 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)));
				driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)).isDisplayed();
				break;
			} catch (Exception e) {
				if(i==35) {
					Assert.fail(e.getMessage());	
					}
				// TODO: handle exception
			}
		}
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(Keys.ENTER);
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().click();
		Double d = Double.valueOf(testData.get("AccountNumber"));
	    String accountNumber =String.format("%.0f", d);
	    waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(accountNumber);
		String beforexpath1 = "//div[text()='";
		String afterxpath1 = "']";
		for (int i = 0; i <= 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)));
				driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)).isDisplayed();
				break;
			} catch (Exception e) {
				if(i==35) {
					Assert.fail(e.getMessage());	
					}
				// TODO: handle exception
			}
		}
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(Keys.ENTER);
		
    }

    @Then("^select the recon period from date for bank reconciliation$")
    public void select_the_recon_period_from_date_for_bank_reconciliation() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("FromYear"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span")));	
		WebElement PeriodFromDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodFromDate);
    }
    
    @And("^verify and cancel Bank Reconciliation process if already done for selected period$")
    public void verify_and_cancel_bank_reconciliation_process_if_already_done_for_selected_period() throws Throwable {
    	try {
			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	    	System.out.println(message);
	    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ValidationMessageCloseButton());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ValidationMessageCloseButton().click();;
			if(message.equalsIgnoreCase("Bank Reconciliation process is already done for selected period and bank account number")) {
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton().click();
		    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView().click();
		    	for (int i = 0; i <= 200; i++) {
					try {
						bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
						break;
					} catch (Exception e) {
						// TODO: handle exception
						if(i==200) {
							Assert.fail(e.getMessage());
						}
					}
				}
		    	for (int i = 0; i <= 200; i++) {
		    		try {
//		    			waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
		    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().isDisplayed();
		    			break;
		    			
		    		} catch (Exception e) {
		    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
		    		}
				}
		    	
		    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
		    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().click();
		    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
		    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().sendKeys(testData.get("BankName"));
		    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton());
		    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton().click();
		    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_cancelButton());
		    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_cancelButton().click();
		    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
				javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys("cancel");
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ValidationMessageCloseButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ValidationMessageCloseButton().click();
				Thread.sleep(3000);
				javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
				for (int i = 0; i <= 200; i++) {
					try {
						bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton().click();
						break;
					} catch (Exception e) {
						if (i == 200) {
							Assert.fail(e.getMessage());
						}
					}
				}
				
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton());
				for (int i = 0; i <= 200; i++) {
					try {
						bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton().click();
						break;
					} catch (Exception e) {
						if (i == 200) {
							Assert.fail(e.getMessage());
						}
					}
				}
				
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(testData.get("BankName"));
				String beforexpath = "//div[text()='";
				String afterxpath = "']";
				for (int i = 0; i <= 50; i++) {
					try {
						waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)));
						driver.findElement(By.xpath(beforexpath+testData.get("BankName")+afterxpath)).isDisplayed();
						break;
					} catch (Exception e) {
						if(i==35) {
							Assert.fail(e.getMessage());	
							}
						// TODO: handle exception
					}
				}
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(Keys.ENTER);
				
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().click();
				Double d = Double.valueOf(testData.get("AccountNumber"));
			    String accountNumber =String.format("%.0f", d);
			    waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(accountNumber);
				String beforexpath1 = "//div[text()='";
				String afterxpath1 = "']";
				for (int i = 0; i <= 35; i++) {
					try {
						waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)));
						driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)).isDisplayed();
						break;
					} catch (Exception e) {
						if(i==35) {
							Assert.fail(e.getMessage());	
							}
						// TODO: handle exception
					}
				}
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(Keys.ENTER);
				
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom().click();
				
				while(true)
				{
					try 
					{
						waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']")));
						WebElement birthmonthandyear=driver.findElement(By.xpath("//span[text()='"+testData.get("FromMonth")+" "+testData.get("FromYear")+" ']"));
//						driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
						break;
					}catch(NoSuchElementException nosuchElement)
					{
						waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
						bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
						String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//						String tablehead="2016 ~ 2036";
						String headyear=tablehead.replaceAll(" ~", "");
//						System.out.println(headyear);
						String ar[] = headyear.split(" ");
						int y1=Integer.parseInt(ar[0]);
						int y2=Integer.parseInt(ar[1]);
						int year=Integer.parseInt(testData.get("FromYear"));
						if(year < y1 && year<y2)
						{
							while(true)
							{
								try {
									waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
									WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
								    break;
								}
								catch(NoSuchElementException nosuchElement1) {
									waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
									bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
								}
							}
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
							Year.click();
							
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
							driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
							
						}
						else if(year>y1 && year>y2)
						{
							while(true)
							{
								try {
									waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
									WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
								    break;
								}
								catch(NoSuchElementException nosuchElement2) {
									waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
									bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
								}
							}
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("FromYear")+" ']"));
							Year.click();
							
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
							driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
							
						}
						else
						{
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']")));
							WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromYear")+"']"));
							Year.click();
							
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")));
							driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromYear")+"']")).click();
							
						}
					}
				}
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span")));	
				WebElement PeriodFromDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth") +" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
				clicksAndActionHelper.doubleClick(PeriodFromDate);
				
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @Then("^select the recon period to date for bank reconciliation$")
    public void select_the_recon_period_to_date_for_bank_reconciliation() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToMonth")+" "+testData.get("ToYear")+" ']")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[text()='"+testData.get("ToMonth")+" "+testData.get("ToYear")+" ']"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("ToYear"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
							WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']")));
					WebElement Year=driver.findElement(By.xpath("//span[text()='"+testData.get("ToYear")+" ']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToYear")+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToYear")+"']"));
					Year.click();
					
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToYear")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth") +" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span")));	
		WebElement PeriodToDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth") +" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodToDate);
    }

    @Then("^upload the text file for bank reconciliation$")
    public void upload_the_text_file_for_bank_reconciliation() throws Throwable {
    	Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().sendKeys(testData.get("UploadTextFile"));
		
		//By using AUTO IT Method
//		//Thread.sleep(7000);
//		Runtime.getRuntime().exec("C://Users/inindc00091/Desktop/IDFC_REC_A11.exe"+" "+"C:\\Users\\inindc00091\\Downloads\\IDFC_REC_A11.txt");
//		//Thread.sleep(1000);
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
    	String toastmessage = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(toastmessage);
    	Assert.assertEquals("File validated successfully", toastmessage);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    }
	
	@Then("^verify after clicking on a match record it displays the match record from uploaded file$")
    public void verify_after_clicking_on_a_match_record_it_displays_the_match_record_from_uploaded_file() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox().click();
		
		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBankStatementTitle());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptNoFromBankStatement());
		boolean status = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptNoFromBankStatement().isDisplayed();
		Assert.assertTrue("Bank statement Record is not present",status);
		
	}
	
	@Then("^verify after clicking on a match record it displays the match record from book$")
	public void verify_after_clicking_on_a_match_record_it_displays_the_match_record_from_book() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
    	
    	Thread.sleep(2000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));

		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox().click();

		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBankStatementTitle());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptNoFromBankStatement());
		boolean status = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptNoFromBankStatement().isDisplayed();
		Assert.assertTrue("Bank statement Record is not present", status);
	}
	
	@Then("^verify after clicking on a match record it matches with multiple records from bank statement$")
    public void verify_after_clicking_on_a_match_record_it_matches_with_multiple_records_from_bank_statement() throws Throwable {
		Thread.sleep(500);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
		for (int i = 0; i < 30; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
		
		String beforexpath = "//div[text()=' ";
		String afterxpath = " ']/../../datatable-body-cell/div/input";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath+testData.get("ReceiptNumber")+afterxpath)));
		driver.findElement(By.xpath(beforexpath+testData.get("ReceiptNumber")+afterxpath)).click();

		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
		
		//ion-grid[2]/descendant::input[1]
		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBankStatement());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBankStatement());
		String recordCount = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBankStatement().getText();
    	System.out.println(recordCount);
    	String matchedCount = "";
		String ar[] = recordCount.split(" ");
		matchedCount=ar[0];
		int Count = Integer.parseInt(matchedCount);
		
		String beforexpath1 = "//ion-grid[2]/descendant::input[";
		String afterxpath1 = "]";
		for (int i = 1; i <= Count ; i++) {
			for (int j = 0; j < 35; j++) {
				try {
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1+i+afterxpath1)));
					driver.findElement(By.xpath(beforexpath1+i+afterxpath1)).click();
					break;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
		
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
		
		for (int i = 0; i < 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox().click();
		
		//ion-grid[3]/descendant::div[contains(text(),'RRN002')]
		String beforexpath2 = "//ion-grid[3]/descendant::div[contains(text(),'";
		String afterxpath2 = "')]";
		List<WebElement> sta = driver.findElements(By.xpath(beforexpath2+testData.get("ReceiptNumber")+afterxpath2));
		System.out.println(sta);
		
	}
	
	@Then("^verify after clicking on a match record it matches with multiple records from book$")
    public void verify_after_clicking_on_a_match_record_it_matches_with_multiple_records_from_book() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
		for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton().click();  	
//    	Thread.sleep(2000);
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
//    	Thread.sleep(2000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
//    	Thread.sleep(500);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
//    	Thread.sleep(2000);
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm().click();
    	
//    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i < 35; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber2"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber2")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i < 35; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber2")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton2().click();
    	
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
    	
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 100; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));

		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox().click();
		Thread.sleep(500);
		for (int i = 0; i <= 200; i++) {
			try {
				javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_multipleMatchedDataCount());
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_multipleMatchedDataCount());
    	String total = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_multipleMatchedDataCount().getText();
    	String matchedCount = "";
		String ar[] = total.split(" ");
		matchedCount=ar[0];
		int multipleDataCount = Integer.parseInt(matchedCount);
		System.out.println("Total multiple record found - "+multipleDataCount);
		//div[text()=' RRN003 ']
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']")));
		boolean record1 = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']")).isDisplayed();
		Assert.assertTrue("first record found", record1);
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber2")+" ']")));
		boolean record2 = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber2")+" ']")).isDisplayed();
		Assert.assertTrue("second record found", record2);
		
	}
	
	
	@Then("^open bank recon format configuration of a bank$")
    public void open_bank_recon_format_configuration_of_a_bank() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().sendKeys(testData.get("BankName"));
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_viewRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_viewRecord().click();
		
	}
	
	@And("^navigate to data matching rule$")
	public void navigate_to_data_matching_rule() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingRuleTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingRuleTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

    @Then("^get the matching rule for correct match record$")
    public void get_the_matching_rule_for_correct_match_record() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ValueDateView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ValueDateView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition1 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Value Date", matchCondition1);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TransactionDateView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TransactionDateView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition2 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Transaction Date", matchCondition2);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_InstrumentNumberView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_InstrumentNumberView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition3 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Instrument Number", matchCondition3);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DepositsView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DepositsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition4 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Deposits", matchCondition4);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ParticularsView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ParticularsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition5 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Particulars", matchCondition5);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_WithdrawlsView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_WithdrawlsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput());
    	String matchCondition6 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_MatchConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Withdrawls", matchCondition6);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
    }
    
    @Then("^get the matching rule for unmatch record$")
    public void get_the_matching_rule_for_unmatch_record() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ParticularsView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_ParticularsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_SuggestedConditionInput());
    	String suggestedCondition = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_SuggestedConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Particulars", suggestedCondition);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DepositsView());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DepositsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TranspositionConditionInput());
    	String transpositionCondition = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TranspositionConditionInput().getText();
    	excelData.updateTestData(dataSetID, "Deposits", transpositionCondition);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_WithdrawlsView());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_WithdrawlsView().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TranspositionConditionInput());
		String transpositionCondition1 = bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_TranspositionConditionInput().getText();
		excelData.updateTestData(dataSetID, "Withdrawls", transpositionCondition1);
		testData = excelData.getTestdata(dataSetID);
//		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton());
//		bankRecon_BankReconciliationObj.BankRecon_BankReconFormat_DataMatchingBackButton().click();
    	
    }

    @Then("^Save and click on process$")
    public void save_and_click_on_process() throws InterruptedException {
    	clicksAndActionHelper.moveToElement(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();;
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton().click();
//    	alertHelper.getAlert();
    	Thread.sleep(500);
    	alertHelper.isAlertPresent();
    	String alertText = alertHelper.getAlertText();
    	alertHelper.AcceptAlert();
//    	Assert.assertEquals("Bank Reconciliation is being processed, kindly wait for few minutes", alertText);
    }
    
    @Then("^verify matched record$")
    public void verify_matched_record() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookCheckbox().click();
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_particularsFromBook());
		String particularsFromBook = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_particularsFromBook().getText();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_instrumentNumberFromBook());
		String instrumentNumberFromBook = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_instrumentNumberFromBook().getText();
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_particularsFromBank());
		String particularsFromBank = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_particularsFromBank().getText();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_instrumentNumberFromBank());
		String instrumentNumberFromBank = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_instrumentNumberFromBank().getText();
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_WithDrawlAmountFromBook());
		String withdrawlAmountFromBook = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_WithDrawlAmountFromBook().getText();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_depositAmountFromBank());
		String depositAmountFromBank = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_depositAmountFromBank().getText();
		
		if(testData.get("Instrument Number").equals("Fully Matched")) {
			Assert.assertEquals(particularsFromBook, particularsFromBank);
			System.out.println("Instrument number are matched according to data matching rule");
		}
		if(testData.get("Particulars").equals("Fully Matched")) {
			Assert.assertEquals(particularsFromBook, particularsFromBank);
			System.out.println("Particulars are matched according to data matching rule");
		}
		if(withdrawlAmountFromBook.equals(depositAmountFromBank)) {
			System.out.println("Withdrawl amount and deposit amount are matched according to data matching rule");
		}
    
    }
    
	@Then("^verify unmatch record$")
	public void verify_unmatch_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Unmatched");
	
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' UNMATCHED ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()=' SUGGESTED ']/../../datatable-body-cell[1]/div/input
				
				boolean status = driver.findElement(By.xpath("//div[text()=' UNMATCHED ']")).isDisplayed();
				Assert.assertTrue(status);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
			
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Suggested");
	
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' SUGGESTED ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()=' SUGGESTED ']/../../datatable-body-cell[1]/div/input
				
				boolean status = driver.findElement(By.xpath("//div[text()=' SUGGESTED ']")).isDisplayed();
				Assert.assertTrue(status);
				if(testData.get("Particulars").equals("Partially Matched")) {
					System.out.println("Particulars are showing in unmatched tab according to data matching rule");
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
			
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Transposition");
	
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' TRANSPOSITION ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()=' TRANSPOSITION ']/../../datatable-body-cell[1]/div/input
				
				boolean status = driver.findElement(By.xpath("//div[text()=' TRANSPOSITION ']")).isDisplayed();
				Assert.assertTrue(status);
				if(testData.get("Deposits").equals("Transposition")&&testData.get("Withdrawls").equals("Transposition")) {
					System.out.println("Deposits and withdrawls are showing in unmatched tab according to data matching rule");
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	
	
	}
    
    @Then("^verify the bank reconciliation process tab is enabled$")
    public void verify_the_bank_reconciliation_process_tab_is_enabled() throws InterruptedException  {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliatioDetails());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliatioDetails().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationProcessTab());
    	boolean bankreconprocess = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationProcessTab().isEnabled();
    	System.out.println("Bank Reconciliation Process Tab is Enabled : "+bankreconprocess);
    }
    
    @Then("^Verify all the matched entries are displayed under the matched tab for book to bank$")
    public void verify_all_the_matched_entries_are_displayed_under_the_matched_tab_for_book_to_bank() throws InterruptedException {
		String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
		System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
		Assert.assertEquals("Book to Bank", bankReconBasis);
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	String total = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount().getText();
    	
    	String matchedCount = "";
		String ar[] = total.split(" ");
		matchedCount=ar[0];
		int matchedDataCount = Integer.parseInt(matchedCount);
		if(matchedDataCount==0)
		{
			System.out.println("No Matched Data Display");
		}else{
			System.out.println("Total "+matchedDataCount+" Matched Data Display");
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
		String matchedTab = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().getText();
		Assert.assertEquals("Matched Data", matchedTab);
		System.out.println("All the matched records are under Matched Tab");
		
    }
    
    @Then("^Verify all the matched entries are displayed under the matched tab for bank to book$")
    public void verify_all_the_matched_entries_are_displayed_under_the_matched_tab_for_bank_to_book() throws InterruptedException {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
    	
//    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisClose().click();
//    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisDropDown());
//    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisDropDown().click();
    	Thread.sleep(2000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	//Thread.sleep(1000);
    	
    	String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
    	System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
    	Assert.assertEquals("Bank to Book", bankReconBasis);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	String total = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount().getText();
    	
    	String matchedCount = "";
    	String ar[] = total.split(" ");
    	matchedCount=ar[0];
    	int matchedDataCount = Integer.parseInt(matchedCount);
    	if(matchedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+matchedDataCount+" Matched Data Display");
    	}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	String matchedTab = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().getText();
    	Assert.assertEquals("Matched Data", matchedTab);
    	System.out.println("All the matched records are under Matched Tab");
    	
    }
    
    @Then("^Verify the Unmatch Record Tab must display all the entries for unmatched records from uploaded bank statement$")
    public void verify_the_unmatch_record_tab_must_display_all_the_entries_for_unmatched_records_from_uploaded_bank_statement() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(2000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	//Thread.sleep(1000);
    	
    	String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
    	System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
    	Assert.assertEquals("Bank to Book", bankReconBasis);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton().click();  	
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	//Thread.sleep(1000);
    	javascripthelper.scrollIntoViewAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Unmatched");
    	//Thread.sleep(2000);
    	String unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String unmatchedCount = "";
    	String ar[] = unmatched.split(" ");
    	unmatchedCount=ar[0];
    	int unmatchedDataCount = Integer.parseInt(unmatchedCount);
    	if(unmatchedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+unmatchedDataCount+" Unmatched Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Suggested");
    	//Thread.sleep(2000);
    	String suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String suggestedCount = "";
    	String ar1[] = suggested.split(" ");
    	suggestedCount=ar1[0];
    	int suggestedDataCount = Integer.parseInt(suggestedCount);
    	if(suggestedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+suggestedDataCount+" Suggested Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Transposition");
    	
    	//Thread.sleep(2000);
    	String transpostion = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String transpositionCount = "";
    	String ar2[] = transpostion.split(" ");
    	transpositionCount=ar2[0];
    	int transpositionDataCount = Integer.parseInt(transpositionCount);
    	if(transpositionDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+transpositionDataCount+" Transposition Data Display");
    	}
    	
    }
    
    @Then("^Verify the Unmatch Record Tab must display all the entries for unmatched records from Book$")
    public void verify_the_unmatch_record_tab_must_display_all_the_entries_for_unmatched_records_from_book() throws Throwable {
        
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch().click();
    	//Thread.sleep(1000);
//    	javascripthelper.scrollToElemetAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
    	javascripthelper.scrollIntoViewAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Unmatched");
    	//Thread.sleep(2000);
    	String unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String unmatchedCount = "";
    	String ar[] = unmatched.split(" ");
    	unmatchedCount=ar[0];
    	int unmatchedDataCount = Integer.parseInt(unmatchedCount);
    	if(unmatchedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+unmatchedDataCount+" Unmatched Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Suggested");
    	//Thread.sleep(2000);
    	String suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String suggestedCount = "";
    	String ar1[] = suggested.split(" ");
    	suggestedCount=ar1[0];
    	int suggestedDataCount = Integer.parseInt(suggestedCount);
    	if(suggestedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+suggestedDataCount+" Suggested Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("Transposition");
    	
    	//Thread.sleep(2000);
    	String transpostion = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String transpositionCount = "";
    	String ar2[] = transpostion.split(" ");
    	transpositionCount=ar2[0];
    	int transpositionDataCount = Integer.parseInt(transpositionCount);
    	if(transpositionDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+transpositionDataCount+" Transposition Data Display");
    	}
    	
//    	boolean unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedRecord().isDisplayed();
//    	System.out.println("Unmatched records entries are present - "+unmatched);
//    	boolean suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SuggestedRecord().isDisplayed();
//    	System.out.println("Suggested records entries are present - "+suggested);
//    	boolean transposition = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TranspositionRecord().isDisplayed();
//    	System.out.println("Transposition records entries are present - "+transposition);
    	
    	
    }
    
    ///////////////////////////003_001_TC_001/////////////////////////////////
    
    @Then("^select matched record from matched tab$")
    public void select_matched_record_from_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
    	//div[text()=' RRN002 ']/ancestor::div/datatable-body-cell[1]/div/input
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/ancestor::div/datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/ancestor::div/datatable-body-cell[1]/div/input"));
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }

    @Then("^verify system must unmatch the matched record and unmatched record must display in unmatched tab$")
    public void verify_system_must_unmatch_the_matched_record_and_unmatched_record_must_display_in_unmatched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")).isDisplayed();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    }

    @And("^verify the same record should not be displayed in matched tab$")
    public void verify_the_same_record_should_not_be_displayed_in_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
		for (int i = 0; i <= 200; i++) {
			try {
				boolean status = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")).isDisplayed();
				Assert.assertFalse(status);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
    
    ///////////////////////////////003_002_TC_001///////////////////////////////
    
    @Then("^select a unmatched record from bank and one record from book where view basis is book to bank$")
    public void select_a_unmatched_record_from_bank_and_one_record_from_book_where_view_basis_is_book_to_bank() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }
    
    @And("^click on match button in unmatched tab$")
    public void click_on_match_button_in_unmatched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				Assert.assertEquals( "Data Matched Successfully!!!", toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	for (int i = 0; i <= 1000; i++) {
			try {
				javascripthelper.executeScript("document.querySelector('ion-toast').shadowRoot.querySelector('div.toast-button-group.toast-button-group-end>button').click()");
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }

    @Then("^verify system must unmatch a matched record and a single record From Book on Matched Tab$")
    public void verify_system_must_unmatch_a_matched_record_and_a_single_record_from_book_on_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber"));
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i < 35; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton().click();
//    	Thread.sleep(2000);
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				Assert.assertEquals( "Data UnMatched Successfully!!!", toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }

    
    //////////////////////////////003_002_TC_002////////////////////////////////
    
    @Then("^select a unmatched record from bank and one record from book where view basis is bank to book$")
    public void select_a_unmatched_record_from_bank_and_one_record_from_book_where_view_basis_is_bank_to_book() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
//    	Thread.sleep(1000);
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	for (int i = 0; i <= 200; i++) {
    		try {
    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    			break;
    		} catch (Exception e) {
    			// TODO: handle exception
    			if(i==200) {
    				Assert.fail(e.getMessage());
    			}
    		}
    	}
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	//Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton().click();    	
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
    	System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
    	Assert.assertEquals("Bank to Book", bankReconBasis);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click(); 
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("unmatched");
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm().click();
    	
//    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i < 35; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	
    }

    @Then("^verify system must unmatch a matched record and a single record From Bank statement on Matched Tab$")
    public void verify_system_must_unmatch_a_matched_record_and_a_single_record_from_bank_statement_on_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber"));
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i < 35; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton().click();
//    	Thread.sleep(2000);
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				Assert.assertEquals( "Data UnMatched Successfully!!!", toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    
    }
    
    //////////////////////////////003_002_TC_003////////////////////////////////
    
    @Then("^select a suggested record from bank and one record from book where view basis is book to bank$")
    public void select_a_suggested_record_from_bank_and_one_record_from_book_where_view_basis_is_book_to_bank() throws Throwable {
        
    }
    
    //////////////////////////////003_002_TC_004////////////////////////////////
    
    @Then("^select a suggested record from bank and one record from book where view basis is bank to book$")
    public void select_a_suggested_record_from_bank_and_one_record_from_book_where_view_basis_is_bank_to_book() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
		for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
//    	Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i < 50; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
//    	Thread.sleep(1000);
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	for (int i = 0; i <= 200; i++) {
    		try {
    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(testData.get("BankReconciliationBasis"));
    			break;
    		} catch (Exception e) {
    			// TODO: handle exception
    			if(i==200) {
    				Assert.fail(e.getMessage());
    			}
    		}
    	}
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	//Thread.sleep(1000);
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataSaveButton().click();    	
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
    	System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
    	Assert.assertEquals("Bank to Book", bankReconBasis);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click(); 
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearch().sendKeys("suggested");
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_Verify().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyYes().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_VerifyConfirm().click();
    	
//    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
//    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
    
    /////////////////////////////////003_002_TC_005///////////////////////////////////
    
    @Then("^verify system to throw validation while sum of selected records are not matching with sum of records from other side$")
    public void verify_system_to_throw_validation_while_sum_of_selected_records_are_not_matching_with_sum_of_records_from_other_side() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	
    	//ion-grid[2]/descendant::div[text()=' RRN002 ']/../../descendant::input
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBankStatement());
    	String beforexpath = "//ion-grid[2]/descendant::div[text()=' ";
		String afterxpath = " ']/../../descendant::input";
		List<WebElement> elements = driver.findElements(By.xpath(beforexpath+testData.get("ReceiptNumber1")+afterxpath));
		for (WebElement webElement : elements) {
			webElement.click();
		}
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
    	
		for (int i = 0; i <= 200; i++) {
			try {
				String validationMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(validationMessage);
				Assert.assertEquals("Please select proper records Bank side for manual match!!!", validationMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 1000; i++) {
			try {
				javascripthelper.executeScript("document.querySelector('ion-toast').shadowRoot.querySelector('div.toast-button-group.toast-button-group-end>button').click()");
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    }

    @Then("^verify sum of selected record from one side matches with sum of records from other side$")
    public void verify_sum_of_selected_record_from_one_side_matches_with_sum_of_records_from_other_side() throws Throwable {
        javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
        waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
		for (int i = 0; i <= 200; i++) {
			try {
				// div[text()=' ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptNumber") + " ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber1"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
    	
		for (int i = 0; i <= 200; i++) {
			try {
				String validationMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(validationMessage);
				Assert.assertEquals( "Data Matched Successfully!!!", validationMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }
    
    ///////////////////////////004_001_TC_001///////////////////////////

    @Then("^verify Book entry will be matched with Bank entry and will be displayed in Matched Tab$")
    public void verify_book_entry_will_be_matched_with_bank_entry_and_will_be_displayed_in_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
  
    	String beforexpath = "//ion-grid[1]/descendant::div[text()=' ";
		String afterxpath = " ']/../../descendant::input";
		List<WebElement> elements = driver.findElements(By.xpath(beforexpath+testData.get("ReceiptNumber")+afterxpath));
		for (WebElement webElement : elements) {
			webElement.click();
		}
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataMatchButton().click();
		
    
    }

    @Then("^verify Unmatched entry from Bank Side will not be displayed$")
    public void verify_unmatched_entry_from_bank_side_will_not_be_displayed() throws Throwable {
        
    }
    
    /////////////////////////////////004_001_TC_002///////////////////////////////////
    
    
    @Then("^user should match the record manually in unmatched tab$")
    public void user_should_match_the_record_manually_in_unmatched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2().sendKeys(testData.get("ReceiptNumber1"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber1")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    }

    @Then("^select the record from temp view of bank recon for reprocessing$")
    public void select_the_record_from_temp_view_of_bank_recon_for_reprocessing() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton().click();
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView().click();
    	
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton());
		for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().sendKeys(testData.get("BankName"));
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton().click();
    	
    }

    @Then("^click on process button for reprocessing$")
    public void click_on_process_button_for_reprocessing() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButtonForReprocessing());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButtonForReprocessing().click();
//    	alertHelper.getAlert();
    	Thread.sleep(500);
    	alertHelper.isAlertPresent();
    	String alertText = alertHelper.getAlertText();
    	alertHelper.AcceptAlert();
    }

    @Then("^verify post reprocessing bank statement there is no impact on manually matched entries$")
    public void verify_post_reprocessing_bank_statement_there_is_no_impact_on_manually_matched_entries() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));;
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				boolean status = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")).isDisplayed();
				Assert.assertTrue(status);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }
    
    ///////////////////////////004_001_TC_003/////////////////////////////
    
    @Then("^user should unmatch the record manually from matched tab$")
    public void user_should_unmatch_the_record_manually_from_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']/../../datatable-body-cell[1]/div/input")).click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    
    }

    @And("^click on unmatch button in matched tab$")
    public void click_on_unmatch_button_in_matched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataUnmatchButton().click();
    	for (int i = 0; i <= 200; i++) {
			try {
				String toastMessage = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div.toast-message\").innerText").toString();
				System.out.println(toastMessage);
				Assert.assertEquals( "Data UnMatched Successfully!!!", toastMessage);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	for (int i = 0; i <= 1000; i++) {
			try {
				javascripthelper.executeScript("document.querySelector('ion-toast').shadowRoot.querySelector('div.toast-button-group.toast-button-group-end>button').click()");
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
    
    @Then("^verify the unmatch record is in unmatched tab$")
    public void verify_the_unmatch_record_is_in_unmatched_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));;
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				boolean status = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")).isDisplayed();
				Assert.assertTrue(status);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	
    }
    
    @Then("^verify post reprocessing bank statement there is no impact on manually unmatched entries$")
    public void verify_post_reprocessing_bank_statement_there_is_no_impact_on_manually_unmatched_entries() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchButton1().click();
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SearchReceiptRecord().sendKeys(testData.get("ReceiptNumber"));;
    	
    	waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")));
    	for (int i = 0; i <= 200; i++) {
			try {
				//div[text()='  ']/../../datatable-body-cell[1]/div/input
				boolean status = driver.findElement(By.xpath("//div[text()=' "+testData.get("ReceiptNumber")+" ']")).isDisplayed();
				Assert.assertTrue(status);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }

    
    /////////////////////////005_001_TC_001///////////////////////////////
    
    @Then("^verify format of bank reconciliation statement is correct as per FSD$")
    public void verify_format_of_bank_reconciliation_statement_is_correct_as_per_fsd() throws Throwable {
        boolean status = driver.findElement(By.xpath("//b[text()='Balance as per Bank Statement']")).isDisplayed();
        Assert.assertTrue(status);
        boolean status1 = driver.findElement(By.xpath("//b[text()='Balance as per Book']")).isDisplayed();
        Assert.assertTrue(status1);
        boolean status2 = driver.findElement(By.xpath("//b[text()='Adjusted Balance as per Bank Statement']")).isDisplayed();
        Assert.assertTrue(status2);
        boolean status3 = driver.findElement(By.xpath("//b[text()='Adjusted Balance as per Book']")).isDisplayed();
        Assert.assertTrue(status3);
        boolean status4 = driver.findElement(By.xpath("//ion-label[text()='Add: Receipt recorded in Book but missing in Bank Statement']")).isDisplayed();
        Assert.assertTrue(status4);
        boolean status5 = driver.findElement(By.xpath("//ion-label[text()='Add: Receipts recorded in bank statement but missing in Book']")).isDisplayed();
        Assert.assertTrue(status5);
        boolean status6 = driver.findElement(By.xpath("//ion-label[text()='Less: Payment recorded in Book but missing in Bank Statement ']")).isDisplayed();
        Assert.assertTrue(status6);
        boolean status7 = driver.findElement(By.xpath("//ion-label[text()='Less : Payment recorded in bank statement but missing in Book']")).isDisplayed();
        Assert.assertTrue(status7);
        
    }
    
    /////////////////////////005_001_TC_002//////////////////////////////
    @Then("^click on bank reconciliation statement tab$")
    public void click_on_bank_reconciliation_statement_tab() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationStatementTab());
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationStatementTab().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
    
    @Then("^verify system displays correct sum and records in Receipt recorded in Book but missing in Bank Statement head$")
    public void verify_system_displays_correct_sum_and_records_in_receipt_recorded_in_book_but_missing_in_bank_statement_head() throws Throwable {
	 	String value = javascripthelper.executeScript("return document.getElementsByClassName('table table-bordered')[0].innerText").toString();
	 	String tablevalue=value.replaceAll("[/\t]", " ");
	 	System.out.println(tablevalue);
    	
    	ArrayList<String> al=new ArrayList();
    	String xpath ="//ion-label[text()='Add: Receipt recorded in Book but missing in Bank Statement']/../../../ion-row[2]/descendant::tbody/tr/td[3]";
    	List<WebElement> amounts = driver.findElements(By.xpath(xpath));
    	int numberOfAmounts = amounts.size();
    	for (int i = 0; i < 200; i++) {
	 		try {
	 			for (WebElement webElement : amounts) {
	 				javascripthelper.scrollIntoView(webElement);
	 				String receiptsAmount = webElement.getText();
	 				al.add(receiptsAmount);
	 				System.out.println(receiptsAmount);
	 			}
	 			break;
	 		} catch (Exception e) {
	 			if (i==30) {
					break;
				}
	 		}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptAmountRecordedInBook());
    	String receiptAmountRecordedInBook = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptAmountRecordedInBook().getText();
    	System.out.println("Add: Receipt recorded in Book but missing in Bank Statement - "+receiptAmountRecordedInBook);
   
    }
    
    @Then("^verify system displays correct sum and records in Payment recorded in Book but missing in Bank Statement head$")
    public void verify_system_displays_correct_sum_and_records_in_payment_recorded_in_book_but_missing_in_bank_statement_head() throws Throwable {
    	String value = javascripthelper.executeScript("return document.getElementsByClassName('table table-bordered')[1].innerText").toString();
	 	String tablevalue=value.replaceAll("[/\t]", " ");
	 	System.out.println(tablevalue);
    	
    	ArrayList<String> al2=new ArrayList();
    	String xpath ="//ion-label[text()='Less: Payment recorded in Book but missing in Bank Statement ']/../../../ion-row[4]/descendant::tr/td[3]";
	 	for (int i = 0; i < 200; i++) {
	 		try {
	 			List<WebElement> receipts = driver.findElements(By.xpath(xpath));
	 			for (WebElement webElement : receipts) {
	 				javascripthelper.scrollIntoView(webElement);
	 				String receiptsDetails = webElement.getText();
	 				al2.add(receiptsDetails);
	 			}
	 			break;
	 		} catch (Exception e) {
	 			if (i==30) {
					break;
				}
	 		}
		}
	 	
	 	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement());
    	String paymentAmountRecordedInBook = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement().getText();
    	System.out.println("Less: Payment recorded in Book but missing in Bank Statement - "+paymentAmountRecordedInBook);
	 	
    }

    @Then("^verify system displays correct sum and records in Receipts recorded in bank statement but missing in Book head$")
    public void verify_system_displays_correct_sum_and_records_in_receipts_recorded_in_bank_statement_but_missing_in_book_head() throws Throwable {
    	String value = javascripthelper.executeScript("return document.getElementsByClassName('table table-bordered')[2].innerText").toString();
	 	String tablevalue=value.replaceAll("[/\t]", " ");
	 	System.out.println(tablevalue);
	 	
    	ArrayList<String> al3=new ArrayList();
    	String xpath ="//ion-label[text()='Add: Receipts recorded in bank statement but missing in Book']/../../../ion-row[2]/descendant::tr/td[3]";
	 	for (int i = 0; i < 200; i++) {
	 		try {
	 			List<WebElement> receipts = driver.findElements(By.xpath(xpath));
	 			for (WebElement webElement : receipts) {
	 				javascripthelper.scrollIntoView(webElement);
	 				String receiptsDetails = webElement.getText();
	 				al3.add(receiptsDetails);
	 			}
	 			break;
	 		} catch (Exception e) {
	 			if (i==30) {
					break;
				}
	 		}
		}
	 	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptAmountRecordedInBankStatement());
    	String receiptAmountRecordedInBankStatement = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReceiptAmountRecordedInBankStatement().getText();
    	System.out.println("Add: Receipt recorded in Bank Statement but missing in Book - "+receiptAmountRecordedInBankStatement);
    }

    @Then("^verify system displays correct sum and records in Payment recorded in bank statement but missing in Book head$")
    public void verify_system_displays_correct_sum_and_records_in_payment_recorded_in_bank_statement_but_missing_in_book_head() throws Throwable {
    	String value = javascripthelper.executeScript("return document.getElementsByClassName('table table-bordered')[3].innerText").toString();
	 	String tablevalue=value.replaceAll("[/\t]", " ");
	 	System.out.println(tablevalue);
    	
    	
    	ArrayList<String> al4=new ArrayList();
    	String xpath ="//ion-label[text()='Less : Payment recorded in bank statement but missing in Book']/../../../ion-row[4]/descendant::tr/td[3]";
	 	for (int i = 0; i < 200; i++) {
	 		try {
	 			List<WebElement> receipts = driver.findElements(By.xpath(xpath));
	 			for (WebElement webElement : receipts) {
	 				javascripthelper.scrollIntoView(webElement);
	 				String receiptsDetails = webElement.getText();
	 				al4.add(receiptsDetails);
	 			}
	 			break;
	 		} catch (Exception e) {
	 			if (i==30) {
					break;
				}
	 		}
		}
	 	
	 	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement());
    	String paymentAmountRecordedInBankStatement = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement().getText();
    	System.out.println("Less: Payment recorded in Bank Statement but missing in Book - "+paymentAmountRecordedInBankStatement);
	 	
	 	
    }
    
    /////////////////////////005_001_TC_003//////////////////////////////
    
	@Then("^verify adjusted balance as per bank statement must match with adjusted balance as per books$")
	public void verify_adjusted_balance_as_per_bank_statement_must_match_with_adjusted_balance_as_per_books() throws Throwable {
		javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement());
		String adjustedBalanceAsPerBankStatement=bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement().getText();
		System.out.println("Adjusted Balance As Per Bank Statement -"+adjustedBalanceAsPerBankStatement);
		
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AdjustedBalanceAsPerBook());
		String adjustedBalanceAsPerBook=bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AdjustedBalanceAsPerBook().getText();
		System.out.println("Adjusted Balance As Per Book -"+adjustedBalanceAsPerBook);
		Assert.assertEquals(adjustedBalanceAsPerBankStatement, adjustedBalanceAsPerBook);
	}
	
	
    ////////////////////////////////////////////////////////////////////
	@Then("^select data set ID for uploading correct bank recon txt file$")
    public void select_data_set_id_for_uploading_correct_bank_recon_txt_file() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_001_TC_001_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for verifying system throws validation on mismatched data$")
    public void select_data_set_id_for_verifying_system_throws_validation_on_mismatched_data() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_001_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
    @Then("^select data set ID for clicking on process button$")
    public void select_data_set_id_for_clicking_on_process_button() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_001_TC_003_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify matched entries under matched tab$")
    public void select_data_set_id_for_verify_matched_entries_under_matched_tab() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_001_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for clicking on match record and check it displays the match record$")
    public void select_data_set_id_for_clicking_on_match_record_and_check_it_displays_the_match_record() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for clicking on match record and check it matches with multiple record$")
    public void select_data_set_id_for_clicking_on_match_record_and_check_it_matches_with_multiple_record() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_003_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify matched entries under matched tab where View Reconciliation Basis is Bank To Book$")
    public void select_data_set_id_for_verify_matched_entries_under_matched_tab_where_view_reconciliation_basis_is_bank_to_book() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_004_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for Click on a match record and check it displays the match record from book$")
    public void select_data_set_id_for_click_on_a_match_record_and_check_it_displays_the_match_record_from_book() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_005_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for clicking on match record and check it matches with multiple record from Book$")
    public void select_data_set_id_for_clicking_on_match_record_and_check_it_matches_with_multiple_record_from_book() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_006_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify match record basis data matching rule$")
    public void select_data_set_id_for_verify_match_record_basis_data_matching_rule() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_002_TC_007_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify unmatch record basis data matching rule$")
    public void select_data_set_id_for_verify_unmatch_record_basis_data_matching_rule() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_003_TC_003_D1";
    	testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for unmatched records from uploaded bank statement$")
    public void select_data_set_id_for_unmatched_records_from_uploaded_bank_statement() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_003_TC_001_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^select data set ID for unmatched records from Book$")
    public void select_data_set_id_for_unmatched_records_from_book() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_002_003_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify system must unmatch a matched record$")
    public void select_data_set_id_for_verify_system_must_unmatch_a_matched_record() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_003_001_TC_001_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for verify system must unmatch a matched record and a single record From Bank statement on Matched Tab$")
    public void select_data_set_id_for_verify_system_must_unmatch_a_matched_record_and_a_single_record_from_bank_statement_on_matched_tab() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_003_002_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^select data set ID for verify system must unmatch a matched record and a single record From Book on Matched Tab$")
    public void select_data_set_id_for_verify_system_must_unmatch_a_matched_record_and_a_single_record_from_book_on_matched_tab() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_003_002_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID for Verify sum of selected record from one side matches with sum of records from other side$")
    public void select_data_set_id_for_verify_sum_of_selected_record_from_one_side_matches_with_sum_of_records_from_other_side() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_003_002_TC_005_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID to verify Bank Recon Process screen post creating additional entries$")
    public void select_data_set_id_to_verify_bank_recon_process_screen_post_creating_additional_entries() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_004_001_TC_001_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^select data set ID to Verify post reprocessing bank statement there is no impact on manually matched entries$")
    public void select_data_set_id_to_verify_post_reprocessing_bank_statement_there_is_no_impact_on_manually_matched_entries() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_004_001_TC_002_D1";
		testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID to Verify post reprocessing bank statement there is no impact on manually unmatched entries$")
    public void select_data_set_id_to_verify_post_reprocessing_bank_statement_there_is_no_impact_on_manually_unmatched_entries() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_004_001_TC_003_D1";
    	testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID to verify format of Bank Reconciliation statement is correct as per FSD$")
    public void select_data_set_id_to_verify_format_of_bank_reconciliation_statement_is_correct_as_per_fsd() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_005_001_TC_001_D1";
    	testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID to verify system must display correct sum and records as per logics given in FSD$")
    public void select_data_set_id_to_verify_system_must_display_correct_sum_and_records_as_per_logics_given_in_fsd() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_005_001_TC_002_D1";
    	testData = excelData.getTestdata(dataSetID);
    }
    
    @Then("^select data set ID to check Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books$")
    public void select_data_set_id_to_check_adjusted_balance_as_per_bank_statement_must_match_with_adjusted_balance_as_per_books() throws Throwable {
    	dataSetID = "KUBS_TAX_UAT_005_001_TC_003_D1";
    	testData = excelData.getTestdata(dataSetID);
    }
    
    
    
    
    
	
    @Then("^cancel the process record from temp view$")
    public void cancel_the_process_record_from_temp_view() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_InboxButton().click();
    	javascripthelper.scrollIntoView(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
		waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempView().click();
    	for (int i = 0; i <= 200; i++) {
			try {
				bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	for (int i = 0; i <= 200; i++) {
    		try {
//    			waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().isDisplayed();
    			break;
    			
    		} catch (Exception e) {
    			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TempViewSearchButton().click();
    		}
		}
    	
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankNameSearch().sendKeys(testData.get("BankName"));
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_firstRecordActionButton().click();
    	waithelper.waitForElementwithFluentwait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_cancelButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_cancelButton().click();
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys("cancel");
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	
    }
}