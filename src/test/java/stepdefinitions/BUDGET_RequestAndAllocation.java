package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_RequestAndAllocationObj;
import resources.BaseClass;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

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
		//body/app-root[1]/ion-app[1]/ion-split-pane[1]/ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/div[2]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[1]
		//driver.findElement(By.xpath("//body/app-root[1]/ion-app[1]/ion-split-pane[1]/ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/div[2]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[1]")).click();
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
		// javascripthelper=new JavascriptHelper();
		//datatable-row-wrapper[12]/datatable-body-row/div/datatable-body-cell[2]//input
		//requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		javahelper.JavaScriptHelper(driver);
		//javascripthelper.JavaScriptHelper(driver);
		Actions action=new Actions(driver);
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]//input";
		//String before_xpath_for_remark = "//datatable-body-cell[3]/div/input[@id='"; // datatable-body-cell[3]/div/input[@id='3']
		String after_xpath_for_remark = "]/datatable-body-row/div/datatable-body-cell[2]//input";
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		System.out.println("BUDGET PERIOD IS: " + requestandallocationbudtype.BudgetPeriod);
		System.out.println("BUDGET TYPE FROM FORM" + budgettype);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waithelper.waitForElement(driver, 10000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());

			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {
			System.out.println("Inside monthy budget code");
			javahelper.scrollIntoView(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12().click();
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12().sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12().sendKeys(RequestAndAllocationTestData.Remark);
		}
/*
			for (int i = 12; i <= 1; i--) {
				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver.findElement(By.xpath(before_xpath + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {
					waithelper.waitForElement(driver, 2000,budget_amount );
					budget_amount.click();
					budget_amount.sendKeys(requestandallocationbudtype.BudgetAmounT);
					budget_remark.click();
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}
				else
				{
					break;
				}
			}
		} else if (budgettype.equalsIgnoreCase("Quaterly")) {

			for (int i = 0; i <= 3; i++) {

				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver
						.findElement(By.xpath(before_xpath + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {

					budget_amount.click();
					budget_amount.sendKeys(RequestAndAllocationTestData.BudgetAmount);
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}

			}
		} else if (budgettype.equalsIgnoreCase("Halfyearly")) {
			for (int i = 0; i <= 1; i++) {
				WebElement budget_amount = driver.findElement(By.xpath(before_xpath + i + after_xpath));
				WebElement budget_remark = driver
						.findElement(By.xpath(before_xpath + i + after_xpath_for_remark));
				if (budget_amount.isEnabled() && budget_remark.isEnabled()) {
					budget_amount.sendKeys(RequestAndAllocationTestData.BudgetAmount);
					budget_remark.sendKeys(RequestAndAllocationTestData.Remark);
				}

			}
		}*/
	}
	//4234

	@And("^Select currency$")
	public void select_currency() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys("RUP");
		//requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);

	}

	@And("^Click the save button$")
	public void click_the_save_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@And("^Click the action button in table$")
	public void click_the_action_button_in_table() {
		//RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		//RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();

		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.BudgetCode + aftr_action)));
		driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.BudgetCode + aftr_action)).click();
	}

	@And("^Submit the record$")
	public void submit_the_record() {
		//waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetsave());
		//requestAndAllocation.budget_requestAndAllocation_Budgetsave().click();
		waithelper.waitForElement(driver, 3000,requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waithelper.waitForElement(driver, 3000,requestAndAllocation.budgetAllocationAlertRemarks());
		requestAndAllocation.budgetAllocationAlertRemarks().sendKeys(RequestAndAllocationTestData.Remark);
		waithelper.waitForElement(driver, 3000,requestAndAllocation.budgetAllocationAlertsubmitButton());
		requestAndAllocation.budgetAllocationAlertsubmitButton().click();
	}

}
