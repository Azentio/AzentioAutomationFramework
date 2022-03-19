package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
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
import pageobjects.INVENTORY_StockConfirm_GL;
import pageobjects.INVENTORY_StockConfirmationObj;
import pageobjects.INVENTORY_StockReturnBranch_Obj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.INVENTORY_InventoryManagement_DataType;

public class INVENTORY_StockConfirm extends BaseClass{ 
	
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
	INVENTORY_InventoryManagement_DataType inventoryData = jsonConfig.getStockReturnBranchByName("Maker");
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String RefNo;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	
	

	//--------------@KUBS_INV_MGMT_UAT_004_StockConfirm--------------//

	@Given("^Launch the Azentio maker url$")
	public void launch_the_azentio_maker_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^Inventory Second direction icon$")
	public void inventory_second_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventoryTransfericon());
		stockConfirmationObj.inventoryTransfericon().click();
	}

	@And("^Inventory Management Module$")
	public void inventory_management_module() throws Throwable {

		// ---------TO VIEW THE Inventory Management----------//
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventoryManagement());
		stockConfirmationObj.inventoryManagement().click();
		javaScriptHelper.scrollIntoView(stockReturnBranchObj.inventoryStockReturnBranchEye());
	}
	
    @Then("^Click on Stock issue eye icon$")
    public void click_on_stock_issue_eye_icon() throws Throwable {
    	waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventory_StockissueEye());
    	stockConfirmationObj.inventory_StockissueEye().click();
 
    }

    @And("^Click on First record eye icon$")
    public void click_on_first_record_eye_icon() throws Throwable {
       	waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventory_StockissueGridEye());
    	stockConfirmationObj.inventory_StockissueGridEye().click();
    }
    
    @Then("^Get the New Request Referance No$")
    public void get_the_new_request_referance_no() throws Throwable {
         RefNo = stockConfirmationObj.inventory_StockissueRefNo().getText();
        System.out.println("Request Referance No =" +RefNo);
    }
    
	@Then("^Click on Inventory stock confirmation eye icon$")
	public void click_on_inventory_stock_confirmation_eye_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Eye icon----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventory_StockConfirmEye());
		stockConfirmationObj.inventory_StockConfirmEye().click();
	}

	@And("^Sub module Inventory stock confirmation click Add icon$")
	public void sub_module_inventory_stock_confirmation_click_add_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Add icon----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.inventoryStockConfirmAdd());
		stockConfirmationObj.inventoryStockConfirmAdd().click();
	}

	@Then("^Enter Request Referance Number$")
	public void enter_request_referance_number() throws Throwable {
		
		// -----------ENTER THE REQUEST REFERANCE NUMBER---------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_RequestReferanceNumber());
		stockConfirmationObj.StockConfirm_RequestReferanceNumber().click();
		stockConfirmationObj.StockConfirm_RequestReferanceNumber().sendKeys(RefNo);
		stockConfirmationObj.StockConfirm_RequestReferanceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Enter Item code Number$")
	public void enter_item_code_number() throws Throwable {
		
		// ---------ENTER THE ITEM CODE--------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_ItemCode());
		stockConfirmationObj.StockConfirm_ItemCode().click();
		stockConfirmationObj.StockConfirm_ItemCode().sendKeys(Keys.DOWN);
		stockConfirmationObj.StockConfirm_ItemCode().sendKeys(Keys.ENTER);
	
	}

	@Then("^Accept the status in checkbox$")
	public void accept_the_status_in_checkbox() throws Throwable {

		// ----------ACCEPT THE STATUS----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_AcceptCheckBox());
		stockConfirmationObj.StockConfirm_AcceptCheckBox().click();
	}

	@And("^click the save icon for StockConfirm$")
	public void click_the_save_icon_for_stockconfirm() throws Throwable {

		// ----------SAVE THE RECORD----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_Save());
		stockConfirmationObj.StockConfirm_Save().click();
		Thread.sleep(2000);
		stockConfirmationObj.StockConfirm_Notification_Close().click();
	}

	@And("^goto maker Notification icon$")
	public void goto_maker_notification_icon() throws Throwable {
		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_MakerNotification());
		stockConfirmationObj.StockConfirm_MakerNotification().click();
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_ReferanceId());
		String Referance_id = stockConfirmationObj.StockConfirm_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_ActionButton());
		stockConfirmationObj.StockConfirm_ActionButton().click();
	}

	@Then("^Click Submit button to Inventory Record$")
	public void click_submit_button_to_inventory_record() throws Throwable {
		// -----------Submit Icon Inventory-----------//
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_Submit());
		stockConfirmationObj.StockConfirm_Submit().click();
	}

	@And("^Give Remark and submit to reviewer$")
	public void give_remark_and_submit_to_reviewer() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		inventoryData = jsonConfig.getStockReturnBranchByName("Maker");
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_Remark());
		stockConfirmationObj.StockConfirm_Remark().click();
		waitHelper.waitForElement(driver, 5000, stockConfirmationObj.StockConfirm_Remark());
		stockConfirmationObj.StockConfirm_Remark().sendKeys(inventoryData.RemarkApprove);
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_RemarkSubmit());
		stockConfirmationObj.StockConfirm_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, stockConfirmationObj.StockConfirm_ReviewerId());
		reviwerId = stockConfirmationObj.StockConfirm_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// Reviewer
	@Given("^Login As Reviewer$")
	public void login_as_reviewer() throws Throwable {

		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@And("^Goto Reviewer Notification$")
	public void goto_reviewer_notification() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^open the submitted Record from maker$")
	public void open_the_submitted_record_from_maker() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		reviewerObj.reviewer_action_button1().click();
	}

	@And("^Approve the Record in Reviewer$")
	public void approve_the_record_in_reviewer() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter The Remark and submit in Reviewer$")
	public void enter_the_remark_and_submit_in_reviewer() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(inventoryData.RemarkApprove);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	//Checker
	@Given("^Login As Checker$")
	public void login_as_checker() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click Security management module$")
	public void click_security_management_module() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click Sub module open Pool Edit icon$")
	public void click_sub_module_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@And("^Claim the submitted Record$")
	public void claim_the_submitted_record() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@Then("^Goto Checker Notification$")
	public void goto_checker_notification() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@And("^Open the Record Approve from Reviewer$")
	public void open_the_record_approve_from_reviewer() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Approve the Record in Checker End$")
	public void approve_the_record_in_checker_end() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Enter the Remark and submit the record in checker$")
	public void enter_the_remark_and_submit_the_record_in_checker() throws Throwable {
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

	// ------------------KUBS_INV_MGMT_UAT_004 Gl-------------------//

	@Given("^Navigate kubs URL  login as maker$")
	public void navigate_kubs_url_login_as_maker() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^click on report button$")
	public void click_on_report_button() throws Throwable {
		//-----------CLICK ON REPORT ICON----------------//
		waitHelper.waitForElement(driver, 3000, stockConfirmGlObj.inventoryReportIcon());
		stockConfirmGlObj.inventoryReportIcon().click();
		waitHelper.waitForElement(driver, 3000, stockConfirmGlObj.inventoryEnquiryMenu());
		Assert.assertTrue(stockConfirmGlObj.inventoryEnquiryMenu().isDisplayed());

	}

	@And("^click Enquiry menu$")
	public void click_Enquiry_menu() throws Throwable {
		//------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElement(driver, 3000, stockConfirmGlObj.inventoryEnquiryMenu());
		stockConfirmGlObj.inventoryEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, stockConfirmGlObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(stockConfirmGlObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on Edit icon near by financial transaction$")
	public void click_on_edit_icon_near_by_financial_transaction() throws Throwable {
		//-----------CLICK ON FINANCIAL EDIT------------//
		stockConfirmGlObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^choose branch code Id$")
	public void choose_branch_code_id() throws Throwable {
		//-----------CLICK ON BRANCH CODE------------//
		stockConfirmGlObj.inventoryBranchCode().sendKeys(inventoryData.branchCode);
		stockConfirmGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^choose Gl code Id$")
	public void choose_gl_code_id() throws Throwable {
		//-----------CLICK ON GL CODE--------------//
		stockConfirmGlObj.inventoryGlCode().sendKeys(inventoryData.gLCode);
		stockConfirmGlObj.inventoryGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date in calender icon$")
	public void click_on_transaction_from_date_calender_in_calender_icon() throws Throwable {
		//-----------CLICK ON CALANDER--------------//
		stockConfirmGlObj.inventoryFromDate().click();
	}

	@Then("^choose from date in calender$")
	public void choose_from_date_in_calender() throws Throwable {
		//----------CLICK ON FROM DATE--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ inventoryData.GlMonth + " " + inventoryData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ inventoryData.GlMonth + " " + inventoryData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				stockConfirmGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + inventoryData.GlFullMonth + " "
				+ inventoryData.GlDay + ", " + inventoryData.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on the transaction to date in calender icon$")
	public void click_on_the_transaction_to_date_calender_in_calender_icon() throws Throwable {
		//----------CLICK ON TRANSACTION TO DATE--------//
		waitHelper.waitForElement(driver, 3000, stockConfirmGlObj.inventoryToDate());
		stockConfirmGlObj.inventoryToDate().click();

	}

	@Then("^choose the To date in calender$")
	public void choose_the_to_date_in_calender() throws Throwable {
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ inventoryData.GlToMonth + " " + inventoryData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ inventoryData.GlToMonth + " " + inventoryData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				stockConfirmGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + inventoryData.GlFullToMonth
				+ " " + inventoryData.GlToDate + ", " + inventoryData.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button to see the Record$")
	public void click_on_view_button_to_see_the_record() throws Throwable {
		//----------CLICK ON VIEW BUTTON----------//
		stockConfirmGlObj.inventoryViewButton().click();

	}


}
