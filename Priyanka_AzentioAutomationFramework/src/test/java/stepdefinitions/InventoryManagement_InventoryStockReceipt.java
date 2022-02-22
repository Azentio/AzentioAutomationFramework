package stepdefinitions;

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
	    public void click_on_inventory_management() {
		waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField().click();
	        
	    }

	    @Then("^Click on inventory stock receipt Eye Icon$")
	    public void click_on_inventory_stock_receipt_eye_icon() throws InterruptedException  {
	    Thread.sleep(2000);
	    WebElement EyeIcon = inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton();
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton());
	  	Assert.assertTrue(inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().isDisplayed());
	  	clicksAndActionHelper.moveToElement(EyeIcon);
	  	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().click();
	    	
		       
	    }

	    @Then("^Click on inventory stock Add button$")
	    public void click_on_inventory_stock_add_button() throws InterruptedException  {
	    Thread.sleep(2000);
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton().click();
		        
	       
	    }
	    

	    @Then("^Fill inventory stock Mandatory fields$")
	    public void fill_inventory_stock_mandatory_fields()  {
	    inventoryManagement_InventoryStockReceiptTestDataType = jsonReader.getInventoryStockReceiptByName("Maker");
	    //GRN Number
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().click();
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(inventoryManagement_InventoryStockReceiptTestDataType.GRNNumber);
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(Keys.ENTER);
	 	
	    
	 	//Accepted Quantity
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity());
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().click();
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(inventoryManagement_InventoryStockReceiptTestDataType.AcceptedQuantity);
	 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(Keys.ENTER);
	 	
	    
	    }
	    
	    @Then("^Click on inventory stock Save button$")
	    public void click_on_inventory_stock_save_button()  {
	  	waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save());
	  	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save().click();
		   
	    }

	    @Then("^Click on inventory stock Notification$")
	    public void click_on_inventory_stock_notification()  {
	    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification().click();
	       
	    }
		

}
