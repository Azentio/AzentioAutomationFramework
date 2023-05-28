package stepdefinitions;

import java.io.IOException;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetDeallocationObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class FixedAsset_AssetDeallocation extends BaseClass {
	WebDriver driver = BaseClass.driver;
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetDeallocationObj fixedAsset_AssetDeallocationObj = new FixedAsset_AssetDeallocationObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	String AssetReferenceNumber;
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> mapData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonWebObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetDeAllocation = new ExcelData(path, "FixedAsset_AssetDeAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(path, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataForAssetImpairementExecutionTracker = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	ExcelData excelDataForAssetRevaluationExecutionTracker = new ExcelData(path, "AssetRevaluation_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAlocDeAllocExecution = new ExcelData(path, "AssetAllocDeAlloc_ExeTracker", "TestCaseID");
	ExcelData excelDataAssetReturnExecution = new ExcelData(path, "AssetReturn_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetWriteOffExecution = new ExcelData(path, "WriteOff_ExecutionTrack", "TestCaseID");
	Map<String, String> assetDeAllocationTestData = new HashMap<>();
	Map<String, String> dataSetID = new HashMap<>();
	Map<String, String> assetDeAllocationReportTestData = new HashMap<>();

	@And("^get the allocated asset reference number in asset allocation module$")
	public void get_the_allocated_asset_reference_number_in_asset_allocation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAssetAllocatedApprovedRecord());
		mapData.put("allocatedAssetReferenceNumber",
				fixedAsset_AssetDeallocationObj.fixedAssetAllocatedApprovedRecord().getText());
		System.out.println("Allocate dasset reference number is " + mapData.get("allocatedAssetReferenceNumber"));

	}

//New Start
	@And("^get the asset de allocation test data from excel database$")
	public void get_the_asset_de_allocation_test_data_from_excel_database() throws Throwable {
		                                                                     //KUBS_FAT_UAT_006_005_01_D1
		dataSetID=excelDataAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_005_01Prereq");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset de allocation test data from excel database for asset write off prerequisite$")
	public void get_the_asset_de_allocation_test_data_from_excel_database_for_asset_write_off_prerequisite()
			throws Throwable {	
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_006_005_01");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset de allocation test data from excel database for asset return prerequsite$")
	public void get_the_asset_de_allocation_test_data_from_excel_database_for_asset_return_prerequsite()
			throws Throwable {
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_006_005_01_Return");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset de allocation test data from excel database for prerequsites of impairment asset$")
	public void get_the_asset_de_allocation_test_data_from_excel_database_for_prerequsites_of_impairment_asset()
			throws Throwable {
		dataSetID=excelDataForAssetImpairementExecutionTracker.getTestdata("KUBS_FAT_UAT_006_005_01_Impairment");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset de allocation test data from excel database for the prerequisite of asset revaluation$")
	public void get_the_asset_de_allocation_test_data_from_excel_database_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		dataSetID=excelDataForAssetRevaluationExecutionTracker.getTestdata("KUBS_FAT_UAT_006_005_01_Revaluation");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^Get the data set id for asset deallocation of asset replacement record in deallocation excel database$")
	public void get_the_data_set_id_for_asset_deallocation_of_asset_replacement_record_in_deallocation_excel_database()
			throws Throwable {
		dataSetID=excelDataAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_01");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^Get the data set id for asset deallocation of asset ammenment record in deallocation excel database$")
	public void get_the_data_set_id_for_asset_deallocation_of_asset_ammenment_record_in_deallocation_excel_database()
			throws Throwable {
		dataSetID=excelDataAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_011_01");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		
	}

	@And("^Get the data set id for asset deallocation of asset transfer record in deallocation excel database$")
	public void get_the_data_set_id_for_asset_deallocation_of_asset_transfer_record_in_deallocation_excel_database()
			throws Throwable {
		
		dataSetID=excelDataAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_01.1_AssetTransferDeAllocation");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^Get the data set id for asset deallocation of asset sale record in deallocation excel database$")
	public void get_the_data_set_id_for_asset_deallocation_of_asset_sale_record_in_deallocation_excel_database()
			throws Throwable {
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D8");
	}

	@And("^Get the data set id for asset deallocation of asset revaluation record in deallocation excel database$")
	public void get_the_data_set_id_for_asset_deallocation_of_asset_revaluation_record_in_deallocation_excel_database()
			throws Throwable {
		dataSetID=excelDataAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_010_01");
		assetDeAllocationTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Then("^Click on asset deallocaion Eye button$")
	public void click_on_asset_deallocaion_eye_button() throws InterruptedException {
		// Eye

		javascriptHelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 100; i++) {
			try {

				javascriptHelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
				// waithelper.waitForElementToVisisbleWithFluentWait(driver,
				// fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
				break;
			} catch (Exception e) {

				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the asset reference number in asset de allocation$")
	public void enter_the_asset_reference_number_in_asset_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber()
				.sendKeys(assetDeAllocationTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetDeAllocationTestData.get("AssetReferenceNumber")
				+ "']";

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

	@And("^enter the asset item number in asset de allocation$")
	public void enter_the_asset_item_number_in_asset_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber()
				.sendKeys(assetDeAllocationTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetDeAllocationTestData.get("AssetItemNumber") + "']";

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

	@And("^save the asset de allocation record$")
	public void save_the_asset_de_allocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		kubsCommonWebObj.kubsSaveButton().click();
	}

	@And("^search the asset de allocation record in notification$")
	public void search_the_asset_de_allocation_record_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetDeAllocationTestData.get("ModuleCode"));

	}

	@And("^store the asset de allocation record in asset de allocation excel database$")
	public void store_the_asset_de_allocation_record_in_asset_de_allocation_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationReferenceNumber());
		excelDataForAssetDeAllocation.updateTestData(assetDeAllocationTestData.get("DataSet ID"), "Reference ID",
				fixedAsset_AssetDeallocationObj.assetDeAllocationReferenceNumber().getText());
	}

	@And("^select the asse de allocation record$")
	public void select_the_asse_de_allocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationNotificationFirstRecord());
		fixedAsset_AssetDeallocationObj.assetDeAllocationNotificationFirstRecord().click();
	}

	@And("^click on submit in asset de allocation$")
	public void click_on_submit_in_asset_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSubmitButton());
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset de allocation$")
	public void enter_the_alert_remark_in_asset_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetDeAllocationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset de allocation$")
	public void click_on_alert_submit_in_asset_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertSubmit());
		kubsCommonWebObj.kubsAlertSubmit().click();
	}

	@And("^store the reviewer ID of asset de allocation record and store in excel database$")
	public void store_the_reviewer_id_of_asset_de_allocation_record_and_store_in_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetDeAllocation.updateTestData(assetDeAllocationTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^search the de allocated asset reference number$")
	public void search_the_de_allocated_asset_reference_number() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationListViewSearchAssetReferenceNumber());
		fixedAsset_AssetDeallocationObj.assetDeAllocationListViewSearchAssetReferenceNumber().click();
		fixedAsset_AssetDeallocationObj.assetDeAllocationListViewSearchAssetReferenceNumber()
				.sendKeys(assetDeAllocationTestData.get("AssetReferenceNumber"));
	}

	@Then("^verify approved de allocated asset reference number should visible long with item number in de allocation list view$")
	public void verify_approved_de_allocated_asset_reference_number_should_visible_long_with_item_number_in_de_allocation_list_view()
			throws Throwable {
		String xpath = "//datatable-body-cell[5]//span[text()=' "
				+ assetDeAllocationTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[1]//span[text()=' "
				+ assetDeAllocationTestData.get("AssetItemNumber") + " ']";
		for (int i = 0; i <= 50; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset reference number and item number of de allocated asset in asset writeoff excel database$")
	public void store_the_asset_reference_number_and_item_number_of_de_allocated_asset_in_asset_writeoff_excel_database()
			throws Throwable {
		
		excelDataForAssetWriteOff.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetDeAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetWriteOff.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetDeAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number in asset return excel database$")
	public void store_the_asset_reference_number_and_item_number_in_asset_return_excel_database() throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_006_01_D1", "AssetReferenceNumber",
				assetDeAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_006_01_D1", "AssetItemNumber",
				assetDeAllocationTestData.get("AssetItemNumber"));

	}

	@And("^store the asset reference number and item number of deallocated asset in asset revaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_deallocated_asset_in_asset_revaluation_excel_database()
			throws Throwable {
		
		excelDataForAssetRevaluation.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetDeAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetDeAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of deallocated asset in asset return excel database$")
	public void store_the_asset_reference_number_and_item_number_of_deallocated_asset_in_asset_return_excel_database()
			throws Throwable {
		//Update Data Set 1
		excelDataForAssetReturn.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetDeAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetReturn.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetDeAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number in impairment excel database$")
	public void store_the_asset_reference_number_and_item_number_in_impairment_excel_database() throws Throwable {
		excelDataForAssetImpairment.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetDeAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData(assetDeAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetDeAllocationTestData.get("AssetItemNumber"));
	}
	//

	// ---------asset sold deallocaion-------------//
	@And("^User get sold asset for de allocation$")
	public void user_get_sold_asset_for_de_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]")));
		// driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
		mapData.put("AssetCode", driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]"))
				.getText());
		System.out.println(driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]"))
				.getText());
	}

	// Asset Reference Number
	@Then("^Select Asset Reference Number$")
	public void select_asset_reference_number() throws InterruptedException, IOException {

		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetReference());
		AssetReferenceNumber = fixedAsset_AssetDeallocationObj.fixedAsset_AssetReference().getText();
		System.out.println(AssetReferenceNumber);

	}

	@Then("^Click on Asset Impairment Eye button$")
	public void click_on_asset_impairment_eye_button() throws InterruptedException, IOException {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon());
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon().click();

	}

	@Then("^fill the form for Asset Impairment$")
	public void fill_the_form_for_asset_impairment() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().click();
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber()
				.sendKeys(AssetReferenceNumber);

		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().sendKeys(Keys.ENTER);

		// Transaction TYpe
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_TransactionType());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_TransactionType().click();

		// impairement
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_Impairement());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_Impairement().click();

		// AssetItemNumber
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().click();
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().sendKeys(Keys.DOWN);
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().sendKeys(Keys.ENTER);

	}

	@Then("^Click on revalued asset Eye button$")
	public void click_on_revalued_asset_eye_button() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon());
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon());
		fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon().click();

	}

	@Then("^Click on amended asset Eye button$")
	public void click_on_amended_asset_eye_button() throws InterruptedException, IOException {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon());
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon());
		fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon().click();

	}

	// ----------asset replacement deallocaion ------------//

	@Then("^Click on asset replacement  Eye button$")
	public void click_on_asset_replacement_eye_button() throws InterruptedException, IOException {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon());
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon());
		fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon().click();

	}

	@And("^open the list view record in de allocation list view$")
	public void open_the_list_view_record_in_de_allocation_list_view() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationFirstApprovedRecord());
		fixedAsset_AssetDeallocationObj.assetDeAllocationFirstApprovedRecord().click();

	}

	@And("^store the de allocation created date for de allocation report$")
	public void store_the_de_allocation_created_date_for_de_allocation_report() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {

				String createdDate = fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationCreatedDate()
						.getText();

				System.out.println("Created Date " + createdDate);
				assetDeAllocationReportTestData.put("createdDate", createdDate);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
	}

	@And("^store the asset item number and asset referece number and de allocated date for de allocation report validation$")
	public void store_the_asset_item_number_and_asset_referece_number_and_de_allocated_date_for_de_allocation_report_validation()
			throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationApprovedAssetReferenceNumber());
		String deallocationAprovedReferenceNumber = fixedAsset_AssetDeallocationObj
				.assetDeAllocationApprovedAssetReferenceNumber().getText();
		assetDeAllocationReportTestData.put("deallocationAprovedReferenceNumber", deallocationAprovedReferenceNumber);
		for (int i = 0; i <= 500; i++) {
			try {
				String deAllocationdate = javascriptHelper
						.executeScript("return document.getElementById('kubDateTime').value").toString();
				assetDeAllocationReportTestData.put("deAllocationdate", deAllocationdate);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^click on temp view of de allocation report temp view$")
	public void click_on_temp_view_of_de_allocation_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationReportTempView());
		fixedAsset_AssetDeallocationObj.assetDeAllocationReportTempView().click();
	}

	@And("^enter the employee in de allocation report form$")
	public void enter_the_employee_in_de_allocation_report_form() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportEmployeeID());
		fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportEmployeeID().click();
		fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportEmployeeID().sendKeys("anant");
		String xpath = "//ng-dropdown-panel//span[text()='" + "anant" + "']";

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
	@And("^enter the de allocation date in de allocation report form$")
	public void enter_the_de_allocation_date_in_de_allocation_report_form() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportDeAallocationCalendar());
		fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportDeAallocationCalendar().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		String[] splitDate = assetDeAllocationReportTestData.get("deAllocationdate").split("-");
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

	@SuppressWarnings("static-access")
	@And("^enter the de allocation as on date in de allocation report form$")
	public void enter_the_de_allocation_as_on_date_in_de_allocation_report_form() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportDeAallocationAsOnCalendar());
		fixedAsset_AssetDeallocationObj.assetDeAllocationDeAllocationReportDeAallocationAsOnCalendar().click();

		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetDeAllocationReportTestData.get("createdDate"));
		String[] splitDate = assetDeAllocationReportTestData.get("createdDate").split("-");
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

	@Then("^validate the de allocated asset should reflect in de allocation report$")
	public void validate_the_de_allocated_asset_should_reflect_in_de_allocation_report() throws Throwable {
		browserHelper.SwitchToWindow(1);

		String validationXpath = "//div[contains(text(),'"
				+ assetDeAllocationReportTestData.get("deallocationAprovedReferenceNumber") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean validationDeAlloation = driver.findElement(By.xpath(validationXpath)).isDisplayed();
				Assert.assertTrue(validationDeAlloation);
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
