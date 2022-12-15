package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader
			.getAssetCategoryByName("Maker");
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData exceldataforGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	ExcelData excelDataForGlSerialNum = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	Map<String, String> glConfigTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);

	@Then("^Click on Asset GL configuration Eye button$")
	public void click_on_asset_gl_configuration_eye_button() {
		// Eye Button
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
	@And("^get the testData for fixed asset gl configuration module for asset ammendment$")
    public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_ammendment() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D5");
    }
	@And("^get the testData for fixed asset gl configuration module for asset revaluation$")
    public void get_the_testdata_for_fixed_asset_gl_configuration_module_for_asset_revaluation() throws Throwable {
		glConfigTestData = exceldataforGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D6");
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
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("AssetCode") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode()
				.sendKeys(glConfigTestData.get("AssetCode"));
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

	@And("^select the data from the fixed asset Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_fixed_asset_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("FixedAssetGl") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL()
				.sendKeys(glConfigTestData.get("FixedAssetGl"));
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

	@And("^select the data from the accumlated Depreceiation Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_accumlated_depreceiation_gl_in_fixed_asset_gl_configuration()
			throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("AccumulatedDepreciationGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL()
				.sendKeys(glConfigTestData.get("AccumulatedDepreciationGL"));
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

	@And("^select the data from the Depreceiation Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_depreceiation_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("DepreciationGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL()
				.sendKeys(glConfigTestData.get("DepreciationGL"));
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

	@And("^select the data from the profit on slae Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_profit_on_slae_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("ProfitOnSaleGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL()
				.sendKeys(glConfigTestData.get("ProfitOnSaleGL"));
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

	@And("^select the data from the Loss on sale Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_loss_on_sale_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("LossOnSaleGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL()
				.sendKeys(glConfigTestData.get("LossOnSaleGL"));
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

	@And("^select the data from the Write off Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_write_off_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("WriteOffGl") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL()
				.sendKeys(glConfigTestData.get("WriteOffGl"));
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

	@And("^select the data from the impairement loss Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_impairement_loss_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("ImpairmentLossGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
				.sendKeys(glConfigTestData.get("ImpairmentLossGL"));
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i > 10 && i < 200) {
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
							.sendKeys(Keys.DOWN);
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL()
							.sendKeys(Keys.ENTER);
					break;
				}
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the data from the accumlated impairement loss Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_accumlated_impairement_loss_gl_in_fixed_asset_gl_configuration()
			throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("AccumulatedImpairmentLossGL")
				+ "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL(), 20,
				1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL()
				.sendKeys(glConfigTestData.get("AccumulatedImpairmentLossGL"));
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

	@And("^select the data from the Revaluation surplus Gl in fixed asset gl configuration$")
	public void select_the_data_from_the_revaluation_surplus_gl_in_fixed_asset_gl_configuration() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + glConfigTestData.get("RevaluationSurplusGL") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL(), 20, 1);
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().click();
		fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
				.sendKeys(glConfigTestData.get("RevaluationSurplusGL"));
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i < 5 && i > 200) {
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
							.sendKeys(Keys.DOWN);
					fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL()
							.sendKeys(Keys.ENTER);
					break;
				}
				if (i == 200) {
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
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
		String xpath = "//datatable-row-wrapper[1]//datatable-body-cell[2]//span[text()=' "
				+ glConfigTestData.get("AssetCode") + " ']";
		for (int i = 0; i <= 50; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
						" GL Asset Reference number is not reflected " + glConfigTestData.get("AssetCode"));
				break;
			} catch (Exception e) {
				if (i == 50) {
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
    public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_allocation() throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D4", "AssetCode",
				glConfigTestData.get("AssetCode"));
    }@And("^store the asset reference number in gl serial number config excel database for asset ammendment$")
    public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_ammendment() throws Throwable {
    	excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D5", "AssetCode",
				glConfigTestData.get("AssetCode"));
    }
    @And("^store the asset reference number in gl serial number config excel database for asset revaluation$")
    public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_revaluation() throws Throwable {
    	excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D6", "AssetCode",
				glConfigTestData.get("AssetCode"));
    }
	@And("^store the asset reference number in gl serial number config excel database for asset return$")
    public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_for_asset_return() throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D3", "AssetCode",
				glConfigTestData.get("AssetCode"));
    }
	@And("^store the asset reference number in gl serial number config excel database to do asset impairment$")
    public void store_the_asset_reference_number_in_gl_serial_number_config_excel_database_to_do_asset_impairment() throws Throwable {
		excelDataForGlSerialNum.updateTestData("KUBS_FAT_UAT_002_005_D2", "AssetCode",
				glConfigTestData.get("AssetCode"));
    }
}
