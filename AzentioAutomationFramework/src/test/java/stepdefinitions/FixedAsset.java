package stepdefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.InventoryManagementTestDataType;
import utilities.ExtentTestManager;

public class FixedAsset {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetDefinitionTestDataType budgetdata1;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);

	//-------------KUBS_FAT_UAT_002_001------
	  @Given("^Navigate to kubs URL and user should login as a maker$")
	    public void navigate_to_kubs_url_and_user_should_login_as_a_maker() throws Throwable {
		  login = new AzentioLogin(driver);
			driver.get(configFileReader.getApplicationUrl());
			login.loginToAzentioApp("Maker"); 
	    }

//	    @Then("^Click on the Finance$")
//	    public void click_on_the_finance() throws Throwable {
//	    	System.out.println("Click on finance");
//	    }

//	    @Then("^Click on the Direction$")
//	    public void click_on_the_direction() throws Throwable {
//	    	waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
//			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
//
//	    }

	    @Then("^Click on Fixed Asset$")
	    public void click_on_fixed_asset() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_Button());
	    	fixedAssetObj.fixedAsset_Button().click();
	    }

	    @Then("^Click on Asset Creation Eye button$")
	    public void click_on_asset_creation_eye_button() throws Throwable {
	    	fixedAssetObj.fixedAsset_AssetCreation_EyeButton().click();
	    }

	    @Then("^Click on the add button to add new record$")
	    public void click_on_the_add_button_to_add_new_record() throws Throwable {
	    	fixedAssetObj.fixedAsset_AssetCreation_AddButton().click();
	    }

	    @Then("^Fill Form$")
	    public void fill_form() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox());
	    	fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(fixedAssetTestDataType.BranchCode);
	    	fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox());
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(fixedAssetTestDataType.AssetCode);
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);	
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox());
	    	fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(fixedAssetTestDataType.BillReferenceNo);
	    	fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);
	    	Thread.sleep(3000);
	    }

	    @Then("^Save the filled form$")
	    public void save_the_filled_form() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_SaveButton());
	    	fixedAssetObj.fixedAsset_AssetCreation_SaveButton().click();
	    	}

//	    @Then("^Click on the Notification$")
//	    public void click_on_the_notification() throws Throwable {
//	    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
//			budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();
//
//	    }

	  /*  @Then("^Select the record which we saved$")
	    public void select_the_record_which_we_saved() throws Throwable {
	    	// Reference
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
			String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
			jsonWriter.addReferanceData(id);
			System.out.println("Reference ID:" + id);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
					referanceID.click();
					System.out.println(referanceID);
					// Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

					budgetTransferObj.maker_notification_next_button().click();
				}

			}
			budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

			// Action-Pencil
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	    }
	    */
	    @Then("^Click on Fixed Asset items$")
	    public void click_on_fixed_asset_items() throws Throwable {
	    //Asset Items
	    	Thread.sleep(2000);
	    waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems());
	    fixedAssetObj.fixedAsset_AssetCreation_FixedAssetItems().click();	
	    
	    }
	     
	    @Then("^Click on the add button of asset items$")
	    public void click_on_the_add_button_of_asset_items() {
	    //Add button	
	    waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AddButton());
	    fixedAssetObj.fixedAsset_AssetCreation_AddButton().click();	
	 	    	
	    }
	    
	    @Then("^fill the asset item details$")
	    public void fill_the_asset_item_details() throws Throwable  {
	    //item details
	    	Random random = new Random();
	    	int randomNumber=random.nextInt(5000-999)+5000;
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAssetTestDataType.AssetItemNumber+randomNumber);
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAssetTestDataType.AssetItemDescription+randomNumber);
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAssetTestDataType.AssetValue);
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_HSNCode());
	    	fixedAssetObj.fixedAsset_AssetCreation_HSNCode().click();
	    	fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(fixedAssetTestDataType.HSNCode);
	    	fixedAssetObj.fixedAsset_AssetCreation_HSNCode().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAssetObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAssetObj.inventoryNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAssetTestDataType.GlFullToMonth+" "+fixedAssetTestDataType.GlToDate+", "+fixedAssetTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			Thread.sleep(2000);
	    }
	    @Then("^Click on save button of item details$")
	    public void click_on_save_button_of_item_details() throws Throwable {
	    	 waithelper.waitForElement(driver, 2000,fixedAssetObj.fixedAsset_AssetAllocation_SaveButton());
	    	fixedAssetObj.fixedAsset_AssetAllocation_SaveButton().click();
	    	Thread.sleep(3000);
	    }

