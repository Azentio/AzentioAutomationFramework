package stepdefinitions;

import java.io.IOException;
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
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentSettlementCancellationObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.Enquiry_Obj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_CheckerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

public class ACCOUNTSPAYABLE_PaymentSettlementCancellation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_ManualPayoutObj aCCOUNTSPAYABLE_ManualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLE_PaymentSettlementCancellationObj aCCOUNTSPAYABLE_PaymentSettlementCancellationObj = new ACCOUNTSPAYABLE_PaymentSettlementCancellationObj(driver);
	ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType PaymentSettlementCancellationTestDataType=jsonReader.getPaymentSettlementCancellationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","ARAP2TestData","Data Set ID");
	Map<String, String> arap;
	
//--------  @KUBS_AR/AP_UAT_005_002_TC_01  ------------
    
    @When("^click on eye button of payment settlement cancellation$")
    public void click_on_eye_button_of_payment_settlement_cancellation() throws InterruptedException {
//    	javascripthelper.JavaScriptHelper(driver);
//    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton().click();
    }
    //

    @And("^click on add button for payment settlement cancellation$")
    public void click_on_add_button_for_payment_settlement_cancellation() {
    	//waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton());
    	for (int i = 0; i < 60; i++) {
			try {
		    	    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton().click();
		    	    	break;
			}
			catch(Exception e) {
			}
			}
    }

    @And("^Fill the required fields for payment settlement cancellation$")
    public void fill_the_required_fields_for_payment_settlement_cancellation() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(arap.get("EntityBranch"));
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(arap.get("PaymentTxnNumber"));
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.ENTER);
		
		
//		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Footer());
//		
//		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Remark());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Remark().sendKeys(PaymentSettlementCancellationTestDataType.Remarks);
		
		
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_ValueDateCalendar().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + arap.get("ValueMonth")+ " "
						+ arap.get("ValueYear") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + arap.get("ValueMonth") + " " + arap.get("ValueYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
			}
		}
		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + arap.get("ValueFullMonth") + " "
				+ arap.get("ValueDate") + ", " + arap.get("ValueYear") + "']/span"));
		clicksAndActionHelper.doubleClick(ValueDate);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(arap.get("CancellationReasonCode"));
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(arap.get("CancellationRemark"));
    }
    
    @Then("^Save and submit the payment settlement cancellation record$")
    public void save_and_submit_the_payment_settlement_cancellation_record() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		for (int i = 0; i <200; i++) {
		try {	
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		}
		catch(Exception e){
		}
		}
		
    
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		//jsonWriter.addReferanceData(id);
		excelData.updateTestData("KUBS_AR/AP_UAT_005_002_TC_01_D1","Reference ID",id);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_01_D1");
		
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +arap.get("Reference ID")+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +arap.get("Reference ID")+ "')]"));	
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
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +arap.get("Reference ID")+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +arap.get("Reference ID")+after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(arap.get("remark"));
		
    	//waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	for (int i = 0; i < 100; i++) {
			try {
		
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	break;
			}
			catch(Exception e) {
			}
			}
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
		System.out.println(reviewerId);
		//jsonWriter=new JsonDataReaderWriter();
		//jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_AR/AP_UAT_005_002_TC_01_D1","Reviewer ID",reviewerId);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_01_D1");
    }
    @And("^Click on claim button in checker in arap$")
	public void click_on_claim_button_in_checker_in_arap() throws IOException, ParseException {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		// String after_xpath = ;
		
		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath_claim)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
    @And("^Fill the required fields for verify cancelled payment txn availability in arap$")
	public void fill_the_required_fields_for_verify_cancelled_payment_txn_availability_in_arap() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch());
		System.out.println(arap.get("EntityBranch"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(arap.get("EntityBranch"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_EntityBranch().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(arap.get("BP_Name"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BP_Name().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(arap.get("BeneficiaryName"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(arap.get("Currency"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Currency().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(arap.get("PaymentBank"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentBank().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(arap.get("BankAccountNumber"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(arap.get("PaymentMode"));
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_PaymentMode().sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(arap.get("ReferenceNumber"));
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(arap.get("ChequeNumber"));
	
		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Footer());
//		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Remark().sendKeys(arap.get("Remarks"));
	
		
//		Thread.sleep(2000);
		javascripthelper.scrollToElemetAndClick(aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_Footer());
		
		while(true)
		{
			try {
				//div[contains(text(),'PAN-246-2022-04-19')]/../../datatable-body-cell/div/ion-checkbox
				String beforexpath = "//div[contains(text(),'";
				String afterxpath = "')]";
				
				driver.findElement(By.xpath(beforexpath+arap.get("CancelledPaymentTxnNumber")+afterxpath)).isDisplayed();
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
	

    @Then("^checker should approved the manual payout record in arap$")
	public void checker_should_approved_the_manual_payout_record_in_arap() throws IOException, ParseException, InterruptedException {
		Thread.sleep(2000);
		//
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" +arap.get("Reference ID")+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + arap.get("Reference ID") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		Thread.sleep(2000);
		//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		//+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		for (int i = 0; i < 100; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" +arap.get("Reference ID")+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
			}
			catch(Exception e)
			{
			}
			}
		
	
		
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		for (int i = 0; i < 100; i++) {
		try {	
			kubschecker.checkerApproveButton().click();
			break;
		}
		catch(Exception e) {
		}}
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(arap.get("approvalCommentsFromChecker"));
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
    @And("^approve the record by the reviewer user in arap$")
	public void approve_the_record_by_the_reviewer_user_in_arap() throws InterruptedException, IOException {
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
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(arap.get("approvalCommentsFromReviewer"));
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

    
    @And("^Fill the required fields for payment settlement cancellation of aprroved payout and verify$")
    public void fill_the_required_fields_for_payment_settlement_cancellation_of_aprroved_payout_and_verify() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(PaymentSettlementCancellationTestDataType.EntityBranch);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(PaymentSettlementCancellationTestDataType.PayoutApprovedPaymentTxnNumber);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.ENTER);
		
		String noitemfound=aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_ManualPayout_PaymentTxnNumberDropdown().getText();
		System.out.println(noitemfound+ " : The aprroved payout txn number is not available for cancellation of payment settlement.");
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_ValueDateCalendar().click();
//		Thread.sleep(2000);
//		javascripthelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " "
//						+ PaymentSettlementCancellationTestDataType.ValueYear + "')]")));
//				WebElement monthAndYear = driver.findElement(By.xpath(
//						"//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " " + PaymentSettlementCancellationTestDataType.ValueYear + "')]"));
//				break;
//			}
//
//			catch (NoSuchElementException nosuchElement) {
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
//			}
//		}
//		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + PaymentSettlementCancellationTestDataType.ValueFullMonth + " "
//				+ PaymentSettlementCancellationTestDataType.ValueDate + ", " + PaymentSettlementCancellationTestDataType.ValueYear + "']/span"));
//		clicksAndActionHelper.doubleClick(ValueDate);
//		
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(PaymentSettlementCancellationTestDataType.CancellationReasonCode);
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
//		
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(PaymentSettlementCancellationTestDataType.CAncellationRemark);
    }
    
    //test case 03
    ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
    INVENTORY_EnquiryGlObject inventoryEnquiryGlObj=new INVENTORY_EnquiryGlObject(driver);
    WaitHelper waitHelper = new WaitHelper(driver);
    JavascriptHelper javascriptHelper = new JavascriptHelper();
    ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
    INVENTORY_EnquiryGlObject glObj = new INVENTORY_EnquiryGlObject(driver);
    ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
    
    
    @And("^search for approved record in view area in arap$")
    public void search_for_approved_record_in_view_area_in_arap() throws Throwable {
		paymentSettlementObj.paymentSettlementSearchTXNNumber().click();
		paymentSettlementObj.paymentSettlementSearchTXNNumber().sendKeys(arap.get("Search"));
    }
	@And("^get the approved record from list view in arap$")
	public void get_the_approved_record_from_list_view_in_arap() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableApprovedSettlementRefNo(), 2000, 100);
		String approvedReferenceNumber = paymentSettlementObj.accountsPayableApprovedSettlementRefNo().getText();
		arap.put("approvedReferenceNumber", approvedReferenceNumber);
		System.out.println("Settlement Reference Number" + arap.get("approvedReferenceNumber"));
	}
	@And("^choose branch code in arap$")
	public void choose_branch_code_in_arap() throws Throwable {
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(arap.get("branchCode"));
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}
	@Then("^choose the from date in arap$")
	public void choose_the_from_date_in_arap() throws Throwable {
		
		javascriptHelper.JavaScriptHelper(driver);
		
//		for(int i=0; i<30; i++) {
//			
//			try {
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonthYear")+"')]")));
//				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonthYear")+"')]"));
//				monthAndYear.click();
//				
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlYear")+"')]")));
//				WebElement year=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlYear")+"')]"));
//				year.click();
//				
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonth")+"')]")));
//				WebElement month=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonth")+"')]"));
//				month.click();
//				
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlDay")+"')]")));
//				WebElement date=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlDay")+"')]"));
//				date.click();
//				break;
//			} catch (Exception e) {
//				if(i==30) {
//					Assert.fail(e.getMessage());
//				}
//			}
//		}
		
		
		
		while(true)
        {
		try
		{
		
			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonth")+" "+arap.get("GlYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlMonth")+" "+arap.get("GlYear")+"')]"));
  	     break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			//inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arap.get("GlFullMonth")+" "+arap.get("GlDay")+", "+arap.get("GlYear")+"']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}
	@Then("^choose the to date in arap$")
	public void choose_the_to_date_in_arap() throws Throwable {
		while(true)
        {
		try
		{
		
			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlToMonth")+" "+arap.get("GlToYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("GlToMonth")+" "+arap.get("GlToYear")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			//inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arap.get("GlFullToMonth")+" "+arap.get("GlToDate")+", "+arap.get("GlToYear")+"']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}
	@And("^give the refrence number which we going to see accounting entries in arap$")
    public void give_the_refrence_number_which_we_going_to_see_accounting_entries_in_arap() throws Throwable {
		
		for(int i=0; i<30; i++) {
			try {
				glObj.glTransactionReferenceNumber().click();
				glObj.glTransactionReferenceNumber().sendKeys(arap.get("approvedReferenceNumber"));
				glObj.glTransactionReferenceNumber().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if(i==30) {
					Assert.fail(e.getMessage());
				}
			
			}
		}
		
    }
	@Then("^verify approved settlement reference number is available in the Gl report in arap$")
	public void verify_approved_settlement_reference_number_is_available_in_the_gl_report_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for(int i=0; i<20; i++) {
			try {
				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ arap.get("approvedReferenceNumber") + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
						+ arap.get("approvedReferenceNumber") + "')])[1]"));
				String TransactionType = driver
					.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
							+ arap.get("approvedReferenceNumber")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ arap.get("approvedReferenceNumber")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;
			} catch (Exception e) {
				if(i==20) {
					Assert.fail(e.getMessage());
				}
			}
		}
	
			
					}
	@Then("^Fill branch details for report in arap$")
    public void fill_branch_details_for_report_in_arap()  {
    	
    	//Thread.sleep(6000);
    	
    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(arap.get("branchCode"));
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(arap.get("ReportType"));
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);
    	
    }
	@Then("^Select date in calendar in arap$")
    public void select_date_in_calendar_in_arap() throws InterruptedException  {
    	
    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
    	
    	
		 waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		 arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
		
		 
javascripthelper.JavaScriptHelper(driver);
while(true)
{
try
	{
		//span[contains(text(),'Oct 2022')]
//		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("B-Month")+" "+arap.get("B-Year")+"')]")));
		WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("B-Month")+" "+arap.get("B-Year")+"')]"));
//		Thread.sleep(2000);
		break;
	}
				
catch(NoSuchElementException nosuchElement)
	{
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
		
	}
}
			//td[@aria-label='November 1, 2022']/span
WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arap.get("B-FullMonth")+" "+arap.get("B-Day")+", "+arap.get("B-Year")+"']/span"));
clicksAndActionHelper.doubleClick(FinalDay);
}
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	Payment_SettlementObj paymentSettlementObj1 = new Payment_SettlementObj(driver);
	JavascriptHelper javascriphelper =new JavascriptHelper();

	@And("^user search active in payment settlement list view in arap$")
    public void user_search_active_in_payment_settlement_list_view_in_arap() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj1.getTransactionStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj1.getTransactionStatus());
        paymentSettlementObj1.getTransactionStatus().sendKeys(arap.get("contractstatusactive"));
        
    }
	@And("^get buisness partner name and payment settlement date in arap$")
    public void get_buisness_partner_name_and_payment_settlement_date_in_arap() throws Throwable {
    	
        seleniumactions.getWaitHelper().waitForElement(driver,2000,paymentSettlementObj1.getGetBuisnessPartnerName());
        String buisnessPartnerName = paymentSettlementObj1.getGetBuisnessPartnerName().getText();
        arap.put("buisnessPartnerName", buisnessPartnerName);
        javascriphelper.JavaScriptHelper(driver);
        String paymentDate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[1].value");
        arap.put("paymentDate", paymentDate);
        System.out.println(paymentDate);
		String year2 = paymentDate.substring(7,11);
		arap.put("year2", year2);
		String month2 = paymentDate.substring(3, 6);
		arap.put("month2", month2);
		switch (month2) {
		case "Dec":
			arap.put("fullmonth","December");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jan":
			arap.put("fullmonth","January");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Feb":
			arap.put("fullmonth","Febuary");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Mar":
			arap.put("fullmonth","March");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Apr":
			arap.put("fullmonth","April");
			System.out.println(arap.get("fullmonth"));
			break;
		case "May":
			arap.put("fullmonth","May");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jun":
			arap.put("fullmonth","June");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jul":
			arap.put("fullmonth","July");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Aug":
			arap.put("fullmonth","August");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Sep":
			arap.put("fullmonth","September");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Oct":
			arap.put("fullmonth","October");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Nov":
			arap.put("fullmonth","November");
			System.out.println(arap.get("fullmonth"));
			break;
		}
		if (Integer.parseInt(paymentDate.substring(0, 2))>9) {
			String day = paymentDate.substring(0,2);
			System.out.println(day);
			arap.put("day", day);
		}
		else{
			String day = paymentDate.substring(1, 2);
			arap.put("day", day);
			System.out.println(day);
		}
		String invoiceNumber = driver.findElement(By.xpath("(//datatable-body-cell[4]/div[1])[9]")).getText();
		System.out.println(invoiceNumber);
		arap.put("invoiceNumber", invoiceNumber);
		
    }
	
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	@And("^select the vendor name in arap$")
    public void select_the_vendor_name_in_arap() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectVendorName());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
        enquiryObj.selectVendorName().sendKeys(arap.get("buisnessPartnerName"));
        enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
    }
	
	@And("^select the date in arap$")
    public void select_the_date_in_arap() throws Throwable {
//    	//arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");
//    	Thread.sleep(2000);
//    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
//    	
//    	
//			 waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
//			 arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
//			
//			 
//javascripthelper.JavaScriptHelper(driver);
//while(true)
//	{
//	try
//		{
//			//span[contains(text(),'Oct 2022')]
//			Thread.sleep(1000);
//			//waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("Month3")+" "+arap.get("Year3")+"')]")));
//			WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("Month3")+" "+arap.get("Year3")+"')]"));
//			Thread.sleep(2000);
//			break;
//		}
//					
//	catch(NoSuchElementException nosuchElement)
//		{
//			//arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
//			
//		}
//	}
//				//td[@aria-label='November 1, 2022']/span
//	WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arap.get("FullMonth3")+" "+arap.get("Day3")+", "+arap.get("Year3")+"']/span"));
//	clicksAndActionHelper.doubleClick(FinalDay);   }


    
		 waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		 arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
		
		 
javascripthelper.JavaScriptHelper(driver);
while(true)
{
try
	{
		//span[contains(text(),'Oct 2022')]
//		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
		//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("Month3")+" "+arap.get("Year3")+"')]")));
		WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+arap.get("Month3")+" "+arap.get("Year3")+"')]"));
//		Thread.sleep(2000);
		break;
	}
				
catch(NoSuchElementException nosuchElement)
	{
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
		
	}
}
			//td[@aria-label='November 1, 2022']/span
WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arap.get("FullMonth3")+" "+arap.get("Day3")+", "+arap.get("Year3")+"']/span"));
clicksAndActionHelper.doubleClick(FinalDay);
}



@And("^User get the test data for the payment settlement transaction test case02$")
public void user_get_the_test_data_for_the_payment_settlement_transaction_test_case02() throws Throwable {
	arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_02_D1");
}
@And("^User get the test data for the payment settlement transaction test case03$")
public void user_get_the_test_data_for_the_payment_settlement_transaction_test_case03() throws Throwable {
	arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_03_D1");
}
@And("^User get the test data for the payment settlement transaction test case04$")
public void user_get_the_test_data_for_the_payment_settlement_transaction_test_case04() throws Throwable {
	arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_04_D1");
}
@And("^User get the test data for the payment settlement transaction test case05$")
public void user_get_the_test_data_for_the_payment_settlement_transaction_test_case05() throws Throwable {
	arap = excelData.getTestdata("KUBS_AR/AP_UAT_005_002_TC_05_D1");
}
}
