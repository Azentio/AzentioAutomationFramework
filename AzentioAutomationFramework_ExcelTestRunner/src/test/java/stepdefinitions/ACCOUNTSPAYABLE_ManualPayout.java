package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_ManualPayoutTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class ACCOUNTSPAYABLE_ManualPayout {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_ManualPayoutObj aCCOUNTSPAYABLE_ManualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLE_ManualPayoutTestDataType aCCOUNTSPAYABLE_ManualPayoutTestDataType=jsonReader.getManualPayoutdata("Maker");
//	ACCOUNTSPAYABLE_InvoiceBookingTestDataType aCCOUNTSPAYABLE_InvoiceBookingTestDataType=jsonReader.getInvoiceBookingdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	
//--------  KUBS_AR/AP_UAT_006_001_TC_01 ------------
    
//    @When("^click on eye button of manual payout$")
//    public void click_on_eye_button_of_manual_payout() throws InterruptedException {
//    	javascripthelper.JavaScriptHelper(driver);
//    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EyeButton());
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EyeButton());
//    	aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EyeButton().click();
//    }

    @And("^click on add button for manual payout$")
    public void click_on_add_button_for_manual_payout() {
    	//waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_AddButton());
    	for (int i = 0; i <200; i++) {
			try {
				aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_AddButton().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }

    @And("^Fill the required fields for manual payout vendor$")
    public void fill_the_required_fields_for_manual_payout_vendor() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		
		//Entity Branch name
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.EntityBranch);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(Keys.ENTER);
		
		//bp name
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BP_Name);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(Keys.ENTER);
		
		//benificiary name
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BeneficiaryName);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(Keys.ENTER);
		
		//currency
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.Currency);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(Keys.ENTER);
		
//		payment bank
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.PaymentBank);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(Keys.ENTER);
		
		//bank account number
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BankAccountNumber);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.PaymentMode);
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(Keys.ENTER);
		
		//reference number
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ReferenceNumber);
		
		//cheque number
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ChequeNumber);
		
		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Footer());
		
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.Remarks);
		
		String beforexpath = "//div[contains(text(),'";
		String afterxpath = "')]/../../datatable-body-cell/div/ion-checkbox";
		driver.findElement(By.xpath(beforexpath+aCCOUNTSPAYABLE_ManualPayoutTestDataType.PaymentApprovalTxnNumber+afterxpath)).click();
		
    }
    
    @Then("^Save and submit the manual payout record$")
    public void save_and_submit_the_manual_payout_record() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
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
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
    
//    @And("^approve the record by the reviewer user$")
//		public void approve_the_record_by_the_reviewer_user() throws InterruptedException, IOException {
//		browserHelper = new BrowserHelper(driver);
//		String before_xpath = "//datatable-row-wrapper[";
//		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
//		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
//		
//		for (int i = 1; i < 10; i++) {
//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
//			String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			
//			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)));
//			driver.findElement(By.xpath(before_xpath + i
//					+ after_xpath_for_action)).click();
//			
//				//reader.addReferanceData(referance_id);
//				
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
//				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ApprovedByReviewer);
//				waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
//		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//		    	clicksAndActionHelper.moveToElement(recordstatus);
//		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
//		    	System.out.println(message);
//		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
//				break;
//		}
//	}
    
    @Then("^checker should approved the manual payout record$")
	public void checker_should_approved_the_manual_payout_record() throws IOException, ParseException, InterruptedException {
		Thread.sleep(2000);
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ApprovedByChecker);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		
		waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    }
    
    @Then("^Get the payout status$")
    public void get_the_payout_status()  {
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Search());
    	aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Search().click();
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BusinessPartnerSearch());
    	aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BusinessPartnerSearch().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BP_Name);
    	System.out.println("Payout Status is - " +aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PayoutStatus().getText());
       
    }
    
	@And("^Fill the required fields for verify cancelled payment txn availability$")
	public void fill_the_required_fields_for_verify_cancelled_payment_txn_availability() throws InterruptedException, IOException, ParseException  {
//		javascripthelper.JavaScriptHelper(driver);
//		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.EntityBranch);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BP_Name);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().click();
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BeneficiaryName);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.Currency);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.PaymentBank);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().click();
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.BankAccountNumber);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.PaymentMode);
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(Keys.ENTER);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ReferenceNumber);
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.ChequeNumber);
//	
//		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Footer());
////		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark());
//		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark().sendKeys(aCCOUNTSPAYABLE_ManualPayoutTestDataType.Remarks);
	
		
//		Thread.sleep(2000);
		javascripthelper.scrollToElemetAndClick(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Footer());
		
		while(true)
		{
			try {
				//div[contains(text(),'PAN-246-2022-04-19')]/../../datatable-body-cell/div/ion-checkbox
				String beforexpath = "//div[contains(text(),'";
				String afterxpath = "')]";
				
				driver.findElement(By.xpath(beforexpath+aCCOUNTSPAYABLE_ManualPayoutTestDataType.CancelledPaymentTxnNumber+afterxpath)).isDisplayed();
                System.out.println("Cancelled payment txn is available");
				Assert.fail();
			
				
			}
			catch(NoSuchElementException nosuchElement) {
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ClickOnNextButton());
				try {
//						waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ClickOnNextButton());
						aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ClickOnNextButton().click();
				}
				catch(Exception ee) {
					System.out.println("Cancelled payment txn is not available");
					break;
				}
			}
		}
	}
	
}