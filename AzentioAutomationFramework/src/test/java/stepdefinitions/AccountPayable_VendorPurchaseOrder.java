package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
//import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
//import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;

public class AccountPayable_VendorPurchaseOrder extends BaseClass {
	
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	//maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
		
		AzentioLogin login;
		AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);

		/*AccountPayable_VendorPurchaseOrderTestDataType accountPayable_VendorPurchaseOrderTestDataType = new AccountPayable_VendorPurchaseOrderTestDataType();

		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
		Azentio_ReviewerObj reviewer;
		BrowserHelper browserHelper;
		String referance_id;
		String user = "Maker";
		Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
		BUDGET_BudgetCreationTestDataType budgetdata;*/
		
		//getVendorPurchaseOrderyByName
		
		 @Then("^Click on Direction icon$")
		 public void click_on_direction_icon() throws InterruptedException {
		 waithelper = new WaitHelper(driver) ;
		Thread.sleep(2000);
		 waithelper.waitForElement(driver, 4000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon().click();
    
		    }
}
		/* @Then("^Click on Account Payable$")
		 public void click_on_account_payable()  {
	     waithelper.waitForElement(driver, 4000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField());
		 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField().click();
			
		   }
		 
		 @Then("^Click on purchase order Eye Icon$")
		 public void click_on_purchase_order_eye_icon()  {
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();
				
		       
		    }

		 @Then("^Click on purchase order Add button$")
		 public void click_on_purchase_order_add_button()  {
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton().click();
				
		        
		    }
		 
		 @Then("^Fill purchase order Mandatory fields$")
		    public void fill_purchase_order_mandatory_fields() throws InterruptedException  {
			 accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
			 
			 //Entity Branch
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.EntityBranch);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(Keys.ENTER);
		    
		     //BP Name
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.BpName);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
		    
		     //Reference Type
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ReferenceType);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
		

			 //Contract
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.Contract);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);
		
			 //CheckBox Po Item
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().click();
			
			//Po Quantity
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoQuantity);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.ENTER);
		
			//Po item save
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave().click();
			
			// Po item save
			//waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber());
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().click();
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoNumber);
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().sendKeys(Keys.ENTER);
		
			 //Po Sub Type
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoSubType);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.ENTER);
		
			
			
			 //cost Center
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.CostCenter);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter().sendKeys(Keys.ENTER);
	
		 }
		 
		 @Then("^Click on Account Payable Save button$")
		 public void click_on_account_payable_save_button() {
	     waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save());
         accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save().click();
			
		 }

		/* 
		@Then("^Click on item Details$")
		public void click_on_item_details() throws Throwable {
		// Asset Items
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetails());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetails().click();

		}*/

		//@Then("^Click on Item Details Record$")
		//public void click_on_item_details_record() throws InterruptedException {
			
			//Thread.sleep(2000);
			/*waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord());
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord().click();

			//validate msg
			
	  		WebElement toast = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg();
	  		waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg());
	  		clicksAndActionHelper.clickOnElement(toast);;
	    	String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg().getText();
	    	System.out.println(message);
	    	
		}
		
		@Then("^Edit the item details fields$")
		public void edit_the_item_details_fields() {

			accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");

			//Shipped from Location
			waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation());
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ShippedFromLocation);
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(Keys.ENTER);
			
			//DeliveryLocation
			waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation());
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.DeliveryLocation);
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(Keys.ENTER);

		}
		@Then("^Click on Account Payable Notification$")
		 public void click_on_account_payable_notification() {
		 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Notification());
        accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Notification().click();
		}
		 
		 @Then("^Select the record from Notification$")
		 public void select_the_record_from_notification() throws Throwable {
			// Reference
			waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId());
			String id = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().getText();
			jsonWriter.addReferanceData(id);
			System.out.println("Reference ID:" + id);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
					referanceID.click();
					System.out.println(referanceID);
					// Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waithelper.waitForElement(driver, 4000,
							accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NotificationNext_Button());

					accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NotificationNext_Button().click();
				}
			}
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().click();

			// pencil
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			waithelper.waitForElement(driver, 2000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		}
		 
		@And("^Submit the Selected record$")
		public void submit_the_selected_record() throws InterruptedException, IOException {
			
			// Submit button
        	waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton().click();
        			
        	//Remark
        	javascripthelper.JavaScriptHelper(driver);
        	waithelper.waitForElement(driver, 3000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
        	javascripthelper.JSEClick(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField().sendKeys("OK");
        	//inventoryMaintenanceTestDataType.Remark
        			    
        			
        	//Remark Submit
        	
        	waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker().click();
        	Thread.sleep(2000);
        	
        	// REVIEWER
        			Thread.sleep(2000);
        			WebElement recordstatus = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();

        			clicksAndActionHelper.moveToElement(recordstatus);
        			String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().getText();
        			System.out.println(message);
        			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
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
        			jsonWriter = new JsonDataReaderWriter();
        			jsonWriter.addData(reviewerId);
			
		}
		 
//------------------PO QUANTITY GREATER ---//
		@Then("^Fill purchase order fields$")
	    public void fill_purchase_order_fields()  {
			accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
			 
			 //Entity Branch
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.EntityBranch);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(Keys.ENTER);
		    
		     //BP Name
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.BpName);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
		    
		     //Reference Type
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ReferenceType);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
		

			 //Contract
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.Contract);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);
		
	    }

	    @Then("^Enter Po Quantity$")
	    public void enter_po_quantity() throws InterruptedException  {
	    	//CheckBox Po Item
			waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem());
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().click();
			accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
			//Po Quantity excess
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoQuantityGreater);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.ENTER);
		
			Thread.sleep(2000);
		  	//WebElement toast = driver.findElement(By.xpath("//body/div/div/div/div[1]"));
		  	WebElement toast = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg();

		  	waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg());
		  	Assert.assertTrue(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg().isDisplayed());
		  	clicksAndActionHelper.moveToElement(toast);
		    String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg().getText();
		    System.out.println(message);
		    	
	    
	    }	
	    
	    
	    //---//
	    @Then("^enter the PO service type details$")
	    public void enter_the_po_service_type_details() throws InterruptedException  {
	    	accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
	    	//Entity Branch
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.EntityBranch);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(Keys.ENTER);
		    
		     //BP Name
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.BpName);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
		    
			 //PO type
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoTypeSerivce);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(Keys.ENTER);
		    
			//PO Sub type
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoSubTypeService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.ENTER);
		    
			//CostCenterService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenterService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenterService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenterService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.CostCenterService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenterService().sendKeys(Keys.ENTER);
		    
			 
			 //Po Delivery Date
			 Thread.sleep(2000);
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PODeliveryDate());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PODeliveryDate().click();
			
			 
			 javascripthelper.JavaScriptHelper(driver);
				while(true)
		        {
					try
					{
						//span[contains(text(),'Nov 2022')]
						 Thread.sleep(2000);
						waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+accountPayable_VendorPurchaseOrderTestDataType.Month+" "+accountPayable_VendorPurchaseOrderTestDataType.Year+"')]")));
						 WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+accountPayable_VendorPurchaseOrderTestDataType.Month+" "+accountPayable_VendorPurchaseOrderTestDataType.Year+"')]"));
					    break;
					}
					
					catch(NoSuchElementException nosuchElement)
					{
						accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NextMonth().click();
					}
				}
				//td[@aria-label='November 1, 2022']/span
				WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+accountPayable_VendorPurchaseOrderTestDataType.FullMonth+" "+accountPayable_VendorPurchaseOrderTestDataType.Day+", "+accountPayable_VendorPurchaseOrderTestDataType.Year+"']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
				
			
	    }
	    
	    @Then("^fill the item details PO Amount is equal or lesser than contract Amount$")
	    public void fill_the_item_details_po_amount_is_equal_or_lesser_than_contract_amount() {
	    	accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
	    	//HSNcodeService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_HSNcodeService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_HSNcodeService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_HSNcodeService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.HSNcodeService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_HSNcodeService().sendKeys(Keys.ENTER);
		     
			//ExpensecodeService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ExpensecodeService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ExpensecodeService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ExpensecodeService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ExpensecodeService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ExpensecodeService().sendKeys(Keys.ENTER);
		     
			//QuantityService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_QuantityService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_QuantityService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_QuantityService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.QuantityService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_QuantityService().sendKeys(Keys.ENTER);
		     
			//UnitService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_UnitService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_UnitService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_UnitService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.UnitService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_UnitService().sendKeys(Keys.ENTER);
		     
			//RatePerUnitService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.RatePerUnit);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService().sendKeys(Keys.ENTER);
		     
			//ShippedLocationService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedLocationService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedLocationService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedLocationService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ShippedLocationService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedLocationService().sendKeys(Keys.ENTER);
		     
			//DeliveryLocationService
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocationService());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocationService().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocationService().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.DeliveryLocationService);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocationService().sendKeys(Keys.ENTER);
		     
			//AutoGenerateBill
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoGenerateBill());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoGenerateBill().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoGenerateBill().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.AutoGenerateBill);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoGenerateBill().sendKeys(Keys.ENTER);
		     
			
			 
	    }
	    @Then("^fill Beneficiary Details$")
	    public void fill_beneficiary_details()  {
	    	
	    	accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
	    	//ModeOfPayement
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ModeOfPayement);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().sendKeys(Keys.ENTER);
		     
			//AutoPayout
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.AutoPayout);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().sendKeys(Keys.ENTER);
		     
			//CreditPeriod
			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod());
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().click();
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.CreditPeriod);
			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().sendKeys(Keys.ENTER);
		     	
	     
	    }
	    @Then("^Click on Beneficiary Save button$")
	    public void click_on_beneficiary_save_button()  {
	    waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave());
	    accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave().click();
			   
	    }
	    @And("^Submit the Selected final record$")
	    public void submit_the_selected_final_record() throws InterruptedException, IOException {
	    
	    
		// Submit button
    	waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_MakerSubmitFinal());
    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_MakerSubmitFinal().click();*/
    			
    	//Remark
    	//javascripthelper.JavaScriptHelper(driver);
    	/*waithelper.waitForElement(driver, 3000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
    	javascripthelper.JSEClick(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField().sendKeys("OK");
    	//inventoryMaintenanceTestDataType.Remark
    			    
    			
    	//Remark Submit
    	
    	waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker().click();
    	Thread.sleep(2000);
    	
    	// REVIEWER
    			Thread.sleep(2000);
    			WebElement recordstatus = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();

    			clicksAndActionHelper.moveToElement(recordstatus);
    			String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().getText();
    			System.out.println(message);
    			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
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
    			jsonWriter = new JsonDataReaderWriter();
    			jsonWriter.addData(reviewerId);
		
	}
	    */
	    
	    
	    
	    
	    
	    

