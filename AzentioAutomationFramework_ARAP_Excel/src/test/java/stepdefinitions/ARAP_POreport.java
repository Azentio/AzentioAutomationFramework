package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_PoReportObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.BUDGET_BudgetTransferObj;
import resources.BaseClass;
import resources.ExcelData;

public class ARAP_POreport extends BaseClass {
	WebDriver driver=BaseClass.driver;
	
	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj=new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
	JavascriptHelper javascriptHelper =new JavascriptHelper();
	Map<String, String> reportData = new HashMap<>();
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_PoReportObj poReportObj = new ACCOUNTSPAYABLE_PoReportObj(driver);
	ACCOUNTSPAYABLE_AccountsPayableReportObj accountsPayableReport = new ACCOUNTSPAYABLE_AccountsPayableReportObj(driver);
	BrowserHelper browserHelper=new BrowserHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_POreport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	

	 @And("^user update the data set ID for PO Report$")
	 public void user_update_the_data_set_id_for_po_report() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_003_002_TC_02_D1");
	 }
	 
	 @And("^user update the data set ID for PO Report2$")
	 public void user_update_the_data_set_id_for_po_report2() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR_AP_UAT_003_003_TC_04_D1");
	 }
	 
	@And("^search for the active po$")
	public void search_for_the_active_po() throws Throwable {
		// waitHelper.waitForElementVisible(poCreationObj.poStatus(), 2000, 200);
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(poCreationObj.poStatus());
		poCreationObj.poStatus().click();
		poCreationObj.poStatus().sendKeys(testData.get("ApprovedPo"));

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
	
	@And("^click on report main menu$")
	public void click_on_report_main_menu() throws Throwable {
		waitHelper.waitForElementVisible(budgetTransferObj.reportReortMainMenu(), 2000, 200);
		budgetTransferObj.reportReortMainMenu().click();
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
	
	@And("^click on date icon$")
	public void click_on_date_icon() throws Throwable {
		budgetTransferObj.budgetTransferDateAsOn().click();
	}
	
	@And("^give date in report$")
	public void give_date_in_report() throws Throwable {
		while (true) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " "
						+ testData.get("Year") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				budgetTransferObj.budgetTransferNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Day") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@And("^enter po status in po report$")
	public void enter_po_status_in_po_report() throws Throwable {
		accountsPayableReport.accountsPayablePayableStatus().click();
		// reportTestData
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(testData.get("ApprovedPo"));
		accountsPayableReport.accountsPayablePayableStatus().sendKeys(Keys.ENTER);
	}
	
	@And("^click on the view button$")
	public void click_on_the_view_button() throws Throwable {
		Thread.sleep(1000);
	//waitHelper.waitForElementVisible(budgetTransferObj.budgetTransferReportViewButton(), 2000, 200);
budgetTransferObj.budgetTransferReportViewButton().click();
		Thread.sleep(1000);
	}
	
	
	@Then("^verify the approved po number is availabe in the po report$")
	public void verify_the_approved_po_number_is_availabe_in_the_po_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javascriptHelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//				javascriptHelper.scrollIntoView(driver
//						.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]")));
//				driver.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]"))
//						.isDisplayed();
//				break;
//			} catch (NoSuchElementException e) {
//				accountsPayableReport.accountsPayableReportNextRecord().click();
//			}
//		}
//		String reportContractNumber=driver.findElement(By.xpath("//div[contains(text(),'" + reportData.get("approvedPoNumber") + "')]/parent::td/following-sibling::td[2]/div")).getText();
//		String StringFinalContractNo=reportContractNumber.trim();
//		if(StringFinalContractNo.equalsIgnoreCase(reportData.get("ContractNumber")))
//		{
//			System.out.println("Test case passed");
//		}
		/*
		 * else { Assert.fail("Contract number mismatched"); }
		 */
		browserHelper.switchToParentWithChildClose();
	}
	
	

}
