package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetTransferTestDataType;
import helper.ClicksAndActionsHelper;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import utilities.ExtentTestManager;

public class Budget_BudgetTransfer_BP_BT extends BaseClass {
		WebDriver driver=BaseClass.driver;
		 
		ConfigFileReader config=new ConfigFileReader();
		KUBS_ReviewerObj reviewer;
		 
		BrowserHelper browserHelper;	 
		BUDGET_BudgetCreationTestDataType budgetdata;
		JsonConfig jsonconfig=new JsonConfig();
		//--------------------------------------common-------------------------------------------
		 
		JsonConfig jsonReader = new JsonConfig();
		ConfigFileReader configFileReader = new ConfigFileReader();
		DropDownHelper dropDownHelper;
		WaitHelper waithelper;
		JavascriptHelper javahelper = new JavascriptHelper();
		BUDGET_BudgetTransferObj budgetTransferObj;
		BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
		KUBS_Login login;
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JavascriptHelper javascripthelper = new JavascriptHelper();
		String user = "Maker";
		String referance_id;
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
		//----------------------------------BudgetTransfer_BP_BT_05_01(Priyanka)----------------------------//
		  //---------------------------------Create record maker------------------------------------//
		 @Given("^Maker login$")
		    public void maker_login() throws InterruptedException  {
			 login = new KUBS_Login(driver);
				driver.get(configFileReader.getApplicationUrl());
				login.loginToAzentioApp("Maker");
		    }
		 @And("^Maker click on  the direction tab$")
		    public void maker_click_on_the_direction_tab(){
			waithelper = new WaitHelper(driver);
			budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
		     
		    }
		 @Then("^Maker click on the budget$")
		    public void maker_click_on_the_budget() {
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetField());
			budgetTransferObj.budget_BudgetTransfer_BudgetField().click();
		       
		    }

		    @Then("^Maker click on  budget transfer eye button$")
		    public void maker_click_on_budget_transfer_eye_button() {
		    waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
			budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
		       
		    }
		    @And("^Maker click on add button$")
		    public void maker_click_on_add_button() {
		    waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
			budgetTransferObj.budget_BudgetTransfer_AddButton().click();
		    
		    }
		    @Then("^Maker fill the details and save$")
		    public void maker_fill_the_details_and_save() throws InterruptedException  {
		    	//Budget code
				budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
				
				//Year
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
				
				//Branch
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
				budgetTransferObj.budget_BudgetTransfer_Branch().click();
				budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
				budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);
				 
				//Transfer to Budget code
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
				
				//Currency
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
				budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
				budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
				budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);
				
				//Apportioned Amount A
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
				budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
				budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
				
				//New Amount A
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
				budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();
				
				//Apportioned Amount B
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
				budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
				budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferTestDataType.ApportionedAmountB);
				
				//New Amount B
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
				budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();
				
				//Save
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
				budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
				Thread.sleep(2000);
		        javascripthelper.JavaScriptHelper(driver);
		        String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
		        System.out.println("Message:" +str);
				
				
				
		       
		    }
		    @Then("^Maker  click on the notification icon$")
		    public void maker_click_on_the_notification_icon()  {
		    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
				budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();
		        
		    }

		    @Then("^Maker submit the budget transfer record$")
		    public void maker_submit_the_budget_transfer_record() throws IOException, ParseException, InterruptedException {
		    	
		        
				//Reference
					waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
			    	String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
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
							waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
							
							budgetTransferObj.maker_notification_next_button().click();
						}
					 
			    	waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
					
			    	budgetTransferObj.maker_notification_next_button().click();
			    	}
			    	budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();	    	
			    	
					 //Action-Pencil
					 String before_xpath="//span[contains(text(),'";
					 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
					  
					 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
					 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
				 	

					// Submit button
					waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Submit());
					budgetTransferObj.budget_BudgetTransfer_Submit().click();
				
					//Remark
					javahelper.JavaScriptHelper(driver);
					waithelper.waitForElement(driver, 3000,budgetTransferObj.budget_BudgetTransfer_RemarkField());
					javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
				
					budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(budgetTransferTestDataType.Remark);
				    
				
				    //Remark Submit
					waithelper.waitForElement(driver, 2000,budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
					budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
					
					//REVIEWER
					Thread.sleep(2000);
					WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
			    	
				
					clicksAndActionHelper.moveToElement(recordstatus);
			    	String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
			    	System.out.println(message);
			    	budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
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
					jsonWriter=new JsonDataReaderWriter();
					jsonWriter.addData(reviewerId);
					
		    }
		    @Then("^Navigate to Url and login as a reviewer$")
		    public void navigate_to_url_and_login_as_a_reviewer() throws Throwable, Throwable {
		    	reader=new JsonDataReaderWriter();
				login = new KUBS_Login(driver);
				driver.get(config.getApplicationUrl());
				 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
				 ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");
		    }

		    @When("^Click on Notification button$")
		    public void click_on_notification_button() {
		    	waithelper=new WaitHelper(driver);
		    	reviewer=new KUBS_ReviewerObj(driver);
		    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		    	reviewer.reviewerNotidicationIcon().click();
		    	 ExtentTestManager.getTest().info("User clicks on notification icon");
		    }
		
