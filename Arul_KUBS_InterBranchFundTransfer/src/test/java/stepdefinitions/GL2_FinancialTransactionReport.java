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

	}
