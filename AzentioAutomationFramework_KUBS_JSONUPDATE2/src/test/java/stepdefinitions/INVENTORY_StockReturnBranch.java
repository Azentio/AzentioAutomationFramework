package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.INVENTORY_StockConfirm_GL;
import pageobjects.INVENTORY_StockConfirmationObj;
import pageobjects.INVENTORY_StockReturnBranch_Obj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.INVENTORY_InventoryManagement_DataType;

public class INVENTORY_StockReturnBranch extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	INVENTORY_StockReturnBranch_Obj stockReturnBranchObj = new INVENTORY_StockReturnBranch_Obj(driver);
	INVENTORY_StockConfirmationObj stockConfirmationObj = new INVENTORY_StockConfirmationObj(driver);
	INVENTORY_StockConfirm_GL stockConfirmGlObj = new INVENTORY_StockConfirm_GL(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	INVENTORY_InventoryManagement_DataType inventoryData = new INVENTORY_InventoryManagement_DataType(); 
	//INVENTORY_InventoryManagement_DataType inventoryData = jsonConfig.getStockReturnBranchByName("Maker");
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String ItemDescription;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);

	// ----------------------------@KUBS_INV_MGMT_UAT_005_StockReturn----------------------------//

	@Given("^Azentio Maker user url$")
	public void azentio_maker_user_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^Click on Second icon page$")
	public void click_on_second_icon_page() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		Thread.sleep(1500);
		waitHelper.waitForElementwithFluentwait(driver, stockReturnBranchObj.inventoryTransfericon());
		stockReturnBranchObj.inventoryTransfericon().click();
	}

//	@And("^Click Inventory Management module$")
//	public void click_inventory_management_module() throws Throwable {
//
//		// ---------TO VIEW THE Inventory Management----------//
//		javaScriptHelper.JavaScriptHelper(driver);
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryManagement());
//		stockReturnBranchObj.inventoryManagement().click();
//		javaScriptHelper.scrollIntoView(stockReturnBranchObj.inventoryStockReturnBranchEye());
//	}

//	@And("^Click on stock return from branch SubModule Eye icon$")
//	public void click_on_stock_return_from_branch_submodule_eye_icon() throws Throwable {
//
//		// ---------TO VIEW THE stock return from branch Eye icon----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryStockReturnBranchEye());
//		stockReturnBranchObj.inventoryStockReturnBranchEye().click();
//	}

//	@Then("^Click on stock return from branch Add icon$")
//	public void click_on_stock_return_from_branch_add_icon() throws Throwable {
//
//		// ---------TO VIEW THE stock return from branch Add icon----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryStockReturnBranchAdd());
//		stockReturnBranchObj.inventoryStockReturnBranchAdd().click();
//	}

//	@And("^Click on Request Referance No code$")
//	public void click_on_request_referance_no_code() throws Throwable {
//
//		// ---------TO Enter Request Referance No code----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryRequestReferanceNumber());
//		stockReturnBranchObj.inventoryRequestReferanceNumber().click();
//		stockReturnBranchObj.inventoryRequestReferanceNumber().sendKeys(inventoryData.requestReferanceNo);
//		stockReturnBranchObj.inventoryRequestReferanceNumber().sendKeys(Keys.ENTER);
//	}

//	@Then("^Click on Issue Referance No code$")
//	public void click_on_issue_referance_no_code() throws Throwable {
//
//		// ---------TO VIEW THE Issue Referance No code----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryIssueReferanceNo());
//		stockReturnBranchObj.inventoryIssueReferanceNo().click();
//		stockReturnBranchObj.inventoryIssueReferanceNo().sendKeys(Keys.DOWN);
//		stockReturnBranchObj.inventoryIssueReferanceNo().sendKeys(Keys.ENTER);
//	}

//	@And("^Click on item code$")
//	public void click_on_item_code() throws Throwable {
//
//		// ---------TO VIEW THE item code----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryItemCode());
//		stockReturnBranchObj.inventoryItemCode().click();
//		stockReturnBranchObj.inventoryItemCode().sendKeys(Keys.DOWN);
//		stockReturnBranchObj.inventoryItemCode().sendKeys(Keys.ENTER);
//		
//	}

//	@And("^Enter Return Quantity Stock value$")
//	public void enter_return_quantity_stock_value() throws Throwable {
//
//		// ---------TO VIEW THE Return Quantity----------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryReturnQuantity());
//		stockReturnBranchObj.inventoryReturnQuantity().click();
//		stockReturnBranchObj.inventoryReturnQuantity().sendKeys(inventoryData.returnQuantity);
//	}


    
//	@Then("^Click on Return Type and Choose Type$")
//	public void click_on_return_type_and_choose_type() throws Throwable {
//
//		// ---------TO VIEW THE Return Type----------//
//		waitHelper.waitForElement(driver, 5000, stockReturnBranchObj.inventory_ReturnType());
//		stockReturnBranchObj.inventory_ReturnType().click();
//		stockReturnBranchObj.inventory_ReturnType().sendKeys(inventoryData.returnType);
//		stockReturnBranchObj.inventory_ReturnType().sendKeys(Keys.ENTER);
//	}

//	@And("^Click on Return Reason and Choose Type$")
//	public void click_on_return_reason_and_choose_type() throws Throwable {
//
//		// ---------TO VIEW THE Return Reason----------//
//		waitHelper.waitForElement(driver, 5000, stockReturnBranchObj.inventory_ReturnReason());
//		stockReturnBranchObj.inventory_ReturnReason().click();
//		stockReturnBranchObj.inventory_ReturnReason().sendKeys(inventoryData.returnReason);
//		stockReturnBranchObj.inventory_ReturnReason().sendKeys(Keys.ENTER);
//	}

