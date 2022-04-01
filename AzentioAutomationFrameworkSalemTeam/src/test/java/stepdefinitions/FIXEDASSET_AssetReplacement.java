package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import pageobjects.FIXEDASSET_AssetReplacementObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;

public class FIXEDASSET_AssetReplacement extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String AssetCreation;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetReplacementObj assetReplacement = new FIXEDASSET_AssetReplacementObj(driver);
	FIXEDASSET_AssetAmendmentData assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
	FIXEDASSET_AssetReplacementObj assetReplacementObj = new FIXEDASSET_AssetReplacementObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	FIXEDASSET_AssetImpairementTestDataType fixedAssetImairementTestData = jsonConfig
			.getFixedAssetTestDataByName("Maker");

	// **********************@KUBS_FAT_UAT_008_001************************//

	@Given("^Launch The Azentio Url$")
	public void launch_the_azentio_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^Click Second Segman button$")
	public void click_second_segman_button() throws Throwable {

		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixedTransfericon());
		assetReplacement.fixedTransfericon().click();
	}

	@And("^Click fixed Asset Module$")
	public void click_fixed_asset_module() throws Throwable {

		// ----------TO CLICK THE FIXED ASSET MODULE---------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_FixedAssets());
		assetReplacement.fixed_FixedAssets().click();
	}

	@Then("^Click on Asset Replacement submodule Eye Icon$")
	public void click_on_asset_replacement_submodule_eye_icon() throws Throwable {

		// -----------TO CLICK THE ASSET REPLACEMENT------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetReplacement.fixed_AssetReplacementEye());
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetReplacementEye());
		assetReplacement.fixed_AssetReplacementEye().click();
	}

	@And("^Click Add Icon button$")
	public void click_add_icon_button() throws Throwable {

		// -----------CLICK ADD ICON---------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixedAssetReplacementAdd());
		assetReplacement.fixedAssetReplacementAdd().click();
	}

	@Then("^Enter the Asset Referance Number$")
	public void enter_the_asset_referance_number() throws Throwable {

		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetReferenceNumber());
		assetReplacement.fixed_AssetReferenceNumber().sendKeys(Keys.DOWN);
		assetReplacement.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetGetReferenceNumber());
		AssetCreation = assetReplacement.fixed_AssetGetReferenceNumber().getText();
		System.out.println(AssetCreation);
	}

	@And("^Enter the Asset Item Number$")
	public void enter_the_asset_item_number() throws Throwable {

		// --------------ASSET ITEM NUMBER---------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetItemNO());
		assetReplacement.fixed_AssetItemNO().click();
		assetReplacement.fixed_AssetItemNO().sendKeys(Keys.DOWN);
		assetReplacement.fixed_AssetItemNO().sendKeys(Keys.ENTER);

	}

	@Then("^Enter the New Item Number$")
	public void enter_the_new_item_number() throws Throwable {

		// --------------ENTER NEW ITEM NUMBER-------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetNewItemNO());
		assetReplacement.fixed_AssetNewItemNO().sendKeys(assetAmendmentData.itemNumber);
	}

	@And("^Enter the New Description$")
	public void enter_the_new_description() throws Throwable {

		// -------------ENTER NEW DESCRIPTION------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetNewDesc());
		assetReplacement.fixed_AssetNewDesc().sendKeys(assetAmendmentData.itemDesc);
	}

