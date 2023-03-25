package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.Account_Receivable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;

public class ARAP_CancellationOfCreditNote extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	String poNumber;
	String poBusinessPartner;
	Map<String, String> testdata = new LinkedHashMap<>();
	Map<String, String> settlementTestData = new HashMap<>();
	Map<String, String> settlementData = new HashMap<>();
	Map<String, String> autoPayout = new HashMap<>();
	Map<String, String> invoiceBookingTestData = new HashMap<>();
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj accountsPayable_PaymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj crediteNoteObj = new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	ARAP_PoCreationObj ArAp_poCreationObj = new ARAP_PoCreationObj(driver);
	ARAP_GRNCreationPageObject grnObject = new ARAP_GRNCreationPageObject(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj = new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj = new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"CancelledCreditNoteTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	// *********************************@KUBS_AR/AP_UAT_003_007TC_01****************************************************//
	// verify accounting entries cancelled credit

	@When("^click the Account Receivable Main Module for verify Accounting entries$")
	public void click_the_account_receivable_main_module_for_verify_accounting_entries() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());

	}

	@And("^click the credit note eye icon$")
	public void click_the_credit_note_eye_icon() throws Throwable {
		
		javascripthelper.scrollIntoView(account_Receivable.accountsReceivable_CreditNote_Eye());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Eye());
	}

	@And("^click the search icon in the list view of credit$")
	public void click_the_search_icon_in_the_list_view_of_credit() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search the cancelled credit note and click the first list$")
	public void search_the_cancelled_credit_note_and_click_the_first_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(testData.get("Contract Status"));
//		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, account_Receivable.accountsReceivable_CreditNote_StatusHead(), 10, 2);
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^store the credit note number$")
	public void store_the_credit_note_number() throws Throwable {
		
		Thread.sleep(1000);
		String creditnotenumber = (String) javascripthelper.executeScript(
				"return document.getElementsByClassName('ng-untouched ng-pristine ng-valid sc-ion-input-md-h sc-ion-input-md-s md has-value hydrated ion-untouched ion-pristine ion-valid')[0].value");
		// String creditnotenumber = (String) javascriphelper.executeScript("return
		// document.getElementsByName('creditnoteNo')[1].value");
		testdata.put("creditnotenumber", creditnotenumber);
		System.out.println(creditnotenumber);
	}

	@And("^click the Notes Option In Top$")
	public void click_the_notes_option_in_top() throws Throwable {
		
		javascripthelper.scrollIntoView(enquiryObj.inventoryReportIcon());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
	}

	@And("^click The Enquiry Module for Accounting Entries$")
	public void click_the_enquiry_module_for_accounting_entries() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryEnquiryMenu());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryEnquiryMenu());
	}

	@And("^Click the Edit icon in Financial Transaction$")
	public void click_the_edit_icon_in_financial_transaction() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFinancialTransactionIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFinancialTransactionIcon());
	}

	@And("^Select Branch code as Azentio Manin Branch$")
	public void select_branch_code_as_azentio_manin_branch() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryBranchCode());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryBranchCode());
		enquiryObj.inventoryBranchCode().sendKeys(testData.get("Branch Code"));
		enquiryObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^Choose the Transaction from date$")
	public void choose_the_transaction_from_date() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFromDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFromDate());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("Year") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + "']")).click();
