package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
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
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class Budgetandplanningsupplementary {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String user = "Maker";
	ConfigFileReader configFileReader = new ConfigFileReader();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	// JsonConfig jsonConfig = new JsonConfig();
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	// BUDGET_BudgetDefinitionUATTestDataType budgetDefinitionUATTestData =
	// jsonConfig.getUATBudgetDefinitionTestData(user);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
//	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	ClicksAndActionsHelper clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> testData;
	// Map<String, String> budgetConfigTestData = new HashMap<>();
	BUDGET_RequestAndAllocationObj requestAndAllocationObj = new BUDGET_RequestAndAllocationObj(driver);
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData Exceldata = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx",
			"BudgetReqAndAllocation", "DataSet ID");
	ExcelData Exceldata1 = new ExcelData("C:\\Users\\inindc00075\\Downloads\\KUBSTestData.xlsx",
			"BudgetSupplimentoryTestData", "DataSet ID");
	Map<String, String> supply;
	/*
	 * String path = System.getProperty("user.dir") +
	 * "\\Test-data\\KUBSTestData.xlsx"; ExcelData excelDataForBudgetConfig = new
	 * ExcelData(path, "BudgetConfiguration", "DataSet ID"); ExcelData
	 * excelDataForBudgetRequestAndAllocation = new ExcelData(path,
	 * "BudgetReqAndAllocation", "DataSet ID");
	 */
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);

	@Given("^navigate to given url and login with maker credentials$")
	public void navigate_to_given_url() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
		javascriptHelper.JavaScriptHelper(driver);

	}

	@And("^click on add button to create budget code$")
	public void click_on_add_button_to_create_budget_code() throws Throwable {
		/*
		 * In this below step is used to click on the action button , Javascript locator
		 * is used instead of xpath Javascript Locator :
		 * document.getElementById('addBtn')
		 */
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AddButton(), 60, 2);
		// budgetCreationObj.budgetCreation_AddButton().click();
		for (int i = 0; i <= 10; i++) {
			try {
				clickAndActionsHelper.moveToElement(budgetCreationObj.budgetCreation_AddButton());
				clickAndActionsHelper.doubleClick(budgetCreationObj.budgetCreation_AddButton());
				waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(),
						5, 2);
				Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^enter the budget code  to make current future financial budget$")
	public void enter_the_budget_code_to_make_current_financial_budget() throws Throwable {
		String budgetPrefix = "BUD";
		Random random = new Random();
		int randomNumber = random.nextInt(999999 - 100000) + 100000;
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60, 2);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(testData.get("BudgetCode") + randomNumber);

	}

	@Then("^click the Two Direction Icon$")
	public void click_the_two_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);

		waithelper = new WaitHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 60, 2);
		clickAndActionsHelper.moveToElement(kubsMakerObj.kubsToolIcon());
		clickAndActionsHelper.doubleClick(kubsMakerObj.kubsToolIcon());
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_DirctionIcon(), 60, 2);
		clickAndActionsHelper.moveToElement(requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		clickAndActionsHelper.doubleClick(requestAndAllocation.budget_requestAndAllocation_DirctionIcon());

	}

	@Then("^click on the search button$")
	public void click_on_the_search_button() throws Throwable {
		waithelper.waitForElementVisible(budgetCreationObj.notificationSearchIcon(), 3000, 300);
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

	@And("^choose yearly option in budget type$")
	public void choose_yearly_option_in_budget_type() throws Throwable {
		String xpath = "//ng-dropdown-panel//span[text()='" + testData.get("BudgetType") + "']";
		budgetCreationObj.budgetCreation_BudgetType().click();

		for (int i = 0; i <= 600; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^give warning percentage$")
	public void give_warning_percentage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_WarningPercentage(),
				60, 2);
		budgetCreationObj.budgetCreation_WarningPercentage().click();
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(testData.get("WarningPercentage"));
	}

	@And("^enter budget name for yearly budget$")
	public void enter_budget_name_for_yearly_budget() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetName(), 60, 2);
		budgetCreationObj.budgetCreation_BudgetName().click();
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(testData.get("BudgetYear"));
	}

	@Then("^enter remark$")
	public void enter_remark() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_Remarks(), 60, 2);
		budgetCreationObj.budgetCreation_Remarks().click();
		budgetCreationObj.budgetCreation_Remarks().sendKeys(testData.get("Remark"));

	}

	@Then("^click on Save button$")
	public void click_on_save_button() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_saveButton(), 60, 2);
		budgetCreationObj.budgetCreation_saveButton().click();

	}

	@And("^click notification buttons$")
	public void click_notification_buttons() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
				100);
		budgetCreationObj.budgetCreationNotificationIcon().click();
