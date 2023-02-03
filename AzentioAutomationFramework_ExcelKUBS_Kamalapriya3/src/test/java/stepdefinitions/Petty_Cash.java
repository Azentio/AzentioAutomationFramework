package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.FixedAsset_ReportsObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.PettyCash_ReconciliationObj;
import pageobjects.Petty_Cash_Obj;
import resources.BaseClass;
import resources.ExcelData;
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
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	PettyCash_ReconciliationObj ReconciliationObj = new PettyCash_ReconciliationObj(driver);
	FixedAsset_ReportsObj fixedAsset_ReportsObj = new FixedAsset_ReportsObj(driver);

	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	PETTY_PettyCash_Data pettyData = jsonConfig.getPettycashByName("Pettycash");
	ExcelData excelData = new ExcelData(System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx","PettyCash","DataSet ID");
	//String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	Map<String, String> testData;


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
	 @And("^Get the data set id for reimbursement in maker$")
	    public void get_the_data_set_id_for_reimbursement_in_maker() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_003_001_D1");

	 }
	   @And("^Choose the data set id reimbursement for multiple expense code$")
	    public void choose_the_data_set_id_reimbursement_for_multiple_expense_code() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_003_003_D1");

	   }
	   @And("^Get the data set id for reconciliation in reviewer$")
	    public void get_the_data_set_id_for_reconciliation_in_reviewer() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_005_002_D1");
	    }

	   @Then("^Get the data set id for fund request in petty cash$")
	    public void get_the_data_set_id_for_fund_request_in_petty_cash() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_004_001-D1");
	    }
	 @Then("^Get the data set id for custodian limit in petty cash$")
	    public void get_the_data_set_id_for_custodian_limit_in_petty_cash() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_001_003_D1");
	    }
	@And("^Get the data set id for expence code in petty cash in maker$")
    public void get_the_data_set_id_for_expence_code_in_petty_cash_in_maker() throws Throwable {
    	testData = excelData.getTestdata("KUBS_PC_UAT_001_001-D1");

	}
	 @Then("^Get the data set id for employee limit as a maker$")
	    public void get_the_data_set_id_for_employee_limit_as_a_maker() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_001_002_D1");
	    }
	 @And("^Choose the data set id for fund request in petty cash as a maker$")
	    public void choose_the_data_set_id_for_fund_request_in_petty_cash_as_a_maker() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_002_001_D1");
	    }

	@And("^Enter Expense code value$")
	public void enter_expense_code_value() throws Throwable {
		// -------EXPENSE CODE VALUE------//
		Random ran = new Random();
		int random = ran.nextInt(500-50)+50;
		//waitHelper.waitFoElementwithFluentwait(driver,  pettyCashObj.Petty_Cash_ExpenseCode());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, pettyCashObj.Petty_Cash_ExpenseCode(), 60, 500);
		//pettyCashObj.Petty_Cash_ExpenseCode().sendKeys(pettyData.ExpenseCode+random);
		pettyCashObj.Petty_Cash_ExpenseCode().sendKeys(testData.get("ExpenseCode")+random);

	}

	@Then("^Enter Expense Name Value$")
	public void enter_expense_name_value() throws Throwable {
		// -------EXPENSE NAME VALUE-------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_ExpenseName(), 60, 500);
		//pettyCashObj.Petty_Cash_ExpenseName().sendKeys(pettyData.ExpenseName);
		pettyCashObj.Petty_Cash_ExpenseName().sendKeys(testData.get("ExpenseName"));

	}

	@And("^Choose Expense Gl$")
	public void choose_expense_gl() throws Throwable {
		// ------CHOOSE EXPENSE GL------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Gl(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Gl().click();
		//pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(pettyData.ExpenseGl);
		pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(testData.get("ExpenseGl"));
		pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Max Limit Value$")
	public void enter_max_limit_value() throws Throwable {
		// --------ENTER MAX LIMIT VALUE------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Max_Limit(), 60, 500);
		//pettyCashObj.Petty_Cash_Max_Limit().sendKeys(pettyData.MaxLimit);
		pettyCashObj.Petty_Cash_Max_Limit().sendKeys(testData.get("MaxLimit"));

	}

	@And("^Choose Currency value$")
	public void choose_currency_value() throws Throwable {
		// --------CHOOSE CURRENCY VALUE-----//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Currency(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Currency().click();
		//pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(pettyData.Currency);
		pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(testData.get("Currency"));
		pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(Keys.ENTER);
	}

	@Then("^save Record in Petty cash$")
	public void save_record_in_petty_cash() throws Throwable {
		// --------SAVE THE RECORD-------//
//		javaScriptHelper.JavaScriptHelper(driver);
//		javaScriptHelper.JSEClick(pettyCashObj.Petty_Cash_Expense_Save());
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Petty_Cash_Expense_Save(), 60, 500);
		pettyCashObj.Petty_Cash_Expense_Save().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.ARAP_MakerNotification_Close(), 60, 500);
		pettyCashObj.ARAP_MakerNotification_Close().click();

		Thread.sleep(4000);
	}
	 @And("^Store the Referance Id and Open the Record in petty cash$")
	    public void store_the_referance_id_and_open_the_record_in_petty_cash() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_001_001-D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}
			 
	 }
		
	 }
	 @And("^Store the Referance Id and Open the Record for employee limit in petty cash$")
	    public void store_the_referance_id_and_open_the_record_for_employee_limit_in_petty_cash() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_001_002_D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}
			 
	 }
	 }
	 @And("^Store the Referance Id and Open the Record for Custodian Limit in petty cash$")
	    public void store_the_referance_id_and_open_the_record_for_custodian_limit_in_petty_cash() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_001_003_D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}
			 
	 }
	 }
	 @And("^Store the Referance Id and Open the Record for fund request in petty cash$")
	    public void store_the_referance_id_and_open_the_record_for_fund_request_in_petty_cash() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_002_001_D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}
			 
	 }	    
			}
	 
	 @And("^Store the Referance Id and Open the Record for reimbuursement in petty cash$")
	    public void store_the_referance_id_and_open_the_record_for_reimbuursement_in_petty_cash() throws Throwable {
			 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
				String Referance_id = arapObj.ARAP_ReferanceId().getText();
				excelData.updateTestData("KUBS_PC_UAT_003_001_D1", "Reference ID", Referance_id);
				for (int i = 0; i < 20; i++) {
					try {
						// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
						arapObj.ARAP_ActionButton().click();
					} catch (Exception e) {
					}
				 
		 }	    
			
	 }
	 @And("^Store the Referance Id and Open the Record for fund request2 in petty cash$")
	    public void store_the_referance_id_and_open_the_record_for_fund_request2_in_petty_cash() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_004_001-D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}
			 
	 }	    
		
	 }
	 @And("^Store the Referance Id and Open the Record reimbursement for multiple expense code$")
	    public void store_the_referance_id_and_open_the_record_reimbursement_for_multiple_expense_code() throws Throwable {
		 waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
			String Referance_id = arapObj.ARAP_ReferanceId().getText();
			excelData.updateTestData("KUBS_PC_UAT_003_003_D1", "Reference ID", Referance_id);
			for (int i = 0; i < 20; i++) {
				try {
					// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
					arapObj.ARAP_ActionButton().click();
				} catch (Exception e) {
				}	   
				}
	 }


	 @Then("^Get the reviewer id for expence code and store it in excel$")
	    public void get_the_reviewer_id_for_expence_code_and_store_it_in_excel() throws Throwable {
		 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
			reviwerId = arapObj.ARAP_ReviewerId().getText();
			String trimmdReviewerID = reviwerId.substring(85);
			StringBuffer sb = new StringBuffer(trimmdReviewerID);
			StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
			String filanReviewerID = bufferedString.toString();
			// arapObj.arapObj_reviewer_id().getText());
			//json.addData(filanReviewerID);
						excelData.updateTestData("KUBS_PC_UAT_001_001-D1", "Reviewer ID", filanReviewerID);
						System.out.println(filanReviewerID);
	    }
	 @Then("^Get the reviewer id for employee limit and store it in excel$")
	    public void get_the_reviewer_id_for_employee_limit_and_store_it_in_excel() throws Throwable {
		 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
			reviwerId = arapObj.ARAP_ReviewerId().getText();
			String trimmdReviewerID = reviwerId.substring(85);
			StringBuffer sb = new StringBuffer(trimmdReviewerID);
			StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
			String filanReviewerID = bufferedString.toString();
			// arapObj.arapObj_reviewer_id().getText());
			//json.addData(filanReviewerID);
						excelData.updateTestData("KUBS_PC_UAT_001_002_D1", "Reviewer ID", filanReviewerID);
						System.out.println(filanReviewerID);
	 
	 }
	 @Then("^Get the reviewer id for Custodian limit and store it in excel$")
	    public void get_the_reviewer_id_for_custodian_limit_and_store_it_in_excel() throws Throwable {
		 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
			reviwerId = arapObj.ARAP_ReviewerId().getText();
			String trimmdReviewerID = reviwerId.substring(85);
			StringBuffer sb = new StringBuffer(trimmdReviewerID);
			StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
			String filanReviewerID = bufferedString.toString();
			// arapObj.arapObj_reviewer_id().getText());
			//json.addData(filanReviewerID);
						excelData.updateTestData("KUBS_PC_UAT_001_003_D1", "Reviewer ID", filanReviewerID);
						System.out.println(filanReviewerID);
	 }
	 
	  @Then("^Get the reviewer id for fund request and store it in excel$")
	    public void get_the_reviewer_id_for_fund_request_and_store_it_in_excel() throws Throwable {
			 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
				reviwerId = arapObj.ARAP_ReviewerId().getText();
				String trimmdReviewerID = reviwerId.substring(86);
				StringBuffer sb = new StringBuffer(trimmdReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				// arapObj.arapObj_reviewer_id().getText());
				//json.addData(filanReviewerID);
							excelData.updateTestData("KUBS_PC_UAT_002_001_D1", "Reviewer ID", filanReviewerID);
							System.out.println(filanReviewerID);	 
							}
	  @Given("^Navigate as a Reviewer in petty cash$")
	    public void navigate_as_a_reviewer_in_petty_cash() throws Throwable {
		  kubsLogin = new KUBS_Login(driver);
			String UserID = "Reviewer";
			System.out.println(UserID);
				driver.get(configFileReader.getApplicationUrl());
				//kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
				kubsLogin.logintoAzentioappReviewer(UserID, testData.get("Reviewer ID"));

	  }

	    @Then("^Get the reviewer id for reimburesement and store it in excel$")
	    public void get_the_reviewer_id_for_reimburesement_and_store_it_in_excel() throws Throwable {
	    	 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
				reviwerId = arapObj.ARAP_ReviewerId().getText();
				String trimmdReviewerID = reviwerId.substring(83);
				StringBuffer sb = new StringBuffer(trimmdReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				// arapObj.arapObj_reviewer_id().getText());
				//json.addData(filanReviewerID);
							excelData.updateTestData("KUBS_PC_UAT_003_001_D1", "Reviewer ID", filanReviewerID);
							System.out.println(filanReviewerID);	 
					}
	    @Then("^Get the reviewer id for reimburesement of multiple expense code and store it in excel$")
	    public void get_the_reviewer_id_for_reimburesement_of_multiple_expense_code_and_store_it_in_excel() throws Throwable {
	    	 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
				reviwerId = arapObj.ARAP_ReviewerId().getText();
				String trimmdReviewerID = reviwerId.substring(83);
				StringBuffer sb = new StringBuffer(trimmdReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				// arapObj.arapObj_reviewer_id().getText());
				//json.addData(filanReviewerID);
							excelData.updateTestData("KUBS_PC_UAT_003_003_D1", "Reviewer ID", filanReviewerID);
							System.out.println(filanReviewerID);	
							}
	    @Then("^Get the reviewer id for fund request2 and store it in excel$")
	    public void get_the_reviewer_id_for_fund_request2_and_store_it_in_excel() throws Throwable {
	    	 waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
				reviwerId = arapObj.ARAP_ReviewerId().getText();
				String trimmdReviewerID = reviwerId.substring(86);
				StringBuffer sb = new StringBuffer(trimmdReviewerID);
				StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
				String filanReviewerID = bufferedString.toString();
				// arapObj.arapObj_reviewer_id().getText());
				//json.addData(filanReviewerID);
							excelData.updateTestData("KUBS_PC_UAT_004_001-D1", "Reviewer ID", filanReviewerID);
							System.out.println(filanReviewerID);	
							}	    

	 // @Then("^choose the data set id for fund request in petty cash as a reviewer$")
	   // public void choose_the_data_set_id_for_fund_request_in_petty_cash_as_a_reviewer() throws Throwable {
	  //  	testData = excelData.getTestdata("KUBS_PC_UAT_002_001_D1");

	// }

	    

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
		pettyCashObj.Petty_Cash_Employee().sendKeys(testData.get("EmployeeValue"));
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
		pettyCashObj.Petty_Cash_Employee_Currancy().sendKeys(testData.get("Currency"));
		pettyCashObj.Petty_Cash_Employee_Currancy().sendKeys(Keys.ENTER);
	}

	@And("^Close the Alert$")
	public void close_the_alert() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  checkerObj.checker_alert_close(), 60, 500);
		checkerObj.checker_alert_close().click();
		Thread.sleep(2000);
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
		pettyCashObj.costodianLimitUserName().sendKeys(testData.get("CustodianLimit"));
		pettyCashObj.costodianLimitUserName().sendKeys(Keys.DOWN);
		pettyCashObj.costodianLimitUserName().sendKeys(Keys.ENTER);
	}

	@And("^give maximum limit$")
	public void give_maximum_limit() throws Throwable {
		pettyCashObj.costodianLimitMaxLimit().click();
		pettyCashObj.costodianLimitMaxLimit().sendKeys(testData.get("MaxLimit"));
	}

	@And("^give replenish limit$")
	public void give_replenish_limit() throws Throwable {
		pettyCashObj.costodianLimitReplenishLimit().click();
		pettyCashObj.costodianLimitReplenishLimit().sendKeys(testData.get("ReplenishLimit"));
	}

	@And("^enter the currency type$")
	public void enter_the_currency_type() throws Throwable {
		pettyCashObj.costodianLimitCurrencyLimit().click();
		pettyCashObj.costodianLimitCurrencyLimit().sendKeys(testData.get("Currency"));
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
		pettyCashObj.enterRequestAmout().sendKeys(testData.get("RequestAmount"));
	}

	@Then("^Enter Petty cash Remark$")
	public void enter_petty_cash_remark() throws Throwable {
		pettyCashObj.enterRemark().click();
		pettyCashObj.enterRemark().sendKeys(testData.get("Remarks"));
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
		pettyCashObj.Reimbursement_Reimbursement_Amount().sendKeys(testData.get("ReimburseAmount"));
	}

	@And("^Enter Reimbursement Remarks$")
	public void enter_reimbursement_remarks() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.Reimbursement_Remark(), 60, 500);
		pettyCashObj.Reimbursement_Remark().click();
		pettyCashObj.Reimbursement_Remark().sendKeys(testData.get("Remarks"));
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
	@Then("^Get the Checker id and store it in a excel for checker$")
    public void get_the_checker_id_and_store_it_in_a_excel_for_checker() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(), 60, 500);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(83);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
		//json.addData(filanReviewerID);
		
		System.out.println(reviwerId);    }


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
		pettyCashObj.Reimbursement_Reimbursement_Amount1().sendKeys(testData.get("MultiReimbursement"));
	}

	@And("^Enter Multiple Reimbursement Remarks$")
	public void enter_multiple_reimbursement_remarks() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, pettyCashObj.Reimbursement_Remark1(), 60, 500);
		pettyCashObj.Reimbursement_Remark1().click();
		pettyCashObj.Reimbursement_Remark1().sendKeys(testData.get("MultiReimbursementRemark"));
	}
	
	@And("^Get the data set id for expence code in petty cash$")
    public void get_the_data_set_id_for_expence_code_in_petty_cash() throws Throwable {
    	testData = excelData.getTestdata("KUBS_PC_UAT_001_001-D1");
    }
	 @Then("^Get the data set id for employee limit as reviewer$")
	    public void get_the_data_set_id_for_employee_limit_as_reviewer() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_001_002_D1");
	    }
	 @And("^Get the data set id for the custodaian limit reviewer approval$")
	    public void get_the_data_set_id_for_the_custodaian_limit_reviewer_approval() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_001_003_D1");
	    }
	 @And("^Get the data set id for reimbursement in petty cash for reviewer$")
	    public void get_the_data_set_id_for_reimbursement_in_petty_cash_for_reviewer() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_003_001_D1");

	  }

	    @And("^choose the data set id for reimbursement for multiple expense code as reviewer$")
	    public void choose_the_data_set_id_for_reimbursement_for_multiple_expense_code_as_reviewer() throws Throwable {
	    	    	testData = excelData.getTestdata("KUBS_PC_UAT_003_003_D1");
	    }
	    @Then("^Get the data set id for fund request2 as a reviewer$")
	    public void get_the_data_set_id_for_fund_request2_as_a_reviewer() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_PC_UAT_004_001-D1");
	    }

		  @Then("^choose the data set id for fund request in petty cash as a reviewer$")
		    public void choose_the_data_set_id_for_fund_request_in_petty_cash_as_a_reviewer() throws Throwable {
		    	testData = excelData.getTestdata("KUBS_PC_UAT_002_001_D1");

		 }

	@Given("^Navigate as a Reviewer$")
	public void navigate_as_a_reviewer() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
	String UserID = "Reviewer";
		driver.get(configFileReader.getApplicationUrl());
		//kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
		kubsLogin.logintoAzentioappReviewer(UserID, testData.get("Reviewer ID"));

	}
	@Given("^Navigate as a Reviewer for fund request$")
    public void navigate_as_a_reviewer_for_fund_request() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		String UserID = "Reviewer";
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer(UserID, testData.get("Reviewer ID"));    
			}


