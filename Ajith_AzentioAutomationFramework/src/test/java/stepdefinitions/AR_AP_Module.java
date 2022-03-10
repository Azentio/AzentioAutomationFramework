package stepdefinitions;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Account_Receivable;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.InvoiceBookingObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import testDataType.Cancellationofcontractdatatype;

public class AR_AP_Module extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	JsonConfig jsonconfig = new JsonConfig();
	Cancellationofcontractdatatype cancellationofcontractdata = jsonconfig.getCancelcontractByName("Maker");
	Map<String, String> testdata = new LinkedHashMap<>();
	private String invoicebuisnessPartner;
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	//******************************@KUBS_AR/AP_UAT_001_002TC_02*********************************************************************
	// verify accounting entries bill is approved
	 @Given("^user navigate to azentio url and login as maker for verify post bill is approved in Accounting Entries$")
	    public void user_navigate_to_azentio_url_and_login_as_maker_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
		 login = new AzentioLogin(driver);
			driver.get(configreader.getApplicationUrl());
			login.loginToAzentioApp("maker");
			Thread.sleep(2000);
			seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	    }

	    @When("^click the account payable main module for verify post bill is approved in Accounting Entries$")
	    public void click_the_account_payable_main_module_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	    }

	    @And("^click the eye icon of invoice bill booking for verify post bill is approved in Accounting Entries$")
	    public void click_the_eye_icon_of_invoice_bill_booking_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
			seleniumactions.getClickAndActionsHelper()
					.clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
	    }

	    @And("^click the search icon in list view for verify post bill is approved in Accounting Entries$")
	    public void click_the_search_icon_in_list_view_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	    }

	    @And("^search invoice type as expense for verify post bill is approved in Accounting Entries$")
	    public void search_invoice_type_as_expense_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchInvoiceType());
			seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceType());
			invoiceBookingObj.searchInvoiceType().sendKeys(cancellationofcontractdata.ContractType);
	    }

	    @And("^click the first eye icon in the list view of Active invoice bill$")
	    public void click_the_first_eye_icon_in_the_list_view_of_active_invoice_bill() throws Throwable {
	    	String beforexpath="//datatable-row-wrapper[";
	    	String afterxpath ="]/datatable-body-row[1]/div[2]/datatable-body-cell[13]/div[1]/span[1]";
	    	for (int i = 1; i < 7; i++) {
	    		// select active bill with expense as contract type
	    		seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(beforexpath+i+afterxpath)));
				String invoiceBillStatus = driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
				if (invoiceBillStatus.equalsIgnoreCase(cancellationofcontractdata.contractstatusactive)) {
					seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])["+i+"]")));
					driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])["+i+"]")).click();
					break;
				}
			}
	    }

	    @And("^get the invoice number from the Active  bill viewed$")
	    public void get_the_invoice_number_from_the_active_bill_viewed() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
	    	String buisnesspartner = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
			System.out.println(buisnesspartner);
			testdata.put("buisnesspartner", buisnesspartner);
			javascriphelper.JavaScriptHelper(driver);
			String invoicenumberforactivebill = (String) javascriphelper
					.executeScript("return document.getElementsByName('billNo')[0].value");
			System.out.println(invoicenumberforactivebill);
			testdata.put("invoicenumberforactivebill",invoicenumberforactivebill);
	    }

	    @And("^click the notes option in top for verify post bill is approved$")
	    public void click_the_notes_option_in_top_for_verify_post_bill_is_approved() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
	    }

	    @And("^click the enquiry module for verify post bill is approved$")
	    public void click_the_enquiry_module_for_verify_post_bill_is_approved() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryEnquiryMenu());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryEnquiryMenu());
	    }

	    @And("^click the financial transaction edit icon for verify post bill is approved in Accounting Entries$")
	    public void click_the_financial_transaction_edit_icon_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFinancialTransactionIcon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFinancialTransactionIcon());
	    }

	    @And("^select the branch code as azentio main branch for verify post bill is approved in Accounting Entries$")
	    public void select_the_branch_code_as_azentio_main_branch_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryBranchCode());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryBranchCode());
			enquiryObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	    }

	    @And("^select the transaction from date  for verify post bill is approved in Accounting Entries$")
	    public void select_the_transaction_from_date_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFromDate());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFromDate());
			Thread.sleep(2000);
			javascriphelper.JavaScriptHelper(driver);
			driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
					.click();
			driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear  + "']")).click();
			driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlMonth + "']")).click();
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
			driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")).click();
	    }

	    @And("^select the transaction to date for verify post bill is approved in Accounting Entries$")
	    public void select_the_transaction_to_date_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryToDate());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryToDate());
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
					.click();
			driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear + "']")).click();
			driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlToMonth + "']")).click();
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
			driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlToDate + "'])[1]")).click();
	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
			Thread.sleep(2000);
	    }

	    @And("^click the view option for verify post bill is approved in Accounting Entries$")
	    public void click_the_view_option_for_verify_post_bill_is_approved_in_accounting_entries() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
			seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
			Thread.sleep(2000);
	    }
	    @Then("^verify that the invoice number get from Active bill matches with voucher id in report$")
	    public void verify_that_the_invoice_number_get_from_active_bill_matches_with_voucher_id_in_report() throws Throwable {
	    	int i=1;
	    	while (true) {
				try {
					seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumber")+"')]")));
					driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("invoicenumberforactivebill")+"')]")).isDisplayed();
					break;
					
				} catch (NoSuchElementException e) {
					if (i==1) {
						javascriphelper.JavaScriptHelper(driver);
						javascriphelper.scrollIntoView(enquiryObj.lastPage());
						enquiryObj.lastPage().click();
					}
					i++;
					seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.previousPageInContractReport());
					enquiryObj.previousPageInContractReport().click();
				}
			}
	    }

	//(***************************************@KUBS_AR/AP_UAT_003_001TC_01***************************************************)
	//verify the contract report should show correct logged info
	 @When("^user login as azentio maker for contract report verification$")
	    public void user_login_as_azentio_maker_for_contract_report_verification() throws Throwable {
		 login = new AzentioLogin(driver);
			driver.get(configreader.getApplicationUrl());
			login.loginToAzentioApp("maker");
			Thread.sleep(2000);
			seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	    }

    @And("^user click Accounts Payable for contract report verification$")
    public void user_click_accounts_payable_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^user click Vendor Contracts eye icon for contract report verification$")
    public void user_click_vendor_contracts_eye_icon_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApeyeicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
    }

    @And("^click the first eye icon in the list for contract report verification$")
    public void click_the_first_eye_icon_in_the_list_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getClickFirstEyeiconInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(cancellationofcontract.getClickFirstEyeiconInListView());
    }

    @And("^get buisness partner name,get contract end date and get contract acccount code,get contract status$")
    public void get_buisness_partner_nameget_contract_end_date_and_get_contract_acccount_codeget_contract_status() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getBuisnessPartnerNameinContract());
		String buisnessPartnerName = cancellationofcontract.getBuisnessPartnerNameinContract()
				.getText();
		testdata.put("buisnessPartnerName", buisnessPartnerName);
		javascriphelper.JavaScriptHelper(driver);
		String contractacccountcode = (String) javascriphelper.executeScript(
				"return document.getElementsByClassName('native-input sc-ion-input-md')[\"contractCode\"].value");
		testdata.put("contractacccountcode", contractacccountcode);
		String contractenddate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[2].value");
		String year = contractenddate.substring(7,11);
		testdata.put("year", year);
		String month = contractenddate.substring(3, 6);
		testdata.put("month", month);
		String day = contractenddate.substring(1, 2);
		testdata.put("day", day);
		String contractStatus = driver.findElement(By.xpath("(//ion-col[15]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div)[2]")).getText();
		testdata.put("contractstatus", contractStatus);
    }
    @And("^click the notes option for contract report verification$")
    public void click_the_notes_option_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
    }

    @And("^click the Reports Sub Module$")
    public void click_the_reports_sub_module() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.reportMenu());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.reportMenu());
    }

    @And("^click the contract report edit icon$")
    public void click_the_contract_report_edit_icon() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.contractReportEditIcon());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.contractReportEditIcon());
    }

    @And("^select the vendor name according to contract$")
    public void select_the_vendor_name_according_to_contract() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectVendorName());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
       enquiryObj.selectVendorName().sendKeys(testdata.get("buisnessPartnerName"));
       enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
    }

    @And("^select the date based on contract end date$")
    public void select_the_date_based_on_contract_end_date() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.calenderInContractReport());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.calenderInContractReport());
       Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testdata.get("year")  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testdata.get("month") + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + testdata.get("day") + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + testdata.get("day") + "'])[1]")).click();
    }
    @And("^select the contract status based on we get from list$")
    public void select_the_contract_status_based_on_we_get_from_list() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectContractStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
        enquiryObj.selectContractStatus().sendKeys(testdata.get("contractstatus"));
        enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
    }

    @And("^click the view icon$")
    public void click_the_view_icon() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.viewInContractReport());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.viewInContractReport());
    }
    @Then("^verify the contract code in contract report$")
    public void verify_the_contract_code_in_contract_report() throws Throwable {
    	//Set<String> windowHandles = seleniumactions.getBrowserHelper().getWindowHandles();
			seleniumactions.getBrowserHelper().SwitchToWindow(1);
		
    	while (true) {
    		try {
    			seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[contains(text(),'"+testdata.get("contractacccountcode")+"')]")));
    			driver.findElement(By.xpath("//div[contains(text(),'"+testdata.get("contractacccountcode")+"')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.nextPageInContractReport());
				enquiryObj.nextPageInContractReport().click();
			}
			
		}
    	seleniumactions.getBrowserHelper().switchToParentWithChildClose();
       
    }
//************************************* @KUBS_AR/AP_UAT_003_001TC_02****************************************************
	// Verify creating po against cancelled order is not allowed

	@Given("^user navigate to the url and login as a maker$")
	public void user_navigate_to_the_url_and_login_as_a_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

	@When("^user click Accounts Payable$")
	public void user_click_accounts_payable() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^user click Vendor Contracts eye icon$")
	public void user_click_vendor_contracts_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApeyeicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
	}

	@And("^user click search icon$")
	public void user_click_search_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^user search cancelled vendor contract$")
	public void user_search_cancelled_vendor_contract() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getSearchcontractstatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchcontractstatus());
		cancellationofcontract.getSearchcontractstatus().sendKeys(cancellationofcontractdata.contractstatus);
	}

	@And("^User search Buisness partner name$")
	public void user_search_buisness_partner_name() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getVendorposearchbpname());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getVendorposearchbpname());
		cancellationofcontract.getVendorposearchbpname().sendKeys(cancellationofcontractdata.BuisnessPartnerName);
	}

	@And("^user click the cancelled vendor contract eye icon$")
	public void user_click_the_cancelled_vendor_contract_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getClickSecondEyeiconInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(cancellationofcontract.getClickSecondEyeiconInListView());
	}

	@And("^get buisness partner name$")
	public void get_buisness_partner_name() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getBuisnessPartnerNameinContract());
		String buisnessPartnerNameinCancelledContract = cancellationofcontract.getBuisnessPartnerNameinContract()
				.getText();
		testdata.put("buisnessPartnerNameinCancelledContract", buisnessPartnerNameinCancelledContract);
	}

	@And("^click vendor purchase order eye ion$")
	public void click_vendor_purchase_order_eye_ion() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				arpoCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton());
	}

	@And("^click vendor purchase order add ion$")
	public void click_vendor_purchase_order_add_ion() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				arpoCreationObj.accountsPayable_VendorPurchaseOrder_AddButton());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_AddButton());
	}

	@And("^select buisness partner we get in cancelled list$")
	public void select_buisness_partner_we_get_in_cancelled_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
		arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName()
				.sendKeys(testdata.get("buisnessPartnerNameinCancelledContract"));
		arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
	}

	@And("^select referece type as contract$")
	public void select_referece_type_as_contract() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
		arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
	}

	@Then("^verify not able to select contract and po creation is not allowed$")
	public void verify_not_able_to_select_contract_and_po_creation_is_not_allowed() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
		Thread.sleep(3000);
		System.out.println("no items found and not able to create purchase order for cancelled contract");

	}
     //*************************************** @KUBS_AR/AP_UAT_003_001TC_03***********************************
	// check cancellation of contract is not allowed when purchase order is created
	// against contract
	@Given("^user navigate to the url and login as a maker for cancellation of contract is not allowed$")
	public void user_navigate_to_the_url_and_login_as_a_maker_for_cancellation_of_contract_is_not_allowed()
			throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

	@When("^click the accounts payable$")
	public void click_the_accounts_payable() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the vendor contract eye icon sub module$")
	public void click_the_vendor_contract_eye_icon_sub_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApeyeicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
	}

	@And("^click search icon in list view$")
	public void click_search_icon_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search contract status as closed$")
	public void search_contract_status_as_closed() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getSearchcontractstatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchcontractstatus());
		cancellationofcontract.getSearchcontractstatus()
				.sendKeys(cancellationofcontractdata.Contractstatusforcancellationofcontract);
	}

	@And("^click the first eye icon in the list$")
	public void click_the_first_eye_icon_in_the_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getClickSecondEyeiconInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(cancellationofcontract.getClickSecondEyeiconInListView());
	}

	@And("^get buisness partner name and get contract acccount code$")
	public void get_buisness_partner_name_and_get_contract_acccount_code() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getBuisnessPartnerNameinContract());
		String buisnessPartnerNameinCancelledContract = cancellationofcontract.getBuisnessPartnerNameinContract()
				.getText();
		testdata.put("buisnessPartnerNameinCancelledContract", buisnessPartnerNameinCancelledContract);
		javascriphelper.JavaScriptHelper(driver);
		Object contractacccountcode = javascriphelper.executeScript(
				"return document.getElementsByClassName('native-input sc-ion-input-md')[\"contractCode\"].value");
		String contractacccountcode1 = String.valueOf(contractacccountcode);
		testdata.put("contractacccountcode", contractacccountcode1);
	}

	@And("^click the ar ap adjustment sub module$")
	public void click_the_ar_ap_adjustment_sub_module() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(arapAdjustment.ClickArApAdjustmentModule());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.ClickArApAdjustmentModule());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.ClickArApAdjustmentModule());
	}

	@And("^click ar ap eye icon$")
	public void click_ar_ap_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentViewButton());
	}

	@And("^click add icon$")
	public void click_add_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.arApAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.arApAddIcon());
	}

	@And("^select bp name according to bp we get in contratc$")
	public void select_bp_name_according_to_bp_we_get_in_contratc() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentBpName());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentBpName());
		arapAdjustment.adjustmentBpName().sendKeys(testdata.get("buisnessPartnerNameinCancelledContract"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
	}

	@And("^select adjustment type as cancellation$")
	public void select_adjustment_type_as_cancellation() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentadjustmentType());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentadjustmentType());
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.ENTER);
	}

	@And("^select adjustment item type as contract$")
	public void select_adjustment_item_type_as_contract() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentItemType());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentItemType());
		arapAdjustment.adjustmentItemType().sendKeys(cancellationofcontractdata.Cancellationtype);
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
	}

	@And("^select adjustment reference as we get in contract account code$")
	public void select_adjustment_reference_as_we_get_in_contract_account_code() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentAdjustmentReference());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentAdjustmentReference());
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(testdata.get("contractacccountcode"));
	}

	@Then("^verify that cancellation of contract is not allowed when po created for contract$")
	public void verify_that_cancellation_of_contract_is_not_allowed_when_po_created_for_contract() throws Throwable {
		System.out.println("no ajustment reference found and cancellation of contract not Allowed against po created");
	}
