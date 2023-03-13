package stepdefinitions;

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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FixedAsset_AssetGlConfigurationObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetGlConfiguration extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetGlConfigurationObj fixedAsset_AssetGlConfigurationObj = new FixedAsset_AssetGlConfigurationObj(
			driver);
	FIXEDASSET_fixedAssetObj fixedAssetAccObj = new FIXEDASSET_fixedAssetObj(driver);
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	ExcelData excelDataForGlSerialNum = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	ExcelData excelDatForAssetSale = new ExcelData(excelPath, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDatForAssetReturn = new ExcelData(excelPath, "FixedAsset_AssetReturn", "DataSet ID");
	Map<String, String> glConfigTestData = new HashMap<>();
	Map<String, String> glConfigReportTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	int intTest = 1;
	Map<String, String> glAccountingTestData = new HashMap<>();
	BrowserHelper browserHelper = new BrowserHelper(driver);

	@Then("^Click on Asset GL configuration Eye button$")
	public void click_on_asset_gl_configuration_eye_button() {
		// Eye Button
		System.out.println(intTest);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon(), 30, 2);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionsHelper
						.moveToElement(fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon());
				clickAndActionsHelper
						.clickOnElement(fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the transfer asset code in gl config list view$")
	public void search_the_transfer_asset_code_in_gl_config_list_view() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D7");
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 60, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsListViewSearchButton());
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsListViewSearchButton());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.AssetGlConfigurationSearchAssetCode(), 20, 1);
		clickAndActionsHelper.moveToElement(fixedAsset_AssetGlConfigurationObj.AssetGlConfigurationSearchAssetCode());
		clickAndActionsHelper.clickOnElement(fixedAsset_AssetGlConfigurationObj.AssetGlConfigurationSearchAssetCode());
		fixedAsset_AssetGlConfigurationObj.AssetGlConfigurationSearchAssetCode()
				.sendKeys(glConfigTestData.get("AssetCode"));

	}

	@And("^get the active asset code in asset category modules$")
	public void get_the_active_asset_code_in_asset_category_modules() throws Throwable {
		waithelper.waitForElementVisible(
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")), 3000, 300);
		// driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
		codeConfigData.put("AssetCode",
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
		System.out.println(
				driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());

	}

	// New
	@And("^get the testData for fixed asset gl configuration module$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");
	}

	@And("^get the testData for fixed asset gl configuration module for asset sold accounting entries$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_sold_accounting_entries()
			throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");
	}

	@And("^get the testData for fixed asset gl configuration module for asset ammendment$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_ammendment() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D5");
	}

	@And("^get the testData for fixed asset gl configuration module for asset revaluation$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_revaluation() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D6");
	}

	@And("^get the testData for fixed asset gl configuration module for asset transfer and undertaking$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_transfer_and_undertaking()
			throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D7");
	}

	@And("^get the testData for fixed asset gl configuration module for asset allocation$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_allocation() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D4");
	}

	@And("^get the testData for fixed asset gl configuration module for asset return$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_return() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D3");
	}

	@And("^get the testData for fixed asset gl configuration module to do asset impairment$")
	public void get_the_testdata_for_fixed_asset_gl_configuration_module_to_do_asset_impairment() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D2");
	}

	@And("^select the data from the asset code in fixed asset gl configuration$")
	public void select_the_data_from_the_asset_code_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("AssetCode") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode()
				.sendKeys(glConfigTestData.get("AssetCode"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the fixed asset Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_fixed_asset_gl_in_fixed_asset_gl_configuration() throws Throwable {
		//ng-dropdown-panel//span[contains(text(),'Vault Cash')]
		String xpath = "//ng-dropdown-panel//span[contains(text(),'"+glConfigTestData.get("FixedAssetGl")+"')]";
		
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL()
				.sendKeys(glConfigTestData.get("FixedAssetGl"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the accumlated Depreceiation Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_accumlated_depreceiation_gl_in_fixed_asset_gl_configuration()
			throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'"+ glConfigTestData.get("AccumulatedDepreciationGL") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL()
				.sendKeys(glConfigTestData.get("AccumulatedDepreciationGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the Depreceiation Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_depreceiation_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("DepreciationGL") +  "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL()
				.sendKeys(glConfigTestData.get("DepreciationGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the profit on slae Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_profit_on_slae_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'"  + glConfigTestData.get("ProfitOnSaleGL") +  "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL()
				.sendKeys(glConfigTestData.get("ProfitOnSaleGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the Loss on sale Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_loss_on_sale_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath =  "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("LossOnSaleGL") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL()
				.sendKeys(glConfigTestData.get("LossOnSaleGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the Write off Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_write_off_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("WriteOffGl") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL()
				.sendKeys(glConfigTestData.get("WriteOffGl"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the impairement loss Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_impairement_loss_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath =  "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("ImpairmentLossGL") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
				.sendKeys(glConfigTestData.get("ImpairmentLossGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i > 10 && i < 500) {
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
							.sendKeys(Keys.DOWN);
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
							.sendKeys(Keys.ENTER);
					break;
				}
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the accumlated impairement loss Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_accumlated_impairement_loss_gl_in_fixed_asset_gl_configuration()
			throws Throwable {
		String xpath = "//ng-dropdown-panel//span[contains(text(),'"+ glConfigTestData.get("AccumulatedImpairmentLossGL")
				+  "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL(), 20,
				1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL()
				.sendKeys(glConfigTestData.get("AccumulatedImpairmentLossGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the Revaluation surplus Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_revaluation_surplus_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath =  "//ng-dropdown-panel//span[contains(text(),'" + glConfigTestData.get("RevaluationSurplusGL") + "')]";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
				.sendKeys(glConfigTestData.get("RevaluationSurplusGL"));
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i < 5 && i > 500) {
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
							.sendKeys(Keys.DOWN);
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
							.sendKeys(Keys.ENTER);
					break;
				}
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^save the fixed asset gl configuration Gl Record$")
	public void save_the_fixed_asset_gl_configuration_gl_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset gl configuration module code in notification$")
	public void search_the_seet_gl_configuration_module_code_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		// assetSaleTestData.get("Remark")
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(glConfigTestData.get("ModuleCode"));
	}

	@And("^store the fixed asset gl configuration record reference number in excel data base and select the record$")
	public void store_the_fixed_asset_gl_configuration_record_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLConfigNotificationRecordReferenceNo(), 20, 1);
		exceldataforGLConfig.updateTestData(glConfigTestData.get("DataSet ID"), "Reference ID",
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLConfigNotificationRecordReferenceNo()
						.getText());

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLConfigNotificationRecord(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLConfigNotificationRecord().click();

	}

	@And("^click on submit button in fixed asset gl configuration$")
	public void click_on_submit_button_in_fixed_asset_gl_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 60, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in fixed asset gl configuration$")
	public void enter_the_alert_remark_in_fixed_asset_gl_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				kubsCommonObj.kubsAlertRemark().click();
				kubsCommonObj.kubsAlertRemark().sendKeys(glConfigTestData.get("MakerAlertRemark"));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on alert submit in fixed asset gl config$")
	public void click_on_alert_submit_in_fixed_asset_gl_config() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		try {
			kubsCommonObj.kubsAlertSubmit().click();
		} catch (Exception e) {
			kubsCommonObj.kubsAlertRemark().click();
			kubsCommonObj.kubsAlertRemark().sendKeys(glConfigTestData.get("MakerAlertRemark"));
			kubsCommonObj.kubsAlertSubmit().click();
		}
	}

	@Then("^validate the submit and store the reviewer ID in database in gl config$")
	public void validate_the_submit_and_store_the_reviewer_id_in_database_in_gl_config() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		exceldataforGLConfig.updateTestData(glConfigTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@Then("^verify approved asset reference number is reflected in gl config list view$")
	public void verify_approved_asset_reference_number_is_reflected_in_gl_config_list_view() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
				+ glConfigTestData.get("AssetCode") + " ')]";
		for (int i = 0; i <= 100; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
						" GL Asset Reference number is not reflected " + glConfigTestData.get("AssetCode"));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset reference number in gl serial number config excel database$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database() throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D1", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database for asset allocation$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_allocation()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D4", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database for asset ammendment$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_ammendment()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D5", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database for asset revaluation$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_revaluation()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D6", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database for asset transfer and undertaking$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_transfer_and_undertaking()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D7", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database for asset return$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_return()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D3", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^store the asset reference number in gl serial number config excel database to do asset impairment$")
	public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_to_do_asset_impairment()
			throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D2", "AssetCode",
				glConfigTestData.get("AssetCode"));
	}

	@And("^click on search button ion gl list view$")
	public void click_on_search_button_ion_gl_list_view() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsListViewSearchButton());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsListViewSearchButton());

	}

	@And("^get the test data for asset sale with high price from excel database for extracking the asset gl code$")
	public void get_the_test_data_for_asset_sale_with_high_price_from_excel_database_for_extracking_the_asset_gl_code()
			throws Throwable {
		glConfigTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_001_01_D1");
	}

	@And("^search the asset code in gl list view$")
	public void search_the_asset_code_in_gl_list_view() throws Throwable {
		String assetCode = glConfigTestData.get("AssetCode");
		System.out.println("Asset Code " + assetCode);
		String[] splitCode = assetCode.split("-");
		String astCode = splitCode[0] + "-" + splitCode[1];

		System.out.println("Splitted Gl Code" + splitCode[0] + "-" + splitCode[1] + " aset code " + astCode);
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetAccObj.fixedAssetGlSearchAssetCode(), 20, 1);
		clickAndActionsHelper.moveToElement(fixedAssetAccObj.fixedAssetGlSearchAssetCode());
		clickAndActionsHelper.clickOnElement(fixedAssetAccObj.fixedAssetGlSearchAssetCode());
		fixedAssetAccObj.fixedAssetGlSearchAssetCode().sendKeys(astCode);
		System.out.println("Asset Code " + glConfigTestData.get("AssetCode"));
	}

	@Then("^store the gl code for verify accounnt entries$")
	public void store_the_gl_code_for_verify_accounnt_entries() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetAccObj.fixedAssetApprovedGl(), 20, 1);
		String glCode = fixedAssetAccObj.fixedAssetApprovedGl().getText();

		System.out.println("Gl Code " + glCode);
		glAccountingTestData.put("glCode", glCode);

	}

	@And("^get the test data for accounting entries test case for asset return$")
	public void get_the_test_data_for_accounting_entries_test_case_for_asset_return() throws Throwable {

		glAccountingTestData = excelDatForAssetReturn.getTestdata("KUBS_FAT_UAT_007_001_01_D10");
	}

	@And("^choose branch as azentio main in accounting entries screen$")
	public void choose_branch_as_azentio_main_in_accounting_entries_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetAccObj.fixedAssetAccountingEntriesBranchCode(), 20, 1);
		fixedAssetAccObj.fixedAssetAccountingEntriesBranchCode().click();
		fixedAssetAccObj.fixedAssetAccountingEntriesBranchCode().sendKeys("AZENTMAIN-Azentio Main Branch");

		fixedAssetAccObj.fixedAssetAccountingEntriesBranchCode().sendKeys(Keys.DOWN);
		fixedAssetAccObj.fixedAssetAccountingEntriesBranchCode().sendKeys(Keys.ENTER);

	}

	@And("^enter the accounting gl in accounting entries screen$")
	public void enter_the_accounting_gl_in_accounting_entries_screen() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetAccObj.fixedAssetAccountingEntriesGlCode(),
				20, 1);
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().click();
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().sendKeys(glAccountingTestData.get("glCode"));
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().sendKeys(Keys.DOWN);
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().sendKeys(Keys.ENTER);
	}

	@And("^enter the accounting gl in accounting entries screen after vendor payment$")
	public void enter_the_accounting_gl_in_accounting_entries_screen_after_vendor_payment() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetAccObj.fixedAssetAccountingEntriesGlCode(),
				20, 1);
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().click();
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode()
				.sendKeys(glAccountingTestData.get("GlCodeForAccountingEntries"));
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().sendKeys(Keys.DOWN);
		fixedAssetAccObj.fixedAssetAccountingEntriesGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click on view button in accounting entries screen$")
	public void click_on_view_button_in_accounting_entries_screen() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetAccObj.fixedAssetAccountingEntriesViewButton(), 20, 1);

		fixedAssetAccObj.fixedAssetAccountingEntriesViewButton().click();

	}

	@Then("^verify no accounting entries should posted for before vendor payment$")
	public void verify_no_accounting_entries_should_posted_for_before_vendor_payment() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				boolean displayed = fixedAssetAccObj.fixedAsset_AccountingEntriesNoDataValidation().isDisplayed();
				break;
			} catch (Exception e) {
				
			}
		}
	}

	@Then("^verify the sold at high price asset gl code should populate in accounting entries screen$")
	public void verify_the_sold_at_high_price_asset_gl_code_should_populate_in_accounting_entries_screen()
			throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				boolean displayed = driver.findElement(By.xpath("//datatable-row-wrapper[1]//span[contains(text(),'"
						+ glAccountingTestData.get("glCode") + "')]")).isDisplayed();
				System.out.println("gl code status " + displayed);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify after payment gl code should display under accounting entries screen$")
	public void verify_after_payment_gl_code_should_display_under_accounting_entries_screen() throws Throwable {
		for (int i = 0; i <= 50; i++) {
			try {
				boolean displayed = driver.findElement(By.xpath("//datatable-row-wrapper[1]//span[contains(text(),'"
						+ glAccountingTestData.get("GlCodeForAccountingEntries") + "')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i == 50) {

				}
			}
		}
	}

	@And("^get the approved asset code for asset gl report$")
	public void get_the_approved_asset_code_for_asset_gl_report() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLApprovedAssetCode(), 20, 1);
		String approvedGlAssetCode = fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLApprovedAssetCode()
				.getText();
		glConfigReportTestData.put("approvedGlAssetCode", approvedGlAssetCode);

	}

	@And("^click on asset gl report temp view$")
	public void click_on_asset_gl_report_temp_view() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAssetGlReportTempView(), 20, 1);
		kubsCommonObj.kubsAssetGlReportTempView().click();
	}

	@And("^enter the asset code for asset gl report$")
	public void enter_the_asset_code_for_asset_gl_report() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCode(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCode().click();
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCode()
				.sendKeys(glConfigReportTestData.get("approvedGlAssetCode"));
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCode().sendKeys(Keys.DOWN);
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCode().sendKeys(Keys.ENTER);
	}

	@And("^enter the asset gl as on date in asset gl report$")
	public void enter_the_asset_gl_as_on_date_in_asset_gl_report() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCodeAsOnDate(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.assetCodeConfigAssetGLReportAssetCodeAsOnDate().click();
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

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsCalendarMonthYearOption(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
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

	@Then("^validate the approved asset code should reflect in asset gl report$")
	public void validate_the_approved_asset_code_should_reflect_in_asset_gl_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String xpath = "//div[contains(text(),'" + glConfigReportTestData.get("approvedGlAssetCode") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
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
