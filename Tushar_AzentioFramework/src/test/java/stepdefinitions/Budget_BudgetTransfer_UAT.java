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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class Budget_BudgetTransfer_UAT {
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
//-------------Budget_BudgetTransfer_UAT_006_001---------
	    @Given("^Maker login to KUBS UAT Url$")
	    public void maker_login_to_kubsuat_url() throws Throwable {
	    	 login = new AzentioLogin(driver);
				driver.get(configFileReader.getApplicationUrl());
				login.loginToAzentioApp("Maker");
	    }
	    @And("^Maker click on the direction tab in home page$")
	    public void maker_click_on_the_direction_tab_in_home_page() throws Throwable {
	    	waithelper = new WaitHelper(driver);
			budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
	    }

	    @Then("^Maker click on budget$")
	    public void maker_click_on_budget() throws Throwable {
	    	
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetField());
			budgetTransferObj.budget_BudgetTransfer_BudgetField().click();
	    }

	    @Then("^Maker click on budget transfer eye button$")
	    public void maker_click_on_budget_transfer_eye_button() throws Throwable {
	    	  waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
				budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
	    }

	  

	    @And("^Maker click on add button to create new record$")
	    public void maker_click_on_add_button_to_create_new_record() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
			budgetTransferObj.budget_BudgetTransfer_AddButton().click();
		    

	}
	    @Then("^Maker fill the details$")
	    public void maker_fill_the_details() throws Throwable {
	    	//Budget code
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
			
			//Year
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
			
			//Branch
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
			budgetTransferObj.budget_BudgetTransfer_Branch().click();
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);
			 
			//Transfer to Budget code
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
			
			//Currency
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);
			
			//Apportioned Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
			
			//New Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();
			
			//Apportioned Amount B
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferTestDataType.ApportionedAmountB);
			
			//New Amount B
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
			budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();
			
			
	    }

	    @And("^save the record$")
	    public void save_the_record() throws Throwable {
	    	//Save
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
			budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
			Thread.sleep(2000);
	        javascripthelper.JavaScriptHelper(driver);
	        String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	        System.out.println("Message:" +str);	
	    }
	    //--------------Budget_BudgetTransfer_UAT_006_007-----------
	    @Then("^fill the form and enter excessive budget amount to the transfer$")
	    public void fill_the_form_and_enter_excessive_budget_amount_to_transfer()   {
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
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountAExcessive);
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

	 
			
			javahelper.JavaScriptHelper(driver);
			String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
			//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
			String str = javahelper.executeScript(script).toString();
			System.out.println(str);
	    }
	    //-------Budget_BudgetTransfer_UAT_006_002---------
	    //Budget code needs to be changed as currently budgetcodes are changed in product
	    @Then("^Maker fill the details of same record$")
	    public void maker_fill_the_details_of_same_record() throws Throwable {
	    	//Budget code
			budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
			
			//Year
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
			
			//Branch
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
			budgetTransferObj.budget_BudgetTransfer_Branch().click();
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);
			 
			//Transfer to Budget code
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
			
			//Currency
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);
			
			//Apportioned Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
			
			//New Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();
			
			//Apportioned Amount B
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferTestDataType.ApportionedAmountB);
			
			//New Amount B
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
			budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();
	    }

	    
	    
	    
	    
	    
}