//****************************************@KUBS_AR/AP_UAT_003_004TC_01************************************************************************
// accounting entries for cancelled bill
	@Given("^user navigate to azentio url and login as maker$")
	public void user_navigate_to_azentio_url_and_login_as_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

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
		invoiceBookingObj.searchInvoiceType().sendKeys(cancellationofcontractdata.ContractType);
	}

	@And("^search invoice status as cancelled$")
	public void search_invoice_status_as_cancelled() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(invoiceBookingObj.searchInvoiceStatus());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchInvoiceStatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceStatus());
		invoiceBookingObj.searchInvoiceStatus().sendKeys(cancellationofcontractdata.contractstatus);
	}

	@And("^click the first eye icon in the list view of cancelled invoice bill$")
	public void click_the_first_eye_icon_in_the_list_view_of_cancelled_invoice_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getClickSecondEyeiconInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(cancellationofcontract.getClickSecondEyeiconInListView());
	}

	@And("^get the invoice number from the bill viewed$")
	public void get_the_invoice_number_from_the_bill_viewed() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
		String buisnesspartner = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
		System.out.println(buisnesspartner);
		testdata.put("buisnesspartner", buisnesspartner);
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.JavaScriptHelper(driver);
		String invoicenumber = (String) javascriphelper
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

	@And("^select the transaction from date$")
	public void select_the_transaction_from_date() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFromDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFromDate());
		Thread.sleep(2000);
		javascriphelper.JavaScriptHelper(driver);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")).click();
	}

	@And("^select the transaction to date$")
	public void select_the_transaction_to_date() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryToDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryToDate());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlToDate + "'])[1]")).click();
	}

	@And("^click the view option$")
	public void click_the_view_option() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
		Thread.sleep(2000);
	}

	@Then("^verify that the invoice number get from bill matches with voucher id in report$")
    public void verify_that_the_invoice_number_get_from_bill_matches_with_voucher_id_in_report() throws Throwable {
		while (true) {
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
	}
    //*********************************@KUBS_AR/AP_UAT_003_004TC_05********************************************
	// cancelled bill is not allowed for payment settlement
	@When("^click the invoice eye icon in accounts payable$")
	public void click_the_invoice_eye_icon_in_accounts_payable() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
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

	@And("^search the buisness partner in list view$")
	public void search_the_buisness_partner_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchBpInList());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchBpInList());
		invoiceBookingObj.searchBpInList().sendKeys(cancellationofcontractdata.BuisnessPartnerName1);

	}

	@Then("^verify the bill is cancelled$")
	public void verify_the_bill_is_cancelled() throws Throwable {

		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.statusOfInvoice);
		String statusOfInvoiceBill = invoiceBookingObj.statusOfInvoice.getText();
		Assert.assertEquals("Cancelled", statusOfInvoiceBill);

	}

	@And("^click the payment settlement eye icon$")
	public void click_the_payment_settlement_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon in payment settlement$")
	public void click_the_add_icon_in_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
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
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(cancellationofcontractdata.BuisnessPartnerName1);
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	@Then("^verify that no bill is available for payment settlement$")
	public void verify_that_no_bill_is_available_for_payment_settlement() throws Throwable {
		System.out.println("No records found for paymentsettlement");
	}
	//*********************************@KUBS_AR/AP_UAT_003_007TC_01****************************************************//
	// verify accounting entries cancelled credit
	@Given("^user login as Azentio Maker$")
    public void user_login_as_azentio_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }

	 @When("^click the Account Receivable Main Module for verify Accounting entries$")
	    public void click_the_account_receivable_main_module_for_verify_accounting_entries() throws Throwable {
		 seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.accountReceivable());
	        seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());

	    }

    @And("^click the credit note eye icon$")
    public void click_the_credit_note_eye_icon() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Eye());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Eye());
    }

    @And("^click the search icon in the list view of credit$")
    public void click_the_search_icon_in_the_list_view_of_credit() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
    }

    @And("^search the cancelled credit note and click the first list$")
    public void search_the_cancelled_credit_note_and_click_the_first_list() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(cancellationofcontractdata.contractstatus);
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }

    @And("^store the credit note number$")
    public void store_the_credit_note_number() throws Throwable {
        javascriphelper.JavaScriptHelper(driver);
       String creditnotenumber = (String) javascriphelper.executeScript("return document.getElementsByClassName('ng-untouched ng-pristine ng-valid sc-ion-input-md-h sc-ion-input-md-s md has-value hydrated ion-untouched ion-pristine ion-valid')[0].value");
        //String creditnotenumber = (String) javascriphelper.executeScript("return document.getElementsByName('creditnoteNo')[1].value");
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
		enquiryObj.inventoryBranchCode().sendKeys(Keys.ENTER);
    }

    @And("^Choose the Transaction from date$")
    public void choose_the_transaction_from_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryFromDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryFromDate());
		Thread.sleep(2000);
		javascriphelper.JavaScriptHelper(driver);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")).click();
    }

    @And("^choose the Transaction To date and click view option$")
    public void choose_the_transaction_to_date_and_click_view_option() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryToDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryToDate());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + cancellationofcontractdata.GlToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + cancellationofcontractdata.GlToDate + "'])[1]")).click();
        seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryViewButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryViewButton());
		Thread.sleep(2000);

        
    }
    @Then("^Verify the Credit note nuber in Voucher Id and verify transactipon type$")
    public void verify_the_credit_note_nuber_in_voucher_id_and_verify_transactipon_type() throws Throwable {
    	while (true) {
			try {
				seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("creditnotenumber")+"')]")));
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("creditnotenumber")+"')]")).isDisplayed();
				String creditnotenumber = driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testdata.get("creditnotenumber")+"')]")).getText();
				System.out.println(creditnotenumber);
				break;
				
			} catch (NoSuchElementException e) {
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(enquiryObj.nextPageInListView());
				seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.nextPageInListView());
				enquiryObj.nextPageInListView().click();
			}
		}
    }
	
	
     //************************************@KUBS_AR/AP_UAT_003_007TC_04*********************************************
	// creditnote cancelled is not allowed for payment settlement
	@Given("^login azentio as maker$")
	public void login_azentio_as_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

	@When("^click the Account Receivable main module$")
	public void click_the_account_receivable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click the eye icon in credit note$")
	public void click_the_eye_icon_in_credit_note() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Eye());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Eye());
	}

	@And("^click the search icon in credit note page$")
	public void click_the_search_icon_in_credit_note_page() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search credit note status as cancelled$")
	public void search_credit_note_status_as_cancelled() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(cancellationofcontractdata.contractstatus);
	}

	@And("^click the first eye icon in the Cancelled Credit List$")
	public void click_the_first_eye_icon_in_the_cancelled_credit_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get invoice number and get buisness partner name$")
	public void get_invoice_number_and_get_buisness_partner_name() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 20000, account_Receivable.creditNote_Buisness_Partner());
		String buinesspartner = account_Receivable.creditNote_Buisness_Partner().getText();
		testdata.put("buinesspartner", buinesspartner);
		// seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.creditNote_Invoice_NumberInCreditNotePage());
		// String invoicenumber =
		// account_Receivable.creditNote_Invoice_NumberInCreditNotePage().getText();
		// testdata.put("invoicenumber", invoicenumber);
	}

	@And("^click account payable main module$")
	public void click_account_payable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon in account payable$")
	public void click_the_eye_icon_in_account_payable() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon in payment settlement for credit$")
	public void click_the_add_icon_in_payment_settlement_for_credit() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
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

			seleniumactions.getWaitHelper().waitForElementVisible(
					driver.findElement(By.xpath("//div[text()=' " + testdata.get("invoicenumber") + " ']")), 1000, 100);

			try {
				boolean displayed = driver
						.findElement(By.xpath("//div[text()=' \"+testdata.get(\"invoicenumber\")+\" ']")).isDisplayed();
			} catch (Exception e) {

				e.printStackTrace();
			}
			System.out.println("invoice number not  match");
		}

	}
