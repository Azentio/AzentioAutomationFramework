package stepdefinitions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.FIXEDASSET_AssetAllocationObj;
import pageobjects.FIXEDASSET_AssetTransferObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FIXED_ASSET_AssetDeAllocationObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import resources.MonthFinder;

public class FIXEDASSET_AssetImpairement extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	KUBS_MakerObj KubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	Map<String, String> impairementData = new HashMap<String, String>();
	JsonConfig jsonConfig = new JsonConfig();

	FIXEDASSET_AssetAllocationObj assetAllocationObj = new FIXEDASSET_AssetAllocationObj(driver);
	FIXED_ASSET_AssetDeAllocationObj deAllocationObj = new FIXED_ASSET_AssetDeAllocationObj(driver);
	FIXEDASSET_AssetTransferObj assetTransferObj = new FIXEDASSET_AssetTransferObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);

	public String assetLife;
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	Map<String, String> impairmentTestData = new HashMap<String, String>();
	Map<String, String> impairmentReportTestData = new HashMap<String, String>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetTransfer = new ExcelData(path, "FixedAsset_AssetTransfer", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(path, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataImpairementAssetTransferExecution = new ExcelData(path, "AssetTransfer_ExecutionTracker", "TestCaseID");
	ExcelData excelDataImpairementAssetImpairementExecution = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	ExcelData excelDataImpairementAssetRevaluationExecution = new ExcelData(path, "AssetRevaluation_ExecutionTrack", "TestCaseID");
	Map<String, String> DataSetID = new HashMap<>();
	BrowserHelper browserHelper = new BrowserHelper(driver);

	@Given("^Navigate to KUBS URL and login with maker credentials$")
	public void navigate_to_kubs_url_and_login_with_maker_credentials() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();

	}

	@And("^click on fixed asset main module$")
	public synchronized void click_on_fixed_asset_main_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, KubsMakerObj.kubsDirectionIcon());
		KubsMakerObj.kubsDirectionIcon().click();
		for (int i = 0; i <= 500; i++) {
			try {
				KubsMakerObj.kubsFixedAssets().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
	}

	@And("^click on fixed asset main Module$")
	public synchronized void click_on_fixed_asset_main_Module() throws Throwable {
	
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(KubsMakerObj.kubsDirectionIcon());
		KubsMakerObj.kubsDirectionIcon().click();
	
		while (true) {
			try {
				KubsMakerObj.kubsFixedAssets().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

	@And("^goto asset creation module$")
	public void goto_asset_creation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetAssetCreationViewButton());
		fixedAssetObj.fixedAssetAssetCreationViewButton().click();

	}

	@SuppressWarnings("static-access")
	@Then("^check if the asset life is exhausted$")
	public void check_if_the_asset_life_is_exhausted() throws Throwable {

		MonthFinder monthFinder = new MonthFinder();
		for (int i = 0; i < 3; i++) {
			try {
				fixedAssetObj.fixedAssetFixedAssetItem().click();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println(e.getMessage());
			}
		}
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetItemRecord());
		fixedAssetObj.fixedAssetItemRecord().click();

		javascriptHelper.JavaScriptHelper(driver);
		String capitalizationDatedate = javascriptHelper
				.executeScript("return document.getElementsByClassName('form-control p-0')[1].value").toString();
		String assetLifePeriod = javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[8].value")
				.toString();
		int assetLifePeriodIntegerValue = Integer.parseInt(assetLifePeriod);
		int finalAssetLife = assetLifePeriodIntegerValue * 365;
		int finalAssetLifeMonth = assetLifePeriodIntegerValue * 30;
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetSystemDate());
		String systemDate = fixedAssetObj.fixedAssetSystemDate().getText();
		System.out.println("Date is" + capitalizationDatedate);
		System.out.println("System date is" + systemDate);
		System.out.println("AssetLife is" + assetLife);
		LocalDate fromDate = null;
		LocalDate toDate = null;
		String[] capitalizationdate = capitalizationDatedate.split("-");
		String[] systemdate = systemDate.split("-");
		int day = Integer.parseInt(capitalizationdate[0]);
		int year = Integer.parseInt(capitalizationdate[2]);
		// Month capitalizationMonth = null;
		String month = capitalizationdate[1];
		Integer.parseInt(systemdate[0]);
		int systemYear = Integer.parseInt(systemdate[2]);
		String SystemMonth = systemdate[1];
		Month capitalizationFromMonth = monthFinder.monthFinder(month);
		Month SystemToMonth = monthFinder.monthFinder(SystemMonth);
		LocalDate capDate = fromDate.of(year, capitalizationFromMonth, day);
		LocalDate sysDate = toDate.of(systemYear, SystemToMonth, day);
		long noOfDaysBetween = ChronoUnit.DAYS.between(capDate, sysDate);
		System.out.println(noOfDaysBetween);
		if (assetLife.equalsIgnoreCase("Month")) {
			if (finalAssetLifeMonth == noOfDaysBetween || finalAssetLifeMonth <= noOfDaysBetween) {
				System.out.println("Condition satisfied");
			} else {
				Assert.fail(" Monthly Asset is not expired ");
			}
		} else if (assetLife.equalsIgnoreCase("Year")) {
			if (finalAssetLife == noOfDaysBetween || finalAssetLife <= noOfDaysBetween) {
				System.out.println("Condition satisfied");
			} else {
				Assert.fail("Yearly Asset is not expired");
			}
		}

	}

	@And("^go to asset allocation module$")
	public void go_to_asset_allocation_module() throws Throwable {
		fixedAssetObj.fixedAssetAssetAllocationViewButton().click();
	}

	@And("^get the active reference number in asset allocation module$")
	public void get_the_active_reference_number_in_asset_allocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");

		impairementData.put("assetReferenceNumber",
				fixedAssetObj.fixedAssetAllocationActiveReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^go to asset de allocation module$")
	public void go_to_asset_de_allocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetDeallocation());
		fixedAssetObj.fixedAssetAssetDeallocation().click();
	}

	@And("^get the active reference number in asset de allocation module$")
	public void get_the_active_reference_number_in_asset_de_allocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");
		impairementData.put("assetReferenceNumber",
				fixedAssetObj.fixedAssetAllocationActiveReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^go to revalued asset module$")
	public void go_to_revalued_asset_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetRevaluation());
		fixedAssetObj.fixedAssetRevaluation().click();
	}

	@And("^get the active reference number in asset re valuation module$")
	public void get_the_active_reference_number_in_asset_re_valuation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");
		impairementData.put("assetReferenceNumber", fixedAssetObj.fixedAssetReValuationReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^goto asset ammendent module$")
	public void goto_asset_ammendent_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetAmmendent());
		fixedAssetObj.fixedAssetAssetAmmendent().click();
	}

	@And("^get the active reference number in the assetammendment module$")
	public void get_the_active_reference_number_in_the_assetammendment_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");

		impairementData.put("assetReferenceNumber", fixedAssetObj.fixedAssetAmmendmentApprovedRecord().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^goto asset replacement module$")
	public void goto_asset_replacement_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetReplacement());
		fixedAssetObj.fixedAssetAssetReplacement().click();
	}

	@And("^get the active reference number in the asset replacement module$")
	public void get_the_active_reference_number_in_the_asset_replacement_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
