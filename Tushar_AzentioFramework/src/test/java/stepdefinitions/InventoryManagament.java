package stepdefinitions;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
import io.cucumber.java.en.When;
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
	JsonDataReaderWriter readerData =new JsonDataReaderWriter();
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	String reviwerId;
	String RefNo;
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
		    
		    
		    
		//-----------priyankaaa-----------------
		 

			@Then("^click on report segment button$")
			public void click_on_report_segment_button() throws Throwable {
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryReportIcon());
				inventoryManagamentObj.inventoryReportIcon().click();
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
				Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());
				
			}

			@And("^click on equiry menu$")
			public void click_on_equiry_menu() throws Throwable {
				waithelper.waitForElement(driver, 3000,inventoryManagamentObj.inventoryEnquiryMenu());

				inventoryManagamentObj.inventoryEnquiryMenu().click();
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
				Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());
				
			}

			@Then("^click on edit icon near by fiancial transaction menu$")
			public void click_on_edit_icon_near_by_fiancial_transaction_menu() throws Throwable {
				inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

			}

			@And("^choose branch code$")
			public void choose_branch_code() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				inventoryManagamentObj.inventoryBranchCode().sendKeys(inventoryManagementTestDataType.BranchCode);
				inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
			}

			@And("^choose Gl code$")
			public void choose_gl_code() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				inventoryManagamentObj.inventoryGlCode().sendKeys(inventoryManagementTestDataType.gLCode);
				inventoryManagamentObj.inventoryGlCode().sendKeys(Keys.ENTER);
			}

			@And("^click on transaction from date calender icon$")
			public void click_on_transaction_from_date_calender_icon() throws Throwable {
				inventoryManagamentObj.inventoryFromDate().click();

			}

			@Then("^choose the from date$")
			public void choose_the_from_date() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				javascripthelper.JavaScriptHelper(driver);
				while(true)
		        {
				try
				{
				
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
					WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
				    break;
				}
				
				catch(NoSuchElementException nosuchElement)
				{
					inventoryManagamentObj.inventoryNextMonth().click();
				}
				}
				WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullMonth+" "+inventoryManagementTestDataType.GlDay+", "+inventoryManagementTestDataType.GlYear+"']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}

			@And("^click on the transaction to date calender icon$")
			public void click_on_the_transaction_to_date_calender_icon() throws Throwable {

				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
				inventoryManagamentObj.inventoryToDate().click();
			
			}

			@Then("^choose the to date$")
			public void choose_the_to_date() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				while(true)
		        {
				try
				{
				
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
					WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
				    break;
				}
				
				catch(NoSuchElementException nosuchElement)
				{
					inventoryManagamentObj.inventoryNextMonth().click();
				}
				}
				WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}

			@And("^click on view button$")
			public void click_on_view_button() throws Throwable {
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryViewButton());
				inventoryManagamentObj.inventoryViewButton().click();
				Thread.sleep(3000);
			}
		    
		    
	//-------arshat KUBS_INV_MGMT_UAT_005_001----
			
		    
			@Then("^Click on Second icon page$")
			public void click_on_second_icon_page() throws Throwable {

				// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryTransfericon());
				inventoryManagamentObj.inventoryTransfericon().click();
			}

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

			@And("^Click on Request Referance No code$")
			public void click_on_request_referance_no_code() throws Throwable {

				// ---------TO Enter Request Referance No code----------//
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryRequestReferanceNumber());
				inventoryManagamentObj.inventoryRequestReferanceNumber().click();
				inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(inventoryManagementTestDataType.requestReferanceNo);
				inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(Keys.ENTER);
			}

			@Then("^Click on Issue Referance No code$")
			public void click_on_issue_referance_no_code() throws Throwable {

				// ---------TO VIEW THE Issue Referance No code----------//
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryIssueReferanceNo());
				inventoryManagamentObj.inventoryIssueReferanceNo().click();
				inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.DOWN);
				inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.ENTER);
			}

			@And("^Click on item code$")
			public void click_on_item_code() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				// ---------TO VIEW THE item code----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryItemCode());
				inventoryManagamentObj.inventoryItemCode().click();
				inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.DOWN);
				inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.ENTER);
				
			}

			@And("^Enter Return Quantity Stock value$")
			public void enter_return_quantity_stock_value() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				// ---------TO VIEW THE Return Quantity----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryReturnQuantity());
				inventoryManagamentObj.inventoryReturnQuantity().click();
				inventoryManagamentObj.inventoryReturnQuantity().sendKeys(inventoryManagementTestDataType.returnQuantity);
			}


		    
			@Then("^Click on Return Type and Choose Type$")
			public void click_on_return_type_and_choose_type() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				// ---------TO VIEW THE Return Type----------//
				waithelper.waitForElement(driver, 5000, inventoryManagamentObj.inventory_ReturnType());
				inventoryManagamentObj.inventory_ReturnType().click();
				inventoryManagamentObj.inventory_ReturnType().sendKeys(inventoryManagementTestDataType.returnType);
				inventoryManagamentObj.inventory_ReturnType().sendKeys(Keys.ENTER);
			}

			@And("^Click on Return Reason and Choose Type$")
			public void click_on_return_reason_and_choose_type() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				// ---------TO VIEW THE Return Reason----------//
				waithelper.waitForElement(driver, 5000, inventoryManagamentObj.inventory_ReturnReason());
				inventoryManagamentObj.inventory_ReturnReason().click();
				inventoryManagamentObj.inventory_ReturnReason().sendKeys(inventoryManagementTestDataType.returnReason);
				inventoryManagamentObj.inventory_ReturnReason().sendKeys(Keys.ENTER);
			}

			@Then("^Save the Inventory Stock Record$")
			public void save_the_inventory_stock_record() throws Throwable {

				// -----------SAVE THE RECORD----------------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Save());
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
				//JsonDataReaderWriter readerData;
				readerData.addReferanceData(Referance_id);
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_ActionButton());
				inventoryManagamentObj.inventory_ActionButton().click();

			}

			@Then("^Click Submit icon to Inventory Record$")
			public void click_submit_icon_to_inventory_record() throws Throwable {

				// -----------Submit Icon Inventory-----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Submit());
				inventoryManagamentObj.inventory_Submit().click();
			}

			@And("^Give Remark and submit Inventory field$")
			public void give_remark_and_submit_inventory_field() throws Throwable {

				// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Remark());
				inventoryManagamentObj.inventory_Remark().click();
				waithelper.waitForElement(driver, 5000, inventoryManagamentObj.inventory_Remark());
				inventoryManagamentObj.inventory_Remark().sendKeys(inventoryManagementTestDataType.RemarkApprove);
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_RemarkSubmit());
				inventoryManagamentObj.inventory_RemarkSubmit().click();
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_ReviewerId());
				String reviwerId = inventoryManagamentObj.inventory_ReviewerId().getText();
				String ReviewerID = reviwerId.substring(85);
				StringBuffer sb = new StringBuffer(ReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				//JsonDataReaderWriter readerData;
				readerData.addData(filanReviewerID);
				System.out.println(reviwerId);

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
		    
		    @Then("^click on search icon$")
		    public void click_on_search_icon() throws Throwable {
		    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_SearchIcon());
		    	inventoryManagamentObj.inventory_SearchIcon().click();
		    }

		    @And("^Give Item description value and Click Edit icon$")
		    public void give_item_description_value_and_click_edit_icon() throws Throwable {
		    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Itemvalue());
		    	inventoryManagamentObj.inventory_Itemvalue().click();
		    	inventoryManagamentObj.inventory_Itemvalue().sendKeys("STAPLERS");
		    }
		    
		    @When("^validate the quantity of the Item$")
		    public void validate_the_quantity_of_the_item() throws Throwable {
		    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_CurrentQuantity());
		    	String Quantity = inventoryManagamentObj.inventory_CurrentQuantity().getText();
		    	System.out.println("The Branch Available Quantity is: "+Quantity);
		    }  
		    
		    //---------------KUBS_INV_MGMT_UAT_004_StockConfirm
		    
		    
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
		        System.out.println("Request Referance No =" +RefNo);
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

			@Then("^Enter Request Referance Number$")
			public void enter_request_referance_number() throws Throwable {
				
				// -----------ENTER THE REQUEST REFERANCE NUMBER---------//
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_RequestReferanceNumber());
				inventoryManagamentObj.StockConfirm_RequestReferanceNumber().click();
				inventoryManagamentObj.StockConfirm_RequestReferanceNumber().sendKeys(RefNo);
				inventoryManagamentObj.StockConfirm_RequestReferanceNumber().sendKeys(Keys.ENTER);
			}

			@And("^Enter Item code Number$")
			public void enter_item_code_number() throws Throwable {
				
				// ---------ENTER THE ITEM CODE--------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ItemCode());
				inventoryManagamentObj.StockConfirm_ItemCode().click();
				inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.DOWN);
				inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.ENTER);
			
			}

			@Then("^Accept the status in checkbox$")
			public void accept_the_status_in_checkbox() throws Throwable {

				// ----------ACCEPT THE STATUS----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_AcceptCheckBox());
				inventoryManagamentObj.StockConfirm_AcceptCheckBox().click();
			}

			@And("^click the save icon for StockConfirm$")
			public void click_the_save_icon_for_stockconfirm() throws Throwable {

				// ----------SAVE THE RECORD----------//
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Save());
				inventoryManagamentObj.StockConfirm_Save().click();
				Thread.sleep(2000);
				inventoryManagamentObj.StockConfirm_Notification_Close().click();
			}

			@And("^goto maker Notification icon$")
			public void goto_maker_notification_icon() throws Throwable {
				// ------------Maker Notification icon---------//
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
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Submit());
				inventoryManagamentObj.StockConfirm_Submit().click();
			}

			@And("^Give Remark and submit to reviewer$")
			public void give_remark_and_submit_to_reviewer() throws Throwable {
				// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Remark());
				inventoryManagamentObj.StockConfirm_Remark().click();
				waithelper.waitForElement(driver, 5000, inventoryManagamentObj.StockConfirm_Remark());
				inventoryManagamentObj.StockConfirm_Remark().sendKeys(inventoryManagementTestDataType.RemarkApprove);
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_RemarkSubmit());
				inventoryManagamentObj.StockConfirm_RemarkSubmit().click();
				waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ReviewerId());
				reviwerId = inventoryManagamentObj.StockConfirm_ReviewerId().getText();
				String ReviewerID = reviwerId.substring(85);
				StringBuffer sb = new StringBuffer(ReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				readerData.addData(filanReviewerID);
				System.out.println(reviwerId);
			}
		    
		 //---------------------KUBS_INV_MGMT_UAT_004_GL-------------
			
		    
			@Then("^click on report button$")
			public void click_on_report_button() throws Throwable {
				//-----------CLICK ON REPORT ICON----------------//
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryReportIcon());
				inventoryManagamentObj.inventoryReportIcon().click();
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
				Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());

			}

			@And("^click Enquiry menu$")
			public void click_Enquiry_menu() throws Throwable {
				//------------CLICK ON ENQUIRY ICON--------------//
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
				inventoryManagamentObj.inventoryEnquiryMenu().click();
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
				Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

			}

			@Then("^click on Edit icon near by financial transaction$")
			public void click_on_edit_icon_near_by_financial_transaction() throws Throwable {
				//-----------CLICK ON FINANCIAL EDIT------------//
				inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

			}

			@And("^choose branch code Id$")
			public void choose_branch_code_id() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				//-----------CLICK ON BRANCH CODE------------//
				inventoryManagamentObj.inventoryBranchCode().sendKeys(inventoryManagementTestDataType.BranchCode);
				inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
			}

			@And("^choose Gl code Id$")
			public void choose_gl_code_id() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				//-----------CLICK ON GL CODE--------------//
				inventoryManagamentObj.inventoryGlCode().sendKeys(inventoryManagementTestDataType.gLCode);
				inventoryManagamentObj.inventoryGlCode().sendKeys(Keys.ENTER);
			}

			@And("^click on transaction from date in calender icon$")
			public void click_on_transaction_from_date_calender_in_calender_icon() throws Throwable {
				//-----------CLICK ON CALANDER--------------//
				inventoryManagamentObj.inventoryFromDate().click();
			}

			@Then("^choose from date in calender$")
			public void choose_from_date_in_calender() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				//----------CLICK ON FROM DATE--------------//
				javascripthelper.JavaScriptHelper(driver);
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ inventoryManagementTestDataType.GlMonth + " " + inventoryManagementTestDataType.GlYear + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ inventoryManagementTestDataType.GlMonth + " " + inventoryManagementTestDataType.GlYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						inventoryManagamentObj.inventoryNextMonth().click();
					}
				}
				WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + inventoryManagementTestDataType.GlFullMonth + " "
						+ inventoryManagementTestDataType.GlDay + ", " + inventoryManagementTestDataType.GlYear + "']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}

			@And("^click on the transaction to date in calender icon$")
			public void click_on_the_transaction_to_date_calender_in_calender_icon() throws Throwable {
				//----------CLICK ON TRANSACTION TO DATE--------//
				waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
				inventoryManagamentObj.inventoryToDate().click();

			}

			@Then("^choose the To date in calender$")
			public void choose_the_to_date_in_calender() throws Throwable {
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				while (true) {
					try {

						waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
								+ inventoryManagementTestDataType.GlToMonth + " " + inventoryManagementTestDataType.GlYear + "')]")));
						WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
								+ inventoryManagementTestDataType.GlToMonth + " " + inventoryManagementTestDataType.GlYear + "')]"));
						break;
					}

					catch (NoSuchElementException nosuchElement) {
						inventoryManagamentObj.inventoryNextMonth().click();
					}
				}
				WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + inventoryManagementTestDataType.GlFullToMonth
						+ " " + inventoryManagementTestDataType.GlToDate + ", " + inventoryManagementTestDataType.GlYear + "']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}

			@And("^click on view button to see the Record$")
			public void click_on_view_button_to_see_the_record() throws Throwable {
				//----------CLICK ON VIEW BUTTON----------//
				inventoryManagamentObj.inventoryViewButton().click();
				Thread.sleep(2000);

			}
			
			 @Then("^validate voucher number$")
			    public void validate_voucher_number() throws Throwable {
				 Thread.sleep(3000);

				    while(true) {
				    	try{

				waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.Voucher+"')]")));


				WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.Voucher+"')]"));
				break;


				}


				catch(NoSuchElementException nosuchElement)

				{
					javascripthelper.JavaScriptHelper(driver);
			    	javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());
			    	

					inventoryManagamentObj.inventory_Next().click();

				}


				 }

				System.out.println("Record is present in the list");

				  

				 }
			    
	    
		//-----------KUBS_INV_MGMT_UAT_007_005-----

		    @Then("^Click on Stock Confirmation edit button$")
		    public void click_on_stock_confirmation_edit_button() throws Throwable {
		    	javascripthelper.JavaScriptHelper(driver);
		    	javascripthelper.scrollIntoView(inventoryManagamentObj.Report_report_StockConfirmationReport());
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.Report_report_StockConfirmationReport());
				inventoryManagamentObj.Report_report_StockConfirmationReport().click();    
				 
		    }

		    @Then("^Fill the details of stock confirmation$")
		    public void fill_the_details_of_stock_confirmation() throws Throwable {
		    	
		    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus());
				inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().click();  
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().sendKeys(inventoryManagementTestDataType.AcceptStatus);
				inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().sendKeys(Keys.ENTER);
		    }
		    
		    //----------------KUBS_FAT_UAT_004_002
		   
		    
		    
		    //------------------KUBS_INV_MGMT_UAT_007_001-----
		    @Then("^Click on Inventory access detail report edit grid$")
		    public void click_on_inventory_access_detail_report_edit_grid() throws Throwable {
		    	javascripthelper.JavaScriptHelper(driver);
				//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
				
				javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryItemDetail_EditButton());
				inventoryManagamentObj.report_inventoryItemDetail_EditButton().click();
		    }

		    @Then("^Fill the form for  Inventory access detail report$")
		    public void fill_the_form_for_inventory_access_detail_report() throws Throwable {
		    	   
		    	
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryItemDetail_ItemDescription());
				inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().click();
				inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().sendKeys(inventoryManagementTestDataType.ItemDescriptionForInvtItemDetails);
				inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().sendKeys(Keys.ENTER);
				//Calendar
				Thread.sleep(2000);
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryItemCalandar_report());
				inventoryManagamentObj.inventoryItemCalandar_report().click();
				//waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
				//inventoryManagamentObj.inventoryToDate().click();
				 
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				while(true)
		        {
				try
				{
				
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
					WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
				    break;
				}
				
				catch(NoSuchElementException nosuchElement)
				{
					inventoryManagamentObj.inventoryNextMonth().click();
				}
				}
				WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}
			
		    

		    @And("^click on view button to view report$")
		    public void click_on_view_button_to_view_report() throws Throwable {
		    	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_viewButton());
				inventoryManagamentObj.report_viewButton().click();
				Thread.sleep(3000); 
		    }
		    
	//---------KUBS_INV_MGMT_UAT_007_002-	    
		    
		    
		    @Then("^Click on Inventory Request report edit grid$")
		    public void click_on_inventory_request_report_edit_grid() throws Throwable {
		    	javascripthelper.JavaScriptHelper(driver);
				//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
				
				javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryRequest_Editbutton());
				inventoryManagamentObj.report_inventoryRequest_Editbutton().click();  
		    }

		    @Then("^Fill the form for Inventory Request report$")
		    public void fill_the_form_for_inventory_request_report() throws Throwable {
		    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo());
				inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().click();
				inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().sendKeys(inventoryManagementTestDataType.RequestReferenceNumber);
				inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().sendKeys(Keys.ENTER);
				//Calendar
				Thread.sleep(2000);
				waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryRequest_calanderbutton());
				inventoryManagamentObj.report_inventoryRequest_calanderbutton().click();
			 
				 
				inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
				while(true)
		        {
				try
				{
				
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
					WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
				    break;
				}
				
				catch(NoSuchElementException nosuchElement)
				{
					inventoryManagamentObj.inventoryNextMonth().click();
				}
				}
				WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
			}
			  
		    	    
		    
