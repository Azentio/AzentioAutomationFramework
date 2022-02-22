package stepdefinitions;

import java.io.IOException;
import java.util.Properties;
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
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;

public class BUDGET_BudgetTransfer_KUBS_BP_UAT_006_002 {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_BudgetTransferTestDataType budgetTransferData = jsonReader.getBudgetTransferdata("Maker");
	//BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementarybudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj=new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	KUBS_Login login;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_ReviewerObj reviewer = new KUBS_ReviewerObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	BrowserHelper browserHelper;
	String referance_id;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	JsonDataReaderWriter reader;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	String reviewerId;
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;

	@Given("^navigate to kubs url and login as a maker user$")
	public void navigate_to_kubs_url_and_login_as_a_maker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");

	}

	@Then("^select the budget menu in segment button$")
	public void select_the_budget_menu_in_segment_button() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon().click();
    	
    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();

	}

	@And("^click on the eye icon of budget transfer sub module$")
	public void click_on_the_eye_icon_of_budget_transfer_sub_module() {
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
		budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
	}

	@Then("^click on add button to create budget record$")
	public void click_on_add_button_to_create_budget_record() {
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
		budgetTransferObj.budget_BudgetTransfer_AddButton().click();
	}

	@And("^fill the required field to transfer budget$")
	public void fill_the_required_field_to_transfer_budget() {
		budgetTransferData = jsonReader.getBudgetTransferdata("Maker");

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferData.BudgetCode);
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferData.BudgetYear);
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_Branch());
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferData.Branch);
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferData.TransferToBudgetCode);
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferData.Currency);
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferData.ApportionedAmountA);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferData.ApportionedAmountB);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_Comment());
		budgetTransferObj.budget_BudgetTransfer_Comment().sendKeys(budgetTransferData.Comment);
	}

	@Then("^save and submit by the maker user to transfer$")
	public void save_and_submit_by_the_maker_user_to_transfer() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
		budgetTransferObj.budget_BudgetTransfer_SaveButton().click();

		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NotificationButton());
		budgetTransferObj.budget_BudgetTransfer_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
				
				budgetTransferObj.maker_notification_next_button().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SubmitButton());
		budgetTransferObj.budget_BudgetTransfer_SubmitButton().click();

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		javascripthelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(budgetTransferData.RemarkByMaker);

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_Submit());
		budgetTransferObj.budget_BudgetTransfer_Submit().click();
		Thread.sleep(2000);
    	WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
    	
		clicksAndActionHelper.moveToElement(recordstatus);
    	String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
    	System.out.println(message);
    	budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
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

	@And("^Navigate to the Url and login as reviewer user$")
	public void navigate_to_the_url_and_login_as_reviewer_user() throws IOException, ParseException {
		reader=new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	}

	@Then("^Click on the Notification button$")
	public void click_on_the_notification_button() {
		waithelper=new WaitHelper(driver);
    	reviewer=new KUBS_ReviewerObj(driver);
    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
    	reviewer.reviewerNotidicationIcon().click();
	}

	@Then("^Find the budget code which is submitted by maker$")
	public void find_the_budget_code_which_is_submitted_by_maker() throws IOException, InterruptedException {
		browserHelper = new BrowserHelper(driver);
    	budgetdata=jsonReader.getBudgetdataByName("Maker");
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		
		for (int i = 1; i < 10; i++) {
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)).click();
			
				reader.addReferanceData(referance_id);
				waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
				reviewer.reviewerApproveButton().click();
				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
				reviewer.reviewerAlertRemarks().sendKeys("ok");
				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
				reviewer.reviewerAlertSubmitButton().click();
				Thread.sleep(2000);
		    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
		    	clicksAndActionHelper.moveToElement(recordstatus);
		    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
		    	System.out.println(message);
		    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
				break;
		}
	}

	@And("^reviewer user should logout$")
	public void reviewer_user_should_logout() throws InterruptedException {
		Thread.sleep(5000);
		budgetTransferObj.budget_ProfileName().click();    	
     	waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_Logout());
     	budgetTransferObj.budget_Logout().click();
	}

	@Given("^Navigate to kubs Url and login as a Checker user$")
	public void navigate_to_kubs_url_and_login_as_a_checker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@And("^Click on the security management menu$")
	public void click_on_the_security_management_menu() {
		waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
    	kubschecker.checkerSecurityManagement().click();
	}

	@Then("^Click on open pool sub menu$")
	public void click_on_open_pool_sub_menu() {
		waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
    	kubschecker.checkerActionIcon().click();
	}

	@And("^Click on claim button of the submitted record$")
	public void click_on_claim_button_of_the_submitted_record() throws IOException, ParseException {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
	}

	@And("^claimed status should appear$")
	public void claimed_status_should_appear() {
		WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
	}

	@Then("^finally checker should approve the record$")
	public void finally_checker_should_approve_the_record() throws IOException, ParseException {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(budgetTransferData.CheckerRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
	}

	@And("^system should show prompt message for verification$")
	public void system_should_show_prompt_message_for_verification() throws InterruptedException {
		Thread.sleep(1000);
    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
	}

	@Then("^checker user should logout$")
	public void checker_user_should_logout() throws InterruptedException {
		Thread.sleep(1000);
    	bUDGET_SupplementaryBudgetObj.budget_ProfileName().click();    	
     	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_Logout());
    	bUDGET_SupplementaryBudgetObj.budget_Logout().click();
	}
	
	//----- -- - - -- - - - - Tushar's codes---- - - - - - - - -- - //
	 @Given("^Maker login to KUBS UAT Url$")
	    public void maker_login_to_kubsuat_url() throws Throwable {
	    	 login = new KUBS_Login(driver);
				driver.get(config.getApplicationUrl());
				login.loginToAzentioApp("Maker");
	    }
	    @And("^Maker click on the direction tab in home page$")
	    public void maker_click_on_the_direction_tab_in_home_page() throws Throwable {
	    	waithelper = new WaitHelper(driver);
			budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
	    }

	    @Then("^Maker click on budget$")
	    public void maker_click_on_budget() throws Throwable {
	    	
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetField());
			budgetTransferObj.budget_BudgetTransfer_BudgetField().click();
	    }

	    @Then("^Maker click on budget transfer eye button$")
	    public void maker_click_on_budget_transfer_eye_button() throws Throwable {
	    	  waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
				budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
	    }

	  

	    @And("^Maker click on add button to create new record$")
	    public void maker_click_on_add_button_to_create_new_record() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
			budgetTransferObj.budget_BudgetTransfer_AddButton().click();
		    

	}
	    @Then("^Maker fill the details$")
	    public void maker_fill_the_details() throws Throwable {
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
			
			
	    }

	    @And("^save the record$")
	    public void save_the_record() throws Throwable {
	    	//Save
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
			budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
			Thread.sleep(2000);
	        javascripthelper.JavaScriptHelper(driver);
	        String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	        System.out.println("Message:" +str);	
	    }
	    //--------------Budget_BudgetTransfer_UAT_006_007-----------
	    @Then("^fill the form and enter excessive budget amount to the transfer$")
	    public void fill_the_form_and_enter_excessive_budget_amount_to_transfer()   {
	    	dropDownHelper = new DropDownHelper(driver);
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
			budgetTransferObj.budget_BudgetTransfer_Branch().click();

			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
					.sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountAExcessive);
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

	 
			
			javascripthelper.JavaScriptHelper(driver);
			String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
			//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
			String str = javascripthelper.executeScript(script).toString();
			System.out.println(str);
	    }


}