//		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
//					driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']")).click();
	}

	@And("^choose the Transaction To date and click view option$")
	public void choose_the_transaction_to_date_and_click_view_option() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryToDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryToDate());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ToYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("ToMonth") + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullToMonth") + " " + testData.get("ToDate") + ", " + testData.get("ToYear") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullToMonth") + " " + testData.get("ToDate") + ", " + testData.get("ToYear") + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
		Thread.sleep(2000);
	}

	@Then("^Verify the Credit note number in Voucher Id and verify transaction type$")
	public void verify_the_credit_note_number_in_voucher_id_and_verify_transaction_type() throws Throwable {
		while (true) {
			try {
				seleniumactions.getWaitHelper().waitForElement(driver, 2000,
						driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + testdata.get("creditnotenumber") + "')]")));
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + testdata.get("creditnotenumber") + "')]")).isDisplayed();
				String creditnotenumber = driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'" + testdata.get("creditnotenumber") + "')]")).getText();
				System.out.println("Found the creditnote number in Accounting Entries " + creditnotenumber);
				break;

			} catch (NoSuchElementException e) {
				
				javascripthelper.scrollIntoView(enquiryObj.nextPageInListView());
				seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.nextPageInListView());
				enquiryObj.nextPageInListView().click();
			}
		}
	}

	/////////////////////// 003_007_TC_02//////////////////////////
	@When("^click the Account Receivable main module$")
	public void click_the_account_receivable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click the eye icon in credit note$")
	public void click_the_eye_icon_in_credit_note() throws Throwable {
//		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_Eye());
		
		javascripthelper.scrollIntoView(account_Receivable.accountsReceivable_CreditNote_Eye());
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, account_Receivable.accountsReceivable_CreditNote_Eye(), 20, 2);
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Eye());
	}

	@And("^click the search icon in credit note page$")
	public void click_the_search_icon_in_credit_note_page() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search credit note status as cancelled$")
	public void search_credit_note_status_as_cancelled() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(testData.get("Contract Status"));
	}

	@And("^click the first eye icon in the Cancelled Credit List$")
	public void click_the_first_eye_icon_in_the_cancelled_credit_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get invoice number and get buisness partner name$")
	public void get_invoice_number_and_get_buisness_partner_name() throws Throwable {
		for(int i = 0;i<20;i++) {
			try {
				seleniumactions.getWaitHelper().waitForElement(driver, 20000, account_Receivable.creditNote_Buisness_Partner());
				String buinesspartner = account_Receivable.creditNote_Buisness_Partner().getText();
				testdata.put("buinesspartner", buinesspartner);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.creditNote_Invoice_NumberInCreditNotePage());
		String invoicenumber = account_Receivable.creditNote_Invoice_NumberInCreditNotePage().getText();
		testdata.put("invoicenumber", invoicenumber);
		
		String creditnotenumber = (String) javascripthelper.executeScript("return document.getElementsByName('creditnoteNo')[1].value");
		testdata.put("creditnotenumber", creditnotenumber);
//		System.out.println(creditnotenumber);
	}

	@And("^get buisness partner name , get credit note number and get credit note date$")
	public void get_buisness_partner_name_get_credit_note_number_and_get_credit_note_date() throws Throwable {
		for (int i = 0; i < 20; i++) {
			try {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, account_Receivable.creditNote_Buisness_Partner());
				String buisnessPartnerName = account_Receivable.creditNote_Buisness_Partner().getText();
				testdata.put("buisnessPartnerName", buisnessPartnerName);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		String contractenddate = (String) javascripthelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
		System.out.println(contractenddate);
		String year = contractenddate.substring(7, 11);
		testdata.put("year", year);
		String month = contractenddate.substring(3, 6);
		testdata.put("month", month);
		switch (month) {
		case "Dec":
			testdata.put("fullmonth", "December");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jan":
			testdata.put("fullmonth", "January");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Feb":
			testdata.put("fullmonth", "Febuary");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Mar":
			testdata.put("fullmonth", "March");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Apr":
			testdata.put("fullmonth", "April");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "May":
			testdata.put("fullmonth", "May");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jun":
			testdata.put("fullmonth", "June");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jul":
			testdata.put("fullmonth", "July");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Aug":
			testdata.put("fullmonth", "August");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Sep":
			testdata.put("fullmonth", "September");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Oct":
			testdata.put("fullmonth", "October");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Nov":
			testdata.put("fullmonth", "November");
			System.out.println(testdata.get("fullmonth"));
			break;
		}

		if (Integer.parseInt(contractenddate.substring(0, 2)) > 9) {
			String day = contractenddate.substring(0, 2);
			System.out.println(day);
			testdata.put("day", day);
		} else {
			String day = contractenddate.substring(1, 2);
			testdata.put("day", day);
			System.out.println(day);
		}
		String creditnotenumber = (String) javascripthelper.executeScript("return document.getElementsByName('creditnoteNo')[1].value");
		testdata.put("creditnotenumber", creditnotenumber);
		System.out.println(creditnotenumber);
		System.out.println(testdata.get("creditnotenumber"));

	}

	@And("^click the notes option in top$")
	public void click_the_notes_optin_in_top() throws Throwable {
		
		javascripthelper.scrollIntoView(enquiryObj.inventoryReportIcon());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
	}

	@And("^select the date$")
	public void select_the_date() throws Throwable {
//    	arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");
//    	Thread.sleep(2000);
//    	arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");

		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();

		
		Thread.sleep(1000);
		for(int i=0;i<30;i++) {
			try {
				// span[contains(text(),'Oct 2022')]
//				waithelper.waitForElement(driver, 2000,
//						driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testdata.get("month") + " " + testdata.get("year") + " ']"));
//				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				int year=Integer.parseInt(testData.get("Year"));
				if(year<2023){
					arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_PreviousMonth().click();
				}else if(year>=2023)
					arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testdata.get("fullmonth") + " " + testdata.get("day") + ", " + testdata.get("year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click the view icon$")
	public void click_the_view_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.viewInContractReport());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.viewInContractReport());
		Thread.sleep(5000);
	}
	
	@Then("^Fill branch details for balance sheet report$")
	public void fill_branch_details_for_balance_sheet_report() {

// Thread.sleep(6000);

		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(testData.get("Branch Code"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
// arAp_BalanceSheetReportTestDataType=
// jsonReader.getBalanceSheetReportByName("maker");
		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(testData.get("ReportType"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);

	}

	@Then("^Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.$")
	public void verify_balance_sheet_should_be_updated_correctly_basis_the_legs_impacted_in_accounting_entries() throws Throwable {
		System.out.println("balance sheet view and verified");
		seleniumactions.getBrowserHelper().SwitchToWindow(1);
		Thread.sleep(2000);
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}

	/////////////////////////// 003_007_tc_03/////////////////////////
	@And("^click the Reports Sub Module$")
	public void click_the_reports_sub_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.reportMenu());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.reportMenu());
	}

	@And("^click the Account Receivable Report$")
	public void click_the_account_receivable_report() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.accountsReceivableReportEditIcon());
		enquiryObj.accountsReceivableReportEditIcon().click();
	}

	@And("^select the vendor name$")
	public void select_the_vendor_name() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.selectVendorName());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
		enquiryObj.selectVendorName().sendKeys(testdata.get("buisnessPartnerName"));
		enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
	}

	@And("^select the Receivable status based on we get from Credit note$")
	public void select_the_receivable_status_based_on_we_get_from_credit_note() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.selectContractStatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
		enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
	}

	@Then("^verify the Credit Note cancelled is available in the report$")
	public void verify_the_credit_note_cancelled_is_available_in_the_report() throws Throwable {
		seleniumactions.getBrowserHelper().SwitchToWindow(1);
		Thread.sleep(2000);
		while (true) {
			try {
				
				javascripthelper.scrollIntoView(driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")));
				// seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()='"+testdata.get("creditnotenumber")+"']")));
				driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")).isDisplayed();
				String creditnumber = driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")).getText();
				System.out.println("found the credit number :" + creditnumber);
				break;
			} catch (NoSuchElementException e) {
//				seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.nextPageInContractReport());
				seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, enquiryObj.nextPageInContractReport(), 10, 2);
				enquiryObj.nextPageInContractReport().click();
			}
		}
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}

	//////////////////////////// 003_007_tc_04//////////////////////////

	@And("^click account payable main module$")
	public void click_account_payable_main_module() throws Throwable {
		
		javascripthelper.scrollIntoView(arapObj.ARAPTransfericon());
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon in account payable$")
	public void click_the_eye_icon_in_account_payable() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon in payment settlement for credit$")
	public void click_the_add_icon_in_payment_settlement_for_credit() throws Throwable {
//		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentSettlementAddIcon());
		Thread.sleep(1000);
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, paymentSettlementObj.getPaymentSettlementAddIcon(), 10, 2);
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partnerwise for credit$")
	public void select_payment_option_as_buisness_partnerwise_for_credit() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select buisness partner in payment settlement for credit$")
	public void select_buisness_partner_in_payment_settlement_for_credit() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(testdata.get("buinesspartner"));
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Then("^verify that invoice from credit not is not available in bill list$")
	public void verify_that_invoice_from_credit_not_is_not_available_in_bill_list() throws Throwable {
		
		
		for (int i = 1; i <= 6; i++) {

			seleniumactions.getWaitHelper().waitForElementVisible(driver.findElement(By.xpath("//div[text()=' " + testdata.get("invoicenumber") + " ']")), 1000, 100);
			try {
				boolean displayed = driver.findElement(By.xpath("//div[text()=' \"+testdata.get(\"invoicenumber\")+\" ']")).isDisplayed();
			} catch (Exception e) {

				e.printStackTrace();
			}
			System.out.println("invoice number not  match");
		}

	}
	
////////////////////////////003_007_tc_04//////////////////////////
	
	
////////////////////////////003_007_tc_05//////////////////////////
	
	@Then("^fill all the mendatory fields for creating vendor for cancellation of credit note$")
	public void fill_all_the_mendatory_fields_for_creating_vendor_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(vendorContractObj.vendorContractExpenceType(), 2000, 100);
		vendorContractObj.vendorContractExpenceType().click();
		vendorContractObj.vendorContractExpenceType().sendKeys(testData.get("ContractType"));
		vendorContractObj.vendorContractExpenceType().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBpName().click();
		vendorContractObj.vendorContractBpName().sendKeys(testData.get("BusinessPartnerName"));
		vendorContractObj.vendorContractBpName().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractContractName().click();
		vendorContractObj.vendorContractContractName().sendKeys(testData.get("ContractName"));
		
		
		javascripthelper.scrollIntoView(vendorContractObj.vendorContractOtherDetails());
//		waitHelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContractOtherDetails(), 20, 2);
		vendorContractObj.vendorContractOtherDetails().click();
		waithelper.waitForElementVisible(vendorContractObj.vendorContractAutoGenerateInvoice(), 2000, 100);
		vendorContractObj.vendorContractAutoGenerateInvoice().click();
		vendorContractObj.vendorContractAutoGenerateInvoice().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractCreditPeriod().click();
		vendorContractObj.vendorContractCreditPeriod().sendKeys(testData.get("CreditPeriod"));

		vendorContractObj.vendorContractLatePaymentAmount().click();
		vendorContractObj.vendorContractLatePaymentAmount().sendKeys(testData.get("PaymentAmmount"));
		waithelper.waitForElementVisible(vendorContractObj.vendorContractSaveButton(), 2000, 100);
		vendorContractObj.vendorContractSaveButton().click();
		waithelper.waitForElementwithFluentwait(driver, vendorContractObj.vendorContract_AlertClose());
		vendorContractObj.vendorContract_AlertClose().click();

	}
	
	@And("^add item details for the contract for cancellation of credit note$")
	public void add_item_details_for_the_contract_for_cancellation_of_credit_note() throws Throwable {
//		waithelper.waitForElementVisible(vendorContractObj.vendorContractTempView(), 2000, 100);
		waithelper.waitForElementwithFluentwait(driver, vendorContractObj.vendorContractTempView());
		vendorContractObj.vendorContractTempView().click();
		waithelper.waitForElementVisible(vendorContractObj.firstTempRecord(), 2000, 100);
		vendorContractObj.firstTempRecord().click();

//		waitHelper.waitForElementVisible(vendorContractObj.vendorContractItemDetails(), 2000, 100);
		waithelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContractItemDetails(), 20, 2);
		vendorContractObj.vendorContractItemDetails().click();

