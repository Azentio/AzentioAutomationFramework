package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSRECEIVABLE_AdvancesObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class CancellationOfAdvanceAgainstPO extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	String poNumber;
	String poBusinessPartner;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	Map<String, String> settlementTestData = new HashMap<>();
	Map<String, String> accountsReceivableTestData = new HashMap<>();
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"CancellationOfAdvanceAgainstPO", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	///////////////////////// 003_009_TC_01////////////////////////

	@And("^goto arap adjustment main module$")
	public void goto_arap_adjustment_main_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
	}

	@Then("^Click on Accounts Receive Advances Eye Icon$")
	public void click_on_accounts_receive_advances_eye_icon() throws Throwable {
		// ---------------ADVANCE EYE ICON----------------//
//		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_Eye());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsReceivable_Advance_Eye());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountsReceivable_Advance_Eye());
		arapObj.accountsReceivable_Advance_Eye().click();
	}
	
	@Then("^Enter Cancelled Value In Advance Status$")
	public void enter_cancelled_value_in_advance_status() throws Throwable {
		// ----------GIVE DETAILS FOR SEARCH-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(testData.get("ReceivableName"));
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(testData.get("GRN Status"));
	}
	
	@And("^Get Business Partner and Advance Number$")
	public void get_business_partner_and_advance_number() throws Throwable {
//		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_GetBp());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountsReceivable_Advance_GetBp());
		BPNumber = arapObj.accountsReceivable_Advance_GetBp().getText();
		System.out.println(BPNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVNumber = (String) javaScriptHelper.executeScript("return document.getElementsByName('advanceNo')[1].value");
		System.out.println(ADVNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVAmount = (String) javaScriptHelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value");
		System.out.println(ADVAmount);
	}

	@Then("^Verify No accounting entry is generated on cancelling advances against PO$")
	public void verify_no_accounting_entry_is_generated_on_cancelling_advances_against_po() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 70; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]"));
				String TransactionType = driver
						.findElement(By
								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(By
								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
		for (int i = 0; i <= 70; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[2]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]"));
				String TransactionType = driver
						.findElement(By
								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(By
								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}

		}
	}
	
	@Then("^Select from date in calender to verify no accounting entries$")
	public void select_from_date_in_calender_to_verify_no_accounting_entries() throws Throwable {
		// ----------CLICK ON FROM DATE--------------//
		for(int i=0;i<=70;i++) {
			try {

				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + "']"));
				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();

			}

		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clicksAndActionsHelper.doubleClick(Click);

	}
	
	@Then("^Select To date in calender to verify no accounting entries$")
	public void select_to_date_in_calender_to_verify_no_accounting_entries() throws Throwable {
		for(int i=0;i<=70;i++) {
			try {

				// span[contains(text(),'Oct 2022')]
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("Month1") + " " + testData.get("Year1") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("Month1") + " " + testData.get("Year1") + "']"));
//				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth1") + " " + testData.get("Date1") + ", " + testData.get("Year1") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth1") + " " + testData.get("Date1") + ", " + testData.get("Year1") + "']/span"));

		clicksAndActionsHelper.doubleClick(Click);

	}
	
	@And("^choose branch codes to verify accounting entries$")
	public void choose_branch_codes_to_verify_accounting_entries() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAPBranchCode());
		arapObj.ARAPBranchCode().click();
		arapObj.ARAPBranchCode().sendKeys(testData.get("BranchCode"));
		arapObj.ARAPBranchCode().sendKeys(Keys.ENTER);
	}

	@Then("^select data set ID for Verify No accounting entry is generated on cancelling advances against PO$")
	public void select_data_set_id_for_verify_no_accounting_entry_is_generated_on_cancelling_advances_against_po() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_009_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}