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
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_PoReportObj;
import pageobjects.ARAP_PoCreationObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSPAYABLE_PoReprt extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ARAP_PoCreationObj poCreationObj = new ARAP_PoCreationObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData = jsonConfig
			.getAccountsPayableContractReportTestDataByName("Maker");
	ACCOUNTSPAYABLE_PoReportObj poReportObj = new ACCOUNTSPAYABLE_PoReportObj(driver);
	ACCOUNTSPAYABLE_AccountsPayableReportObj accountsPayableReport = new ACCOUNTSPAYABLE_AccountsPayableReportObj(
			driver);
	Map<String, String> reportData = new HashMap<>();
	BrowserHelper browserHelper=new BrowserHelper(driver);

	@And("^search for the active po$")
	public void search_for_the_active_po() throws Throwable {
		// waitHelper.waitForElementVisible(poCreationObj.poStatus(), 2000, 200);
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(poCreationObj.poStatus());
		poCreationObj.poStatus().click();
		poCreationObj.poStatus().sendKeys(reportTestData.ApprovedPo);

	}

	@And("^get the approved po reference number and get the business partner name$")
	public void get_the_approved_po_reference_number_and_get_the_business_partner_name() throws Throwable {
		String approvedBpName = poCreationObj.approvedBpName().getText();
		reportData.put("approvedBpName", approvedBpName);
		String poNumber = poCreationObj.approvedPoNumber().getText();
		reportData.put("approvedPoNumber", poNumber);
		String contractNumber=poCreationObj.approvedPoContractNumber().getText();
		reportData.put("ContractNumber", contractNumber);

	}

	@And("^goto po report$")
	public void goto_po_report() throws Throwable {
		waitHelper.waitForElementVisible(poReportObj.accountsPayablePoReportTempView(), 2000, 200);
		poReportObj.accountsPayablePoReportTempView().click();
	}

	@And("^enter business partner name in po report$")
	public void enter_business_partner_name_in_po_report() throws Throwable {
		waitHelper.waitForElementVisible(accountsPayableReport.accountspayableReportBpName(), 2000, 200);
		accountsPayableReport.accountspayableReportBpName().click();
		accountsPayableReport.accountspayableReportBpName().sendKeys(reportData.get("approvedBpName"));
		accountsPayableReport.accountspayableReportBpName().sendKeys(Keys.ENTER);
	}

	@And("^enter po status in po report$")
	public void enter_po_status_in_po_report() throws Throwable {
		accountsPayableReport.accountsPayablePayableStatus().click();
		// reportTestData
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(reportTestData.ApprovedPo);
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
	}

	@Then("^verify the approved po number is availabe in the po report$")
	public void verify_the_approved_po_number_is_availabe_in_the_po_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver
						.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]"))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				accountsPayableReport.accountsPayableReportNextRecord().click();
			}
		}
		String reportContractNumber=driver.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]/parent::td/following-sibling::td[2]/div")).getText();
		String StringFinalContractNo=reportContractNumber.trim();
		if(StringFinalContractNo.equalsIgnoreCase(reportData.get("ContractNumber")))
		{
			System.out.println("Test case passed");
		}
		else
		{
			Assert.fail("Contract number mismatched");
		}
		browserHelper.switchToParentWithChildClose();
	}
}
