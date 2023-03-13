package stepdefinitions;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
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
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.MASTERREPORT_BudgetCodeReportObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;

public class BUDGET_UAT_BudgetDefinition extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String user = "Maker";
	ConfigFileReader configFileReader = new ConfigFileReader();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();

	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> testData = new HashMap<>();
	Map<String, String> budgetConfigTestData = new HashMap<>();
	BUDGET_RequestAndAllocationObj requestAndAllocationObj = new BUDGET_RequestAndAllocationObj(driver);
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBudgetConfig = new ExcelData(path, "BudgetConfiguration", "DataSet ID");
	ExcelData excelDataForBudgetRequestAndAllocation = new ExcelData(path, "BudgetReqAndAllocation", "DataSet ID");

	@Given("^navigate to given url and login with maker credentials$")
	public void navigate_to_given_url() throws Throwable {
		/*
		 * This function used to open the chrome browser and lauch the URL we want to
		 * test
		 */
		driver.get(configFileReader.getApplicationUrl());
		// loginToAzentioApp is already written function, Which is written inside the
		// same step definition package className: KUBS_Login
		kubsLogin.loginToAzentioAppByMaker();
		javascriptHelper.JavaScriptHelper(driver);

	}

	@Then("^click on budget configuration menu$")
	public void click_on_budget_configuration_menu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsBudgetConfiguration(), 60, 500);
		/*
		 * This step is to click the budget configuration main menu after login to the
		 * azentio application successfully
		 */
		kubsMakerObj.kubsBudgetConfiguration().click();

	}

	@Then("^click on eye icon which is near by budget definition submenu$")
	public void click_on_eye_icon_which_is_near_by_budget_definition_submenu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_EyeIcon(), 60, 500);
		budgetCreationObj.budgetCreation_EyeIcon().click();

	}

	@And("^get the test data from excel database for creating yearly budget code$")
	public void get_the_test_data_from_excel_database_for_creating_yearly_budget_code() throws Throwable {

		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D1");
	}

	@And("^get the test data from excel database for creating monthly budget code$")
	public void get_the_test_data_from_excel_database_for_creating_monthly_budget_code() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_002_D1");
	}
	@And("^get the test data from excel database for creating monthly budget code for validate the budget amount fields for current financial budget$")
    public void get_the_test_data_from_excel_database_for_creating_monthly_budget_code_for_validate_the_budget_amount_fields_for_current_financial_budget() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D4");
    }
	@And("^get the test data from excel database for creating quarterly budget code$")
	public void get_the_test_data_from_excel_database_for_creating_quarterly_budget_code() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_003_D1");
	}
	@And("^get the test data from excel database for creating quarterly budget code to validate the budget amount field$")
    public void get_the_test_data_from_excel_database_for_creating_quarterly_budget_code_to_validate_the_budget_amount_field() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D5");
    }
	@And("^get the test data from excel database for creating half yearly budget code$")
	public void get_the_test_data_from_excel_database_for_creating_half_yearly_budget_code() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_004_D1");
	}
	@And("^get the test data from excel database for creating half yearly budget code to validate the budget amount field$")
    public void get_the_test_data_from_excel_database_for_creating_half_yearly_budget_code_to_validate_the_budget_amount_field() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D6");
    }
	@And("^get the test data from excel database for creating the current financial budget$")
	public void get_the_test_data_from_excel_database_for_creating_the_current_financial_budget() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D2");
	}
	@And("^get the test data from excel database for creating the future financial budget$")
    public void get_the_test_data_from_excel_database_for_creating_the_future_financial_budget() throws Throwable {
		budgetConfigTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D3");
    }

	@And("^click on search button in budget config list view$")
	public void click_on_search_button_in_budget_config_list_view() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsListViewSearchButton(), 30, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsListViewSearchButton());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsListViewSearchButton());
	}

	@And("^search the approved budget code in budget config list view$")
	public void search_the_approved_budget_code_in_budget_config_list_view() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetConfigListViewSearchBudgetCode(), 20, 1);
		clickAndActionsHelper.moveToElement(budgetCreationObj.budgetConfigListViewSearchBudgetCode());
		clickAndActionsHelper.clickOnElement(budgetCreationObj.budgetConfigListViewSearchBudgetCode());
		budgetCreationObj.budgetConfigListViewSearchBudgetCode().sendKeys(budgetConfigTestData.get("BudgetCode"));
	}

	@Then("^verify approved budget code should reflect in budget config list view$")
	public void verify_approved_budget_code_should_reflect_in_budget_config_list_view() throws Throwable {
		String xpath="//span[text()=' "+budgetConfigTestData.get("BudgetCode")+" ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell[1]//span[text()=' "+budgetConfigTestData.get("BudgetName")+" ']";
		for(int i=0;i<=100;i++)
		{
			try
			{
				boolean budgetStatus = driver.findElement(By.xpath(xpath)).isDisplayed();
				Assert.assertTrue(budgetStatus);
				break;
			}
			catch(Exception e)
			{
				if(i==100)
				{
					Assert.fail(e.getMessage());
				}
			}
		}
		
	}

	@And("^store the budget code in budget request and allocation excel database for current financial year$")
	public void store_the_budget_code_in_budget_request_and_allocation_excel_database_for_current_financial_year()
			throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_001_005_D1", "BudgetCode",
				budgetConfigTestData.get("BudgetCode"));
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_001_005_D1", "BudgetType",
				budgetConfigTestData.get("BudgetType"));
	}
	@And("^store the quarterly budget code in budget request and allocation excel database for validate the budget amount field$")
    public void store_the_quarterly_budget_code_in_budget_request_and_allocation_excel_database_for_validate_the_budget_amount_field() throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_004_D1", "BudgetCode",
				budgetConfigTestData.get("BudgetCode"));
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_004_D1", "BudgetType",
				budgetConfigTestData.get("BudgetType"));
    }
	@And("^store the half yearly budget code in budget request and allocation excel database for validate the budget amount field$")
    public void store_the_half_yearly_budget_code_in_budget_request_and_allocation_excel_database_for_validate_the_budget_amount_field() throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_005_D1", "BudgetCode",
				budgetConfigTestData.get("BudgetCode"));
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_005_D1", "BudgetType",
				budgetConfigTestData.get("BudgetType"));
    }
	@And("^store the budget code in budget request and allocation excel database for future financial year$")
    public void store_the_budget_code_in_budget_request_and_allocation_excel_database_for_future_financial_year() throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_001_006_D1", "BudgetCode",
				budgetConfigTestData.get("BudgetCode"));
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_001_006_D1", "BudgetType",
				budgetConfigTestData.get("BudgetType"));
    }
	@And("^store the budget code and budget type in budget request and allocation excel database for monthly budget amount field validation$")
    public void store_the_budget_code_and_budget_type_in_budget_request_and_allocation_excel_database_for_monthly_budget_amount_field_validation() throws Throwable {
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_003_D1", "BudgetCode",
				budgetConfigTestData.get("BudgetCode"));
		excelDataForBudgetRequestAndAllocation.updateTestData("KUBS_B&P_UAT_003_003_D1", "BudgetType",
				budgetConfigTestData.get("BudgetType"));
    }

	@And("^click on add button to create budget code$")
	public void click_on_add_button_to_create_budget_code() throws Throwable {
		/*
		 * In this below step is used to click on the action button , Javascript locator
		 * is used instead of xpath Javascript Locator :
		 * document.getElementById('addBtn')
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AddButton(), 60, 500);
		// budgetCreationObj.budgetCreation_AddButton().click();
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionsHelper.moveToElement(budgetCreationObj.budgetCreation_AddButton());
				clickAndActionsHelper.doubleClick(budgetCreationObj.budgetCreation_AddButton());
				waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(),
						5, 500);
				Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	/*
	 * Coming below 14 steps helps us to enter our test data like budget code and
	 * budget name in to the appropriate fields we have separate budget name for
	 * every budget type
	 */
	@Then("^enter Budget Code for yearly budget$")
	public void enter_budget_code_for_yearly_budget() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		Random random = new Random();
		int randomNumber1 = random.nextInt(5000 - 500) + 5000;
		int randomNumber2 = random.nextInt(10000 - 5000) + 10000;
		String budgetCode = budgetConfigTestData.get("BudgetCodePrefix") + randomNumber1 + randomNumber2;
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetCode);

		excelDataForBudgetConfig.updateTestData(budgetConfigTestData.get("DataSet ID"), "BudgetCode", budgetCode);

	}

	@Then("^enter Budget Code in budget configuration screen$")
	public void enter_budget_code_in_budget_configuration_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		Random random = new Random();
		int randomNumber1 = random.nextInt(5000 - 500) + 5000;
		int randomNumber2 = random.nextInt(10000 - 5000) + 10000;
		String budgetCode = budgetConfigTestData.get("BudgetCodePrefix") + randomNumber1 + randomNumber2;
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetCode);

		excelDataForBudgetConfig.updateTestData(budgetConfigTestData.get("DataSet ID"), "BudgetCode", budgetCode);
	}

	@Then("^enter the budget code  to make current/future financial budget$")
	public void enter_the_budget_code_to_make_current_financial_budget() throws Throwable {
		// String budgetPrefix="BUD";
		Random random = new Random();
//		int randomNumber = random.nextInt(999999 - 100000) + 100000;
//		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
//				500);
//		budgetCreationObj.budgetCreation_BudgetCode()
//				.sendKeys(budgetDefinitionUATTestData.BudgetCodePrefix + randomNumber);
//		excelDataForBudgetConfig.updateTestData(path, user, path)

	}

	
	@And("^choose yearly option in budget type$")
	public void choose_yearly_option_in_budget_type() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetType(), 60, 1);
		String xpath = "//ng-dropdown-panel//span[text()='" + budgetConfigTestData.get("BudgetType") + "']";
		budgetCreationObj.budgetCreation_BudgetType().click();

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

	@And("^choose budget type in budget configuration screen$")
	public void choose_budget_type_in_budget_configuration_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetType(), 60, 1);		
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetConfigTestData.get("BudgetType"));
		String xpath = "//ng-dropdown-panel//span[text()='" + budgetConfigTestData.get("BudgetType") + "']";
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

	@And("^choose monthly option in budget type$")
	public void choose_monthly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);

	}

	@And("^choose Quarterly option in budget type$")
	public void choose_quarterly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
	}

	@And("^choose half yearly option in budget type$")
	public void choose_half_yearly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
	}

	@And("^give warning percentage$")
	public void give_warning_percentage() throws Throwable {
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetConfigTestData.get("WarningPercentage"));
	}
	@And("^enter the the budget name in budget configuration screen$")
    public void enter_the_the_budget_name_in_budget_configuration_screen() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetName(), 20, 1);
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetConfigTestData.get("BudgetName"));
    }
	

	@And("^enter the remark in budget config screen$")
	public void enter_the_remark_in_budget_config_screen() throws Throwable {
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetConfigTestData.get("Remark"));
	}

	/*
	 * After enter all the test data in appropriate text box the we have to click on
	 * the save button This below method help us to click on the save button
	 */
	@Then("^click on Save button$")
	public void click_on_save_button() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_saveButton(), 60,
				500);
		budgetCreationObj.budgetCreation_saveButton().click();

	}

	@And("^search for budget configuration record in notification$")
	public void search_for_budget_configuration_record_in_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(budgetConfigTestData.get("ModuleCode"));

	}

	@And("^store the reference number of budget config record in excel database$")
	public void store_the_reference_number_of_budget_config_record_in_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetConfigReferenceNumber(), 20,
				1);
		String referenceNumber = budgetCreationObj.budgetConfigReferenceNumber().getText();
		excelDataForBudgetConfig.updateTestData(budgetConfigTestData.get("DataSet ID"), "Reference ID",
				referenceNumber);

	}

	@And("^select the budget config record$")
	public void select_the_budget_config_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				budgetCreationObj.budgetConfigNotificationFirstRecord(), 20, 1);
		clickAndActionsHelper.moveToElement(budgetCreationObj.budgetConfigNotificationFirstRecord());
		clickAndActionsHelper.clickOnElement(budgetCreationObj.budgetConfigNotificationFirstRecord());
	}

	@And("^click on submit in budget configuration$")
	public void click_on_submit_in_budget_configuration() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@And("^enter the alert remark in budget configuration$")
	public void enter_the_alert_remark_in_budget_configuration() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(budgetConfigTestData.get("MakerAlerRemark"));
	}

	@And("^click on alert submit in budget configuration$")
	public void click_on_alert_submit_in_budget_configuration() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {

				clickAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
				clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
				break;
			} catch (Exception e) {
				clickAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
				kubsCommonObj.kubsAlertRemark().sendKeys(budgetConfigTestData.get("MakerAlerRemark"));
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the reviewer id of budget configuration in excel database$")
	public void store_the_reviewer_id_of_budget_configuration_in_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForBudgetConfig.updateTestData(budgetConfigTestData.get("DataSet ID"), "Reviewer ID", reviewerID);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertClose(), 20, 1);
		kubsCommonObj.kubsAlertClose().click();
	}

	
	@And("^choose the budget year as current financial year$")
	public void choose_the_budget_year_as_current_financial_year() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetyear().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.ENTER);
	}

	@And("^choose branch as azentio main$")
	public void choose_branch_as_azentio_main() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		requestAndAllocationObj.budget_requestAndAllocation_Budgetbranch().click();
		// javascriptHelper.scrollIntoViewAndClick(requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch());
		// requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch().click();
		requestAndAllocationObj.budget_requestAndAllocation_branchOK().click();
	}

	@And("^enter the budget amount in the appropriate text box along with remark$")
	public void enter_the_budget_amount_in_the_appropriate_text_box_along_with_remark() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetamount().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetamount().sendKeys("1000000");
	}

	@And("^click notification button$")
	public void click_notification_button() throws Throwable {
		// After save our budget record we have to click on notification to submit our
		// record for approvals
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
				100);
		for (int i = 0; i <= 50; i++) {
			try {
				budgetCreationObj.budgetCreationNotificationIcon().click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
//		Thread.sleep(1000);

	}

	@Then("^choose first record in the notification record$")
	public void choose_first_record_in_the_notification_record() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				1);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@Then("^click on the search button$")
	public void click_on_the_search_button() throws Throwable {
		waitHelper.waitForElementVisible(budgetCreationObj.notificationSearchIcon(), 3000, 300);
//		javascriptHelper.JavaScriptHelper(driver);
//		javascriptHelper.JSEClick( budgetCreationObj.notificationSearchIcon());
		for (int i = 0; i <= 15; i++) {
			try {
				budgetCreationObj.notificationSearchIcon().click();
				break;
			} catch (Exception e) {
				if (i == 15) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	

	@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	

	

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage()
			throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	@Then("^logout from maker$")
	public void logout_from_maker() throws Throwable {
		/*
		 * Then we have to logout from maker
		 */
		budgetCreationObj.budgetCreationUserName().click();
//		Thread.sleep(1000);		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationLogoutButton(), 90,
				500);
		clickAndActionsHelper.moveToElement(budgetCreationObj.budgetCreationLogoutButton());
		budgetCreationObj.budgetCreationLogoutButton().click();
	}

	/*
	 * ******************************** Reviewer steps
	 * ************************************
	 */
	@And("^login with reviewer credentials$")
	public void login_with_reviewer_credentials() throws Throwable {

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, jsonReaderWriter.readdata());

	}

	@Then("^login as a checker$")
	public void login_as_a_checker() throws Throwable {
		/*
		 * By the help of following step we can login as a checker
		 */
		Thread.sleep(3000);
		kubsLogin.loginToAzentioAppAsChecker("Checker");

	}

	

	@Then("^get the budget code budget type and transaction date$")
	public void get_the_budget_code_budget_type_and_transaction_date() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationApprovedBudgetCode(),
				60, 500);
		testData.put("budgetCode", budgetCreationObj.budgetCreationApprovedBudgetCode().getText());
		testData.put("budgetType", budgetCreationObj.approvedBudgetType().getText());
		testData.put("TransactionDate", budgetCreationObj.approvedBudgetDate().getText());
		System.out.println("Apprpved Budget code :" + testData.get("budgetCode"));
		System.out.println("Approved Budget Type :" + testData.get("budgetType"));
		System.out.println("Approved budget Transaction Date :" + testData.get("TransactionDate"));
	}

	MASTERREPORT_BudgetCodeReportObj budgetCodeReport = new MASTERREPORT_BudgetCodeReportObj(driver);
	@Then("^click on report segment button$")
    public void click_on_report_segment_button() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.reportSegmentButton(), 20, 1);
		clickAndActionsHelper.moveToElement(budgetCodeReport.reportSegmentButton());
		clickAndActionsHelper.clickOnElement(budgetCodeReport.reportSegmentButton());
    }
	@Then("^click on master report main module$")
	public void click_on_master_report_main_module() throws Throwable {

		budgetCodeReport.masterReportMainMenu().click();
	}

	@Then("^enter budget type in budget code report$")
	public void enter_budget_type_in_budget_code_report() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetBudgetType(), 60, 500);
		budgetCodeReport.masterBudgetBudgetType().click();
		budgetCodeReport.masterBudgetBudgetType().sendKeys(testData.get("budgetType"));
		budgetCodeReport.masterBudgetBudgetType().sendKeys(Keys.DOWN);
		budgetCodeReport.masterBudgetBudgetType().sendKeys(Keys.ENTER);
	}

	@And("^click on temp view near by budget code report sub module$")
	public void click_on_temp_view_near_by_budget_code_report_sub_module() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetReport(), 60, 500);
		budgetCodeReport.masterBudgetReport().click();
	}

	@And("^give transaction date$")
	public void give_transaction_date() throws Throwable {
		Month months = null;
		String[] splittedDate = testData.get("TransactionDate").split("-");
		String day = splittedDate[0];
		String month = splittedDate[1];
		String year = splittedDate[2];
		switch (month) {
		case "Jan":
			months = months.JANUARY;
			break;
		case "Feb":
			months = months.FEBRUARY;
			break;
		case "Mar":
			months = months.MARCH;
			break;
		case "Apr":
			months = months.APRIL;
			break;
		case "May":
			months = months.MAY;
			break;
		case "Jun":
			months = months.JUNE;
			break;
		case "Jul":
			months = months.JULY;
			break;
		case "Aug":
			months = months.AUGUST;
			break;
		case "Sep":
			months = months.SEPTEMBER;
			break;
		case "Oct":
			months = months.OCTOBER;
			break;
		case "Nov":
			months = months.NOVEMBER;
			break;
		case "Dec":
			months = months.DECEMBER;
			break;

		}
		String stringMonth = months.toString();
		String finalMonth = stringMonth.substring(1).toLowerCase();
		String trmDay = null;
		System.out.println("Final Month is : " + finalMonth);
		stringMonth.substring(0, 1);
		System.out.println("Final Full month:" + stringMonth.substring(0, 1) + finalMonth);
		Thread.sleep(1000);
		int dayNo = Integer.parseInt(day);
		if (dayNo < 10) {
			System.out.println("Inside day if statement");
			trmDay = day.substring(1);

		} else {
			trmDay = day.substring(0);
		}
		System.out.println("Trim Day is " + trmDay);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetInputCalendar(), 90, 500);
		budgetCodeReport.masterBudgetInputCalendar().click();
		System.out.println(month + " " + year);
		driver.findElement(By.xpath("//owl-date-time-calendar/div/div/button")).click();
		driver.findElement(By.xpath("//td//span[contains(text(),'" + year + "')]")).click();
		driver.findElement(By.xpath("//td//span[contains(text(),'" + month + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-label='" + stringMonth.substring(0, 1) + finalMonth + " " + trmDay
				+ ", " + year + "']/span")).click();

	}

	@Then("^click on view button in budget code report$")
	public void click_on_view_button_in_budget_code_report() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetBudgetCodeViewButton(),
				60, 500);
		budgetCodeReport.masterBudgetBudgetCodeViewButton().click();
	}

	@Then("^verify approved budget code is appeared under in master report$")
	public void verify_approved_budget_code_is_appeared_under_in_master_report() throws Throwable {

		browserHelper.SwitchToWindow(1);
		// waitHelper.setPageLoadTimeout(60, TimeUnit.SECONDS);
		boolean budgetCodeStatus = false;
		for (int i = 0; i <= 150; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//td/div[contains(text(),'" + testData.get("budgetCode") + "')]")),
						150, 500);
				budgetCodeStatus = driver
						.findElement(By.xpath("//td/div[contains(text(),'" + testData.get("budgetCode") + "')]"))
						.isDisplayed();
			} catch (Exception e) {
				if (i == 150) {

					Assert.fail(e.getMessage());
				}
			}
		}
		if (budgetCodeStatus == true) {
			System.out.println(testData.get("budgetCode") + " is visible in budget code report");

			browserHelper.switchToParentWithChildClose();
		} else {

			Assert.fail(testData.get("budgetCode") + "Budget Code not visisble in report");
			browserHelper.switchToParentWithChildClose();
		}

	}
}
