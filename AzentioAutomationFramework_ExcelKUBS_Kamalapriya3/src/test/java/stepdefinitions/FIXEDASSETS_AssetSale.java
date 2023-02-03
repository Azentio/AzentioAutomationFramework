package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSETS_AssetSaleTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSETS_AssetSale {

	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	FIXEDASSETS_AssetSaleTestDataType fIXEDASSETS_AssetSaleTestDataType = jsonReader.getAssetSaledata("Maker");
	FixedAsset_AssetCreationTestDataType assetCreation = jsonReader.getAssetCreationByName("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Map<String, String> assetSaleTestData = new HashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDatForAssetSale = new ExcelData(path, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDatForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDatForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");

	@And("^user should navigate to fixed asset menu$")
	public void user_should_navigate_to_fixed_asset_menu() throws InterruptedException {
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_DirectionButton(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_DirectionButton().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.fixedAssets_Menu(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_Menu().click();
	}

	@When("^click on eye button of asset sale$")
	public void click_on_eye_button_of_asset_sale() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_EyeButton(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_EyeButton().click();
	}

	@And("^click on add button to create sale asset record$")
	public void click_on_add_button_to_create_sale_asset_record() {
		// waithelper.waitForElementToVisibleWithFluentWait(driver,
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AddButton(),60,5);
		for (int i = 0; i < 30; i++) {
			try {
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("Add icon not clicked");
				}
			}
		}

	}

//New With excel Start
	@And("^get the test data for asset sale with high price from excel database$")
	public void get_the_test_data_for_asset_sale_with_high_price_from_excel_database() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_001_01_D1");
	}
	 @And("^get the test data for creation of asset sale from excel database$")
	    public void get_the_test_data_for_creation_of_asset_sale_from_excel_database() throws Throwable {
			assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UATD_004_003_01_D11");

	 }
	@And("^get the test data for asset sale from excel database for the pre requisite of asset revaluation$")
    public void get_the_test_data_for_asset_sale_from_excel_database_for_the_pre_requisite_of_asset_revaluation() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D3");
    }
	@And("^get the test data for asset sale with high price from excel database for asset impairment prerequsite$")
    public void get_the_test_data_for_asset_sale_with_high_price_from_excel_database_for_asset_impairment_prerequsite() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D2");
    }
	@And("^get the test data for asset sale with low price from excel database$")
	public void get_the_test_data_for_asset_sale_with_low_price_from_excel_database() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D1");
	}

	@Then("^verify maker user can able to see the approved asset sale record which is sold at high price in maker list view$")
	public void verify_maker_user_can_able_to_see_the_approved_asset_sale_record_which_is_sold_at_high_price_in_maker_list_view()
			throws Throwable {
		String xpath = "//span[text()=' " + assetSaleTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell//ion-button[1]";
		for (int i = 0; i <= 100; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				driver.findElement(By.xpath(xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@Then("^verify approved Asset item number is available in approved asset sale record$")
	public void verify_approved_asset_item_number_is_available_in_approved_asset_sale_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.assetSaleApprovedItemNumber(),
				20, 1);

		Assert.assertEquals(fIXEDASSETS_AssetSaleObj.assetSaleApprovedItemNumber().getText(),
				assetSaleTestData.get("AssetItemNumber"));
	}

	@And("^enter the asset reference number in asset sale$")
	public void enter_the_asset_reference_number_in_asset_sale() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + assetSaleTestData.get("AssetReferenceNumber") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber()
				.sendKeys(assetSaleTestData.get("AssetReferenceNumber"));

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

	@And("^enter the asset item number in asset sale module$")
	public void enter_the_asset_item_number_in_asset_sale_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + assetSaleTestData.get("AssetItemNumber") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(assetSaleTestData.get("AssetItemNumber"));
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

	@And("^enter the asset sale value which is sold in high price$")
	public void enter_the_asset_sale_value_which_is_sold_in_high_price() throws Throwable {

		int assetSalevalue = Integer.parseInt(assetSaleTestData.get("Salevalue")) * 1000000000;

		String assetValueStr = String.valueOf(assetSalevalue);
		System.out.println(assetValueStr);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(assetValueStr);
	}
	@And("^enter the asset sale value in asset module$")
    public void enter_the_asset_sale_value_in_asset_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(assetSaleTestData.get("Salevalue"));
	}

	@And("^enter the asset sale value which is sold in low price$")
	public void enter_the_asset_sale_value_which_is_sold_in_low_price() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(assetSaleTestData.get("Salevalue"));
	}

	@And("^choose the actionable by in asset sale module$")
	public void choose_the_actionable_by_in_asset_sale_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + assetSaleTestData.get("ActionableBy") + "']";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(assetSaleTestData.get("ActionableBy"));
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

	@And("^and enter the remark in asset sale module$")
	public void and_enter_the_remark_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(assetSaleTestData.get("Remark"));
	}

	@And("^save the asset sale value record$")
	public void save_the_asset_sale_value_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^click on search in maker notification section$")
	public void click_on_search_in_maker_notification_section() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationSearchButton(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(kubsCommonObj.kubsNotificationSearchButton());
				clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsNotificationSearchButton());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^search the asset sale module code in notification$")
	public void search_the_asset_sale_module_code_in_notification() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
//assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetSaleTestData.get("ModuleCode"));
	}

	@And("^store the asset sale reference number which is sold at high price$")
	public void store_the_asset_sale_reference_number_which_is_sold_at_high_price() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber(),
				20, 1);
		excelDatForAssetSale.updateTestData("KUBS_FAT_UAT_004_001_01_D1", "Reference ID",
				fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber().getText());
	}

    @And("^store the asset sale reference number for creation of asset sale$")
    public void store_the_asset_sale_reference_number_for_creation_of_asset_sale() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber(),
				20, 1);
		excelDatForAssetSale.updateTestData("KUBS_FAT_UATD_004_003_01_D11", "Reference ID",
				fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber().getText());    }

	@And("^store the asset sale reference number which is sold at low price$")
	public void store_the_asset_sale_reference_number_which_is_sold_at_low_price() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber(),
				20, 1);
		excelDatForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D1", "Reference ID",
				fIXEDASSETS_AssetSaleObj.assetSaleReferenceNumber().getText());
	}

	@And("^select the asset sale value record$")
	public void select_the_asset_sale_value_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.assetSaleNotificationFirstRecord(), 20, 1);
		fIXEDASSETS_AssetSaleObj.assetSaleNotificationFirstRecord().click();

	}

	@And("^click on submit button in asset sale module$")
	public void click_on_submit_button_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset sale record$")
	public void enter_the_alert_remark_in_asset_sale_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetSaleTestData.get("MakerRemark"));
	}

	@And("^click on alet submit button in asset sale module$")
	public void click_on_alet_submit_button_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		kubsCommonObj.kubsAlertSubmit().click();

	}

	@And("^store the reviewer id in asset sale module excel database$")
	public void store_the_reviewer_id_in_asset_sale_module_excel_database() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDatForAssetSale.updateTestData("KUBS_FAT_UAT_004_001_01_D1", "Reviewer ID", reviewerID);

	}
	 @And("^store the reviewer id in creation asset sale module excel database$")
	    public void store_the_reviewer_id_in_creation_asset_sale_module_excel_database() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
			String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
			excelDatForAssetSale.updateTestData("KUBS_FAT_UATD_004_003_01_D11", "Reviewer ID", reviewerID);
	 }

	    @And("^Store the asset reference number and asset item number of asset sale in asset allocation excel database$")
	    public void store_the_asset_reference_number_and_asset_item_number_of_asset_sale_in_asset_allocation_excel_database() throws Throwable {
	    	excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_003_D11", "AssetReferenceNumber", assetSaleTestData.get("AssetReferenceNumber"));
	    	excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_003_D11", "AssetItemNumber", assetSaleTestData.get("AssetItemNumber"));  
	    }
	
	@And("^store the asset reference number and item number of sale asset in revaluation excel database$")
    public void store_the_asset_reference_number_and_item_number_of_sale_asset_in_revaluation_excel_database() throws Throwable {
		excelDatForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_07_D1", "AssetReferenceNumber", assetSaleTestData.get("AssetReferenceNumber"));
		excelDatForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_07_D1", "AssetItemNumber", assetSaleTestData.get("AssetItemNumber"));
    }
	@And("^store the asset reference number and item number of sold asset in impairment excel database$")
    public void store_the_asset_reference_number_and_item_number_of_sold_asset_in_impairment_excel_database() throws Throwable {
		excelDatForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_008_01_D1", "AssetReferenceNumber", assetSaleTestData.get("AssetReferenceNumber"));
		excelDatForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_008_01_D1", "AssetItemNumber", assetSaleTestData.get("AssetItemNumber"));
    }
	@And("^store the reviewer id in asset sale module excel database  which is sold at low price$")
	public void store_the_reviewer_id_in_asset_sale_module_excel_database_which_is_sold_at_low_price()
			throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDatForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D1", "Reviewer ID", reviewerID);
	}

