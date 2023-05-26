package stepdefinitions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BUDGET_BudgetDefinitionTestDataType;

public class FixedAsset {
	WebDriver driver = BaseClass.driver;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	BUDGET_BudgetDefinitionTestDataType budgetdata1;
	JavascriptHelper jaascriptHelper = new JavascriptHelper();
	
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_MakerObj makerObj;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	Map<String, String> codeConfigData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonWebObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetCreation = new ExcelData(path, "FixedAsset_AssetCreation", "DataSet ID");
	ExcelData excelDataForAssetSale = new ExcelData(path, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetDeAllocation = new ExcelData(path, "FixedAsset_AssetDeAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetAmmendment = new ExcelData(path, "FixedAsset_AssetAmmendment", "DataSet ID");
	ExcelData excelDataForAssetReplacement = new ExcelData(path, "FixedAsset_AssetReplacement", "DataSet ID");
	ExcelData excelDataForAssetTransfer = new ExcelData(path, "FixedAsset_AssetTransfer", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(path, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataAssetCreationForTransfer = new ExcelData(path, "AssetTransfer_ExecutionTracker", "TestCaseID");
	ExcelData excelDataAssetCreationForImpairement = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetCreationForRevaluation = new ExcelData(path, "AssetRevaluation_ExecutionTrack", "TestCaseID");
	Map<String, String> dataSetID = new HashMap<>();
	Map<String, String> assetCreationTestData = new HashMap<>();
	Map<String, String> assetAllocationTestData = new HashMap<>();
	Map<String, String> assetAllocationReportTestData = new HashMap<>();
	Map<String, String> assetCreationReportTestData = new HashMap<>();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	
	@Given("^Maker Navigate to UAT URL login$")
	public void maker_navigate_to_uat_url_login() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
	}

	@And("^click on configuration section$")
	public void click_on_configuration_section() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsConfigurationSection());
	}

	@And("^click on transaction section$")
	public void click_on_transaction_section() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsTransactionSection());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsConfigurationSection());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsTransactionSection());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsConfigurationSection());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsTransactionSection());

	}

	@Then("^Click on Fixed Asset$")
	public void click_on_fixed_asset() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_Button());
		fixedAssetObj.fixedAsset_Button().click();
	}

	@Then("^Click on Asset Creation Eye button$")
	public void click_on_asset_creation_eye_button() throws Throwable {
		fixedAssetObj.fixedAsset_AssetCreation_EyeButton().click();
	}

	@Then("^Click on Asset Creation Eye button1$")
	public void click_on_asset_creation_eye_button1() throws Throwable {
		fixedAssetObj.fixedAsset_AssetCreation_EyeButton().click();
	}

	@And("^click on search button in asset creation module$")
	public void click_on_search_button_in_asset_creation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.kubsSearchButton());
		for (int i = 0; i <= 50; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.kubsSearchButton());
				clicksAndActionHelper.clickOnElement(fixedAssetObj.kubsSearchButton());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the asset code in asset creation module$")
	public void search_the_asset_code_in_asset_creation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetSearchAssetCode());
		fixedAssetObj.fixedAssetSearchAssetCode().sendKeys(assetCreationTestData.get("AssetCode"));
	}

	@Then("^Click on the add button to add new record$")
	public void click_on_the_add_button_to_add_new_record() throws Throwable {
		for (int i = 0; i <= 200; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCreation_AddButton());
				clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAsset_AssetCreation_AddButton());
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail("Add button not clicked");
				}
			}
		}

	}

	@Then("^verify approved asset creation record is visible under asset creation list view$")
	public void verify_approved_asset_creation_record_is_visible_under_asset_creation_list_view() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode") + " ']";
		for (int i = 0; i <= 500; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
						"Approved asset Code is not reflected in asset creation list view");
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the approved asset reference number record$")
	public void select_the_approved_asset_reference_number_record() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[3]//ion-button[1]";
		for (int i = 0; i <= 500; i++) {
			try {

				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
	}

	@Then("^verify asset item number is visible under the asset item details section$")
	public void verify_asset_item_number_is_visible_under_the_asset_item_details_section() throws Throwable {
		// UpdatedItemNumber
		String xpath = "//datatable-row-wrapper[1]//datatable-body-cell[2]//span[text()=' "
				+ assetCreationTestData.get("UpdatedItemNumber") + " ']";
		for (int i = 0; i <= 100; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(), "Assert Item number not visisble");
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset reference number in asset transfer undertaking excel database$")
	public void store_the_asset_reference_number_in_asset_transfer_undertaking_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset transfer and undertaking excel database$")
	public void store_the_asset_reference_number_in_asset_transfer_and_undertaking_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset impairment excel database for the prerequisite of asset transfer$")
	public void store_the_asset_reference_number_in_asset_impairment_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetImpairment.updateTestData(assetCreationTestData.get("Update Data Set 2"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset revaluation excel database for the prerequisite of asset transfer$")
	public void store_the_asset_reference_number_in_asset_revaluation_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset replacement excel data base$")
	public void store_the_asset_reference_number_in_asset_replacement_excel_data_base() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D6", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset ammenment excel data base$")
	public void store_the_asset_reference_number_in_asset_ammenment_excel_data_base() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D7", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset revaluation excel data base$")
	public void store_the_asset_reference_number_in_asset_revaluation_excel_data_base() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D5", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^Store the asset item number in asset revaluation excel data base$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_data_base() throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D5", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^Store the asset item number in asset ammenment excel data base$")
	public void store_the_asset_item_number_in_asset_ammenment_excel_data_base() throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D7", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^Store the asset item number in asset replacement excel data base$")
	public void store_the_asset_item_number_in_asset_replacement_excel_data_base() throws Throwable {
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D6", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset Transfer excel data base$")
	public void store_the_asset_reference_number_in_asset_transfer_excel_data_base() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D4", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in excel database for prerequisite of asset sale$")
	public void store_the_asset_reference_number_in_excel_database_for_prerequisite_of_asset_sale() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D4", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in excel database for prerequisite of asset sale$")
	public void store_the_asset_item_number_in_excel_database_for_prerequisite_of_asset_sale() throws Throwable {
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^Store the asset item number in asset transfer excel data base$")
	public void store_the_asset_item_number_in_asset_transfer_excel_data_base() throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset impairment excel database for the prerequisite of asset transfer$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData(assetCreationTestData.get("Update Data Set 2"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset revaluation excel database for the prerequisite of asset transfer$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset transfer undertaking excel database$")
	public void store_the_asset_item_number_in_asset_transfer_undertaking_excel_database() throws Throwable {
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset transfer and undertaking excel database$")
	public void store_the_asset_item_number_in_asset_transfer_and_undertaking_excel_database() throws Throwable {
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number number for asset sale in excel database$")
	public void store_the_asset_item_number_number_for_asset_sale_in_excel_database() throws Throwable {
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_001_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset Reference number in asset allocation excel Database$")
	public void store_the_asset_reference_number_in_asset_allocation_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_001_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset return excel database$")
	public void store_the_asset_reference_number_in_asset_return_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D1", "AssetReferenceNumber",
				assetReferenceNumber);

	}

	@And("^store the asset reference number in asset impairment excel database$")
	public void store_the_asset_reference_number_in_asset_impairment_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetImpairment.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetReferenceNumber);

	}

	@And("^store the asset reference number it allocation excel database to make impirement of allocated asset$")
	public void store_the_asset_reference_number_it_allocation_excel_database_to_make_impirement_of_allocated_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset allocation excel Database$")
	public void store_the_asset_item_number_in_asset_allocation_excel_database() throws Throwable {
		excelDataForAssetAllocation.updateTestData(assetCreationTestData.get("Update Data Set 2"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset Reference number in asset revaluation excel Database for asset allocation$")
	public void store_the_asset_reference_number_in_asset_revaluation_excel_database_for_asset_allocation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D4", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset revaluation excel Database for asset allocation$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_database_for_asset_allocation()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset Reference number in asset ammendment excel Database for asset allocation$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database_for_asset_allocation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D5", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset ammendment excel Database for asset allocation$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_asset_allocation() throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D5", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset revaluation excel database$")
	public void store_the_asset_reference_number_in_asset_revaluation_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset impairment excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_impairment_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D3", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset ammendment excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		excelDataForAssetAmmendment.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset replacement excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_replacement_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		excelDataForAssetReplacement.updateTestData(assetCreationTestData.get("Update Data Set 7"), "AssetReferenceNumber",
				assetReferenceNumber);

	}

	@And("^store the asset reference number in asset sale excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_sale_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	
		excelDataForAssetSale.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset return excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_return_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
		excelDataForAssetReturn.updateTestData(assetCreationTestData.get("Update Data Set 6"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset transfer undertaking excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_transfer_undertaking_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 8"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset transfer undertaking excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_transfer_undertaking_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 8"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset Sale excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_sale_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		excelDataForAssetSale.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset return excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_return_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {

		excelDataForAssetReturn.updateTestData(assetCreationTestData.get("Update Data Set 6"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset replacement excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_replacement_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetReplacement.updateTestData(assetCreationTestData.get("Update Data Set 7"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset allocation excel database for prerequisite of asset revaluation$")
	public void store_the_asset_reference_number_in_asset_allocation_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAllocation.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset allocation excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_allocation_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset revaluation excel database$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_database() throws Throwable {
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset impairment excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset ammendment excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset return excel database$")
	public void store_the_asset_item_number_in_asset_return_excel_database() throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset impairment excel database$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database() throws Throwable {
		excelDataForAssetImpairment.updateTestData(assetCreationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number it allocation excel database to make impirement of allocated asset$")
	public void store_the_asset_item_number_it_allocation_excel_database_to_make_impirement_of_allocated_asset()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData(assetCreationTestData.get("Update Data Set 2"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset transfer excel database for prerequiste of asset impairment$")
	public void store_the_asset_reference_number_in_asset_transfer_excel_database_for_prerequiste_of_asset_impairment()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 8"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset transfer excel database for prerequiste of asset impairment$")
	public void store_the_asset_item_number_in_asset_transfer_excel_database_for_prerequiste_of_asset_impairment()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData(assetCreationTestData.get("Update Data Set 8"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
		
	}

	@And("^store the asset reference number in asset replacement excel database$")
	public void store_the_asset_reference_number_in_asset_replacement_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset replacement excel database$")
	public void store_the_asset_item_number_in_asset_replacement_excel_database() throws Throwable {
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset ammendment excel database$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset ammendment excel database for change the asset life$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database_for_change_the_asset_life()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_02_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset ammendment excel database for change the asset asset capitalization date less than given date$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database_for_change_the_asset_asset_capitalization_date_less_than_given_date()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_03_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number in asset ammendment excel database for change the asset asset capitalization date greater than given date$")
	public void store_the_asset_reference_number_in_asset_ammendment_excel_database_for_change_the_asset_asset_capitalization_date_greater_than_given_date()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_04_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset ammendment excel database$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database() throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset ammendment excel database for change the asset life$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_change_the_asset_life()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_02_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset ammendment excel database for change the asset asset capitalization date less than given date$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_change_the_asset_asset_capitalization_date_less_than_given_date()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_03_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset ammendment excel database for change the asset asset capitalization date greater than given date$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_change_the_asset_asset_capitalization_date_greater_than_given_date()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_04_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset revlauation excel database for prerequsite of asset impairment$")
	public void store_the_asset_reference_number_in_asset_revlauation_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset revlauation excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_revlauation_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData(assetCreationTestData.get("Update Data Set 3"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset ammemdment excel database for prerequsite of asset impairment$")
	public void store_the_asset_reference_number_in_asset_ammemdment_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {

		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetReferenceNumber",
				assetReferenceNumber);

	}

	@And("^store the asset item number in asset ammendment excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData(assetCreationTestData.get("Update Data Set 4"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset replacement excel database for prerequsite of asset impairment$")
	public void store_the_asset_reference_number_in_asset_replacement_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset replacement excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_replacement_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetReplacement.updateTestData(assetCreationTestData.get("Update Data Set 5"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset return excel database for prerequsite of asset impairment$")
	public void store_the_asset_reference_number_in_asset_return_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReturn.updateTestData(assetCreationTestData.get("Update Data Set 6"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset return excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_return_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		
		excelDataForAssetReturn.updateTestData(assetCreationTestData.get("Update Data Set 6"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset reference number in asset Sale excel database for prerequsite of asset impairment$")
	public void store_the_asset_reference_number_in_asset_sale_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetSale.updateTestData(assetCreationTestData.get("Update Data Set 7"), "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset Sale excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_sale_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetSale.updateTestData(assetCreationTestData.get("Update Data Set 7"), "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset refeference number in asset revaluation excel database for return revalued asset$")
	public void store_the_asset_refeference_number_in_asset_revaluation_excel_database_for_return_revalued_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D3", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset revaluation excel database for return revalued asset$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_database_for_return_revalued_asset()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset refeference number in asset ammendment excel database for return ammendment asset$")
	public void store_the_asset_refeference_number_in_asset_ammendment_excel_database_for_return_ammendment_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D4", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset ammendment excel database for return ammendment asset$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_return_ammendment_asset()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset refeference number in asset impairment excel database for return impairment asset$")
	public void store_the_asset_refeference_number_in_asset_impairment_excel_database_for_return_impairment_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset impairment excel database for return impaired asset$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database_for_return_impaired_asset()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D2", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset refeference number in asset replacement excel database for return replacement asset$")
	public void store_the_asset_refeference_number_in_asset_replacement_excel_database_for_return_replacement_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D3", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset replacement excel database for return replacement asset$")
	public void store_the_asset_item_number_in_asset_replacement_excel_database_for_return_replacement_asset()
			throws Throwable {
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));

	}

	@And("^store the asset refeference number in asset allocation excel database for return allocation asset$")
	public void store_the_asset_refeference_number_in_asset_allocation_excel_database_for_return_allocation_asset()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D3", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset refeference number in asset undertaking excel databse for for prerequisite of asset undertaking$")
	public void store_the_asset_refeference_number_in_asset_undertaking_excel_databse_for_for_prerequisite_of_asset_undertaking()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D8", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset allocation excel database for return allocation asset$")
	public void store_the_asset_item_number_in_asset_allocation_excel_database_for_return_allocation_asset()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));

	}

	@And("^store the asset item number in asset undertaking excel databse for asset return excel database$")
	public void store_the_asset_item_number_in_asset_undertaking_excel_databse_for_asset_return_excel_database()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D8", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	// New
	@And("^get the test data for asset creation with minimum details from excel data$")
	public void get_the_test_data_for_asset_creation_with_minimum_details_from_excel_data() throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_006_D1");
	}

	@And("^get the test data for asset creation with GRN number from excel database$")
	public void get_the_test_data_for_asset_creation_with_grn_number_from_excel_database() throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D8");
	}

	@And("^get the test data for asset creation with full details from excel data$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data() throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D1");
	}

	@And("^get the test data for asset creation with full details from excel data for asset transfer$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_asset_transfer()
			throws Throwable {
		dataSetID=excelDataAssetCreationForTransfer.getTestdata("KUBS_FAT_UAT_002_007_01_AssetTransfer1");
		assetCreationTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset creation with full details from excel data for prerequisite of asset revaluation$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		dataSetID=excelDataAssetCreationForRevaluation.getTestdata("KUBS_FAT_UAT_002_007_01_AssetRevaluation01");
		assetCreationTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset creation with full details from excel data for prerequisite of asset ammendment$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_prerequisite_of_asset_ammendment()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D5");
	}

	@And("^get the test data for asset creation with full details from excel data for asset allocation$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_asset_allocation()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D4");
	}

	@And("^get the test data for asset creation from excel database to do asset impairment$")
	public void get_the_test_data_for_asset_creation_from_excel_database_to_do_asset_impairment() throws Throwable {
		dataSetID=excelDataAssetCreationForImpairement.getTestdata("KUBS_FAT_UAT_002_007_01_Impairment01");
		assetCreationTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset creation with full details from excel data for asset return$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_asset_return()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D3");
	}

	@And("^select the branch code in asset creation module$")
	public void select_the_branch_code_in_asset_creation_module() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(assetCreationTestData.get("BranchCode"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("BranchCode") + "']";
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the asset code in asset creation module$")
	public void select_the_asset_code_in_asset_creation_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("AssetCode") + "']";
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(assetCreationTestData.get("AssetCode"));
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

	@And("^enter the GRN number in asset creation screen$")
	public void enter_the_grn_number_in_asset_creation_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreationGRNReferenceNumberTextBox());
		fixedAssetObj.fixedAsset_AssetCreationGRNReferenceNumberTextBox().click();
		fixedAssetObj.fixedAsset_AssetCreationGRNReferenceNumberTextBox()
				.sendKeys(assetCreationTestData.get("GRNNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("GRNNumber") + "']";
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

	@And("^click on contract linkage tab$")
	public void click_on_contract_linkage_tab() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreationAssetContractLinkageTab());
		fixedAssetObj.fixedAsset_AssetCreationAssetContractLinkageTab().click();
		fixedAssetObj.fixedAsset_AssetCreationAssetContractLinkageTab();
	}

	@And("^enter the po number in contract linkage screen$")
	public void enter_the_po_number_in_contract_linkage_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreationContractLinkagePoNumberTextBox());
		fixedAssetObj.fixedAsset_AssetCreationContractLinkagePoNumberTextBox().click();
		fixedAssetObj.fixedAsset_AssetCreationContractLinkagePoNumberTextBox()
				.sendKeys(assetCreationTestData.get("PONumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("PONumber") + "']";
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

	@And("^save the contract linkage screen$")
	public void save_the_contract_linkage_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		kubsCommonWebObj.kubsSaveButton().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		String toastAlert = kubsCommonWebObj.kubsToastAlert().getText();
		System.out.println(toastAlert);
		Assert.assertEquals(toastAlert, "AssetContractLinkage created successfully.");
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertClose());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertClose());
	}

	@And("^select the bill reference number in asset creation module$")
	public void select_the_bill_reference_number_in_asset_creation_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("BillReferenceNumber") + "']";
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox()
				.sendKeys(assetCreationTestData.get("BillReferenceNumber"));
		for (int i = 0; i <= 10; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the asset life in asset creation module$")
	public void select_the_asset_life_in_asset_creation_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("AssetLife") + "']";
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit());
		fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().click();

		fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit()
				.sendKeys(assetCreationTestData.get("AssetLife"));
		for (int i = 0; i <= 10; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^save the asset creation record$")
	public void save_the_asset_creation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSaveButton());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSaveButton());

	}

	@And("^search the asset asset creation module code in notification$")
	public void search_the_asset_asset_creation_module_code_in_notification() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
				clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
				kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetCreationTestData.get("ModuleCode"));
				break;
			} catch (Exception e) {
				if (i > 300 && i < 499) {
					clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsNotificationIcon());
					clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsNotificationIcon());
				} else if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^store the fixed asset creation with minimum details reference number in excel data base and select the record$")
	public void store_the_fixed_asset_creation_with_minimum_details_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationReferenceNumber());
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reference ID",
				fixedAssetObj.assetCreationReferenceNumber().getText());
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationNotificationFirstRecord());
		fixedAssetObj.assetCreationNotificationFirstRecord().click();

	}

	@Then("^validate the submit and store the reviewer ID of fixed asset creation with full details in excel database$")
	public void validate_the_submit_and_store_the_reviewer_id_of_fixed_asset_creation_with_full_details_in_excel_database()
			throws Throwable {
		for (int i = 0; i <= 1000; i++) {
			try {
				String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
				excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reviewer ID",
						reviewerID);
				break;
			} catch (Exception e) {
				if (i == 1000) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the fixed asset creation with full details reference number in excel data base and select the record$")
	public void store_the_fixed_asset_creation_with_full_details_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationReferenceNumber());
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reference ID",
				fixedAssetObj.assetCreationReferenceNumber().getText());
