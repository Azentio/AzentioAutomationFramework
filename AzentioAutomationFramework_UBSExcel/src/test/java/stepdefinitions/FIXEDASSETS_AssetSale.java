package stepdefinitions;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class FIXEDASSETS_AssetSale {

	WebDriver driver = BaseClass.driver;
	FIXEDASSETS_AssetSaleObj fxedAssetAssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);

	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> assetSaleTestData = new HashMap<>();
	Map<String, String> assetSaleReportTestData = new HashMap<>();
	Map<String, String> dataSetID = new HashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDatForAssetSale = new ExcelData(path, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDatForAssetImpairment = new ExcelData(path, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDatForAssetRevaluation = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDatForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDatForAssetImpairementExecution = new ExcelData(path, "AssetImpairement_ExecutionTrack", "TestCaseID");
	ExcelData excelDatForAssetRevaluationExecution = new ExcelData(path, "AssetRevaluation_ExecutionTrack", "TestCaseID");
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);

	@And("^user should navigate to fixed asset menu$")
	public void user_should_navigate_to_fixed_asset_menu() throws InterruptedException, IOException {
		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_DirectionButton());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_DirectionButton().click();
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_Menu());
		fxedAssetAssetSaleObj.fixedAssets_Menu().click();
	}

	@When("^click on eye button of asset sale$")
	public void click_on_eye_button_of_asset_sale() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_EyeButton());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_EyeButton().click();
	}

	@And("^click on add button to create sale asset record$")
	public void click_on_add_button_to_create_sale_asset_record() {
		// waithelper.waitForElementwithFluentwait(driver,
		// fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AddButton(),60,5);
		for (int i = 0; i < 30; i++) {
			try {
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_AddButton().click();
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

	@And("^get the test data for asset sale from excel database for the pre requisite of asset revaluation$")
	public void get_the_test_data_for_asset_sale_from_excel_database_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		dataSetID=excelDatForAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_004_001_01_Revaluation");
		assetSaleTestData = excelDatForAssetSale.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset sale with high price from excel database for asset impairment prerequsite$")
	public void get_the_test_data_for_asset_sale_with_high_price_from_excel_database_for_asset_impairment_prerequsite()
			throws Throwable {
		dataSetID=excelDatForAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_004_001_01");
		assetSaleTestData = excelDatForAssetSale.getTestdata(dataSetID.get("Data Set ID"));
	}

	@And("^get the test data for asset sale with low price from excel database$")
	public void get_the_test_data_for_asset_sale_with_low_price_from_excel_database() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D1");
	}

	@And("^get the test data for asset sale with high price from excel database for pre requiste of asset de allocation$")
	public void get_the_test_data_for_asset_sale_with_high_price_from_excel_database_for_pre_requiste_of_asset_de_allocation()
			throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D4");
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
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleApprovedItemNumber());
		Assert.assertEquals(fxedAssetAssetSaleObj.assetSaleApprovedItemNumber().getText(),
				assetSaleTestData.get("AssetItemNumber"));
	}

	@And("^enter the asset reference number in asset sale$")
	public void enter_the_asset_reference_number_in_asset_sale() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetSaleTestData.get("AssetReferenceNumber") + "']";
		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber()
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
		String xpath = "//ng-dropdown-panel//div[text()='" + assetSaleTestData.get("AssetItemNumber") + "']";
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(assetSaleTestData.get("AssetItemNumber"));
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
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(assetValueStr);
	}

	@And("^enter the asset sale value which is sold in low price$")
	public void enter_the_asset_sale_value_which_is_sold_in_low_price() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(assetSaleTestData.get("Salevalue"));
	}

	@And("^choose the actionable by in asset sale module$")
	public void choose_the_actionable_by_in_asset_sale_module() throws Throwable {
		String xpath = "//ng-dropdown-panel//div[text()='" + assetSaleTestData.get("ActionableBy") + "']";
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(assetSaleTestData.get("ActionableBy"));
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
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_Remark());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_Remark().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(assetSaleTestData.get("Remark"));
	}

	@And("^save the asset sale value record$")
	public void save_the_asset_sale_value_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSaveButton());
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^click on search in maker notification section$")
	public void click_on_search_in_maker_notification_section() throws Throwable {

		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionHelper.moveToElement(kubsCommonObj.kubsNotificationSearchButton());
				clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsNotificationSearchButton());
				break;
			} catch (Exception e) {
				if (i != 500) {
					clicksAndActionHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
					clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
				} else if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^get the asset code and asset reference number of sold asset for sale$")
	public void get_the_asset_code_and_asset_reference_number_of_sold_asset_for_sale() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleListViewApprovedAssetCode());
		String assetSaleApprovedAssetCode = fxedAssetAssetSaleObj.assetSaleListViewApprovedAssetCode().getText();
		assetSaleReportTestData.put("assetSaleApprovedAssetCode", assetSaleApprovedAssetCode);
		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.assetSaleListViewApprovedAssetRefereceNumber());
		String assetSaleApprovedAssetReferenceNumber = fxedAssetAssetSaleObj
				.assetSaleListViewApprovedAssetRefereceNumber().getText();
		assetSaleReportTestData.put("assetSaleApprovedAssetReferenceNumber", assetSaleApprovedAssetReferenceNumber);

	}

	@And("^search the asset sale module code in notification$")
	public void search_the_asset_sale_module_code_in_notification() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSearchEventCode());
