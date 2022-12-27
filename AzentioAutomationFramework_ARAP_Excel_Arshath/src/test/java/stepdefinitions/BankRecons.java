package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BankRecon_ReconFormatObj;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class BankRecons {
	WebDriver driver = BaseClass.driver;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx", "BankReconTestdata", "DataSet ID");
	Map<String, String>testData;
	BankRecon_ReconFormatObj bankRecon_ReconFormatObj = new BankRecon_ReconFormatObj(driver);
	// BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType =
	// jsonReader.getBankReconByName("Maker");
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper =new BrowserHelper(driver);
	Azentio_ReviewerObj reviewer =new Azentio_ReviewerObj(driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	//JsonDataReaderWriter reader = new JsonDataReaderWriter();
	Map<String, String> Getdata = new LinkedHashMap<>();
	

	@Then("^Click on Direction Left$")
	public void click_on_direction_left() {
		waithelper = new WaitHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft(), 60, 2);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft().click();

	}

	@Then("^Click on Bank Recon$")
	public void click_on_bank_recon() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormatField(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormatField().click();

	}

	@Then("^click on Bank Recon format eye button$")
	public void click_on_bank_recon_format_eye_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton().click();
	}

	@Then("^Click on Inventory Maintenance Add button$")
	public void click_on_inventory_maintenance_add_button() throws InterruptedException {
//    Thread.sleep(2000);
//    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryMaintenanceObj.inventoryMaintenance_AddButton(), 60, 2);
		inventoryMaintenanceObj.inventoryMaintenance_AddButton().click();

	}

	@Then("^fill the Bank Reconciliation Format$")
	public void fill_the_bank_reconciliation_format() throws InterruptedException {

		// BankName
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(testData.get("BankName"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(Keys.ENTER);

		// ApplicableAccountType
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType()
				.sendKeys(testData.get("ApplicableAccountType"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(Keys.ENTER);

//UploadFileExtension
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension()
				.sendKeys(testData.get("UploadFileExtension"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(Keys.ENTER);
//Separator
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(testData.get("Separator"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(Keys.ENTER);
//AllowUnadjusted
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted()
				.sendKeys(testData.get("AllowUnadjusted"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(Keys.ENTER);
//EffectiveDate
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate().click();
//Year Selection
		Thread.sleep(2000);
		String year1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[3]")).getText()
				.toString();
		List<WebElement> size1 = driver.findElements(By.xpath("//ion-picker-column[3]/div/button"));
		for (WebElement webElement : size1) {
			webElement.click();
			String year = webElement.getText();
			if (year.equalsIgnoreCase("2023")) {
				break;
			}
		}
//Month selection
		Thread.sleep(2000);
		String month1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[2]")).getText()
				.toString();
		List<WebElement> size2 = driver.findElements(By.xpath("//ion-picker-column[2]/div/button"));
		for (WebElement webElement2 : size2) {
			try {
				webElement2.click();
				String month = webElement2.getText();
				if (month.equalsIgnoreCase("Jun")) {
					break;
				}
			} catch (ElementNotInteractableException ee) {

			}

		}
//Date selection
		Thread.sleep(2000);
		String day1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[1]")).getText()
				.toString();
		List<WebElement> size3 = driver.findElements(By.xpath("//ion-picker-column[1]/div/button"));
		for (WebElement webElement3 : size3) {
			try {
				webElement3.click();
				String day = webElement3.getText();
				if (day.equalsIgnoreCase("09")) {
					break;
				}
			} catch (ElementNotInteractableException ee) {

			}
		}
//EffectiveDateDoneButton
		Thread.sleep(1500);
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton(), 60, 2);
		WebElement done = bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton();
		clicksAndActionHelper.clickOnElement(done);
		Thread.sleep(2000);

//AllowValueDate
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate()
				.sendKeys(testData.get("AllowValueDate"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//SummaryLineToBeSkipped
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped()
				.sendKeys(testData.get("SummaryLineToBeSkipped"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(Keys.ENTER);
//FileNamePrefix
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix()
				.sendKeys(testData.get("FileNamePrefix"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(Keys.ENTER);

	}

	@Then("^fill the Bank Reconciliation PlaceHolder$")
	public void fill_the_bank_reconciliation_placeholder() throws InterruptedException {
		// PlaceHolderInFile
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder().click();

		// PlaceHolderInFile
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile().click();

		// AccountNo
		
				waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton().click();

		// AddButton
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton().click();

		// PlaceHolderInFile second
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond().click();

		// ClosingBalance__RadioButton
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton().click();

		// AddButton
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton().click();

		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox()
				.sendKeys(testData.get("AccNoRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox()
				.sendKeys(testData.get("AccNoRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox()
				.sendKeys(testData.get("AccNoLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox()
				.sendKeys(testData.get("AccNoPosition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox()
				.sendKeys(testData.get("AsOnDateRow"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox()
				.sendKeys(testData.get("AsOnDateColumn"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox()
				.sendKeys(testData.get("AsOnDateLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox()
				.sendKeys(testData.get("AsOnDatePosition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(Keys.ENTER);

		// PlaceHolderInFile Thrid
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird(), 60, 2);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird().click();

		// AsOnDate_RadioButton
		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton(), 60, 2);
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

		waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save());
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
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint()
				.sendKeys(testData.get("SystemDataPoint"));
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
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength()
				.sendKeys(testData.get("FixedLength"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("Position"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding()
				.sendKeys(testData.get("BlankSpacePadding"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition()
				.sendKeys(testData.get("MatchCondition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);

	}

	@Then("^click back button$")
	public void click_back_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton().click();
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
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(testData.get("BlankSpacePaddingTrans"));
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
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("PositionDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(testData.get("BlankSpacePaddingDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(testData.get("MatchConditionDepo"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(testData.get("TranspositionCondition"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(Keys.ENTER);
		   
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
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(testData.get("PositionWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(testData.get("BlankSpacePaddingWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(testData.get("MatchConditionWith"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
		 
    }
	@Then("^Click on Inventory Item Notification$")
    public void click_on_inventory_item_notification()  {
    //Notification
     waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification());
     inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification().click();
     
    }
	 @And("^Select and Submit the record$")
	    public void select_and_submit_the_record() throws InterruptedException, IOException, ParseException  {
	      
	   //Reference
	    	waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
	    	String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
	        //jsonWriter.addReferanceData(id);
	    	Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_03_D1", "ReferenceID", id);
	        System.out.println("Reference ID:" +id);
	        Thread.sleep(1000);
	        for (int i = 1; i <= 35; i++) {
	        		try {
	        	    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("referanceID")+ "')]")));	
	        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("referanceID") + "')]"));	
	        			referanceID.click();
	        	    	System.out.println(referanceID);
	        	    	//Assert.assertTrue(referanceID.isDisplayed());
	        			break;
	        		} catch (NoSuchElementException e) 
	        		{
	        			waithelper.waitForElement(driver,4000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());
	        			
	        			inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
	        		}
	        	 
	        	
	        	
	        	}
	           inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();	    	
	        	
	        	//pencil 
	        	 String before_xpath="//span[contains(text(),'";
	        	 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	        	  
	        	 waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID")+after_xpath)));
	        	 driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
	        	 
	        	
	        	// Submit button
	        	waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
	        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();
	        			
	        	//Remark
	        	javascripthelper.JavaScriptHelper(driver);
	        	waithelper.waitForElement(driver, 3000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
	        	javascripthelper.JSEClick(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
	        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys("OK");
	        	//inventoryMaintenanceTestDataType.Remark
	        			    
	        			
	        	//Remark Submit
	        	waithelper.waitForElement(driver, 2000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
	        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
//	        	Thread.sleep(3000);
	        	
	        	// REVIEWER
//	        			waithelper.waitForElement(driver, 5000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
	        			waithelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
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
	        			Exceldata.updateTestData("KUBS_BRS_UAT_001_001_TC_001_03_D1", "ReviewerID", reviewerId);
	        			//jsonWriter = new JsonDataReaderWriter();
	        			//jsonWriter.addData(reviewerId);
	       
	        }
	 @Then("^click on the Notification select the record and Approve$")
		public void click_on_the_notification_select_the_record_and_approve() throws InterruptedException, IOException, ParseException {
			//notification
			waithelper = new WaitHelper(driver);
			reviewer = new Azentio_ReviewerObj(driver);
			waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
			reviewer.reviewerNotidicationIcon().click();
			
			
			//select the record
			browserHelper = new BrowserHelper(driver);
			//budgetdata =  jsonReader.getBudgetdataByName("Maker");
			javascripthelper = new JavascriptHelper();
			Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
					WebElement referanceID = driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
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

			waithelper.waitForElement(driver, 5000,
					driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

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
	    public void select_the_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException  {
	    Thread.sleep(2000);
		for (int i = 1; i <= 35; i++) {
			try {
//			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
			referanceID.click();
			Assert.assertTrue(referanceID.isDisplayed());
			break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
				}
	    }
			String before_xpath="//span[contains(text(),'";
			String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			 
//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
			
			
			//Approve
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
		 testData = Exceldata.getTestdata("KUBS_BRS_UAT_001_001_TC_001_01_D1 ");	    
		 }
	 @Then("^history must be correctly maintained on record$")
	    public void history_must_be_correctly_maintained_on_record() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next().click(); 
			Thread.sleep(2000);
	    }
	 @Then("^select the active record$")
	    public void select_the_active_record()  {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord());
	 	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord().click();   
	    }
	 @Then("^Inactivate the record$")
	    public void inactivate_the_record()  {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().click();  
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(testData.get("FormatStatus"));
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(Keys.ENTER);
		   
	    }
		 
}