package stepdefinitions;

import org.openqa.selenium.By;
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
import io.cucumber.java.en.When;

import resources.BaseClass;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import pageobjects.BUDGET_RequestAndAllocationObj;

public class BUDGET_RequestAndAllocation extends BaseClass {

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	DropDownHelper dropDownHelper;
	BUDGET_RequestAndAllocationTestDataType RequestAndAllocationTestData;
	BUDGET_RequestandallocationBUDTYPEDATA requestandallocationbudtype;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	WaitHelper waithelper;
	JavascriptHelper javahelper = new JavascriptHelper();

	@Given("^Open Azentio login$")
	public void Open_Azentio_login() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");

	}

	@And("^Click the Dirction icon$")
	public void click_the_dirction_icon() {
		waithelper = new WaitHelper(driver);
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@When("^Select the budget Field$")
	public void select_the_budget_field() {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@And("^Click the Budget request & allocation Eye icon$")
	public void click_the_budget_request_allocation_eye_icon() {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Curser click the add icon$")
	public void curser_click_the_add_icon() {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@And("^Select budget code$")
	public void select_budget_code() {
		dropDownHelper = new DropDownHelper(driver);
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		// dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetcode(),
		// RequestAndAllocationTestData.BudgetCode);
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		// requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select budget year$")
	public void select_budget_year() {
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
	}

	@And("^Select budget branch$")
	public void select_budget_branch() {
		// dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetbranch(),
		// RequestAndAllocationTestData.Branch);
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_co());
		requestAndAllocation.requestAndAllocation_branch_co().click();
		waithelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Enter budget amount$")
	public void enter_budget_amount() {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		String before_xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='";
		String after_xpath = "']";
		String before_xpath_for_remark = "//datatable-body-cell[3]/div/input[@id='"; // datatable-body-cell[3]/div/input[@id='3']
		String after_xpath_for_remark = "']";
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		System.out.println("BUDGET PERIOD IS: " + requestandallocationbudtype.BudgetPeriod);
		System.out.println("BUDGET TYPE FROM FORM" + budgettype);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 10000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());			
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			for (int i = 0; i <= 11; i++) {
				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver
						.findElement(By.xpath(before_xpath_for_remark + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {
					budget_amount.sendKeys(RequestAndAllocationTestData.BudgetAmount);
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}
			}
		} else if (budgettype.equalsIgnoreCase("Quaterly")) {

			for (int i = 0; i <= 3; i++) {
				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver
						.findElement(By.xpath(before_xpath_for_remark + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {
					budget_amount.sendKeys(RequestAndAllocationTestData.BudgetAmount);
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}

			}
		} else if (budgettype.equalsIgnoreCase("Halfyearly")) {
			for (int i = 0; i <= 1; i++) {
				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver
						.findElement(By.xpath(before_xpath_for_remark + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {
					budget_amount.sendKeys(RequestAndAllocationTestData.BudgetAmount);
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}

			}
		}
	}

	@And("^Select currency$")
	public void select_currency() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);

	}

	@And("^Click the save button$")
	public void click_the_save_button() throws Throwable {
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@And("^Click the action button in table$")
	public void click_the_action_button_in_table() {
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button\")";
		driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.BudgetCode + aftr_action)).click();
	}

	@And("^Submit the record$")
	public void submit_the_record() {
		requestAndAllocation.budget_requestAndAllocation_Budgetsave().click();
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
	}

}
