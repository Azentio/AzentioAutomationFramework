package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.util.Timeout;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.RadioButtonHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.InventoryManagementTestDataType;
import utilities.ExtentTestManager;

public class InventoryManagament extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_ReviewerObj reviewer;
	KUBS_Login login = new KUBS_Login(driver);
	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	BUDGET_BudgetDefinitionTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	JavascriptHelper javascript;
	RadioButtonHelper radioButtonHelper = new RadioButtonHelper(driver);
	String reviwerId;
	String RefNo;
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "GRNTestData", "Data Set ID");
	ExcelData excelDataForInvoiceBooking = new ExcelData(path, "BillBookingTestData", "Data Set ID");
	ExcelData excelDataForAssetCreation = new ExcelData(path, "FixedAsset_AssetCreation", "Data Set ID");
	ExcelData excelDataAssetConfigExecution = new ExcelData(path, "AssetConfig_ExecutionTrack", "TestCaseID");
	Map<String, String> testData;
	Map<String, String> dataSetID=new HashMap<>();
	// ----KUBS_INV_MGMT_UAT_001_001-----

	@Given("^Navigate to URL and user should login as a maker$")
	public void navigate_to_url_and_user_should_login_as_a_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppByMaker();
	}

	/*
	 * @Then("^Click on Finance$") public void click_on_finance() throws Throwable {
	 * waithelper = new WaitHelper(driver); budgetTransferObj = new
	 * BUDGET_BudgetTransferObj(driver);
	 * 
	 * }
	 */

	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);

	@Then("^Click on the Finance$")
	public void click_on_the_finance() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

	@Then("^Click on the Direction$")
	public void click_on_direction() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

	}

	/*
	 * @Then("^Click on Inventory Management$") public void
	 * click_on_inventory_management() throws Throwable {
	 * 
	 * waithelper.waitForElement(driver, 2000,
	 * inventoryManagamentObj.inventoryManagament_button());
	 * inventoryManagamentObj.inventoryManagament_button().click(); }
	 */

	@And("^Click on the eye icon of Inventory Request$")
	public void click_on_the_eye_icon_of_inventory_request() throws Throwable {
//		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton());
		waithelper.waitForElementwithFluentwait(driver,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton().click();
//		inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton().click();
	}

	@Then("^Click on Add button$")
	public void click_on_add_button() throws Throwable {
//		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
//		inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
		waithelper.waitForElementwithFluentwait(driver,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
		clicksAndActionHelper.moveToElement(inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
		clicksAndActionHelper.clickOnElement(inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
	}

	@Then("^Click on save button$")
	public void click_on_save_button() throws Throwable {

		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();

		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();

		// javascripthelper.JavaScriptHelper(driver);
		// String str = javascripthelper.executeScript("return
		// document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
		// System.out.println("Message:" + str);

	}

	@Then("^Click Notification button$")
	public void click_notification_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();

	}

	@And("^Select record which we saved$")
	public void select_record_which_we_saved() throws Throwable {
		// Reference
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

				budgetTransferObj.maker_notification_next_button().click();
			}

			waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

			budgetTransferObj.maker_notification_next_button().click();
		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	@And("^Submit the record$")
	public void submit_the_record() throws Throwable {

		// Submit button
		// Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
		inventoryManagamentObj.accountPayable_SubmitButton().click();
		// budgetTransferObj.budget_BudgetTransfer_Submit().click();
		javahelper.JavaScriptHelper(driver);
		// Remark
		// javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		/*
		 * inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed(); boolean
		 * result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
		 * System.out.println(result); while(true) { try {
		 * //inventoryManagamentObj.accountPayable_SubmitButton().click(); WebElement
		 * submitButton = (WebElement) javahelper.
		 * executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]"
		 * ); submitButton.click(); break; } catch(ElementNotInteractableException e) {
		 * System.out.println(e.getMessage()); } }
		 */
//		Thread.sleep(2000);
		WebElement element = waithelper.waitForElementwithFluentwait(driver,
				budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element.click();
//		javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		WebElement element1 = waithelper.waitForElementwithFluentwait(driver,
				budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element1.sendKeys("ok");

//		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("OK");

		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
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

//----------KUBS_INV_MGMT_UAT_002_001--------------

	@Then("^Click on Inventory maintenance$")
	public void click_on_inventory_maintenance() throws Throwable {
		waithelper.waitForElement(driver, 4000, inventoryManagamentObj.inventoryMaintenance_Button());
		inventoryManagamentObj.inventoryMaintenance_Button().click();
	}

	@Then("^Click on Instrument code master eye button$")
	public void click_on_instrument_code_master_eye_button() throws Throwable {
		waithelper.waitForElement(driver, 4000,
				inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton().click();
	}

	@Then("^Click on save button on instrument code master$")
	public void click_on_save_button_on_instrument_code_master() throws Throwable {
//		 Thread.sleep(1000);
//		 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		waithelper.waitForElementwithFluentwait(driver,
				inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton().click();
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
	}

	// -------------KUBS_INV_MGMT_UAT_003_001------
	@Then("^Click on Inventory access master$")
	public void click_on_inventory_access_master() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_EyeButton());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_EyeButton().click();
	}

	@Then("^Click on issue checkbox$")
	public void click_on_issue_checkbox() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_IssueCheckBox());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_IssueCheckBox().click();
		Thread.sleep(1000);
	}

	@Then("^Click on save button in inventory Access Master$")
	public void click_on_save_button_in_inventory_access_master() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton().click();
		Thread.sleep(5000);
	}

	@Then("^Click on Recive checkbox$")
	public void click_on_recive_checkbox() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox().click();
	}

	@Then("^Click on Place Order checkbox$")
	public void click_on_place_order_checkbox() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox().click();
	}

	@Then("^Click on Place Request checkbox$")
	public void click_on_place_request_checkbox() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox().click();
	}

	// ----------KUBS_INV_MGMT_UAT_001_004 Create a GRN-----
	@Then("^Click on Accounts Payable$")
	public void click_on_accounts_payable() throws Throwable {
//		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayableButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayableButton());
		inventoryManagamentObj.accountPayableButton().click();
	}

	@Then("^Click on Good Recived Note GRN Eye buutton$")
	public void click_on_good_recived_notegrn_eye_buutton() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_GoodsReceivedNoteGRNEyeButton());
		inventoryManagamentObj.accountPayable_GoodsReceivedNoteGRNEyeButton().click();
	}

	@And("^Enter GRN Business partner name$")
	public void enter_grn_business_partner_name() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_GrnBpName());
		inventoryManagamentObj.accountPayable_GrnBpName().click();
		inventoryManagamentObj.accountPayable_GrnBpName().sendKeys(testData.get("GRNbpName"));
		inventoryManagamentObj.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
	}

	@And("^Enter GRN Business partner branch$")
	public void enter_grn_business_partner_branch() throws Throwable {
		inventoryManagamentObj.accountPayable_GRN_BPBranch().click();
		// Thread.sleep(4000);
		inventoryManagamentObj.accountPayable_GRN_BPBranch().click();
		Thread.sleep(500);
		inventoryManagamentObj.accountPayable_GRN_BPBranch().sendKeys(Keys.DOWN);
		inventoryManagamentObj.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
	}

	@And("^Enter GRN Invoice number$")
	public void enter_grn_invoice_number() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_GrnInvoiceNumber());
		inventoryManagamentObj.accountPayable_GrnInvoiceNumber().click();

		inventoryManagamentObj.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("GRNInvoiceNumber"));
		Thread.sleep(2000);
		inventoryManagamentObj.accountPayable_GrnInvoiceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Enter GRN Delivery location$")
	public void enter_grn_delivery_location() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_GrnDeliveryLocation());
		inventoryManagamentObj.accountPayable_GrnDeliveryLocation().click();
		inventoryManagamentObj.accountPayable_GrnDeliveryLocation().sendKeys(testData.get("GRNDeliveryLocation"));
		Thread.sleep(2000);
		inventoryManagamentObj.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
	}

	@Then("^Click on save button to save the record$")
	public void click_on_save_button_to_save_the_record() throws Throwable {
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();
//				Thread.sleep(4000);
	}

	@Then("^Click on notification & open record which we created for GRN$")
	public void click_on_notification_open_record_which_we_created_for_grn() throws Throwable {
//		    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		// waithelper.waitForElementwithFluentwait(driver,
		// budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i < 200; i++) {
			try {
				javascripthelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
				break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}

//		waithelper.waitForElementToVisibleWithFluentWait(driver,
//				inventoryManagamentObj.AccountsPayableGRNNotificationFirstRecord(), 20, 1);
//		inventoryManagamentObj.AccountsPayableGRNNotificationFirstRecord().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryManagamentObj.AccountsPayableGRNNotificationFirstReferenceNumber(), 20, 1);
		String id = "";
		for (int i = 0; i <= 500; i++) {
			try {
				id = inventoryManagamentObj.AccountsPayableGRNNotificationFirstReferenceNumber().getText();
				System.out.println("Reference ID:" + id);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		for (int i = 1; i <= 500; i++) {
			try {
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + id + "')]"));
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
////					Thread.sleep(3000);
////					waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(before_xpath + id + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
//		/*
//		 * By xpath = By.xpath(before_xpath + reader.readReferancedata() + after_xpath);
//		 * Actions action = new Actions(driver);
//		 * 
//		 * action.moveToElement((WebElement) xpath).click().perform();
//		 */

	}

	@Then("^Click on Item Details Tab$")
	public void click_on_item_details_tab() throws Throwable {
//		    	Thread.sleep(2000);
//		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_GRNItemDetails());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_GRNItemDetails());
		inventoryManagamentObj.inventoryManagament_GRNItemDetails().click();
	}

	@Then("^Add qty received qty approved$")
	public void add_qty_received_qty_approved() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnQtyReceived());
		inventoryManagamentObj.accountPayable_GrnQtyReceived().click();
		inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(testData.get("GRNQtyReceived"));
		inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(Keys.ENTER);

	}

	@Then("^Click on GRN item save button$")
	public void click_on_grn_item_save_button() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnQtyApproved());
		inventoryManagamentObj.accountPayable_GrnQtyApproved().click();
		inventoryManagamentObj.accountPayable_GrnQtyApproved().sendKeys(testData.get("GRNQtyApproved"));
		inventoryManagamentObj.accountPayable_GrnQtyApproved().sendKeys(Keys.ENTER);

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnSaveButton());
		WebElement save = inventoryManagamentObj.accountPayable_GrnSaveButton();
		clicksAndActionHelper.moveToElement(save);
		inventoryManagamentObj.accountPayable_GrnSaveButton().click();

	}

	@Then("^Click on the Notification$")
	public void click_on_the_notification() throws Throwable {
//		    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		// waithelper.waitForElementwithFluentwait(driver,
		// budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		for (int i = 0; i < 30; i++) {
			try {
				budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("notification icon not clicked");
				}
			}
		}

	}

	@Then("^Select the record which we saved$")
	public void select_the_record_which_we_saved() throws Throwable {
		// Reference
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryManagamentObj.AccountsPayableGRNNotificationFirstReferenceNumber(), 20, 1);
		String id = inventoryManagamentObj.AccountsPayableGRNNotificationFirstReferenceNumber().getText();

		// jsonWriter.addReferanceData(id);
		excelData.updateTestData(testData.get("Update Data Set 1"), "Reference ID", id);
		// testData.get("KUBS_FAT_UAT_001_004_02_D1");
		testData = excelData.getTestdata(testData.get("Update Data Set 1"));
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				// waithelper.waitForElement(driver, 3000, driver
				// .findElement(By.xpath("//span[contains(text(),'" +testData.get("Reference
				// ID")+ "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 35) {
					Assert.fail(e.getMessage());
				}
			}

		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 50; i++) {
			try {

				waithelper.waitForElement(driver, 10000,
						driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^Submit record$")
	public void submit_record() throws Throwable {
		// Submit button
		// Thread.sleep(2000);
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
		try {
			inventoryManagamentObj.accountPayable_SubmitButton().click();
		} catch (ElementClickInterceptedException e) {
			javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		}
		// budgetTransferObj.budget_BudgetTransfer_Submit().click();

		// Remark
		// javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		/*
		 * inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed(); boolean
		 * result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
		 * System.out.println(result); while(true) { try {
		 * //inventoryManagamentObj.accountPayable_SubmitButton().click(); WebElement
		 * submitButton = (WebElement) javahelper.
		 * executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]"
		 * ); submitButton.click(); break; } catch(ElementNotInteractableException e) {
		 * System.out.println(e.getMessage()); } }
		 */
//				Thread.sleep(3000);	
		// waithelper.waitForElement(driver, 2000,
		// budgetTransferObj.budget_BudgetTransfer_RemarkField());

		// javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		budgetTransferObj.budget_BudgetTransfer_RemarkField().click();
		// waithelper.waitForElement(driver, 2000,
		// budgetTransferObj.budget_BudgetTransfer_RemarkField());
		// Thread.sleep(2000);
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);

		// Thread.sleep(2000);
		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
		// Thread.sleep(2000);
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
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
		excelData.updateTestData(testData.get("Update Data Set 1"), "Reviewer ID", reviewerId);

	}

	@And("^store the GRN Number and po number and bp name in invoice booking excel database$")
	public void store_the_grn_number_and_po_number_and_bp_name_in_invoice_booking_excel_database() throws Throwable {
		//Update Data Set 2
		excelDataForInvoiceBooking.updateTestData(testData.get("Update Data Set 2"), "BP_Name", testData.get("GRNbpName"));
		excelDataForInvoiceBooking.updateTestData(testData.get("Update Data Set 2"), "PONumber",
				testData.get("GRNPoNumber"));
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryManagamentObj.approvedGRNNumber(), 20, 1);
		String grnNumber = inventoryManagamentObj.approvedGRNNumber().getText();
		excelDataForInvoiceBooking.updateTestData(testData.get("Update Data Set 2"), "GRNNumber", grnNumber);
		excelDataForAssetCreation.updateTestData(testData.get("Update Data Set 3"), "GRNNumber", grnNumber);
	}

	@Then("^Clam record$")
	public void clam_record() throws Throwable {
		waithelper = new WaitHelper(driver);
		kubschecker = new KUBS_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();
		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
//				waithelper.waitForElement(driver, 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();
	}

	@Then("^Click on the notification and approve the record$")
	public void click_on_the_notification_and_approve_the_record() throws Throwable {
		javascript = new JavascriptHelper();
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
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

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

//				waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}

	@And("^Submit the record in maker stage$")
	public void submit_the_record_in_maker_stage() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_GRNNotificationSubmitButton());

		inventoryManagamentObj.accountPayable_GRNNotificationSubmitButton().click();
	}

	// -----------priyankaaa-----------------

	@And("^click on equiry menu$")
	public void click_on_equiry_menu() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());

		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on edit icon near fiancial transaction menu$")
	public void click_on_edit_icon_near_fiancial_transaction_menu() throws Throwable {
		inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^click transaction from date calender icon$")
	public void click_transaction_from_date_calender_icon() throws Throwable {
		inventoryManagamentObj.inventoryFromDate().click();

	}

	@And("^click on transaction to date calender icon$")
	public void click_on_transaction_to_date_calender_icon() throws Throwable {

		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
		inventoryManagamentObj.inventoryToDate().click();

	}

	@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
		Thread.sleep(3000);
	}

	// -------arshat KUBS_INV_MGMT_UAT_005_001----

