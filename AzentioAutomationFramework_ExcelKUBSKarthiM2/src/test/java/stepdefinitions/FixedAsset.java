package stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;
import testDataType.InventoryManagementTestDataType;
import utilities.ExtentTestManager;

public class FixedAsset {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetDefinitionTestDataType budgetdata1;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	FixedAsset_AssetCreationTestDataType assetCreation = jsonReader.getAssetCreationByName("Maker");
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
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
	Map<String, String> assetCreationTestData = new HashMap<>();
	Map<String, String> assetAllocationTestData = new HashMap<>();
	//

	// -------------KUBS_FAT_UAT_002_001------
	@Given("^Navigate to kubs URL and user should login as a maker$")
	public void navigate_to_kubs_url_and_user_should_login_as_a_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

//	    @Then("^Click on the Finance$")
//	    public void click_on_the_finance() throws Throwable {
//	    	System.out.println("Click on finance");
//	    }

//	    @Then("^Click on the Direction$")
//	    public void click_on_the_direction() throws Throwable {
//	    	waithelper.waitForElementToVisisbleWithFluentWait(driver, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
//			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
//
//	    }
	@And("^click on configuration section$")
	public void click_on_configuration_section() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsConfigurationSection(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsConfigurationSection());

	}

	@And("^click on transaction section$")
	public void click_on_transaction_section() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsTransactionSection(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsTransactionSection());
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsConfigurationSection(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsConfigurationSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsConfigurationSection());
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsTransactionSection(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsTransactionSection());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsTransactionSection());
	}

	@Then("^Click on Fixed Asset$")
	public void click_on_fixed_asset() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_Button(), 60, 5);
		fixedAssetObj.fixedAsset_Button().click();
	}

	@Then("^Click on Asset Creation Eye button$")
	public void click_on_asset_creation_eye_button() throws Throwable {
		fixedAssetObj.fixedAsset_AssetCreation_EyeButton().click();
	}

	@And("^click on search button in asset creation module$")
	public void click_on_search_button_in_asset_creation_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.kubsSearchButton(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAssetSearchAssetCode(), 20, 1);
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
		for (int i = 0; i <= 100; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
						"Approved asset Code is not reflected in asset creation list view");
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the approved asset reference number record$")
	public void select_the_approved_asset_reference_number_record() throws Throwable {
		String xpath = "//datatable-row-wrapper[1]//span[text()=' " + assetCreationTestData.get("AssetCode")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[3]//ion-button[1]";
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
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D1", "AssetReferenceNumber",
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
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D4", "AssetReferenceNumber",
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
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D10", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset impairment excel database for the prerequisite of asset transfer$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}
	@And("^store the asset item number in asset revaluation excel database for the prerequisite of asset transfer$")
    public void store_the_asset_item_number_in_asset_revaluation_excel_database_for_the_prerequisite_of_asset_transfer() throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D10", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
    }

	@And("^store the asset item number in asset transfer undertaking excel database$")
	public void store_the_asset_item_number_in_asset_transfer_undertaking_excel_database() throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D1", "AssetItemNumber",
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
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D1", "AssetReferenceNumber",
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
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_001_D1", "AssetItemNumber",
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
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D1", "AssetReferenceNumber",
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
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D6", "AssetReferenceNumber",
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
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D4", "AssetReferenceNumber",
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
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D3", "AssetReferenceNumber",
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
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D3", "AssetReferenceNumber",
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
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D3", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset transfer undertaking excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_transfer_undertaking_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset Sale excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_sale_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset return excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_return_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {

		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset replacement excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_replacement_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D4", "AssetItemNumber",
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
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D4", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset allocation excel database for prerequisite of asset revaluation$")
	public void store_the_asset_item_number_in_asset_allocation_excel_database_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D4", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset revaluation excel database$")
	public void store_the_asset_item_number_in_asset_revaluation_excel_database() throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D1", "AssetItemNumber",
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
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D6", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset return excel database$")
	public void store_the_asset_item_number_in_asset_return_excel_database() throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number in asset impairment excel database$")
	public void store_the_asset_item_number_in_asset_impairment_excel_database() throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_001_01_D1", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));
	}

	@And("^store the asset item number it allocation excel database to make impirement of allocated asset$")
	public void store_the_asset_item_number_it_allocation_excel_database_to_make_impirement_of_allocated_asset()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D2", "AssetItemNumber",
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
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset transfer excel database for prerequiste of asset impairment$")
	public void store_the_asset_item_number_in_asset_transfer_excel_database_for_prerequiste_of_asset_impairment()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_001_D2", "AssetItemNumber",
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
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset revlauation excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_revlauation_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_01_D2", "AssetItemNumber",
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
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D3", "AssetReferenceNumber",
				assetReferenceNumber);

	}

	@And("^store the asset item number in asset ammendment excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_ammendment_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetAmmendment.updateTestData("KUBS_FAT_UAT_011_01_D3", "AssetItemNumber",
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
		excelDataForAssetReplacement.updateTestData("KUBS_FAT_UAT_008_D2", "AssetItemNumber",
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
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset return excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_return_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_001_01_D2", "AssetItemNumber",
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
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D2", "AssetReferenceNumber",
				assetReferenceNumber);
	}

	@And("^store the asset item number in asset Sale excel database for prerequsite of asset impairment$")
	public void store_the_asset_item_number_in_asset_sale_excel_database_for_prerequsite_of_asset_impairment()
			throws Throwable {
		excelDataForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D2", "AssetItemNumber",
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

	@And("^store the asset item number in asset allocation excel database for return allocation asset$")
	public void store_the_asset_item_number_in_asset_allocation_excel_database_for_return_allocation_asset()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D3", "AssetItemNumber",
				assetCreationTestData.get("UpdatedItemNumber"));

	}

	// New
	@And("^get the test data for asset creation with minimum details from excel data$")
	public void get_the_test_data_for_asset_creation_with_minimum_details_from_excel_data() throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_006_D1");
	}

	@And("^get the test data for asset creation with full details from excel data$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data() throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D1");
	}

	@And("^get the test data for asset creation with full details from excel data for asset transfer$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_asset_transfer()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D7");
	}

	@And("^get the test data for asset creation with full details from excel data for prerequisite of asset revaluation$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D6");
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
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D2");
	}

	@And("^get the test data for asset creation with full details from excel data for asset return$")
	public void get_the_test_data_for_asset_creation_with_full_details_from_excel_data_for_asset_return()
			throws Throwable {
		assetCreationTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D3");
	}

	@And("^select the branch code in asset creation module$")
	public void select_the_branch_code_in_asset_creation_module() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(assetCreationTestData.get("BranchCode"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCreationTestData.get("BranchCode") + "']";
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
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCreationTestData.get("AssetCode") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox(), 60, 5);
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

	@And("^select the bill reference number in asset creation module$")
	public void select_the_bill_reference_number_in_asset_creation_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCreationTestData.get("BillReferenceNumber") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox(), 60, 5);
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
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCreationTestData.get("AssetLife") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit(), 60, 5);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSaveButton(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSaveButton());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSaveButton());

	}

	@And("^search the asset asset creation module code in notification$")
	public void search_the_asset_asset_creation_module_code_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSearchEventCode(), 20, 1);

		// assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetCreationTestData.get("ModuleCode"));
	}

	@And("^store the fixed asset creation with minimum details reference number in excel data base and select the record$")
	public void store_the_fixed_asset_creation_with_minimum_details_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetCreationReferenceNumber(), 20, 1);
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reference ID",
				fixedAssetObj.assetCreationReferenceNumber().getText());
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetCreationNotificationFirstRecord(),
				20, 1);
		fixedAssetObj.assetCreationNotificationFirstRecord().click();

	}

	@Then("^validate the submit and store the reviewer ID of fixed asset creation with full details in excel database$")
	public void validate_the_submit_and_store_the_reviewer_id_of_fixed_asset_creation_with_full_details_in_excel_database()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^store the fixed asset creation with full details reference number in excel data base and select the record$")
	public void store_the_fixed_asset_creation_with_full_details_reference_number_in_excel_data_base_and_select_the_record()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetCreationReferenceNumber(), 20, 1);
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reference ID",
				fixedAssetObj.assetCreationReferenceNumber().getText());