@And("^Click First record Action icon$")
public void click_first_record_action_icon() throws Throwable {
	// -----------REVIEWER ACTION-------------//
	javaScriptHelper.JavaScriptHelper(driver);
	String befr_xpath = "//span[contains(text(),'";
	String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
	waitHelper.waitForElement(driver, 2000,
			driver.findElement(By.xpath(befr_xpath + testData.get("Reference ID") + aftr_xpath)));
	driver.findElement(By.xpath(befr_xpath + testData.get("Reference ID") + aftr_xpath)).click();

	// reviewerObj.reviewer_action_button().click();
}
@And("^Get the system data for petty cash$")
public void get_the_system_data_for_petty_cash() throws Throwable {
	waitHelper.waitForElementToVisibleWithFluentWait(driver,pettyCashObj.systemDate(), 30, 2);
    String systemdate = pettyCashObj.systemDate().getText();
System.out.println(systemdate);
String[] split = systemdate.split("-");
String date = split[0];
testData.put("Date", date);
//  System.out.println(date);
String month = split[1];
testData.put("ToMonth", month);
//  System.out.println(month);
String year = split[2];
testData.put("Year", year);
//  System.out.println(year);
String fullMonth;
switch (month) {
case "Jan":
fullMonth = "January";
break;
case "Feb":
fullMonth = "February";
break;
case "Mar":
fullMonth = "March";
break;
case "Apr":
fullMonth = "April";
break;
case "May":
fullMonth = "May";
break;
case "Jun":
fullMonth ="June";
break;
case "Jul":
fullMonth = "July";
break;
case "Aug":
fullMonth ="August";
break;
case "Sep":
fullMonth = "September";
break;
case "Oct":
fullMonth = "October";
break;
case "Nov":
fullMonth = "November";
break;
case "Dec":
fullMonth = "December";
break;
default:
 fullMonth = "InvalidMonth";
break;
}
testData.put("FullMonth", fullMonth);
}
//----------KUBS_PC_UAT_004_002-------


