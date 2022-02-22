package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class Budget_BusgetTransfer_BP_BT_UAT {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper;
	JavascriptHelper javahelper = new JavascriptHelper();
	BUDGET_BudgetTransferObj budgetTransferObj;
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	AzentioLogin login; 
	 
	ConfigFileReader config=new ConfigFileReader();
	KUBS_ReviewerObj reviewer;
	 
	BrowserHelper browserHelper;	 
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig=new JsonConfig();
	//--------------------------------------common-------------------------------------------
	 
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	String referance_id;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

//-----------Budget_BusgetTransfer_BP_BT_UAT_006_001--------
    @When("^User login to maker$")
    public void user_login_to_maker() throws InterruptedException  {
    	login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }

    @Then("^click on configuration$")
    public void click_on_configuration()   {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

    }

    @And("^click on finance$")
    public void click_on_finance()  {
      
    }

    @Then("^click on direction button$")
    public void click_on_direction_button()   {
      
    }
    @And("^Budget button$")
    public void budget_button()   {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

    }
    @Then("^Click on budget transfer eye button$")
    public void click_on_budget_transfer_eye_button() throws Throwable {
    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
		budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
    }

    @Then("^click on add buttion$")
    public void click_on_add_buttion()   {
    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
		budgetTransferObj.budget_BudgetTransfer_AddButton().click();
    }

    @Then("^fill the form$")
    public void fill_the_form() throws Throwable {
    	dropDownHelper = new DropDownHelper(driver);
		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
		budgetTransferObj.budget_BudgetTransfer_Branch().click();

		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
				.sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
		budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferTestDataType.ApportionedAmountB);
		

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
		budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();


    }
    @And("^save the form$")
    public void save_the_form() throws Throwable {

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
		budgetTransferObj.budget_BudgetTransfer_SaveButton().click();

    }
    @Then("^form should get save$")
    public void form_should_get_save() throws Throwable {
        
    }

 
    
   

   
    

    
}
