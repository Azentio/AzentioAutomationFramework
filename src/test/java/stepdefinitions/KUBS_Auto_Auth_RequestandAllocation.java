package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
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

public class KUBS_Auto_Auth_RequestandAllocation extends BaseClass{

	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	WaitHelper waithelper;
	String reviwerId;
	BUDGET_RequestAndAllocationTestDataType RequestAndAllocationTestData;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerobj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	/*
	 * 
	 * KUBS_BP_BC_01_01_Auto_auth
	 * 
	 */
	@Given("^Navigate The Azentio Kubs url$")
	public void Navigate_The_Azentio_Kubs_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Transfer button Maker$")
	public void Transfer_button_Maker() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Budget module$")
	public void Budget_module() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());
	}

	@Then("^Budget module Budget Request and Allocation click Eye Icon$")
	public void Budget_module_Budget_Request_and_Allocation_click_Eye_Icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());
	}

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

	@And("^Capture Add icon Request and Allocation$")
	public void Capture_Add_icon_Request_and_Allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Addicon().isDisplayed());
	}

	@Then("^Capture current Budget Code$")
	public void Capture_current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
		javahelper.JavaScriptHelper(driver);
		javahelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println();
	}

	/*
	 * @And("^capture the hidden budget name$") public void
	 * capture_the_hidden_budget_name() throws Throwable {
	 * javahelper.JavaScriptHelper(driver); String out= (String) javahelper.
	 * executeScript("return document.getElementById('ion-input-12-lbl')[0].innerText"
	 * ); System.out.println(out); }
	 */

	@And("^Capture current Budget Year$")
	public void Capture_current_Budget_Year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());
	}

	@Then("^Capture on Branch fields$")
	public void Capture_on_Branch_fields() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());
	}

	@And("^Capture one Branch in branch field$")
	public void Capture_one_Branch_in_branch_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type3().isDisplayed());
	}

	@Then("^Capture on Branch ok button in pop up$")
	public void Capture_on_Branch_ok_button_in_pop_up() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

	@Then("^Capture Need currency$")
	public void Capture_Need_currency() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().isDisplayed());
	}

	@And("^Capture Amount for which Budget Type Show in Budget type$")
	public void Capture_Amount_for_which_Budget_Type_Show_in_Budget_type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgettype().isDisplayed());
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^Capture on save icon$")
	public void Capture_on_save_icon() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_AllowSave());
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_AllowSave().isDisplayed());
	}

	@Then("^Click on Maker Notification icon$")
	public void click_on_maker_notification_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Approve the Auto auth Record$")
	public void approve_the_auto_auth_record() throws Throwable {
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(RequestAndAllocationTestData.Remark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		javahelper.JSEClick(kubschecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

	/*
	 * * * Autoauth_Saverecord *
	 */
	@Given("^Navigate The url As Maker$")
	public void Navigate_The_url_as_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Transfer icon$")
	public void Transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Budget module field$")
	public void Budget_module_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());
	}

	@Then("^Budget module Budget Request and Allocation clk Eye Icon$")
	public void Budget_module_Budget_Request_and_Allocation_clk_Eye_Icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());
	}

	@And("^the Budget Code fields$")
	public void the_budget_code_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_code_field().isDisplayed());
	}

	@Then("^the Budget Name Fields$")
	public void the_budget_name_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Name_field().isDisplayed());
	}

	@And("^the Budget Year fields$")
	public void the_budget_year_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Year_field().isDisplayed());
	}

	@Then("^the Budget Type fields$")
	public void the_budget_type_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Type_field().isDisplayed());
	}

	@And("^the Budget Budget Amount fields$")
	public void the_budget_budget_amount_fields() throws Throwable {
		Assert.assertTrue(
				requestAndAllocation.budget_requestAndAllocation_budget_Transfer_Amount_field().isDisplayed());

	}

	@Then("^the Budget Status fields$")
	public void the_budget_status_fields() throws Throwable {
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_budget_Status_field().isDisplayed());
	}

	@And("^Add icon Request and Allocation$")
	public void Add_icon_Request_and_Allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Addicon().isDisplayed());
	}

	@Then("^choose current Budget Code$")
	public void choose_current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
		javahelper.JavaScriptHelper(driver);
		String get = (String) javahelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println(get);
	}

	/*
	 * @And("^capture the hidden budget name$") public void
	 * capture_the_hidden_budget_name() throws Throwable {
	 * javahelper.JavaScriptHelper(driver); String out= (String) javahelper.
	 * executeScript("return document.getElementById('ion-input-12-lbl')[0].innerText"
	 * ); System.out.println(out); }
	 */

	@And("^Clk current Budget Year$")
	public void Clk_current_Budget_Year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());
	}

	@Then("^Clk on Branch fields$")
	public void Clk_on_Branch_fields() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());
	}

	@And("^Clk one Branch in branch field$")
	public void Clk_one_Branch_in_branch_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type3().isDisplayed());
	}

	@Then("^Clk on Branch ok button in pop up$")
	public void Clk_on_Branch_ok_button_in_pop_up() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

	@Then("^Clk Need currency$")
	public void Clk_Need_currency() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().isDisplayed());
	}

	@And("^Select Amount for which Budget Type Show in Budget type$")
	public void Select_Amount_for_which_Budget_Type_Show_in_Budget_type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgettype().isDisplayed());
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^Clk on save icon$")
	public void Clk_on_save_icon() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(2000);
		javahelper.JavaScriptHelper(driver);
		String output = (String) javahelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText");
		System.out.println(output);
	}

	/*
	 * * * Autoauth_MultiRecords
	 * 
	 * 
	 * *
	 */

	@Given("^Launch the Azentio Url as Maker$")
	public void launch_the_azentio_url_as_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Find and clickTwo Direction Icon$")
	public void find_and_clicktwo_direction_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Find and Click on Budget$")
	public void find_and_click_on_budget() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();

	}

	@Then("^UnderClick on Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void underclick_on_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@And("^Right corner Add icon in Request and Allocation$")
	public void right_corner_add_icon_in_request_and_allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Find the updated Budget Code$")
	public void find_the_updated_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(RequestAndAllocationTestData.Multiplecode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose the current financial Budget Year$")
	public void choose_the_current_financial_budget_year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Press on Branch$")
	public void press_on_branch() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect one  Branchs$")
	public void multiselect_one_branchs() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Branch ok button$")
	public void branch_ok_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Which currency we need$")
	public void which_currency_we_need() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Amount for Showing in Budget type field$")
	public void enter_amount_for_showing_in_budget_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^click save button$")
	public void click_save_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Click the Notification Action button$")
	public void click_the_notification_action_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click on Record Approve$")
	public void click_on_record_approve() throws Throwable {
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		javahelper.JSEClick(kubschecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

// Second - MultiRecord
	@Given("^Launch the Url as Maker$")
	public void launch_the_url_as_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@Then("^Mouseclk Two Direction Icon$")
	public void Mouseclk_two_direction_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Mouseclk on Budget$")
	public void Mouseclk_on_budget() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();

	}

	@Then("^Mouseclk on Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void Mouseclk_on_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@And("^Mouseclk Add icon in Request and Allocation$")
	public void Mouseclk_add_icon_in_request_and_allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^updated Budget Code$")
	public void updated_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(RequestAndAllocationTestData.Multiplecode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^current financial Budget Year$")
	public void current_financial_budget_year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Mouseclk on Branch$")
	public void Mouseclk_on_branch() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect Two  Branchs$")
	public void multiselect_two_branchs() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type4());
		requestAndAllocation.requestAndAllocation_branch_type4().click();
	}

	@Then("^Branch Mouseclk ok button$")
	public void branch_Mouseclk_ok_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Mouseclk select currency we need$")
	public void Mouseclk_select_currency_we_need() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@Then("^Mouseclk and Enter Amount for Showing in Budget type field$")
	public void Mouseclk_and_enter_amount_for_showing_in_budget_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^Mouseclk save button$")
	public void Mouseclk_save_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Mouseclk the Action button$")
	public void Mouseclk_the_action_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Mouseclk on Record Approve$")
	public void Mouseclk_on_record_approve() throws Throwable {
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		javahelper.JSEClick(kubschecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

// Third - MultiRecord
	@Given("^Launch Maker Url$")
	public void launch_maker_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@Then("^Mouseclk Transfer Icon$")
	public void Mouseclk_transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Mouseclk Budget fields$")
	public void Mouseclk_budget_fields() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();

	}

	@Then("^Mouseclk Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void Mouseclk_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@And("^Mouseclk Add icon Request and Allocation$")
	public void Mouseclk_add_icon_request_and_allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Choose updated Budget Code$")
	public void Choose_updated_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(RequestAndAllocationTestData.Multiplecode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^choose current financial Budget Year$")
	public void choose_current_financial_budget_year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Mouseclk on Branch fields$")
	public void Mouseclk_on_branch_fields() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Multiselect on Third  Branchs$")
	public void multiselect_on_third_branchs() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
	}

	@Then("^Branch Mouseclk on ok button$")
	public void branch_Mouseclk_on_ok_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Mouseclk select which currency we need$")
	public void Mouseclk_select_which_currency_we_need() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@Then("^Mouseclk then Enter Amount for Showing in Budget type field$")
	public void Mouseclk_then_enter_amount_for_showing_in_budget_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^Mouseclk on save button$")
	public void Mouseclk_on_save_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(3000);
	}

	@Then("^Mouseclk to the Action button$")
	public void Mouseclk_to_the_action_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Mouseclk on the Record Approve$")
	public void Mouseclk_on_the_record_approve() throws Throwable {
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		javahelper.JSEClick(kubschecker.checkersubmitButton());
		Thread.sleep(2000);
		String getdata = requestAndAllocation.Popup_status().getText();
		System.out.println(getdata);
	}

	/*
	 *
	 *
	 * Autoauth - ManualYear
	 *
	 */
	@Given("^Navigate The product url$")
	public void Navigate_The_product_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^CLK Transfer icon$")
	public void CLK_Transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^CLK Budget module field")
	public void CLK_Budget_module_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());
	}

	@Then("^CLK Budget module Budget Request and Allocation clk Eye Icon$")
	public void CLK_Budget_module_Budget_Request_and_Allocation_clk_Eye_Icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());
	}

	@And("^CLK Add icon Request and Allocation$")
	public void CLK_Add_icon_Request_and_Allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Addicon().isDisplayed());
	}

	@Then("^press current Budget Code$")
	public void press_current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
		javahelper.JavaScriptHelper(driver);
		String get = (String) javahelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println();
	}

	@And("^Manual Enter current Budget Year$")
	public void Manual_Enter_current_Budget_Year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		String gettext = requestAndAllocation.budget_requestAndAllocation_Budgetyear().getText();
		System.out.println(gettext);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());

	}

	/*
	 *
	 * Autoauth - pastyear
	 *
	 *
	 */
	@Given("^Navigate The product$")
	public void Navigate_The_product() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^CLK Transfer$")
	public void CLK_Transfer() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^CLK Budget module")
	public void CLK_Budget_module() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());
	}

	@Then("^CLK Budget module clk Eye Icon$")
	public void CLK_Budget_module_clk_Eye_Icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());
	}

	@And("^CLK Add icon$")
	public void CLK_Add_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Addicon().isDisplayed());
	}

	@Then("^CLK current Budget Code$")
	public void CLK_current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
		javahelper.JavaScriptHelper(driver);
		String get = (String) javahelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println();
	}

	@And("^Enter and capture the Previous Budget Year$")
	public void Enter_and_capture_the_Previous_Budget_Year() throws Throwable {
		/*
		 * waithelper.waitForElement(driver, 3000,
		 * requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		 * dropDownHelper.SelectUsingVisibleText(requestAndAllocation.
		 * budget_requestAndAllocation_Budgetyear(),
		 * RequestAndAllocationTestData.BudgetYear);
		 * requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.
		 * DOWN);
		 */
		String Text = requestAndAllocation.budget_requestAndAllocation_Budgetyear().getText();
		System.out.println(Text);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());
	}

	/*
	 *
	 * Autoauth - Validation
	 *
	 */

	@Given("^Navigate The url login$")
	public void navigate_the_url_login() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Touch Transfer icon$")
	public void touch_transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Touch Budget module field$")
	public void touch_budget_module_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());

	}

	@Then("^Select Budget module Budget Request and Allocation clk Eye Icon$")
	public void select_budget_module_budget_request_and_allocation_clk_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());

	}

	@And("^Hit Add icon Request and Allocation$")
	public void hit_add_icon_request_and_allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^choose Budget Code$")
	public void choose_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Clk Budget Year$")
	public void clk_budget_year() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetyear().isDisplayed());

	}

	@Then("^Clk Branch fields$")
	public void clk_branch_fields() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_Budgetbranch().isDisplayed());

	}

	@And("^Choose Branch in branch field$")
	public void Choose_branch_in_branch_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type());
		requestAndAllocation.requestAndAllocation_branch_type().click();
		Assert.assertTrue(requestAndAllocation.requestAndAllocation_branch_type().isDisplayed());
	}

	@Then("^Clk Branch ok button in pop up$")
	public void clk_branch_ok_button_in_pop_up() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
		// Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_branchOK().isDisplayed());
	}

//document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText
	@And("^Capture the validation Message$")
	public void capture_the_validation_message() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		WebElement message = (WebElement) javahelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String validate = message.getText();
		System.out.println("Validation Message : " + validate);
	}

	/*
	 *
	 * Autoauth - Manualcode Enter
	 *
	 */
	@Given("^Navigate The login url$")
	public void navigate_the_login_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Touch the Transfer icon$")
	public void touch_the_transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Touch the Budget module field$")
	public void touch_the_budget_module_field() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetField().isDisplayed());

	}

	@Then("^Select the Budget module Budget Request and Allocation clk Eye Icon$")
	public void select_the_budget_module_budget_request_and_allocation_clk_eye_icon() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		Assert.assertTrue(requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().isDisplayed());

	}

	@And("^Hit the Add icon Request and Allocation$")
	public void hit_the_add_icon_request_and_allocation() throws Throwable {
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^choose the Budget Code$")
	public void choose_the_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

}