//		waithelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationNotificationFirstRecord(),
//				20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				fixedAssetObj.assetCreationNotificationFirstRecord().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on submit in fixed asset creation with full details$")
	public void click_on_submit_in_fixed_asset_creation_with_full_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSubmitButton());
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in fixed asset creation with full details$")
	public void enter_the_alert_remark_in_fixed_asset_creation_with_full_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());

		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCreationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in fixed asset creation with full details$")
	public void click_on_alert_submit_in_fixed_asset_creation_with_full_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertSubmit());

		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonWebObj.kubsAlertSubmit().click();
				break;
			} catch (Exception e) {
				waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
				clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
				clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());

				kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCreationTestData.get("MakerAlertRemark"));
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^validate the submit and store the reviewer ID of fixed asset creation with minimum details in excel database$")
	public void validate_the_submit_and_store_the_reviewer_id_of_fixed_asset_creation_with_minimum_details_in_excel_database()
			throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^Select the asset creation recod in notification$")
	public void select_the_asset_creation_recod_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationNotificationFirstRecord());
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.assetCreationNotificationFirstRecord());

				clicksAndActionHelper.doubleClick(fixedAssetObj.assetCreationNotificationFirstRecord());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on asset Item tab in asset creation$")
	public void click_on_asset_item_tab_in_asset_creation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems());
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems());
				clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on add button in asset item section$")
	public void click_on_add_button_in_asset_item_section() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetAddButton());
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAssetAddButton());
				clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAssetAddButton());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^enter asset item number in asset item creation$")
	public void enter_asset_item_number_in_asset_item_creation() throws Throwable {
		Random random = new Random();
		int randomNumber1 = random.nextInt(100 - 1) + 100;
		int randomNumber2 = random.nextInt(200 - 100) + 200;
		int randomNumber3 = random.nextInt(1000 - 500) + 1000;
		String assetItemNumber = assetCreationTestData.get("AssetItemNumber") + randomNumber1 + randomNumber2
				+ randomNumber3;
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "UpdatedItemNumber",
				assetItemNumber);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber());
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(assetItemNumber);
	}

	@And("^enter asset description in asset item creation$")
	public void enter_asset_description_in_asset_item_creation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription());
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription()
				.sendKeys(assetCreationTestData.get("AssetItemDescription"));
	}

	@And("^select the asset capitalization date in asset item creation$")
	public void select_the_asset_capitalization_date_in_asset_item_creation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar());
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsMonthAndYear());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsMonthAndYear());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsMonthAndYear());

