package stepdefinitions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.InventoryManagementTestDataType;
import utilities.ExtentTestManager;

public class InventoryManagament extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;

	// ----KUBS_INV_MGMT_UAT_001_001-----

	@Given("^Navigate to URL and user should login as a maker$")
	public void navigate_to_url_and_user_should_login_as_a_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@Then("^Click on Finance$")
	public void click_on_finance() throws Throwable {
		waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		

	}

	@Then("^Click on Direction$")
	public void click_on_direction() throws Throwable {

		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

	}

	@Then("^Click on Inventory Management$")
	public void click_on_inventory_management() throws Throwable {

		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_button());
		inventoryManagamentObj.inventoryManagament_button().click();
	}

	@And("^Click on the eye icon of Inventory Request$")
	public void click_on_the_eye_icon_of_inventory_request() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton().click();
	}

	@Then("^Click on Add button$")
	public void click_on_add_button() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
	}

	@And("^Fill all the mandatory fields$")
	public void fill_all_the_mandatory_fields() throws Throwable {
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().click();
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().sendKeys(inventoryManagementTestDataType.BranchCode);
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().sendKeys(Keys.ENTER);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_ItemCodeDescriptionButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_ItemCodeDescriptionButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_SavingAccountChequeRadioButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SavingAccountChequeRadioButton().click();
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton().click();
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty().click();
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty().sendKeys(inventoryManagementTestDataType.RequestQty);

	}

	@Then("^Click on save button$")
	public void click_on_save_button() throws Throwable {

		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();

		// javascripthelper.JavaScriptHelper(driver);
		// String str = javascripthelper.executeScript("return
		// document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
		// System.out.println("Message:" + str);

	}

	@Then("^Click on Notification button$")
	public void click_on_notification_button() throws Throwable {
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
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
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

		waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	@And("^Submit the record$")
	public void submit_the_record() throws Throwable {
		
		// Submit button
		//Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
		inventoryManagamentObj.accountPayable_SubmitButton().click();
		//budgetTransferObj.budget_BudgetTransfer_Submit().click();
		javahelper.JavaScriptHelper(driver);
		// Remark
		//javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		/*inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed();
		boolean result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
		System.out.println(result);
		while(true) {
			try {
		//inventoryManagamentObj.accountPayable_SubmitButton().click();
			WebElement submitButton =	(WebElement) javahelper.executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]");
			submitButton.click();	
			break;
			}
			catch(ElementNotInteractableException e)
			{
				System.out.println(e.getMessage());
			}
			}*/
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		
		javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());

		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(inventoryManagementTestDataType.Remark);

		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
		Thread.sleep(2000);
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

	@Then("^Open Reviewer account$")
	public void open_reviewer_account() throws Throwable {
		reader = new JsonDataReaderWriter();
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", reader.readdata());
		ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");

	}

	@And("^Click on notification$")
	public void click_on_notification() throws Throwable {
		waithelper = new WaitHelper(driver);
		reviewer = new KUBS_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();
		browserHelper = new BrowserHelper(driver);
		budgetdata = jsonconfig.getBudgetdataByName("Maker");
		javascript = new JavascriptHelper();
		Thread.sleep(1000);
		waithelper = new WaitHelper(driver);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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

		waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	@Then("^Approve the record which we submitted from maker stage$")
	public void approve_the_record_which_we_submitted_from_maker_stage() throws Throwable {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);
	}

	@Then("^Go to Checker account$")
	public void go_to_checker_account() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");

	}

	@And("^Clam the record$")
	public void clam_the_record() throws Throwable {
		waithelper = new WaitHelper(driver);
		kubschecker = new KUBS_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();
		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^Click on notification and approve the record$")
	public void click_on_notification_and_approve_the_record() throws Throwable {
		javascript = new JavascriptHelper();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());

		kubschecker.checkerNotificationIcon().click();
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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

		waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(4000);
	}
