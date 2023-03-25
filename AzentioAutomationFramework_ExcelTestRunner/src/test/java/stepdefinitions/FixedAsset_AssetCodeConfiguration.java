package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetCodeConfigurationObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetCodeConfiguration extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCodeConfigurationObj fixedAsset_AssetCodeConfigurationObj = new FixedAsset_AssetCodeConfigurationObj(
			driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader
			.getAssetCategoryByName("Maker");
	String AssetCode;
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	Map<String, String> assetCodeConfigTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonWebObj = new KUBS_CommonWebElements(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();

	@And("^get the active asset code in asset category module$")
	public void get_the_active_asset_code_in_asset_category_module() throws Throwable {
		waithelper.waitForElementVisible(
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")), 3000, 300);
		// driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
		codeConfigData.put("AssetCode",
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
		System.out.println(
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
	}

	@Then("^Click on Asset code configuration Eye button$")
	public void click_on_asset_code_configuration_eye_button() {
		// Eye Button
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon().click();

	}

	@Then("^Fill Asset code configuration Mandatory fields$")
	public void fill_asset_code_configuration_mandatory_fields() throws InterruptedException {

		fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");

		// Asset Code
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode()
				.sendKeys(codeConfigData.get("AssetCode"));
		Thread.sleep(1000);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().sendKeys(Keys.ENTER);

		// AccountingModel
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.AccountingModel);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.ENTER);

		// AssetLifeUnit
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.AssetLifeUnit);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().sendKeys(Keys.ENTER);

		// AssetLife
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.AssetLife);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().sendKeys(Keys.ENTER);

		// BasisForDeperciation
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.BasisForDeperciation);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation()
				.sendKeys(Keys.ENTER);

		// DeperciationMethod
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.DeperciationMethod);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(Keys.ENTER);

		// DeperciationRoundingMethod
		waithelper.waitForElement(driver, 4000,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod());
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod()
				.sendKeys(fixedAsset_AssetCategoryTestDataType.DeperciationRoundingMethod);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod()
				.sendKeys(Keys.ENTER);

	}

	// New
	@And("^get the test data for asset code configuration$")
	public void get_the_test_data_for_asset_code_configuration() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D1");
	}

	@And("^get the test data for asset code configuration for asset ammendment$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_ammendment() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D5");
	}

	@And("^get the test data for asset code configuration for asset return$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_return() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D3");
	}

	@And("^get the test data for asset code configuration to do impairment$")
	public void get_the_test_data_for_asset_code_configuration_to_do_impairment() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D2");
	}

	@And("^get the test data for asset code configuration for asset allocation$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_allocation() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D4");
	}

	@And("^get the test data for asset code configuration for asset revaluation$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_revaluation() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D6");
	}

	@And("^get the test data for asset code configuration for asset transfer and undetaking$")
	public void get_the_test_data_for_asset_code_configuration_for_asset_transfer_and_undetaking() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_002_003_D7");
	}

	@And("^enter the asset code in asset code configuration$")
	public void enter_the_asset_code_in_asset_code_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().click();
		System.out.println("Asset Code "+assetCodeConfigTestData.get("AssetCode"));
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
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCodeConfigTestData.get("AssetCode") + "']";
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
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel()
				.sendKeys(assetCodeConfigTestData.get("AccountingModel"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.ENTER);
	}

	@And("^enter the asset life unit in asset code configuration$")
	public void enter_the_asset_life_unit_in_asset_code_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit()
				.sendKeys(assetCodeConfigTestData.get("AssetLifeUnit"));
		for (int i = 0; i <= 20; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(
						By.xpath("//span[text()='" + assetCodeConfigTestData.get("AssetLifeUnit") + "']")));
				clickAndActionsHelper.clickOnElement(driver.findElement(
						By.xpath("//span[text()='" + assetCodeConfigTestData.get("AssetLifeUnit") + "']")));
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
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife()
				.sendKeys(assetCodeConfigTestData.get("AssetLife"));
	}

	@And("^enter the basis for depriciation in asset code configuration$")
	public void enter_the_basis_for_depriciation_in_asset_code_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().click();
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(assetCodeConfigTestData.get("DepriciationMethod"));
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().sendKeys(Keys.DOWN);
		fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod()
				.sendKeys(Keys.ENTER);
	}

	@And("^enter the depriciation rounding method in asset code configuration$")
	public void enter_the_depriciation_rounding_method_in_asset_code_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod(), 20,
				1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 60, 1);
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelData.updateTestData(assetCodeConfigTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^save the asset code configuration record$")
	public void save_the_asset_code_configuration_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSaveButton(), 20, 1);
		kubsCommonWebObj.kubsSaveButton().click();
	}

	@Then("^validate record got save in maker stage$")
	public void validate_record_got_save_in_maker_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonWebObj.kubsToastAlert().getText(),
				"Workflow initiated submit record from inbox.");
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertClose(), 20, 1);
		clickAndActionsHelper.clickUsingActionClass(kubsCommonWebObj.kubsAlertClose(),
				kubsCommonWebObj.kubsAlertClose());

	}

	@And("^click on notification icon in maker stage$")
	public void click_on_notification_icon_in_maker_stage() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsNotificationIcon(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSearchEventCode(), 20, 1);
		// assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetCodeConfigTestData.get("ModuleCode"));

	}

	@And("^store the asset code reference number in excel file$")
	public void store_the_asset_code_reference_number_in_excel_file() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecordReferenceNo(), 20, 1);

		excelData.updateTestData(assetCodeConfigTestData.get("DataSet ID"), "Reference ID",
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecordReferenceNo().getText());
	}

	@And("^select the asset code configuration record$")
	public void select_the_asset_code_configuration_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecord(), 20, 1);
		fixedAsset_AssetCodeConfigurationObj.assetCodeConfigNotificationRecord().click();
	}

	@And("^click on submit in asset code configuration record$")
	public void click_on_submit_in_asset_code_configuration_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSubmitButton(), 20, 1);
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset code configuration record$")
	public void enter_the_alert_remark_in_asset_code_configuration_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertRemark(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clickAndActionsHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCodeConfigTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset code configuration$")
	public void click_on_alert_submit_in_asset_code_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertSubmit(), 20, 1);
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
		String xpath = "//span[text()=' " + assetCodeConfigTestData.get("AssetCode") + " ']";
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
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D1", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset ammendment$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_ammendment() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D5", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset revaluation$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_revaluation() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D6", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset transfer and undetaking$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_transfer_and_undetaking()
			throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D7", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset allocation$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_allocation() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D4", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database to do impairment$")
	public void store_the_asset_code_in_asset_gl_configuration_database_to_do_impairment() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D2", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset gl Configuration database for asset return$")
	public void store_the_asset_code_in_asset_gl_configuration_database_for_asset_return() throws Throwable {
		ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
		exceldataforGLConfig.updateTestData("KUBS_FAT_UAT_002_004_D3", "AssetCode",
				assetCodeConfigTestData.get("AssetCode"));
	}
}
