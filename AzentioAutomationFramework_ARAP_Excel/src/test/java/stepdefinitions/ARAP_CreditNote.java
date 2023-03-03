package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_ContractReportPageObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.REPORT_ACCOUNTSPAYABLEREPORTObj;
import resources.BaseClass;
import resources.ExcelData;


public class ARAP_CreditNote extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActions = new ClicksAndActionsHelper(driver);
	Map<String, String> invoiceBookingTestData = new HashMap<>();
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj crediteNoteObj = new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	String invoiceAmmount;
    INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	REPORT_ACCOUNTSPAYABLEREPORTObj accountsPayableReportObj = new REPORT_ACCOUNTSPAYABLEREPORTObj(driver);
	ACCOUNTSPAYABLE_AccountsPayableReportObj payableReportObj=new ACCOUNTSPAYABLE_AccountsPayableReportObj(driver);
	ACCOUNTSPAYABLE_ContractReportPageObj contractReportObj = new ACCOUNTSPAYABLE_ContractReportPageObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper=new BrowserHelper(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	// ClicksAndActionsHelper clickAndActionHelper=new
	// ClicksAndActionsHelper(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_CreditNote", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^user update the data set ID for Invoice against Expense$")
    public void user_update_the_data_set_id_for_invoice_against_expense() throws Throwable {
    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_004_005_TC_01_01_D1");   
    }

	


	@And("^fill the mendatory field for invoice booking for expenseType invoice$")
	public void fill_the_mendatory_field_for_invoice_booking_for_expensetype_invoice() throws Throwable {
		Random rand= new Random();
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

		invoiceBookingObj.billBookingExpenceBpName().click();
		invoiceBookingObj.billBookingExpenceBpName().sendKeys(testData.get("BusinessPartnerName"));
		Thread.sleep(1000);	
		invoiceBookingObj.billBookingExpenceBpName().sendKeys(Keys.ENTER);

		invoiceBookingObj.billBookingExpenceSuplierName().click();
		int min=1000;
		int max=100000;
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    String suplierReferenceNumber=testData.get("SuplierName")+random_int;
		invoiceBookingObj.billBookingExpenceSuplierName().sendKeys(suplierReferenceNumber);

		invoiceBookingObj.billBookingExpenceFlatDiscount().click();
		invoiceBookingObj.billBookingExpenceFlatDiscount().sendKeys(testData.get("FlatDiscount"));

		invoiceBookingObj.billBookingExpenceDiscountType().click();
		invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);
		
		clickAndActionHelper.moveToElement(invoiceBookingObj.billBookingExpenceDiscountPercent());
		invoiceBookingObj.billBookingExpenceDiscountPercent().click();
		invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys(testData.get("FlatDiscountPercent"));

		clickAndActionHelper.moveToElement(invoiceBookingObj.billBookingExpencePaymentMode());
		invoiceBookingObj.billBookingExpencePaymentMode().click();
		invoiceBookingObj.billBookingExpencePaymentMode().sendKeys(testData.get("ModeOfPayment"));
		invoiceBookingObj.billBookingExpencePaymentMode().sendKeys(Keys.ENTER);

		clickAndActionHelper.moveToElement(invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton());
		invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
		while (true) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
				String mssg = accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
				System.out.println(mssg);
				waitHelper.waitForElementwithFluentwait(driver,accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
				accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
				break;
				} catch (Exception e) {
				}
			}
	}
	
	
	@And("^goto invoice bill booking temp view and select the record$")
	public void goto_invoice_bill_booking_temp_view_and_select_the_record() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingTempView(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingTempView().click();
		Thread.sleep(2000);
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingRecord(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingRecord().click();
	}
	
	@And("^fill the second tab for expencess details$")
	public void fill_the_second_tab_for_expencess_details() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				waitHelper.waitForElementVisible(
						invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
				invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
				waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode(), 2000,
						100);
				invoiceBookingObj.accountPayable_InvoiceBooking_ExpenseCode().click();
				waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingExpenceExpense11Code(),
						2000, 100);
				invoiceBookingObj.accountPayableIvoiceBookingExpenceExpense11Code().click();
				
				waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK(),
						2000, 100);
				invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK().click();
				
				

				break;
			} catch (StaleElementReferenceException e) {

			}
		}
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceQuantity()
				.sendKeys(testData.get("InvoiceQuantity"));
		invoiceBookingObj.accountPayable_InvoiceBooking_Unit().click();
		try {
			invoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
		} catch (StaleElementReferenceException e) {
			invoiceBookingObj.accountPayable_InvoiceBooking_UnitBoxes().click();
		}
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK(),
				2000, 100);
		invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK().click();
		
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().click();
		invoiceAmmount = invoiceBookingObj.billBookingExpenceInvoiceAmmount().getText();
		invoiceBookingTestData.put("InvoiceAmmount", invoiceAmmount);
		// invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit().clear();
		invoiceBookingObj.accountPayable_InvoiceBooking_RatePerUnit()
				.sendKeys(testData.get("InvoiceRatePerUnitQuantity"));

		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_ShippedFromLocation().click();
		
		Thread.sleep(1500);
		invoiceBookingObj.accountPayableIvoiceBookingDeleveryLocationPunjab().click();
		
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK(),
				2000, 100);
		invoiceBookingObj.accountPayable_invoiceBookingExpenceExpenceCode_OK().click();
		
		

		invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		while (true) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
				String mssg = accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
				System.out.println(mssg);
				waitHelper.waitForElementwithFluentwait(driver,accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
				accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
				break;
				} catch (Exception e) {
				}
			}

		// Thread.sleep(5000);
	}
	
	 @Then("^store the Reference ID and open the invoice booking record$")
	    public void store_the_reference_id_and_open_the_invoice_booking_record() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
			String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
			
			excelData.updateTestData("KUBS_AR_AP_UAT_004_005_TC_01_02_D1", "ReferenceID", Reference_Id);
			
			System.out.println("ReferenceID:" +Reference_Id);
			
			for (int i = 1; i <=199; i++) {
				try {
					waitHelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton().click();
			 
	    	break;
				}
				catch(Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
				}  
	    }

	    @Then("^click submit and enter remark for invoice booking$")
	    public void click_submit_and_enter_remark_for_invoice_booking() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
	    	
