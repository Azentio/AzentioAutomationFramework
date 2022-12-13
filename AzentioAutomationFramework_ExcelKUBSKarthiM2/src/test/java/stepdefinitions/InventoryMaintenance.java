package stepdefinitions;

import java.io.IOException;
import java.util.Map;
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
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
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
		KUBS_Login kubsLogin;
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
		BUDGET_BudgetDefinitionTestDataType budgetdata;
		
		ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","POCreationTestData","Data Set ID");
		Map<String, String> testData;
		
		 @Given("^Maker Navigate to UAT URL login$")
		    public void maker_navigate_to_uat_url_login() throws InterruptedException {
				kubsLogin = new KUBS_Login(driver);
				driver.get(configFileReader.getApplicationUrl());
				kubsLogin.loginToAzentioAppByMaker();
				
		       
		    }
		 
		//getVendorPurchaseOrderyByName
			
		/* @Then("^Click on Direction icon$")
		 public void click_on_direction_icon() throws InterruptedException {
		 waithelper = new WaitHelper(driver) ;
		Thread.sleep(2000);
		 waithelper.waitForElement(driver, 4000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon().click();
    
		    }*/
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
//		    Thread.sleep(2000);
//		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
		    waithelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
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
		    
		  /*  //CurrentBalanceQuantity
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
		    */
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
		        Thread.sleep(1000);
		        /*
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
		        	*/
		        	//pencil 
		        	 String before_xpath="//span[contains(text(),'";
		        	 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		        	  
		        	// waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		        	 for (int i = 0; i < 50; i++) {
						try {
							driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)).click();
							break;
						} catch (Exception e) {
							if (i==49) {
								Assert.fail(" Record not clicked");
							}
						}
					}
		        	 
		        	 Thread.sleep(2000);
		        	
		        	// Submit button
		        	//waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		        	 for (int i = 0; i <90; i++) {
		        		 try {
		        			 clicksAndActionHelper.moveToElement(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
			        		 inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();
			        		 break;
						} catch (Exception e) {
							if (i==89) {
								Assert.fail("Submit button not clicked ");
							}
						}
					}
		        	 
		        	Thread.sleep(1000);
		        			
		        	//Remark
		        	javascripthelper.JavaScriptHelper(driver);
		        	//waithelper.waitForElement(driver, 3000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		        	for (int i = 0; i <40; i++) {
						try {
							inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().click();
				        	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys("OK");
							break;
						} catch (Exception e) {
							if (i==39) {
								Assert.fail("Remark not entered");
							}
						}
					}
		        	
		        	//inventoryMaintenanceTestDataType.Remark
		        			    
		        			
		        	//Remark Submit
		        	//waithelper.waitForElement(driver, 2000,inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		        	for (int i = 0; i <40; i++) {
						try {
							inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
							break;
						} catch (Exception e) {
							
						}
					}
		        	
		        	Thread.sleep(3000);
		        	
		        	// REVIEWER
//		        			waithelper.waitForElement(driver, 5000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		        			clicksAndActionHelper.moveToElement(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
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
				public void log_in_to_the_reviewer_account() throws IOException, ParseException, InterruptedException {
					//reader = new JsonDataReaderWriter();
					testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");
					kubsLogin = new KUBS_Login(driver);
					driver.get(config.getApplicationUrl());
					kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
					Thread.sleep(1000); 
					

				}

				@Then("^click on the Notification select the record and Approve$")
				public void click_on_the_notification_select_the_record_and_approve() throws InterruptedException, IOException, ParseException {
					//notification
					waithelper = new WaitHelper(driver);
					reviewer = new Azentio_ReviewerObj(driver);
					//waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
					//waithelper.waitForElementToVisibleWithFluentWait(driver,reviewer.reviewerNotidicationIcon(),30, 2);
					Thread.sleep(2000);
					
							reviewer.reviewerNotidicationIcon().click();
							
					
					
					//select the record
					browserHelper = new BrowserHelper(driver);
					budgetdata =  jsonReader.getBudgetdataByName("Maker");
					
					
					Thread.sleep(1000);
//					for (int i = 0; i < 35; i++) {
//						try {
//							//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//							WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
//							referanceID.click();
//							Assert.assertTrue(referanceID.isDisplayed());
//
//							break;
//						} catch (NoSuchElementException e) {
//							//waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//							kubschecker.checker_notification_next_button().click();
//							
//						}
//					}
					String before_xpath = "//span[contains(text(),'";
					String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
					
					for (int i = 0; i < 50; i++) {
					try {
					
					//waithelper.waitForElement(driver, 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
					driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath)).click();
					break;
					}catch(Exception e) {
						
					}
					}
					// Approve
//					waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
					waithelper.waitForElementToVisibleWithFluentWait(driver,reviewer.reviewerApproveButton(),30, 2);
					reviewer.reviewerApproveButton().click();
					
//					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
					waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
					reviewer.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
					
//					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
					waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
					reviewer.reviewerAlertSubmitButton().click();
					Thread.sleep(3000);
					
				
		}
				 @Then("^log in to the Checker Account$")
				 public void log_in_to_the_checker_account() throws InterruptedException  {
				    kubsLogin = new KUBS_Login(driver);
					driver.get(configFileReader.getApplicationUrl());
					kubsLogin.loginToAzentioAppAsChecker("Checker");
				       
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
				    	Thread.sleep(2000);
				    	String before_xpath = "//span[contains(text(),'";
						String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
					//	waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
						for (int i = 0; i <50; i++) {
							try {
								driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath_claim)).click();
								break;
							} catch (Exception e) {
								
							}
						}
						
						waithelper.waitForElement(driver,3000,kubschecker.checkerAlertClose());
						kubschecker.checkerAlertClose().click();
				 
				        
				    }
				    @Then("^click on the checker Notification$")
				    public void click_on_the_checker_notification() throws InterruptedException  {
//				    	Thread.sleep(1000);
//						waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
						waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
						kubschecker.checkerNotificationIcon().click();
				    }



				    @And("^select the record and Approve by checker$")
				    public void select_the_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException  {
				    //Thread.sleep(2000);
				    	/*
					for (int i = 1; i <= 35; i++) {
						try {
//						waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
						waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
						referanceID.click();
						Assert.assertTrue(referanceID.isDisplayed());
						break;
						} catch (NoSuchElementException e) {
							waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
							kubschecker.checker_notification_next_button().click();
							}
				    }
				    */
						String before_xpath="//span[contains(text(),'";
						String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
						 
//						waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
						//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)));
						for (int i = 0; i <200; i++) {
							try {
								driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+after_xpath)).click();
								break;
							} catch (Exception e) {
								
							}
						}
						
						
						
						//Approve
//				    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
				    	waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
				    	kubschecker.checkerApproveButton().click();
//				    	Thread.sleep(1000);
//				    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
						waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
				    	kubschecker.checkerRemarks().sendKeys(testData.get("Remark"));
//						Thread.sleep(2000);
//						waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
						waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
				    	kubschecker.checkersubmitButton().click();
						Thread.sleep(3000);
					}
				    
				    @And("^Get the test data for the po creation test case2$")
				    public void get_the_test_data_for_the_po_creation_test_case2() throws Throwable {
				    	testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_02_D1");
				    }
				    @And("^Get the test data for the po creation test case3$")
				    public void get_the_test_data_for_the_po_creation_test_case3() throws Throwable {
				    	testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_03_D1");
				    }
				    
				   
}
