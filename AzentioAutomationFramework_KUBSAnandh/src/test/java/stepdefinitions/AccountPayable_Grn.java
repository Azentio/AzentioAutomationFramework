package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountPayable_GrnObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.InventoryManagement_InventoryStockReceiptObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountPayable_GrnTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;

public class AccountPayable_Grn extends BaseClass {

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	AzentioLogin login;
	AccountPayable_GrnObj accountPayable_GrnObj = new AccountPayable_GrnObj(driver);
	AccountPayable_GrnTestDataType accountPayable_GrnTestDataType = new AccountPayable_GrnTestDataType();
	Azentio_ReviewerObj reviewer;
	BUDGET_BudgetCreationTestDataType budgetdata;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	InventoryManagement_InventoryStockReceiptObj inventoryManagement_InventoryStockReceiptObj = new InventoryManagement_InventoryStockReceiptObj(
			driver);
	InventoryManagement_InventoryStockReceiptTestDataType inventoryManagement_InventoryStockReceiptTestDataType = new InventoryManagement_InventoryStockReceiptTestDataType();
	String GrnReference;

	@Then("^Click on GRN Eye button$")
	public void click_on_grn_eye_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_EyeButton());
		accountPayable_GrnObj.accountsPayable_Grn_EyeButton().click();

	}

	@Then("^Fill the form for the GRN$")
	public void fill_the_form_for_the_grn() throws Throwable {
		accountPayable_GrnTestDataType = jsonReader.getGrnByName("Maker");

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_BpName());
		accountPayable_GrnObj.accountsPayable_Grn_BpName().click();
		accountPayable_GrnObj.accountsPayable_Grn_BpName().sendKeys(accountPayable_GrnTestDataType.GRNbpName);
		accountPayable_GrnObj.accountsPayable_Grn_BpName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_BpBranch());
		accountPayable_GrnObj.accountsPayable_Grn_BpBranch().click();
		accountPayable_GrnObj.accountsPayable_Grn_BpBranch().sendKeys(accountPayable_GrnTestDataType.GRNbpBranch);
		accountPayable_GrnObj.accountsPayable_Grn_BpBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_InvoiceNumber());
		accountPayable_GrnObj.accountsPayable_Grn_InvoiceNumber().click();
		accountPayable_GrnObj.accountsPayable_Grn_InvoiceNumber()
				.sendKeys(accountPayable_GrnTestDataType.GRNInvoiceNumber);
		accountPayable_GrnObj.accountsPayable_Grn_InvoiceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_DeliveryLocation());
		accountPayable_GrnObj.accountsPayable_Grn_DeliveryLocation().click();
		accountPayable_GrnObj.accountsPayable_Grn_DeliveryLocation()
				.sendKeys(accountPayable_GrnTestDataType.GRNDeliveryLocation);
		accountPayable_GrnObj.accountsPayable_Grn_DeliveryLocation().sendKeys(Keys.ENTER);

	}

	@Then("^Click on item Details tab$")
	public void click_on_item_details_tab() throws InterruptedException {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_ItemDetails());
		accountPayable_GrnObj.accountsPayable_Grn_ItemDetails().click();

	}

	@Then("^Select the PO Number$")
	public void select_the_po_number() throws Throwable {

		accountPayable_GrnTestDataType = jsonReader.getGrnByName("Maker");

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_PoNumber());
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().click();
		Thread.sleep(1000);
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().sendKeys(accountPayable_GrnTestDataType.GRNPoNumber);
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	@Then("^Add qty received qnty approved$")
	public void add_qty_received_qnty_approved() throws Throwable {
		accountPayable_GrnTestDataType = jsonReader.getGrnByName("Maker");
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_QtyReceived());
		accountPayable_GrnObj.accountsPayable_Grn_QtyReceived().click();
		accountPayable_GrnObj.accountsPayable_Grn_QtyReceived().sendKeys(accountPayable_GrnTestDataType.GRNQtyReceived);
		accountPayable_GrnObj.accountsPayable_Grn_QtyReceived().sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_QtyApproved());
		accountPayable_GrnObj.accountsPayable_Grn_QtyApproved().click();
		accountPayable_GrnObj.accountsPayable_Grn_QtyApproved().sendKeys(accountPayable_GrnTestDataType.GRNQtyApproved);
		accountPayable_GrnObj.accountsPayable_Grn_QtyApproved().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("^Click on item Details Save button$")
	public void click_on_item_details_save_button() throws Throwable {

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_ItemSave());
		accountPayable_GrnObj.accountsPayable_Grn_ItemSave().click();

	}

	@And("^Submit the record with Remark$")
	public void submit_the_record_with_remark() throws InterruptedException, IOException {

		// Submit button
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_SubmitButton());
		accountPayable_GrnObj.accountsPayable_Grn_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, accountPayable_GrnObj.accountsPayable_Grn_RemarkField());
		javascripthelper.JSEClick(accountPayable_GrnObj.accountsPayable_Grn_RemarkField());
		accountPayable_GrnObj.accountsPayable_Grn_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_SubmitByMaker());
		accountPayable_GrnObj.accountsPayable_Grn_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = accountPayable_GrnObj.accountsPayable_Grn_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = accountPayable_GrnObj.accountsPayable_Grn_RecordStatus().getText();
		System.out.println(message);
		accountPayable_GrnObj.accountsPayable_Grn_RecordStatus().click();
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
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);

	}

	// reviewer approve

	@Then("^click on the Notification Approve the record$")
	public void click_on_the_notification_approve_the_record()
			throws IOException, ParseException, InterruptedException {

		// notification
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		//budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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

		waithelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Approve
		waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.reviewer_Grn_remarks());
		accountPayable_GrnObj.reviewer_Grn_remarks().sendKeys("ok");

		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(2000);

	}

	// checker
	@And("^select the record and Approve add remark by checker$")
	public void select_the_record_and_approve_add_remark_by_checker() throws Throwable {

		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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

		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Approve
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.reviewer_Grn_remarks());
		accountPayable_GrnObj.reviewer_Grn_remarks().sendKeys("OK");
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);

	}

	// ----------//

	@Then("^Select PO Number which is created with expense code mapped with inventory code$")
	public void select_po_number_which_is_created_with_expense_code_mapped_with_inventory_code()
			throws InterruptedException {
		accountPayable_GrnTestDataType = jsonReader.getGrnByName("Maker");

		waithelper.waitForElement(driver, 2000, accountPayable_GrnObj.accountsPayable_Grn_PoNumber());
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().click();
		Thread.sleep(1000);
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().sendKeys(accountPayable_GrnTestDataType.InventoryPoNumber);
		accountPayable_GrnObj.accountsPayable_Grn_PoNumber().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("^select GRN refernce$")
    public void select_grn_refernce() throws InterruptedException {
    
    	Thread.sleep(2000);
    	 waithelper.waitForElement(driver, 2000,accountPayable_GrnObj.accountsPayable_Grn_GrnReference());
    	 GrnReference =accountPayable_GrnObj.accountsPayable_Grn_GrnReference().getText();
    	 System.out.println(GrnReference);
     }

    @Then("^enter GRN reference check details auto populated$")
    public void enter_grn_reference_check_details_auto_populated() throws InterruptedException {
        
     //GRN Number
 	  waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
 	 inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().click();
 	 inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(GrnReference);
 	 inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(Keys.ENTER);
 	 Thread.sleep(2000);
    
    }

}