//Year
		String yearXpath = "//owl-date-time-multi-year-view//span[text()='"
				+ assetCreationTestData.get("CapitalizationYear") + "']";
		for (int i = 0; i <= 50; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(yearXpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(yearXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// Month
		String monthXpath = "//owl-date-time-year-view//span[text()='"
				+ assetCreationTestData.get("CapitalizationMonth").substring(0, 3) + "']";
		for (int i = 0; i <= 50; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(monthXpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(monthXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String dayXpath = "//owl-date-time-month-view//td[@aria-label='"
				+ assetCreationTestData.get("CapitalizationMonth") + " "
				+ assetCreationTestData.get("Capitalizationday") + ", "
				+ assetCreationTestData.get("CapitalizationYear") + "']";

		for (int i = 0; i <= 200; i++) {
			try {

				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(dayXpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(dayXpath)));

				break;

			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter HSN Code in asset item creation$")
	public void enter_hsn_code_in_asset_item_creation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetCreation_HSNCode());
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().click();
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(assetCreationTestData.get("HSNCode"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetCreationTestData.get("HSNCode") + "']";
		for (int i = 0; i <= 10; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter asset value in asset item creation$")
	public void enter_asset_value_in_asset_item_creation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetCreation_AssetValue());
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(assetCreationTestData.get("Assetvalue"));
	}

	@And("^save the asset item creation record$")
	public void save_the_asset_item_creation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		kubsCommonWebObj.kubsSaveButton().click();
	}

	// End
	@And("^click on submit in fixed asset creation with minimum details$")
	public void click_on_submit_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSubmitButton());
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in fixed asset creation with minimum details$")
	public void enter_the_alert_remark_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().click();
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCreationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in fixed asset creation with minimum details$")
	public void click_on_alert_submit_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertSubmit());
		kubsCommonWebObj.kubsAlertSubmit().click();
	}

	@And("^store the asset reference number for asset sale in excel database$")
	public void store_the_asset_reference_number_for_asset_sale_in_excel_database() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_001_01_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset reference number for asset sale in excel database for asset sale at low price$")
	public void store_the_asset_reference_number_for_asset_sale_in_excel_database_for_asset_sale_at_low_price()
			throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[2]//span";
		String assetReferenceNumber = "";
		for (int i = 0; i <= 100; i++) {
			try {
				assetReferenceNumber = driver.findElement(By.xpath(xpath)).getText();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D1", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number number for asset sale in excel database for asset sale at low price$")
	public void store_the_asset_item_number_number_for_asset_sale_in_excel_database_for_asset_sale_at_low_price()
			throws Throwable {
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

//new

	@Then("^Save the filled form$")
	public void save_the_filled_form() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetCreation_SaveButton());
		fixedAssetObj.fixedAsset_AssetCreation_SaveButton().click();
		for (int i = 0; i < 90; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated());
				fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated().click();
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 0; i < 90; i++) {
			try {
				fixedAssetObj.fixedAsset_AssetCreation_SuccessMessageClose().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					// Assert.fail("Success message close button not clicked ");
				}
			}
		}
	}


	@Then("^Click on Fixed Asset items$")
	public void click_on_fixed_asset_items() throws Throwable {
	
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems());
		fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems().click();

	}

	@Then("^Click on the add button of asset items$")
	public void click_on_the_add_button_of_asset_items() {
		// Add button
		// waithelper.waitForElementwithFluentwait(driver,fixedAssetObj.fixedAsset_AssetCreation_AddButton(),60,5);
		for (int i = 0; i < 30; i++) {
			try {
				fixedAssetObj.fixedAsset_AssetCreation_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("Add icon not clicked in asset item creation");
				}
			}
		}

	}

	@Then("^Click on save button of item details$")
	public void click_on_save_button_of_item_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetAllocation_SaveButton());
		fixedAssetObj.fixedAsset_AssetAllocation_SaveButton().click();
	
	}

	@And("^click on search in notification section$")
	public void click_on_search_in_notification_section() throws Throwable {
	

		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAssetMailBoxSearchButton());
				
				javascripthelper.JSEClick(fixedAssetObj.fixedAssetMailBoxSearchButton());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	

	@Then("^Click on Asset Allocation Eye button$")
	public void click_on_asset_allocation_eye_button() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300; i++) {
			try {
				javascripthelper.scrollIntoView(fixedAssetObj.fixedAsset_AssetAllocation_EyeButton());
				fixedAssetObj.fixedAsset_AssetAllocation_EyeButton().click();
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	// New start
	@And("^get the asset allocation test data from excel database$")
	public void get_the_asset_allocation_test_data_from_excel_database() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_001_D1");
	}

	@And("^get the asset allocation test data from excel database for prerequisite of asset writeoff$")
	public void get_the_asset_allocation_test_data_from_excel_database_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D11");
	}

	@And("^get the asset allocation test data from excel database for prerequisite of asset deallocation writeoff$")
	public void get_the_asset_allocation_test_data_from_excel_database_for_prerequisite_of_asset_deallocation_writeoff()
			throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D12");
	}

	@And("^get the asset allocation test data from excel database for asset revaluation prerequisite$")
	public void get_the_asset_allocation_test_data_from_excel_database_for_asset_revaluation_prerequisite()
			throws Throwable {
		dataSetID=excelDataAssetCreationForRevaluation.getTestdata("KUBS_FAT_UAT_006_001_01_Revaluation");
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset allocation test data from excel database which is already revalued$")
	public void get_the_asset_allocation_test_data_from_excel_database_which_is_already_revalued() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_004_D1");
	}

	@And("^Get the data set id from asset sale in asset allocation excel data base$")
	public void get_the_data_set_id_from_asset_sale_in_asset_allocation_excel_data_base() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D8");
	}

	@And("^get the asset allocation test data from excel database which is already used$")
	public void get_the_asset_allocation_test_data_from_excel_database_which_is_already_used() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
	}

	@And("^get the asset allocation test data from excel database for asset return prerequsite$")
	public void get_the_asset_allocation_test_data_from_excel_database_for_asset_return_prerequsite() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D3");
	}

	@And("^get the asset allocating test data from excel database for prerequisite of asset impairment$")
	public void get_the_asset_allocating_test_data_from_excel_database_for_prerequisite_of_asset_impairment()
			throws Throwable {
		dataSetID=excelDataAssetCreationForImpairement.getTestdata("KUBS_FAT_UAT_006_001_01_Impairment");
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the asset allocation test data from excel database which the asset is already used$")
	public void get_the_asset_allocation_test_data_from_excel_database_which_the_asset_is_already_used()
			throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
	}

	@And("^get the asset allocation test data from excel database which the asset is already impaired$")
	public void get_the_asset_allocation_test_data_from_excel_database_which_the_asset_is_already_impaired()
			throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D1");
	}

	@And("^Get the data set id from asset replacement in asset allocation excel data base$")
	public void get_the_data_set_id_from_asset_replacement_in_asset_allocation_excel_data_base() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D5");
	}

	@And("^Get the data set id from asset ammenment in asset allocation excel data base$")
	public void get_the_data_set_id_from_asset_ammenment_in_asset_allocation_excel_data_base() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D6");
	}

	@And("^Get the data set id from asset transfer in asset allocation excel data base$")
	public void get_the_data_set_id_from_asset_transfer_in_asset_allocation_excel_data_base() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D7");
	}

	@And("^Get the data set id from asset revalaution in asset allocation excel data base$")
	public void get_the_data_set_id_from_asset_revalaution_in_asset_allocation_excel_data_base() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D9");
	}

	@And("^enter the asset reference number in asset allocation$")
	public void enter_the_asset_reference_number_in_asset_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber()
				.sendKeys(assetAllocationTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAllocationTestData.get("AssetReferenceNumber")
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

	@And("^enter the asset item number in asset allocation$")
	public void enter_the_asset_item_number_in_asset_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(assetAllocationTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAllocationTestData.get("AssetItemNumber") + "']";

		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify item number of sold asset is not reflecting in asset allocation screen$")
	public void verify_item_number_of_sold_asset_is_not_reflecting_in_asset_allocation_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(assetAllocationTestData.get("AssetItemNumber"));

		for (int i = 0; i <= 500; i++) {
			try {
				boolean dropdownVerification = kubsCommonWebObj.kubsDropdownNoItemFound().isDisplayed();
				Assert.assertTrue(dropdownVerification);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify asset reference number or item number is not reflected in asset allocation screen$")
	public void verify_asset_reference_number_or_item_number_is_not_reflected_in_asset_allocation_screen()
			throws Throwable {
		boolean statusOfrefNo = false;
		boolean statusOfItemNo = false;
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber()
				.sendKeys(assetAllocationTestData.get("AssetReferenceNumber"));
		String xpathRefNo = "//ng-dropdown-panel//div[text()='" + assetAllocationTestData.get("AssetReferenceNumber")
				+ "']";

		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpathRefNo)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpathRefNo)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					statusOfrefNo = true;
				}
			}
		}

		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(assetAllocationTestData.get("AssetItemNumber"));
		String xpathItem = "//ng-dropdown-panel//div[text()='" + assetAllocationTestData.get("AssetItemNumber") + "']";

		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpathItem)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpathItem)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					statusOfItemNo = true;
				}
			}
		}
		if (statusOfrefNo == true || statusOfItemNo == true) {
			System.out.println("Expected condition met");
		} else {
			Assert.fail("Expected condition not met hence failed");
		}
	}

	@And("^enter the employee id in asset allocation$")
	public void enter_the_employee_id_in_asset_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID());
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(assetAllocationTestData.get("EmployeeID"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAllocationTestData.get("EmployeeID") + "']";

		for (int i = 0; i <= 10; i++) {
			try {
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^save the asset allocation record$")
	public void save_the_asset_allocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSaveButton());
		kubsCommonWebObj.kubsSaveButton().click();
	}

	@And("^search the asset allocation module code$")
	public void search_the_asset_allocation_module_code() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetAllocationTestData.get("ModuleCode"));
	}

	@And("^store the asset allocation reference number in asset allocation excel data base$")
	public void store_the_asset_allocation_reference_number_in_asset_allocation_excel_data_base() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationReferenceNumber());
		String allocationReferenceNum = fixedAssetObj.assetAllocationReferenceNumber().getText();
		excelDataForAssetAllocation.updateTestData(assetAllocationTestData.get("DataSet ID"), "Reference ID",
				allocationReferenceNum);
	}

	@And("^select the asset allocation record$")
	public void select_the_asset_allocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationNotificationFirstRecord());
		clicksAndActionHelper.moveToElement(fixedAssetObj.assetAllocationNotificationFirstRecord());
		clicksAndActionHelper.clickOnElement(fixedAssetObj.assetAllocationNotificationFirstRecord());

	}

	@And("^enter the submit button in asset allocation module$")
	public void enter_the_submit_button_in_asset_allocation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsSubmitButton());
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset allocation module$")
	public void enter_the_alert_remark_in_asset_allocation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetAllocationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset allocation module$")
	public void click_on_alert_submit_in_asset_allocation_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAlertSubmit());
		kubsCommonWebObj.kubsAlertSubmit().click();
	}

	@Then("^store the reviewer ID in asset allocation  excel database$")
	public void store_the_reviewer_id_in_asset_allocation_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsToastAlert());
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");

		excelDataForAssetAllocation.updateTestData(assetAllocationTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^click on search in maker approved list view$")
	public void click_on_search_in_maker_approved_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsListViewSearchButton());
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsListViewSearchButton());
				clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsListViewSearchButton());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the approved asset reference number in asset allocation list view$")
	public void search_the_approved_asset_reference_number_in_asset_allocation_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetAllocationListViewSearchAssetReferenceNumber());
		clicksAndActionHelper.moveToElement(fixedAssetObj.assetAllocationListViewSearchAssetReferenceNumber());
		clicksAndActionHelper.clickOnElement(fixedAssetObj.assetAllocationListViewSearchAssetReferenceNumber());
		fixedAssetObj.assetAllocationListViewSearchAssetReferenceNumber()
				.sendKeys(assetAllocationTestData.get("AssetReferenceNumber"));
	}

	@Then("^verify approved allocation asset record should visible along with item number$")
	public void verify_approved_allocation_asset_record_should_visible_along_with_item_number() throws Throwable {
		String xpath = "//datatable-body-cell[5]//span[text()=' " + assetAllocationTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[1]//span[text()=' "
				+ assetAllocationTestData.get("AssetItemNumber") + " ']";
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

	@And("^Store the asset reference number and asset item number of asset replacement allocation in asset deallocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_replacement_allocation_in_asset_deallocation_excel_data_base()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D5", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D5", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of allocated asset in asset writeoff excel database$")
	public void store_the_asset_reference_number_and_item_number_of_allocated_asset_in_asset_writeoff_excel_database()
			throws Throwable {

		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_007_D1", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_007_D1", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of allocated asset in asset deallocation excel database for prerequisite of asset write off$")
	public void store_the_asset_reference_number_and_item_number_of_allocated_asset_in_asset_deallocation_excel_database_for_prerequisite_of_asset_write_off()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D11", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D11", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number in impairment excel database for impairment$")
	public void store_the_asset_reference_number_and_item_number_in_impairment_excel_database_for_impairment()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData(assetAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData(assetAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the assetreference number and item number of allocation asset in de allocation excel database for asset revaluation prerequisite$")
	public void store_the_assetreference_number_and_item_number_of_allocation_asset_in_de_allocation_excel_database_for_asset_revaluation_prerequisite()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData(assetAllocationTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData(assetAllocationTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number asset item number in asset de allocation excel database$")
	public void store_the_asset_reference_number_asset_item_number_in_asset_de_allocation_excel_database()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D1", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D1", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number asset item number in asset de allocation excel database for asset return prerequsite$")
	public void store_the_asset_reference_number_asset_item_number_in_asset_de_allocation_excel_database_for_asset_return_prerequsite()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D3", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D3", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^Store the asset reference number and asset item number of asset ammenment allocation in asset deallocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_ammenment_allocation_in_asset_deallocation_excel_data_base()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D6", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D6", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number in de allocation for impairment prequesites$")
	public void store_the_asset_reference_number_and_item_number_in_de_allocation_for_impairment_prequesites()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D2", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D2", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^Store the asset reference number and asset item number of asset sale allocation in asset deallocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_sale_allocation_in_asset_deallocation_excel_data_base()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D8", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D8", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^Store the asset reference number and asset item number of asset transfer allocation in asset deallocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_transfer_allocation_in_asset_deallocation_excel_data_base()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D7", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D7", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^Store the asset reference number and asset item number of asset revaluation allocation in asset deallocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_revaluation_allocation_in_asset_deallocation_excel_data_base()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D9", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D9", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@Then("^Save the filled Allocation$")
	public void save_the_filled_allocation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsserAllocationSaveButton());
		fixedAssetObj.fixedAsserAllocationSaveButton().click();
		for (int i = 0; i < 30; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated());
				fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated().click();
				break;
			} catch (Exception e) {

			}

		}
		for (int i = 0; i < 30; i++) {
			try {

				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCategory_AlertClose());
				fixedAssetObj.fixedAsset_AssetCategory_AlertClose().click();
				break;
			} catch (Exception e) {

			}
		}

	}

//-----------KUBS_FAT_UAT_006_002----

	// ------------KUBS_FAT_UAT_006_003-----------
	@And("^User search impaired asset record$")
	public void user_search_impaired_asset_record() throws Throwable {
		for (int i = 0; i < 30; i++) {
			try {
				fixedAssetObj.searchIconInApprovedListView().click();
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 0; i < 30; i++) {
			try {
				fixedAssetObj.searchTransactionType().click();
				fixedAssetObj.searchTransactionType().sendKeys("Impairment");
				break;
			} catch (Exception e) {

			}
		}

	}

	@And("^get imparied asset reference number$")
	public void get_imparied_asset_reference_number() throws Throwable {
		waitHelper.waitForElementVisible(driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[6]")),
				3000, 300);
		// driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
		codeConfigData.put("AssetCode", driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[6]"))
				.getText());
		System.out.println(driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[6]"))
				.getText());
	}

	// -------KUBS_FAT_UAT_006_004---------
	@And("^User get the revalued asset for allocation$")
	public void user_get_the_revalued_asset_for_allocation() throws Throwable {
		waitHelper.waitForElementVisible(driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]")),
				3000, 300);
		// driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
		codeConfigData.put("AssetCode", driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]"))
				.getText());
		System.out.println(driver.findElement(By.xpath(
				"(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]"))
				.getText());
	}

	// --------KUBS_FAT_UAT_002_008-----
	@Then("^Click on Job Scheduler$")
	public void click_on_job_scheduler() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.JobScheduler_Button());
		fixedAssetObj.JobScheduler_Button().click();
	}

	@Then("^Click on Job Execution edit button$")
	public void click_on_job_execution_edit_button() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.JobExecution_EditButton());
		fixedAssetObj.JobExecution_EditButton().click();
	}

	@Then("^click on Start the job$")
	public void click_on_start_the_job() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.JobExecution_StartJobButton());
		fixedAssetObj.JobExecution_StartJobButton().click();
		
	}

	@Then("^Click on refresh button$")
	public void click_on_refresh_button() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.JobExecution_RefreshButton());
		fixedAssetObj.JobExecution_RefreshButton().click();
	}

	// ------------------KUBS_FAT_UAT_013_007-------
	@Then("^Click on Asset Creation Common Edit Grid$")
	public void click_on_asset_creation_common_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(fixedAssetObj.Report_report_AssetCreationCommon_editButton());
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_editButton());
		fixedAssetObj.Report_report_AssetCreationCommon_editButton().click();

	}

	@Then("^Click on view button to see Asset Creation report$")
	public void click_on_view_button_to_see_asset_creation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_ViewButton());
		fixedAssetObj.Report_report_AssetCreationCommon_ViewButton().click();

	}

	// Report
	@And("^open the list view record which is appeared in asset allocation record$")
	public void open_the_list_view_record_which_is_appeared_in_asset_allocation_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationListViewFirstRecord());
		clicksAndActionHelper.moveToElement(fixedAssetObj.assetAllocationListViewFirstRecord());
		clicksAndActionHelper.clickOnElement(fixedAssetObj.assetAllocationListViewFirstRecord());
	}

	@And("^store the asset item number and asset referece number and allocated date for report validation$")
	public void store_the_asset_item_number_and_asset_referece_number_and_allocated_date_for_report_validation()
			throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetAllocationAllocatedReferenceNumber());
		String assetRefereceNumber = fixedAssetObj.assetAllocationAllocatedReferenceNumber().getText();
		assetAllocationReportTestData.put("assetRefereceNumber", assetRefereceNumber);
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationAllocatedEmployeeID());
		String employeeId = fixedAssetObj.assetAllocationAllocatedEmployeeID().getText();
		assetAllocationReportTestData.put("employeeId", employeeId);
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationAllocatedItemNumber());
		String ItemNumber = fixedAssetObj.assetAllocationAllocatedItemNumber().getText();
		assetAllocationReportTestData.put("ItemNumber", ItemNumber);

		for (int i = 0; i <= 500; i++) {
			try {
				String assetAllocatedDate = javascripthelper
						.executeScript("return document.getElementById('kubDateTime').value").toString();
				System.out.println("Allocated date" + assetAllocatedDate);
				assetAllocationReportTestData.put("assetAllocatedDate", assetAllocatedDate);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^click on asset allocation report temp view$")
	public void click_on_asset_allocation_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAllocationAllocationReportTemp());
		fixedAssetObj.assetAllocationAllocationReportTemp().click();
	}

	@And("^enter the employee name in report$")
	public void enter_the_employee_name_in_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetAllocationAllocationReportEmployeeID());
		fixedAssetObj.assetAllocationAllocationReportEmployeeID().click();
		fixedAssetObj.assetAllocationAllocationReportEmployeeID()
				.sendKeys(assetAllocationReportTestData.get("employeeId"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAllocationReportTestData.get("employeeId") + "']";

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

	@And("^enter the asset item number in report$")
	public void enter_the_asset_item_number_in_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetAllocationAllocationReportItemNumber());
		fixedAssetObj.assetAllocationAllocationReportItemNumber().click();
		fixedAssetObj.assetAllocationAllocationReportItemNumber()
				.sendKeys(assetAllocationReportTestData.get("ItemNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAllocationReportTestData.get("ItemNumber") + "']";

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
	@And("^enter the asset allocated date in alocation report$")
	public void enter_the_asset_allocated_date_in_alocation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetAllocationAllocationReportAllocatedDate());
		fixedAssetObj.assetAllocationAllocationReportAllocatedDate().click();

		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		String[] splitDate = assetAllocationReportTestData.get("assetAllocatedDate").split("-");
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

	@Then("^validate the asset reference number should reflect in the allocation report$")
	public void validate_the_asset_reference_number_should_reflect_in_the_allocation_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String xpath = "//div[contains(text(),'" + assetAllocationReportTestData.get("assetRefereceNumber") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(validation);
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	@And("^store the asset branch for asset creation common report$")
	public void store_the_asset_branch_for_asset_creation_common_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationListViewApprovedAssetBranch());
		String approvedBranch = fixedAssetObj.assetcreationListViewApprovedAssetBranch().getText();
		assetCreationReportTestData.put("approvedBranch", approvedBranch);
	}

	@And("^store the asset code and seet reference number for asset creation report$")
	public void store_the_asset_code_and_seet_reference_number_for_asset_creation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationListViewApprovedAssetReferenceNumber());
		String ApprovedAssetReferenceNumber = fixedAssetObj.assetcreationListViewApprovedAssetReferenceNumber()
				.getText();
		assetCreationReportTestData.put("ApprovedAssetReferenceNumber", ApprovedAssetReferenceNumber);
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetCreationListViewApprovedAssetCode());
		String ApprovedAssetCode = fixedAssetObj.assetCreationListViewApprovedAssetCode().getText();
		assetCreationReportTestData.put("ApprovedAssetCode", ApprovedAssetCode);
	}

	@And("^seelect the asset creation approved record in list view$")
	public void seelect_the_asset_creation_approved_record_in_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationListViewApprovedAssetRecord());
		fixedAssetObj.assetcreationListViewApprovedAssetRecord().click();
	}

	@And("^store the asset life in for asset creation report validation$")
	public void store_the_asset_life_in_for_asset_creation_report_validation() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationApprovedAssetCreationAssetLife());
		String approvedAssetLife = fixedAssetObj.assetcreationApprovedAssetCreationAssetLife().getText();
		assetCreationReportTestData.put("approvedAssetLife", approvedAssetLife);
	}

	@And("^select the item record in list view of item details$")
	public void select_the_item_record_in_list_view_of_item_details() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationListViewApprovedAssetItemNumber());
		String approvedAssetItemNumber = fixedAssetObj.assetcreationListViewApprovedAssetItemNumber().getText();
		assetCreationReportTestData.put("approvedAssetItemNumber", approvedAssetItemNumber);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationListViewApprovedAssetItemRecord());
		fixedAssetObj.assetcreationListViewApprovedAssetItemRecord().click();
	}

	@And("^store the capitalization date and created date for asset creation report$")
	public void store_the_capitalization_date_and_created_date_for_asset_creation_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				String assetDate = javascripthelper.executeScript("return document.getElementById('kubDateTime').value")
						.toString();
				assetCreationReportTestData.put("assetDate", assetDate);

				String capDate = javascripthelper
						.executeScript("return document.getElementsByClassName('form-control p-0')[1].value")
						.toString();
				assetCreationReportTestData.put("capDate", capDate);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kUBSSystemDate());
		String systemDate = kubsCommonWebObj.kUBSSystemDate().getText();
		assetCreationReportTestData.put("systemDate", systemDate);
		System.out.println("System Date" + assetCreationReportTestData.get("systemDate"));

		for (int i = 0; i <= 500; i++) {
			try {
				String assetAsOnDate = javascripthelper
						.executeScript("return document.getElementsByClassName('form-control p-0')[0].value")
						.toString();
				assetCreationReportTestData.put("assetAsOnDate", assetAsOnDate);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
	}

	@SuppressWarnings("static-access")
	@And("^give the capitalization date in asset creation item wise report$")
	public void give_the_capitalization_date_in_asset_creation_item_wise_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationLReportCapitalizationDateCalendar());
		fixedAssetObj.assetcreationLReportCapitalizationDateCalendar().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetCreationReportTestData.get("capDate"));
		String[] splitDate = assetCreationReportTestData.get("capDate").split("-");
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
	@And("^give the asset creation as on date in asset creation item wise report$")
	public void give_the_asset_creation_as_on_date_in_asset_creation_item_wise_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationLReportAssetCreationAsOnDateCalendar());
		fixedAssetObj.assetcreationLReportAssetCreationAsOnDateCalendar().click();

		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetCreationReportTestData.get("systemDate"));
		String[] splitDate = assetCreationReportTestData.get("systemDate").split("-");
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

	@And("^click on asset creation item report temp view$")
	public void click_on_asset_creation_item_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsAssetCreationItemReport());
		kubsCommonWebObj.kubsAssetCreationItemReport().click();

	}

	@Then("^verify approved asset reference number should reflect in asset item report$")
	public void verify_approved_asset_reference_number_should_reflect_in_asset_item_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javascripthelper.JavaScriptHelper(driver);
		String xpath = "//div[contains(text(),'" + assetCreationReportTestData.get("approvedAssetItemNumber") + "')]";
		System.out.println(xpath);
		for (int i = 0; i <= 500; i++) {
			try {

				javascripthelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(validation);
				break;
			} catch (Exception e) {
				if (i != 500) {
					waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsReportNextButton());
					kubsCommonWebObj.kubsReportNextButton().click();
				} else if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	@And("^click on asset creation common roport temp view$")
	public void click_on_asset_creation_common_roport_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				kubsCommonWebObj.kubsAssetAssetCreationCommonReportTempView());
		kubsCommonWebObj.kubsAssetAssetCreationCommonReportTempView().click();
	}

	@And("^enter the asset life unit in asset creation common report$")
	public void enter_the_asset_life_unit_in_asset_creation_common_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetCreationCommonReport_AssetLifeUnit());
		fixedAssetObj.assetCreationCommonReport_AssetLifeUnit().click();
		fixedAssetObj.assetCreationCommonReport_AssetLifeUnit()
				.sendKeys(assetCreationReportTestData.get("approvedAssetLife"));
		fixedAssetObj.assetCreationCommonReport_AssetLifeUnit().sendKeys(Keys.DOWN);
		fixedAssetObj.assetCreationCommonReport_AssetLifeUnit().sendKeys(Keys.ENTER);
	}

	@SuppressWarnings("static-access")
	@And("^enter the asset date in asset creation common report$")
	public void enter_the_asset_date_in_asset_creation_common_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.assetcreationLReportCapitalizationDateCalendar());
		fixedAssetObj.assetcreationLReportCapitalizationDateCalendar().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kUBSSystemDate());
		String systemDate = kubsCommonWebObj.kUBSSystemDate().getText();
		System.out.println("Created date" + systemDate);
		String[] splitDate = systemDate.split("-");
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

	@Then("^verify asset reference number and code should reflect in asset code common report$")
	public void verify_asset_reference_number_and_code_should_reflect_in_asset_code_common_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javascripthelper.JavaScriptHelper(driver);
		String xpath = "//div[contains(text(),'" + assetCreationReportTestData.get("ApprovedAssetReferenceNumber")
				+ "')]";
		System.out.println(xpath);
		for (int i = 0; i <= 500; i++) {
			try {

				javascripthelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(validation);
				break;
			} catch (Exception e) {
				if (i != 500) {
					waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsReportNextButton());
					kubsCommonWebObj.kubsReportNextButton().click();
				} else if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	@And("^click on fixed asset branch level depriciation list view$")
	public void click_on_fixed_asset_branch_level_depriciation_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAssetBranchLevelDepriciationListView());
		fixedAssetObj.fixedAssetBranchLevelDepriciationListView().click();

	}

	@And("^click on search button in branch level depriciation list view$")
	public void click_on_search_button_in_branch_level_depriciation_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsListViewSearchButton());
		kubsCommonWebObj.kubsListViewSearchButton().click();
	}

	@And("^search the branch level for geting the depriciation period$")
	public void search_the_branch_level_for_geting_the_depriciation_period() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAssetBranchLevelDepriciationSearchBranchCode());
		fixedAssetObj.fixedAssetBranchLevelDepriciationSearchBranchCode().click();
		String[] splitBranch = assetCreationReportTestData.get("approvedBranch").split("-");
		fixedAssetObj.fixedAssetBranchLevelDepriciationSearchBranchCode().sendKeys(splitBranch[0].trim());

		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAssetBranchLevelDepriciationListViewDepriciationPeriod());
		String depriciationPeriod = fixedAssetObj.fixedAssetBranchLevelDepriciationListViewDepriciationPeriod()
				.getText();
		assetCreationReportTestData.put("depriciationPeriod", depriciationPeriod);
		System.out.println("Depriciation period " + assetCreationReportTestData.get("depriciationPeriod"));
	}

	@And("^click on temp view of depriciation report temp view$")
	public void click_on_temp_view_of_depriciation_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.depriciationReportTempView());
		fixedAssetObj.depriciationReportTempView().click();
	}

	@And("^enter the branch in depriciation report$")
	public void enter_the_branch_in_depriciation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.depriciationReportBranchInput());
		fixedAssetObj.depriciationReportBranchInput().click();
		String[] splitBranch = assetCreationReportTestData.get("approvedBranch").split("-");
		fixedAssetObj.depriciationReportBranchInput().sendKeys(splitBranch[1]);
		fixedAssetObj.depriciationReportBranchInput().sendKeys(Keys.BACK_SPACE);
		fixedAssetObj.depriciationReportBranchInput().sendKeys(Keys.DOWN);
		fixedAssetObj.depriciationReportBranchInput().sendKeys(Keys.ENTER);

	}

	@SuppressWarnings("static-access")
	@And("^give the date in depriciation report$")
	public void give_the_date_in_depriciation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.depriciationReportDepriciationCalendar());
		fixedAssetObj.depriciationReportDepriciationCalendar().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetCreationReportTestData.get("assetDate"));
		String[] splitDate = assetCreationReportTestData.get("assetDate").split("-");
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

	@And("^enter the depriciation period in depriciation report$")
	public void enter_the_depriciation_period_in_depriciation_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.depriciationReportDepriciationPeriod());
		fixedAssetObj.depriciationReportDepriciationPeriod().click();
		fixedAssetObj.depriciationReportDepriciationPeriod()
				.sendKeys(assetCreationReportTestData.get("depriciationPeriod"));
		fixedAssetObj.depriciationReportDepriciationPeriod().sendKeys(Keys.DOWN);
		fixedAssetObj.depriciationReportDepriciationPeriod().sendKeys(Keys.ENTER);
	}

	@Then("^validate the asset reference number should reflect in asset depriciation report$")
	public void validate_the_asset_reference_number_should_reflect_in_asset_depriciation_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javascripthelper.JavaScriptHelper(driver);
		String xpath = "//div[contains(text(),'" + assetCreationReportTestData.get("ApprovedAssetReferenceNumber")
				+ "')]";
		System.out.println(xpath);
		for (int i = 0; i <= 500; i++) {
			try {

				javascripthelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
				boolean validation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(validation);
				break;
			} catch (Exception e) {
				if (i != 500) {
					waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebObj.kubsReportNextButton());
					kubsCommonWebObj.kubsReportNextButton().click();
				} else if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	@And("^click on temp view of asset limit report$")
	public void click_on_temp_view_of_asset_limit_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetLimitReportTempView());
		fixedAssetObj.assetLimitReportTempView().click();
		;
	}

	@And("^enter the accounting standard in asset limit report$")
	public void enter_the_accounting_standard_in_asset_limit_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetLimitAccountingStandards());
		fixedAssetObj.assetLimitAccountingStandards().click();
		fixedAssetObj.assetLimitAccountingStandards().sendKeys(Keys.DOWN);
		fixedAssetObj.assetLimitAccountingStandards().sendKeys(Keys.ENTER);
	}

	@And("^enter the limit as on date in asset limit report$")
	public void enter_the_limit_as_on_date_in_asset_limit_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetLimitLimitAsOnDate());
		fixedAssetObj.assetLimitLimitAsOnDate().click();

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
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsCalendarMonthYearOption());
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
				clicksAndActionHelper.doubleClick(FinalDay);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getLocalizedMessage());

				}
			}
		}
	}

	@Then("^verify asset limit report should generate$")
	public void verify_asset_limit_report_should_generate() throws Throwable {
		browserHelper.SwitchToWindow(1);
		for (int i = 0; i <= 500; i++) {
			try {

				boolean displayVerfication = driver
						.findElement(By.xpath("//div[contains(text(),'Asset Limit Configuration Report')]"))
						.isDisplayed();
				Assert.assertTrue(displayVerfication);
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
