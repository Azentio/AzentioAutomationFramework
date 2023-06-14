package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_CommentsFromApprover;

public class BUDGET_BudgetDefinitionReviewer extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonconfig = new JsonConfig();
	AzentioLogin kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	Azentio_ReviewerObj kubsReviewerObj;
	JsonDataReaderWriter jsonDataReader = new JsonDataReaderWriter();
	String user = "Reviewer";
	BUDGET_CommentsFromApprover commentsFromapprover = jsonconfig.getApproverData(user);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	BUDGET_BudgetDefinitionTestDataType budgetDefinitionTestData = jsonconfig.getBudgetdataByName("Maker");

	@Given("^navigate to URL and login as a reviewer$")
	public void navigate_to_URL_and_login_as_a_reviewer() throws IOException, ParseException {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin = new AzentioLogin(driver);
		// This step we have to login with the mentioned user ID and password
		kubsLogin.logintoAzentioappReviewer(user, jsonDataReader.readdata());

	}

	@Then("^click on notification icon$")
	public void click_on_notification_icon() {
		kubsReviewerObj = new Azentio_ReviewerObj(driver);
		// At the first step we have to click on notification first
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerNotidicationIcon());
		kubsReviewerObj.reviewerNotidicationIcon().click();
	}

	@When("^click on notification icon to check reviewer can get a record which is submited by maker$")
	public void click_on_notification_icon_to_check_reviewer_can_get_a_record_whic_is_submited_by_maker()
			throws IOException, ParseException {
		// Then we have to cut the xpath in two, And in between of the two xpath we have
		// to pass the reference ID to locate our particular record
		// span[contains(text(),'105')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + jsonDataReader.readReferancedata() + after_xpath)));
		Assert.assertTrue(
				driver.findElement(By.xpath(before_xpath + jsonDataReader.readReferancedata() + after_xpath)).isDisplayed());
		String referenceID = driver.findElement(By.xpath(before_xpath + jsonDataReader.readReferancedata() + after_xpath))
				.getText();
		System.out.println("Reference ID is" + referenceID);
		System.out.println("Json reference is" + jsonDataReader.readReferancedata());
		Assert.assertEquals(referenceID, jsonDataReader.readReferancedata());

	}

	@And("^click on action button$")
	public void click_on_action_button() throws IOException, ParseException {
// after validation we have to click on that perticular record
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		driver.findElement(By.xpath(before_xpath + jsonDataReader.readReferancedata() + after_xpath)).click();

	}

	@Then("^verify the budget record is matched with maker submited record$")
	public void verify_the_budget_record_is_matched_with_maker_submited_record() throws Throwable {
		/*
		 * In this step we have to validate the budget code record which is submited by
		 * maker This field data are hidden element so we have to use java script
		 * 
		 */
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.setImplicitWait(5000);

		String budgetCode = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		String budgetTpe = kubsReviewerObj.budgetType().getText();
		String warningPercentage = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
		String budgetname = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
		String budgetRemark = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");
		Assert.assertEquals(budgetCode, budgetDefinitionTestData.budgetCode);
		Assert.assertEquals(budgetTpe, budgetDefinitionTestData.budgetType);
		Assert.assertEquals(budgetname, budgetDefinitionTestData.budgetName);
		Assert.assertEquals(warningPercentage, budgetDefinitionTestData.warningPecentage);
		Assert.assertEquals(budgetRemark, budgetDefinitionTestData.remark);
	}

	@And("^approve the record in reviewer stage$")
	public void approve_the_record() {
		// after vaidation we have to approve the record
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApproveButton());
		kubsReviewerObj.reviewerApproveButton().click();
	}

	@Then("^enter remark then submit$")
	public void enter_remark_then_submit() {
// when click on submit button alert will pop up and we have to enter possitive remark in alert
		waitHelper.waitForElement(driver, 2000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(commentsFromapprover.PossitiveRemarks);
		// this place we have to submit the record
		kubsReviewerObj.reviewerAlertSubmitButton().click();
		// after submitting the record we have to validate the approval status
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApprovalStatus());
		Assert.assertTrue(kubsReviewerObj.reviewerApprovalStatus().isDisplayed());
		String reviewerApprovalStatus = kubsReviewerObj.reviewerApprovalStatus().getText();
		// we have the locate the alert which is open after we approve the record
		/*
		 * We get the text from that alert and check with assert function
		 */
		Assert.assertEquals(reviewerApprovalStatus, "Record is available in CHECKER's Open Pool with status PENDING");

	}

	// Reviewer Reject the budgetCode
	@And("^reject the record in reviewer stage$")
	public void reject_the_record_in_reviewer_stage() {
		// In this step we reject the budget code
		kubsReviewerObj.reviewerRejectButton().click();

	}

	@Then("^enter remark then submit in reviewer stage$")
	public void enter_remark_then_submit_in_reviewer_stage() {
		// approvercomments=jsonconfig.getApproverData(user);
		/*
		 * In this step we give negative remark in the alert text field , Because we are
		 * going to reject the budget code
		 */
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(commentsFromapprover.NegativeRemarks);
		kubsReviewerObj.reviewerAlertSubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApprovalStatus());
		Assert.assertTrue(kubsReviewerObj.reviewerApprovalStatus().isDisplayed());
		// This step we get the text from alert and validate the text is equals with our
		// expected result
		// with the help of assert function
		String approvalStatus = kubsReviewerObj.reviewerApprovalStatus().getText();
		Assert.assertEquals(approvalStatus, "Record REJECTED Successfully");

	}

	@Then("^verify the updated budget record is matched with maker submited record$")
	public void verify_the_updated_budget_record_is_matched_with_maker_submited_record() throws Throwable {
		/*
		 * This step is for validate the budget record which is update d by maker 
		 * This fields data are hidden element so we have to use java script
		 * and validate with our test data
		 */
		Thread.sleep(1000);
		waitHelper.setImplicitWait(5000);
		// waithelper.wait(3000);
		javascriptHelper.JavaScriptHelper(driver);
		String budgetCode = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		String budgetType = kubsReviewerObj.budgetType().getText();
		System.out.println("Budget Type is"+budgetType);
		String warningPercentage = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
		String budgetname = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
		String budgetRemark = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");
		Assert.assertEquals(budgetCode, budgetDefinitionTestData.updatedBudgetCode);
		Assert.assertEquals(budgetType, budgetDefinitionTestData.updatedBudgetType);
		Assert.assertEquals(budgetname, budgetDefinitionTestData.updatedBudgetName);
		Assert.assertEquals(warningPercentage, budgetDefinitionTestData.updatedWarningPecentage);
		Assert.assertEquals(budgetRemark, budgetDefinitionTestData.updatedRemark);
	}

}