//		waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContractAddButton(), 20, 2);
		vendorContractObj.vendorContractAddButton().click();

		waithelper.waitForElementVisible(vendorContractObj.vendorContractHSNCode(), 2000, 100);
		vendorContractObj.vendorContractHSNCode().click();
		vendorContractObj.vendorContractHSNCode().sendKeys(testData.get("HSNCode"));
		vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractExpenceCode().click();
		Thread.sleep(1000);
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractCostCenter().click();
		vendorContractObj.vendorContractCostCenter().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractQuantity().click();
		vendorContractObj.vendorContractQuantity().sendKeys(testData.get("VendorContractQuantity"));

		vendorContractObj.vendorContractUnit().click();
		vendorContractObj.vendorContractUnit().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractRatePerUnit().click();
		vendorContractObj.vendorContractRatePerUnit().sendKeys(testData.get("RatePerUnit"));

		vendorContractObj.itemDetailsSaveButton().click();
	}
	
	@And("^add the payment term for the contract for cancellation of credit note$")
	public void add_the_payment_term_for_the_contract_for_cancellation_of_credit_note() throws Throwable {
		Thread.sleep(1000);
		while (true) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContractPaymentTerm(), 20,2);
				vendorContractObj.vendorContractPaymentTerm().click();
				waithelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
				vendorContractObj.vendorContractAddButton().click();
				waithelper.waitForElementVisible(vendorContractObj.paymentTermPaymentTerm(), 2000, 100);
				vendorContractObj.paymentTermPaymentTerm().click();
				vendorContractObj.paymentTermPaymentTerm().sendKeys(testData.get("PaymentTerm"));
				vendorContractObj.paymentTermPaymentTermPercentage().click();
				vendorContractObj.paymentTermPaymentTermPercentage().sendKeys(testData.get("PaymentTermPercentage"));
				vendorContractObj.paymentTermPaymentTermType().click();
				vendorContractObj.paymentTermPaymentTermType().sendKeys(Keys.ENTER);
				vendorContractObj.paymentTermPaymentTermSaveButton().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}
	}
	
	@And("^add the benificiory details and select auto payout as yes for cancellation of credit note$")
	public void add_the_benificiory_details_and_select_auto_payout_as_yes_for_cancellation_of_credit_note() throws Throwable {
		while (true) {
			try {
				waithelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetails(), 2000, 100);
				vendorContractObj.vendorContractBenificioryDetails().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		} // waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(),
			// 2000, 100);
			// vendorContractObj.vendorContractAddButton().click();
		waithelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetailsPaymentMode(), 2000, 100);
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(testData.get("PaymentMode"));
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().click();
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractBenificioryDetailsSaveButton().click();
		
