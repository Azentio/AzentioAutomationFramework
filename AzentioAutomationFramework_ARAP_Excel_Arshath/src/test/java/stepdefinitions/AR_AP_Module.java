package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
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
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSRECEIVABLE_AdvancesObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.Account_Receivable;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.Enquiry_Obj;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.InvoiceBookingObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.Payment_SettlementObj;
import pageobjects.REPORT_FinancialReportingObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class AR_AP_Module {

	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	KUBS_Login login = new KUBS_Login(driver);
//	Map<String, String> testdata = new LinkedHashMap<>();
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	ACCOUNTSRECEIVABLE_AdvancesObj accuountsReceivableObj = new ACCOUNTSRECEIVABLE_AdvancesObj(driver);
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj = new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	ACCOUNTSPAYABLE_AccountsPayableReportObj accountsPayableReport = new ACCOUNTSPAYABLE_AccountsPayableReportObj(driver);
	REPORT_FinancialReportingObj financialReportObj=new REPORT_FinancialReportingObj(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBillBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	BUDGET_SupplementaryBudgetObj supplimentoryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx","CancellationBillTestdata", "DataSet ID");
	Map<String, String> testData;
	Map<String, String> testdata = new HashMap<>();

	// ****************************************@KUBS_AR/AP_UAT_003_004TC_01************************************************************************
	// accounting entries for cancelled bill

	@When("^click the account payable main module$")
	public void click_the_account_payable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon of invoice bill booking$")
	public void click_the_eye_icon_of_invoice_bill_booking() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());

	}

	@And("^click the search icon in list view$")
	public void click_the_search_icon_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());

	}

	@And("^search invoice type as expense$")
	public void search_invoice_type_as_expense() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchInvoiceType());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceType());
		invoiceBookingObj.searchInvoiceType().sendKeys(testData.get("InvoiceType"));
		System.out.println(testData.get("InvoiceType"));
	}

	@And("^click the first eye icon in the list view of cancelled invoice bill$")
	public void click_the_first_eye_icon_in_the_list_view_of_cancelled_invoice_bill() throws Throwable {
		String invoiceBillStatus = null;
		String beforexpath = "//datatable-row-wrapper[";
		String afterxpath = "]/datatable-body-row[1]/div[2]/datatable-body-cell[13]/div[1]/span[1]";
		for (int j = 1; j < 6; j++) {
			for (int i = 1; i < 9; i++) {
				// select active bill with expense as contract type
				seleniumactions.getWaitHelper().waitForElement(driver, 2000,
						driver.findElement(By.xpath(beforexpath + i + afterxpath)));
				invoiceBillStatus = driver.findElement(By.xpath(beforexpath + i + afterxpath)).getText();
				System.out.println(invoiceBillStatus);
				if (invoiceBillStatus.equalsIgnoreCase(testData.get("status"))) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000, driver.findElement(
							By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])[" + i + "]")));
					driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])[" + i + "]"))
							.click();
					break;
				}

			}
			if (invoiceBillStatus.equalsIgnoreCase(testData.get("status"))) {
				break;
			}
			// seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.nextPageInListView());
			invoiceBookingObj.nextPageInListView().click();
		}
	}

	@And("^get the invoice number from the bill viewed$")
	public void get_the_invoice_number_from_the_bill_viewed() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
		String buisnesspartner = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
		System.out.println(buisnesspartner);
		// testdata.put("buisnesspartner", buisnesspartner);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_004_TC_05_D1", "Buisnesspartner", buisnesspartner);
		javascriphelper.JavaScriptHelper(driver);
		String invoicenumber = (String) javascriphelper
				.executeScript("return document.getElementsByName('billNo')[0].value");
		System.out.println(invoicenumber);
		// testdata.put("invoicenumber", invoicenumber);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_004_TC_05_D1", "InvoiceNo", invoicenumber);

	}

	@And("^get buisness partner name and Bill Status$")
	public void get_buisness_partner_name_and_bill_status() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
		String buisnessPartnerName = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
		testdata.put("buisnessPartnerName", buisnessPartnerName);
		javascriphelper.JavaScriptHelper(driver);
		String contractenddate = (String) javascriphelper
				.executeScript("return document.getElementsByName('kubDateTime')[1].value");
		System.out.println(contractenddate);
		String year = contractenddate.substring(7, 11);
		testdata.put("year", year);
		String month = contractenddate.substring(3, 6);
		testdata.put("month", month);
		System.out.println(month);
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
		// System.out.println(Integer.parseInt(contractenddate.substring(0, 2)));
		if (Integer.parseInt(contractenddate.substring(0, 2)) > 9) {
			String day = contractenddate.substring(0, 2);
			testdata.put("day", day);
			// System.out.println(day);
		} else {
			String day = contractenddate.substring(1, 2);
			testdata.put("day", day);
			// System.out.println(day);
		}
		String invoicestatus = invoiceBookingObj.statusOfInvoice().getText();
		testdata.put("invoicestatus", invoicestatus);

	}

	@And("^click the notes option in top$")
	public void click_the_notes_optin_in_top() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
	}

	@Then("^Fill branch details for report$")
	public void fill_branch_details_for_report() {

		// Thread.sleep(6000);

		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(testData.get("BranchCode"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
		// arAp_BalanceSheetReportTestDataType=
		// jsonReader.getBalanceSheetReportByName("maker");
		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(testData.get("ReportType"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);

	}

	@And("^select the date$")
	public void select_the_date() throws Throwable {
		// arAp_BalanceSheetReportTestDataType =
		// jsonReader.getBalanceSheetReportByName("maker");
		Thread.sleep(2000);
		// arAp_BalanceSheetReportTestDataType =
		// jsonReader.getBalanceSheetReportByName("maker");

		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {
				// span[contains(text(),'Oct 2022')]
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));

				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		Thread.sleep(1000);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click the view icon$")
	public void click_the_view_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.viewInContractReport());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.viewInContractReport());
		Thread.sleep(5000);
	}

	@Then("^Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries.$")
	public void verify_balance_sheet_should_be_updated_correctly_basis_the_legs_impacted_in_accounting_entries()
			throws Throwable {
		System.out.println("balance sheet view and verified");
		seleniumactions.getBrowserHelper().SwitchToWindow(1);
		Thread.sleep(2000);
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}
	// *********************************@KUBS_AR/AP_UAT_003_004TC_03********************************************//

	@And("^click the Reports Sub Module$")
	public void click_the_reports_sub_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.reportMenu());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.reportMenu());
	}

	@And("^click the Accounts Payable Report$")
	public void click_the_accounts_payable_report() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(enquiryObj.accountsPayableReport());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.accountsPayableReport());
		enquiryObj.accountsPayableReport().click();
	}

	@And("^select the vendor name$")
	public void select_the_vendor_name() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.selectVendorName());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
		enquiryObj.selectVendorName().sendKeys(testdata.get("buisnessPartnerName"));
		enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
	}

	@And("^select the payable status$")
	public void select_the_payable_status() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.selectContractStatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
		enquiryObj.selectContractStatus().sendKeys(testdata.get("invoicestatus"));
		enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
	}

	@Then("^verify the bill is cancelled in Accounts payable report$")
	public void verify_the_bill_is_cancelled_in_accounts_payable_report() throws Throwable {
		seleniumactions.getBrowserHelper().SwitchToWindow(1);
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		String beforeXpath = "//*[@id=\"__bookmark_1\"]/tbody/tr[";
		String afterXpath = "]/td[4]/div";
		for (int j = 1; j <= 50; j++) {
			String actualXpath = beforeXpath + j + afterXpath;
			try {
				seleniumactions.getWaitHelper().waitForElement(driver, 2000, driver.findElement(By.xpath(actualXpath)));
				String invoice = driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println(invoice);
				if (invoice.equalsIgnoreCase(testdata.get("invoicenumber"))) {
					System.out.println("found invoice number " + invoice);
					break;
				}
			} catch (NoSuchElementException e) {
				continue;
			}

		}
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}

	// *********************************@KUBS_AR/AP_UAT_003_004TC_04_01********************************************//

	@And("^maker should navigate to the budget module UAT$")
	public void maker_should_navigate_to_the_budget_module_UAT() throws InterruptedException {
		waithelper = new WaitHelper(driver);
		bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(kubsMakerObj.kubsToolIcon());
		clicksAndActionHelper.doubleClick(kubsMakerObj.kubsToolIcon());

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		clicksAndActionHelper.doubleClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
	}

	@And("^maker click on budget field UAT$")
	public void maker_click_on_budget_field_UAT() {
//		waithelper.waitForElementVisible(kubsMakerObj.kubsBudget(), 3000, 300);
//		kubsMakerObj.kubsBudget().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField(), 120, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
	}

	@When("^maker click on budget supplementary eye icon UAT$")
	public void maker_click_on_budget_supplymentary_eye_icon_UAT() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();

	}

	@And("^click on add button on budget supplementary view page UAT$")
	public void click_on_add_button_on_budget_supplementary_view_page_UAT() throws InterruptedException {

		for (int i = 0; i <= 10; i++) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 60, 500);
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
				// bUDGET_SupplementaryBudgetTestDataType =
				// jsonReader.getSupplementaryBudgetByName("Maker");
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 6, 500);
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
				break;
			} catch (Exception e) {
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 6, 500);
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
			}
		}
	}

	@Then("^check the budget utilazation amount of budet code which we create the expense code$")
	public void check_the_budget_utilazation_amount_of_budet_code_which_we_create_the_expense_code() throws Throwable {
		waithelper.waitForElementVisible(supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 3000, 300);
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys("BUD174786");
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys("2023-2024");
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);

		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys("Azentio Main");
		supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);

		javascripthelper.JavaScriptHelper(driver);
		String utilizationAmount = (String) javascripthelper
				.executeScript("return document.getElementById('utilizedAmt').value");
		System.out.println("Amount utilization is " + utilizationAmount);

		testData.put("UtilizationAmount", utilizationAmount);
	}

	@And("^goto vendor contract module$")
	public void goto_vendor_contract_module() throws Throwable {
		waithelper.waitForElementVisible(vendorContractObj.vendorContractEyeIcon(), 2000, 100);
		vendorContractObj.vendorContractEyeIcon().click();
	}

	@And("^click on accounts Payable module$")
	public void click_on_accounts_payable_module() throws Throwable {
		Thread.sleep(1000);
		kubsMakerObj.kubsDirectionIcon().click();
		waithelper.waitForElementVisible(kubsMakerObj.kubsAccountsPayable(), 1000, 100);
		kubsMakerObj.kubsAccountsPayable().click();
	}

	@And("^click on Add Icon$")
	public void click_on_Add_Icon() throws Throwable {
		for (int i = 0; i < 30; i++) {
			try {
				assetImpairementObj.fixedAssetAddButton().click();
				break;
			} catch (Exception e) {

			}
		}
	}

	@Then("^fill all the mendatory fields for creating vendor$")
	public void fill_all_the_mendatory_fields_for_creating_vendor() throws Throwable {
		waithelper.waitForElementVisible(vendorContractObj.vendorContractExpenceType(), 2000, 100);
		vendorContractObj.vendorContractExpenceType().click();
		vendorContractObj.vendorContractExpenceType().sendKeys(autoPayoutTestData.ContractType);
		vendorContractObj.vendorContractExpenceType().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBpName().click();
		vendorContractObj.vendorContractBpName().sendKeys(autoPayoutTestData.BusinessPartnerName);
		vendorContractObj.vendorContractBpName().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractContractName().click();
		vendorContractObj.vendorContractContractName().sendKeys(autoPayoutTestData.ContractName);

		vendorContractObj.vendorContractOtherDetails().click();
		waithelper.waitForElementVisible(vendorContractObj.vendorContractAutoGenerateInvoice(), 2000, 100);
		vendorContractObj.vendorContractAutoGenerateInvoice().click();
		vendorContractObj.vendorContractAutoGenerateInvoice().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractCreditPeriod().click();
		vendorContractObj.vendorContractCreditPeriod().sendKeys(autoPayoutTestData.CreditPeriod);

		vendorContractObj.vendorContractLatePaymentAmount().click();
		vendorContractObj.vendorContractLatePaymentAmount().sendKeys(autoPayoutTestData.PaymentAmmount);
		waithelper.waitForElementVisible(vendorContractObj.vendorContractSaveButton(), 2000, 100);
		vendorContractObj.vendorContractSaveButton().click();

	}

	@And("^add item details for the contract give budgetcode maped expense code$")
	public void add_item_details_for_the_contract_give_budgetcode_maped_expense_code() throws Throwable {
		waithelper.waitForElementVisible(vendorContractObj.vendorContractTempView(), 2000, 100);
		vendorContractObj.vendorContractTempView().click();
		waithelper.waitForElementVisible(vendorContractObj.firstTempRecord(), 2000, 100);
		vendorContractObj.firstTempRecord().click();

		waithelper.waitForElementVisible(vendorContractObj.vendorContractItemDetails(), 2000, 100);
		vendorContractObj.vendorContractItemDetails().click();

		waithelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
		vendorContractObj.vendorContractAddButton().click();

		waithelper.waitForElementVisible(vendorContractObj.vendorContractHSNCode(), 2000, 100);
		vendorContractObj.vendorContractHSNCode().click();
		vendorContractObj.vendorContractHSNCode().sendKeys(autoPayoutTestData.budgetMapedHSNCode);
		vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractExpenceCode().click();
		vendorContractObj.vendorContractExpenceCode().sendKeys(autoPayoutTestData.budgetMapedExpensecode);
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractCostCenter().click();
		vendorContractObj.vendorContractCostCenter().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractQuantity().click();
		vendorContractObj.vendorContractQuantity().sendKeys(autoPayoutTestData.VendorContractQuantity);

		vendorContractObj.vendorContractUnit().click();
		vendorContractObj.vendorContractUnit().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractRatePerUnit().click();
		vendorContractObj.vendorContractRatePerUnit().sendKeys(autoPayoutTestData.RatePerUnit);

		vendorContractObj.itemDetailsSaveButton().click();
	}

	@And("^add the payment term for the contract$")
	public void add_the_payment_term_for_the_contract() throws Throwable {
		while (true) {
			try {
				vendorContractObj.vendorContractPaymentTerm().click();
				waithelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
				vendorContractObj.vendorContractAddButton().click();
				waithelper.waitForElementVisible(vendorContractObj.paymentTermPaymentTerm(), 2000, 100);
				vendorContractObj.paymentTermPaymentTerm().click();
				vendorContractObj.paymentTermPaymentTerm().sendKeys(autoPayoutTestData.PaymentTerm);
				vendorContractObj.paymentTermPaymentTermPercentage().click();
				vendorContractObj.paymentTermPaymentTermPercentage().sendKeys(autoPayoutTestData.PaymentTermPercentage);
				vendorContractObj.paymentTermPaymentTermType().click();
				vendorContractObj.paymentTermPaymentTermType().sendKeys(Keys.ENTER);
				vendorContractObj.paymentTermPaymentTermSaveButton().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}
	}

	@And("^add the benificiory details and select auto payout as yes$")
	public void add_the_benificiory_details_and_select_auto_payout_as_yes() throws Throwable {
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
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(autoPayoutTestData.PaymentMode);
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().click();
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractBenificioryDetailsSaveButton().click();
	}

	@And("^click notification button$")
	public void click_notification_button() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
				100);
		budgetCreationObj.budgetCreationNotificationIcon().click();
