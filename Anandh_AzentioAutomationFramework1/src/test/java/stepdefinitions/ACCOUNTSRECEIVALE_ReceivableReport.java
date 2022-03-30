package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
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
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSRECEIVABLE_AccountsReceivableReportObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSRECEIVALE_ReceivableReport extends BaseClass {
	WebDriver driver=BaseClass.driver;
	KUBS_MakerObj makerObj=new KUBS_MakerObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj creditNoteObj=new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSRECEIVABLE_AccountsReceivableReportObj accountsReceivableReportObj=new ACCOUNTSRECEIVABLE_AccountsReceivableReportObj(driver);
	Map<String,String> testData=new HashMap<>();
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj =new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	JsonConfig jsonConfig=new JsonConfig();
	BrowserHelper browserHelper=new BrowserHelper(driver);
	JavascriptHelper javascriptHelper= new JavascriptHelper();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData= jsonConfig.getAccountsPayableContractReportTestDataByName("Maker");
    @And("^click ok segment segmant button$")
    public void click_ok_segment_segmant_button() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 200);
    	makerObj.kubsDirectionIcon().click();
    }
    @And("^select the approved credit note reference number$")
    public void select_the_approved_credit_note_reference_number() throws Throwable {
    	waitHelper.waitForElementVisible(creditNoteObj.approvedCreditNoteRecord(), 2000, 200);
    	String approvedCreditNoteReferenceNumber=creditNoteObj.approvedCreditNoteRecord().getText();
    	testData.put("approvedCreditNoteReferenceNumber", approvedCreditNoteReferenceNumber);

    }

    @And("^get the credit note amount$")
    public void get_the_credit_note_amount() throws Throwable {
    	String approvedCreditNoteAmount=creditNoteObj.creditNoteApprovedCreditAmount().getText();
    	testData.put("approvedCreditNoteAmount", approvedCreditNoteAmount);
    }

    @And("^get the business partner name from approved credit note$")
    public void get_the_business_partner_name_from_approved_credit_note() throws Throwable {
    	String approvedCreditNoteBpName=creditNoteObj.creditNoteApprovedBusinessPartnerName().getText();
    	testData.put("approvedCreditNoteBpName", approvedCreditNoteBpName);
    }
    @And("^click on temp view near by accounts receivable report$")
    public void click_on_temp_view_near_by_accounts_receivable_report() throws Throwable {
    	waitHelper.waitForElementVisible(accountsReceivableReportObj.accountsReceivableReportTempView(), 2000, 200);
    	accountsReceivableReportObj.accountsReceivableReportTempView().click();
    	
    }

    @And("^click on business partner for settled credit note$")
    public void click_on_business_partner_for_settled_credit_note() throws Throwable {
    	waitHelper.waitForElementVisible(accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName(), 2000, 200);
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().click();
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(testData.get("approvedCreditNoteBpName"));
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(Keys.ENTER);
    }

    @And("^enter active credit note status in accounts Receivable module$")
    public void enter_active_credit_note_status_in_accounts_receivable_module() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().click();
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(reportTestData.ReceivableReportStatusAll);
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the approved credit note is available in the receivable report$")
    public void verify_the_approved_credit_note_is_available_in_the_receivable_report() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("approvedCreditNoteReferenceNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("approvedCreditNoteReferenceNumber") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				accountsReceivableReportObj.accountsReceivableReportNextRecord().click();
			} catch (StaleElementReferenceException e1) {

			}
		}
		browserHelper.switchToParentWithChildClose();
    }

    
    /********* KUBS_AR_AP_UAT_006_003_TC_04 ***************/
    @And("^search the advance approved reference number in the reference number search column$")
    public void search_the_advance_approved_reference_number_in_the_reference_number_search_column() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber());
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().click();
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().sendKeys("PTN-1001-17-1712022");
    	
    }

    @And("^get the business partner nname$")
    public void get_the_business_partner_nname() throws Throwable {
    	String approvedBpName=manualPayoutObj.accountsPayableApprovedBpName().getText();
    	testData.put("approveBpName", approvedBpName);
    	System.out.println(testData.get("approveBpName"));
    	
    }

    @And("^click on the perticular suggestion record and get the advance reference number$")
    public void click_on_the_perticular_suggestion_record_and_get_the_advance_reference_number() throws Throwable {
    	
    	javascriptHelper.JavaScriptHelper(driver);
    	manualPayoutObj.accountsPayablePayoutRecord().click();
    	Thread.sleep(1000);
    	javascriptHelper.scrollIntoView(manualPayoutObj.accountsPayableGetAdvanceReferenceNumber());
    	String receivableReferenceNo=manualPayoutObj.accountsPayableGetAdvanceReferenceNumber().getText();
    	testData.put("receivableReferenceNo", receivableReferenceNo);
    	System.out.println("Receivable reference number : "+receivableReferenceNo);

    }
    @And("^enter the business partner name for advances to employee$")
    public void enter_the_business_partner_name_for_advances_to_employee() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().click();
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(testData.get("approveBpName"));
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(Keys.ENTER);
    }   
    @And("^enter the advances to employee status active$")
    public void enter_the_advances_to_employee_status_active() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().click();
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(reportTestData.ReceivableReportStatusAll);
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the advance reference number is available in the accounts Receivable report$")
    public void verify_the_advance_reference_number_is_available_in_the_accounts_receivable_report() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("receivableReferenceNo") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("receivableReferenceNo") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				accountsReceivableReportObj.accountsReceivableReportNextRecord().click();
			} catch (StaleElementReferenceException e1) {

			}
		}
		browserHelper.switchToParentWithChildClose();
    }
    
    
}
