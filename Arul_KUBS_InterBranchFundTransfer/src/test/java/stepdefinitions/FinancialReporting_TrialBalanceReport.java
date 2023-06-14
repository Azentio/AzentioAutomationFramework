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

	}
