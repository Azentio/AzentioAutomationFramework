package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class InventoryManagement_PurchaseRequisitionConfirmation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);


	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"PurchaseRequisitionConfTestData", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@And("^user should navigate to inventory management$")
	public void user_should_navigate_to_inventory_management() throws InterruptedException {
		Thread.sleep(2000);
//		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 4000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu().click();
	}

	@When("^click on eye button of purchase requisition confirmation$")
	public void click_on_eye_button_of_purchase_requisition_confirmation() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_EyeButton());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_EyeButton().click();
	}

	@And("^click on add button  of purchase requisition confirmation$")
	public void click_on_add_button_of_purchase_requisition_confirmation() {
//		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_AddButton());
		waithelper.waitForElementwithFluentwait(driver, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_AddButton());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_AddButton().click();
	}

	@And("^Fill the required fields to purchase req$")
	public void fill_the_required_fields_to_purchase_req() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode().sendKeys(testData.get("ItemCode"));
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode().sendKeys(Keys.ENTER);
	}

	@Then("^Save and submit the purchase req confirmation$")
	public void save_and_submit_the_purchase_req_confirmation() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElementwithFluentwait(driver, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_SaveButton());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_SaveButton().click();
//		Thread.sleep(2000);
//		String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
//		System.out.println("Message:" + str);

//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus0 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus0);

		String message0 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message0);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
//		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//		String id=driver.findElement(By.xpath("(//span[contains(text(),'PUR_REQ_CONFIRM')])[1]/../../../datatable-body-cell[2]/div/span")).getText();
//		String id="";
//		for (int i = 0; i <= 30; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000,
//						driver.findElement(By.xpath("(//datatable-body-row/div[2]/datatable-body-cell[3]/div/span[contains(text(),'PUR_REQ_CONFIRM')])[1]/../../../datatable-body-cell[2]/div/span")));
//				id = driver.findElement(By.xpath("(//datatable-body-row/div[2]/datatable-body-cell[3]/div/span[contains(text(),'PUR_REQ_CONFIRM')])[1]/../../../datatable-body-cell[2]/div/span"))
//						.getText();
//				break;
//			} catch (NoSuchElementException ne) {
//				if (i == 30) {
//					if (driver.findElement(By.xpath("(//li[8][@class=''])[2]")).isDisplayed())
//						driver.findElement(By.xpath("(//li[8]/a/i)[2]")).click();
//					else {
//						Assert.fail("No Record Found");
//					}
//				}
//			}
//		}
////		String id=driver.findElement(By.xpath("(//span[text()='PUR_REQ_CONFIRM'])[1]/../../../../../datatable-body-row/div[2]/datatable-body-cell[2]/div/span")).getText();
//		jsonWriter.addReferanceData(id);
//		System.out.println("Reference ID:" + id);
//		while (true) {
//			try {
//				WebElement eventname = driver.findElement(By.xpath("(//span[contains(text(),'PUR_REQ_CONFIRM')])[1]"));
//				driver.findElement(By.xpath("(//span[contains(text(),'PUR_REQ_CONFIRM')])[1]/../../../datatable-body-cell/div/ion-buttons/ion-button/ion-icon")).click();
//				break;
//			} catch (Exception e) {
//				
//			}
//		}
//		Thread.sleep(500000);

//		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

//		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());

		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("RemarkByMaker"));

//		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);

	}
	
	@And("^approve the purchase requisition confirmation record by reviewer user$")
	public void approve_the_purchase_requisition_confirmation_record_by_reviewer_user() throws InterruptedException, IOException, ParseException {
		browserHelper = new BrowserHelper(driver);
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 35; i++) {

			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();

		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

	}

	@Then("^click on first eye button to get the indent reference number$")
	public void click_on_first_eye_button_to_get_the_indent_reference_number() throws InterruptedException, IOException {
		javascripthelper.JavaScriptHelper(driver);

//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String indentrefnumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[6].value").toString();
		System.out.println(" Unique Indent Reference Number is -: " + indentrefnumber);
//		jsonWriter.addInventoryManagementPRnumber(indentrefnumber);
		excelData.updateTestData(dataSetID, "IndentRefNumber", indentrefnumber);
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^checker should approved the purchase requisition confirmation record$")
	public void checker_should_approved_the_purchase_requisition_confirmation_record() throws IOException, ParseException, InterruptedException {
		Thread.sleep(2000);
		// testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
		for (int i = 1; i <= 35; i++) {
			try {
//			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^log in to the Checker Account$")
	public void log_in_to_the_checker_account() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");

	}
	
	@Then("^select data set ID for purchase requisition confirmation creation$")
    public void select_data_set_id_for_purchase_requisition_confirmation_creation() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_002";
		testData = excelData.getTestdata(dataSetID);
    }

}
