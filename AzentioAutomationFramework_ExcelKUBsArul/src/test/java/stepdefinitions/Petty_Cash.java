package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Petty_Cash_Obj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.PETTY_PettyCash_Data;

public class Petty_Cash extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	Map<String, String> Getdata = new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	Petty_Cash_Obj pettyCashObj = new Petty_Cash_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	PETTY_PettyCash_Data pettyData = jsonConfig.getPettycashByName("Pettycash");

	// *******************@KUBS_PC_UAT_001_001********************//

	@Then("^Click on Pettycash Configuration$")
	public void click_on_pettycash_configuration() throws Throwable {
		// ------PETTY CASH CONFIGURATION-------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(pettyCashObj.Petty_Cash_Configuration());
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Configuration(), 60, 500);
		pettyCashObj.Petty_Cash_Configuration().click();
	}

	@And("^Click on Expense Code Limit$")
	public void click_on_expense_code_limit() throws Throwable {
		// -------EXPENSE CODE LIMIT-------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(pettyCashObj.Petty_Cash_Expense_code_limit());
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_code_limit(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_code_limit().click();
	}

	@Then("^Click on Add Icon in Petty cash$")
	public void click_on_add_icon_in_petty_cash() throws Throwable {
		// -----ADD ICON -------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Add(), 60, 500);
		pettyCashObj.Petty_Cash_Add().click();
	}

	@And("^Enter Expense code value$")
	public void enter_expense_code_value() throws Throwable {
		// -------EXPENSE CODE VALUE------//
		Random ran = new Random();
		int random = ran.nextInt(500-50)+50;
		//waitHelper.waitFoElementwithFluentwait(driver,  pettyCashObj.Petty_Cash_ExpenseCode());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, pettyCashObj.Petty_Cash_ExpenseCode(), 60, 500);
		pettyCashObj.Petty_Cash_ExpenseCode().sendKeys(pettyData.ExpenseCode+random);
	}

	@Then("^Enter Expense Name Value$")
	public void enter_expense_name_value() throws Throwable {
		// -------EXPENSE NAME VALUE-------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_ExpenseName(), 60, 500);
		pettyCashObj.Petty_Cash_ExpenseName().sendKeys(pettyData.ExpenseName);
	}

	@And("^Choose Expense Gl$")
	public void choose_expense_gl() throws Throwable {
		// ------CHOOSE EXPENSE GL------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Gl(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Gl().click();
		pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(pettyData.ExpenseGl);
		// pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(Keys.DOWN);
		pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Max Limit Value$")
	public void enter_max_limit_value() throws Throwable {
		// --------ENTER MAX LIMIT VALUE------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Max_Limit(), 60, 500);
		pettyCashObj.Petty_Cash_Max_Limit().sendKeys(pettyData.MaxLimit);
	}

	@And("^Choose Currency value$")
	public void choose_currency_value() throws Throwable {
		// --------CHOOSE CURRENCY VALUE-----//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Currency(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Currency().click();
		pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(pettyData.Currency);
		pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(Keys.ENTER);
	}

	@Then("^save Record in Petty cash$")
	public void save_record_in_petty_cash() throws Throwable {
		// --------SAVE THE RECORD-------//
//		javaScriptHelper.JavaScriptHelper(driver);
//		javaScriptHelper.JSEClick(pettyCashObj.Petty_Cash_Expense_Save());
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Save(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Save().click();
	}

	// *****************@KUBS_PC_UAT_001_002******************//

	@And("^Click on Employee Limit$")
	public void click_on_employee_limit() throws Throwable {
		// -------EMPLOYEE LIMIT-------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(pettyCashObj.Petty_Cash_Employee_limit());
		pettyCashObj.Petty_Cash_Employee_limit().click();
	}

	@And("^Choose Employee Value$")
	public void choose_employee_value() throws Throwable {
		// -------EMPLOYEE VALUE-------//
		pettyCashObj.Petty_Cash_Employee().click();
		pettyCashObj.Petty_Cash_Employee().sendKeys(pettyData.EmployeeValue);
		pettyCashObj.Petty_Cash_Employee().sendKeys(Keys.DOWN);
		pettyCashObj.Petty_Cash_Employee().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Advance Limit$")
	public void enter_advance_limit() throws Throwable {
		// --------ENTER ADVANCE LIMIT-----//
		pettyCashObj.Petty_Cash_Max_AdvanceLimit().click();
		pettyCashObj.Petty_Cash_Max_AdvanceLimit().sendKeys("1000000");
	}

	@And("^Choose Employee Currency value$")
	public void choose_employee_currency_value() throws Throwable {
		// --------CHOOSE CURRENCY VALUE-----//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Employee_Currancy(), 60, 500);
		pettyCashObj.Petty_Cash_Employee_Currancy().click();
		pettyCashObj.Petty_Cash_Employee_Currancy().sendKeys(pettyData.Currency);
		pettyCashObj.Petty_Cash_Employee_Currancy().sendKeys(Keys.ENTER);
	}

	@And("^Close the Alert$")
	public void close_the_alert() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  checkerObj.checker_alert_close(), 60, 500);
		checkerObj.checker_alert_close().click();
	}

	// ***************@KUBS_PC_UAT_001_003*****************//

	@And("^click on Custodian limit module$")
	public void click_on_custodian_limit_module() throws Throwable {
		pettyCashObj.pettyCashConfigCostodianLimitViewButton().click();
	}

	@And("^Enter user name in the Custodian limit$")
	public void enter_user_name_in_the_Custodian_limit() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.costodianLimitUserName(), 60, 500);
		pettyCashObj.costodianLimitUserName().click();
		pettyCashObj.costodianLimitUserName().sendKeys(pettyData.CustodianLimit);
		pettyCashObj.costodianLimitUserName().sendKeys(Keys.DOWN);
		pettyCashObj.costodianLimitUserName().sendKeys(Keys.ENTER);
	}

	@And("^give maximum limit$")
	public void give_maximum_limit() throws Throwable {
		pettyCashObj.costodianLimitMaxLimit().click();
		pettyCashObj.costodianLimitMaxLimit().sendKeys(pettyData.MaxLimit);
	}

	@And("^give replenish limit$")
	public void give_replenish_limit() throws Throwable {
		pettyCashObj.costodianLimitReplenishLimit().click();
		pettyCashObj.costodianLimitReplenishLimit().sendKeys(pettyData.ReplenishLimit);
	}

	@And("^enter the currency type$")
	public void enter_the_currency_type() throws Throwable {
		pettyCashObj.costodianLimitCurrencyLimit().click();
		pettyCashObj.costodianLimitCurrencyLimit().sendKeys(pettyData.Currency);
		pettyCashObj.costodianLimitCurrencyLimit().sendKeys(Keys.ENTER);
	}

	// ****************@KUBS_PC_UAT_002_001*******************//

	@And("^Click on Petty cash module$")
	public void click_on_petty_cash_module() throws Throwable {
		pettyCashObj.pettyCashModule().click();
	}

	@Then("^Click on Fund Request Eye Icon$")
	public void click_on_fund_request_eye_icon() throws Throwable {
		pettyCashObj.fundRequestEyeIcon().click();
	}

	@And("^Enter Request Amount value$")
	public void enter_request_amount_value() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.enterRequestAmout(), 60, 500);
		pettyCashObj.enterRequestAmout().click();
		pettyCashObj.enterRequestAmout().sendKeys(pettyData.RequestAmount);
	}

	@Then("^Enter Petty cash Remark$")
	public void enter_petty_cash_remark() throws Throwable {
		pettyCashObj.enterRemark().click();
		pettyCashObj.enterRemark().sendKeys(pettyData.Remarks);
	}

	@Then("^Click submit button and Enter Remark then submit it$")
	public void click_submit_button_and_enter_remark_then_submit_it() throws Throwable {
		// -------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_Submit(), 60, 500);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_Remark(), 60, 500);
		arapObj.ARAP_Remark().sendKeys(pettyData.Remarks);
		for (int i = 0; i < 30; i++) {
			try {
				//waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAP_RemarkSubmit());
				arapObj.ARAP_RemarkSubmit().click();
				break;
			}
			catch(ElementClickInterceptedException e) {
		}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_ReviewerId(), 60, 500);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(86);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	@Then("^Approve the record in ReviewerStage$")
	public void approve_the_record_in_reviewerstage() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.fundRequest_Approve(), 60, 500);
		pettyCashObj.fundRequest_Approve().click();
	}

	// ******************@KUBS_PC_UAT_003*********************//

	@Then("^Click on Reimbursement Eye Icon$")
	public void click_on_reimbursement_eye_icon() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(pettyCashObj.Reimbursement_Eye_Icon());
		pettyCashObj.Reimbursement_Eye_Icon().click();
	}

	@And("^Choose Cash Memo Ref number$")
	public void choose_cash_memo_ref_number() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_cashMemo(), 60, 500);
		pettyCashObj.Reimbursement_cashMemo().click();
		pettyCashObj.Reimbursement_cashMemo().sendKeys(Keys.DOWN);
		pettyCashObj.Reimbursement_cashMemo().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Advance Amount value$")
	public void enter_advance_amount_value() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_AdvanceAmount(), 60, 500);
		String Amount = pettyCashObj.Reimbursement_AdvanceAmount().getText();
		System.out.println(Amount);
	}

	@And("^Choose Expense Code$")
	public void choose_expense_code() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_expenseCode(), 60, 500);
		pettyCashObj.Reimbursement_expenseCode().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Expense1(), 60, 500);
		pettyCashObj.Reimbursement_Expense1().click();
	}

	@Then("^Enter Reimbursement Amount$")
	public void enter_reimbursement_amount() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Reimbursement_Amount(), 60, 500);
		pettyCashObj.Reimbursement_Reimbursement_Amount().click();
		pettyCashObj.Reimbursement_Reimbursement_Amount().clear();
		pettyCashObj.Reimbursement_Reimbursement_Amount().sendKeys(pettyData.ReimburseAmount);
	}

	@And("^Enter Reimbursement Remarks$")
	public void enter_reimbursement_remarks() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Remark(), 60, 500);
		pettyCashObj.Reimbursement_Remark().click();
		pettyCashObj.Reimbursement_Remark().sendKeys(pettyData.Remarks);
	}

	@Then("^Click submit button and Enter the Remark submit it$")
	public void click_submit_button_and_enter_the_remark_submit_it() throws Throwable {
		// -------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_Submit(), 60, 500);
		arapObj.ARAP_Submit().click();
		Thread.sleep(1000);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_Remark(), 60, 500);
		arapObj.ARAP_Remark().sendKeys(pettyData.Remarks);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 60, 500);
		arapObj.ARAP_RemarkSubmit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  arapObj.ARAP_ReviewerId(), 60, 500);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(83);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	@Then("^Click submit button and Enter the Remark then submit it$")
	public void click_submit_button_and_enter_the_remark_then_submit_it() throws Throwable {
		// --------------TO SUBMIT THE RECORD---------------//
	
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(), 60, 500);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(83);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// ***************@KUBS_PC_UAT_003_003*******************//

	@Then("^Click on Extra Add button$")
	public void click_on_extra_add_button() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_ExtraAdd(), 60, 500);
		pettyCashObj.Reimbursement_ExtraAdd().click();
	}

	@And("^Choose Multiple Expense Code$")
	public void choose_multiple_expense_code() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_expenseCode1(), 60, 500);
		pettyCashObj.Reimbursement_expenseCode1().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Expense2(), 60, 500);
		pettyCashObj.Reimbursement_Expense2().click();
	}

	@Then("^Enter Multiple Reimbursement Amount$")
	public void enter_multiple_reimbursement_amount() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Reimbursement_Amount1(), 60, 500);
		pettyCashObj.Reimbursement_Reimbursement_Amount1().click();
		pettyCashObj.Reimbursement_Reimbursement_Amount1().clear();
		pettyCashObj.Reimbursement_Reimbursement_Amount1().sendKeys(pettyData.ReimburseAmount);
	}

	@And("^Enter Multiple Reimbursement Remarks$")
	public void enter_multiple_reimbursement_remarks() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, pettyCashObj.Reimbursement_Remark1(), 60, 500);
		pettyCashObj.Reimbursement_Remark1().click();
		pettyCashObj.Reimbursement_Remark1().sendKeys(pettyData.Remarks);
	}

}
