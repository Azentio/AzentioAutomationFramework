package stepdefinitions;

import java.io.IOException;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.FIXEDASSET_AssetAmmendentObj;
import pageobjects.FIXEDASSET_AssetReturnObj;
import pageobjects.FIXEDASSET_AssetRevalueationObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FIXED_ASSET_AssetDeAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;

public class FIXEDASSET_AssetReturn extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	VerificationHelper verificationHelper = new VerificationHelper();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetReturnObj assetReturnObj = new FIXEDASSET_AssetReturnObj(driver);
	String RefNo;
	String referance_id;
	String reviwerId;
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> assetReferenceNo = new HashMap<String, String>();
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	FIXEDASSET_AssetRevalueationObj assetRevaluvationObj = new FIXEDASSET_AssetRevalueationObj(driver);
	FIXEDASSET_AssetAmmendentObj assetAmmendmentObj = new FIXEDASSET_AssetAmmendentObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	FIXED_ASSET_AssetDeAllocationObj fixedAsset_AssetDeallocationObj = new FIXED_ASSET_AssetDeAllocationObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetImpairementExecution = new ExcelData(path, "AssetImpairement_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataForAssetRevaluationExecution = new ExcelData(path, "AssetRevaluation_ExecutionTrack",
			"TestCaseID");
	Map<String, String> assetReturnTestdata = new HashMap<>();
	Map<String, String> assetReturnReportTestdata = new HashMap<>();
	Map<String, String> dataSetID = new HashMap<>();
	BrowserHelper browserHelper = new BrowserHelper(driver);

	@Given("^Navigate the Azentio url$")
	public void navigate_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
	}

	@And("^click on view button in asset return$")
	public void click_on_view_button_in_asset_return() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAssetAssetReturnViewButton());
		javascriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnViewButton());
		clicksAndActionHelper.moveToElement(assetReturnObj.fixedAssetAssetReturnViewButton());
		clicksAndActionHelper.clickOnElement(assetReturnObj.fixedAssetAssetReturnViewButton());
	}

	@And("^click on add button to add new record$")
	public void click_on_add_button_to_add_new_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAssetReturnAdd());
		clicksAndActionHelper.moveToElement(assetReturnObj.fixedAssetReturnAdd());
		clicksAndActionHelper.clickOnElement(assetReturnObj.fixedAssetReturnAdd());
	}

	@And("^get the test data for asset return from excel database$")
	public void get_the_test_data_for_asset_return_from_excel_database() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_001_01_D1");
	}

	@And("^get the test data for asset return from excel database for asset impairment prerequsite$")
	public void get_the_test_data_for_asset_return_from_excel_database_for_asset_impairment_prerequsite()
			throws Throwable {
		dataSetID = excelDataForAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_007_001_01_Impairment");
		assetReturnTestdata = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));

	}

	@And("^get the test data for asset return which is done asset ammendment$")
	public void get_the_test_data_for_asset_return_which_is_done_asset_ammendment() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_003_01_D1");
	}

	@And("^get the test data for assset return which is already revalued$")
	public void get_the_test_data_for_assset_return_which_is_already_revalued() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_002_01_D1");
	}

	@And("^get the test data for assset return which is already undertaken$")
	public void get_the_test_data_for_assset_return_which_is_already_undertaken() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_007_01_D1");
	}

	@And("^get the test data for assset return which is already impaired$")
	public void get_the_test_data_for_assset_return_which_is_already_impaired() throws Throwable {
		// KUBS_FAT_UAT_007_004_01_D1
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_004_01_D1");
	}

	@And("^get the test data for assset return which is already replacement$")
	public void get_the_test_data_for_assset_return_which_is_already_replacement() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_005_01_D1");
	}

	@And("^get the test data for assset return which is already deallocated$")
	public void get_the_test_data_for_assset_return_which_is_already_deallocated() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_006_01_D1");
	}

	@And("^get the test data for assset return for prerequisite of asset revaluation$")
	public void get_the_test_data_for_assset_return_for_prerequisite_of_asset_revaluation() throws Throwable {
		dataSetID=excelDataForAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_007_006_01_revaluation");
		assetReturnTestdata = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^enter the asset reference number in asset return$")
	public void enter_the_asset_reference_number_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetReferenceNumber());
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestdata.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetReturnTestdata.get("AssetReferenceNumber") + "']";

		for (int i = 0; i <= 50; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the item number in asset return$")
	public void enter_the_item_number_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetItemNo());
		assetReturnObj.assetReturnAssetItemNo().click();
		assetReturnObj.assetReturnAssetItemNo().sendKeys(assetReturnTestdata.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetReturnTestdata.get("AssetItemNumber") + "']";

		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on save button in asset return$")
	public void click_on_save_button_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixetReturnSaveButton());
		assetReturnObj.fixetReturnSaveButton().click();
	}

	@And("^search the asset return event code in notification section$")
	public void search_the_asset_return_event_code_in_notification_section() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSearchEventCode());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetReturnTestdata.get("ModuleCode"));

	}

	@And("^strore the reference number on asset retrurn record in excel database$")
	public void strore_the_reference_number_on_asset_retrurn_record_in_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnReferenceNumber());
		String referenceNumber = assetReturnObj.assetReturnReferenceNumber().getText();
		excelDataForAssetReturn.updateTestData(assetReturnTestdata.get("DataSet ID"), "Reference ID", referenceNumber);
	}

	@And("^select the asset return record in notification$")
	public void select_the_asset_return_record_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnNotificationFirstRecord());
		assetReturnObj.assetReturnNotificationFirstRecord().click();
	}

	@And("^click on submit in asset return$")
	public void click_on_submit_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSubmitButton());

		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@Then("^verify asset reference number and item number of impaired asset should not reflect in asset return screen$")
	public void verify_asset_reference_number_and_item_number_of_impaired_asset_should_not_reflect_in_asset_return_screen()
			throws Throwable {
		boolean referenceNumberStatus = false, itemNumberStatus = false;

		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetReferenceNumber());
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestdata.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetReturnTestdata.get("AssetReferenceNumber") + "']";

		for (int i = 0; i <= 100; i++) {
			try {

				referenceNumberStatus = driver.findElement(By.xpath(xpath)).isDisplayed();
				break;
			} catch (Exception e) {

			}
		}
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetItemNo());
		assetReturnObj.assetReturnAssetItemNo().click();
		assetReturnObj.assetReturnAssetItemNo().sendKeys(assetReturnTestdata.get("AssetItemNumber"));
		String xpath2 = "//ng-dropdown-panel//div[text()='" + assetReturnTestdata.get("AssetItemNumber") + "']";

		for (int i = 0; i <= 100; i++) {
			try {
				itemNumberStatus = driver.findElement(By.xpath(xpath2)).isDisplayed();

			} catch (Exception e) {

			}
		}
		if (referenceNumberStatus == false || itemNumberStatus == false) {
			System.out.println("Condition Statisfied");
		} else {
			Assert.fail("Condition not satisfied reference Number " + assetReturnTestdata.get("AssetReferenceNumber")
					+ " Item Number " + assetReturnTestdata.get("AssetItemNumber") + " Is visible");
		}
	}

	@And("^enter the alert remark in asset return$")
	public void enter_the_alert_remark_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertRemark());

		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetReturnTestdata.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset return$")
	public void click_on_alert_submit_in_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertSubmit());
		kubsCommonObj.kubsAlertSubmit().click();
	}

	@And("^store the reviewer id in asset return excel data base$")
	public void store_the_reviewer_id_in_asset_return_excel_data_base() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetReturn.updateTestData(assetReturnTestdata.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^store the asset reference number and item number in asset revaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_in_asset_revaluation_excel_database()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_08_D1", "AssetReferenceNumber",
				assetReturnTestdata.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_08_D1", "AssetItemNumber",
				assetReturnTestdata.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of return asset in impairment excel database$")
	public void store_the_asset_reference_number_and_item_number_of_return_asset_in_impairment_excel_database()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_007_01_D1", "AssetReferenceNumber",
				assetReturnTestdata.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_007_01_D1", "AssetItemNumber",
				assetReturnTestdata.get("AssetItemNumber"));
	}

	@And("^click on search button in list view of asset return module$")
	public void click_on_search_button_in_list_view_of_asset_return_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsListViewSearchIcon());
		kubsCommonObj.kubsListViewSearchIcon().click();
	}

	@And("^search the asset reference number in asset return module$")
	public void search_the_asset_reference_number_in_asset_return_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnListViewSearchAssetReferenceNumber());
		clicksAndActionHelper.moveToElement(assetReturnObj.assetReturnListViewSearchAssetReferenceNumber());
		clicksAndActionHelper.clickOnElement(assetReturnObj.assetReturnListViewSearchAssetReferenceNumber());
		assetReturnObj.assetReturnListViewSearchAssetReferenceNumber()
				.sendKeys(assetReturnTestdata.get("AssetReferenceNumber"));
	}

	@And("^verify approved asset reference shoudl be available in asset return approved list view$")
	public void verify_approved_asset_reference_shoudl_be_available_in_asset_return_approved_list_view()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//datatable-body-cell[4]//span[text()=' "
				+ assetReturnTestdata.get("AssetReferenceNumber") + " ']";
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

	@And("^select the asset return list view record$")
	public void select_the_asset_return_list_view_record() throws Throwable {
		String xpath = "//span[text()=' " + assetReturnTestdata.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[3]//ion-button[1]";
		for (int i = 0; i <= 100; i++) {
			try {
				driver.findElement(By.xpath(xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@Then("^verify approved asset item number of asset return record should be available$")
	public void verify_approved_asset_item_number_of_asset_return_record_should_be_available() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedItemNumber());
		Assert.assertEquals(assetReturnObj.assetReturnApprovedItemNumber().getText(),
				assetReturnTestdata.get("AssetItemNumber"));
	}

	// New End
	@Then("^Click Second Segmant Icon$")
	public void click_second_segmant_icon() throws Throwable {
		// -----------CLICK ON SEGMANT ICON------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedTransfericon());
		assetReturnObj.fixedTransfericon().click();
	}

	@And("^Click main module fixed Asset Module$")
	public void click_main_module_fixed_asset_module() throws Throwable {
		// -----------CLICK ON FIXED ASSET MODULE---------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_FixedAssets());
		assetReturnObj.fixed_FixedAssets().click();
	}

	@Then("^Asset Replacement Store the Referance No$")
	public void asset_replacement_store_the_referance_no() throws Throwable {
		// ----------ASSET REPLACEMENT REF NO------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetReturnObj.fixed_AssetReplacementEye());
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetReplacementEye());
		assetReturnObj.fixed_AssetReplacementEye().click();
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetTableRef());
		RefNo = assetReturnObj.fixed_AssetTableRef().getText();
		System.out.println(RefNo);
	}

	@Then("^Asset Return Click on Eye Icon$")
	public void asset_return_click_on_eye_icon() throws Throwable {
		// -----------CLICK ON EYE ICON---------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnEyeButton());
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAssetAssetReturnEyeButton());
		assetReturnObj.fixedAssetAssetReturnEyeButton().click();
	}

	@And("^Asset Return Add Icon button$")
	public void asset_return_add_icon_button() throws Throwable {
		// ------------CLICK ON ADD ICON-------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAssetReturnAdd());
		assetReturnObj.fixedAssetReturnAdd().click();
	}

	@Then("^Give Asset Replacement Referance Number$")
	public void give_asset_replacement_referance_number() throws Throwable {
		// -----------GIVE ASSET REF NO----------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetReferenceNumber());
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		// RefNo
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys("01-001-woodply28738");
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Select Asset Return Item Number$")
	public void select_asset_return_item_number() throws Throwable {
		// -----------ASSET ITEM NUMBER----------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetItemNo());
		assetReturnObj.assetReturnAssetItemNo().click();

		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.ENTER);
	}

	@And("^Click on Maker Notification icon button$")
	public void click_on_maker_notification_icon_button() throws Throwable {
		// ------------Maker Notification icon---------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_MakerNotification());
		assetReturnObj.fixed_MakerNotification().click();
	}

	@And("^Approve the Asset Return Record$")
	public void approve_the_asset_return_record() throws Throwable {
		// ---------------SUBMIT RECORD--------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_Submit());
		assetReturnObj.fixed_Submit().click();

	}

	@And("^Reviewer Notification icon button$")
	public void reviewer_notification_icon_button() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElementwithFluentwait(driver, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElementwithFluentwait(driver, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Given("^Launch the Azentio Checker URL$")
	public void launch_the_azentio_checker_url() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Main module Security management$")
	public void main_module_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Sub module open pool Edit icon$")
	public void sub_module_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@And("^Click Checker Notification icon button$")
	public void click_checker_notification_icon_button() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@And("^Click Approve icon button$")
	public void click_approve_icon_button() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@And("^Mouse click on search icon$")
	public void mouse_click_on_search_icon() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetSearch());
		assetReturnObj.fixed_AssetSearch().click();
	}

	@Then("^Enter Asset Referance No in that field$")
	public void enter_asset_referance_no_in_that_field() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetSearchCode());
		assetReturnObj.fixed_AssetSearchCode().click();
		assetReturnObj.fixed_AssetSearchCode().sendKeys(RefNo);
	}

	@When("^capture the Asset Grid view list$")
	public void capture_the_asset_grid_view_list() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(befr + RefNo + aftr)));
		driver.findElement(By.xpath(befr + RefNo + aftr)).click();
	}

	// ***************@KUBS_FAT_UAT_007_007****************//

	@Then("^Asset Undertaken Store the Referance No$")
	public void asset_undertaken_store_the_referance_no() throws Throwable {
		// ----------ASSET REPLACEMENT REF NO------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetUndertakenEye());
		assetReturnObj.fixed_AssetUndertakenEye().click();
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixed_AssetTableRef());
		RefNo = assetReturnObj.fixed_AssetTableRef().getText();
		System.out.println(RefNo);
	}

	// *********************@KUBS_FAT_UAT_007_008*********************//

	@Then("^click Third Segment button$")
	public void click_third_segment_button() throws Throwable {
		// -----------CLICK ON REPORT ICON----------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixesAsset_ReportIcon());
		assetReturnObj.fixesAsset_ReportIcon().click();
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixesAsset_ReportIcon());
		Assert.assertTrue(assetReturnObj.fixesAsset_ReportIcon().isDisplayed());
	}

	@And("^Click on Enquiry main module$")
	public void click_on_enquiry_main_module() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixesAsset_EnquiryMenu());
		assetReturnObj.fixesAsset_EnquiryMenu().click();
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixesAsset_EnquiryMenu());
		Assert.assertTrue(assetReturnObj.fixesAsset_EnquiryMenu().isDisplayed());
	}

	@Then("^Click on Financial sub module Edit icon$")
	public void click_on_financial_sub_module_edit_icon() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		assetReturnObj.fixesAsset_FinancialTransactionIcon().click();
	}

	@And("^Click on View and See the record$")
	public void click_on_view_and_see_the_record() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		assetReturnObj.fixedAsset_ViewButton().click();
	}

	// ******************@KUBS_FAT_UAT_007_009*********************//

	@And("^get the asset reference number for asset return$")
	public void get_the_asset_reference_number_for_asset_return() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAssetNewAssetReferenceNumber());
		assetReferenceNo.put("AssetReferenceNumberCreated",
				assetReturnObj.fixedAssetNewAssetReferenceNumber().getText());

	}

	public String revaluedAssetReferenceNo;

	@And("^click on view button nearby asset return module$")
	public void click_on_view_button_nearby_asset_return_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);

		javascriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnViewButton());
		assetReturnObj.fixedAssetAssetReturnViewButton().click();
	}

	@Then("^goto ammendent asset module$")
	public void goto_ammendent_asset_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);

		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetAmmendent());
		fixedAssetObj.fixedAssetAssetAmmendent().click();

	}

	@And("^choose asset reference number$")
	public void choose_asset_reference_number() throws Throwable {
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReferenceNo.get("AssetReferenceNumberCreated"));
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
		String assetReferenceNumber = assetReturnObj.fixedAssetGetReferenceNo().getText();
		assetReferenceNo.put("AssetReferenceNumber", assetReferenceNumber);
	}

	@Then("^Select Asset Reference Number for asset return$")
	public void select_asset_reference_number_for_asset_return() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixedAsset_AssetReference());
		String AssetReferenceNumber = assetReturnObj.fixedAsset_AssetReference().getText();
		assetReferenceNo.put("AssetReferenceNumberCreated", AssetReferenceNumber);

	}

	@Then("^Give AssetReferance Number$")
	public void give_asset_Referance_Number() throws Throwable {

		// -----------ENTER ASSET REF NO---------------//
		waitHelper.waitForElementwithFluentwait(driver, assetRevaluvationObj.fixed_AssetReferenceNumber());

		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetReferenceNo.get("AssetReferenceNumberCreated"));

		assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
		waitHelper.waitForElementwithFluentwait(driver, assetRevaluvationObj.fixed_AssetGetReferenceNumber());
		revaluedAssetReferenceNo = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
		System.out.println(revaluedAssetReferenceNo);
		assetReferenceNo.put("AssetReferenceNumber", revaluedAssetReferenceNo);
	}

	@And("^choose item number for the asset$")
	public void choose_item_number_for_the_asset() throws Throwable {
		assetReturnObj.assetReturnAssetItemNo().click();

		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.ENTER);
	}

	@Then("^Click on fixed asset deallocaion  Direction icon$")
	public void click_on_fixed_asset_deallocaion_direction_icon_AssetReturn() throws InterruptedException, IOException {

		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon().click();

	}

	@Then("^Click on Fixed assets field$")
	public void click_on_fixed_assets_field() throws IOException {
		// Fixed Assets
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField().click();

	}

	@Then("^Click on Fixed Asset Save button for de allocation$")
	public void click_on_fixed_asset_save_button_Deallocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton());
		fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton().click();
	}

	@Then("^click on Save after fill all the asset$")
	public void click_on_save_after_fill_all_the_asset() throws Throwable {

		System.out.println("The asset reference number is" + assetReferenceNo.get("AssetReferenceNumber"));
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.fixetReturnSaveButton());
		assetReturnObj.fixetReturnSaveButton().click();

		for (int i = 0; i < 90; i++) {
			try {
				clicksAndActionHelper.moveToElement(assetReturnObj.fixedAsset_AssetReturn_WorkflowInitiated());
				assetReturnObj.fixedAsset_AssetReturn_WorkflowInitiated().click();
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 0; i < 90; i++) {
			try {
				assetReturnObj.fixedAsset_AssetReturn_AlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
				}
			}
		}

	}

	@Then("^check the approved record is displayed in de allocation list view$")
	public void check_the_approved_record_is_displayed_in_de_allocation_list_view() throws Throwable {
		System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetReturnObj.fixedAssetNextButton().click();
			}
		}
	}

	@Then("^check the approved record is displayed in list view of returned asset$")
	public void check_the_approved_record_is_displayed_in_list_view_od_returned_asset() throws Throwable {
		System.out.println(assetReferenceNo.get("AssetReferenceNumberCreated"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(
						By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumberCreated") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetReturnObj.fixedAssetNextButton().click();
			}
		}

	}

	@Then("^check the approved record is displayed in revalued asset$")
	public void check_the_approved_record_is_displayed_in_revalued_asset() throws Throwable {
		System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetReturnObj.fixedAssetNextButton().click();
			}
		}
	}

	@Then("^check the approved record is displayed in ammendent asset$")
	public void check_the_approved_record_is_displayed_in_ammendent_asset() throws Throwable {
		System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetReturnObj.fixedAssetNextButton().click();
			}
		}
	}

