package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.PettyCash_ReconciliationObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_ManualPayoutTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.PettyCash_ReconciliationTestDataType;
import testDataType.Reports_PettyCashTestDataType;

public class PettyCash_Reconciliation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
//	ACCOUNTSPAYABLE_ManualPayoutObj aCCOUNTSPAYABLE_ManualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	PettyCash_ReconciliationObj ReconciliationObj = new PettyCash_ReconciliationObj(driver);
//	ACCOUNTSPAYABLE_ManualPayoutTestDataType aCCOUNTSPAYABLE_ManualPayoutTestDataType=jsonReader.getManualPayoutdata("Maker");
	Reports_PettyCashTestDataType PettyCashTestDataType=jsonReader.getPettyCashdata("Maker");
	PettyCash_ReconciliationTestDataType ReconciliationTestDataType=jsonReader.getReconciliationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper=new BrowserHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	
//-------- KUBS_PC_UAT_006 ------------
    
	
	@And("^user should navigate to petty cash menu$")
	public void user_should_navigate_to_petty_cash_menu()  {
		
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_DirctionIcon());
		ReconciliationObj.PettyCash_Reconciliation_DirctionIcon().click();
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_PettyCashMenu());
		ReconciliationObj.PettyCash_Reconciliation_PettyCashMenu().click();
	}
	
	@When("^click on eye button of reconciliation$")
    public void click_on_eye_button_of_reconciliation(){
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_EyeButton());
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.PettyCash_Reconciliation_EyeButton());
    }
	
	@And("^Fill the required fields for reconciliation$")
	public void fill_the_required_fields_for_reconciliation()  {
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_PhysicalCashInHand());
		ReconciliationObj.PettyCash_Reconciliation_PhysicalCashInHand().sendKeys(ReconciliationTestDataType.PhysicalCashInHand);
		ReconciliationObj.PettyCash_Reconciliation_Currency().sendKeys(ReconciliationTestDataType.Currency);
	}
	
	@Then("^Save and submit the reconciliation$")
    public void save_and_submit_the_reconciliation() throws InterruptedException, IOException, ParseException  {
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_SaveButton());
		ReconciliationObj.PettyCash_Reconciliation_SaveButton().click();
		
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		
		WebElement recordstatus = ReconciliationObj.PettyCash_Reconciliation_ApprovalRecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = ReconciliationObj.PettyCash_Reconciliation_ApprovalRecordStatus().getText();
    	System.out.println(message);
    	ReconciliationObj.PettyCash_Reconciliation_ApprovalRecordStatus().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
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
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(ReconciliationTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus1 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus1);
    	
    	String message1 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message1);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	
    	String emptystring = "";
		String ar[] = message1.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
		
    }
	
	@Then("^click on first eye button of new record$")
	public void click_on_first_eye_button_of_new_record() {
		waithelper.waitForElement(driver, 3000, ReconciliationObj.PettyCash_Reconciliation_FirstRecordEyeButton());
		ReconciliationObj.PettyCash_Reconciliation_FirstRecordEyeButton().click();
	}

	@Then("^Balance should tally$")
	public void balance_should_tally() {
		javascripthelper.JavaScriptHelper(driver);
		String status = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[5].value").toString();
		System.out.println("Reconciliation Status - " +status);
	}
	
	