//		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());
//		
//		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");
//		.sleep(500);
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetReValuationReferenceNumber());
		impairementData.put("assetReferenceNumber", fixedAssetObj.fixedAssetReValuationReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^goto asset return module and choose the edit icon$")
	public void goto_asset_return_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetReturnActionIcon());
		fixedAssetObj.fixedAssetAssetReturnActionIcon().click();
	}

	@And("^get the active reference number in asset return module$")
	public void get_the_active_reference_number_in_asset_return_module() throws Throwable {

		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetAssetReferenceNumStatus());
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());
		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");

		impairementData.put("assetReferenceNumber", fixedAssetObj.fixedAssetReValuationReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^goto asset sale module and choose the edit icon$")
	public void goto_asset_sale_module_and_choose_the_edit_icon() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetSale());
		fixedAssetObj.fixedAssetAssetSale().click();
	}

	@And("^get the active reference number in asset Sale module$")
	public void get_the_active_reference_number_in_asset_sale_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");

		impairementData.put("assetReferenceNumber",
				fixedAssetObj.fixedAssetAllocationActiveReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^goto asset transfer module and choose the edit icon$")
	public void goto_asset_transfer_module_and_choose_the_edit_icon() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetTransferEditIcon());
		fixedAssetObj.fixedAssetAssetTransferEditIcon().click();
	}

	@And("^get the active reference number in asset Transfer module$")
	public void get_the_active_reference_number_in_asset_transfer_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());

		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");
		impairementData.put("assetReferenceNumber",
				fixedAssetObj.fixedAssetAllocationActiveReferenceNumber().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));
	}

	@And("^search the active record in asset creation module$")
	public void search_the_active_record_in_asset_creation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		fixedAssetObj.fixedAssetAssetReferenceNumStatus().click();
		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");

		impairementData.put("assetReferenceNumber", fixedAssetObj.fixedAssetActiveRecord().getText());
		System.out.println(impairementData.get("assetReferenceNumber"));

	}

	@And("^click on view button near by asset impairement module$")
	public void click_on_view_button_near_by_asset_impairement_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementwithFluentwait(assetImpairementObj.fixedAssetViewIcon(),
		// 1000, 100);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(assetImpairementObj.fixedAssetViewIcon());
				assetImpairementObj.fixedAssetViewIcon().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@And("^click on Add Icon$")
	public void click_on_Add_Icon() throws Throwable {
		for (int i = 0; i < 90; i++) {
			try {
				assetImpairementObj.fixedAssetAddButton().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@And("^get the test data for impairment asset from excel database$")
	public void get_the_test_data_for_impairment_asset_from_excel_database() throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_001_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database for the pre requisite of asset write off$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_pre_requisite_of_asset_write_off()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D11");
	}

	@And("^get the test data for asset write off from excel database$")
	public void get_the_test_data_for_asset_write_off_from_excel_database() throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_001_D1");
	}

	@And("^get the test data for asset write off from excel database which is already revalued$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_revalued() throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_003_D1");
	}

	@And("^get the test data for asset write off from excel database which is already ammendment$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_ammendment()
			throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_004_D1");
	}

	@And("^get the test data for asset write off from excel database which is already Replaced$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_replaced() throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_006_D1");
	}

	@And("^get the test data for asset write off from excel database which is already allocated$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_allocated()
			throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_007_D1");
	}

	@And("^get the test data for asset write off from excel database which is already de allocated$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_de_allocated()
			throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_008_D1");
	}

	@And("^get the test data for asset write off from excel database which is already undertaking$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_undertaking()
			throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_009_D1");
	}

	@And("^get the test data for asset write off from excel database which is already impaired$")
	public void get_the_test_data_for_asset_write_off_from_excel_database_which_is_already_impaired() throws Throwable {
		impairmentTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_005_D1");
	}

	@And("^get the test data for impairment asset from excel database for the prerequisite of asset transfer$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		DataSetID=excelDataImpairementAssetTransferExecution.getTestdata("KUBS_FAT_UAT_009_001_01_AssetTransfer");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database for the prerequisite of asset revaluation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		DataSetID=excelDataImpairementAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_009_001_01_Revaluation");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database for the prerequsite of asset return$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequsite_of_asset_return()
			throws Throwable {
		// KUBS_FAT_UAT_009_001_01_D2
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D2");
	}

	@And("^get the test data for impairment asset from excel database which is already done one asset allocation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_one_asset_allocation()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_002_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset de allocation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_de_allocation()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_003_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset revaluation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_revaluation()
			throws Throwable {
		
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_004_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset ammendment$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_ammendment()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_005_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset replacement maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_replacement_maker_part()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_006_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset return maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_return_maker_part()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_007_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset Sale maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_sale_maker_part()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_008_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset Transfer maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_transfer_maker_part()
			throws Throwable {
		DataSetID=excelDataImpairementAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_009_01");
		impairmentTestData = excelDataForAssetImpairment.getTestdata(DataSetID.get("Data Set ID"));
	}

	@Then("^verify asset reference number should visisble along with item number in impairment list view$")
	public void verify_asset_reference_number_should_visisble_along_with_item_number_in_impairment_list_view()
			throws Throwable {
		String xpath = "//datatable-body-row[1]//span[text()=' " + impairmentTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[1]//span[text()=' "
				+ impairmentTestData.get("AssetItemNumber") + " ']";
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

	@And("^store the asset reference number and item number of impaired assset in write off excel database$")
	public void store_the_asset_reference_number_and_item_number_of_impaired_assset_in_write_off_excel_database()
			throws Throwable {
		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_005_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_005_D1", "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the impaired asset reference number and item number in asset transfer exceldatabase$")
	public void store_the_impaired_asset_reference_number_and_item_number_in_asset_transfer_exceldatabase()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData(impairmentTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetTransfer.updateTestData(impairmentTestData.get("Update Data Set 1"), "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the impaired asset reference number and item number in asset transfer and undertaking exceldatabase$")
	public void store_the_impaired_asset_reference_number_and_item_number_in_asset_transfer_and_undertaking_exceldatabase()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData(impairmentTestData.get("Update Data Set 2"), "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetTransfer.updateTestData(impairmentTestData.get("Update Data Set 2"), "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of impaired asset in assetrevaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_impaired_asset_in_assetrevaluation_excel_database()
			throws Throwable {
		
		excelDataForAssetRevaluation.updateTestData(impairmentTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData(impairmentTestData.get("Update Data Set 1"), "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and asset item number in asset allocation excel database$")
	public void store_the_asset_reference_number_and_asset_item_number_in_asset_allocation_excel_database()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_002_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_002_D1", "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of imapired asset in asset return excel database$")
	public void store_the_asset_reference_number_and_item_number_of_imapired_asset_in_asset_return_excel_database()
			throws Throwable {

		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_004_01_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_004_01_D1", "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of impaired asset should store in excel database$")
	public void store_the_asset_reference_number_and_item_number_of_impaired_asset_should_store_in_excel_database()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D1", "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^click on search button in list view of asset impairment module$")
	public void click_on_search_button_in_list_view_of_asset_impairment_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsListViewSearchIcon());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsListViewSearchIcon());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsListViewSearchIcon());

	}

	@And("^search the asset reference number in asset impairment list view$")
	public void search_the_asset_reference_number_in_asset_impairment_list_view() throws Throwable {

		for (int i = 0; i <= 200; i++) {
			try {
				clicksAndActionsHelper
						.moveToElement(assetImpairementObj.assetImpairmentListViewSearchAssetReferenceNumber());
				clicksAndActionsHelper
						.clickOnElement(assetImpairementObj.assetImpairmentListViewSearchAssetReferenceNumber());
				assetImpairementObj.assetImpairmentListViewSearchAssetReferenceNumber()
						.sendKeys(impairmentTestData.get("AssetReferenceNumber"));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on temp view of asset sale module$")
	public void click_on_temp_view_of_asset_sale_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetSaleTempView());
		assetImpairementObj.fixedAssetAssetSaleTempView().click();
	}

	@And("^get the asset reference number which is submitted now$")
	public void get_the_asset_reference_number_which_is_submitted_now() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetImpairementObj.fixedAssetTempViewFirstAssetReferenceNumber());
		impairementData.put("assetReferenceNumber",
				assetImpairementObj.fixedAssetTempViewFirstAssetReferenceNumber().getText());
	}

	@Then("^Check System shuld display the input fields$")
	public void check_system_shuld_display_the_input_fields() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetReferenceNumber());
		Assert.assertTrue(assetImpairementObj.fixedAssetReferenceNumber().isDisplayed());
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetItemNo());
		Assert.assertTrue(assetImpairementObj.fixedAssetAssetItemNo().isDisplayed());

	}

	@And("^select asset reference number$")
	public void select_asset_reference_number() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetReferenceNumber());
		for (int i = 0; i <= 50; i++) {
			try {
				assetImpairementObj.fixedAssetReferenceNumber().click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(impairementData.get("assetReferenceNumber"));

		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);

	}

	@And("^goto assetallocation module$")
	public void goto_assetallocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(assetAllocationObj.fixedAssetAssetAllocationView());
		waitHelper.waitForElementwithFluentwait(driver, assetAllocationObj.fixedAssetAssetAllocationView());
		assetAllocationObj.fixedAssetAssetAllocationView().click();
	}

	@And("^enter item number in allocation module$")
	public void enter_item_number_in_allocation_module() throws Throwable {
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().click();
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().sendKeys(Keys.DOWN);
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().sendKeys(Keys.ENTER);
	}

	@Then("^save the record$")
	public void save_the_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetAllocationObj.fixedAssetAssetAllocationSaveButton());
		assetAllocationObj.fixedAssetAssetAllocationSaveButton().click();

	}

	@And("^goto asset deallocation module$")
	public void goto_asset_deallocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon());
		waitHelper.waitForElementwithFluentwait(driver, deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon());
		deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
	}

	@And("^enter asset item number for de allocation$")
	public void enter_asset_item_number_for_de_allocation() throws Throwable {
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
	}

	@And("^save the asset deallocation record$")
	public void save_the_asset_deallocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, deAllocationObj.fixedAssetDeAllocationSaveButton());
		deAllocationObj.fixedAssetDeAllocationSaveButton().click();
	}

	@And("^go to asset undertaking module$")
	public void go_to_asset_undertaking_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.assetUndertakingViewButton());
		assetTransferObj.assetUndertakingViewButton().click();
	}

	@And("^Goto Asset Transfer$")
	public void goto_asset_transfer() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.fixedAssetAssetTransferViewButton());
		assetTransferObj.fixedAssetAssetTransferViewButton().click();
	}

	@And("^enter new ranch$")
	public void enter_new_ranch() throws Throwable {
		assetTransferObj.fixedAssetAssetTransferBranch().click();
		assetTransferObj.fixedAssetAssetTransferBranch().sendKeys(Keys.DOWN);
		assetTransferObj.fixedAssetAssetTransferBranch().sendKeys(Keys.ENTER);
	}

	@And("^enter transfer as yes and save the record$")
	public void enter_transfer_as_yes_and_save_the_record() throws Throwable {
		assetTransferObj.fixedAssetTransferButton().click();
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.fixedAssetTransferYes());
		assetTransferObj.fixedAssetTransferYes().click();
		assetTransferObj.fixedAssetTransferSaveButton().click();
	}

	@And("^enter transfer as yes and save the record in second reviewer$")
	public void enter_transfer_as_yes_and_save_the_record_in_second_reviewer() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.fixedAssetTransferButton());
		assetTransferObj.fixedAssetTransferButton().click();
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.fixedAssetTransferYes());
		assetTransferObj.fixedAssetTransferYes().click();

		assetTransferObj.transferSecondReviewer().click();

	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in Transfer maker stage$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_Transfer_maker_stage()
			throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, assetTransferObj.TransferReviewerId());
		String reviwerId = assetTransferObj.TransferReviewerId().getText();
		String trimmerReviewerID = reviwerId.substring(81);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		jsonReaderWriter.addData(revID);
		assetTransferObj.transferAlertClose().click();

	}

	@And("^choose the asset Item no$")
	public void choose_the_asset_no() throws Throwable {
		assetImpairementObj.fixedAssetAssetItemNo().click();

		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.DOWN);
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.ENTER);

	}

	@And("^select the asset reference number in asset impairment module$")
	public void select_the_asset_reference_number_in_asset_impairment_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetReferenceNumber());
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(impairmentTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + impairmentTestData.get("AssetReferenceNumber") + "']";
		for (int i = 0; i <= 10; i++) {
			try {

				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the asset item number in asset impairment module$")
	public void select_the_asset_item_number_in_asset_impairment_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetItemNo());
		System.out.println("Item number " + impairmentTestData.get("AssetItemNumber"));
		assetImpairementObj.fixedAssetAssetItemNo().click();
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(impairmentTestData.get("AssetItemNumber"));

		String xpath = "//ng-dropdown-panel//div[text()='" + impairmentTestData.get("AssetItemNumber") + "']";
		for (int i = 0; i <= 500; i++) {
			try {

				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify asset reference number or asset item number should not visible for write off$")
	public void verify_asset_reference_number_or_asset_item_number_should_not_visible_for_write_off() throws Throwable {
		boolean refNoStatus = false, itemNumStatus = false;
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetReferenceNumber());
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(impairmentTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + impairmentTestData.get("AssetReferenceNumber") + "']";
		for (int i = 0; i <= 10; i++) {
			try {

				refNoStatus = driver.findElement(By.xpath(xpath)).isDisplayed();

				break;
			} catch (Exception e) {

			}
		}
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetItemNo());
		System.out.println("Item number " + impairmentTestData.get("AssetItemNumber"));
		assetImpairementObj.fixedAssetAssetItemNo().click();
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(impairmentTestData.get("AssetItemNumber"));

		String xpath2 = "//ng-dropdown-panel//div[text()='" + impairmentTestData.get("AssetItemNumber") + "']";
		for (int i = 0; i <= 10; i++) {
			try {

				itemNumStatus = driver.findElement(By.xpath(xpath2)).isDisplayed();
				break;
			} catch (Exception e) {

			}
		}
		if (refNoStatus == false || itemNumStatus == false) {
			System.out.println("Condition matched");
		} else {
			Assert.fail("Asset reference number and item number both are showing");
		}
	}

	@And("^choose the transcation type as impairment$")
	public void choose_the_transcation_type_as_impairment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetTransactionType());
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetTransTypeImpairement());
		assetImpairementObj.fixedAssetTransTypeImpairement().click();

	}

	@And("^choose the transcation type as write off$")
	public void choose_the_transcation_type_as_write_off() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetAssetTransactionType());
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetTransTypeWriteOff());
		assetImpairementObj.fixedAssetTransTypeWriteOff().click();
	}

	@And("^click on save button in impairment module$")
	public void click_on_save_button_in_impairment_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSaveButton());
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset asset impairment module code in notification$")
	public void search_the_asset_asset_impairment_module_code_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSearchEventCode());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(impairmentTestData.get("ModuleCode"));
	}

	@And("^store the asset impairment reference number in impairment excel database$")
	public void store_the_asset_impairment_reference_number_in_impairment_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImapirmentReferenceNumber());

		excelDataForAssetImpairment.updateTestData(impairmentTestData.get("DataSet ID"), "Reference ID",
				assetImpairementObj.assetImapirmentReferenceNumber().getText());
	}

	@And("^store the asset writeoff reference number in impairment excel database$")
	public void store_the_asset_writeoff_reference_number_in_impairment_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImapirmentReferenceNumber());

		excelDataForAssetWriteOff.updateTestData(impairmentTestData.get("DataSet ID"), "Reference ID",
				assetImpairementObj.assetImapirmentReferenceNumber().getText());
	}

	@And("^select the asset impairment record from notification$")
	public void select_the_asset_impairment_record_from_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImpairmentNotificationFirstRecord());
		assetImpairementObj.assetImpairmentNotificationFirstRecord().click();
	}

	@And("^click on submit in asset impairment$")
	public void click_on_submit_in_asset_impairment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSubmitButton());
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset impairment$")
	public void enter_the_alert_remark_in_asset_impairment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertRemark());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(impairmentTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset impairment$")
	public void click_on_alert_submit_in_asset_impairment() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
				clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
				break;
			} catch (Exception e) {
				if (i > 200 && i < 490) {
					clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
					clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
					kubsCommonObj.kubsAlertRemark().sendKeys(impairmentTestData.get("MakerAlertRemark"));
				}

				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^store the reviewer ID in asset impairment excel database$")
	public void store_the_reviewer_id_in_asset_impairment_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetImpairment.updateTestData(impairmentTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^store the reviewer ID in asset write off excel database$")
	public void store_the_reviewer_id_in_asset_write_off_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetWriteOff.updateTestData(impairmentTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	// End
	@And("^choose the transcation type as writeOff$")
	public void choose_the_transcation_type_as_writeoff() throws Throwable {
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetTransTypeWriteOff());
		assetImpairementObj.fixedAssetTransTypeWriteOff().click();
		String assetReferenceNumber = assetImpairementObj.fixedAssetGetReferenceNo().getText();
		impairementData.put("AssetReferenceNo", assetReferenceNumber);
	}

	@Then("^click on Save Button$")
	public void click_on_save_button() throws Throwable {

		for (int i = 0; i < 5; i++) {
			try {
				if (i == 4) {
					Assert.fail("Save button not able to click");
				}
				waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.fixedAssetSaveButton());
				assetImpairementObj.fixedAssetSaveButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Then("^verify user can able to get the successfull saved message$")
	public void verify_user_can_able_to_get_the_successfull_saved_message() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.kubsToastAlert());
		Assert.assertEquals(assetImpairementObj.kubsToastAlert().getText(),
				"Workflow initiated submit record from inbox.");
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.alertClose());
		assetImpairementObj.alertClose().click();
	}

	@And("^login with Maker ID$")
	public void login_with_maker_id() throws Throwable {

		kubsLogin.loginToAzentioAppByMaker();
	}

	@And("^get the transfered asset reference number which is submitted now$")
	public void get_the_transfered_asset_reference_number_which_is_submitted_now() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetImpairementObj.assetTransferTempViewAssetReferenceNumber());
		impairementData.put("assetReferenceNumber",
				assetImpairementObj.assetTransferTempViewAssetReferenceNumber().getText());
	}

	@Then("^check the approved record is displayed in appeared in maker list view stage$")
	public void check_the_approved_record_is_displayed_in_appeared_in_maker_list_view_stage() throws Throwable {
		System.out.println(impairementData.get("AssetReferenceNo"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + impairementData.get("AssetReferenceNo") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

	/****** KUBS_FAT_UAT_010_009 *********/

	@And("^get the text of asset code$")
	public void get_the_text_of_asset_code() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.underTakingApprovedAssetCode());
		String assetCode = assetTransferObj.underTakingApprovedAssetCode().getText();
		String transferedBranch = assetTransferObj.fixedAssetAssetTransferBranch().getText();
		impairementData.put("AssetCode", assetCode);
		impairementData.put("TransferBranch", transferedBranch);
		System.out.println("AssetCode" + impairementData.get("AssetCode") + " Transfered Branch"
				+ impairementData.get("TransferBranch"));
	}

	@And("^get the text of asset code and transfered branch name$")
	public void select_the_record_and_get_the_transfered_branch_name() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.underTakingApprovedAssetCode());
		String assetCode = assetTransferObj.underTakingApprovedAssetCode().getText();
		String transferedBranch = assetTransferObj.underTakingTransferedBranch().getText();
		impairementData.put("AssetCode", assetCode);
		impairementData.put("TransferBranch", transferedBranch);
		System.out.println("AssetCode" + impairementData.get("AssetCode") + " Transfered Branch"
				+ impairementData.get("TransferBranch"));
	}

	@And("^choose configuration option$")
	public void choose_configuration_option() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsMakerObj.kubsFinaceOption());
		kubsMakerObj.kubsFinaceOption().click();
		waitHelper.waitForElementwithFluentwait(driver, KubsMakerObj.configurationMenu());
		kubsMakerObj.configurationMenu().click();
	}

	@And("^click on entity maintenece$")
	public void click_on_entity_maintenece() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.configEntityMainteneceMain());
		assetTransferObj.configEntityMainteneceMain().click();
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.configBranchEntityMaintenence());
		assetTransferObj.configBranchEntityMaintenence().click();
		// assetTransferObj.configEntityMainteneceDescription().sendKeys(impairementData.get("TransferBranch"));

	}

	@And("^click on view button near by legal entity branches$")
	public void click_on_view_button_near_by_legal_entity_branches() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.configBranchEntityMaintenence());
		assetTransferObj.configBranchEntityMaintenence().click();

	}

	@And("^search the brach name and get the branch code$")
	public void search_the_brach_name_and_get_the_branch_code() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.configEntityMainteneceDescription());
		assetTransferObj.configEntityMainteneceDescription().click();
		assetTransferObj.configEntityMainteneceDescription().sendKeys(impairementData.get("TransferBranch"));
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.configgetBranchCode());
		String branchCode = assetTransferObj.configgetBranchCode().getText();
		impairementData.put("BranchCode", branchCode);
		System.out.println("BranchCode is" + impairementData.get("BranchCode"));
	}

	@And("^choose finance option$")
	public void choose_finance_option() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, kubsMakerObj.kubsFinaceOption());
		kubsMakerObj.kubsFinaceOption().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsMakerObj.FinanceOption());
		kubsMakerObj.FinanceOption().click();
	}

	@And("^click on fixed asset configuration$")
	public void click_on_fixed_asset_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsMakerObj.kubsFixedAssetsConfigurations());
		kubsMakerObj.kubsFixedAssetsConfigurations().click();

	}

	@And("^the click on view button near by serail number setup$")
	public void the_click_on_view_button_near_by_serail_number_setup() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementwithFluentwait(assetTransferObj.fixedAssetSerailNumber(),
		// 2000, 200);
		javascriptHelper.scrollIntoView(assetTransferObj.fixedAssetSerailNumber());
		assetTransferObj.fixedAssetSerailNumber().click();
	}

	@And("^serach the asset code and get the last serail number$")
	public void serach_the_asset_code_and_get_the_last_serail_number() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.serachAssetCode());
		assetTransferObj.serachAssetCode().click();
		assetTransferObj.serachAssetCode().sendKeys(impairementData.get("AssetCode"));
		waitHelper.waitForElementwithFluentwait(driver, assetTransferObj.assetSerailNumberGetLastSerailNumber());
		String lastSerailNumber = assetTransferObj.assetSerailNumberGetLastSerailNumber().getText();
		impairementData.put("LastSerailNumber", lastSerailNumber);
		System.out.println("Last serail number" + impairementData.get("LastSerailNumber"));

	}

	@And("^select asset reference number of undertaking assset in write off$")
	public void select_asset_reference_number_of_undertaking_assset_in_write_off() throws Throwable {
		String assetReferenceNumber = impairementData.get("AssetCode") + "_" + impairementData.get("BranchCode") + "_"
				+ impairementData.get("LastSerailNumber");

		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(assetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^get the asset impaired date in asset impairement list view$")
	public void get_the_asset_impaired_date_in_asset_impairement_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetImpairementObj.assetImpairmentListViewApprovedAssetReferenceNumber());
		String approvedImpairementAssetReferenceNumber = assetImpairementObj
				.assetImpairmentListViewApprovedAssetReferenceNumber().getText();
		impairmentReportTestData.put("approvedImpairementAssetReferenceNumber",
				approvedImpairementAssetReferenceNumber);
		System.out.println(impairmentReportTestData.get("approvedImpairementAssetReferenceNumber"));
	}

	@And("^get the impaired asset reference number from asset impairement list view$")
	public void get_the_impaired_asset_reference_number_from_asset_impairement_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImpairmentListViewApprovedDate());
		String approvedImpairementDate = assetImpairementObj.assetImpairmentListViewApprovedDate().getText();
		impairmentReportTestData.put("approvedImpairementDate", approvedImpairementDate);
		System.out.println(impairmentReportTestData.get("approvedImpairementDate"));
	}

	@And("^click on transactional reports module$")
	public void click_on_transactional_reports_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubs_TransactionReportMainModule());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubs_TransactionReportMainModule());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubs_TransactionReportMainModule());

	}

	@And("^click on temp view of impairement report$")
	public void click_on_temp_view_of_impairement_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsImapirementReportTempView());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsImapirementReportTempView());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsImapirementReportTempView());
	}

	@SuppressWarnings("static-access")
	@And("^enter the impairement loss booking as on date$")
	public void enter_the_impairement_loss_booking_as_on_date() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImpairmentImpairementAsOnDate());
		clicksAndActionsHelper.moveToElement(assetImpairementObj.assetImpairmentImpairementAsOnDate());
		clicksAndActionsHelper.clickOnElement(assetImpairementObj.assetImpairmentImpairementAsOnDate());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
		String[] splitDate = impairmentReportTestData.get("approvedImpairementDate").split("-");
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

	@And("^click on view button in loss booking report screen$")
	public void click_on_view_button_in_loss_booking_report_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsReportViewButton());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsReportViewButton());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsReportViewButton());
	}

	@Then("^verify the asset code of impaired asset should reflect in report section$")
	public void verify_the_asset_code_of_impaired_asset_should_reflect_in_report_section() throws Throwable {
		browserHelper.SwitchToWindow(1);

		String validationXpath = "//div[contains(text(),'"
				+ impairmentReportTestData.get("approvedImpairementAssetReferenceNumber") + "')]";
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

	@And("^click on view button in Asset Revaluation report screen$")
	public void click_on_view_button_in_asset_revaluation_report_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsReportViewButton());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsReportViewButton());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsReportViewButton());
	}

	@And("^enter the Revaluation as on date$")
	public void enter_the_revaluation_as_on_date() throws Throwable {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/uuuu");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MMMM/uuuu");
		LocalDate localDate = LocalDate.now();

		String Date = dtf.format(localDate);
		String Date1 = dtf1.format(localDate);
		String[] DateSplit = Date.split("[/]");
		String[] DateSplit1 = Date1.split("[/]");
		Integer DateNum = Integer.valueOf(DateSplit[0]);
		String Month = DateSplit[1];
		String FullMonth = DateSplit1[1];
		Integer yearNum = Integer.valueOf(DateSplit[2]);

		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetImpairmentImpairementAsOnDate());
		clicksAndActionsHelper.moveToElement(assetImpairementObj.assetImpairmentImpairementAsOnDate());
		clicksAndActionsHelper.clickOnElement(assetImpairementObj.assetImpairmentImpairementAsOnDate());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
		String yearXpath = "//span[contains(text(),'" + yearNum + "')]//ancestor::td";
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

		String monthXpath = "//span[contains(text(),'" + Month + "')]//ancestor::td";
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

		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + FullMonth + " " + DateNum + ", " + yearNum + "']/span"));

		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionsHelper.doubleClick(FinalDay);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());

				}
			}
		}
	}

	@Then("^verify the asset code of Revaluation asset should reflect in report section$")
	public void verify_the_asset_code_of_revaluation_asset_should_reflect_in_report_section() throws Throwable {
		browserHelper.SwitchToWindow(1);

		String validationXpath = "//div[contains(text(),'"
				+ impairmentReportTestData.get("approvedImpairementAssetReferenceNumber") + "')]";
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

	@And("^click on view button near by asset Revaluation module$")
	public void click_on_view_button_near_by_asset_revaluation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(assetImpairementObj.fixedAssetRevaluationViewIcon());
				assetImpairementObj.fixedAssetRevaluationViewIcon().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@And("^get the Revalued asset reference number from asset Revaluation list view$")
	public void get_the_revalued_asset_reference_number_from_asset_revaluation_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetImpairementObj.assetImpairmentListViewApprovedAssetReferenceNumber());
		String approvedImpairementAssetReferenceNumber = assetImpairementObj
				.assetImpairmentListViewApprovedAssetReferenceNumber().getText();
		impairmentReportTestData.put("approvedImpairementAssetReferenceNumber",
				approvedImpairementAssetReferenceNumber);
		System.out.println(impairmentReportTestData.get("approvedImpairementAssetReferenceNumber"));
	}

	@And("^click on temp view of Revaluation report$")
	public void click_on_temp_view_of_revaluation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetImpairementObj.assetsRevaluationReportTempView());
		clicksAndActionsHelper.moveToElement(assetImpairementObj.assetsRevaluationReportTempView());
		clicksAndActionsHelper.clickOnElement(assetImpairementObj.assetsRevaluationReportTempView());
	}

}