//			@Then("^Click on Second icon page$")
//			public void click_on_second_icon_page() throws Throwable {
//
//				// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
//				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryTransfericon());
//				inventoryManagamentObj.inventoryTransfericon().click();
//			}

	@And("^Click Inventory Management module$")
	public void click_inventory_management_module() throws Throwable {

		// ---------TO VIEW THE Inventory Management----------//
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagement());
		inventoryManagamentObj.inventoryManagement().click();
		javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryStockReturnBranchEye());
	}

	@And("^Click on stock return from branch SubModule Eye icon$")
	public void click_on_stock_return_from_branch_submodule_eye_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Eye icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockReturnBranchEye());
		inventoryManagamentObj.inventoryStockReturnBranchEye().click();
	}

	@Then("^Click on stock return from branch Add icon$")
	public void click_on_stock_return_from_branch_add_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Add icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockReturnBranchAdd());
		inventoryManagamentObj.inventoryStockReturnBranchAdd().click();
	}

	@Then("^Save the Inventory Stock Record$")
	public void save_the_inventory_stock_record() throws Throwable {

		// -----------SAVE THE RECORD----------------//
//				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Save());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Save());
		inventoryManagamentObj.inventory_Save().click();
		Thread.sleep(3000);
	}

	@And("^goto the maker Notification icon$")
	public void goto_the_maker_notification_icon() throws Throwable {

		// ------------Maker Notification icon---------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_MakerNotification());
		inventoryManagamentObj.inventory_MakerNotification().click();
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_ReferanceId());
		String Referance_id = inventoryManagamentObj.inventory_ReferanceId().getText();
		// JsonDataReaderWriter readerData;
		readerData.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_ActionButton());
		inventoryManagamentObj.inventory_ActionButton().click();

	}

	@Then("^Click on Inventory Maintance module$")
	public void click_on_inventory_maintance_module() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_InventoryMaintenance());
		inventoryManagamentObj.inventory_InventoryMaintenance().click();
	}

	@And("^click on Master Item eye icon$")
	public void click_on_master_item_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_MasterItemEye());
		inventoryManagamentObj.inventory_MasterItemEye().click();
	}

	@Then("^click on the search icon$")
	public void click_on_the_search_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_SearchIcon());
		inventoryManagamentObj.inventory_SearchIcon().click();
	}

