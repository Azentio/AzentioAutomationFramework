package stepdefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.Azentio_MakerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionTestDataType;

public class BUDGET_BudgetDefinition extends BaseClass {
	WebDriver driver = BaseClass.driver;
	AzentioLogin kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	JsonConfig jsonConfig = new JsonConfig();
	Azentio_MakerObj kubsMakerObj = new Azentio_MakerObj(driver);
	String user = "Maker";
	WaitHelper waitHelper = new WaitHelper(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	BUDGET_BudgetDefinitionTestDataType budgetDefinitionTestData=jsonConfig.getBudgetdataByName(user);

	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();

	@Given("^navigate to URL and login as a maker and choose finance option$")
	public void navigate_to_url_and_login_as_a_and_choose_finance_option() throws InterruptedException {
        // to get a URL from property file(data.properties)
		driver.get(configFileReader.getApplicationUrl());

		// function from AzentioLogin class and user should login as a maker
		kubsLogin = new AzentioLogin(driver);
       // function from AzentioLogin this user argument denote the which type of user we have to login
		kubsLogin.loginToAzentioApp(user);
		javascripthelper.JavaScriptHelper(driver);

	}

	@Then("^click on budget configuration Menu$")
	public void click_on_budget_configuration_menu() {
		// waiting 2 seconds for budget configuration menu
		waitHelper.waitForElement(driver, 2000, kubsMakerObj.kubsBudgetConfiguration());
		kubsMakerObj.kubsBudgetConfiguration().click();

	}

	@And("^click on budget definition sub menu and click on eye icon$")
	public void click_on_budget_definition_sub_menu_and_click_on_eye_icon() {
       //to click the eye icon inside in the budget configuration menu
		budgetCreationObj.budgetCreation_EyeIcon().click();

	}

	@And("^click on add icon$")
	public void click_on_add_icon() {
		// To click the add icon which means the plus icon to create our budget code
		budgetCreationObj.budgetCreation_AddButton().click();

	}

	@Then("^enter budget code$")
	public void enter_budget_code() {
		// after open the budget definition window we have to enter budget code first
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.budgetCode);

	}

	@And("^enter budget type$")
	public void enter_budget_type() {
		/*
		 * This step we can choose our budget type. We have four type of budget code. As per our test data we can match with our condition and coose it accordingly
		 */
		if (budgetDefinitionTestData.budgetType.equalsIgnoreCase("YEARLY")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.budgetType.equalsIgnoreCase("HalfYearly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.budgetType.equalsIgnoreCase("Monthly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.budgetType.equalsIgnoreCase("Quarterly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		}
	}
	@And("^enter warning percentage$")
	public void enter_warning_percentage() {
		// This step we can enter our warning percentage warning percentage must be with in  0 to 100 only
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.warningPecentage);

	}

	@And("^enter budget name$")
	public void enter_budget_name() {
		//this we can enter our budget name
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.budgetName);

	}
	@Then("^give remark$")
	public void give_remark() {
		//this step we can enter the remark in remark field which is appear in the budget definition form
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionTestData.remark);

	}


	@Then("^click on save button$")
	public void click_on_save_button() throws InterruptedException {
		// this step we can save the record
		/*
		 * String variable successmsg1 ,successmsg2 are store the alert message's text which is appearing after we save our budget record 
		 * We have to locate that and ensure our record got save or not
		 */
		budgetCreationObj.budgetCreation_saveButton().click();
		Thread.sleep(1000);
		WebElement successMsg1 = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg1 = successMsg1.getText();
		System.out.println("The Message is " + successmsg1);
		Assert.assertEquals(successmsg1, "Budget Registration  created successfully.");
		Thread.sleep(2000);
		WebElement successMsg2 = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg2 = successMsg2.getText();
		System.out.println("The Message is " + successmsg2);
		Assert.assertEquals(successmsg2, "success");

	}
	@Then("^Click on notification icon$")
	public void click_on_notification_icon() throws Throwable {
		//after verifying that we can click the notification to approve our record
		budgetCreationObj.budgetCreationNotificationIcon().click();
	}

