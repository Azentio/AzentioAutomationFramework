package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.GL2_FinancialTransactionReportObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.GL2_FinancialTransactionReportTestDataType;

public class GL2_FinancialTransactionReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);

	AzentioLogin kubsLogin = new AzentioLogin(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	GL2_FinancialTransactionReportObj gL2_FinancialTransactionReportObj = new GL2_FinancialTransactionReportObj(driver);
	GL2_FinancialTransactionReportTestDataType gL2_FinancialTransactionReportTestDataType = jsonReader
			.getFinancialTransactionReportByName("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);

	@And("^click on tool icon$")
	public void click_on_tool_icon() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 5, 500);
		kubsMakerObj.kubsToolIcon().click();
	}

	@Then("^click on Financial reporting button$")
	public void click_on_financial_reporting_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_FinancialReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_FinancialReport().click();

	}

	@Then("^click on Financial Transaction Report$")
	public void click_on_financial_transaction_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport().click();

	}

	@Then("^fill the input fields of Financial Transaction$")
	public void fill_the_input_fields_of_financial_transaction() {
		// BranchCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch().click();
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.BranchCode);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch().sendKeys(Keys.ENTER);

		// GlCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode().click();
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.GlCode);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode().sendKeys(Keys.ENTER);
	}

	@Then("^Select Transaction from date Financial Transaction Report$")
	public void select_transaction_from_date_financial_transaction_report() {

		// select Transaction from date
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarFromDate(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarFromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_FinancialTransactionReportTestDataType.FromMonth + " "
										+ gL2_FinancialTransactionReportTestDataType.Year + "')]")),
								5, 500);

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + gL2_FinancialTransactionReportTestDataType.FromMonth + " "
								+ gL2_FinancialTransactionReportTestDataType.Year + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_NextMonth(), 5, 500);
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_NextMonth().click();
			}
		}
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + gL2_FinancialTransactionReportTestDataType.FromFullMonth
						+ " " + gL2_FinancialTransactionReportTestDataType.FromDay + ", "
						+ gL2_FinancialTransactionReportTestDataType.Year + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@Then("^select Transaction to date Financial Transaction Report$")
	public void select_transaction_to_date_financial_transaction_report() {

		// select Transaction to date

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarToDate(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarToDate().click();

		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + gL2_FinancialTransactionReportTestDataType.ToMonth
										+ " " + gL2_FinancialTransactionReportTestDataType.Year + "')]")),
						5, 500);
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + gL2_FinancialTransactionReportTestDataType.ToMonth + " "
								+ gL2_FinancialTransactionReportTestDataType.Year + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver
				.findElement(By.xpath("//td[@aria-label='" + gL2_FinancialTransactionReportTestDataType.ToFullMonth
						+ " " + gL2_FinancialTransactionReportTestDataType.ToDate + ", "
						+ gL2_FinancialTransactionReportTestDataType.Year + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@And("^click view button of report$")
	public void click_view_button_of_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_View(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_View().click();

	}

	@Then("^verify the approved invoicebill number is available in report$")
	public void verify_the_approved_invoicebill_number_is_available_in_report() throws Throwable {
		System.out.println("Voucher " + gL2_FinancialTransactionReportTestDataType.Voucher);
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();
	}

	// ----------KUBS_GL2_UAT_008_005 GL monthly balances----------------//

	@Then("^click on GL monthly balances$")
	public void click_on_gl_monthly_balances() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport().click();

	}

	@Then("^fill the input fields of GL monthly balances$")
	public void fill_the_input_fields_of_gl_monthly_balances() {
		// BranchCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Branch(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Branch().click();
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Branch()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.BranchCode);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Branch().sendKeys(Keys.ENTER);

		// GlCode
		waithelper.waitForElement(driver, 3000, gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_GlCode());
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_GlCode().click();
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_GlCode()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.GlCode);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_GlCode().sendKeys(Keys.ENTER);

		// Currency
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Currency(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Currency().click();
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Currency()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.Currency);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport_Currency().sendKeys(Keys.ENTER);

	}

	@Then("^verify the Record available in report$")
	public void verify_the_record_available_in_report() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();

	}

	// -----------------KUBS_GL2_UAT_008_011 Balancesheet
	// report-------------------//

	@Then("^click on balancesheet report$")
	public void click_on_balancesheet_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport().click();

	}

	@Then("^fill the input fields of balancesheet report$")
	public void fill_the_input_fields_of_balancesheet_report() {
		// BranchCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().click();
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.BranchCode);
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().sendKeys(Keys.DOWN);
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
		gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().click();
		gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().sendKeys(Keys.DOWN);
		gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().sendKeys(Keys.ENTER);
	}

	@Then("^verify the Record available in the report$")
	public void verify_the_record_available_in_the_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(2000);
		for (int i = 0; i <= 3000; i++) {
			try {
				javascripthelper.scrollIntoView(gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport());
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport(), 5, 500);
				gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport().isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				if (i == 3000) {
					Assert.fail();
				}
			}
		}
//		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();
	}

	// --------------------Cashflow statement report-----------------------//

	@Then("^click on Cashflow statement report$")
	public void click_on_cashflow_statement_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport().click();

	}

	@Then("^fill the input fields of Cashflow statement report$")
	public void fill_the_input_fields_of_cashflow_statement_report() {
		// BranchCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch().click();
		gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.BranchCode);
		gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch().sendKeys(Keys.ENTER);

	}

	// -----------------Income statement report--------------------------//

	@Then("^click on Income statement report$")
	public void click_on_income_statement_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport().click();

	}

	@Then("^fill the input fields of Income statement report$")
	public void fill_the_input_fields_of_income_statement_report() {
		// BranchCode
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch().click();
		gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch()
				.sendKeys(gL2_FinancialTransactionReportTestDataType.BranchCode);
		gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch().sendKeys(Keys.ENTER);

	}

}
