package stepdefinitions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.FixedAsset_AssetCategoryObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetCategory extends BaseClass {

	WebDriver driver = BaseClass.driver;

	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	BUDGET_BudgetCreationTestDataType budgetdata;
	FixedAsset_AssetCategoryObj fixedAsset_AssetCategoryObj = new FixedAsset_AssetCategoryObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = new FixedAsset_AssetCategoryTestDataType();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "FixedAsset_AssetCategory", "DataSet ID");
	Map<String, String> assetcatogoryTestdata = new HashMap<>();
	Map<String, String> assetcatogoryReportTestdata = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData excelDataAssetCode = new ExcelData(path, "FixedAsset_AssetCodeConfig", "DataSet ID");
	Map<String, String> testMap = new HashMap<>();
	KUBS_CommonWebElements kubsCommonWebElements= new KUBS_CommonWebElements(driver);
	ExcelData excelDataAssetCategoryForTransfer = new ExcelData(path, "AssetTransfer_ExecutionTracker", "TestCaseID");
	Map<String, String> DataSetID = new HashMap<>();

	@And("^get the test data for asset catogory creation Test Data$")
	public void get_the_test_data_for_asset_catogory_creation_test_data() throws Throwable {
		System.out.println("Test");
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D1");
	}

	@And("^get the test data for asset catogory creation Test Data for asset return$")
	public void get_the_test_data_for_asset_catogory_creation_test_data_for_asset_return() throws Throwable {
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D3");
	}

	@And("^get the test data for asset catogory creation Test Data for asset allocation$")
	public void get_the_test_data_for_asset_catogory_creation_test_data_for_asset_allocation() throws Throwable {
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D4");
	}

	@And("^get the test data for asset catogory creation Test Data for asset ammendment$")
	public void get_the_test_data_for_asset_catogory_creation_test_data_for_asset_ammendment() throws Throwable {
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D5");
	}

	@And("^get the test data for asset catogory creation Test Data for asset Revaluation$")
	public void get_the_test_data_for_asset_catogory_creation_test_data_for_asset_revaluation() throws Throwable {
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D6");
	}

	@And("^get the test data for asset catogory creation Test Data for asset transfer undertaking$")
	public void get_the_test_data_for_asset_catogory_creation_test_data_for_asset_transfer_undertaking()
			throws Throwable {
		DataSetID = excelDataAssetCategoryForTransfer.getTestdata("KUBS_FAT_UAT_002_002_01_Transfer");
		assetcatogoryTestdata = excelData.getTestdata(DataSetID.get("Data Set ID"));
	}

	@Then("^verify newly created asset category is refelected in list view$")
	public void verify_newly_created_asset_category_is_refelected_in_list_view() throws Throwable {
		String xpath = "//span[contains(text(),' " + assetcatogoryTestdata.get("UpdateAssetItemcategory") + " ')]";
		for (int i = 0; i <= 600; i++) {
			try {

				Assert.assertTrue("Newly Created asset category is not reflected ",
						driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 300; i++) {
			try {
				String assetCode = driver.findElement(By.xpath("//span[text()=' "
						+ assetcatogoryTestdata.get("UpdateAssetItemcategory")
						+ " ']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[3]//span"))
						.getText();
				assetcatogoryTestdata.put("Asset_Code", assetCode);
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the asset code for asset code configuration$")
	public void store_the_asset_code_for_asset_code_configuration() throws Throwable {
		System.out.println("Asset Code " + assetcatogoryTestdata.get("Asset_Code"));
//		testMap=excelDataAssetCode.getTestdata("KUBS_FAT_UAT_002_003_D1");
//		System.out.println(testMap.get("AccountingModel"));
		excelDataAssetCode.updateTestData("KUBS_FAT_UAT_002_003_D1", "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^store the asset code for asset code configuration for asset ammendment$")
	public void store_the_asset_code_for_asset_code_configuration_for_asset_ammendment() throws Throwable {
		excelDataAssetCode.updateTestData("KUBS_FAT_UAT_002_003_D5", "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^store the asset code for asset code configuration for asset revaluation$")
	public void store_the_asset_code_for_asset_code_configuration_for_asset_revaluation() throws Throwable {
		excelDataAssetCode.updateTestData("KUBS_FAT_UAT_002_003_D6", "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^store the asset code for asset code configuration for asset transfer and undertaking$")
	public void store_the_asset_code_for_asset_code_configuration_for_asset_transfer_and_undertaking()
			throws Throwable {
		excelDataAssetCode.updateTestData(assetcatogoryTestdata.get("Update Data Set 1"), "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
		
	}

	@And("^store the asset code for asset code configuration for asset allocation$")
	public void store_the_asset_code_for_asset_code_configuration_for_asset_allocation() throws Throwable {
		excelDataAssetCode.updateTestData(assetcatogoryTestdata.get("Update Data Set 1"), "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^store the asset code for asset code configuration for asset return$")
	public void store_the_asset_code_for_asset_code_configuration_for_asset_return() throws Throwable {
		excelDataAssetCode.updateTestData("KUBS_FAT_UAT_002_003_D3", "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^store the asset code for asset code configuration in impairment asset code config$")
	public void store_the_asset_code_for_asset_code_configuration_in_impairment_asset_code_config() throws Throwable {
		System.out.println("Asset Code " + assetcatogoryTestdata.get("Asset_Code"));

		excelDataAssetCode.updateTestData("KUBS_FAT_UAT_002_003_D2", "AssetCode",
				assetcatogoryTestdata.get("Asset_Code"));
	}

	@And("^get the test data for asset catogory creation for asset impairment$")
	public void get_the_test_data_for_asset_catogory_creation_for_asset_impairment() throws Throwable {
		assetcatogoryTestdata = excelData.getTestdata("KUBS_FAT_UAT_002_002_D2");
	}

	@And("^select the data from Asset category dropdown$")
	public void select_the_data_from_asset_category_dropdown() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetcatogoryTestdata.get("Assetcategory") + "']";
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().click();
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField()
				.sendKeys(assetcatogoryTestdata.get("Assetcategory"));
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

	@And("^select the data from Asset sub category$")
	public void select_the_data_from_asset_sub_category() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().click();
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory()
				.sendKeys(assetcatogoryTestdata.get("AssetSubCategory"));
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(
						By.xpath("//div[text()='" + assetcatogoryTestdata.get("AssetSubCategory") + "']")));
				clickAndActionsHelper.clickOnElement(driver.findElement(
						By.xpath("//div[text()='" + assetcatogoryTestdata.get("AssetSubCategory") + "']")));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^enter the dta in asset item category$")
	public void enter_the_dta_in_asset_item_category() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		int randomNum2 = random.nextInt(200 - 1) + 1;
		String assetItemcategory = assetcatogoryTestdata.get("AssetItemCategory") + randomNum + randomNum2;
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().click();
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().sendKeys(assetItemcategory);

		excelData.updateTestData(assetcatogoryTestdata.get("DataSet ID"), "UpdateAssetItemcategory", assetItemcategory);

	}

	@And("^enter the asset description input$")
	public void enter_the_asset_description_input() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().click();
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription()
				.sendKeys(assetcatogoryTestdata.get("AssetDescription"));
	}

	@Then("^Click on Fixed Asset Direction icon$")
	public void click_on_fixed_asset_direction_icon() throws IOException {
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon().click();

	}

	@Then("^Click on Fixed assets configuration$")
	public void click_on_fixed_assets_configuration() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration().click();

	}

	@Then("^Click on Asset Category Eye button$")
	public void click_on_asset_category_eye_button() throws IOException {
		// Eye Button
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon());
		for (int i = 0; i <= 100; i++) {
			try {
				if (i > 50 && i < 100) {
					fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration().click();
					fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon().click();
					break;
				}
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^Click on Fixed Asset Add button$")
	public void click_on_fixed_asset_add_button() {
		// Add Button
		// waitHelper.waitForElementwithFluentwait(driver,
		// fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton(),60,5);
		for (int i = 0; i < 30; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					Assert.fail("add button not clicked");
				}
			}
		}

	}

	@Then("^Click on Fixed Asset Save button$")
	public void click_on_fixed_asset_save_button() throws InterruptedException {
		// Save
		// waitHelper.waitForElementwithFluentwait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save(),60,5);
		for (int i = 0; i < 20; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save().click();
				break;
			} catch (Exception e) {

			}

		}

	}

	@Then("^Click on Fixed Asset Notification$")
	public void click_on_fixed_asset_notification() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String toastAlert = kubsCommonObj.kubsToastAlert().getText();
		System.out.println(toastAlert);
		for (int i = 0; i <= 500; i++) {
			try {
				kubsCommonObj.kubsAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage() + " Caused By" + e.getCause());
				}
			}
		}

		// waitHelper.waitForElementwithFluentwait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification(),60,5);
		for (int i = 0; i <= 200; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification().click();
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}

			}
		}

	}

	@And("^click on notification search in asset category$")
	public void click_on_notification_search_in_asset_category() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.fixedAssetCategorySearchButton());
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(fixedAsset_AssetCategoryObj.fixedAssetCategorySearchButton());
				fixedAsset_AssetCategoryObj.fixedAssetCategorySearchButton().click();
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search the asset catregory record$")
	public void search_the_asset_catregory_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonWebElements.kubsNotificationSearchButton());
		kubsCommonWebElements.kubsNotificationSearchButton().click();
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.fixedAssetcategoryEventCode());
		fixedAsset_AssetCategoryObj.fixedAssetcategoryEventCode().click();
		fixedAsset_AssetCategoryObj.fixedAssetcategoryEventCode().sendKeys(assetcatogoryTestdata.get("ModuleCode"));
	}

	@And("^store the reference number of asset category record$")
	public void store_the_reference_number_of_asset_category_record() throws Throwable {
		System.out.println("DataSet ID : " + assetcatogoryTestdata.get("DataSet ID"));
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.assetCategoryReferenceNumber());
		excelData.updateTestData(assetcatogoryTestdata.get("DataSet ID"), "Reference ID",
				fixedAsset_AssetCategoryObj.assetCategoryReferenceNumber().getText());
	}

	@And("^select the asset category record$")
	public void select_the_asset_category_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.assetCategoryNotificationRecord());
		fixedAsset_AssetCategoryObj.assetCategoryNotificationRecord().click();
	}

	@And("^submit the asset category record$")
	public void submit_the_asset_category_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSubmitButton());
		kubsCommonObj.kubsSubmitButton().click();
