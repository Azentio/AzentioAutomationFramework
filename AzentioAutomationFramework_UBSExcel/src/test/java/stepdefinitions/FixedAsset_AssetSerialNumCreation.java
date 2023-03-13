package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetSerialNumCreationObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetSerialNumCreation extends BaseClass {

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetSerialNumCreationObj fixedAsset_AssetSerialNumCreationObj = new FixedAsset_AssetSerialNumCreationObj(
			driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = new FixedAsset_AssetCategoryTestDataType();
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelTestDataaForAssetSerialNumber = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig",
			"DataSet ID");
	Map<String, String> assetSerialNumberTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData excelDataForAssetCreation = new ExcelData(excelPath, "FixedAsset_AssetCreation", "DataSet ID");

	@Then("^Click on Asset Serial Num Creation Eye button$")
	public void click_on_asset_serial_num_creation_eye_button() {
		// Eye Button
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(
						fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon());
				fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^get the test data for asset serial number setup from excel database$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database() throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D1");
	}

	@And("^get the test data for asset serial number setup from excel database for asset ammendment$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_for_asset_ammendment()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D5");
	}

	@And("^get the test data for asset serial number setup from excel database for asset allocation$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_for_asset_allocation()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D4");
	}

	@And("^get the test data for asset serial number setup from excel database for asset revaluation$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_for_asset_revaluation()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D6");
	}

	@And("^get the test data for asset serial number setup from excel database for asset transfer and undertaking$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_for_asset_transfer_and_undertaking()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D7");
	}

	@And("^get the test data for asset serial number setup from excel database to do asset impairment$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_to_do_asset_impairment()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D2");
	}

	@And("^get the test data for asset serial number setup from excel database for asset return$")
	public void get_the_test_data_for_asset_serial_number_setup_from_excel_database_for_asset_return()
			throws Throwable {
		assetSerialNumberTestData = excelTestDataaForAssetSerialNumber.getTestdata("KUBS_FAT_UAT_002_005_D3");
	}

	@And("^select the asset code record which is newly completed asset gl configuration$")
	public void select_the_asset_code_record_which_is_newly_completed_asset_gl_configuration() throws Throwable {
		String xpath = "//span[contains(text(),' " + assetSerialNumberTestData.get("AssetCode")
				+ " ')]//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button[2]";
		for (int i = 0; i <= 50; i++) {
			try {
				driver.findElement(By.xpath(xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the asset seria number in asset serail number configuration$")
	public void enter_the_asset_seria_number_in_asset_serail_number_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber(), 20, 1);
		fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().clear();
		fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber()
				.sendKeys(assetSerialNumberTestData.get("SerailNumber"));
	}

	@And("^click on save button in asset serial number configuration$")
	public void click_on_save_button_in_asset_serial_number_configuration() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset asset serail number setup module code in notification$")
	public void search_the_asset_asset_serail_number_setup_module_code_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		// assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetSerialNumberTestData.get("ModuleCode"));
	}

	@And("^store the fixed asset gl serail number setup record reference number in excel data base and select the record$")
	public void store_the_fixed_asset_gl_serail_number_setup_record_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetSerialNumCreationObj.assetSerialNumberReferenceNumber(), 20, 1);
		excelTestDataaForAssetSerialNumber.updateTestData(assetSerialNumberTestData.get("DataSet ID"), "Reference ID",

				fixedAsset_AssetSerialNumCreationObj.assetSerialNumberReferenceNumber().getText());
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAsset_AssetSerialNumCreationObj.assetSerialNumberNotificationFirstRecord(), 20, 1);
		fixedAsset_AssetSerialNumCreationObj.assetSerialNumberNotificationFirstRecord().click();
	}

	@And("^click on submit in asset serail number setup$")
	public void click_on_submit_in_asset_serail_number_setup() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset serial number setup$")
	public void enter_the_alert_remark_in_asset_serial_number_setup() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
				kubsCommonObj.kubsAlertRemark().sendKeys(assetSerialNumberTestData.get("MakerAlerRemark"));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on alert submit in serial number setup$")
	public void click_on_alert_submit_in_serial_number_setup() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		kubsCommonObj.kubsAlertSubmit().click();
	}

	@Then("^validate the submit and store the reviewer ID of asset gl setup in excel database$")
	public void validate_the_submit_and_store_the_reviewer_id_of_asset_gl_setup_in_excel_database() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelTestDataaForAssetSerialNumber.updateTestData(assetSerialNumberTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@Then("^verify approved serial number record should reflect the approved list view$")
	public void verify_approved_serial_number_record_should_reflect_the_approved_list_view() throws Throwable {
		String xpath = "//span[contains(text(),' " + assetSerialNumberTestData.get("AssetCode")
				+ " ')]//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String serialNum = "";
		for (int i = 0; i <= 50; i++) {
			try {
				serialNum = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		Assert.assertEquals(serialNum, assetSerialNumberTestData.get("SerailNumber"));

	}

	@And("^store the asset code in asset creation excel database$")
	public void store_the_asset_code_in_asset_creation_excel_database() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_006_D1", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D1", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D8", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database for asset ammendment$")
	public void store_the_asset_code_in_asset_creation_excel_database_for_asset_ammendment() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D5", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database for asset allocation$")
	public void store_the_asset_code_in_asset_creation_excel_database_for_asset_allocation() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D4", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D4", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database for asset revaluation$")
	public void store_the_asset_code_in_asset_creation_excel_database_for_asset_revaluation() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D6", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database for asset transfer and undertaking$")
	public void store_the_asset_code_in_asset_creation_excel_database_for_asset_transfer_and_undertaking()
			throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D7", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database for asset return$")
	public void store_the_asset_code_in_asset_creation_excel_database_for_asset_return() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D3", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));
	}

	@And("^store the asset code in asset creation excel database to do impairment$")
	public void store_the_asset_code_in_asset_creation_excel_database_to_do_impairment() throws Throwable {
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D2", "AssetCode",
				assetSerialNumberTestData.get("AssetCode"));

	}
	/*
	 * @And("^get the active asset code in asset category moduless$") public void
	 * get_the_active_asset_code_in_asset_category_moduless() throws Throwable {
	 * waithelper.waitForElementVisible( driver.findElement(By.xpath(
	 * "//datatable-row-wrapper[1]//datatable-body-cell[2]//span")), 3000, 300);
	 * driver.findElement(By.xpath(
	 * "//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
	 * codeConfigData.put("AssetCode", driver.findElement(By.xpath(
	 * "//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
	 * 
	 * }
	 */

	/*
	 * @Then("^Click on Asset Serial Num Creation Search icon$") public void
	 * click_on_asset_serial_num_creation_search_icon() { //
	 * waithelper.waitForElementToVisibleWithFluentWait(driver, //
	 * fixedAsset_AssetSerialNumCreationObj.
	 * fixedAsset_AssetSerialNumCreation_SearchIcon(),60,5); for (int i = 0; i < 30;
	 * i++) { try { fixedAsset_AssetSerialNumCreationObj.
	 * fixedAsset_AssetSerialNumCreation_SearchIcon().click(); break; } catch
	 * (Exception e) { if (i == 29) {
	 * Assert.fail("Asset serial number search icon not clicked"); } } }
	 */

}

