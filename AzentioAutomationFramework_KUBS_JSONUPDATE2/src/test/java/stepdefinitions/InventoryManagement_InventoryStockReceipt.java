package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.InventoryManagement_InventoryStockReceiptObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;

public class InventoryManagement_InventoryStockReceipt  extends BaseClass{
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
		AzentioLogin login;
		InventoryManagement_InventoryStockReceiptObj inventoryManagement_InventoryStockReceiptObj = new InventoryManagement_InventoryStockReceiptObj(driver);
		InventoryManagement_InventoryStockReceiptTestDataType inventoryManagement_InventoryStockReceiptTestDataType = new InventoryManagement_InventoryStockReceiptTestDataType();

		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
		Azentio_ReviewerObj reviewer;
		BrowserHelper browserHelper;
		String referance_id;
		String user = "Maker";
		Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
		BUDGET_BudgetCreationTestDataType budgetdata;
		ConfigFileReader config=new ConfigFileReader();
		
		
		
		
		@Then("^Click on Inventory Management$")
	    public void click_on_inventory_management() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		javascripthelper.scrollIntoViewAndClick(inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());
	        
	    }

	    @Then("^Click on inventory stock receipt Eye Icon$")
	    public void click_on_inventory_stock_receipt_eye_icon() throws InterruptedException  {
//	    Thread.sleep(2000);
	    waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton());
	    WebElement EyeIcon = inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton();
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton());
	  	Assert.assertTrue(inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().isDisplayed());
	  	clicksAndActionHelper.moveToElement(EyeIcon);
	  	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().click();
		       
	    }

	    @Then("^Click on inventory stock Add button$")
	    public void click_on_inventory_stock_add_button() throws InterruptedException  {
//	    Thread.sleep(2000);
//	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton());
	    inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton().click();
	       
	    }
	    

	    @Then("^Fill inventory stock Mandatory fields$")
	    public void fill_inventory_stock_mandatory_fields() throws IOException, ParseException  {
	    inventoryManagement_InventoryStockReceiptTestDataType = jsonReader.getInventoryStockReceiptByName("Maker");
	    //GRN Number
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().click();
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(jsonWriter.readInventoryManagementGRNnumber());
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(Keys.ENTER);
	 	
	 	//Accepted Quantity
//	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity());
//	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().click();
//	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(inventoryManagement_InventoryStockReceiptTestDataType.AcceptedQuantity);
//	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(Keys.ENTER);
	    
	    }
	    
	    @Then("^Click on inventory stock Save button$")
	    public void click_on_inventory_stock_save_button()  {
//	  	waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save());
	  	waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save());
	  	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save().click();
	  	
//	  	waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagament_InventoryRequest_PopupCloseButton());
//	  	inventoryManagement_InventoryStockReceiptObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
//	  	
	    }

	    @Then("^Click on inventory stock Notification$")
	    public void click_on_inventory_stock_notification()  {
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification().click();
	       
	    }
	    
	    @Then("^click on first eye button to get the grn number$")
		public void click_on_first_eye_button_to_get_the_grn_number() throws InterruptedException, IOException {
			
			javascripthelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 2000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_FirstEyeButton());
			inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_FirstEyeButton().click();
			Thread.sleep(2000);
			String grnnumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
			System.out.println("GRN Number: " + grnnumber);
			jsonWriter.addInventoryManagementGRNnumber(grnnumber);

		}
		

}