//		    @And("^Give Item description value and Click Edit icon$")
//		    public void give_item_description_value_and_click_edit_icon() throws Throwable {
//		    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Itemvalue());
//		    	inventoryManagamentObj.inventory_Itemvalue().click();
//		    	inventoryManagamentObj.inventory_Itemvalue().sendKeys("STAPLERS");
//		    }

//		    @When("^validate the quantity of the Item$")
//		    public void validate_the_quantity_of_the_item() throws Throwable {
//		    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_CurrentQuantity());
//		    	String Quantity = inventoryManagamentObj.inventory_CurrentQuantity().getText();
//		    	System.out.println("The Branch Available Quantity is: "+Quantity);
//		    }  
//		    
	// ---------------KUBS_INV_MGMT_UAT_004_StockConfirm

	@Then("^Inventory Second direction icon$")
	public void inventory_second_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//

		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryTransfericon());
		inventoryManagamentObj.inventoryTransfericon().click();
	}

	@And("^Inventory Management Module$")
	public void inventory_management_module() throws Throwable {

		// ---------TO VIEW THE Inventory Management----------//
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagement());
		inventoryManagamentObj.inventoryManagement().click();
		javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryStockReturnBranchEye());
	}

	@Then("^Click on Stock issue eye icon$")
	public void click_on_stock_issue_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockissueEye());
		inventoryManagamentObj.inventory_StockissueEye().click();

	}

	@And("^Click on First record eye icon$")
	public void click_on_first_record_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockissueGridEye());
		inventoryManagamentObj.inventory_StockissueGridEye().click();
	}

	@Then("^Get the New Request Referance No$")
	public void get_the_new_request_referance_no() throws Throwable {
		RefNo = inventoryManagamentObj.inventory_StockissueRefNo().getText();
		System.out.println("Request Referance No =" + RefNo);
	}

	@Then("^Click on Inventory stock confirmation eye icon$")
	public void click_on_inventory_stock_confirmation_eye_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Eye icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockConfirmEye());
		inventoryManagamentObj.inventory_StockConfirmEye().click();
	}

	@And("^Sub module Inventory stock confirmation click Add icon$")
	public void sub_module_inventory_stock_confirmation_click_add_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Add icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockConfirmAdd());
		inventoryManagamentObj.inventoryStockConfirmAdd().click();
	}

	@And("^Enter Item code Number$")
	public void enter_item_Code_Number() throws Throwable {

		// ---------ENTER THE ITEM CODE--------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ItemCode());
		inventoryManagamentObj.StockConfirm_ItemCode().click();
		inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.DOWN);
		inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.ENTER);

	}

	@Then("^Accept the status in checkbox$")
	public void accept_the_status_in_checkbox() throws Throwable {

		// ----------ACCEPT THE STATUS----------//
//				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_AcceptCheckBox());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_AcceptCheckBox());
		inventoryManagamentObj.StockConfirm_AcceptCheckBox().click();
	}

	@And("^click the save icon for StockConfirm$")
	public void click_the_save_icon_for_stockconfirm() throws Throwable {

		// ----------SAVE THE RECORD----------//
//				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Save());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_Save());
		inventoryManagamentObj.StockConfirm_Save().click();

		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.StockConfirm_Notification_Close());
		inventoryManagamentObj.StockConfirm_Notification_Close().click();
	}

	@And("^goto maker Notification Icon$")
	public void goto_maker_notification_Icon() throws Throwable {
		// ------------Maker Notification icon---------//
//				Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_MakerNotification());
		inventoryManagamentObj.StockConfirm_MakerNotification().click();
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ReferanceId());
		String Referance_id = inventoryManagamentObj.StockConfirm_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ActionButton());
		inventoryManagamentObj.StockConfirm_ActionButton().click();
	}

	@Then("^Click Submit button to Inventory Record$")
	public void click_submit_button_to_inventory_record() throws Throwable {
		// -----------Submit Icon Inventory-----------//
//				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Submit());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_Submit());
		inventoryManagamentObj.StockConfirm_Submit().click();
	}

	// ---------------------KUBS_INV_MGMT_UAT_004_GL-------------

	@Then("^click on report button$")
	public void click_on_report_button() throws Throwable {
		// -----------CLICK ON REPORT ICON----------------//
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryReportIcon());
				javascripthelper.JSEClick(inventoryManagamentObj.inventoryReportIcon());

				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click Enquiry menu$")
	public void click_Enquiry_menu() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on Edit icon near by financial transaction$")
	public void click_on_edit_icon_near_by_financial_transaction() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^click on transaction from date in calender icon$")
	public void click_on_transaction_from_date_calender_in_calender_icon() throws Throwable {
		// -----------CLICK ON CALANDER--------------//
		inventoryManagamentObj.inventoryFromDate().click();
	}

	@And("^click on the transaction to date in calender icon$")
	public void click_on_the_transaction_to_date_calender_in_calender_icon() throws Throwable {
		// ----------CLICK ON TRANSACTION TO DATE--------//
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
		inventoryManagamentObj.inventoryToDate().click();

	}

	@And("^click on view button to see the Record$")
	public void click_on_view_button_to_see_the_record() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		inventoryManagamentObj.inventoryViewButton().click();
		Thread.sleep(2000);

	}

	@Then("^validate voucher number$")
	public void validate_voucher_number() throws Throwable {
		Thread.sleep(2000);

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + inventoryManagementTestDataType.Voucher + "')]")));

				WebElement VoucherNum = driver.findElement(
						By.xpath("//span[contains(text(),'" + inventoryManagementTestDataType.Voucher + "')]"));
				break;

			}

			catch (NoSuchElementException nosuchElement)

			{
				javascripthelper.JavaScriptHelper(driver);
				javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());

				inventoryManagamentObj.inventory_Next().click();

			}

		}

		System.out.println("Record is present in the list");

	}

	@Then("^validate voucher number for stock issue$")
	public void validate_voucher_number_for_stock_issue() throws Throwable {
		Thread.sleep(2000);

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath(
						"//span[contains(text(),'" + inventoryManagementTestDataType.VoucherForStockIssue + "')]")));

				WebElement VoucherNum = driver.findElement(By.xpath(
						"//span[contains(text(),'" + inventoryManagementTestDataType.VoucherForStockIssue + "')]"));
				break;

			}

			catch (NoSuchElementException nosuchElement)

			{
				javascripthelper.JavaScriptHelper(driver);
				javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());

				inventoryManagamentObj.inventory_Next().click();

			}

		}

		System.out.println("Record is present in the list");

	}

	// -----------KUBS_INV_MGMT_UAT_007_005-----
	@Then("^Click on Report Tab$")
	public void click_on_report_tab() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_Report_Button());
		inventoryManagamentObj.report_Report_Button().click();
	}

	@Then("^Click on Stock Confirmation edit button$")
	public void click_on_stock_confirmation_edit_button() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(inventoryManagamentObj.Report_report_StockConfirmationReport());
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.Report_report_StockConfirmationReport());
		inventoryManagamentObj.Report_report_StockConfirmationReport().click();

	}

	@Then("^Click on Inventory access detail report edit grid$")
	public void click_on_inventory_access_detail_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryItemDetail_EditButton());
		inventoryManagamentObj.report_inventoryItemDetail_EditButton().click();
	}

	@And("^click on view button to view report$")
	public void click_on_view_button_to_view_report() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_viewButton());
		inventoryManagamentObj.report_viewButton().click();
		Thread.sleep(3000);
	}

	@Then("^Select PO Number$")
	public void select_po_number() throws Throwable {

//		    	Thread.sleep(2000);
//		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnPONumber());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnPONumber());
		inventoryManagamentObj.accountPayable_GrnPONumber().click();
//				Thread.sleep(2000);

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnPONumber());
		inventoryManagamentObj.accountPayable_GrnPONumber().sendKeys(testData.get("GRNPoNumber"));
