package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import resources.BaseClass;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;

public class ACCOUNSPAYABLE_ManualPayout extends BaseClass {
	WebDriver driver=BaseClass.driver;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj=new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	WaitHelper waitHelper= new WaitHelper(driver);
	Map<String,String> payoutData= new HashMap<>();
	JavascriptHelper javascrtiptHelper= new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUTSAPAYBLE_AutoPayoutTestDataType ManualPayoutData=jsonConfig.getAccountsPayableAutoPayoutTestDataByName("Maker");
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj= new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	@And("^click on view button near by manual payout module$")
    public void click_on_view_button_near_by_manual_payout_module() throws Throwable {
		//waitHelper.waitForElementVisible(manualPayoutObj.accountsPayable_ManualPayoutViewButton(), 2000, 200);
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayable_ManualPayoutViewButton());
		manualPayoutObj.accountsPayable_ManualPayoutViewButton().click();
		
    }
	@And("^search the active record in the manual pay out and get the transaction reference number$")
    public void search_the_active_record_in_the_manual_pay_out_and_get_the_transaction_reference_number() throws Throwable {
     //waitHelper.waitForElementVisible(manualPayoutObj.accountsPayablePayoutStatus(), 2000, 200);
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayablePayoutStatus());
     manualPayoutObj.accountsPayablePayoutStatus().click();
     manualPayoutObj.accountsPayablePayoutStatus().sendKeys(ManualPayoutData.ManualPayoutStatus);
     
     waitHelper.waitForElementVisible(manualPayoutObj.approvedManualPayoutReferenceNumber(), 2000, 200);
     String payoutApprovedReferenceNumber=manualPayoutObj.approvedManualPayoutReferenceNumber().getText();
     payoutData.put("approvedReferenceNumber", payoutApprovedReferenceNumber);
     
    }
	@Then("^verify the manual payout is appeared in the accounting entries$")
    public void verify_the_manual_payout_is_appeared_in_the_accounting_entries() throws Throwable {
		Thread.sleep(1000);
		javascrtiptHelper.JavaScriptHelper(driver);
		// boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i < 299; i++) {
			try {
				waitHelper
						.waitForElementVisible(
								driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
										+ payoutData.get("approvedReferenceNumber") + "')]")),
								2000, 100);
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
						+ payoutData.get("approvedReferenceNumber") + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);

				javascrtiptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}

			if (i == 299) {
				Assert.fail("InvoiceNumber not availabe : " + payoutData.get("approvedReferenceNumber"));
			}
		}

	}

	@And("^search the multiple bill payout approved reference number$")
    public void search_the_multiple_bill_payout_approved_reference_number() throws Throwable {
		
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber());
       manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().click();
       manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().sendKeys(ManualPayoutData.ManualPayoutReferenceNumber);
       
	}
	


	
}