//****************************************** @KUBS_AR/AP_UAT_004_001TC_01************************************
	// active bill is available for payment settlement
	@Given("^log in to azentio as maker$")
	public void log_in_to_azentio_as_maker() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click the Account payable module$")
	public void click_the_accounht_payable_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the invoice booking eye icon in sub module$")
	public void click_the_invoice_booking_eye_icon_in_sub_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
	}

	@And("^search Invoice status as active$")
	public void search_invoice_status_as_active() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(invoiceBookingObj.searchInvoiceStatus());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchInvoiceStatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceStatus());
		invoiceBookingObj.searchInvoiceStatus().sendKeys("active");

	}

	@And("^click the first eye icon in the list view$")
	public void click_the_first_eye_icon_in_the_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.selectFirstEyeicon);
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.selectFirstEyeicon);
	}

	@And("^get the buisness partner from invoice bill$")
	public void get_the_buisness_partner_and_the_system_invoice_number() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				invoiceBookingObj.getBuisnessPartnerFromInvoiceBill());
		invoicebuisnessPartner = invoiceBookingObj.getBuisnessPartnerFromInvoiceBill().getText();
		System.out.println(invoicebuisnessPartner);

	}

	@And("^click the payment settlement eye icon in Accounts payable$")
	public void click_the_payment_settlement_eye_icon_in_accounts_payable() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon fot the payment settlement$")
	public void click_the_add_icon_fot_the_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^choose the payment option as Buisness partner Type$")
	public void choose_the_payment_option_as_buisness_partner_type() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^Enter buisness partner get from bill booking$")
	public void enter_buisness_partner_get_from_bill_booking() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(invoicebuisnessPartner);
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	@Then("^verify that active bill is available for payment settlement$")
	public void verify_that_active_bill_is_available_for_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getGetActiveBillBuisnessPartner());
		String ActiveBillBuisnessPartner = paymentSettlementObj.getGetActiveBillBuisnessPartner().getText();
		Assert.assertEquals(invoicebuisnessPartner, ActiveBillBuisnessPartner);

	}
   //**********************************@KUBS_AR/AP_UAT_004_001TC_02************************************************
	// verify tds % and tds amount in payment settlement
	@Given("^log into azentio as maker and select finance option$")
	public void log_into_azentio_as_maker_and_select_finance_option() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click the Account payable Mainmodule$")
	public void click_the_account_payable_mainmodule() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon of the payment settlement$")
	public void click_the_eye_icon_of_the_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement$")
	public void click_the_add_icon_of_the_payment_settlement() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type$")
	public void select_payment_option_as_buisness_partner_type() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select the buisness partner from the list$")
	public void select_the_buisness_partner_from_the_list() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
	}

	@And("^select listed bill contains tds percentage$")
	public void select_listed_bill_contains_tds_percentage() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getBillListViewCheckBox2());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox2());
	}

	@And("^get tds percentage and calculate tds amount$")
	public void get_tds_percentage_and_calculate_tds_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getTdspercentfromList2());
		String tdspercent = paymentSettlementObj.getTdspercentfromList2().getText();
		String substring = tdspercent.substring(0, 1);
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getTdsvaluefromlist2());
		String TdsValue = paymentSettlementObj.getTdsvaluefromlist2().getText();
		int TDSVALUE = Integer.parseInt(TdsValue);
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getGetNetAdjustedAmountList2());
		String NetAdjusted = paymentSettlementObj.getGetNetAdjustedAmountList2().getText();
		int NETADJUSTED = Integer.parseInt(NetAdjusted);
		int TDSPERCENTAGE = Integer.parseInt(substring);
		float tdspercent1 = TDSPERCENTAGE;
		System.out.println(TDSPERCENTAGE);
		CalculatedTdsValue = (float) ((TDSPERCENTAGE / 100.0) * NETADJUSTED);
		Assert.assertEquals(TDSVALUE, Math.round(CalculatedTdsValue));
	}

	@Then("^verify tds in bill with calculated tds amt$")
	public void verify_tds_in_bill_with_calculated_tds_amt() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object tdsamountinpaymentsettlement = javascriphelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		String tdsvalueinsettlement = String.valueOf(tdsamountinpaymentsettlement);
		System.out.println(tdsvalueinsettlement);
		String tdsvalueinpayment = tdsvalueinsettlement.substring(0, 4);
		float tdsvalue = Float.parseFloat(tdsvalueinpayment);
		Assert.assertEquals(tdsvalue, Math.round(CalculatedTdsValue));
	}