//	@Then("^Save the Inventory Stock Record$")
//	public void save_the_inventory_stock_record() throws Throwable {
//
//		// -----------SAVE THE RECORD----------------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_Save());
//		stockReturnBranchObj.inventory_Save().click();
//		Thread.sleep(3000);
//	}

//	@And("^goto the maker Notification icon$")
//	public void goto_the_maker_notification_icon() throws Throwable {
//
//		// ------------Maker Notification icon---------//
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_MakerNotification());
//		stockReturnBranchObj.inventory_MakerNotification().click();
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_ReferanceId());
//		String Referance_id = stockReturnBranchObj.inventory_ReferanceId().getText();
//		readerData.addReferanceData(Referance_id);
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_ActionButton());
//		stockReturnBranchObj.inventory_ActionButton().click();
//
//	}

	@Then("^Click Submit icon to Inventory Record$")
	public void click_submit_icon_to_inventory_record() throws Throwable {

		// -----------Submit Icon Inventory-----------//
		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_Submit());
		stockReturnBranchObj.inventory_Submit().click();
	}

//	@And("^Give Remark and submit Inventory field$")
//	public void give_remark_and_submit_inventory_field() throws Throwable {
//
//		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
//		inventoryData = jsonConfig.getStockReturnBranchByName("Maker");
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_Remark());
//		stockReturnBranchObj.inventory_Remark().click();
//		waitHelper.waitForElement(driver, 5000, stockReturnBranchObj.inventory_Remark());
//		stockReturnBranchObj.inventory_Remark().sendKeys(inventoryData.RemarkApprove);
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_RemarkSubmit());
//		stockReturnBranchObj.inventory_RemarkSubmit().click();
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_ReviewerId());
//		reviwerId = stockReturnBranchObj.inventory_ReviewerId().getText();
//		String ReviewerID = reviwerId.substring(85);
//		StringBuffer sb = new StringBuffer(ReviewerID);
//		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
//		String filanReviewerID = bufferedString.toString();
//		readerData.addData(filanReviewerID);
//		System.out.println(reviwerId);
//
//	}

	@Given("^Login As Reviewer user$")
	public void login_as_reviewer_user() throws Throwable {

		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@And("^Goto the Reviewer Notification$")
	public void goto_the_reviewer_notification() throws Throwable {

		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^Find submitted Record from maker End and open the Record$")
	public void find_submitted_code_from_maker_end_and_open_the_record() throws Throwable {

		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		reviewerObj.reviewer_action_button1().click();
	}

	@And("^Approve the Record from Reviewer End$")
	public void approve_the_record_from_reviewer_end() throws Throwable {

		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		Thread.sleep(2000);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter The Remark and submit from Reviewer End$")
	public void enter_the_remark_and_submit_from_reviewer_end() throws Throwable {
		INVENTORY_InventoryManagement_DataType inventoryData = jsonConfig.getStockReturnBranchByName("Maker");
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().click();
		reviewerObj.reviewerAlertRemarks().sendKeys(inventoryData.RemarkApprove);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());

	}

	// Checker Stage

	@Given("^Login As Checker user$")
	public void login_as_checker_user() throws Throwable {

		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click module Security management$")
	public void click_module_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click Sub module open Pool$")
	public void click_sub_module_open_pool() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@And("^Claim the Record Which submit from Reviewer$")
	public void claim_the_record_which_submit_from_reviewer() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerAlertClose());
		checkerObj.checkerAlertClose().click();
	}


	@Then("^Goto the Checker Notification$")
	public void goto_the_checker_notification() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}
	

	@And("^Find submitted Record from Reviewer End and Open the Record$")
	public void find_submitted_record_from_reviewer_end_and_open_the_record() throws Throwable {
		
		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}
	
    @Then("^Get Item Description value$")
    public void get_item_description_value() throws Throwable {
    	//--------------GET ITEM DESCRIPTION VALE-----------------//
    	//document.getElementsByClassName('native-input sc-ion-input-md')[1].value
    	waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventoryItemDescrption());
    	ItemDescription  = stockReturnBranchObj.inventoryItemDescrption().getText();
    	System.out.println(ItemDescription);
    }
    
	@And("^Approve the Record from Checker End$")
	public void approve_the_record_from_checker_end() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Enter the Remark and submit from checker End$")
	public void enter_the_remark_and_submit_from_checker_end() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(inventoryData.RemarkApprove);
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}
	
//	@Then("^Click on Inventory Maintance module$")
//    public void click_on_inventory_maintance_module() throws Throwable {
//		waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_InventoryMaintenance());
//		stockReturnBranchObj.inventory_InventoryMaintenance().click();
//    }

//    @And("^click on Master Item eye icon$")
//    public void click_on_master_item_eye_icon() throws Throwable {
//    	waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_MasterItemEye());
//    	stockReturnBranchObj.inventory_MasterItemEye().click();
//    }
    
//    @Then("^click on search icon$")
//    public void click_on_search_icon() throws Throwable {
//    	waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_SearchIcon());
//    	stockReturnBranchObj.inventory_SearchIcon().click();
//    }

    @And("^Give Item description value and Click Edit icon$")
    public void give_item_description_value_and_click_edit_icon() throws Throwable {
    	waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_Itemvalue());
    	stockReturnBranchObj.inventory_Itemvalue().click();
    	stockReturnBranchObj.inventory_Itemvalue().sendKeys("STAPLERS");
    }
    
    @When("^validate the quantity of the Item$")
    public void validate_the_quantity_of_the_item() throws Throwable {
    	waitHelper.waitForElement(driver, 2000, stockReturnBranchObj.inventory_CurrentQuantity());
    	String Quantity = stockReturnBranchObj.inventory_CurrentQuantity().getText();
    	System.out.println("The Branch Available Quantity is: "+Quantity);
    }
}
