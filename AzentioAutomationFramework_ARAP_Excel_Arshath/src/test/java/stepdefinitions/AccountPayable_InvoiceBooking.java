package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class AccountPayable_InvoiceBooking {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","ARAP_InvoiceBoooking", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	
  @When("^click on eye button of invoice booking$")
  public void click_on_eye_button_of_invoice_booking() {
  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(),15,1);
  aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
  }
  
  @When("^click on temp grid button of invoice booking$")
  public void click_on_temp_grid_button_of_invoice_booking() {
  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton(),15,1);
  aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TempGridButton().click();
  }

  @And("^click on add button for invoice booking$")
  public void click_on_add_button_for_invoice_booking() {
  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton(),15,1);
  aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_AddButton().click();
  }
  @And("^user update the data set ID for invoice booking$")
  public void user_update_the_data_set_id_for_invoice_booking() {
  testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_009_01_D1");   
  }
  @And("^Fill the required fields for invoice booking$")
  public void fill_the_required_fields_for_invoice_booking() {
	  Random random = new Random();
  javascripthelper.JavaScriptHelper(driver);
  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch(),15,1);
  aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(testData.get("EntityBranch"));
  aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_EntityBranch().sendKeys(Keys.ENTER);
  
waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(testData.get("InvoiceType"));
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
	
 waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(testData.get("InvoiceSubType"));
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);

  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(testData.get("BPName"));
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.DOWN);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_BP_Name().sendKeys(Keys.ENTER);

  waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(testData.get("CostCenter"));
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_CostCenter().sendKeys(Keys.ENTER);
  
int randomNum=random.nextInt(5000-2500)+2500;
waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(testData.get("SupplierReferenceNumber")+randomNum);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_SupplierReferenceNumber().sendKeys(Keys.ENTER);

waithelper.waitForElementToVisibleWithFluentWait(driver,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate(),15,1);
aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceDate().click();


  
  }
}