//		waithelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContract_AlertClose(), 20, 2);
//		vendorContractObj.vendorContract_AlertClose().click();
	}
	
	@Then("^enter remark in confirmation alert for cancellation of credit note$")
	public void enter_remark_in_confirmation_alert_for_cancellation_of_credit_note() throws Throwable {
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60, 500);
		javascripthelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("Remark"));

	}
	
	@And("^capture the reviewer ID for cancellation of credit note$")
	public void capture_the_reviewer_id_for_cancellation_of_credit_note() throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
//		jsonReaderWriter.addData(revID);
		excelData.updateTestData(dataSetID, "ReviewerID", revID);
		testData = excelData.getTestdata(dataSetID);
		waithelper.waitForElementwithFluentwait(driver, budgetCreationObj.budgetCreationAlertClose());
		budgetCreationObj.budgetCreationAlertClose().click();

	}
	
	@And("^enter the remark in alert for cancellation of credit note$")
	public void enter_the_remark_in_alert_for_cancellation_of_credit_note() throws Throwable {

		waithelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark by Reviewer"));
	}
	
	@Then("^click on submit in alert for cancellation of credit note$")
	public void click_on_submit_in_alert_for_cancellation_of_credit_note() throws Throwable {
		while (true) {

			try {
				waithelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
				kubsReviewerObj.reviewerAlertSubmitButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				kubsReviewerObj.reviewerAlertRemarks().click();
				kubsReviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark by Reviewer"));
			}
		}
	}
	
	@And("^login with reviewer credentials for cancellation of credit note$")
	public void login_with_reviewer_credentials_for_cancellation_of_credit_note() throws Throwable {

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, testData.get("ReviewerID"));

	}

	@Given("^login with reviewer credentials to approve payment settlement for cancellation of credit note$")
	public void login_with_reviewer_credentials_to_approve_payment_settlement_for_cancellation_of_credit_note() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}
	
	@Given("^login with checker credentials to approve payment settlement for cancellation of credit note$")
	public void login_with_checker_credentials_to_approve_payment_settlement_for_cancellation_of_credit_note() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		
	}
	
	
	@Then("^give alert remark for checker$")
	public void give_alert_remark_for_checker() throws Throwable {
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
		clicksAndActionHelper.clickOnElement(kubsCheckerObj.checkerRemarks());
		kubsCheckerObj.checkerRemarks().sendKeys(testData.get("Remark by Checker"));
	}
	
	@And("^login with Maker ID$")
	public void login_with_maker_id() throws Throwable {
		Thread.sleep(2000);
//		kubsLogin.loginToAzentioApp("Maker");
//		kubsLogin = new KUBS_Login(driver);
//		driver.get(configreader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
	}
	
	@Then("^select our record in notification records for cancellation of credit note$")
	public void select_our_record_in_notification_records_for_cancellation_of_credit_note() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */
		
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		for (int i = 0; i <= 200; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				clicksAndActionHelper.doubleClick(driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	
	@And("^select our record and claim for cancellation of credit note$")
	public void select_our_budget_record_and_claim_for_cancellation_of_credit_note() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javascripthelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 0; i <= 100; i++) {
			try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//				80, 500);
				WebElement climeButton = driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim));

				boolean bool = climeButton.isDisplayed();
				clicksAndActionHelper.clickOnElement(climeButton);

				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	
	@And("^get the contract number for cancellation of credit note$")
	public void get_the_contract_number_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(vendorContractObj.vendorContractApprovedContractNumber(), 2000, 100);
		String approvedContractNumber = vendorContractObj.vendorContractApprovedContractNumber().getText();
		autoPayout.put("approvedContractNumber", approvedContractNumber);
	}
	
	@And("^fill the mendatory fields for po creation for cancellation of credit note$")
	public void fill_the_mendatory_fields_for_po_creation_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_BPName(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, poCreationObj.accountsPayable_VendorPurchaseOrder_BPName(), 20, 2);
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(testData.get("BusinessPartnerName"));
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.DOWN);
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);

		poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);

		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(testData.get("ContractName"));
		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);

		/*
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().click()3
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().
		 * sendKeys("Purchace Contract3"); Thread.sleep(1000);
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(Keys.
		 * ENTER);
		 */
		// div[contains(text(),'Agency-8-41-28022022')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox
		Thread.sleep(1000);
		waithelper.waitForElementVisible(
				driver.findElement(
						By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox")),
				2000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox"))
				.click();
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input"))
				.sendKeys("1");
		while (true) {
			try {
				// Thread.sleep(1000);
				waithelper.waitForElementVisible(poCreationObj.vendorContractPoItemSave(), 2000, 100);
				poCreationObj.pocontractPoQuantity().click();
				poCreationObj.vendorContractPoItemSave().click();
				break;
			} catch (ElementClickInterceptedException e) {

			}
		}

		waithelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().click();
		// poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.DOWN);
		poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.ENTER);
		// waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter(),
		// 2000, 100);
		while (true) {
			try {
				poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().click();
				poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().sendKeys(Keys.ENTER);
				break;
			} catch (NoSuchElementException e) {

			}
		}

		poCreationObj.accountsPayable_VendorPurchaseOrder_Save().click();
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, poCreationObj.checkerAlertClose(), 20, 2);
		poCreationObj.checkerAlertClose().click();
	}
	
	@Then("^choose first record in the notification record for cancellation of credit note$")
	public void choose_first_record_in_the_notification_record_for_cancellation_of_credit_note() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60, 500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
