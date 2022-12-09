package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.GL2_JournalVoucher_AccountEntryReportObj;
import resources.BaseClass;
import testDataType.GL2_JournalVoucher_AccountEntryReportTestDataType;

public class GL2_JournalVoucher_AccountEntryReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	GL2_JournalVoucher_AccountEntryReportObj gL2_JournalVoucher_AccountEntryReportObj = new GL2_JournalVoucher_AccountEntryReportObj(
			driver);
	GL2_JournalVoucher_AccountEntryReportTestDataType gL2_JournalVoucher_AccountEntryReportTestDataType = jsonReader
			.getJournalVoucherReportByName("Maker");;
	JavascriptHelper javascripthelper = new JavascriptHelper();

	// -------------------------------@KUBS_GL2_UAT_003_003
	// JournalVoucher----------------------------------------//

	}
