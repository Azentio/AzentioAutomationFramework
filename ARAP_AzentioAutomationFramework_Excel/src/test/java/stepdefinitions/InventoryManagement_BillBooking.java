package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class InventoryManagement_BillBooking {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
//	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);

	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"BillBookingTestData", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@And("^Fill the required fields for bill booking$")
	public void fill_the_required_fields_for_bill_booking() {
		Random random = new Random();
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(testData.get("EntityBranch"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(testData.get("InvoiceType"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(testData.get("InvoiceSubType"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(testData.get("BPName"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(testData.get("CostCenter"));
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);

		int randomNum = random.nextInt(5000 - 2500) + 2500;
		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(testData.get("SupplierReferenceNumber") + randomNum);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate(), 15, 1);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();

	}

	@Then("^Save and submit the invoice billing$")
	public void save_and_submit_the_invoice_billing() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		Thread.sleep(2000);

		javascripthelper.JavaScriptHelper(driver);

		String invoicetype2 = testData.get("InvoiceType");
		System.out.println(invoicetype2);
		if (invoicetype2.equals("Expense")) {
			String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
			System.out.println("Message:" + str);
		} else {
			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			clicksAndActionHelper.moveToElement(recordstatus);

			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			System.out.println(message);
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		}

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(testData.get("RemarkByMaker"));

		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		
		excelData.updateTestData(dataSetID, "ReviewerId", reviewerId);
		testData = excelData.getTestdata(dataSetID);
	}

	@And("^approve the record by the reviewer user$")
	public void approve_the_record_by_the_reviewer_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 10; i++) {
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();

			// reader.addReferanceData(referance_id);

			waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
			waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(testData.get("ApprovedByReviewer"));
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

	@Then("^checker should approved the invoice billing$")
	public void checker_should_approved_the_invoice_billing() throws IOException, ParseException, InterruptedException {
//			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, driver
				.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//			+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

//			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//			+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//			driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//			.click();

//			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(testData.get("ApprovedByChecker"));
//			waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^click on first eye button to get the system invoice number$")
	public void click_on_first_eye_button_to_get_the_system_invoice_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String invoicenumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("System generated invoice number: " + invoicenumber);

	}

	@Then("^select data set ID for bill booking$")
	public void select_data_set_id_for_bill_booking() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_007_TC_01";
		testData = excelData.getTestdata(dataSetID);
	}

}
