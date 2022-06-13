package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
	
	AzentioLogin login;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	String referance_id;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	 @Then("^fill form and enter excessive budget amount to transfer$")
	    public void fill_form_and_enter_excessive_budget_amount_to_transfer() throws InterruptedException {
	    	budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
			// Budget code
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
			budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferTestDataType.BudgetCodeQuarter);
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
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(budgetTransferTestDataType.TransferToBudgetCodeQuarter);
			budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
			Thread.sleep(2000);
			// currency
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferTestDataType.Currency);
			budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

			// apportioned amount
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountQuarter().sendKeys(budgetTransferTestDataType.ApportionedAmountAExcessive);
			Thread.sleep(3000);
			
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountQuarter().click();

			

			javahelper.JavaScriptHelper(driver);
			String script = "return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
			// document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
			Thread.sleep(1000);
			String str = javahelper.executeScript(script).toString();
			System.out.println(str);
	    	
	        
	    }
	 //-----------BudgetTransfer_KUBS_BP_UAT_006_004----------///
	 @Then("^Maker modify the amount$")
	    public void maker_modify_the_amount() throws Throwable {
		//Reference
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
	    	String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
	    	jsonWriter.addReferanceData(id);
	    	System.out.println("Reference ID:" +id);
	    	for (int i = 1; i <= 35; i++) {
				try {
			    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
					referanceID.click();
			    	System.out.println(referanceID);
			    	//Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) 
				{
					waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
					
					budgetTransferObj.maker_notification_next_button().click();
				}
			 
	    	waithelper.waitForElement(driver,4000,budgetTransferObj.maker_notification_next_button());
			
	    	budgetTransferObj.maker_notification_next_button().click();
	    	}
	    	budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();	    	
	    	
			 //Action-Pencil
			 String before_xpath="//span[contains(text(),'";
			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();

			Thread.sleep(2000);
			
			//Apportioned Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferTestDataType.ApportionedAmountA);
			
			//New Amount A
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
			budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();
			
			//Apportioned Amount B
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
			budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferTestDataType.ApportionedAmountB);
			
			//New Amount B
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
			budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();
			
			//Save
			waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
			budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
			Thread.sleep(2000);
	        javascripthelper.JavaScriptHelper(driver);
	        String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	        System.out.println("Message:" +str);
	    }


}