@And("^click on view button to view report of inventory request$")
public void click_on_view_button_to_view_report_of_inventory_request() throws Throwable {
   
	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_inventoryRequest_viewbutton());
	inventoryManagamentObj.report_inventoryRequest_viewbutton().click();
	Thread.sleep(3000); 
	
	
	
}
	//----------------	    KUBS_INV_MGMT_UAT_007_003--------
		    
@Then("^Click on Purchase requisition report edit grid$")
public void click_on_purchase_requisition_report_edit_grid() throws Throwable {
	javascripthelper.JavaScriptHelper(driver);
	//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
	
	javascripthelper.scrollIntoView(inventoryManagamentObj.report_PurchaseRequsition_editbutton());
	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_PurchaseRequsition_editbutton());
	inventoryManagamentObj.report_PurchaseRequsition_editbutton().click();
}

@Then("^Fill the form for Purchase requisition report$")
public void fill_the_form_for_purchase_requisition_report() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo());
	inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().click();
	inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().sendKeys(inventoryManagementTestDataType.IndentReferenceNo);
	inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().sendKeys(Keys.ENTER);
	//Calendar
	Thread.sleep(2000);
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
	inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
	Thread.sleep(2000);
	 
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
	while(true)
    {
	try
	{
	
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
		WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
	    break;
	}
	
	catch(NoSuchElementException nosuchElement)
	{
		inventoryManagamentObj.inventoryNextMonth().click();
	}
	}
	WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
	clicksAndActionHelper.doubleClick(FinalDay);
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
	//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
	
	javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockIssuance_editbutton());
	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockIssuance_editbutton());
	inventoryManagamentObj.report_StockIssuance_editbutton().click();
}

