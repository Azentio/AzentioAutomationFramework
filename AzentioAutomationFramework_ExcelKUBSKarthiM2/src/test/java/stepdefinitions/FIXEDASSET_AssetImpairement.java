package stepdefinitions;

import java.time.LocalDate;
import java.time.Month;
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

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
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
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

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
	FIXEDASSET_AssetImpairementTestDataType fixedAssetImairementTestData = jsonConfig
			.getFixedAssetTestDataByName("Maker");
	FIXEDASSET_AssetAllocationObj assetAllocationObj = new FIXEDASSET_AssetAllocationObj(driver);
	FIXED_ASSET_AssetDeAllocationObj deAllocationObj = new FIXED_ASSET_AssetDeAllocationObj(driver);
	FIXEDASSET_AssetTransferObj assetTransferObj = new FIXEDASSET_AssetTransferObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig
			.getAssetCreationByName("Maker");
	public String assetLife;
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	Map<String, String> impairmentTestData = new HashMap<String, String>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetTransfer = new ExcelData(path, "FixedAsset_AssetTransfer", "DataSet ID");
	//K
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","WriteOffTestData","Data Set ID");
	Map<String, String> testData;

	@Given("^Navigate to KUBS URL and login with maker credentials$")
	public void navigate_to_kubs_url_and_login_with_maker_credentials() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();

	}

	@And("^click on fixed asset main module$")
	public synchronized void click_on_fixed_asset_main_module() throws Throwable {
		waitHelper.waitForElementVisible(KubsMakerObj.kubsDirectionIcon(), 1000, 100);
		Thread.sleep(1000);
		KubsMakerObj.kubsDirectionIcon().click();
		Thread.sleep(2000);
		// waitHelper.waitForElementVisible(KubsMakerObj.kubsFixedAssets(), 1000, 100);
		while (true) {
			try {
				KubsMakerObj.kubsFixedAssets().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
//				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

	@And("^click on fixed asset main Module$")
	public synchronized void click_on_fixed_asset_main_Module() throws Throwable {
		// waitHelper.waitForElementVisible(KubsMakerObj.kubsDirectionIcon(), 1000,
		// 100);
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(KubsMakerObj.kubsDirectionIcon());
		KubsMakerObj.kubsDirectionIcon().click();
		// waitHelper.waitForElementVisible(KubsMakerObj.kubsFixedAssets(), 1000, 100);
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
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetAssetCreationViewButton(), 1000, 100);
		fixedAssetObj.fixedAssetAssetCreationViewButton().click();

	}

	@Then("^search the asset reference number in asset Creation$")
	public void search_the_asset_reference_number_in_asset_creation() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(By.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.writeOffAssetRefNo
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);

	}

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
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetItemRecord(), 2000, 100);
		fixedAssetObj.fixedAssetItemRecord().click();
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		String capitalizationDatedate = javascriptHelper
				.executeScript("return document.getElementsByClassName('form-control p-0')[1].value").toString();
		String assetLifePeriod = javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[8].value")
				.toString();
		int assetLifePeriodIntegerValue = Integer.parseInt(assetLifePeriod);
		int finalAssetLife = assetLifePeriodIntegerValue * 365;
		int finalAssetLifeMonth = assetLifePeriodIntegerValue * 30;
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSystemDate(), 1000, 100);
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
		int SystemDay = Integer.parseInt(systemdate[0]);
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
		Thread.sleep(1000);
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
		Thread.sleep(500);
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
//		Thread.sleep(500);
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetReValuationReferenceNumber(), 3000, 300);
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAssetAssetReferenceNumStatus(), 20,
				1);
		javascriptHelper.scrollIntoViewAndClick(fixedAssetObj.fixedAssetAssetReferenceNumStatus());
		fixedAssetObj.fixedAssetAssetReferenceNumStatus().sendKeys("Active");
		Thread.sleep(500);
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
		Thread.sleep(500);
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

	@Then("^check asset reference number is availabe in the list view$")
	public void check_asset_reference_number_is_availabe_in_the_list_view() throws Throwable {
		// span[contains(text(),'01-ASTSBCTGRY001-Lockers_AZENTMAIN_10')]
		while (true) {
			try {
				driver.findElement(
						By.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNo + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

	@Then("^check asset reference number of de allocated asset is availabe in the list view$")
	public void check_asset_reference_number_of_de_allocated_asset_is_availabe_in_the_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath("//span[contains(text(),'"
						+ fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate + "')]")).isDisplayed();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}

	}

	@Then("^search the asset reference number of revalued is availabe in list view$")
	public void search_the_asset_code_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefRevalued);
		for (int i = 0; i < 3; i++) {
			try {
				driver.findElement(By.xpath(
						"//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefRevalued + "')]"))
						.isDisplayed();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}

	}

	@Then("^search the asset reference number of ammendent asset is availabe in list view$")
	public void search_the_asset_reference_number_of_ammendent_asset_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoAmmendent);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath(
						"//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoAmmendent + "')]"))
						.isDisplayed();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}
	}

	@Then("^search the asset reference number of replacement asset is availabe in list view$")
	public void search_the_asset_reference_number_of_replacement_asset_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
		fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
		fixedAssetObj.AssetReplacementAssetRefNoSearch()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReplacement);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath("//span[contains(text(),'"
						+ fixedAssetImairementTestData.allocatedAssetRefNoReplacement + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}
	}

	@Then("^search the asset reference number of returned asset is availabe in list view$")
	public void search_the_asset_reference_number_of_returned_asset_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
		fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
		fixedAssetObj.AssetReplacementAssetRefNoSearch()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReturn);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath(
						"//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoReturn + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}
	}

	@Then("^search the asset reference number of sale asset is availabe in list view$")
	public void search_the_asset_reference_number_of_sale_asset_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
		fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
		fixedAssetObj.AssetReplacementAssetRefNoSearch().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoSale);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath(
						"//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoSale + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}
	}

	@Then("^search the asset reference number of transfered asset is availabe in list view$")
	public void search_the_asset_reference_number_of_transfered_asset_is_availabe_in_list_view() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
		fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
		fixedAssetObj.AssetReplacementAssetRefNoSearch()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoTransfer);
		for (int i = 0; i < 3; i++) {
			try {
				boolean result = driver.findElement(By.xpath(
						"//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoTransfer + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				if (i > 1) {
					Assert.fail("Asset Reference number not available");

				}

			}
		}
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
		// waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetViewIcon(),
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
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D1");
	}

	@And("^get the test data for impairment asset from excel database for the prerequisite of asset transfer$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequisite_of_asset_transfer()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D4");
	}

	@And("^get the test data for impairment asset from excel database for the prerequisite of asset revaluation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D3");
	}

	@And("^get the test data for impairment asset from excel database for the prerequsite of asset return$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_for_the_prerequsite_of_asset_return()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D2");
	}

	@And("^get the test data for impairment asset from excel database which is already done one asset allocation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_one_asset_allocation()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_002_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset de allocation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_de_allocation()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_003_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset revaluation$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_revaluation()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_004_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset ammendment$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_ammendment()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_005_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset replacement maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_replacement_maker_part()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_006_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset return maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_return_maker_part()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_007_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset Sale maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_sale_maker_part()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_008_01_D1");
	}

	@And("^get the test data for impairment asset from excel database which is already done on asset Transfer maker part$")
	public void get_the_test_data_for_impairment_asset_from_excel_database_which_is_already_done_on_asset_transfer_maker_part()
			throws Throwable {
		impairmentTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_009_01_D1");
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

	@And("^store the impaired asset reference number and item number in asset transfer exceldatabase$")
	public void store_the_impaired_asset_reference_number_and_item_number_in_asset_transfer_exceldatabase()
			throws Throwable {
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_002_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetTransfer.updateTestData("KUBS_FAT_UAT_005_002_D1", "AssetItemNumber",
				impairmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of impaired asset in assetrevaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_impaired_asset_in_assetrevaluation_excel_database()
			throws Throwable {
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_04_D1", "AssetReferenceNumber",
				impairmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_04_D1", "AssetItemNumber",
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchIcon(), 20, 1);
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.fixedAssetAssetSaleTempView(), 20,
				1);
		assetImpairementObj.fixedAssetAssetSaleTempView().click();
	}

	@And("^get the asset reference number which is submitted now$")
	public void get_the_asset_reference_number_which_is_submitted_now() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				assetImpairementObj.fixedAssetTempViewFirstAssetReferenceNumber(), 20, 1);
		impairementData.put("assetReferenceNumber",
				assetImpairementObj.fixedAssetTempViewFirstAssetReferenceNumber().getText());
	}

	@Then("^Check System shuld display the input fields$")
	public void check_system_shuld_display_the_input_fields() throws Throwable {
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetReferenceNumber(), 1000, 100);
		Assert.assertTrue(assetImpairementObj.fixedAssetReferenceNumber().isDisplayed());
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetAssetItemNo(), 1000, 100);
		Assert.assertTrue(assetImpairementObj.fixedAssetAssetItemNo().isDisplayed());

	}

	@And("^select asset reference number of ammendent assset in write off$")
	public void select_asset_reference_number_of_ammendent_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffAmmendentAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number of replacement assset in write off$")
	public void select_asset_reference_number_of_replacement_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffReplacementAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number of allocated assset in write off$")
	public void select_asset_reference_number_of_allocated_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number of deallocated assset in write off$")
	public void select_asset_reference_number_of_deallocated_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number$")
	public void select_asset_reference_number() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.fixedAssetReferenceNumber(), 20,
				1);
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
		Thread.sleep(500);
		// assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);

	}

	@And("^select the asset reference number of allocated asset$")
	public void select_the_asset_reference_number_of_allocated_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNo);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select the asset reference number of deallocated asset$")
	public void select_the_asset_reference_number_of_deallocated_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset reference number of revalued asset$")
	public void choose_the_asset_reference_number_of_revalued_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefRevalued);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset reference number of ammendent asset$")
	public void choose_the_asset_reference_number_of_ammendent_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoAmmendent);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset reference number of replaced asset$")
	public void choose_the_asset_reference_number_of_replaced_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReplacement);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset reference number of returned asset$")
	public void choose_the_asset_reference_number_of_returned_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReturn);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset reference number of sold asset$")
	public void choose_the_asset_reference_number_of_sold_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoSale);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number for write Off$")
	public void select_asset_reference_number_for_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@Then("^search the asset reference number which we going to do impairement$")
	public void search_the_asset_reference_number_which_we_going_to_do_impairement() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber);
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(
				By.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@Then("^search the asset reference number which we going to do revaluation$")
	public void search_the_asset_reference_number_which_we_going_to_do_revaluation() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(testData.get("writeOffRevaluedAssetReferenceNumber"));
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(
				By.xpath("//span[contains(text(),'" + testData.get("writeOffRevaluedAssetReferenceNumber")
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@Then("^search the asset reference number which we going to do ammendent$")
	public void search_the_asset_reference_number_which_we_going_to_do_ammendent() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(testData.get("writeOffAmmendentAssetReferenceNumber"));
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(
				By.xpath("//span[contains(text(),'" + testData.get("writeOffAmmendentAssetReferenceNumber")
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@Then("^search the asset reference number which we going to do replacement$")
	public void search_the_asset_reference_number_which_we_going_to_do_replacement() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(fixedAssetImairementTestData.writeOffReplacementAssetReferenceNumber);
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(By
				.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.writeOffReplacementAssetReferenceNumber
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@Then("^search the asset reference number which we going to do allocation$")
	public void search_the_asset_reference_number_which_we_going_to_do_allocation() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber);
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(
				By.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@Then("^search the asset reference number which we going to do undertaking$")
	public void search_the_asset_reference_number_which_we_going_to_do_undertaking() throws Throwable {
		fixedAssetObj.fixedAssetSearchIcon().click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
		fixedAssetObj.fixedAssetSearchRefNo().click();
		fixedAssetObj.fixedAssetSearchRefNo()
				.sendKeys(fixedAssetImairementTestData.writeOffUnderTakingdAssetReferenceNumber);
		// ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
		driver.findElement(By.xpath(
				"//span[contains(text(),'" + fixedAssetImairementTestData.writeOffUnderTakingdAssetReferenceNumber
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
				.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);

		assetLife = fixedAssetObj.fixedAssetLife().getText();
		System.out.println("Asset Life Is" + assetLife);
	}

	@And("^goto assetallocation module$")
	public void goto_assetallocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(assetAllocationObj.fixedAssetAssetAllocationView());
		waitHelper.waitForElementVisible(assetAllocationObj.fixedAssetAssetAllocationView(), 2000, 200);
		assetAllocationObj.fixedAssetAssetAllocationView().click();
	}

	@And("^enter reference number$")
	public void enter_reference_number() throws Throwable {
		waitHelper.waitForElementVisible(assetAllocationObj.fixedAssetAssetAllocationReferenceNumber(), 2000, 100);
		assetAllocationObj.fixedAssetAssetAllocationReferenceNumber().click();
		assetAllocationObj.fixedAssetAssetAllocationReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber);
		assetAllocationObj.fixedAssetAssetAllocationReferenceNumber().sendKeys(Keys.ENTER);

	}

	@And("^enter item number in allocation module$")
	public void enter_item_number_in_allocation_module() throws Throwable {
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().click();
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().sendKeys(Keys.DOWN);
		assetAllocationObj.fixedAssetAssetAllocationItemNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the employee$")
	public void choose_the_employee() throws Throwable {
		assetAllocationObj.fixedAsset_AssetAllocationEmployeeName().click();
		assetAllocationObj.fixedAsset_AssetAllocationEmployeeName()
				.sendKeys(fixedAssetImairementTestData.AllocationEmployeeName);
		assetAllocationObj.fixedAsset_AssetAllocationEmployeeName().sendKeys(Keys.ENTER);
	}

	@Then("^save the record$")
	public void save_the_record() throws Throwable {
		waitHelper.waitForElementVisible(assetAllocationObj.fixedAssetAssetAllocationSaveButton(), 2000, 200);
		assetAllocationObj.fixedAssetAssetAllocationSaveButton().click();

	}

	@And("^goto asset deallocation module$")
	public void goto_asset_deallocation_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon());
		waitHelper.waitForElementVisible(deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon(), 2000, 200);
		deAllocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
	}

	@And("^enter asset reference number for de allocation$")
	public void enter_asset_reference_number_for_de_allocation() throws Throwable {
		waitHelper.waitForElementVisible(deAllocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(), 3000,
				300);
		deAllocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
		deAllocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffAllocatedAssetReferenceNumber);
		deAllocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);

	}

	@And("^enter asset item number for de allocation$")
	public void enter_asset_item_number_for_de_allocation() throws Throwable {
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
		deAllocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
	}

	@And("^save the asset deallocation record$")
	public void save_the_asset_deallocation_record() throws Throwable {
		waitHelper.waitForElementVisible(deAllocationObj.fixedAssetDeAllocationSaveButton(), 2000, 200);
		deAllocationObj.fixedAssetDeAllocationSaveButton().click();
	}

	@And("^go to asset undertaking module$")
	public void go_to_asset_undertaking_module() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.assetUndertakingViewButton(), 2000, 200);
		assetTransferObj.assetUndertakingViewButton().click();
	}

	@And("^check the asset reference number is available in the undertaking module$")
	public void check_the_asset_reference_number_is_available_in_the_undertaking_module() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.searchUndertakingAssetReferenceNumber(), 2000, 200);
		assetTransferObj.searchUndertakingAssetReferenceNumber().click();
		assetTransferObj.searchUndertakingAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffUnderTakingdAssetReferenceNumber);
		// span[contains(text(),'MACHINARY-GENERATOR-UPS_BR0005_129')]
		driver.findElement(By.xpath("//span[contains(text(),'"
				+ fixedAssetImairementTestData.writeOffUnderTakingdAssetReferenceNumber + "')]"));
	}

	@And("^Goto Asset Transfer$")
	public void goto_asset_transfer() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(assetTransferObj.fixedAssetAssetTransferViewButton(), 2000, 200);
		assetTransferObj.fixedAssetAssetTransferViewButton().click();
	}

	@And("^enter asset reerence Number$")
	public void enter_asset_reerence_number() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.fixedAssetAssetTransferReferenceNumber(), 3000, 300);
		assetTransferObj.fixedAssetAssetTransferReferenceNumber().click();
		assetTransferObj.fixedAssetAssetTransferReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffUnderTakingdAssetReferenceNumber);
		assetTransferObj.fixedAssetAssetTransferReferenceNumber().sendKeys(Keys.ENTER);
		// assetTransferObj.fixedAssetAssetTransferReferenceNumber().sendKeys(Keys.DOWN);

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
		waitHelper.waitForElementVisible(assetTransferObj.fixedAssetTransferYes(), 3000, 200);
		assetTransferObj.fixedAssetTransferYes().click();
		assetTransferObj.fixedAssetTransferSaveButton().click();
	}

	@And("^enter transfer as yes and save the record in second reviewer$")
	public void enter_transfer_as_yes_and_save_the_record_in_second_reviewer() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.fixedAssetTransferButton(), 2000, 100);
		assetTransferObj.fixedAssetTransferButton().click();
		waitHelper.waitForElementVisible(assetTransferObj.fixedAssetTransferYes(), 3000, 200);
		assetTransferObj.fixedAssetTransferYes().click();
		Thread.sleep(1000);
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

	@And("^choose the asset reference number of transfered asset$")
	public void choose_the_asset_reference_number_of_transfered_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoTransfer);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number of expaired asset$")
	public void select_asset_reference_number_of_expaired_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select asset reference number for revalued assset in write off$")
	public void select_asset_reference_number_for_revalued_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(testData.get("writeOffRevaluedAssetReferenceNumber"));
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the asset Item no$")
	public void choose_the_asset_no() throws Throwable {
		assetImpairementObj.fixedAssetAssetItemNo().click();
		Thread.sleep(500);
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.DOWN);
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.ENTER);

	}

	@Then("^Give Asset Referance Number of revaluation$")
	public void give_asset_referance_number_of_revaluation() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(testData.get("writeOffRevaluedAssetReferenceNumber"));
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Asset Referance Number in ammendent asset for doing write off$")
	public void enter_asset_referance_number_in_ammendent_asset_for_doing_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber()
				.sendKeys(testData.get("writeOffAmmendentAssetReferenceNumber"));
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^select the asset reference number in asset impairment module$")
	public void select_the_asset_reference_number_in_asset_impairment_module() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.fixedAssetReferenceNumber(), 20,
				1);
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(impairmentTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + impairmentTestData.get("AssetReferenceNumber") + "']";
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.fixedAssetAssetItemNo(), 20, 1);
		System.out.println("Item number " + impairmentTestData.get("AssetItemNumber"));
		assetImpairementObj.fixedAssetAssetItemNo().click();
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(impairmentTestData.get("AssetItemNumber"));

		String xpath = "//ng-dropdown-panel//span[text()='" + impairmentTestData.get("AssetItemNumber") + "']";
		for (int i = 0; i <= 200; i++) {
			try {

				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^choose the transcation type as impairment$")
	public void choose_the_transcation_type_as_impairment() throws Throwable {
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetTransTypeImpairement(), 1000, 100);
		assetImpairementObj.fixedAssetTransTypeImpairement().click();
		String assetReferenceNumber = assetImpairementObj.fixedAssetGetReferenceNo().getText();
		impairementData.put("AssetReferenceNo", assetReferenceNumber);

	}

	@And("^click on save button in impairment module$")
	public void click_on_save_button_in_impairment_module() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset asset impairment module code in notification$")
	public void search_the_asset_asset_impairment_module_code_in_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(impairmentTestData.get("ModuleCode"));
	}

	@And("^store the asset impairment reference number in impairment excel database$")
	public void store_the_asset_impairment_reference_number_in_impairment_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.assetImapirmentReferenceNumber(),
				20, 1);

		excelDataForAssetImpairment.updateTestData(impairmentTestData.get("DataSet ID"), "Reference ID",
				assetImpairementObj.assetImapirmentReferenceNumber().getText());
	}

	@And("^select the asset impairment record from notification$")
	public void select_the_asset_impairment_record_from_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				assetImpairementObj.assetImpairmentNotificationFirstRecord(), 20, 1);
		assetImpairementObj.assetImpairmentNotificationFirstRecord().click();
	}

	@And("^click on submit in asset impairment$")
	public void click_on_submit_in_asset_impairment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset impairment$")
	public void enter_the_alert_remark_in_asset_impairment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(impairmentTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in asset impairment$")
	public void click_on_alert_submit_in_asset_impairment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
	}

	@And("^store the reviewer ID in asset impairment excel database$")
	public void store_the_reviewer_id_in_asset_impairment_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetImpairment.updateTestData(impairmentTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
	}

	// End
	@And("^choose the transcation type as writeOff$")
	public void choose_the_transcation_type_as_writeoff() throws Throwable {
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetTransTypeWriteOff(), 1000, 100);
		assetImpairementObj.fixedAssetTransTypeWriteOff().click();
		String assetReferenceNumber = assetImpairementObj.fixedAssetGetReferenceNo().getText();
		impairementData.put("AssetReferenceNo", assetReferenceNumber);
	}

	@And("^check the book value of asset$")
	public void check_the_book_value_of_asset() throws Throwable {
		assetImpairementObj.fixedAssetBookValue().clear();
		assetImpairementObj.fixedAssetBookValue().sendKeys(fixedAssetImairementTestData.bookValue);

	}

	@Then("^click on Save Button$")
	public void click_on_save_button() throws Throwable {

		for (int i = 0; i < 5; i++) {
			try {
				if (i == 4) {
					Assert.fail("Save button not able to click");
				}
				waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetSaveButton(), 1000, 100);
				assetImpairementObj.fixedAssetSaveButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Then("^verify user can able to get the successfull saved message$")
	public void verify_user_can_able_to_get_the_successfull_saved_message() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.kubsToastAlert(), 20, 1);
		Assert.assertEquals(assetImpairementObj.kubsToastAlert().getText(),
				"Workflow initiated submit record from inbox.");
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetImpairementObj.alertClose(), 20, 1);
		assetImpairementObj.alertClose().click();
	}

	@And("^login with Maker ID$")
	public void login_with_maker_id() throws Throwable {
		Thread.sleep(2000);
		kubsLogin.loginToAzentioAppByMaker();
	}

	@And("^get the transfered asset reference number which is submitted now$")
	public void get_the_transfered_asset_reference_number_which_is_submitted_now() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				assetImpairementObj.assetTransferTempViewAssetReferenceNumber(), 20, 1);
		impairementData.put("assetReferenceNumber",
				assetImpairementObj.assetTransferTempViewAssetReferenceNumber().getText());
	}

	@Then("^check the approved record is displayed in appeared in maker list view stage$")
	public void check_the_approved_record_is_displayed_in_appeared_in_maker_list_view_stage() throws Throwable {
		System.out.println(impairementData.get("AssetReferenceNo"));
		Thread.sleep(1000);
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
	@Then("^check the approved record is displayed in appeared in maker list view stage1$")
	public void check_the_approved_record_is_displayed_in_appeared_in_maker_list_view_stage1() throws Throwable {
		System.out.println(testData.get("AssetReferenceNo"));
		Thread.sleep(1000);
		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + testData.get("AssetReferenceNo") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

	@Then("^Validate whether the reference number is visible in dropdown$")
	public void validate_whether_the_reference_number_is_visible_in_dropdown() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
		boolean result = assetImpairementObj.fixedAssetNoList().isDisplayed();
		Assert.assertTrue(result);
	}

	/****** KUBS_FAT_UAT_010_009 *********/

	@And("^get the text of asset code$")
	public void get_the_text_of_asset_code() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.underTakingApprovedAssetCode(), 2000, 200);
		String assetCode = assetTransferObj.underTakingApprovedAssetCode().getText();
		String transferedBranch = assetTransferObj.fixedAssetAssetTransferBranch().getText();
		impairementData.put("AssetCode", assetCode);
		impairementData.put("TransferBranch", transferedBranch);
		System.out.println("AssetCode" + impairementData.get("AssetCode") + " Transfered Branch"
				+ impairementData.get("TransferBranch"));
	}

	@And("^get the text of asset code and transfered branch name$")
	public void select_the_record_and_get_the_transfered_branch_name() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.underTakingApprovedAssetCode(), 2000, 200);
		String assetCode = assetTransferObj.underTakingApprovedAssetCode().getText();
		String transferedBranch = assetTransferObj.underTakingTransferedBranch().getText();
		impairementData.put("AssetCode", assetCode);
		impairementData.put("TransferBranch", transferedBranch);
		System.out.println("AssetCode" + impairementData.get("AssetCode") + " Transfered Branch"
				+ impairementData.get("TransferBranch"));
	}

	@And("^choose configuration option$")
	public void choose_configuration_option() throws Throwable {
		waitHelper.waitForElementVisible(kubsMakerObj.kubsFinaceOption(), 2000, 200);
		kubsMakerObj.kubsFinaceOption().click();
		waitHelper.waitForElementVisible(KubsMakerObj.configurationMenu(), 2000, 200);
		kubsMakerObj.configurationMenu().click();
	}

	@And("^click on entity maintenece$")
	public void click_on_entity_maintenece() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.configEntityMainteneceMain(), 2000, 200);
		assetTransferObj.configEntityMainteneceMain().click();
		waitHelper.waitForElementVisible(assetTransferObj.configBranchEntityMaintenence(), 2000, 200);
		assetTransferObj.configBranchEntityMaintenence().click();
		// assetTransferObj.configEntityMainteneceDescription().sendKeys(impairementData.get("TransferBranch"));

	}

	@And("^click on view button near by legal entity branches$")
	public void click_on_view_button_near_by_legal_entity_branches() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.configBranchEntityMaintenence(), 2000, 200);
		assetTransferObj.configBranchEntityMaintenence().click();

	}

	@And("^search the brach name and get the branch code$")
	public void search_the_brach_name_and_get_the_branch_code() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.configEntityMainteneceDescription(), 2000, 200);
		assetTransferObj.configEntityMainteneceDescription().click();
		assetTransferObj.configEntityMainteneceDescription().sendKeys(impairementData.get("TransferBranch"));
		waitHelper.waitForElementVisible(assetTransferObj.configgetBranchCode(), 2000, 200);
		String branchCode = assetTransferObj.configgetBranchCode().getText();
		impairementData.put("BranchCode", branchCode);
		System.out.println("BranchCode is" + impairementData.get("BranchCode"));
	}

	@And("^choose finance option$")
	public void choose_finance_option() throws Throwable {

		waitHelper.waitForElementVisible(kubsMakerObj.kubsFinaceOption(), 2000, 200);
		kubsMakerObj.kubsFinaceOption().click();
		waitHelper.waitForElementVisible(kubsMakerObj.FinanceOption(), 2000, 200);
		kubsMakerObj.FinanceOption().click();
	}

	@And("^click on fixed asset configuration$")
	public void click_on_fixed_asset_configuration() throws Throwable {
		waitHelper.waitForElementVisible(kubsMakerObj.kubsFixedAssetsConfigurations(), 2000, 200);
		kubsMakerObj.kubsFixedAssetsConfigurations().click();

	}

	@And("^the click on view button near by serail number setup$")
	public void the_click_on_view_button_near_by_serail_number_setup() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementVisible(assetTransferObj.fixedAssetSerailNumber(),
		// 2000, 200);
		javascriptHelper.scrollIntoView(assetTransferObj.fixedAssetSerailNumber());
		assetTransferObj.fixedAssetSerailNumber().click();
	}

	@And("^serach the asset code and get the last serail number$")
	public void serach_the_asset_code_and_get_the_last_serail_number() throws Throwable {
		waitHelper.waitForElementVisible(assetTransferObj.serachAssetCode(), 2000, 200);
		assetTransferObj.serachAssetCode().click();
		assetTransferObj.serachAssetCode().sendKeys(impairementData.get("AssetCode"));
		waitHelper.waitForElementVisible(assetTransferObj.assetSerailNumberGetLastSerailNumber(), 2000, 200);
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
}