//	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	    	javascriptHelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
			
//	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
	    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
	    	
//	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	    	clicksAndActions.moveToElement(recordstatus);
	    	
	    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	    	System.out.println(message);
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	    	String emptystring = "";
			String ar[] = message.split(" ");
			emptystring=ar[ar.length-1];
			String reviewerId=emptystring.replaceAll("[/.]", "");
			System.out.println(reviewerId);
//			jsonWriter=new JsonDataReaderWriter();
//			jsonWriter.addData(reviewerId);
			excelData.updateTestData("KUBS_AR_AP_UAT_004_005_TC_01_02_D1", "ReviewerID", reviewerId);   
		  
	    }
	    
	    @And("^user update the data set ID for Invoice against Expense reviewer$")
	    public void user_update_the_data_set_id_for_invoice_against_expense_reviewer() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_004_005_TC_01_02_D1");   
	    }

	    @And("^User login as a reviewer user for Invoice against Expense$")
	    public void user_login_as_a_reviewer_user_for_invoice_against_expense() throws Throwable {
	    	login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	    }
	    
	    @And("^approve the record by reviewer for Invoice against Expense$")
	    public void approve_the_record_by_reviewer_for_invoice_against_expense() throws Throwable {
	    	browserHelper = new BrowserHelper(driver);
			String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
			Thread.sleep(1000);
			for (int i = 1; i < 35; i++) {
				
				try {
					waitHelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
					WebElement referanceID = driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
					referanceID.click();
					Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waitHelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

					kubschecker.checker_notification_next_button().click();
				}
			}
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			waitHelper.waitForElement(driver, 5000,
					driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

			
			waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
					waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer1());
	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer1().click();
			
	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer1());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer1().sendKeys(testData.get("ReviewerAlertRemark"));