//		    	inventoryManagamentObj.accountPayable_GrnPONumber().sendKeys(inventoryManagementTestDataType.GRNPoNumber);

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnPONumber());
		inventoryManagamentObj.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
//				Thread.sleep(1000);

	}

	// ---------KUBS_INV_MGMT_UAT_007_002-

	@Then("^Click on Inventory Request report edit grid$")
	public void click_on_inventory_request_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryRequest_Editbutton());
		inventoryManagamentObj.report_inventoryRequest_Editbutton().click();
	}

	@And("^click on view button to view report of inventory request$")
	public void click_on_view_button_to_view_report_of_inventory_request() throws Throwable {

		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_inventoryRequest_viewbutton());
		inventoryManagamentObj.report_inventoryRequest_viewbutton().click();
		Thread.sleep(3000);

	}
	// ---------------- KUBS_INV_MGMT_UAT_007_003--------

	@Then("^Click on Purchase requisition report edit grid$")
	public void click_on_purchase_requisition_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_PurchaseRequsition_editbutton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_PurchaseRequsition_editbutton());
		inventoryManagamentObj.report_PurchaseRequsition_editbutton().click();
	}

	@And("^Click on view button to view report of Purchase requisition report$")
	public void click_on_view_button_to_view_report_of_purchase_requisition_report() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_PurchaseRequsition_viewbutton());
		inventoryManagamentObj.report_PurchaseRequsition_viewbutton().click();
		Thread.sleep(3000);
	}

