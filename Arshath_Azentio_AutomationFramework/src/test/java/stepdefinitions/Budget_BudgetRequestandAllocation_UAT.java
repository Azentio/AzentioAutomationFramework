package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class Budget_BudgetRequestandAllocation_UAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	WaitHelper waitHelper;
	String reviwerId;
	BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javaHelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	String referance_id;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubsChecker = new KUBS_CheckerObj(driver);

	@Given("^Navigate to the Azentio Url$")
	public void navigate_to_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^click the Two Direction Icon$")
	public void click_the_two_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^click to the Budget$")
	public void click_to_the_budget() throws Throwable {

		// -----------TO CLICK THE BUDGET MODULE--------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^click on the Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void click_on_the_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {

		// ----------TO CLICK THE EYE ICON------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^click on the Add icon in Request and Allocation$")
	public void click_on_the_add_icon_in_request_and_allocation() throws Throwable {

		// ----------TO CREATE A NEW BUDGET AMOUNT------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^click on the Branch$")
	public void click_on_the_branch() throws Throwable {

		// ------------------------TO SELECT THE BRANCH-------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^select the Budget Year$")
	public void select_the_budget_year() throws Throwable {

		// ----------TO SELECT THE BUDGET YEAR---------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}
	@Then("^click on the Branch ok button$")
	public void click_on_the_branch_ok_button() throws Throwable {

		// -------------------------TO CLICK BRANCH OK BUTTON-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}
	
	@Then("^select one currency we need$")
	public void select_one_currency_we_need() throws Throwable {

		// -------------------------TO SELECT THE CURRENCY WE
		// NEED---------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}
	
	@Then("^click on the Maker icon button$")
	public void click_on_the_maker_icon_button() throws Throwable {

		// ---------------------------TO CLICK THE MAKER
		// NOTIFICATION------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^click on the save button$")
	public void click_on_the_save_button() throws Throwable {

		// ------------TO SAVE THE RECORD--------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@And("^click on the Record submit$")
	public void click_on_the_record_submit() throws Throwable {

		// -------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(requestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// ------------------------@KUBS_UAT_Monthly_KUBS_BP_UAT_002_001----------------------//

	@Then("^select the Budget Code$")
	public void select_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Monthly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}



	@And("^select to one Branch$")
	public void select_to_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^Enter the Amount for Monthly Budget type$")
	public void enter_the_amount_for_monthly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);

		// ----------------------------THIS CODE FOR MONTHLY
		// BUDGET-------------------------//

		javaHelper.JavaScriptHelper(driver);
		javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
				.sendKeys(requestAndAllocationTestData.Remark);
	}

	
	//----------------------------@KUBS_UAT_Quarterly_KUBS_BP_UAT_002_002----------------------//
	
	
    @Then("^select to Budget Code$")
    public void select_to_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Quarterly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
    }
    
    @And("^select the one Branch$")
    public void select_the_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
    }
    
    @And("^Enter the Amount for Quarterly Budget type$")
    public void enter_the_amount_for_quarterly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		
		// ----------------------------THIS CODE FOR QUARTERLY BUDGET---------------------------//

		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
				.sendKeys(requestAndAllocationTestData.Remark);
    }
	
	//------------------------@KUBS_UAT_Halfyearly_KUBS_BP_UAT_002_003------------------------//
    
    @Then("^Choose to Budget Code$")
    public void choose_to_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Halfyearly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
    }

    @And("^select the Branch$")
    public void select_the_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
    }

    @And("^Enter the Amount for Halfyearly Budget type$")
    public void enter_the_amount_for_halfyearly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		
    	// ---------------------------------THIS CODE FOR HALFYEARLY BUDGET-------------------------//

    				javaHelper.JavaScriptHelper(driver);
    				waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
    				javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
    				waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
    				requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
    						.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
    				waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
    				requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
    						.sendKeys(requestAndAllocationTestData.Remark);

    				waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
    				javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
    				javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
    				waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
    				requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
    						.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
    				requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
    						.sendKeys(requestAndAllocationTestData.Remark);
    }
	
	//---------------------------@KUBS_UAT_yearly_KUBS_BP_UAT_002_004--------------------//
	
	
    @Then("^Choose to the Budget Code$")
    public void choose_to_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Yearly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
    }

    @And("^Choose to the one Branch$")
    public void choose_to_the_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
    }

    @And("^Enter the Amount for yearly Budget type$")
    public void enter_the_amount_for_yearly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		
			// ---------------------------THIS CODE FOR YEARLY BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
    }
	
	
	//--------------------------@KUBS_UAT_BudgetApprove_KUBS_BP_UAT_002_005------------------------//
	
    @Then("^To Select the Budget Code$")
    public void to_select_the_budget_code() throws Throwable {
        
    }

    @And("^Choose the one Branch$")
    public void choose_the_one_branch() throws Throwable {
        
    }

    @And("^Give Amount for Budget Type Show in Budget type field$")
    public void give_amount_for_budget_type_show_in_budget_type_field() throws Throwable {
        
    }
	
	
}
