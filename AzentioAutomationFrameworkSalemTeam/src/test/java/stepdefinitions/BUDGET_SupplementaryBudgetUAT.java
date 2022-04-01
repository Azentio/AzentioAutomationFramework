package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
import io.cucumber.java.en.When;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import utilities.ExtentTestManager;

public class BUDGET_SupplementaryBudgetUAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javahelper = new JavascriptHelper();
	AzentioLogin login = new AzentioLogin(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;
	// Checker//
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	JavascriptHelper javascript;

	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper = new BrowserHelper(driver) ;
	String referance_id;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig = new JsonConfig();
	ConfigFileReader config = new ConfigFileReader();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

	// ----------------------------------------SupplementaryBudget_KUBS_BP_UAT_005_004---------------------------------------------//
	// ----------------------------------------------Budget Record
	
	@Given("^maker should navigate to the url and login with valid credentials UAT$")
    public void maker_should_navigate_to_the_url_and_login_with_valid_credentials_UAT() throws InterruptedException  {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }
	@And("^maker should navigate to the budget module UAT$")
	public void maker_should_navigate_to_the_budget_module_UAT() throws InterruptedException  {
		 waithelper = new WaitHelper(driver);
		 bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
		 Thread.sleep(2000);
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon().click();
	}
	
	@And("^maker click on budget field UAT$")
    public void maker_click_on_budget_field_UAT()   {
        
	 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField());
	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
    }
	@When("^maker click on budget supplementary eye icon UAT$")
	public void maker_click_on_budget_supplymentary_eye_icon_UAT()  {
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();
		
	}
	@And("^click on add button on budget supplementary view page UAT$")
	public void click_on_add_button_on_budget_supplementary_view_page_UAT() throws InterruptedException  {
		Thread.sleep(2000);
    	waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();

	}
	@Then("^fill the input fields UAT$")
    public void fill_the_input_fields_UAT()  {
    	 //budget code
  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeA);
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
  //budget year
  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearA);
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
  	//budget  branch
  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameA);
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
  		//currency
  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
  	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyA);
  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);

    }
	@Then("fill apportion amount and save the record UAT")
	public void fill_apportion_amount_and_save_the_record_uat() throws InterruptedException {
		// Supplementary apportion amount
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.SupplymentaryApportionAmtA);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);

		// New amount
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();

		// save button
		waithelper.waitForElement(driver, 3000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

	}

	@Then("^validate maker can submit the record UAT$")
	public void validate_maker_can_submit_the_record_UAT() throws InterruptedException, IOException, ParseException {

		// Notification
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();

		// Reference
		waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId());
		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.maker_notification_next_button());

				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}

			
		}
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 1000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Submit button
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();

		// Remark
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		javahelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField()
				.sendKeys("OK");

		// Remark Submit
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();


		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
		System.out.println(message);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
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
	//-----------SupplementaryBudget_KUBS_BP_UAT_005_004-------------------------------//
	
	  @Then("^user login to checker1 UAT$")
	    public void user_login_to_checker1_UAT() throws IOException, ParseException   {
			reader = new JsonDataReaderWriter();
			login = new AzentioLogin(driver);
		    driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	    }
	  @And("^click on notification icon UAT$")
	    public void click_on_notification_icon_UAT()  {
		  waithelper=new WaitHelper(driver);
	    	reviewer=new Azentio_ReviewerObj(driver);
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	    	reviewer.reviewerNotidicationIcon().click();
	    	 ExtentTestManager.getTest().info("User clicks on notification icon");
	    }
	  @And("^click on action button button of the record which we want to approve UAT$")
	    public void click_on_action_button_button_of_the_record_which_we_want_to_approve_UAT() throws InterruptedException, IOException, ParseException   {
		  browserHelper = new BrowserHelper(driver);
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
	    @Then("^user approve the record UAT$")
	    public void user_approve_the_record_UAT()  {
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
			reviewer.reviewerApproveButton().click();
		 ExtentTestManager.getTest().info("User Click Approve button");
	    }

	    @And("^user write the remark & submit the record UAT$")
	    public void user_write_the_remark_submit_the_record_UAT() throws InterruptedException   {
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
			reviewer.reviewerAlertRemarks().sendKeys("ok");
		 ExtentTestManager.getTest().info("User write remark");

	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
			reviewer.reviewerAlertSubmitButton().click();
		 ExtentTestManager.getTest().info("User click on submit button");
		 Thread.sleep(3000);
		 
	    }
	    @Then("^User should login to checker2 UAT$")
	    public void user_should_login_to_checker2_UAT() throws InterruptedException  {
	    	login = new AzentioLogin(driver);
			driver.get(config.getApplicationUrl());
			login.loginToAzentioAppAsChecker("Checker");
	    	ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
	    }

	    @Then("^click on open pool UAT$")
	    public void click_on_open_pool_UAT()  {
	    	waithelper = new WaitHelper(driver);
			kubschecker = new Azentio_CheckerObj(driver);
			waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
	    	kubschecker.checkerSecurityManagement().click();
	    	 	
	    }
	    @And("^Verify for claming the record UAT$")
	    public void verify_for_claming_the_record_UAT() throws IOException, Throwable  {
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
	    @Then("^User should click on notification icon on reviewer2 home page UAT$")
	    public void user_should_click_on_notification_icon_on_reviewer2_home_page_UAT() throws InterruptedException    {
	    	javascript=new JavascriptHelper();
	    	Thread.sleep(1000);
			waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
			
			kubschecker.checkerNotificationIcon().click();
	    }
	    @Then("^Claim and approve the record UAT$")
	    public void claim_and_approve_the_record_UAT() throws InterruptedException, IOException, ParseException  {
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
			Thread.sleep(2000);
	    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
			kubschecker.checkerRemarks().sendKeys("OK");
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
			kubschecker.checkersubmitButton().click();
			Thread.sleep(2000);
	    	
	     
	    }

	//-----------SupplementaryBudget_KUBS_BP_UAT_005_005-------------------------------//
	
	@Then("^Claim and reject the record UAT$")
    public void claim_and_reject_the_record_UAT() throws InterruptedException, IOException, ParseException  {
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
    	
    	//Reject
    	waithelper.waitForElement(driver,4000,kubschecker.checkerRejectButton());
		
		kubschecker.checkerRejectButton().click();
		Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("OK");
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
     
    }
	
	//-----------------SupplementaryBudget_KUBS_BP_UAT_005_003-------------------//
	 @Then("^Select the Supplementary record from notification$")
	    public void select_the_supplementary_record_from_notification() throws InterruptedException, IOException, ParseException {

		// Notification
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();

		// Reference
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId());
		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.maker_notification_next_button());

				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}

			
		}
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 1000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		Thread.sleep(2000);
	 }
	 
	 //---------------SupplementaryBudget_KUBS_BP_UAT_005_007------------------------//
	 @Then("^Click on Report field$")
	    public void click_on_report_field()  {
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.report_Field());
	  	 bUDGET_SupplementaryBudgetObj.report_Field().click();
	   }

	    @Then("^click on supplementary budget Report$")
	    public void click_on_supplementary_budget_report() throws InterruptedException  {
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report());
	    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report());
	    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report().click();   
	    }

	    @Then("^Select the date$")
	    public void select_the_date()  {
	    	
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	 
	  		//select Transaction from date
	 		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate());
	 		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate().click();
	 	
	 		javascripthelper.JavaScriptHelper(driver);
	 		while(true)
	         {
	 		try
	 		{
	 		
	 			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUDGET_SupplementaryBudgetTestDataType.FromMonth+" "+bUDGET_SupplementaryBudgetTestDataType.Year+"')]")));
	 			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+bUDGET_SupplementaryBudgetTestDataType.FromMonth+" "+bUDGET_SupplementaryBudgetTestDataType.Year+"')]"));
	 		    break;
	 		}
	 		
	 		catch(NoSuchElementException nosuchElement)
	 		{
	 			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NextMonth().click();
	 		}
	 		}
	 		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+bUDGET_SupplementaryBudgetTestDataType.FromFullMonth+" "+bUDGET_SupplementaryBudgetTestDataType.FromDay+", "+bUDGET_SupplementaryBudgetTestDataType.Year+"']/span"));
	 		clicksAndActionHelper.doubleClick(FinalDay);
	    }
	    @And("^click on view button of report$")
	    public void click_on_view_button_of_report() {
	    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport());
	    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport().click();
	    		
	    }

	    @Then("^verify the Supplementary Budget report$")
	    public void verify_the_supplementary_budget_report() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	    	browserHelper.SwitchToWindow(1);
	    	Thread.sleep(3000);
	    	javascripthelper.JavaScriptHelper(driver);
	        javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
	        waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
	        bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear().click();
	    	Thread.sleep(3000);
	    	browserHelper.switchToParentWithChildClose();
	}
	

}
