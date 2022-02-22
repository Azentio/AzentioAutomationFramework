package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.INVENTORY_MAINTENANCE_DenominationMasterObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.INVENTORY_MAINTENANCE_DenominationMasterTestDataType;

public class INVENTORY_MAINTENANCE_DenominationMaster {
	
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	INVENTORY_MAINTENANCE_DenominationMasterObj iNVENTORY_MAINTENANCE_DenominationMasterObj = new INVENTORY_MAINTENANCE_DenominationMasterObj(driver);
	INVENTORY_MAINTENANCE_DenominationMasterTestDataType iNVENTORY_MAINTENANCE_DenominationMasterTestDataType=jsonReader.getDenominationMasterdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	@Given("^User should navigate to the kubs url and login as a maker user$")
	public void user_should_navigate_to_the_kubs_url_and_login_as_a_maker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}
	
	@And("^user should navigate to denomination master menu$")
	public void user_should_navigate_to_denomination_master_menu() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenanceMenu());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenanceMenu().click();
	}

	@When("^click on eye button of denomination master$")
	public void click_on_eye_button_of_denomination_master() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton().click();
	}
	
	@And("^click on add button to create denomination details$")
	public void click_on_add_button_to_create_denomination_details(){
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_AddButton());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_AddButton().click();
	}
	
	@And("^Fill the required fields to create denomination details$")
	public void fill_the_required_fields_to_create_denomination_details()  {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.InstrumentCode);
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.Currency);
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.DenominationType);
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubType());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubType();
		
//		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubTypeCoin().click();
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSequence());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSequence().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.DenominationSequence);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationValue());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationValue().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.DenominationValue);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationDescription());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationDescription().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.DenominationDescription);
		
//		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_ActionButton());
//		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_ActionButton().click();
	}

	@Then("^Save and submit the creation denomination details$")
	public void save_and_submit_the_creation_denomination_details() throws IOException, ParseException, InterruptedException  {
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	String t = "";
		String ar[] = message.split(" ");
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
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
		
	}

	@Then("^checker should approved the denomination details$")
	public void checker_should_approved_the_denomination_details()
			throws IOException, InterruptedException, ParseException {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer()
				.sendKeys(iNVENTORY_MAINTENANCE_DenominationMasterTestDataType.ApproveRemarkByReviewer);

		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
		Thread.sleep(2000);
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

	}
	@And("^checker should logout$")
    public void checker_should_logout()  {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_profilename());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_profilename().click();
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_Logout());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_Logout();
    }

}