//		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetCreationNotificationFirstRecord(),
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSubmitButton(), 20, 1);
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in fixed asset creation with full details$")
	public void enter_the_alert_remark_in_fixed_asset_creation_with_full_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertRemark(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());

		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCreationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in fixed asset creation with full details$")
	public void click_on_alert_submit_in_fixed_asset_creation_with_full_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertSubmit(), 20, 1);

		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonWebObj.kubsAlertSubmit().click();
				break;
			} catch (Exception e) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertRemark(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	@And("^Select the asset creation recod in notification$")
	public void select_the_asset_creation_recod_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetCreationNotificationFirstRecord(),
				20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAssetAddButton(), 20, 1);
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
		String assetItemNumber = assetCreationTestData.get("AssetItemNumber") + randomNumber1 + randomNumber2;
		excelDataForAssetCreation.updateTestData(assetCreationTestData.get("DataSet ID"), "UpdatedItemNumber",
				assetItemNumber);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber(), 20, 1);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(assetItemNumber);
	}

	@And("^enter asset description in asset item creation$")
	public void enter_asset_description_in_asset_item_creation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription(), 20, 1);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription()
				.sendKeys(assetCreationTestData.get("AssetItemDescription"));
	}

	@And("^select the asset capitalization date in asset item creation$")
	public void select_the_asset_capitalization_date_in_asset_item_creation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar(), 20, 1);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsMonthAndYear(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_HSNCode(), 20,
				1);
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().click();
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(assetCreationTestData.get("HSNCode"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetCreationTestData.get("HSNCode") + "']";
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_AssetValue(),
				20, 1);
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(assetCreationTestData.get("Assetvalue"));
	}

	@And("^save the asset item creation record$")
	public void save_the_asset_item_creation_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSaveButton(), 20, 1);
		kubsCommonWebObj.kubsSaveButton().click();
	}

	// End
	@And("^click on submit in fixed asset creation with minimum details$")
	public void click_on_submit_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSubmitButton(), 20, 1);
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in fixed asset creation with minimum details$")
	public void enter_the_alert_remark_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertRemark(), 20, 1);
		kubsCommonWebObj.kubsAlertRemark().click();
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetCreationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in fixed asset creation with minimum details$")
	public void click_on_alert_submit_in_fixed_asset_creation_with_minimum_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertSubmit(), 20, 1);
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

