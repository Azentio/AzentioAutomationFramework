package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class BudgetAndPlanningExcel {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String user = "Maker";
	ConfigFileReader configFileReader = new ConfigFileReader();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	BUDGET_BudgetDefinitionUATTestDataType budgetDefinitionUATTestData = jsonConfig
			.getUATBudgetDefinitionTestData(user);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	ExcelData excelData = new ExcelData(System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx","BudgetRequestAndAllocation","DataSet ID");
	Map<String, String> testData = new HashMap<>();
	BUDGET_RequestAndAllocationObj requestAndAllocationObj = new BUDGET_RequestAndAllocationObj(driver);
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JavascriptHelper javaHelper = new JavascriptHelper();
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);


	@Then("^Get the data set id for wrongly created budget code$")
    public void get_the_data_set_id_for_wrongly_created_budget_code() throws Throwable {
    	testData = excelData.getTestdata("KUBS_BP_UAT_004_001_01_D1");
    }
	@Then("^fill the budget code fields$")
	public void fill_the_budget_code_fields() throws Throwable {
		Random random = new Random();
		int randomNumber = random.nextInt(999999 - 100000) + 100000;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode()
				.sendKeys(testData.get("BudgetCodePrefix") + randomNumber);
	}
	@And("^give warning percentages$")
	public void give_warning_percentages() throws Throwable {
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(testData.get("warningPecentage"));
	}
	@And("^enter budget name for Quarterly budgets$")
	public void enter_budget_name_for_quarterly_budgets() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(testData.get("uatQuarterlyBudgetType"));
	}
	@Then("^enter remarks$")
	public void enter_remarks() throws Throwable {
		budgetCreationObj.budgetCreation_Remarks().sendKeys(testData.get("remark"));

	}
	@And("^serach the budget defenition sub module names$")
	public void serach_the_budget_defenition_sub_module_names() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.eventCode(), 30, 500);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(testData.get("budgetDefenitionEventCode"));
	}

	@Then("^choose first record in the notification records$")
	public void choose_first_record_in_the_notification_records() throws Throwable {
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
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_BP_UAT_004_001_01_D1", "Reference ID", referenceID);

		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	 @Then("^choose first record in the notification record to allocate the budget$")
	    public void choose_first_record_in_the_notification_record_to_allocate_the_budget() throws Throwable {
		 waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
					1);
			String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
			/*
			 * addReferanceData(referenceID) This method is a predefined method to store the
			 * reference ID into the Json file
			 */
			//jsonReaderWriter.addReferanceData(referenceID);
			excelData.updateTestData("KUBS_UAT_KUBS_BP_UAT_005_001_D1", "Reference ID", referenceID);

			budgetCreationObj.budgetCreationFirstRecord().click();
	    }
	 
	@Then("^enter remark in confirmation alerts$")
	public void enter_remark_in_confirmation_alerts() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				500);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());

				clickAndActions.clickUsingActionClass(budgetCreationObj.budgetCreation_AlertRemarks(),
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
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("remark"));

	}
	@Then("^click on submit button in alerts$")
	public void click_on_submit_button_in_alerts() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActions.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("remark"));
					budgetCreationObj.budgetCreation_AlertsubmitButton().click();
					break;
				} catch (Exception e) {
					if (i == 50) {
						Assert.fail(e.getMessage());
					}
				}
			}
		}
	}

@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stages$")
public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stages()
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
	//jsonReaderWriter.addData(revID);
	excelData.updateTestData("KUBS_BP_UAT_004_001_01_D1", "Reviewer ID", revID);
	budgetCreationObj.budgetCreationAlertClose().click();

}
@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage to allocate the budget$")
public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_to_allocate_the_budget() throws Throwable {
	waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
	String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
	System.out.println(reviwerId);
	String trimmerReviewerID = reviwerId.substring(85);
	StringBuffer sb = new StringBuffer(trimmerReviewerID);
	StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
	String revID = finalReviewerID.toString();
	System.out.println("Reviewer ID is" + revID);
	//jsonReaderWriter.addData(revID);
	excelData.updateTestData("KUBS_UAT_KUBS_BP_UAT_005_001_D1", "Reviewer ID", revID);
	budgetCreationObj.budgetCreationAlertClose().click();}

