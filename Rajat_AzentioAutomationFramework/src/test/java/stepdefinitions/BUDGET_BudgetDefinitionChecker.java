package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Azentio_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_CommentsFromApprover;

public class BUDGET_BudgetDefinitionChecker extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin kubsLogin;
	String user = "checker";
	Azentio_CheckerObj kubsCheckerObj;
	JsonConfig jsonconfig = new JsonConfig();
	WaitHelper waitHelper;
	JsonDataReaderWriter ReferenceIDReader = new JsonDataReaderWriter();
	BUDGET_CommentsFromApprover remarks = jsonconfig.getApproverData(user);
	// remarks = json.getApproverData(user);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	BUDGET_BudgetDefinitionTestDataType budgetDefinitionTestData = jsonconfig.getBudgetdataByName("Maker");

	@Given("^navigate to URL and login as a checker$")
	public void navigate_to_url_and_login_as_a_checker() throws InterruptedException {
       
		driver.get(config.getApplicationUrl());
		kubsLogin = new AzentioLogin(driver);
		// This step launch the URL login with the user we mentiond
		kubsLogin.loginToAzentioAppAsChecker(user);
		
	}

	@Then("^click on security management menu$")
	public void click_on_security_management_menu() {
		kubsCheckerObj = new Azentio_CheckerObj(driver);
		//This step is for clicking the security management
		kubsCheckerObj.checkerSecurityManagement().click();

	}

	@And("^click on Action icon in security management$")
	public void click_on_action_icon_user_security_management() {
		// this step is for click on action button to view the records which is pending for clime
		kubsCheckerObj.checkerActionIcon().click();

	}

	@Then("^clime the record$")
	public void clime_the_record() throws IOException, ParseException {
		waitHelper = new WaitHelper(driver);
		//This will find our clime through the reference ID 
		/*
		 * At first we have to cut the xpath into two in between of the xpath we have to put our reference ID which is captured in the maker stage
		 *  
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + ReferenceIDReader.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + ReferenceIDReader.readReferancedata() + after_xpath_claim)).click();
        // after clicking on the clime button , clime successful message will came we have to close mesage
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerAlertClose());
		kubsCheckerObj.checkerAlertClose().click();

	}

	@And("^click on notification icon in checker stage$")
	public void click_on_notificaton_icon() {
		// this step is used to click the notification ICON
		kubsCheckerObj.checkerNotificationIcon().click();

	}

	@When("^checker click on notification icon record might be showed in notification area$")
	public void checker_click_on_notification_icon_record_might_be_showed_in_notification_area() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		// This step we have to customize our xpath to find out our record with the help of reviewer ID 
		/*
		 * This step we can able to check whether the notification came to checker or not
		 */
		Assert.assertTrue(
				driver.findElement(By.xpath(before_xpath + ReferenceIDReader.readReferancedata() + after_xpath)).isDisplayed());
	}

	@And("^click on action button in checker stage$")
	public void click_on_action_button_in_checker_stage() throws IOException, ParseException {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + ReferenceIDReader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + ReferenceIDReader.readReferancedata() + after_xpath)).click();

	}

	@Then("^validate the budget record$")
	public void validate_the_budget_record() throws Throwable {
		Thread.sleep(1000);
        waitHelper.setImplicitWait(5000);
        javascriptHelper.JavaScriptHelper(driver);
        //waithelper.wait(3000);
        /* in this step we can validate the budget record which is submited by maker
         * 
         */
        String budgetCode = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		String budgetTpe = kubsCheckerObj.budgetType().getText();
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

	@Then("^click on approve in checker stage$")
	public void click_on_approve_in_checker_stage() {
        // this step we can approve the record
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerApproveButton());
		kubsCheckerObj.checkerApproveButton().click();

	}

	@And("^Write remark in alert$")
	public void write_remark_in_alert() {
   // this step we enter the alert remark for thei step we can enter the possitive remark because This record going to approve
		waitHelper.waitForElement(driver, kubsCheckerObj.checkerRemarks(), 3000);
		kubsCheckerObj.checkerRemarks().click();
		kubsCheckerObj.checkerRemarks().sendKeys(remarks.PossitiveRemarks);

	}

	@And("^Submit the record from checker$")
	public void submit_the_record() {
		//after filling the alert remark we can click the submit button
		javascriptHelper.JSEClick(kubsCheckerObj.checkersubmitButton());
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerApprovalStatus());
		String checkerApprovalStatus = kubsCheckerObj.checkerApprovalStatus().getText();
		// This step we can validate the alert message which is apear after submiting the record
		/*
		 * This step we can validate approval status
		 */
		Assert.assertEquals(checkerApprovalStatus, "Record APPROVED Successfully");

	}

	@Then("^validate the updated budget record$")
	public void validate_the_updated_budget_record() throws Throwable {
		/*
		 * This step we can validate the updated budget data
		 * This field data are in hidden element so we use javascript to locate that element 
		 * 
		 */
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
        waitHelper.setImplicitWait(5000);
        //waithelper.wait(3000);
		String budgetCode = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
		String budgetTpe = kubsCheckerObj.budgetType().getText();
		String warningPercentage = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
		String budgetname = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
		String budgetRemark = (String) javascriptHelper
				.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");
		Assert.assertEquals(budgetCode, budgetDefinitionTestData.updatedBudgetCode);
		Assert.assertEquals(budgetTpe, budgetDefinitionTestData.updatedBudgetType);
		Assert.assertEquals(budgetname, budgetDefinitionTestData.updatedBudgetName);
		Assert.assertEquals(warningPercentage, budgetDefinitionTestData.updatedWarningPecentage);
		Assert.assertEquals(budgetRemark, budgetDefinitionTestData.updatedRemark);

	}

	// checker reject the budgetcode

	@Then("^reject the record$")
	public void reject_the_record() {
		//This step we reject the budget record
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerRejectButton());
		kubsCheckerObj.checkerRejectButton().click();
	}

	@And("^write negative remark and submit it$")
	public void write_negative_remark_and_submit_it() {
		// approverComments=jsonconfig.getApproverData(user);
		//This step we have to give some negative remark , Because the budget record is going to reject
		kubsCheckerObj.checkerRemarks().sendKeys(remarks.NegativeRemarks);
		kubsCheckerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsCheckerObj.checkerApprovalStatus());
		// after clicking the submit button we can validate the budget is rejected or not
		String checkerApprovalStatus = kubsCheckerObj.checkerApprovalStatus().getText();
		Assert.assertEquals(checkerApprovalStatus, "Record REJECTED Successfully");

	}

}