package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

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
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Petty_Cash_Obj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;

public class Petty_Cash extends BaseClass{

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
	Map<String, String> Getdata =new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	Petty_Cash_Obj pettyCashObj = new Petty_Cash_Obj(driver);
	
	
	//*******************@KUBS_PC_UAT_001_001********************//
	

    @Then("^Click on Pettycash Configuration$")
    public void click_on_pettycash_configuration() throws Throwable {
        //------PETTY CASH CONFIGURATION-------//
    	javaScriptHelper.JavaScriptHelper(driver);
    	javaScriptHelper.scrollIntoView(pettyCashObj.Petty_Cash_Configuration());
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Configuration());
    	pettyCashObj.Petty_Cash_Configuration().click();
    }

    @And("^Click on Expense Code Limit$")
    public void click_on_expense_code_limit() throws Throwable {
       //-------EXPENSE CODE LIMIT-------//
    	javaScriptHelper.JavaScriptHelper(driver);
    	javaScriptHelper.scrollIntoView(pettyCashObj.Petty_Cash_Expense_code_limit());
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Expense_code_limit());
    	pettyCashObj.Petty_Cash_Expense_code_limit().click();
    }
    
    @Then("^Click on Add Icon in Petty cash$")
    public void click_on_add_icon_in_petty_cash() throws Throwable {
        //-----ADD ICON -------//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Add());
    	pettyCashObj.Petty_Cash_Add().click();
    }
    
    @And("^Enter Expense code value$")
    public void enter_expense_code_value() throws Throwable {
        //-------EXPENSE CODE VALUE------//    	
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_ExpenseCode());
    	pettyCashObj.Petty_Cash_ExpenseCode().sendKeys("Exp001");
    }

    
    @Then("^Enter Expense Name Value$")
    public void enter_expense_name_value() throws Throwable {
        //-------EXPENSE NAME VALUE-------//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_ExpenseName());
    	pettyCashObj.Petty_Cash_ExpenseName().sendKeys("12345");
    }
    
    @And("^Choose Expense Gl$")
    public void choose_expense_gl() throws Throwable {
        //------CHOOSE EXPENSE GL------//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Expense_Gl());
    	pettyCashObj.Petty_Cash_Expense_Gl().click();
    	pettyCashObj.Petty_Cash_Expense_Gl().sendKeys("IFRS-AS-AS1000023 - Advances to Employee");
    	//pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(Keys.DOWN);
    	pettyCashObj.Petty_Cash_Expense_Gl().sendKeys(Keys.ENTER);
    }
    
    @Then("^Enter Max Limit Value$")
    public void enter_max_limit_value() throws Throwable {
        //--------ENTER MAX LIMIT VALUE------//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Max_Limit());
    	pettyCashObj.Petty_Cash_Max_Limit().sendKeys("100000");
    }
    
    @And("^Choose Currency value$")
    public void choose_currency_value() throws Throwable {
        //--------CHOOSE CURRENCY VALUE-----//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Expense_Currency());
    	pettyCashObj.Petty_Cash_Expense_Currency().click();
    	pettyCashObj.Petty_Cash_Expense_Currency().sendKeys("INR");
    	pettyCashObj.Petty_Cash_Expense_Currency().sendKeys(Keys.ENTER);
    }

    @Then("^save Record in Petty cash$")
    public void save_record_in_petty_cash() throws Throwable {
        //--------SAVE THE RECORD-------//
    	waitHelper.waitForElement(driver, 2000, pettyCashObj.Petty_Cash_Expense_Save());
    	pettyCashObj.Petty_Cash_Expense_Save().click();
    }




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