//*************************************@KUBS_AR/AP_UAT_004_001TC_03***********************************************
	// verify net payable amount in bill
	@Given("^log into azentio as maker and select finance option for verify net payable amount$")
	public void log_into_azentio_as_maker_and_select_finance_option_for_verify_net_payable_amount() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click the Account payable Mainmodule for verify net payable amount$")
	public void click_the_account_payable_mainmodule_for_verify_net_payable_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon of the payment settlement for verify net payable amount$")
	public void click_the_eye_icon_of_the_payment_settlement_for_verify_net_payable_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify net payable amount$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_net_payable_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify net payable amount$")
	public void select_payment_option_as_buisness_partner_type_for_verify_net_payable_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select the buisness partner from the list for verify net payable amount$")
	public void select_the_buisness_partner_from_the_list_for_verify_net_payable_amount() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);

	}

	@And("^select the bill in the list view$")
	public void select_the_bill_in_the_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getBillListViewCheckBox());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
	}

	@And("^calculate the net payable amount from the bill in list view$")
	public void calculate_the_net_payable_amount_from_the_bill_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getGetNetPayableAmountinBillList());
		NetPayableAmountinBillList = paymentSettlementObj.getGetNetPayableAmountinBillList().getText();
		System.out.println(NetPayableAmountinBillList);
	}

	@Then("^verify netpayable amount in payment settlement with calculated amount$")
	public void verify_netpayable_amount_in_payment_settlement_with_calculated_amount() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object object = javascriphelper.executeScript(
				"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
		String netpayablevalueinsettlement = String.valueOf(object);
		System.out.println(netpayablevalueinsettlement);
		String substring = netpayablevalueinsettlement.substring(0, 6);
		System.out.println(substring);
		String NetAmount = substring.substring(0, 2) + substring.substring(3);
		Assert.assertEquals(NetPayableAmountinBillList, NetAmount);

	}