@Then("^choose from date in calender for petty cashs$")
public void choose_from_date_in_calender_for_petty_cashs() throws Throwable {
	javaScriptHelper.JavaScriptHelper(driver);
	while (true) {
		try {

			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"/+ pettyCashTestDataType.GlMonth + " " + pettyCashTestDataType.GlYear + "')]")));
			WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
					+ testData.get("ToMonth") + " " + testData.get("Year") + "')]"));
			break;
		}

		catch (NoSuchElementException nosuchElement) {
			inventoryManagamentObj.inventoryNextMonth().click();
		}
	}
	WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
			+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
	clickAndActionHelper.doubleClick(FinalDay);
}



@Then("^choose the To date in calender for petty cashs$")
public void choose_the_to_date_in_calender_for_petty_cashs() throws Throwable {
	while (true) {
		try {

			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"/+ pettyCashTestDataType.GlToMonth + " " + pettyCashTestDataType.GlToYear + "')]")));
			WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
					+ testData.get("ToMonth") + " " + testData.get("Year") + "')]"));
			break;
		}

		catch (NoSuchElementException nosuchElement) {
			inventoryManagamentObj.inventoryNextMonth().click();
		}
	}
	waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth")
			+ " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")),20, 500);
	WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth")
			+ " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
	clickAndActionHelper.doubleClick(FinalDay);
}
@And("^choose branchs code Id$")
public void choose_branch_code_Id() throws Throwable {
	//inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
	// -----------CLICK ON BRANCH CODE------------//
	inventoryManagamentObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
	inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
}
@Then("^Get the data set id for GL entries$")
public void get_the_data_set_id_for_gl_entries() throws Throwable {
	testData = excelData.getTestdata("KUBS_PC_UAT_004_001-D1");

}
@And("^Fill the required fields for reconciliations$")
public void fill_the_required_fields_for_reconciliations()  {
	waitHelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.PettyCash_Reconciliation_PhysicalCashInHand(), 60, 500);
	ReconciliationObj.PettyCash_Reconciliation_PhysicalCashInHand().sendKeys(testData.get("PhysicalCashInHand"));
	ReconciliationObj.PettyCash_Reconciliation_Currency().sendKeys(testData.get("Currency"));
}
@Then("^Get the data set id for reconciliation$")
public void get_the_data_set_id_for_reconciliation() throws Throwable {
	testData = excelData.getTestdata("KUBS_PC_UAT_005_002_D1");

}
@And("^Store the Referance Id and Open the Record for reconciliation in petty cash$")
public void store_the_referance_id_and_open_the_record_for_reconciliation_in_petty_cash() throws Throwable {
	waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
	String Referance_id = arapObj.ARAP_ReferanceId().getText();
	excelData.updateTestData("KUBS_PC_UAT_005_002_D1", "Reference ID", Referance_id);
	for (int i = 0; i < 20; i++) {
		try {
			// waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
			arapObj.ARAP_ActionButton().click();
		} catch (Exception e) {
		}
}
}
@Then("^Get the reviewer id for reconciliation and store it in excel$")
public void get_the_reviewer_id_for_reconciliation_and_store_it_in_excel() throws Throwable {
	waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
	reviwerId = arapObj.ARAP_ReviewerId().getText();
	String trimmdReviewerID = reviwerId.substring(83);
	StringBuffer sb = new StringBuffer(trimmdReviewerID);
	StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
	String filanReviewerID = bufferedString.toString();
	// arapObj.arapObj_reviewer_id().getText());
	//json.addData(filanReviewerID);
				excelData.updateTestData("KUBS_PC_UAT_005_002_D1", "Reviewer ID", filanReviewerID);
				System.out.println(filanReviewerID);	
				}