	@And("^select the first record$")
	public void select_the_first_record() throws IOException {
		// budgetCreationObj.budgetCreationNotificationIcon().click();
		
		/*
		 * This step we have to select the first record
		 *Before selecting the first record we have to store the reference ID into one file because we can access this reference ID in
		 *Reviewer stage and checker stage 
		 *addReferenceData(String) --> This function is used to store the reference Data into one Json File
		 */
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstReferenceId());
		String firtsReferenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		//Geting reference ID 
		jsonWriter.addReferanceData(firtsReferenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	@Then("^click on submit button$")
	public void click_on_submit_button() {
		// after select the record in notification we have to submit the record in maker stage
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@And("^enter remark in alert tab$")
	public void enter_remark_in_alert_tab() {
		javascripthelper.JavaScriptHelper(driver);
      //While we submit our record one alert will open we have to give the remark in alert 
		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_AlertRemarks());
		// budgetCreationObj.budgetCreation_AlertRemarks().click();
		javascripthelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionTestData.remark);
	}

	@And("^click on submit$")
	public void click_on_submit() {
		// we have to submit the alert
		budgetCreationObj.budgetCreation_AlertsubmitButton().click();

	}

	@When("^click on submit button save the reviewer id$")
	public void click_on_submit_button_save_the_reviewer_id() throws IOException {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast alert and we have to locate that  alert and 
		 * extract the ID from the alert(That reviewer ID is extracted with one dot)
		 * By the help of that string buffer class we can remove that dot
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		// System.out.println("String buffer reviewer ID is"+finalReviewerID);
		// System.out.println("Reviewer ID is"+revID);
		jsonWriter.addData(revID);

	}
	// this step we can search the budget code we want to update
	@Then("^search the budget code want to update$")
	public void click_on_pencil_icon_near_by_budget_code() throws Throwable {

		budgetCreationObj.budgetCreationSearchIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationSearchBudgetCode());
		budgetCreationObj.budgetCreationSearchBudgetCode().sendKeys(budgetDefinitionTestData.budgetCodeToBeSearch);
	}

	@And("^select the budget code$")
	public void select_the_budget_code() throws Throwable {
		// this step we can select the budget code in appearing budget code
		// span[contains(text(),'BGD9528001')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button[2]
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button[2]";
		WebElement pencilIcon = driver
				.findElement(By.xpath(before_xpath + budgetDefinitionTestData.budgetCodeToBeSearch + after_xpath));
		waitHelper.waitForElement(driver, 3000, pencilIcon);
		pencilIcon.click();
	}

	@And("^update the budget code$")
	public void update_the_budget_code() throws InterruptedException {
		//after select that budget code we can update the budget code
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_BudgetCode());
		budgetCreationObj.budgetCreation_BudgetCode().clear();
		Thread.sleep(3000);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.updatedBudgetCode);
	}

	@Then("^update the budget type$")
	public void update_the_budget_budget_type() {
		// The update the budget type
		/*
		 * In This step we can choose the budget type which is matching with the test data budget type 
		 */
		if (budgetDefinitionTestData.updatedBudgetType.equalsIgnoreCase("YEARLY")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.updatedBudgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.updatedBudgetType.equalsIgnoreCase("HalfYearly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.updatedBudgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.updatedBudgetType.equalsIgnoreCase("Monthly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.updatedBudgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		} else if (budgetDefinitionTestData.updatedBudgetType.equalsIgnoreCase("Quarterly")) {
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.updatedBudgetType);
			budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		}
	}

	@Then("^update warning percentage$")
	public void update_warning_percentage() {
		//update the warning percentage 
		budgetCreationObj.budgetCreation_WarningPercentage().clear();
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.updatedWarningPecentage);
	}

	@Then("^update budget name$")
	public void update_budget_name() {
		//update budget name, before updating we have to clear the old record
		budgetCreationObj.budgetCreation_BudgetName().clear();
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.updatedBudgetName);

	}

	@Then("^update remark$")
	public void update_remark() {
		//update budget remark
		budgetCreationObj.budgetCreation_Remarks().clear();
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionTestData.updatedRemark);
	}

	@And("^click on save after update all the details$")
	public void click_on_save_after_update_all_the_details() throws InterruptedException {
		//after all the data are updated we have to save the record
		/*
		 * Here we use that sucessmsg 1 and 2 are the alert messages which is appearing after saving our record
		 */
		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_saveButton());
		budgetCreationObj.budgetCreation_saveButton().click();
		Thread.sleep(1000);
		WebElement successMsg1 = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg1 = successMsg1.getText();
		System.out.println("The Message is " + successmsg1);
		Assert.assertEquals(successmsg1, "Budget Registration  updated successfully.");
		Thread.sleep(2000);
		WebElement successMsg2 = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg2 = successMsg2.getText();
		System.out.println("The Message is " + successmsg2);
		Assert.assertEquals(successmsg2, "success");

	}


	
	@When("^user enter budget name which is already exeist system should through validatiom message$")
	public void user_enter_budget_name_which_is_already_exeist_system_should_through_validatiom_message()
			throws Throwable {
		//This 
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.budgetName);
	}

	
		/*
	 *
	 * here the below budget name entered fields are depending on UAT cases
	 * 
	 * 
	 * 
	 */
	@And("^enter budget name for yearly budget type$")
	public void enter_budget_name_for_yearly_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.uatYearlyBudgetType);
	}

	@And("^enter budget name for monthly budget$")
	public void enter_budget_name_for_monthly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.uatMonthlyBudgetType);
	}

	@And("^enter budget name for half yearly budget$")
	public void enter_budget_name_for_half_yearly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.uatHalfYearlyBudgetType);
	}

	@And("^enter budget name for quarterly budget$")
	public void enter_budget_name_for_quarterly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.uatQuarterlyBudgetType);
	}

	/*
	 * 
	 * Here after all the steps are applicable for auto auth steps except modification history because sape steps were followed in auto auth and multi auth to see the modification history
	 * 
	 * 
	 */
	@Then("^verify budget code field is enable$")
	public void verify_budget_code_field_is_enable() throws Throwable {
		//This step to validate the budget code is enable or not
		Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isEnabled());
		Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isDisplayed());
	}

	@Then("^verify budget type field is enable$")
	public void verify_budget_type_field_is_enable() throws Throwable {
		//This step to validate budget type is enable or not
		Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetType().isEnabled());
		Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetType().isDisplayed());
	}

	@Then("^verify warning percentage fiedls is enable$")
	public void verify_warning_percentage_fiedls_is_enable() throws Throwable {
		// this step to validate warning percentage is enable or not
		Assert.assertTrue(budgetCreationObj.budgetCreation_WarningPercentage().isDisplayed());
		Assert.assertTrue(budgetCreationObj.budgetCreation_WarningPercentage().isEnabled());
	}

	@Then("^verify remark field is enable$")
	public void verify_remark_field_is_enable() throws Throwable {
		// this step is to validate remark field is enable or not
		Assert.assertTrue(budgetCreationObj.budgetCreation_Remarks().isDisplayed());
		Assert.assertTrue(budgetCreationObj.budgetCreation_Remarks().isEnabled());

	}

	//This steps are to see the modification history Both the two authentication status  
	/*
	 * 
	 * Line numbers are 391 to 482
	 * This steps are used to system should show the autorized details in not editable mode(Which the list is inside in the eye icon of budget definition module)
	 */

	@And("^Find the budet code in the list$")
	public void find_the_budet_code_in_the_list() throws Throwable {

		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch + "')]")));
				WebElement budgetCode = driver
						.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch + "')]"));

				Assert.assertTrue(budgetCode.isDisplayed());
				break;
			} catch (NoSuchElementException e) {

				budgetCreationObj.budgetCreationNextButton().click();
			}
		}
	}

	@Then("^verify system should display the status of the record$")
	public void verify_system_should_display_the_status_of_the_record() throws Throwable {
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
						+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[3]//span")));
		WebElement statusOfBudget = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[3]//span"));
		waitHelper.waitForElement(driver, 3000, statusOfBudget);
		//here we check the data is displayed or not
		Assert.assertTrue(statusOfBudget.isDisplayed());
		// here the condition is the displayed string is not null
		Assert.assertNotNull(statusOfBudget);
	}

	@And("^verify system should display the name or id who created the record$")
	public void verify_system_should_display_the_name_or_id_who_created_the_record() throws Throwable {
		WebElement budgetCreatorID = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[4]//span"));
		//here we check the data is displayed or not
		Assert.assertTrue(budgetCreatorID.isDisplayed());
		// here the condition is the displayed string is not null
		Assert.assertNotNull(budgetCreatorID);
	}

	@And("^verify system should display record created date$")
	public void verify_system_should_display_record_created_date() throws Throwable {
		WebElement budgetCreatedDate = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[5]//span"));
		//here we check the data is displayed or not
		Assert.assertTrue(budgetCreatedDate.isDisplayed());
		// here the condition is the displayed string is not null
		Assert.assertNotNull(budgetCreatedDate);

	}

	@And("^verify system should display the name or id who made changes the record at last$")
	public void verify_system_should_display_the_name_or_id_who_made_changes_the_record_at_last() throws Throwable {
		WebElement modifierName = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[6]//span"));
		//here we check the data is displayed or not
		Assert.assertTrue(modifierName.isDisplayed());
		// here the condition is the displayed string is not null
		Assert.assertNotNull(modifierName);
	}

	@And("^verify system should display record modified date$")
	public void verify_system_should_display_record_modified_date() throws Throwable {
		WebElement modifiedDate = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[7]//span"));
		Assert.assertTrue(modifiedDate.isDisplayed());
		Assert.assertNotNull(modifiedDate);
	}

	@Then("^verify system should display name or id of the authorized person of that record$")
	public void verify_system_should_display_name_or_id_of_the_authorized_person_of_that_record() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		WebElement authorizedBy = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[8]//span"));
		Assert.assertTrue(authorizedBy.isDisplayed());
		String approvedBy = authorizedBy.getAttribute("innerHTML");
		javascripthelper.scrollIntoView(authorizedBy);

		if (approvedBy.isBlank()) {
			Assert.fail("Authorizer id is blank");
		}

	}

	@And("^verify system should diplay the authorized date$")
	public void verify_system_should_diplay_the_authorized_date() throws Throwable {
		WebElement authorizedDate = driver.findElement(By.xpath("//span[contains(text(),'" + budgetDefinitionTestData.budgetCodeToBeSearch
				+ "')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]//span"));
		Assert.assertTrue(authorizedDate.isDisplayed());
		javascripthelper.scrollIntoView(authorizedDate);
		String approvedDate = authorizedDate.getText();
		if (approvedDate.isBlank()) {
			Assert.fail("Authirized date is  blank");
		}
	}


	/*In auto auth verify maker can able to create multiple budget code 
	 * Starting line:497-Ending line:547--> Inside this line codings are used to create the multiple budget code in auto auth 
	 */
	 

	@Then("^create first budget code$")
	public void create_first_budget_code() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.budgetCode1);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType1);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.warningPecentage1);
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.budgetName1);
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionTestData.remark);
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_saveButton());

	}

	@Then("^select the record from notification$")
	public void select_the_record_from_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationNotificationIcon());
		budgetCreationObj.budgetCreationNotificationIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstRecord());
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@And("^approve approve the record$")
	public void approve_approve_the_record() throws Throwable {
		// budgetCreationObj.budgetCreationApproveButton().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_AlertRemarks());
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionTestData.remark);
		budgetCreationObj.budgetCreation_AlertsubmitButton().click();
	}

	@Then("^create second budget code$")
	public void create_second_budget_code() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.budgetCode2);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType2);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.warningPecentage2);
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.budgetName2);
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionTestData.remark);

	}

	@Then("^create Third budget code$")
	public void create_third_budget_code() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.budgetCode3);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(budgetDefinitionTestData.budgetType3);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.warningPecentage3);
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionTestData.budgetName3);
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionTestData.remark);

	}
