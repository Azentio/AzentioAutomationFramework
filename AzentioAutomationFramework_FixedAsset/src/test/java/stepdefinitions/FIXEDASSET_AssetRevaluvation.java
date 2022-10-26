package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import pageobjects.FIXEDASSET_AssetRevaluvationObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSET_AssetRevaluvation extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	ClicksAndActionsHelper actionHelper = new ClicksAndActionsHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String AssetCreation;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetRevaluvationObj assetRevaluvationObj = new FIXEDASSET_AssetRevaluvationObj(driver);
	FIXEDASSET_AssetAmendmentData assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig.getAssetCreationByName("Maker");
	Map<String,String> revaluationTestData= new HashMap<>();

	// ************************@KUBS_FAT_UAT_012_001********************* //

	@Given("^Navigate the Maker Url$")
	public void navigate_the_maker_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Then("^Choose Second Segmant Icon$")
	public void choose_second_segmant_icon() throws Throwable {

		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixedTransfericon());
		assetRevaluvationObj.fixedTransfericon().click();

	}
	

	@And("^fixed Asset Module$")
	public void fixed_asset_module() throws Throwable {

		// ----------TO CLICK THE FIXED ASSET MODULE---------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_FixedAssets());
		assetRevaluvationObj.fixed_FixedAssets().click();
	}
	@And("^store the asset reference number to do the asset revaluation$")
    public void store_the_asset_reference_number_to_do_the_asset_revaluation() throws Throwable {
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetApprovedReferenceNumber(), 3000, 300);
		
		revaluationTestData.put("AssetReferenceNumber", fixedAssetObj.fixedAssetApprovedReferenceNumber().getText());
		System.out.println("Asset Reference number is : "+revaluationTestData.get("AssetReferenceNumber"));
    }
	@Then("^Asset Revaluvation submodule Eye Icon$")
	public void asset_revaluvation_submodule_eye_icon() throws Throwable {
		// -----------TO CLICK THE ASSET REPLACEMENT------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetRevalueEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetRevalueEye());
		assetRevaluvationObj.fixed_AssetRevalueEye().click();
	}

	@And("^Add Icon button$")
	public void add_icon_button() throws Throwable {

		// -----------CLICK ADD ICON---------------//
		//waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixedAssetRevalueAdd());
		assetRevaluvationObj.fixedAssetRevalueAdd().click();
		
	}

	@Then("^Give Asset Referance Number$")
	public void give_asset_referance_number() throws Throwable {

		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(revaluationTestData.get("AssetReferenceNumber"));
	//	assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.DOWN);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetGetReferenceNumber());
		AssetCreation = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
		System.out.println(AssetCreation);
	}

	@And("^Select Asset Item Number$")
	public void select_asset_item_number() throws Throwable {

		// --------------ASSET ITEM NUMBER---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetItemCode());
		assetRevaluvationObj.fixed_AssetItemCode().click();
		Thread.sleep(1000);
		assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
		assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	}

	@Then("^Alter TheBook Value$")
	public void alter_the_book_value() throws Throwable {

		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.BookValue);

	}

	@Then("^save the Revaluation record$")
	public void save_the_revaluation_record() throws Throwable {

		// -----------------SAVE THE RECORD---------------//
		//waitHelper.waitForElement(driver, 3000, assetRevaluvationObj.AssetRevaluvation_Save());
		for (int i = 0; i < 9; i++) {
			try {
				assetRevaluvationObj.AssetRevaluvation_Save().click();
				break;
			} catch (ElementClickInterceptedException e) {
				
			}
		}
		
	}

	@And("^Go to Maker Notification$")
	public void go_to_maker_notification() throws Throwable {

		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_MakerNotification());
		assetRevaluvationObj.fixed_MakerNotification().click();
	}

	@Then("^Select the first Action icon$")
	public void select_the_first_action_icon() throws Throwable {

		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_ReferanceId());
		String Referance_id = assetRevaluvationObj.fixed_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_ActionButton());
		assetRevaluvationObj.fixed_ActionButton().click();
	}

	@And("^Submit Record in maker$")
	public void submit_record_in_maker() throws Throwable {

		// ---------------SUBMIT RECORD--------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_Submit());
		assetRevaluvationObj.fixed_Submit().click();
		Thread.sleep(2000);
	}

	@Then("^Give Remark and Submit it$")
	public void give_remark_and_submit_it() throws Throwable {

		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_Remark());
		assetRevaluvationObj.fixed_Remark().click();
		waitHelper.waitForElement(driver, 5000, assetRevaluvationObj.fixed_Remark());
		assetRevaluvationObj.fixed_Remark().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_RemarkSubmit());
		assetRevaluvationObj.fixed_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_ReviewerId());
		reviwerId = assetRevaluvationObj.fixed_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER
	@Given("^Launch Azentio Reviewer Url$")
	public void launch_azentio_reviewer_url() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@And("^Reviewer Notification icon$")
	public void reviewer_notification_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^submitted record from maker$")
	public void submitted_record_from_maker() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		javaScriptHelper.JSEClick(reviewerObj.reviewer_action_button());
		//reviewerObj.reviewer_action_button().click();
	}

	@And("^Approve icon from Reviewer End$")
	public void approve_icon_from_reviewer_end() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter remark and submit Record$")
	public void enter_remark_and_submit_record() throws Throwable {
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
	@Given("^Launch Azentio Checker Url$")
	public void launch_azentio_checker_url() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click the Security management$")
	public void click_the_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click the open pool Note icon$")
	public void click_the_open_pool_Note_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@Then("^Claim the record from Checker$")
	public void claim_the_record_from_checker() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@And("^Checker Notification icon$")
	public void checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@Then("^Action Icon from claimed record$")
	public void action_icon_from_claimed_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Press Approve icon$")
	public void press_approve_icon() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Submit Record from Checker$")
	public void submit_record_from_checker() throws Throwable {
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

	@And("^Click search icon button$")
	public void click_search_icon_button() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetSearch());
		assetRevaluvationObj.fixed_AssetSearch().click();
	}

	@Then("^Give the Asset Referance Number$")
	public void give_the_asset_referance_number() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetSearchCode());
		assetRevaluvationObj.fixed_AssetSearchCode().click();
		assetRevaluvationObj.fixed_AssetSearchCode().sendKeys(AssetCreation);
	}

	@When("^capture Asset Grid view List$")
	public void capture_asset_grid_view_list() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr + AssetCreation + aftr)));
		driver.findElement(By.xpath(befr + AssetCreation + aftr)).click();
	}

	// **********************@KUBS_FAT_UAT_012_002**************************//

	@Then("^Asset deallocation submodule Eye Icon$")
	public void asset_deallocation_submodule_eye_icon() throws Throwable {

		// -------------DE-ALLOCATION EYE ICON--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetDeallocationEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetDeallocationEye());
		assetRevaluvationObj.fixed_AssetDeallocationEye().click();
	}

	@Then("^Alter the Deallocation Book Value$")
	public void alter_the_deallocation_book_value() throws Throwable {

		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Deallocation);
	}

	@And("^Click Table first Eye Icon$")
	public void click_table_first_eye_icon() throws Throwable {

		// -------------TABLE FIRST ICON--------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetTableEye());
		assetRevaluvationObj.fixed_AssetTableEye().click();
	}

	@Then("^Store the Referance No$")
	public void store_the_refferance_no() throws Throwable {

		// -------------GETTIN ASSET REFERANCE NO-----------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetGetReferenceNumber());
		//javaScriptHelper.JavaScriptHelper(driver);
		// AssetCreation = (String) javaScriptHelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		AssetCreation = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
		System.out.println(AssetCreation);
	}

	@Then("^Give Asset Deallocation Referance Number$")
	public void give_asset_deallocation_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		//assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.DeallocationRef);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	// ************************@KUBS_FAT_UAT_012_003**********************//

	// PREVIOUS STEP WRITE ABOVE

    @Then("^Give Asset Revalued Referance Number$")
    public void give_asset_revalued_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
	//	assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    
	@Then("^Alter the Revalue Book Value$")
	public void alter_the_revalue_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Revalue);
	}

	@And("^Click Table Row first Eye Icon$")
	public void click_table_row_first_eye_icon() throws Throwable {

		// -------------TABLE FIRST ICON--------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetTableEye());
		assetRevaluvationObj.fixed_AssetTableEye().click();
	}

	// ********************@KUBS_FAT_UAT_012_004*********************//

	// PREVIOUS STEP WRITE ABOVE
    @Then("^Give Asset Impaired Referance Number$")
    public void give_asset_impaired_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		//AssetCreation
	//	assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.ImpairedAssetRef);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    
	@Then("^Asset Impairment submodule Eye Icon$")
	public void asset_impairment_submodule_eye_icon() throws Throwable {

		// ---------------IMPAIRMENT EYE ICON------------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetImpairmentEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetImpairmentEye());
		assetRevaluvationObj.fixed_AssetImpairmentEye().click();
	}

	@Then("^Alter the Impaired Book Value$")
	public void alter_the_impaired_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Impaired);
	}

	// ******************@KUBS_FAT_UAT_012_005*********************//

	// PREVIOUS STEP WRITE ABOVE

    @Then("^Asset Amendment submodule Eye Icon$")
    public void asset_amendment_submodule_eye_icon() throws Throwable {

		// ---------------AMENDMENT EYE ICON------------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetAmendmentEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetAmendmentEye());
		assetRevaluvationObj.fixed_AssetAmendmentEye().click();
    }
    
    @Then("^Give Asset Amendment Referance Number$")
    public void give_asset_amendment_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		//assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.AmendmentAssetRef);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    
    @Then("^Alter the Amendment Book Value$")
    public void alter_the_amendment_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Amendment);
    }
    
    //******************@KUBS_FAT_UAT_012_006*********************//
    
    @Then("^Asset Undertaken submodule Eye Icon$")
    public void asset_undertaken_submodule_eye_icon() throws Throwable {
		// ---------------UNDERTAKEN EYE ICON------------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetUndertakenEye());
		assetRevaluvationObj.fixed_AssetUndertakenEye().click();
    }

    @Then("^Give Asset Undertaken Referance Number$")
    public void give_asset_undertaken_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }

    @Then("^Alter the Undertaken Book Value$")
    public void alter_the_undertaken_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Undertaking);
    }
    
    
  //******************@KUBS_FAT_UAT_012_007*********************//    
    

    @Then("^Asset Sale submodule Eye Icon$")
    public void asset_sale_submodule_eye_icon() throws Throwable {
		// ---------------UNDERTAKEN EYE ICON------------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetSaleEye());
		assetRevaluvationObj.fixed_AssetSaleEye().click();
    }

    @Then("^Give Asset Sale Referance Number$")
    public void give_asset_sale_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		//AssetCreation
	//	assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.SoldAssetRefNum);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }

    @Then("^Alter the Sale Book Value$")
    public void alter_the_sale_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Sold);
    }
    
    
  //******************@KUBS_FAT_UAT_012_008*********************//    

    @Then("^Asset Return submodule Eye Icon$")
    public void asset_return_submodule_eye_icon() throws Throwable {
		// ---------------UNDERTAKEN EYE ICON------------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetReturnEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReturnEye());
		assetRevaluvationObj.fixed_AssetReturnEye().click();
    }

    @Then("^Give Asset Return Referance Number$")
    public void give_asset_return_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.returnAssetNum);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }

    @Then("^Alter the Return Book Value$")
    public void alter_the_return_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Return);
    }    
    

    //******************@KUBS_FAT_UAT_012_009********************//

    @Then("^Asset Replacement submodule Eye Icon$")
    public void asset_replacement_submodule_eye_icon() throws Throwable {

		// ---------------IMPAIRMENT EYE ICON------------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetRevaluvationObj.fixed_AssetReplaceEye());
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReplaceEye());
		assetRevaluvationObj.fixed_AssetReplaceEye().click();
    }

    @Then("^Give Asset Replace Referance Number$")
    public void give_asset_replace_referance_number() throws Throwable {
		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
		//AssetCreation
	//	assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetAmendmentData.replacementAssetRefNum);
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		
		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }

    @Then("^Alter the Replace Book Value$")
    public void alter_the_replace_book_value() throws Throwable {
		// --------------ALTER THE BOOK VALUE---------------//
		waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
		assetRevaluvationObj.fixed_AssetBookValue().clear();
		assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetAmendmentData.Replace);
    }























}
