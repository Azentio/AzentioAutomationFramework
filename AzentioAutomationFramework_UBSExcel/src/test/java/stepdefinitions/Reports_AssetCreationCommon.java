package stepdefinitions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.Reports_AssetCreationCommonObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class Reports_AssetCreationCommon {

	WebDriver driver = BaseClass.driver;
	WaitHelper waitHelper = new WaitHelper(driver);
	Reports_AssetCreationCommonObj reports_AssetCreationCommonObj = new Reports_AssetCreationCommonObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "LimitConfigCataTestData", "Data Set ID");
	Map<String, String> limitconfig;
	ExcelData excelDataCheckAssertSerialNum = new ExcelData(path, "CheckAssSerialNumTestData", "Data Set ID");
	Map<String, String> checkAssertSerialNum = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);

	@And("^user should navigate to reports menu$")
	public void user_should_navigate_to_reports_menu() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon().click();

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu().click();
	}

	@Then("^click on temp grid button of asset creation common$")
	public void click_on_temp_grid_button_of_asset_creation_common() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationCommonTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationCommonTempView().click();
	}

	@Then("^click on temp grid button of asset creation item$")
	public void click_on_temp_grid_button_of_asset_creation_item() {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper
				.scrollIntoView(reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView());
		// waithelper.waitForElementwithFluentwait(driver, 3000,
		// reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView().click();
	}

	@Then("^click in the view button to check$")
	public void click_in_the_view_button_to_check() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton().click();
	}

//-------	Check Asset Category
	@And("^select the asset life unit and date to check the asset limit are displaying$")
	public void select_the_asset_life_unit_date_to_check_the_asset_limit_are_displaying() {

	}

	@Then("^click on temp grid button of depreciation$")
	public void click_on_temp_grid_button_of_depreciation() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_DepreciationTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_DepreciationTempView().click();
	}



	@Then("^the report is displaying all the asset depreciation details for a branch$")
	public void the_report_is_displaying_all_the_asset_depreciation_details_for_a_branch() throws InterruptedException, IOException {

		browserHelper.SwitchToWindow(1);
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_Depreciation_DepreciationReport());
		reports_AssetCreationCommonObj.Report_Depreciation_DepreciationReport().isDisplayed();
		browserHelper.switchToParentWithChildClose();

	}

//-------------------	asset contract
	@Then("^click on temp grid button of asset contract$")
	public void click_on_temp_grid_button_of_asset_contract() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetContractTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetContractTempView().click();
	}

	@Then("^the report is displaying all the asset contract details for a branch$")
	public void the_report_is_displaying_all_the_asset_contract_details_for_a_branch() throws InterruptedException, IOException {
		browserHelper.SwitchToWindow(1);
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetContract_AssetContractReport());
		reports_AssetCreationCommonObj.Report_AssetContract_AssetContractReport().isDisplayed();
		driver.close();
		browserHelper.SwitchToWindow(0);
	}

