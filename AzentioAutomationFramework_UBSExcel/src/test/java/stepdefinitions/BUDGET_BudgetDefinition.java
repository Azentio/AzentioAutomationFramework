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
import helper.ClicksAndActionsHelper;
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

	ConfigFileReader configFileReader = new ConfigFileReader();
	JsonConfig jsonConfig = new JsonConfig();
	Azentio_MakerObj kubsMakerObj = new Azentio_MakerObj(driver);
	ClicksAndActionsHelper clicksAndActionsHelper= new ClicksAndActionsHelper(driver);
	String user = "Maker";
	WaitHelper waitHelper = new WaitHelper(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	

	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();

	

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

	


	@Then("^select the record from notification$")
	public void select_the_record_from_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationNotificationIcon());
		budgetCreationObj.budgetCreationNotificationIcon().click();
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreationFirstRecord());
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	
//BudgetCodeUpdation

	
	// Search criteria
	@And("^click on action button in budget configuration$")
	public void click_on_action_button_in_budget_configuration() throws Throwable {
		budgetCreationObj.budgetCreation_ActionButton().click();

	}

	@And("^click on search icon$")
	public void click_on_search_icon() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationSearchIcon(), 20, 1);
		clicksAndActionsHelper.moveToElement(budgetCreationObj.budgetCreationSearchIcon());
		clicksAndActionsHelper.clickOnElement(budgetCreationObj.budgetCreationSearchIcon());
		//budgetCreationObj.budgetCreationSearchIcon().click();

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