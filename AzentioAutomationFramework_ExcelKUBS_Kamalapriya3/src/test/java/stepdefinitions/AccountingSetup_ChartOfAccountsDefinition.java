package stepdefinitions;

import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountingSetup_ChartOfAccountsDefinitionObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountingSetup_ChartOfAccountsDefinitionTestDataType;

public class AccountingSetup_ChartOfAccountsDefinition {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionObj ChartOfAccountsDefinitionObj = new AccountingSetup_ChartOfAccountsDefinitionObj(
			driver);
//	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
//	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionTestDataType ChartOfAccountsDefinitionTestDataType = jsonReader
			.getChartOfAccountsDefinitiondata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	@Then("^search COA name to modify the coa$")
	public void search_coa_name_to_modify_the_coa() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.COA_NameSearch);
	}

	@Then("^search COA name to modify the coa1$")
	public void search_coa_name_to_modify_the_coa1() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.COA_NameSearch1);
	}

	@Then("^search used COA code for which GL entries are passed$")
	public void search_used_COA_code_for_which_GL_entries_are_passed() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.LeafCOA_CodeSearch);
	}

	@Then("^search used parent COA code for which GL entries are passed$")
	public void search_used_parent_COA_code_for_which_GL_entries_are_passed() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.ParentCOA_CodeSearch);
	}

	@Then("^click on pencil button to modify the COA$")
	public void click_on_pencil_button_to_modify_the_coa() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_FirstPencilButton(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_FirstPencilButton().click();
	}

	@Then("^modify the COA details$")
	public void modify_the_coa_details() throws InterruptedException {
		Random ran = new Random();
		int radom = ran.nextInt(500 - 100) + 100;
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(ChartOfAccountsDefinitionTestDataType.AccountingCategory);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().click();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().clear();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.COA_Name1 + radom);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode().click();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.ExternalMappingCode1);

//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL());
//   	    ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().click();
//    	//ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(ChartOfAccountsDefinitionTestDataType.ParentGL1);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(Keys.DOWN);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.GL_Type1);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().click();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().clear();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.Description1 + radom);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.BalanceType1);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(Keys.ENTER);
//    	
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(ChartOfAccountsDefinitionTestDataType.statusofCOA);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.DOWN);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.ENTER);
//    	
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Remarks());
//   	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Remarks().sendKeys(ChartOfAccountsDefinitionTestDataType.Remark);
//    	
////    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EntitySegment());
////    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EntitySegment().sendKeys(ChartOfAccountsDefinitionTestDataType.EntitySegment);
////    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EntitySegment().sendKeys(Keys.ENTER);
	}

	@Then("^Inactive the active Chart of account$")
	public void inactive_the_active_chart_of_account() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.StatusInactive);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.ENTER);
	}

	@Then("^Save the Record and submit the modified record of COA$")
	public void save_the_record_and_submit_the_modified_record_of_coa() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

		for (int i = 0; i < 60; i++) {

			try {
				javascripthelper.JavaScriptHelper(driver);
				String str = javascripthelper.executeScript(
						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
						.toString();
				System.out.println("Message:" + str);
			} catch (JavascriptException e) {

			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton(), 60, 500);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId(), 60, 500);
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				// waithelper.waitForElementwithFluentwait(driver,
				// driver.findElement(By.xpath("//span[contains(text(),'"
				// +jsonWriter.readReferancedata()+ "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				waithelper.waitForElementToVisibleWithFluentWait(driver, referanceID, 60, 500);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				// waithelper.waitForElementwithFluentwait(driver,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)), 60, 500);
		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton(), 60, 500);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1(), 60, 500);
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.RemarkByMaker);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//    	clicksAndActionHelper.moveToElement(recordstatus);

		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
	}

	@Then("^Save and submit the modified record of COA$")
	public void save_and_submit_the_modified_record_of_coa() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton(), 60, 500);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId(), 60, 500);
		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				// waithelper.waitForElementwithFluentwait(driver,
				// driver.findElement(By.xpath("//span[contains(text(),'"
				// +jsonWriter.readReferancedata()+ "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				waithelper.waitForElementToVisibleWithFluentWait(driver, referanceID, 60, 500);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				// waithelper.waitForElementwithFluentwait(driver,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)), 60, 500);
		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton(), 60, 500);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField(), 60, 500);
		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.RemarkByMaker);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//    	clicksAndActionHelper.moveToElement(recordstatus);

		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
//    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
	}

	@Then("^checker should approved the COA record$")
	public void checker_should_approved_the_coa_record() throws IOException, ParseException, InterruptedException {

//		waithelper.waitForElementwithFluentwait(driver,  driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton(), 60, 500);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		for (int i = 0; i < 30; i++) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
						+ jsonWriter.readReferancedata()
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")),
						90, 500);
				driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
						.click();
				break;
			} catch (NoSuchElementException e) {

			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerApproveButton(), 60, 500);
		kubschecker.checkerApproveButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark(), 60, 500);
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.ApprovedByChecker);

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkersubmitButton(), 60, 500);
		kubschecker.checkersubmitButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//    	clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@Then("^modify the COA details for which GL entries are passed$")
	public void modify_the_coa_details_for_which_GL_entries_are_passed() {
		Random ran = new Random();
		int rand = ran.nextInt(500 - 100) + 100;
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(ChartOfAccountsDefinitionTestDataType.AccountingCategory);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(Keys.ENTER);

//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().click();
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().clear();
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().sendKeys(ChartOfAccountsDefinitionTestDataType.COA_Name);

//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode().sendKeys(ChartOfAccountsDefinitionTestDataType.ExternalMappingCode);
//    	
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(ChartOfAccountsDefinitionTestDataType.ParentGL);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.GL_TypeModifiedForUsedCOA);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().clear();
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description()
				.sendKeys(ChartOfAccountsDefinitionTestDataType.Description + rand);

//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(ChartOfAccountsDefinitionTestDataType.BalanceType);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(Keys.ENTER);
//    	
//    	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField());
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(ChartOfAccountsDefinitionTestDataType.Status);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.ENTER);

	}

	@Then("^Save and check the modified record of used leaf COA$")
	public void save_and_check_the_modified_record_of_used_leaf_coa()
			throws IOException, ParseException, InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus(), 60, 500);
//    	WebElement recordstatus = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus();
//    	clicksAndActionHelper.moveToElement(recordstatus);

		String message = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus()
				.getText();
		System.out.println("Accounting Scheme - " + message);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus().click();
	}

	@Then("^Save and check the modified record of used parent COA$")
	public void save_and_check_the_modified_record_of_used_parent_coa()
			throws IOException, ParseException, InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus(), 60, 500);
//    	WebElement recordstatus = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus();
//    	clicksAndActionHelper.moveToElement(recordstatus);

		String message = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus()
				.getText();
		System.out.println("Accounting Scheme - " + message);
//    	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus().click();
	}
}