//	@Then("^save the Replacement record$")
//	public void save_the_replacement_record() throws Throwable {
//
//		// -----------------SAVE THE RECORD---------------//
//		waitHelper.waitForElement(driver, 3000, assetReplacement.AssetReplace_Save());
//		javaScriptHelper.JavaScriptHelper(driver);
//		javaScriptHelper.JSEClick(assetReplacement.AssetReplace_Save());
//
//	}

	@And("^Went to Maker Notification$")
	public void went_to_maker_notification() throws Throwable {

		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_MakerNotification());
		assetReplacement.fixed_MakerNotification().click();
	}

	@Then("^Click the first Action icon$")
	public void click_the_first_action_icon() throws Throwable {

		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_ReferanceId());
		String Referance_id = assetReplacement.fixed_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_ActionButton());
		assetReplacement.fixed_ActionButton().click();

	}

	@And("^Submit the Record in maker$")
	public void submit_the_record_in_maker() throws Throwable {

		// ---------------SUBMIT RECORD--------------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_Submit());
		assetReplacement.fixed_Submit().click();
		Thread.sleep(2000);
	}

	@Then("^Enter Remark and Submit it$")
	public void enter_remark_and_submit_it() throws Throwable {

		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_Remark());
		assetReplacement.fixed_Remark().click();
		waitHelper.waitForElement(driver, 5000, assetReplacement.fixed_Remark());
		assetReplacement.fixed_Remark().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_RemarkSubmit());
		assetReplacement.fixed_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_ReviewerId());
		reviwerId = assetReplacement.fixed_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER

	@Given("^Launch the Azentio Reviewer$")
	public void launch_the_azentio_reviewer() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@And("^Click Reviewer Notification icon$")
	public void click_reviewer_notification_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^Click submitted record from maker$")
	public void click_submitted_record_from_maker() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		javaScriptHelper.JSEClick(reviewerObj.reviewer_action_button());
		// reviewerObj.reviewer_action_button().click();
	}

	@And("^Click Approve icon from Reviewer End$")
	public void click_approve_icon_from_reviewer_end() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter remark and submit the Record$")
	public void enter_remark_and_submit_the_record() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER
	@Given("^Launch the Azentio Checker$")
	public void launch_the_azentio_checker() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click Security management$")
	public void click_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click open pool Edit icon$")
	public void click_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@Then("^Claim record Approved from Reviewer$")
	public void claim_record_approved_from_reviewer() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@And("^Click Checker Notification icon$")
	public void click_checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@Then("^Click Action Icon from claimed record$")
	public void click_action_icon_from_claimed_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Click Approve icon$")
	public void click_approve_icon() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Submit Record from Checker End$")
	public void submit_record_from_checker_end() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	@And("^Click on the search icon$")
	public void click_on_the_search_icon() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetSearch());
		assetReplacement.fixed_AssetSearch().click();
	}

	@Then("^Enter Asset Referance No$")
	public void enter_asset_referance_no() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElement(driver, 2000, assetReplacement.fixed_AssetSearchCode());
		assetReplacement.fixed_AssetSearchCode().click();
		assetReplacement.fixed_AssetSearchCode().sendKeys(AssetCreation);
	}

	@When("^capture Asset Grid view$")
	public void capture_asset_grid_view() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr + AssetCreation + aftr)));
		driver.findElement(By.xpath(befr + AssetCreation + aftr)).click();
	}

	/***** Validation and get reference number ****/

	@And("^click on view button in asset replacement module$")
	public void click_on_view_button_in_seet_replacement_module() throws Throwable {
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(assetReplacementObj.fixedAssetAAssetReplacementViewButton());
		// waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetAAssetReplacementViewButton(),
		// 2000, 100);
		assetReplacementObj.fixedAssetAAssetReplacementViewButton().click();
	}

	@And("^fill the required details$")
	public void fill_the_required_details() throws Throwable {

		waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetReplacementReferenceNumber(), 2000, 100);
		assetReplacementObj.fixedAssetReplacementReferenceNumber().click();
		assetReplacementObj.fixedAssetReplacementReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffReplacementAssetReferenceNumber);
		assetReplacementObj.fixedAssetReplacementReferenceNumber().sendKeys(Keys.ENTER);
		assetReplacementObj.fixedAssetReplacementItemNumber().click();
		assetReplacementObj.fixedAssetReplacementItemNumber().sendKeys(Keys.ENTER);
		assetReplacementObj.fixedAssetReplacementNewItemNumber().click();
		assetReplacementObj.fixedAssetReplacementNewItemNumber()
				.sendKeys(fixedAssetImairementTestData.WriteOffNewAssetItemNumber);
		assetReplacementObj.fixedAssetReplacementNewDescription().click();
		assetReplacementObj.fixedAssetReplacementNewDescription()
				.sendKeys(fixedAssetImairementTestData.WriteOffNewAssetDescription);

	}

    @And("^save the replacement record$")
    public void save_the_replacement_record() throws Throwable {
    	waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetReplacementSaveButton(), 2000, 100);
    	assetReplacementObj.fixedAssetReplacementSaveButton().click();
    }
}
