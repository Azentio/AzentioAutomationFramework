package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountingSetup_ChartOfAccountsDefinitionObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_TrialBalanceReportObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FinancialReporting_TrialBalanceReportTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class FinancialReporting_TrialBalanceReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_TrialBalanceReportObj financialReporting_TrialBalanceReportObj = new FinancialReporting_TrialBalanceReportObj(
			driver);
	AccountingSetup_ChartOfAccountsDefinitionObj accountingSetup_ChartOfAccountsDefinitionObj = new AccountingSetup_ChartOfAccountsDefinitionObj(
			driver);
	FinancialReporting_TrialBalanceReportTestDataType TrialBalanceReportTestDataType = jsonReader
			.getTrialBalanceReportdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType = jsonReader.getJournalVoucherdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	@Then("^click on temp grid button of Trial Balance report$")
	public void click_on_temp_grid_button_of_Trial_balance_report() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton().click();
	}

	@And("^fill the required field of Trial Balance report$")
	public void fill_the_required_field_of_Trial_balance_report() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(TrialBalanceReportTestDataType.BranchCode);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);

		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.ENTER);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth + " "
										+ TrialBalanceReportTestDataType.TrialYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth
								+ " " + TrialBalanceReportTestDataType.TrialYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullMonth + " " + TrialBalanceReportTestDataType.TrialDate + ", "
				+ TrialBalanceReportTestDataType.TrialYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth + " "
										+ TrialBalanceReportTestDataType.TrialToYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth
								+ " " + TrialBalanceReportTestDataType.TrialToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullToMonth + " " + TrialBalanceReportTestDataType.TrialToDate
				+ ", " + TrialBalanceReportTestDataType.TrialToYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