//	    @Then("^Submit record$")
//	    public void submit_record() throws Throwable {
//	    	// Submit button
//			//Thread.sleep(2000);
//			waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
//			inventoryManagamentObj.accountPayable_SubmitButton().click();
//			//budgetTransferObj.budget_BudgetTransfer_Submit().click();
//			javahelper.JavaScriptHelper(driver);
//			// Remark
//			//javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
//			/*inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed();
//			boolean result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
//			System.out.println(result);
//			while(true) {
//				try {
//			//inventoryManagamentObj.accountPayable_SubmitButton().click();
//				WebElement submitButton =	(WebElement) javahelper.executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]");
//				submitButton.click();	
//				break;
//				}
//				catch(ElementNotInteractableException e)
//				{
//					System.out.println(e.getMessage());
//				}
//				}*/
//			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			
//			//javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().click();
//			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_RemarkField());
//			Thread.sleep(2000);
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
//			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);
//			
//			Thread.sleep(2000);
//			// Remark Submit
//			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
//			budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
//			Thread.sleep(2000);
//			WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
//
//			clicksAndActionHelper.moveToElement(recordstatus);
//			String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
//			System.out.println(message);
//			budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
//			String t = "";
//			String ar[] = message.split(" ");
//			Thread.sleep(2000);
//			for (int i = ar.length - 1; i >= 0; i--) {
//				t = ar[ar.length - 1];
//			}
//			String reviewerId = "";
//			for (int i = 0; i < t.length() - 1; i++) {
//				if (t.charAt(i) == '.') {
//				} else {
//					reviewerId = reviewerId + t.charAt(i);
//				}
//			}
//			System.out.println(reviewerId);
//			jsonWriter = new JsonDataReaderWriter();
//			jsonWriter.addData(reviewerId);
//
//	    }

//	    @Then("^Open the Reviewer account$")
//	    public void open_the_reviewer_account() throws Throwable {
//	    	reader = new JsonDataReaderWriter();
//			login = new AzentioLogin(driver);
//			driver.get(config.getApplicationUrl());
//			login.logintoAzentioappReviewer("Reviewer", reader.readdata());
//			waithelper = new WaitHelper(driver);
//			reviewer = new KUBS_ReviewerObj(driver);
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
//			reviewer.reviewerNotidicationIcon().click();
//			browserHelper = new BrowserHelper(driver);
//			budgetdata1 = jsonconfig.getBudgetdataByName("Maker");
//			javascript = new JavascriptHelper();
//			Thread.sleep(2000);
//			waithelper = new WaitHelper(driver);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'"+reader.readReferancedata()+"')]"));
//					referanceID.click();
//
//					Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//
//					kubschecker.checker_notification_next_button().click();
//				}
//			}
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
//			driver.findElement(By.xpath(before_xpath+reader.readReferancedata()+after_xpath)).click();
//
//	    }

	  /*  @Then("^Approve the record which we submitted from maker$")
	    public void approve_the_record_which_we_submitted_from_maker() throws Throwable {
	    	Thread.sleep(3000);
	    	 
	    	browserHelper = new BrowserHelper(driver);
			budgetdata1 =  jsonReader.getBudgetdataByName("Maker");
			javascripthelper = new JavascriptHelper();
			javascripthelper.JavaScriptHelper(driver);
			Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000, driver.findElement(

						By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
					WebElement referanceID = driver.findElement(
							By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]"));
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

			

	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
			reviewer.reviewerApproveButton().click();
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
			javahelper.JSEClick(reviewer.reviewerAlertRemarks());
			Thread.sleep(2000);
			reviewer.reviewerAlertRemarks().sendKeys("ok");
			Thread.sleep(3000);
			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
			reviewer.reviewerAlertSubmitButton().click();
			Thread.sleep(3000);
		
	    }
*/
//	    @Then("^Go to Checker login$")
//	    public void go_to_checker_login() throws Throwable {
//	    	login = new AzentioLogin(driver);
//			driver.get(config.getApplicationUrl());
//			login.loginToAzentioAppAsChecker("Checker");
//			ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
//
//		
//	    }

//	    @Then("^Clam record$")
//	    public void clam_record() throws Throwable {
//	    	waithelper = new WaitHelper(driver);
//			kubschecker = new KUBS_CheckerObj(driver);
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
//			kubschecker.checkerSecurityManagement().click();
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
//
//			kubschecker.checkerActionIcon().click();
//			Thread.sleep(1000);
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
//			waithelper.waitForElement(driver, 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
//			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
//			kubschecker.checkerAlertClose().click();
// 
//	    }

//	    @Then("^Click on the notification and approve the record$")
//	    public void click_on_the_notification_and_approve_the_record() throws Throwable {
//	    	javascript = new JavascriptHelper();
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
//
//			kubschecker.checkerNotificationIcon().click();
//			Thread.sleep(1000);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
//					referanceID.click();
//
//					Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//
//					kubschecker.checker_notification_next_button().click();
//				}
//			}
//			String before_xpath = "//span[contains(text(),'";
//			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//
//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
//			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
//
//			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
//
//			kubschecker.checkerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
//			reviewer.reviewerAlertRemarks().sendKeys("ok");
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
//			reviewer.reviewerAlertSubmitButton().click();
//			Thread.sleep(4000);
//		 
//	    }

	//-------------KUBS_FAT_UAT_006_001-------------
	
	
	    @Then("^Click on Asset Allocation Eye button$")
	    public void click_on_asset_allocation_eye_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_EyeButton());
	    	fixedAssetObj.fixedAsset_AssetAllocation_EyeButton().click();
	    }
	
	
	    @Then("^Fill the Allocation form with unused asset$")
	    public void fill_the_allocation_form_with_unused_asset() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
	    	//fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID());
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
	    }
	
	
	    @Then("^Save the filled Allocation$")
	    public void save_the_filled_allocation() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsserAllocationSaveButton());
	    	fixedAssetObj.fixedAsserAllocationSaveButton().click();
	    }
