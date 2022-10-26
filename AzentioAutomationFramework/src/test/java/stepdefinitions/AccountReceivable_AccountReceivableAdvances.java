package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.AccountReceivable_AccountReceivableAdvancesObj;
import resources.BaseClass;
import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.AccountReceivable_AccountReceivableAdvancesTestDataType;

public class AccountReceivable_AccountReceivableAdvances extends BaseClass { 
WebDriver driver = BaseClass.driver;
JsonConfig jsonReader = new JsonConfig();
ConfigFileReader configFileReader = new ConfigFileReader();
ConfigFileReader config=new ConfigFileReader();
DropDownHelper dropDownHelper;
WaitHelper waithelper = new WaitHelper(driver) ;
// maker//
JavascriptHelper javascripthelper = new JavascriptHelper();
	
AccountReceivable_AccountReceivableAdvancesObj accountReceivable_AccountReceivableAdvancesObj = new AccountReceivable_AccountReceivableAdvancesObj(driver);

AccountReceivable_AccountReceivableAdvancesTestDataType accountReceivable_AccountReceivableAdvancesTestDataType = new AccountReceivable_AccountReceivableAdvancesTestDataType();

	
	
	

	@Then("^Click on Account Recivable button$")
	public void click_on_account_recivable_button() throws Throwable {
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_AccountReceivableButton());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_AccountReceivableButton().click();
    }

    @Then("^Click on Account Recivable Advances eye button$")
    public void click_on_account_recivable_advances_eye_button() throws Throwable {
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EyeButton());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EyeButton().click();
    }

    @Then("^Click to add record in Account Recivable$")
    public void click_to_add_record_in_account_recivable() throws Throwable {
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_AddButton());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_AddButton().click();  
    }
    
    @Then("^Fill the form for Account Recivable$")
    public void fill_the_form_for_account_recivable() throws Throwable {
    	accountReceivable_AccountReceivableAdvancesTestDataType = jsonReader.getAccountReceivableAdvancesByName("Maker");
    	//EntityBranch
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.EntityBranch);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().sendKeys(Keys.ENTER);
    	
    	//ReceivableName
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.ReceivableName);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(Keys.ENTER);
    	
    	//EmployeeName
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.EmployeeName);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(Keys.ENTER);
    	
    	//PaymentMode
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.PaymentMode);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(Keys.ENTER);
    	
    	//Amount
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.Amount);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(Keys.ENTER);
    	
    	//Currency
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.Currency);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(Keys.ENTER);
    	
    	//CostCenter
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.CostCenter);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	
    	//Description
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().click();
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().sendKeys(accountReceivable_AccountReceivableAdvancesTestDataType.Description);
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    }
    

    @Then("^Click on save button to save the Record for Account Recivable$")
    public void click_on_save_button_to_save_the_record_for_account_recivable() throws InterruptedException  {
    	
    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Save());
    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Save().click();
    	Thread.sleep(2000);
        javascripthelper.JavaScriptHelper(driver);
        String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
        System.out.println("Message:" +str);
        Thread.sleep(4000);
    }

}
