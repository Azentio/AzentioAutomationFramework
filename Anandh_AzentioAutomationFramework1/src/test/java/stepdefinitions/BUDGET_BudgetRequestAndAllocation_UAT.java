package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_RequestAndAllocationObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class BUDGET_BudgetRequestAndAllocation_UAT extends BaseClass {
	WebDriver driver=BaseClass.driver;
	JsonConfig jsonConfig=new JsonConfig();
	BUDGET_RequestAndAllocationObj budgetReqestAndAllocationObj=new BUDGET_RequestAndAllocationObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
    BUDGET_RequestAndAllocationTestDataType budgetRequestAndAllocationTestData=jsonConfig.getAllowcationByName("Maker");
    DropDownHelper dropDownHelper =new DropDownHelper(driver);
    BUDGET_RequestandallocationBUDTYPEDATA budgetRequestAndAllocationBudgetAmount;
    JsonDataReaderWriter jsonDataReaderWriter=new JsonDataReaderWriter();
    KUBS_Login kubsLogin;
	@And("^click on second segment button$")
	public void click_on_second_segment_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, budgetReqestAndAllocationObj.budget_requestAndAllocation_DirctionIcon());
		budgetReqestAndAllocationObj.budget_requestAndAllocation_DirctionIcon().click();
	}

	@Then("^click on budget menu$")
	public void click_on_budget_menu() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetField());
		budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetField().click();

	}

	@And("^click on eye icon near by budget request and allocation$")
	public void click_on_eye_icon_near_by_budget_request_and_allocation() throws Throwable {
		budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetEyeIcon().click();

	}

	@Then("^click on add button$")
	public void click_on_add_button() throws Throwable {
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Addicon().click();
	}

	@And("^choose yearly budget code$")
	public void choose_yearly_budget_code() throws Throwable {
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetcode().click();
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetcode().sendKeys(budgetRequestAndAllocationTestData.BudgetCode);
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@Then("^choose current financial year$")
	public void choose_current_financial_year() throws Throwable {
		dropDownHelper.SelectUsingVisibleText(budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetyear(),budgetRequestAndAllocationTestData.BudgetYear );
		

	}

	@And("^choose branch$")
	public void choose_branch() throws Throwable {
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetbranch().click();
		waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.requestAndAllocation_branch_co());
		budgetReqestAndAllocationObj.requestAndAllocation_branch_co().click();
		budgetReqestAndAllocationObj.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^enter the amount in the appropriate box$")
	public void enter_the_amount_in_the_appropriate_box() throws Throwable {
		String BudgetType=budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgettype().getText();
		budgetRequestAndAllocationBudgetAmount=jsonConfig.getBudtypeByName(BudgetType);
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Budgetyearly().sendKeys(budgetRequestAndAllocationBudgetAmount.BudgetAmounT);
	}

	@And("^give remark in nearby amount text box$")
	public void give_remark_in_nearby_amount_text_box() throws Throwable {
		budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetHyremark1().sendKeys(budgetRequestAndAllocationTestData.Remark);

	}

	@Then("^choose the currency type$")
	public void choose_the_currency_type() throws Throwable {
		
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Amountcurruncy().click();
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Amountcurruncy().sendKeys(budgetRequestAndAllocationTestData.Currency);
		budgetReqestAndAllocationObj.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
		

	}

	@And("^Click on save button$")
	public void click_on_save_button() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		budgetReqestAndAllocationObj.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(1000);
		WebElement successMsg1 = (WebElement) javascriptHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg1 = successMsg1.getText();
		System.out.println("The Message is " + successmsg1);
		Assert.assertEquals(successmsg1, "Budget Code "+budgetRequestAndAllocationTestData.BudgetCode+" created successfully.");
		Thread.sleep(2000);
		WebElement successMsg2 = (WebElement) javascriptHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		String successmsg2 = successMsg2.getText();
		System.out.println("The Message is " + successmsg2);
		Assert.assertEquals(successmsg2, "success");

	}

	@And("^Click on notification button$")
	public void click_on_notification_button() throws Throwable {
		budgetReqestAndAllocationObj.budgetRequestAndAllocationNotificationIcon().click();
		
	}

	@When("^click on first notification records are appear in that list$")
	public void click_on_notification_records_are_appear_in_that_choose_the_first_one() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budgetRequestAndAllocationFirstReferenceId());
		String referenceID=budgetReqestAndAllocationObj.budgetRequestAndAllocationFirstReferenceId().getText();
		jsonDataReaderWriter.addReferanceData(referenceID);
		budgetReqestAndAllocationObj.budgetRequestAndAllocationFirstRecord().click();
	}

	@Then("^Click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetSubmit());
		budgetReqestAndAllocationObj.budget_requestAndAllocation_BudgetSubmit().click();

	}

	@And("^enter the remark in Alert$")
	public void enter_the_remark_in_alert() throws Throwable {
		waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budgetAllocationAlertRemarks());
		budgetReqestAndAllocationObj.budgetAllocationAlertRemarks().click();
		budgetReqestAndAllocationObj.budgetAllocationAlertRemarks().sendKeys(budgetRequestAndAllocationTestData.Remark);
	}

	@Then("^click on submit button appear in alert$")
	public void click_on_submit_button_appear_in_alert() throws Throwable {
		
		budgetReqestAndAllocationObj.budgetAllocationAlertsubmitButton().click();
	}
	 @Then("^click on logout from maker$")
	    public void click_on_logout_from_maker() throws Throwable {
		 waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budgetRequestAndAllocationAlertClose());
		 budgetReqestAndAllocationObj.budgetRequestAndAllocationAlertClose().click();
		 budgetReqestAndAllocationObj.budgetRequestAndAllocationUserName().click();
		 waitHelper.waitForElement(driver, 3000, budgetReqestAndAllocationObj.budgetRequestAndAllocationLogoutButton());
		 javascriptHelper.JSEClick( budgetReqestAndAllocationObj.budgetRequestAndAllocationLogoutButton());
		
	    }
	 @And("^login with reviewer ID$")
	    public void login_with_reviewer_id() throws Throwable {
		 kubsLogin=new KUBS_Login(driver);
		 kubsLogin.logintoAzentioappReviewer("Reviewer", jsonDataReaderWriter.readdata());
	 }


}