//return report
	@And("^store the returned asset reference number$")
	public void store_the_returned_asset_reference_number() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedAssetReferenceNumber());
		String approvedAssetReferenceNumber = assetReturnObj.assetReturnApprovedAssetReferenceNumber().getText();

		assetReturnReportTestdata.put("approvedAssetReferenceNumber", approvedAssetReferenceNumber);
		System.out.println(
				"Approved Asset Reference number " + assetReturnReportTestdata.get("approvedAssetReferenceNumber"));
	}

	@And("^store the returned asset code$")
	public void store_the_returned_asset_code() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedAssetReferenceCode());
		String approvedAssetCode = assetReturnObj.assetReturnApprovedAssetReferenceCode().getText();

		assetReturnReportTestdata.put("approvedAssetCode", approvedAssetCode);
		System.out.println("Approved Asset Code " + assetReturnReportTestdata.get("approvedAssetCode"));
	}

	@And("^store the asset returned date$")
	public void store_the_asset_returned_date() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedAssetCreatedDate());
		String returnDate = assetReturnObj.assetReturnApprovedAssetCreatedDate().getText();
		assetReturnReportTestdata.put("returnDate", returnDate);
		System.out.println("Approved Asset date " + assetReturnReportTestdata.get("returnDate"));
	}

	@And("^select the approved record in return list view$")
	public void select_the_approved_record_in_return_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedReturnRecord());
		assetReturnObj.assetReturnApprovedReturnRecord().click();
	}

	@And("^store the return asset item number$")
	public void store_the_return_asset_item_number() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnApprovedItemNumber());
		String approvedItemNumber = assetReturnObj.assetReturnApprovedItemNumber().getText();
		assetReturnReportTestdata.put("approvedItemNumber", approvedItemNumber);
		System.out.println("Approved Asset Item Number " + assetReturnReportTestdata.get("approvedItemNumber"));
	}

	@And("^click on asset return report temp view$")
	public void click_on_asset_return_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturn_AssetReturnTempView());
		assetReturnObj.assetReturn_AssetReturnTempView().click();
	}

	@And("^enter the asset code in asset return report$")
	public void enter_the_asset_code_in_asset_return_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnAssetCode());
		assetReturnObj.assetReturnAssetCode().click();
		assetReturnObj.assetReturnAssetCode().sendKeys(assetReturnReportTestdata.get("approvedAssetCode"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetReturnReportTestdata.get("approvedAssetCode") + "']";

		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the asset item number in asset return report$")
	public void enter_the_asset_item_number_in_asset_return_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnReportItemNumber());
		assetReturnObj.assetReturnReportItemNumber().click();
		assetReturnObj.assetReturnReportItemNumber().sendKeys(assetReturnReportTestdata.get("approvedItemNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetReturnReportTestdata.get("approvedItemNumber") + "']";

		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	@And("^give the asset return date in report$")
	public void give_the_asset_return_date_in_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetReturnObj.assetReturnReportReturnDate());
		assetReturnObj.assetReturnReportReturnDate().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetReturnReportTestdata.get("returnDate"));
		String[] splitDate = assetReturnReportTestdata.get("returnDate").split("-");
		String date = "";
		if (splitDate[0].charAt(0) == '0') {
			date = splitDate[0].substring(1);
		} else {
			date = splitDate[0];
		}
		Month months = null;
		String month = splitDate[1];
		switch (month) {
		case "Jan":
			months = months.JANUARY;
			break;
		case "Feb":
			months = months.FEBRUARY;
			break;
		case "Mar":
			months = months.MARCH;
			break;
		case "Apr":
			months = months.APRIL;
			break;
		case "May":
			months = months.MAY;
			break;
		case "Jun":
			months = months.JUNE;
			break;
		case "Jul":
			months = months.JULY;
			break;
		case "Aug":
			months = months.AUGUST;
			break;
		case "Sep":
			months = months.SEPTEMBER;
			break;
		case "Oct":
			months = months.OCTOBER;
			break;
		case "Nov":
			months = months.NOVEMBER;
			break;
		case "Dec":
			months = months.DECEMBER;
			break;

		}
		String stringMonth = months.toString();
		String finalMonth = stringMonth.substring(1).toLowerCase();
		System.out.println("Final Month is : " + finalMonth);
		stringMonth.substring(0, 1);
		System.out.println("Final Full month:" + stringMonth.substring(0, 1) + finalMonth);
		String yearXpath = "//span[contains(text(),'" + splitDate[2] + "')]//ancestor::td";
		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(yearXpath)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());
				}
			}
		}

		String monthXpath = "//span[contains(text(),'" + splitDate[1] + "')]//ancestor::td";
		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(monthXpath)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());
				}
			}
		}

		String dayXapath = "//td[@aria-label='" + stringMonth.substring(0, 1) + finalMonth + " " + date + ", "
				+ splitDate[2] + "']";

		for (int i = 0; i <= 500; i++) {
			try {
				driver.findElement(By.xpath(dayXapath)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());
				}
			}
		}

	}

	@Then("^verify return record should reflect in return report$")
	public void verify_return_record_should_reflect_in_return_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String validationXpath = "//div[contains(text(),'"
				+ assetReturnReportTestdata.get("approvedAssetReferenceNumber") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean validation = driver.findElement(By.xpath(validationXpath)).isDisplayed();
				Assert.assertTrue(validation);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		browserHelper.switchToParentWithChildClose();
	}

}