@Then("^Fill the form for stock issuance report$")
public void fill_the_form_for_stock_issuance_report() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo());
	inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().click();
	inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().sendKeys(inventoryManagementTestDataType.IssueReferenceNo);
	inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().sendKeys(Keys.ENTER);
	//Calendar
	Thread.sleep(2000);
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
	inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
	Thread.sleep(2000);
	 
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
	while(true)
    {
	try
	{
	
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
		WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
	    break;
	}
	
	catch(NoSuchElementException nosuchElement)
	{
		inventoryManagamentObj.inventoryNextMonth().click();
	}
	}
	WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
	clicksAndActionHelper.doubleClick(FinalDay);
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
	//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
	
	javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockReturn_EditButton());
	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockReturn_EditButton());
	inventoryManagamentObj.report_StockReturn_EditButton().click();
}

@Then("^Fill the form for stock return report$")
public void fill_the_form_for_stock_return_report() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_StockReturn_returntype_Textbox());
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().click();
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(inventoryManagementTestDataType.ReturnType);
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(Keys.ENTER);
	
	
	
	//Calendar
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
		Thread.sleep(2000);
		 
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while(true)
	    {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
}

@And("^Click on view button to view report of stock return report$")
public void click_on_view_button_to_view_report_of_stock_return_report() throws Throwable {
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
	inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click(); 
}
@Then("^verify the approved record is available in the report$")
public void verify_the_approved_record_is_available_in_the_report() throws Throwable {
	System.out.println("Approved invoice number "+inventoryManagementTestDataType.Voucher);
	javascripthelper.JavaScriptHelper(driver);

	browserHelper.SwitchToWindow(1);
	Thread.sleep(1500);
	while(true)
	{
	try
	{
	javascripthelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")));
	driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")).isDisplayed();
	break;
	}
	catch(NoSuchElementException e)
	{
		inventoryManagamentObj.Report_report_NextButton().click();
	}
	catch(StaleElementReferenceException e1)
	{
	}
	}
	browserHelper.switchToParentWithChildClose();
	}