//New
	@Then("^Fill Form$")
	public void fill_form() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();
		Thread.sleep(500);
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(fixedAssetTestDataType.BranchCode);
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();
		Thread.sleep(500);
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(assetCreation.AssetCode);
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();
		Thread.sleep(500);
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox()
				.sendKeys(fixedAssetTestDataType.BillReferenceNo);
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);

	}

	@Then("^Save the filled form$")
	public void save_the_filled_form() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_SaveButton(),
				60, 5);
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

//	    @Then("^Click on the Notification$")
//	    public void click_on_the_notification() throws Throwable {
//	    	waithelper.waitForElementToVisisbleWithFluentWait(driver,  budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
//			budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();
//
//	    }

	/*
	 * @Then("^Select the record which we saved$") public void
	 * select_the_record_which_we_saved() throws Throwable { // Reference
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * budgetTransferObj.budget_BudgetTransfer_FirstReferenceId()); String id =
	 * budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
	 * jsonWriter.addReferanceData(id); System.out.println("Reference ID:" + id);
	 * for (int i = 1; i <= 35; i++) { try {
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * driver.findElement(By.xpath("//span[contains(text(),'" +
	 * jsonWriter.readReferancedata() + "')]"))); WebElement referanceID =
	 * driver.findElement(By.xpath("//span[contains(text(),'" +
	 * jsonWriter.readReferancedata() + "')]")); referanceID.click();
	 * System.out.println(referanceID); //
	 * Assert.assertTrue(referanceID.isDisplayed()); break; } catch
	 * (NoSuchElementException e) {
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver, 4000,
	 * budgetTransferObj.maker_notification_next_button());
	 * 
	 * budgetTransferObj.maker_notification_next_button().click(); }
	 * 
	 * } budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();
	 * 
	 * // Action-Pencil String before_xpath = "//span[contains(text(),'"; String
	 * after_xpath =
	 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	 * 
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() +
	 * after_xpath))); driver.findElement(By.xpath(before_xpath +
	 * reader.readReferancedata() + after_xpath)).click();
	 * 
	 * }
	 */
	@Then("^Click on Fixed Asset items$")
	public void click_on_fixed_asset_items() throws Throwable {
		// Asset Items
		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems().click();

	}

	@Then("^Click on the add button of asset items$")
	public void click_on_the_add_button_of_asset_items() {
		// Add button
		// waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAssetObj.fixedAsset_AssetCreation_AddButton(),60,5);
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

	@Then("^fill the asset item details$")
	public void fill_the_asset_item_details() throws Throwable {
		// item details
		Random random = new Random();
		int randomNumber = random.nextInt(5000 - 999) + 5000;
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber(), 30, 5);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber()
				.sendKeys(fixedAssetTestDataType.AssetItemNumber + randomNumber);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription(), 30, 5);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription()
				.sendKeys(fixedAssetTestDataType.AssetItemDescription + randomNumber);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_AssetValue(),
				30, 5);
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().click();
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAssetTestDataType.AssetValue);
		fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_HSNCode(), 30,
				5);
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().click();
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(fixedAssetTestDataType.HSNCode);
		fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(Keys.ENTER);

		// Calendar
		javascripthelper.JavaScriptHelper(driver);
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar(), 60, 5);
		fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
		Thread.sleep(1000);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(
						driver, driver.findElement(By.xpath("//span[contains(text(),'"
								+ fixedAssetTestDataType.GlToMonth + " " + fixedAssetTestDataType.GlYear + "')]")),
						60, 5);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ fixedAssetTestDataType.GlToMonth + " " + fixedAssetTestDataType.GlYear + "')]"));
				Thread.sleep(1000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				fixedAssetObj.inventoryNextMonth().click();
			}
		}
		Thread.sleep(2000);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + fixedAssetTestDataType.GlFullToMonth
				+ " " + fixedAssetTestDataType.GlToDate + ", " + fixedAssetTestDataType.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
		Thread.sleep(2000);
	}

	@Then("^Click on save button of item details$")
	public void click_on_save_button_of_item_details() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_SaveButton(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_SaveButton().click();
		Thread.sleep(3000);
	}

	@And("^click on search in notification section$")
	public void click_on_search_in_notification_section() throws Throwable {
		// waithelper.waitForElementToVisibleWithFluentWait(driver,
		// fixedAssetObj.fixedAssetMailBoxSearchButton(), 20, 1);

		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAssetMailBoxSearchButton());
				// clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAssetMailBoxSearchButton());
				// clicksAndActionHelper.doubleClick(fixedAssetObj.fixedAssetMailBoxSearchButton());
				javascripthelper.JSEClick(fixedAssetObj.fixedAssetMailBoxSearchButton());
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search for asset creation record in notification$")
	public void search_for_asset_creation_record_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAssetSearchEventCode(), 20, 1);
		clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAssetSearchEventCode());
		clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAssetSearchEventCode());
		fixedAssetObj.fixedAssetSearchEventCode().sendKeys(fixedAssetTestDataType.ModuleEventCode);
	}
