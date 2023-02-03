package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLEREPORT_PayoutReportObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSPAYABLE_PayoutReport extends BaseClass {

	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLEREPORT_PayoutReportObj payoutReportObj = new ACCOUNTSPAYABLEREPORT_PayoutReportObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	Map<String, String> mapData = new HashMap<>();
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData = jsonConfig
			.getAccountsPayableContractReportTestDataByName("Maker");
	BrowserHelper browserHelper=new BrowserHelper(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	INVENTORY_EnquiryGlObject glObj=new INVENTORY_EnquiryGlObject(driver);

	@And("^get the recently approved payout reference number$")
	public void get_the_recently_approved_payout_reference_number() throws Throwable {

		waithelper.waitForElementVisible(manualPayoutObj.approvedManualPayoutReferenceNumber(), 2000, 200);
		String approvedReferenceNumber = manualPayoutObj.approvedManualPayoutReferenceNumber().getText();
		mapData.put("approvedReferenceNumber", approvedReferenceNumber);
		String approvedBpName = manualPayoutObj.accountsPayableApprovedBpName().getText();
		mapData.put("ApprovedBpName", approvedBpName);
	}
	
	/******** KUBS_AR_AP_UAT_006_002_TC_02    *****************/
	@Then("^verify the approved payout reference number is available in the accounting entries screen$")
    public void verify_the_approved_payout_reference_number_is_available_in_the_accounting_entries_screen() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);

    	for(int i=0;i<299;i++)
    	{
    		try
    		{
    			//waithelper.waitForElementVisible(driver.findElement(By.xpath("//span[contains(text(),'"+mapData.get("approvedReferenceNumber")+"')]")), 2000, 100);
    			driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+mapData.get("approvedReferenceNumber")+"')]")).isDisplayed();
    			
    	
    		}
    		catch(NoSuchElementException e)
    		{
    			javascriptHelper.scrollIntoViewAndClick(glObj.nextRecord());
    			
    		}
    	}
    }
    
	

	@And("^click on the payout report$")
	public void click_on_the_payout_report() throws Throwable {
		waithelper.waitForElementVisible(payoutReportObj.accountsPayablePayoutReportTempView(), 2000, 200);
		payoutReportObj.accountsPayablePayoutReportTempView().click();
	}

	@And("^enter business partner name for payout report$")
	public void enter_business_partner_name_for_payout_report() throws Throwable {
		payoutReportObj.accountsPayablePayoutBusinessPartnerName().click();
		payoutReportObj.accountsPayablePayoutBusinessPartnerName().sendKeys(mapData.get("ApprovedBpName"));
		payoutReportObj.accountsPayablePayoutBusinessPartnerName().sendKeys(Keys.ENTER);

	}

	@And("^enter payout status in payout report$")
	public void enter_payout_status_in_payout_report() throws Throwable {
		payoutReportObj.accountsPayablePayoutStatus().click();
		payoutReportObj.accountsPayablePayoutStatus().sendKeys(reportTestData.PayoutStatus);
		payoutReportObj.accountsPayablePayoutStatus().sendKeys(Keys.ENTER);

	}

	@Then("^verify approved payout reference number is available in the payout report$")
	public void verify_approved_payout_reference_number_is_available_in_the_payout_report() throws Throwable {
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		while (true) {
			try {
				
				javascriptHelper.scrollIntoView(driver.findElement(
								By.xpath("//div[contains(text(),'" + mapData.get("approvedReferenceNumber") + "')]")));
					driver.findElement(By.xpath("//div[contains(text(),'" + mapData.get("approvedReferenceNumber") + "')]")).isDisplayed();
					break;	
					
		    	 }
		    	 catch(NoSuchElementException e)
		    	 {
		    		 payoutReportObj.accountsPayableReportNextRecord().click(); 
		    	 }

			

			}
		browserHelper.switchToParentWithChildClose();
		}
	}

