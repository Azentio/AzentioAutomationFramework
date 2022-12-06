package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_AccountingEntries {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String GRNNO;
	String Branchcode;
	String InvoiceNo;
	String PoNumber;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	String TxnNo;
	Map<String, String> Getdata =new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	BrowserHelper browseHelper = new BrowserHelper(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","ARAP_AccountingEntries", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^Update the data set id for Accounting entries post bill is approved$")
    public void update_the_data_set_id_for_accounting_entries_post_bill_is_approved() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_12_D1");     
    }
	
	@Then("^Give the Invoice Number for Puchase Bill$")
	public void give_the_invoice_number_for_puchase_bill() throws Throwable {
		// --------INVOICE FOR PURCHASE CONTRACT--------//
		arapObj.ARAP_InvoiceNumber().click();
		arapObj.ARAP_InvoiceNumber().sendKeys(testData.get("InvoiceNoBill"));

	}
	
	@And("^Choose Enquiry Module$")
	public void choose_enquiry_module() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPEnquiryMenu());
		arapObj.ARAPEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPFinancialTransactionIcon());
		Assert.assertTrue(arapObj.ARAPFinancialTransactionIcon().isDisplayed());
	}

	@Then("^Click Note iCon near by financial transction$")
	public void click_note_icon_near_by_financial_transction() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		arapObj.ARAPFinancialTransactionIcon().click();
	}
	@And("^choose branch codes$")
	public void choose_branch_codes() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAPBranchCode());
		arapObj.ARAPBranchCode().click();
		arapObj.ARAPBranchCode().sendKeys(testData.get("BranchCode"));
		arapObj.ARAPBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date in calender$")
	public void click_on_transaction_from_date_in_calender() throws Throwable {
		// -----------CLICK ON CALANDER--------------//
		arapObj.ARAPFromDate().click();
	}

	@Then("^Select from date in calender$")
	public void select_from_date_in_calender() throws Throwable {
		// ----------CLICK ON FROM DATE--------------//
		while (true) {
			try {

	waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]")));
	WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]"));
	Thread.sleep(2000);
	break;
			}

   catch (NoSuchElementException nosuchElement) {
arapObj.ARAPNextMonth().click();
			
   }
		
	}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clickAndActionHelper.doubleClick(Click);

			}

	@And("^click on transaction to date in calender icon$")
	public void click_on_transaction_to_date_in_calender_icon() throws Throwable {
		// ----------CLICK ON TRANSACTION TO DATE--------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPToDate());
		arapObj.ARAPToDate().click();
	}

	@Then("^Select To date in calender$")
	public void select_to_date_in_calender() throws Throwable {
		while (true) {
			try {

				//span[contains(text(),'Oct 2022')]
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month1")+" "+testData.get("Year1")+"')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month1")+" "+testData.get("Year1")+"')]"));
//				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("FullMonth1") + " " + testData.get("Date1") + ", " + testData.get("Year1") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth1") + " "
				+ testData.get("Date1") + ", " + testData.get("Year1") + "']/span"));

		clickAndActionHelper.doubleClick(Click);

			    
	}

	@And("^Click View HyperLink$")
	public void click_view_hyperlink() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		for (int i = 0; i <= 20; i++) {
			try {
		waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAPViewButton());
		WebElement ViewButton = arapObj.ARAPViewButton();
		clickAndActionHelper.doubleClick(ViewButton);
		break;

			} catch (Exception e) {
				
			}}
	}

	@Then("^Verify Accounting entries post Bill is approved$")
	public void verify_accounting_entries_post_bill_is_approved() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNoBill") + "')])[1]"))
						.isDisplayed();

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNoBill") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ testData.get("InvoiceNoBill")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ testData.get("InvoiceNoBill")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNoBill") + "')])[2]"))
						.isDisplayed();

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNoBill") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ testData.get("InvoiceNoBill")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ testData.get("InvoiceNoBill")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
//			if (i == 299) {
//				Assert.fail();
//			}
		}
	}

}
