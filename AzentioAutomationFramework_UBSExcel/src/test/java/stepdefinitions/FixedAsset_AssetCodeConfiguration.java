package stepdefinitions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FixedAsset_AssetCodeConfigurationObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class FixedAsset_AssetCodeConfiguration extends BaseClass {
	WebDriver driver = BaseClass.driver;
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCodeConfigurationObj fixedAsset_AssetCodeConfigurationObj = new FixedAsset_AssetCodeConfigurationObj(
			driver);
	String AssetCode;
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	Map<String, String> assetCodeConfigTestData = new HashMap<>();
	Map<String, String> assetCodeConfigReportTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonWebObj = new KUBS_CommonWebElements(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	FIXEDASSET_fixedAssetObj fixedAssetAccObj = new FIXEDASSET_fixedAssetObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	ExcelData excelDataAssetCategoryForTransfer = new ExcelData(excelPath, "AssetTransfer_ExecutionTracker",
			"TestCaseID");
	ExcelData excelDataAssetCategoryForImpairement = new ExcelData(excelPath, "AssetImpairement_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataAssetCodeConfigForRevaluation = new ExcelData(excelPath, "AssetRevaluation_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataAssetCodeForAlocDeAllocExecution = new ExcelData(excelPath, "AssetAllocDeAlloc_ExeTracker",
			"TestCaseID");
	ExcelData excelDataAssetReturnExecution = new ExcelData(excelPath, "AssetReturn_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetAmendmentExecution = new ExcelData(excelPath, "AssetAmendment_EXecutionTrack",
			"TestCaseID");
	ExcelData excelDataAssetCreationExecution = new ExcelData(excelPath, "AssetCreation_ExecutionTrack", "TestCaseID");
	Map<String, String> DataSetID = new HashMap<>();

	@And("^get the active asset code in asset category module$")
	public void get_the_active_asset_code_in_asset_category_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")));

		codeConfigData.put("AssetCode",
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
		System.out.println(
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
	}

	@Then("^Click on Asset code configuration Eye button$")
	public void click_on_asset_code_configuration_eye_button() throws IOException {
		// Eye Button
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon().click();

	}

	// New
	@And("^get the test data for asset code configuration$")
	public void get_the_test_data_for_asset_code_configuration() throws Throwable {
		DataSetID = excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_003_01");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration for asset ammendment$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_ammendment() throws Throwable {
		DataSetID = excelDataAssetAmendmentExecution.getTestdata("KUBS_FAT_UAT_002_003_01_AssetAmmendment");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration for asset return$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_return() throws Throwable {
		DataSetID = excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_003_01_Return");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration to do impairment$")
	public void get_the_test_data_for_asset_code_configuration_to_do_impairment() throws Throwable {
		DataSetID = excelDataAssetCategoryForImpairement.getTestdata("KUBS_FAT_UAT_002_003_01");
		System.out.println("DataSet ID " + DataSetID.get("Data Set ID"));
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration for asset allocation$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_allocation() throws Throwable {
		DataSetID = excelDataAssetCodeForAlocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_003_01Allocation");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration for asset revaluation$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_revaluation() throws Throwable {
		DataSetID = excelDataAssetCodeConfigForRevaluation.getTestdata("KUBS_FAT_UAT_002_003_01_ReValuation");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset code configuration for asset transfer and undetaking$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_transfer_and_undetaking() throws Throwable {
		DataSetID = excelDataAssetCategoryForTransfer.getTestdata("KUBS_FAT_UAT_002_003_01_Transfer");
		assetCodeConfigTestData = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@And("^enter the asset code in asset code configuration$")
	public void enter_the_asset_code_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().click();
		System.out.println("Asset Code " + assetCodeConfigTestData.get("AssetCode"));
		for (int i = 0; i <= 50; i++) {
			try {
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode()
						.sendKeys(assetCodeConfigTestData.get("AssetCode"));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String xpath = "//ng-dropdown-panel//div[contains(text(),'" + assetCodeConfigTestData.get("AssetCode") + "')]";
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the accounting model in asset code configuration$")
	public void enter_the_accounting_model_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel()
				.sendKeys(assetCodeConfigTestData.get("AccountingModel"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.ENTER);
	}

	@And("^enter the asset life unit in asset code configuration$")
	public void enter_the_asset_life_unit_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit()
				.sendKeys(assetCodeConfigTestData.get("AssetLifeUnit"));
		for (int i = 0; i <= 20; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver
						.findElement(By.xpath("//div[text()='" + assetCodeConfigTestData.get("AssetLifeUnit") + "']")));
				clickAndActionsHelper.clickOnElement(driver
						.findElement(By.xpath("//div[text()='" + assetCodeConfigTestData.get("AssetLifeUnit") + "']")));
				break;
			} catch (Exception e) {
				if (i == 20) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the asset life in asset code configuration$")
	public void enter_the_asset_life_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife()
				.sendKeys(assetCodeConfigTestData.get("AssetLife"));
	}

	@And("^enter the basis for depriciation in asset code configuration$")
	public void enter_the_basis_for_depriciation_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation()
				.sendKeys(assetCodeConfigTestData.get("BasisForDepriciation"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation()
				.sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation()
				.sendKeys(Keys.ENTER);
	}

	@And("^enter the depriciaton method in asset code configuration$")
	public void enter_the_depriciaton_method_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(assetCodeConfigTestData.get("DepriciationMethod"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(Keys.ENTER);
	}

	@And("^enter the depriciation rounding method in asset code configuration$")
	public void enter_the_depriciation_rounding_method_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod()
				.sendKeys(assetCodeConfigTestData.get("DepriciationRoundingMethod"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod()
				.sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod()
				.sendKeys(Keys.ENTER);
	}

	@Then("^verify asset code config record got submitted and store the reviewer ID$")
	public void verify_asset_code_config_record_got_submitted_and_store_the_reviewer_id() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelData.updateTestData(assetCodeConfigTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^save the asset code configuration record$")
	public void save_the_asset_code_configuration_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		for (int i = 0; i <= 300; i++) {
			try {
				clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsSaveButton());
				clickAndActionsHelper.clickUsingActionClass(kubsCommonWebObj.kubsSaveButton(),
						kubsCommonWebObj.kubsSaveButton());
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());

				}
			}
		}

	}

	@Then("^validate record got save in maker stage$")
	public void validate_record_got_save_in_maker_stage() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsToastAlert());
		Assert.assertEquals(kubsCommonWebObj.kubsToastAlert().getText(),
				"Workflow initiated submit record from inbox.");
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.clickUsingActionClass(kubsCommonWebObj.kubsAlertClose(),
						kubsCommonWebObj.kubsAlertClose());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on notification icon in maker stage$")
	public void click_on_notification_icon_in_maker_stage() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsNotificationIcon());
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsNotificationIcon());
				clickAndActionsHelper.clickOnElement(kubsCommonWebObj.kubsNotificationIcon());
				break;
			} catch (Exception e) {
				if (i > 20 && i < 50) {
					javascriptHelper.JSEClick(kubsCommonWebObj.kubsNotificationIcon());
					break;
				}
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^search the asset code config module code in notification$")
	public void search_the_asset_code_config_module_code_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSearchEventCode());
		// assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetCodeConfigTestData.get("ModuleCode"));

	}

	@And("^store the asset code reference number in excel file$")
	public void store_the_asset_code_reference_number_in_excel_file() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecordReferenceNo());
		System.out.println("DataSet ID " + assetCodeConfigTestData.get("DataSet ID"));
		excelData.updateTestData(assetCodeConfigTestData.get("DataSet ID"), "Reference ID",
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecordReferenceNo().getText());
	}

	@And("^select the asset code configuration record$")
	public void select_the_asset_code_configuration_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecord());
		fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecord().click();
	}

	@And("^click on submit in asset code configuration record$")
	public void click_on_submit_in_asset_code_configuration_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSubmitButton());
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset code configuration record$")
	public void enter_the_alert_remark_in_asset_code_configuration_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
		clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clickAndActionsHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCodeConfigTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset code configuration$")
	public void click_on_alert_submit_in_asset_code_configuration() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertSubmit());
		try {
			kubsCommonWebObj.kubsAlertSubmit().click();
		} catch (Exception e) {
			kubsCommonWebObj.kubsAlertRemark().click();
			kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCodeConfigTestData.get("MakerAlertRemark"));
			kubsCommonWebObj.kubsAlertSubmit().click();
		}
	}

	@Then("^verify approved asset code appear in aset code config list view$")
	public void verify_approved_asset_code_appear_in_aset_code_config_list_view() throws Throwable {
		String xpath = "//span[contains(text(),' " + assetCodeConfigTestData.get("AssetCode") + " ')]";
		for (int i = 0; i <= 100; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
						"Asset code is not getting reflected");
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset code in asset gl Configuration database$")
	public void store_the_asset_code_in_asset_gl_configuration_database() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		// Update Data Set 1
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset ammendment$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_ammendment() throws Throwable {
		// Update Data Set 1
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset revaluation$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_revaluation() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));

	}

	@And("^store the asset code in asset gl Configuration database for asset transfer and undetaking$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_transfer_and_undetaking()
			throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset allocation$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_allocation() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		// Update Data Set 1
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database to do impairment$")
	public void store_the_asset_code_in_asset_gl_configuration_database_to_do_impairment() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset return$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_return() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData(assetCodeConfigTestData.get("Update Data Set 1"), "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));

	}

	@And("^get the asset code for report$")
	public void get_the_asset_code_for_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigListViewApprovedAssetRecord());
		String approvedAssetCode = fixedAsset_AssetCodeConfigurationObj.assetCodeConfigListViewApprovedAssetRecord()
				.getText();
		assetCodeConfigReportTestData.put("approvedAssetCode", approvedAssetCode);

	}

	@And("^get the asset depriciation method for report$")
	public void get_the_asset_depriciation_method_for_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigListViewApprovedAssetDepriciationType());
		String approvedAssetDepriciationType = fixedAsset_AssetCodeConfigurationObj
				.assetCodeConfigListViewApprovedAssetDepriciationType().getText();
		assetCodeConfigReportTestData.put("approvedAssetDepriciationType", approvedAssetDepriciationType);
	}

	@And("^click on temp view of asset code report$")
	public void click_on_temp_view_of_asset_code_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAssetCodeReportTempView());
		kubsCommonWebObj.kubsAssetCodeReportTempView().click();
	}

	@And("^enter the asset depriciation method in asset code report$")
	public void enter_the_asset_depriciation_method_in_asset_code_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeReportDepriciationMethod());
		fixedAsset_AssetCodeConfigurationObj.assetCodeReportDepriciationMethod().click();
		fixedAsset_AssetCodeConfigurationObj.assetCodeReportDepriciationMethod()
				.sendKeys(assetCodeConfigReportTestData.get("approvedAssetDepriciationType"));
		fixedAsset_AssetCodeConfigurationObj.assetCodeReportDepriciationMethod().sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.assetCodeReportDepriciationMethod().sendKeys(Keys.ENTER);
	}

	@And("^enter the asset code as on date in asset code report$")
	public void enter_the_asset_code_as_on_date_in_asset_code_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeReportAssetCodeAsOndate());
		fixedAsset_AssetCodeConfigurationObj.assetCodeReportAssetCodeAsOndate().click();
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

		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clickAndActionsHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
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
				clickAndActionsHelper.doubleClick(FinalDay);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());

				}
			}
		}
	}

	@Then("^validate the asset code should reflect in asset code report$")
	public void validate_the_asset_code_should_reflect_in_asset_code_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String xpath = "//div[contains(text(),'" + assetCodeConfigReportTestData.get("approvedAssetCode") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(validation);
				System.out.println("Validation Succesfully done");
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