//		Thread.sleep(1000);

	}

	@And("^serach the budget defenition sub module name$")
	public void serach_the_budget_defenition_sub_module_name() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.eventCode(), 30, 2);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(testData.get("BudgetCode"));
	}

	@Then("^choose first record in the notification records1$")
	public void choose_first_record_in_the_notification_records1() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				2);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		// jsonReaderWriter.addReferanceData(referenceID);
		Exceldata.updateTestData("KUBS_BP_UAT_005_001_D1", "ReferenceID", referenceID);
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstRecord(), 60, 2);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	/*@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}*/

	@Then("^enter remark in confirmation alertss$")
	public void enter_remark_in_confirmation_alertss() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				2);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActionsHelper.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());

				clickAndActionsHelper.clickUsingActionClass(budgetCreationObj.budgetCreation_AlertRemarks(),
						budgetCreationObj.budgetCreation_AlertRemarks());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("MakerAlertRemark"));

	}

	/*@Then("^click on submit button in alert$")
	public void click_on_submit_button_in_alert() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActionsHelper.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActionsHelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("Remark"));
					budgetCreationObj.budgetCreation_AlertsubmitButton().click();
					break;
				} catch (Exception e) {
					if (i == 50) {
						Assert.fail(e.getMessage());
					}
				}
			}
		}
	}*/

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage1$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage1()
			throws Throwable {
		waithelper.waitForElement(driver, 6000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata.updateTestData("KUBS_BP_UAT_005_001_D1", "ReviewerID", revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	@And("^click on notification in reviewer stage$")
	public void click_on_notification_in_reviewer_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationIcon(), 60, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
				clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the record in notification$")
	public void select_the_record_in_notification() throws Throwable {

		String xpath = "//span[text()='" + testData.get("ReferenceID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 600; i++) {
			try {
				if (i > 100 && i < 600) {
					clickAndActionsHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
					clickAndActionsHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
					clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
					clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
					break;
				}
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;

			} catch (Exception e) {

				if (i == 600) {
					Assert.fail(e.getMessage());
				}

			}
		}
	}

	@And("^User should go to the kubs url and login as a reviewer users1$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_users1() throws IOException, ParseException {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}

	@And("^click on approve button in reviewer stage$")
	public void click_on_approve_button_in_reviewer_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 60, 1);
		kubsCommonObj.kubsApproveButton().click();
	}

	@And("^enter the alert remark in reviewer stage$")
	public void enter_the_alert_remark_in_reviewer_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 60, 1);
		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonObj.kubsAlertRemark().click();
				kubsCommonObj.kubsAlertRemark().sendKeys(testData.get("Remark"));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on submit in reviewer alert pop up$")
	public void click_on_submit_in_reviewer_alert_pop_up() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 60, 1);
		try {
			kubsCommonObj.kubsAlertSubmit().click();
		} catch (Exception e) {
			waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 60, 1);
			kubsCommonObj.kubsAlertRemark().click();
			kubsCommonObj.kubsAlertRemark().sendKeys(testData.get("ReviewerAlertRemark"));
			kubsCommonObj.kubsAlertSubmit().click();
		}
	}

	@Then("^verify record got approved in reviewer stage$")
	public void verify_record_got_approved_in_reviewer_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Record is available in CHECKER's Open Pool with status PENDING");
	}

	@Then("^log in to the Checker Account1$")
	public void log_in_to_the_checker_account1() throws InterruptedException {

		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");

	}

	@And("^click on security management tool$")
	public void click_on_security_management_tool() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerSecurityManagement(), 60, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.moveToElement(checkerObj.checkerSecurityManagement());
				clickAndActionsHelper.clickOnElement(checkerObj.checkerSecurityManagement());

				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on temp view near by open pool$")
	public void click_on_temp_view_near_by_open_pool() throws Throwable {
		// waitHelper.waitForElementToVisibleWithFluentWait(driver,
		// checkerObj.kubsCheckerOpenPoolTemp(), 30, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clickAndActionsHelper.moveToElement(checkerObj.kubsCheckerOpenPoolTemp());
				clickAndActionsHelper.clickOnElement(checkerObj.kubsCheckerOpenPoolTemp());
				break;
			} catch (Exception e) {
				if (i > 1 && i < 99) {
					clickAndActionsHelper.moveToElement(checkerObj.checkerSecurityManagement());
					clickAndActionsHelper.clickOnElement(checkerObj.checkerSecurityManagement());
				} else if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^clime the record by the help of Record reference ID$")
	public void clime_the_record_by_the_help_of_record_reference_id() throws Throwable {
		String xpath = "//span[text()='" + testData.get("ReferenceID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button";
		for (int i = 0; i <= 600; i++) {
			try {
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i > 145 && i < 150) {
					waithelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerNotificationIcon(), 60,
							1);
					clickAndActionsHelper.moveToElement(checkerObj.checkerNotificationIcon());
					clickAndActionsHelper.clickOnElement(checkerObj.checkerNotificationIcon());
					waithelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.kubsCheckerOpenPoolTemp(), 60,
							1);
					clickAndActionsHelper.moveToElement(checkerObj.kubsCheckerOpenPoolTemp());
					clickAndActionsHelper.clickOnElement(checkerObj.kubsCheckerOpenPoolTemp());
				}
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify record got climed in checker$")
	public void verify_record_got_climed_in_checker() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Claimed Successfully!!! Approve record from inbox");
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertClose(), 60, 1);
		kubsCommonObj.kubsAlertClose().click();
	}

	@And("^click on notification in checker stage$")
	public void click_on_notification_in_checker_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationIcon(), 60, 1);
		kubsCommonObj.kubsNotificationIcon().click();
	}

	@And("^select the record in notification in checker stage$")
	public void select_the_record_in_notification_in_checker_stage() throws Throwable {
		String xpath = "//span[text()='" + testData.get("ReferenceID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 2; i++) {
			try {
				if (i > 600 && i < 400) {
					kubsCommonObj.kubsNotificationIcon().click();
					clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
					clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
					break;
				}
				clickAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clickAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 2) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on approve button in checker$")
	public void click_on_approve_button_in_checker() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 60, 1);
		kubsCommonObj.kubsApproveButton().click();

	}

	@And("^give approve alert remark in checker stage$")
	public void give_approve_alert_remark_in_checker_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 60, 1);
		clickAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clickAndActionsHelper.clickUsingActionClass(kubsCommonObj.kubsAlertRemark(), kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(testData.get("CheckerAlertRemark"));
	}

	@And("^click on submit button in checker stage$")
	public void click_on_submit_button_in_checker_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 60, 1);
		kubsCommonObj.kubsAlertSubmit().click();
	}

	@Then("^verify record got approved in checker stage$")
	public void verify_record_got_approved_in_checker_stage() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(), "Record approved successfully");
	}

	@Then("^click on budget configuration menu$")
	public void click_on_budget_configuration_menu() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsBudgetConfiguration(), 60, 2);
		/*
		 * This step is to click the budget configuration main menu after login to the
		 * azentio application successfully
		 */
		kubsMakerObj.kubsBudgetConfiguration().click();

	}

	@Then("^click on eye icon which is near by budget definition submenu$")
	public void click_on_eye_icon_which_is_near_by_budget_definition_submenu() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_EyeIcon(), 60, 2);
		budgetCreationObj.budgetCreation_EyeIcon().click();

	}

	@And("^get the budget code for allocation$")
	public void get_the_budget_code_for_allocation() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationApprovedBudgetCode(),
				60, 2);
		// budgetCreationobj.budgetCreationApprovedBudgetCode().getText();
		// budgetAllocationTestData.put("budgetCode",
		// budgetCreationObj.budgetCreationApprovedBudgetCode().getText());
		// System.out.println("Budget code is : " +
		// budgetAllocationTestData.get("budgetCode"));
	}

	@And("^click to the Budget$")
	public void click_to_the_budget() throws Throwable {

		// -----------TO CLICK THE BUDGET MODULE--------------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_BudgetField(), 60, 2);
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();

	}

	@Then("^click on the Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void click_on_the_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {

		// ----------TO CLICK THE EYE ICON------------------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon(), 60, 2);
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@And("^click on the Add icon in Request and Allocation$")
	public void click_on_the_add_icon_in_request_and_allocation() throws Throwable {

		// ----------TO CREATE A NEW BUDGET AMOUNT------------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Addicon(), 60, 2);
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^select the Budget Code$")
	public void select_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		// requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(testData.get("BudgetCode"));
		Thread.sleep(2);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
		// requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage2$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage2()
			throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata.updateTestData("KUBS_BP_UAT_005_001_D1", "ReviewerID", revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage3$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage3()
			throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata.updateTestData("KUBS_BP_UAT_005_001_01_D1", "ReviewerID", revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	@And("^select the Budget Year$")
	public void select_the_budget_year() throws Throwable {

		// ----------TO SELECT THE BUDGET YEAR-------------//
		for (int i = 0; i <= 600; i++) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 5, 2);
				dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
						testData.get("BudgetType"));
				requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^click on the Branch$")
	public void click_on_the_branch() throws Throwable {

		// ----------TO SELECT THE BRANCH-----------------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Budgetbranch(), 60, 2);
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Select the Requested Branch$")
	public void select_the_requested_branch() throws Throwable {

		// ---------------ENTER REQUESTED BRANCH-----------------//
		waithelper.waitForElement(driver, 6000, requestAndAllocation.requestAndAllocation_branch_type4());
		requestAndAllocation.requestAndAllocation_branch_type4().click();
	}

	@Then("^click on the Branch ok button$")
	public void click_on_the_branch_ok_button() throws Throwable {

		// -----------TO CLICK BRANCH OK BUTTON------------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_branchOK(), 60, 2);
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();

	}

	@Then("^select one currency we need$")
	public void select_one_currency_we_need() throws Throwable {

		// -----------TO SELECT THE CURRENCY WE NEED-----------//
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_Amountcurruncy(), 60, 2);
		// waitHelper.waitForElement(driver, 3000,
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Give Branch requested to allocate the budget amount$")
	public void give_branch_requested_to_allocate_the_budget_amount() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		// requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		// requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javascriptHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY
			// BUDGET--------------------------//

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JavaScriptHelper(driver);
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetremark().sendKeys(testData.get("Remark"));
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY
			// BUDGET-------------------------//

			javascriptHelper.JavaScriptHelper(driver);
			javascriptHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1().sendKeys(testData.get("Remark"));

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

			// ----------------------------THIS CODE FOR QUARTERLY
			// BUDGET---------------------------//

			javascriptHelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0().sendKeys(testData.get("Remark"));

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

			// ---------------------------------THIS CODE FOR HALFYEARLY
			// BUDGET-------------------------//

			javascriptHelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1().sendKeys(testData.get("BudgetAmount"));
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1().sendKeys(testData.get("Remark"));

			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javascriptHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waithelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2().sendKeys(testData.get("BudgetAmount"));
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2().sendKeys(testData.get("Remark"));

		}
	}

	@And("^serach the budget request and allocation sub module name$")
	public void serach_the_budget_request_and_allocation_sub_module_name() throws Throwable {
		waithelper.waitForElementVisible(budgetCreationObj.eventCode(), 3000, 300);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(testData.get("budgetRequestAndAllocationEventCode"));
	}

	@Then("^choose first record in the notification record4$")
	public void choose_first_record_in_the_notification_record4() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				2);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		// jsonReaderWriter.addReferanceData(referenceID);
		Exceldata.updateTestData("KUBS_BP_UAT_005_004_D1", "ReferenceID", referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@And("^click on Submit buttons$")
	public void click_on_submit_buttons() throws Throwable {
		// After select the record we have to submit the record for approval
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_SubmitButton(), 60,2);
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@And("^click on the save button$")
	public void click_on_the_save_button() throws Throwable {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				requestAndAllocation.budget_requestAndAllocation_AllowSave(), 60, 1);
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

	@Then("^fill the input fields UAT$")
	public void fill_the_input_fields_UAT() {
		// budget code
		
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode()
				.sendKeys(testData.get("BudgetCode"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
		
		// budget year
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear()
				.sendKeys(testData.get("BudgetYear"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
		// budget branch
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch()
				.sendKeys(testData.get("Branch"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
		// currency
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency()
				.sendKeys(testData.get("Currency"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);
		
	}

	@Then("fill apportion amount and save the record UAT")
	public void fill_apportion_amount_and_save_the_record_uat() throws InterruptedException {
		// Supplementary apportion amount

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount()
				.sendKeys(testData.get("SupplymentaryApportionAmtA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);

		// New amount
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();

		// save button
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();

		for (int i = 0; i <= 30; i++) {
			javascriptHelper.JavaScriptHelper(driver);
			try {
				String str = javascriptHelper.executeScript(
						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
						.toString();
				System.out.println("Message:" + str);
				break;
			} catch (JavascriptException e) {
				if (i == 30) {
					e.printStackTrace();
				}
			}
		}

	for (int i = 0; i < 100; i++) {
		try {
			clickAndActionsHelper.moveToElement(kubsMakerObj.ARAP_Notification_Close());
			kubsMakerObj.ARAP_Notification_Close().click();
			break;
		} catch (Exception e) {
			if (i==100) {
				Assert.fail();
			}
		}
	}
	}
	@Then("^validate maker can submit the record UAT$")
	public void validate_maker_can_submit_the_record_UAT() throws InterruptedException, IOException, ParseException {

		// Notification
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();

		// Reference
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId(), 60, 500);
		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
		 Exceldata1.updateTestData("KUBS_BP_UAT_005_002_D1", "ReferenceID", id);
		//jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {

				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
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
     
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)), 60, 500);
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();

		// Remark
		// javascriptHelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField(), 60, 500);
		javascriptHelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		// bUDGET_SupplementaryBudgetTestDataType =
		// jsonReader.getSupplementaryBudgetByName("Maker");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys("OK");

		// Remark Submit

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();

		// REVIEWER
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus(), 60, 500);
		WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();

		clickAndActionsHelper.moveToElement(recordstatus);
		String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
		System.out.println(message);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
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
		Exceldata1.updateTestData("KUBS_BP_UAT_005_002_D1", "Reviewer ID",reviewerId);
	//	jsonWriter = new JsonDataReaderWriter();
	//	jsonWriter.addData(reviewerId);

	}

	@Then("^Select the Supplementary record from notification$")
	public void select_the_supplementary_record_from_notification()
			throws InterruptedException, IOException, ParseException {

		// Notification
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();

		// Reference
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId());
		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
		//jsonWriter.addReferanceData(id);
		Exceldata1.updateTestData("KUBS_BP_UAT_005_003_D1", "ReferenceID", id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
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
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

	}
	@And("^serach the budget supplimentory sub module name$")
	public void serach_the_budget_supplimentory_sub_module_name() throws Throwable {
		waithelper.waitForElementVisible(budgetCreationObj.eventCode(), 3000, 300);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(testData.get("budgetSupplimentoryEventCode"));
	}
	@When("^maker click on budget supplementary eye icon UAT$")
	public void maker_click_on_budget_supplymentary_eye_icon_UAT() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();

	}
	@Then("^choose first record in the notification records2$")
	public void choose_first_record_in_the_notification_records2() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		// jsonReaderWriter.addReferanceData(referenceID);
		Exceldata1.updateTestData("KUBS_BP_UAT_005_004_D1", "ReferenceID", referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stagesss$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stagesss()
			throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata1.updateTestData("KUBS_BP_UAT_005_004_D1", "ReviewerID", revID);
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationAlertClose(), 60, 2);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
	/*@Then("^choose first record in the notification recordss5$")
	public void choose_first_record_in_the_notification_recordss5() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		// jsonReaderWriter.addReferanceData(referenceID);
		Exceldata.updateTestData("KUBS_AR/AP_UAT_003_004_TC_04_D1", "ReferenceID", referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}*/

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage5$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage5()
			throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		// jsonReaderWriter.addData(revID);
		Exceldata1.updateTestData("KUBS_BP_UAT_005_005_D1", "ReviewerID", revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
	@And("^navigate to search icon and  fill the required field1$")
    public void navigate_to_search_icon_and_fill_the_required_field1() throws InterruptedException  {
	    //search icon
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();

		 //Budget code	
		 //bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(testData.get("BudgetCode"));
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
		 //budget name
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(testData.get("BudgetNameA"));
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(Keys.ENTER);
		 //budget budget year
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(testData.get("BudgetYear"));
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(Keys.ENTER);
		 //budget Type
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType());
	 	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(testData.get("BudgetTypeA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(Keys.ENTER);
		 //total amount
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(testData.get("TotalAmountA"));
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
}

	@And("^user update the Excel sheet testdata for Budget and planning Allocation$")
	public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_BP_UAT_005_001_D1");
	}

	@And("^user update the Excel sheet testdata for Budget and planning Allocation1$")
	public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation1() throws Throwable {
		testData = Exceldata.getTestdata("KUBS_BP_UAT_005_001_01_D1");
	}

	@And("^user update the Excel sheet testdata for Budget and planning Allocation2$")
	public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation2() throws Throwable {
		testData = Exceldata1.getTestdata("KUBS_BP_UAT_005_002_D1");
	}

	@And("^user update the Excel sheet testdata for Budget and planning Allocation3$")
	public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation3() throws Throwable {
		testData = Exceldata1.getTestdata("KUBS_BP_UAT_005_003_D1");
	}
	@And("^user update the Excel sheet testdata for Budget and planning Allocation4$")
    public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation4() throws Throwable {
		testData = Exceldata1.getTestdata("KUBS_BP_UAT_005_004_D1");
    }
	@And("^user update the Excel sheet testdata for Budget and planning Allocation5$")
    public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation5() throws Throwable {
		testData = Exceldata1.getTestdata("KUBS_BP_UAT_005_005_D1");
    }
    @And("^user update the Excel sheet testdata for Budget and planning Allocation6$")
    public void user_update_the_excel_sheet_testdata_for_budget_and_planning_allocation6() throws Throwable {
		testData = Exceldata1.getTestdata("KUBS_BP_UAT_005_006_D1");
    }

}