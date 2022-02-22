package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class BUDGET_BudgetTransferUAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javahelper = new JavascriptHelper();
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	AzentioLogin login;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	String referance_id;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	 @Then("^fill form and enter excessive budget amount to transfer$")
	    public void fill_form_and_enter_excessive_budget_amount_to_transfer() {
	    	budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			// Budget code
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCode);
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
			// budget Year
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferTestDataType.BudgetYear);
			budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
			// budget Branch
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
			budgetTransferObj.budget_BudgetTransfer_Branch().click();
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferTestDataType.Branch);
			budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

			// transfer to budget code
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
					.sendKeys(budgetTransferTestDataType.TransferToBudgetCode);
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
			// currency
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

			// apportioned amount
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountAExcessive);
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

			

			javahelper.JavaScriptHelper(driver);
			String script = "return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
			// document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
			String str = javahelper.executeScript(script).toString();
			System.out.println(str);
	    	
	        
	    }


}