//-----------KUBS_INV_MGMT_UAT_007_008-----
@Then("^Click on Fund Requisition Report edit grid$")
public void click_on_fund_requisition_report_edit_grid() throws Throwable {
	javascripthelper.JavaScriptHelper(driver);
	//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
	
	javascripthelper.scrollIntoView(inventoryManagamentObj.report_FundRequsitionReport_EditButton());
	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_FundRequsitionReport_EditButton());
	inventoryManagamentObj.report_FundRequsitionReport_EditButton().click();
}

@Then("^Fill the form for Fund Requisition Report$")
public void fill_the_form_for_fund_requisition_report() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	
	
	
	
	//Calendar
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_FundRequsitionReport_CalendarButton());
		inventoryManagamentObj.report_FundRequsitionReport_CalendarButton().click();
		Thread.sleep(2000);
		 
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while(true)
	    {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
}

@And("^Click on view button to view report of Fund Requisition Report$")
public void click_on_view_button_to_view_report_of_fund_requisition_report() throws Throwable {
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
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

@Then("^Fill the form for inventory item details Report$")
public void fill_the_form_for_inventory_item_details_report() throws Throwable {
	
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox());
	inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().click();
	inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().sendKeys(inventoryManagementTestDataType.Itemdescription);
	inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().sendKeys(Keys.ENTER);
	
	
	
	//Calendar
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
		Thread.sleep(2000);
		 
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while(true)
	    {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
}

@And("^Click on view button to view report of inventory item details Report$")
public void click_on_view_button_to_view_report_of_inventory_item_details_report() throws Throwable {
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_InventoryItemDetails_ViewButton());
	inventoryManagamentObj.report_InventoryItemDetails_ViewButton().click();    
}
//----------------------KUBS_INV_MGMT_UAT_007_010------------