//BudgetCodeUpdation

	
	// Search criteria
	@And("^click on action button in budget configuration$")
	public void click_on_action_button_in_budget_configuration() throws Throwable {
		budgetCreationObj.budgetCreation_ActionButton().click();

	}

	@And("^click on search icon$")
	public void click_on_search_icon() throws Throwable {
		budgetCreationObj.budgetCreationSearchIcon().click();

	}

	@Then("^enter the budget code to search$")
	public void enter_the_budget_code_to_search() throws Throwable {
		budgetCreationObj.budgetCreationSearchBudgetCode().click();
		budgetCreationObj.budgetCreationSearchBudgetCode().sendKeys(budgetDefinitionTestData.updatedBudgetCode);

	}

	@Then("^select the budget code in the search result$")
	public void select_the_budget_code_in_the_search_result() throws Throwable {
		WebElement budgetCode;
		// span[contains(text(),'BUD987Test')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button
		String befor_xpath = "//span[contains(text(),'";
		String after_xpath = "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button[2]";

		budgetCode = driver.findElement(By.xpath(befor_xpath + budgetDefinitionTestData.updatedBudgetCode + after_xpath));
		waitHelper.waitForElement(driver, 3000, budgetCode);
		budgetCode.click();

	}

	@And("^validate the submited record$")
	public void validate_the_submited_record() throws Throwable {
		waitHelper.setImplicitWait(5000);
		String budgetCode = (String) javascripthelper
				.executeScript("return document.getElementsByName('budgetCode')[1].value");
		String budgetType=budgetCreationObj.getBudgetType().getText();
		//String budgetTpe = checkerobj.budgetType().getText();
		String warningPercentage = (String) javascripthelper
				.executeScript("return document.getElementsByName('warningPercentage')[1].value");
		String budgetName = (String) javascripthelper
				.executeScript("return document.getElementsByName('budgetName')[1].value");
		String budgetRemark = (String) javascripthelper
				.executeScript("return document.getElementsByName('remarks')[1].value");
		Assert.assertEquals(budgetCode, budgetDefinitionTestData.updatedBudgetCode);
		Assert.assertEquals(warningPercentage, budgetDefinitionTestData.updatedWarningPecentage);
		Assert.assertEquals(budgetName, budgetDefinitionTestData.updatedBudgetName);
		Assert.assertEquals(budgetRemark, budgetDefinitionTestData.updatedRemark);
		Assert.assertEquals(budgetType, budgetDefinitionTestData.updatedBudgetType);
		// System.out.println(budgetCode+" "+warningPercentage+" "+budgetName+"
		// "+budgetRemark);
	}

