package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class BUDGET_Auto_Auth_RequestandAllocation extends BaseClass{

	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	WaitHelper waitHelper;
	String reviwerId;
	BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javaHelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsChecker = new KUBS_CheckerObj(driver);
	
	// -----------------------AZENTIO COMMON LOGIN STEPS--------------------------//

	@Given("^Navigate Azentio Maker Url$")
	public void navigate_azentio_maker_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppByMaker();
	}
		// -------------------------MAKER COMMON STEPS--------------------------//

		@Then("^Click Transfer Icon button$")
		public void click_transfer_icon_button() throws Throwable {

			// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
			requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
			requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

		}

		@And("^Click on Budget Module field$")
		public void click_on_budget_module_field() throws Throwable {

			// -----------TO CLICK THE BUDGET MODULE--------------//
			waitHelper = new WaitHelper(driver);
			requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
			requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		}

		@Then("^Click on Budget Sub module Near Eye Icon button$")
		public void click_on_Budget_Sub_module_near_eye_icon_button() throws Throwable {

			// ----------TO CLICK THE EYE ICON------------------//
			waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
			requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		}

		@And("^Click on Add icon Request and Allocation$")
		public void click_on_add_icon_request_and_allocation() throws Throwable {

			// ----------TO CREATE A NEW BUDGET AMOUNT------------//
			waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
			requestAndAllocation.budget_requestAndAllocation_Addicon().click();
		}


	/*
	 * 
	 * KUBS_BP_BC_01_01_Auto_auth
	 * 
	 */
	
	@And("^Capture the Budget Code fields$")
	public void capture_the_budget_code_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_code_field().isDisplayed());
	}

	@Then("^Capture the Budget Name Fields$")
	public void capture_the_budget_name_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Name_field().isDisplayed());
	}

	@And("^Capture the Budget Year fields$")
	public void capture_the_budget_year_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Year_field().isDisplayed());
	}

	@Then("^Capture the Budget Type fields$")
	public void capture_the_budget_type_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Type_field().isDisplayed());
	}

	@Then("^Capture the Budget Status fields$")
	public void capture_the_budget_status_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Status_field().isDisplayed());
	}

	@And("^Capture the Budget Budget Amount fields$")
	public void capture_the_budget_budget_amount_fields() throws Throwable {
		Assert.assertTrue(
				requestAndAllocation.budget_requestAndAllocation_budget_Transfer_Amount_field().isDisplayed());

	}


	


	@And("^Capture current Budget Year$")
	public void Capture_current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());
	}

	@Then("^Capture on Branch fields$")
	public void Capture_on_Branch_fields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());
	}

	@And("^Capture one Branch in branch field$")
	public void Capture_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type());
		requestAndAllocation.requestAndAllocation_branch_type().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type().isDisplayed());
	}

	@Then("^Capture on Branch ok button in pop up$")
	public void Capture_on_Branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

	@Then("^Capture Need currency$")
	public void Capture_Need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().isDisplayed());
	}

	

	@And("^Capture on save icon$")
	public void Capture_on_save_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_AllowSave().isDisplayed());
	}

	@Then("^Click on Maker Notification icon$")
	public void click_on_maker_notification_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Approve the Auto auth Record$")
	public void approve_the_auto_auth_record() throws Throwable {
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys(requestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		javaHelper.JSEClick(kubsChecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

	/*
	 * * * @KUBS_BP_BC_01_03_Autoauth_Savarecord
	 */
	
	


	@And("^Clk current Budget Year$")
	public void Clk_current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());
	}

	@Then("^Clk on Branch fields$")
	public void Clk_on_Branch_fields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());
	}

	@And("^Clk one Branch in branch field$")
	public void Clk_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type3().isDisplayed());
	}

	@Then("^Clk on Branch ok button in pop up$")
	public void Clk_on_Branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

	@Then("^Clk Need currency$")
	public void Clk_Need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().isDisplayed());
	}

	

	@And("^Clk on save icon$")
	public void Clk_on_save_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(2000);
		javaHelper.JavaScriptHelper(driver);
		String output = (String) javaHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText");
		System.out.println(output);
	}

	/*
	 * * * 
	 * 
	 * @KUBS_BP_BC_01_04_Autoauth_MultipleRecords
	 * 
	 * * *
	 */


	

	@And("^Choose the current financial Budget Year$")
	public void choose_the_current_financial_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Press on Branch$")
	public void press_on_branch() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect one  Branchs$")
	public void multiselect_one_branchs() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Branch ok button$")
	public void branch_ok_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Which currency we need$")
	public void which_currency_we_need() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	

	@And("^click save button$")
	public void click_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Click the Notification Action button$")
	public void click_the_notification_action_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click on Record Approve$")
	public void click_on_record_approve() throws Throwable {
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		javaHelper.JSEClick(kubsChecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

// Second - MultiRecord

	
	@And("^current financial Budget Year$")
	public void current_financial_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Mouseclk on Branch$")
	public void Mouseclk_on_branch() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect Two  Branchs$")
	public void multiselect_two_branchs() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type4());
		requestAndAllocation.requestAndAllocation_branch_type4().click();
	}

	@Then("^Branch Mouseclk ok button$")
	public void branch_Mouseclk_ok_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Mouseclk select currency we need$")
	public void Mouseclk_select_currency_we_need() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}



	@And("^Mouseclk save button$")
	public void Mouseclk_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Mouseclk the Action button$")
	public void Mouseclk_the_action_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Mouseclk on Record Approve$")
	public void Mouseclk_on_record_approve() throws Throwable {
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		javaHelper.JSEClick(kubsChecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

// Third - MultiRecord



	@And("^choose current financial Budget Year$")
	public void choose_current_financial_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Mouseclk on Branch fields$")
	public void Mouseclk_on_branch_fields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect on Third  Branchs$")
	public void multiselect_on_third_branchs() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
	}

	@Then("^Branch Mouseclk on ok button$")
	public void branch_Mouseclk_on_ok_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Mouseclk select which currency we need$")
	public void Mouseclk_select_which_currency_we_need() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	

	@And("^Mouseclk on save button$")
	public void Mouseclk_on_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Mouseclk to the Action button$")
	public void Mouseclk_to_the_action_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Mouseclk on the Record Approve$")
	public void Mouseclk_on_the_record_approve() throws Throwable {
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		javaHelper.JSEClick(kubsChecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

	/*
	 *
	 *
	 * @KUBS_BP_BC_01_07_Autoauth_ManualYear
	 *
	 */


	

	@And("^Manual Enter current Budget Year$")
	public void Manual_Enter_current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		String gettext = requestAndAllocation.budget_requestAndAllocation_Budgetyear().getText();
		System.out.println(gettext);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());

	}

	/*
	 *
	 *  @KUBS_BP_BC_01_08_Autoauth_pastYear
	 *
	 *
	 */


	@And("^Enter and capture the Previous Budget Year$")
	public void Enter_and_capture_the_Previous_Budget_Year() throws Throwable {
		/*waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear1());
		String Text = requestAndAllocation.budget_requestAndAllocation_Budgetyear1().getText();
		System.out.println(Text);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear1().isDisplayed());*/
		String Text = requestAndAllocation.budget_requestAndAllocation_Budgetyear().getText();
		System.out.println(Text);
		boolean pastyear = false;
		try {
			requestAndAllocation.budget_requestAndAllocation_Budgetyear1().click();
		}catch(NoSuchElementException e) {
			pastyear = true;
		}
		Assert.assertTrue(pastyear);
	}

	/*
	 *
	 *  @KUBS_BP_BC_01_02_Autoauth_Validation
	 *
	 */


	

	@And("^Clk Budget Year$")
	public void clk_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());

	}

	@Then("^Clk Branch fields$")
	public void clk_branch_fields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());

	}

	@And("^Choose Branch in branch field$")
	public void Choose_branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type3().isDisplayed());
	}

	@Then("^Clk Branch ok button in pop up$")
	public void clk_branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

//document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText
	@And("^Capture the validation Message$")
	public void capture_the_validation_message() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
		WebElement message = (WebElement) javaHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String validate = message.getText();
		System.out.println("Validation Message : " + validate);
	}

	/*
	 *
	 * @KUBS_BP_BC_01_06_Autoauth_CodeenterManually
	 *
	 */

	

}