//		jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData(dataSetID, "ReferenceID", referenceID);
		testData = excelData.getTestdata(dataSetID);
		System.out.println(referenceID);
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstRecord(), 20, 2);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	
	@And("^search for approved po record for cancellation of credit note$")
	public void search_for_approved_po_record_for_cancellation_of_credit_note() throws Throwable {
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, ArAp_poCreationObj.poCreationSearchIcon(), 20, 2);
		ArAp_poCreationObj.poCreationSearchIcon().click();
		Thread.sleep(1000);
		// waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
		javascripthelper.scrollIntoView(ArAp_poCreationObj.poStatus());
		ArAp_poCreationObj.poStatus().sendKeys(testData.get("ApprovedPo"));
		poNumber = ArAp_poCreationObj.poPoNumber().getText();
		poBusinessPartner = ArAp_poCreationObj.poBusinessPartner().getText();
		System.out.println(poNumber + " " + poBusinessPartner + " ");
		settlementTestData.put("poNumber", poNumber);
		settlementTestData.put("poBusinessPartner", poBusinessPartner);
		System.out.println("Po Number" + settlementTestData.get("poNumber"));
		System.out.println("Po Number" + settlementTestData.get("poBusinessPartner"));
	}
	
	@And("^check GRN can be created for that perticular po for cancellation of credit note$")
	public void check_grn_can_be_created_for_that_perticular_po_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 1000, 100);
		System.out.println("Business Partner is" + poBusinessPartner);
		grnObject.accountPayable_GrnBpName().click();
		grnObject.accountPayable_GrnBpName().sendKeys(poBusinessPartner);
		// grnObject.accountPayable_GRN_BPBranch().click();
		grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
		waithelper.waitForElementVisible(grnObject.accountPayable_GRN_BPBranch(), 2000, 100);
		grnObject.accountPayable_GRN_BPBranch().click();
		grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
		Random random = new Random();
		int randomNum=random.nextInt(2000-1500)+1500;
		grnObject.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("InvoiceNo")+randomNum);
		waithelper.waitForElementToVisibleWithFluentWait(driver, grnObject.accountPayable_GrnDeliveryLocation(), 20, 2);
		grnObject.accountPayable_GrnDeliveryLocation().click();
		grnObject.accountPayable_GrnDeliveryLocation().sendKeys(testData.get("DeliveryLocation"));
		grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, grnObject.accountPayable_GrnSaveButton());
		clicksAndActionHelper.doubleClick(grnObject.accountPayable_GrnSaveButton());
		waithelper.waitForElementwithFluentwait(driver, arapObj.ARAP_Notification_Close());
		arapObj.ARAP_Notification_Close().click();
		
		javascripthelper.scrollIntoView(grnObject.grnTempView());
		waithelper.waitForElementwithFluentwait(driver, grnObject.grnTempView());
		grnObject.grnTempView().click();
		Thread.sleep(500);
		waithelper.waitForElementwithFluentwait(driver, grnObject.grnTempViewFirstRecord());
		grnObject.grnTempViewFirstRecord().click();

	}
	
	@Then("^go to Item details and enter po number for cancellation of credit note$")
	public void go_to_item_details_and_enter_po_number_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
		grnObject.inventoryManagament_GRNItemDetails().click();
		waithelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
		grnObject.accountPayable_GrnPONumber().click();
		grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
		grnObject.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		for (int row = 1; row < 5; row++) {
			// datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]/input[1]

			for (int col = 7; col <= 8; col++) {
				try {
					// waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")),
					// 5000, 100);
					boolean status = driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]")).isDisplayed();
					driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]")).click();
					driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]"))
							.sendKeys(testData.get("ItemQuantity"));
					if (status == false) {
						break;
					}
				} catch (NoSuchElementException e) {
					e.getMessage();
					break;
				}

			}
		}
		// 
		 Thread.sleep(1000);
		// grnObject.ItemDetailsSaveButton().click();
		// clickAndActions.doubleClick(grnObject.ItemDetailsSaveButton());
		clicksAndActionHelper.clickOnElement(grnObject.ItemDetailsSaveButton());
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, vendorContractObj.vendorContract_AlertClose(), 20, 2);
		vendorContractObj.vendorContract_AlertClose().click();
		// Thread.sleep(2000);
	}
	
	@And("^get the approved po number from approved record for cancellation of credit note$")
	public void get_the_approved_po_number_from_approved_record_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(poCreationObj.poCreationApprovedPoNumber(), 2000, 100);
		String poNumber = poCreationObj.poCreationApprovedPoNumber().getText();
		autoPayout.put("poNumber", poNumber);
	}

	@And("^fill The invoice against po record for cancellation of credit note$")
	public void fill_the_invoice_against_po_record_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
		while (true) {
			try {
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(autoPayout.get("poNumber"));
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
				{
					waithelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 2000, 100);
					invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
					waithelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSelectGRNRecord(), 2000, 100);
					invoiceBookingObj.invoiceBookingSelectGRNRecord().click();
					waithelper.waitForElementVisible(invoiceBookingObj.invoiceBooingOkButton(), 2000, 100);
					invoiceBookingObj.invoiceBooingOkButton().click();
					break;
				}
			} catch (StaleElementReferenceException e) {

			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense(), 20, 2);
		invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		waithelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
		poCreationObj.checkerAlertClose().click();
	}
	
	@And("^fill the invoice booking record for cancellation of credit note$")
	public void fill_the_invoice_booking_record_for_cancellation_of_credit_note() throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt(1000 - 500) + 500;
		waithelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		/*
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(
		 * Keys.DOWN);
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(
		 * Keys.ENTER);
		 */
		invoiceBookingObj.billBookingPoBpName().click();
		invoiceBookingObj.billBookingPoBpName().sendKeys(testData.get("BusinessPartnerName"));
		invoiceBookingObj.billBookingPoBpName().sendKeys(Keys.ENTER);

		invoiceBookingObj.invoiceBollSuplierNAme().click();
		invoiceBookingObj.invoiceBollSuplierNAme().sendKeys(testData.get("SuplierReferenceNumber") + random);

		invoiceBookingObj.billBookingPoFlatDiscount().click();
		invoiceBookingObj.billBookingPoFlatDiscount().sendKeys(testData.get("FlatDiscount"));
		/*
		 * invoiceBookingObj.billBookingExpenceDiscountType().click();
		 * invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);
		 * 
		 * invoiceBookingObj.billBookingExpenceDiscountPercent().click();
		 * invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys("2");
		 * 
		 */
		invoiceBookingObj.billBookingPoPaymentMode().click();
		invoiceBookingObj.billBookingPoPaymentMode().sendKeys(testData.get("PaymentMode"));
		invoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
	}

	@And("^get the approved invoice from table for cancellation of credit note$")
	public void get_the_approved_invoice_from_table_for_cancellation_of_credit_note() throws Throwable {
		waithelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(), 2000, 100);
		String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		autoPayout.put("approvedInvoiceNumber", approvedInvoiceNumber);
	}
	
	@And("^select the approved record from invoice bill booking for cancellation of credit note$")
	public void select_the_approved_record_from_invoice_bill_booking_for_cancellation_of_credit_note() throws Throwable {
		// waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(),
		// 2000, 100);
//		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, invoiceBookingObj.accountPayable_InvoiceBooking_Search());
		invoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
		waithelper.waitForElementwithFluentwait(driver, invoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch());
		invoiceBookingObj.accountPayable_InvoiceBooking_BusinessPartnerSearch().sendKeys(testData.get("BusinessPartnerName"));
		String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		System.out.println(approvedInvoiceNumber);
		invoiceBookingTestData.put("approvedInvoiceNumber", approvedInvoiceNumber);
		
//		testData.put("ApprovedInvoiceNumber", approvedInvoiceNumber);
		excelData.updateTestData(dataSetID, "ApprovedInvoiceNumber", approvedInvoiceNumber);
		testData = excelData.getTestdata(dataSetID);
		
		String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
		invoiceBookingTestData.put("approvedBpName", approvedBpName);

	}
	
	@And("^goto accouts receivable module$")
	public void goto_accouts_receivable_module() throws Throwable {
		
		// waitHelper.waitForElementVisible(makerObj.kubsAccountsReceivable(), 2000,
		// 100);
		// makerObj.kubsDirectionIcon().click();
		javascripthelper.scrollIntoView(makerObj.kubsAccountsReceivable());
		makerObj.kubsAccountsReceivable().click();
	}

	@And("^goto credit notet module$")
	public void goto_credit_notet_module() throws Throwable {
		
		javascripthelper.scrollIntoView(crediteNoteObj.accountsReceivableViewButton());
		// waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableViewButton(),
		// 2000, 100);
		crediteNoteObj.accountsReceivableViewButton().click();
	}
	
	@And("^Fill the form for cancellation of credit note$")
	public void fill_the_form_for_cancellation_of_credit_note() throws Throwable {
		
		waithelper.waitForElementVisible(crediteNoteObj.accountsReceivableReceivableName(), 2000, 100);
		crediteNoteObj.accountsReceivableReceivableName().click();
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableBpName().click();
		crediteNoteObj.accountsReceivableBpName().sendKeys(invoiceBookingTestData.get("approvedBpName"));
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableInvoiceNumber().click();// approvedInvoiceNumber
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(invoiceBookingTestData.get("approvedInvoiceNumber"));
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableCreditAmmount().click();
		crediteNoteObj.accountsReceivableCreditAmmount().sendKeys(testData.get("CreditAmmount"));
		String creditAmmount = testData.get("CreditAmmount");
		String finalCreditValue = creditAmmount.substring(0, creditAmmount.length() - 2);
		invoiceBookingTestData.put("finalCreditValue", finalCreditValue);
		Thread.sleep(1000);

		crediteNoteObj.accountsReceivableDescription().click();
		crediteNoteObj.accountsReceivableDescription().sendKeys(testData.get("Remark"));
		waithelper.waitForElementVisible(crediteNoteObj.accountsReceivablleSaveButton(), 2000, 100);
		clicksAndActionHelper.doubleClick(crediteNoteObj.accountsReceivablleSaveButton());
		//crediteNoteObj.accountsReceivablleSaveButton().click();
		waithelper.waitForElementwithFluentwait(driver, crediteNoteObj.crditNote_ConfirmationMessageCloseButton());
		crediteNoteObj.crditNote_ConfirmationMessageCloseButton().click();
	}
	
	@And("^fill the mendatory fields for settle the payment$")
	public void fill_the_mendatory_fields_for_settle_the_payment() throws Throwable {
		
		waithelper.waitForElementVisible(accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOption"));
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(testData.get("BusinessPartnerName"));
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 50; i++) {
			Thread.sleep(1000);
			if (i == 20) {
				System.out.println("Data not available");
				System.out.println("Approved record we search " + testData.get("ApprovedInvoiceNumber"));
				Assert.fail("Data not available");
			}
			try {

				waithelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedInvoiceNumber") + "')]")), 2000, 100);
				javascripthelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("ApprovedInvoiceNumber") + "')]")).isDisplayed();
				Assert.assertTrue(finalStatus);
				waithelper.waitForElementVisible(
						driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("ApprovedInvoiceNumber") + "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("ApprovedInvoiceNumber") + "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				break;
			} catch (NoSuchElementException e) {
				javascripthelper.scrollIntoView(accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}
	
	@And("^fill the calender detail and description$")
	public void fill_the_calender_detail_and_description() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, arapObj.accountsPayable_paymentSettlement_SystemDate());
		String systemDate=arapObj.accountsPayable_paymentSettlement_SystemDate().getText();
		System.out.println(systemDate);
		String date[]=systemDate.split("-");
		excelData.updateTestData(dataSetID, "Date", date[0]);
		testData = excelData.getTestdata(dataSetID);
		excelData.updateTestData(dataSetID, "Month", date[1]);
		testData = excelData.getTestdata(dataSetID);
		excelData.updateTestData(dataSetID, "Year", date[2]);
		testData = excelData.getTestdata(dataSetID);
		String fullMonth = "";
		switch (date[1]) {
		case "Jan":
			fullMonth="January";
			break;
		case "Feb":
			fullMonth="February";
			break;
		case "Mar":
			fullMonth="March";
			break;
		case "Apr":
			fullMonth="April";
			break;
		case "May":
			fullMonth="May";
			break;
		case "Jun":
			fullMonth="June";
			break;
		case "Jul":
			fullMonth="July";
			break;
		case "Aug":
			fullMonth="August";
			break;
		case "Sep":
			fullMonth="September";
			break;
		case "Oct":
			fullMonth="October";
			break;
		case "Nov":
			fullMonth="November";
			break;
		case "Dec":
			fullMonth="December";
			break;
		}
		excelData.updateTestData(dataSetID, "FullMonth", fullMonth);
		testData = excelData.getTestdata(dataSetID);

		
		javascripthelper.scrollIntoView(accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementValueDate());
		accountsPayable_PaymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
//		while (true) {
//			try {
//
//				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("MonthYear") + " ']")));
//				driver.findElement(By.xpath("//span[text()='" + testData.get("MonthYear") + " ']"));
//				break;
//			}
//
//			catch (NoSuchElementException nosuchElement) {
////				inventoryEnquiryGlObj.inventoryNextMonth().click();
//			}
//		}
		for(int i=0;i<=50;i++) {
			try {
				waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + " ']")));
				driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + " ']"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElement(driver, 5000, arapObj.ARAPNextMonth());
				arapObj.ARAPNextMonth().click();
			}
		}
		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
		clicksAndActionHelper.doubleClick(accountsPayable_PaymentSettlementObj.accountsPayableDescription());
		accountsPayable_PaymentSettlementObj.accountsPayableDescription().sendKeys(testData.get("Remark"));

	}
	
	@And("^search the Active credit note and click on the first list$")
    public void search_the_active_credit_note_and_click_on_the_first_list() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(testData.get("contractstatusactive"));
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }
	
	@Then("^Fill the credit note number in Adjustment Item Type$")
    public void fill_the_credit_note_number_in_adjustment_item_type() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(testData.get("AdjustmentItemType"));
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);
    }
	
	@Then("^Fill The Business Partner according to creditnote$")
    public void fill_the_business_partner_according_to_creditnote() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapObj.adjustmentBpName());
		arapObj.adjustmentBpName().click();
		arapObj.adjustmentBpName().sendKeys(testdata.get("buisnessPartnerName"));
		arapObj.adjustmentBpName().sendKeys(Keys.ENTER);
    }
	
	@And("^Give the Adjustment Ref No and Validate cancellation is not allowed$")
	public void give_the_adjustment_ref_no_and_validate_cancellation_is_not_allowed() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waithelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(testdata.get("creditnotenumber"));

		try {
			waithelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().isDisplayed();
		} catch (ElementClickInterceptedException e) {
			System.out.println("The Approved Invoice Bill Record is Not Allowed for Cancellation");
		}
	}
	
	@And("^click the financial reporting button$")
    public void click_the_financial_reporting_button() throws Throwable {
	 waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport().click();
    }
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////
	@Then("^select data set ID for Verify accounting entries post credit note is cancelled$")
	public void select_data_set_id_for_verify_accounting_entries_post_credit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
		System.out.println(testData);
	}
	
	@Then("^select data set ID for Verify balance sheet post credit note is cancelled$")
    public void select_data_set_id_for_verify_balance_sheet_post_credit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_02_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for Verify accounts receivable report post credit note is cancelled$")
    public void select_data_set_id_for_verify_accounts_receivable_report_post_credit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_03_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for verifying credit cancelled is not available$")
    public void select_data_set_id_for_verifying_credit_cancelled_is_not_available() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_04_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted$")
    public void select_data_set_id_for_verify_cancelling_credit_note_is_not_allowed_if_it_has_been_adjusted() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^update data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted for reviewer$")
    public void update_data_set_id_for_verify_cancelling_credit_note_is_not_allowed_if_it_has_been_adjusted_for_reviewer() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^update data set ID for Verify cancelling Credit Note is not allowed if it has been adjusted for checker$")
	public void update_data_set_id_for_verify_cancelling_credit_note_is_not_allowed_if_it_has_been_adjusted_for_checker() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
	}


}