//	    @Then("^Submit record$")
//	    public void submit_record() throws Throwable {
//	    	// Submit button
//			//Thread.sleep(2000);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, inventoryManagamentObj.accountPayable_SubmitButton());
//			inventoryManagamentObj.accountPayable_SubmitButton().click();
//			//budgetTransferObj.budget_BudgetTransfer_Submit().click();
//			javahelper.JavaScriptHelper(driver);
//			// Remark
//			//javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
//			/*inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed();
//			boolean result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
//			System.out.println(result);
//			while(true) {
//				try {
//			//inventoryManagamentObj.accountPayable_SubmitButton().click();
//				WebElement submitButton =	(WebElement) javahelper.executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]");
//				submitButton.click();	
//				break;
//				}
//				catch(ElementNotInteractableException e)
//				{
//					System.out.println(e.getMessage());
//				}
//				}*/
//			waithelper.waitForElementToVisisbleWithFluentWait(driver,  budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			
//			//javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().click();
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			Thread.sleep(2000);
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);
//			
//			Thread.sleep(2000);
//			// Remark Submit
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
//			budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
//			Thread.sleep(2000);
//			WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
//
//			clicksAndActionHelper.moveToElement(recordstatus);
//			String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
//			System.out.println(message);
//			budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
//			String t = "";
//			String ar[] = message.split(" ");
//			Thread.sleep(2000);
//			for (int i = ar.length - 1; i >= 0; i--) {
//				t = ar[ar.length - 1];
//			}
//			String reviewerId = "";
//			for (int i = 0; i < t.length() - 1; i++) {
//				if (t.charAt(i) == '.') {
//				} else {
//					reviewerId = reviewerId + t.charAt(i);
//				}
//			}
//			System.out.println(reviewerId);
//			jsonWriter = new JsonDataReaderWriter();
//			jsonWriter.addData(reviewerId);
//
//	    }