/*
 * @Then("^Enter Asset code$") public void enter_asset_code() {
 * fixedAsset_AssetCategoryTestDataType =
 * jsonReader.getAssetCategoryByName("Maker"); // Asset code
 * 
 * waithelper.waitForElementToVisibleWithFluentWait(driver,
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_AssetCode(), 60, 5);
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_AssetCode().click(); //
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(
 * fixedAsset_AssetCategoryTestDataType.AssetCode);
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_AssetCode()
 * .sendKeys(codeConfigData.get("AssetCode"));
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(Keys.ENTER);
 * 
 * }
 */

/*
 * @Then("^Click on the record$") public void click_on_the_record() { // Pencil
 * 
 * waithelper.waitForElementToVisibleWithFluentWait(driver,
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_PencilIcon(), 60, 5);
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_PencilIcon().click();
 * 
 * }
 */

/*
 * @Then("^Fill Asset Serial Num Creation Mandatory fields$") public void
 * fill_asset_serial_num_creation_mandatory_fields() throws InterruptedException
 * { fixedAsset_AssetCategoryTestDataType =
 * jsonReader.getAssetCategoryByName("Maker"); // StartSerialNumber
 * 
 * waithelper.waitForElementToVisibleWithFluentWait(driver,
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_StartSerialNumber(), 60, 5);
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_StartSerialNumber().click();
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_StartSerialNumber()
 * .sendKeys(fixedAsset_AssetCategoryTestDataType.StartSerialNumber);
 * fixedAsset_AssetSerialNumCreationObj.
 * fixedAsset_AssetSerialNumCreation_StartSerialNumber().sendKeys(Keys.ENTER);
 * Thread.sleep(2000);
 * 
 * }
 */