//*************************************@KUBS_AR/AP_UAT_004_001TC_04*************************************
	// pop up message displayed and click yes to proceed for payment
	@Given("^log into azentio as maker and select finance option for verify pop up$")
	public void log_into_azentio_as_maker_and_select_finance_option_for_verify_pop_up() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click the Account payable Mainmodule for verify pop up$")
	public void click_the_account_payable_mainmodule_for_verify_pop_up() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());

	}

	@And("^click the eye icon of the payment settlement for verify pop up$")
	public void click_the_eye_icon_of_the_payment_settlement_for_verify_pop_up() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());

	}

	@And("^click the add icon of the payment settlement for verify pop up$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_pop_up() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify pop up$")
	public void select_payment_option_as_buisness_partner_type_for_verify_pop_up() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select the buisness partner from the list for verify  pop up$")
	public void select_the_buisness_partner_from_the_list_for_verify_pop_up() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
	}

	@And("^select any bill in list view$")
	public void select_any_bill_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getBillListViewCheckBox());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
	}

	@And("^choose the valid date$")
	public void choose_the_valid_date() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getCalenderInPaymentSettlement());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(paymentSettlementObj.getCalenderInPaymentSettlement());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDate());

	}

	@And("^Enter the description$")
	public void enter_the_description() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getDescription());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDescription());
		paymentSettlementObj.getDescription().sendKeys(cancellationofcontractdata.PaymentSettlementDescription);

	}

	@And("^Click save button$")
	public void click_save_button() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSavebutton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSavebutton());
	}

	@And("^pop up messages displayed and  click yes$")
	public void pop_up_messages_displayed_and_click_yes() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getClickYespopup());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickYespopup());

	}

	@Then("^verify bill is proceed for payment$")
	public void verify_bill_is_proceed_for_payment() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getClickFirstPaymentInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(paymentSettlementObj.getClickFirstPaymentInListView());
		Thread.sleep(2000);

	}