//----------  KUBS_INV_MGMT_UAT_007_004---------

	@Then("^Click on stock issuance report edit grid$")
	public void click_on_stock_issuance_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockIssuance_editbutton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockIssuance_editbutton());
		inventoryManagamentObj.report_StockIssuance_editbutton().click();
	}

	@And("^Click on view button to view report of stock issuance report$")
	public void click_on_view_button_to_view_report_of_stock_issuance_report() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockIssuance_ViewButton());
		inventoryManagamentObj.report_StockIssuance_ViewButton().click();
		Thread.sleep(3000);
	}

//----------KUBS_INV_MGMT_UAT_007_006-------
	@Then("^Click on stock return report edit grid$")
	public void click_on_stock_return_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockReturn_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockReturn_EditButton());
		inventoryManagamentObj.report_StockReturn_EditButton().click();
	}

	@And("^Click on view button to view report of stock return report$")
	public void click_on_view_button_to_view_report_of_stock_return_report() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
	}

	@Then("^verify the approved record is available in the report$")
	public void verify_the_approved_record_is_available_in_the_report() throws Throwable {
		System.out.println("Approved invoice number " + inventoryManagementTestDataType.Voucher);
		javascripthelper.JavaScriptHelper(driver);

		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
//	while(true)
//	{
//	try
//	{
//	javascripthelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")));
//	driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")).isDisplayed();
//	break;
//	}
//	catch(NoSuchElementException e)
//	{
//		inventoryManagamentObj.Report_report_NextButton().click();
//	}
//	catch(StaleElementReferenceException e1)
//	{
//	}
//	}
		browserHelper.switchToParentWithChildClose();
	}

