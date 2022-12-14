package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSET_AssetAmendmentObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FixedAssetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.DateIncrementDecrement;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSET_AssetAmendment extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String AssetCreation;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetAmendmentObj assetAmendmentObj = new FIXEDASSET_AssetAmendmentObj(driver);
	FIXEDASSET_AssetAmendmentData assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig
			.getAssetCreationByName("Maker");
	Map<String, String> testData = new HashMap<>();
	Map<String, String> assetAmmendmentTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetAmmendment = new ExcelData(path, "FixedAsset_AssetAmmendment", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	DateIncrementDecrement dateIncrementDecrement = new DateIncrementDecrement();

	@Given("^Lauch The Azentio Url$")
	public void lauch_the_azentio_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
		Thread.sleep(1000);
	}

	@Then("^Click Second Segment Icon$")
	public void click_second_segment_icon() throws Throwable {

		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixedTransfericon());
		assetAmendmentObj.fixedTransfericon().click();
	}

	@And("^Click on fixed Asset Module$")
	public void click_on_fixed_asset_module() throws Throwable {

		// ----------TO CLICK THE FIXED ASSET MODULE---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_FixedAssets());
		assetAmendmentObj.fixed_FixedAssets().click();
	}

	@Then("^click on Asset creation Eye icon$")
	public void click_on_asset_creation_eye_icon() throws Throwable {
		// ----------TO CLICK THE FIXED ASSETCREATION---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetCreataionEye());
		assetAmendmentObj.fixed_AssetCreataionEye().click();
	}

	@And("^Click to view First record and store RefNo$")
	public void click_to_view_first_record_and_store_refno() throws Throwable {
		// ----------TO CLICK THE FIXED ASSETCREATION---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetTableRef());
		AssetCreation = assetAmendmentObj.fixed_AssetTableRef().getText();
		System.out.println(AssetCreation);
	}

	@And("^get the approved asset reference number to do the asset ammendment$")
	public void get_the_approved_asset_reference_number_to_do_the_asset_ammendment() throws Throwable {
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetApprovedReferenceNumber(), 3000, 300);

	}

