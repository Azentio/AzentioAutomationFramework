package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.InventoryMaintenanceTestDataType;




public class InventoryMaintenance extends BaseClass{
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
		AzentioLogin login;
		InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
		InventoryMaintenanceTestDataType inventoryMaintenanceTestDataType = new InventoryMaintenanceTestDataType();

		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
		Azentio_ReviewerObj reviewer;
		BrowserHelper browserHelper;
		String referance_id;
		String user = "Maker";
		Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
		BUDGET_BudgetCreationTestDataType budgetdata;
		
		 @Given("^Maker Navigate to UAT URL login$")
		    public void maker_navigate_to_uat_url_login() throws InterruptedException {
			login = new AzentioLogin(driver);
			driver.get(configFileReader.getApplicationUrl());
			login.loginToAzentioApp("Maker");
		       
		    }
		 	@Then("^Click on Direction Left$")
		    public void click_on_direction_left() {
		 	waithelper = new WaitHelper(driver) ;
		 	waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft());
		 	inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft().click();
		       
		    }

		    @Then("^Click on Inventory Maintenance$")
		    public void click_on_inventory_maintenance() throws InterruptedException{
		   
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceField());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceField().click();
		       
		    }

		    @Then("^Click on Inventory Item Master Eye Icon$")
		    public void click_on_inventory_item_master_eye_icon()  {
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_EyeButton());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_EyeButton().click();
		        
		    }

		    @Then("^Click on Inventory Maintenance Add button$")
		    public void click_on_inventory_maintenance_add_button() throws InterruptedException  {
		    Thread.sleep(2000);
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
		    inventoryMaintenanceObj.inventoryMaintenance_AddButton().click();
		        
		    }
		    
		    @Then("^Fill Inventory Item Mandatory fields$")
		    public void fill_inventory_item_mandatory_fields() throws InterruptedException{
		    inventoryMaintenanceTestDataType = jsonReader.getInventoryMaintenanceByName("Maker");
		    inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
		    
		   //Branch Code
		   waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode());
		   inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().click();
		   inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().sendKeys(inventoryMaintenanceTestDataType.BranchCode);
		   inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().sendKeys(Keys.ENTER);
		   
		    
		    //Item Code
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().sendKeys(inventoryMaintenanceTestDataType.ItemCode);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().sendKeys(Keys.ENTER);
		    
		    //Item Description
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription().sendKeys(inventoryMaintenanceTestDataType.ItemDescription);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription().sendKeys(Keys.ENTER);
		    
		    //Item Short Description
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription().sendKeys(inventoryMaintenanceTestDataType.ItemShortDescription);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription().sendKeys(Keys.ENTER);
		    
		    //Instrument Code
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode().sendKeys(inventoryMaintenanceTestDataType.InstrumentCode);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode().sendKeys(Keys.ENTER);
		    
		    //Currency Code
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode().sendKeys(inventoryMaintenanceTestDataType.CurrencyCode);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode().sendKeys(Keys.ENTER);
		     
		    //Reorder Level
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel().sendKeys(inventoryMaintenanceTestDataType.ReorderLevel);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel().sendKeys(Keys.ENTER);
		    
		    //Excess Level
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().sendKeys(inventoryMaintenanceTestDataType.ExcessLevel);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().sendKeys(Keys.ENTER);
		      
		    //Reorder Qty
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().sendKeys(inventoryMaintenanceTestDataType.ReorderQty);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().sendKeys(Keys.ENTER);
		    
		    //CurrentBalanceQuantity
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrentBalanceQuantity());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().click();
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().sendKeys(inventoryMaintenanceTestDataType.CurrentBalanceQuantity);
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().sendKeys(Keys.ENTER);
		    
		    //Qc Required
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_QcRequired());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_QcRequired().click();
		    
		    //Fill Indicator
		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_FillIndicator());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_FillIndicator().click();
		    
		    }

		    @Then("^Click on Inventory Item Save button$")
		    public void click_on_inventory_item_save_button() throws InterruptedException  {
		    	
		    //save
		    waithelper.waitForElement(driver, 2000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save());
		    inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save().click();
		   	Thread.sleep(2000);
		    javascripthelper.JavaScriptHelper(driver);
		    String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
		    System.out.println("Message:" +str);
		       
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
		        jsonWriter.addReferanceData(id);
		        System.out.println("Reference ID:" +id);
		        for (int i = 1; i <= 35; i++) {
		        		try {
		        	    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
		        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
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
		        	  
		        	 waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		        	 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
		        	 
		        	
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
		        	Thread.sleep(3000);
		        	
		        	// REVIEWER
		        			Thread.sleep(2000);
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
		        			jsonWriter = new JsonDataReaderWriter();
		        			jsonWriter.addData(reviewerId);
		       
		        }
		    
				@Then("^log in to the reviewer account$")
				public void log_in_to_the_reviewer_account() throws IOException, ParseException {
					reader = new JsonDataReaderWriter();
					login = new AzentioLogin(driver);
					driver.get(config.getApplicationUrl());
					login.logintoAzentioappReviewer("Reviewer", reader.readdata());
						 
					

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
					budgetdata =  jsonReader.getBudgetdataByName("Maker");
					javascripthelper = new JavascriptHelper();
					Thread.sleep(1000);
					for (int i = 1; i <= 35; i++) {
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(
									By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
							WebElement referanceID = driver.findElement(
									By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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
							driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
					driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

					// Approve
					waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
					reviewer.reviewerApproveButton().click();
					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
					reviewer.reviewerAlertRemarks().sendKeys("ok");
					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
					reviewer.reviewerAlertSubmitButton().click();
					Thread.sleep(3000);
					
				
		}
				 @Then("^log in to the Checker Account$")
				 public void log_in_to_the_checker_account() throws InterruptedException  {
				    login = new AzentioLogin(driver);
					driver.get(configFileReader.getApplicationUrl());
					login.loginToAzentioAppAsChecker("Checker");
				       
				    }
				    
				 @And("^then checker claim the record$")
				 public void then_checker_claim_the_record() throws InterruptedException, IOException, ParseException  {
				    	
				    	//open pool
				    	waithelper = new WaitHelper(driver);
						kubschecker = new Azentio_CheckerObj(driver);
						waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
				    	kubschecker.checkerSecurityManagement().click();
				    	
				    	//claim
				    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
				    	kubschecker.checkerActionIcon().click();
				    	Thread.sleep(1000);
				    	String before_xpath = "//span[contains(text(),'";
						String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
						waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
						driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
						waithelper.waitForElement(driver,3000,kubschecker.checkerAlertClose());
						kubschecker.checkerAlertClose().click();
				 
				        
				    }
				    @Then("^click on the checker Notification$")
				    public void click_on_the_checker_notification() throws InterruptedException  {
				    	Thread.sleep(1000);
						waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
						kubschecker.checkerNotificationIcon().click();
				    }



				    @And("^select the record and Approve by checker$")
				    public void select_the_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException  {
				    Thread.sleep(1000);
					for (int i = 1; i <= 35; i++) {
						try {
						waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
						 
						waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
						driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
						
						
						//Approve
				    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
				    	kubschecker.checkerApproveButton().click();
				    	Thread.sleep(2000);
				    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
						kubschecker.checkerRemarks().sendKeys("OK");
						Thread.sleep(2000);
						waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
						kubschecker.checkersubmitButton().click();
						Thread.sleep(6000);
					}
				    
				    //-------------------GL-----------//
			
				    @Then("^Click on Inventory Gl Configuration Eye Icon$")
				    public void click_on_inventory_gl_configuration_eye_icon() throws InterruptedException {
				  
				   // waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton());
				   // inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton().click();
				    Thread.sleep(2000);
			  
			  		WebElement eye = inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton();

			  		waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton());
			  		Assert.assertTrue(inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton().isDisplayed());
			  		clicksAndActionHelper.moveToElement(eye);
			  		inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_EyeButton().click();
			    	
				       
				    } 
				    
				    @Then("^Fill Inventory Gl Configuration Mandatory fields$")
				    public void fill_inventory_gl_configuration_mandatory_fields() {
				    inventoryMaintenanceTestDataType = jsonReader.getInventoryMaintenanceByName("Maker");
					inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
					    
					//Item Code
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_Itemcode());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_Itemcode().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_Itemcode().sendKeys(inventoryMaintenanceTestDataType.ItemCodeGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_Itemcode().sendKeys(Keys.ENTER);
					
					//Inventory Gl
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryGl().sendKeys(inventoryMaintenanceTestDataType.InventoryGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryGl().sendKeys(Keys.ENTER);
				        
					//Accrued Purchase GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl().sendKeys(inventoryMaintenanceTestDataType.AccruedPurchaseGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl().sendKeys(Keys.ENTER);
				 
					//Accrued Landed Cost GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl().sendKeys(inventoryMaintenanceTestDataType.AccruedLandedCostGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl().sendKeys(Keys.ENTER);
				    
					//Inventory Inter Branch GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl().sendKeys(inventoryMaintenanceTestDataType.InventoryInterBranchGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl().sendKeys(Keys.ENTER);
				   
					//Inventory Damage Adjustment GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl().sendKeys(inventoryMaintenanceTestDataType.InventoryDamageAdjustmentGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl().sendKeys(Keys.ENTER);
				   
					//Inventory Loss Adjustment GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl().sendKeys(inventoryMaintenanceTestDataType.InventoryLossAdjustmentGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl().sendKeys(Keys.ENTER);
				   
					//Inventory Consumption GL
					waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl());
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl().click();
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl().sendKeys(inventoryMaintenanceTestDataType.InventoryConsumptionGL);
					inventoryMaintenanceObj.inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl().sendKeys(Keys.ENTER);
				    
				    }
				    
				    @And("^Select Inventory Maintenance and Submit the record$")
				    public void select_inventory_maintenance_and_submit_the_record() throws InterruptedException, IOException, ParseException  {
				      
				   //Reference
				    	waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
				    	String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
				        jsonWriter.addReferanceData(id);
				        System.out.println("Reference ID:" +id);
				        for (int i = 1; i <= 35; i++) {
				        		try {
				        	    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
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
				        	  
				        	 waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
				        	 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
				        	 
				        	
				        	// Submit button
				        	waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
				        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();
				        			
				        	//Remark
				        	javascripthelper.JavaScriptHelper(driver);
				        	waithelper.waitForElement(driver, 3000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
				        	javascripthelper.JSEClick(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
				        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys(inventoryMaintenanceTestDataType.Remark);
				        			    
				        			
				        	//Remark Submit
				        	waithelper.waitForElement(driver, 2000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
				        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
				        	Thread.sleep(3000);
				        	
				        	// REVIEWER
				        			Thread.sleep(2000);
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
				        			jsonWriter = new JsonDataReaderWriter();
				        			jsonWriter.addData(reviewerId);
				       
				        }
				    
				
}