@And("^Click First record Action icon in employee limit$")
public void click_first_record_action_icon_in_employee_limit() throws Throwable {
	javaScriptHelper.JavaScriptHelper(driver);
	String befr_xpath = "//span[contains(text(),'";
	String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
	waitHelper.waitForElement(driver, 2000,
			driver.findElement(By.xpath(befr_xpath + testData.get("Reference ID") + aftr_xpath)));
	driver.findElement(By.xpath(befr_xpath + testData.get("Reference ID") + aftr_xpath)).click();
}
@And("^Claim the Record in Checker$")
public void claim_the_record_in_checker() throws Throwable {
	// -------------------------CLICK CLAIM OPTION-------------------------//
	String before_xpath = "//span[contains(text(),'";
	String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";

	// waitHelper.waitForElement(driver,
	// 10000,driver.findElement(By.xpath(before_xpath +
	// readerData.readReferancedata() + after_xpath_claim)));
	for (int i = 0; i < 20; i++) {
		try {
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
			break;
		} catch (Exception e) {

		}
	}

	waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
	checkerObj.checker_alert_close().click();
}@And("^select the date to check the fund requisitions details are displaying$")
public void select_the_date_to_check_the_fund_requisitions_details_are_displaying() throws InterruptedException {
	
	waitHelper.waitForElementToVisibleWithFluentWait(driver, ReconciliationObj.Reports_PettyCash_Calendar1(), 60, 500);
	ReconciliationObj.Reports_PettyCash_Calendar1().click();
	
	while (true) {
		try {

			waitHelper.waitForElement(driver, 3000, driver.findElement(
					By.xpath("//span[contains(text(),'" + testData.get("ToMonth") + " " + testData.get("Year") + "')]")));
			driver.findElement(
					By.xpath("//span[contains(text(),'" + testData.get("ToMonth") + " " + testData.get("Year") + "')]"));
			break;
		}

		catch (NoSuchElementException nosuchElement) {
			//ReconciliationObj.ARAPNextMonth().click();
 	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();


		}
	}
	waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
			+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
	WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
			+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

	clickAndActionHelper.doubleClick(Click);
			
}
}


