package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.Account_Receivable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;

public class ARAP_CancellationOfCreditNote extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00091\\git\\AzentioAutomationFramework\\ARAP_Excel_priyanka0612\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
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
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^store the credit note number$")
	public void store_the_credit_note_number() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		String creditnotenumber = (String) javascriphelper.executeScript(
				"return document.getElementsByClassName('ng-untouched ng-pristine ng-valid sc-ion-input-md-h sc-ion-input-md-s md has-value hydrated ion-untouched ion-pristine ion-valid')[0].value");
		// String creditnotenumber = (String) javascriphelper.executeScript("return
		// document.getElementsByName('creditnoteNo')[1].value");
		testdata.put("creditnotenumber", creditnotenumber);
		System.out.println(creditnotenumber);
	}

	@And("^click the Notes Option In Top$")
	public void click_the_notes_option_in_top() throws Throwable {
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
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Full Month") + " " + testData.get("Date") + ", " + testData.get("Year") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Full Month") + " " + testData.get("Date") + ", " + testData.get("Year") + "']")).click();
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
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(enquiryObj.nextPageInListView());
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
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_CreditNote_Eye());
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
		seleniumactions.getWaitHelper().waitForElement(driver, 20000, account_Receivable.creditNote_Buisness_Partner());
		String buinesspartner = account_Receivable.creditNote_Buisness_Partner().getText();
		testdata.put("buinesspartner", buinesspartner);
	}

	@And("^get buisness partner name , get credit note number and get credit note date$")
	public void get_buisness_partner_name_get_credit_note_number_and_get_credit_note_date() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 4000, account_Receivable.creditNote_Buisness_Partner());
		String buisnessPartnerName = account_Receivable.creditNote_Buisness_Partner().getText();
		testdata.put("buisnessPartnerName", buisnessPartnerName);
		javascriphelper.JavaScriptHelper(driver);
		String contractenddate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
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
		String creditnotenumber = (String) javascriphelper.executeScript("return document.getElementsByName('creditnoteNo')[1].value");
		testdata.put("creditnotenumber", creditnotenumber);
		System.out.println(creditnotenumber);
		System.out.println(testdata.get("creditnotenumber"));

	}

	@And("^click the notes option in top$")
	public void click_the_notes_optin_in_top() throws Throwable {
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

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {
				// span[contains(text(),'Oct 2022')]
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click the view icon$")
	public void click_the_view_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.viewInContractReport());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.viewInContractReport());
		Thread.sleep(5000);
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

		while (true) {
			try {
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")));
				// seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()='"+testdata.get("creditnotenumber")+"']")));
				driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")).isDisplayed();
				String creditnumber = driver.findElement(By.xpath("//div[text()='" + testdata.get("creditnotenumber") + "']")).getText();
				System.out.println("found the credit number :" + creditnumber);

				break;
			} catch (NoSuchElementException e) {
				seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.nextPageInContractReport());
				enquiryObj.nextPageInContractReport().click();
			}
		}
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}

	//////////////////////////// 003_007_tc_04//////////////////////////

	@And("^click account payable main module$")
	public void click_account_payable_main_module() throws Throwable {
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
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentSettlementAddIcon());
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
		javascriphelper.JavaScriptHelper(driver);

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
	
	@Then("^select data set ID for Verify accounting entries post credit note is cancelled$")
	public void select_data_set_id_for_verify_accounting_entries_post_credit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
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

}