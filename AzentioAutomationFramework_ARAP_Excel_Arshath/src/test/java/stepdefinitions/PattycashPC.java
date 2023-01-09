package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.PettyCash_ReconciliationObj;
import pageobjects.Reports_AssetCreationCommonObj;
import resources.BaseClass;
import resources.ExcelData;


public class PattycashPC {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx", "Pettycashtestdata", "DataSet ID");
	Map<String, String>testData;
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	Reports_AssetCreationCommonObj reports_AssetCreationCommonObj = new Reports_AssetCreationCommonObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	PettyCash_ReconciliationObj ReconciliationObj = new PettyCash_ReconciliationObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Map<String, String> Getdata = new LinkedHashMap<>();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

	
	
	/*@Given("^User should go to the kubs url and login as a maker user$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_maker_user() throws InterruptedException  {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Maker");
	}*/
	 
    @Then("^click on report icon$")
    public void click_on_report_icon() throws InterruptedException {
    	Thread.sleep(2000);
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
    }
    @And("^user should navigate to reports menu$")
	public void user_should_navigate_to_reports_menu()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon().click();
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu().click();
	}
    @Then("^click on temp grid button of fund requisition report$")
	public void click_on_temp_grid_button_of_fund_requisition_report() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_FundRequisitionTempView());
	}
    @And("^select the date to check the fund requisition details are displaying$")
	public void select_the_date_to_check_the_fund_requisition_details_are_displaying() throws InterruptedException {
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_Calendar1(), 60, 500);
		ReconciliationObj.Reports_PettyCash_Calendar1().click();
		
		
		
		while(true)
		{
			try 
			{
				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Month+" "+PettyCashTestDataType.FundRequisition_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Month")+" "+testData.get("FundRequisition_Year")+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				//bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
				//String tablehead="6016 ~ 6036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("FundRequisition_Year"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							//bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							//bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FundRequisition_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_Year")+"']")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_Year")+"']"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth")+" "+testData.get("FundRequisition_Year")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth") +" "+testData.get("FundRequisition_Date")+", "+testData.get("FundRequisition_Year")+"']/span")), 60, 500);	
		WebElement FundRequisitionDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FundRequisition_FullMonth") +" "+testData.get("FundRequisition_Date")+", "+testData.get("FundRequisition_Year")+"']/span"));
		clicksAndActionHelper.doubleClick(FundRequisitionDate);
		
	}
    @Then("^click in the view button to check$")
    public void click_in_the_view_button_to_check()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton().click();
    }
    @Then("^the report is displaying all fund requisition details$")
	public void the_report_is_displaying_all_fund_requisition_details() throws InterruptedException {
		Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_FundRequisitionReport(), 60, 500);
		ReconciliationObj.Reports_PettyCash_FundRequisitionReport().isDisplayed();
		browserHelper.switchToParentWithChildClose();
	}

	@Then("^click on temp grid button of petty cash receipt report$")
    public void click_on_temp_grid_button_of_petty_cash_receipt_report() throws InterruptedException  {
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_PettyCashReceiptTempView());
    }
	@And("^select the date to check the petty cash receipt details are displaying$")
	public void select_the_date_to_check_the_petty_cash_receipt_details_are_displaying() throws InterruptedException  {
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_Calendar1(), 60, 500);
		ReconciliationObj.Reports_PettyCash_Calendar1().click();
		
		
		while(true)
		{
			try 
			{
				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Month+" "+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Month")+" "+testData.get("PettyCashReceipt_Year")+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				//bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="6016 ~ 6036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("PettyCashReceipt_Year"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashReceipt_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year") +"']")).click();
					
				}
				else
				{
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_Year")+"']")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_Year")+"']"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth")+" "+testData.get("PettyCashReceipt_Year")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth") +" "+testData.get("PettyCashReceipt_Date")+", "+testData.get("PettyCashReceipt_Year")+"']/span")), 60, 500);	
		WebElement ReceiptDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashReceipt_FullMonth") +" "+testData.get("PettyCashReceipt_Date")+", "+testData.get("PettyCashReceipt_Year")+"']/span"));
		clicksAndActionHelper.doubleClick(ReceiptDate);
		
	}

    @Then("^the report is displaying all the petty cash receipt details$")
    public void the_report_is_displaying_all_the_petty_cash_receipt_details() throws InterruptedException {
//    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
    	waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_PettyCashReceiptReport(), 60, 500);
    	ReconciliationObj.Reports_PettyCash_PettyCashReceiptReport().isDisplayed();
    	browserHelper.switchToParentWithChildClose();
    }

    @Then("^click on temp grid button of petty cash register report$")
    public void click_on_temp_grid_button_of_petty_cash_register_report() throws InterruptedException  {
//    	Thread.sleep(6000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_PettyCashRegisterTempView());
    }
    @And("^select the date to check the petty cash register details are displaying$")
    public void select_the_date_to_check_the_petty_cash_register_details_are_displaying() throws InterruptedException  {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_Calendar1(), 60, 500);
    	ReconciliationObj.Reports_PettyCash_Calendar1().click();
//    	
//    	Thread.sleep(6000);
		while(true)
		{
			try 
			{
				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Month+" "+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Month")+" "+testData.get("PettyCashRegister_Year")+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="6016 ~ 6036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(testData.get("PettyCashRegister_Year"));
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							//waithelper.waitForElementwithFluentwait(driver, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("PettyCashRegister_Year")+"')]"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")).click();
					
				}
				else
				{
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_Year")+"']")), 60, 500);
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_Year")+"']"));
					Year.click();
					
					waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")), 60, 500);
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth")+" "+testData.get("PettyCashRegister_Year")+"']")).click();
					
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth") +" "+testData.get("PettyCashRegister_Date")+", "+testData.get("PettyCashRegister_Year")+"']/span")), 60, 500);	
		WebElement registerDate=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("PettyCashRegister_FullMonth") +" "+testData.get("PettyCashRegister_Date")+", "+testData.get("PettyCashRegister_Year")+"']/span"));
		clicksAndActionHelper.doubleClick(registerDate);
    }
    @Then("^the report is displaying all the petty cash register details$")
    public void the_report_is_displaying_all_the_petty_cash_register_details() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
    	waithelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_PettyCashRegisterReport(), 60, 500);
    	ReconciliationObj.Reports_PettyCash_PettyCashRegisterReport().isDisplayed();
    	browserHelper.switchToParentWithChildClose();
    }
    @Then("^user update the Excel sheet testdata for Pettycash$")
    public void user_update_the_excel_sheet_testdata_for_pettycash() throws Throwable {
    	 testData = Exceldata.getTestdata("KUBS_PC_UAT_006_001_D1");    
    	 }
    @Then("^user update the Excel sheet testdata for Pettycashs$")
    public void user_update_the_excel_sheet_testdata_for_pettycashs() throws Throwable {
    	 testData = Exceldata.getTestdata("KUBS_PC_UAT_006_002_D1");    
    	 }
    @Then("^user update the Excel sheet testdata for Pettycashss$")
    public void user_update_the_excel_sheet_testdata_for_pettycashss() throws Throwable {
    	 testData = Exceldata.getTestdata("KUBS_PC_UAT_006_003_D1");    
    	 }
}