//invalid details to create budget code
	@Then("^enter budget code which is already exist$")
	public void enter_budget_code_which_is_already_exist() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionTestData.budgetCode);

	}

	@Then("^system should display validation message for budget code$")
	public void system_should_display_validation_message() throws Throwable {
		// javascripthelper.JavaScriptHelper(driver);
		String validationMessage = "Budget Code is already exist !!!!";
		WebElement validationFOrBudgetCode = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String message = validationFOrBudgetCode.getText();
		Assert.assertEquals(message, validationMessage);
		System.out.println("Message :" + message);
		Thread.sleep(2000);
	}

	@And("^enter warning percentage grater than hundread$")
	public void enter_warning_percentage_grater_than_hundread() throws Throwable {
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionTestData.wrongWarningPercentage);
	}

	@Then("^system should display validation message for warning percentage$")
	public void system_should_display_validation_message_for_warning_percentage() throws Throwable {
		String validationMessage = "Please select between 0 to 100!!!";
		WebElement validationFOrBudgetCode = (WebElement) javascripthelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String message = validationFOrBudgetCode.getText();
		Assert.assertEquals(validationMessage, message);
		System.out.println("Message :" + message);

	}

	@When("^try to click on save button but system not allow to save the record$")
	public void try_to_click_on_save_button_button_but_system_not_allow_to_save_the_record() throws Throwable {
		boolean status = false;
		try {
			budgetCreationObj.budgetCreation_saveButton().click();
		} catch (ElementClickInterceptedException e) {
			status = true;
		}
		Assert.assertTrue(status);
		;

	}

	@Then("^click on approve button$")
	public void click_on_approve_button() throws Throwable {

		/*
		 *This step represent approve the record in auto auth configuration
		 * In auto auth we can approve our budget record in maker itself
		 *
		 */
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationApproveButton());
		budgetCreationObj.budgetCreationApproveButton().click();

	}

	@Then("^check the approval status form alert message$")
	public void check_the_approval_status_form_alert_message() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationApprovalStatus());
		String approvalStatus = budgetCreationObj.budgetCreationApprovalStatus().getText();
		Assert.assertEquals(approvalStatus, "Record APPROVED Successfully");
		budgetCreationObj.checkerAlertClose().click();
	}

	@Then("^select the first record from notification$")
	public void select_the_first_record_from_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationNotificationIcon());
		budgetCreationObj.budgetCreationNotificationIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstRecord());
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@Then("^select the second record from notification$")
	public void select_the_second_record_from_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationNotificationIcon());
		budgetCreationObj.budgetCreationNotificationIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstRecord());
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@Then("^select the record third from notification$")
	public void select_the_record_third_from_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationNotificationIcon());
		budgetCreationObj.budgetCreationNotificationIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstRecord());
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

}