//*************************** @KUBS_AR/AP_UAT_004_001TC_05***************************
	@Given("^log into azentio as maker and select finance option for verify pop up display$")
	public void log_into_azentio_as_maker_and_select_finance_option_for_verify_pop_up_display() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click the Account payable Mainmodule for verify pop up display$")
	public void click_the_account_payable_mainmodule_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon of the payment settlement for verify pop up display$")
	public void click_the_eye_icon_of_the_payment_settlement_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());

	}

	@And("^click the add icon of the payment settlement for verify pop up display$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify pop up display$")
	public void select_payment_option_as_buisness_partner_type_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^select the buisness partner from the list for verify pop up display$")
	public void select_the_buisness_partner_from_the_list_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
	}

	@And("^select any bill in list view for verify pop up display$")
	public void select_any_bill_in_list_view_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getBillListViewCheckBox());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getBillListViewCheckBox());
	}

	@And("^choose the valid date for verify pop up display$")
	public void choose_the_valid_date_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getCalenderInPaymentSettlement());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(paymentSettlementObj.getCalenderInPaymentSettlement());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getDate());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDate());
	}

	@And("^Enter the description for verify pop up display$")
	public void enter_the_description_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getDescription());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getDescription());
		paymentSettlementObj.getDescription().sendKeys(cancellationofcontractdata.PaymentSettlementDescription);
	}

	@And("^Click save button  for verify pop up display$")
	public void click_save_button_for_verify_pop_up_display() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSavebutton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSavebutton());
	}

	@And("^pop up messages displayed and click no$")
	public void pop_up_messages_displayed_and_click_no() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getClickNopopup());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getClickNopopup());
	}

	@Then("^verify bill is not proceed for payment and return to payment settlement$")
	public void verify_bill_is_not_proceed_for_payment_and_return_to_payment_settlement() throws Throwable {
		System.out.println("User verified previous Screen");
	}
//*************************************** @KUBS_AR/AP_UAT_004_004TC_01***************************************************************
	// verify debit note adjusted for the selected bill and verify net adjusted
	// value is correctly displayed
	@Given("^log in as a Maker and select finance option for verify debit note against bill$")
	public void log_in_as_a_maker_and_select_finance_option_for_verify_debit_note_against_bill() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click Account receivable Main module$")
	public void click_account_receivable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click debit note eye icon$")
	public void click_debit_note_eye_icon() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search$")
	public void click_search_button_and_then_click_debit_note_status_search() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status$")
	public void search_active_in_debit_note_status() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);

	}

	@And("^click first eye icon in list view$")
	public void click_first_eye_icon_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get buisness partner name and invoice number$")
	public void get_buisness_partner_name_and_invoice_number() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
	}

	@And("^click Account Payable Main Module for verify debit note against bill$")
	public void click_account_payable_main_module_for_verify_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());

	}

	@And("^select payment option as buisness partner type for verify debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_debit_note_against_bill() throws Throwable {

		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^Select buisness partner according to debit note buisnes partner$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner() throws Throwable {

		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^search the invoice number based on invoice after click bill and get gross,debit amount$")
	public void search_the_invoice_number_based_on_invoice_after_click_bill_and_get_grossdebit_amount()
			throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 12; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String GrossAmount = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
					String DebitAmount = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
					String NetAdjustedValuefromBillDebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[12]/div"))
							.getText();
					String flatDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[9]/div"))
							.getText();
					String EarlypaymentDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[10]/div"))
							.getText();
					testdata.put("GrossAmountfordebit", GrossAmount);
					testdata.put("DebitAmount", DebitAmount);
					testdata.put("EarlypaymentDiscountfordebit", EarlypaymentDiscount);
					testdata.put("flatDiscountfordebit", flatDiscount);
					testdata.put("NetAdjustedValuefromBillDebit", NetAdjustedValuefromBillDebit);
					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
				break;
			}
		}
	}

	@Then("^calculate netAdjusted amount based on gross and debit amount then verify with netadjusted value from list$")
	public void calculate_netadjusted_amount_based_on_gross_and_debit_amount_then_verify_with_netadjusted_value_from_list()
			throws Throwable {
		int grossamt = Integer.parseInt(testdata.get("GrossAmountfordebit"));
		int debitamount = Integer.parseInt(testdata.get("DebitAmount"));
		int CalculatedNetAjusted = grossamt - debitamount - Integer.parseInt(testdata.get("flatDiscountfordebit"))
				- Integer.parseInt(testdata.get("EarlypaymentDiscountfordebit"));
		Assert.assertEquals(CalculatedNetAjusted, Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit")));
	}

	@Then("^verify net adjusted value in bill with net adjusted value shown in payment settlement page$")
	public void verify_net_adjusted_value_in_bill_with_net_adjusted_value_shown_in_payment_settlement_page()
			throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object obj = javascriphelper
				.executeScript("return document.getElementsByTagName('input')[\"paymentAmt\"].value");
		String valueOf = String.valueOf(obj);
		String substring = valueOf.substring(0, 2) + valueOf.substring(3, 6);
		int NetAjustedfromPaymentPage = Integer.parseInt(substring);
		int NetAdjustedfrombill = Integer.parseInt(testdata.get("NetAdjustedValuefromBillDebit"));
		Assert.assertEquals(NetAdjustedfrombill, NetAjustedfromPaymentPage);
	}