//-----------KUBS_INV_MGMT_UAT_007_008-----
	@Then("^Click on Fund Requisition Report edit grid$")
	public void click_on_fund_requisition_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_FundRequsitionReport_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_FundRequsitionReport_EditButton());
		inventoryManagamentObj.report_FundRequsitionReport_EditButton().click();
	}

	@And("^Click on view button to view report of Fund Requisition Report$")
	public void click_on_view_button_to_view_report_of_fund_requisition_report() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
	}

//-------------KUBS_INV_MGMT_UAT_007_009-------------

	@Then("^Click on inventory item details Report edit grid$")
	public void click_on_inventory_item_details_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_InventoryItemDetails_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_InventoryItemDetails_EditButton());
		inventoryManagamentObj.report_InventoryItemDetails_EditButton().click();
	}

	@And("^Click on view button to view report of inventory item details Report$")
	public void click_on_view_button_to_view_report_of_inventory_item_details_report() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_InventoryItemDetails_ViewButton());
		inventoryManagamentObj.report_InventoryItemDetails_ViewButton().click();
	}
//----------------------KUBS_INV_MGMT_UAT_007_010------------

	@Then("^Click on inventory stock receipt Report edit grid$")
	public void click_on_inventory_stock_receipt_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		// waithelper.waitForElement(driver, 2000,
		// inventoryManagamentObj.report_inventoryItemDetail_EditButton());

		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryStockReceipt_EditButton());

		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryStockReceipt_EditButton());
		inventoryManagamentObj.report_inventoryStockReceipt_EditButton().click();
	}

	@And("^Click on view button to view report of inventory stock receipt Report$")
	public void click_on_view_button_to_view_report_of_inventory_stock_receipt_report() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();

	}

	@Then("^click on temp grid button of inventory code report$")
	public void click_on_temp_grid_button_of_inventory_code_report() {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.Report_InventoryCode_TempView());
		inventoryManagamentObj.Report_InventoryCode_TempView().click();

	}

	@Then("^the report is displaying with all the details$")

	public void the_report_is_displaying_with_all_the_details() throws InterruptedException {
		Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, inventoryManagamentObj.Report_inventoryCodeReport());
		boolean result = inventoryManagamentObj.Report_inventoryCodeReport().isDisplayed();
		System.out.println(result);
		browserHelper.switchToParentWithChildClose();

	}

	@And("^update test data to create GRN for generated PO$")
	public void update_test_data_to_create_grn_for_generated_po() throws Throwable {
		dataSetID=excelDataAssetConfigExecution.getTestdata("KUBS_FAT_UAT_001_004_01");
		testData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^Update test data to approve GRN record in reviewer$")
	public void update_test_data_to_approve_grn_record_in_reviewer() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_004_02_D1");
	}

	@And("^Update test data to approve GRN record in checker$")
	public void update_test_data_to_approve_grn_record_in_checker() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_004_03_D1");
	}

}
