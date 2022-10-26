package stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSPAYABLE_AccountspayableReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> testData = new HashMap<>();
	ACCOUNTSPAYABLE_AccountsPayableReportObj accountsPayableReport = new ACCOUNTSPAYABLE_AccountsPayableReportObj(
			driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData = jsonConfig
			.getAccountsPayableContractReportTestDataByName("Maker");
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	List<String> invoiceList= new ArrayList<>();

	@And("^search the active bill$")
	public void search_the_active_bill() throws Throwable {
		// waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableSearchInvoiceStatus(),
		// 2000, 200);
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(invoiceBookingObj.accountPayableSearchInvoiceStatus());
		invoiceBookingObj.accountPayableSearchInvoiceStatus().click();
		invoiceBookingObj.accountPayableSearchInvoiceStatus().sendKeys(reportTestData.InvoiceStatus);

	}

	@And("^get the approved invoice number$")
	public void get_the_approved_invoice_number() throws Throwable {

		String invoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
		System.out.println("Approved invoiceNumber" + invoiceNumber + " Approved BpName " + approvedBpName);
		testData.put("InvoiceNumber", invoiceNumber);
		testData.put("approvedBpName", approvedBpName);
	}

	@And("^click on accouts payable report$")
	public void click_on_accouts_payable_report() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(accountsPayableReport.accountsPayableReportTempView());
		accountsPayableReport.accountsPayableReportTempView().click();
	}

	@And("^enter bp name in accoutspayable report for approved invoice$")
	public void enter_bp_name_in_accoutspayable_report_for_approved_invoice() throws Throwable {
		accountsPayableReport.accountspayableReportBpName().click();
		accountsPayableReport.accountspayableReportBpName().sendKeys(testData.get("approvedBpName"));
		accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);

	}

	@And("^give payable status in accounts payable report for approved invoice$")
	public void give_payable_status_in_accounts_payable_report_for_approved_invoice() throws Throwable {
		accountsPayableReport.accountsPayablePayableStatus().click();
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(reportTestData.PayableStatus);
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
	}

	@Then("^verify the approved invoice is appeared in the accounts Payable report$")
	public void verify_the_approved_invoice_is_appeared_in_the_accounts_payable_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		Thread.sleep(2000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver
						.findElement(By.xpath("//div[contains(text(),'" + testData.get("InvoiceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("InvoiceNumber") + "')]"))
						.isDisplayed();

				break;
			} catch (NoSuchElementException e) {
				accountsPayableReport.accountsPayableReportNextRecord().click();
			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	/****************** KUBS_AR_AP_UAT_003_002_TC_03 *************/
	@Then("^search the cancelled invoice number with po$")
	public void search_the_cancelled_invoice_number_with_po() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(invoiceBookingObj.accountPayableSearchInvoiceStatus());
		invoiceBookingObj.accountPayableSearchInvoiceStatus().click();
		invoiceBookingObj.accountPayableSearchInvoiceStatus().sendKeys(reportTestData.CancellInvoiceStatus);
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
				testData.put("cancelledInvoiceNumber", cancelledInvoiceNumber);
				testData.put("cancelledBpName", cancelledBpName);
				System.out.println("Cancelled invoiceNumber" + testData.get("cancelledInvoiceNumber"));
				break;
			}
		}

		System.out.println("Cancelled invoiceNumber" + testData.get("cancelledInvoiceNumber"));

	}

	@And("^enter the business partner name for cancelled invoice$")
	public void enter_the_business_partner_name_for_cancelled_invoice() throws Throwable {
		waitHelper.waitForElementVisible(accountsPayableReport.accountspayableReportBpName(), 2000, 200);
		accountsPayableReport.accountspayableReportBpName().click();
		accountsPayableReport.accountspayableReportBpName().sendKeys(testData.get("cancelledBpName"));
		accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);
	}

	@And("^enter the payable status as cancelled$")
	public void enter_the_payable_status_as_cancelled() throws Throwable {
		Thread.sleep(1000);
		accountsPayableReport.accountsPayablePayableStatus().click();
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(reportTestData.CancelledPayableStatus);
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
	}

	@Then("^verify the cancelled invoice number is available in the accountspayable report$")
	public void verify_the_cancelled_invoice_number_is_available_in_the_accountspayable_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("cancelledInvoiceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("cancelledInvoiceNumber") + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				accountsPayableReport.accountsPayableReportNextRecord().click();
			}
		}

		browserHelper.switchToParentWithChildClose();
	}

	/******************** KUBS_AR_AP_UAT_004_007_TC_06 *******************/
	@And("^open the recently payment settlement approved record$")
	public void open_the_recently_payment_settlement_approved_record() throws Throwable {
		waitHelper.waitForElementVisible(payementSettlementObj.paymentSettlementRecentlyApprovedRecord(), 2000, 200);
		payementSettlementObj.paymentSettlementRecentlyApprovedRecord().click();
	}

	@And("^get the approved invoice number and business partner$")
	public void get_the_approved_invoice_number_and_business_partner() throws Throwable {
		waitHelper.waitForElementVisible(payementSettlementObj.payementSettlementApprovedBusinessPartnerName(), 2000,
				200);
		String approvedBpName = payementSettlementObj.payementSettlementApprovedBusinessPartnerName().getText();
		String approvedInvoiceNumber = payementSettlementObj.paymentSettlementRecentlyApprovedInvoiceNUmber().getText();
		String GrossInvoiceAmount = payementSettlementObj.paymentSettlementGrossInvoiceAmount().getText();
		testData.put("approvedBPName", approvedBpName);
		testData.put("approvedInvoiceNumber", approvedInvoiceNumber);
		testData.put("GrossInvoiceAmount", GrossInvoiceAmount);
		System.out.println("Gross amount of invoice" + testData.get("GrossInvoiceAmount"));
		// System.out.println("approved ");
	}

	@And("^enter the payment settled business partner$")
	public void enter_the_payment_settled_business_partner() throws Throwable {
		waitHelper.waitForElementVisible(accountsPayableReport.accountspayableReportBpName(), 2000, 200);
		accountsPayableReport.accountspayableReportBpName().click();
		accountsPayableReport.accountspayableReportBpName().sendKeys(testData.get("approvedBPName"));
		accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);
	}

	@Then("^verify the payment settlement invoice number is available in the report$")
	public void verify_the_payment_settlement_invoice_number_is_available_in_the_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			Thread.sleep(150);
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				try
				{
				accountsPayableReport.accountsPayableReportNextRecord().click();
				}
				catch(ElementClickInterceptedException e2)
				{
					
				}
			} catch (StaleElementReferenceException e1) {

			}
		}
		Thread.sleep(1000);
		while (true) {
			try {
				String payableAmt = driver.findElement(By.xpath("//div[contains(text(),'"
						+ testData.get("approvedInvoiceNumber") + "')]/parent::td/following-sibling::td[5]//div"))
						.getText();
				System.out.println("Payable Ammount is " + payableAmt);
				String[] splitPayableAmt = payableAmt.split("[.]");
				String finalPayableAmt = splitPayableAmt[0].replace(",", "");
				String finalPayableAAmount = finalPayableAmt.trim();

				if ((testData.get("GrossInvoiceAmount").equalsIgnoreCase(finalPayableAAmount))) {
					System.out.println("Test Case Passed");
					break;
				} else {
					System.out.println("final Payout" + finalPayableAmt);
					System.out.println("Gross invoice Amount" + testData.get("GrossInvoiceAmount"));
					Assert.fail("Amount mismatched");
					break;
				}

			} catch (NoSuchElementException e) {

			}
		}
		browserHelper.switchToParentWithChildClose();
	}
	
	
	@And("^click on that record$")
    public void click_on_that_record() throws Throwable {
		waitHelper.waitForElementVisible(manualPayoutObj.accountsPayableApprovedBpName(), 2000, 200);
		String approvedBpName=manualPayoutObj.accountsPayableApprovedBpName().getText();
		testData.put("approvedBpName", approvedBpName);
		waitHelper.waitForElementVisible(manualPayoutObj.accountsPayablePayoutRecord(), 2000, 200);
		manualPayoutObj.accountsPayablePayoutRecord().click();
    }

    @And("^get the invoice number$")
    public void get_the_invoice_number() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	for(int i=1;i<5;i++)
    	{
        try
        {
        	javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//page-manual-payout-processing-update//datatable-row-wrapper["+i+"]//datatable-body-cell[4]//span")));
    	String invoiceNumber=driver.findElement(By.xpath("//page-manual-payout-processing-update//datatable-row-wrapper["+i+"]//datatable-body-cell[4]//span")).getText();
    	invoiceList.add(invoiceNumber);
    	System.out.println("InvoiceNumber"+invoiceNumber);
        }
        catch(NoSuchElementException e)
        {
        	break;
        }
    	}
    	}
    @And("^enter businessPartner name for multiple record$")
    public void enter_businesspartner_name_for_multiple_record() throws Throwable {
     waitHelper.waitForElementVisible(accountsPayableReport.accountspayableReportBpName(), 2000, 200);
     accountsPayableReport.accountspayableReportBpName().click();
     accountsPayableReport.accountspayableReportBpName().sendKeys(testData.get("approvedBpName"));
     accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);
    }
    @And("^give status of the settlement record$")
    public void give_status_of_the_settlement_record() throws Throwable {
    	accountsPayableReport.accountsPayablePayableStatus().click();
    	accountsPayableReport.accountsPayablePayableStatus().sendKeys(reportTestData.ClosedReportStatus);
    	accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
    	
    }
    @Then("^verify the approved invoice reference number are available in the payable report$")
    public void verify_the_approved_invoice_reference_number_are_available_in_the_payable_report() throws Throwable {
     Thread.sleep(1000);
     browserHelper.SwitchToWindow(1);
    for(int i=0;i<5;i++)
     {
    	 try
    	 {
    		 javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + invoiceList.get(i) + "')]")));
				boolean result=driver.findElement(By.xpath("//div[contains(text(),'" + invoiceList.get(i) + "')]")).isDisplayed();
				System.out.println(result);
			
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 accountsPayableReport.accountsPayableReportNextRecord().click(); 
    	 }
    	 catch(IndexOutOfBoundsException e2)
    	 {
    		 break;
    	 }
    	 
     }
    browserHelper.switchToParentWithChildClose();
    }
    
    
    @And("^search the payout completed reference number$")
    public void search_the_payout_completed_reference_number() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	waitHelper.waitForElementVisible(manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber(), 2000, 200);
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().click();
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().sendKeys(reportTestData.advanceApprovedPayoutReferenceNumber);
    	String approvedBpName=manualPayoutObj.accountsPayableApprovedBpName().getText();
    	testData.put("approvedBpName", approvedBpName);
    	manualPayoutObj.accountsPayablePayoutRecord().click();
    	Thread.sleep(1000);
    	javascriptHelper.scrollIntoView(manualPayoutObj.accountsPayableGetAdvanceReferenceNumber());
    	String advanceReferenceNumber=manualPayoutObj.accountsPayableGetAdvanceReferenceNumber().getText();
    	testData.put("advanceReferenceNumber", advanceReferenceNumber);
    	System.out.println("Advance reference number "+advanceReferenceNumber);
    }
    @Then("^verify the advance record is available in the payable report section$")
    public void verify_the_advance_record_is_available_in_the_payable_report_section() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			Thread.sleep(150);
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("advanceReferenceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("advanceReferenceNumber") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				try
				{
				accountsPayableReport.accountsPayableReportNextRecord().click();
				}
				catch(ElementClickInterceptedException e2)
				{
					
				}
			} catch (StaleElementReferenceException e1) {

			}
		}
		browserHelper.switchToParentWithChildClose();
    }
    
