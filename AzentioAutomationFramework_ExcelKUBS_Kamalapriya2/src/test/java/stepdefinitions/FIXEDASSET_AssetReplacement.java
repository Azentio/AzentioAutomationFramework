package stepdefinitions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
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
import pageobjects.FIXEDASSET_AssetReplacementObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

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
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig
			.getAssetCreationByName("Maker");
	Map<String, String> testData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetReplacement = new ExcelData(path, "FixedAsset_AssetReplacement", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");

	Map<String, String> assetReplacementTestData = new HashMap<>();

	// **********************@KUBS_FAT_UAT_008_001************************//

	@Given("^Launch The Azentio Url$")
	public void launch_the_azentio_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
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

	@And("^get the asset reference number for do asset replacement$")
	public void get_the_asset_reference_number_for_do_asset_replacement() throws Throwable {
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetApprovedReferenceNumber(), 3000, 300);
		testData.put("AssetReferemnceNumber", fixedAssetObj.fixedAssetApprovedReferenceNumber().getText());
		System.out.println("Asset reference number is :" + testData.get("AssetReferemnceNumber"));

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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.fixedAssetReplacementAdd(), 20, 1);
		for (int i = 0; i <= 200; i++) {
			try {
				assetReplacement.fixedAssetReplacementAdd().click();
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

//new Start
	@And("^get the test data from asset replacement excel database$")
	public void get_the_test_data_from_asset_replacement_excel_database() throws Throwable {
		assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D1");
	}
	 @Then("^Get the data set id for asset replacement from asset replacement excel data base$")
	    public void get_the_data_set_id_for_asset_replacement_from_asset_replacement_excel_data_base() throws Throwable {
			assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_006_AR_D10");
	    }

	@And("^get the test data from asset replacement excel database for asset return prerequsite$")
	public void get_the_test_data_from_asset_replacement_excel_database_for_asset_return_prerequsite()
			throws Throwable {
		assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D3");
	}

	@And("^get the test data from asset replacement excel database for asset impairment prerequsite$")
	public void get_the_test_data_from_asset_replacement_excel_database_for_asset_impairment_prerequsite()
			throws Throwable {
		assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D2");
	}

	@And("^get the test data from asset replacement excel database for prerequisite of asset revaluation$")
	public void get_the_test_data_from_asset_replacement_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D4");
	}

	@And("^enter the asset reference number in asset replacement$")
	public void enter_the_asset_reference_number_in_asset_replacement() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				assetReplacement.fixedAssetReplacementReferenceNumber(), 20, 1);
		assetReplacement.fixedAssetReplacementReferenceNumber().click();
		assetReplacement.fixedAssetReplacementReferenceNumber()
				.sendKeys(assetReplacementTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetReplacementTestData.get("AssetReferenceNumber")
				+ "']";
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the asset item number in asset replacement$")
	public void enter_the_asset_item_number_in_asset_replacement() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.fixedAssetReplacementItemNumber(), 20,
				1);
		assetReplacement.fixedAssetReplacementItemNumber().click();
		assetReplacement.fixedAssetReplacementItemNumber().sendKeys(assetReplacementTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetReplacementTestData.get("AssetItemNumber") + "']";
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the new asset item number in asset replacement$")
	public void enter_the_new_asset_item_number_in_asset_replacement() throws Throwable {
		Random random = new Random();
		int randomNumber1 = random.nextInt(100 - 1) + 100;
		int randomNumber2 = random.nextInt(200 - 100) + 200;
		String newItemNum = assetReplacementTestData.get("NewItemNumber") + randomNumber1 + randomNumber2;
		excelDataForAssetReplacement.updateTestData(assetReplacementTestData.get("DataSet ID"), "UpdatedNewItemNumber",
				newItemNum);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.fixedAssetReplacementNewItemNumber(),
				20, 1);
		assetReplacement.fixedAssetReplacementNewItemNumber().click();
		assetReplacement.fixedAssetReplacementNewItemNumber().sendKeys(newItemNum);
	}

	@And("^enter the new item description in asset replacement$")
	public void enter_the_new_item_description_in_asset_replacement() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.fixedAssetReplacementNewDescription(),
				20, 1);
		assetReplacement.fixedAssetReplacementNewDescription().click();
		assetReplacement.fixedAssetReplacementNewDescription()
				.sendKeys(assetReplacementTestData.get("NewItemDescription"));
	}

	@And("^save the asset replacement record$")
	public void save_the_asset_replacement_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSaveButton());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSaveButton());
	}

	@And("^search the asset replacement event code in notification$")
	public void search_the_asset_replacement_event_code_in_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetReplacementTestData.get("ModuleCode"));
	}

	@And("^store the replacement record reference number in replacement excel database$")
	public void store_the_replacement_record_reference_number_in_replacement_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.assetReplacementReferenceNumber(), 20,
				1);
		String referenceID = assetReplacement.assetReplacementReferenceNumber().getText();
		excelDataForAssetReplacement.updateTestData(assetReplacementTestData.get("DataSet ID"), "Reference ID",
				referenceID);
	}

	@And("^select the replcement record in notification$")
	public void select_the_replcement_record_in_notification() throws Throwable {
//		waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				assetReplacement.assetReplacementNotificationFirstRecord(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionHelper.moveToElement(assetReplacement.assetReplacementNotificationFirstRecord());
				clickAndActionHelper.clickOnElement(assetReplacement.assetReplacementNotificationFirstRecord());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^click on submit in asset replacement$")
	public void click_on_submit_in_asset_replacement() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@And("^enter the alert remark in asset replacement$")
	public void enter_the_alert_remark_in_asset_replacement() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetReplacementTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset replacement$")
	public void click_on_alert_submit_in_asset_replacement() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
	}

	@And("^validate the submission on replacement record and store the reviewer ID$")
	public void validate_the_submission_on_replacement_record_and_store_the_reviewer_id() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetReplacement.updateTestData(assetReplacementTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^store the asset reference number and item number of replaced asset in impairment excel database$")
	public void store_the_asset_reference_number_and_item_number_of_replaced_asset_in_impairment_excel_database()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_006_01_D1", "AssetReferenceNumber",
				assetReplacementTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_006_01_D1", "AssetItemNumber",
				assetReplacementTestData.get("AssetItemNumber"));
	}

	@And("^click on search button in replacement list view$")
	public void click_on_search_button_in_replacement_list_view() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 20, 1);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(kubsCommonObj.kubsListViewSearchButton());
				clickAndActionHelper.clickOnElement(kubsCommonObj.kubsListViewSearchButton());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the approved asset reference number of replacement asset$")
	public void search_the_approved_asset_reference_number_of_replacement_asset() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				assetReplacement.assetReplacementListViewSearchAssetReferenceNumber(), 20, 1);
		clickAndActionHelper.moveToElement(assetReplacement.assetReplacementListViewSearchAssetReferenceNumber());
		clickAndActionHelper.clickOnElement(assetReplacement.assetReplacementListViewSearchAssetReferenceNumber());
		assetReplacement.assetReplacementListViewSearchAssetReferenceNumber()
				.sendKeys(assetReplacementTestData.get("AssetReferenceNumber"));
	}

	@Then("^verify approved asset reference number should visible in asset replacement list view along with item number$")
	public void verify_approved_asset_reference_number_should_visible_in_asset_replacement_list_view_along_with_item_number()
			throws Throwable {
		String xpath = "//span[text()=' " + assetReplacementTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[1]//span[text()=' "
				+ assetReplacementTestData.get("UpdatedNewItemNumber") + " ']";

		for (int i = 0; i <= 100; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset reference and item number of replacement should store in asset return excel database$")
	public void store_the_asset_reference_and_item_number_of_replacement_should_store_in_asset_return_excel_database()
			throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_005_01_D1", "AssetReferenceNumber",
				assetReplacementTestData.get("AssetReferenceNumber"));
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_005_01_D1", "AssetItemNumber",
				assetReplacementTestData.get("UpdatedNewItemNumber"));
	}
	 @And("^store the asset reference and item number of replacement should store in asset allocation excel database$")
	    public void store_the_asset_reference_and_item_number_of_replacement_should_store_in_asset_allocation_excel_database() throws Throwable {
		 excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_011_AR_D14", "AssetReferenceNumber",
					assetReplacementTestData.get("AssetReferenceNumber"));
		 excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_011_AR_D14", "AssetItemNumber",
					assetReplacementTestData.get("UpdatedNewItemNumber"));	   
			}



	@And("^store the asset reference and item number of replacement should store in asset revaluation excel database$")
	public void store_the_asset_reference_and_item_number_of_replacement_should_store_in_asset_revaluation_excel_database()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_09_D1", "AssetReferenceNumber",
				assetReplacementTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_09_D1", "AssetItemNumber",
				assetReplacementTestData.get("UpdatedNewItemNumber"));
	}

	// New End
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

	@Then("^Enter the Asset Referance Number which we got from aset Creation module$")
	public void enter_the_asset_referance_number_which_we_got_from_aset_creation_module() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetReplacement.fixed_AssetReferenceNumber(), 20, 1);
		assetReplacement.fixed_AssetReferenceNumber().click();
		Thread.sleep(1000);
		assetReplacement.fixed_AssetReferenceNumber().sendKeys(testData.get("AssetReferemnceNumber"));
		// assetReplacement.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
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
		Thread.sleep(500);
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

	@Then("^save the Replacement recordss$")
	public void save_the_replacement_recordss() throws Throwable {

		// -----------------SAVE THE RECORD---------------//
		waitHelper.waitForElement(driver, 3000, assetReplacement.AssetReplace_Save());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(assetReplacement.AssetReplace_Save());

	}

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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				+ readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")),
				60, 5);
		for (int i = 0; i < 10; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
						.click();
				break;
			} catch (NoSuchElementException e) {

			}

		}

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