//					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//					Thread.sleep(2000);
					waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			    	clickAndActionHelper.moveToElement(recordstatus);
			    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			    	System.out.println(message);
			    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		
		
	    }
	    
	    @And("^Click on claim for Invoice against Expense$")
	    public void click_on_claim_for_invoice_against_expense() throws Throwable {
	    	//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			for(int i=1; i<=10; i++) {
				try {
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	    
			break;
				}
				catch(Exception e) {}}
	    }
	    @Then("^checker should approved the record for Invoice against Expense$")
	    public void checker_should_approved_the_record_for_invoice_against_expense() throws Throwable {
	    	Thread.sleep(2000);
	    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    		for (int i = 1; i <= 35; i++) {
	    			try {
//	    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
	    				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
	    			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
	    			referanceID.click();
	    			Assert.assertTrue(referanceID.isDisplayed());
	    			break;
	    			} catch (NoSuchElementException e) {
	    				waitHelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
	    				kubschecker.checker_notification_next_button().click();
	    				}
	    	    }
	    			String before_xpath="//span[contains(text(),'";
	    			String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	    			 
//	    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
	    			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
	    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
	    			
	    		
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
	    			waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
	    		kubschecker.checkerApproveButton().click();
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    		waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks2());
	    		kubschecker.checkerRemarks2().sendKeys(testData.get("CheckerAlertRemark"));
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    		waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
	    		kubschecker.checkersubmitButton().click();