//assetSaleTestData.get("Remark")
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(assetSaleTestData.get("ModuleCode"));
	}

	@And("^store the asset sale reference number which is sold at high price$")
	public void store_the_asset_sale_reference_number_which_is_sold_at_high_price() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleReferenceNumber());
		excelDatForAssetSale.updateTestData(assetSaleTestData.get("DataSet ID"), "Reference ID",
				fxedAssetAssetSaleObj.assetSaleReferenceNumber().getText());
	}

	@And("^store the asset sale reference number which is sold at low price$")
	public void store_the_asset_sale_reference_number_which_is_sold_at_low_price() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleReferenceNumber());
		excelDatForAssetSale.updateTestData(assetSaleTestData.get("DataSet ID"), "Reference ID",
				fxedAssetAssetSaleObj.assetSaleReferenceNumber().getText());
	}

	@And("^select the asset sale value record$")
	public void select_the_asset_sale_value_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleNotificationFirstRecord());
		fxedAssetAssetSaleObj.assetSaleNotificationFirstRecord().click();

	}

	@And("^click on submit button in asset sale module$")
	public void click_on_submit_button_in_asset_sale_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsSubmitButton());
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in asset sale record$")
	public void enter_the_alert_remark_in_asset_sale_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertRemark());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(assetSaleTestData.get("MakerRemark"));
	}

	@And("^click on alet submit button in asset sale module$")
	public void click_on_alet_submit_button_in_asset_sale_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAlertSubmit());
		kubsCommonObj.kubsAlertSubmit().click();

	}

	@And("^store the reviewer id in asset sale module excel database$")
	public void store_the_reviewer_id_in_asset_sale_module_excel_database() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDatForAssetSale.updateTestData(assetSaleTestData.get("DataSet ID"), "Reviewer ID", reviewerID);

	}

	@And("^store the asset reference number and item number of sale asset in revaluation excel database$")
	public void store_the_asset_reference_number_and_item_number_of_sale_asset_in_revaluation_excel_database()
			throws Throwable {
		
		excelDatForAssetRevaluation.updateTestData(assetSaleTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetSaleTestData.get("AssetReferenceNumber"));
		excelDatForAssetRevaluation.updateTestData(assetSaleTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetSaleTestData.get("AssetItemNumber"));
	}

	@And("^store the asset reference number and item number of sold asset in impairment excel database$")
	public void store_the_asset_reference_number_and_item_number_of_sold_asset_in_impairment_excel_database()
			throws Throwable {
		excelDatForAssetImpairment.updateTestData(assetSaleTestData.get("Update Data Set 1"), "AssetReferenceNumber",
				assetSaleTestData.get("AssetReferenceNumber"));
		excelDatForAssetImpairment.updateTestData(assetSaleTestData.get("Update Data Set 1"), "AssetItemNumber",
				assetSaleTestData.get("AssetItemNumber"));
	}

	@And("^Store the asset reference number and asset item number of asset sale in asset allocation excel database$")
	public void store_the_asset_reference_number_and_asset_item_number_of_asset_sale_in_asset_allocation_excel_database()
			throws Throwable {
		excelDatForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D8", "AssetReferenceNumber",
				assetSaleTestData.get("AssetReferenceNumber"));
		excelDatForAssetAllocation.updateTestData("KUBS_FAT_UAT_006_003_D8", "AssetItemNumber",
				assetSaleTestData.get("AssetItemNumber"));
	}

	@And("^store the reviewer id in asset sale module excel database  which is sold at low price$")
	public void store_the_reviewer_id_in_asset_sale_module_excel_database_which_is_sold_at_low_price()
			throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsToastAlert());
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDatForAssetSale.updateTestData("KUBS_FAT_UAT_004_003_01_D1", "Reviewer ID", reviewerID);
	}

	@And("^click on temp view of asset sale report$")
	public void click_on_temp_view_of_asset_sale_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsAssetSaleReportTempView());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAssetSaleReportTempView());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAssetSaleReportTempView());
	}

	@And("^enter the asset sale asset code in report$")
	public void enter_the_asset_sale_asset_code_in_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleReoprtAssetCodeInputBox());
		fxedAssetAssetSaleObj.assetSaleReoprtAssetCodeInputBox().click();

		fxedAssetAssetSaleObj.assetSaleReoprtAssetCodeInputBox()
				.sendKeys(assetSaleReportTestData.get("assetSaleApprovedAssetCode"));
		String xpath = "//ng-dropdown-panel//div[text()='" + assetSaleReportTestData.get("assetSaleApprovedAssetCode")
				+ "']";
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

	@And("^give the asset sale date in asset sale report$")
	public void give_the_asset_sale_date_in_asset_sale_report() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.assetSaleReoprtDateField());
		fxedAssetAssetSaleObj.assetSaleReoprtDateField().click();
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
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());
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

	@Then("^validate the sold asset reference number should reflect in asset sale report$")
	public void validate_the_sold_asset_reference_number_should_reflect_in_asset_sale_report() throws Throwable {
		browserHelper.SwitchToWindow(1);

		String xpath = "//div[contains(text(),'" + assetSaleReportTestData.get("assetSaleApprovedAssetReferenceNumber")
				+ "')]";
		for (int i = 0; i <= 500; i++) {
			try {
				boolean refValidation = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(refValidation);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		browserHelper.switchToParentWithChildClose();

	}

// asset sale -excel end
	@And("^get the asset reference number for asset sale$")
	public void get_the_asset_reference_number_for_asset_sale() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssetNewAssetReferenceNumber());

		assetSaleTestData.put("NewAssetReferenceNumber",
				fxedAssetAssetSaleObj.fixedAssetNewAssetReferenceNumber().getText());
	}

	@And("^choose the asset item number in asset sale$")
	public void choose_the_asset_item_number_in_asset_sale() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.DOWN);
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);
	}

	@And("^choose the actionable in asset sale module$")
	public void choose_the_actionable_in_asset_sale_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy().click();
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.DOWN);
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);
	}

	@And("^save the asset sale record$")
	public void save_the_asset_sale_record() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_Save());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_Save().click();
	}

	@Then("^click on first eye button to get the profit earned$")
	public void click_on_first_eye_button_to_get_the_profit_earned() throws InterruptedException, IOException {
		javascriptHelper.JavaScriptHelper(driver);

		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_BookValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_BookValue().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().click();

		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();

		String bv = javascriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value")
				.toString();
		Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
		System.out.println("Book value is: " + bookvalue);

		String sv = javascriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value")
				.toString();
		Double salevalue = Double.parseDouble(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " + salevalue);

		String pft = javascriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[2].value")
				.toString();
		Double profit = Double.parseDouble(pft.replaceAll("[^0-9/.]", ""));

		profit = salevalue - bookvalue;
		System.out.println("Profit earned is : " + profit);

//    	String loss = javascripthelper.executeScript("return document.getElementsByTagName('input')[17].value").toString();
//    	System.out.println("Loss accrued is: " +loss);

	}

	@Then("^click on first eye button to get the loss earned$")
	public void click_on_first_eye_button_to_get_the_loss_earned() throws InterruptedException, IOException {
		javascriptHelper.JavaScriptHelper(driver);

		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_BookValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_BookValue().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_SaleValue().click();

		waitHelper.waitForElementwithFluentwait(driver,
				fxedAssetAssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();

		waitHelper.waitForElementwithFluentwait(driver, fxedAssetAssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL());
		fxedAssetAssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();

		String bv = javascriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value")
				.toString();
		Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
		System.out.println("Book value is: " + bookvalue);

		String sv = javascriptHelper.executeScript(
				"return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value")
				.toString();
		Double salevalue = Double.valueOf(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " + salevalue);

		String loss1 = javascriptHelper.executeScript("return document.getElementsByTagName('input')[17].value")
				.toString();
		Double loss = Double.valueOf(loss1.replaceAll("[^0-9/.]", ""));

		loss = bookvalue - salevalue;
		System.out.println("Loss accrued is: " + loss);

	}

}
