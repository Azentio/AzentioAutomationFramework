package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetTransferObj;
import resources.BaseClass;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class Budget_BudgetTransfer_BP_BT_UAT_006_007 {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper;
	JavascriptHelper javahelper = new JavascriptHelper();
	BUDGET_BudgetTransferObj budgetTransferObj;
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	KUBS_Login login;
    @When("^user login into maker stage$")
    public void user_login_into_maker_stage() throws Throwable {
    	login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }

    @Then("^user click on configuration$")
    public void user_click_on_configuration()  {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

    }

    @Then("^user click on the finance button$")
    public void user_click_on_the_finance_button()   {
         
    }

    @Then("^click on direction$")
    public void click_on_direction()   {
       
    }

    @Then("^click on budget button$")
    public void click_on_budget_button()  {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 5000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();
	
		
			 waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetField());
				budgetTransferObj.budget_BudgetTransfer_BudgetField().click();
    }

    @Then("^click on transfer eye button$")
    public void click_on_transfer_eye_button()   {
     	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
    		budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
       
    }

    @Then("^click on add button in transfer$")
    public void click_on_add_button_in_transfer()    {
    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
		budgetTransferObj.budget_BudgetTransfer_AddButton().click();
    
    }

    @Then("^fill the form and enter excessive budget amount to transfer$")
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

	
	/*	public class ShadowDom extends BaseClass{
		WebDriver driver=BaseClass.driver;
		JavascriptHelper javascripthelper=new JavascriptHelper();
		WaitHelper waithelper=new WaitHelper(driver);
		WebElement element;
	
		
		BUDGET_BudgetTransferObj budgetTransfer=new BUDGET_BudgetTransferObj(driver);
		element=(WebElement)javascripthelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")")
		String str=element.getText();
		System.out.println("String message is :"+str")
		}*/
		
		javahelper.JavaScriptHelper(driver);
		String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
		//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
		String str = javahelper.executeScript(script).toString();
		System.out.println(str);
    }

}