//	    		Thread.sleep(2000);
	    		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	        	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	        	clickAndActionHelper.moveToElement(recordstatus);
	        	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	        	System.out.println(message);
	        	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	    	
	    }
	    
	    @And("^select the approved record from invoice bill booking$")
		public void select_the_approved_record_from_invoice_bill_booking() throws Throwable {
			// waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(),
			// 2000, 100);
			Thread.sleep(1000);
			String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
			String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
			invoiceBookingTestData.put("approvedInvoiceNumber", approvedInvoiceNumber);
			invoiceBookingTestData.put("approvedBpName", approvedBpName);

		}
	    
	    @And("^goto accouts receivable module$")
		public void goto_accouts_receivable_module() throws Throwable {
			javascriptHelper.JavaScriptHelper(driver);
			// waitHelper.waitForElementVisible(makerObj.kubsAccountsReceivable(), 2000,
			// 100);
			// makerObj.kubsDirectionIcon().click();
			javascriptHelper.scrollIntoView(makerObj.kubsAccountsReceivable());
			makerObj.kubsAccountsReceivable().click();
		}

		@And("^goto credit notet module$")
		public void goto_credit_notet_module() throws Throwable {
			javascriptHelper.JavaScriptHelper(driver);
			javascriptHelper.scrollIntoView(crediteNoteObj.accountsReceivableViewButton());
			// waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableViewButton(),
			// 2000, 100);
			crediteNoteObj.accountsReceivableViewButton().click();
		}
		
		@And("^Fill the form for credit note$")
		public void fill_the_form_for_credit_note() throws Throwable {
			javascriptHelper.JavaScriptHelper(driver);
			waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableReceivableName(), 2000, 100);
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
			crediteNoteObj.accountsReceivableDescription().sendKeys(testData.get("CreditRemark"));
			waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivablleSaveButton(), 2000, 100);
			clickAndActionHelper.doubleClick(crediteNoteObj.accountsReceivablleSaveButton());
			//crediteNoteObj.accountsReceivablleSaveButton().click();

		}

		 @Then("^store the Reference ID and open the credit note record$")
		    public void store_the_reference_id_and_open_the_credit_note_record() throws Throwable {
			 waitHelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
				String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
				
				excelData.updateTestData("KUBS_AR_AP_UAT_004_005_TC_01_04_D1", "ReferenceID", Reference_Id);
				
				System.out.println("ReferenceID:" +Reference_Id);
				
				for (int i = 1; i <=199; i++) {
					try {
						waitHelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton());
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton().click();
				 
		    	break;
					}
					catch(Exception e) {
						if (i==199) {
							Assert.fail(e.getMessage());
						}
					}
					}
		    }

		    @Then("^click submit and enter remark for credit note$")
		    public void click_submit_and_enter_remark_for_credit_note() throws Throwable {
		    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
		    	
//		    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		    	javascriptHelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
				
//		    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
		    	
//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		    	clicksAndActions.moveToElement(recordstatus);
		    	
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		    	String emptystring = "";
				String ar[] = message.split(" ");
				emptystring=ar[ar.length-1];
				String reviewerId=emptystring.replaceAll("[/.]", "");
				System.out.println(reviewerId);
//				jsonWriter=new JsonDataReaderWriter();
//				jsonWriter.addData(reviewerId);
				excelData.updateTestData("KUBS_AR_AP_UAT_004_005_TC_01_04_D1", "ReviewerID", reviewerId);   
			  
		    }
		    
		    @And("^user update the data set ID for credit note reviewer$")
		    public void user_update_the_data_set_id_for_credit_note_reviewer() throws Throwable {
		    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_004_005_TC_01_04_D1");
		    }

		    @And("^User login as a reviewer user for for credit note$")
		    public void user_login_as_a_reviewer_user_for_for_credit_note() throws Throwable {
		    	login = new KUBS_Login(driver);
				driver.get(config.getApplicationUrl());
				login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
		    }
		    @And("^approve the record by reviewer for credit note$")
		    public void approve_the_record_by_reviewer_for_credit_note() throws Throwable {
		    	browserHelper = new BrowserHelper(driver);
				String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
				Thread.sleep(1000);
				for (int i = 1; i < 35; i++) {
					
					try {
						waitHelper.waitForElement(driver, 3000, driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
						WebElement referanceID = driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
						referanceID.click();
						Assert.assertTrue(referanceID.isDisplayed());
						break;
					} catch (NoSuchElementException e) {
						waitHelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

						kubschecker.checker_notification_next_button().click();
					}
				}
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

				waitHelper.waitForElement(driver, 5000,
						driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

				
				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
						waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
				
		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//						waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//						Thread.sleep(2000);
						waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
				    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
				    	clickAndActionHelper.moveToElement(recordstatus);
				    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
				    	System.out.println(message);
				    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			
			
		    }
		    @And("^Click on claim for for credit note$")
		    public void click_on_claim_for_for_credit_note() throws Throwable {
		    	//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
		    	String before_xpath = "//span[contains(text(),'";
				String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
				//String after_xpath = ;
				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
				Thread.sleep(1000);
				for(int i=1; i<=10; i++) {
					try {
				driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
		    
				break;
					}
					catch(Exception e) {}}
		    }
		    @Then("^checker should approved the record for credit note$")
		    public void checker_should_approved_the_record_for_credit_note() throws Throwable {
		    	Thread.sleep(2000);
		    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
		    		for (int i = 1; i <= 35; i++) {
		    			try {
//		    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
		    				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
		    			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
		    			referanceID.click();
		    			Assert.assertTrue(referanceID.isDisplayed());
		    			break;
		    			} catch (NoSuchElementException e) {
		    				waitHelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
		    				kubschecker.checker_notification_next_button().click();
		    				}
		    	    }
		    			String before_xpath="//span[contains(text(),'";
		    			String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		    			 
//		    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		    			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
		    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
		    			
		    		
//		    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		    			waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		    		kubschecker.checkerApproveButton().click();
//		    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		    		waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		    		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//		    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		    		waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		    		kubschecker.checkersubmitButton().click();
//		    		Thread.sleep(2000);
		    		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		        	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		        	clickAndActionHelper.moveToElement(recordstatus);
		        	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		        	System.out.println(message);
		        	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		    	
		    }
		    
		    @And("^Go to payment settlement module$")
			public void go_to_payment_settlement_module() throws Throwable {
		    	clickAndActionHelper.moveToElement(paymentSettlementObj.accountsPayablePayementSettlementViewIcon());
				waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementViewIcon(), 1000, 100);
				paymentSettlementObj.accountsPayablePayementSettlementViewIcon().click();
				Thread.sleep(1000);

			}
		    
		    @And("^fill the mendatory field to check the the net payable ammount$")
			public void fill_the_mendatory_field_to_check_the_the_net_payable_ammount() throws Throwable {
				javascriptHelper.JavaScriptHelper(driver);
				waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000,
						100);
				paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
				paymentSettlementObj.accountsPayablePayementSettlementPaymentOption()
						.sendKeys(testData.get("PaymentOption"));
				paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
				paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
				paymentSettlementObj.accountsPayablePayementSettlementBpNAme()
						.sendKeys(testData.get("approvedBpName"));
				paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				// div[contains(text(),'ADV_36_2422022')]
				for (int i = 1; i <= 30; i++) {
					Thread.sleep(1000);
					if (i == 30) {
						System.out.println("Data not available");
						clickAndActionHelper.moveToElement(driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
						javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
						
						System.out.println("Approved record we search " + testData.get("approvedInvoiceNumber"));
						Assert.fail("Data not available");
					}
					try {

						waitHelper.waitForElementVisible(driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")), 2000,
								100);
						clickAndActionHelper.moveToElement(driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
						javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
								"//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
						boolean finalStatus = driver.findElement(By
								.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]"))
								.isDisplayed();
						Assert.assertTrue(finalStatus);
						waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"
								+ testData.get("approvedInvoiceNumber")
								+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
								5000, 100);
						driver.findElement(By.xpath("//div[contains(text(),'"
								+ testData.get("approvedInvoiceNumber")
								+ "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
								.click();
						javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableAdjustedAmmount());
						String adjustedAmmount = javascriptHelper.executeScript(
								"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value")
								.toString();
						System.out.println("Adjusted ammount : " + adjustedAmmount);
						String ammount = adjustedAmmount.replace(".", "-");
						String[] Ammount = ammount.split("-");
						System.out.println("Ammount is" + Ammount[0]);

						String ammountFull = Ammount[0];

						String finalAmmount = ammountFull.replaceAll(",", "");
						int intFinalAmmount = Integer.parseInt(finalAmmount);
						javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableTDSAmmount());
						String tdsAmmount = javascriptHelper
								.executeScript(
										"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value")
								.toString();
						System.out.println("TDS Ammount is" + tdsAmmount);
						javascriptHelper.scrollIntoView(driver.findElement(
								By.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber")
										+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div")));
						String tdsPercentage = driver
								.findElement(By.xpath("//div[contains(text(),'"
										+ testData.get("approvedInvoiceNumber")
										+ "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[9]//div"))
								.getText();
						// javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayableTDSAmmount());
						// String tdsAmmount=javascriptHelper.executeScript("return
						// document.getElementsByClassName('native-input
						// sc-ion-input-md')[1].value").toString();
						System.out.println("TDS Ammount is" + tdsAmmount);
						String[] finalTDSAmmount = tdsAmmount.split("[.]");
						int intTdsAmmount = Integer.parseInt(finalTDSAmmount[0]);
						String formNetPayableAmmount = javascriptHelper.executeScript(
								"return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value")
								.toString();
						String[] arrayNetPayableAmmount = formNetPayableAmmount.split("[.]");
						String finalStringNetPayableAmmount = arrayNetPayableAmmount[0];
						String finalNet = finalStringNetPayableAmmount.replace(",", "");
						int IntegerNetPayableAmmount = Integer.parseInt(finalNet);
						int expectedNetPayableAmmount = intFinalAmmount - intTdsAmmount;

						System.out.println("Net Payable Ammount" + formNetPayableAmmount);
						System.out.println("Final Ammount is" + finalAmmount);
						System.out.println("TDS Percentage is" + tdsPercentage);
						System.out.println("expected netPayableAmmount is" + expectedNetPayableAmmount);
						if (IntegerNetPayableAmmount == expectedNetPayableAmmount) {
							System.out.println("Test Case passed");

						} else {
							Assert.fail("Condition not matched");
						}
						break;
					} catch (NoSuchElementException e) {
						javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
						paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
					}

				}
			}


		  

}