@Then("^Choose the dataset id for wrongly created budget code reviewer$")
public void choose_the_dataset_id_for_wrongly_created_budget_code_reviewer() throws Throwable {
testData=excelData.getTestdata("KUBS_BP_UAT_004_001_01_D1");	
}
@Then("^Choose the data set id for branch request to allocate the budget reviewer$")
public void choose_the_data_set_id_for_branch_request_to_allocate_the_budget_reviewer() throws Throwable {
	testData=excelData.getTestdata("KUBS_UAT_KUBS_BP_UAT_005_001_D1");	
}
@And("^login with reviewers credentials$")
public void login_with_reviewers_credentials() throws Throwable {

	// ---------LOGIN THE REVIEWER USER--------------//
			kubsLogin = new KUBS_Login(driver);
		String UserID = "Reviewer";
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer(UserID, testData.get("Reviewer ID"));



}
@And("^select our record in notification records using references IDs$")
public void select_our_record_in_notification_records_using_references_ids() throws Throwable {
	/*
	 * After click on the notification icon lot of records will shown there, We have
	 * to select our record by the help of reference ID which is captured in maker
	 * stage
	 *
	 * before_xpath and after_xpath string variable are used to customize the xpath
	 * as per our reference ID
	 */
	// Thread.sleep(1000);
	javascriptHelper.JavaScriptHelper(driver);
	String before_xpath = "//span[contains(text(),'";
	String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	for (int i = 0; i <= 300; i++) {
		try {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerNotidicationIcon(), 60,
					500);
			kubsReviewerObj.reviewerNotidicationIcon().click();
			waitHelper.waitForElement(driver, 3000, driver
					.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			javascriptHelper.JSEClick(driver
					.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			// driver.findElement(By.xpath(before_xpath +
			// jsonReaderWriter.readReferancedata() + after_xpath)).click();
			break;
		} catch (Exception e) {
			if (i == 300) {
				Assert.fail(e.getMessage());
			}
		}
	}
}
@And("^enter the remark in alerts$")
public void enter_the_remark_in_alerts() throws Throwable {

	waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
	kubsReviewerObj.reviewerAlertRemarks().click();
	kubsReviewerObj.reviewerAlertRemarks().sendKeys(testData.get("approvalCommentsFromReviewer"));
}
@Then("^click on submit in alerts$")
public void click_on_submit_in_alerts() throws Throwable {
	while (true) {

		try {
			waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
			kubsReviewerObj.reviewerAlertSubmitButton().click();
			break;
		} catch (ElementClickInterceptedException e) {
			kubsReviewerObj.reviewerAlertRemarks().click();
			kubsReviewerObj.reviewerAlertRemarks()
					.sendKeys(testData.get("approvalCommentsFromReviewer"));
		}
	}
}
@Then("^login as a checkers$")
public void login_as_a_checker() throws Throwable {
	/*
	 * By the help of following step we can login as a checker
	 */
	kubsLogin = new KUBS_Login(driver);
	driver.get(configFileReader.getApplicationUrl());
	kubsLogin.loginToAzentioAppAsChecker("Checker");

}
@And("^select our record and clime using reference IDs$")
public void select_our_budget_record_and_clime_using_reference_ids() throws Throwable {
	/*
	 * after click on the action button we have to clime the particular our record
	 * by the help of reference ID
	 * 
	 * try catch block is used for avoid stalelementReference Exception
	 */
	String before_xpath = "//span[contains(text(),'";
	String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
	javascriptHelper.JavaScriptHelper(driver);
	javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
	for (int i = 0; i <= 200; i++) {
		try {
//		waitHelper.waitForElementToVisibleWithFluentWait(driver,
//			driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//			80, 500);
			WebElement climeButton = driver
					.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim));

			boolean bool = climeButton.isDisplayed();
			clickAndActions.clickOnElement(climeButton);

			// after clicking on the clime button , clime successful message will came we

			Assert.assertTrue(bool);
			break;
		} catch (Exception e) {
			if (i == 200) {
				Assert.fail(e.getMessage());
			}
		}
	}
}
@Then("^select our record in notification records by the help of reference IDs$")
public void select_our_record_in_notification_records_by_the_help_of_reference_ids() throws Throwable {
	/*
	 * After clime our record the record will go to notification we have to capture
	 * the our record by the help of reference ID
	 */

	String before_xpath = "//span[contains(text(),'";
	String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
	for (int i = 0; i <= 300; i++) {
		try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//					driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)),
//					100, 500);
			clickAndActions.moveToElement(driver
					.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			clickAndActions.clickOnElement(driver
					.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			break;
		} catch (Exception e) {
			if (i == 300) {
				Assert.fail(e.getMessage());
			}
		}
	}
}
@Then("^give alert remarks$")
public void give_alert_remarks() throws Throwable {
	javascriptHelper.JavaScriptHelper(driver);
	waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
	for (int i = 0; i <= 50; i++) {
		try {
			clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
			kubsCheckerObj.checkerRemarks().sendKeys(testData.get("approvalCommentsFromChecker"));
			break;
		} catch (Exception e) {
			if (i == 50) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
}
@Then("^click on submit button on alerts$")
public void click_on_submit_button_on_alerts() throws Throwable {

	try {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
		kubsCheckerObj.checkersubmitButton().click();
	} catch (Exception e) {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
		clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
		kubsCheckerObj.checkerRemarks().sendKeys(testData.get("approvalCommentsFromChecker"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
		kubsCheckerObj.checkersubmitButton().click();
	}
}
	@And("^get the budget code for allocations$")
	public void get_the_budget_code_for_allocations() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,kubsCheckerObj.budgetCreationApprovedBudgetCode(), 60, 500);
		// budgetCreationobj.budgetCreationApprovedBudgetCode().getText();
//.put("budgetCode", kubsCheckerObj.budgetCreationApprovedBudgetCode().getText());
		 kubsCheckerObj.budgetCreationApprovedBudgetCode().getText();
		excelData.updateTestData("KUBS_BP_UAT_004_001_01_D1", "BudgetCode", kubsCheckerObj.budgetCreationApprovedBudgetCode().getText());
//String budgetcode = kubsCheckerObj.budgetCreationApprovedBudgetCode().getText();
//excelData.updateTestData("KUBS_BP_UAT_004_001_01_D1", "BudgetCode", budgetcode);
		System.out.println("Budget code is : " + testData.get("BudgetCode"));
	}
	@And("^get the budget code for allocation to allocate the budget$")
    public void get_the_budget_code_for_allocation_to_allocate_the_budget() throws Throwable {
   
		waitHelper.waitForElementToVisibleWithFluentWait(driver,kubsCheckerObj.budgetCreationApprovedBudgetCode(), 60, 500);
		// budgetCreationobj.budgetCreationApprovedBudgetCode().getText();
//.put("budgetCode", kubsCheckerObj.budgetCreationApprovedBudgetCode().getText());
 kubsCheckerObj.budgetCreationApprovedBudgetCode().getText();
excelData.updateTestData("KUBS_UAT_KUBS_BP_UAT_005_001_D1", "BudgetCode", kubsCheckerObj.budgetCreationApprovedBudgetCode().getText());
		System.out.println("Budget code is : " + testData.get("BudgetCode"));
	}


@Then("^select the Budget Codes$")
public void select_the_budget_codes() throws Throwable {

	// ----------TO SELECT THE BUDGET CODE----------------//
	//requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
	waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
	requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
	requestAndAllocation.budget_requestAndAllocation_Budgetcode()
			.sendKeys(testData.get("BudgetCode"));
	Thread.sleep(500);
	requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
//	requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
	requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
}
@And("^select the past Budget Years$")
public void select_the_past_budget_years() throws Throwable {

	// ----------TO SELECT THE PAST BUDGET YEAR---------------//
	System.out.println(testData.get("BudgetYear1"));
	while (true) {
		try {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
			dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
					testData.get("BudgetYear1"));
			break;
		} catch (NoSuchElementException e) {

		}
	}
	// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
}
@And("^Enter the Amount for Required Budget types$")
public void enter_the_amount_for_required_budget_types() throws Throwable {

	// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
	// TYPE----------------------//
	//requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
	String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
	//requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
	
	javaHelper.JavaScriptHelper(driver);
	if (budgettype.equalsIgnoreCase("YEARLY")) {

		// ---------------------------THIS CODE FOR YEARLY
		// BUDGET--------------------------//

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
		requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetremark()
				.sendKeys(testData.get("remark"));
	} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

		// ----------------------------THIS CODE FOR MONTHLY
		// BUDGET-------------------------//

		javaHelper.JavaScriptHelper(driver);
		javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
				.sendKeys(testData.get("remark"));

	} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

		// ----------------------------THIS CODE FOR QUARTERLY
		// BUDGET---------------------------//

		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
				.sendKeys(testData.get("remark"));

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
				.sendKeys(testData.get("remark"));

	} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

		// ---------------------------------THIS CODE FOR HALFYEARLY
		// BUDGET-------------------------//

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
				.sendKeys(testData.get("BudgetAmount"));
		requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
				.sendKeys(testData.get("remark"));

	}
}
@Then("^click on the Maker icon buttons$")
public void click_on_the_maker_icon_buttons() throws Throwable {

	// -----------TO CLICK THE MAKER NOTIFICATION-------------//
	waitHelper.waitForElementToVisibleWithFluentWait(driver,requestAndAllocation.makerNotificationIcon(), 60, 500);
	//		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
	requestAndAllocation.makerNotificationIcon().click();
	waitHelper.waitForElementToVisibleWithFluentWait(driver,requestAndAllocation.maker_Referance_id(), 60, 500);
	String Referance_id = requestAndAllocation.maker_Referance_id().getText();
	excelData.updateTestData("KUBS_BP_UAT_004_001_01_D1", "Reference ID", Referance_id);
	//json.addReferanceData(Referance_id);
	waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
	requestAndAllocation.maker_Action_icon().click();
}
@Then("^Submit the Cancel Records$")
public void submit_the_cancel_records() throws Throwable {

	// -----------------------SUBMIT THE RECORD------------------------//
	waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
	requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(testData.get("remark"));
	waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertsubmit());
	requestAndAllocation.requestAndAllocation_Alertsubmit().click();
	waitHelper.waitForElement(driver, 2000, requestAndAllocation.Popup_status());
	String status = requestAndAllocation.Popup_status().getText();
	System.out.println(status);
}
@Then("^Choose the data set id for branch request to allocate the budget$")
public void choose_the_data_set_id_for_branch_request_to_allocate_the_budget() throws Throwable {
	testData=excelData.getTestdata("KUBS_UAT_KUBS_BP_UAT_005_001_D1");	

}