//New Start
	@And("^get the test data for asset ammendment from ammendment excel database$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database() throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D1");
	}
	 @And("^get the test data for asset ammendment from ammendment excel database to deallocate$")
	    public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_to_deallocate() throws Throwable {
			assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_006_011_AA_D11");
	    }
	@And("^get the test data for asset ammendment from ammendment excel database for prerequisite asset revaluation$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_prerequisite_asset_revaluation()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D6");
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
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D3");
	}

	@And("^get the test data for asset ammendment from ammendment excel database for asset return prerequsite$")
	public void get_the_test_data_for_asset_ammendment_from_ammendment_excel_database_for_asset_return_prerequsite()
			throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D4");
	}

	@And("^enter the asset reference number in aset ammendment$")
	public void enter_the_asset_reference_number_in_aset_ammendment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetReferenceNumber(),
				20, 1);
		fixedAssetObj.assetAmmendmentAssetReferenceNumber().click();
		fixedAssetObj.assetAmmendmentAssetReferenceNumber()
				.sendKeys(assetAmmendmentTestData.get("AssetReferenceNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAmmendmentTestData.get("AssetReferenceNumber")
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetItemNumber(), 20, 1);
		fixedAssetObj.assetAmmendmentAssetItemNumber().click();
		fixedAssetObj.assetAmmendmentAssetItemNumber().sendKeys(assetAmmendmentTestData.get("AssetItemNumber"));
		String xpath = "//ng-dropdown-panel//span[text()='" + assetAmmendmentTestData.get("AssetItemNumber") + "']";
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.AssetAmmendmentModificationType(), 20,
				1);
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.AssetAmmendmentModificationType(), 20,
				1);
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate(),
				20, 1);
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsMonthAndYear(), 20, 1);
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

	}

	@And("^change the asset capitalizaion date as less than existing asset life$")
	public void change_the_asset_capitalizaion_date_as_less_than_existing_asset_life() throws Throwable {
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate(),
				20, 1);
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsMonthAndYear(), 20, 1);
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
	}

	@And("^change the asset capitalizaion date as greater than existing asset life$")
	public void change_the_asset_capitalizaion_date_as_greater_than_existing_asset_life() throws Throwable {
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetCapitalizationDate(),
				20, 1);
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentAssetCapitalizationDate());

		// Year
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsMonthAndYear(), 20, 1);
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
	}

	@And("^change the asset life in ammendment screen$")
	public void change_the_asset_life_in_ammendment_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentAssetLife(), 20, 1);
		fixedAssetObj.assetAmmendmentAssetLife().click();
		fixedAssetObj.assetAmmendmentAssetLife().clear();
		fixedAssetObj.assetAmmendmentAssetLife().sendKeys(assetAmmendmentTestData.get("AssetLife"));
	}

	@And("^click on save button in asset ammanedment$")
	public void click_on_save_button_in_asset_ammanedment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the asset ammendment event code in notification$")
	public void search_the_asset_ammendment_event_code_in_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetAmmendmentTestData.get("ModuleCode"));
	}

	@And("^store the record reference number of ammendment asset in ammendment excel database$")
	public void store_the_record_reference_number_of_ammendment_asset_in_ammendment_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentReferenceNumber(), 20, 1);
		String referenceNumber = fixedAssetObj.assetAmmendmentReferenceNumber().getText();
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Reference ID",
				referenceNumber);

	}

	@And("^select the ammendment record from notification$")
	public void select_the_ammendment_record_from_notification() throws Throwable {
//		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentNotificationFirstRecord(),
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@And("^enter the alert remark in asset ammendment$")
	public void enter_the_alert_remark_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetAmmendmentTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert remark in asset ammendment$")
	public void click_on_alert_remark_in_asset_ammendment() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		clickAndActionHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
		clickAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
	}

	@And("^valiadate teh ammendment record submittion and store the reviewer ID in ammendment excel database$")
	public void valiadate_teh_ammendment_record_submittion_and_store_the_reviewer_id_in_ammendment_excel_database()
			throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForAssetAmmendment.updateTestData(assetAmmendmentTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
	}

	@And("^click on search button in ammendment list view$")
	public void click_on_search_button_in_ammendment_list_view() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 20, 1);
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo(), 20, 1);
		clickAndActionHelper.moveToElement(fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo());
		clickAndActionHelper.clickOnElement(fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo());
		fixedAssetObj.assetAmmendmentListViewSearchAssetRefNo()
				.sendKeys(assetAmmendmentTestData.get("AssetReferenceNumber"));
	}

	@Then("^verify approved asset reference number of ammendment record should visible available along with item number$")
	public void verify_approved_asset_reference_number_of_ammendment_record_should_visible_available_along_with_item_number()
			throws Throwable {
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.assetAmmendmentApprovedItemNumber(), 20,
				1);
		String ItemNum = fixedAssetObj.assetAmmendmentApprovedItemNumber().getText();
		Assert.assertEquals(ItemNum, assetAmmendmentTestData.get("AssetItemNumber"));

	}

    @Then("^Store the asset reference number and asset item number of asset ammenment in asset allocation excel data base$")
    public void store_the_asset_reference_number_and_asset_item_number_of_asset_ammenment_in_asset_allocation_excel_data_base() throws Throwable {
    	excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_011_AA_D13", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
    	excelDataForAssetAllocation.updateTestData("KUBS_FAT_UATD_006_011_AA_D13", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
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

		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_05_D1", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetRevaluation.updateTestData("KUBS_FAT_UAT_012_05_D1", "AssetItemNumber",
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
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_005_01_D1", "AssetReferenceNumber",
				assetAmmendmentTestData.get("AssetReferenceNumber"));
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_009_005_01_D1", "AssetItemNumber",
				assetAmmendmentTestData.get("AssetItemNumber"));
	}

	// New End
	@Then("^Click on Asset Ammendent submodule Eye Icon$")
	public void click_on_asset_ammendent_submodule_eye_icon() throws Throwable {

		// ----------TO CLICK AMMENDMENT EYE ICON------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetAmendmentObj.fixed_AssetAmmendmentEye());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetAmendmentObj.fixed_AssetAmmendmentEye(), 20, 1);
		assetAmendmentObj.fixed_AssetAmmendmentEye().click();
	}

	@And("^Click on Add Icon$")
	public void click_on_add_icon() throws Throwable {

		// ----------TO CLICK ADD ICON--------------//
		// waitHelper.waitForElement(driver, 2000,
		// assetAmendmentObj.fixedAssetAmmendmentAdd());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, assetAmendmentObj.fixedAssetAmmendmentAdd(), 20, 1);
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

	@Then("^Enter Asset Referance Number$")
	public void enter_asset_referance_number() throws Throwable {

		// ---------ENTER THE REQUEST REFERANCE NUMBER---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetReferenceNumber());
		// assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Enter Asset Item Number$")
	public void enter_asset_item_number() throws Throwable {

		// ----------ENTER ASSET ITEM NUMBER-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetItemCode());
		assetAmendmentObj.fixed_AssetItemCode().click();
		Thread.sleep(500);
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	}

	@Then("^Choose Modification Type Which we need$")
	public void choose_modification_type_which_we_need() throws Throwable {

		// -----------CHOOSE THE MODIFICATION TYPE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ModificationType());
		assetAmendmentObj.fixed_ModificationType().click();
		assetAmendmentObj.fixed_ModificationType().sendKeys(assetAmendmentData.modificationType2);
		assetAmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
	}

	@And("^Click on calender Icon$")
	public void click_on_calender_icon() throws Throwable {

		// ------------CLICK ON CALENDER ICON------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetCalenderDate());
		assetAmendmentObj.fixed_AssetCalenderDate().click();
	}

	@And("^Choose a current date in calender$")
	public void choose_a_current_date_in_calender() throws Throwable {
		waitHelper.waitForElement(driver, 2000, driver
				.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")));
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Year + "']")));
		driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Year + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Month + "']")).click();
