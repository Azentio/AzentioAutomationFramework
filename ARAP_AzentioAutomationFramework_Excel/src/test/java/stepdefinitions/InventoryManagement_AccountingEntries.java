package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class InventoryManagement_AccountingEntries {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"AccountingEntriesTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	///////////////////////// 006_001////////////////////////
	@Then("^click on edit icon near fiancial transaction menu$")
	public void click_on_edit_icon_near_fiancial_transaction_menu() throws Throwable {
		
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^choose the branch code$")
	public void choose_the_branch_code() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryBranchCode());
		inventoryManagamentObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^choose the Gl code$")
	public void choose_the_gl_code() throws Throwable {
		
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryGlCode());
		inventoryManagamentObj.inventoryGlCode().sendKeys(testData.get("gLCode"));
		inventoryManagamentObj.inventoryGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click transaction from date calender icon$")
	public void click_transaction_from_date_calender_icon() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryFromDate());
		inventoryManagamentObj.inventoryFromDate().click();

	}

	@Then("^choose from date$")
	public void choose_from_date() throws Throwable {
//		Thread.sleep(2000);
		for(int i=0;i<=50;i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + "']"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on transaction to date calender icon$")
	public void click_on_transaction_to_date_calender_icon() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryToDate());
		inventoryManagamentObj.inventoryToDate().click();

	}

	@Then("^choose to date$")
	public void choose_to_date() throws Throwable {
//		Thread.sleep(500);
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL To FullMonth") + " " + testData.get("GL To Date") + ", " + testData.get("GL To Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL To FullMonth") + " " + testData.get("GL To Date") + ", " + testData.get("GL To Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@Then("^Fill Transaction Ref No to check GL$")
    public void fill_transaction_ref_no_to_check_gl() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_TransactionRefNo());
		inventoryManagamentObj.inventory_TransactionRefNo().sendKeys(testData.get("Transaction Ref No"));
		inventoryManagamentObj.inventory_TransactionRefNo().sendKeys(Keys.ENTER);
		
    }

	@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
//		Thread.sleep(3000);
	}

	////////////////////////// 006_002///////////////////////////

	@And("^click Enquiry menu$")
	public void click_Enquiry_menu() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryEnquiryMenu());
		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on Edit icon near by financial transaction$")
	public void click_on_edit_icon_near_by_financial_transaction() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^choose branch code Id$")
	public void choose_branch_code_Id() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryBranchCode());
		inventoryManagamentObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^choose the Gl code Id$")
	public void choose_the_gl_code_id() throws Throwable {
		// -----------CLICK ON GL CODE--------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryGlCode());
		inventoryManagamentObj.inventoryGlCode().sendKeys(testData.get("gLCode"));
		inventoryManagamentObj.inventoryGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date in calender icon$")
	public void click_on_transaction_from_date_calender_in_calender_icon() throws Throwable {
		// -----------CLICK ON CALANDER--------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryFromDate());
		inventoryManagamentObj.inventoryFromDate().click();
	}

	@Then("^choose from date in the calender$")
	public void choose_from_date_in_the_calender() throws Throwable {
		// ----------CLICK ON FROM DATE--------------//
//		Thread.sleep(1000);
		while (true) {
			try {

				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
//		Thread.sleep(1000);
		clicksAndActionHelper.doubleClick(FinalDay);

	}

	@And("^click on the transaction to date in calender icon$")
	public void click_on_the_transaction_to_date_calender_in_calender_icon() throws Throwable {
		// ----------CLICK ON TRANSACTION TO DATE--------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryToDate());
		inventoryManagamentObj.inventoryToDate().click();

	}

	@Then("^choose the To date in the calender$")
	public void choose_the_to_date_in_the_calender() throws Throwable {
//		Thread.sleep(1000);
		while (true) {
			try {

				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]"));
				break;
			}
			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL To FullMonth") + " " + testData.get("GL To Date") + ", " + testData.get("GL To Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL To FullMonth") + " " + testData.get("GL To Date") + ", " + testData.get("GL To Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button to see the Record$")
	public void click_on_view_button_to_see_the_record() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		waithelper.waitForElementwithFluentwait(driver,  inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
//		Thread.sleep(2000);

	}

	@Then("^validate voucher number$")
	public void validate_voucher_number() throws Throwable {
//		Thread.sleep(2000);
		for(int i=0;i<=30;i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Voucher") + "')]")));
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Voucher") + "')]"));
				System.out.println("Record is present in the list");
				break;
			}
			catch (NoSuchElementException nosuchElement)
			{
				javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());
				inventoryManagamentObj.inventory_Next().click();
			}
		}
	}

	@Then("^select data set ID for checking accounting entries$")
	public void select_data_set_id_for_checking_accounting_entries() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_008_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for checking GL$")
	public void select_data_set_id_for_checking_gl() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_006_002_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}