//	    @Then("^Open the Reviewer account$")
//	    public void open_the_reviewer_account() throws Throwable {
//	    	reader = new JsonDataReaderWriter();
//			login = new AzentioLogin(driver);
//			driver.get(config.getApplicationUrl());
//			login.logintoAzentioappReviewer("Reviewer", reader.readdata());
//			waithelper = new WaitHelper(driver);
//			reviewer = new KUBS_ReviewerObj(driver);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, reviewer.reviewerNotidicationIcon());
//			reviewer.reviewerNotidicationIcon().click();
//			browserHelper = new BrowserHelper(driver);
//			budgetdata1 = jsonconfig.getBudgetdataByName("Maker");
//			javascript = new JavascriptHelper();
//			Thread.sleep(2000);
//			waithelper = new WaitHelper(driver);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElementToVisisbleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'"+reader.readReferancedata()+"')]"));
//					referanceID.click();
//
//					Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElementToVisisbleWithFluentWait(driver, 4000, kubschecker.checker_notification_next_button());
//
//					kubschecker.checker_notification_next_button().click();
//				}
//			}
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//			Thread.sleep(2000);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
//			driver.findElement(By.xpath(before_xpath+reader.readReferancedata()+after_xpath)).click();
//
//	    }

	/*
	 * @Then("^Approve the record which we submitted from maker$") public void
	 * approve_the_record_which_we_submitted_from_maker() throws Throwable {
	 * Thread.sleep(3000);
	 * 
	 * browserHelper = new BrowserHelper(driver); budgetdata1 =
	 * jsonReader.getBudgetdataByName("Maker"); javascripthelper = new
	 * JavascriptHelper(); javascripthelper.JavaScriptHelper(driver);
	 * Thread.sleep(1000); for (int i = 1; i <= 35; i++) { try {
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver, driver.findElement(
	 * 
	 * By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
	 * WebElement referanceID = driver.findElement(
	 * By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]"));
	 * referanceID.click(); Assert.assertTrue(referanceID.isDisplayed()); break; }
	 * catch (NoSuchElementException e) {
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver, 4000,
	 * kubschecker.checker_notification_next_button());
	 * 
	 * kubschecker.checker_notification_next_button().click(); } } String
	 * before_xpath = "//span[contains(text(),'"; String after_xpath =
	 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	 * 
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver, 5000,
	 * driver.findElement(By.xpath(before_xpath + reader.readReferancedata() +
	 * after_xpath))); driver.findElement(By.xpath(before_xpath +
	 * reader.readReferancedata() + after_xpath)).click();
	 * 
	 * 
	 * 
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * reviewer.reviewerApproveButton()); reviewer.reviewerApproveButton().click();
	 * Thread.sleep(2000); waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * reviewer.reviewerAlertRemarks());
	 * javahelper.JSEClick(reviewer.reviewerAlertRemarks()); Thread.sleep(2000);
	 * reviewer.reviewerAlertRemarks().sendKeys("ok"); Thread.sleep(3000);
	 * waithelper.waitForElementToVisisbleWithFluentWait(driver,
	 * reviewer.reviewerAlertSubmitButton());
	 * reviewer.reviewerAlertSubmitButton().click(); Thread.sleep(3000);
	 * 
	 * }
	 */
