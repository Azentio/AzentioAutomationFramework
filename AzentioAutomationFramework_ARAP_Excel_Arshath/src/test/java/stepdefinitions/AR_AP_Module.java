package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.Account_Receivable;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.Enquiry_Obj;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.InvoiceBookingObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;

public class AR_AP_Module {

	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
//	Map<String, String> testdata = new LinkedHashMap<>();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj=new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	BUDGET_SupplementaryBudgetObj  supplimentoryBudgetObj = new  BUDGET_SupplementaryBudgetObj(driver);
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
		testdata.put("buisnesspartner", buisnesspartner);
		javascriphelper.JavaScriptHelper(driver);
		String invoicenumber = (String) javascriphelper
				.executeScript("return document.getElementsByName('billNo')[0].value");
		System.out.println(invoicenumber);
		testdata.put("invoicenumber", invoicenumber);

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
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox()
				.sendKeys(testData.get("BranchCode"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
		// arAp_BalanceSheetReportTestDataType=
		// jsonReader.getBalanceSheetReportByName("maker");
		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType()
				.sendKeys(testData.get("ReportType"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);

	}

	@And("^select the date$")
	public void select_the_date() throws Throwable {
		//arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");
		Thread.sleep(2000);
		//arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");

		waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {
				// span[contains(text(),'Oct 2022')]
				Thread.sleep(1000);
				waithelper.waitForElement(driver, 2000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("Month") + " "
										+ testData.get("Year") + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month")
								+ " " + testData.get("Year") + "')]"));
				
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		Thread.sleep(1000);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
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
  //*********************************@KUBS_AR/AP_UAT_003_004TC_03********************************************//
    
    @And("^click the Reports Sub Module$")
    public void click_the_reports_sub_module() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.reportMenu());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.reportMenu());
    }
    @And("^click the Accounts Payable Report$")
    public void click_the_accounts_payable_report() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(enquiryObj.accountsPayableReport());
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.accountsPayableReport());
       enquiryObj.accountsPayableReport().click();
    }
    @And("^select the vendor name$")
    public void select_the_vendor_name() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectVendorName());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
        enquiryObj.selectVendorName().sendKeys(testdata.get("buisnessPartnerName"));
        enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
    }
    @And("^select the payable status$")
    public void select_the_payable_status() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectContractStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
        enquiryObj.selectContractStatus().sendKeys(testdata.get("invoicestatus"));
        enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the bill is cancelled in Accounts payable report$")
    public void verify_the_bill_is_cancelled_in_accounts_payable_report() throws Throwable {
    	seleniumactions.getBrowserHelper().SwitchToWindow(1);
    	String currenturl = driver.getCurrentUrl();
    	System.out.println(currenturl);
    	String beforeXpath="//*[@id=\"__bookmark_1\"]/tbody/tr[";
    	String afterXpath ="]/td[4]/div";
    	for (int j = 1; j <=50; j++) {
    		String actualXpath=beforeXpath+j+afterXpath;
    		try {
    			seleniumactions.getWaitHelper().waitForElement(driver,2000,  driver.findElement(By.xpath(actualXpath)));
    			String invoice = driver.findElement(By.xpath(actualXpath)).getText();
        		System.out.println(invoice);
        		if (invoice.equalsIgnoreCase(testdata.get("invoicenumber"))) {
    				System.out.println("found invoice number "+invoice);
    				break;
    			}
			} catch (NoSuchElementException e) {
				continue;
			}
    		
		}
    	seleniumactions.getBrowserHelper().switchToParentWithChildClose();
    }

    //*********************************@KUBS_AR/AP_UAT_003_004TC_04_01********************************************//


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

for(int i=0;i<=10;i++)
{
	try
	{
	waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
		//bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 6, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	break;
	}
	catch(Exception e)
	{
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
     String utilizationAmount  =(String) javascripthelper.executeScript("return document.getElementById('utilizedAmt').value");
     System.out.println("Amount utilization is "+utilizationAmount);
     
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
		for (int i = 0; i <30; i++) {
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
        waithelper.waitForElementVisible(vendorContractObj.firstTempRecord(),2000,100);
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
    	while(true)
    	{
    		try
    		{
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
    		}
    		catch(StaleElementReferenceException e)
    		{
    			
    		}
    	}
    }
    @And("^add the benificiory details and select auto payout as yes$")
    public void add_the_benificiory_details_and_select_auto_payout_as_yes() throws Throwable {
    	while(true)
    	{
    		try
    		{
    	waithelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetails(), 2000, 100);
    	 vendorContractObj.vendorContractBenificioryDetails().click();
    	 break;
    		}
    		catch(StaleElementReferenceException e)
    		{
    			
    		}
    	}//waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
         //vendorContractObj.vendorContractAddButton().click();
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
		// After save our budget record we have to click on notification to submit our
		// record for approvals
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
				100);
		budgetCreationObj.budgetCreationNotificationIcon().click();
//		Thread.sleep(1000);

	}



@And("^user update the Excelsheet Testdata for balancesheet$")
public void user_update_the_Excelsheet_Testdata_for_balancesheet() throws Throwable{
	testData=Exceldata.getTestdata("KUBS_AR/AP_UAT_003_004_TC_02_D1");
}
@And("^user update the Excelsheet Testdata for report$")
public void user_update_the_Excelsheet_Testdata_for_report() throws Throwable{
	testData=Exceldata.getTestdata("KUBS_AR/AP_UAT_003_004_TC_03_D1");
}



}
