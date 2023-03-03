package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class AR_AP extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
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
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);


	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_InvoiceBoooking", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	

    @And("^Update the data set id for creating Bill against cancelled GRN$")
    public void update_the_data_set_id_for_creating_bill_against_cancelled_grn() throws Throwable {
    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_003_003_TC_05_D1"); 
    }

	@And("^Enter the GRN status$")
	public void enter_the_grn_status() throws Throwable {
		// ---------ENTER THE STATUS-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GRNStatus());
		arapObj.ARAP_GRNStatus().click();
		arapObj.ARAP_GRNStatus().sendKeys(testData.get("GRNStatus"));
	}
	
	
	@And("^Get the Required Details$")
	public void get_the_required_details() throws Throwable {
		// --------GET BUSINESS PARTNER DETAILS-----------//
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetPoNumber());
		BPNumber = arapObj.ARAP_GetPoNumber().getText();
		System.out.println(BPNumber);

		// --------GET THE GRN NUMBER DETAILS---------//
		javaScriptHelper.JavaScriptHelper(driver);
		GRNNO = (String) javaScriptHelper.executeScript(" return document.getElementsByName('grnNumber')[1].value");
		System.out.println(GRNNO);

		// --------GET INVOICE NUMBER DETAILS----------//
		javaScriptHelper.JavaScriptHelper(driver);
		InvoiceNo = (String) javaScriptHelper
				.executeScript(" return document.getElementsByName('billNumber')[1].value");
		System.out.println(InvoiceNo);
	}
	
	@Then("^Click on Item Details$")
	public void click_on_item_details() throws Throwable {
		// ---------CLICK ON ITEM DETAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ItemDetails());
		arapObj.ARAP_ItemDetails().click();
		Thread.sleep(2000);
	}
	
	@And("^Get PO Number$")
	public void get_po_number() throws Throwable {
		// ---------GET PO NUMBER------------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetPoNumber());
		PoNumber = arapObj.ARAP_GetPoNumber().getText();
		System.out.println(PoNumber);
	}
	@Then("^Open Invoice Bill Booking Eye icon$")
	public void open_invoice_bill_booking_eye_icon() throws Throwable {
		// --------CLICK BILL BOOKING EYE ICON---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceEye());
		arapObj.ARAP_InvoiceEye().click();
	}

	@And("^Click Add icon button$")
	public void click_add_icon_button() throws Throwable {
		// -------CLICK ON ADD ICON--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceAdd());
		arapObj.ARAP_InvoiceAdd().click();
	}

	@Then("^Enter the Invoice Type$")
	public void enter_the_invoice_type() throws Throwable {
		// -------ENTER THE INVOICE TYPE--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceType());
		arapObj.ARAP_InvoiceType().click();
		arapObj.ARAP_InvoiceType().sendKeys(testData.get("InvoiceType"));
		arapObj.ARAP_InvoiceType().sendKeys(Keys.ENTER);
	}
	@And("^Enter Business Partner Name$")
	public void enter_business_partner_name() throws Throwable {
		// -------ENTER THE BUSINESS PARTNER--------//
		waitHelper.waitForElementVisible(arapObj.ARAP_InvoiceSubType(), 3000, 3000);
		arapObj.ARAP_InvoiceSubType().click();
		arapObj.ARAP_InvoiceSubType().sendKeys(BPNumber);
		arapObj.ARAP_InvoiceSubType().sendKeys(Keys.ENTER);

	}
	
	@Then("^Enter Cost Center value$")
	public void enter_cost_center_value() throws Throwable {
		// -------ENTER COST CENTER VALUE---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveCostCenter());
		arapObj.ARAP_GiveCostCenter().click();
		arapObj.ARAP_GiveCostCenter().sendKeys(testData.get("Cost Center"));
		arapObj.ARAP_GiveCostCenter().sendKeys(Keys.ENTER);
	}
	
	@And("^Enter Supplier Referance Number$")
	public void enter_supplier_referance_number() throws Throwable {
		// ---------ENTER SUPPLIER REF NO---------//
//		Random random = new Random();
//		int randNum=random.nextInt(1000-500)+500;
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GivesupplierRefno());
		arapObj.ARAP_GivesupplierRefno().click();
		
		int min=1000;
		int max=100000;
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    String suplierReferenceNumber=testData.get("SuplierName")+random_int;
		arapObj.ARAP_GivesupplierRefno().sendKeys(suplierReferenceNumber);
	}
	
	@And("^Enter Flat Discount Invoice Amount$")
	public void enter_flat_discount_invoice_amount() throws Throwable {
		// -------ENTER INVOICE AMOUNT-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveflatDiscount());
		arapObj.ARAP_GiveflatDiscount().click();
		arapObj.ARAP_GiveflatDiscount().sendKeys(testData.get("Discount"));
	}
	@Then("^Give Mode of payment$")
	public void give_mode_of_payment() throws Throwable {
		// --------GIVE MODE OF PAYMENT----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GiveModeofPayment());
		arapObj.ARAP_GiveModeofPayment().click();
		arapObj.ARAP_GiveModeofPayment().sendKeys(testData.get("Mode of Payment"));
		arapObj.ARAP_GiveModeofPayment().sendKeys(Keys.ENTER);
	}
	

	@And("^Save the Invoice Bill Record$")
	public void save_the_invoice_bill_record() throws Throwable {
		// --------SAVE THE RECORD--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceSave());
		arapObj.ARAP_InvoiceSave().click();
//		javaScriptHelper.JavaScriptHelper(driver);
//		for (int i = 0; i <=200; i++) {
//			try {
//				String str = javaScriptHelper.executeScript(
//						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//						.toString();
//				System.out.println("Message:" + str);  
//				break;
//			} catch (Exception e) {
//				if (i==200) {
//					Assert.fail(e.getMessage());
//				}
//			}
//		}
//		
		for(int i=1; i<=20; i++) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.MessageContent());
		String mssg =aCCOUNTSPAYABLE_VendorContractsObj.MessageContent().getText();
		System.out.println(mssg);
		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
		aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
		break;
			}
			catch(Exception e) {}
		}
		Thread.sleep(1000);
		for(int i=1; i<=15; i++) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.MessageContent());
		String mssg =aCCOUNTSPAYABLE_VendorContractsObj.MessageContent().getText();
		System.out.println(mssg);
		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
		aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
		break;
			}
			catch(Exception e) {}
		}
