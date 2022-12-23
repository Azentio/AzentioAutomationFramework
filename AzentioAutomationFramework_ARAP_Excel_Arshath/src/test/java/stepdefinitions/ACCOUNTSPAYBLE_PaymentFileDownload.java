package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentFileDownloadObj;
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.ExcelReader;

public class ACCOUNTSPAYBLE_PaymentFileDownload extends BaseClass{
	WebDriver driver=BaseClass.driver;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj=new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLE_PaymentFileDownloadObj paymentFileDownloadObj = new ACCOUNTSPAYABLE_PaymentFileDownloadObj(driver);
	Map<String,String> Value= new HashMap<>();
	WaitHelper waitHelper=new WaitHelper(driver);
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
//	JsonConfig jsonConfig = new JsonConfig();
//	ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData paymentFileDownloadUploadTestData= jsonConfig.getPaymentFileUploadDownloadTesData("Maker");
	//String excelFilePath="C:\\Users\\inindc00076\\Downloads\\JAIPURBRANCH_HDFCBANK_2022-10-31_13-31-00(11).csv";
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx", "CancellationBillTestdata", "DataSet ID");
	Map<String, String>testData;
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);
	ExcelReader excelReader = new ExcelReader("C:\\Users\\inindc00075\\Downloads");
	
	@And("^click on arap configuration main menu$")
    public void click_on_arap_configuration_main_menu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.kubsArApExpenseConfiguration(), 60, 2);
		makerObj.kubsArApExpenseConfiguration().click();
		
    }

    @And("^click on payment file generation setup sub menu$")
    public void click_on_payment_file_generation_setup_sub_menu() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.arapExpenceConfiguration(), 60, 2);
    	makerObj.arapExpenceConfiguration().click();
    }
    @And("^configure the file format as Bank & Account Number Wise$")
    public void configure_the_file_format_as_bank_account_number_wise() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.arapConfigBranchRecord(), 60, 2);
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(testData.get("BankAndBankAccountWise"));
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.DOWN);  
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);  
    }

    @And("^verify payment file download format is in bank and accont number wise$")
    public void verify_payment_file_download_format_is_in_bank_and_accont_number_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	System.out.println(makerObj.arapCreateFileBasis().getText());
    	Assert.assertEquals(testData.get("BankAndBankAccountWise"),makerObj.arapCreateFileBasis().getText());
    }
    @And("^verify payment file download format is in Bank wise wise$")
    public void verify_payment_file_download_format_is_in_bank_wise_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	Assert.assertEquals("Bank Wise",makerObj.arapCreateFileBasis().getText() );
    }
    @And("^verify payment file download format is in Payout wise$")
    public void verify_payment_file_download_format_is_in_payout_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	Assert.assertEquals("Payout Wise",makerObj.arapCreateFileBasis().getText() );
    }
    @And("^configure the file format as Bank Wise$")
    public void configure_the_file_format_as_bank_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(testData.get("PaymentFileAs") );
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);
    	
    }
    @And("^configure the file format as Payout wise$")
    public void configure_the_file_format_as_payout_wise() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.arapConfigBranchRecord(), 20, 1);
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(testData.get("PaymentFileAsPayoutWise"));
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);
    }
    @And("^save the arap configure record$")
    public void save_the_arap_configure_record() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.arapConfigPaymentFileConfigSaveButton(), 2000, 200);
    	makerObj.arapConfigPaymentFileConfigSaveButton().click();
		for (int i = 0; i < 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(makerObj.ARAP_Notification_Close());
				makerObj.ARAP_Notification_Close().click();
				break;
			} catch (Exception e) {
				if (i==100) {
					Assert.fail();
				}
			}
		}
    }
	@And("^Select and Submit the Update Deposited Cheque records$")
	public void select_and_submit_the_update_deposited_cheque_records()
			throws InterruptedException, IOException, ParseException {

		// Reference
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId(), 60, 2);

		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_01_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000,
						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000,accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys(testData.get("Remarks"));
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
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
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_01_D1", "ReviewerID", reviewerId);

	}
	
	@And("^Select and Submit the Update Deposited Cheque recordss$")
	public void select_and_submit_the_update_deposited_cheque_recordss() throws Throwable {

		// Reference
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId(), 60, 2);

		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_02_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000,
						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000,accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys(testData.get("Remarks"));
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
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
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_02_D1", "ReviewerID", reviewerId);

	}
	
	@And("^Select and Submit the Update Deposited Cheque recordsss$")
	public void select_and_submit_the_update_deposited_cheque_recordsss() throws Throwable {

		// Reference
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId(), 60, 2);

		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_02_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000,
						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000,accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys(testData.get("Remarks"));
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waitHelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
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
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_008_001_TC_02_D1", "ReviewerID", reviewerId);

	}

	@And("^search the transfer as payment mode$")
    public void search_the_transfer_as_payment_mode() throws Throwable {
		manualPayoutObj.accountsPayableManualPayoutSearchPaymentMode().click();
		manualPayoutObj.accountsPayableManualPayoutSearchPaymentMode().sendKeys(testData.get("PaymentMode"));
		//testData.put("branchName", manualPayoutObj.accountsPayableManualPayoutBranchName().getText());
		Thread.sleep(1500);
		String[] branchName=manualPayoutObj.accountsPayableManualPayoutBranchName().getText().split("-");
		Value.put("branchName", branchName[1].trim());
		System.out.println(manualPayoutObj.accountsPayableManualPayoutPayoutDate().getText());
		String[] paymentDate=manualPayoutObj.accountsPayableManualPayoutPayoutDate().getText().split("T");
		
				System.out.println(paymentDate[0]);
			String[] seperateDate=paymentDate[0].split("-");
			String year=seperateDate[0];
			Value.put("year", year);
			int day=Integer.parseInt(seperateDate[2]);

			if(day<9)
			{
				String Day=seperateDate[2].substring(1,2);
				Value.put("Day", Day);
				System.out.println(Value.get("Day"));
				
			}
			else
			{
				String Day=seperateDate[2].substring(0,2);
				Value.put("Day", Day);
				System.out.println(Value.get("Day"));
			}
			
			String month;
			switch(seperateDate[1])
			{
			
			case "01":
				month="Jan";
				Value.put("month", month);
				break;
			case "02":
				month="Feb";
				Value.put("month", month);
				break;
			case "03":
				month="Mar";
				Value.put("month", month);
				break;
			case "04":
				month="Apr";
				Value.put("month", month);
				break;
			case "05":
				month="May";
				Value.put("month", month);
				break;
			case "06":
				month="Jun";
				Value.put("month", month);
				break;
			case "07":
				month="Jul";
				Value.put("month", month);
				break;
			case "08":
				month="Aug";
				Value.put("month", month);
				break;
			case "09":
				month="Sep";
				Value.put("month", month);
				break;
			case "10":
				month="Oct";
				Value.put("month", month);
				break;
			case "11":
				month="Nov";
				Value.put("month", month);
				break;
			case "12":
				month="Dec";
				Value.put("month", month);
				break;	
			}
			System.out.println(Value.get("month"));
	}
	@And("^goto payment file download module$")
    public void goto_payment_file_download_module() throws Throwable {
		paymentFileDownloadObj.paymentFileDownloadVTempiewButton().click();
    }

    @And("^enter branch name$")
    public void enter_branch_name() throws Throwable {
    	paymentFileDownloadObj.paymentFileDownloadBranchName().click();
    	paymentFileDownloadObj.paymentFileDownloadBranchName().sendKeys(Value.get("branchName"));
    	paymentFileDownloadObj.paymentFileDownloadBranchName().sendKeys(Keys.ENTER);
    }

    @And("^click on calendar in the payment file download module$")
    public void click_on_calendar_in_the_payment_file_download_module() throws Throwable {
    	paymentFileDownloadObj.PaymentFileDownloadCalendarButton().click();
    }

    @And("^enter the payout date$")
    public void enter_the_payout_date() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, paymentFileDownloadObj.paymentFileDownloadChooseMonthAndYear(), 60, 2);
    	paymentFileDownloadObj.paymentFileDownloadChooseMonthAndYear().click();
    	
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("Year")+"')]")), 60, 2);
    	driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("Year")+"')]")).click();
    	
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("Month")+"')]")), 60, 2);
    	driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("Month")+"')]")).click();
    	
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//tr//span[text()='"+testData.get("Date")+"']")), 60, 2);
    	driver.findElement(By.xpath("//tr//span[text()='"+testData.get("Date")+"']")).click();
    	
    	
     
    }
    @And("^click on go button$")
    public void click_on_go_button() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, paymentFileDownloadObj.PaymentFileDownloadGoButton(), 60, 2);
    	paymentFileDownloadObj.PaymentFileDownloadGoButton().click();
    }

    @And("^download the payment file$")
    public void download_the_payment_file() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, paymentFileDownloadObj.paymentFileDownloadDownloadButton(), 60, 2);
    	paymentFileDownloadObj.paymentFileDownloadDownloadButton().click();
    	Thread.sleep(2000);
    	
    }
   
	@And("^User should go to the kubs url and login as a reviewer userr$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_userr() throws IOException, ParseException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}
	@Then("^click on the Notification select the Cheque record and Approved$")
	public void click_on_the_notification_select_the_cheque_record_and_approved()
			throws InterruptedException, IOException, ParseException {
		// notification
		waitHelper = new WaitHelper(driver);

		waitHelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		/*
		 * for (int i = 1; i <= 35; i++) { try { waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//span[contains(text(),'" +
		 * reader.readReferancedata() + "')]"))); WebElement referanceID = driver
		 * .findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata()
		 * + "')]")); referanceID.click(); Assert.assertTrue(referanceID.isDisplayed());
		 * break; } catch (NoSuchElementException e) { waithelper.waitForElement(driver,
		 * 4000, kubschecker.checker_notification_next_button());
		 * 
		 * kubschecker.checker_notification_next_button().click(); } }
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i < 100; i++) {
			try {
				waitHelper.waitForElement(driver, 5000,
						driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
				break;
			} catch (Exception e) {

			}
		}
		// Approve
		waitHelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarkSecond());
		reviewer.reviewerAlertRemarkSecond().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}
    
	@Given("^User should go to the kubs url and login as a checker userr$")
    public void user_should_go_to_the_kubs_url_and_login_as_a_checker_userr() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
    }
	@And("^then checker claim the records$")
	public void then_checker_claim_the_records() throws InterruptedException, IOException, ParseException {

		// open pool
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerSecurityManagement(), 60, 0);
		kubschecker.checkerSecurityManagement().click();

		// claim
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}
	@And("^select the Cheque record and Approve by checkers$")
	public void select_the_cheque_record_and_approve_by_checkers()
			throws InterruptedException, IOException, ParseException {
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			} catch (StaleElementReferenceException e) {
				if (i == 35) {
					Assert.fail("Data not found");
				}
			}
		}
		while (true) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

				waitHelper.waitForElement(driver, 2000,
						driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}

		// Approve
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		Thread.sleep(2000);
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarkSecond());
		kubschecker.checkerRemarkSecond().sendKeys("OK");
		Thread.sleep(2000);
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    @And("^verify Where payment mode is Wire Transfer$")
    public void verify_where_payment_mode_is_wire_transfer() throws Throwable {
    	//CSVReader csvReader= new CSVReader();
    	String payoutReferenceNumber=excelReader.getCellData("ICICIbankLtd_HDFCBANK_2022-06-0", 7, 2);
    	System.out.println("Payout Reference number"+payoutReferenceNumber);
     
    }
	
	@And("^user update the Excelsheet Testdata for payment file download$")
	public void user_update_the_Excelsheet_Testdata_for_payment_file_download() throws Throwable{
		testData = Exceldata.getTestdata("KUBS_AR_AP_UAT_008_001_TC_01_D1");
	}
	
	@And("^user update the Excelsheet Testdata for payment file legal$")
	public void user_update_the_Excelsheet_Testdata_for_payment_file_legal() throws Throwable{
		testData = Exceldata.getTestdata("KUBS_AR_AP_UAT_008_001_TC_02_D1"); 
	}
}
