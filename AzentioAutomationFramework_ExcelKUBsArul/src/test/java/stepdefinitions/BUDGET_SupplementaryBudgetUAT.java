package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import utilities.ExtentTestManager;

public class BUDGET_SupplementaryBudgetUAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javahelper = new JavascriptHelper();
	AzentioLogin login = new AzentioLogin(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;
	// Checker//
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	JavascriptHelper javascript;
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	String referance_id;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig = new JsonConfig();
	ConfigFileReader config = new ConfigFileReader();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\KUBSTestDataDesign2912.xlsx";
    ExcelData excelData = new ExcelData(excelPath,"SupplementoryBudgetTestData","Data Set ID");
    private Map<String, String> testData;
//	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);

	// ----------------------------------------SupplementaryBudget_KUBS_BP_UAT_005_004---------------------------------------------//
	// ----------------------------------------------Budget Record

	@Given("^maker should navigate to the url and login with valid credentials UAT$")
	public void maker_should_navigate_to_the_url_and_login_with_valid_credentials_UAT() throws InterruptedException {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@And("^maker should navigate to the budget module UAT$")
	public void maker_should_navigate_to_the_budget_module_UAT() throws InterruptedException {
		waithelper = new WaitHelper(driver);
		bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(kubsMakerObj.kubsToolIcon());
		clicksAndActionHelper.doubleClick(kubsMakerObj.kubsToolIcon());

		
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		clicksAndActionHelper.doubleClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
	}

	@And("^maker click on budget field UAT$")
	public void maker_click_on_budget_field_UAT() {
//		waithelper.waitForElementVisible(kubsMakerObj.kubsBudget(), 3000, 300);
//		kubsMakerObj.kubsBudget().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField(), 120, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
	}

	@When("^maker click on budget supplementary eye icon UAT$")
	public void maker_click_on_budget_supplymentary_eye_icon_UAT() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();

	}

	@And("^click on add button on budget supplementary view page UAT$")
	public void click_on_add_button_on_budget_supplementary_view_page_UAT() throws InterruptedException {

for(int i=0;i<=10;i++)
{
	try
	{
	waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 6, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	break;
	}
	catch(Exception e)
	{
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 6, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();	
	}
	}
	}
	@Then("^fill the input fields UAT$")
	public void fill_the_input_fields_UAT() {
		// budget code
		
			bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode()
				.sendKeys(testData.get("BudgetCodeA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
		
		// budget year
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear()
				.sendKeys(testData.get("BudgetYearA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
		// budget branch
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch()
				.sendKeys(testData.get("BudgetBranchNameA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
		// currency
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency()
				.sendKeys(testData.get("CurrencyA"));
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);
		
	}

	@Then("fill apportion amount and save the record UAT")
	public void fill_apportion_amount_and_save_the_record_uat() throws InterruptedException {
		// Supplementary apportion amount
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
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
			javascripthelper.JavaScriptHelper(driver);
			try {
				String str = javascripthelper.executeScript(
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
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {

				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
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
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)), 60, 500);
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Submit button
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();

		// Remark
		javahelper.JavaScriptHelper(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField(), 60, 500);
		javahelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys("OK");

		// Remark Submit

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();

		// REVIEWER
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus(), 60, 500);
		WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
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
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);

	}
	// -----------SupplementaryBudget_KUBS_BP_UAT_005_004-------------------------------//

	@Then("^user login to checker1 UAT$")
	public void user_login_to_checker1_UAT() throws IOException, ParseException {
		reader = new JsonDataReaderWriter();
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	}

	@And("^click on notification icon UAT$")
	public void click_on_notification_icon_UAT() {
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();
		ExtentTestManager.getTest().info("User clicks on notification icon");
	}

	@And("^click on action button button of the record which we want to approve UAT$")
	public void click_on_action_button_button_of_the_record_which_we_want_to_approve_UAT()
			throws InterruptedException, IOException, ParseException {
		browserHelper = new BrowserHelper(driver);
		javascript = new JavascriptHelper();

		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	@Then("^user approve the record UAT$")
	public void user_approve_the_record_UAT() {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		ExtentTestManager.getTest().info("User Click Approve button");
	}

	@And("^user write the remark & submit the record UAT$")
	public void user_write_the_remark_submit_the_record_UAT() throws InterruptedException {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		ExtentTestManager.getTest().info("User write remark");

		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		ExtentTestManager.getTest().info("User click on submit button");

	}

	@Then("^User should login to checker2 UAT$")
	public void user_should_login_to_checker2_UAT() throws InterruptedException {
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
	}

	@Then("^click on open pool UAT$")
	public void click_on_open_pool_UAT() {
		waithelper = new WaitHelper(driver);
		kubschecker = new Azentio_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

	}

	@And("^Verify for claming the record UAT$")
	public void verify_for_claming_the_record_UAT() throws IOException, Throwable {
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();

		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		for (int i = 0; i <= 30; i++) {
			try {
				waithelper.waitForElement(driver, 5000,
						driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
				break;
			} catch (NoSuchElementException e) {

			}
		}
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^User should click on notification icon on reviewer2 home page UAT$")
	public void user_should_click_on_notification_icon_on_reviewer2_home_page_UAT() throws InterruptedException {
		javascript = new JavascriptHelper();

		waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());

		kubschecker.checkerNotificationIcon().click();
	}

	@Then("^Claim and approve the record UAT$")
	public void claim_and_approve_the_record_UAT() throws InterruptedException, IOException, ParseException {

		for (int i = 1; i <= 35; i++) {
			try {
//				waithelper.waitForElement(driver, 3000,
//						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();

				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		waithelper.waitForElement(driver, 4000, kubschecker.checkerRejectButton());

		Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerReturnButton());
		Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

		// Approve
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		kubschecker.checkerApproveButton().click();

		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("OK");

		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();

	}

	// -----------SupplementaryBudget_KUBS_BP_UAT_005_005-------------------------------//

	@Then("^Claim and reject the record UAT$")
	public void claim_and_reject_the_record_UAT() throws InterruptedException, IOException, ParseException {

//		for (int i = 1; i <= 35; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000,
//						driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
//				WebElement referanceID = driver
//						.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
//				referanceID.click();
//				
//
//				Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
//				
//				kubschecker.checker_notification_next_button().click();
//			}
//    }

//		javascripthelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//				String before_xpath = "//span[contains(text(),'";
//				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
//				// waitHelper.waitForElement(driver, 1000, driver
//				// .findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() +
//				// after_xpath)));
//				// driver.findElement(By.xpath(before_xpath +
//				// jsonReaderWriter.readReferancedata() + after_xpath)).click();
//				javascripthelper.JSEClick(driver
//						.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)));
//				break;
//			} catch (Exception exception) {
//				System.out.println(exception.getMessage());
//
//			}
//		}
		// Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

		// Reject

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerRejectButton(), 60, 500);
		kubschecker.checkerRejectButton().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerRemarks(), 60, 500);
		kubschecker.checkerRemarks().click();
		kubschecker.checkerRemarks().sendKeys("OK");

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkersubmitButton(), 60, 500);
		kubschecker.checkersubmitButton().click();

	}

	// -----------------SupplementaryBudget_KUBS_BP_UAT_005_003-------------------//
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
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
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
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	// ---------------SupplementaryBudget_KUBS_BP_UAT_005_007------------------------//
	@Then("^Click on Report field$")
	public void click_on_report_field() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.report_Field());
		bUDGET_SupplementaryBudgetObj.report_Field().click();
	}

	@Then("^click on supplementary budget Report$")
	public void click_on_supplementary_budget_report() throws InterruptedException {

		javascripthelper.JavaScriptHelper(driver);
		
		javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report());
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report(), 5, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report().click();
	}

	@Then("^Select the date$")
	public void select_the_date() {

		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");

		// select Transaction from date
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + bUDGET_SupplementaryBudgetTestDataType.FromMonth
										+ " " + bUDGET_SupplementaryBudgetTestDataType.Year + "')]")),
						60, 500);
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + bUDGET_SupplementaryBudgetTestDataType.FromMonth + " "
								+ bUDGET_SupplementaryBudgetTestDataType.Year + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NextMonth().click();
			}
		}
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + bUDGET_SupplementaryBudgetTestDataType.FromFullMonth + " "
						+ bUDGET_SupplementaryBudgetTestDataType.FromDay + ", "
						+ bUDGET_SupplementaryBudgetTestDataType.Year + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button of report$")
	public void click_on_view_button_of_report() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport().click();

	}

	@Then("^verify the Supplementary Budget report$")
	public void verify_the_supplementary_budget_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
//	    	
//	    	javascripthelper.JavaScriptHelper(driver);
//	        javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
//	        waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
//	        bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear().click();

		browserHelper.switchToParentWithChildClose();
	}
	@And("^Update test data for supplementory budget test case$")
    public void update_test_data_for_supplementory_budget_test_case() throws Throwable {
		testData = excelData.getTestdata("KUBS_UAT_KUBS_BP_UAT_004_002_01_D1");
    }
}
