package stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class Budget_BudgetRequestandAllocation_UAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	String reviwerId;
	// BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData = new
	// BUDGET_RequestAndAllocationTestDataType();
	JsonConfig jsonReader = new JsonConfig();

	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javaHelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	String referance_id;
	String Type;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_CheckerObj kubsChecker = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetCreationObj budgetCreationobj = new BUDGET_BudgetCreationObj(driver);
	Map<String, String> budgetAllocationTestData = new HashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBudgetRequestAndAllocation = new ExcelData(path, "BudgetReqAndAllocation", "DataSet ID");
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
// ---------------------------LOGIN---------------------------------//

	@Given("^Navigate to the Azentio Url$")
	public void navigate_to_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppByMaker();

	}

	@Given("^Azentio Url login as Reviewer$")
	public void azentio_url_login_as_reviewer() throws Throwable {

		// ---------LOGIN THE REVIEWER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Given("^Azentio Url login as checker page$")
	public void azentio_url_login_as_checker_page() throws Throwable {

		// ---------LOGIN THE CHECKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	// ---------------------------MAKER COMMON
	// STEPS---------------------------------//

//	@Then("^click the Two Direction Icon$")
//	public void click_the_two_direction_icon() throws Throwable {
//
//		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
//		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
//		
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 60, 500);		
//		clickAndActionHelper.moveToElement(kubsMakerObj.kubsToolIcon());
//		clickAndActionHelper.doubleClick(kubsMakerObj.kubsToolIcon());
//		waitHelper.waitForElementToVisibleWithFluentWait(driver,requestAndAllocation.budget_requestAndAllocation_DirctionIcon(), 60, 500);
//		clickAndActionHelper.moveToElement(requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
//		clickAndActionHelper.doubleClick(requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
//		
//	}

	@And("^click to the Budget$")
	public void click_to_the_budget() throws Throwable {

		// -----------TO CLICK THE BUDGET MODULE--------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_BudgetField(), 60, 500);
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();

	}

	@Then("^click on the Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void click_on_the_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {

		// ----------TO CLICK THE EYE ICON------------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon(), 60, 500);
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@And("^click on the Add icon in Request and Allocation$")
	public void click_on_the_add_icon_in_request_and_allocation() throws Throwable {

		// ----------TO CREATE A NEW BUDGET AMOUNT------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Addicon(), 60, 500);
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@And("^get the test data for allocate the budget for current finacial year$")
	public void get_the_test_data_for_allocate_the_budget_for_current_finacial_year() throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_001_005_D1");
	}

	@And("^get the test data for allocate the budget for validate the monthy budget amount field$")
	public void get_the_test_data_for_allocate_the_budget_for_validate_the_monthy_budget_amount_field()
			throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
	}

	@And("^get the test data for allocate the budget for validate the quarterly budget amount field$")
	public void get_the_test_data_for_allocate_the_budget_for_validate_the_quarterly_budget_amount_field()
			throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
	}

	@And("^get the test data for allocate the budget for validate the half yearly budget amount field$")
	public void get_the_test_data_for_allocate_the_budget_for_validate_the_half_yearly_budget_amount_field()
			throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
	}

	@And("^get the test data for allocate the budget for future finacial year$")
	public void get_the_test_data_for_allocate_the_budget_for_future_finacial_year() throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_001_006_D1");
	}

	@And("^get the test data for modify budget after HO approval$")
	public void get_the_test_data_for_modify_budget_after_ho_approval() throws Throwable {
		budgetAllocationTestData = excelDataForBudgetRequestAndAllocation.getTestdata("KUBS_B&P_UAT_003_002_D1");
	}

	@And("^enter the budget code for budget request and allocation screen$")
	public void enter_the_budget_code_for_budget_request_and_allocation_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetcode(), 20, 1);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(budgetAllocationTestData.get("BudgetCode"));
		String xpath = "//ng-dropdown-panel//span[contains(text(),'" + budgetAllocationTestData.get("BudgetCode")
				+ "')]";
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on search button in busget request and allocation screen$")
	public void click_on_search_button_in_busget_request_and_allocation_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 20, 1);
		kubsCommonObj.kubsListViewSearchButton().click();

	}

	@And("^search for approved budget in budgte request and allocation screen$")
	public void search_for_approved_budget_in_budgte_request_and_allocation_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch(), 20, 1);
		clickAndActionsHelper.moveToElement(requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		clickAndActionsHelper.clickOnElement(requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch()
				.sendKeys(budgetAllocationTestData.get("BudgetCode"));
	}

	@Then("^validate the budget amount field of quarterly budget record$")
	public void validate_the_budget_amount_field_of_quarterly_budget_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, requestAndAllocation.requestAndAllocationSystemDate(),
				20, 1);
		String systemDate = requestAndAllocation.requestAndAllocationSystemDate().getText();
		String[] spliSystemDate = systemDate.split("-");
		String splitMonth = spliSystemDate[1];
		if (splitMonth.equalsIgnoreCase("Apr") || splitMonth.equalsIgnoreCase("May")
				|| splitMonth.equalsIgnoreCase("Jun")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour()
					.getAttribute("ng-reflect-is-disabled"), "false");
		} else if (splitMonth.equalsIgnoreCase("Jul") || splitMonth.equalsIgnoreCase("Aug")
				|| splitMonth.equalsIgnoreCase("Sep")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour()
					.getAttribute("ng-reflect-is-disabled"), "false");
		} else if (splitMonth.equalsIgnoreCase("Oct") || splitMonth.equalsIgnoreCase("Nov")
				|| splitMonth.equalsIgnoreCase("Dec")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour()
					.getAttribute("ng-reflect-is-disabled"), "false");
		} else if (splitMonth.equalsIgnoreCase("Jan") || splitMonth.equalsIgnoreCase("Feb")
				|| splitMonth.equalsIgnoreCase("Mar")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldThree()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldFour()
					.getAttribute("ng-reflect-is-disabled"), "false");
		}
	}

	@Then("^validate the budget amount field of half yearly budget record$")
	public void validate_the_budget_amount_field_of_half_yearly_budget_record() throws Throwable {
		String systemDate = requestAndAllocation.requestAndAllocationSystemDate().getText();
		String[] spliSystemDate = systemDate.split("-");
		String splitMonth = spliSystemDate[1];
		if (splitMonth.equalsIgnoreCase("Apr") || splitMonth.equalsIgnoreCase("May")
				|| splitMonth.equalsIgnoreCase("Jun") || splitMonth.equalsIgnoreCase("Jul")
				|| splitMonth.equalsIgnoreCase("Aug") || splitMonth.equalsIgnoreCase("Sep")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "false");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "false");
		} else if (splitMonth.equalsIgnoreCase("Oct") || splitMonth.equalsIgnoreCase("Nov")
				|| splitMonth.equalsIgnoreCase("Dec") || splitMonth.equalsIgnoreCase("Jan")
				|| splitMonth.equalsIgnoreCase("Feb") || splitMonth.equalsIgnoreCase("Mar")) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldOne()
					.getAttribute("ng-reflect-is-disabled"), "true");
			waitHelper.waitForElementToVisibleWithFluentWait(driver,
					requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo(), 20, 1);
			Assert.assertEquals(requestAndAllocation.budgetRequestAndAllocationQuarterlyBudgetAmontFieldTwo()
					.getAttribute("ng-reflect-is-disabled"), "false");
		}
	}

	@Then("^verify approved budget code should reflect in budget request and allocation screen$")
	public void verify_approved_budget_code_should_reflect_in_budget_request_and_allocation_screen() throws Throwable {
		String xpath = "//span[contains(text(),' " + budgetAllocationTestData.get("BudgetCode")
				+ " ')]//ancestor::datatable-row-wrapper[1]";
		for (int i = 0; i <= 100; i++) {
			try {
				driver.findElement(By.xpath(xpath)).isDisplayed();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the budget code in after HO approval scenario excel database$")
	public void store_the_budget_code_in_after_ho_approval_scenario_excel_database() throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_002_D1", "BudgetCode",
				budgetAllocationTestData.get("BudgetCode"));
	}

	@And("^select the budget year as current financial year$")
	public void select_the_budget_year_as_current_financial_year() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 20, 1);

		dropDownHelper.SelectUsingIndex(requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 0);

	}

	@And("^select the budget record in request and allocation screen$")
	public void select_the_budget_record_in_request_and_allocation_screen() throws Throwable {
		String xpath = "//span[contains(text(),'" + budgetAllocationTestData.get("BudgetCode")
				+ "')]//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell//ion-button[1]";
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));

				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;

			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^update the budget code in request and allocation$")
	public void update_the_budget_code_in_request_and_allocation() throws Throwable {
		String xpath = "//app-kub-currency[@id='0']//input";
		for (int i = 0; i < 12; i++) {
			try {
				driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']//input")).click();
				driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']//input")).clear();
				driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']//input"))
						.sendKeys(budgetAllocationTestData.get("UpdatedBudgetAmount"));
				driver.findElement(By.xpath("//input[@id='" + i + "']")).click();
				driver.findElement(By.xpath("//input[@id='" + i + "']")).clear();
				driver.findElement(By.xpath("//input[@id='" + i + "']"))
						.sendKeys(budgetAllocationTestData.get("Remark"));
			} catch (Exception e) {

			}
		}
	}

	@And("^select the budget year as future financial year$")
	public void select_the_budget_year_as_future_financial_year() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 20, 1);
		dropDownHelper.SelectUsingIndex(requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 2);
	}

	@And("^select the branch in budget request and allocation screen$")
	public void select_the_branch_in_budget_request_and_allocation_screen() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetbranch(), 20, 1);
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
		String xpath = "(//div[contains(text(),'" + budgetAllocationTestData.get("Branch")
				+ "')]//ancestor::button//div/div[1])[1]";
		for (int i = 0; i <= 100; i++) {
			try {
				javaHelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
				driver.findElement(By.xpath(xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_branchOK(), 20, 1);
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^validate the amount field should populate as per the financial period$")
	public void validate_the_amount_field_should_populate_as_per_the_financial_period() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, requestAndAllocation.requestAndAllocationSystemDate(),
				20, 1);
		String systemDate = requestAndAllocation.requestAndAllocationSystemDate().getText();
		String[] splitSystemDate = systemDate.split("-");
		System.out.println("Month " + splitSystemDate[1]);
		String xpath = "//div[contains(text(),'" + splitSystemDate[1]
				+ "')]//parent::datatable-body-cell//following-sibling::datatable-body-cell[1]//app-kub-currency";
		String currencyFieldValidation = driver.findElement(By.xpath(xpath)).getAttribute("ng-reflect-is-disabled");
		if (currencyFieldValidation.equalsIgnoreCase("false")) {
			System.out.println("Its getting populatted");
		} else {
			Assert.fail("Currency field not getting populatted currectly");
		}
	}

	@And("^enter the currency in budget request and allocation screen$")
	public void enter_the_currency_in_budget_request_and_allocation_screen() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Amountcurruncy(), 20, 1);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy()
				.sendKeys(budgetAllocationTestData.get("Currency"));
		String xpath = "//ng-dropdown-panel//span[text()='" + budgetAllocationTestData.get("Currency") + "']";
		for (int i = 0; i <= 200; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^enter the amount in budget request and allocation screen$")
	public void enter_the_amount_in_budget_request_and_allocation_screen() throws Throwable {
		String fieldStatus = "";
		for (int i = 0; i < 12; i++) {
			for (int k = 0; k <= 100; k++) {
				try {
					fieldStatus = driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']"))
							.getAttribute("ng-reflect-is-disabled");
					System.out.println("Field Status is" + fieldStatus);
					break;
				} catch (Exception e) {

				}
			}
			if (fieldStatus.equalsIgnoreCase("false")) {
				for (int j = 0; j <= 100; j++) {
					try {
						driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']//input")).click();
						driver.findElement(By.xpath("//app-kub-currency[@id='" + i + "']//input"))
								.sendKeys(budgetAllocationTestData.get("BudgetAmount"));
						driver.findElement(By.xpath("//input[@id='" + i + "']")).click();
						driver.findElement(By.xpath("//input[@id='" + i + "']"))
								.sendKeys(budgetAllocationTestData.get("Remark"));
						break;
					} catch (Exception e) {

					}
				}
			}
		}
	}

	// End
	@Then("^click on the Branch$")
	public void click_on_the_branch() throws Throwable {

		// ----------TO SELECT THE BRANCH-----------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetbranch(), 60, 500);
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^get the budget code for allocation$")
	public void get_the_budget_code_for_allocation() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationobj.budgetCreationApprovedBudgetCode(),
				60, 500);
		// budgetCreationobj.budgetCreationApprovedBudgetCode().getText();
		budgetAllocationTestData.put("budgetCode", budgetCreationobj.budgetCreationApprovedBudgetCode().getText());
		System.out.println("Budget code is : " + budgetAllocationTestData.get("budgetCode"));
	}

	@Then("^click on the Branch ok button$")
	public void click_on_the_branch_ok_button() throws Throwable {

		// -----------TO CLICK BRANCH OK BUTTON------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_branchOK(), 60, 500);
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();

	}

	@Then("^select one currency we need$")
	public void select_one_currency_we_need() throws Throwable {

		// -----------TO SELECT THE CURRENCY WE NEED-----------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Amountcurruncy(), 60, 500);
		// waitHelper.waitForElement(driver, 3000,
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@Then("^click on the Maker icon button$")
	public void click_on_the_maker_icon_button() throws Throwable {

		// -----------TO CLICK THE MAKER NOTIFICATION-------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver, requestAndAllocation.makerNotificationIcon(), 60, 500);
		// waitHelper.waitForElement(driver, 2000,
		// requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, requestAndAllocation.maker_Referance_id(), 60, 500);
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^click on the save button$")
	public void click_on_the_save_button() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_AllowSave(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^search for budget request and allocation record in notification$")
	public void search_for_budget_request_and_allocation_record_in_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(budgetAllocationTestData.get("ModuleCode"));
	}

	@And("^store the record reference number of budget allocation record request and allocation excel database$")
	public void store_the_record_reference_number_of_budget_allocation_record_request_and_allocation_excel_database()
			throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budgetRequestAndAllocationReferenceNumber(), 20, 1);
		String referenceNumber = requestAndAllocation.budgetRequestAndAllocationReferenceNumber().getText();
		excelDataForBudgetRequestAndAllocation.updateTestData(budgetAllocationTestData.get("DataSet ID"),
				"Reference ID", referenceNumber);
	}

	@And("^select the request and allocation notification record$")
	public void select_the_request_and_allocation_notification_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budgetRequestAndAllocationNotificationFirstRecord(), 20, 1);
		clickAndActionsHelper.moveToElement(requestAndAllocation.budgetRequestAndAllocationNotificationFirstRecord());
		clickAndActionsHelper.clickOnElement(requestAndAllocation.budgetRequestAndAllocationNotificationFirstRecord());
	}

	@And("^click on submit in request and allocation screen$")
	public void click_on_submit_in_request_and_allocation_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in request and allocation$")
	public void enter_the_alert_remark_in_request_and_allocation() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());

		kubsCommonObj.kubsAlertRemark().sendKeys(budgetAllocationTestData.get("MakerAlertRemark"));
	}

	@And("^click on alert submit in request and allocation$")
	public void click_on_alert_submit_in_request_and_allocation() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonObj.kubsAlertSubmit().click();
				break;
			} catch (Exception e) {

				if (i == 50) {
					Assert.fail(e.getMessage());
				} else if (i != 50) {
					clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());

					kubsCommonObj.kubsAlertRemark().sendKeys(budgetAllocationTestData.get("MakerAlertRemark"));
				}

			}
		}
	}

	@And("^store the reviewer ID in request and allocation excel database$")
	public void store_the_reviewer_id_in_request_and_allocation_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForBudgetRequestAndAllocation.updateTestData(budgetAllocationTestData.get("DataSet ID"), "Reviewer ID",
				reviewerID);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertClose(), 20, 1);
		kubsCommonObj.kubsAlertClose().click();
	}

}
