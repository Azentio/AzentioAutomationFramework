package stepdefinitions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSET_AssetAmendmentObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.DateIncrementDecrement;
import resources.ExcelData;

public class FIXEDASSET_AssetAmendment extends BaseClass {

	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetAmendmentObj assetAmendmentObj = new FIXEDASSET_AssetAmendmentObj(driver);
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	Map<String, String> testData = new HashMap<>();
	Map<String, String> dataSetID = new HashMap<>();
	Map<String, String> assetAmmendmentTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetAmmendment = new ExcelData(path, "FixedAsset_AssetAmmendment", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(path, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataForAssetImpairementExecution = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	ExcelData excelDataForAssetRevaluationExecution = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	DateIncrementDecrement dateIncrementDecrement = new DateIncrementDecrement();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> assetAmmendmentReportTestData = new HashMap<>();

	@And("^Click on fixed Asset Module$")
	public void click_on_fixed_asset_module() throws Throwable {

		// ----------TO CLICK THE FIXED ASSET MODULE---------//
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_FixedAssets());
		assetAmendmentObj.fixed_FixedAssets().click();
	}

	@Then("^click on Asset creation Eye icon$")
	public void click_on_asset_creation_eye_icon() throws Throwable {
		// ----------TO CLICK THE FIXED ASSETCREATION---------//
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_AssetCreataionEye());
		assetAmendmentObj.fixed_AssetCreataionEye().click();
	}

	@And("^get the approved asset reference number to do the asset ammendment$")
	public void get_the_approved_asset_reference_number_to_do_the_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAssetApprovedReferenceNumber());

	}

