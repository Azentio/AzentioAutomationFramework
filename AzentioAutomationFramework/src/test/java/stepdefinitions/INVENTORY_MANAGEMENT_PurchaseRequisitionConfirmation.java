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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
//import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
//import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType;

public class INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	//ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType=jsonReader.getVendorContractdata("Maker");
	INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType PurchaseRequisitionConfirmationTestDataType=jsonReader.getPurchaseRequisitionConfirmationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@And("^user should navigate to inventory management$")
    public void user_should_navigate_to_inventory_management(){
		
		/*waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();*/
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu().click();
    }
	
	@When("^click on eye button of purchase requisition confirmation$")
    public void click_on_eye_button_of_purchase_requisition_confirmation() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_EyeButton());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_EyeButton().click();
    }
	
	@And("^click on add button  of purchase requisition confirmation$")
	public void click_on_add_button_of_purchase_requisition_confirmation() {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_AddButton());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_AddButton().click();
	}
	
	@And("^Fill the required fields to purchase req$")
	public void fill_the_required_fields_to_purchase_req()  {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode());
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode().sendKeys(PurchaseRequisitionConfirmationTestDataType.ItemCode);
		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_ItemCode().sendKeys(Keys.ENTER);
	}

    @Then("^Save and submit the purchase req confirmation$")
    public void save_and_submit_the_purchase_req_confirmation() throws InterruptedException, IOException, ParseException {
    	
    	iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagement_PurchaseRequisitionConfirmation_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
    	/*waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus0 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus0);
    	
    	String message0 = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message0);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	
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
    	
    	/*waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(aCCOUNTSPAYABLE_VendorContractsTestDataType.RemarkByMaker);
		
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
		jsonWriter.addData(reviewerId);*/
		
    }
    
    @Then("^click on first eye button to get the indent reference number$")
    public void click_on_first_eye_button_to_get_the_indent_reference_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		
		/*waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();*/
		Thread.sleep(2000);
		String indentrefnumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[6].value").toString();
    	System.out.println(" Unique Indent Reference Number is -: " +indentrefnumber);
       
    }
    @And("^maker should logout$")
    public void checker_should_logout()  {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ProfileName().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Logout();
    }
	
}