//alert Remark
		for (int i = 0; i <= 500; i++) {
			try {
				clickAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				clickAndActionsHelper.clickUsingActionClass(kubsCommonObj.kubsAlertRemark(),
						kubsCommonObj.kubsAlertRemark());
				kubsCommonObj.kubsAlertRemark().sendKeys(assetcatogoryTestdata.get("MakerAlertRemark"));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// aler submit click
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertSubmit());
		try {
			kubsCommonObj.kubsAlertSubmit().click();
		} catch (Exception e) {
			kubsCommonObj.kubsAlertRemark().click();
			kubsCommonObj.kubsAlertRemark().sendKeys(assetcatogoryTestdata.get("MakerAlertRemark"));
			kubsCommonObj.kubsAlertSubmit().click();
		}
	}

	@And("^store the reciewer ID in asset category$")
	public void store_the_reciewer_id_in_asset_category() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelData.updateTestData(assetcatogoryTestdata.get("DataSet ID"), "Reviewer ID", reviewerID);

	}

	@Then("^Click on Fixed Asset Notification icon$")
	public void click_on_fixed_asset_notification_icon() throws Throwable {
		for (int i = 0; i < 30; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification().click();
				break;
			} catch (Exception e) {

			}
		}
	}

	// Asset category report
	@And("^get the asset category from asset category approved list view$")
	public void get_the_asset_category_from_asset_category_approved_list_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.assetCategory_ReportCategoryApprovedItemCategory());
		String approvedItemCategory = fixedAsset_AssetCategoryObj.assetCategory_ReportCategoryApprovedItemCategory()
				.getText();
		assetcatogoryReportTestdata.put("approvedItemCategory", approvedItemCategory);

	}

	@And("^click on asset category report temp view$")
	public void click_on_asset_category_report_temp_view() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCategoryObj.assetCategoryReporTempView());
		fixedAsset_AssetCategoryObj.assetCategoryReporTempView().click();
	}

	@And("^enter the asset category as on date in report$")
	public void enter_the_asset_category_as_on_date_in_report() throws Throwable {
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

		waitHelper.waitForElementwithFluentwait(driver,
				fixedAsset_AssetCategoryObj.assetCategoryReportCategoryAsOnDate());
		clickAndActionsHelper.moveToElement(fixedAsset_AssetCategoryObj.assetCategoryReportCategoryAsOnDate());
		clickAndActionsHelper.clickOnElement(fixedAsset_AssetCategoryObj.assetCategoryReportCategoryAsOnDate());
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
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

	@Then("^verify approved asset category should reflect in asset category report$")
	public void verify_approved_asset_category_should_reflect_in_asset_category_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		String xpath = "//div[contains(text(),'" + assetcatogoryReportTestdata.get("approvedItemCategory") + "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean varifyXapth = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(varifyXapth);
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