//------------------------------Budget_BudgetTransfer_BP_BT_05_02--------------------------------//
   

    @Then("^Click on action button$")
    public void click_on_action_button()  {
       
    }

    @And("^Find the budget code which submitted from maker$")
    public void find_the_budget_code_which_submitted_from_maker() throws IOException, InterruptedException, Throwable  {
    	browserHelper = new BrowserHelper(driver);
    	budgetdata=jsonconfig.getBudgetdataByName("Maker");
		javascript=new JavascriptHelper();
    	Thread.sleep(1000);
		waithelper.waitForElement(driver,4000,kubschecker.checkerNotificationIcon());
		
		kubschecker.checkerNotificationIcon().click();
		Thread.sleep(1000);
	 for(int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
		  
		 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
		     
    }

    @And("^Verify the record$")
    public void verify_the_record() {
    	Assert.assertTrue(reviewer.reviewerApproveButton().isDisplayed());
    	Assert.assertTrue(reviewer.reviewerRejectButton().isDisplayed());
    	Assert.assertTrue(reviewer.reviewerReturnButton().isDisplayed());
    }
    
 //----------------------------Budget_BudgetTransfer_BP_BT_05_04---------=-------------------------//

	

    @Then("^Navigate to Url and login as a reviewer1$")
    public void navigate_to_url_and_login_as_a_reviewer1() throws IOException, Throwable  {
    	reader=new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
		 ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
    }

    @When("^Click on Notification button on reviewer1 home page$")
    public void click_on_notification_button_on_reviewer1_home_page()  {
    	waithelper=new WaitHelper(driver);
    	reviewer=new KUBS_ReviewerObj(driver);
    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
    	reviewer.reviewerNotidicationIcon().click();
    	 ExtentTestManager.getTest().info("User clicks on notification icon");
    }
    @And("^Find the budget code which submitted from maker end$")
    public void find_the_budget_code_which_submitted_from_maker_end()  {
       
    }

    @Then("^Click on action button on reviewer1 notification page$")
    public void click_on_action_button_on_reviewer1_notification_page() throws Throwable  {
    	browserHelper = new BrowserHelper(driver);
    	budgetdata=jsonconfig.getBudgetdataByName("Maker");
    javascript=new JavascriptHelper();
    	Thread.sleep(1000);
    	waithelper=new WaitHelper(driver);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
		  
		 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	
    }
    @And("^Reject the record$")
    public void reject_the_record() {
    	waithelper.waitForElement(driver, 2000, reviewer.reviewerRejectButton());
		reviewer.reviewerRejectButton().click();
	 ExtentTestManager.getTest().info("User Click Reject button");
		
    }
    @Then("^Enter the remark$")
    public void enter_the_remark() {
    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
	 ExtentTestManager.getTest().info("User write remark");
		
    }
    @And("^Click on submit button$")
    public void click_on_submit_button() {
    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
	 ExtentTestManager.getTest().info("User click on submit button");
	 waithelper.waitForElement(driver, 3000, reviewer.reviewer_reject_toast());
	 Assert.assertTrue(reviewer.reviewer_reject_toast().isDisplayed());
    }
    
    //-------------------------------------Budget_BudgetTransfer_BP_BT_05_05-------------------------//
    
     
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	
	  @Then("^user login to checker1$")
	    public void user_login_to_checker1() throws Throwable, Throwable {
		  reader=new JsonDataReaderWriter();
			login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
			 ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");
	    }
	  @And("^click on notification icon$")
	    public void click_on_notification_icon()  {
		  waithelper=new WaitHelper(driver);
	    	reviewer=new KUBS_ReviewerObj(driver);
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	    	reviewer.reviewerNotidicationIcon().click();
	    	 ExtentTestManager.getTest().info("User clicks on notification icon");
	    }
	  @And("^click on action button button of the record which we want to approve$")
	    public void click_on_action_button_button_of_the_record_which_we_want_to_approve() throws Throwable  {
		  browserHelper = new BrowserHelper(driver);
	    	budgetdata=jsonconfig.getBudgetdataByName("Maker");
	    javascript=new JavascriptHelper();
	    	Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000,
							driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
		
	    }
	    @Then("^user approve the record$")
	    public void user_approve_the_record()  {
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
			reviewer.reviewerApproveButton().click();
		 ExtentTestManager.getTest().info("User Click Approve button");
	    }

	    @And("^user write the remark & submit the record$")
	    public void user_write_the_remark_submit_the_record() throws Throwable  {
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
			reviewer.reviewerAlertRemarks().sendKeys("ok");
		 ExtentTestManager.getTest().info("User write remark");

	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
			reviewer.reviewerAlertSubmitButton().click();
		 ExtentTestManager.getTest().info("User click on submit button");
		 Thread.sleep(3000);
		 
	    }
	    @Then("^User should login to checker2$")
	    public void user_should_login_to_checker2() throws InterruptedException  {
	    	login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.loginToAzentioAppAsChecker("Checker");
	    	ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
	    }

	    @Then("^click on open pool$")
	    public void click_on_open_pool()  {
	    	waithelper = new WaitHelper(driver);
			kubschecker = new KUBS_CheckerObj(driver);
			waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
	    	kubschecker.checkerSecurityManagement().click();
	    	 	
	    }
	    @And("^Verify for claming the record$")
	    public void verify_for_claming_the_record() throws IOException, Throwable  {
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
	    @Then("^User should click on notification icon on reviewer2 home page$")
	    public void user_should_click_on_notification_icon_on_reviewer2_home_page() throws Throwable   {
	    	javascript=new JavascriptHelper();
	    	Thread.sleep(1000);
			waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
			
			kubschecker.checkerNotificationIcon().click();
	    }

	    @Then("^Verify the clamed record is showing or not$")
	    public void verify_the_claimed_record_is_showing_or_not() throws IOException, ParseException, Throwable   {
	    	Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000,
							driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
			 
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
			waithelper.waitForElement(driver,4000,kubschecker.checkerRejectButton());
			
	    	Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
	    	waithelper.waitForElement(driver,4000,kubschecker.checkerReturnButton());
	    	Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
	    	waithelper.waitForElement(driver,4000,kubschecker.checkerApproveButton());
			
	    	Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());
			    
	    }
//------------------------------------------Priyanka----------------
	  
 	    
	  	  //----------------------------------BudgetTransfer_BP_BT_08_01----------------------------//
	  	  //---------------------Budget Transfer within same branch--------------------------------//
	  				    @Then("^Claim and approve the record$")
	  				    public void claim_and_approve_the_record() throws InterruptedException, IOException, ParseException  {
	  				    	Thread.sleep(1000);
	  						for (int i = 1; i <= 35; i++) {
	  							try {
	  								waithelper.waitForElement(driver, 3000,
	  										driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
	  								WebElement referanceID = driver
	  										.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
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
	  						 
	  						waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
	  						driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	  						waithelper.waitForElement(driver,4000,kubschecker.checkerRejectButton());
	  						
	  				    	Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
	  				    	waithelper.waitForElement(driver,4000,kubschecker.checkerReturnButton());
	  				    	Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
	  				    	waithelper.waitForElement(driver,4000,kubschecker.checkerApproveButton());
	  						
	  				    	Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());
	  				    	
	  				    	//Approve
	  				    	waithelper.waitForElement(driver,4000,kubschecker.checkerApproveButton());
	  						
	  						kubschecker.checkerApproveButton().click();
	  				    	
	  				     
	  				    }
	  	  //----------------------------------BudgetTransfer_BP_BT_10_01----------------------------//
	  	 //---------------------------------------Search record --------------------------------//
	  	    
	  	    @Then("^Maker click on the search icon$")
	  	    public void maker_click_on_the_search_icon()  {
	  	    	waithelper.waitForElement(driver, 5000, budgetTransferObj.budget_BudgetTransfer_SearchIcon());
	  			budgetTransferObj.budget_BudgetTransfer_SearchIcon().click();
	  	       
	  	    }

	  	    @Then("^maker enter the required data$")
	  	    public void maker_enter_the_required_data()  {
	  	    	budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
	  			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchBudgetCode());
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetCode().click();
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetCode().sendKeys(budgetTransferTestDataType.BudgetCode);
	  			
	  			//Budget Name
	  			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchBudgetName());
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetName().click();
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetName().sendKeys(budgetTransferTestDataType.BudgetName);
	  			
	  			//Year
	  			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchBudgetYear());
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetYear().click();
	  			budgetTransferObj.budget_BudgetTransfer_SearchBudgetYear().sendKeys(budgetTransferTestDataType.BudgetYear);
	  			
	  			//Transfer From budget code
	  			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchTransferFrom());
	  			budgetTransferObj.budget_BudgetTransfer_SearchTransferFrom().click();
	  			budgetTransferObj.budget_BudgetTransfer_SearchTransferFrom().sendKeys(budgetTransferTestDataType.BudgetCode);
	  			
	  			// Transfer to Budget code
	  			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchTransferTo());
	  			budgetTransferObj.budget_BudgetTransfer_SearchTransferTo().click();
	  			budgetTransferObj.budget_BudgetTransfer_SearchTransferTo().sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
	  			
	  			//Transfer Amount
	  			//waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchTransferAmount());
	  			//budgetTransferObj.budget_BudgetTransfer_SearchTransferAmount().click();
	  			//budgetTransferObj.budget_BudgetTransfer_SearchTransferAmount().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
	  			
	  			//status
	  			//waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchStatus());
	  			//budgetTransferObj.budget_BudgetTransfer_SearchStatus().click();
	  			//budgetTransferObj.budget_BudgetTransfer_SearchStatus().sendKeys(budgetTransferTestDataType.Status);
	  		
	  	    }

	  	    @Then("^click on the matching record$")
	  	    public void click_on_the_matching_record() throws InterruptedException  {
	  	    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SearchRecord());
	  			Assert.assertTrue(budgetTransferObj.budget_BudgetTransfer_SearchRecord().isDisplayed());
	  			Thread.sleep(2000);
	  	     
	  	    }

	    
	    //-----------------------------------------------------------------------------------------------------
	  	    //--------------------------new tc of budgetTransfer Tushar------------------
	  	    //-----------------------Budget_BudgetTransfer_BP_BT_01_04---------------------
	  	    
	  	   

	  	   //------Auto auth priyanka codes-------
	      //----------------------------------BudgetTransfer_BP_BT_01_02----------------------------//
			 //-------------------------------------Auto Auth-------------------------------------//
		    
		    @Then("^Maker Approve the budget transfer record$")
		    public void maker_approve_the_budget_transfer_record() throws IOException, ParseException {
		    
	  //Reference

		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
	    	String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
	    	jsonWriter.addReferanceData(id);
	    	System.out.println("Reference ID:" +id);
	    	for (int i = 1; i <= 35; i++) {
		try {
	waithelper.waitForElement(driver,3000,driver.findElement(By.xpath("//span[contains(text(),'"+jsonWriter.readReferancedata()+ "')]")));	
	WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
			referanceID.click();
			  System.out.println(referanceID);
			    //Assert.assertTrue(referanceID.isDisplayed());
			break;
		} catch (NoSuchElementException e) 
				{
					waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
					
					budgetTransferObj.maker_notification_next_button().click();
				}
			 
	    	waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
			
	    	budgetTransferObj.maker_notification_next_button().click();
	    	}
	    	budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();	    	
	    	
			 //Action-Pencil
			 String before_xpath="//span[contains(text(),'";
			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();

			// Approve button
			waithelper.waitForElement(driver, 2000, budgetTransferObj.maker_Approve_button());
			budgetTransferObj.maker_Approve_button().click();
		
			//Remark
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000,budgetTransferObj.budget_BudgetTransfer_RemarkField());
			javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		
			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(budgetTransferTestDataType.Remark);
		    
		
		    //Remark Submit
			waithelper.waitForElement(driver, 2000,budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
			budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();

		    }   
		  //----------------------------------BudgetTransfer_BP_BT_01_03----------------------------//
			 //-------------------------------------Auto Auth-------------------------------------//
		    
		    
		    
		    @Then("^Maker fill the invalid details and try to save$")
		    public void maker_fill_the_invalid_details_and_try_to_save() throws InterruptedException  {
		    	
		    	budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
				budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
				
				//Year
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
				budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
				
				//Branch
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
				budgetTransferObj.budget_BudgetTransfer_Branch().click();
				budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.InvalidBranch);
				budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.ENTER);
				 
				//Transfer to Budget code
				waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferTestDataType.InvalidTransferToBudgetCode);
				budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.ENTER);
			
				//Save button disabled
				waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
				boolean res=false;
				try{
					budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
				}
				catch(Exception e) {
					res=true;
					
					
				}
				Assert.assertTrue(res);
	}

	  	    
    
}