//	    @Then("^Go to Checker login$")
//	    public void go_to_checker_login() throws Throwable {
//	    	login = new AzentioLogin(driver);
//			driver.get(config.getApplicationUrl());
//			login.loginToAzentioAppAsChecker("Checker");
//			ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
//
//		
//	    }

//	    @Then("^Clam record$")
//	    public void clam_record() throws Throwable {
//	    	waithelper = new WaitHelper(driver);
//			kubschecker = new KUBS_CheckerObj(driver);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver,  kubschecker.checkerSecurityManagement());
//			kubschecker.checkerSecurityManagement().click();
//			waithelper.waitForElementToVisisbleWithFluentWait(driver,  kubschecker.checkerActionIcon());
//
//			kubschecker.checkerActionIcon().click();
//			Thread.sleep(1000);
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
//			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
//			waithelper.waitForElementToVisisbleWithFluentWait(driver,  kubschecker.checkerAlertClose());
//			kubschecker.checkerAlertClose().click();
// 
//	    }

//	    @Then("^Click on the notification and approve the record$")
//	    public void click_on_the_notification_and_approve_the_record() throws Throwable {
//	    	javascript = new JavascriptHelper();
//			Thread.sleep(1000);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver,  kubschecker.checkerNotificationIcon());
//
//			kubschecker.checkerNotificationIcon().click();
//			Thread.sleep(1000);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElementToVisisbleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
//					referanceID.click();
//
//					Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElementToVisisbleWithFluentWait(driver, 4000, kubschecker.checker_notification_next_button());
//
//					kubschecker.checker_notification_next_button().click();
//				}
//			}
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
//			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
//
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, 4000, kubschecker.checkerApproveButton());
//
//			kubschecker.checkerApproveButton().click();
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, reviewer.reviewerAlertRemarks());
//			reviewer.reviewerAlertRemarks().sendKeys("ok");
//			Thread.sleep(1000);
//			waithelper.waitForElementToVisisbleWithFluentWait(driver, reviewer.reviewerAlertSubmitButton());
//			reviewer.reviewerAlertSubmitButton().click();
//			Thread.sleep(4000);
//		 
//	    }

	// -------------KUBS_FAT_UAT_006_001-------------

	@Then("^Click on Asset Allocation Eye button$")
	public void click_on_asset_allocation_eye_button() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EyeButton(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EyeButton().click();
	}

	// New start
	@And("^get the asset allocation test data from excel database$")
	public void get_the_asset_allocation_test_data_from_excel_database() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_001_D1");
	}

	@And("^get the asset allocation test data from excel database for asset revaluation prerequisite$")
	public void get_the_asset_allocation_test_data_from_excel_database_for_asset_revaluation_prerequisite()
			throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D4");
	}

	@And("^get the asset allocation test data from excel database which is already revalued$")
	public void get_the_asset_allocation_test_data_from_excel_database_which_is_already_revalued() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_004_D1");
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
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D2");
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

	@And("^enter the asset reference number in asset allocation$")
	public void enter_the_asset_reference_number_in_asset_allocation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(), 20, 1);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber()
				.sendKeys(assetAllocationTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAllocationTestData.get("AssetReferenceNumber")
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
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(assetAllocationTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAllocationTestData.get("AssetItemNumber") + "']";

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

	@And("^enter the employee id in asset allocation$")
	public void enter_the_employee_id_in_asset_allocation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(assetAllocationTestData.get("EmployeeID"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAllocationTestData.get("EmployeeID") + "']";

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
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSaveButton(), 20, 1);
		kubsCommonWebObj.kubsSaveButton().click();
	}

	@And("^search the asset allocation module code$")
	public void search_the_asset_allocation_module_code() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSearchEventCode(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsSearchEventCode());
		kubsCommonWebObj.kubsSearchEventCode().sendKeys(assetAllocationTestData.get("ModuleCode"));
	}

	@And("^store the asset allocation reference number in asset allocation excel data base$")
	public void store_the_asset_allocation_reference_number_in_asset_allocation_excel_data_base() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAllocationReferenceNumber(), 20, 1);
		String allocationReferenceNum = fixedAssetObj.assetAllocationReferenceNumber().getText();
		excelDataForAssetAllocation.updateTestData(assetAllocationTestData.get("DataSet ID"), "Reference ID",
				allocationReferenceNum);
	}

	@And("^select the asset allocation record$")
	public void select_the_asset_allocation_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAllocationNotificationFirstRecord(),
				20, 1);
		clicksAndActionHelper.moveToElement(fixedAssetObj.assetAllocationNotificationFirstRecord());
		clicksAndActionHelper.clickOnElement(fixedAssetObj.assetAllocationNotificationFirstRecord());

	}

	@And("^enter the submit button in asset allocation module$")
	public void enter_the_submit_button_in_asset_allocation_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsSubmitButton(), 20, 1);
		kubsCommonWebObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset allocation module$")
	public void enter_the_alert_remark_in_asset_allocation_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertRemark(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonWebObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonWebObj.kubsAlertRemark());
		kubsCommonWebObj.kubsAlertRemark().sendKeys(assetAllocationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset allocation module$")
	public void click_on_alert_submit_in_asset_allocation_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsAlertSubmit(), 20, 1);
		kubsCommonWebObj.kubsAlertSubmit().click();
	}

	@Then("^store the reviewer ID in asset allocation  excel database$")
	public void store_the_reviewer_id_in_asset_allocation_excel_database() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonWebObj.kubsToastAlert().getText().substring(85).replace(".", "");

		excelDataForAssetAllocation.updateTestData(assetAllocationTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^click on search in maker approved list view$")
	public void click_on_search_in_maker_approved_list_view() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonWebObj.kubsListViewSearchButton(), 20, 1);
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
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.assetAllocationListViewSearchAssetReferenceNumber(), 20, 1);
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

	@And("^store the asset reference number and item number in impairment excel database for impairment$")
	public void store_the_asset_reference_number_and_item_number_in_impairment_excel_database_for_impairment()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_002_01_D1", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_002_01_D1", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	@And("^store the assetreference number and item number of allocation asset in de allocation excel database for asset revaluation prerequisite$")
	public void store_the_assetreference_number_and_item_number_of_allocation_asset_in_de_allocation_excel_database_for_asset_revaluation_prerequisite()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D4", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D4", "AssetItemNumber",
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

	@And("^store the asset reference number and item number in de allocation for impairment prequesites$")
	public void store_the_asset_reference_number_and_item_number_in_de_allocation_for_impairment_prequesites()
			throws Throwable {
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D2", "AssetReferenceNumber",
				assetAllocationTestData.get("AssetReferenceNumber"));
		excelDataForAssetDeAllocation.updateTestData("KUBS_FAT_UAT_006_005_01_D2", "AssetItemNumber",
				assetAllocationTestData.get("AssetItemNumber"));
	}

	// New End
	@Then("^Fill the Allocation form with unused asset$")
	public void fill_the_allocation_form_with_unused_asset() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(), 60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		// fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(assetCreation.AssetReferenceNumber);
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.DOWN);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
		// fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
	}

	@Then("^Save the filled Allocation$")
	public void save_the_filled_allocation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsserAllocationSaveButton(), 60, 5);
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
	@Then("^Fill the Allocation form with used asset details$")
	public void fill_the_allocation_form_with_used_asset_details() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(), 60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		// fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(assetCreation.AssetCode);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
		// fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);

	}

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
		waithelper.waitForElementVisible(driver.findElement(By.xpath(
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

	@Then("^Fill the Allocation form with impaired asset details$")
	public void fill_the_allocation_form_with_impaired_asset_details() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(), 60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		// fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(codeConfigData.get("AssetCode"));
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
		// fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);

	}

	// -------KUBS_FAT_UAT_006_004---------
	@And("^User get the revalued asset for allocation$")
	public void user_get_the_revalued_asset_for_allocation() throws Throwable {
		waithelper.waitForElementVisible(driver.findElement(By.xpath(
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

	@Then("^Fill the Allocation form with revalued asset details$")
	public void fill_the_allocation_form_with_revalued_asset_details() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(), 60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
		Thread.sleep(1000);
		// fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(codeConfigData.get("AssetCode"));
		fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
		// fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
		fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID(),
				60, 5);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
		Thread.sleep(1000);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
		fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);

	}

	// --------KUBS_FAT_UAT_002_008-----
	@Then("^Click on Job Scheduler$")
	public void click_on_job_scheduler() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.JobScheduler_Button(), 60, 5);
		fixedAssetObj.JobScheduler_Button().click();
	}

	@Then("^Click on Job Execution edit button$")
	public void click_on_job_execution_edit_button() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.JobExecution_EditButton(), 60, 5);
		fixedAssetObj.JobExecution_EditButton().click();
	}

	@Then("^Click on calander to set desire date$")
	public void click_on_calander_to_set_desire_date() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.JobExecution_ToDateCalanderButton(), 60,
				5);
		fixedAssetObj.JobExecution_ToDateCalanderButton().click();
		Thread.sleep(2000);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(
						driver, driver.findElement(By.xpath("//span[contains(text(),'"
								+ fixedAssetTestDataType.GlToMonth + " " + fixedAssetTestDataType.GlYear + "')]")),
						60, 5);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ fixedAssetTestDataType.GlToMonth + " " + fixedAssetTestDataType.GlYear + "')]"));
				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				fixedAssetObj.inventoryNextMonth().click();
			}
		}
		Thread.sleep(2000);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + fixedAssetTestDataType.GlFullToMonth
				+ " " + fixedAssetTestDataType.GlToDate + ", " + fixedAssetTestDataType.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);

	}

	@Then("^click on Start the job$")
	public void click_on_start_the_job() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.JobExecution_StartJobButton(), 60, 5);
		fixedAssetObj.JobExecution_StartJobButton().click();
		Thread.sleep(2000);
	}

	@Then("^Click on refresh button$")
	public void click_on_refresh_button() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.JobExecution_RefreshButton(), 60, 5);
		fixedAssetObj.JobExecution_RefreshButton().click();
	}

	@Then("^login with maker to check if date is changed or not$")
	public void login_with_maker_to_check_if_date_is_changed_or_not() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	// ------------------KUBS_FAT_UAT_013_007-------
	@Then("^Click on Asset Creation Common Edit Grid$")
	public void click_on_asset_creation_common_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(fixedAssetObj.Report_report_AssetCreationCommon_editButton());
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_editButton(), 60, 5);
		fixedAssetObj.Report_report_AssetCreationCommon_editButton().click();

	}

	@Then("^Fill the form$")
	public void fill_the_form() throws Throwable {
		fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit(), 60, 5);
		fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().click();

		fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().sendKeys(fixedAssetTestDataType.AssetLife);
		fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_Calendar(), 60, 5);
		fixedAssetObj.Report_report_AssetCreationCommon_Calendar().click();

		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + inventoryManagementTestDataType.GlToMonth + " "
										+ inventoryManagementTestDataType.GlYear + "')]")),
						60, 5);
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + inventoryManagementTestDataType.GlToMonth
								+ " " + inventoryManagementTestDataType.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ inventoryManagementTestDataType.GlFullToMonth + " " + inventoryManagementTestDataType.GlToDate + ", "
				+ inventoryManagementTestDataType.GlYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@Then("^Click on view button to see Asset Creation report$")
	public void click_on_view_button_to_see_asset_creation_report() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.Report_report_AssetCreationCommon_ViewButton(), 60, 5);
		fixedAssetObj.Report_report_AssetCreationCommon_ViewButton().click();

	}

}