//----------KUBS_INV_MGMT_UAT_002_001--------------

	@Then("^Click on Inventory maintenance$")
	public void click_on_inventory_maintenance() throws Throwable {
		waithelper.waitForElement(driver, 4000, inventoryManagamentObj.inventoryMaintenance_Button());
		inventoryManagamentObj.inventoryMaintenance_Button().click();
	}

	@Then("^Click on Instrument code master eye button$")
	public void click_on_instrument_code_master_eye_button() throws Throwable {
		waithelper.waitForElement(driver, 4000, inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton().click();
	}

	@Then("^Fill all the details$")
	public void fill_all_the_details() throws Throwable {
//We need to change instrument code every time. If not changed it will show error instrument code already exist
//We need to change instrument code & Description every time. If not changed it will show error instrument code already exist	
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().click();
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().sendKeys(inventoryManagementTestDataType.InstrumentCode);
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().click();
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().sendKeys(inventoryManagementTestDataType.InstrumentDescription);
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().click();
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().sendKeys(inventoryManagementTestDataType.StartingSerialNumber);
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().sendKeys(Keys.ENTER);
	}
	 @Then("^Click on save button on instrument code master$")
	    public void click_on_save_button_on_instrument_code_master() throws Throwable {
		 Thread.sleep(1000);
		 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		 inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton().click();
		 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
			inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
	    }
		
		//-------------KUBS_INV_MGMT_UAT_003_001------
		@Then("^Click on Inventory access master$")
	    public void click_on_inventory_access_master() throws Throwable {
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_EyeButton());
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_EyeButton().click();
	    }
		
		 @Then("^Fill all the required field for issuing inventories$")
		    public void fill_all_the_required_field_for_issuing_inventories() throws Throwable {
			 inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
			 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().click();
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(inventoryManagementTestDataType.AccessBranchCodeForIssue);
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(Keys.ENTER);  
			
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().click();
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(inventoryManagementTestDataType.InventoryBranchCodeForIssue);
			inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(Keys.ENTER); 
			
		    }

		    @Then("^Click on issue checkbox$")
		    public void click_on_issue_checkbox() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_IssueCheckBox());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_IssueCheckBox().click();    
				Thread.sleep(1000);
		    }
		    @Then("^Click on save button in inventory Access Master$")
		    public void click_on_save_button_in_inventory_access_master() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		    	inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton().click();
		    	Thread.sleep(5000);
		    }
		
		//-----------KUBS_INV_MGMT_UAT_003_002--------------
		    @Then("^Fill all the required field for receiving inventories$")
		    public void fill_all_the_required_fiel_for_receiving_inventories() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(inventoryManagementTestDataType.AccessBranchCodeForReceive);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(Keys.ENTER);  
				
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(inventoryManagementTestDataType.InventoryBranchCodeForReceive);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(Keys.ENTER);
		    }
		    
		    @Then("^Click on Recive checkbox$")
		    public void click_on_recive_checkbox() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox().click();  
		    }
		//----    KUBS_INV_MGMT_UAT_003_003-----
		    
		    @Then("^Fill all the required field for ordering inventories$")
		    public void fill_all_the_required_field_for_ordering_inventories() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(inventoryManagementTestDataType.AccessBranchCodeForOrder);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(Keys.ENTER);  
				
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(inventoryManagementTestDataType.AccessBranchCodeForOrder);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(Keys.ENTER);
		    
		    }
		    @Then("^Click on Place Order checkbox$")
		    public void click_on_place_order_checkbox() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox().click();  
		    }
		//---------KUBS_INV_MGMT_UAT_003_004----    
		    @Then("^Fill all the required field for requesting inventories$")
		    public void fill_all_the_required_field_for_requesting_inventories() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(inventoryManagementTestDataType.AccessBranchCodeForRequest);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(Keys.ENTER);  
				
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().click();
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(inventoryManagementTestDataType.InventoryBranchCodeForRequest);
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(Keys.ENTER);
		  
		    }
		    @Then("^Click on Place Request checkbox$")
		    public void click_on_place_request_checkbox() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox());
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox().click();  
		    }
		    
		    //----------KUBS_INV_MGMT_UAT_001_004	Create a GRN-----
		    @Then("^Click on Accounts Payable$")
		    public void click_on_accounts_payable() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayableButton());
				inventoryManagamentObj.accountPayableButton().click();  
		    }

		    @Then("^Click on Good Recived Note GRN Eye buutton$")
		    public void click_on_good_recived_notegrn_eye_buutton() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GoodsReceivedNoteGRNEyeButton());
				inventoryManagamentObj.accountPayable_GoodsReceivedNoteGRNEyeButton().click(); 
		    }
		    @Then("^Fill the form for GRN$")
		    public void fill_the_form_for_grn() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnBpName());
				inventoryManagamentObj.accountPayable_GrnBpName().click(); 
				
				inventoryManagamentObj.accountPayable_GrnBpName().sendKeys(inventoryManagementTestDataType.GRNbpName);
				inventoryManagamentObj.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
				
				inventoryManagamentObj.accountPayable_GRN_BPBranch().click();
				//Thread.sleep(4000);
				inventoryManagamentObj.accountPayable_GRN_BPBranch().sendKeys(inventoryManagementTestDataType.GRNbpBranch);
				inventoryManagamentObj.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
				//Thread.sleep(4000);
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnInvoiceNumber());
				inventoryManagamentObj.accountPayable_GrnInvoiceNumber().click(); 
				
				inventoryManagamentObj.accountPayable_GrnInvoiceNumber().sendKeys(inventoryManagementTestDataType.GRNInvoiceNumber);
				inventoryManagamentObj.accountPayable_GrnInvoiceNumber().sendKeys(Keys.ENTER);
				
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnDeliveryLocation());
				inventoryManagamentObj.accountPayable_GrnDeliveryLocation().click();
				inventoryManagamentObj.accountPayable_GrnDeliveryLocation().sendKeys(inventoryManagementTestDataType.GRNDeliveryLocation);
				inventoryManagamentObj.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
				
				
				
				
		    }
		    @Then("^Click on save button to save the record$")
		    public void click_on_save_button_to_save_the_record() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
				inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();
				Thread.sleep(4000);
		    }
		    @Then("^Click on notification & open record which we created for GRN$")
		    public void click_on_notification_open_record_which_we_created_for_grn() throws Throwable {
		    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
				budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();
				
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
				String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
				jsonWriter.addReferanceData(id);
				System.out.println("Reference ID:" + id);
				for (int i = 1; i <= 35; i++) {
					try {
						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
						referanceID.click();
						System.out.println(referanceID);
						// Assert.assertTrue(referanceID.isDisplayed());
						break;
					} catch (NoSuchElementException e) {
						waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

						budgetTransferObj.maker_notification_next_button().click();
					}
				}
					budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();
					
					String before_xpath = "//span[contains(text(),'";
					String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
					Thread.sleep(3000);
					waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
					driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
				/*By xpath = By.xpath(before_xpath + reader.readReferancedata() + after_xpath);
				Actions action = new Actions(driver);
				
				action.moveToElement((WebElement) xpath).click().perform();
				*/
				}
		    

		    @Then("^Click on Item Details Tab$")
		    public void click_on_item_details_tab() throws Throwable {
		    	Thread.sleep(2000);
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_GRNItemDetails());
				inventoryManagamentObj.inventoryManagament_GRNItemDetails().click();
		    }


		    
		    @Then("^Select PO Number$")
		    public void select_po_number() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	Thread.sleep(2000);
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnPONumber());
				inventoryManagamentObj.accountPayable_GrnPONumber().click();
				Thread.sleep(2000);
				inventoryManagamentObj.accountPayable_GrnPONumber().sendKeys(inventoryManagementTestDataType.GRNPoNumber);
				inventoryManagamentObj.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
		    }

		    @Then("^Add qty received qty approved$")
		    public void add_qty_received_qty_approved() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnQtyReceived());
				inventoryManagamentObj.accountPayable_GrnQtyReceived().click();
				inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(inventoryManagementTestDataType.GRNQtyReceived);
				inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
		    }

		    @Then("^Click on GRN item save button$")
		    public void click_on_grn_item_save_button() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnQtyApproved());
				inventoryManagamentObj.accountPayable_GrnQtyApproved().click();
				inventoryManagamentObj.accountPayable_GrnQtyApproved().sendKeys(inventoryManagementTestDataType.GRNQtyApproved);
				inventoryManagamentObj.accountPayable_GrnQtyApproved().sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnSaveButton());
				
				
				WebElement save = inventoryManagamentObj.accountPayable_GrnSaveButton();
				clicksAndActionHelper.moveToElement(save);
				inventoryManagamentObj.accountPayable_GrnSaveButton().click();
				//clicksAndActionHelper.clickOnElement(save);
				Thread.sleep(2000);
		    }
		    @And("^Submit the record in maker stage$")
		    public void submit_the_record_in_maker_stage() throws Throwable {
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GRNNotificationSubmitButton());
				
		    	inventoryManagamentObj.accountPayable_GRNNotificationSubmitButton().click();
		    } 
		    
		    
	}

