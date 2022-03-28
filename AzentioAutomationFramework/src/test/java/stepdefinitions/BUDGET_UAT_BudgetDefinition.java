package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
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
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
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
	BUDGET_BudgetDefinitionUATTestDataType budgetDefinitionUATTestData = jsonConfig.getUATBudgetDefinitionTestData(user);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
    BUDGET_RequestAndAllocationObj requestAndAllocationObj  = new BUDGET_RequestAndAllocationObj(driver);
    
	@Given("^navigate to given url and login with maker credentials$")
	public void navigate_to_given_url() throws Throwable {
		/*
		 * This function used to open the chrome browser and lauch the URL we want to
		 * test
		 */
		driver.get(configFileReader.getApplicationUrl());
		// loginToAzentioApp is already written function, Which is written inside the
		// same step definition package className: KUBS_Login
		kubsLogin.loginToAzentioApp(user);
		javascriptHelper.JavaScriptHelper(driver);

	}

	@Then("^click on budget configuration menu$")
	public void click_on_budget_configuration_menu() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubsMakerObj.kubsBudgetConfiguration());
		/*
		 * This step is to click the budget configuration main menu after login to the
		 * azentio application successfully
		 */
		kubsMakerObj.kubsBudgetConfiguration().click();

	}

	@Then("^click on eye icon which is near by budget definition submenu$")
	public void click_on_eye_icon_which_is_near_by_budget_definition_submenu() throws Throwable {

		budgetCreationObj.budgetCreation_EyeIcon().click();

	}

	@And("^click on add button to create budget code$")
	public void click_on_add_button_to_create_budget_code() throws Throwable {
		/*
		 * In this below step is used to click on the action button , Javascript locator
		 * is used instead of xpath Javascript Locator :
		 * document.getElementById('addBtn')
		 */

		WebElement addButton = (WebElement) javascriptHelper.executeScript("return document.getElementById('addBtn')");
		javascriptHelper.JSEClick(addButton);
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isDisplayed());

	}

	/*
	 * Coming below 14 steps helps us to enter our test data like budget code and
	 * budget name in to the appropriate fields we have separate budget name for
	 * every budget type
	 */
	@Then("^enter Budget Code for yearly budget$")
	public void enter_budget_code_for_yearly_budget() throws Throwable {

		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatYearlyBudgetCode);

	}
	@Then("^enter Budget Code for current financial yearly budget$")
    public void enter_budget_code_for_current_financial_yearly_budget() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatCurrentFinancialBudgetCode);     
    }

	@Then("^enter Budget Code for monthly budget$")
	public void enter_budget_code_for_monthly_budget() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatMonthlyBudgetCode);

	}

	@Then("^enter Budget Code for half yearly budget$")
	public void enter_budget_code_for_half_yearly_budget() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);

	}

	@Then("^enter Budget Code quarterly budget$")
	public void enter_budget_code_for_quarterly_budget() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatQuarterlyBudgetCode);

	}

	@And("^choose yearly option in budget type$")
	public void choose_yearly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);

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
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionUATTestData.warningPecentage);
	}

	@And("^enter budget name for yearly budget$")
	public void enter_budget_name_for_yearly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatYearlyBudgetType);
	}

	@And("^enter budget name for monthly Budget$")
	public void enter_budget_name_for_monthly_Budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatMonthlyBudgetType);
	}

	@And("^enter budget name for Quarterly budget$")
	public void enter_budget_name_for_quarterly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatQuarterlyBudgetType);
	}

	@And("^enter budget name for half yearly$")
	public void enter_budget_name_for_half_yearly() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
	}

	@Then("^enter remark$")
	public void enter_remark() throws Throwable {
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionUATTestData.remark);

	}

	/*
	 * After enter all the test data in appropriate text box the we have to click on
	 * the save button This below method help us to click on the save button
	 */
	@Then("^click on Save button$")
	public void click_on_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_saveButton());
		budgetCreationObj.budgetCreation_saveButton().click();
		/*
		 * This two while loops are helped us to capture the message pop up after click
		 * on the save button
		 */
		// while(true) --> is used for implement infinity loop
		while (true) {
			/*
			 * we have to wait for the first pop up that is available only one second if the
			 * pop up is not present the it throw the exception we have to locate until the
			 * alert is displayed so that infinity loop is used
			 */
			try {
				/*
				 * Query selector is used here to locate the element inside the shadow DOM
				 */
				WebElement successMsg1 = (WebElement) javascriptHelper.executeScript(
						"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");

				String successmsg1 = successMsg1.getText();

				Assert.assertEquals(successmsg1, "Budget Registration  created successfully.");
				break;
			}
			/*
			 * In this catch block just catch the exception and and it wont print any thing
			 * inside to console to make our console clear
			 */
			catch (Exception exception) {

			}
		}
		while (true) {
			try {
				WebElement successMsg2 = (WebElement) javascriptHelper.executeScript(
						"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
				String successmsg2 = successMsg2.getText();
				// System.out.println("The Message is " + successmsg2);
				Assert.assertEquals(successmsg2, "success");
				break;
			}
			/*
			 * In this catch blocks just catch the exception and and it wont print any thin
			 * inside to console to make our console clear
			 */

			catch (AssertionError exception) {
			} catch (StaleElementReferenceException staleElementException) {
			}
		}
	}
	
	@And("^enter the budget code for current financial year$")
    public void enter_the_budget_code_for_current_financial_year() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode().sendKeys(budgetDefinitionUATTestData.uatCurrentFinancialBudgetCode);
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
		
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
    	//javascriptHelper.scrollIntoViewAndClick(requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch());
    	//requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch().click();
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
		budgetCreationObj.budgetCreationNotificationIcon().click();
		Thread.sleep(1000);

	}

	@Then("^choose first record in the notification record$")
	public void choose_first_record_in_the_notification_record() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElement(driver, 5000, budgetCreationObj.budgetCreationFirstReferenceId());
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@Then("^enter remark in confirmation alert$")
	public void enter_remark_in_confirmation_alert() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_AlertRemarks());
		javascriptHelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionUATTestData.remark);

	}

	@Then("^click on submit button in alert$")
	public void click_on_submit_button_in_alert() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			Thread.sleep(1000);
			budgetCreationObj.budgetCreation_AlertRemarks().click();
			budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionUATTestData.remark);
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		}
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
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationLogoutButton());
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

		kubsLogin.logintoAzentioappReviewer(userType, jsonReaderWriter.readdata());

	}

	@Then("^click on notification button$")
	public void click_on_notification_button() throws Throwable {
		/*
		 * After successful login our first step is to click on the notification icon
		 */
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerNotidicationIcon());
		kubsReviewerObj.reviewerNotidicationIcon().click();

	}

	@And("^select our record in notification records using reference ID$")
	public void select_our_record_in_notification_records_using_reference_id() throws Throwable {
		/*
		 * After click on the notification icon lot of records will shown there, We have
		 * to select our record by the help of reference ID which is captured in maker
		 * stage
		 *
		 * before_xpath and after_xpath string variable are used to customize the xpath
		 * as per our reference ID
		 */
		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)).click();

	}

	@Then("^verify budget data are matched whic is submited by maker$")
	public void verify_budget_data_are_matched_whic_is_submited_by_maker() throws Throwable {

		/*
		 * After select the record we have to verify the details which is matched with
		 * maker submitted data we can use java script locator for locating the budget
		 * code and etc
		 */
		while (true) {
			try {
				waitHelper.setImplicitWait(5000);

				String budgetCode = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
				String budgetType = kubsReviewerObj.budgetType().getText();
				String warningPercentage = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
				String budgetname = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
				String budgetRemark = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");

				if (budgetType.equalsIgnoreCase("YEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("HALFYEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("MONTHLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatMonthlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatMonthlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("QUARTERLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatQuarterlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatQuarterlyBudgetCode);
				}

				Assert.assertEquals(warningPercentage, budgetDefinitionUATTestData.warningPecentage);
				Assert.assertEquals(budgetRemark, budgetDefinitionUATTestData.remark);
				break;
			} catch (StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			}
		}
	}

	@Then("^Approve the record from reviewer$")
	public void approve_the_budget_record_from_reviewer() throws Throwable {
		/*
		 * after verification we have to submit the record
		 * 
		 * approveButton() function contains the xpath for the approve button
		 */
		while(true)
		{
		try
		{
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApproveButton());
		kubsReviewerObj.reviewerApproveButton().click();
		break;
		}
	    catch(Exception e)
		{
	    	
		}
		}
	}

	@And("^enter the remark in alert$")
	public void enter_the_remark_in_alert() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromReviewer);
	}

	@Then("^click on submit in alert$")
	public void click_on_submit_in_alert() throws Throwable {
		while(true)
		{
			
		try
		{
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
		kubsReviewerObj.reviewerAlertSubmitButton().click();
		break;
		}
		catch(ElementClickInterceptedException e)
		{
			kubsReviewerObj.reviewerAlertRemarks().click();
			kubsReviewerObj.reviewerAlertRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromReviewer);
		}
		}
	}

	@Then("^verify the approval status of the record$")
	public void verify_the_approval_status_of_the_record() throws Throwable {
		/*
		 * After clicked on the approve button we have to verify the record is approved
		 * or not By the help of toast alert.
		 * 
		 * reviewerApprovalStatus() this function have the xpath for that particular
		 * alert (That alert is present only 3 mins so we have to locate that and get
		 * the text for that alert)
		 * 
		 * We can use assert function for verification
		 */
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApprovalStatus());
		String approval_status = kubsReviewerObj.reviewerApprovalStatus().getText();
		Assert.assertEquals(approval_status, "Record is available in CHECKER's Open Pool with status PENDING");

	}

	@And("^logout from reviewer$")
	public void logout_from_reviewer() throws Throwable {
		/*
		 * Then we have to logout from reviewer and start with checker approval
		 */
		while(true)
		{
		try
		{
		javascriptHelper.JavaScriptHelper(driver);
		kubsReviewerObj.reviewerAlertClose().click();
		kubsReviewerObj.reviewerUserName().click();
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerLogoutButton());
		javascriptHelper.JSEClick(kubsReviewerObj.reviewerLogoutButton());
		break;
		}
		catch(StaleElementReferenceException e)
		{
			
		}
		}
		}

	/* *** checker steps ***** */

	@Then("^login as a checker$")
	public void login_as_a_checker() throws Throwable {
		/*
		 * By the help of following step we can login as a checker
		 */
		Thread.sleep(2000);
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		
	}

	@And("^click on security management menu in checker$")
	public void click_on_security_management_menu_in_checker() throws Throwable {
		while (true) {

			try {
				waitHelper.waitForElementVisible(kubsCheckerObj.checkerSecurityManagement(), 1000, 100);
				kubsCheckerObj.checkerSecurityManagement().click();
				break;
			} catch (StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			}
		}
	}

	@Then("^click on action button under security management menu$")
	public void click_on_action_button_under_security_management_menu() throws Throwable {

		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());

	}

	@And("^select our record and clime using reference ID$")
	public void select_our_budget_record_and_clime_using_reference_id() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 1; i <= 3; i++) {
			try {

				WebElement climeButton = driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim));
				boolean bool = climeButton.isDisplayed();
				clickAndActions.clickOnElement(climeButton);
				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);

				break;
			} catch (StaleElementReferenceException staleElementException) {
				System.out.println(staleElementException.getMessage());
			}
		}
		
	}

	@Then("^click on Notification button$")
	public void cliick_on_notification_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerAlertClose());
		kubsCheckerObj.checkerAlertClose().click();
		Thread.sleep(1000);
		clickAndActions.clickOnElement(kubsCheckerObj.checkerNotificationIcon());

	}

	@Then("^select our record in notification records by the help of reference ID$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */
		while (true) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
				//waitHelper.waitForElement(driver, 1000, driver
					//	.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
			//	driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)).click();
				javascriptHelper.JSEClick(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				
				
			}
		}
	}
		

	@And("^validate the record which is submited by maker$")
	public void validate_the_budget_record_which_is_submited_by_maker() throws Throwable {
		/*
		 * After select our record we have to verify the budget data by the help of
		 * assert statement
		 */
		while (true) {
			try {
				waitHelper.waitForElement(driver, 3000, kubsCheckerObj.budgetType());
				String budgetType = kubsCheckerObj.budgetType().getText();
				String budgetCode = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
				String warningPercentage = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
				String budgetname = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
				String budgetRemark = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");

				if (budgetType.equalsIgnoreCase("YEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("HALFYEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("MONTHLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatMonthlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatMonthlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("QUARTERLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatQuarterlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatQuarterlyBudgetCode);
				}

				Assert.assertEquals(warningPercentage, budgetDefinitionUATTestData.warningPecentage);

				Assert.assertEquals(budgetRemark, budgetDefinitionUATTestData.remark);
				break;
			} catch (StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			}
		}
	}

	@And("^click on approve button in checker stage$")
	public void click_on_approve_button_in_checker_stage() throws Throwable {
		while(true)
		{
		try
		{
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerApproveButton());
		kubsCheckerObj.checkerApproveButton().click();
		break;
		}
		catch(ElementClickInterceptedException e)
		{
			
		}
		}
	}
	

	@Then("^give alert remark$")
	public void give_alert_remark() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerRemarks());
		kubsCheckerObj.checkerRemarks().click();
		kubsCheckerObj.checkerRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromChecker);
	}

	@Then("^click on submit button on alert$")
	public void click_on_submit_button_on_alert() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkersubmitButton());
		kubsCheckerObj.checkersubmitButton().click();
	}

	@And("^verify the record got approved from checker$")
	public void verify_the_record_got_approved_from_checker() throws Throwable {
		/*
		 * After clicked on the approve button we have to verify the record is approved
		 * or not By the help of toast alert.
		 * 
		 * checkerApprovalStatus() this function have the xpath for that particular
		 * alert (That alert is present only 3 mins so we have to locate that and get
		 * the text for that alert)
		 * 
		 * We can use assert function for verification
		 * 
		 */
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerApprovalStatus());
		String approvalStatusForChecker = kubsCheckerObj.checkerApprovalStatus().getText();
		Assert.assertEquals(approvalStatusForChecker, "Record APPROVED Successfully");
	}

	@Then("^logout from checker$")
	public void logout_from_checker() throws Throwable {
		waitHelper.waitForElementVisible(kubsCheckerObj.checkerAlertClose(), 1000, 100);
		kubsCheckerObj.checkerAlertClose().click();
		waitHelper.waitForElementVisible(kubsCheckerObj.checkerUserName(), 1000, 100);
		kubsCheckerObj.checkerUserName().click();
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			try {
				waitHelper.waitForElementVisible(kubsCheckerObj.checkerLogoutButton(), 1000, 100);
				kubsCheckerObj.checkerLogoutButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
