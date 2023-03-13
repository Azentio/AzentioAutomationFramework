package stepdefinitions;

import org.openqa.selenium.By;
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
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.FixedAsset_ReportsObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_Reports {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	
	JavascriptHelper javascripthelper = new JavascriptHelper();

	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	BUDGET_BudgetCreationTestDataType budgetdata;
	
	FixedAsset_ReportsObj fixedAsset_ReportsObj = new FixedAsset_ReportsObj(driver);

	

	
	@Then("^Click on Transaction Reports tab$")
    public void click_on_transaction_reports_tab() throws Throwable {
	waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_TransactionReports());
	fixedAsset_ReportsObj.fixedAsset_TransactionReports().click();   
    }

    @Then("^Click on Asset replacement Report edit button$")
    public void click_on_asset_replacement_report_edit_button() throws Throwable {
    waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport());
    fixedAsset_ReportsObj.fixedAsset_ReplacementReport().click();   
    }

   

   
    
    ///---impair----//
    
    
    @Then("^Click on Impairement Report edit button$")
    public void click_on_impairement_report_edit_button()  {
    waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ImpairementReport());
    fixedAsset_ReportsObj.fixedAsset_ImpairementReport().click();  	
       
    }

    @Then("^Click on Revaluation Report edit button$")
    public void click_on_revaluation_report_edit_button() throws Throwable {
    	waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_RevaluationReport());
        fixedAsset_ReportsObj.fixedAsset_RevaluationReport().click(); 
    }

    
    //-----------------return---//
    @Then("^Click on return Report edit button$")
    public void click_on_return_report_edit_button() throws Throwable {
   waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport());
   fixedAsset_ReportsObj.fixedAsset_ReturnReport().click();   
    }

   

  
    
    
    //-----Allocation Report----------//
    @Then("^Click on Allocation Report edit button$")
    public void click_on_allocation_report_edit_button() throws Throwable {
     waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport());
     fixedAsset_ReportsObj.fixedAsset_AllocationReport().click();    
    }

   

    
    //Deallocation
    @Then("^Click on DeAllocation Report edit button$")
    public void click_on_deallocation_report_edit_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_ReportsObj.fixedAsset_DeAllocationReport());
        waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport());
        fixedAsset_ReportsObj.fixedAsset_DeAllocationReport().click();
    
    }

    

    @Then("^Click on Amendment Report edit button$")
    public void click_on_amendment_report_edit_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        fixedAsset_ReportsObj.fixedAsset_AmendmentReport().click();    
    }

    

    
      
}