@Then("^enter the budget code  to make current/future financial budgets$")
public void enter_the_budget_code_to_make_current_financial_budget() throws Throwable {
	// String budgetPrefix="BUD";
	Random random = new Random();
	int randomNumber = random.nextInt(999999 - 100000) + 100000;
	waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
			500);
	budgetCreationObj.budgetCreation_BudgetCode()
			.sendKeys(testData.get("BudgetCodePrefix") + randomNumber);

}
@And("^enter budget name for yearly budgets$")
public void enter_budget_name_for_yearly_budgets() throws Throwable {
	budgetCreationObj.budgetCreation_BudgetName().sendKeys(testData.get("uatYearlyBudgetType"));
}
@And("^select the Budget Years$")
public void select_the_budget_years() throws Throwable {

	// ----------TO SELECT THE BUDGET YEAR-------------//
for(int i=0;i<=200;i++)
{
try
{
	waitHelper.waitForElementToVisibleWithFluentWait(driver,requestAndAllocation.budget_requestAndAllocation_Budgetyear(), 5, 500);
			dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
					testData.get("BudgetYear"));
				requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.ENTER);
break;
}
catch(Exception e)
{
if(i==200)
{
	Assert.fail(e.getMessage());
}
}
}
				// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
}
@And("^serach the budget request and allocation sub module names$")
public void serach_the_budget_request_and_allocation_sub_module_names() throws Throwable {
	waitHelper.waitForElementVisible(budgetCreationObj.eventCode(), 3000, 300);
	budgetCreationObj.eventCode().click();
	budgetCreationObj.eventCode().sendKeys(testData.get("budgetRequestAndAllocationEventCode"));
}
@Then("^Get the data set id for transfering the budget$")
public void get_the_data_set_id_for_transfering_the_budget() throws Throwable {
	testData=excelData.getTestdata("KUBS_BP_UAT_006_008_D1");	

}
@Then("^fill form and enter excessive budget amount to transfers$")
public void fill_form_and_enter_excessive_budget_amount_to_transfers() throws InterruptedException {
	//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
	// Budget code
	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
	budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
	budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown()
			.sendKeys(testData.get("BudgetCodeQuarter"));
	budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
	// budget Year
	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
	budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
	budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(testData.get("BudgetYear"));
	budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
	// budget Branch
	waitHelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
	budgetTransferObj.budget_BudgetTransfer_Branch().click();
	budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(testData.get("Branch"));
	budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

	// transfer to budget code
	waitHelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
	budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
	budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
			.sendKeys(testData.get("TransferToBudgetCodeQuarter"));
	budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
	Thread.sleep(2000);
	// currency
	waitHelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
	budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
	budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(testData.get("Currency"));
	budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

	// apportioned amount
	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter());
	budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter().click();
	budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter()
			.sendKeys(testData.get("ApportionedAmountAExcessive"));
	Thread.sleep(3000);

	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter());
	budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter().click();
	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter2());
	budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter2().click();
	budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter2()
			.sendKeys(testData.get("ApportionedAmountAExcessive"));
	Thread.sleep(3000);

	waitHelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter());
	budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter().click();

//		javahelper.JavaScriptHelper(driver);
	for (int i = 0; i <= 30; i++) {
		javaHelper.JavaScriptHelper(driver);
		try {
			WebElement successMsg1 = (WebElement) javaHelper.executeScript(
					"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");

			String successmsg1 = successMsg1.getText();
			System.out.println(successmsg1);
			break;
		} catch (JavascriptException e) {

		} catch (NullPointerException e2) {

		}
	}
}

}