// asset sale -excel end
	@And("^get the asset reference number for asset sale$")
	public void get_the_asset_reference_number_for_asset_sale() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssetNewAssetReferenceNumber(), 20, 1);

		assetSaleTestData.put("NewAssetReferenceNumber",
				fIXEDASSETS_AssetSaleObj.fixedAssetNewAssetReferenceNumber().getText());
	}

	@And("^choose the asset item number in asset sale$")
	public void choose_the_asset_item_number_in_asset_sale() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		Thread.sleep(500);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.DOWN);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);
	}

	@And("^enter asset sale ammount in asset sale module$")
	public void enter_asset_sale_ammount_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.SaleValue);
	}

	@And("^choose the actionable in asset sale module$")
	public void choose_the_actionable_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().click();
		Thread.sleep(500);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.DOWN);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);
	}

	@And("^enter the remark in asset sale module$")
	public void enter_the_remark_in_asset_sale_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark(), 20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Remark);
	}

	@And("^save the asset sale record$")
	public void save_the_asset_sale_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save(),
				20, 1);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save().click();
	}

	@And("^Fill the required fields to sale asset in profit$")
	public void fill_the_required_fields_to_sale_asset_in_profit() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber(), 60, 5);
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.AssetReferenceNumberForProfit);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(assetCreation.AssetCode);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(Keys.ENTER);

		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.DOWN);
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ItemNumber);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.SaleValue);

		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Currency);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.ActionableBy);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Remark);
	}

	@And("^Fill the required fields to sale asset in loss$")
	public void fill_the_required_fields_to_sale_asset_in_loss() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber(), 30, 2);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.AssetReferenceNumberForLoss);
		Thread.sleep(1000);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(Keys.ENTER);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber(), 30, 2);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		Thread.sleep(1000);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.DOWN);
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ItemNumberForLoss);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 30, 2);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.SaleValue);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency(), 30, 2);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().click();
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Currency);
		Thread.sleep(1000);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy(), 30, 2);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.ActionableBy);
		Thread.sleep(1000);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Remark);
	}

	@Then("^Save and submit the asset sale record$")
	public void save_and_submit_the_asset_sale_record() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save(),
				60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		// waithelper.waitForElementToVisibleWithFluentWait(driver,
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton(),60,5);
		for (int i = 0; i < 30; i++) {
			try {
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("Inbox Icon not clicked ");
				}
			}
		}

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId(), 60, 5);
		String id = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(
						By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")), 60, 5);
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				waithelper.waitForElementToVisibleWithFluentWait(driver, referanceID, 60, 5);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton(), 60, 5);
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)), 60, 5);
		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
		// Thread.sleep(1000);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField(), 60, 5);
		javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField()
				.sendKeys(fIXEDASSETS_AssetSaleTestDataType.RemarkByMaker);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();

		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus(), 60, 5);
		WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);

		String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
		System.out.println(message);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
	}

	@Then("^checker should approved the asset sale$")
	public void checker_should_approved_the_asset_sale() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				+ jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")),
				60, 5);
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
//    	waithelper.waitForElementToVisibleWithFluentWait(driver, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton(),60,5);
//    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
//		Thread.sleep(2000);
//		waithelper.waitForElementToVisibleWithFluentWait(driver,  driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")),60,5);
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerApproveButton(), 60, 5);
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerRemarks(), 60, 5);
		kubschecker.checkerRemarks().sendKeys(fIXEDASSETS_AssetSaleTestDataType.CheckerRemark);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkersubmitButton(), 60, 5);
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus(), 60, 5);
		WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
		System.out.println(message);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();

	}

	@Then("^click on first eye button to get the profit earned$")
	public void click_on_first_eye_button_to_get_the_profit_earned() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();

		String bv = javascripthelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value")
				.toString();
		Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
		System.out.println("Book value is: " + bookvalue);

		String sv = javascripthelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value")
				.toString();
		Double salevalue = Double.parseDouble(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " + salevalue);

		String pft = javascripthelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[2].value")
				.toString();
		Double profit = Double.parseDouble(pft.replaceAll("[^0-9/.]", ""));

		profit = salevalue - bookvalue;
		System.out.println("Profit earned is : " + profit);

//    	String loss = javascripthelper.executeScript("return document.getElementsByTagName('input')[17].value").toString();
//    	System.out.println("Loss accrued is: " +loss);

	}

	@Then("^click on first eye button to get the loss earned$")
	public void click_on_first_eye_button_to_get_the_loss_earned() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL(), 60, 5);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();

		String bv = javascripthelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value")
				.toString();
		Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
		System.out.println("Book value is: " + bookvalue);

		String sv = javascripthelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value")
				.toString();
		Double salevalue = Double.valueOf(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " + salevalue);

		String loss1 = javascripthelper.executeScript("return document.getElementsByTagName('input')[17].value")
				.toString();
		Double loss = Double.valueOf(loss1.replaceAll("[^0-9/.]", ""));

		loss = bookvalue - salevalue;
		System.out.println("Loss accrued is: " + loss);

	}

}