@Then("^Click on inventory stock receipt Report edit grid$")
public void click_on_inventory_stock_receipt_report_edit_grid() throws Throwable {
	javascripthelper.JavaScriptHelper(driver);
	//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
	
	javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryStockReceipt_EditButton());
	
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_EditButton());
	inventoryManagamentObj.report_inventoryStockReceipt_EditButton().click();
}

@Then("^Fill the form for inventory stock receipt Report$")
public void fill_the_form_for_inventory_stock_receipt_report() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox());
	inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().click();
	inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().sendKeys(inventoryManagementTestDataType.POReference);
	inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().sendKeys(Keys.ENTER);
	
	
	
	//Calendar
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
		Thread.sleep(2000);
		 
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while(true)
	    {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
}

@And("^Click on view button to view report of inventory stock receipt Report$")
public void click_on_view_button_to_view_report_of_inventory_stock_receipt_report() throws Throwable {
	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
	inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
	   
}



//-------------KUBS_INV_MGMT_UAT_006_001-----------
@Then("^Fill the form for stock return report for return the inventories$")
public void fill_the_form_for_stock_return_report_for_return_the_inventories() throws Throwable {
	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_StockReturn_returntype_Textbox());
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().click();
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(inventoryManagementTestDataType.ReturnTypeInventory);
	inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(Keys.ENTER);
	
	
	
	//Calendar
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
		Thread.sleep(2000);
		 
		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while(true)
	    {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
}

















}	    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	

