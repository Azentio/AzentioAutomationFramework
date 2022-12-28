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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentSettlementCancellationObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.KUBS_CheckerObj;
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
}
