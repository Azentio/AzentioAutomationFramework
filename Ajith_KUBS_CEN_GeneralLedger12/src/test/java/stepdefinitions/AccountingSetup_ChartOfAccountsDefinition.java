package stepdefinitions;

import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountingSetup_ChartOfAccountsDefinitionObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountingSetup_ChartOfAccountsDefinitionTestDataType;

public class AccountingSetup_ChartOfAccountsDefinition {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionObj ChartOfAccountsDefinitionObj = new AccountingSetup_ChartOfAccountsDefinitionObj(
			driver);
//	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
//	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionTestDataType ChartOfAccountsDefinitionTestDataType = jsonReader
			.getChartOfAccountsDefinitiondata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	
}