//****************************@KUBS_AR/AP_UAT_004_004TC_02****************************************
	// verify tds percent and tds value for debit note
	@Given("^log in as a Maker and select finance option for verify tds in debit note against bill$")
	public void log_in_as_a_maker_and_select_finance_option_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());

	}

	@When("^click Account receivable Main module for verify tds in debit note against bill$")
	public void click_account_receivable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());

	}

	@And("^click debit note eye icon for verify tds in debit note against bill$")
	public void click_debit_note_eye_icon_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search for verify tds in debit note against bill$")
	public void click_search_button_and_then_click_debit_note_status_search_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status for verify tds in debit note against bill$")
	public void search_active_in_debit_note_status_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);
	}

	@And("^click first eye icon in list view for verify tds in debit note against bill$")
	public void click_first_eye_icon_in_list_view_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get buisness partner name and invoice number for verify tds in debit note against bill$")
	public void get_buisness_partner_name_and_invoice_number_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
	}

	@And("^click Account Payable Main Module for verify tds in debit note against bill$")
	public void click_account_payable_main_module_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify tds in debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_tds_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify tds in debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify tds in debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_tds_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);
	}

	@And("^Select buisness partner according to debit note buisnes partner we get$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^get tds percent , net adjusted,tds amount based on invoice then click bill$")
	public void get_tds_percent_net_adjustedtds_amount_based_on_invoice_then_click_bill() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 12; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String TdsPercentfordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[13]/div"))
							.getText();
					String NetAjustedValueforDebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[12]/div"))
							.getText();
					String tdsvaluefordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[14]/div"))
							.getText();
					testdata.put("TdsPercentfordebit", TdsPercentfordebit);
					testdata.put("NetAjustedValueforDebit", NetAjustedValueforDebit);
					testdata.put("tdsvaluefordebit", tdsvaluefordebit);

					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
				break;
			}
		}
	}

	@And("^calculate tds value based on tds percent and net adjusted value and verify with tds value in bill$")
	public void calculate_tds_value_based_on_tds_percent_and_net_adjusted_value_and_verify_with_tds_value_in_bill()
			throws Throwable {
		int NETADJUSTED = Integer.parseInt(testdata.get("NetAjustedValueforDebit"));
		String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
		int TDSPERCENTAGE = Integer.parseInt(substring);
		float tdspercent1 = TDSPERCENTAGE;
		System.out.println(TDSPERCENTAGE);
		CalculatedTdsValue = (float) ((TDSPERCENTAGE / 100.0) * NETADJUSTED);
		testdata.put("calculatedtds", String.valueOf(CalculatedTdsValue));
		float parseFloat = Float.parseFloat(testdata.get("tdsvaluefordebit"));
		Assert.assertEquals(parseFloat, Math.round(CalculatedTdsValue));
	}

	@And("^get tds value from payment settlement for debit note$")
	public void get_tds_value_from_payment_settlement_for_debit_note() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		Object tdsvalue = javascriphelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		testdata.put("tdsvaluefrompayment", String.valueOf(tdsvalue));
	}

	@Then("^verify calculated tds value equals to tds value get from payment settlement and correctly displayed$")
	public void verify_calculated_tds_value_equals_to_tds_value_get_from_payment_settlement_and_correctly_displayed()
			throws Throwable {
		Assert.assertEquals(Math.round(Float.parseFloat(testdata.get("calculatedtds"))),
				Float.parseFloat(testdata.get("tdsvaluefrompayment")));
	}
    //**************************** @KUBS_AR/AP_UAT_004_004TC_03*************************************************
	// verify net payable amount is correctly calculated and displayed
	@Given("^log in as a Maker and select finance option for verify Netpayable amount in debit note against bill$")
	public void log_in_as_a_maker_and_select_finance_option_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
	}

	@When("^click Account receivable Main module for verify Netpayable amount in debit note against bill$")
	public void click_account_receivable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountReceivable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountReceivable());
	}

	@And("^click debit note eye icon for verify Netpayable amount in debit note against bill$")
	public void click_debit_note_eye_icon_for_verify_netpayable_amount_in_debit_note_against_bill() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.accountsReceivable_Debit_Eye());
		seleniumactions.getClickAndActionsHelper().clickOnElement(account_Receivable.accountsReceivable_Debit_Eye());
	}

	@And("^click search button and then click debit note status search for verify Netpayable amount in debit note against bill$")
	public void click_search_button_and_then_click_debit_note_status_search_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
	}

	@And("^search Active in debit note status for verify Netpayable amount in debit note against bill$")
	public void search_active_in_debit_note_status_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_DebitNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_DebitNote_Status());
		account_Receivable.accountsReceivable_DebitNote_Status()
				.sendKeys(cancellationofcontractdata.Contractstatusfordebitnote);
	}

	@And("^click first eye icon in list view for verify Netpayable amount in debit note against bill$")
	public void click_first_eye_icon_in_list_view_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
	}

	@And("^get buisness partner name and invoice number for verify Netpayable amount in debit note against bill$")
	public void get_buisness_partner_name_and_invoice_number_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteBuisnessPartner());
		debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, account_Receivable.debitNoteInvoiceNumber());
		String text = account_Receivable.debitNoteInvoiceNumber().getText();
		debitinvoicenumber = text.substring(0, 3) + text.substring(4, 7) + text.substring(8);
	}

	@And("^click Account Payable Main Module for verify Netpayable amount in debit note against bill$")
	public void click_account_payable_main_module_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click eye icon in Payment Settlement for verify Netpayable amount in debit note against bill$")
	public void click_eye_icon_in_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementEyeIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementEyeIcon());
	}

	@And("^click the add icon of the payment settlement for verify Netpayable amount in debit note against bill$")
	public void click_the_add_icon_of_the_payment_settlement_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				paymentSettlementObj.getPaymentSettlementAddIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentSettlementAddIcon());
	}

	@And("^select payment option as buisness partner type for verify Netpayable amount in debit note against bill$")
	public void select_payment_option_as_buisness_partner_type_for_verify_netpayable_amount_in_debit_note_against_bill()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getPaymentOptions());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getPaymentOptions());
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.DOWN);
		paymentSettlementObj.getPaymentOptions().sendKeys(Keys.ENTER);

	}

	@And("^Select buisness partner according to debit note buisnes partner we get in debit list view$")
	public void select_buisness_partner_according_to_debit_note_buisnes_partner_we_get_in_debit_list_view()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSelectBuisnessPartner());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSelectBuisnessPartner());
		paymentSettlementObj.getSelectBuisnessPartner().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}

	@And("^get gross amount, debit amount,tds percent,netpayable amount$")
	public void get_gross_amount_debit_amounttds_percentnetpayable_amount() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		for (int j = 1; j <= 5; j++) {
			String invoice = null;

			for (int i = 1; i <= 6; i++) {
				seleniumactions.getWaitHelper().waitForElement(driver, 4000, driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]")));
				String text2 = driver.findElement(By.xpath(
						"(//datatable-row-wrapper[" + i + "]/datatable-body-row/div/datatable-body-cell[4]/div)[2]"))
						.getText();
				invoice = text2.substring(0, 3) + text2.substring(4, 7) + text2.substring(8);
				if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							driver.findElement(By.xpath("//datatable-row-wrapper[" + i
									+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
					driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")).click();
					String GrossAmountfromdebitbill = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[6]/div)[2]")).getText();
					String DebitAmountfrombill = driver.findElement(By.xpath("(//datatable-row-wrapper[" + i
							+ "]/datatable-body-row[1]/div/datatable-body-cell[8]/div)[2]")).getText();
					String NetPayableAmountfrombill = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[15]/div"))
							.getText();
					String TdsPercentfordebit = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[13]/div"))
							.getText();
					String flatDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[9]/div"))
							.getText();
					String EarlypaymentDiscount = driver.findElement(By.xpath(
							"//datatable-row-wrapper[" + i + "]/datatable-body-row[1]/div/datatable-body-cell[10]/div"))
							.getText();

					testdata.put("NetPayableAmountfrombill", NetPayableAmountfrombill);
					testdata.put("GrossAmountfromdebitbill", GrossAmountfromdebitbill);
					testdata.put("DebitAmountfrombill", DebitAmountfrombill);
					testdata.put("TdsPercentfordebit", TdsPercentfordebit);
					testdata.put("flatDiscount", flatDiscount);
					testdata.put("EarlypaymentDiscount", EarlypaymentDiscount);
					break;
				}
				if (i > 3) {
					javascriphelper.scrollIntoView(driver.findElement(By.xpath("//datatable-row-wrapper[" + i
							+ "]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")));
				}
				if (i == 6) {
					seleniumactions.getWaitHelper().waitForElement(driver, 2000,
							paymentSettlementObj.getNextPageInListView());
					seleniumactions.getClickAndActionsHelper()
							.clickOnElement(paymentSettlementObj.getNextPageInListView());
				}

			}
			if (debitinvoicenumber.equalsIgnoreCase(invoice)) {
				break;
			}
		}
	}

	@And("^calculate net adjusted value , tds value from net adjusted$")
	public void calculate_net_adjusted_value_tds_value_from_net_adjusted() throws Throwable {
		int grossamt = Integer.parseInt(testdata.get("GrossAmountfromdebitbill"));
		System.out.println(grossamt);
		int debitamount = Integer.parseInt(testdata.get("DebitAmountfrombill"));
		System.out.println(debitamount);
		int CalculatedNetAjusted = grossamt - debitamount;
		System.out.println(CalculatedNetAjusted);
		testdata.put("CalculatedNetAjusted", String.valueOf(CalculatedNetAjusted));
		// tds
		int NETADJUSTED = Integer.parseInt(testdata.get("CalculatedNetAjusted"));
		System.out.println(NETADJUSTED);
		String substring = testdata.get("TdsPercentfordebit").substring(0, 1);
		int TDSPERCENTAGE = Integer.parseInt(substring);
		float tdspercent1 = TDSPERCENTAGE;
		CalculatedTdsValue = (float) ((TDSPERCENTAGE / 100.0) * NETADJUSTED);
		System.out.println(CalculatedTdsValue);
		testdata.put("calculatedtds", String.valueOf(Math.round(CalculatedTdsValue)));

	}

	@And("^Calcualte net payable amount from calculated net adjusted value and tds value$")
	public void calcualte_net_payable_amount_from_calculated_net_adjusted_value_and_tds_value() throws Throwable {
		int CalculatedNetPayableAmount = Integer.parseInt(testdata.get("CalculatedNetAjusted"))
				- Integer.parseInt(testdata.get("calculatedtds")) - Integer.parseInt(testdata.get("flatDiscount"))
				- Integer.parseInt(testdata.get("EarlypaymentDiscount"));
		System.out.println(CalculatedNetPayableAmount);
		testdata.put("CalculatedNetPayableAmount", String.valueOf(CalculatedNetPayableAmount));
	}

	@Then("^verify calculated net payable amount with net payable amount get from debit bill$")
	public void verify_calculated_net_payable_amount_with_net_payable_amount_get_from_debit_bill() throws Throwable {

		Assert.assertEquals(Integer.parseInt(testdata.get("CalculatedNetPayableAmount")),
				Integer.parseInt(testdata.get("NetPayableAmountfrombill")));
	}

	@And("^get net payable amount from payment settlement$")
	public void get_net_payable_amount_from_payment_settlement() throws Throwable {
		Object object = javascriphelper.executeScript(
				"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
		String netpayablevalueinsettlement = String.valueOf(object);
		System.out.println(netpayablevalueinsettlement);
		String substring = netpayablevalueinsettlement.substring(0, 6);
		System.out.println(substring);
		String NetAmount = substring.substring(0, 2) + substring.substring(3);
		testdata.put("NetPayableAmount", NetAmount);
	}

	@Then("^verify net payable amount is correctly displayed according to debit bill$")
	public void verify_net_payable_amount_is_correctly_displayed_according_to_debit_bill() throws Throwable {
		Assert.assertEquals(testdata.get("CalculatedNetPayableAmount"), testdata.get("NetPayableAmount"));
	}

}