//-----------KUBS_FAT_UAT_006_002----
	    @Then("^Fill the Allocation form with used asset details$")
	    public void fill_the_allocation_form_with_used_asset_details() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
	    	//fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID());
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
	    
	    }
	    //------------KUBS_FAT_UAT_006_003-----------
	    @Then("^Fill the Allocation form with impaired asset details$")
	    public void fill_the_allocation_form_with_impaired_asset_details() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
	    	//fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID());
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
	     
	    }
	    //-------KUBS_FAT_UAT_006_004---------
	    
	    @Then("^Fill the Allocation form with revalued asset details$")
	    public void fill_the_allocation_form_with_revalued_asset_details() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAssetTestDataType.AssetReferenceNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber());
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
	    	//fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAssetTestDataType.ItemNumber);
	    	fixedAssetObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID());
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().click();
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAssetTestDataType.EmployeeID);
	    	fixedAssetObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
	     
	    }
	
	//--------KUBS_FAT_UAT_002_008-----
	    @Then("^Click on Job Scheduler$")
	    public void click_on_job_scheduler() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.JobScheduler_Button());
	    	fixedAssetObj.JobScheduler_Button().click();
	    }

	    @Then("^Click on Job Execution edit button$")
	    public void click_on_job_execution_edit_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.JobExecution_EditButton());
	    	fixedAssetObj.JobExecution_EditButton().click(); 
	    }

	    @Then("^Click on calander to set desire date$")
	    public void click_on_calander_to_set_desire_date() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.JobExecution_ToDateCalanderButton());
	    	fixedAssetObj.JobExecution_ToDateCalanderButton().click();
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAssetObj.inventoryNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAssetTestDataType.GlFullToMonth+" "+fixedAssetTestDataType.GlToDate+", "+fixedAssetTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
		
	    	
	    	
	    }

	    @Then("^click on Start the job$")
	    public void click_on_start_the_job() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.JobExecution_StartJobButton());
	    	fixedAssetObj.JobExecution_StartJobButton().click(); 
	    	Thread.sleep(2000);
	    }

	    @Then("^Click on refresh button$")
	    public void click_on_refresh_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, fixedAssetObj.JobExecution_RefreshButton());
	    	fixedAssetObj.JobExecution_RefreshButton().click();
	    }

	    @Then("^login with maker to check if date is changed or not$")
	    public void login_with_maker_to_check_if_date_is_changed_or_not() throws Throwable {
	    	 login = new AzentioLogin(driver);
				driver.get(configFileReader.getApplicationUrl());
				login.loginToAzentioApp("Maker"); 
	    }
	
	//------------------KUBS_FAT_UAT_013_007-------
	    @Then("^Click on Asset Creation Common Edit Grid$")
	    public void click_on_asset_creation_common_edit_grid() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoView(fixedAssetObj.Report_report_AssetCreationCommon_editButton());
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.Report_report_AssetCreationCommon_editButton());
	    	fixedAssetObj.Report_report_AssetCreationCommon_editButton().click();    
			
	    }

	    @Then("^Fill the form$")
	    public void fill_the_form() throws Throwable {
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit());
	    	fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().click(); 
	    	
	    	fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().sendKeys(fixedAssetTestDataType.AssetLife);
	    	fixedAssetObj.Report_report_AssetCreationCommon_AssetLifeUnit().sendKeys(Keys.ENTER);
			
	    	
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.Report_report_AssetCreationCommon_Calendar());
	    	fixedAssetObj.Report_report_AssetCreationCommon_Calendar().click(); 
	    	
	    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
			while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+inventoryManagementTestDataType.GlToMonth+" "+inventoryManagementTestDataType.GlYear+"')]"));
			    break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				inventoryManagamentObj.inventoryNextMonth().click();
			}
			}
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+inventoryManagementTestDataType.GlFullToMonth+" "+inventoryManagementTestDataType.GlToDate+", "+inventoryManagementTestDataType.GlYear+"']/span"));
			clicksAndActionHelper.doubleClick(FinalDay);
	    }

	    @Then("^Click on view button to see Asset Creation report$")
	    public void click_on_view_button_to_see_asset_creation_report() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,fixedAssetObj.Report_report_AssetCreationCommon_ViewButton());
	    	fixedAssetObj.Report_report_AssetCreationCommon_ViewButton().click(); 
	    	
	    }

	
	
	
}