//	-----------------PETTY CASH REPORTS-------------------//
	
	@Then("^click on temp grid button of fund requisition report$")
	public void click_on_temp_grid_button_of_fund_requisition_report() throws InterruptedException {
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_FundRequisitionTempView());
	}

	@And("^select the date to check the fund requisition details are displaying$")
	public void select_the_date_to_check_the_fund_requisition_details_are_displaying() throws InterruptedException {
		
		waithelper.waitForElement(driver, 3000, ReconciliationObj.Reports_PettyCash_Calendar1());
		ReconciliationObj.Reports_PettyCash_Calendar1().click();
		
		Thread.sleep(2000);
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Month+" "+PettyCashTestDataType.FundRequisition_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Month+" "+PettyCashTestDataType.FundRequisition_Year+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(PettyCashTestDataType.FundRequisition_Year);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.FundRequisition_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_Year+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_Year+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth+" "+PettyCashTestDataType.FundRequisition_Year+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth +" "+PettyCashTestDataType.FundRequisition_Date+", "+PettyCashTestDataType.FundRequisition_Year+"']/span")));	
		WebElement FundRequisitionDate=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.FundRequisition_FullMonth +" "+PettyCashTestDataType.FundRequisition_Date+", "+PettyCashTestDataType.FundRequisition_Year+"']/span"));
		clicksAndActionHelper.doubleClick(FundRequisitionDate);
		
	}

	@Then("^the report is displaying all fund requisition details$")
	public void the_report_is_displaying_all_fund_requisition_details() throws InterruptedException {
		Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, ReconciliationObj.Reports_PettyCash_FundRequisitionReport());
		ReconciliationObj.Reports_PettyCash_FundRequisitionReport().isDisplayed();
		browserHelper.switchToParentWithChildClose();
	}
	
	@Then("^click on temp grid button of petty cash receipt report$")
    public void click_on_temp_grid_button_of_petty_cash_receipt_report() throws InterruptedException  {
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_PettyCashReceiptTempView());
    }

	@And("^select the date to check the petty cash receipt details are displaying$")
	public void select_the_date_to_check_the_petty_cash_receipt_details_are_displaying() throws InterruptedException  {
		
		waithelper.waitForElement(driver, 3000, ReconciliationObj.Reports_PettyCash_Calendar1());
		ReconciliationObj.Reports_PettyCash_Calendar1().click();
		
		Thread.sleep(2000);
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Month+" "+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Month+" "+PettyCashTestDataType.PettyCashReceipt_Year+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(PettyCashTestDataType.PettyCashReceipt_Year);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashReceipt_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_Year+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_Year+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth+" "+PettyCashTestDataType.PettyCashReceipt_Year+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth +" "+PettyCashTestDataType.PettyCashReceipt_Date+", "+PettyCashTestDataType.PettyCashReceipt_Year+"']/span")));	
		WebElement ReceiptDate=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashReceipt_FullMonth +" "+PettyCashTestDataType.PettyCashReceipt_Date+", "+PettyCashTestDataType.PettyCashReceipt_Year+"']/span"));
		clicksAndActionHelper.doubleClick(ReceiptDate);
		
	}
	
    @Then("^the report is displaying all the petty cash receipt details$")
    public void the_report_is_displaying_all_the_petty_cash_receipt_details() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 10000, ReconciliationObj.Reports_PettyCash_PettyCashReceiptReport());
    	ReconciliationObj.Reports_PettyCash_PettyCashReceiptReport().isDisplayed();
    	browserHelper.switchToParentWithChildClose();
    }
    
    @Then("^click on temp grid button of petty cash register report$")
    public void click_on_temp_grid_button_of_petty_cash_register_report() throws InterruptedException  {
    	Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoViewAndClick(ReconciliationObj.Reports_PettyCash_PettyCashRegisterTempView());
    }

    @And("^select the date to check the petty cash register details are displaying$")
    public void select_the_date_to_check_the_petty_cash_register_details_are_displaying() throws InterruptedException  {
    	waithelper.waitForElement(driver, 3000, ReconciliationObj.Reports_PettyCash_Calendar1());
    	ReconciliationObj.Reports_PettyCash_Calendar1().click();
    	
    	Thread.sleep(2000);
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Month+" "+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Month+" "+PettyCashTestDataType.PettyCashRegister_Year+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(PettyCashTestDataType.PettyCashRegister_Year);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+PettyCashTestDataType.PettyCashRegister_Year+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_Year+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_Year+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth+" "+PettyCashTestDataType.PettyCashRegister_Year+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth +" "+PettyCashTestDataType.PettyCashRegister_Date+", "+PettyCashTestDataType.PettyCashRegister_Year+"']/span")));	
		WebElement registerDate=driver.findElement(By.xpath("//td[@aria-label='"+PettyCashTestDataType.PettyCashRegister_FullMonth +" "+PettyCashTestDataType.PettyCashRegister_Date+", "+PettyCashTestDataType.PettyCashRegister_Year+"']/span"));
		clicksAndActionHelper.doubleClick(registerDate);
    }
    
    @Then("^the report is displaying all the petty cash register details$")
    public void the_report_is_displaying_all_the_petty_cash_register_details() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 10000, ReconciliationObj.Reports_PettyCash_PettyCashRegisterReport());
    	ReconciliationObj.Reports_PettyCash_PettyCashRegisterReport().isDisplayed();
    	browserHelper.switchToParentWithChildClose();
    }



	
}