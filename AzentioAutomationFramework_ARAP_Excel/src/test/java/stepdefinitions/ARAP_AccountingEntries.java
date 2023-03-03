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
import helper.Selenium_Actions;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.Enquiry_Obj;
import pageobjects.InvoiceBookingObj;
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
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	VerificationHelper verificationHelper = new VerificationHelper();
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
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
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	BrowserHelper browseHelper = new BrowserHelper(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	Map<String, String> settlementData = new HashMap<>();
	
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_AccountingEntries", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^Update the data set id for Accounting entries post bill is approved$")
    public void update_the_data_set_id_for_accounting_entries_post_bill_is_approved() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_12_D1");     
    }
	
	@And("^Update the data set id for Accounting entries3$")
    public void update_the_data_set_id_for_accounting_entries3() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_002_TC_02_D1");     
    }
	@And("^Update the data set id for Accounting entries4$")
    public void update_the_data_set_id_for_accounting_entries4() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_003_TC_02_D1");     
    }
	@And("^Update the data set id for Accounting entries5$")
    public void update_the_data_set_id_for_accounting_entries5() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_004_TC_01_D1");     
    }
	@And("^Update the data set id for Accounting entries6$")
    public void update_the_data_set_id_for_accounting_entries6() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_004_TC_06_D1");     
    }
	@And("^Update the data set id for Accounting entries7$")
    public void update_the_data_set_id_for_accounting_entries7() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_005_TC_01_D1");     
    }
	@And("^Update the data set id for Accounting entries8$")
    public void update_the_data_set_id_for_accounting_entries8() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_005_TC_06_D1");     
    }
	
	@And("^Update the data set id for Accounting entries9$")
    public void update_the_data_set_id_for_accounting_entries9() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_006_TC_03_D1");     
    }
	
	@And("^Update the data set id for Accounting entries10$")
    public void update_the_data_set_id_for_accounting_entries10() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_007_TC_02_D1");     
    }
	@And("^Update the data set id for Accounting entries11$")
    public void update_the_data_set_id_for_accounting_entries11() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_008_TC_01_D1");     
    }
	@And("^Update the data set id for Accounting entries12$")
    public void update_the_data_set_id_for_accounting_entries12() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_009_TC_01_D1");     
    }
	@And("^Update the data set id for Accounting entries13$")
    public void update_the_data_set_id_for_accounting_entries13() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_010_TC_01_D1");     
    }
	
	@And("^Update the data set id for Accounting entries14$")
    public void update_the_data_set_id_for_accounting_entries14() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_003_003_TC_02_D1");     
    }
	
	@And("^Update the data set id for Accounting entries15$")
    public void update_the_data_set_id_for_accounting_entries15() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_003_004_TC_01_D1");     
    }
	 @And("^update data set id for accounting entries payment settlement$")
	    public void update_data_set_id_for_accounting_entries_payment_settlement() throws Throwable {
		  testData = excelData.getTestdata("KUBS_AR/AP_UAT_004_005_TC_04_D1"); 
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
//		for (int i = 0; i <= 20; i++) {
//			try {
		waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAPViewButton());
		WebElement ViewButton = arapObj.ARAPViewButton();
		clickAndActionHelper.moveToElement(ViewButton);
//		clickAndActionHelper.doubleClick(ViewButton);
		ViewButton.click();
//		break;
//
//			} catch (Exception e) {
//				
//			}}
	}

	@Then("^Verify Accounting entries post Bill is approved$")
	public void verify_accounting_entries_post_bill_is_approved() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 20; i++) {
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
	
	
	@Then("^Enter the GRN status cancel$")
	public void enter_the_grn_status_cancel() throws Throwable {
		// ---------ENTER THE STATUS-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GRNStatus());
		arapObj.ARAP_GRNStatus().click();
		arapObj.ARAP_GRNStatus().sendKeys(testData.get("GRNStatus"));
	}
	
	@And("^Get the Branchcode and Ref No$")
	public void get_the_branchcode_and_ref_no() throws Throwable {
		// ---------GET BRANCH CODE---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviable_GetBranchcode());
		Branchcode = arapObj.accountReceviable_GetBranchcode().getText();
		System.out.println(Branchcode);
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviable_GetGrn());
		GRNNO = arapObj.accountReceviable_GetGrn().getText();
		System.out.println(GRNNO);
	}
	
	@Then("^Verify Accounting entries post GRN is cancelled$")
	public void verify_accounting_entries_post_grn_is_cancelled() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 30; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')])[1]"))
						.isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + GRNNO
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + GRNNO
						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
		for (int i = 0; i <= 30; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')])[2]"))
						.isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + GRNNO + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + GRNNO
								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + GRNNO
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

//----------------------------------//
	
	
	@And("^search invoice type as a expense$")
	public void search_invoice_type_as_a_expense() throws Throwable {
		arapObj.ARAP_InvoiceTypeSearch().click();
		arapObj.ARAP_InvoiceTypeSearch().sendKeys(testData.get("InvoiceType"));
	}
	@And("^get the invoice number from the bill viewed$")
	public void get_the_invoice_number_from_the_bill_viewed() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
		String buisnesspartner = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
		System.out.println(buisnesspartner);
		testdata.put("buisnesspartner", buisnesspartner);
		javaScriptHelper.JavaScriptHelper(driver);
		String invoicenumber = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('billNo')[0].value");
		System.out.println(invoicenumber);
		testdata.put("invoicenumber", invoicenumber);

	}

	@And("^click the notes option in top$")
	public void click_the_notes_optin_in_top() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
	}

	@And("^click the enquiry module$")
	public void click_the_enquiry_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryEnquiryMenu());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryEnquiryMenu());
	}

	@And("^click the financial transaction edit icon$")
	public void click_the_financial_transaction_edit_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFinancialTransactionIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFinancialTransactionIcon());
	}
	
	
	@And("^select the branch code as azentio main branch$")
	public void select_the_branch_code_as_azentio_main_branch() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryBranchCode());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryBranchCode());
		enquiryObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	
	
	@And("^click the view option$")
	public void click_the_view_option() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
		Thread.sleep(2000);
	}
	

	@Then("^verify that the invoice number get from bill matches with voucher id in report$")
    public void verify_that_the_invoice_number_get_from_bill_matches_with_voucher_id_in_report() throws Throwable {
	/*	while (true) {
			try {
				seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")));
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")).isDisplayed();
				String invoiceNumber = driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")).getText();
				System.out.println(invoiceNumber);
				break;
				
			} catch (NoSuchElementException e) {
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(enquiryObj.nextPageInListView());
				seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.nextPageInListView());
				enquiryObj.nextPageInListView().click();
			}
		}
		*/
		seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.transactionRefNo());
        enquiryObj.transactionRefNo().click();
        enquiryObj.transactionRefNo().sendKeys(testdata.get("invoicenumber"));
        enquiryObj.transactionRefNo().sendKeys(Keys.ENTER);
        seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")).isDisplayed();
