package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;

import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.VerificationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;

import resources.BaseClass;
import testDataType.BUDGET_BudgetCreationTestDataType;

public class BUDGET_BudgetCreation {

	public class BudgetCreation extends BaseClass {

		WebDriver driver = BaseClass.driver;
		JsonConfig json = new JsonConfig();
		ConfigFileReader config = new ConfigFileReader();
		KUBS_Login login = new KUBS_Login(driver);
		DropDownHelper dropDownHelper;
		BUDGET_BudgetCreationObj budgetCreationObj;
		KUBS_MakerObj kubsMakerObj;
		BUDGET_BudgetCreationTestDataType budgdata;
		String reviwerId;
		KUBS_ReviewerObj kubsReviewerObj;
		String reference_id;
		BrowserHelper browserHelper;
		KUBS_CheckerObj kubsCheckerObj;

		// VerificationHelper vhelper;
		@Given("^navigate to the url and user should login as a maker$")
		public void navigate_to_the_url_and_user_should_login_as_a_maker() throws InterruptedException {
			login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			 login.loginToAzentioAppByMaker();
		}

		/*@And("^choose finance in configuration page$")
		public void choose_finance_in_configuration_page() {
			budgdata = json.getBudgetdataByName("Maker");
			dropDownHelper = new DropDownHelper(driver);
			budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
			kubsMakerObj = new KUBS_MakerObj(driver);
			dropDownHelper.SelectUsingVisibleText(kubsMakerObj.kubsFinaceOption(), "Finance");
		}*/

		@Then("^Choose Budget creation menu$")
		public void choose_budget_creation_menu() {
			kubsMakerObj.kubsBudgetConfiguration().click();
		}

		@And("^click on the eye icon of budget defenition sub menu$")
		public void click_on_the_eye_icon_of_budget_defenition_sub_menu() {

			budgetCreationObj.budgetCreation_EyeIcon().click();

		}

		@Then("^capture all the valid details and save the record$")
		public void capture_all_the_valid_details_and_save_the_record() {

			budgetCreationObj.budgetCreation_AddButton().click();

			budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgdata.BudgetCode);
			dropDownHelper.SelectUsingVisibleText(budgetCreationObj.budgetCreation_BudgetType(), budgdata.BudgetType);
			budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgdata.WarningPecentage);
			budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgdata.BudgetName);
			budgetCreationObj.budgetCreation_Remarks().sendKeys(budgdata.Remark);
			budgetCreationObj.budgetCreation_saveButton().click();
		}

		@And("^click note icon and choose our data and click our data and submit$")
		public void click_note_icon_and_choose_our_data_and_click_our_data_and_submit() {
			budgetCreationObj.budgetCreation_ActionButton().click();
			String before_xpath = "//datatable-row-wrapper[";
			String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]/div/span";
			for (int i = 1; i <= 8; i++) {
				String budger_code = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

				if (budger_code.equalsIgnoreCase(budgdata.BudgetCode)) {
					driver.findElement(By.xpath(before_xpath + i
							+ "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button")).click();
					budgetCreationObj.budgetCreation_SubmitButton().click();
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys("Ok");
					budgetCreationObj.budgetCreation_AlertsubmitButton().click();
					break;
				}

			}
			VerificationHelper.verifyElementPresent(budgetCreationObj.budgetCreation_ReviewerId());
			reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
			System.out.println(reviwerId);
		}

		@Then("^click logout button and login as a reviewer$")
		public void click_logout_button_and_login_as_a_reviewer() throws InterruptedException {
			//budgetCreationObj.budgetCreation_LogoutButton().click();
			login.logintoAzentioappReviewer(reviwerId.substring(10, 16));
		}

		@And("^find the budget code and approve the record$")
		public void find_the_budget_code_and_approve_the_record() {
			// datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]/div/span
			// datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button
			browserHelper = new BrowserHelper(driver);
			String before_xpath = "//datatable-row-wrapper[";
			String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]/div/span";
			kubsReviewerObj = new KUBS_ReviewerObj(driver);
			kubsReviewerObj.reviewerNotificationIcon().click();
			for (int i = 0; i < 10; i++) {
				reference_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				driver.findElement(By.xpath(before_xpath + i
						+ "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button")).click();
				String budgetcode = kubsReviewerObj.reviewerGetBudgetCode().getText();
				if (budgetcode.equalsIgnoreCase(budgdata.BudgetCode)) {

					kubsReviewerObj.reviewerApproveButton().click();
					kubsReviewerObj.reviewerAlertRemarks().sendKeys("ok");
					kubsReviewerObj.reviewerAlertSubmitButton().click();
					break;
				} else {
					browserHelper.goBack();
					reference_id = "";
				}
			}
		}

		@Then("^logout from the reviewer and login from checker$")
		public void logout_from_the_reviewer_and_login_from_checker() throws InterruptedException {
			login.loginToAzentioAppAsChecker();
			kubsCheckerObj = new KUBS_CheckerObj(driver);
			kubsCheckerObj.checkerSecurityManagement().click();
			kubsCheckerObj.checkerActionIcon().click();
			;
		}

		@And("^find the reference id and select the record$")
		public void find_the_reference_id_and_select_the_record() {
			// span[contains(text(),'199')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button
			String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			// span[contains(text(),'199')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
			driver.findElement(By.xpath(before_xpath + reference_id + after_xpath_claim)).click();
			kubsCheckerObj.checkerNotificationIcon().click();
			driver.findElement(By.xpath(before_xpath + reference_id + after_xpath)).click();
		}

		@And("^approve the record$")
		public void approve_the_record() throws Throwable {
			kubsCheckerObj.checkerApproveButton().click();
			kubsCheckerObj.checkerRemarks().sendKeys("ok");
			kubsCheckerObj.checkersubmitButton().click();

		}

	}
}