//		Thread.sleep(1000);
//		for(int i=1; i<=15; i++){
//			try {
//				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.MessageContent());
//		String mssg =aCCOUNTSPAYABLE_VendorContractsObj.MessageContent().getText();
//		System.out.println(mssg);
//		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
//		break;
//			}
//			catch(Exception e) {}
//		}
	}

	@Then("^Goto The Notification Icon$")
	public void goto_the_notification_icon() throws Throwable {

		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_MakerNotification());
		arapObj.ARAP_MakerNotification().click();
	}
	
	@And("^Store the Referance Id and Open the Record$")
	public void store_the_referance_id_and_open_the_record() throws Throwable {
		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}
	
	@Then("^Click on AP Invoice Against PO Tab$")
	public void click_on_ap_invoice_against_po_tab() throws Throwable {
		// -----------CLICK ON AGAINST PO TAB----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_APInvoiceAgainstPO());
		arapObj.ARAP_APInvoiceAgainstPO().click();
	}
	
	@And("^Enter The PO Number and Validate$")
	public void enter_the_po_number_and_Validate() throws Throwable {
		// ----------GIVE THE PO NUMBER-------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_PoNumber());
		arapObj.ARAP_PoNumber().click();
		arapObj.ARAP_PoNumber().sendKeys(PoNumber);
		arapObj.ARAP_PoNumber().sendKeys(Keys.ENTER);
		try {
			arapObj.InvoiceBooking_GRN_Number().isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("THE CANCELLATION GRN IS NOT ALLOWED");
		}
	}
	
	
	//--------------------------//
	
	 @And("^Update the data set id for GRN cancellation is not allowed if Bill has been approved$")
	    public void update_the_data_set_id_for_grn_cancellation_is_not_allowed_if_bill_has_been_approved() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR_AP_UAT_003_003_TC_06_D1"); 
	    }
	@And("^Enter the Invoice Bill Booking status$")
	public void enter_the_invoice_bill_booking_status() throws Throwable {
		// --------------BILL BOOKING STATUS--------------//
		
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceTypeSearch());
		arapObj.ARAP_InvoiceTypeSearch().click();
		arapObj.ARAP_InvoiceTypeSearch().sendKeys(testData.get("InvoiceType"));
		Thread.sleep(1500); 
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceNumber());
		arapObj.ARAP_InvoiceNumber().click();
		arapObj.ARAP_InvoiceNumber().sendKeys(testData.get("InvoiceNumber"));
		

		/*ARAP_InvoiceNumber
		 * javaScriptHelper.JavaScriptHelper(driver);
		 * javaScriptHelper.scrollIntoView(arapObj.ARAP_InvoiceStatus());
		 * waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceStatus());
		 * arapObj.ARAP_InvoiceStatus().click();
		 * arapObj.ARAP_InvoiceStatus().sendKeys(arapData.GRNStatus);
		 */
	}
	
	@And("^Store the Business partner Value$")
	public void store_the_business_partner_value() throws Throwable {
		// ------------STORE THE VALUES-----------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_GetcancelBpName(), 10, 1);
//		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_GetcancelBpName());
		BPNumber = arapObj.ARAP_GetcancelBpName().getText();
		System.out.println(BPNumber);
	}
	
	@And("^Get the Required Number$")
	public void get_the_required_number() throws Throwable {
		// ----------GET THE DETAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.InvoiceBooking_GRN_Number());
		GRNNO = arapObj.InvoiceBooking_GRN_Number().getText();
		System.out.println(GRNNO);
	}
	@And("^Click On Main module Accounts payable$")
	public void click_on_main_module_accounts_payable() throws Throwable {
		// ---------CLICK ON ACCOUNTS PAYABLE MODULE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Accountspayable());
		arapObj.ARAP_Accountspayable().click();
	}
	@Then("^Open the Adjustment ARAP module$")
	public void open_the_adjustment_arap_module() throws Throwable {
		// ----------adjustment ARAP---------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustment_ARAP());
		arapObj.adjustment_ARAP().click();
	}
	@And("^Click on Adjustment ARAP Eye Icon$")
	public void click_on_adjustment_arap_eye_icon() throws Throwable {
		// -----------ADJUSTMENT ARAP-------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentViewButton());
		arapObj.adjustmentViewButton().click();
	}
	
	@Then("^Give The Business Partner$")
	public void give_the_business_partner() throws Throwable {
		// ----------BUSINESS PARTNER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentBpName());
		arapObj.adjustmentBpName().click();
		arapObj.adjustmentBpName().sendKeys(BPNumber);
		arapObj.adjustmentBpName().sendKeys(Keys.ENTER);
	}
	@And("^Give The Adjustment Type$")
	public void give_the_adjustment_type() throws Throwable {
		// -----------ADJUSTMENTS TYPE-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentadjustmentType());
		arapObj.adjustmentadjustmentType().sendKeys(Keys.DOWN);
		arapObj.adjustmentadjustmentType().sendKeys(Keys.ENTER);
	}

	@Then("^Enter the Adjustment Item Type$")
	public void enter_the_adjustment_item_type() throws Throwable {
		// ----------ADJUSTMENTS ITEM TYPE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(testData.get("AdjustmentType"));
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);

	}

	@And("^Enter the Adjustment Ref No and Validate$")
	public void enter_the_adjustment_ref_no_and_validate() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(GRNNO);

		try {
			waitHelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("The Approved Invoice Bill Record GRN is Not Allowed to Cancellation");
		}

	}
}
