package stepdefinitions;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.BankRecon_BankReconciliationObj;
import pageobjects.BankRecon_ReconFormatObj;
import pageobjects.BankRecon_ReconcilliationObj;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;

public class BankRecons {
	WebDriver driver = BaseClass.driver;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BankRecon_ReconFormatObj bankRecon_ReconFormatObj = new BankRecon_ReconFormatObj(driver);
	// BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType =
	// jsonReader.getBankReconByName("Maker");
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	BankRecon_BankReconciliationObj bankRecon_BankReconciliationObj = new BankRecon_BankReconciliationObj(driver);
	BankRecon_ReconcilliationObj bankRecon_ReconcilliationObj = new BankRecon_ReconcilliationObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	// JsonDataReaderWriter reader = new JsonDataReaderWriter();
	Map<String, String> Getdata = new LinkedHashMap<>();
	AlertHelper alertHelper = new AlertHelper(driver);
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx", "BankReconTestdata",
			"DataSet ID");
	Map<String, String> testData;
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);

	@Then("^Click on Direction Left$")
	public void click_on_direction_left() {
		waithelper = new WaitHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft(), 60, 2);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft().click();

	}

	@Then("^Click on Bank Recon$")
	public void click_on_bank_recon() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormatField(),
				60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormatField().click();

	}

	@Then("^click on Bank Recon format eye button$")
	public void click_on_bank_recon_format_eye_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton().click();
	}

	@Then("^click on the first Record of bankReon$")
	public void click_on_the_first_Record_of_bankReon() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord().click();
	}

	@Then("^Click on Inventory Maintenance Add button$")
	public void click_on_inventory_maintenance_add_button() throws InterruptedException {

		// waithelper.waitForElementToVisibleWithFluentWait(driver,
		// inventoryMaintenanceObj.inventoryMaintenance_AddButton(), 60, 2);
		for (int i = 0; i < 100; i++) {
			try {
				inventoryMaintenanceObj.inventoryMaintenance_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail();
				}
			}
		}

	}

	@Then("^fill the Bank Reconciliation Format$")
	public void fill_the_bank_reconciliation_format() throws InterruptedException {

		// BankName
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(testData.get("BankName"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(Keys.ENTER);

		// ApplicableAccountType
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType()
				.sendKeys(testData.get("ApplicableAccountType"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(Keys.ENTER);

//UploadFileExtension
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension()
				.sendKeys(testData.get("UploadFileExtension"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(Keys.ENTER);
//Separator
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(testData.get("Separator"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(Keys.ENTER);
//AllowUnadjusted
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(testData.get("AllowUnadjusted"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(Keys.ENTER);
//EffectiveDate
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate().click();
		while (true) {
			try {

				driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				bankRecon_ReconFormatObj.ARAPNextMonth().click();

			}
		}

		waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")),
				60, 2);
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.moveToElement(Click);
		clicksAndActionHelper.doubleClick(Click);

//AllowValueDate
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(testData.get("AllowValueDate"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//SummaryLineToBeSkipped
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped()
				.sendKeys(testData.get("SummaryLineToBeSkipped"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(Keys.ENTER);
//FileNamePrefix
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(testData.get("FileNamePrefix"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(Keys.ENTER);

	}

	@Then("^fill the Bank Reconciliation PlaceHolder$")
	public void fill_the_bank_reconciliation_placeholder() throws InterruptedException {
		// PlaceHolderInFile
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder().click();

		// PlaceHolderInFile
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile().click();

		// AccountNo

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton().click();

		// AddButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton().click();

		// PlaceHolderInFile second
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond().click();

		// ClosingBalance__RadioButton
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton().click();

		// AddButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton().click();

		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(testData.get("AccNoRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(testData.get("AccNoColumn"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(testData.get("AccNoLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox()
				.sendKeys(testData.get("AccNoPosition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(testData.get("AsOnDateRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox()
				.sendKeys(testData.get("AsOnDateColumn"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox()
				.sendKeys(testData.get("AsOnDateLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox()
				.sendKeys(testData.get("AsOnDatePosition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(Keys.ENTER);

		// PlaceHolderInFile Thrid
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird().click();

		// AsOnDate_RadioButton
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton().click();

		waithelper.waitForElement(driver, 3000,
				bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox()
				.sendKeys(testData.get("ClosingBalanceRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox()
				.sendKeys(testData.get("ClosingBalanceColumn"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox()
				.sendKeys(testData.get("ClosingBalanceLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox()
				.sendKeys(testData.get("ClosingBalancePosition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Click on Inventory Item Save button$")
	public void click_on_inventory_item_save_button() throws InterruptedException {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save(), 60, 2);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

	}

	@Then("^File Data matching rule$")
	public void file_data_matching_rule() throws Throwable {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(testData.get("FileName"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(testData.get("SystemDataPoint"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(testData.get("DataType"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(testData.get("DateFormate"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(testData.get("FixedLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("Position"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(testData.get("BlankSpacePadding"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(testData.get("MatchCondition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);

	}

	@Then("^click back button$")
	public void click_back_button() throws Throwable {

		for (int i = 0; i < 100; i++) {
			try {
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton().click();
				break;
			} catch (Exception e) {
				Assert.fail();
			}
		}

	}

	@Then("^File Transaction Data matching rule$")
	public void file_transaction_data_matching_rule() throws Throwable {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(testData.get("FileNameTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(testData.get("SystemDataPointTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(testData.get("DataTypeTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(testData.get("DateFormateTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(testData.get("FixedLengthTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("Position"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding()
				.sendKeys(testData.get("BlankSpacePaddingTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(testData.get("MatchConditionTrans"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);

	}

	@Then("^File Deposit Data matching rule$")
	public void file_deposit_data_matching_rule() throws Throwable {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(testData.get("FileNameDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(testData.get("SystemDataPointDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(testData.get("DataTypeDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(testData.get("FixedLengthDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum()
				.sendKeys(testData.get("BlankSpacePaddingDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("PositionDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().sendKeys(testData.get("Soundex"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(testData.get("MatchConditionDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);

//		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition());
//		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().click();
//		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(testData.get("TranspositionCondition"));
//		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(Keys.ENTER);

	}

	@Then("^File Withdrawals Data matching rule$")
	public void file_withdrawals_data_matching_rule() throws Throwable {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(testData.get("FileNameWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(testData.get("SystemDataPointWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(testData.get("DataTypeWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(testData.get("FixedLengthWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum()
				.sendKeys(testData.get("BlankSpacePaddingWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("PositionWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().sendKeys(testData.get("Soundex"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Soundex().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(testData.get("MatchConditionWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);

	}

	@Then("^Click on Inventory Item Notification$")
	public void click_on_inventory_item_notification() {
		// Notification
		for (int i = 0; i < 100; i++) {
			try {
				clicksAndActionHelper.moveToElement(makerObj.ARAP_Notification_Close());
				makerObj.ARAP_Notification_Close().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail();
				}
			}
		}
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification().click();

	}

	@And("^User Enter BankRecon Event Name$")
	public void User_Enter_BankRecon_Event_Name() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.eventCode(), 60, 2);
		bankRecon_ReconFormatObj.eventCode().click();
		bankRecon_ReconFormatObj.eventCode().sendKeys("Bank");
	}

	@And("^Select and Submit the record$")
	public void select_and_submit_the_record() throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_01_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
//	        for (int i = 1; i <= 35; i++) {
//	        		try {
//	        	    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("referanceID")+ "')]")));	
//	        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("referanceID") + "')]"));	
//	        			referanceID.click();
//	        	    	System.out.println(referanceID);
//	        	    	//Assert.assertTrue(referanceID.isDisplayed());
//	        			break;
//	        		} catch (NoSuchElementException e) 
//	        		{
//	        			waithelper.waitForElement(driver,4000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());
//	        			
//	        			inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
//	        		}
//	        	 
//	        	
//	        	
//	        	}
//	           inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();	    	

		// pencil

		for (int i = 0; i < 100; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID")
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"))
						.click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail();
				}
			}

		}

		// Submit button
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		javascripthelper.JSEClick(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker(), 60, 2);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
//	        	Thread.sleep(3000);

		// REVIEWER
//	        			waithelper.waitForElement(driver, 5000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_01_D1", "ReviewerID", reviewerId);
		// jsonWriter = new JsonDataReaderWriter();
		// jsonWriter.addData(reviewerId);

	}

	@And("^Select and Submit the records$")
	public void select_and_submit_the_records() throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_04_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
//	        for (int i = 1; i <= 35; i++) {
//	        		try {
//	        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));	
//	        			referanceID.click();
//	        	    	System.out.println(referanceID);
//	        	    	//Assert.assertTrue(referanceID.isDisplayed());
//	        			break;
//	        		} catch (NoSuchElementException e) 
//	        		{
//	        			waithelper.waitForElement(driver,4000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());
//	        			
//	        			inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
//	        		}
//	        	 
//	        	
//	        	
//	        	}
//	           inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();	    	

		// pencil
		for (int i = 0; i < 100; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID")
						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"))
						.click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail();
				}
			}

		}

		// Submit button
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		javascripthelper.JSEClick(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
//	        	Thread.sleep(3000);

		// REVIEWER
//	        			waithelper.waitForElement(driver, 5000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_04_D1", "ReviewerID", reviewerId);
		// jsonWriter = new JsonDataReaderWriter();
		// jsonWriter.addData(reviewerId);

	}

	@Then("^log in to the reviewer account1$")
	public void log_in_to_the_reviewer_account1() throws IOException, ParseException {
		// reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}

	@Then("^log in to the Checker Account2$")
	public void log_in_to_the_checker_account2() throws InterruptedException {

		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");

	}

	@And("^then checker claim the record1$")
	public void then_checker_claim_the_record1() throws InterruptedException, IOException, ParseException {

		// open pool
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

		// claim
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^click on the Notification select the record and Approve$")
	public void click_on_the_notification_select_the_record_and_approve()
			throws InterruptedException, IOException, ParseException {
		waithelper.waitForElementToVisibleWithFluentWait(driver, reviewer.reviewerNotidicationIcon(), 60, 2);
		reviewer.reviewerNotidicationIcon().click();
	
//		for (int i = 1; i <= 135; i++) {
//			try {
//				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")).click();
//				break;
//			} catch (Exception e) {
//				kubschecker.checker_notification_next_button().click();
//			}
//		}

		for (int i = 0; i < 100; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button")).click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail();
				}
			}

		}
		// Approve
//			waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();

//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");

//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}

	@And("^select the record and Approve by checker$")
	public void select_the_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		for (int i = 1; i <= 35; i++) {
			try {
//			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				waithelper.waitForElementwithFluentwait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Approve
//	    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("OK");
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(3000);
	}

	@Then("^user update the Excel sheet testdata for BankRecon$")
	public void user_update_the_excel_sheet_testdata_for_bankrecon() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_BRS_UAT_001_001_TC_001_01_D1");
	}

	@Then("^user update the Excel sheet testdata for BankRecon1$")
	public void user_update_the_excel_sheet_testdata_for_bankrecon1() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_BRS_UAT_001_001_TC_001_04_D1");
	}

	@Then("^user update the Excel sheet testdata for BankRecon2$")
	public void user_update_the_excel_sheet_testdata_for_bankrecon2() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_TAX_UAT_002_003_TC_002_D1");
	}
	
	@Then("^history must be correctly maintained on record$")
	public void history_must_be_correctly_maintained_on_record() throws Throwable {
//	    	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next());
//			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next().isDisplayed();

		// BankName
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName1(), 60, 2);
		String BNM = bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName1().getText();
		System.out.println("The Bank Name :" + BNM);

	}

	@Then("^select the active record$")
	public void select_the_active_record() {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord().click();
	}

	@Then("^Inactivate the record$")
	public void inactivate_the_record() {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(testData.get("FormatStatus"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(Keys.ENTER);

	}
	
	
	//-------- @KUBS_TAX_UAT_002_001_TC_003------------
	
		@And("^user should navigate to bank recon menu$")
		public void user_should_navigate_to_bank_recon_menu()  {
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankReconciliationMenu());
			bankRecon_BankReconciliationObj.BankReconciliationMenu().click();
		}
		@When("^click on eye button of bank reconciliation$")
	    public void click_on_eye_button_of_bank_reconciliation() {
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton().click();
			
	    }
		
		@And("^click on add button for bank reconciliation$")
		public void click_on_add_button_for_bank_reconciliation() {
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton().click();
		}
		@And("^Fill the required fields and upload bank statement for bank reconciliation$")
		public void fill_the_required_fields_and_upload_bank_statement_for_bank_reconciliation() throws InterruptedException, IOException {
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(testData.get("BankName"));
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(Keys.ENTER);
			
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().click();
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(testData.get("AccountNumber"));
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom().click();
			
			while (true) {
				try {
					
					driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReconPeriodFromMonth") + " " + testData.get("ReconYear") + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					bankRecon_BankReconciliationObj.NextMonth().click();

				}
			}
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
					+ testData.get("ReconPeriodFromFullMonth") + " " + testData.get("ReconPeriodFromDay") + ", " + testData.get("ReconYear") + "']/span")));
			WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ReconPeriodFromFullMonth") + " "
					+ testData.get("ReconPeriodFromDay") + ", " + testData.get("ReconYear") + "']/span"));

			clicksAndActionHelper.doubleClick(Click);
		
			
			waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo(), 60, 2);
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo().click();
			
			
			while (true) {
				try {

					driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReconPeriodToMonth") + " " + testData.get("ReconYear") + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					bankRecon_BankReconciliationObj.NextMonth().click();

				}
			}
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
					+ testData.get("ReconPeriodToFullMonth") + " " + testData.get("ReconPeriodToDate") + ", " + testData.get("ReconYear") + "']/span")));
			WebElement Click1 = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ReconPeriodToFullMonth") + " "
					+ testData.get("ReconPeriodToDate") + ", " + testData.get("ReconYear") + "']/span"));

			clicksAndActionHelper.doubleClick(Click1);
			
			waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile());
			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().sendKeys("C:\\Users\\ININDC00075\\git\\Arshath_Excel_AzentioAutomationFramework\\AzentioAutomationFramework_ARAP_Excel_Arshath\\BankReconTextCsvFiles\\HDFC_123.txt");
//			bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().click();
			
			
			//By using AUTO IT Method
//			Thread.sleep(7000);
//			Runtime.getRuntime().exec("C://Users/inindc00091/Desktop/IDFC_REC_A11.exe"+" "+"C:\\Users\\inindc00091\\Downloads\\IDFC_REC_A11.txt");
//			Thread.sleep(1000);
			
			waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	
	    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	    	System.out.println(message);
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		}
	    @Then("^Save and click on process$")
	    public void save_and_click_on_process() throws InterruptedException {
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton().click();
	    	
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	    	String toastmessage = javascripthelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	    	System.out.println(toastmessage);
	    	
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton().click();
//	    	alertHelper.getAlert();
//	    	Thread.sleep(1000);
	    	alertHelper.isAlertPresent();
	    	String alertText = alertHelper.getAlertText();
	    	alertHelper.AcceptAlert();
	    }

	    @Then("^Verify the Unmatch Record Tab must display all the entries for unmatched records from Book$")
	    public void verify_the_unmatch_record_tab_must_display_all_the_entries_for_unmatched_records_from_book() throws Throwable {
	        
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
	    	
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch().click();
	    	Thread.sleep(1000);
	    	javascripthelper.JavaScriptHelper(driver);
//	    	javascripthelper.scrollToElemetAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
	    	javascripthelper.scrollIntoViewAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
	    	
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Unmatched");
	    	Thread.sleep(2000);
	    	String unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
	    	String unmatchedCount = "";
	    	String ar[] = unmatched.split(" ");
	    	unmatchedCount=ar[0];
	    	int unmatchedDataCount = Integer.parseInt(unmatchedCount);
	    	if(unmatchedDataCount==0)
	    	{
	    		System.out.println("No Matched Data Display");
	    	}else{
	    		System.out.println("Total "+unmatchedDataCount+" Unmatched Data Display");
	    	}
	    	
	    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Suggested");
	    	Thread.sleep(2000);
	    	String suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
	    	String suggestedCount = "";
	    	String ar1[] = suggested.split(" ");
	    	suggestedCount=ar1[0];
	    	int suggestedDataCount = Integer.parseInt(suggestedCount);
	    	if(suggestedDataCount==0)
	    	{
	    		System.out.println("No Matched Data Display");
	    	}else{
	    		System.out.println("Total "+suggestedDataCount+" Suggested Data Display");
	    	}
	    	
	    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
	    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
	    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Transposition");
	    	
	    	Thread.sleep(2000);
	    	String transpostion = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
	    	String transpositionCount = "";
	    	String ar2[] = transpostion.split(" ");
	    	transpositionCount=ar2[0];
	    	int transpositionDataCount = Integer.parseInt(transpositionCount);
	    	if(transpositionDataCount==0)
	    	{
	    		System.out.println("No Matched Data Display");
	    	}else{
	    		System.out.println("Total "+transpositionDataCount+" Transposition Data Display");
	    	}
	    	
    	
	    }
	    
	    
	    @Then("^Select Bank Name and Account Number$")
	    public void select_bank_name_and_account_number() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName());
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().click();
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(testData.get("BankNameRecon"));1
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(Keys.ENTER);
	    
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber());
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().click();
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(testData.get("AccountNumberRecon"));1
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(Keys.ENTER);
	    
	    }  
	    
	    
	    @Then("^Select Recon period from$")
	    public void select_recon_period_from() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate());
		bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate().click();
		
		javascripthelper.JavaScriptHelper(driver);
		while(true)
	    {
		try
		{
			
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ReconPeriodFromMonth")+" "+testData.get("ReconYear")+"')]")));
		WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ReconPeriodFromMonth")+" "+testData.get("ReconYear")+"')]"));
		break;
			
		}
			
	    catch(NoSuchElementException nosuchElement)
		{
		bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ReconPeriodFromFullMonth")+" "+testData.get("ReconPeriodFromDay")+", "+testData.get("ReconYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);   
	    }
	    
	    @Then("^Select Recon period to$")
	    public void select_recon_period_to() throws Throwable {
	    Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate());
		bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate().click();

		
			while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ReconPeriodToMonth")+" "+testData.get("ReconYear")+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ReconPeriodToMonth")+" "+testData.get("ReconYear")+"')]"));
			    break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
			}
			}
			WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ReconPeriodToFullMonth")+" "+testData.get("ReconPeriodToDate")+", "+testData.get("ReconYear")+"']/span"));
			clicksAndActionHelper.doubleClick(FinalDay2); 
			 Thread.sleep(2000); 
			//// waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
			// bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(testData.get("ChooseFile);
	    }
	    
	    @Then("^upload the file$")
	    public void upload_the_file() throws Throwable {
	    
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
	  
	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(bankRecon_ReconFormatTestDataType.ChooseFile);
	    Thread.sleep(2000);      
	    }   
	    
	    @Then("^verify unmatch record$")
	    public void verify_unmatch_record() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab().click();
	    Thread.sleep(2000); 
	    //suggested record
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
	    
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord().isDisplayed();
	    Thread.sleep(1000);
	    javascripthelper.JavaScriptHelper(driver);
	    javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
	    Thread.sleep(1000);
	    
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
	    
	    //Transposition
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec().click();
	    
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord());
	    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord().isDisplayed();
	    Thread.sleep(1000);
	    //javascripthelper.JavaScriptHelper(driver);
	   // javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
	    //Thread.sleep(1000);
	    
	    
	    }   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}