/******************   KUBS_AR_AP_UAT_005_001_TC_06    ********************/    
    
    @And("^search the cancelled payment settlement record$")
    public void search_the_cancelled_payment_settlement_record() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(payementSettlementObj.paymentSettlementSearchTXNNumber());
    	payementSettlementObj.paymentSettlementSearchTXNNumber().click();
    	payementSettlementObj.paymentSettlementSearchTXNNumber().sendKeys("cancelled");
    	String bpname=payementSettlementObj.paymentSettlementApprovedBpName().getText();
    	payementSettlementObj.paymentSettlementRecentlyApprovedRecord().click();
    	testData.put("approvedBPName", bpname);
		
    	
    	
    }

    @And("^get the invoice number of cancelled payment settlement record$")
    public void get_the_invoice_number_of_cancelled_payment_settlement_record() throws Throwable {
    	Thread.sleep(1000);
    	javascriptHelper.scrollIntoView(payementSettlementObj.paymentSettlementRecentlyApprovedInvoiceNUmber());
    	String invoiceNumber=payementSettlementObj.paymentSettlementRecentlyApprovedInvoiceNUmber().getText();
    	System.out.println(invoiceNumber);
    	testData.put("approvedInvoiceNumber", invoiceNumber);
    }
    @And("^give the status in payment settlement report section$")
    public void give_the_status_in_payment_settlement_report_section() throws Throwable {
    	accountsPayableReport.accountsPayablePayableStatus().click();
    	accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the payment settement invoice number is available in the payable report$")
    public void verify_the_payment_settement_invoice_number_is_available_in_the_payable_report() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			Thread.sleep(150);
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("approvedInvoiceNumber") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				try
				{
				accountsPayableReport.accountsPayableReportNextRecord().click();
				}
				catch(ElementClickInterceptedException e2)
				{
					
				}
			} catch (StaleElementReferenceException e1) {

			}
		}
		browserHelper.switchToParentWithChildClose();
    }
}