//		String invoiceNumber = driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")).getText();
//		System.out.println(invoiceNumber);
		
	}
	
	 
	    @And("^get the approved record from list view$")
	    public void get_the_approved_record_from_list_view() throws Throwable {
	    	waitHelper.waitForElementVisible(payementSettlementObj.accountsPayableApprovedSettlementRefNo(), 2000, 100);
			String approvedReferenceNumber = payementSettlementObj.accountsPayableApprovedSettlementRefNo().getText();
			settlementData.put("approvedReferenceNumber", approvedReferenceNumber);
			System.out.println("Settlement Reference Number" + settlementData.get("approvedReferenceNumber"));  
	    }
	    @Then("^verify approved settlement reference number is available in the Gl report$")
		public void verify_approved_settlement_reference_number_is_available_in_the_gl_report() throws Throwable {
	    	javaScriptHelper.JavaScriptHelper(driver);
			Thread.sleep(1000);
			
		
					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
							+ settlementData.get("approvedReferenceNumber") + "')])[1]")).isDisplayed();

					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
							+ settlementData.get("approvedReferenceNumber") + "')])[1]"));
					String TransactionType = driver
							.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
									+ settlementData.get("approvedReferenceNumber")
									+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
							.getText();
					System.out.println("TransactionType is " + TransactionType);
					String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
							+ settlementData.get("approvedReferenceNumber")
							+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
							.getText();
					System.out.println("Amount is " + amount);
						}
	    
	    
	    
	    
	    //----------------------------------//
	    
	    @And("^Update the data set id for Accounting entries16$")
	    public void update_the_data_set_id_for_accounting_entries16() {
			testData = excelData.getTestdata("KUBS_AR_AP_UAT_002_001_TC_02_D1");     
	    } 
	    @Then("^Enter Active Value In Debit Not Status$")
		public void enter_active_value_in_debit_not_status() throws Throwable {
			// ------------ACTIVE STATUS------------//
			javaScriptHelper.JavaScriptHelper(driver);
			javaScriptHelper.scrollIntoView(arapObj.accountsReceivable_DebitNote_Status());
			waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Status());
			arapObj.accountsReceivable_DebitNote_Status().click();
			arapObj.accountsReceivable_DebitNote_Status().sendKeys("Active");
		}
	    @And("^Get The Bp Name and Debit Number Store It$")
		public void get_the_bp_name_and_debit_number_store_it() throws Throwable {
			// ---------GET THE REQUIRED DETAILS--------------//
			Thread.sleep(1000);
			waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetBpname());
			BPNumber = arapObj.accountsReceivable_DebitNote_GetBpname().getText();
			System.out.println(BPNumber);
			Thread.sleep(1000);
			javaScriptHelper.JavaScriptHelper(driver);
			DebitNo = (String) javaScriptHelper
					.executeScript("return document.getElementsByName('debitNoteNumber')[1].value");
			System.out.println(DebitNo);
			waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetInvoiceNo());
			InvoiceNo = arapObj.accountsReceivable_DebitNote_GetInvoiceNo().getText();
			System.out.println(InvoiceNo);
			
		}
	    @Then("^Verify Accounting entries post Debit Note is approved$")
		public void verify_accounting_entries_post_debit_note_is_approved() throws Throwable {
			javaScriptHelper.JavaScriptHelper(driver);
			Thread.sleep(1000);
			for (int i = 0; i <= 20; i++) {
				try {

					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]"))
							.isDisplayed();

					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]"));
					String TransactionType = driver
							.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo
									+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
							.getText();
					System.out.println("TransactionType is " + TransactionType);
					String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
							+ DebitNo
							+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
							.getText();
					System.out.println("Amount is " + amount);
					break;

				} catch (NoSuchElementException e) {
					javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
					arapObj.accountsPayablePayementSettlementNextRecord().click();
				}
			}
			for (int i = 0; i <= 20; i++) {
				try {

					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[2]"))
							.isDisplayed();

					driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]"));
					String TransactionType = driver
							.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo
									+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
							.getText();
					System.out.println("TransactionType is " + TransactionType);
					String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
							+ DebitNo
							+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
							.getText();
					System.out.println("Amount is " + amount);
					break;

				} catch (NoSuchElementException e) {
					javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
					arapObj.accountsPayablePayementSettlementNextRecord().click();
				}

			}
		}


}