//		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency());
//		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(TrialBalanceReportTestDataType.Currency);
//		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(Keys.ENTER);
	}

	@And("^click on view button in trial balance report$")
	public void click_on_view_button_in_trial_balance_report() throws Throwable {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
	}

	@Then("^click on view button to view the report of Trial balance$")
	public void click_on_view_button_to_view_the_report_of_trial_balance() throws InterruptedException {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
		for(int i=0;i<=3000000;i++)
		try
		{
		 browserHelper.SwitchToWindow(1);
		break;
		}
		catch(IndexOutOfBoundsException e)
		{
		if(i==3000000)
		{
			
			e.printStackTrace();
			Assert.fail("Report not openene");
		}
		}
		 for (int i = 0; i <= 200; i++) {
			try {
				driver.findElement(By.xpath("//div[text()='TRIAL BALANCE']")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				if (i == 200) {
					e.printStackTrace();
				}

			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	// ------------------Trial balance Report Summary

	@Then("^click on temp grid button of Trial Balance report summarized$")
	public void click_on_temp_grid_button_of_Trial_Balance_report_summarized() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton().click();
	}

	@And("^fill the required field of Trial Balance report summarized$")
	public void fill_the_required_field_of_Trial_Balance_report_summarized() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(TrialBalanceReportTestDataType.BranchCodeForTrialBalancesSummary);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.ENTER);

		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.ENTER);
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ TrialBalanceReportTestDataType.TrialMonthForTrialBalancesSummary + " "
								+ TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonthForTrialBalancesSummary
								+ " " + TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + TrialBalanceReportTestDataType.TrialFullMonthForTrialBalancesSummary
						+ " " + TrialBalanceReportTestDataType.TrialDateForTrialBalancesSummary + ", "
						+ TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ TrialBalanceReportTestDataType.TrialToMonthForTrialBalancesSummary + " "
								+ TrialBalanceReportTestDataType.TrialToYearForTrialBalancesSummary + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonthForTrialBalancesSummary
								+ " " + TrialBalanceReportTestDataType.TrialToYearForTrialBalancesSummary + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + TrialBalanceReportTestDataType.TrialToFullMonthForTrialBalancesSummary
						+ " " + TrialBalanceReportTestDataType.TrialToDateForTrialBalancesSummary + ", "
						+ TrialBalanceReportTestDataType.TrialToYearForTrialBalancesSummary + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency()
				.sendKeys(TrialBalanceReportTestDataType.Currency);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj
				.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary()
				.sendKeys(TrialBalanceReportTestDataType.Currency);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary()
				.sendKeys(Keys.ENTER);
	}

	@Then("^click on view button to view the report of Trial balance summary$")
	public void click_on_view_button_to_view_the_report_of_trial_balance_summary() throws InterruptedException {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
		Thread.sleep(5000);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		browserHelper.switchToParentWithChildClose();

	}

	// ----008_009 & 008_010

	@And("^user should navigate to accounting setup menu$")
	public void user_should_navigate_to_accounting_setup_menu() {
		waithelper.waitForElement(driver, 3000, accountingSetup_ChartOfAccountsDefinitionObj.AccountingSetupMenu());
		accountingSetup_ChartOfAccountsDefinitionObj.AccountingSetupMenu().click();
	}

	@Then("^click on eye button of chart of accounts definition submenu$")
	public void click_on_eye_button_of_chart_of_accounts_definition_submenu() {
		waithelper.waitForElement(driver, 3000,
				accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EyeButton());
		accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EyeButton().click();
	}

	@Then("^search coa code using coa name$")
	public void search_coa_code_using_coa_name() {
		waithelper.waitForElement(driver, 3000, accountingSetup_ChartOfAccountsDefinitionObj
				.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch());
		accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
				.sendKeys(TrialBalanceReportTestDataType.COA_Name);
	}

	@And("^get the coa code$")
	public void get_the_coa_code() throws IOException {
		String coacode = accountingSetup_ChartOfAccountsDefinitionObj
				.accountingSetup_ChartOfAccountsDefinition_COA_Code().getText();
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(coacode);
	}

	@And("^fill the required field of Trial Balance report based on leaf GL$")
	public void fill_the_required_field_of_trial_balance_report_based_on_gl() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(TrialBalanceReportTestDataType.BranchCode);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.ENTER);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth + " "
										+ TrialBalanceReportTestDataType.TrialYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth
								+ " " + TrialBalanceReportTestDataType.TrialYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullMonth + " " + TrialBalanceReportTestDataType.TrialDate + ", "
				+ TrialBalanceReportTestDataType.TrialYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth + " "
										+ TrialBalanceReportTestDataType.TrialToYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth
								+ " " + TrialBalanceReportTestDataType.TrialToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullToMonth + " " + TrialBalanceReportTestDataType.TrialToDate
				+ ", " + TrialBalanceReportTestDataType.TrialToYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency()
				.sendKeys(TrialBalanceReportTestDataType.Currency);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(Keys.ENTER);
	}

	@And("^fill the required field of Trial Balance report based on given date$")
	public void fill_the_required_field_of_trial_balance_report_based_on_given_date() {

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(TrialBalanceReportTestDataType.BranchCode);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth + " "
										+ TrialBalanceReportTestDataType.TrialYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth
								+ " " + TrialBalanceReportTestDataType.TrialYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullMonth + " " + TrialBalanceReportTestDataType.TrialDate + ", "
				+ TrialBalanceReportTestDataType.TrialYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth + " "
										+ TrialBalanceReportTestDataType.TrialToYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth
								+ " " + TrialBalanceReportTestDataType.TrialToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullToMonth + " " + TrialBalanceReportTestDataType.TrialToDate
				+ ", " + TrialBalanceReportTestDataType.TrialToYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().click();
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys("INR");
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(Keys.DOWN);
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(Keys.ENTER);
	}

	@And("^check the trial balance based on the leaf gl is available$")
	public void check_the_trial_balance_based_on_the_leaf_gl_is_available()
			throws IOException, ParseException, InterruptedException {
		// Thread.sleep(6000);
//    	waithelper.waitForElement(driver, 10000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Report());
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300000; i++) {
			try {
				browserHelper.SwitchToWindow(1);
				break;
			} catch (IndexOutOfBoundsException e) {
				if (i == 300000) {
					e.printStackTrace();
				}
			}
		}
		String beforexpath = "//td//div[contains(text(),'";
		String afterxpath = "')]";
		// Thread.sleep(6000);
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(beforexpath +jsonWriter.readdata()+ afterxpath)));
//    	javascripthelper.scrollIntoView(driver.findElement(By.xpath(beforexpath +jsonWriter.readdata()+ afterxpath)));

		System.out.println("Leaf GL is in JSON " + jsonWriter.readdata());
//    	System.out.println("Leaf GL is"+leafGL);
		for(int j=1;j<=3;j++)
		{
		for(int i=3;i<=30;i++) {
			try {
				//table[@id='__bookmark_2']//tr[8]//td[1]/div
				String leafGl = driver.findElement(By.xpath("//table[@id='__bookmark_2']//tr["+i+"]//td[1]/div")).getText();
				System.out.println("leaf GL is"+leafGl);
				
			if((jsonWriter.readdata().trim()).equals(leafGl.trim()));
			{
				break;
			}
			} catch (NoSuchElementException e) {

				if(i==30)
				{
				driver.findElement(By.xpath("//input[@title='Next page']")).click();
				}
				} catch (StaleElementReferenceException e) {

			}
		}
		
		}
		
		browserHelper.switchToParentWithChildClose();
	}

}