//New Start
	@And("^get the test data for asset ammendment from ammendment excel database$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database() throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D1");
	}

	@And("^get the test data for asset ammendment from ammendment excel database for prerequisite of asset writeoff$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D11");
	}

	@And("^get the test data for asset ammendment from ammendment excel database for prerequisite asset revaluation$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_prerequisite_asset_revaluation()
			throws Throwable {
		dataSetID=excelDataForAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_011_01_Revaluation");
		
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset ammendment from ammendment excel database to change the asset life$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_change_the_asset_life()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_02_D1");
	}

	@And("^get the test data for asset ammendment from ammendment excel database to change the asset life less than existing asset life$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_change_the_asset_life_less_than_existing_asset_life()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_03_D1");
	}

	@And("^get the test data for asset ammendment from ammendment excel database to change the asset life greater than existing asset life$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_change_the_asset_life_greater_than_existing_asset_life()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_04_D1");
	}

	@And("^get the test data for asset ammendment from ammendment excel database to make asset as used for asset allocation$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_make_asset_as_used_for_asset_allocation()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D5");
	}

	@And("^get the test data for asset ammendment from ammendment excel database for asset impairment prerequsite$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_asset_impairment_prerequsite()
			throws Throwable {
		dataSetID= excelDataForAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_011_01_Impairment");
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset ammendment from ammendment excel database for asset return prerequsite$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_asset_return_prerequsite()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D4");
	}

	@And("^get the test data for asset ammendment from ammendment excel database to deallocate$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_deallocate() throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D7");
	}

	@And("^enter the asset reference number in aset ammendment$")
	public void enter_the_asset_reference_number_in_aset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetReferenceNumber());
		fixedAssetObj.assetAmmendmentAssetReferenceNumber().click();
		fixedAssetObj.assetAmmendmentAssetReferenceNumber()
				.sendKeys(assetAmmendmentTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAmmendmentTestData.get("AssetReferenceNumber")
				+ "']";
		for (int i = 0; i <= 10; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^enter the asset item number in asset ammendment$")
	public void enter_the_asset_item_number_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetItemNumber());
		fixedAssetObj.assetAmmendmentAssetItemNumber().click();
		fixedAssetObj.assetAmmendmentAssetItemNumber().sendKeys(assetAmmendmentTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetAmmendmentTestData.get("AssetItemNumber") + "']";
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^choose modifcation type as capitalization date$")
	public void choose_modifcation_type_as_capitalization_date() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.AssetAmmendmentModificationType());
		fixedAssetObj.AssetAmmendmentModificationType().click();
		fixedAssetObj.AssetAmmendmentModificationType().sendKeys(assetAmmendmentTestData.get("ModificationType"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAmmendmentTestData.get("ModificationType") + "']";
		for (int i = 0; i <= 10; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^choose modifcation type as Asset life$")
	public void choose_modifcation_type_as_asset_life() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.AssetAmmendmentModificationType());
		fixedAssetObj.AssetAmmendmentModificationType().click();
		fixedAssetObj.AssetAmmendmentModificationType().sendKeys(assetAmmendmentTestData.get("ModificationType"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAmmendmentTestData.get("ModificationType") + "']";
		for (int i = 0; i <= 10; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^change the asset capitalizaion date in asset ammendment$")
	public void change_the_asset_capitalizaion_date_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsMonthAndYear());

		// Year
		String yearXpath = "//span[text()='" + assetAmmendmentTestData.get("Year") + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(yearXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(yearXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String monthXpath = "//span[text()='" + assetAmmendmentTestData.get("Month").substring(0, 3) + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(monthXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(monthXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String dayXpath = "//td[@aria-label='" + assetAmmendmentTestData.get("Month") + " "
				+ assetAmmendmentTestData.get("Day") + ", " + assetAmmendmentTestData.get("Year") + "']";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(dayXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(dayXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String finalcapitalizationDate = "";
		finalcapitalizationDate = javaScriptHelper
				.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"),
				"UpdatedCapitalizationDateAsPerTheScreen", finalcapitalizationDate);
	}

	@And("^change the asset capitalizaion date as less than existing asset life$")
	public void change_the_asset_capitalizaion_date_as_less_than_existing_asset_life() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		String[] monthArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String capitalizationDate = "";
		String finalcapitalizationDate = "";
		int Monthcount = 0;
		for (int i = 0; i <= 300; i++) {
			try {
				capitalizationDate = javaScriptHelper
						.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
				System.out.println("Capitalization Date " + capitalizationDate);
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] splitCapDate = capitalizationDate.split("-");
		String splitCapDay = splitCapDate[0];
		for (int i = 0; i <= monthArray.length; i++) {
			if (splitCapDate[1].equals(monthArray[i])) {
				Monthcount = Monthcount + 1;
				break;
			} else {
				Monthcount = Monthcount + 1;
			}
		}
		for (int i = 0; i < splitCapDay.length(); i++) {
			if (splitCapDay.charAt(i) != '0') {
				splitCapDay = splitCapDay.substring(i);

			}
		}
		System.out.println("Arguments of Year : " + Integer.parseInt(splitCapDate[2]));
		System.out.println("Arguments of Month : " + Monthcount);
		System.out.println("Arguments of day : " + Integer.parseInt(splitCapDay));
		String finalDate = dateIncrementDecrement.dateDecrementor(Integer.parseInt(splitCapDate[2]), Monthcount,
				Integer.parseInt(splitCapDay));

		String[] splitFinalDate = finalDate.split("-");
		System.out.println("Year " + splitFinalDate[0]);
		System.out.println("Month " + splitFinalDate[1]);
		System.out.println("Day " + splitFinalDate[2]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Year",
				splitFinalDate[0]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Month",
				splitFinalDate[1]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Day", splitFinalDate[2]);
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata(assetAmmendmentTestData.get("DataSet ID"));
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsMonthAndYear());

		// Year
		String yearXpath = "//span[text()='" + assetAmmendmentTestData.get("Year") + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(yearXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(yearXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String monthXpath = "//span[text()='" + assetAmmendmentTestData.get("Month").substring(0, 3) + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(monthXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(monthXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String dayXpath = "//td[@aria-label='" + assetAmmendmentTestData.get("Month") + " "
				+ assetAmmendmentTestData.get("Day") + ", " + assetAmmendmentTestData.get("Year") + "']";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(dayXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(dayXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		finalcapitalizationDate = javaScriptHelper
				.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"),
				"UpdatedCapitalizationDateAsPerTheScreen", finalcapitalizationDate);

	}

	@And("^change the asset capitalizaion date as greater than existing asset life$")
	public void change_the_asset_capitalizaion_date_as_greater_than_existing_asset_life() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		String[] monthArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String capitalizationDate = "";
		int Monthcount = 0;
		for (int i = 0; i <= 300; i++) {
			try {
				capitalizationDate = javaScriptHelper
						.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
				System.out.println("Capitalization Date " + capitalizationDate);
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] splitCapDate = capitalizationDate.split("-");
		String splitCapDay = splitCapDate[0];
		for (int i = 0; i <= monthArray.length; i++) {
			if (splitCapDate[1].equals(monthArray[i])) {
				Monthcount = Monthcount + 1;
				break;
			} else {
				Monthcount = Monthcount + 1;
			}
		}
		for (int i = 0; i < splitCapDay.length(); i++) {
			if (splitCapDay.charAt(i) != '0') {
				splitCapDay = splitCapDay.substring(i);

			}
		}
		System.out.println("Arguments of Year : " + Integer.parseInt(splitCapDate[2]));
		System.out.println("Arguments of Month : " + Monthcount);
		System.out.println("Arguments of day : " + Integer.parseInt(splitCapDay));
		String finalDate = dateIncrementDecrement.dateIncrementor(Integer.parseInt(splitCapDate[2]), Monthcount,
				Integer.parseInt(splitCapDay));

		String[] splitFinalDate = finalDate.split("-");
		System.out.println("Year " + splitFinalDate[0]);
		System.out.println("Month " + splitFinalDate[1]);
		System.out.println("Day " + splitFinalDate[2]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Year",
				splitFinalDate[0]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Month",
				splitFinalDate[1]);
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Day", splitFinalDate[2]);
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata(assetAmmendmentTestData.get("DataSet ID"));
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsMonthAndYear());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsMonthAndYear());

		// Year
		String yearXpath = "//span[text()='" + assetAmmendmentTestData.get("Year") + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(yearXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(yearXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String monthXpath = "//span[text()='" + assetAmmendmentTestData.get("Month").substring(0, 3) + "']//parent::td";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(monthXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(monthXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String dayXpath = "//td[@aria-label='" + assetAmmendmentTestData.get("Month") + " "
				+ assetAmmendmentTestData.get("Day") + ", " + assetAmmendmentTestData.get("Year") + "']";
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(dayXpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(dayXpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String finalcapitalizationDate = "";
		finalcapitalizationDate = javaScriptHelper
				.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"),
				"UpdatedCapitalizationDateAsPerTheScreen", finalcapitalizationDate);
	}

	@And("^change the asset life in ammendment screen$")
	public void change_the_asset_life_in_ammendment_screen() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentAssetLife());
		fixedAssetObj.assetAmmendmentAssetLife().click();
		fixedAssetObj.assetAmmendmentAssetLife().clear();
		fixedAssetObj.assetAmmendmentAssetLife().sendKeys(assetAmmendmentTestData.get("AssetLife"));
	}

	@And("^click on save button in asset ammanedment$")
	public void click_on_save_button_in_asset_ammanedment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSaveButton());
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset ammendment event code in notification$")
	public void search_the_asset_ammendment_event_code_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSearchEventCode());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetAmmendmentTestData.get("ModuleCode"));
	}

	@And("^store the record reference number of ammendment asset in ammendment excel database$")
	public void store_the_record_reference_number_of_ammendment_asset_in_ammendment_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentReferenceNumber());
		String referenceNumber = fixedAssetObj.assetAmmendmentReferenceNumber().getText();
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Reference ID",
				referenceNumber);

	}

	@And("^select the ammendment record from notification$")
	public void select_the_ammendment_record_from_notification() throws Throwable {
//		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentNotificationFirstRecord(),
//				20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				fixedAssetObj.assetAmmendmentNotificationFirstRecord().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on submit in asset ammendment$")
	public void click_on_submit_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSubmitButton());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@And("^enter the alert remark in asset ammendment$")
	public void enter_the_alert_remark_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertRemark());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetAmmendmentTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert remark in asset ammendment$")
	public void click_on_alert_remark_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertSubmit());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
	}

	@And("^valiadate teh ammendment record submittion and store the reviewer ID in ammendment excel database$")
	public void valiadate_teh_ammendment_record_submittion_and_store_the_reviewer_id_in_ammendment_excel_database()
			throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^click on search button in ammendment list view$")
	public void click_on_search_button_in_ammendment_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsListViewSearchButton());
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionHelper.moveToElement(kubsCommonObj.kubsListViewSearchButton());
				clickAndActionHelper.clickOnElement(kubsCommonObj.kubsListViewSearchButton());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the asset approved reference number of ammendment record$")
	public void search_the_asset_approved_reference_number_of_ammendment_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo());
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo());
		fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo()
				.sendKeys(assetAmmendmentTestData.get("AssetReferenceNumber"));
	}

	@Then("^verify approved asset reference number of ammendment record should visible available along with item number$")
	public void verify_approved_asset_reference_number_of_ammendment_record_should_visible_available_along_with_item_number()
			throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		String xpath = "//span[text()=' " + assetAmmendmentTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[4]//ion-button[1]";
		String RefXpath = "//span[text()=' " + assetAmmendmentTestData.get("AssetReferenceNumber") + " ']";
		for (int i = 0; i <= 50; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(RefXpath)).isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 50; i++) {
			try {

				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentApprovedItemNumber());
		String ItemNum = fixedAssetObj.assetAmmendmentApprovedItemNumber().getText();
		Assert.assertEquals(ItemNum, assetAmmendmentTestData.get("AssetItemNumber"));
		String updatedCapitalizationDate = "";
		for (int i = 0; i <= 100; i++) {
			try {
				updatedCapitalizationDate = javaScriptHelper
						.executeScript("return document.getElementsByName('kubDateTime')[0].value").toString();
				break;
			} catch (Exception e) {
				if (i == 100) {

					Assert.fail(e.getMessage());
				}
			}
		}
		Assert.assertEquals(updatedCapitalizationDate,
				assetAmmendmentTestData.get("UpdatedCapitalizationDateAsPerTheScreen"));
	}

	@And("^store the asset reference number and item number of ammendment asset in asset writeoff excel database$")
	public void store_the_asset_reference_number_and_item_number_of_ammendment_asset_in_asset_writeoff_excel_database()
			throws Throwable {
		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_004_D1", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetWriteOff.updateTestData("KUBS_FAT_UAT_010_004_D1", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	@Then("^Store the asset reference number and asset item number of asset ammenment in asset allocation excel data base$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_ammenment_in_asset_allocation_excel_data_base()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D6", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D6", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	@Then("^verify approved asset reference number of ammendment record should visible available along with item number and updated asset life$")
	public void verify_approved_asset_reference_number_of_ammendment_record_should_visible_available_along_with_item_number_and_updated_asset_life()
			throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		String xpath = "//span[text()=' " + assetAmmendmentTestData.get("AssetReferenceNumber")
				+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[4]//ion-button[1]";
		String RefXpath = "//span[text()=' " + assetAmmendmentTestData.get("AssetReferenceNumber") + " ']";
		for (int i = 0; i <= 50; i++) {
			try {

				Assert.assertTrue(driver.findElement(By.xpath(RefXpath)).isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 50; i++) {
			try {

				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.assetAmmendmentApprovedItemNumber());
		String ItemNum = fixedAssetObj.assetAmmendmentApprovedItemNumber().getText();
		Assert.assertEquals(ItemNum, assetAmmendmentTestData.get("AssetItemNumber"));
		String updatedAssetLife = "";
		for (int i = 0; i <= 100; i++) {

			try {
				updatedAssetLife = javaScriptHelper
						.executeScript("return document.getElementsByName('newAssetLife')[0].value").toString();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
			Assert.assertEquals(updatedAssetLife, assetAmmendmentTestData.get("AssetLife"));
		}

	}

	@And("^store the asset reference number and item number of approved ammendment asset in asset return excel database$")
	public void store_the_asset_reference_number_and_item_number_of_approved_ammendment_asset_in_asset_return_excel_database()
			throws Throwable {
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_003_01_D1", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetReturn.updateTestData("KUBS_FAT_UAT_007_003_01_D1", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of ammendment asset in asset revaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_ammendment_asset_in_asset_revaluation_excel_database()
			throws Throwable {

		excelDataForAssetRevaluation.updateTestData(assetAmmendmentTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData(assetAmmendmentTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of ammendment in asset allocation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_ammendment_in_asset_allocation_excel_database()
			throws Throwable {
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_002_D1", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_002_D1", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of ammendment asset in asset impairment excel database$")
	public void store_the_asset_reference_number_and_item_number_of_ammendment_asset_in_asset_impairment_excel_database()
			throws Throwable {
		excelDataForAssetImpairment.updateTestData(assetAmmendmentTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData(assetAmmendmentTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	// New End
	@Then("^Click on Asset Ammendent submodule Eye Icon$")
	public void click_on_asset_ammendent_submodule_eye_icon() throws Throwable {

		// ----------TO CLICK AMMENDMENT EYE ICON------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetAmendmentObj.fixed_AssetAmmendmentEye());
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_AssetAmmendmentEye());
		assetAmendmentObj.fixed_AssetAmmendmentEye().click();
	}

	@And("^Click on Add Icon$")
	public void click_on_add_icon() throws Throwable {

		// ----------TO CLICK ADD ICON--------------//
		// waitHelper.waitForElementwithFluentwait(driver, 2000,
		// assetAmendmentObj.fixedAssetAmmendmentAdd());
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixedAssetAmmendmentAdd());
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionHelper.moveToElement(assetAmendmentObj.fixedAssetAmmendmentAdd());
				clickAndActionHelper.clickOnElement(assetAmendmentObj.fixedAssetAmmendmentAdd());
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// assetAmendmentObj.fixedAssetAmmendmentAdd().click();
	}

	@And("^Enter Asset Item Number$")
	public void enter_asset_item_number() throws Throwable {

		// ----------ENTER ASSET ITEM NUMBER-----------//
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_AssetItemCode());
		assetAmendmentObj.fixed_AssetItemCode().click();
		Thread.sleep(500);
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	}

	@And("^Click on calender Icon$")
	public void click_on_calender_icon() throws Throwable {

		// ------------CLICK ON CALENDER ICON------------//
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_AssetCalenderDate());
		assetAmendmentObj.fixed_AssetCalenderDate().click();
	}

	@Then("^Save the Asset Record$")
	public void save_the_asset_record() throws Throwable {
		// -----------------SAVE THE RECORD---------------//

		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().isDisplayed();
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().click();
	}

	@And("^Click on Maker Notification$")
	public void click_on_maker_notification() throws Throwable {
		// ------------Maker Notification icon---------//
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixed_MakerNotification());
		assetAmendmentObj.fixed_MakerNotification().click();
	}

	@And("^store the asset reference number of ammendment asset$")
	public void store_the_asset_reference_number_of_ammendment_asset() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetAmendmentObj.fixedAmendmentListViewApprovedAssetReferenceNumber());
		String ammendmentAssetReferenceNumber = assetAmendmentObj.fixedAmendmentListViewApprovedAssetReferenceNumber()
				.getText();
		assetAmmendmentReportTestData.put("ammendmentAssetReferenceNumber", ammendmentAssetReferenceNumber);
		System.out.println(
				"Ammendment reference number" + assetAmmendmentReportTestData.get("ammendmentAssetReferenceNumber"));
	}

	@And("^store the asset code of ammendment asset$")
	public void store_the_asset_code_of_ammendment_asset() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixedAmendmentListViewApprovedAssetCode());
		String ammendmentAssetCode = assetAmendmentObj.fixedAmendmentListViewApprovedAssetCode().getText();
		assetAmmendmentReportTestData.put("ammendmentAssetCode", ammendmentAssetCode);
		System.out.println("Ammendment Asset Code " + assetAmmendmentReportTestData.get("ammendmentAssetCode"));
	}

	@And("^select the approved ammendment asset from ammendmen list view$")
	public void select_the_approved_ammendment_asset_from_ammendmen_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixedAmendmentListViewApprovedRecord());
		assetAmendmentObj.fixedAmendmentListViewApprovedRecord().click();
	}

	@And("^store the capitalization date of the ammednment asset$")
	public void store_the_capitalization_date_of_the_ammednment_asset() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.fixedAmendmentApprovedModificationType());
		String ammendmentModificationType = assetAmendmentObj.fixedAmendmentApprovedModificationType().getText();
		assetAmmendmentReportTestData.put("ammendmentModificationType", ammendmentModificationType);
		System.out.println("Ammendment Asset modification Type "
				+ assetAmmendmentReportTestData.get("ammendmentModificationType"));

		for (int i = 0; i <= 500; i++) {
			try {
				String ammendmentCapDate = javaScriptHelper
						.executeScript("return document.getElementById('kubDateTime').value").toString();
				assetAmmendmentReportTestData.put("ammendmentCapDate", ammendmentCapDate);
				System.out.println("cap date " + assetAmmendmentReportTestData.get("ammendmentCapDate"));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on temp view of ammendment asset$")
	public void click_on_temp_view_of_ammendment_asset() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetAmendmentObj.fixedAmendmentAssetAmmendmentReportTempView());
		assetAmendmentObj.fixedAmendmentAssetAmmendmentReportTempView().click();
	}

	@And("^enter the modification type in ammendment report$")
	public void enter_the_modification_type_in_ammendment_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.assetAmmendmentReportModificationType());
		assetAmendmentObj.assetAmmendmentReportModificationType().click();
		assetAmendmentObj.assetAmmendmentReportModificationType()
				.sendKeys(assetAmmendmentReportTestData.get("ammendmentModificationType"));
		String xpath = "//ng-dropdown-panel//span[text()='"
				+ assetAmmendmentReportTestData.get("ammendmentModificationType") + "']";
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	@And("^enter the capitalization date in ammemdment report$")
	public void enter_the_capitalization_date_in_ammemdment_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, assetAmendmentObj.assetAmmendmentReportcapitalizationDate());
		assetAmendmentObj.assetAmmendmentReportcapitalizationDate().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
		System.out.println("Created date" + assetAmmendmentReportTestData.get("ammendmentCapDate"));
		String[] splitDate = assetAmmendmentReportTestData.get("ammendmentCapDate").split("-");
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

	@And("^enter theammendment as on date in ammdnement report$")
	public void enter_theammendment_as_on_date_in_ammdnement_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				assetAmendmentObj.fixedAmendmentAssetAmmendmentReportAsOndate());
		assetAmendmentObj.fixedAmendmentAssetAmmendmentReportAsOndate().click();

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
		System.out.println("Month " + Month);
		System.out.println(" Full Month " + FullMonth);
		System.out.println(" Year  " + yearNum);
		System.out.println("Day " + DateNum);
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());

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

		String dayXapath = "//td[@aria-label='" + FullMonth + " " + DateNum + ", " + yearNum + "']";

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

	@Then("^verify pproved asset ammedment record should reflect in ammendment report$")
	public void verify_pproved_asset_ammedment_record_should_reflect_in_ammendment_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String xpath = "//div[contains(text(),'" + assetAmmendmentReportTestData.get("ammendmentAssetReferenceNumber")
				+ "')]";
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