//		Thread.sleep(1000);

	}

	@Then("^choose first record in the notification record$")
	public void choose_first_record_in_the_notification_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		// jsonReaderWriter.addReferanceData(referenceID);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_004_TC_04_D1", "ReferenceID", referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_SubmitButton(), 60,
				500);
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@Then("^enter remark in confirmation alert$")
	public void enter_remark_in_confirmation_alert() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				500);
		javascripthelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys("OK");
	}

	@Then("^click on submit button in alert$")
	public void click_on_submit_button_in_alert() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
//			Thread.sleep(1000);
			budgetCreationObj.budgetCreation_AlertRemarks().click();
			budgetCreationObj.budgetCreation_AlertRemarks().sendKeys("OK");
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		}
	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage()
			throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_004_TC_04_D1", "ReviewerID", revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	// *********************************@KUBS_AR/AP_UAT_003_004TC_05********************************************//

	@Then("^Choose the second Tab Segment$")
	public void choose_the_second_tab_segment() throws Throwable {
		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		waithelper.waitForElement(driver, 2000, arapObj.ARAPTransfericon());
		arapObj.ARAPTransfericon().click();
	}

	@When("^click the invoice eye icon in accounts payable$")
	public void click_the_invoice_eye_icon_in_accounts_payable() throws Throwable {
//		login = new AzentioLogin(driver);
//		driver.get(configreader.getApplicationUrl());
//		login.loginToAzentioApp("maker");
//		Thread.sleep(2000);
		cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
	}

	@And("^click the search icon in invoice booking list view$")
	public void click_the_search_icon_in_invoice_booking_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^click the payment settlement eye icon$")
	public void click_the_payment_settlement_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon in payment settlement$")
	public void click_the_add_icon_in_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, paymentSettlementObj.getPaymentSettlementAddIcon(), 60, 2);																	
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partnerwise$")
	public void select_payment_option_as_buisness_partnerwise() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select buisness partner in payment settlement$")
	public void select_buisness_partner_in_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(testData.get("Buisnesspartner"));
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Then("^verify that no bill is available for payment settlement$")
	public void verify_that_no_bill_is_available_for_payment_settlement() throws Throwable {
		while (true) {
			try {
				// seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[contains(text(),'"+testdata.get("invoicenumber")+"')]")));
				javascriphelper.scrollIntoView(driver
						.findElement(By.xpath("//div[contains(text(),'" + testData.get("invoicenumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("invoicenumber") + "')]"))
						.isDisplayed();
				String invoicenumber = driver
						.findElement(By.xpath("//div[contains(text(),'" + testData.get("invoicenumber") + "')]"))
						.getText();
				System.out.println(invoicenumber);
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(enquiryObj.nextPageInListView());
				seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.nextPageInListView());
				enquiryObj.nextPageInListView().click();
				break;

			} catch (NoSuchElementException e) {
				System.out.println("cannot find the invoice number " + testData.get("invoicenumber"));
				break;
			}
		}
	}

	@And("^Go to invoice bill booking module$")
	public void go_to_invoice_bill_booking_module() throws Throwable {
		waithelper.waitForElementVisible(kubsMakerObj.kubsDirectionIcon(), 2000, 100);
		kubsMakerObj.kubsDirectionIcon().click();
		waithelper.waitForElementVisible(kubsMakerObj.kubsAccountsPayable(), 2000, 100);
		kubsMakerObj.kubsAccountsPayable().click();
		invoiceBillBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
	}

	@Then("^click on search$")
	public void click_on_search() throws Throwable {
		invoiceBillBookingObj.accountPayable_InvoiceBooking_Search().click();
	}

	@And("^search for cancelled bill$")
	public void search_for_cancelled_bill() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(invoiceBillBookingObj.invoiceBookingCancelledStatus());
		waithelper.waitForElementVisible(invoiceBillBookingObj.invoiceBookingCancelledStatus(), 2000, 200);
		invoiceBillBookingObj.invoiceBookingCancelledStatus().click();
		invoiceBillBookingObj.invoiceBookingCancelledStatus().sendKeys(testData.get("status"));
		String bpName = invoiceBillBookingObj.invoiceBookingBpName().getText();
		// invoiceBookingData.put("BpName", bpName);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_005_TC_01_D1", "Buisnesspartner", bpName);
		String invoiceNumber = invoiceBillBookingObj.invoiceBookingInvoiceNumber().getText();
		// invoiceBookingData.put("InvoiceNumber", invoiceNumber);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_005_TC_01_D1", "InvoiceNo", invoiceNumber);
		System.out.println("Invoice Number is" + invoiceNumber);
	}

	@And("^search for the cancelled bill$")
	public void search_for_the_cancelled_bill() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(invoiceBillBookingObj.invoiceBookingCancelledStatus());
		waithelper.waitForElementVisible(invoiceBillBookingObj.invoiceBookingCancelledStatus(), 2000, 200);
		invoiceBillBookingObj.invoiceBookingCancelledStatus().click();
		invoiceBillBookingObj.invoiceBookingCancelledStatus().sendKeys(testData.get("status"));
		String bpName = invoiceBillBookingObj.invoiceBookingBpName().getText();
		// invoiceBookingData.put("BpName", bpName);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_005_TC_04_D1", "Buisnesspartner", bpName);
		String invoiceNumber = invoiceBillBookingObj.invoiceBookingInvoiceNumber().getText();
		// invoiceBookingData.put("InvoiceNumber", invoiceNumber);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_005_TC_04_D1", "InvoiceNo", invoiceNumber);
		System.out.println("Invoice Number is" + invoiceNumber);
	}
	
	@Then("^click on report segment button$")
	public void click_on_report_segment_button() throws Throwable {
		Thread.sleep(1500);
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoViewAndClick(inventoryManagamentObj.inventoryReportIcon());
	}

	@And("^click on equiry menu$")
	public void click_on_equiry_menu() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());

		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on edit icon near by fiancial transaction menu$")
	public void click_on_edit_icon_near_by_fiancial_transaction_menu() throws Throwable {
		inventoryEnquiryGlObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^choose branch code$")
	public void choose_branch_code() throws Throwable {
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^choose Gl code$")
	public void choose_gl_code() throws Throwable {

		inventoryEnquiryGlObj.inventoryGlCode().sendKeys(testData.get("Glcode"));
		inventoryEnquiryGlObj.inventoryGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date calender icon$")
	public void click_on_transaction_from_date_calender_icon() throws Throwable {
		inventoryEnquiryGlObj.inventoryFromDate().click();

	}

	@Then("^choose the from date$")
	public void choose_the_from_date() throws Throwable {

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on the transaction to date calender icon$")
	public void click_on_the_transaction_to_date_calender_icon() throws Throwable {

		waithelper.waitForElement(driver, 3000, inventoryEnquiryGlObj.inventoryToDate());
		clicksAndActionHelper.doubleClick(inventoryEnquiryGlObj.inventoryToDate());

	}

	@Then("^choose the to date$")
	public void choose_the_to_date() throws Throwable {
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("ToMonth") + " " + testData.get("ToYear") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("ToMonth") + " " + testData.get("ToYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ToFullMonth") + " "
				+ testData.get("ToDate") + ", " + testData.get("ToYear") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
		Thread.sleep(3000);
	}

	@Then("^verify the accounting entries for the cancelled bill$")
	public void verify_the_accounting_entries_for_the_cancelled_bill() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i < 299; i++) {
			try {

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNo") + "')])[1]"))
						.isDisplayed();

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNo") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ testData.get("InvoiceNo")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ testData.get("InvoiceNo")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javascripthelper.scrollIntoView(inventoryEnquiryGlObj.nextRecord());
				inventoryEnquiryGlObj.nextRecord().click();
			}
		}
		for (int i = 0; i < 299; i++) {
			try {

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNo") + "')])[2]"))
						.isDisplayed();

				driver.findElement(By.xpath(
						"(//datatable-body-cell[1]//span[contains(text(),'" + testData.get("InvoiceNo") + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
								+ testData.get("InvoiceNo")
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
						+ testData.get("InvoiceNo")
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javascripthelper.scrollIntoView(inventoryEnquiryGlObj.nextRecord());
				inventoryEnquiryGlObj.nextRecord().click();
			}
		}
	}
	
	
//	@And("^search the cancelled bill$")
//	public void search_the_cancelled_bill() throws Throwable {
//		invoiceBillBookingObj.accountPayable_InvoiceBooking_ContractStatus().click();
//		invoiceBillBookingObj.accountPayableSearchInvoiceStatus().sendKeys(testData.get("status"));
//		Thread.sleep(3000);
//		String beforXpath = "//span[contains(text(),'";
//		String afterXpath = "')]";
//		javascripthelper.JavaScriptHelper(driver);
//		javascripthelper.scrollIntoView(driver.findElement(By.xpath(beforXpath + paymentSettlementTestData.canceledInvoiceNumber + afterXpath)));
//		boolean status = driver.findElement(By.xpath(beforXpath + paymentSettlementTestData.canceledInvoiceNumber + afterXpath)).isDisplayed();
//		Assert.assertTrue(status);
//		waithelper.waitForElementVisible(invoiceBillBookingObj.invoiceBookingBpName(), 2000, 100);
//
//		String bpName = invoiceBillBookingObj.invoiceBookingBpName().getText();
//		accountsReceivableTestData.put("bpName", bpName);
//
//	}
	@And("^get the transcationDate$")
    public void get_the_transcationdate() throws Throwable {
		
		String transactionDate=invoiceBookingObj.invoiceBillBooking_TransactionDate.getText();
		testdata.put("transactionDate", transactionDate);
		System.out.println(testdata.get("transactionDate"));
       
    }
	
	@And("^click on financial reporting main menu$")
    public void click_on_financial_reporting_main_menu() throws Throwable {
		financialReportObj.financialTransactionMainMenu().click();
    }
    @And("^click on temp view near by balance sheet sub menu$")
    public void click_on_temp_view_near_by_balance_sheet_sub_menu() throws Throwable {
    	
    	financialReportObj.financialReportingBalanceSheet().click();
    }
    @And("^enter the transaction date$")
    public void enter_the_transaction_date() throws Throwable {
    	financialReportObj.financialReportingBalanceSheetInputCalendar().click();
    	//Thread.sleep(2000);
    	financialReportObj.financialReprtingYearMonth().click();
    	String fullDate=testdata.get("transactionDate");
    	String[] transDate=fullDate.split("-");
    	String splitDay = transDate[0];
    	testdata.put("splitDay", splitDay);
    	if (Integer.parseInt(splitDay)<9) {
    		String day = splitDay.substring(1, 2);
    		testdata.put("day", day);
    
		}
    	else
    	{
    		String day = splitDay.substring(0, 2);		
    		testdata.put("day", day);
    	}
    	
    	System.out.println(transDate[1]);
    	System.out.println(transDate[2]);
    	//Thread.sleep(2000);
    	while(true)
    	{
    		
    	try
    	{
    	driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[2]+"')]")).click();
    	break;
    	}
    	catch(ElementClickInterceptedException e)
    	{
    		
    	}
    	}
    	//driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[1]+"')]")).click();
    	clicksAndActionHelper.doubleClick(driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[1]+"')]")));
    	//driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+testData.get("day")+"')]")).click();
    	clicksAndActionHelper.doubleClick(driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+testdata.get("day")+"')]")));
    }

    @Then("^Verify Balance sheet post Bill is cancelled$")
    public void verify_balance_sheet_post_bill_is_cancelled() throws Throwable {
    	browserHelper.SwitchToWindow(1);
    	javascripthelper.JavaScriptHelper(driver);
    	Thread.sleep(2000);
    	javascripthelper.scrollDownByPixel();
    	Thread.sleep(1000);
    	browserHelper.switchToParentWithChildClose();
    }
	/****************** KUBS_AR_AP_UAT_003_002_TC_03 *************/
    
	@Then("^search the cancelled invoice number with po$")
	public void search_the_cancelled_invoice_number_with_po() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(invoiceBookingObj.accountPayableSearchInvoiceStatus());
		invoiceBookingObj.accountPayableSearchInvoiceStatus().click();
		invoiceBookingObj.accountPayableSearchInvoiceStatus().sendKeys(testData.get("status"));
	}
	
	@And("^get the invoice number and business partner name$")
	public void get_the_invoice_number_and_business_partner_name() throws Throwable {

		for (int i = 1; i < 7; i++) {
			String invoiceType = driver
					.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//datatable-body-cell[4]//span"))
					.getText();
			if (invoiceType.equalsIgnoreCase("Invoice Against PO")) {
				String cancelledBpName = driver
						.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//datatable-body-cell[5]//span"))
						.getText();
				String cancelledInvoiceNumber = driver
						.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//datatable-body-cell[3]//span"))
						.getText();
				System.out.println("Cancelled Bp name" + cancelledBpName);
				testdata.put("cancelledInvoiceNumber", cancelledInvoiceNumber);
				testdata.put("cancelledBpName", cancelledBpName);
				System.out.println("Cancelled invoiceNumber" + testdata.get("cancelledInvoiceNumber"));
				break;
			}
		}

		System.out.println("Cancelled invoiceNumber" + testdata.get("cancelledInvoiceNumber"));

	}
	@And("^click on report main menu$")
	public void click_on_report_main_menu() throws Throwable {
		waithelper.waitForElementVisible(budgetTransferObj.reportReortMainMenu(), 2000, 200);
		budgetTransferObj.reportReortMainMenu().click();
	}
	@And("^click on accouts payable report$")
	public void click_on_accouts_payable_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(accountsPayableReport.accountsPayableReportTempView());
		accountsPayableReport.accountsPayableReportTempView().click();
	}
	@And("^enter the business partner name for cancelled invoice$")
	public void enter_the_business_partner_name_for_cancelled_invoice() throws Throwable {
		waithelper.waitForElementVisible(accountsPayableReport.accountspayableReportBpName(), 2000, 200);
		accountsPayableReport.accountspayableReportBpName().click();
		accountsPayableReport.accountspayableReportBpName().sendKeys(testData.get("cancelledBpName"));
		accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);
	}
	@And("^click on date icon$")
	public void click_on_date_icon() throws Throwable {
		budgetTransferObj.budgetTransferDateAsOn().click();
	}
	@And("^give date in report$")
	public void give_date_in_report() throws Throwable {
		while (true) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " "
						+ testData.get("Year") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				budgetTransferObj.budgetTransferNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	@And("^enter the payable status as cancelled$")
	public void enter_the_payable_status_as_cancelled() throws Throwable {
		Thread.sleep(1000);
		accountsPayableReport.accountsPayablePayableStatus().click();
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(testData.get("status"));
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
	}
	@Then("^verify the cancelled invoice number is available in the accountspayable report$")
	public void verify_the_cancelled_invoice_number_is_available_in_the_accountspayable_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		while (true) {
			try {
				javascripthelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testdata.get("cancelledInvoiceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testdata.get("cancelledInvoiceNumber") + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				accountsPayableReport.accountsPayableReportNextRecord().click();
			}
		}

		browserHelper.switchToParentWithChildClose();
	}
	@And("^Go to payment settlement module$")
	public void go_to_payment_settlement_module() throws Throwable {
		waithelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementViewIcon(), 60, 2);
		paymentSettlementObj.accountsPayablePayementSettlementViewIcon().click();
		Thread.sleep(1000);

	}
	@And("^fill the form for payment settlement$")
	public void fill_the_form_for_payment_settlement() throws Throwable {
		waithelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000,100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
				.sendKeys(testData.get("paymentoption"));
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
				.sendKeys(testData.get("Buisnesspartner"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.DOWN);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	@And("^find the invoice reference number is availabe at the billing queue$")
	public void find_the_invoice_reference_number_is_availabe_at_the_billing_queue() throws Throwable {
		// div[contains(text(),'ADV_10_21122021')]
		Thread.sleep(3000);
		javascripthelper.JavaScriptHelper(driver);
		boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 13; i++) {
			try {
				waithelper.waitForElementVisible(
						driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("InvoiceNo") + "')]")),
						1000, 100);
				driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("InvoiceNo") + "')]"))
						.isDisplayed();
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				try {
					javascripthelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

					paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
				} catch (ElementNotInteractableException e2) {
					pageStatus = false;
				}
			}
			if (i == 13) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
		if (pageStatus == false) {
			System.out.println(
					"This is the final record " + testData.get("InvoiceNo") + " is not availabe");
		}
	}
	
	@And("^Goto accounts receivable advances module$")
	public void goto_accounts_receivable_advances_module() throws Throwable {
		waithelper.waitForElementVisible(kubsMakerObj.kubsDirectionIcon(), 1000, 100);
		Thread.sleep(2000);
		kubsMakerObj.kubsDirectionIcon().click();
		Thread.sleep(2000);
		kubsMakerObj.kubsAccountsReceivable().click();
		waithelper.waitForElementVisible(accuountsReceivableObj.accountsreceivableAdvancesViewIcon(), 1000, 100);
		accuountsReceivableObj.accountsreceivableAdvancesViewIcon().click();

	}
	@And("^Fill the mendatory fields for creating advance to employee$")
	public void fill_the_mendatory_fields_for_creating_advance_to_employee() throws Throwable {
		waithelper.waitForElementVisible(accuountsReceivableObj.accountsReceivablereceivableNameInput(), 3000, 100);
		accuountsReceivableObj.accountsReceivablereceivableNameInput().click();
		accuountsReceivableObj.accountsReceivablereceivableNameInput()
				.sendKeys(testData.get("RecevableName"));
		accuountsReceivableObj.accountsReceivablereceivableNameInput().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName().click();
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName()
				.sendKeys(testData.get("Buisnesspartner"));
		accuountsReceivableObj.accountsReceivablereceivablebusinessPartnerEmployeeName().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode().click();
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode()
				.sendKeys(testData.get("PaymentMode"));
		accuountsReceivableObj.accountsReceivablereceivablePaymentMode().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivableAmmount().click();
		accuountsReceivableObj.accountsReceivableAmmount().sendKeys(testData.get("Amount"));
		accuountsReceivableObj.accountsReceivableCurrencyType().click();
		for (int i = 1; i < 4; i++) {
			accuountsReceivableObj.accountsReceivableCurrencyType().sendKeys(Keys.DOWN);
		}
		accuountsReceivableObj.accountsReceivableCurrencyType().sendKeys(Keys.ENTER);
		accuountsReceivableObj.accountsReceivableDescription().click();
		accuountsReceivableObj.accountsReceivableDescription().sendKeys(testData.get("Description"));
	}
	@And("^Save the advance record$")
	public void save_the_advance_record() throws Throwable {
		waithelper.waitForElementVisible(paymentSettlementObj.accountsPayableSaveButton(), 2000, 100);
		paymentSettlementObj.accountsPayableSaveButton().click();
	}
	@Then("^Click on Update Deposited Cheque Notification$")
	public void click_on_update_deposited_cheque_notification() {
		waithelper.waitForElement(driver, 3000,accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification().click();

	}
	@And("^Select and Submit the Update Deposited Cheque record$")
	public void select_and_submit_the_update_deposited_cheque_record()
			throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId(), 60, 2);
				
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		//jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_004_002_TC_01_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000,
						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		Exceldata.updateTestData("KUBS_AR_AP_UAT_004_002_TC_01_D1", "ReviewerID", reviewerId);

	}
	@Then("^click on the Notification select the Cheque record and Approve$")
	public void click_on_the_notification_select_the_cheque_record_and_approve()
			throws InterruptedException, IOException, ParseException {
		// notification
		waithelper = new WaitHelper(driver);
		
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		/*
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		*/
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
for (int i = 0; i < 100; i++) {
	try {
		waithelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
		break;
	}
catch(Exception e) {
	
}
}
		// Approve
		waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarkSecond());
		reviewer.reviewerAlertRemarkSecond().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}
	@Then("^log in to the reviewer account$")
	public void log_in_to_the_reviewer_account() throws IOException, ParseException {
		//reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));	
	}
	 @Then("^log in to the Checker Account$")
	 public void log_in_to_the_checker_account() throws InterruptedException  {
		 
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	       
	    }
	 @And("^then checker claim the record$")
	 public void then_checker_claim_the_record() throws InterruptedException, IOException, ParseException  {
	    	
	    	//open pool
	    	waithelper = new WaitHelper(driver);	    	
			waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
	    	kubschecker.checkerSecurityManagement().click();
	    	
	    	//claim
	    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
	    	kubschecker.checkerActionIcon().click();
	    	Thread.sleep(2000);
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
			driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
			waithelper.waitForElement(driver,3000,kubschecker.checkerAlertClose());
			kubschecker.checkerAlertClose().click();
	 
	        
	    }
	    @Then("^click on the checker Notification$")
	    public void click_on_the_checker_notification() throws InterruptedException  {
//	    	Thread.sleep(1000);
//			waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
			kubschecker.checkerNotificationIcon().click();
	    }
		@And("^select the Cheque record and Approve by checker$")
		public void select_the_cheque_record_and_approve_by_checker()
				throws InterruptedException, IOException, ParseException {
			Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000,
							driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
					referanceID.click();
					Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
					kubschecker.checker_notification_next_button().click();
				}
				catch(StaleElementReferenceException e)
				{
					if(i==35)
					{
						Assert.fail("Data not found");
					}
				}
			}
			while (true) {
				try {
					String before_xpath = "//span[contains(text(),'";
					String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

					waithelper.waitForElement(driver, 2000,
							driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
					driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
					break;
				} catch (StaleElementReferenceException e) {

				}
			}

			// Approve
			waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
			kubschecker.checkerApproveButton().click();
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarkSecond());
			kubschecker.checkerRemarkSecond().sendKeys("OK");
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
			kubschecker.checkersubmitButton().click();
			Thread.sleep(2000);
		}
		@And("^get the receivable number from aproved record$")
		public void get_the_receivable_number_from_aproved_record() throws Throwable {
			waithelper.waitForElementVisible(accuountsReceivableObj.accountsReceivableApprovedFirstRecord(), 2000, 100);
			String firstApprovedRecord = accuountsReceivableObj.accountsReceivableApprovedFirstRecord().getText();
			accountsReceivableTestData.put("FirstApprovedRecord", firstApprovedRecord);
			System.out.println(accountsReceivableTestData.get("FirstApprovedRecord"));
		}
		@And("^go to aacounts payable module$")
		public void go_to_aacounts_payable_module() throws Throwable {
			waithelper.waitForElementVisible(kubsMakerObj.kubsDirectionIcon(), 2000, 100);
			kubsMakerObj.kubsDirectionIcon().click();
			waithelper.waitForElementVisible(kubsMakerObj.kubsAccountsPayable(), 2000, 100);
			kubsMakerObj.kubsAccountsPayable().click();
		}
		@Then("^verify approved record is availabe for payment settlement$")
		public void verify_approved_record_is_availabe_for_payment_settlement() throws Throwable {
			javascripthelper.JavaScriptHelper(driver);
			waithelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
					100);
			paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
			paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
					.sendKeys(paymentSettlementTestData.PaymentOption);
			paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
			paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
			paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
					.sendKeys(AccoutsReceivableAdvanceTestData.BusinessPartnerNAme);
			paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// div[contains(text(),'ADV_36_2422022')]
			for (int i = 1; i <= 14; i++) {
				Thread.sleep(1000);
				if (i == 14) {
					System.out.println("Data not available");
					System.out
							.println("Approved record we search " + accountsReceivableTestData.get("FirstApprovedRecord"));
					Assert.fail("Data not available");
				}
				try {

					waithelper.waitForElementVisible(driver.findElement(By.xpath(
							"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]")),
							2000, 100);
					javascripthelper.scrollToElemet(driver.findElement(By.xpath(
							"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]")));
					boolean finalStatus = driver.findElement(By.xpath(
							"//div[contains(text(),'" + accountsReceivableTestData.get("FirstApprovedRecord") + "')]"))
							.isDisplayed();
					Assert.assertTrue(finalStatus);
					break;
				} catch (NoSuchElementException e) {
					javascripthelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
					paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
				}
			}
		}
	
	
	
	
	
	
	
	@And("^user update the Excelsheet Testdata for balancesheet$")
	public void user_update_the_Excelsheet_Testdata_for_balancesheet() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR/AP_UAT_003_004_TC_02_D1");
	}

	@And("^user update the Excelsheet Testdata for report$")
	public void user_update_the_Excelsheet_Testdata_for_report() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR/AP_UAT_003_004_TC_03_D1");
	}

	@And("^user update the Excelsheet Testdata for paymentsettlement$")
	public void user_update_the_Excelsheet_Testdata_for_paymentsettlement() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR/AP_UAT_003_004_TC_05_D1");
	}

	@And("^user update the Excelsheet Testdata for accountingentry$")
	public void user_update_the_Excelsheet_Testdata_for_accountingentry() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR/AP_UAT_003_005_TC_01_D1");
	}
	
	@And("^user update the Excelsheet Testdata for Balancesheets$")
	public void user_update_the_Excelsheet_Testdata_for_Balancesheets() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR/AP_UAT_003_005_TC_02_D1");
	}
	
	@And("^user update the Excelsheet Testdata for Payable report$")
	public void user_update_the_Excelsheet_Testdata_for_Payable_report() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR_AP_UAT_003_005_TC_03_D1");
	}
	
	@And("^user update the excelshheet Testdata for payment settlement$")
	public void user_update_the_excelsheet_Testdata_for_payment_settlement() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR_AP_UAT_003_005_TC_04_D1");
	}
	

	
	@And("^user update the exccelsheet Testdata for Advance to Employee$")
	public void user_update_the_exccelsheet_Testdata_for_Advance_to_Employee() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_AR_AP_UAT_004_002_TC_01_D1");
	}
}