//-----------    Asset Transfer

	@Then("^click on temp grid button of asset transfer$")
	public void click_on_temp_grid_button_of_asset_transfer() throws IOException {
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetTransferTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetTransferTempView().click();
	}

	@Then("^the report is displaying all the asset transfer details for a branch$")
	public void the_report_is_displaying_all_the_asset_transfer_details_for_a_branch() throws InterruptedException, IOException {
		browserHelper.SwitchToWindow(1);
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport());
		boolean reports = reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport().isDisplayed();
		System.out.println("The report is displaying all the asset transfer details for a branch - " + reports);
		browserHelper.switchToParentWithChildClose();
		// ---report fetching code---//
	}

	@Then("^the report is displaying all the asset undertaking details for a branch$")
	public void the_report_is_displaying_all_the_asset_undertaking_details_for_a_branch() throws InterruptedException, IOException {
		browserHelper.SwitchToWindow(1);
		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport());
		boolean reports = reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport().isDisplayed();
		System.out.println("The report is displaying all the asset undertaking details for a branch - " + reports);
		browserHelper.switchToParentWithChildClose();
		// ---report fetching code---//
	}

	@Then("^click on temp grid button of account payable report$")
	public void click_on_temp_grid_button_of_account_payable_report() throws InterruptedException {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper
				.scrollIntoView(reports_AssetCreationCommonObj.Report_AssetCreationCommon_FinancialReportingMenu());
		reports_AssetCreationCommonObj.Report_AccountPayableReport_AccountPayableReportTempView().click();
	}

	@Then("^verify the accounts payable report must correctly displayed$")
	public void verify_the_accounts_payable_report_must_correctly_displayed()
			throws InterruptedException, IOException, ParseException {
		browserHelper.SwitchToWindow(1);
		for (int i = 0; i < 5; i++) {
			try {
				javascriptHelper.JavaScriptHelper(driver);
				javascriptHelper.scrollIntoView(
						driver.findElement(By.xpath("//div[contains(text(),'" + jsonWriter.readdata() + ")]")));
				boolean result = driver.findElement(By.xpath("//div[contains(text(),'" + jsonWriter.readdata() + ")]"))
						.isDisplayed();
				System.out.println(result);
			} catch (NoSuchElementException e) {
				waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AccountPayableReport_NextPage());
				reports_AssetCreationCommonObj.Report_AccountPayableReport_NextPage().click();
			}

		}

		browserHelper.switchToParentWithChildClose();

	}

	@And("^user should navigate to master reports menu$")

	public void user_should_navigate_to_master_reports_menu() throws IOException {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_MasterReportsMenu());

		reports_AssetCreationCommonObj.Report_MasterReportsMenu().click();

	}

	@Then("^click on temp grid button of asset code$")

	public void click_on_temp_grid_button_of_asset_code() throws IOException {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCodeReport_TempView());

		reports_AssetCreationCommonObj.Report_AssetCodeReport_TempView().click();

	}

	@Then("^click on temp grid button of asset category$")

	public void click_on_temp_grid_button_of_asset_category() throws IOException {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCategoryReport_TempView());

		reports_AssetCreationCommonObj.Report_AssetCategoryReport_TempView().click();

	}

	@Then("^click on temp grid button of asset limit configuration$")

	public void click_on_temp_grid_button_of_asset_limit_configuration() {

		javascriptHelper.JavaScriptHelper(driver);

		javascriptHelper
				.scrollIntoViewAndClick(reports_AssetCreationCommonObj.Report_AssetLimitConfiguration_TempView());

	}

	@Then("^click on temp grid button of asset serial number$")

	public void click_on_temp_grid_button_of_asset_serial_number() {

		javascriptHelper.JavaScriptHelper(driver);

		javascriptHelper.scrollIntoViewAndClick(reports_AssetCreationCommonObj.Report_AssetSerialNumber_TempView());

	}

	@And("^select the accounting standards and date to check the asset limit are displaying$")

	public void select_the_accounting_standards_date_to_check_the_asset_limit_are_displaying()
			throws InterruptedException, IOException {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(limitconfig.get("AccountingStandards"));

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();


		while (true)

		{

			try

			{

				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + limitconfig.get("AssetCategoryToMonth")
								+ " " + limitconfig.get("AssetCategoryToYear") + "')]")));

				driver
						.findElement(By.xpath("//span[contains(text(),'" + limitconfig.get("AssetCategoryToMonth") + " "
								+ limitconfig.get("AssetCategoryToYear") + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ limitconfig.get("AssetCategoryToFullMonth") + " " + limitconfig.get("AssetCategoryToDate") + ", "
				+ limitconfig.get("AssetCategoryToYear") + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@And("^select the asset category and date to check the asset category are displaying$")

	public void select_the_asset_category_and_date_to_check_the_asset_category_are_displaying()
			throws InterruptedException, IOException {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(limitconfig.get("AssetCategory"));

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();


		while (true)

		{

			try

			{

				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + limitconfig.get("AssetCategoryToMonth")
								+ " " + limitconfig.get("AssetCategoryToYear") + "')]")));

				 driver
						.findElement(By.xpath("//span[contains(text(),'" + limitconfig.get("AssetCategoryToMonth") + " "
								+ limitconfig.get("AssetCategoryToYear") + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ limitconfig.get("AssetCategoryToFullMonth") + " " + limitconfig.get("AssetCategoryToDate") + ", "
				+ limitconfig.get("AssetCategoryToYear") + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@Then("^the report is displaying all the asset codes details for a branch$")

	public void the_report_is_displaying_all_the_asset_codes_details_for_a_branch() throws InterruptedException, IOException {

		browserHelper.SwitchToWindow(1);

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCodesReport());

		boolean result = reports_AssetCreationCommonObj.Report_AssetCodesReport().isDisplayed();

		System.out.println(result);

		browserHelper.switchToParentWithChildClose();

	}

	@Then("^the report is displaying all the asset category details for a branch$")

	public void the_report_is_displaying_all_the_asset_category_details_for_a_branch() throws InterruptedException, IOException {

	

		browserHelper.SwitchToWindow(1);

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCodesReport());

		boolean result = reports_AssetCreationCommonObj.Report_AssetCodesReport().isDisplayed();

		System.out.println(result);

		browserHelper.switchToParentWithChildClose();

	}

	@And("^User get the test data for check assert serial number$")
	public void user_get_the_test_data_for_check_assert_serial_number() throws Throwable {
		checkAssertSerialNum = excelDataCheckAssertSerialNum.getTestdata("KUBS_FAT_UAT_013_006_D1");
	}

	@And("^User click the fixed assert config button$")
	public void user_click_the_fixed_assert_config_button() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.FixedAssertConfigButton());
		reports_AssetCreationCommonObj.FixedAssertConfigButton().click();

	}

	@And("^User click the assert serial number setup tempview$")
	public void user_click_the_assert_serial_number_setup_tempview() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.AssertSerialNumberSetup());
		reports_AssetCreationCommonObj.AssertSerialNumberSetup().click();

	}

	@And("^User get the assert code in fixed assert config$")
	public void user_get_the_assert_code_in_fixed_assert_config() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.AssertReport_AssertCode());
		String AssertCode = reports_AssetCreationCommonObj.AssertReport_AssertCode().getText();
		System.out.println(reports_AssetCreationCommonObj.AssertReport_AssertCode().getText());
		checkAssertSerialNum.put("AssertCode", AssertCode);
		waitHelper.waitForElementwithFluentwait(driver,
				reports_AssetCreationCommonObj.AssertReport_AssertCode());

		String AssetStartSerialNumber = reports_AssetCreationCommonObj.AssertReportAssertSerialNumber().getText();
		checkAssertSerialNum.put("AssetStartSerialNumber", AssetStartSerialNumber);

	}

	// ------- Check Asset Category

	@And("^User enter the assert code$")
	public void user_enter_the_assert_code() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(checkAssertSerialNum.get("AssertCode"));

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);
	}

	@And("^User enter the start assert serial number$")
	public void user_enter_the_start_assert_serial_number() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetLimit_StartSerialNumber());

		reports_AssetCreationCommonObj.Report_AssetLimit_StartSerialNumber()
				.sendKeys(checkAssertSerialNum.get("AssetStartSerialNumber"));

	}

	@And("^User select the date in assert report$")
	public void user_select_the_date_in_assert_report() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
		waitHelper.waitForElementwithFluentwait(driver, kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.moveToElement(kubsCommonObj.kubsCalendarMonthYearOption());
		clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsCalendarMonthYearOption());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/uuuu");

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MMMM/uuuu");

		LocalDate localDate = LocalDate.now();
		// System.out.println(dtf.format(localDate));
		String Date = dtf.format(localDate);
		String Date1 = dtf1.format(localDate);
		String[] DateSplit = Date.split("[/]");
		String[] DateSplit1 = Date1.split("[/]");
		Integer DateNum = Integer.valueOf(DateSplit[0]);
		String Month = DateSplit[1];
		String FullMonth = DateSplit1[1];
		Integer yearNum = Integer.valueOf(DateSplit[2]);

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

		for (int i = 0; i < 50; i++) {
			try {
				WebElement FinalDay2 = driver.findElement(
						By.xpath("//td[@aria-label='" + FullMonth + " " + DateNum + ", " + yearNum + "']/span"));

				clicksAndActionHelper.doubleClick(FinalDay2);
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}

			}
		}

	}

	@And("^User get the limit config testdata for test case01$")
	public void user_get_the_limit_config_testdata_for_test_case01() throws Throwable {
		limitconfig = excelData.getTestdata("KUBS_FAT_UAT_013_001_D1");
	}

	@And("^User get the limit config testdata for test case02$")
	public void user_get_the_limit_config_testdata_for_test_case02() throws Throwable {
		limitconfig = excelData.getTestdata("KUBS_FAT_UAT_013_002_D1");
	}

}