//tbody/tr[5]/td[@aria-label='April 30, 2022']
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.FullMonth + " "
						+ assetAmendmentData.Day + ", " + assetAmendmentData.Year + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.FullMonth + " " + assetAmendmentData.Day
				+ ", " + assetAmendmentData.Year + "']")).click();

		/*
		 * // -------------CHOOSE DATE---------------//
		 * javaScriptHelper.JavaScriptHelper(driver); while (true) { try {
		 * 
		 * waitHelper.waitForElement(driver, 5000,
		 * driver.findElement(By.xpath("//span[contains(text(),'" +
		 * assetAmendmentData.Month + " " + assetAmendmentData.Year + "')]")));
		 * driver.findElement(By.xpath( "//span[contains(text(),'" +
		 * assetAmendmentData.Month + " " + assetAmendmentData.Year + "')]")); break; }
		 * 
		 * catch (NoSuchElementException nosuchElement) {
		 * assetAmendmentObj.fixed_CalenderNextMonth().click(); } }
		 * waitHelper.waitForElement(driver, 5000,
		 * driver.findElement(By.xpath("//td[@aria-label='" +
		 * assetAmendmentData.FullMonth + " " + assetAmendmentData.Day + ", " +
		 * assetAmendmentData.Year + "']/span"))); WebElement Click =
		 * driver.findElement(By.xpath("//td[@aria-label='" +
		 * assetAmendmentData.FullMonth + " " + assetAmendmentData.Day + ", " +
		 * assetAmendmentData.Year + "']/span"));
		 * 
		 * clickAndActionHelper.doubleClick(Click);
		 * clickAndActionHelper.clickOnElement(Click);
		 */
	}

	@Then("^Save the Asset Record$")
	public void save_the_asset_record() throws Throwable {
		// -----------------SAVE THE RECORD---------------//

		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().isDisplayed();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().click();
	}

	@And("^Click on Maker Notification$")
	public void click_on_maker_notification() throws Throwable {
		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_MakerNotification());
		assetAmendmentObj.fixed_MakerNotification().click();
	}

	@Then("^Select Saved record and click on action icon$")
	public void select_saved_record_and_click_on_action_icon() throws Throwable {
		// -----------Submit Icon-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ReferanceId());
		String Referance_id = assetAmendmentObj.fixed_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ActionButton());
		assetAmendmentObj.fixed_ActionButton().click();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_Submit());
		assetAmendmentObj.fixed_Submit().click();
		Thread.sleep(2000);
	}

	@And("^Submit the Asset record to Reviewer$")
	public void submit_the_asset_record_to_reviewer() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_Remark());
		assetAmendmentObj.fixed_Remark().click();
		waitHelper.waitForElement(driver, 5000, assetAmendmentObj.fixed_Remark());
		assetAmendmentObj.fixed_Remark().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_RemarkSubmit());
		assetAmendmentObj.fixed_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ReviewerId());
		reviwerId = assetAmendmentObj.fixed_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER STAGE

	@Given("^Launch the Azentio Reviewer Page$")
	public void launch_the_azentio_reviewer_page() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@And("^Click the Reviewer Notification icon$")
	public void click_the_reviewer_notification_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^Click the submitted record from maker$")
	public void click_the_submitted_record_from_maker() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		javaScriptHelper.JSEClick(reviewerObj.reviewer_action_button());
		// reviewerObj.reviewer_action_button().click();
	}

	@And("^Click the Approve icon from Reviewer End$")
	public void click_the_approve_icon_from_reviewer_end() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter the remark and submit the Record$")
	public void enter_the_remark_and_submit_the_record() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER STAGE
	@Given("^Launch the Azentio Checker page$")
	public void launch_the_azentio_checker_page() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click the Security management module$")
	public void click_the_security_management_module() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click the open pool Edit icon$")
	public void click_the_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@Then("^Claim the record Approved from Reviewer$")
	public void claim_the_record_approved_from_reviewer() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@And("^Click the Checker Notification icon$")
	public void click_the_checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@Then("^Click the Action Icon from claimed record$")
	public void click_the_action_icon_from_claimed_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		// waitHelper.waitForElement(driver, 3000,
		// driver.findElement(By.xpath("//span[contains(text(),'"
		// + readerData.readReferancedata()
		// +
		// "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		for (int i = 0; i < 9; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
						.click();
				break;
			} catch (NoSuchElementException e) {

			} catch (StaleElementReferenceException e) {

			}

		}

	}

	@And("^Click on Approve icon$")
	public void click_on_approve_icon() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Submit the Record from Checker End$")
	public void submit_the_record_from_checker_end() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	// span[contains(text(),'LAND-BUILDING-Building-01_BR0003_2')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]

	@And("^Click the search icon$")
	public void click_the_search_icon() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetSearch());
		assetAmendmentObj.fixed_AssetSearch().click();
	}

	@Then("^Enter the Asset Referance No$")
	public void enter_the_asset_referance_no() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetSearchCode());
		assetAmendmentObj.fixed_AssetSearchCode().click();
		assetAmendmentObj.fixed_AssetSearchCode().sendKeys(AssetCreation);
	}

	@When("^capture the Asset Grid view$")
	public void capture_the_asset_grid_view() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr + AssetCreation + aftr)));
		driver.findElement(By.xpath(befr + AssetCreation + aftr)).click();
	}

	// **************************@KUBS_FAT_UAT_011_002***********************//

	@Then("^Choose Modification Type Which need$")
	public void choose_modification_type_which_need() throws Throwable {

		// -----------CHOOSE THE MODIFICATION TYPE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ModificationType());
		assetAmendmentObj.fixed_ModificationType().click();
		assetAmendmentObj.fixed_ModificationType().sendKeys(assetAmendmentData.modificationType1);
		assetAmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
	}

//	@And("^Enter Asset Life Value$")
//	public void enter_asset_life_value() throws Throwable {
//
//		// ----------------ENTER ASSET VALUE----------------//
//		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
//		assetAmendmentObj.fixed_AssetLife().click();
//		assetAmendmentObj.fixed_AssetLife().clear();
//		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLife);
//	}

	// ********************@KUBS_FAT_UAT_011_003***********************//

	@And("^Enter Asset Life lesser than Value$")
	public void enter_asset_life_lesser_than_value() throws Throwable {
		// ----------------ENTER ASSET LESSER THAN VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
		assetAmendmentObj.fixed_AssetLife().click();
		assetAmendmentObj.fixed_AssetLife().clear();
		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLifelesser);
	}

	// *********************@KUBS_FAT_UAT_011_004********************//

	@And("^Enter Asset Life greater than Value$")
	public void enter_asset_life_greater_than_value() throws Throwable {
		// ----------------ENTER ASSET GREATER THAN VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
		assetAmendmentObj.fixed_AssetLife().click();
		assetAmendmentObj.fixed_AssetLife().clear();
		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLifegreater);
	}
}
