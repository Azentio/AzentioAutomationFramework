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
import pageobjects.ArApObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ArApTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.InventoryManagementTestDataType;

public class ArAp {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	ArApTestDataType arApTestDataType = new ArApTestDataType();
	ArApObj arAPobj = new ArApObj(driver);
	
	
	  @Then("^Click on Report button$")
	    public void click_on_repoet_button() throws Throwable {
		  waithelper.waitForElement(driver, 2000,  arAPobj.report_button());
		  arAPobj.report_button().click();
	    }

	    @Then("^Click on Finincial Reporting tab$")
	    public void click_on_finincial_reporting_tab() throws Throwable {
	    	  waithelper.waitForElement(driver, 2000,arAPobj.financial_Reporting());
	    	arAPobj.financial_Reporting().click();
	    }

	    @Then("^Click on Balance Sheet Report edit button$")
	    public void click_on_balance_sheet_report_edit_button() throws Throwable {
	    	  waithelper.waitForElement(driver, 2000,arAPobj.balanceSheetReport_button());
		    	arAPobj.balanceSheetReport_button().click();
	    }

	    @Then("^Fill branch details for report$")
	    public void fill_branch_details_for_report() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	waithelper.waitForElement(driver, 2000,arAPobj.balanceSheetReport_branch_textbox());
	    	arAPobj.balanceSheetReport_branch_textbox().click();
	    	arAPobj.balanceSheetReport_branch_textbox().sendKeys(arApTestDataType.BranchCode);
	    	arAPobj.balanceSheetReport_branch_textbox().sendKeys(Keys.ENTER);
	    	//Thread.sleep(6000);
	    }

	    @Then("^Select date in calendar$")
	    public void select_date_in_calendar() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.calendar_button());
	    	arAPobj.calendar_button().click();
	    	javascripthelper.JavaScriptHelper(driver);
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAssetObj.inventoryNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAssetTestDataType.GlFullToMonth+" "+fixedAssetTestDataType.GlToDate+", "+fixedAssetTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
		
	    	
	    }

	    @Then("^Click on View button$")
	    public void click_on_view_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.view_button());
	    	arAPobj.view_button().click();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
